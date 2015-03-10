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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

/**
 * The XmlStreamReaderException is thrown by the XmlStreamReader constructors if
 * the charset encoding can not be determined according to the XML 1.0
 * specification and RFC 3023.
 * <p>
 * The exception returns the unconsumed InputStream to allow the application to
 * do an alternate processing with the stream. Note that the original
 * InputStream given to the XmlStreamReader cannot be used as that one has been
 * already read.
 *
 * @version $Id: XmlStreamReaderException.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 2.0
 */
public class XmlStreamReaderException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.713 -0400", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.714 -0400", hash_original_field = "BCB566D72037AF7F9E064FBC666076E1", hash_generated_field = "EC82926CAB066F06AAFC3726EF2F5BF5")

    private  String bomEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.714 -0400", hash_original_field = "3534FBB3FFC5B8FED0C0CE5746401C09", hash_generated_field = "293562CF19517A35BB931BB29CBF3076")

    private  String xmlGuessEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.715 -0400", hash_original_field = "DAFD1F56979D27C6800F92D1F6F82EE0", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private  String xmlEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.715 -0400", hash_original_field = "5AD82F0083A03E78BDA0D5BDE93CC09D", hash_generated_field = "CF0AADC5E49F7DC7EC0DF8E902974BFE")

    private  String contentTypeMime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.716 -0400", hash_original_field = "EB765441808FEEEA183BED002B64CCBF", hash_generated_field = "C4A1C9E33654E0FF1EF148FC95CCA1FD")

    private  String contentTypeEncoding;

    /**
     * Creates an exception instance if the charset encoding could not be
     * determined.
     * <p>
     * Instances of this exception are thrown by the XmlStreamReader.
     *
     * @param msg message describing the reason for the exception.
     * @param bomEnc BOM encoding.
     * @param xmlGuessEnc XML guess encoding.
     * @param xmlEnc XML prolog encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.716 -0400", hash_original_method = "B1FC8025A53E034082D8F586CBC4D3DF", hash_generated_method = "DB7EBCB4A1B3D823FC7B0FF66BB9C85C")
    
public XmlStreamReaderException(String msg, String bomEnc,
            String xmlGuessEnc, String xmlEnc) {
        this(msg, null, null, bomEnc, xmlGuessEnc, xmlEnc);
    }

    /**
     * Creates an exception instance if the charset encoding could not be
     * determined.
     * <p>
     * Instances of this exception are thrown by the XmlStreamReader.
     *
     * @param msg message describing the reason for the exception.
     * @param ctMime MIME type in the content-type.
     * @param ctEnc encoding in the content-type.
     * @param bomEnc BOM encoding.
     * @param xmlGuessEnc XML guess encoding.
     * @param xmlEnc XML prolog encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.717 -0400", hash_original_method = "67214B0FED640930AABB3A175A226E31", hash_generated_method = "0CE2DC9095A048349DB0C720F4925AA5")
    
public XmlStreamReaderException(String msg, String ctMime, String ctEnc,
            String bomEnc, String xmlGuessEnc, String xmlEnc) {
        super(msg);
        contentTypeMime = ctMime;
        contentTypeEncoding = ctEnc;
        bomEncoding = bomEnc;
        xmlGuessEncoding = xmlGuessEnc;
        xmlEncoding = xmlEnc;
    }

    /**
     * Returns the BOM encoding found in the InputStream.
     *
     * @return the BOM encoding, null if none.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.718 -0400", hash_original_method = "8E6ACC549621DB046C39AAF67FE47CA0", hash_generated_method = "53BA3EE9CD15F4A6E020F2DB2D968979")
    
public String getBomEncoding() {
        return bomEncoding;
    }

    /**
     * Returns the encoding guess based on the first bytes of the InputStream.
     *
     * @return the encoding guess, null if it couldn't be guessed.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.718 -0400", hash_original_method = "93213E0474402E85CBBF9C6807083224", hash_generated_method = "ACE12E2EA479D4EA9C8D845479659B02")
    
public String getXmlGuessEncoding() {
        return xmlGuessEncoding;
    }

    /**
     * Returns the encoding found in the XML prolog of the InputStream.
     *
     * @return the encoding of the XML prolog, null if none.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.718 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "52CC0571C63508D20A0FDEAF20E2DECC")
    
public String getXmlEncoding() {
        return xmlEncoding;
    }

    /**
     * Returns the MIME type in the content-type used to attempt determining the
     * encoding.
     *
     * @return the MIME type in the content-type, null if there was not
     *         content-type or the encoding detection did not involve HTTP.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.719 -0400", hash_original_method = "AF89DB06972BD6AFB50AFEC4B946DE00", hash_generated_method = "F2227FE88C063102EAD612294F13FAC1")
    
public String getContentTypeMime() {
        return contentTypeMime;
    }

    /**
     * Returns the encoding in the content-type used to attempt determining the
     * encoding.
     *
     * @return the encoding in the content-type, null if there was not
     *         content-type, no encoding in it or the encoding detection did not
     *         involve HTTP.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.719 -0400", hash_original_method = "D63D11323318AB5C82EE37F5F9D391F2", hash_generated_method = "84DB04B4F19567B46C572BFFD719BEBE")
    
public String getContentTypeEncoding() {
        return contentTypeEncoding;
    }
}
