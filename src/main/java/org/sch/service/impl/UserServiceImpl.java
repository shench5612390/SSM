package org.sch.service.impl;



import javax.annotation.Resource;

import org.sch.dao.UserMapper;
import org.sch.model.User;
import org.sch.service.IUserService;
import org.springframework.stereotype.Service;
  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
	@Resource
    private UserMapper userMapper;  
    
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userMapper.selectByPrimaryKey(userId);  
    }  
  
}  
