package design.springboot.zjj.service.impl;

import design.springboot.zjj.entity.Market;
import design.springboot.zjj.mapper.MarketMapper;
import design.springboot.zjj.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarketServiceImpl implements MarketService {
    @Autowired
    MarketMapper marketMapper;
    @Override
    public List<Market> getMarketAll() {
        return marketMapper.getMarketAll();
    }
    @Override
    public Market getMarketByName(String name) {
        return marketMapper.getMarketByName(name);
    }

    @Override
    public int updateMarket(Market market) {
            return marketMapper.updateMarket(market);
    }

    @Override
    public int delMarket(String name) {
            return marketMapper.delMarket(name);
    }

    @Override
    public int insertMarket(Market market) {
            return marketMapper.insertMarket(market);
    }

    @Override
    public List<Market> getMarketByLike(String name) {
        return marketMapper.getMarketByLike(name);
    }

    @Override
    public int insertMarkets(List<Market> list) {
        return marketMapper.insertMarkets(list);
    }
}
