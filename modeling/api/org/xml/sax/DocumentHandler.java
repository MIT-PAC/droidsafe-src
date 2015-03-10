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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.xml.sax;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

@Deprecated public interface DocumentHandler {
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setDocumentLocator (Locator locator);
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void startDocument ()
    throws SAXException;
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void endDocument ()
    throws SAXException;
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void startElement (String name, AttributeList atts)
    throws SAXException;
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void endElement (String name)
    throws SAXException;
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void characters (char ch[], int start, int length)
    throws SAXException;
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void ignorableWhitespace (char ch[], int start, int length)
    throws SAXException;
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void processingInstruction (String target, String data)
    throws SAXException;

}
