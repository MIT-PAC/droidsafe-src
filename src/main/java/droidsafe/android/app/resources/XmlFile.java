package droidsafe.android.app.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

public class XmlFile extends File {
  
  private static final Logger logger = LoggerFactory.getLogger(XmlFile.class);	

  public XmlFile(String pathname) {
    super(pathname);
  }

  public Element getDocumentElement() {
    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

    // Set up document builder
    DocumentBuilder docBuilder = null;
    try {
      docBuilder = docBuilderFactory.newDocumentBuilder();
    } catch(ParserConfigurationException e){
      logger.error("Couldn't create and configure DocumentBuilder for XmlFile {} : {}", this, e);
      return null;
    }

    // Parse the file
    Document doc = null;
    try {
      doc = docBuilder.parse (this);
    } catch(SAXException e) {
      logger.error("Couldn't parse the XmlFile {} : {}", this, e);
      return null;
    } catch(IOException e) {
      logger.error("Couldn't parse the XmlFile {} : {}", this, e);
      return null;
    } 


    if(doc != null) {
      // Normalize the doc
      doc.normalize();

      // return top-level element
      return doc.getDocumentElement();
    }

    return null;
  }
}
