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


package org.apache.commons.net.smtp;

/***
 * SMTPCommand stores a set of constants for SMTP command codes.  To interpret
 * the meaning of the codes, familiarity with RFC 821 is assumed.
 * The mnemonic constant names are transcriptions from the code descriptions
 * of RFC 821.  For those who think in terms of the actual SMTP commands,
 * a set of constants such as {@link #HELO  HELO } are provided
 * where the constant name is the same as the SMTP command.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class SMTPCommand
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.139 -0500", hash_original_field = "CFF41351A80A8122D7B7583B2512B89A", hash_generated_field = "E4B7A9D51BBD3D01A2C78386CB368092")

    public static final int HELO = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.148 -0500", hash_original_field = "290235FD08C2A109808EB927A7D92440", hash_generated_field = "B4BAAD190FD61659A62FAA608ADB9BB2")

    public static final int MAIL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.152 -0500", hash_original_field = "464DF18BB680C0DCD95161D5AF16D288", hash_generated_field = "616C1E4F868BC6B30D0C457827A0111B")

    public static final int RCPT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.156 -0500", hash_original_field = "B293B7F3ECC4FD7DE29A5F241B269A8E", hash_generated_field = "A59742109FBE9A9D8C75AEC256FD6DF9")

    public static final int DATA = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.159 -0500", hash_original_field = "B553925317EF744E0941ED83A19A4629", hash_generated_field = "7C4714EEB82AB1260B7376A82EDA14F3")

    public static final int SEND = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.163 -0500", hash_original_field = "4A1AB27381C89642C52B20A7BA278015", hash_generated_field = "988EBD9E7754A25E1843188C8BD850B9")

    public static final int SOML = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.167 -0500", hash_original_field = "C79732BF75ED0470AA3EDB3C5E8D4DE7", hash_generated_field = "19BE06AB66F4BBFA4ECF420646AB235B")

    public static final int SAML = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.170 -0500", hash_original_field = "C623D62C441EA8D532340690BC91E52A", hash_generated_field = "336ADB5653209788F093A0D89B0B6BB3")

    public static final int RSET = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.174 -0500", hash_original_field = "13AE93E9E997B699C76259D5062D5084", hash_generated_field = "E65A27B25879665B92C77D06FE03024D")

    public static final int VRFY = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.178 -0500", hash_original_field = "F9230151F02681999A2B9BA010EA27F1", hash_generated_field = "27A463E43F517A039584B8F11A9FD3C9")

    public static final int EXPN = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.182 -0500", hash_original_field = "C36C7C6EA852C150046CA5CE16716A52", hash_generated_field = "EB1C423ABF0A3647510021E931D2FB9A")

    public static final int HELP = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.185 -0500", hash_original_field = "B3C6202A7D60C5D1B112076F6F8611C5", hash_generated_field = "378F58E0D0DE9793AF29F0795533755D")

    public static final int NOOP = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.190 -0500", hash_original_field = "58AB06A0FC54E855D2C710B443B5DAA8", hash_generated_field = "2615C1E4F272A3685B01C37B5AF817D0")

    public static final int TURN = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.194 -0500", hash_original_field = "FDED8FDD9AEF9810381F3CACD54A4D15", hash_generated_field = "44470712BCA691A57B66DECAE39719DA")

    public static final int QUIT = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.198 -0500", hash_original_field = "8E0AECA8A4C2F31FCAEC7AB29FEC11A5", hash_generated_field = "786C65804402CDA076B652E6166E2B45")

    public static final int HELLO = HELO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.201 -0500", hash_original_field = "590DCD3ABF8D5E728E2634DF78D32898", hash_generated_field = "9229598A08BA5E69B5DBC7BA7E537342")

    public static final int LOGIN = HELO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.205 -0500", hash_original_field = "FC6F93C67477B2E1F0804DCFE348C52C", hash_generated_field = "DE9856DD363DC267B064DD7EB6BD9E54")

    public static final int MAIL_FROM = MAIL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.209 -0500", hash_original_field = "BEE40D35C93B4F1637C71F6B7B3BFF99", hash_generated_field = "9377C0B81B5D53F3AC7743A86C783A1D")

    public static final int RECIPIENT = RCPT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.218 -0500", hash_original_field = "DAAAE658333BC152F6E42C03FD3B2C62", hash_generated_field = "4BDF7CB93B33F24028EE13B5E875AC8B")

    public static final int SEND_MESSAGE_DATA = DATA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.222 -0500", hash_original_field = "F4D2E0BEB5A13E690BFA9441FBD3B47A", hash_generated_field = "79EAB0EC5725A7D5460EC9A52C590083")

    public static final int SEND_FROM = SEND;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.226 -0500", hash_original_field = "55E58A65717D1857A7D26AE596D19727", hash_generated_field = "79202B06EEA60BE162D81A9161B853E9")

    public static final int SEND_OR_MAIL_FROM = SOML;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.229 -0500", hash_original_field = "F60F89E1AD4B82E2C59037A8A4C630D1", hash_generated_field = "9CEB21A09D84DE8CBF09A49A6C1C0988")

    public static final int SEND_AND_MAIL_FROM = SAML;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.233 -0500", hash_original_field = "E561614930970C3E5405C42F905A6C32", hash_generated_field = "4787E57D910D53603C3B2B4A231F7CA8")

    public static final int RESET = RSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.236 -0500", hash_original_field = "ABFC9FF3EC8F8616ED67EA4CF6AB0984", hash_generated_field = "24027EB9B2956BA86E6A9DBF6D698364")

    public static final int VERIFY = VRFY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.240 -0500", hash_original_field = "1C627BD2E4D46302A5CDFE874650FF53", hash_generated_field = "860911B6ED9C6803A99D12F87590F774")

    public static final int EXPAND = EXPN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.243 -0500", hash_original_field = "A1B20A100BD5ECACE747BEC66B25EC54", hash_generated_field = "9C6A5F228FEAB026AF4DE16DBDB6DEC1")

    // public static final int NOOP = NOOP;
    // public static final int TURN = TURN;
    // public static final int QUIT = QUIT;
    public static final int LOGOUT = QUIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.251 -0500", hash_original_field = "E684C9AEF1B4C4AD4F8CE877295AF32F", hash_generated_field = "DAA2574BDEACA8FC0DC2C6223D997D59")

    static final String[] _commands = {
                                          "HELO", "MAIL FROM:", "RCPT TO:", "DATA", "SEND FROM:", "SOML FROM:",
                                          "SAML FROM:", "RSET", "VRFY", "EXPN", "HELP", "NOOP", "TURN", "QUIT"
                                      };

    /***
     * Retrieve the SMTP protocol command string corresponding to a specified
     * command code.
     * <p>
     * @param command The command code.
     * @return The SMTP protcol command string corresponding to a specified
     *         command code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.255 -0500", hash_original_method = "00EADAB9B7F650A465A01299B290A28E", hash_generated_method = "D266DA9BA95C2A211722ACB893ECDCA5")
    
public static final String getCommand(int command)
    {
        return _commands[command];
    }

    // Cannot be instantiated
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.247 -0500", hash_original_method = "5354EDA6BABF6D32AE02D2AFA879F3F5", hash_generated_method = "0A095AE3D16540CC8EB953AB476EDD28")
    
private SMTPCommand()
    {}

}
