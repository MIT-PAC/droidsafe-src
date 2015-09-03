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

public class Protocol extends SIPObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.849 -0500", hash_original_field = "0DE260D6A36CCF8999125C978C33AD00", hash_generated_field = "51FBF3C81D0285A3EC2B590DCDB910C8")

    private static final long serialVersionUID = 2216758055974073280L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.853 -0500", hash_original_field = "01561A498881F9CD9507DA7CA24D0E27", hash_generated_field = "C766D4C5CA44A223EF8697E2A0C74072")

    protected String protocolName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.856 -0500", hash_original_field = "ED81B55A70B55ECC7C15752BDF8485B2", hash_generated_field = "D5DF73E283251EA2D1226355FFEB1D1C")

    protected String protocolVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.859 -0500", hash_original_field = "852FD1938B4FCA59C0635E9D670A8D0B", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;

    /**
    * Default constructor.
    */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.898 -0500", hash_original_method = "B029C737A70A786967A2F293EBAB35D1", hash_generated_method = "C1460450827126E64BFBFB3B004B2B52")
    
public Protocol() {
        protocolName = "SIP";
        protocolVersion = "2.0";
        transport = "UDP";
    }

    /**
     * Return canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.863 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.867 -0500", hash_original_method = "5917804CC8541DAC2CA5A0DEC050E620", hash_generated_method = "D606F55ABA77BD4DE25ABED386D980B3")
    
public StringBuffer encode(StringBuffer buffer) {
        buffer.append(protocolName.toUpperCase())
                .append(SLASH)
                .append(protocolVersion)
                .append(SLASH)
                .append(transport.toUpperCase());

        return buffer;
    }

    /** get the protocol name
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.870 -0500", hash_original_method = "0EA6E7D3A9B59E59CEEBB8D3EE9D071C", hash_generated_method = "D7061D0695C2C4C3AAAA2E06D0E510DE")
    
public String getProtocolName() {
        return protocolName;
    }

    /** get the protocol version
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.873 -0500", hash_original_method = "B8FA221EC0DA8944EFD0CEB861346936", hash_generated_method = "E98C0BF6FE7BE1220E5389C92E3DD540")
    
public String getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * Get the protocol name + version
     * JvB: This is what is returned in the ViaHeader interface for 'getProtocol()'
     *
     * @return String : protocolname + '/' + version
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.877 -0500", hash_original_method = "3E5201C0CB5C46DC512CD40707A0CB06", hash_generated_method = "8C4ED23D1EEFD069E9D561B96D8FF7B9")
    
public String getProtocol() {
        return protocolName + '/' + protocolVersion;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.880 -0500", hash_original_method = "095B78DD27D74EBF49777967A681F20E", hash_generated_method = "294E38CF2D32567761D38FD960FE5B84")
    
public void setProtocol( String name_and_version ) throws ParseException {
        int slash = name_and_version.indexOf('/');
        if (slash>0) {
            this.protocolName = name_and_version.substring(0,slash);
            this.protocolVersion = name_and_version.substring( slash+1 );
        } else throw new ParseException( "Missing '/' in protocol", 0 );
    }

    /** get the transport
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.883 -0500", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "00BA105A025E226F3C987987A5F86CDE")
    
public String getTransport() {
        return transport;
    }

    /**
         * Set the protocolName member
         * @param p String to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.888 -0500", hash_original_method = "D424701D0BAFF5CEC55A80344E30BD30", hash_generated_method = "BBE7F66ECF3F3AC9510A67EA86B6AE23")
    
public void setProtocolName(String p) {
        protocolName = p;
    }

    /**
         * Set the protocolVersion member
         * @param p String to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.891 -0500", hash_original_method = "2A792840748FAB978DAA68C8F2495344", hash_generated_method = "916E03D44F4439080E5A39A909618948")
    
public void setProtocolVersion(String p) {
        protocolVersion = p;
    }

    /**
         * Set the transport member
         * @param t String to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.894 -0500", hash_original_method = "2F1F81EB1D8D9B12E2B4CE0AEE6CB155", hash_generated_method = "CB8045E2B406212721430A95B1B2ECDC")
    
public void setTransport(String t) {
        transport = t;
    }
}

