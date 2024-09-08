package com.xust.ffms.service;


import com.xust.ffms.entity.Privilege;

import java.util.List;

public interface PrivilegeService {

    List<Privilege> getPrivilegeByRoleid(int roleid);

    int addDefaultPrivilegesWhenAddRole(String roleid);

    int delPrivilegesWenDelRole(String roleid);
}
