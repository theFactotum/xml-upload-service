package com.task.controller;

import com.task.model.DeviceInfoModel;
import com.task.model.xmlpojo.EpaperRequestBean;
import com.task.service.IXmlDataUploadService;
import com.task.service.impl.XmlDataUploadServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class XmlDataUploadController {

    Logger logger = LoggerFactory.getLogger(XmlDataUploadServiceImpl.class);
    @Autowired
    IXmlDataUploadService iXmlDataUploadService;

    @GetMapping(value = "/getAll", produces = "application/json")
    public ResponseEntity<List<DeviceInfoModel>> getData(
    ) {
        logger.debug("Request in process");
        final List<DeviceInfoModel> list = iXmlDataUploadService.getAll();
        logger.debug("Response Total Records found: "+list.size());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping (value="/save")
    public ResponseEntity<DeviceInfoModel> saveData(
            @RequestBody DeviceInfoModel request
    ) {
        try {
            return new ResponseEntity<>(iXmlDataUploadService.saveData(request), HttpStatus.CREATED);

        } catch(Exception e) {
            logger.error("Upload Operation Failed. ");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping (value="/saveXML",
    consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<EpaperRequestBean> saveXMLDataInStore(
            @RequestBody EpaperRequestBean request
    ) throws Exception {
        logger.error("Upload Operation Failed. ");
        return new ResponseEntity<>(iXmlDataUploadService.saveXML(request),HttpStatus.CREATED);
    }

}
