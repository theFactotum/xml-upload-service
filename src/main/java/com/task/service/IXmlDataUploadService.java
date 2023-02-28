package com.task.service;

import com.task.model.DeviceInfoModel;
import com.task.model.xmlpojo.EpaperRequestBean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IXmlDataUploadService {

    public List<DeviceInfoModel> getAll();
    public DeviceInfoModel saveData(DeviceInfoModel deviceInfoModel);
    public EpaperRequestBean saveXML(EpaperRequestBean request) throws Exception;

}
