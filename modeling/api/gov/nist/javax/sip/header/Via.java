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
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.stack.HopImpl;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.address.Hop;
import javax.sip.header.ViaHeader;

public class Via extends ParametersHeader implements javax.sip.header.ViaHeader, ViaHeaderExt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.031 -0500", hash_original_field = "677EAF6CDCAE295B23459F626BCF0C3F", hash_generated_field = "44E58998010CA4EBABA566C0FB985DB3")

    private static final long serialVersionUID = 5281728373401351378L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.034 -0500", hash_original_field = "1973AC16448B079042B7B0461DD2437E", hash_generated_field = "22327A98EDD3D141225105CEAD3ABB13")

    public static final String BRANCH = ParameterNames.BRANCH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.038 -0500", hash_original_field = "6C068330D64C312F8A54CB52624C50C5", hash_generated_field = "4D8C5F2DB4C0964744FED89BE27D1A75")

    public static final String RECEIVED = ParameterNames.RECEIVED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.041 -0500", hash_original_field = "9AD56A0DA974A4CC0B255A28D584B762", hash_generated_field = "4AA8F81F93B467DE58E70654B3136851")

    public static final String MADDR = ParameterNames.MADDR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.045 -0500", hash_original_field = "292A9A085259A8A30E6CFF414A138BC5", hash_generated_field = "EAB3FB3A2E323EFD5528878B03366C28")

    public static final String TTL = ParameterNames.TTL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.049 -0500", hash_original_field = "7FC8BC0E49FF893140497EF8D2B9C6AC", hash_generated_field = "180F648B89D676D4D5F0240DFDFE1D7D")

    public static final String RPORT = ParameterNames.RPORT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.052 -0500", hash_original_field = "13161F95E23706340DC2167873BBF563", hash_generated_field = "5B51F01BA670CB6A7B4E1A02DEB8A619")

    protected Protocol sentProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.055 -0500", hash_original_field = "B831EA091B905EC502B89CC3BC49A84A", hash_generated_field = "0B1CBB926459AD49C5AAB0F0CD26CCCF")

    protected HostPort sentBy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.058 -0500", hash_original_field = "6C9FE4127C88B2FD28EFE861CA65A713", hash_generated_field = "F67D9B9E386FB326EF97E9813CA35FC6")

    protected String comment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.061 -0500", hash_original_field = "A8DC08CD30DA636AE03D9B76ABCE0FC4", hash_generated_field = "2352712DCFC5BA30D0234B4D1AC22071")

    private boolean rPortFlag = false;

    /** Default constructor
    */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.065 -0500", hash_original_method = "7D07E05C0BEE96603D98F8B1E7A2E317", hash_generated_method = "CF253407FBFFE348FD46E59E622DDD53")
    
