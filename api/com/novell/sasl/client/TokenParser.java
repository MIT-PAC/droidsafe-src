/* **************************************************************************
 * $OpenLDAP: /com/novell/sasl/client/TokenParser.java,v 1.3 2005/01/17 15:00:54 sunilk Exp $
 *
 * Copyright (C) 2002 Novell, Inc. All Rights Reserved.
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
/**
 * The TokenParser class will parse individual tokens from a list of tokens that
 * are a directive value for a DigestMD5 authentication.The tokens are separated
 * commas.
 */
class TokenParser extends Object
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.302 -0400", hash_original_field = "C2B3F3D4EBE82ED311FCD5E7CEC0CC0D", hash_generated_field = "63FF0053A0B8DC23B5F728ACBDFFABCF")

    private static final int STATE_LOOKING_FOR_FIRST_TOKEN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.302 -0400", hash_original_field = "996625A6707A5D8F57D0307159A9AC2C", hash_generated_field = "1DC6C6EECCE8A4B3E916CAE1A6106DF8")

    private static final int STATE_LOOKING_FOR_TOKEN       = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.303 -0400", hash_original_field = "54252C975E2BCC016744C240613741A1", hash_generated_field = "7B37BB84D8E9BF35DDB91896FB6FF0A5")

    private static final int STATE_SCANNING_TOKEN          = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.303 -0400", hash_original_field = "EB70E1183E1290B6C4BFB8B5461F4386", hash_generated_field = "61A890F5A9275A6085383DA067B03CCF")

    private static final int STATE_LOOKING_FOR_COMMA       = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.303 -0400", hash_original_field = "4920C770BE13FA9403C16201CC992C6E", hash_generated_field = "F8A2219C04544D1C4CC61E2A6497DFC8")

    private static final int STATE_PARSING_ERROR           = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.304 -0400", hash_original_field = "4EF641AE7B9359CF9A08186FC4C2EDD9", hash_generated_field = "6684DA8F320A24B9E6344562085AC24C")

    private static final int STATE_DONE                    = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.304 -0400", hash_original_field = "4E7E9E66EFE2A1D672E2A3D6C3739E6C", hash_generated_field = "DF335CC9A9A4F49795664736E809700F")


    private int        m_curPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.304 -0400", hash_original_field = "053E05000DDCEB31DF6544D90ED49DFA", hash_generated_field = "CA707FD05D7E6C294081338DE4D33980")

    private int     m_scanStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.305 -0400", hash_original_field = "D01CAE2C152521D735FF4BEDA177DA34", hash_generated_field = "7C0FADC2E45317251723B3D155E47B41")

    private int     m_state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.305 -0400", hash_original_field = "0574C54064DCE664A6B9A631BC5AFFCE", hash_generated_field = "FB651BF8F1E071C4F86EDB4C928E5142")

    private String  m_tokens;


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.306 -0400", hash_original_method = "584B65226EB184F0EF86784424553AF5", hash_generated_method = "584B65226EB184F0EF86784424553AF5")
    
