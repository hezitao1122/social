package com.zeryts.c2c.social.govern.report.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description: 举报投票的任务
 * @title: ReportTaskVote
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 11:54
 */
@Data
@TableName("report_task_vote")
public class ReportTaskVote {

    /**
     * 举报任务投票id
     */
    @TableId(type = IdType.AUTO)
    @TableField("ID")
    private Long id;
    /**
     * 评审员id
     */
    @TableField("REVIEWER_ID")
    private Long reviewerId;
    /**
     * 举报任务id
     */
    @TableField("REPORT_TASK_ID")
    private Long reportTaskId;
    /**
     * 投票结果
     */
    @TableField("VOTE_RESULT")
    private Integer voteResult;
    @TableField("CREATE_TIME")
    private Date createTime;
    @TableField("REPORT_TIME")
    private Date reportTime;

}
