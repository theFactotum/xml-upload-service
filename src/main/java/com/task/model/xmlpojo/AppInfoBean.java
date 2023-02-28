package com.task.model.xmlpojo;


import javax.xml.bind.annotation.XmlAttribute;
import com.fasterxml.jackson.databind.ObjectMapper;



public class AppInfoBean {

    String newspaperName="";
    String version="";
    String textContent="";
  public void setNewspaperName(String newspaperName) { 
		this.newspaperName=newspaperName;
	} 
    @XmlAttribute(name = "newspaperName")
    public String getNewspaperName() { 
		return newspaperName;
	} 
  public void setVersion(String version) { 
		this.version=version;
	} 
    @XmlAttribute(name = "version")
    public String getVersion() { 
		return version;
	} 
  public void setTextContent(String textContent) { 
		this.textContent=textContent;
	} 
    @XmlAttribute(name = "TextContent")
    public String getTextContent() { 
		return textContent;
	} 


}