TokenParser(
        String tokens)
    {
        m_tokens = tokens;
        m_curPos = 0;
        m_scanStart = 0;
        m_state =  STATE_LOOKING_FOR_FIRST_TOKEN;
    }

    /**
     * This function parses the next token from the tokens string and returns
     * it as a string. If there are no more tokens a null reference is returned.
     *
     * @return  the parsed token or a null reference if there are no more
     * tokens
     *
     * @exception  SASLException if an error occurs while parsing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.307 -0400", hash_original_method = "D22A8775F93D73C17BDF3BF09F23B3C9", hash_generated_method = "08B7A9770FF616867305B5D01AD15C1C")
    
String parseToken() throws SaslException
    {
        char    currChar;
        String  token = null;


        if (m_state == STATE_DONE)
            return null;

        while (m_curPos < m_tokens.length() && (token == null))
        {
            currChar = m_tokens.charAt(m_curPos);
            switch (m_state)
            {
            case STATE_LOOKING_FOR_FIRST_TOKEN:
            case STATE_LOOKING_FOR_TOKEN:
                if (isWhiteSpace(currChar))
                {
                    break;
                }
                else if (isValidTokenChar(currChar))
                {
                    m_scanStart = m_curPos;
                    m_state = STATE_SCANNING_TOKEN;
                }
                else
                {
                    m_state = STATE_PARSING_ERROR;
                    throw new SaslException("Invalid token character at position " + m_curPos);
                }
                break;

            case STATE_SCANNING_TOKEN:
                if (isValidTokenChar(currChar))
                {
                    break;
                }
                else if (isWhiteSpace(currChar))
                {
                    token = m_tokens.substring(m_scanStart, m_curPos);
                    m_state = STATE_LOOKING_FOR_COMMA;
                }
                else if (',' == currChar)
                {
                    token = m_tokens.substring(m_scanStart, m_curPos);
                    m_state = STATE_LOOKING_FOR_TOKEN;
                }
                else
                {
                    m_state = STATE_PARSING_ERROR;
                    throw new SaslException("Invalid token character at position " + m_curPos);
                }
                break;


            case STATE_LOOKING_FOR_COMMA:
                if (isWhiteSpace(currChar))
                    break;
                else if (currChar == ',')
                    m_state = STATE_LOOKING_FOR_TOKEN;
                else
                {
                    m_state = STATE_PARSING_ERROR;
                    throw new SaslException("Expected a comma, found '" +
                                            currChar + "' at postion " +
                                            m_curPos);
                }
                break;
            }
            m_curPos++;
        } /* end while loop */

        if (token == null)
        {    /* check the ending state */
            switch (m_state)
            {
            case STATE_SCANNING_TOKEN:
                token = m_tokens.substring(m_scanStart);
                m_state = STATE_DONE;
                break;

            case STATE_LOOKING_FOR_FIRST_TOKEN:
            case STATE_LOOKING_FOR_COMMA:
                break;

            case STATE_LOOKING_FOR_TOKEN:
                throw new SaslException("Trialing comma");
            }
        }

        return token;
    }

    /**
     * This function returns TRUE if the character is a valid token character.
     *
     *     token          = 1*<any CHAR except CTLs or separators>
     *
     *      separators     = "(" | ")" | "<" | ">" | "@"
     *                     | "," | ";" | ":" | "\" | <">
     *                     | "/" | "[" | "]" | "?" | "="
     *                     | "{" | "}" | SP | HT
     *
     *      CTL            = <any US-ASCII control character
     *                       (octets 0 - 31) and DEL (127)>
     *
     *      CHAR           = <any US-ASCII character (octets 0 - 127)>
     *
     * @param c  character to be validated
     *
     * @return True if character is valid Token character else it returns 
     * false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.307 -0400", hash_original_method = "766EA6F313F99A7CA24F215077B7B1EB", hash_generated_method = "766EA6F313F99A7CA24F215077B7B1EB")
    
boolean isValidTokenChar(
        char c)
    {
        if ( ( (c >= '\u0000') && (c <='\u0020') ) ||
             ( (c >= '\u003a') && (c <= '\u0040') ) ||
             ( (c >= '\u005b') && (c <= '\u005d') ) ||
             ('\u002c' == c) ||
             ('\u0025' == c) ||
             ('\u0028' == c) ||
             ('\u0029' == c) ||
             ('\u007b' == c) ||
             ('\u007d' == c) ||
             ('\u007f' == c) )
            return false;

        return true;
    }

    /**
     * This function returns TRUE if the character is linear white space (LWS).
     *         LWS = [CRLF] 1*( SP | HT )
     *
     * @param c  character to be validated
     *
     * @return True if character is liner whitespace else it returns false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.308 -0400", hash_original_method = "2CA40CF84E3F91F9DEE97B01BD037D11", hash_generated_method = "B76FA6807697DC48B463878C7F5CD84F")
    
boolean isWhiteSpace(
        char c)
    {
        if ( ('\t' == c) || // HORIZONTAL TABULATION.
             ('\n' == c) || // LINE FEED.
             ('\r' == c) || // CARRIAGE RETURN.
             ('\u0020' == c) )
            return true;

        return false;
    }

}

