/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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
