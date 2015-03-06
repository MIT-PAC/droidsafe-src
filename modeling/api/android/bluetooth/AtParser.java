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
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.bluetooth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.*;

/**
 * An AT (Hayes command) Parser based on (a subset of) the ITU-T V.250 standard.
 * <p>
 *
 * Conformant with the subset of V.250 required for implementation of the
 * Bluetooth Headset and Handsfree Profiles, as per Bluetooth SIP
 * specifications. Also implements some V.250 features not required by
 * Bluetooth - such as chained commands.<p>
 *
 * Command handlers are registered with an AtParser object. These handlers are
 * invoked when command lines are processed by AtParser's process() method.<p>
 *
 * The AtParser object accepts a new command line to parse via its process()
 * method. It breaks each command line into one or more commands. Each command
 * is parsed for name, type, and (optional) arguments, and an appropriate
 * external handler method is called through the AtCommandHandler interface.
 *
 * The command types are<ul>
 * <li>Basic Command. For example "ATDT1234567890". Basic command names are a
 * single character (e.g. "D"), and everything following this character is
 * passed to the handler as a string argument (e.g. "T1234567890").
 * <li>Action Command. For example "AT+CIMI". The command name is "CIMI", and
 * there are no arguments for action commands.
 * <li>Read Command. For example "AT+VGM?". The command name is "VGM", and there
 * are no arguments for get commands.
 * <li>Set Command. For example "AT+VGM=14". The command name is "VGM", and
 * there is a single integer argument in this case. In the general case then
 * can be zero or more arguments (comma delimited) each of integer or string
 * form.
 * <li>Test Command. For example "AT+VGM=?. No arguments.
 * </ul>
 *
 * In V.250 the last four command types are known as Extended Commands, and
 * they are used heavily in Bluetooth.<p>
 *
 * Basic commands cannot be chained in this implementation. For Bluetooth
 * headset/handsfree use this is acceptable, because they only use the basic
 * commands ATA and ATD, which are not allowed to be chained. For general V.250
 * use we would need to improve this class to allow Basic command chaining -
 * however it's tricky to get right because there is no delimiter for Basic
 * command chaining.<p>
 *
 * Extended commands can be chained. For example:<p>
 * AT+VGM?;+VGM=14;+CIMI<p>
 * This is equivalent to:<p>
 * AT+VGM?
 * AT+VGM=14
 * AT+CIMI
 * Except that only one final result code is return (although several
 * intermediate responses may be returned), and as soon as one command in the
 * chain fails the rest are abandoned.<p>
 *
 * Handlers are registered by there command name via register(Char c, ...) or
 * register(String s, ...). Handlers for Basic command should be registered by
 * the basic command character, and handlers for Extended commands should be
 * registered by String.<p>
 *
 * Refer to:<ul>
 * <li>ITU-T Recommendation V.250
 * <li>ETSI TS 127.007  (AT Command set for User Equipment, 3GPP TS 27.007)
 * <li>Bluetooth Headset Profile Spec (K6)
 * <li>Bluetooth Handsfree Profile Spec (HFP 1.5)
 * </ul>
 * @hide
 */
