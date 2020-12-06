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
    /** description: 更新投票信息
     * @param vote 投票对象
     * @return: void
     * @Author: zeryts
     * @email: hezitao12@163.com
     * Date: 2020/11/29 16:14
     */
    void update(ReportTaskVote vote);

    /** description:对举报任务进行投票
     * @param vote 评审信息
     * @Author: zeryts
     * @email: hezitao12@163.com
     * Date: 2020/12/5 21:30
     */
    void vote(ReportTaskVote vote);


    /** description: 对举报任务进行归票
     * @param reportTaskId 举报任务ID
     * @return: java.lang.Boolean
     * @Author: zeryts
     * @email: hezitao12@163.com
     * Date: 2020/12/5 21:44
     */
    Boolean calculateVotes(Long reportTaskId);
}
