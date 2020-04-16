package cn.controller;

import cn.pojo.TbContent;
import cn.service.ContectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentController {
    @Autowired
    private ContectService contectService;

    @GetMapping("/list")
    @ResponseBody
    public TbContent queryAllContent(@RequestParam("categoryId") Integer categoryId){
        return contectService.queryAllContent(categoryId);
    }
}
