package cn.controller;

import cn.pojo.PrescriptionTemplate;
import cn.service.TemplateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {
    @Autowired
    private TemplateService templateService;

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;
    MockHttpSession session;

    @Test
    public void getInfo() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/getInfo")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void add() throws Exception {
        ObjectMapper om = new ObjectMapper();
        PrescriptionTemplate template=new PrescriptionTemplate("bk0000001","处方模板19",
                "中药处方","鼻炎","公共模板",new Date(),"张三","");
        String s = om.writeValueAsString(template);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(s)
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void update() throws Exception{
        ObjectMapper om = new ObjectMapper();
        PrescriptionTemplate template=new PrescriptionTemplate("bk0000001","处方模板19",
                "中药处方","鼻炎","公共模板",new Date(),"张三","aaaa");
        template.setId(1);
        String s = om.writeValueAsString(template);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(s)
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void delete() throws Exception{
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/del/1")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session=new MockHttpSession();
    }
}
