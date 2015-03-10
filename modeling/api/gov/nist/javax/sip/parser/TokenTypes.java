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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.LexerCore;

public interface TokenTypes {

    public static final int START = LexerCore.START;
    
    public static final int END = LexerCore.END;
    

    public static final int SIP = START + 3;
    public static final int REGISTER = START + 4;
    public static final int INVITE = START + 5;
    public static final int ACK = START + 6;
    public static final int BYE = START + 7;
    public static final int OPTIONS = START + 8;
    public static final int CANCEL = START + 9;
    public static final int ERROR_INFO = START + 10;
    public static final int IN_REPLY_TO = START + 11;
    public static final int MIME_VERSION = START + 12;
    public static final int ALERT_INFO = START + 13;
    public static final int FROM = START + 14;
    public static final int TO = START + 15;
    public static final int VIA = START + 16;
    public static final int USER_AGENT = START + 17;
    public static final int SERVER = START + 18;
    public static final int ACCEPT_ENCODING = START + 19;
    public static final int ACCEPT = START + 20;
    public static final int ALLOW = START + 21;
    public static final int ROUTE = START + 22;
    public static final int AUTHORIZATION = START + 23;
    public static final int PROXY_AUTHORIZATION = START + 24;
    public static final int RETRY_AFTER = START + 25;
    public static final int PROXY_REQUIRE = START + 26;
    public static final int CONTENT_LANGUAGE = START + 27;
    public static final int UNSUPPORTED = START + 28;
    public static final int SUPPORTED = START + 20;
    public static final int WARNING = START + 30;
    public static final int MAX_FORWARDS = START + 31;
    public static final int DATE = START + 32;
    public static final int PRIORITY = START + 33;
    public static final int PROXY_AUTHENTICATE = START + 34;
    public static final int CONTENT_ENCODING = START + 35;
    public static final int CONTENT_LENGTH = START + 36;
    public static final int SUBJECT = START + 37;
    public static final int CONTENT_TYPE = START + 38;
    public static final int CONTACT = START + 39;
    public static final int CALL_ID = START + 40;
    public static final int REQUIRE = START + 41;
    public static final int EXPIRES = START + 42;
    public static final int ENCRYPTION = START + 43;
    public static final int RECORD_ROUTE = START + 44;
    public static final int ORGANIZATION = START + 45;
    public static final int CSEQ = START + 46;
    public static final int ACCEPT_LANGUAGE = START + 47;
    public static final int WWW_AUTHENTICATE = START + 48;
    public static final int RESPONSE_KEY = START + 49;
    public static final int HIDE = START + 50;
    public static final int CALL_INFO = START + 51;
    public static final int CONTENT_DISPOSITION = START + 52;
    public static final int SUBSCRIBE = START + 53;
    public static final int NOTIFY = START + 54;
    public static final int TIMESTAMP = START + 55;
    public static final int SUBSCRIPTION_STATE = START + 56;
    public static final int TEL = START + 57;
    public static final int REPLY_TO = START + 58;
    public static final int REASON = START + 59;
    public static final int RSEQ = START + 60;
    public static final int RACK = START + 61;
    public static final int MIN_EXPIRES = START + 62;
    public static final int EVENT = START + 63;
    public static final int AUTHENTICATION_INFO = START + 64;
    public static final int ALLOW_EVENTS = START + 65;
    public static final int REFER_TO = START + 66;

    
    public static final int PUBLISH = START + 67;
    public static final int SIP_ETAG = START + 68;
    public static final int SIP_IF_MATCH = START + 69;




    public static final int MESSAGE = START + 70;

    
    public static final int PATH = START + 71;
    public static final int SERVICE_ROUTE = START + 72;
    public static final int P_ASSERTED_IDENTITY = START + 73;
    public static final int P_PREFERRED_IDENTITY = START + 74;
    public static final int P_VISITED_NETWORK_ID = START + 75;
    public static final int P_CHARGING_FUNCTION_ADDRESSES = START + 76;
    public static final int P_VECTOR_CHARGING = START + 77;



    
    public static final int PRIVACY = START + 78;
    public static final int P_ACCESS_NETWORK_INFO = START + 79;
    public static final int P_CALLED_PARTY_ID = START + 80;
    public static final int P_ASSOCIATED_URI = START + 81;
    public static final int P_MEDIA_AUTHORIZATION = START + 82;
    public static final int P_MEDIA_AUTHORIZATION_TOKEN = START + 83;


    
    public static final int REFERREDBY_TO = START + 84;

    
    public static final int SESSIONEXPIRES_TO = START + 85;
    public static final int MINSE_TO = START + 86;

    
    public static final int REPLACES_TO = START + 87;

    
    public static final int SIPS = START + 88;


    
    public static final int SECURITY_SERVER = START + 89;
    public static final int SECURITY_CLIENT = START + 90;
    public static final int SECURITY_VERIFY = START + 91;

    
    public static final int JOIN_TO = START + 92;

    
    public static final int P_USER_DATABASE = START + 93;
    
    public static final int P_PROFILE_KEY = START + 94;
    
    public static final int P_SERVED_USER = START + 95;
    
    public static final int P_PREFERRED_SERVICE = START + 96;
    
    public static final int P_ASSERTED_SERVICE = START + 97;
    
    public static final int REFERENCES = START + 98;

    public static final int ALPHA = LexerCore.ALPHA;
    public static final int DIGIT = LexerCore.DIGIT;
    public static final int ID = LexerCore.ID;
    public static final int WHITESPACE = LexerCore.WHITESPACE;
    public static final int BACKSLASH = LexerCore.BACKSLASH;
    public static final int QUOTE = LexerCore.QUOTE;
    public static final int AT = LexerCore.AT;
    public static final int SP = LexerCore.SP;
    public static final int HT = LexerCore.HT;
    public static final int COLON = LexerCore.COLON;
    public static final int STAR = LexerCore.STAR;
    public static final int DOLLAR = LexerCore.DOLLAR;
    public static final int PLUS = LexerCore.PLUS;
    public static final int POUND = LexerCore.POUND;
    public static final int MINUS = LexerCore.MINUS;
    public static final int DOUBLEQUOTE = LexerCore.DOUBLEQUOTE;
    public static final int TILDE = LexerCore.TILDE;
    public static final int BACK_QUOTE = LexerCore.BACK_QUOTE;
    public static final int NULL = LexerCore.NULL;
    public static final int EQUALS = (int) '=';
    public static final int SEMICOLON = (int) ';';
    public static final int SLASH = (int) '/';
    public static final int L_SQUARE_BRACKET = (int) '[';
    public static final int R_SQUARE_BRACKET = (int) ']';
    public static final int R_CURLY = (int) '}';
    public static final int L_CURLY = (int) '{';
    public static final int HAT = (int) '^';
    public static final int BAR = (int) '|';
    public static final int DOT = (int) '.';
    public static final int EXCLAMATION = (int) '!';
    public static final int LPAREN = (int) '(';
    public static final int RPAREN = (int) ')';
    public static final int GREATER_THAN = (int) '>';
    public static final int LESS_THAN = (int) '<';
    public static final int PERCENT = (int) '%';
    public static final int QUESTION = (int) '?';
    public static final int AND = (int) '&';
    public static final int UNDERSCORE = (int) '_';

}
