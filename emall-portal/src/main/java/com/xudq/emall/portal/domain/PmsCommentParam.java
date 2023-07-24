package com.xudq.emall.portal.domain;

import com.xudq.emall.model.PmsComment;
import com.xudq.emall.model.PmsCommentReplay;
import lombok.Data;

import java.util.List;


@Data
public class PmsCommentParam extends PmsComment {
    private List<PmsCommentReplay> pmsCommentReplayList;
}
