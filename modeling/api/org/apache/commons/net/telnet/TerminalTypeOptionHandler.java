/*
 * Copyright 2003-2004 The Apache Software Foundation
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

/***
 * Implements the telnet terminal type option RFC 1091.
 * <p>
 * @author Bruno D'Avanzo
 ***/
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class TerminalTypeOptionHandler extends TelnetOptionHandler
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.479 -0500", hash_original_field = "5BF2E6521F87CF5738C74E2A6D189DC7", hash_generated_field = "1E7C317A658599A9339D2AB4797467F2")

    protected static final int TERMINAL_TYPE = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.483 -0500", hash_original_field = "A89462D97D2931971734486B1514C30D", hash_generated_field = "5027F6B1616AA53A706CCDD9FFC03565")

    protected static final int TERMINAL_TYPE_SEND =  1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.487 -0500", hash_original_field = "FE03FA125483B4B3CBF0DBDF39C8A1F1", hash_generated_field = "5D69BE2CF4BE83AF43F50978F09F86E9")

    protected static final int TERMINAL_TYPE_IS =  0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.474 -0500", hash_original_field = "7A25A0FEE96A45233140B8A9D2256395", hash_generated_field = "1EE48627B3455C92EFD8E9B33D833E17")

    private String termType = null;

    /***
     * Constructor for the TerminalTypeOptionHandler. Allows defining desired
     * initial setting for local/remote activation of this option and
     * behaviour in case a local/remote activation request for this
     * option is received.
     * <p>
     * @param termtype - terminal type that will be negotiated.
     * @param initlocal - if set to true, a WILL is sent upon connection.
     * @param initremote - if set to true, a DO is sent upon connection.
     * @param acceptlocal - if set to true, any DO request is accepted.
     * @param acceptremote - if set to true, any WILL request is accepted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.492 -0500", hash_original_method = "4503D459388D495116030507C769B22D", hash_generated_method = "CAD8938D9D37C652871D219C63F55B3A")
    
public TerminalTypeOptionHandler(String termtype,
                                boolean initlocal,
                                boolean initremote,
                                boolean acceptlocal,
                                boolean acceptremote)
    {
        super(TelnetOption.TERMINAL_TYPE, initlocal, initremote,
                                      acceptlocal, acceptremote);
        termType = termtype;
    }

    /***
     * Constructor for the TerminalTypeOptionHandler. Initial and accept
     * behaviour flags are set to false
     * <p>
     * @param termtype - terminal type that will be negotiated.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.496 -0500", hash_original_method = "CC6B5847F4BD17A5F69B792ED245FD4C", hash_generated_method = "89276B5CEDCAF183F0508D09268CF0B9")
    
public TerminalTypeOptionHandler(String termtype)
    {
        super(TelnetOption.TERMINAL_TYPE, false, false, false, false);
        termType = termtype;
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @param suboptionData - the sequence received, whithout IAC SB & IAC SE
     * @param suboptionLength - the length of data in suboption_data
     * <p>
     * @return terminal type information
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.504 -0500", hash_original_method = "DE289248E8D46F4249A96EE9032302CF", hash_generated_method = "86458B42B9324AB5BD55114A8AFE5CE7")
    
public int[] answerSubnegotiation(int suboptionData[], int suboptionLength)
    {
        if ((suboptionData != null) && (suboptionLength > 1)
            && (termType != null))
        {
            if ((suboptionData[0] == TERMINAL_TYPE)
                && (suboptionData[1] == TERMINAL_TYPE_SEND))
            {
                int response[] = new int[termType.length() + 2];

                response[0] = TERMINAL_TYPE;
                response[1] = TERMINAL_TYPE_IS;

                for (int ii = 0; ii < termType.length(); ii++)
                {
                    response[ii + 2] = (int) termType.charAt(ii);
                }

                return response;
            }
        }
        return null;
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @return always null (no response to subnegotiation)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.507 -0500", hash_original_method = "F400F1CB4F55C1DB38DB506118AEBF9E", hash_generated_method = "399E1A91FCB7925032E7C1A70F4E4379")
    
public int[] startSubnegotiationLocal()
    {
        return null;
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @return always null (no response to subnegotiation)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.510 -0500", hash_original_method = "13C71D739499D98499F08E0B68D72954", hash_generated_method = "3B4139C4D3E5EEAC06EE22EAA7358A3F")
    
public int[] startSubnegotiationRemote()
    {
        return null;
    }
}
