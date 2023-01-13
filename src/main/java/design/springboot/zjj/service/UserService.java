package design.springboot.zjj.service;

import design.springboot.zjj.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserAll();
    int getUserById(int uid);
    User getUserByName(String username);
    int updateUser(User user);
    int delUser(int uid);
    int insertUser(User user);
}
