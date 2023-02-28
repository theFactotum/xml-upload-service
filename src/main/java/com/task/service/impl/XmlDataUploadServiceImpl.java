package com.task.service.impl;

import com.task.exception.OperationFailedException;
import com.task.model.DeviceInfoModel;

import com.task.model.xmlpojo.EpaperRequestBean;
import com.task.repository.IDeviceInfoRepository;
import com.task.service.IXmlDataUploadService;
import com.task.util.parser.BeanToXMLUtil;
import com.task.util.parser.XMLHelper;
import com.task.util.validator.XMLValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;


@Service
public class XmlDataUploadServiceImpl implements IXmlDataUploadService {

    Logger logger = LoggerFactory.getLogger(XmlDataUploadServiceImpl.class);

    @Autowired
    IDeviceInfoRepository uploadRepository;

    @Override
    public List<DeviceInfoModel> getAll() {
        List<DeviceInfoModel> xmlDataModelList = new ArrayList<>();
        uploadRepository.findAll().forEach(xmlDataModelList::add);

        logger.debug("Total records fetched from database successfully : "+xmlDataModelList.size());

        return xmlDataModelList;
    }
    @Override
    public DeviceInfoModel saveData(DeviceInfoModel deviceInfoModel) {

        deviceInfoModel.setUploadtime(LocalDateTime.now(ZoneId.systemDefault()));
        try {

            uploadRepository.
                    save(new DeviceInfoModel(
                            deviceInfoModel.getName(),
                            deviceInfoModel.getScreen_width(),
                            deviceInfoModel.getScreen_height(),
                            deviceInfoModel.getScreen_dpi(),
                            deviceInfoModel.getScreen_newspapername(),
                            deviceInfoModel.getFilename(),
                            deviceInfoModel.getUploadtime())
                    );
            logger.debug("New Record saved into Database successfully at : "+deviceInfoModel.getUploadtime());
            return deviceInfoModel;
        } catch (Exception e) {
            logger.error("Insert Operation Failed");
            throw new OperationFailedException("Insert Operation Failed");
        }
    }

    @Override
    public EpaperRequestBean saveXML(EpaperRequestBean requestBean) throws Exception {

        String filename = pathToSaveFile();
        BeanToXMLUtil.saveToFile(filename+"input.xml", requestBean);

        if(XMLValidator.validateXMLSchema(filename+"EpaperRequest.xsd",filename+"input.xml" )) {
            saveData(XMLHelper.transformXML(requestBean, filename));
            logger.debug("Record has been uploaded successfully");
            return requestBean;
        }
        else {
            logger.error("Save Operation Failed");
            throw new OperationFailedException("Save Operation Failed");
        }
    }

    private String pathToSaveFile() throws IOException {
       // String routePath = this.getClass().getClassLoader().getResource(File.separator).getPath();
       // log.debug(CLASSPATH+ "routePath="+ routePath);
        String routepath = "C://Rakesh_MauryaDrive/tem/";
      // return routePath+ File.separator+".."+File.separator+"schema"+File.separator;
return routepath;
    }
}
