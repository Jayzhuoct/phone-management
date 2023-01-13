package design.springboot.zjj.service.impl;

import design.springboot.zjj.entity.User;
import design.springboot.zjj.mapper.UserMapper;
import design.springboot.zjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUserAll(){
        return userMapper.getAllUser();
    }

    @Override
    public int getUserById(int uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int delUser(int uid) {
            return userMapper.delUser(uid);
    }

    @Override
    public int insertUser(User user) {
            return userMapper.insertUser(user);
    }

}
