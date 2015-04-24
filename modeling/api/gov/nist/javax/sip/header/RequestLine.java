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
/*******************************************************************************
* Product of NIST/ITL Advanced Networking Technologies Division (ANTD).        *
*******************************************************************************/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;

import javax.sip.address.URI;

public class RequestLine extends SIPObject implements SipRequestLine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.338 -0500", hash_original_field = "1D23EDFC276CA31BFE3F364D7A71C4E9", hash_generated_field = "ED5F8AB740667ACC3F117C961E7750C6")

    private static final long serialVersionUID = -3286426172326043129L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.341 -0500", hash_original_field = "301DE89A58C4FF637054844336681A92", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.344 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.347 -0500", hash_original_field = "CE1553CBFC9C6BF901CA3EFBFD71C841", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.350 -0500", hash_original_method = "E4B7F4B41910EC919E5F140217342F7C", hash_generated_method = "0C3AC04EB0C8B36380A7117E78C5276B")
    
public RequestLine() {
        sipVersion = "SIP/2.0";
    }

    /** Constructor given the request URI and the method.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.361 -0500", hash_original_method = "FF0843F55ACEC2A8E2B69A1885A4A70E", hash_generated_method = "021C6E46A9441F0E8B72A9E3A3F22E70")
    
public RequestLine(GenericURI requestURI, String method) {
        this.uri = requestURI;
        this.method = method;
        this.sipVersion = "SIP/2.0";
    }
   
    /** Encode the request line as a String.
    *
     * @return requestLine encoded as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.353 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.356 -0500", hash_original_method = "4F6DB28D47CD31A53DCF9FC226D5B630", hash_generated_method = "40AEC8575F20BE624923B0DF4AB0F2E8")
    
public StringBuffer encode(StringBuffer buffer) {
        if (method != null) {
            buffer.append(method);
            buffer.append(SP);
        }
        if (uri != null) {
            uri.encode(buffer);
            buffer.append(SP);
        }
        buffer.append(sipVersion);
        buffer.append(NEWLINE);
        return buffer;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getUri()
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.358 -0500", hash_original_method = "F87CE2D8FFE3E61DA8A4BD8B0BDA0697", hash_generated_method = "ED3D81A0DF2E489D77E3CFF96334234F")
    
public GenericURI getUri() {
        return uri;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getMethod()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.364 -0500", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "BC38B478E0AED2517A3460750CABA307")
    
public String getMethod() {
        return method;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getSipVersion()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.367 -0500", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "7635A3ADA2875913277DA776A6504B01")
    
public String getSipVersion() {
        return sipVersion;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#setUri(gov.nist.javax.sip.address.GenericURI)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.371 -0500", hash_original_method = "E1410A4CC0BAAD1440D0D1F349F6B893", hash_generated_method = "8035294072322FC4F6F0BD50AF522DD9")
    
public void setUri(URI uri) {
        this.uri = (GenericURI)uri;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#setMethod(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.374 -0500", hash_original_method = "190C52163DA3AE651D57D1F9409B666E", hash_generated_method = "E0D74BFAE23F23561EFCCA871D8C9B90")
    
public void setMethod(String method) {
        this.method = method;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#setSipVersion(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.377 -0500", hash_original_method = "1D61DBA7A6626C97B8FBAF50D3DDD562", hash_generated_method = "5CBB1B0455D6A559F03A690FE53AA3E3")
    
public void setSipVersion(String version) {
        this.sipVersion = version;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getVersionMajor()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.380 -0500", hash_original_method = "4D5FB483F06B9DEED18B900A5129C79B", hash_generated_method = "9BC8B56F13A145D6334560377EA214D5")
    
public String getVersionMajor() {
        if (sipVersion == null)
            return null;
        String major = null;
        boolean slash = false;
        for (int i = 0; i < sipVersion.length(); i++) {
            if (sipVersion.charAt(i) == '.')
                break;
            if (slash) {
                if (major == null)
                    major = "" + sipVersion.charAt(i);
                else
                    major += sipVersion.charAt(i);
            }
            if (sipVersion.charAt(i) == '/')
                slash = true;
        }
        return major;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getVersionMinor()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.383 -0500", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "6EA6974F2F8CEB1964A391173266EFF2")
    
public String getVersionMinor() {
        if (sipVersion == null)
            return null;
        String minor = null;
        boolean dot = false;
        for (int i = 0; i < sipVersion.length(); i++) {
            if (dot) {
                if (minor == null)
                    minor = "" + sipVersion.charAt(i);
                else
                    minor += sipVersion.charAt(i);
            }
            if (sipVersion.charAt(i) == '.')
                dot = true;
        }
        return minor;
    }

    /**
    * Compare for equality.
    *
    *@param other object to compare with. We assume that all fields
    * are set.
    */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.386 -0500", hash_original_method = "1239840CE17889EA14CF87055D293638", hash_generated_method = "B6ABF3CF04C7903483B84BB8675BEEB1")
    
public boolean equals(Object other) {
        boolean retval;
        if (!other.getClass().equals(this.getClass())) {
            return false;
        }
        RequestLine that = (RequestLine) other;
        try {
            retval =
                this.method.equals(that.method)
                    && this.uri.equals(that.uri)
                    && this.sipVersion.equals(that.sipVersion);
        } catch (NullPointerException ex) {
            retval = false;
        }
        return retval;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.389 -0500", hash_original_method = "6B13CE61BDAF8DDF9CB0869D09E1BD0F", hash_generated_method = "ED54138F64CE7B2D61E53C7BA7B4C189")
    
public Object clone() {
        RequestLine retval = (RequestLine) super.clone();
        if (this.uri != null)
            retval.uri = (GenericURI) this.uri.clone();
        return retval;
    }
}

