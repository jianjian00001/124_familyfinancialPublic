package com.xust.ffms.service;


import com.xust.ffms.entity.Role;
import com.xust.ffms.entity.UserInfo;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;

import java.util.List;

public interface UserInfoService {

    int add(UserInfo userInfo);

    int update(UserInfo userInfo);
    int changePassword(UserInfo userInfo,String newPassword);

    boolean userIsExisted(UserInfo userInfo);

    int delete(String id);

    UserInfo getUserInfo(UserInfo userInfo);

    Result getUsersByWhere(PageModel<UserInfo> model);

    List<Role> getAllRoles();

    int addRole(Role role);

    int updateRole(Role role);

    int deleteRole(String id);

    Role getRoleById(String id);

    List<String> getAllPrivilege(String roleId);
}
