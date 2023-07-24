package com.xudq.emall.domain;

import com.xudq.emall.model.UmsMember;
import com.xudq.emall.model.UmsMemberLevel;
import lombok.Data;

/**
 * @author ：xudq
 * @date ：Created in 2020/1/6 21:12
 * @version: V1.0
 * @description:
 **/
@Data
public class PortalMemberInfo extends UmsMember {
    private UmsMemberLevel umsMemberLevel;
}
