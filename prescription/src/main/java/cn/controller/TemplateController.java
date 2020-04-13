package cn.controller;

import cn.http.HttpClientHelper;
import cn.pojo.Page;
import cn.pojo.PrescriptionDetail;
import cn.pojo.PrescriptionTemplate;
import cn.response.Response;
import cn.service.TemplateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "处方模板数据")
public class TemplateController {
    @Value("${server.medicine.url}")
    private String serverMedicineUrl;
    @Autowired
    private HttpClientHelper httpClientHelper;

    @Autowired
    private TemplateService templateService;

    @ApiOperation(value = "查询处方模板信息", notes = "根据条件查询处方模板信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "number", value = "模板编号", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "模板名称", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "处方类别", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "jurisdiction", value = "模板权限", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "curPageNo", value = "当前页", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页数量", required = false, dataType = "Integer")
    })
    @GetMapping("/getInfo")
    public Response getInfo(@RequestParam String templateNumber, @RequestParam String templateName,
                            @RequestParam String prescriptionType, @RequestParam String templateJurisdiction,
                            @RequestParam Integer curPageNo, @RequestParam Integer pageSize) {
        if (curPageNo == null) {
            curPageNo = 1;
        }
        Page page = templateService.getInfo(
                templateNumber, templateName, prescriptionType, templateJurisdiction, curPageNo, 3);

        return httpClientHelper.get(serverMedicineUrl + "/");
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功!"),
            @ApiResponse(code = 500, message = "删除失败!")
    })
    @ApiOperation(value = "删除处方模板信息", notes = "通过id删除处方模板信息")
    @DeleteMapping("/del/{id}")
    public Integer deleteUserById(@PathVariable Integer id) {
        return templateService.delete(id);
    }

    @ApiOperation(value = "添加处方模板信息", notes = "添加处方模板，传入信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "number", value = "模板编号", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "模板名称", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "处方类别", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "jurisdiction", value = "模板权限", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "diagnose", value = "诊断", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "createtime", value = "创建时间", required = true, dataType = "Date"),
            @ApiImplicitParam(paramType = "query", name = "creator", value = "创建人员", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "describe", value = "模板描述", required = false, dataType = "String")
    })
    @PostMapping("/add")
    public Integer add(@RequestBody PrescriptionTemplate prescriptionTemplate, String creator) {
        return templateService.add(prescriptionTemplate, creator);
    }

    @ApiOperation(value = "修改处方模板信息", notes = "修改处方模板，传入信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "templateName", value = "模板名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "templateJurisdiction", value = "模板权限", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "diagnose", value = "诊断", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "describe", value = "模板描述", required = false, dataType = "String"),
    })
    @PutMapping("/update")
    public Integer updateUser(@RequestBody PrescriptionTemplate prescriptionTemplate) {
        List<PrescriptionDetail> list=templateService.getById(prescriptionTemplate.getId());
        return templateService.update(prescriptionTemplate);
    }
}
