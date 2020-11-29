package com.zeryts.c2c.social.govern.reviewer.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zeryts.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 评审员操作的mapper
 * @title: ReviewerTaskStatusMapper
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 11:24
 */
@Mapper
public interface ReviewerTaskStatusMapper extends BaseMapper<ReviewerTaskStatus> {
}
