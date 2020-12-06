package com.zeryts.c2c.social.govern.reviewer.dao;


import com.baomidou.mybatisplus.service.IService;
import com.zeryts.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Update;

/**
 * 评审员处理任务状态DAO接口
 */
public interface ReviewerTaskStatusDAO extends IService<ReviewerTaskStatus> {

    @Update("UPDATE reviewer_task_status " +
            "SET STATUS=#{status} " +
            "WHERE REVIEWER_ID=#{reviewerId} " +
            "AND REPORT_TASK_ID=#{reportTaskId}")
    void updateData(ReviewerTaskStatus reviewerTaskStatus);

}
