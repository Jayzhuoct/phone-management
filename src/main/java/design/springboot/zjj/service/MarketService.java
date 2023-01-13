package design.springboot.zjj.service;

import design.springboot.zjj.entity.Market;

import java.util.List;

public interface MarketService {
    List<Market> getMarketAll();
    Market getMarketByName(String name);
    int updateMarket(Market market);
    int delMarket(String name);
    int insertMarket(Market market);
    List<Market> getMarketByLike(String name);
    int insertMarkets(List<Market> list);
}
