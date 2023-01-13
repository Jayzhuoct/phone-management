package design.springboot.zjj.mapper;

import design.springboot.zjj.entity.Market;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MarketMapper {
    @Select("select * from market")
    List<Market> getMarketAll();
    @Select("select * from market where pName=#{name}")
    Market getMarketByName(String name);
    @Update("update market set pName=#{pName},pModel=#{pModel},pBid=#{pBid},pPrice=#{pPrice},pSales=#{pSales} where pName=#{pName}")
    int updateMarket(Market market);
    @Delete("delete from market where pName=#{name}")
    int delMarket(String name);
    @Insert("insert into market(pName,pModel,pBid,pPrice,pSales) values(#{pName},#{pModel},#{pBid},#{pPrice},#{pSales})")
    int insertMarket(Market market);
    List<Market> getMarketByLike(@Param("name") String name);
    int insertMarkets(List<Market> list);

}
