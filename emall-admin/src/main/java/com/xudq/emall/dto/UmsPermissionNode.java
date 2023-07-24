package com.xudq.emall.dto;

import com.xudq.emall.model.UmsPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class UmsPermissionNode extends UmsPermission {
    @Getter
    @Setter
    private List<UmsPermissionNode> children;
}
