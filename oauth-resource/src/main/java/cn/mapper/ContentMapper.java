package cn.mapper;

import cn.pojo.TbContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ContentMapper {
    TbContent queryAllContent(Integer categoryId);
}
