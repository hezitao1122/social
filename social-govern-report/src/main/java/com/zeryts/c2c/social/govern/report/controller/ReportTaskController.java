package com.zeryts.c2c.social.govern.report.controller;

import com.zeryts.c2c.social.govern.report.domain.ReportTask;
import com.zeryts.c2c.social.govern.report.service.ReportTaskService;
import com.zeryts.c2c.social.govern.report.service.ReportTaskVoteService;
import com.zeryts.c2c.social.govern.reviewer.api.ReviewerService;
import com.zeryts.c2c.social.govern.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 举报任务的controller层
 * @title: ReportTaskController
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 10:10
 */
@RestController
@RequestMapping("/report")
public class ReportTaskController {
    @Autowired
    private ReportTaskService reportTaskService;
    @Autowired
    private ReportTaskVoteService reportTaskVoteService;

    @Reference(
            version = "1.0.0",
            interfaceClass = ReviewerService.class,
            cluster = "failfast"
    )
    private ReviewerService reviewerService;
    @Reference(
            version = "1.0.0",
            interfaceClass = RewardService.class,
            cluster = "failfast"
    )
    private RewardService rewardService;


    @PostMapping
    public ReportTask add(@RequestBody ReportTask reportTask){
        reportTaskService.add(reportTask);

        // 调用评审员服务，选择一批评审员
        List<Long> reviewerIds = reviewerService.selectReviewers(
                reportTask.getId());
        // 在本地数据库初始化这批评审员对举报任务的投票状态
        reportTaskVoteService.inittVotes( reportTask.getId(),reviewerIds);
        // 模拟发送push消息给评审员
        System.out.println("模拟发送push消息给评审员.....");
        return reportTask;
    }

}
