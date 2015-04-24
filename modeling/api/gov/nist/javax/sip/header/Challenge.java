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
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;

public class Challenge extends SIPObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.086 -0500", hash_original_field = "8C93F8B08E4F462465A8F640E0762DB0", hash_generated_field = "11864689FB5A61F36957C7AFB5C2B569")

    private static final long serialVersionUID = 5944455875924336L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.089 -0500", hash_original_field = "0C44A58709479306B86B0611FCABFC25", hash_generated_field = "78E11EC5EB66AE64A2B95E2463577A76")

    private static String DOMAIN = ParameterNames.DOMAIN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.092 -0500", hash_original_field = "1275ADD4899A05374E4917DEB3E85A56", hash_generated_field = "E9916446BFADB0600378FB202B20EF35")

    private static String REALM = ParameterNames.REALM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.096 -0500", hash_original_field = "81FBABA1EA606A8FA62DB9607A4FE8BA", hash_generated_field = "3C70F1532BAEF7757CB87A3B1702DE00")

    private static String OPAQUE = ParameterNames.OPAQUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.099 -0500", hash_original_field = "0BDB2E931C77EE01757E7E39F51323F7", hash_generated_field = "0874C153365E26C97F39F1556B070049")

    private static String ALGORITHM = ParameterNames.ALGORITHM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.102 -0500", hash_original_field = "467F6A3015D0A09F1AD10451955B0FA4", hash_generated_field = "CF00A7D2B9ED61B4C939D708439BEAEB")

    private static String QOP = ParameterNames.QOP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.105 -0500", hash_original_field = "A3C5D0834CA28C61E526EFE1B82B6B04", hash_generated_field = "A3405C57F3C22C48D01F5F052E44B2FF")

    private static String STALE = ParameterNames.STALE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.107 -0500", hash_original_field = "C3F46FDD688E9B421594AAA8A6AC9EC3", hash_generated_field = "BBFD446F7266827713456A338EE7CC61")

    private static String SIGNATURE = ParameterNames.SIGNATURE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.110 -0500", hash_original_field = "4589237E4C15BE9E58625B89E2F768D7", hash_generated_field = "42D65330C8C16A68BB4020BE7AB00365")

    private static String RESPONSE = ParameterNames.RESPONSE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.113 -0500", hash_original_field = "E29A15EF258616A7A5914BE34AD5CFD4", hash_generated_field = "C526A53CD7792EE76E85F7166E823C42")

    private static String SIGNED_BY = ParameterNames.SIGNED_BY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.117 -0500", hash_original_field = "0E8BEAC5A0A9AAAE1E1CD6CDD2FE317F", hash_generated_field = "C4DF7E8DFBBC37CD137736E52F4CB325")

    private static String URI = ParameterNames.URI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.119 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.122 -0500", hash_original_field = "33FE6931AE28AF60FF53E33B80B976B6", hash_generated_field = "3C192C96CF447535D68E25BB7C5623D6")

    protected NameValueList authParams;

    /**
     * Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.125 -0500", hash_original_method = "8BBE6E62DECF2D10899FEF6115E55B0A", hash_generated_method = "DE7C269A3CBD9505E5C2DB474FE0DBD0")
    
public Challenge() {
        authParams = new NameValueList();
        authParams.setSeparator(COMMA);
    }

    /**
     * Encode the challenge in canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.128 -0500", hash_original_method = "31A296A1CA9C2500AE4E208A72C83C52", hash_generated_method = "123A116FE416943FBFC086F875EB5A60")
    
public String encode() {
        return new StringBuffer(scheme)
            .append(SP)
            .append(authParams.encode())
            .toString();
    }

    /**
     * get the scheme field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.130 -0500", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "9D11AD0B611F352DC84C8E1A6B825617")
    
public String getScheme() {
        return scheme;
    }

    /**
     * get AuthParms list.
     * @return NameValueList
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.133 -0500", hash_original_method = "7AB044197F27131A6F832759E545093F", hash_generated_method = "C1FD56E0D2E1B81682E96E6A4B8CD473")
    
public NameValueList getAuthParams() {
        return authParams;
    }

    /**
     * get the domain
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.136 -0500", hash_original_method = "524CBE86F5CB0851551BD8D9CE41050E", hash_generated_method = "1EA3C88A55E5A077598E312EA3C50BB7")
    
public String getDomain() {
        return (String) authParams.getValue(DOMAIN);
    }

    /**
     * get the URI field
     * @return String
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.139 -0500", hash_original_method = "BE9B31EF9F34CC2717C92C00E671086A", hash_generated_method = "67A6F388027FD3637B2CA6F56A11C34D")
    
public String getURI() {
        return (String) authParams.getValue(URI);
    }

    /**
     * get the Opaque field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.142 -0500", hash_original_method = "E73B00719536CCDE494138AC7E39B883", hash_generated_method = "42D5851CE9BF45ADAB4C6BB93F2711B5")
    
public String getOpaque() {
        return (String) authParams.getValue(OPAQUE);
    }

    /**
     * get QOP value
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.145 -0500", hash_original_method = "F3682063DCD7F1CD4155E38D853E5DBB", hash_generated_method = "2931F62047E1A25EB18E006BB685D5C1")
    
public String getQOP() {
        return (String) authParams.getValue(QOP);
    }

    /**
     * get the Algorithm value.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.148 -0500", hash_original_method = "CCB0E42EBD2B55CEF1C50D8E85A69BA0", hash_generated_method = "C6744E9AEEB88A43E76EE18CFDD5C2E1")
    
public String getAlgorithm() {
        return (String) authParams.getValue(ALGORITHM);
    }

    /**
     * get the State value.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.150 -0500", hash_original_method = "1B871D910B9E0136E877D688BCC83CE6", hash_generated_method = "BED9D185F87CBB2FDCE3CBC784D0EE56")
    
public String getStale() {
        return (String) authParams.getValue(STALE);
    }

    /**
     * get the Signature value.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.153 -0500", hash_original_method = "255DD7DBA22AF99FB411A52085D76836", hash_generated_method = "213D92964A459E6DCBA57ADFDCB1F16D")
    
public String getSignature() {
        return (String) authParams.getValue(SIGNATURE);
    }

    /**
     * get the signedBy value.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.155 -0500", hash_original_method = "FB9E11AAE433D181FA345FD8C6B7C434", hash_generated_method = "DE233CF3F39CE2F89F6714AF5F78D86F")
    
public String getSignedBy() {
        return (String) authParams.getValue(SIGNED_BY);
    }

    /**
     * get the Response value.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.158 -0500", hash_original_method = "630101C0FEA93ACE37620C1431253BDE", hash_generated_method = "43292E585E78232846D6C52E5F03E8A8")
    
public String getResponse() {
        return (String) authParams.getValue(RESPONSE);
    }

    /**
     * get the realm value.
     * @return String.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.161 -0500", hash_original_method = "2BDBFC5CD9055A8A53440AACCEEECF63", hash_generated_method = "900D6497C19BC8F3CBA57E50AF7EDE57")
    
public String getRealm() {
        return (String) authParams.getValue(REALM);
    }

    /**
     * get the specified parameter
     * @param name String to set
     * @return String to set
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.164 -0500", hash_original_method = "99F64D67B14B37266543A349C4B21B53", hash_generated_method = "C83A48FB8B528372A04C52C4DDDAB2DB")
    
public String getParameter(String name) {
        return (String) authParams.getValue(name);
    }

    /**
     * boolean function
     * @param name String to set
     * @return true if this header has the specified parameter, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.166 -0500", hash_original_method = "2E34AAE119CD850D1B253E2693552FEB", hash_generated_method = "CE8828523E7A9B60A987131B4DE4D317")
    
public boolean hasParameter(String name) {
        return authParams.getNameValue(name) != null;
    }

    /**
     * Boolean function
     * @return true if this header has some parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.169 -0500", hash_original_method = "B5F8473E1F8564D0A56C45C190B84DBB", hash_generated_method = "CEDF34F1D1CB3150308435DAEA067A4F")
    
public boolean hasParameters() {
        return authParams.size() != 0;
    }

    /**
     * delete the specified parameter
     * @param name String
     * @return true if the specified parameter has been removed, false
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.172 -0500", hash_original_method = "18ADB44A3B024567153A6DCCF4159539", hash_generated_method = "268F8132701501F6493A11900AC7946D")
    
public boolean removeParameter(String name) {
        return authParams.delete(name);
    }

    /**
     * remove all parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.175 -0500", hash_original_method = "75751EE68232240DE115414D89F9922B", hash_generated_method = "C96862B1345CDBC2343D5949F5562413")
    
public void removeParameters() {
        authParams = new NameValueList();
    }

    /**
     * set the specified parameter
     * @param nv NameValue to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.178 -0500", hash_original_method = "6C2AF9C154AE46C371A5DD84DFA39C4F", hash_generated_method = "473250599EF6A4799E91A6251FF744AE")
    
public void setParameter(NameValue nv) {
        authParams.set(nv);
    }

    /**
     * Set the scheme member
     * @param s String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.180 -0500", hash_original_method = "E1049E827E0E0A74C671FFCF89FB5B30", hash_generated_method = "6A4DBE921DE8ECF0764F8A11E737265C")
    
public void setScheme(String s) {
        scheme = s;
    }

    /**
     * Set the authParams member
     * @param a NameValueList to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.183 -0500", hash_original_method = "82B720F7CD11140D4D4B228FFF7C7395", hash_generated_method = "F8AC13E4F549F7200BD0E64294369988")
    
public void setAuthParams(NameValueList a) {
        authParams = a;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.186 -0500", hash_original_method = "BDAE145DB99173579ABC594BFE585895", hash_generated_method = "2A754E22B34BF385F00A958B8C14DB72")
    
public Object clone() {
        Challenge retval = (Challenge) super.clone();
        if (this.authParams != null)
            retval.authParams = (NameValueList) this.authParams.clone();
        return retval;
    }
}

