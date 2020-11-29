package com.zeryts.c2c.social.govern.reviewer.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * @description: 审核任务状态的实体类
 * @title: ReviewerTaskStatus
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 11:14
 */
@Data
@TableName("reviewer_task_status")
public class ReviewerTaskStatus {
    /**
     * 评审员执行任务状态id
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
     * 评审员处理举报任务状态
     */
    @TableField("STATUS")
    private Integer status;
    @TableField("CREATE_TIME")
    private Date createTime;
    @TableField("REVIEWER_TIME")
    private Date reviewerTime;
}
