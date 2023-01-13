package design.springboot.zjj.service.impl;

import design.springboot.zjj.entity.Admin;
import design.springboot.zjj.mapper.AdminMapper;
import design.springboot.zjj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Admin> getAdminAll() {
        return adminMapper.getAdminAll();
    }

    @Override
    public int getAdminById(int aid) {
        return adminMapper.getAdminById(aid);
    }

    @Override
    public Admin getAdminByName(String name) {
        return adminMapper.getAdminByName(name);
    }

    @Override
    public int updateAdmin(Admin admin) {
            return adminMapper.updateAdmin(admin);
    }

    @Override
    public int delAdmin(int aid) {
            return adminMapper.delAdmin(aid);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }
}
