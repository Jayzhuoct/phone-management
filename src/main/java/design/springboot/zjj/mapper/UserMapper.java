package design.springboot.zjj.mapper;

import design.springboot.zjj.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> getAllUser();
    @Select("select * from user where uid=#{uid}")
    public int getUserById(int uid);
    @Select("select * from user where username=#{username}")
    public User getUserByName(String username);
    @Update("update user set username=#{username},password=#{password}  where uid=#{uid}")
    public int updateUser(User user);
    @Delete("delete from user where uid=#{uid}")
    public int delUser(int uid);
    @Insert("insert into user(username,password) values(#{username},#{password})")
    public int insertUser(User user);
}
