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


package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ASN1ParsingException extends IllegalStateException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.969 -0500", hash_original_field = "E65D4B046C7E75D4305AF1275FC1F72B", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.972 -0500", hash_original_method = "A04BEE8A9A73EAD532708A0AE36FAA5C", hash_generated_method = "A04BEE8A9A73EAD532708A0AE36FAA5C")
    
ASN1ParsingException(String message)
    {
        super(message);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.975 -0500", hash_original_method = "9ABB1845457B0FD65DC264E5CAAB1469", hash_generated_method = "9ABB1845457B0FD65DC264E5CAAB1469")
    
ASN1ParsingException(String message, Throwable cause)
    {
        super(message);
        this.cause = cause;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.978 -0500", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "7216169927F14A6BA3457BBD72FD53B3")
    
public Throwable getCause()
    {
        return cause;
    }
    
}

