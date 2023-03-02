package com.task.util.parser;

import com.task.model.xmlpojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class BeanToXMLUtil {

    public static Logger logger = LoggerFactory.getLogger(BeanToXMLUtil.class);

    public static Document convertBeanToXML(EpaperRequestBean epaperRequestBean) throws Exception {
        Document inputDoc = XMLUtil.createDocument("epaperRequest");
        Element epaperRequestElm = inputDoc.getDocumentElement();
        epaperRequestElm.setTextContent(epaperRequestBean.getTextContent());

        Element deviceInfoElm = XMLUtil.createChildElement(epaperRequestElm, "deviceInfo");
        DeviceInfoBean deviceInfoBean = epaperRequestBean.getDeviceInfoBean();
        deviceInfoElm.setTextContent(deviceInfoBean.getTextContent());

        deviceInfoElm.setAttribute("id", deviceInfoBean.getId());
        deviceInfoElm.setAttribute("name", deviceInfoBean.getName());

        Element screenInfoElm = XMLUtil.createChildElement(deviceInfoElm, "screenInfo");
        ScreenInfoBean screenInfoBean = deviceInfoBean.getScreenInfoBean();
        screenInfoElm.setTextContent(screenInfoBean.getTextContent());

        screenInfoElm.setAttribute("dpi", screenInfoBean.getDpi());
        screenInfoElm.setAttribute("height", screenInfoBean.getHeight());
        screenInfoElm.setAttribute("width", screenInfoBean.getWidth());

        Element osInfoElm = XMLUtil.createChildElement(deviceInfoElm, "osInfo");
        OsInfoBean osInfoBean = deviceInfoBean.getOsInfoBean();
        osInfoElm.setTextContent(osInfoBean.getTextContent());

        osInfoElm.setAttribute("name", osInfoBean.getName());
        osInfoElm.setAttribute("version", osInfoBean.getVersion());

        Element appInfoElm = XMLUtil.createChildElement(deviceInfoElm, "appInfo");
        AppInfoBean appInfoBean = deviceInfoBean.getAppInfoBean();
        appInfoElm.setTextContent(appInfoBean.getTextContent());

        appInfoElm.setAttribute("newspaperName", appInfoBean.getNewspaperName());
        appInfoElm.setAttribute("version", appInfoBean.getVersion());

        Element getPagesElm = XMLUtil.createChildElement(epaperRequestElm, "getPages");
        GetPagesBean getPagesBean = epaperRequestBean.getGetPagesBean();
        getPagesElm.setTextContent(getPagesBean.getTextContent());

        getPagesElm.setAttribute("editionDefId", getPagesBean.getEditionDefId());
        getPagesElm.setAttribute("publicationDate", getPagesBean.getPublicationDate());

        return inputDoc;
    }


    public static void saveToFile(String filename, EpaperRequestBean epaperRequestBean) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(EpaperRequestBean.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File(filename);
            jaxbMarshaller.marshal(epaperRequestBean, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

}