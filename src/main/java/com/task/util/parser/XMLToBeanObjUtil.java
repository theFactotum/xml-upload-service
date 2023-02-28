package com.task.util.parser;

import com.task.model.xmlpojo.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// This class has not been used
public class XMLToBeanObjUtil {
    private static EpaperRequestBean convertXmlToBeanObject(Document doc) throws Exception {

        Element epaperRequestElm = doc.getDocumentElement();
        EpaperRequestBean epaperRequestBean = new EpaperRequestBean();


        epaperRequestBean.setTextContent(XMLUtil.getFirstLevelTextContent(epaperRequestElm));

        Element deviceInfoElm = XMLUtil.getChildElement(epaperRequestElm, "deviceInfo");
        DeviceInfoBean deviceInfoBean = new DeviceInfoBean();
        epaperRequestBean.setDeviceInfoBean(deviceInfoBean);


        deviceInfoBean.setId(deviceInfoElm.getAttribute("id"));
        deviceInfoBean.setName(deviceInfoElm.getAttribute("name"));
        deviceInfoBean.setTextContent(XMLUtil.getFirstLevelTextContent(deviceInfoElm));

        Element screenInfoElm = XMLUtil.getChildElement(deviceInfoElm, "screenInfo");
        ScreenInfoBean screenInfoBean = new ScreenInfoBean();
        deviceInfoBean.setScreenInfoBean(screenInfoBean);


        screenInfoBean.setDpi(screenInfoElm.getAttribute("dpi"));
        screenInfoBean.setHeight(screenInfoElm.getAttribute("height"));
        screenInfoBean.setWidth(screenInfoElm.getAttribute("width"));
        screenInfoBean.setTextContent(XMLUtil.getFirstLevelTextContent(screenInfoElm));

        Element osInfoElm = XMLUtil.getChildElement(deviceInfoElm, "osInfo");
        OsInfoBean osInfoBean = new OsInfoBean();
        deviceInfoBean.setOsInfoBean(osInfoBean);


        osInfoBean.setName(osInfoElm.getAttribute("name"));
        osInfoBean.setVersion(osInfoElm.getAttribute("version"));
        osInfoBean.setTextContent(XMLUtil.getFirstLevelTextContent(osInfoElm));

        Element appInfoElm = XMLUtil.getChildElement(deviceInfoElm, "appInfo");
        AppInfoBean appInfoBean = new AppInfoBean();
        deviceInfoBean.setAppInfoBean(appInfoBean);


        appInfoBean.setNewspaperName(appInfoElm.getAttribute("newspaperName"));
        appInfoBean.setVersion(appInfoElm.getAttribute("version"));
        appInfoBean.setTextContent(XMLUtil.getFirstLevelTextContent(appInfoElm));

        Element getPagesElm = XMLUtil.getChildElement(epaperRequestElm, "getPages");
        GetPagesBean getPagesBean = new GetPagesBean();
        epaperRequestBean.setGetPagesBean(getPagesBean);


        getPagesBean.setEditionDefId(getPagesElm.getAttribute("editionDefId"));
        getPagesBean.setPublicationDate(getPagesElm.getAttribute("publicationDate"));
        getPagesBean.setTextContent(XMLUtil.getFirstLevelTextContent(getPagesElm));


        return epaperRequestBean;
    }
}