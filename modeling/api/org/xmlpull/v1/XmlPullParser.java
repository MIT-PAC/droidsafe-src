/* -*-             c-basic-offset: 4; indent-tabs-mode: nil; -*-  //------100-columns-wide------>|*/

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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * for license please see accompanying LICENSE.txt file (available also at http://www.xmlpull.org/)
 *
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.xmlpull.v1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public interface XmlPullParser {
    
    String NO_NAMESPACE = "";
    
    int START_DOCUMENT = 0;
    
    int END_DOCUMENT = 1;
    
    int START_TAG = 2;
    
    int END_TAG = 3;
    
    int TEXT = 4;
    
    int CDSECT = 5;
    
    int ENTITY_REF = 6;
    
    int IGNORABLE_WHITESPACE = 7;
    
    int PROCESSING_INSTRUCTION = 8;
    
    int COMMENT = 9;
    
    int DOCDECL = 10;
    
    String [] TYPES = {
        "START_DOCUMENT",
            "END_DOCUMENT",
            "START_TAG",
            "END_TAG",
            "TEXT",
            "CDSECT",
            "ENTITY_REF",
            "IGNORABLE_WHITESPACE",
            "PROCESSING_INSTRUCTION",
            "COMMENT",
            "DOCDECL"
    };
    
    String FEATURE_PROCESS_NAMESPACES =
        "http://xmlpull.org/v1/doc/features.html#process-namespaces";
    
    String FEATURE_REPORT_NAMESPACE_ATTRIBUTES =
        "http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes";
    
    String FEATURE_PROCESS_DOCDECL =
        "http://xmlpull.org/v1/doc/features.html#process-docdecl";
    
    String FEATURE_VALIDATION =
        "http://xmlpull.org/v1/doc/features.html#validation";
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setFeature(String name,
                           boolean state) throws XmlPullParserException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean getFeature(String name);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setProperty(String name,
                            Object value) throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Object getProperty(String name);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setInput(Reader in) throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setInput(InputStream inputStream, String inputEncoding)
        throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getInputEncoding();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void defineEntityReplacementText( String entityName,
                                            String replacementText ) throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getNamespaceCount(int depth) throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getNamespacePrefix(int pos) throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getNamespaceUri(int pos) throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getNamespace (String prefix);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getDepth();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getPositionDescription ();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getLineNumber();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getColumnNumber();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isWhitespace() throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getText ();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    char[] getTextCharacters(int [] holderForStartAndLength);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getNamespace ();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getName();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getPrefix();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isEmptyElementTag() throws XmlPullParserException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getAttributeCount();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getAttributeNamespace (int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getAttributeName (int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getAttributePrefix(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getAttributeType(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isAttributeDefault(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getAttributeValue(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getAttributeValue(String namespace,
                                    String name);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getEventType()
        throws XmlPullParserException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int next()
        throws XmlPullParserException, IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int nextToken()
        throws XmlPullParserException, IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void require(int type, String namespace, String name)
        throws XmlPullParserException, IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String nextText() throws XmlPullParserException, IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int nextTag() throws XmlPullParserException, IOException;

}
