package com.zeryts.c2c.social.govern.report;

import com.zeryts.c2c.social.govern.report.config.db.DruidDataSourceConfig;
import org.apache.ibatis.transaction.Transaction;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class SocialGovernReportApplication {

    public static void main(String[] args) {

        SpringApplication.run(SocialGovernReportApplication.class, args);
    }


    public static void sendMessage() throws MQClientException, UnsupportedEncodingException {
        /*
            接收RocketMQ回调的一个监听器接口
            这里会执行本地事务,commit \ rollback , 回调监听等逻辑
         */
        TransactionListener transactionListener = new TransactionListenerImpl();

        // 建立一个支持事务消息的Producer
        // 并且指定一个生产者分组
        TransactionMQProducer producer = new TransactionMQProducer("test_producer_group");

        //指定一个线程池,里面包含一些线程
        // 这个线程池是用来处理RocketMQ回调你的请求
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("TestThread");
                        return t;
                    }
                }
        );

        // 事务生产者设置相应的线程池
        producer.setExecutorService(executorService);
        // 事务生产者设置监听
        producer.setTransactionListener(transactionListener);
        producer.start();

        Message message = new Message(
                "PayOrderSucessTopic",
                "TestTag",
                "TestKey",
                ("订单支付消息").getBytes(RemotingHelper.DEFAULT_CHARSET)

        );

        try {
            //将这条消息发送出去
            TransactionSendResult transactionSendResult = producer.sendMessageInTransaction(message, null);

        } catch (Exception e) {
            // 这里代表half消息发送失败
            // 数据进行回调
        }

    }
}

class TransactionListenerImpl implements TransactionListener {

    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        try {


            // 在这里执行订单的本地事务
            // 根据结果去选择commit还是rollback
            return LocalTransactionState.COMMIT_MESSAGE;
        } catch (Exception e) {
            // 如果本地事务执行失败,回滚一切
            // 将消息设置为rollback
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
    }

    /**
     * 如果因为各种原因,没有返回commit和rollback
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        // 查询本地事务是否执行成功了

        // 根据本地事务的执行情况选择commit和rollback

        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
