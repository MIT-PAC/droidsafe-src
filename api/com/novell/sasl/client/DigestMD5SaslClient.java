/* **************************************************************************
 * $OpenLDAP: /com/novell/sasl/client/DigestMD5SaslClient.java,v 1.4 2005/01/17 15:00:54 sunilk Exp $
 *
 * Copyright (C) 2003 Novell, Inc. All Rights Reserved.
 *
 * THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND
 * TREATIES. USE, MODIFICATION, AND REDISTRIBUTION OF THIS WORK IS SUBJECT
 * TO VERSION 2.0.1 OF THE OPENLDAP PUBLIC LICENSE, A COPY OF WHICH IS
 * AVAILABLE AT HTTP://WWW.OPENLDAP.ORG/LICENSE.HTML OR IN THE FILE "LICENSE"
 * IN THE TOP-LEVEL DIRECTORY OF THE DISTRIBUTION. ANY USE OR EXPLOITATION
 * OF THIS WORK OTHER THAN AS AUTHORIZED IN VERSION 2.0.1 OF THE OPENLDAP
 * PUBLIC LICENSE, OR OTHER PRIOR WRITTEN CONSENT FROM NOVELL, COULD SUBJECT
 * THE PERPETRATOR TO CRIMINAL AND CIVIL LIABILITY.
 ******************************************************************************/
package com.novell.sasl.client;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.harmony.javax.security.sasl.*;
import org.apache.harmony.javax.security.auth.callback.*;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.*;

/**
 * Implements the Client portion of DigestMD5 Sasl mechanism.
 */
