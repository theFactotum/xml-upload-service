package com.task.util.parser;

import com.task.model.DeviceInfoModel;
import com.task.model.xmlpojo.EpaperRequestBean;

public class XMLHelper {

    public static DeviceInfoModel transformXML(EpaperRequestBean requestBean, String filename) {
        final DeviceInfoModel deviceInfoModel = new DeviceInfoModel();
        deviceInfoModel.setName(requestBean.getDeviceInfoBean().getName());
        deviceInfoModel.setScreen_width(requestBean.getDeviceInfoBean().getScreenInfoBean().getWidth());
        deviceInfoModel.setScreen_height(requestBean.getDeviceInfoBean().getScreenInfoBean().getHeight());
        deviceInfoModel.setScreen_dpi(requestBean.getDeviceInfoBean().getScreenInfoBean().getDpi());
        deviceInfoModel.setScreen_newspapername(requestBean.getDeviceInfoBean().getAppInfoBean().getNewspaperName());
        deviceInfoModel.setFilename(filename);

        return deviceInfoModel;
    }



}
