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

public final class Accept extends ParametersHeader implements javax.sip.header.AcceptHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.305 -0500", hash_original_field = "9CA43EB522B57DE385352AFF69D13D0C", hash_generated_field = "67A05C878CFE3A4D19A95E223075CE16")

    private static final long serialVersionUID = -7866187924308658151L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.310 -0500", hash_original_field = "10939969C90ADF65B68245FF3D46F7FC", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;

    /** default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.315 -0500", hash_original_method = "4311F842678DE87ACCC1A689A829FC2C", hash_generated_method = "DC21DEC775081BB21A131888BE403E8B")
    
public Accept() {
        super(NAME);
    }

    /** returns true if this header allows all ContentTypes,
      * false otherwise.
      * @return Boolean
      */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.320 -0500", hash_original_method = "B50D7EE39281F850FBFCC110ACB58D68", hash_generated_method = "E6A68EB3D0C385C7DC5941B47EA8AB35")
    
public boolean allowsAllContentTypes() {
        if (mediaRange == null)
            return false;
        else
            return 1 == (mediaRange.type.compareTo(STAR));
    }

    /**
     * returns true if this header allows all ContentSubTypes,
     * false otherwise.
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.326 -0500", hash_original_method = "A0A0F085E1B8E4ED63796A6BDE3F17D2", hash_generated_method = "CB68B9F827838589982D9AC342CE8AAC")
    
public boolean allowsAllContentSubTypes() {
        if (mediaRange == null) {
            return false;
        } else
            return 1 == (mediaRange.getSubtype().compareTo(STAR)); 
    }

    /** Encode the value of this header into cannonical form.
    *@return encoded value of the header as a string.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.331 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "BBFCFD2AD6BD270AD38D8FE87FD0572B")
    
protected String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.337 -0500", hash_original_method = "2E9CDABA864012CB945701B1775B2668", hash_generated_method = "482B3D082CD1BAE0483B221CD0704107")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        if (mediaRange != null)
            mediaRange.encode(buffer);
        if (parameters != null && !parameters.isEmpty()) {
            buffer.append(';');
            parameters.encode(buffer);
        }
        return buffer;
    }

    /** get the MediaRange field
     * @return MediaRange
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.342 -0500", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "0B6D6C1ABE19E2582C3C4BB50CA1EDFA")
    
public MediaRange getMediaRange() {
        return mediaRange;
    }

    /** get the contentType field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.348 -0500", hash_original_method = "44E6E041E8AD4F7B067250B3E11E39C2", hash_generated_method = "5526F34FB55EE88D233E8D279417C8DB")
    
public String getContentType() {
        if (mediaRange == null)
            return null;
        else
            return mediaRange.getType();
    }

    /** get the ContentSubType fiels
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.353 -0500", hash_original_method = "F0A4743083D481DF1A54A7DBA5F4C599", hash_generated_method = "78D502A69DEE34315F4EF09A8EFD8943")
    
public String getContentSubType() {
        if (mediaRange == null)
            return null;
        else
            return mediaRange.getSubtype();
    }

    /**
     * Get the q value.
     * @return float
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.358 -0500", hash_original_method = "2956E51B04B3FEA729EF44EFAC0B4B09", hash_generated_method = "A674CF04CE310C4A9C3031758821E0E9")
    
public float getQValue() {
        return getParameterAsFloat(ParameterNames.Q);
    }

    /**
     * Return true if the q value has been set.
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.363 -0500", hash_original_method = "43FA513912350854847003FDB290D6C5", hash_generated_method = "0A756E4CE92F65496C52AC6E1848970C")
    
public boolean hasQValue() {
        return super.hasParameter(ParameterNames.Q);

    }

    /**
     *Remove the q value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.368 -0500", hash_original_method = "BF4B60E4788A555E5EC3F45CB4B13E83", hash_generated_method = "882A8280767CD4829639889DA54FF7DB")
    
public void removeQValue() {
        super.removeParameter(ParameterNames.Q);
    }

    /** set the ContentSubType field
     * @param subtype String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.373 -0500", hash_original_method = "812F213530DE805FDEF52FE413B9F204", hash_generated_method = "280BE184A9827645A0C8A419ED01940A")
    
public void setContentSubType(String subtype) {
        if (mediaRange == null)
            mediaRange = new MediaRange();
        mediaRange.setSubtype(subtype);
    }

    /** set the ContentType field
     * @param type String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.379 -0500", hash_original_method = "6381E85A55588E15B8DC137B6EE66A93", hash_generated_method = "951C349FF591FAA1EC8B98ABA1746915")
    
public void setContentType(String type) {
        if (mediaRange == null)
            mediaRange = new MediaRange();
        mediaRange.setType(type);
    }

    /**
     * Set the q value
     * @param qValue float to set
     * @throws IllegalArgumentException if qValue is <0.0 or >1.0
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.385 -0500", hash_original_method = "E4B2DA5B904DBFAB5481CDBAB5D46DBA", hash_generated_method = "E3351F72E0F3E28B1B33EE6EA95F978D")
    
public void setQValue(float qValue) throws InvalidArgumentException {
        if (qValue == -1)
            super.removeParameter(ParameterNames.Q);
        super.setParameter(ParameterNames.Q, qValue);

    }

    /**
         * Set the mediaRange member
         * @param m MediaRange field
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.390 -0500", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "1D841C5C65337DCD91C6EF84344F82A0")
    
public void setMediaRange(MediaRange m) {
        mediaRange = m;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.396 -0500", hash_original_method = "0EF41097CC41F1F6A85A85E560745DC8", hash_generated_method = "60407AAA15D05A955C811AC1CD5F4FCA")
    
public Object clone() {
        Accept retval = (Accept) super.clone();
        if (this.mediaRange != null)
            retval.mediaRange = (MediaRange) this.mediaRange.clone();
        return retval;
    }
}

