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
import javax.sip.address.URI;
import javax.sip.header.ProxyAuthenticateHeader;

public class ProxyAuthenticate extends AuthenticationHeader implements ProxyAuthenticateHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.165 -0500", hash_original_field = "E7F54878DCE0AAC522CC5C0A23B21F1D", hash_generated_field = "08ABAB95072FCF7B3E4A2200DCD67ACD")

    private static final long serialVersionUID = 3826145955463251116L;

    /**
     * Default Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.168 -0500", hash_original_method = "B80D256AA9E947492E2C0A1F4B8ED695", hash_generated_method = "D3A7B8A928A18C52D613156AA542DCD4")
    
public ProxyAuthenticate() {
        super(NAME);
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AuthenticationHeader#getURI()
     *
     * @since 1.2 this method is deprecated, uri is not a valid paramter for this header
     * Fail silently for backwards compatibility
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.171 -0500", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "9CD9E8CBB3E8DE9C3106F82ACE4168F0")
    
public URI getURI() {
        return null;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.AuthenticationHeader#setURI(javax.sip.address.URI)
     *
     * @since 1.2 this method is deprecated, uri is not a valid paramter for this header
     * Fail silently for backwards compatibility
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.174 -0500", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "A689FA9B74FE57B530103C2D77990F19")
    
public void setURI(URI uri) {
        // empty, fail silently
    }
}

