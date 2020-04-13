package cn.mapper;

import cn.pojo.TbPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbPermissionMapper {
    List<TbPermission> getByUserid(Integer id);
}
