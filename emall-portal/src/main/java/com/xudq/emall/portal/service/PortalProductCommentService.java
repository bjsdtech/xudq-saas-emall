package com.xudq.emall.portal.service;

import com.xudq.emall.common.api.CommonResult;
import com.xudq.emall.model.PmsComment;
import com.xudq.emall.model.PmsCommentReplay;
import org.springframework.transaction.annotation.Transactional;

public interface PortalProductCommentService {
    /**
     * 获取评论列表
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    CommonResult getCommentList(Long productId, Integer pageNum, Integer pageSize);

    /**
     * 用户评价
     * @param pmsComment
     * @return
     */
    @Transactional
    Integer insertProductComment(PmsComment pmsComment);

    /**
     * 用户评价回复
     * @param replay
     * @return
     */
    @Transactional
    Integer insertCommentReply(PmsCommentReplay replay);

}
