package com.task.model.xmlpojo;


import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.databind.ObjectMapper;



public class GetPagesBean {
    String editionDefId="";
    String publicationDate="";
    String textContent="";
  public void setEditionDefId(String editionDefId) { 
		this.editionDefId=editionDefId;
	} 
    @XmlAttribute(name = "editionDefId")
    public String getEditionDefId() { 
		return editionDefId;
	} 
  public void setPublicationDate(String publicationDate) { 
		this.publicationDate=publicationDate;
	} 
    @XmlAttribute(name = "publicationDate")
    public String getPublicationDate() { 
		return publicationDate;
	} 
  public void setTextContent(String textContent) { 
		this.textContent=textContent;
	} 
    @XmlAttribute(name = "TextContent")
    public String getTextContent() { 
		return textContent;
	} 


}