package com.zeryts.c2c.social.govern.reviewer.service;

import com.zeryts.c2c.common.core.enums.ReviewerStatucEnum;
import com.zeryts.c2c.social.govern.reviewer.api.ReviewerService;
import com.zeryts.c2c.social.govern.reviewer.dao.ReviewerTaskStatusDAO;
import com.zeryts.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zeryts
 * @description: Reviewer服务暴露的service实现接口
 * ```````````````````````````
 * @title: ReviewerService
 * @projectName c2c-social-govern
 * @date 2020/11/8 20:56
 */
@DubboService(
        version = "1.0.0",
        interfaceClass = ReviewerService.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
@Slf4j
public class ReviewerServiceImpl implements ReviewerService {

    @Autowired
    private ReviewerTaskStatusDAO dao;



    @Override
    public List<Long> selectReviewers(Long reportTaskId) {
        // 模拟通过算法选择一批评审员
        log.info("模拟通过算法选择一批评审员");

        List<Long> reviewerIds = new ArrayList<Long>();
        reviewerIds.add(1L);
        reviewerIds.add(2L);
        reviewerIds.add(3L);
        reviewerIds.add(4L);
        reviewerIds.add(5L);

        // 把每个评审员要执行的任务录入数据库
        for(Long reviewerId : reviewerIds) {
            ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
            reviewerTaskStatus.setReviewerId(reviewerId);
            reviewerTaskStatus.setReportTaskId(reportTaskId);
            reviewerTaskStatus.setStatus(ReviewerStatucEnum.PROCESSING.getKey());
            dao.save(reviewerTaskStatus);
        }
        return null;
    }

    @Override
    public void finishVote(Long reviewerId, Long reportTaskId) {
        ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
        reviewerTaskStatus.setReviewerId(reviewerId);
        reviewerTaskStatus.setReportTaskId(reportTaskId);
        reviewerTaskStatus.setStatus(ReviewerStatucEnum.FINISHED.getKey());
        dao.updateData(reviewerTaskStatus);
    }
}
