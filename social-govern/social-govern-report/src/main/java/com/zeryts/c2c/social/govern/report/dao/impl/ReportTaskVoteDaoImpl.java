package com.zeryts.c2c.social.govern.report.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeryts.c2c.social.govern.report.dao.ReportTaskVoteDao;
import com.zeryts.c2c.social.govern.report.domain.ReportTaskVote;
import com.zeryts.c2c.social.govern.report.mapper.ReportTaskVoteMapper;
import org.springframework.stereotype.Repository;

/**
 * @description: Report操作的dao层实现类
 * @title: ReportTaskDaoImpl
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29  10:01
 */
@Repository
public class ReportTaskVoteDaoImpl extends ServiceImpl<ReportTaskVoteMapper, ReportTaskVote> implements ReportTaskVoteDao {
    @Override
    public void updateData(ReportTaskVote vote) {

    }
}
