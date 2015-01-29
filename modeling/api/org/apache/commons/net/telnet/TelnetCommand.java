/*
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
package org.apache.commons.net.telnet;

/**
 * The TelnetCommand class cannot be instantiated and only serves as a
 * storehouse for telnet command constants.
 * @author Daniel F. Savarese
 * @see org.apache.commons.net.telnet.Telnet
 * @see org.apache.commons.net.telnet.TelnetClient
 */

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class TelnetCommand
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.981 -0500", hash_original_field = "FD61378024C25E1E2D0C578BA8C00ED8", hash_generated_field = "7FCD318A6A85FAEF21482A951C3D577E")

    public static final int MAX_COMMAND_VALUE = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.985 -0500", hash_original_field = "3F818C67E0BB7257E6DB63D35C29370F", hash_generated_field = "3B065AC11D582CF36E5B2F05B576BE42")

    public static final int IAC = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.989 -0500", hash_original_field = "6A1047E28BEBEDDE376A0344E921E8B9", hash_generated_field = "B0E1E707990864E739997BD58E9D3FC8")

    public static final int DONT = 254;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.996 -0500", hash_original_field = "C19A7652D320C215B49525482186BA4D", hash_generated_field = "B0F89DA6EF9E19AEB7D5B5532F9215D6")

    public static final int DO = 253;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.000 -0500", hash_original_field = "7872B108C9802C617F458296FBEA157F", hash_generated_field = "77ABD515E5AC3BAC17A65AB1333BB252")

    public static final int WONT = 252;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.005 -0500", hash_original_field = "2BF9A680BC8474B86E5C31C00A1D2F6E", hash_generated_field = "C2A427A24D82F92A1CFB7F4A410A77B7")

    public static final int WILL = 251;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.009 -0500", hash_original_field = "7C2911C87E9E49C858BA64319827BEE3", hash_generated_field = "3D44779D2A8A79D5139ABF850B29E731")

    public static final int SB = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.013 -0500", hash_original_field = "0301F3176E1C667E1DCBBB2C4B2D9296", hash_generated_field = "06CF2D1F947645E154058D62E7FBBCA6")

    public static final int GA = 249;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.017 -0500", hash_original_field = "03D75DEB6D464B8542B100729E06F31A", hash_generated_field = "025804A69EBBE06B825C121817CBF935")

    public static final int EL = 248;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.021 -0500", hash_original_field = "D3B7F0E507BEF3E669304B040E1106C4", hash_generated_field = "60913811502974E8B0EAA64656ED6532")

    public static final int EC = 247;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.025 -0500", hash_original_field = "D5BD914526A657CE477385DD8A1400F0", hash_generated_field = "DD597D7DB996D30C0CC42F48C1A39BDD")

    public static final int AYT = 246;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.029 -0500", hash_original_field = "0B1EC0368DB8FAB7791416D499200D05", hash_generated_field = "BB5A57EDBEA33B7F2E1C457671DA8FC2")

    public static final int AO = 245;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.033 -0500", hash_original_field = "80A44CFD1BAAE1FD6E2EB23649973E0D", hash_generated_field = "EE25B8F9BE37C3B01DA737CC2BC5BB7E")

    public static final int IP = 244;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.037 -0500", hash_original_field = "3DB5B342A48D57B3F547A92B15C5EBB0", hash_generated_field = "3E789D21E528576B7A6CE1971F6B843E")

    public static final int BREAK = 243;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.041 -0500", hash_original_field = "926AEBD81BD5BF074CF4790AF7B4067A", hash_generated_field = "C9A528BFDD90F49E5A59CB5D521C45A8")

    public static final int DM = 242;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.044 -0500", hash_original_field = "93A4FFEC2C5683CDBCFCB721D55672A4", hash_generated_field = "269C7C2EC9FCBE4AB8C099F76060DAAF")

    public static final int NOP = 241;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.049 -0500", hash_original_field = "7F2607E7FE3B7E9057BEB7A42442023A", hash_generated_field = "7FA40828E91B0A97077AC6115C1B7410")

    public static final int SE = 240;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.053 -0500", hash_original_field = "7304602ECB415A1F05085E9DE4E87FDD", hash_generated_field = "B3A34B298999704CF792AA8654F00A2F")

    public static final int EOR = 239;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.057 -0500", hash_original_field = "DAE5BF035B03044699995547F80F69E5", hash_generated_field = "DE28E1633A8935A848C2987DDC422059")

    public static final int ABORT = 238;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.061 -0500", hash_original_field = "08FD19EAE99EA9DAA45C2631756798C3", hash_generated_field = "85DDBCD0B56C7D2756403D736C783F6F")

    public static final int SUSP = 237;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.065 -0500", hash_original_field = "F6F25505EA9A2C7C613E78598BA7B53B", hash_generated_field = "DCE616737C29DDAB543237C53243F6DF")

    public static final int EOF = 236;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.068 -0500", hash_original_field = "F5C04BD8312A744DEAA961B7C23D3BD1", hash_generated_field = "D565E9DEB4F7A48074D6B97FAD09F02B")

    public static final int SYNCH = 242;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.073 -0500", hash_original_field = "12AD89F641567B36BA7C5010B52B5072", hash_generated_field = "63354DA08162D232BC0CC84717044F7E")

    private static final String __commandString[] = {
                "IAC", "DONT", "DO", "WONT", "WILL", "SB", "GA", "EL", "EC", "AYT",
                "AO", "IP", "BRK", "DMARK", "NOP", "SE", "EOR", "ABORT", "SUSP", "EOF"
            };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.077 -0500", hash_original_field = "64A133464BD487C502135936B948BFFE", hash_generated_field = "B2C7C6778F0A4670D609B5816375E3DF")

    private static final int __FIRST_COMMAND = IAC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.080 -0500", hash_original_field = "45F7262FBC382AF6C2BFF2E944385226", hash_generated_field = "121C5E5B411AA49C4079565E549BFF75")

    private static final int __LAST_COMMAND = EOF;

    /***
     * Returns the string representation of the telnet protocol command
     * corresponding to the given command code.
     * <p>
     * @param code The command code of the telnet protocol command.
     * @return The string representation of the telnet protocol command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.084 -0500", hash_original_method = "00AEA2E31FF76DC8CBD4A242360FF8FD", hash_generated_method = "5F5C908DFF4E611D8291C9B197F856EB")
    
public static final String getCommand(int code)
    {
        return __commandString[__FIRST_COMMAND - code];
    }

    /***
     * Determines if a given command code is valid.  Returns true if valid,
     * false if not.
     * <p>
     * @param code  The command code to test.
     * @return True if the command code is valid, false if not.
     **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.087 -0500", hash_original_method = "408B8A2F6473D1390F4BD92FAF80FE83", hash_generated_method = "16646E13182984A5B04207C46B29C805")
    
public static final boolean isValidCommand(int code)
    {
        return (code <= __FIRST_COMMAND && code >= __LAST_COMMAND);
    }

    // Cannot be instantiated
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.092 -0500", hash_original_method = "30DDC75EA8D4EFF80E3C73F9CE19A917", hash_generated_method = "48B8FC30CB357F8CF0428E8BA2BD15E6")
    
private TelnetCommand()
    { }
}