public Via() {
        super(NAME);
        sentProtocol = new Protocol();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.076 -0500", hash_original_method = "6B6D36FD3A79EE403682FF6F25A822A5", hash_generated_method = "D50701C5313B523D2AFCDD2A382184CA")
    
public boolean equals(Object other) {

        if (other==this) return true;

        if (other instanceof ViaHeader) {
            final ViaHeader o = (ViaHeader) other;
            return getProtocol().equalsIgnoreCase( o.getProtocol() )
                && getTransport().equalsIgnoreCase( o.getTransport() )
                && getHost().equalsIgnoreCase( o.getHost() )
                && getPort() == o.getPort()
                && equalParameters( o );
        }
        return false;
    }

    /** get the Protocol Version
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.079 -0500", hash_original_method = "F03A2761E3B9AF6DF371EC359829DB1F", hash_generated_method = "32895BC1C079DC20DE78B350609DB20B")
    
public String getProtocolVersion() {
        if (sentProtocol == null)
            return null;
        else
            return sentProtocol.getProtocolVersion();
    }

    /**
     * Accessor for the sentProtocol field.
     * @return Protocol field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.082 -0500", hash_original_method = "07C91BB13E357235D0646F9B1302A813", hash_generated_method = "3A0F2EC46C83142EFE37885BF3789ABB")
    
public Protocol getSentProtocol() {

        return sentProtocol;
    }

    /**
     * Accessor for the sentBy field
     *@return SentBy field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.085 -0500", hash_original_method = "834E4BBD7298D05AE3719FD543779099", hash_generated_method = "7E9F36EDB6B8F7DEC4550BD2B30D1B4B")
    
public HostPort getSentBy() {
        return sentBy;
    }

    /**
     * Get the host, port and transport as a Hop. This is
     * useful for the stack to avoid duplication of code.
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.088 -0500", hash_original_method = "D671032CD8E13BB36667C287933AFA1D", hash_generated_method = "63F29EFA98759442F1A8B24A62C4F969")
    
public Hop getHop() {
        HopImpl hop = new HopImpl(sentBy.getHost().getHostname(),
                sentBy.getPort(),sentProtocol.getTransport());
        return hop;
    }

    /**
     * Accessor for the parameters field
     * @return parameters field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.091 -0500", hash_original_method = "50080B5B5AC1614DCB7B006B51F53E3F", hash_generated_method = "DFE8C46845B2BF694E1F9DF7A36DD65A")
    
public NameValueList getViaParms() {
        return parameters;
    }

    /**
     * Accessor for the comment field.
     * @return comment field.
     * @deprecated RFC 2543 support feature.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.094 -0500", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "E40F10878D62F1009133973700BC0B5C")
    
public String getComment() {
        return comment;
    }

    /** port of the Via Header.
     * @return true if Port exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.098 -0500", hash_original_method = "60E8CE9FCECD3622E03D9910A9625801", hash_generated_method = "C77D2550DD3D2C9672729BA276F9DDD6")
    
public boolean hasPort() {
        return (getSentBy()).hasPort();
    }

    /** comment of the Via Header.
     *
     * @return false if comment does not exist and true otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.101 -0500", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "4AECA1BA2AB25600F1AD63164D2ACAC2")
    
public boolean hasComment() {
        return comment != null;
    }

    /** remove the port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.104 -0500", hash_original_method = "944AB7146038DECB09A155E81BB22663", hash_generated_method = "126306B8785401B8C74EB7916AA2C2C9")
    
public void removePort() {
        sentBy.removePort();
    }

    /** remove the comment field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.107 -0500", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "4C5598F3753C2A0079DD4D0DD691D05A")
    
public void removeComment() {
        comment = null;
    }

    /** set the Protocol Version
     * @param protocolVersion String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.110 -0500", hash_original_method = "EAF98E914AE1C4A3745B20F70C227AC7", hash_generated_method = "FAC026355BED919F9D525B451C4230F5")
    
public void setProtocolVersion(String protocolVersion) {
        if (sentProtocol == null)
            sentProtocol = new Protocol();
        sentProtocol.setProtocolVersion(protocolVersion);
    }

    /** set the Host of the Via Header
         * @param host String to set
         */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.113 -0500", hash_original_method = "DC556AA065BEAF9D4C2B976D57E39DA8", hash_generated_method = "6C40B83EF6C0E6452AD2399FE668FCB3")
    
public void setHost(Host host) {
        if (sentBy == null) {
            sentBy = new HostPort();
        }
        sentBy.setHost(host);
    }

    /**
     * Set the sentProtocol member
     * @param s Protocol to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.116 -0500", hash_original_method = "F4FB101A445D5E49EE8B10DCE47E32FC", hash_generated_method = "A60980380F089206E40A3F100A70EF48")
    
public void setSentProtocol(Protocol s) {
        sentProtocol = s;
    }

    /**
     * Set the sentBy member
     * @param s HostPort to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.119 -0500", hash_original_method = "543B4EA18E4F8858630BB59B262697DA", hash_generated_method = "F9C60CEE52C59A696D28208B7034EF56")
    
public void setSentBy(HostPort s) {
        sentBy = s;
    }

    /**
     * Set the comment member
     * @param c String to set.
     * @deprecated This is an RFC 2543 feature.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.122 -0500", hash_original_method = "DE8908B9CA5447E854A0D06D0B1B9195", hash_generated_method = "0B9E5F7573C266EFFB88E1DE14EE2B1E")
    
public void setComment(String c) {
        comment = c;
    }

    /** Encode the body of this header (the stuff that follows headerName).
     * A.K.A headerValue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.125 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "BBFCFD2AD6BD270AD38D8FE87FD0572B")
    
protected String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.128 -0500", hash_original_method = "C937D3FA4F8C32F6B76B74CD5C9B4805", hash_generated_method = "2588D424856079864764717D30534A88")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        sentProtocol.encode(buffer);
        buffer.append(SP);
        sentBy.encode(buffer);
        if (!parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        }
        if (comment != null) {
            buffer.append(SP).append(LPAREN).append(comment).append(RPAREN);
        }
        if (rPortFlag) buffer.append(";rport");
        return buffer;
    }

    /**
     * Set the host part of this ViaHeader to the newly supplied <code>host</code>
     * parameter.
     *
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the host value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.131 -0500", hash_original_method = "A6610C3C674AD8475435D641E21474E9", hash_generated_method = "CD939FA926D042953639AC7BDFD55E52")
    
public void setHost(String host) throws ParseException {
        if (sentBy == null)
            sentBy = new HostPort();
        try {
            Host h = new Host(host);
            sentBy.setHost(h);
        } catch (Exception e) {
            throw new NullPointerException(" host parameter is null");
        }
    }

    /**
    * Returns the host part of this ViaHeader.
    *
    * @return  the string value of the host
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.134 -0500", hash_original_method = "C40590C8092ADD61F2FE2F813826D182", hash_generated_method = "D2C361D4C23F32BB17AC6E8CCEE36372")
    
public String getHost() {
        if (sentBy == null)
            return null;
        else {
            Host host = sentBy.getHost();
            if (host == null)
                return null;
            else
                return host.getHostname();
        }
    }

    /**
     * Set the port part of this ViaHeader to the newly supplied <code>port</code>
     * parameter.
     *
     * @param port - the Integer.valueOf value of the port of this ViaHeader
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.137 -0500", hash_original_method = "3BFDF83597585B440A29B8E314A4320F", hash_generated_method = "6B58981524053DA5CEBD218FA31BFE68")
    
public void setPort(int port) throws InvalidArgumentException {

        if ( port!=-1 && (port<1 || port>65535)) {
            throw new InvalidArgumentException( "Port value out of range -1, [1..65535]" );
        }

        if (sentBy == null)
            sentBy = new HostPort();
        sentBy.setPort(port);
    }

    /**
     * Set the RPort flag parameter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.141 -0500", hash_original_method = "524778E64DA2B969E2ED4D2BD7E92B55", hash_generated_method = "0B9EAA87CFF53228B28F2E4B2141D3A0")
    
public void setRPort(){
        rPortFlag = true;
    }

    /**
     * Returns the port part of this ViaHeader.
     *
     * @return the integer value of the port
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.144 -0500", hash_original_method = "E4A7E9B0C37CC00BF245A9AEF6038FD8", hash_generated_method = "906A1F3A5691CFDC4DDC6C1A571AB8A3")
    
public int getPort() {
        if (sentBy == null)
            return -1;
        return sentBy.getPort();
    }

    /**
    * Return the rport parameter.
    *
    *@return the rport parameter or -1.
    */
       @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.147 -0500", hash_original_method = "8F51D2BD996E5077EFE382EF5CCB28F7", hash_generated_method = "3511351E0D0FE8826264B6C3334B3AAF")
    
public int getRPort() {
         String strRport = getParameter(ParameterNames.RPORT);
         if (strRport != null && ! strRport.equals(""))
            return Integer.valueOf(strRport).intValue();
         else
            return -1;
         }

    /**
     * Returns the value of the transport parameter.
     *
     * @return the string value of the transport paramter of the ViaHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.151 -0500", hash_original_method = "2C7D6CB162F307BBDEA3C529EA37600B", hash_generated_method = "278AEA19B837E1396BDED40458AA0DF4")
    
public String getTransport() {
        if (sentProtocol == null)
            return null;
        return sentProtocol.getTransport();
    }

    /**
     * Sets the value of the transport. This parameter specifies
     * which transport protocol to use for sending requests and responses to
     * this entity. The following values are defined: "udp", "tcp", "sctp",
     * "tls", but other values may be used also.
     *
     * @param transport - new value for the transport parameter
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the transport value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.154 -0500", hash_original_method = "DA10FBD3B27193627F0BF00A97E141AB", hash_generated_method = "70EFF33C755FC93B2D9F1AE6A3D3C60B")
    
public void setTransport(String transport) throws ParseException {
        if (transport == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setTransport(), the transport parameter is null.");
        if (sentProtocol == null)
            sentProtocol = new Protocol();
        sentProtocol.setTransport(transport);
    }

    /**
     * Returns the value of the protocol used.
     *
     * @return the string value of the protocol paramter of the ViaHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.157 -0500", hash_original_method = "076253ECD4074E0CF94E6CAE84ACD031", hash_generated_method = "AE3F914C1F385E80EBD7FC351D7FF964")
    
public String getProtocol() {
        if (sentProtocol == null)
            return null;
        return sentProtocol.getProtocol();// JvB: Return name ~and~ version
    }

    /**
     * Sets the value of the protocol parameter. This parameter specifies
     * which protocol is used, for example "SIP/2.0".
     *
     * @param protocol - new value for the protocol parameter
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the protocol value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.160 -0500", hash_original_method = "983A1DB4807CBA4F5F74F526664C05F9", hash_generated_method = "9FB96C9A6B3B83D3DC2242FDB012BD1E")
    
public void setProtocol(String protocol) throws ParseException {
        if (protocol == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setProtocol(), the protocol parameter is null.");

        if (sentProtocol == null)
            sentProtocol = new Protocol();

        sentProtocol.setProtocol(protocol);
    }

    /**
     * Returns the value of the ttl parameter, or -1 if this is not set.
     *
     * @return the integer value of the <code>ttl</code> parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.163 -0500", hash_original_method = "AB2BF7863E6929FA549276BF1FCB8F41", hash_generated_method = "FC6220DDEB7B2F642A5C176519D4A5FD")
    
public int getTTL() {
        int ttl = getParameterAsInt(ParameterNames.TTL);
        return ttl;
    }

    /**
     * Sets the value of the ttl parameter. The ttl parameter specifies the
     * time-to-live value when packets are sent using UDP multicast.
     *
     * @param ttl - new value of the ttl parameter
     * @throws InvalidArgumentException if supplied value is less than zero or
     * greater than 255, excluding -1 the default not set value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.167 -0500", hash_original_method = "275C0FDDD82C74D9D06FF2EBDF31F802", hash_generated_method = "68E4131A7FBF1C99BF6026D77E50DE97")
    
public void setTTL(int ttl) throws InvalidArgumentException {
        if (ttl < 0 && ttl != -1)
            throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", Via, setTTL(), the ttl parameter is < 0");
        setParameter(new NameValue(ParameterNames.TTL, Integer.valueOf(ttl)));
    }

    /**
     * Returns the value of the <code>maddr</code> parameter, or null if this
     * is not set.
     *
     * @return the string value of the maddr parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.170 -0500", hash_original_method = "BA8497BF19C86E6498457C19F33C2BB1", hash_generated_method = "1F148048371B6A738FC40E49494DF6D1")
    
public String getMAddr() {
        return getParameter(ParameterNames.MADDR);
    }

    /**
     * Sets the value of the <code>maddr</code> parameter of this ViaHeader. The
     * maddr parameter indicates the server address to be contacted for this
     * user, overriding any address derived from the host field.
     *
     * @param  mAddr new value of the <code>maddr</code> parameter
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the mAddr value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.172 -0500", hash_original_method = "6AB0C98EE8B2466C821195A9A73846A0", hash_generated_method = "85B938EA502BF43FCC37B7396603824F")
    
public void setMAddr(String mAddr) throws ParseException {
        if (mAddr == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setMAddr(), the mAddr parameter is null.");

        Host host = new Host();
        host.setAddress(mAddr);
        NameValue nameValue = new NameValue(ParameterNames.MADDR, host);
        setParameter(nameValue);

    }

    /**
     * Gets the received paramater of the ViaHeader. Returns null if received
     * does not exist.
     *
     * @return the string received value of ViaHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.175 -0500", hash_original_method = "25AF7C33721E5D780684174C5845DEAD", hash_generated_method = "4E8FCF5656D0BCA0C0FBDE4F491C238B")
    
public String getReceived() {
        return getParameter(ParameterNames.RECEIVED);
    }

    /**
     * Sets the received parameter of ViaHeader.
     *
     * @param received - the newly supplied received parameter.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the received value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.178 -0500", hash_original_method = "F727BD69B2536BBCBA80253D70F95056", hash_generated_method = "DC81FC96D12EC8236D2B8780E9141741")
    
public void setReceived(String received) throws ParseException {
        if (received == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setReceived(), the received parameter is null.");

        setParameter(ParameterNames.RECEIVED, received);

    }

    /**
     * Gets the branch paramater of the ViaHeader. Returns null if branch
     * does not exist.
     *
     * @return the string branch value of ViaHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.182 -0500", hash_original_method = "9A958EF7B290CF5A27A4EB96F15158F0", hash_generated_method = "0018E0512B32E4AA454DEB730D48FE1D")
    
public String getBranch() {
        return getParameter(ParameterNames.BRANCH);
    }

    /**
     * Sets the branch parameter of the ViaHeader to the newly supplied
     * branch value.
     *
     * @param branch - the new string branch parmameter of the ViaHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the branch value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.185 -0500", hash_original_method = "5A56F4FACEB17A95A8FCAD93BB83EA63", hash_generated_method = "340F253F2A8F99F6D632137DDBBA9D59")
    
public void setBranch(String branch) throws ParseException {
        if (branch == null || branch.length()==0)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setBranch(), the branch parameter is null or length 0.");

        setParameter(ParameterNames.BRANCH, branch);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.188 -0500", hash_original_method = "252C53006150044E4EBAAC8A002E65B1", hash_generated_method = "D075F094A4B37AF199BF12E2E17F1587")
    
public Object clone() {
        Via retval = (Via) super.clone();
        if (this.sentProtocol != null)
            retval.sentProtocol = (Protocol) this.sentProtocol.clone();
        if (this.sentBy != null)
            retval.sentBy = (HostPort) this.sentBy.clone();
        if ( this.getRPort() != -1)
            retval.setParameter(RPORT,this.getRPort());
        return retval;
    }

    /*
     * (non-Javadoc)
     * @see gov.nist.javax.sip.header.ViaHeaderExt#getSentByField()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.192 -0500", hash_original_method = "5347FDDA2C7AAC95D7D1D2F666800B71", hash_generated_method = "7741DB56E64F64615C969A6462982567")
    
public String getSentByField() {
        if(sentBy != null)
            return sentBy.encode();
        return null;
    }
    /*
     * (non-Javadoc)
     * @see gov.nist.javax.sip.header.ViaHeaderExt#getSentProtocolField()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.195 -0500", hash_original_method = "128FFEF5D307451BA5388B5193A6BF26", hash_generated_method = "58427536C6610BFA4C3467698B755DC0")
    
public String getSentProtocolField() {
        if(sentProtocol != null)
            return sentProtocol.encode();
        return null;
    }
}

