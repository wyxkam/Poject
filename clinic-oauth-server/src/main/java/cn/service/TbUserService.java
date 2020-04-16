package cn.service;

import cn.mapper.TbUserMapper;
import cn.pojo.TbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbUserService {
    @Resource
    private TbUserMapper tbUserMapper;

    public TbUser getUserByUsername(String username) {
        return tbUserMapper.getUserByUsername(username);
    }
}
