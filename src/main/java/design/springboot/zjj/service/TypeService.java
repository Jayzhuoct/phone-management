package design.springboot.zjj.service;

import design.springboot.zjj.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> getTypeAll();
    Type getTypeById(int id);
    int updateType(Type type);
    int delType(int id);
    int insertType(Type type);
    List<Type> getTypeByLike(String name);
    int insertTypes(List<Type> list);
}
