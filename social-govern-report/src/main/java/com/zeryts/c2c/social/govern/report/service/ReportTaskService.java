package com.zeryts.c2c.social.govern.report.service;

import com.baomidou.mybatisplus.service.IService;
import com.zeryts.c2c.social.govern.report.domain.ReportTask;

/**
 * @description: Report操作的dao层
 * @title: ReportTaskDao
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29  10:00
 */
public interface ReportTaskService {
    /** description: 插入一条举报信息
     * @param reportTask 举报对象
     * @return: java.lang.Boolean
     * @Author: zeryts
     * @email: hezitao12@163.com
     * Date: 2020/11/29 10:09
     */
    Boolean add(ReportTask reportTask);
}
