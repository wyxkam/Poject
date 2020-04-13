package cn.mapper;

import cn.pojo.PrescriptionDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DetailMapper {
    List<PrescriptionDetail> getById(Integer id);
}
