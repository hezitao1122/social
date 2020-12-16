package com.zeryts.c2c.social.govern.report.controller;

import com.zeryts.c2c.common.core.util.Result;
import com.zeryts.c2c.social.govern.report.domain.ReportTask;
import com.zeryts.c2c.social.govern.report.domain.ReportTaskVote;
import com.zeryts.c2c.social.govern.report.service.ReportTaskService;
import com.zeryts.c2c.social.govern.report.service.ReportTaskVoteService;
import com.zeryts.c2c.social.govern.reviewer.api.ReviewerService;
import com.zeryts.c2c.social.govern.reward.api.RewardService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DubboReference(
            version = "1.0.0",
            interfaceClass = ReviewerService.class,
            cluster = "failfast"
    )
    private ReviewerService reviewerService;
    @DubboReference(
            version = "1.0.0",
            interfaceClass = RewardService.class,
            cluster = "failfast"
    )
    private RewardService rewardService;


    @PostMapping
    public Result<ReportTask> add(@RequestBody ReportTask reportTask){
        reportTaskService.add(reportTask);
        // 调用评审员服务，选择一批评审员
        List<Long> reviewerIds = reviewerService.selectReviewers(
                reportTask.getId());
        // 在本地数据库初始化这批评审员对举报任务的投票状态
        reportTaskVoteService.inittVotes( reportTask.getId(),reviewerIds);
        // 模拟发送push消息给评审员
        System.out.println("模拟发送push消息给评审员.....");
        return new Result<>(reportTask);
    }
    /** description:根据主键获取数据
     * @param id 主键
     * @return: com.zeryts.c2c.social.govern.report.domain.ReportTask
     * @Author: zeryts
     * @email: hezitao12@163.com
     * Date: 2020/11/29 15:53
     */
    @GetMapping("{id}")
    public ReportTask get(@PathVariable("id") Long id){
        return reportTaskService.get(id);
    }

    /** description:对举报任务进行投票
     * @param vote 举报任务对象
     * @return: com.zeryts.c2c.social.govern.common.util.Result<com.zeryts.c2c.social.govern.report.domain.ReportTaskVote>
     * @Author: zeryts
     * @email: hezitao12@163.com
     * Date: 2020/12/5 21:29
     */
    @PostMapping("/vote")
    public Result<ReportTaskVote> vote(@RequestBody ReportTaskVote vote){
        Result<ReportTaskVote> result = new Result<>();
        // 本地数据库记录投票
        reportTaskVoteService.vote(vote);
        // 调用评审员服务，标记本次投票结束
        reviewerService.finishVote(vote.getReviewerId(), vote.getReportTaskId());

        // 对举报任务进行归票
//        Boolean hasFinishedVote = reportTaskVoteService
//                .calculateVotes(reportTaskId);

        reportTaskVoteService.update(vote);

        return result.suc().setData(vote);
    }

}
