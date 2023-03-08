package com.task.service.impl;

import com.task.exception.OperationFailedException;
import com.task.exception.RecordAlreadyExistException;
import com.task.exception.RecordNotFoundException;
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

import java.io.File;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class XmlDataUploadServiceImpl implements IXmlDataUploadService {

    public static final String XSD_FILE_NAME="schema"+File.separator+"EpaperRequest.xsd";
    public static final String XML_FILE_NAME="schema"+File.separator+"input.xml";


    Logger logger = LoggerFactory.getLogger(XmlDataUploadServiceImpl.class);

    @Autowired
    IDeviceInfoRepository uploadRepository;


    @Override
    public Optional<DeviceInfoModel> getDeviceInfoById(DeviceInfoModel deviceInfoModel) {

        // use orElse Throw
        return Optional.ofNullable(uploadRepository.findById(deviceInfoModel.getId()))
                .orElseThrow(RecordNotFoundException::new);
    }

    @Override
    public List<DeviceInfoModel> getAll() {
        return StreamSupport.stream(uploadRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public DeviceInfoModel saveData(DeviceInfoModel deviceInfoModel) {

        deviceInfoModel.setUploadtime(LocalDateTime.now(ZoneId.systemDefault()));

            uploadRepository.save(deviceInfoModel);
            logger.debug("New Record saved into Database successfully at : "+deviceInfoModel.getUploadtime());
           return deviceInfoModel;

    }

    @Override
    public EpaperRequestBean saveXML(EpaperRequestBean requestBean) throws Exception {

        BeanToXMLUtil.saveToFile(XML_FILE_NAME, requestBean);

        // should be more functional
        if(XMLValidator.validateXMLSchema(XSD_FILE_NAME,XML_FILE_NAME)) {
            saveData(XMLHelper.transformXML(requestBean, XML_FILE_NAME));
            logger.debug("XML Record has been uploaded successfully");
            return requestBean;
        }
        else {
            logger.error("Save Operation Failed");
            throw new OperationFailedException("Save Operation Failed");
        }
    }
}