public class AtParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.470 -0400", hash_original_field = "F5705487A5BC837FCBEC13D6970905A8", hash_generated_field = "0D37A62F1B84379C3C3C1E4CC5F5D9DC")

    private static final int TYPE_ACTION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.476 -0400", hash_original_field = "CB25AF716A9D078BD119ACE24DC7CD2B", hash_generated_field = "7261EEB7EF2626C8A9AB44542D45C6F6")

    private static final int TYPE_READ = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.483 -0400", hash_original_field = "1C540F3AB9F3E99464003DE30349E360", hash_generated_field = "A7E61D906F18E3D1A9D8965AA19987A2")

    private static final int TYPE_SET = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.488 -0400", hash_original_field = "ABE7CDFAE75980F596F138114DAD270B", hash_generated_field = "3C09B228CF16E69F37BDDA156EC12109")

    private static final int TYPE_TEST = 3;

    /**
     * Strip input of whitespace and force Uppercase - except sections inside
     * quotes. Also fixes unmatched quotes (by appending a quote). Double
     * quotes " are the only quotes allowed by V.250
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.525 -0400", hash_original_method = "98E54B1AC20FAE9C9CBD9991BB145BD9", hash_generated_method = "5F6B7801C5DA05C07AE3DD68FD690B91")
    
static private String clean(String input) {
        StringBuilder out = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '"') {
                int j = input.indexOf('"', i + 1 );  // search for closing "
                if (j == -1) {  // unmatched ", insert one.
                    out.append(input.substring(i, input.length()));
                    out.append('"');
                    break;
                }
                out.append(input.substring(i, j + 1));
                i = j;
            } else if (c != ' ') {
                out.append(Character.toUpperCase(c));
            }
        }

        return out.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.531 -0400", hash_original_method = "D17016E89D9D08EADBB675E2CD271B98", hash_generated_method = "6AA74D5070BD83E6D14D8CE1A2199D41")
    
static private boolean isAtoZ(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    /**
     * Find a character ch, ignoring quoted sections.
     * Return input.length() if not found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.536 -0400", hash_original_method = "32B0ACF05078B72AA19A5AA94D1E2C78", hash_generated_method = "812531FFAD32DE977D2C79B04FA6D4E8")
    
static private int findChar(char ch, String input, int fromIndex) {
        for (int i = fromIndex; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '"') {
                i = input.indexOf('"', i + 1);
                if (i == -1) {
                    return input.length();
                }
            } else if (c == ch) {
                return i;
            }
        }
        return input.length();
    }

    /**
     * Break an argument string into individual arguments (comma delimited).
     * Integer arguments are turned into Integer objects. Otherwise a String
     * object is used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.547 -0400", hash_original_method = "D7EF56BAEA0F19544F64896EACCC0C00", hash_generated_method = "17A7166F91CB6958EDE976684EB39DDA")
    
static private Object[] generateArgs(String input) {
        int i = 0;
        int j;
        ArrayList<Object> out = new ArrayList<Object>();
        while (i <= input.length()) {
            j = findChar(',', input, i);

            String arg = input.substring(i, j);
            try {
                out.add(new Integer(arg));
            } catch (NumberFormatException e) {
                out.add(arg);
            }

            i = j + 1; // move past comma
        }
        return out.toArray();
    }

    /**
     * Return the index of the end of character after the last character in
     * the extended command name. Uses the V.250 spec for allowed command
     * names.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.554 -0400", hash_original_method = "8C639B0FD4B4B22285D25F015AD7A331", hash_generated_method = "7452890A2D5BA54E5A4E4D80E80A4173")
    
static private int findEndExtendedName(String input, int index) {
        for (int i = index; i < input.length(); i++) {
            char c = input.charAt(i);

            // V.250 defines the following chars as legal extended command
            // names
            if (isAtoZ(c)) continue;
            if (c >= '0' && c <= '9') continue;
            switch (c) {
            case '!':
            case '%':
            case '-':
            case '.':
            case '/':
            case ':':
            case '_':
                continue;
            default:
                return i;
            }
        }
        return input.length();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.493 -0400", hash_original_field = "5ED6C8209A1BDDF253B542DBEAA25B26", hash_generated_field = "A70564404D23FC6EFF9CFE93A43CFBFB")

    private HashMap<String, AtCommandHandler> mExtHandlers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.498 -0400", hash_original_field = "C8231A97311E6D5773E80D7A7E656763", hash_generated_field = "1FC7C8BEFF733381365B0EED297CBC8A")

    private HashMap<Character, AtCommandHandler> mBasicHandlers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.503 -0400", hash_original_field = "C2991DB82F67966AC5EA0BE54BAAD09A", hash_generated_field = "CC7D8A444ED75F21A28407F977C1A351")

    private String mLastInput;  // for "A/" (repeat last command) support

    /**
     * Create a new AtParser.<p>
     * No handlers are registered.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.508 -0400", hash_original_method = "A9DEAEFACA924C792443989EB127F9DE", hash_generated_method = "AA3EB45FD65D0E088548003CE64926D1")
    
public AtParser() {
        mBasicHandlers = new HashMap<Character, AtCommandHandler>();
        mExtHandlers = new HashMap<String, AtCommandHandler>();
        mLastInput = "";
    }

    /**
     * Register a Basic command handler.<p>
     * Basic command handlers are later called via their
     * <code>handleBasicCommand(String args)</code> method.
     * @param  command Command name - a single character
     * @param  handler Handler to register
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.513 -0400", hash_original_method = "607AEEC83545C16FE1721D19F208C5BE", hash_generated_method = "CEB4572DA5E3EDD2E0968C2CD5270B55")
    
public void register(Character command, AtCommandHandler handler) {
        mBasicHandlers.put(command, handler);
    }

    /**
     * Register an Extended command handler.<p>
     * Extended command handlers are later called via:<ul>
     * <li><code>handleActionCommand()</code>
     * <li><code>handleGetCommand()</code>
     * <li><code>handleSetCommand()</code>
     * <li><code>handleTestCommand()</code>
     * </ul>
     * Only one method will be called for each command processed.
     * @param  command Command name - can be multiple characters
     * @param  handler Handler to register
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.518 -0400", hash_original_method = "95B367B29207B84F57FA0AC8C88D7587", hash_generated_method = "51BD899EDC75332FFDC13E22A22A2768")
    
public void register(String command, AtCommandHandler handler) {
        mExtHandlers.put(command, handler);
    }

    /**
     * Processes an incoming AT command line.<p>
     * This method will invoke zero or one command handler methods for each
     * command in the command line.<p>
     * @param raw_input The AT input, without EOL delimiter (e.g. <CR>).
     * @return          Result object for this command line. This can be
     *                  converted to a String[] response with toStrings().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:01.569 -0400", hash_original_method = "77A09A4D28981B0EED9193BA2388A580", hash_generated_method = "0D0FA58CCC10978747A5E4E7C40D6623")
    
public AtCommandResult process(String raw_input) {
        String input = clean(raw_input);

        // Handle "A/" (repeat previous line)
        if (input.regionMatches(0, "A/", 0, 2)) {
            input = new String(mLastInput);
        } else {
            mLastInput = new String(input);
        }

        // Handle empty line - no response necessary
        if (input.equals("")) {
            // Return []
            return new AtCommandResult(AtCommandResult.UNSOLICITED);
        }

        // Anything else deserves an error
        if (!input.regionMatches(0, "AT", 0, 2)) {
            // Return ["ERROR"]
            return new AtCommandResult(AtCommandResult.ERROR);
        }

        // Ok we have a command that starts with AT. Process it
        int index = 2;
        AtCommandResult result =
                new AtCommandResult(AtCommandResult.UNSOLICITED);
        while (index < input.length()) {
            char c = input.charAt(index);

            if (isAtoZ(c)) {
                // Option 1: Basic Command
                // Pass the rest of the line as is to the handler. Do not
                // look for any more commands on this line.
                String args = input.substring(index + 1);
                if (mBasicHandlers.containsKey((Character)c)) {
                    result.addResult(mBasicHandlers.get(
                            (Character)c).handleBasicCommand(args));
                    return result;
                } else {
                    // no handler
                    result.addResult(
                            new AtCommandResult(AtCommandResult.ERROR));
                    return result;
                }
                // control never reaches here
            }

            if (c == '+') {
                // Option 2: Extended Command
                // Search for first non-name character. Short-circuit if
                // we don't handle this command name.
                int i = findEndExtendedName(input, index + 1);
                String commandName = input.substring(index, i);
                if (!mExtHandlers.containsKey(commandName)) {
                    // no handler
                    result.addResult(
                            new AtCommandResult(AtCommandResult.ERROR));
                    return result;
                }
                AtCommandHandler handler = mExtHandlers.get(commandName);

                // Search for end of this command - this is usually the end of
                // line
                int endIndex = findChar(';', input, index);

                // Determine what type of command this is.
                // Default to TYPE_ACTION if we can't find anything else
                // obvious.
                int type;

                if (i >= endIndex) {
                    type = TYPE_ACTION;
                } else if (input.charAt(i) == '?') {
                    type = TYPE_READ;
                } else if (input.charAt(i) == '=') {
                    if (i + 1 < endIndex) {
                        if (input.charAt(i + 1) == '?') {
                            type = TYPE_TEST;
                        } else {
                            type = TYPE_SET;
                        }
                    } else {
                        type = TYPE_SET;
                    }
                } else {
                    type = TYPE_ACTION;
                }

                // Call this command. Short-circuit as soon as a command fails
                switch (type) {
                case TYPE_ACTION:
                    result.addResult(handler.handleActionCommand());
                    break;
                case TYPE_READ:
                    result.addResult(handler.handleReadCommand());
                    break;
                case TYPE_TEST:
                    result.addResult(handler.handleTestCommand());
                    break;
                case TYPE_SET:
                    Object[] args =
                            generateArgs(input.substring(i + 1, endIndex));
                    result.addResult(handler.handleSetCommand(args));
                    break;
                }
                if (result.getResultCode() != AtCommandResult.OK) {
                    return result;   // short-circuit
                }

                index = endIndex;
            } else {
                // Can't tell if this is a basic or extended command.
                // Push forwards and hope we hit something.
                index++;
            }
        }
        // Finished processing (and all results were ok)
        return result;
    }
}
