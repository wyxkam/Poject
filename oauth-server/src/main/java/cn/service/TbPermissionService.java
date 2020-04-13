package cn.service;

import cn.mapper.TbPermissionMapper;
import cn.pojo.TbPermission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbPermissionService {
    @Resource
    TbPermissionMapper tbPermissionMapper;

    public List<TbPermission> getByUserid(Integer id){
        return tbPermissionMapper.getByUserid(id);
    }
}
