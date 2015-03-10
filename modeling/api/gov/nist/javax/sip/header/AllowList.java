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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.sip.header.AllowHeader;

public class AllowList extends SIPHeaderList<Allow> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.467 -0500", hash_original_field = "3126D085B18C0C241D668F6D8D8B569F", hash_generated_field = "8863FD75AF45B1DB104BC3DD11CC5A05")

    private static final long serialVersionUID = -4699795429662562358L;

    /** default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.473 -0500", hash_original_method = "F4CA7E921A2CAA269087CDE3B4673EDF", hash_generated_method = "72E03A22D2A84D8D19DD811CA6FF01E8")
    
public AllowList() {
        super(Allow.class, AllowHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.470 -0500", hash_original_method = "0478A1539FEF5A12FA1EE4755C128735", hash_generated_method = "DEDECA4600B8A2FB49B9D4A254B06A32")
    
public Object clone() {
        AllowList retval = new AllowList();
        retval.clonehlist(this.hlist);
        return retval;
    }

    /**
     * Gets an Iterator of all the methods of the AllowHeader. Returns an empty
     *
     * Iterator if no methods are defined in this Allow Header.
     *
     *
     *
     * @return Iterator of String objects each identifing the methods of
     *
     * AllowHeader.
     *
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.476 -0500", hash_original_method = "AEA3F358A5E0CA1930C1FE1C96E2D485", hash_generated_method = "EBD2DBE5931875805EE50D4F3F19DCE7")
    
public ListIterator<String> getMethods() {

        LinkedList<String> ll = new LinkedList<String> ();

        for ( Iterator<Allow> it = this.hlist.iterator(); it.hasNext();) {
            Allow a = (Allow)it.next();
            ll.add(a.getMethod());
        }

        return ll.listIterator();
    }

    /**
     * Sets the methods supported defined by this AllowHeader.
     *
     *
     *
     * @param methods - the Iterator of Strings defining the methods supported
     *
     * in this AllowHeader
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the Strings defining the methods supported.
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.479 -0500", hash_original_method = "6420AFA8DFEC18654E9A726650C49FF0", hash_generated_method = "D7E7781B5CBB37132AAC1EA1B8FF6648")
    
public void setMethods(List<String> methods) throws ParseException {
        ListIterator<String> it = methods.listIterator();
        while (it.hasNext()) {
            Allow allow = new Allow();
            allow.setMethod((String) it.next());
            this.add(allow);
        }
    }
}

