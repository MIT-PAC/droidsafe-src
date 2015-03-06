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
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;

import javax.sip.header.ReplyToHeader;

public final class ReplyTo extends AddressParametersHeader implements ReplyToHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.378 -0500", hash_original_field = "3A5B4FE5B18CE7B5DAE5AAAFFDB6AD99", hash_generated_field = "236E3B2333C15B09CBC94B2F5B379AB6")

    private static final long serialVersionUID = -9103698729465531373L;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.381 -0500", hash_original_method = "39A6C3CE738448740A75D288CF2B6517", hash_generated_method = "215C0EB654E39530A8A56A4BBF05A692")
    
public ReplyTo() {
        super(NAME);
    }

    /** Default constructor given an address.
     *
     *@param address -- address of this header.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.384 -0500", hash_original_method = "FAB557ADCBC2DA51C11496316EFDCBFF", hash_generated_method = "F600F35BBABEE3B678FE2707B34999FC")
    
public ReplyTo(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * Encode the header into a String.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.387 -0500", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "EB7FE71751A7FA292A28A3D6E4687565")
    
public String encode() {
        return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    /**
     * Encode the header content into a String.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.390 -0500", hash_original_method = "248CC4EEE70871BA210925CAD15B2704", hash_generated_method = "2D09E4D3F3C30F555B778BB8390517E8")
    
public String encodeBody() {
        String retval = "";
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval += LESS_THAN;
        }
        retval += address.encode();
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval += GREATER_THAN;
        }
        if (!parameters.isEmpty()) {
            retval += SEMICOLON + parameters.encode();
        }
        return retval;
    }

    /**
     * Conveniance accessor function to get the hostPort field from the address
     * @return HostPort
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.393 -0500", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "F596BC5BA68B5CC2EC3CBFF9B1755A33")
    
public HostPort getHostPort() {
        return address.getHostPort();
    }

    /**
     * Get the display name from the address.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.396 -0500", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "00EBF039D8E78F649651183BA6D3C490")
    
public String getDisplayName() {
        return address.getDisplayName();
    }
}

