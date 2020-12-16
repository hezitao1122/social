package com.zeryts.c2c.social.govern.reviewer.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeryts.c2c.social.govern.reviewer.dao.ReviewerTaskStatusDAO;
import com.zeryts.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import com.zeryts.c2c.social.govern.reviewer.mapper.ReviewerTaskStatusMapper;
import org.springframework.stereotype.Repository;

/**
 * @description: 评审员处理任务DAO组件
 * @title: ReviewerTaskStatusDAO
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 11:14
 */
@Repository
public class ReviewerTaskStatusDAOImpl extends ServiceImpl<ReviewerTaskStatusMapper, ReviewerTaskStatus> implements ReviewerTaskStatusDAO {

    @Override
    public void updateData(ReviewerTaskStatus reviewerTaskStatus) {
        baseMapper.updateData(reviewerTaskStatus);
    }
}
