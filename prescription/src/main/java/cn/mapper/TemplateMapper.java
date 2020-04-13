package cn.mapper;

import cn.pojo.PrescriptionTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TemplateMapper {
    List<PrescriptionTemplate> getInfo(
            String number, String name, String type,String jurisdiction,
            Integer curPageNo,Integer pageSize);

    int add(PrescriptionTemplate prescriptionTemplate);

    int update(PrescriptionTemplate prescriptionTemplate);

    int delete(Integer id);

    int count(String number, String name, String type,String jurisdiction);
}
