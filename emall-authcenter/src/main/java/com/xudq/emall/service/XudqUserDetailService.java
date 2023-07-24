package com.xudq.emall.service;

import com.xudq.emall.mapper.UmsMemberMapper;
import com.xudq.emall.model.UmsMember;
import com.xudq.emall.model.UmsMemberExample;
import com.xudq.emall.domain.MemberDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
*
* @desc: 类的描述:认证服务器加载用户的类
* @author:
* @createDate:
* @version: 1.0
*/
@Slf4j
@Component
public class XudqUserDetailService implements UserDetailsService {

    /**
     * 方法实现说明:用户登陆
     * @author:
     * @param userName 用户名密码
     * @return: UserDetails
     * @exception:
     * @date:
     */

    @Autowired
    private UmsMemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        if(StringUtils.isEmpty(userName)) {
            log.warn("用户登陆用户名为空:{}",userName);
            throw new UsernameNotFoundException("用户名不能为空");
        }

        UmsMember umsMember = getByUsername(userName);

        if(null == umsMember) {
            log.warn("根据用户名没有查询到对应的用户信息:{}",userName);
        }

        log.info("根据用户名:{}获取用户登陆信息:{}",userName,umsMember);

        MemberDetails memberDetails = new MemberDetails(umsMember);

        return memberDetails;
    }

    /**
     * 方法实现说明:根据用户名获取用户信息
     * @author:
     * @param username:用户名
     * @return: UmsMember 会员对象
     * @exception:
     * @date:
     */
    public UmsMember getByUsername(String username) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }
}
