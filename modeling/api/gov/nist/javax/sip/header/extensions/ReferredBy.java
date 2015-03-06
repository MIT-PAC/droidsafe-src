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


package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public final class ReferredBy extends AddressParametersHeader implements ExtensionHeader, ReferredByHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.228 -0500", hash_original_field = "7AEDC9BC4CFFED95927680DB7DC3DADB", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.232 -0500", hash_original_field = "F8A953A58E2CF0B7BECF90BD57C899A1", hash_generated_field = "BAA3173ECCDDFD8B4EF4E90187540A3C")

    public static final String NAME = "Referred-By";

    /** default Constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.235 -0500", hash_original_method = "C3DEC8F418CE8BBD8D4ED1D7A2F51A12", hash_generated_method = "30E71F39A1AD50D68074E783C22D51B4")
    
public ReferredBy() {
        super(NAME);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.238 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "01B37E653FE76FEB916567082AAEE1D8")
    
public void setValue(String value) throws ParseException {
        // not implemented.
        throw new ParseException(value,0);

    }

    /**
     * Encode the header content into a String.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.241 -0500", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "293E3E92EE6F12C01ED80607A408DDB1")
    
protected String encodeBody() {
        if (address == null)
            return null;
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
}

