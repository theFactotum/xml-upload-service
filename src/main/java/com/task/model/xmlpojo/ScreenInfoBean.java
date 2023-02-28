package com.task.model.xmlpojo;

import javax.xml.bind.annotation.XmlAttribute;


import com.fasterxml.jackson.databind.ObjectMapper;



public class ScreenInfoBean {

    String dpi="";
    String height="";
    String width="";
    String textContent="";
  public void setDpi(String dpi) { 
		this.dpi=dpi;
	} 
    @XmlAttribute(name = "dpi")
    public String getDpi() { 
		return dpi;
	} 
  public void setHeight(String height) { 
		this.height=height;
	} 
    @XmlAttribute(name = "height")
    public String getHeight() { 
		return height;
	} 
  public void setWidth(String width) { 
		this.width=width;
	} 
    @XmlAttribute(name = "width")
    public String getWidth() { 
		return width;
	} 
  public void setTextContent(String textContent) { 
		this.textContent=textContent;
	} 
    @XmlAttribute(name = "TextContent")
    public String getTextContent() { 
		return textContent;
	} 


}