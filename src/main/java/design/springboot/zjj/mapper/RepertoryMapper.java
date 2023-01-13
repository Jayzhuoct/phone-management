package design.springboot.zjj.mapper;

import design.springboot.zjj.entity.Repertory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RepertoryMapper {
    @Select("select * from repertory")
    List<Repertory> getRepertoryAll();
    @Select("select * from repertory where pName=#{name}")
    Repertory getRepertoryByName(String name);
    @Update("update repertory set pName=#{pName},pModel=#{pModel},pEnter=#{pEnter},pOut=#{pOut},pStock=#{pStock} where pName=#{pName}")
    int updateRepertory(Repertory repertory);
    @Delete("delete from repertory where pName=#{pName}")
    int delRepertory(String pName);
    @Insert("insert into repertory(pName,pModel,pEnter,pOut,pStock) values(#{pName},#{pModel},#{pEnter},#{pOut},#{pStock})")
    int insertRepertory(Repertory repertory);
    List<Repertory> getRepertoryByLike(@Param("name") String name);
    int insertRepertories(List<Repertory> list);
}
