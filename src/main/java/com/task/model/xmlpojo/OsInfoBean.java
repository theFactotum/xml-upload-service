package com.task.model.xmlpojo;


import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.databind.ObjectMapper;



public class OsInfoBean {

    String name="";
    String version="";
    String textContent="";
  public void setName(String name) { 
		this.name=name;
	} 
    @XmlAttribute(name = "name")
    public String getName() { 
		return name;
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