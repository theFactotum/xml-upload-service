package com.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.model.DeviceInfoModel;
import com.task.service.IXmlDataUploadService;
import com.task.service.impl.XmlDataUploadServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(XmlDataUploadController.class)
@AutoConfigureMockMvc(addFilters=false)
 class XmlDataUploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private XmlDataUploadServiceImpl xmlDataUploadService;

    @Before
    public void setUp() {

    }

    @Test
    void testGetData() throws Exception {

        List<DeviceInfoModel> deviceInfoList = new ArrayList<>();

        DeviceInfoModel deviceInfo = new DeviceInfoModel();
        deviceInfo.setName("device1");
        deviceInfo.setScreen_height("200");
        deviceInfo.setScreen_width("300");
        deviceInfo.setScreen_dpi("45");
        deviceInfo.setScreen_newspapername("abac");

        deviceInfoList.add(deviceInfo);
        when(xmlDataUploadService.getAll()).thenReturn(deviceInfoList);

        mockMvc.perform(get("/api/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testSaveData() throws Exception {

        DeviceInfoModel deviceInfo = new DeviceInfoModel();
        deviceInfo.setName("device1");
        deviceInfo.setScreen_height("200");
        deviceInfo.setScreen_width("300");
        deviceInfo.setScreen_dpi("45");
        deviceInfo.setScreen_newspapername("abac");

        when(xmlDataUploadService.saveData(deviceInfo)).thenReturn(deviceInfo);

        mockMvc.perform(post("/api/save")
                .content(asJsonString(deviceInfo))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    void testSaveXMLDataInStore() {
    }

    public static String asJsonString(final Object obj)
            throws JsonProcessingException {

        return new ObjectMapper().writeValueAsString(obj);

    }
}