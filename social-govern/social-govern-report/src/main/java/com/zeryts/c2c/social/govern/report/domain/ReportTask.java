package com.zeryts.c2c.social.govern.report.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description: 举报的实体类
 * @title: ReportTask
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 9:42
 */
@Data
@TableName("report_task")
public class ReportTask {
    @TableId(type = IdType.AUTO)
    @TableField(value = "ID")
    private Long id;
    @TableField("TYPE")
    private String type;
    @TableField("REPORT_USER_ID")
    private Long reportUserId;
    @TableField("REPORT_CONTENT")
    private String reportContent;
    @TableField("TARGET_ID")
    private Long targetId;
    @TableField("CREATE_TIME")
    private Date createTime;
}
