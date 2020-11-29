package com.zeryts.c2c.social.govern.report.dao.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zeryts.c2c.social.govern.report.dao.ReportTaskDao;
import com.zeryts.c2c.social.govern.report.domain.ReportTask;
import com.zeryts.c2c.social.govern.report.mapper.ReportTaskMapper;
import org.springframework.stereotype.Repository;

/**
 * @description: Report操作的dao层实现类
 * @title: ReportTaskDaoImpl
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29  10:01
 */
@Repository
public class ReportTaskDaoImpl extends ServiceImpl<ReportTaskMapper, ReportTask> implements ReportTaskDao {
}
