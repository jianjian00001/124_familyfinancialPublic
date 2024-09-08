package com.xust.ffms.service.impl;


import com.xust.ffms.dao.UserInfoMapper;
import com.xust.ffms.entity.House;
import com.xust.ffms.entity.Role;
import com.xust.ffms.entity.UserInfo;
import com.xust.ffms.service.UserInfoService;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;
import com.xust.ffms.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int add(UserInfo userInfo) {
        //添加用户
        int result = userInfoMapper.add(userInfo);
        System.out.println(userInfo);
        if (userInfo.getRoleid() == 2) {
            //如果是家庭管理员，则新增家庭
            House newHouse = new House();
            newHouse.setOwnerid(userInfo.getId());
            int r = userInfoMapper.addHouseId(newHouse);

            //添加家庭成功后，绑定到该用户
            if (r == 1) {
                userInfo.setHouseid(newHouse.getId().toString());
                result = userInfoMapper.update(userInfo);
            }
        }
        return result;
    }


    @Override
    public int update(UserInfo userInfo) {
        return userInfoMapper.update(userInfo);
    }

    @Override
    public int changePassword(UserInfo userInfo, String newPassword) {
        return userInfoMapper.changePassword(userInfo.getId(),newPassword);
    }

    @Override
    public int delete(String id) {
        return userInfoMapper.delete(id);
    }

    @Override
    public UserInfo getUserInfo(UserInfo userInfo) {
        return userInfoMapper.getUserInfo(userInfo);
    }

    @Override
    public boolean userIsExisted(UserInfo userInfo) {
        return userInfoMapper.userIsExisted(userInfo) > 0 ? true : false;
    }

    @Override
    public Result getUsersByWhere(PageModel<UserInfo> model) {
        try {
            List<UserInfo> users = userInfoMapper.getUsersByWhere(model);
            if (users.size() >= 0) {
                Result<UserInfo> result = ResultUtil.success(users);
                result.setTotal(userInfoMapper.getToatlByWhere(model));
                if (result.getTotal() == 0) {
                    result.setMsg("没有查到相关数据");
                } else {
                    result.setMsg("数据获取成功");
                }
                return result;
            } else {
                return ResultUtil.unSuccess("没有找到符合条件的属性！");
            }
        } catch (Exception e) {
            return ResultUtil.error(e);
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return userInfoMapper.getAllRoles();
    }

    @Override
    public int addRole(Role role) {
        return userInfoMapper.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return userInfoMapper.updateRole(role);
    }

    @Override
    public int deleteRole(String id) {
        return userInfoMapper.deleteRole(id);
    }

    @Override
    public Role getRoleById(String id) {
        return userInfoMapper.getRoleById(id);
    }

    @Override
    public List<String> getAllPrivilege(String roleId) {
        return userInfoMapper.getAllPrivilege(roleId);
    }

}
