/* **************************************************************************
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
 * $OpenLDAP: /com/novell/sasl/client/DigestChallenge.java,v 1.3 2005/01/17 15:00:54 sunilk Exp $
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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.novell.sasl.client;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.*;
import org.apache.harmony.javax.security.sasl.*;

/**
 * Implements the DigestChallenge class which will be used by the
 * DigestMD5SaslClient class
 */
class DigestChallenge extends Object
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.876 -0400", hash_original_field = "4AE11AD925DE56E2D10E564839A58AB8", hash_generated_field = "323111545A268AEAE7FE55E18979FBE8")

    public static final int QOP_AUTH           =    0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.876 -0400", hash_original_field = "89D21B99008B5439D42E936C8F6AAAB8", hash_generated_field = "83C80D983A3DE3132FEA53342FE950A1")

    public static final int QOP_AUTH_INT       =    0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.877 -0400", hash_original_field = "8047682CE301C1298ABBF49B61C4E654", hash_generated_field = "6ABF504B130BF776528831C9FAABD59A")

    public static final int QOP_AUTH_CONF       =    0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.877 -0400", hash_original_field = "DD35F058F3836EF29E1DA82A22FC5130", hash_generated_field = "0711BAAB5E4D7CE82AECDE787FE423A6")

    public static final int QOP_UNRECOGNIZED   =    0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.878 -0400", hash_original_field = "1045629B15CEE21DB08D9CF34438E7B2", hash_generated_field = "D7E777545932EAD470D69AF8CC4789B4")


    private static final int CIPHER_3DES          = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.878 -0400", hash_original_field = "CC2227AF9E829F546D5E097417AF9D85", hash_generated_field = "C51648A48C4D2EC139FF5CE6E395FBC5")

    private static final int CIPHER_DES           = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.878 -0400", hash_original_field = "4AD241D8EFBF5B087CE0C7CA2F3572B5", hash_generated_field = "D6EF95DF0DB8A74E1AF6DA571934A560")

    private static final int CIPHER_RC4_40        = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.879 -0400", hash_original_field = "D2E8E4696BED34E1AF88A822993EA811", hash_generated_field = "775CA94DBBADA5A367D75615B7D64FC5")

    private static final int CIPHER_RC4           = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.879 -0400", hash_original_field = "57364ED3E76EB660CD2FC98C8F7AB17A", hash_generated_field = "6D4F9D7FEB19239C82D1E3BBD8C91E2F")

    private static final int CIPHER_RC4_56        = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.879 -0400", hash_original_field = "5A880C23542756BEECDC3FD710A8EAB4", hash_generated_field = "5A8B9D97D4D08564C26106EF6DB1EDB4")

    private static final int CIPHER_UNRECOGNIZED  = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.880 -0400", hash_original_field = "D4C851D569AD334DEE653114387D916B", hash_generated_field = "894D1F81EA8A1C8B441086AC9DFA5921")

    private static final int CIPHER_RECOGNIZED_MASK =
     CIPHER_3DES | CIPHER_DES | CIPHER_RC4_40 | CIPHER_RC4 | CIPHER_RC4_56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.880 -0400", hash_original_field = "D815B8E3B760FDD8ECF175E16BF9FF93", hash_generated_field = "9EC8D83C9DF7B80969627C9F7D6D09E4")


    private ArrayList m_realms;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.880 -0400", hash_original_field = "822C1C08FB8204272CDAD5175DFA34F6", hash_generated_field = "6A224F9CAE9E756800FCE3C42AFF69F7")

    private String    m_nonce;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.881 -0400", hash_original_field = "79B08D2599D1FE372FABBB5A07CB1357", hash_generated_field = "25686160BF7533817FB519D2F561976D")

    private int       m_qop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.881 -0400", hash_original_field = "9009F64F49F62B6F4B68669D3746943B", hash_generated_field = "FCC0546AA48486ECA08400559AF8BECC")

    private boolean   m_staleFlag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.881 -0400", hash_original_field = "FECECEE651054D357B6B047AAE501761", hash_generated_field = "C746971036F7C1B0794932A59535D354")

    private int       m_maxBuf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.882 -0400", hash_original_field = "876703D6C3CB0CEC71C106C5E7F14A8B", hash_generated_field = "64D02C5F58CC07CACBDDC1F04C22BC24")

    private String    m_characterSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.882 -0400", hash_original_field = "E0421ED40F2D22FB640E62DD793E604F", hash_generated_field = "E56E6321767E268D4CD9607FF03F8794")

    private String    m_algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.882 -0400", hash_original_field = "9750EBE97ADBEBC822B28460F3386DE3", hash_generated_field = "09C73B2DD74C0286267255E759B8A796")

    private int       m_cipherOptions;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.883 -0400", hash_original_method = "AAA0BFBD9F41701813D027547440A995", hash_generated_method = "AAA0BFBD9F41701813D027547440A995")
    
