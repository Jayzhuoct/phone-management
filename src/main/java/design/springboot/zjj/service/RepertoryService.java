package design.springboot.zjj.service;

import design.springboot.zjj.entity.Repertory;

import java.util.List;

public interface RepertoryService {
    List<Repertory> getRepertoryAll();
    Repertory getRepertoryByName(String name);
    int updateRepertory(Repertory repertory);
    int delRepertory(String name);
    int insertRepertory(Repertory repertory);
    List<Repertory> getRepertoryByLike(String name);
    int insertRepertories(List<Repertory> list);
}
