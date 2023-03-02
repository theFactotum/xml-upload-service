package com.task.service.impl;

import com.task.model.DeviceInfoModel;
import com.task.model.xmlpojo.*;
import com.task.repository.IDeviceInfoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters=false)
@ExtendWith(MockitoExtension.class)
class XmlDataUploadServiceImplTest {

    @InjectMocks
    private XmlDataUploadServiceImpl xmlDataUploadService;

    @Mock
    private IDeviceInfoRepository deviceRepository;


    @Test
    void test_getAll_success() {

        List<DeviceInfoModel> deviceInfoList = new ArrayList<>();

        DeviceInfoModel deviceInfo = DeviceInfoModel.builder().name("device1")
                .screen_height("200")
                .screen_width("300")
                .screen_dpi("45")
                .screen_newspapername("abac").build();

        deviceInfoList.add(deviceInfo);
        deviceInfoList.add(deviceInfo);

        Mockito.when(deviceRepository.findAll()).thenReturn(deviceInfoList);
        List<DeviceInfoModel> result = xmlDataUploadService.getAll();

        assertEquals(2, result.size());
    }


    @Test
    void test_saveData_success() {

        DeviceInfoModel deviceInfo = DeviceInfoModel.builder().name("device1")
                .screen_height("200")
                .screen_width("300")
                .screen_dpi("45")
                .screen_newspapername("abac").build();

        Mockito.when(deviceRepository.save(any())).thenReturn(deviceInfo);
        DeviceInfoModel result = xmlDataUploadService.saveData(deviceInfo);

        assertNotNull(result);

    }

@Test
    void test_saveXML_success() throws Exception {

    DeviceInfoModel deviceInfo = DeviceInfoModel.builder().name("device1")
            .screen_height("200")
            .screen_width("300")
            .screen_dpi("45")
            .screen_newspapername("abac").build();

        Mockito.when(deviceRepository.save(any())).thenReturn(deviceInfo);
        EpaperRequestBean result = xmlDataUploadService.saveXML(buildXMLBeans());

    }

    private EpaperRequestBean buildXMLBeans(){
        OsInfoBean osInfoBean = new OsInfoBean();
        osInfoBean.setVersion("1.0");

        ScreenInfoBean screenInfoBean = new ScreenInfoBean();
        screenInfoBean.setDpi("123");
        screenInfoBean.setHeight("800");
        screenInfoBean.setWidth("450");

        AppInfoBean appInfoBean = new AppInfoBean();
        appInfoBean.setNewspaperName("abc");
        appInfoBean.setVersion("1.0");

        DeviceInfoBean deviceInfoBean = new DeviceInfoBean();
        deviceInfoBean.setName("device2");
        deviceInfoBean.setId("id1");
        deviceInfoBean.setScreenInfoBean(screenInfoBean);
        deviceInfoBean.setOsInfoBean(osInfoBean);
        deviceInfoBean.setAppInfoBean(appInfoBean);

        GetPagesBean getPagesBean = new GetPagesBean();
        getPagesBean.setEditionDefId("11");
        getPagesBean.setPublicationDate("2017-06-06");

        EpaperRequestBean requestBean = new EpaperRequestBean();

        requestBean.setDeviceInfoBean(deviceInfoBean);
        requestBean.setGetPagesBean(getPagesBean);

        return requestBean;
    }

}