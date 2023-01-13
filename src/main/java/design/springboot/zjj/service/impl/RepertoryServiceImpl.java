package design.springboot.zjj.service.impl;

import design.springboot.zjj.entity.Repertory;
import design.springboot.zjj.mapper.RepertoryMapper;
import design.springboot.zjj.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepertoryServiceImpl implements RepertoryService {
    @Autowired
    RepertoryMapper repertoryMapper;
    @Override
    public List<Repertory> getRepertoryAll() {
        return repertoryMapper.getRepertoryAll();
    }

    @Override
    public Repertory getRepertoryByName(String name) {
        return repertoryMapper.getRepertoryByName(name);
    }

    @Override
    public int updateRepertory(Repertory repertory) {
        return repertoryMapper.updateRepertory(repertory);
    }

    @Override
    public int delRepertory(String name) {
        return repertoryMapper.delRepertory(name);
    }

    @Override
    public int insertRepertory(Repertory repertory) {
        return repertoryMapper.insertRepertory(repertory);
    }

    @Override
    public List<Repertory> getRepertoryByLike(String name) {
        return repertoryMapper.getRepertoryByLike(name);
    }

    @Override
    public int insertRepertories(List<Repertory> list) {
        return repertoryMapper.insertRepertories(list);
    }
}
