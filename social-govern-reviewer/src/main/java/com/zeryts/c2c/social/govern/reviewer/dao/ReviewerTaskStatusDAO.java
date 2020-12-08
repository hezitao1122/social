package com.zeryts.c2c.social.govern.reviewer.dao;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zeryts.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Update;

/**
 * @description: 评审员处理任务状态DAO接口
 * @title: ReviewerTaskStatusDAO
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 11:14
 */
public interface ReviewerTaskStatusDAO extends IService<ReviewerTaskStatus> {


    void updateData(ReviewerTaskStatus reviewerTaskStatus);

}
