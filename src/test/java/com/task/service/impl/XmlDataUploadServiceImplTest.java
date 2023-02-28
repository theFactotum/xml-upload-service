package com.task.service.impl;

import com.task.model.DeviceInfoModel;
import com.task.repository.IDeviceInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters=false)
class XmlDataUploadServiceImplTest {

    @InjectMocks
    private XmlDataUploadServiceImpl xmlDataUploadService;

    @MockBean
    private IDeviceInfoRepository deviceRepository;


    @Test
    void test_getAll_success() {

        List<DeviceInfoModel> deviceInfoList = new ArrayList<>();

        DeviceInfoModel deviceInfo = new DeviceInfoModel();
        deviceInfo.setName("device1");
        deviceInfo.setScreen_height("200");
        deviceInfo.setScreen_width("300");
        deviceInfo.setScreen_dpi("45");
        deviceInfo.setScreen_newspapername("abac");

        deviceInfoList.add(deviceInfo);
        //Mockito.when(xmlDataUploadService.getAll()).thenReturn(deviceInfoList);
    }

    @Test
    void test_saveData_success() {

        List<DeviceInfoModel> deviceInfoList = new ArrayList<>();

        DeviceInfoModel deviceInfo = new DeviceInfoModel();
        deviceInfo.setName("device1");
        deviceInfo.setScreen_height("200");
        deviceInfo.setScreen_width("300");
        deviceInfo.setScreen_dpi("45");
        deviceInfo.setScreen_newspapername("abac");

        deviceInfoList.add(deviceInfo);
       // Mockito.when(xmlDataUploadService.saveData(deviceInfo)).thenReturn(deviceInfo);
    }

    @Test
    void test_saveData_failure() {

        DeviceInfoModel deviceInfo = new DeviceInfoModel();
        deviceInfo.setName("device1");
        deviceInfo.setScreen_height("200");
        deviceInfo.setScreen_width("300");
        deviceInfo.setScreen_dpi("45");
        deviceInfo.setScreen_newspapername("abac");

      //  Mockito.when(xmlDataUploadService.saveData(deviceInfo)).thenThrow(new OperationFailedException());
    }

}