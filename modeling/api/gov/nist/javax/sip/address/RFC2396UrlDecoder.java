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
* Conditions Of Use 
* 
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
* 
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
* 
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*  
* .
* 
*/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;

public class RFC2396UrlDecoder {

    /**
     * Decode a path.
     *
     * <p>Interprets %XX (where XX is hexadecimal number) as UTF-8 encoded bytes.
     * <p>The validity of the input path is not checked (i.e. characters that
     * were not encoded will not be reported as errors).
     * <p>This method differs from URLDecoder.decode in that it always uses UTF-8
     * (while URLDecoder uses the platform default encoding, often ISO-8859-1),
     * and doesn't translate + characters to spaces.
     *
     * @param uri the path to decode
     * @return the decoded path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.904 -0500", hash_original_method = "A5A2A9811677715038BAC786167B8765", hash_generated_method = "9C82F7C6B7E76163BD81250FB611C32C")
    
public static String decode(String uri) {
        StringBuffer translatedUri = new StringBuffer(uri.length());
        byte[] encodedchars = new byte[uri.length() / 3];
        int i = 0;
        int length = uri.length();
        int encodedcharsLength = 0;
        while (i < length) {
            if (uri.charAt(i) == '%') {
                //we must process all consecutive %-encoded characters in one go, because they represent
                //an UTF-8 encoded string, and in UTF-8 one character can be encoded as multiple bytes
                while (i < length && uri.charAt(i) == '%') {
                    if (i + 2 < length) {
                        try {
                            byte x = (byte)Integer.parseInt(uri.substring(i + 1, i + 3), 16);
                            encodedchars[encodedcharsLength] = x;
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Illegal hex characters in pattern %" + uri.substring(i + 1, i + 3));
                        }
                        encodedcharsLength++;
                        i += 3;
                    } else {
                        throw new IllegalArgumentException("% character should be followed by 2 hexadecimal characters.");
                    }
                }
                try {
                    String translatedPart = new String(encodedchars, 0, encodedcharsLength, "UTF-8");
                    translatedUri.append(translatedPart);
                } catch (UnsupportedEncodingException e) {
                    //the situation that UTF-8 is not supported is quite theoretical, so throw a runtime exception
                    throw new RuntimeException("Problem in decodePath: UTF-8 encoding not supported.");
                }
                encodedcharsLength = 0;
            } else {
                //a normal character
                translatedUri.append(uri.charAt(i));
                i++;
            }
        }
        return translatedUri.toString();
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.135 -0400", hash_original_method = "9568D8B70D3A77B07F9F9DE5F70834DD", hash_generated_method = "9568D8B70D3A77B07F9F9DE5F70834DD")
    public RFC2396UrlDecoder ()
    {
        //Synthesized constructor
    }
    
}

