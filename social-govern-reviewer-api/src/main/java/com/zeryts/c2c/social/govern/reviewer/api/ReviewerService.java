package com.zeryts.c2c.social.govern.reviewer.api;

import java.util.List;

/**
 * @author zeryts
 * @description: Reviewer服务暴露的service接口
 * ```````````````````````````
 * @title: ReviewerService
 * @projectName c2c-social-govern
 * @date 2020/11/8 20:56
 */
public interface ReviewerService {
    /**
     * 选择评审员
     * @param reportTaskId 举报任务id
     * @return 评审员用户id
     */
    List<Long> selectReviewers(Long reportTaskId);

}
