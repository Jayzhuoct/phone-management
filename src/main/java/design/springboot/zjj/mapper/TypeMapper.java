package design.springboot.zjj.mapper;

import design.springboot.zjj.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeMapper {
    @Select("select * from type")
    List<Type> getTypeAll();
    @Select("select * from type where pId=#{id}")
    Type getTypeById(int id);
    @Update("update type set pId=#{pId},pName=#{pName},pModel=#{pModel},pMemory=#{pMemory},pColour=#{pColour},pPrice=#{pPrice} where pId=#{pId}")
    int updateType(Type type);
    @Delete("delete from type where pId=#{id}")
    int delType(int id);
    @Insert("insert into type(pId,pName,pModel,pMemory,pColour,pPrice) values(#{pId},#{pName},#{pModel},#{pMemory},#{pColour},#{pPrice})")
    int insertType(Type type);
    List<Type> getTypeByLike(@Param("name") String name);
    int insertTypes(List<Type> list);
}
