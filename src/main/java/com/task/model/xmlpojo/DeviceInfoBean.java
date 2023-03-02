package com.task.model.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;


public class DeviceInfoBean {
    String id="";
    String name="";
    String textContent="";
@JsonProperty("screenInfo") 
    ScreenInfoBean screenInfoBean ;
@JsonProperty("osInfo") 
    OsInfoBean osInfoBean ;
@JsonProperty("appInfo") 
    AppInfoBean appInfoBean ;
  public void setId(String id) { 
		this.id=id;
	} 
    @XmlAttribute(name = "id")
    public String getId() { 
		return id;
	} 
  public void setName(String name) { 
		this.name=name;
	} 
    @XmlAttribute(name = "name")
    public String getName() { 
		return name;
	} 
  public void setTextContent(String textContent) {
		this.textContent=textContent;
	}
    @XmlAttribute(name = "TextContent")
    public String getTextContent() {
		return textContent;
	}
    @XmlElement(name = "screenInfo")
    public ScreenInfoBean getScreenInfoBean() { 
		if(screenInfoBean==null) screenInfoBean=new ScreenInfoBean(); 
		return screenInfoBean;
	} 
  public void setScreenInfoBean( ScreenInfoBean screenInfoBean ) { 
		this.screenInfoBean=screenInfoBean;
	} 
    @XmlElement(name = "osInfo")
    public OsInfoBean getOsInfoBean() { 
		if(osInfoBean==null) osInfoBean=new OsInfoBean(); 
		return osInfoBean;
	} 
  public void setOsInfoBean( OsInfoBean osInfoBean ) { 
		this.osInfoBean=osInfoBean;
	} 
    @XmlElement(name = "appInfo")
    public AppInfoBean getAppInfoBean() { 
		if(appInfoBean==null) appInfoBean=new AppInfoBean(); 
		return appInfoBean;
	} 
  public void setAppInfoBean( AppInfoBean appInfoBean ) { 
		this.appInfoBean=appInfoBean;
	} 


}