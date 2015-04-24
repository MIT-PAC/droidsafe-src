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
import gov.nist.javax.sip.address.AddressImpl;

public class RecordRoute extends AddressParametersHeader implements javax.sip.header.RecordRouteHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.745 -0500", hash_original_field = "0CC8C4545E3BD3FC39865092180091DE", hash_generated_field = "E1824FFE4050EC4E12856745910C83B9")

    private static final long serialVersionUID = 2388023364181727205L;

    /**
     * constructor
     * @param address address to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.748 -0500", hash_original_method = "1784D193E15A9C55742286FE08847141", hash_generated_method = "68762B3923E88A894D1DBB8B8DE01A1E")
    
public RecordRoute(AddressImpl address) {
        super(NAME);
        this.address = address;
    }

    /**
     * default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.751 -0500", hash_original_method = "F63822F670C4D20D985D1B2C470568FD", hash_generated_method = "17F61CC6B71508A7BB61DE330A2E0A08")
    
public RecordRoute() {
        super(RECORD_ROUTE);

    }

    /** Encode into canonical form.
     *@return String containing the canonicaly encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.753 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.757 -0500", hash_original_method = "1F2E3BF90793586E89EB2C500039787C", hash_generated_method = "D688FF255C0C6D223FE1C295ADDB811F")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            buffer.append(LESS_THAN);
        }
        address.encode(buffer);
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            buffer.append(GREATER_THAN);
        }

        if (!parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            this.parameters.encode(buffer);
        }
        return buffer;
    }
}

