package com.xudq.emall.domain;

import com.xudq.emall.model.UmsMember;
import com.xudq.emall.model.UmsMemberLevel;
import lombok.Data;


@Data
public class PortalMemberInfo extends UmsMember {
    private UmsMemberLevel umsMemberLevel;
}
