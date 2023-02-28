package com.task.model.xmlpojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class EpaperRequestBean {

    String textContent="";
@JsonProperty("deviceInfo") 
    DeviceInfoBean deviceInfoBean ;
@JsonProperty("getPages") 
    GetPagesBean getPagesBean ;
  public void setTextContent(String textContent) { 
		this.textContent=textContent;
	} 
    @XmlAttribute(name = "TextContent")
    public String getTextContent() { 
		return textContent;
	} 
    @XmlElement(name = "deviceInfo")
    public DeviceInfoBean getDeviceInfoBean() { 
		if(deviceInfoBean==null) deviceInfoBean=new DeviceInfoBean(); 
		return deviceInfoBean;
	} 
  public void setDeviceInfoBean( DeviceInfoBean deviceInfoBean ) { 
		this.deviceInfoBean=deviceInfoBean;
	} 
    @XmlElement(name = "getPages")
    public GetPagesBean getGetPagesBean() { 
		if(getPagesBean==null) getPagesBean=new GetPagesBean(); 
		return getPagesBean;
	} 
  public void setGetPagesBean( GetPagesBean getPagesBean ) { 
		this.getPagesBean=getPagesBean;
	} 


}