package cn.service;

import cn.mapper.StaffMapper;
import cn.pojo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StaffService {
    @Resource
    private StaffMapper staffMapper;

    public Page getInfo(String name, String departmentsName, Integer curPageNo, Integer pageSize) {
        Page page = new Page();
        page.setCurPageNo(curPageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(staffMapper.count(name, departmentsName));
        page.setStaffList(staffMapper.getInfo(name, departmentsName, (curPageNo - 1) * pageSize, pageSize));
        return page;
    }

    public int getById(String name) {
        return staffMapper.getById(name);
    }
}
