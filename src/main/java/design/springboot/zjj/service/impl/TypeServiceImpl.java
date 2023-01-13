package design.springboot.zjj.service.impl;

import design.springboot.zjj.entity.Type;
import design.springboot.zjj.mapper.TypeMapper;
import design.springboot.zjj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    public List<Type> getTypeAll() {
        return typeMapper.getTypeAll();
    }

    @Override
    public Type getTypeById(int id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public int delType(int id) {
        return typeMapper.delType(id);
    }

    @Override
    public int insertType(Type type) {
        return typeMapper.insertType(type);
    }

    @Override
    public List<Type> getTypeByLike(String name) {
        return typeMapper.getTypeByLike(name);
    }

    @Override
    public int insertTypes(List<Type> list) {
        return typeMapper.insertTypes(list);
    }
}
