package com.zeryts.c2c.social.govern.report.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeryts.c2c.social.govern.report.domain.ReportTaskVote;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @description: Report操作的dao层
 * @title: ReportTaskDao
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29  10:00
 */
@Repository
public interface ReportTaskVoteDao extends IService<ReportTaskVote> {
    @Update("UPDATE REPORT_TASK_VOTE " +
            "SET VOTE_RESULT=#{voteResult} " +
            "WHERE REVIEWER_ID=#{reviewerId} " +
            "AND REPORT_TASK_ID=#{reportTaskId}")
    void updateData(ReportTaskVote vote);
}