public class DigestMD5SaslClient implements SaslClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.079 -0400", hash_original_field = "FA87AC59973B38ADAE8DBDA5D2B21C75", hash_generated_field = "A32BD57A6E912677A21C3C344A408FA1")

    private static final int   STATE_INITIAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.079 -0400", hash_original_field = "1EACCFB4BC8511179EBB11B73883EF96", hash_generated_field = "030D8793D6DA04860BD9AFE934E67D84")

    private static final int   STATE_DIGEST_RESPONSE_SENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.079 -0400", hash_original_field = "F006130B2B81B71F1DB63219D2739C9C", hash_generated_field = "541BE6597399F330521B36B7D66DFD75")

    private static final int   STATE_VALID_SERVER_RESPONSE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.080 -0400", hash_original_field = "B84EB66738A8F24E6A7DAA3672274BF1", hash_generated_field = "88ACD17BBF7AA1759297F2EE12598889")

    private static final int   STATE_INVALID_SERVER_RESPONSE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.080 -0400", hash_original_field = "7D0A2E895C9A66A52642234C04AE771F", hash_generated_field = "481764CAD6D86FDE9C9E9FA3343B1373")

    private static final int   STATE_DISPOSED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.080 -0400", hash_original_field = "C9E2B82451163FF5F78D3A7C70062FE1", hash_generated_field = "CCE9BD44A9BD0B8AAA99CF11A20514A8")

    private static final int   NONCE_BYTE_COUNT = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.081 -0400", hash_original_field = "C7F53400E76C2001C6F8CA23C0F121B7", hash_generated_field = "F691E2EAA8FD6374E826CDAF56A045E7")

    private static final int   NONCE_HEX_COUNT = 2*NONCE_BYTE_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.081 -0400", hash_original_field = "530D3D362EE226A4263422B088AD44F5", hash_generated_field = "2D7383530BA1017246DF1467E3BB2D9F")

    private static final String DIGEST_METHOD = "AUTHENTICATE";

    /**
     * Creates an DigestMD5SaslClient object using the parameters supplied.
     * Assumes that the QOP, STRENGTH, and SERVER_AUTH properties are
     * contained in props
     *
     * @param authorizationId  The possibly null protocol-dependent
     *                     identification to be used for authorization. If
     *                     null or empty, the server derives an authorization
     *                     ID from the client's authentication credentials.
     *                     When the SASL authentication completes
     *                     successfully, the specified entity is granted
     *                     access.
     *
     * @param protocol     The non-null string name of the protocol for which
     *                     the authentication is being performed (e.g. "ldap")
     *
     * @param serverName   The non-null fully qualified host name of the server
     *                     to authenticate to
     *
     * @param props        The possibly null set of properties used to select
     *                     the SASL mechanism and to configure the
     *                     authentication exchange of the selected mechanism.
     *                     See the Sasl class for a list of standard properties.
     *                     Other, possibly mechanism-specific, properties can
     *                     be included. Properties not relevant to the selected
     *                     mechanism are ignored.
     *
     * @param cbh          The possibly null callback handler to used by the
     *                     SASL mechanisms to get further information from the
     *                     application/library to complete the authentication.
     *                     For example, a SASL mechanism might require the
     *                     authentication ID, password and realm from the
     *                     caller. The authentication ID is requested by using
     *                     a NameCallback. The password is requested by using
     *                     a PasswordCallback. The realm is requested by using
     *                     a RealmChoiceCallback if there is a list of realms
     *                     to choose from, and by using a RealmCallback if the
     *                     realm must be entered.
     *
     * @return            A possibly null SaslClient created using the
     *                     parameters supplied. If null, this factory cannot
     *                     produce a SaslClient using the parameters supplied.
     *
     * @exception SaslException  If a SaslClient instance cannot be created
     *                     because of an error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.082 -0400", hash_original_method = "02E16E2713BA27EEAA83B83BE5137560", hash_generated_method = "FB514EAB5A550A96BDDE29AB502C972A")
    
public static SaslClient getClient(
        String          authorizationId,
        String          protocol,
        String          serverName,
        Map             props,
        CallbackHandler cbh)
    {
        String desiredQOP = (String)props.get(Sasl.QOP);
        String desiredStrength = (String)props.get(Sasl.STRENGTH);
        String serverAuth = (String)props.get(Sasl.SERVER_AUTH);

        //only support qop equal to auth
        if ((desiredQOP != null) && !"auth".equals(desiredQOP))
            return null;

        //doesn't support server authentication
        if ((serverAuth != null) && !"false".equals(serverAuth))
            return null;

        //need a callback handler to get the password
        if (cbh == null)
            return null;

        return new DigestMD5SaslClient(authorizationId, protocol,
                                       serverName, props, cbh);
    }

    /**
     * This function returns hex character representing the value of the input
     * 
     * @param value Input value in byte
     *
     * @return Hex value of the Input byte value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.092 -0400", hash_original_method = "130E15708D55DA23B0A04268B347279E", hash_generated_method = "5D506ABB3DA872C7804D710C3CE545F0")
    
private static char getHexChar(
        byte    value)
    {
        switch (value)
        {
        case 0:
            return '0';
        case 1:
            return '1';
        case 2:
            return '2';
        case 3:
            return '3';
        case 4:
            return '4';
        case 5:
            return '5';
        case 6:
            return '6';
        case 7:
            return '7';
        case 8:
            return '8';
        case 9:
            return '9';
        case 10:
            return 'a';
        case 11:
            return 'b';
        case 12:
            return 'c';
        case 13:
            return 'd';
        case 14:
            return 'e';
        case 15:
            return 'f';
        default:
            return 'Z';
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.074 -0400", hash_original_field = "C85B419BE6678E2F3DD6EA75BDA37DA1", hash_generated_field = "535AC5AB9047A7B4F1AC2A95A2DEECC8")

    private String           m_authorizationId = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.075 -0400", hash_original_field = "E809DC3028E19F659B3CB1F90FCB7DFD", hash_generated_field = "5BFA5D382060E8266BD32596383DB108")

    private String           m_protocol = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.075 -0400", hash_original_field = "86CE253C5680F92896CCB122882918F0", hash_generated_field = "982330C2FD4D8ED8502A7E78855E7AFF")

    private String           m_serverName = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.075 -0400", hash_original_field = "38CF6F5F3C9B3EF7AD72FA0A7730BCF1", hash_generated_field = "FC65EEF98991D05B8AFD817440EBC4E2")

    private Map              m_props;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.076 -0400", hash_original_field = "77012CF0B93D1BB251CA370C7007FD05", hash_generated_field = "90B9DCFB7A9E3C250755024B080C8617")

    private CallbackHandler  m_cbh;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.076 -0400", hash_original_field = "D01CAE2C152521D735FF4BEDA177DA34", hash_generated_field = "7C0FADC2E45317251723B3D155E47B41")

    private int              m_state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.076 -0400", hash_original_field = "06120E09231853E2431867D2D959EACE", hash_generated_field = "4ABB3957A21D122697ADE6889CFFF13D")

    private String           m_qopValue = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.077 -0400", hash_original_field = "532EEED29E035D4B97185E4EC294BBD7", hash_generated_field = "CC9276E85223FB155C87D000A0E9DB03")

    private char[]              m_HA1 = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.077 -0400", hash_original_field = "A1A4C666792ACABEE172F63FE7E3FB54", hash_generated_field = "AD70F3004E7B7E4AAC0026BDCB7C956E")

    private String           m_digestURI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.077 -0400", hash_original_field = "DE86850CD8565655FDD5F9E216567CBC", hash_generated_field = "787538F31955F75CD5B87D09526FD240")

    private DigestChallenge  m_dc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.078 -0400", hash_original_field = "AB7E298FF55DA108E5D4E0D62A5F1E29", hash_generated_field = "5B6A345EAC3CC8A342D6EE685E720594")

    private String           m_clientNonce = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.078 -0400", hash_original_field = "E45EF109C86D080A24FB09878B880363", hash_generated_field = "EEE3D3655B84114DE2EC3581F9C83C94")

    private String           m_realm = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.078 -0400", hash_original_field = "34CCB085B58A1BB04CA4D567CFA17B82", hash_generated_field = "E2C3282B98ACCB6ED78D0B1160BA1D96")

    private String           m_name = "";

    /**
     * Creates an DigestMD5SaslClient object using the parameters supplied.
     * Assumes that the QOP, STRENGTH, and SERVER_AUTH properties are
     * contained in props
     *
     * @param authorizationId  The possibly null protocol-dependent
     *                     identification to be used for authorization. If
     *                     null or empty, the server derives an authorization
     *                     ID from the client's authentication credentials.
     *                     When the SASL authentication completes
     *                     successfully, the specified entity is granted
     *                     access.
     *
     * @param protocol     The non-null string name of the protocol for which
     *                     the authentication is being performed (e.g. "ldap")
     *
     * @param serverName   The non-null fully qualified host name of the server
     *                     to authenticate to
     *
     * @param props        The possibly null set of properties used to select
     *                     the SASL mechanism and to configure the
     *                     authentication exchange of the selected mechanism.
     *                     See the Sasl class for a list of standard properties.
     *                     Other, possibly mechanism-specific, properties can
     *                     be included. Properties not relevant to the selected
     *                     mechanism are ignored.
     *
     * @param cbh          The possibly null callback handler to used by the
     *                     SASL mechanisms to get further information from the
     *                     application/library to complete the authentication.
     *                     For example, a SASL mechanism might require the
     *                     authentication ID, password and realm from the
     *                     caller. The authentication ID is requested by using
     *                     a NameCallback. The password is requested by using
     *                     a PasswordCallback. The realm is requested by using
     *                     a RealmChoiceCallback if there is a list of realms
     *                     to choose from, and by using a RealmCallback if the
     *                     realm must be entered.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.083 -0400", hash_original_method = "0290D4AD50FF3D928893DFCC7EB99280", hash_generated_method = "7FE8186B2C1EF4B60A25EB8E183869E7")
    
private  DigestMD5SaslClient(
        String          authorizationId,
        String          protocol,
        String          serverName,
        Map             props,
        CallbackHandler cbh)
    {
        m_authorizationId = authorizationId;
        m_protocol = protocol;
        m_serverName = serverName;
        m_props = props;
        m_cbh = cbh;

        m_state = STATE_INITIAL;
    }

    /**
     * Determines if this mechanism has an optional initial response. If true,
     * caller should call evaluateChallenge() with an empty array to get the
     * initial response.
     *
     * @return  true if this mechanism has an initial response
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.083 -0400", hash_original_method = "1ECCE9E7B8E4B2ABE7862485905FED28", hash_generated_method = "5D6143BFB96C7D98182A05D61ACED164")
    
public boolean hasInitialResponse()
    {
        return false;
    }

    /**
     * Determines if the authentication exchange has completed. This method
     * may be called at any time, but typically, it will not be called until
     * the caller has received indication from the server (in a protocol-
     * specific manner) that the exchange has completed.
     *
     * @return  true if the authentication exchange has completed;
     *           false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.083 -0400", hash_original_method = "510E55A569E5F58C0254A27CAD05D1AE", hash_generated_method = "4EFE0B36F792513ED2C5DD72288AD049")
    
public boolean isComplete()
    {
        if ((m_state == STATE_VALID_SERVER_RESPONSE) ||
            (m_state == STATE_INVALID_SERVER_RESPONSE) ||
            (m_state == STATE_DISPOSED))
            return true;
        else
            return false;
    }

    /**
     * Unwraps a byte array received from the server. This method can be called
     * only after the authentication exchange has completed (i.e., when
     * isComplete() returns true) and only if the authentication exchange has
     * negotiated integrity and/or privacy as the quality of protection;
     * otherwise, an IllegalStateException is thrown.
     *
     * incoming is the contents of the SASL buffer as defined in RFC 2222
     * without the leading four octet field that represents the length.
     * offset and len specify the portion of incoming to use.
     *
     * @param incoming   A non-null byte array containing the encoded bytes
     *                   from the server
     * @param offset     The starting position at incoming of the bytes to use
     *
     * @param len        The number of bytes from incoming to use
     *
     * @return           A non-null byte array containing the decoded bytes
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.084 -0400", hash_original_method = "4D0571A7E4FC2D691D4F805227DFD9C3", hash_generated_method = "59D764D9F72131F5B8D84FD2CAD70471")
    
public byte[] unwrap(
        byte[] incoming,
        int    offset,
        int    len)
            throws SaslException
    {
        throw new IllegalStateException(
         "unwrap: QOP has neither integrity nor privacy>");
    }

    /**
     * Wraps a byte array to be sent to the server. This method can be called
     * only after the authentication exchange has completed (i.e., when
     * isComplete() returns true) and only if the authentication exchange has
     * negotiated integrity and/or privacy as the quality of protection;
     * otherwise, an IllegalStateException is thrown.
     *
     * The result of this method will make up the contents of the SASL buffer as
     * defined in RFC 2222 without the leading four octet field that represents
     * the length. offset and len specify the portion of outgoing to use.
     *
     * @param outgoing   A non-null byte array containing the bytes to encode
     * @param offset     The starting position at outgoing of the bytes to use
     * @param len        The number of bytes from outgoing to use
     *
     * @return A non-null byte array containing the encoded bytes
     *
     * @exception SaslException  if incoming cannot be successfully unwrapped.
     *
     * @exception IllegalStateException   if the authentication exchange has
     *                   not completed, or if the negotiated quality of
     *                   protection has neither integrity nor privacy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.084 -0400", hash_original_method = "8A091F325B2B1BE84B433E7B2F988B9C", hash_generated_method = "C6810D6341C6F42FA1E511539AAE4989")
    
public byte[] wrap(
        byte[]  outgoing,
        int     offset,
        int     len)
            throws SaslException
    {
        throw new IllegalStateException(
         "wrap: QOP has neither integrity nor privacy>");
    }

    /**
     * Retrieves the negotiated property. This method can be called only after
     * the authentication exchange has completed (i.e., when isComplete()
     * returns true); otherwise, an IllegalStateException is thrown.
     *
     * @param propName   The non-null property name
     *
     * @return  The value of the negotiated property. If null, the property was
     *          not negotiated or is not applicable to this mechanism.
     *
     * @exception IllegalStateException   if this authentication exchange has
     *                                    not completed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.085 -0400", hash_original_method = "A788B7A9A1C056E611894C2DC8634F3D", hash_generated_method = "C8042C74077FAED142376A86E13DFE02")
    
public Object getNegotiatedProperty(
        String propName)
    {
        if (m_state != STATE_VALID_SERVER_RESPONSE)
            throw new IllegalStateException(
             "getNegotiatedProperty: authentication exchange not complete.");

        if (Sasl.QOP.equals(propName))
            return "auth";
        else
            return null;
    }

    /**
     * Disposes of any system resources or security-sensitive information the
     * SaslClient might be using. Invoking this method invalidates the
     * SaslClient instance. This method is idempotent.
     *
     * @exception SaslException  if a problem was encountered while disposing
     *                           of the resources
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.085 -0400", hash_original_method = "F1F4EB72DFF772C64E230B7C17B3D041", hash_generated_method = "87E83F01FDF638CAA33BED1D66852668")
    
public void dispose()
            throws SaslException
    {
        if (m_state != STATE_DISPOSED)
        {
            m_state = STATE_DISPOSED;
        }
    }

    /**
     * Evaluates the challenge data and generates a response. If a challenge
     * is received from the server during the authentication process, this
     * method is called to prepare an appropriate next response to submit to
     * the server.
     *
     * @param challenge  The non-null challenge sent from the server. The
     *                   challenge array may have zero length.
     *
     * @return    The possibly null reponse to send to the server. It is null
     *            if the challenge accompanied a "SUCCESS" status and the
     *            challenge only contains data for the client to update its
     *            state and no response needs to be sent to the server.
     *            The response is a zero-length byte array if the client is to
     *            send a response with no data.
     *
     * @exception SaslException   If an error occurred while processing the
     *                            challenge or generating a response.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.086 -0400", hash_original_method = "31AD7988DC6C484C1191489DC59E082D", hash_generated_method = "FFE848F30B13C91D22B81735BFBF10C0")
    
public byte[] evaluateChallenge(
        byte[] challenge)
            throws SaslException
    {
        byte[] response = null;

        //printState();
        switch (m_state)
        {
        case STATE_INITIAL:
            if (challenge.length == 0)
                throw new SaslException("response = byte[0]");
            else
                try
                {
                    response = createDigestResponse(challenge).
                                                           getBytes("UTF-8");
                    m_state = STATE_DIGEST_RESPONSE_SENT;
                }
                catch (java.io.UnsupportedEncodingException e)
                {
                    throw new SaslException(
                     "UTF-8 encoding not suppported by platform", e);
                }
            break;
        case STATE_DIGEST_RESPONSE_SENT:
            if (checkServerResponseAuth(challenge))
                m_state = STATE_VALID_SERVER_RESPONSE;
            else
            {
                m_state = STATE_INVALID_SERVER_RESPONSE;
                throw new SaslException("Could not validate response-auth " +
                                        "value from server");
            }
            break;
        case STATE_VALID_SERVER_RESPONSE:
        case STATE_INVALID_SERVER_RESPONSE:
            throw new SaslException("Authentication sequence is complete");
        case STATE_DISPOSED:
            throw new SaslException("Client has been disposed");
        default:
            throw new SaslException("Unknown client state.");
        }

        return response;
    }

    /**
     * This function takes a 16 byte binary md5-hash value and creates a 32
     * character (plus    a terminating null character) hex-digit 
     * representation of binary data.
     *
     * @param hash  16 byte binary md5-hash value in bytes
     * 
     * @return   32 character (plus    a terminating null character) hex-digit
     *           representation of binary data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.087 -0400", hash_original_method = "772E48859B8D6014A94196EB87B496F8", hash_generated_method = "08C77205267DC41FDD11DCA1C30BC7D4")
    
char[] convertToHex(
        byte[] hash)
    {
        int          i;
        byte         j;
        byte         fifteen = 15;
        char[]      hex = new char[32];

        for (i = 0; i < 16; i++)
        {
            //convert value of top 4 bits to hex char
            hex[i*2] = getHexChar((byte)((hash[i] & 0xf0) >> 4));
            //convert value of bottom 4 bits to hex char
            hex[(i*2)+1] = getHexChar((byte)(hash[i] & 0x0f));
        }

        return hex;
    }

    /**
     * Calculates the HA1 portion of the response
     *
     * @param  algorithm   Algorith to use.
     * @param  userName    User being authenticated
     * @param  realm       realm information
     * @param  password    password of teh user
     * @param  nonce       nonce value
     * @param  clientNonce Clients Nonce value
     *
     * @return  HA1 portion of the response in a character array
     *
     * @exception SaslException  If an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.088 -0400", hash_original_method = "6DB44DC05092472C2E9CFC4E7733DDB9", hash_generated_method = "6DB44DC05092472C2E9CFC4E7733DDB9")
    
char[] DigestCalcHA1(
        String   algorithm,
        String   userName,
        String   realm,
        String   password,
        String   nonce,
        String   clientNonce) throws SaslException
    {
        byte[]        hash;

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(userName.getBytes("UTF-8"));
            md.update(":".getBytes("UTF-8"));
            md.update(realm.getBytes("UTF-8"));
            md.update(":".getBytes("UTF-8"));
            md.update(password.getBytes("UTF-8"));
            hash = md.digest();

            if ("md5-sess".equals(algorithm))
            {
                md.update(hash);
                md.update(":".getBytes("UTF-8"));
                md.update(nonce.getBytes("UTF-8"));
                md.update(":".getBytes("UTF-8"));
                md.update(clientNonce.getBytes("UTF-8"));
                hash = md.digest();
            }
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new SaslException("No provider found for MD5 hash", e);
        }
        catch(UnsupportedEncodingException e)
        {
            throw new SaslException(
             "UTF-8 encoding not supported by platform.", e);
        }

        return convertToHex(hash);
    }

    /**
     * This function calculates the response-value of the response directive of
     * the digest-response as documented in RFC 2831
     *
     * @param  HA1           H(A1)
     * @param  serverNonce   nonce from server
     * @param  nonceCount    8 hex digits
     * @param  clientNonce   client nonce 
     * @param  qop           qop-value: "", "auth", "auth-int"
     * @param  method        method from the request
     * @param  digestUri     requested URL
     * @param  clientResponseFlag request-digest or response-digest
     *
     * @return Response-value of the response directive of the digest-response
     *
     * @exception SaslException  If an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.089 -0400", hash_original_method = "B7A28C61A846EBE9286148203C13F859", hash_generated_method = "5A744421AE0A165279C10CC209A57682")
    
char[] DigestCalcResponse(
        char[]      HA1,            /* H(A1) */
        String      serverNonce,    /* nonce from server */
        String      nonceCount,     /* 8 hex digits */
        String      clientNonce,    /* client nonce */
        String      qop,            /* qop-value: "", "auth", "auth-int" */
        String      method,         /* method from the request */
        String      digestUri,      /* requested URL */
        boolean     clientResponseFlag) /* request-digest or response-digest */
            throws SaslException
    {
        byte[]             HA2;
        byte[]             respHash;
        char[]             HA2Hex;

        // calculate H(A2)
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (clientResponseFlag)
                  md.update(method.getBytes("UTF-8"));
            md.update(":".getBytes("UTF-8"));
            md.update(digestUri.getBytes("UTF-8"));
            if ("auth-int".equals(qop))
            {
                md.update(":".getBytes("UTF-8"));
                md.update("00000000000000000000000000000000".getBytes("UTF-8"));
            }
            HA2 = md.digest();
            HA2Hex = convertToHex(HA2);

            // calculate response
            md.update(new String(HA1).getBytes("UTF-8"));
            md.update(":".getBytes("UTF-8"));
            md.update(serverNonce.getBytes("UTF-8"));
            md.update(":".getBytes("UTF-8"));
            if (qop.length() > 0)
            {
                md.update(nonceCount.getBytes("UTF-8"));
                md.update(":".getBytes("UTF-8"));
                md.update(clientNonce.getBytes("UTF-8"));
                md.update(":".getBytes("UTF-8"));
                md.update(qop.getBytes("UTF-8"));
                md.update(":".getBytes("UTF-8"));
            }
            md.update(new String(HA2Hex).getBytes("UTF-8"));
            respHash = md.digest();
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new SaslException("No provider found for MD5 hash", e);
        }
        catch(UnsupportedEncodingException e)
        {
            throw new SaslException(
             "UTF-8 encoding not supported by platform.", e);
        }

        return convertToHex(respHash);
    }

    /**
     * Creates the intial response to be sent to the server.
     *
     * @param challenge  Challenge in bytes recived form the Server
     *
     * @return Initial response to be sent to the server
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.091 -0400", hash_original_method = "9E0DA735A7E1F6A8C723ADDD316FAC17", hash_generated_method = "22C3FB5BAC04C1EA364CFD4C5737B43F")
    
private String createDigestResponse(
        byte[] challenge)
            throws SaslException
    {
        char[]            response;
        StringBuffer    digestResponse = new StringBuffer(512);
        int             realmSize;

        m_dc = new DigestChallenge(challenge);

        m_digestURI = m_protocol + "/" + m_serverName;

        if ((m_dc.getQop() & DigestChallenge.QOP_AUTH)
            == DigestChallenge.QOP_AUTH )
            m_qopValue = "auth";
        else
            throw new SaslException("Client only supports qop of 'auth'");

        //get call back information
        Callback[] callbacks = new Callback[3];
        ArrayList realms = m_dc.getRealms();
        realmSize = realms.size();
        if (realmSize == 0)
        {
            callbacks[0] = new RealmCallback("Realm");
        }
        else if (realmSize == 1)
        {
            callbacks[0] = new RealmCallback("Realm", (String)realms.get(0));
        }
        else
        {
            callbacks[0] =
             new RealmChoiceCallback(
                         "Realm",
                         (String[])realms.toArray(new String[realmSize]),
                          0,      //the default choice index
                          false); //no multiple selections
        }

        callbacks[1] = new PasswordCallback("Password", false); 
        //false = no echo

        if (m_authorizationId == null || m_authorizationId.length() == 0)
            callbacks[2] = new NameCallback("Name");
        else
            callbacks[2] = new NameCallback("Name", m_authorizationId);

        try
        {
            m_cbh.handle(callbacks);
        }
        catch(UnsupportedCallbackException e)
        {
            throw new SaslException("Handler does not support" +
                                          " necessary callbacks",e);
        }
        catch(IOException e)
        {
            throw new SaslException("IO exception in CallbackHandler.", e);
        }

        if (realmSize > 1)
        {
            int[] selections =
             ((RealmChoiceCallback)callbacks[0]).getSelectedIndexes();

            if (selections.length > 0)
                m_realm =
                ((RealmChoiceCallback)callbacks[0]).getChoices()[selections[0]];
            else
                m_realm = ((RealmChoiceCallback)callbacks[0]).getChoices()[0];
        }
        else
            m_realm = ((RealmCallback)callbacks[0]).getText();

        m_clientNonce = getClientNonce();

        m_name = ((NameCallback)callbacks[2]).getName();
        if (m_name == null)
            m_name = ((NameCallback)callbacks[2]).getDefaultName();
        if (m_name == null)
            throw new SaslException("No user name was specified.");

        m_HA1 = DigestCalcHA1(
                      m_dc.getAlgorithm(),
                      m_name,
                      m_realm,
                      new String(((PasswordCallback)callbacks[1]).getPassword()),
                      m_dc.getNonce(),
                      m_clientNonce);

        response = DigestCalcResponse(m_HA1,
                                      m_dc.getNonce(),
                                      "00000001",
                                      m_clientNonce,
                                      m_qopValue,
                                      "AUTHENTICATE",
                                      m_digestURI,
                                      true);

        digestResponse.append("username=\"");
        digestResponse.append(m_authorizationId);
        if (0 != m_realm.length())
        {
            digestResponse.append("\",realm=\"");
            digestResponse.append(m_realm);
        }
        digestResponse.append("\",cnonce=\"");
        digestResponse.append(m_clientNonce);
        digestResponse.append("\",nc=");
        digestResponse.append("00000001"); //nounce count
        digestResponse.append(",qop=");
        digestResponse.append(m_qopValue);
        digestResponse.append(",digest-uri=\"ldap/");
        digestResponse.append(m_serverName);
        digestResponse.append("\",response=");
        digestResponse.append(response);
        digestResponse.append(",charset=utf-8,nonce=\"");
        digestResponse.append(m_dc.getNonce());
        digestResponse.append("\"");

        return digestResponse.toString();
     }
     
    /**
     * This function validates the server response. This step performs a 
     * modicum of mutual authentication by verifying that the server knows
     * the user's password
     *
     * @param  serverResponse  Response recived form Server
     *
     * @return  true if the mutual authentication succeeds;
     *          else return false
     *
     * @exception SaslException  If an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.092 -0400", hash_original_method = "3560B5296CD50B5994588488BE467E27", hash_generated_method = "3560B5296CD50B5994588488BE467E27")
    
boolean checkServerResponseAuth(
            byte[]  serverResponse) throws SaslException
    {
        char[]           response;
        ResponseAuth  responseAuth = null;
        String        responseStr;

        responseAuth = new ResponseAuth(serverResponse);

        response = DigestCalcResponse(m_HA1,
                                  m_dc.getNonce(),
                                  "00000001",
                                  m_clientNonce,
                                  m_qopValue,
                                  DIGEST_METHOD,
                                  m_digestURI,
                                  false);

        responseStr = new String(response);

        return responseStr.equals(responseAuth.getResponseValue());
    }

    /**
     * Calculates the Nonce value of the Client
     * 
     * @return   Nonce value of the client
     *
     * @exception   SaslException If an error Occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.093 -0400", hash_original_method = "1FABB4A082725D727787F05970246331", hash_generated_method = "E8CAA59E8D818B71C76055CFF448904F")
    
String getClientNonce() throws SaslException
    {
        byte[]          nonceBytes = new byte[NONCE_BYTE_COUNT];
        SecureRandom    prng;
        byte            nonceByte;
        char[]          hexNonce = new char[NONCE_HEX_COUNT];

        try
        {
            prng = SecureRandom.getInstance("SHA1PRNG");
            prng.nextBytes(nonceBytes);
            for(int i=0; i<NONCE_BYTE_COUNT; i++)
            {
                //low nibble
                hexNonce[i*2] = getHexChar((byte)(nonceBytes[i] & 0x0f));
                //high nibble
                hexNonce[(i*2)+1] = getHexChar((byte)((nonceBytes[i] & 0xf0)
                                                                      >> 4));
            }
            return new String(hexNonce);
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new SaslException("No random number generator available", e);
        }
    }

    /**
     * Returns the IANA-registered mechanism name of this SASL client.
     *  (e.g. "CRAM-MD5", "GSSAPI")
     *
     * @return  "DIGEST-MD5"the IANA-registered mechanism name of this SASL
     *          client.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.094 -0400", hash_original_method = "C1804286569190DC3AF8EF2974E43DC5", hash_generated_method = "CD87F2F83444BA32E082DBAF9FBB9ECF")
    
public String getMechanismName()
    {
        return "DIGEST-MD5";
    }

} //end class DigestMD5SaslClient

