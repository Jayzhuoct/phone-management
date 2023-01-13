package design.springboot.zjj;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import design.springboot.zjj.entity.Syslog;
import design.springboot.zjj.entity.Type;
import design.springboot.zjj.entity.User;
import design.springboot.zjj.mapper.TypeMapper;
import design.springboot.zjj.mapper.UserMapper;
import design.springboot.zjj.service.SysLogService;
import design.springboot.zjj.utils.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

@SpringBootTest
public class test {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private SysLogService sysLogService;
    @Test
    public void testPageHelper(){
        PageHelper.startPage(1, 2);
        List<User> select = userMapper.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(select);
        for(User user : select){
            System.out.println(pageInfo);
        }
    }
    @Test
    public void test() throws Exception {
        String filePath = "D:\\ideaproject\\phonemanagement\\src\\main\\resources\\file\\Type.xlsx";
        File file = new File(filePath);
        List<Type> select = ExcelUtil.readType(filePath);
        System.out.println("导入数据一共【"+select.size()+"】行");
        typeMapper.insertTypes(select);
        System.out.println("插入成功");
        System.out.println(select);
    }
    @Test
    public void test1() throws Exception {
        String filePath = "D:\\1.xlsx";
        List<Type> select = typeMapper.getTypeAll();
        System.out.println(select);
        ExcelUtil.writeType(select,filePath);
    }
    @Test
    public void test2() throws Exception {
        List<Syslog>syslogs= sysLogService.getLogByLike("z");
        System.out.println(syslogs);
    }


}

