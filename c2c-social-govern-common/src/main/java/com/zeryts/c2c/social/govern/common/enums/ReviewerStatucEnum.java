package com.zeryts.c2c.social.govern.common.enums;

/**
 * @description: 评审员审核状态的枚举类
 * @title: ReviewerStatucEnum
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 11:20
 */
public enum ReviewerStatucEnum {
    PROCESSING(1,"处理中"),
    FINISHED(2,"处理完毕"),

    ;

    private Integer key;

    private String value;

    ReviewerStatucEnum(Integer key , String value){
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
