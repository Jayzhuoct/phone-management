package design.springboot.zjj.service;

import design.springboot.zjj.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdminAll();
    int getAdminById(int aid);
    Admin getAdminByName(String name);
    int updateAdmin(Admin admin);
    int delAdmin(int aid);
    int insertAdmin(Admin admin);
}
