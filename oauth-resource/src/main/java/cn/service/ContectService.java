package cn.service;

import cn.mapper.ContentMapper;
import cn.pojo.TbContent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContectService {
    @Resource
    private ContentMapper contentMapper;

    public TbContent queryAllContent(Integer categoryId) {
        TbContent tbContent = contentMapper.queryAllContent(categoryId);
        System.out.println(tbContent);
        return tbContent;
    }
}
