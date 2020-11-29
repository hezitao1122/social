package com.zeryts.c2c.social.govern.reviewer.dao.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zeryts.c2c.social.govern.reviewer.dao.ReviewerTaskStatusDAO;
import com.zeryts.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import com.zeryts.c2c.social.govern.reviewer.mapper.ReviewerTaskStatusMapper;
import org.springframework.stereotype.Repository;

/**
 * 评审员处理任务DAO组件
 */
@Repository
public class ReviewerTaskStatusDAOImpl extends ServiceImpl<ReviewerTaskStatusMapper, ReviewerTaskStatus> implements ReviewerTaskStatusDAO {

}
