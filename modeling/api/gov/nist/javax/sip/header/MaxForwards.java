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
import javax.sip.InvalidArgumentException;
import javax.sip.header.MaxForwardsHeader;
import javax.sip.header.TooManyHopsException;

public class MaxForwards extends SIPHeader implements MaxForwardsHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.756 -0500", hash_original_field = "D9775AA801F210D5CECF25591E61CB22", hash_generated_field = "A999D5831FAE9A2CB5D83E10B325A89A")

    private static final long serialVersionUID = -3096874323347175943L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.762 -0500", hash_original_field = "9C0DC10D1BD6CA2C8B2EAD1A7C372272", hash_generated_field = "A7FC64164120C43082DBAEB73DE730FA")

    protected int maxForwards;

    /** Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.768 -0500", hash_original_method = "112FF42CCB27FA28BF813D0D5005682D", hash_generated_method = "B8A1AA2ED7A081F7B36310F2B22C2B73")
    
public MaxForwards() {
        super(NAME);
    }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.775 -0500", hash_original_method = "23B968D979F2A1F7830372508F81A601", hash_generated_method = "3C8F142BE284AC6E9363FCDF39770559")
    
public MaxForwards( int m ) throws InvalidArgumentException {
        super(NAME);
        this.setMaxForwards( m );
    }

    /** get the MaxForwards field.
     * @return the maxForwards member.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.781 -0500", hash_original_method = "938FE465D8E1495DA17B5EBE827AE012", hash_generated_method = "5D411B80736C63B0B65BC65395AF0617")
    
public int getMaxForwards() {
        return maxForwards;
    }

    /**
         * Set the maxForwards member
         * @param maxForwards maxForwards parameter to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.787 -0500", hash_original_method = "FA1042197B22377DF7A66B8C90EDB406", hash_generated_method = "C1078083B891E1DAFAABA4A9AF100632")
    
public void setMaxForwards(int maxForwards)
        throws InvalidArgumentException {
        if (maxForwards < 0 || maxForwards > 255)
            throw new InvalidArgumentException(
                "bad max forwards value " + maxForwards);
        this.maxForwards = maxForwards;
    }

    /**
         * Encode into a string.
         * @return encoded string.
         *
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.793 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.797 -0500", hash_original_method = "3054700CB5B8914F4AFAE52C6BC42EFB", hash_generated_method = "FF374059AE5FA7629E38477A2273692C")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        return buffer.append(maxForwards);
    }

    /** Boolean function
     * @return true if MaxForwards field reached zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.800 -0500", hash_original_method = "5954B7E2243EB0AA755A2C7023AF3E50", hash_generated_method = "E4EC00F798DD35579B3FA9A6C74222C7")
    
public boolean hasReachedZero() {
        return ((maxForwards) == 1); 
    }

    /** decrement MaxForwards field one by one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.804 -0500", hash_original_method = "AD70092C1832EBC094F0EF6B8F6DE4A8", hash_generated_method = "F11749F786740540B14A8CA16535621F")
    
public void decrementMaxForwards() throws TooManyHopsException {
        if (maxForwards > 0)
            maxForwards--;
        else throw new TooManyHopsException ("has already reached 0!");
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.808 -0500", hash_original_method = "272F5F4A3D96880D7AA6FF639321E7AD", hash_generated_method = "D24AA88A20F30BC54F9479F34F32F85A")
    
public boolean equals(Object other) {
        if (this==other) return true;
        if (other instanceof MaxForwardsHeader) {
            final MaxForwardsHeader o = (MaxForwardsHeader) other;
            return this.getMaxForwards() == o.getMaxForwards();
        }
        return false;
    }
}

