package com.xust.ffms.dao;


import com.xust.ffms.entity.Privilege;

import java.util.List;

public interface PrivilegeMapper {

    List<Privilege> getPrivilegeByRoleid(int roleid);

    int addDefaultPrivilegesWhenAddRole(String roleid);

    int delPrivilegesWenDelRole(String roleid);
}
