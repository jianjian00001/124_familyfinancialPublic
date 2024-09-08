package com.xust.ffms.dao;


import com.xust.ffms.entity.House;
import com.xust.ffms.entity.Role;
import com.xust.ffms.entity.UserInfo;
import com.xust.ffms.utils.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    /**
     * 获取单个用户信息，可用于：
     * 1.登录
     * 2.通过用户某一部分信息获取用户完整信息
     * @param userInfo
     * @return
     */
    UserInfo getUserInfo(UserInfo userInfo);

    /**
     * 注册
     * @param userInfo
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 通过username判断该用户是否存在
     * @param userInfo
     * @return
     */
    int userIsExisted(UserInfo userInfo);

    /**
     * 通过条件获取符合条件的优化信息 -- 分页
     * @param model
     * @return
     */
    List<UserInfo> getUsersByWhere(PageModel<UserInfo> model);

    int getToatlByWhere(PageModel<UserInfo> model);

    int add(UserInfo userInfo);

    int update(UserInfo userInfo);

    int changePassword(Integer id,String newPassword);

    int delete(String id);

    List<Role> getAllRoles();

    int addRole(Role role);

    int updateRole(Role role);

    int deleteRole(String id);

    Role getRoleById(String id);

    int addHouseId(House house);

    List<String> getAllPrivilege(@Param("id") String roleId);

    void deletePrivilege(@Param("id") String roleid);

    Role selectRoleByName(@Param("name") String name,@Param("id") String roleid);

    Role selectRoleByName1(@Param("name") String name);

    void insertPrivileges(@Param("roleid") int i, @Param("id") String s);

    void addRole1(Role role1);
}
