package cn.mapper;

import cn.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StaffMapper {
    List<Staff> getInfo(String name,String departmentsName,Integer curPageNo,Integer pageSize);

    int count(String name,String departmentsName);

    int getById(String name);
}
