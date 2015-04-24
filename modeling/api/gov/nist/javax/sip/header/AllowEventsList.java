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

import javax.sip.header.AllowEventsHeader;

public class AllowEventsList extends SIPHeaderList<AllowEvents> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.816 -0500", hash_original_field = "F850C344EE0C5124FED83C597CBFB673", hash_generated_field = "86B6C308D3FCCC18BA910315347C5416")

    private static final long serialVersionUID = -684763195336212992L;

    /** default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.822 -0500", hash_original_method = "BE25141B87EEBB7CC79E715B98DBCC1B", hash_generated_method = "1830E60686F9030EC32D01D2CE2303E3")
    
public AllowEventsList() {
        super(AllowEvents.class, AllowEventsHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.819 -0500", hash_original_method = "73FBB2E32770F78B7C4AE500CDD51F25", hash_generated_method = "A0EA21C71E3199A31B7950BE526D14E0")
    
public Object clone() {
        AllowEventsList retval = new AllowEventsList();
        retval.clonehlist(this.hlist);
        return retval;
    }

    /**
     * Gets an Iterator of all the methods of the AllowEventsHeader. Returns an empty
     *
     * Iterator if no methods are defined in this AllowEvents Header.
     *
     *
     *
     * @return Iterator of String objects each identifing the methods of
     *
     * AllowEventsHeader.
     *
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.825 -0500", hash_original_method = "8BAEE8E3A5391DDA801BF0B845B6BCD7", hash_generated_method = "FDEA2FDB650D04EE5EB88AA720957BD1")
    
public ListIterator<String> getMethods() {
        ListIterator<AllowEvents> li = super.hlist.listIterator();
        LinkedList<String>  ll = new LinkedList<String> ();
        while (li.hasNext()) {
            AllowEvents allowEvents = (AllowEvents) li.next();
            ll.add(allowEvents.getEventType());
        }
        return ll.listIterator();
    }

    /**
     * Sets the methods supported defined by this AllowEventsHeader.
     *
     *
     *
     * @param methods - the Iterator of Strings defining the methods supported
     *
     * in this AllowEventsHeader
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the Strings defining the methods supported.
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.828 -0500", hash_original_method = "222F0135AD0C9432632E9A9F7AD003FD", hash_generated_method = "72C063C4DB2B9B1CD412E92B49A10884")
    
public void setMethods(List<String> methods) throws ParseException {
        ListIterator<String> it = methods.listIterator();
        while (it.hasNext()) {
            AllowEvents allowEvents = new AllowEvents();
            allowEvents.setEventType((String) it.next());
            this.add(allowEvents);
        }
    }
}

