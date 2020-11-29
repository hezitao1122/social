package com.zeryts.c2c.social.govern.report.service.impl;

import com.zeryts.c2c.social.govern.report.dao.ReportTaskDao;
import com.zeryts.c2c.social.govern.report.domain.ReportTask;
import com.zeryts.c2c.social.govern.report.service.ReportTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description: Report操作的dao层实现类
 * @title: ReportTaskDaoImpl
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29  10:01
 */
@Service
public class ReportTaskServiceImpl implements ReportTaskService {
    @Autowired
    private ReportTaskDao reportTaskDao;


    @Override
    public Boolean add(ReportTask reportTask) {
        reportTask.setCreateTime(new Date());
        return reportTaskDao.insert(reportTask);
    }

    @Override
    public ReportTask get(Long id) {
        return reportTaskDao.selectById(id);
    }
}
