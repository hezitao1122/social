package com.zeryts.c2c.social.govern.report.service;

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
    /** description:根据主键获取数据
     * @param id 主键
     * @return: com.zeryts.c2c.social.govern.report.domain.ReportTask
     * @Author: zeryts
     * @email: hezitao12@163.com
     * Date: 2020/11/29 15:53
     */
    ReportTask get(Long id);

}
