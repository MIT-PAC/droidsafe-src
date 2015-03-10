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
import javax.sip.header.AcceptLanguageHeader;

public class AcceptLanguageList extends SIPHeaderList<AcceptLanguage> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.384 -0500", hash_original_field = "3B88016CC39BABB27158BD84AEED3A23", hash_generated_field = "7EA90335ABAD53EEB534CFBDFF1F0433")

    private static final long serialVersionUID = -3289606805203488840L;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.391 -0500", hash_original_method = "240BB3B9B24C078BD16B4E527289E882", hash_generated_method = "3E83EBD18B1DE187BD967F92DA52EE4B")
    
public AcceptLanguageList() {
        super(AcceptLanguage.class, AcceptLanguageHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.388 -0500", hash_original_method = "D59E3796661CC485086FCE096143E912", hash_generated_method = "03A83275E60D6404210400900BC142E2")
    
@Override
    public Object clone() {
        AcceptLanguageList retval = new AcceptLanguageList();
        retval.clonehlist(this.hlist);
        return retval;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.394 -0500", hash_original_method = "4EAA649C6A43B8603903A57164247286", hash_generated_method = "1F7DE68755099C27F78E58477863060F")
    
public AcceptLanguage getFirst() {
        AcceptLanguage retval = (AcceptLanguage) super.getFirst();
        if (retval != null)
            return retval;
        else
            return new AcceptLanguage();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.397 -0500", hash_original_method = "D3074C13DEFE0D00E21551F82106E50D", hash_generated_method = "2658A3B001939B556FD5F0B5A223EB5E")
    
public AcceptLanguage getLast() {
        AcceptLanguage retval = (AcceptLanguage) super.getLast();
        if (retval != null)
            return retval;
        else
            return new AcceptLanguage();
    }
}

