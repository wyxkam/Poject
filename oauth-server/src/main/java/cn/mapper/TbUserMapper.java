package cn.mapper;

import cn.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbUserMapper {
    TbUser getUserByUsername(String username);
}
