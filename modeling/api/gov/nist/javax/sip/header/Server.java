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
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.sip.header.ServerHeader;

public class Server extends SIPHeader implements ServerHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.352 -0500", hash_original_field = "913204900B2AA8283490DB716F4EAB0C", hash_generated_field = "C0E073D0311495EC10E3519402318717")

    private static final long serialVersionUID = -3587764149383342973L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.356 -0500", hash_original_field = "653407BF74D72644FCAA011418913E1D", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;

    /**
     * Constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.367 -0500", hash_original_method = "28A485C01704A957BCAF31556583EFBE", hash_generated_method = "E049C03A454C678F415C7FC04628FD9F")
    
public Server() {
        super(NAME);
        productTokens = new LinkedList();
    }

    /**
     * Return canonical form.
     * @return String
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.360 -0500", hash_original_method = "3BD03A3FDC86F025553E39D4B6A63060", hash_generated_method = "1CB22F75567C416919AFB0E86A4E8F65")
    
private String encodeProduct() {
        StringBuffer tokens = new StringBuffer();
        ListIterator it = productTokens.listIterator();

        while (it.hasNext()) {
            tokens.append((String) it.next());
            if (it.hasNext())
                tokens.append('/');
            else
                break;
        }
        return tokens.toString();
    }

    /** set the productToken field
     * @param pt String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.363 -0500", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "783A8969227B068302CF8EEB89CF506B")
    
public void addProductToken(String pt) {
        productTokens.add(pt);
    }

    /** Encode only the body of this header.
    *@return encoded value of the header.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.371 -0500", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "21389218728DC2B181D1950BEC50F95B")
    
public String encodeBody() {
        return encodeProduct();
    }

    /**
    * Returns the list value of the product parameter.
    *
    * @return the software of this UserAgentHeader
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.374 -0500", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "C9C3D2F5F5748D4E71625F3B55C13941")
    
public ListIterator getProduct() {
        if (productTokens == null || productTokens.isEmpty())
            return null;
        else
            return productTokens.listIterator();
    }

    /**
     * Sets the product value of the UserAgentHeader.
     *
     * @param product - a List specifying the product value
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the product value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.378 -0500", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "A1C0FB2108C269FB3ADADC9F9320B0E3")
    
public void setProduct(List product) throws ParseException {
        if (product == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        productTokens = product;
    }
}

