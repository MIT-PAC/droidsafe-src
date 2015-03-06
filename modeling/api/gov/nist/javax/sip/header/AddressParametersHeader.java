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
* of the terms of this agreement.
*
*/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;

import javax.sip.address.Address;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;

public abstract class AddressParametersHeader extends ParametersHeader implements Parameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.430 -0500", hash_original_field = "FA8896132AE8FEC3BA371981DFF10BB4", hash_generated_field = "50232C7D5628BA6D2DA2D4A79905A12A")

    protected AddressImpl address;

    /**
     * Constructor given the name of the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.439 -0500", hash_original_method = "86C06714D64ED7D78AC32A4EA648ACC6", hash_generated_method = "E547070368655B86250D6BA76558B4C2")
    
protected AddressParametersHeader(String name) {
        super(name);
    }

    /**
     * Constructor given a synch flag.
     *
     * @param name
     * @param sync
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.442 -0500", hash_original_method = "18F0A32F1016A1077EE2441198C172CD", hash_generated_method = "5B20A643B2E6E2A2EE16BEF7786F6499")
    
protected AddressParametersHeader(String name, boolean sync) {
        super(name,sync);
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AddressParameters#getAddress()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.433 -0500", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "C447D8F3D28FA4B357817DCC39DEFF36")
    
public Address getAddress() {
        return address;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AddressParameters#setAddress(javax.sip.address.Address)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.436 -0500", hash_original_method = "AAE5DCDD86A2817DB3BE7BA0761992E2", hash_generated_method = "DE3FC5718DD3280DE802498DE52CEF36")
    
public void setAddress(Address address) {
        this.address = (AddressImpl) address;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AddressParameters#clone()
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.445 -0500", hash_original_method = "0CBC2CD54CDD43105BA83DF4459B73A7", hash_generated_method = "FB5CBBFE24B024CC25590AC7DAF685F2")
    
public Object clone() {
        AddressParametersHeader retval = (AddressParametersHeader) super.clone();
        if (this.address != null)
            retval.address = (AddressImpl) this.address.clone();
        return retval;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AddressParameters#equals(java.lang.Object)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.448 -0500", hash_original_method = "432CD1C0278E1FF82C91D27AB1E82A92", hash_generated_method = "D7E1B377E091CB2ECC8B05466F8B75DB")
    
public boolean equals(Object other) {
        if (this==other) return true;

        if (other instanceof HeaderAddress && other instanceof Parameters) {
            final HeaderAddress o = (HeaderAddress) other;
            return this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o );
        }
        return false;
    }
    
}

