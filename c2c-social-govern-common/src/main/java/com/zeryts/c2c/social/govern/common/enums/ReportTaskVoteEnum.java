package com.zeryts.c2c.social.govern.common.enums;

/**
 * @description: 举报任务的投票
 * @title: ReportTaskVoteEnum
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 11:52
 */
public enum ReportTaskVoteEnum {
    UNKNOWN(-1,"未投票"),
    APPROVED(1,"投票通过"),
    UNAPPROVED(2,"投票未通过"),
    ;

    private Integer key;

    private String value;

    ReportTaskVoteEnum(Integer key , String value){
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
