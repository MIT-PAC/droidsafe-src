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
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.net.telnet;

/***
 * The TelnetOption class cannot be instantiated and only serves as a
 * storehouse for telnet option constants.
 * <p>
 * Details regarding Telnet option specification can be found in RFC 855.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see org.apache.commons.net.telnet.Telnet
 * @see org.apache.commons.net.telnet.TelnetClient
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class TelnetOption
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.290 -0500", hash_original_field = "6F8B970707D3E5BE358BA57F7D2A13B0", hash_generated_field = "628D03ABEB6010EF1C7AB25486A420A7")

    public static final int MAX_OPTION_VALUE = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.294 -0500", hash_original_field = "8B3E70FF2D570D8773F24581A15390F3", hash_generated_field = "067BA51015C315D071C70B5465D1CEFF")

    public static int BINARY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.300 -0500", hash_original_field = "577450D265091D4E598E2CAA77A5E18C", hash_generated_field = "B84AE6A4BE195121A5F79A137464D78E")

    public static int ECHO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.305 -0500", hash_original_field = "69DFD1C3BF4284EE6469DFAFE1D705DE", hash_generated_field = "0169FCE67A75CE415F56531AF930C354")

    public static int PREPARE_TO_RECONNECT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.310 -0500", hash_original_field = "9125AA76171653A035DF2361D268C74A", hash_generated_field = "2F34C6DF9F706D6D20E43253E758E40B")

    public static int SUPPRESS_GO_AHEAD = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.315 -0500", hash_original_field = "941DFC551B4C3F18EB314F36A8836EAB", hash_generated_field = "3ECF4F7785BE973F584B25A0D4CB42A3")

    public static int APPROXIMATE_MESSAGE_SIZE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.319 -0500", hash_original_field = "18C36067CDD02E3AB95B5403A8AD4563", hash_generated_field = "63C7BC04E01B8A122670B58DFF47479E")

    public static int STATUS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.325 -0500", hash_original_field = "7F8AC4359B4166EBACC3AA2361472107", hash_generated_field = "C508FC61C68235D1CDC62B33FC62A5D5")

    public static int TIMING_MARK = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.330 -0500", hash_original_field = "A499A9B57E576870A071C53EB42B0694", hash_generated_field = "EA15F2B8B3695C62F06EDB6722B921C2")

    public static int REMOTE_CONTROLLED_TRANSMISSION = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.335 -0500", hash_original_field = "75B0C2750E97F55977185FE365C44DC5", hash_generated_field = "7289D17ADE1BBD8825F9D2C9DA76289E")

    public static int NEGOTIATE_OUTPUT_LINE_WIDTH = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.339 -0500", hash_original_field = "488D0241E1C35C86AB91059C796DA358", hash_generated_field = "BBF85CAF71D1FD5FFC33A122A81CFAF8")

    public static int NEGOTIATE_OUTPUT_PAGE_SIZE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.350 -0500", hash_original_field = "918B30706E0E311CE7201A28F9330C15", hash_generated_field = "8D78A6E8F94F1F0702DB49B54B74B8EB")

    public static int NEGOTIATE_CARRIAGE_RETURN = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.355 -0500", hash_original_field = "99A6B9C70AFF47717C98F1517CE0AACE", hash_generated_field = "0288A1BDCFB0B0D7FC0FCE74C6BAFF7B")

    public static int NEGOTIATE_HORIZONTAL_TAB_STOP = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.359 -0500", hash_original_field = "90F46AFDE594A33A15A349EB006E14C9", hash_generated_field = "B05200B5451BF1407E9604050D11DDAC")

    public static int NEGOTIATE_HORIZONTAL_TAB = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.365 -0500", hash_original_field = "36AEFAC5A97F8F3FBA65AA22EF62316C", hash_generated_field = "097B38227E3105BDA8101704F216DAD9")

    public static int NEGOTIATE_FORMFEED = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.369 -0500", hash_original_field = "FCEAF502475B74D03D34F17D62EF8F98", hash_generated_field = "8AB65BF26A056CF0DE4723CAC1CA2FB9")

    public static int NEGOTIATE_VERTICAL_TAB_STOP = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.374 -0500", hash_original_field = "61104325D72FAFE844246653EDD32471", hash_generated_field = "C83526F1DC93F367B243133A7A48684E")

    public static int NEGOTIATE_VERTICAL_TAB = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.379 -0500", hash_original_field = "DB0756C1BFC27A05C5DF263B08077EEC", hash_generated_field = "7881FD9E87652DE64D282D11FA636710")

    public static int NEGOTIATE_LINEFEED = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.384 -0500", hash_original_field = "D12B1FFFB24CC2AC59F68BC5A5E353F8", hash_generated_field = "95EEA9B39E873CCE1413FB832217A742")

    public static int EXTENDED_ASCII = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.389 -0500", hash_original_field = "00153CBD1E9410591E47AAACB2ACB61D", hash_generated_field = "38858EA8F902322BE8F12A42B9F64722")

    public static int FORCE_LOGOUT = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.394 -0500", hash_original_field = "5C33276C5B58E29B6F08FB7EB1330FC8", hash_generated_field = "ADA492C4702435EAA19A7B6655C00441")

    public static int BYTE_MACRO = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.399 -0500", hash_original_field = "A26700B5416AF81826813F71364CD2CE", hash_generated_field = "5DA7CE453A5CED45149A9AF685F57E0E")

    public static int DATA_ENTRY_TERMINAL = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.404 -0500", hash_original_field = "B1A955A1F628D97E292087DAE103FFD2", hash_generated_field = "513DD3ABC357994866230968D95F7D9B")

    public static int SUPDUP = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.408 -0500", hash_original_field = "872529C54CA13935B01134B4C2A0409A", hash_generated_field = "657505ED8F8AB6225F6A0E2EBB3DFB49")

    public static int SUPDUP_OUTPUT = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.414 -0500", hash_original_field = "4B473967363419E066C66CF2AD3FFAE9", hash_generated_field = "1272AD6D4CCEB8AEA0B73948D3782E99")

    public static int SEND_LOCATION = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.418 -0500", hash_original_field = "5BF2E6521F87CF5738C74E2A6D189DC7", hash_generated_field = "6F5A1494E6924A5C29A25AABDC853835")

    public static int TERMINAL_TYPE = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.423 -0500", hash_original_field = "3050350E5AB3CEB14FBE0844B998AE26", hash_generated_field = "1F182E79E13CD6BFFFC2174166E98F2F")

    public static int END_OF_RECORD = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.428 -0500", hash_original_field = "EB103FF63F73A722306FCCB1AC477552", hash_generated_field = "5C6CB1AFC4672BCF1ECB1E7ECBE131DC")

    public static int TACACS_USER_IDENTIFICATION = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.439 -0500", hash_original_field = "D757B0956B5D120B97DD0078BE98CF44", hash_generated_field = "07F549995F56F7059F31AC871A11C8D4")

    public static int OUTPUT_MARKING = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.444 -0500", hash_original_field = "6CC5748047BE41A1F380D5292C4C50C2", hash_generated_field = "69457F4500EBC378985022FCC49A7653")

    public static int TERMINAL_LOCATION_NUMBER = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.449 -0500", hash_original_field = "EFFD38C6AB1D220F0C7DA8BB8F6CF923", hash_generated_field = "045058F5D350696A65C437AAF4D8DA74")

    public static int REGIME_3270 = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.453 -0500", hash_original_field = "35DB2343A8FEE6528C7943B4F1EF798E", hash_generated_field = "C69975D59EE022D9ECB8CFA7C5E7370E")

    public static int X3_PAD = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.458 -0500", hash_original_field = "F3E219B287B673F3A2D68DD3B62B297C", hash_generated_field = "5078B6607A60B9512A1C8F51FE6D83C9")

    public static int WINDOW_SIZE = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.463 -0500", hash_original_field = "7F453C866175D45A46E90AE79105D3ED", hash_generated_field = "3394642DDE6AD6693B5D37CDF15D4DBC")

    public static int TERMINAL_SPEED = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.468 -0500", hash_original_field = "C5DEAA8236E73DD8C336E488CD9DE41C", hash_generated_field = "3E161CBF56A808C57E0CE29E91CCF08F")

    public static int REMOTE_FLOW_CONTROL = 33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.473 -0500", hash_original_field = "7FD43C0EBD72CE182F055940EB9EB80A", hash_generated_field = "B1F0D7CFE803C6B63DF3A636A0DB2C32")

    public static int LINEMODE = 34;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.478 -0500", hash_original_field = "C3DF0F26C860164E3DD082D71D77A7CE", hash_generated_field = "C303BD62E81861C5730BD5A325391166")

    public static int X_DISPLAY_LOCATION = 35;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.483 -0500", hash_original_field = "AFB809C75598C9E68DDA28AA94E9D31F", hash_generated_field = "D9FBBE1A0DEC31B662AFFA16E27FE2C5")

    public static int OLD_ENVIRONMENT_VARIABLES = 36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.488 -0500", hash_original_field = "944871D6F6C757C2ED24DAC4AF5A4120", hash_generated_field = "B3F1891857EBD526270BA140DAB77BD2")

    public static int AUTHENTICATION = 37;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.493 -0500", hash_original_field = "E59E4C5957794FCEC9932748E10D1076", hash_generated_field = "935A50AFC9DCEE69A1950B08CBA78B6D")

    public static int ENCRYPTION = 38;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.498 -0500", hash_original_field = "D3A7886FFB32569E2EA582A6B9704705", hash_generated_field = "9439894C957AC8C12C18C2051ED502E6")

    public static int NEW_ENVIRONMENT_VARIABLES = 39;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.502 -0500", hash_original_field = "2F1673A5B78EDFAA7A82E9CF3544F11B", hash_generated_field = "FBF030CE50F826CF6B78C5632746C441")

    public static int EXTENDED_OPTIONS_LIST = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.507 -0500", hash_original_field = "7BD3B9D78E92D95B9D0391D091BC19B0", hash_generated_field = "DBDBE7DC2BE8D5D31D673541F48247BB")

    private static int __FIRST_OPTION = BINARY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.512 -0500", hash_original_field = "8C1F48FC99D8FCD59B0D2410FBBA6737", hash_generated_field = "1937DE556FBE1E211E48F6A58347988A")

    private static int __LAST_OPTION = EXTENDED_OPTIONS_LIST;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.526 -0500", hash_original_field = "6820EDED14ABEE88CB437CDC5D1B0EF7", hash_generated_field = "C07DE8E5921F316DE5D1859FDC4842D6")

    private static final String __optionString[] = {
                "BINARY", "ECHO", "RCP", "SUPPRESS GO AHEAD", "NAME", "STATUS",
                "TIMING MARK", "RCTE", "NAOL", "NAOP", "NAOCRD", "NAOHTS", "NAOHTD",
                "NAOFFD", "NAOVTS", "NAOVTD", "NAOLFD", "EXTEND ASCII", "LOGOUT",
                "BYTE MACRO", "DATA ENTRY TERMINAL", "SUPDUP", "SUPDUP OUTPUT",
                "SEND LOCATION", "TERMINAL TYPE", "END OF RECORD", "TACACS UID",
                "OUTPUT MARKING", "TTYLOC", "3270 REGIME", "X.3 PAD", "NAWS", "TSPEED",
                "LFLOW", "LINEMODE", "XDISPLOC", "OLD-ENVIRON", "AUTHENTICATION",
                "ENCRYPT", "NEW-ENVIRON", "TN3270E", "XAUTH", "CHARSET", "RSP",
                "Com Port Control", "Suppress Local Echo", "Start TLS",
                "KERMIT", "SEND-URL", "FORWARD_X", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "TELOPT PRAGMA LOGON", "TELOPT SSPI LOGON",
                "TELOPT PRAGMA HEARTBEAT", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "Extended-Options-List"
            };

    /***
     * Returns the string representation of the telnet protocol option
     * corresponding to the given option code.
     * <p>
     * @param code The option code of the telnet protocol option
     * @return The string representation of the telnet protocol option.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.532 -0500", hash_original_method = "CC23FA6B3245BE9853FCA6B6A83F8AD5", hash_generated_method = "DF2DAB1B4C0DD98E1791781D84014935")
    
public static final String getOption(int code)
    {
        if(__optionString[code].length() == 0)
        {
            return "UNASSIGNED";
        }
        else
        {
            return __optionString[code];
        }
    }

    /***
     * Determines if a given option code is valid.  Returns true if valid,
     * false if not.
     * <p>
     * @param code  The option code to test.
     * @return True if the option code is valid, false if not.
     **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.536 -0500", hash_original_method = "A7C439783215BA4035222C170E44FE0D", hash_generated_method = "37790595F75A1C65F45522ADC50E4A90")
    
public static final boolean isValidOption(int code)
    {
        return (code <= __LAST_OPTION);
    }

    // Cannot be instantiated
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.541 -0500", hash_original_method = "F7A24102E788A3AB96BADE10DEFF8EC0", hash_generated_method = "3E36167F189841A78AA7E4789BD8E158")
    
private TelnetOption()
    { }
}
