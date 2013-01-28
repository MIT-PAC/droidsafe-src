package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;


/**
 * Reads in an XML file and dumps it to standard out
 */
public class DumpXML {

  public static void  main (String[] args) throws Exception {

    DocumentBuilderFactory docBuilderFactory 
      = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    Document doc = docBuilder.parse (new File (args[0]));    
    doc.normalize();
    Element e = doc.getDocumentElement();
 
    BaseElement.dump_node (e, 0);
  }
}
