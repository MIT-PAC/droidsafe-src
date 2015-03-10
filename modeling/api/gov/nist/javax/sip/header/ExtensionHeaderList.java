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
import java.util.ListIterator;

public class ExtensionHeaderList extends SIPHeaderList<ExtensionHeaderImpl> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.521 -0500", hash_original_field = "58E3CCA7E2AAA3E0DC76C7C57052B201", hash_generated_field = "C901BD677804F800F6B013B6AE6500C8")

    private static final long serialVersionUID = 4681326807149890197L;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.527 -0500", hash_original_method = "9F1BA104827E0F2F29324BDDE3EB0EE9", hash_generated_method = "51B2C597779951FAD329383C2C836B25")
    
public ExtensionHeaderList(String hName) {
        super( ExtensionHeaderImpl.class, hName);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.530 -0500", hash_original_method = "52FAE424BADAAEF22385083D45DE9281", hash_generated_method = "AEBCEF2F63FAE8D2CF1FFDFEBA42309F")
    
public ExtensionHeaderList() {
        super(ExtensionHeaderImpl.class,null);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.523 -0500", hash_original_method = "C859D426E02BE595D55C2FAA9CB97225", hash_generated_method = "B7F895EB064386538442B0104026E859")
    
public Object clone() {
        ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        retval.clonehlist(this.hlist);
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.534 -0500", hash_original_method = "05F9E55197B7F8BF967FE19D758EB1FB", hash_generated_method = "9112A084FC8B867E36A85D3547A2F8E6")
    
public String encode() {
        StringBuffer retval = new StringBuffer();
        ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        while(it.hasNext()) {
           ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
           retval.append(eh.encode());
        }
        return retval.toString();
    }
}

