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
 * $OpenLDAP: /com/novell/sasl/client/DirectiveList.java,v 1.4 2005/01/17 15:00:54 sunilk Exp $
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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.novell.sasl.client;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.*;
import org.apache.harmony.javax.security.sasl.*;
import java.io.UnsupportedEncodingException;

/**
 * Implements the DirectiveList class whihc will be used by the 
 * DigestMD5SaslClient class
 */
class DirectiveList extends Object
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.395 -0400", hash_original_field = "03E25BEA0C5384AE719D96BCAB5F1B52", hash_generated_field = "F76004D88BA9A7952FC8B0CB8605A37D")

    private static final int STATE_LOOKING_FOR_FIRST_DIRECTIVE  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.396 -0400", hash_original_field = "222D3E0E574A992F910D274FD9DACB51", hash_generated_field = "F081FFC0B6D53B8CCE4AD1D2F4EC5A7B")

    private static final int STATE_LOOKING_FOR_DIRECTIVE        = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.396 -0400", hash_original_field = "A9065CC9231D4D0D1BF8937A08DFEE9B", hash_generated_field = "9622C72282DBEB223CC38C8DB0387F27")

    private static final int STATE_SCANNING_NAME                = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.396 -0400", hash_original_field = "88EC4FEFBE3B0ABC7AEFF8306F52253D", hash_generated_field = "A4CB3565E35CF96C6514FA18A08CC5FC")

    private static final int STATE_LOOKING_FOR_EQUALS            = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.397 -0400", hash_original_field = "042BFFC79BDBAD62F1BB575268806096", hash_generated_field = "047948E1B9114C43BB675FDF70C35AAD")

    private static final int STATE_LOOKING_FOR_VALUE            = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.397 -0400", hash_original_field = "7D91F7B04B6C51035691384797125C2D", hash_generated_field = "96DBC0C561753F0901F4EC76E2EA6947")

    private static final int STATE_LOOKING_FOR_COMMA            = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.397 -0400", hash_original_field = "D18A1F5A27D26AF21D87BBB9B48CA88A", hash_generated_field = "F38BC6A466A84BC4CEC993CCF852093C")

    private static final int STATE_SCANNING_QUOTED_STRING_VALUE    = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.398 -0400", hash_original_field = "76A2D00CB9C1180B8130135EF00F65C6", hash_generated_field = "E2EA037F8BEA7AF8F6B283F815627281")

    private static final int STATE_SCANNING_TOKEN_VALUE            = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.398 -0400", hash_original_field = "06DDF6C9854771A8786119A96AEF8D9D", hash_generated_field = "096A9D18CED584AF13EEC9B2E249D0A5")

    private static final int STATE_NO_UTF8_SUPPORT              = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.399 -0400", hash_original_field = "4E7E9E66EFE2A1D672E2A3D6C3739E6C", hash_generated_field = "DF335CC9A9A4F49795664736E809700F")


    private int        m_curPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.399 -0400", hash_original_field = "414AEACB66A377F46C760E56F4EA355B", hash_generated_field = "87AD831687C85D0E76A9B44F6085B3AE")

    private int        m_errorPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.400 -0400", hash_original_field = "352C669F7B80174ABEA64E9A1D841861", hash_generated_field = "BE0944EB903659DF31EE97BFB0B07846")

    private String     m_directives;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.400 -0400", hash_original_field = "D01CAE2C152521D735FF4BEDA177DA34", hash_generated_field = "7C0FADC2E45317251723B3D155E47B41")

    private int        m_state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.400 -0400", hash_original_field = "58089BB955B540A1DD6C5C25855FA039", hash_generated_field = "D35D26E6123A70A7A27A2E183220412B")

    private ArrayList  m_directiveList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.401 -0400", hash_original_field = "A22D9A104757D3C731EF03E62C437E95", hash_generated_field = "A9012B439B8C9E12C195DF598FCBD2C3")

    private String     m_curName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.401 -0400", hash_original_field = "053E05000DDCEB31DF6544D90ED49DFA", hash_generated_field = "CA707FD05D7E6C294081338DE4D33980")

    private int        m_scanStart;

    /**
     *  Constructs a new DirectiveList.
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.402 -0400", hash_original_method = "B55FC7CF4E0F303FAA191B93D3A00366", hash_generated_method = "B55FC7CF4E0F303FAA191B93D3A00366")
    
DirectiveList(
        byte[] directives)
    {
        m_curPos = 0;
        m_state = STATE_LOOKING_FOR_FIRST_DIRECTIVE;
        m_directiveList = new ArrayList(10);
        m_scanStart = 0;
        m_errorPos = -1;
        try
        {
            m_directives = new String(directives, "UTF-8");
        }
        catch(UnsupportedEncodingException e)
        {
            m_state = STATE_NO_UTF8_SUPPORT;
        }
    }

    /**
     * This function takes a US-ASCII character string containing a list of comma
     * separated directives, and parses the string into the individual directives
     * and their values. A directive consists of a token specifying the directive
     * name followed by an equal sign (=) and the directive value. The value is
     * either a token or a quoted string
     *
     * @exception SaslException  If an error Occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.404 -0400", hash_original_method = "C1DAA8A1CE7EAD292D96D0E0AC7B4475", hash_generated_method = "8DBEEEA0DE0417A5E8CF3806B098982C")
    
void parseDirectives() throws SaslException
    {
        char        prevChar;
        char        currChar;
        int            rc = 0;
        boolean        haveQuotedPair = false;
        String      currentName = "<no name>";

        if (m_state == STATE_NO_UTF8_SUPPORT)
            throw new SaslException("No UTF-8 support on platform");

        prevChar = 0;

        while (m_curPos < m_directives.length())
        {
            currChar = m_directives.charAt(m_curPos);
            switch (m_state)
            {
            case STATE_LOOKING_FOR_FIRST_DIRECTIVE:
            case STATE_LOOKING_FOR_DIRECTIVE:
                if (isWhiteSpace(currChar))
                {
                    break;
                }
                else if (isValidTokenChar(currChar))
                {
                    m_scanStart = m_curPos;
                    m_state = STATE_SCANNING_NAME;
                }
                else
                {
                     m_errorPos = m_curPos;
                    throw new SaslException("Parse error: Invalid name character");
                }
                break;

            case STATE_SCANNING_NAME:
                if (isValidTokenChar(currChar))
                {
                    break;
                }
                else if (isWhiteSpace(currChar))
                {
                    currentName = m_directives.substring(m_scanStart, m_curPos);
                    m_state = STATE_LOOKING_FOR_EQUALS;
                }
                else if ('=' == currChar)
                {
                    currentName = m_directives.substring(m_scanStart, m_curPos);
                    m_state = STATE_LOOKING_FOR_VALUE;
                }
                else
                {
                     m_errorPos = m_curPos;
                    throw new SaslException("Parse error: Invalid name character");
                }
                break;

            case STATE_LOOKING_FOR_EQUALS:
                if (isWhiteSpace(currChar))
                {
                    break;
                }
                else if ('=' == currChar)
                {
                    m_state = STATE_LOOKING_FOR_VALUE;
                }
                else
                {
                    m_errorPos = m_curPos;
                    throw new SaslException("Parse error: Expected equals sign '='.");
                }
                break;

            case STATE_LOOKING_FOR_VALUE:
                if (isWhiteSpace(currChar))
                {
                    break;
                }
                else if ('"' == currChar)
                {
                    m_scanStart = m_curPos+1; /* don't include the quote */
                    m_state = STATE_SCANNING_QUOTED_STRING_VALUE;
                }
                else if (isValidTokenChar(currChar))
                {
                    m_scanStart = m_curPos;
                    m_state = STATE_SCANNING_TOKEN_VALUE;
                }
                else
                {
                    m_errorPos = m_curPos;
                    throw new SaslException("Parse error: Unexpected character");
                }
                break;

            case STATE_SCANNING_TOKEN_VALUE:
                if (isValidTokenChar(currChar))
                {
                    break;
                }
                else if (isWhiteSpace(currChar))
                {
                    addDirective(currentName, false);
                    m_state = STATE_LOOKING_FOR_COMMA;
                }
                else if (',' == currChar)
                {
                    addDirective(currentName, false);
                    m_state = STATE_LOOKING_FOR_DIRECTIVE;
                }
                else
                {
                     m_errorPos = m_curPos;
                    throw new SaslException("Parse error: Invalid value character");
                }
                break;

            case STATE_SCANNING_QUOTED_STRING_VALUE:
                if ('\\' == currChar)
                    haveQuotedPair = true;
                if ( ('"' == currChar) &&
                     ('\\' != prevChar) )
                {
                    addDirective(currentName, haveQuotedPair);
                    haveQuotedPair = false;
                    m_state = STATE_LOOKING_FOR_COMMA;
                }
                break;

            case STATE_LOOKING_FOR_COMMA:
                if (isWhiteSpace(currChar))
                    break;
                else if (currChar == ',')
                    m_state = STATE_LOOKING_FOR_DIRECTIVE;
                else
                {
                    m_errorPos = m_curPos;
                    throw new SaslException("Parse error: Expected a comma.");
                }
                break;
            }
            if (0 != rc)
                break;
            prevChar = currChar;
            m_curPos++;
        } /* end while loop */


        if (rc == 0)
        {
            /* check the ending state */
            switch (m_state)
            {
            case STATE_SCANNING_TOKEN_VALUE:
                addDirective(currentName, false);
                break;

            case STATE_LOOKING_FOR_FIRST_DIRECTIVE:
            case STATE_LOOKING_FOR_COMMA:
                break;

            case STATE_LOOKING_FOR_DIRECTIVE:
                    throw new SaslException("Parse error: Trailing comma.");

            case STATE_SCANNING_NAME:
            case STATE_LOOKING_FOR_EQUALS:
            case STATE_LOOKING_FOR_VALUE:
                    throw new SaslException("Parse error: Missing value.");

            case STATE_SCANNING_QUOTED_STRING_VALUE:
                    throw new SaslException("Parse error: Missing closing quote.");
            }
        }

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
     * @param c  character to be tested
     *
     * @return Returns TRUE if the character is a valid token character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.404 -0400", hash_original_method = "766EA6F313F99A7CA24F215077B7B1EB", hash_generated_method = "766EA6F313F99A7CA24F215077B7B1EB")
    
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
     * @param c  Input charcter to be tested
     *
     * @return Returns TRUE if the character is linear white space (LWS)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.405 -0400", hash_original_method = "2CA40CF84E3F91F9DEE97B01BD037D11", hash_generated_method = "B76FA6807697DC48B463878C7F5CD84F")
    
