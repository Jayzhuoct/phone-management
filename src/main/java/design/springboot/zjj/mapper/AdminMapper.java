package design.springboot.zjj.mapper;

import design.springboot.zjj.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from admin")
     List<Admin> getAdminAll();
    @Select("select * from admin where aId=#{aId}")
     int getAdminById(int aId);
    @Select("select * from admin where aName=#{name}")
     Admin getAdminByName(String name);
    @Update("update admin set aName=#{aName},`key`=#{key} where aId=#{aId}")
     int updateAdmin(Admin admin);
    @Delete("delete from admin where aId=#{aId}")
     int delAdmin(int aId);
    @Insert("insert into admin values(null,#{aName},#{key})")
     int insertAdmin(Admin admin);
}
