package com.xust.ffms.service.impl;


import com.xust.ffms.dao.PrivilegeMapper;
import com.xust.ffms.entity.Privilege;
import com.xust.ffms.service.PrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Resource
    private PrivilegeMapper mapper;

    @Override
    public List<Privilege> getPrivilegeByRoleid(int roleid) {
        return this.mapper.getPrivilegeByRoleid(roleid);
    }

    @Override
    public int addDefaultPrivilegesWhenAddRole(String roleid) {
        return mapper.addDefaultPrivilegesWhenAddRole(roleid);
    }

    @Override
    public int delPrivilegesWenDelRole(String roleid) {
        return mapper.delPrivilegesWenDelRole(roleid);
    }
}
