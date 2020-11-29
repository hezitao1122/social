package com.zeryts.c2c.social.govern.report.service;

import com.zeryts.c2c.social.govern.report.domain.ReportTask;
import com.zeryts.c2c.social.govern.report.domain.ReportTaskVote;

import java.util.List;

/**
 * @description: 举报任务操作的service层
 * @title: ReportTaskDao
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29  10:00
 */
public interface ReportTaskVoteService {
    /** description: 插入一条举报信息
     * @param reportTaskId 举报的任务id
     * @param reportReviewerIds 评审员所有人id
     * @return: java.lang.Boolean
     * @Author: zeryts
     * @email: hezitao12@163.com
     * Date: 2020/11/29 10:09
     */
    void inittVotes(Long reportTaskId , List<Long> reportReviewerIds);
}