DigestChallenge(
        byte[] challenge)
            throws SaslException
    {
        m_realms = new ArrayList(5);
        m_nonce = null;
        m_qop = 0;
        m_staleFlag = false;
        m_maxBuf = -1;
        m_characterSet = null;
        m_algorithm = null;
        m_cipherOptions = 0;

        DirectiveList dirList = new DirectiveList(challenge);
        try
        {
            dirList.parseDirectives();
            checkSemantics(dirList);
        }
        catch (SaslException e)
        {
        }
    }

    /**
     * Checks the semantics of the directives in the directive list as parsed
     * from the digest challenge byte array.
     *
     * @param dirList  the list of directives parsed from the digest challenge
     *
     * @exception SaslException   If a semantic error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.884 -0400", hash_original_method = "BB1233CF4738AE9FC92DF89DC7B16A58", hash_generated_method = "503758B2B85726EABC31062235DC24FB")
    
void checkSemantics(
        DirectiveList dirList) throws SaslException
    {
    Iterator        directives = dirList.getIterator();
    ParsedDirective directive;
    String          name;

    while (directives.hasNext())
    {
        directive = (ParsedDirective)directives.next();
        name = directive.getName();
        if (name.equals("realm"))
            handleRealm(directive);
        else if (name.equals("nonce"))
            handleNonce(directive);
        else if (name.equals("qop"))
            handleQop(directive);
        else if (name.equals("maxbuf"))
            handleMaxbuf(directive);
        else if (name.equals("charset"))
            handleCharset(directive);
        else if (name.equals("algorithm"))
            handleAlgorithm(directive);
        else if (name.equals("cipher"))
            handleCipher(directive);
        else if (name.equals("stale"))
            handleStale(directive);
    }

    /* post semantic check */
    if (-1 == m_maxBuf)
        m_maxBuf = 65536;

    if (m_qop == 0)
        m_qop = QOP_AUTH;
    else if ( (m_qop & QOP_AUTH) != QOP_AUTH )
        throw new SaslException("Only qop-auth is supported by client");
    else if ( ((m_qop & QOP_AUTH_CONF) == QOP_AUTH_CONF) &&
              (0 == (m_cipherOptions & CIPHER_RECOGNIZED_MASK)) )
        throw new SaslException("Invalid cipher options");
    else if (null == m_nonce)
        throw new SaslException("Missing nonce directive");
    else if (m_staleFlag)
        throw new SaslException("Unexpected stale flag");
    else if ( null == m_algorithm )
        throw new SaslException("Missing algorithm directive");
    }

    /**
     * This function implements the semenatics of the nonce directive.
     *
     * @param      pd   ParsedDirective
     *
     * @exception  SaslException   If an error occurs due to too many nonce
     *                             values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.884 -0400", hash_original_method = "26D8064AB91F9591B711540A79522C6C", hash_generated_method = "26D8064AB91F9591B711540A79522C6C")
    
void handleNonce(
        ParsedDirective  pd) throws SaslException
    {
        if (null != m_nonce)
            throw new SaslException("Too many nonce values.");

        m_nonce = pd.getValue();
    }

    /**
     * This function implements the semenatics of the realm directive.
     *
     * @param      pd   ParsedDirective
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.885 -0400", hash_original_method = "610EF243350B95DA9BF2481ADC1F99AA", hash_generated_method = "610EF243350B95DA9BF2481ADC1F99AA")
    
void handleRealm(
        ParsedDirective  pd)
    {
        m_realms.add(pd.getValue());
    }

    /**
     * This function implements the semenatics of the qop (quality of protection)
     * directive. The value of the qop directive is as defined below:
     *      qop-options =     "qop" "=" <"> qop-list <">
     *      qop-list    =     1#qop-value
     *      qop-value    =     "auth" | "auth-int"  | "auth-conf" | token
     *
     * @param      pd   ParsedDirective
     *
     * @exception  SaslException   If an error occurs due to too many qop
     *                             directives
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.885 -0400", hash_original_method = "A04684FB7E50F0BFD4ACB9DB06824BBB", hash_generated_method = "A04684FB7E50F0BFD4ACB9DB06824BBB")
    
void handleQop(
        ParsedDirective  pd) throws SaslException
    {
        String       token;
        TokenParser  parser;

        if (m_qop != 0)
            throw new SaslException("Too many qop directives.");

        parser = new TokenParser(pd.getValue());
        for (token = parser.parseToken();
             token != null;
             token = parser.parseToken())
        {
            if (token.equals("auth"))
                  m_qop |= QOP_AUTH;
              else if (token.equals("auth-int"))
                  m_qop |= QOP_AUTH_INT;
            else if (token.equals("auth-conf"))
                m_qop |= QOP_AUTH_CONF;
            else
                m_qop |= QOP_UNRECOGNIZED;
        }
    }

    /**
     * This function implements the semenatics of the Maxbuf directive.
     * the value is defined as: 1*DIGIT
     *
     * @param      pd   ParsedDirective
     *
     * @exception  SaslException If an error occur    
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.886 -0400", hash_original_method = "94DC0A67074803592AE1A1EB602923E4", hash_generated_method = "52C08A3C302F9CD911BDFD3DD36B55D1")
    
void handleMaxbuf(
        ParsedDirective  pd) throws SaslException
    {
        if (-1 != m_maxBuf) /*it's initialized to -1 */
            throw new SaslException("Too many maxBuf directives.");

        m_maxBuf = Integer.parseInt(pd.getValue());

        if (0 == m_maxBuf)
            throw new SaslException("Max buf value must be greater than zero.");
    }

    /**
     * This function implements the semenatics of the charset directive.
     * the value is defined as: 1*DIGIT
     *
     * @param      pd   ParsedDirective
     *
     * @exception  SaslException If an error occurs dur to too many charset
     *                           directives or Invalid character encoding
     *                           directive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.886 -0400", hash_original_method = "0AA1F6914629AC76DD489D600EF77E58", hash_generated_method = "0AA1F6914629AC76DD489D600EF77E58")
    
void handleCharset(
        ParsedDirective  pd) throws SaslException
    {
        if (null != m_characterSet)
            throw new SaslException("Too many charset directives.");

        m_characterSet = pd.getValue();

        if (!m_characterSet.equals("utf-8"))
            throw new SaslException("Invalid character encoding directive");
    }

    /**
     * This function implements the semenatics of the charset directive.
     * the value is defined as: 1*DIGIT
     *
     * @param      pd   ParsedDirective
     *
     * @exception  SaslException If an error occurs due to too many algorith
     *                           directive or Invalid algorithm directive
     *                           value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.886 -0400", hash_original_method = "EA468D4C5448BAE97D968ABD02B259FA", hash_generated_method = "EA468D4C5448BAE97D968ABD02B259FA")
    
void handleAlgorithm(
        ParsedDirective  pd) throws SaslException
    {
        if (null != m_algorithm)
            throw new SaslException("Too many algorithm directives.");

          m_algorithm = pd.getValue();

        if (!"md5-sess".equals(m_algorithm))
            throw new SaslException("Invalid algorithm directive value: " +
                                    m_algorithm);
    }

    /**
     * This function implements the semenatics of the cipher-opts directive
     * directive. The value of the qop directive is as defined below:
     *      qop-options =     "qop" "=" <"> qop-list <">
     *      qop-list    =     1#qop-value
     *      qop-value    =     "auth" | "auth-int"  | "auth-conf" | token
     *
     * @param      pd   ParsedDirective
     *
     * @exception  SaslException If an error occurs due to Too many cipher
     *                           directives 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.887 -0400", hash_original_method = "7E19F379205F7BA279747CDDB3E37EFA", hash_generated_method = "7E19F379205F7BA279747CDDB3E37EFA")
    
void handleCipher(
        ParsedDirective  pd) throws SaslException
    {
        String  token;
        TokenParser parser;

        if (0 != m_cipherOptions)
            throw new SaslException("Too many cipher directives.");

        parser = new TokenParser(pd.getValue());
        token = parser.parseToken();
        for (token = parser.parseToken();
             token != null;
             token = parser.parseToken())
        {
              if ("3des".equals(token))
                  m_cipherOptions |= CIPHER_3DES;
              else if ("des".equals(token))
                  m_cipherOptions |= CIPHER_DES;
            else if ("rc4-40".equals(token))
                m_cipherOptions |= CIPHER_RC4_40;
            else if ("rc4".equals(token))
                m_cipherOptions |= CIPHER_RC4;
            else if ("rc4-56".equals(token))
                m_cipherOptions |= CIPHER_RC4_56;
            else
                m_cipherOptions |= CIPHER_UNRECOGNIZED;
        }

        if (m_cipherOptions == 0)
            m_cipherOptions = CIPHER_UNRECOGNIZED;
    }

    /**
     * This function implements the semenatics of the stale directive.
     *
     * @param      pd   ParsedDirective
     *
     * @exception  SaslException If an error occurs due to Too many stale
     *                           directives or Invalid stale directive value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.888 -0400", hash_original_method = "4583C21333B440A518B6EBCE7C54AD83", hash_generated_method = "4583C21333B440A518B6EBCE7C54AD83")
    
void handleStale(
        ParsedDirective  pd) throws SaslException
    {
        if (false != m_staleFlag)
            throw new SaslException("Too many stale directives.");

        if ("true".equals(pd.getValue()))
            m_staleFlag = true;
        else
            throw new SaslException("Invalid stale directive value: " +
                                    pd.getValue());
    }

    /**
     * Return the list of the All the Realms
     *
     * @return  List of all the realms 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.888 -0400", hash_original_method = "D9E422343AA91450CC89A2231DF2DBC1", hash_generated_method = "6284639E71FF44949154EC7D35B09A16")
    
public ArrayList getRealms()
    {
        return m_realms;
    }

    /**
     * @return Returns the Nonce
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.888 -0400", hash_original_method = "A02B98AD5FD5DEF077FE6F666198509E", hash_generated_method = "B24507F961451A7F420BE8750AAC56C7")
    
public String getNonce()
    {
        return m_nonce;
    }

    /**
     * Return the quality-of-protection
     * 
     * @return The quality-of-protection
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.889 -0400", hash_original_method = "DE535F91785AE7ECBDAA40F114C91960", hash_generated_method = "F3DBC19BCABB2851AEBB195F24A64C3B")
    
public int getQop()
    {
        return m_qop;
    }

    /**
     * @return The state of the Staleflag
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.889 -0400", hash_original_method = "EF28C73339A10AA71527DA5CD07EBBDD", hash_generated_method = "C52FADF7D3F9C1BC8E4D052CBA0CFCEA")
    
public boolean getStaleFlag()
    {
        return m_staleFlag;
    }

    /**
     * @return The Maximum Buffer value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.889 -0400", hash_original_method = "2097248E0A597EFA40847EBF1076FD97", hash_generated_method = "812E8B21A61A7259E00DE718A8C4998E")
    
public int getMaxBuf()
    {
        return m_maxBuf;
    }

    /**
     * @return character set values as string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.890 -0400", hash_original_method = "1489C04ED714821E4C2811A9C151E42B", hash_generated_method = "174E79F37EEAA7CF218B66D8CFC7E951")
    
public String getCharacterSet()
    {
        return m_characterSet;
    }

    /**
     * @return The String value of the algorithm
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.890 -0400", hash_original_method = "6860FE8EDFB16DE7C9BC8286581EDDD5", hash_generated_method = "BCA27D0F660721730E58E7FBDE3A3763")
    
public String getAlgorithm()
    {
        return m_algorithm;
    }

    /**
     * @return The cipher options
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:37.890 -0400", hash_original_method = "7A0395BF1632C1E58804B7A9198FD8DF", hash_generated_method = "609BC9D610A05EC0A63A10D456968AB4")
    
public int getCipherOptions()
    {
        return m_cipherOptions;
    }
}