boolean isWhiteSpace(
        char c)
    {
        if ( ('\t' == c) ||  // HORIZONTAL TABULATION.
             ('\n' == c) ||  // LINE FEED.
             ('\r' == c) ||  // CARRIAGE RETURN.
             ('\u0020' == c) )
            return true;

        return false;
    }

    /**
     * This function creates a directive record and adds it to the list, the
     * value will be added later after it is parsed.
     *
     * @param name  Name
     * @param haveQuotedPair true if quoted pair is there else false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.406 -0400", hash_original_method = "266E87F8A828CDA30627CAA7433FF646", hash_generated_method = "CE03EAF7EDFB05F294B401E410CDC667")
    
void addDirective(
        String    name,
        boolean   haveQuotedPair)
    {
        String value;
        int    inputIndex;
        int    valueIndex;
        char   valueChar;
        int    type;

        if (!haveQuotedPair)
        {
            value = m_directives.substring(m_scanStart, m_curPos);
        }
        else
        { //copy one character at a time skipping backslash excapes.
            StringBuffer valueBuf = new StringBuffer(m_curPos - m_scanStart);
            valueIndex = 0;
            inputIndex = m_scanStart;
            while (inputIndex < m_curPos)
            {
                if ('\\' == (valueChar = m_directives.charAt(inputIndex)))
                    inputIndex++;
                valueBuf.setCharAt(valueIndex, m_directives.charAt(inputIndex));
                valueIndex++;
                inputIndex++;
            }
            value = new String(valueBuf);
        }

        if (m_state == STATE_SCANNING_QUOTED_STRING_VALUE)
            type = ParsedDirective.QUOTED_STRING_VALUE;
        else
            type = ParsedDirective.TOKEN_VALUE;
        m_directiveList.add(new ParsedDirective(name, value, type));
    }


    /**
     * Returns the List iterator.
     *
     * @return     Returns the Iterator Object for the List.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.406 -0400", hash_original_method = "C1A23D08EF654713F298E7271002D3F0", hash_generated_method = "C1A23D08EF654713F298E7271002D3F0")
    
Iterator getIterator()
    {
        return m_directiveList.iterator();
    }
}

