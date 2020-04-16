package cn.service;

import cn.mapper.DetailMapper;
import cn.mapper.TemplateMapper;
import cn.pojo.Page;
import cn.pojo.PrescriptionDetail;
import cn.pojo.PrescriptionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateService {
    @Resource
    private TemplateMapper templateMapper;

    @Resource
    private DetailMapper detailMapper;

    public Page getInfo(
            String templateNumber, String templateName,
            String prescriptionType, String templateJurisdiction,
            Integer curPageNo, Integer pageSize) {
        Page page = new Page();
        page.setCurPageNo(curPageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(templateMapper.count(templateNumber, templateName, prescriptionType, templateJurisdiction));
        page.setList(templateMapper.getInfo(templateNumber, templateName, prescriptionType,
                templateJurisdiction, (curPageNo - 1) * pageSize, pageSize));
        return page;
    }

    public int add(PrescriptionTemplate prescriptionTemplate,String name) {
        StaffService staffService=new StaffService();
        Integer id=staffService.getById(name);
        prescriptionTemplate.setStaffid(id);
        return templateMapper.add(prescriptionTemplate);
    }

    public int update(PrescriptionTemplate prescriptionTemplate) {
        return templateMapper.update(prescriptionTemplate);
    }

    public List<PrescriptionDetail> getById(Integer id){
        return detailMapper.getById(id);
    }

    public int delete(Integer id) {
        return templateMapper.delete(id);
    }
}
