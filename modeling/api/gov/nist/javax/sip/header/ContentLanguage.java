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
import java.util.Locale;

public class ContentLanguage extends SIPHeader implements javax.sip.header.ContentLanguageHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.720 -0500", hash_original_field = "54EA45B077AD6285DC89BC0113FB6B5B", hash_generated_field = "51CDCD95970F98C01DA5ED4493E40EC1")

    private static final long serialVersionUID = -5195728427134181070L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.723 -0500", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "90B62845FED5E7253FA0E87D66166425")

    protected Locale locale;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.727 -0500", hash_original_method = "04F34AE7A99F7FC60EC2CE238423FC91", hash_generated_method = "C1C43149E28DA7A6DC93F17973FCBD19")
    
public ContentLanguage() {
        super(CONTENT_LANGUAGE);
    }

    /**
     * Default constructor.
     * @param languageTag String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.732 -0500", hash_original_method = "AA9A79158F9BAA0E6C86C7EA6B5AA5A0", hash_generated_method = "B362780FA17238F9F559B3BCF91461E3")
    
public ContentLanguage(String languageTag) {
        super(CONTENT_LANGUAGE);
        this.setLanguageTag( languageTag );
    }

    /**
     * Canonical encoding of the  value of the header.
     * @return encoded body of header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.735 -0500", hash_original_method = "969C0CF9A75C29D747322906DB447799", hash_generated_method = "C13FD116C755D51CFFF3A380AAAFC6FE")
    
public String encodeBody() {
        return this.getLanguageTag();
    }

    /** get the languageTag field.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.739 -0500", hash_original_method = "97684B013EF42C114E2563BE4754CC3B", hash_generated_method = "FE64D074FF4C5334640BF606935ED70C")
    
public String getLanguageTag() {
        // JvB: Need to take sub-tags into account
        if ( "".equals(locale.getCountry())) {
            return locale.getLanguage();
        } else {
            return locale.getLanguage() + '-' + locale.getCountry();
        }
    }

    /** set the languageTag field
     * @param languageTag -- language tag to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.742 -0500", hash_original_method = "0029980C0556452F57A726D089728FB9", hash_generated_method = "FC3B28B9C6A9A9F36B41B9B87D38F212")
    
public void setLanguageTag(String languageTag) {

        final int slash = languageTag.indexOf('-');
        if (slash>=0) {
            this.locale = new Locale(languageTag.substring(0,slash), languageTag.substring(slash+1) );
        } else {
            this.locale = new Locale(languageTag);
        }
    }

    /**
     * Gets the language value of the ContentLanguageHeader.
     *
     *
     *
     * @return the Locale value of this ContentLanguageHeader
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.745 -0500", hash_original_method = "BB5B9CEBF2423E9AF1F4569292591142", hash_generated_method = "F2D9ECC6A5EC51558C55D8E3FD4EA8D7")
    
public Locale getContentLanguage() {
        return locale;
    }

    /**
     * Sets the language parameter of this ContentLanguageHeader.
     *
     * @param language - the new Locale value of the language of
     *
     * ContentLanguageHeader
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.749 -0500", hash_original_method = "7E2DC8255947AB5497CF8DB62C4D31B5", hash_generated_method = "64605A7420D59354713CC4AEC84C0208")
    
public void setContentLanguage(Locale language) {
        this.locale = language;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.753 -0500", hash_original_method = "CEAD9E53DA5FB3A31278ED5B9373A85D", hash_generated_method = "A3DE4E843567838B73CDB1AB764A0142")
    
public Object clone() {
        ContentLanguage retval = (ContentLanguage) super.clone();
        if (this.locale != null)
            retval.locale = (Locale) this.locale.clone();
        return retval;
    }
}

