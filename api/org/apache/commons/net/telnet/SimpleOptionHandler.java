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
 * Simple option handler that can be used for options
 * that don't require subnegotiation.
 * <p>
 * @author Bruno D'Avanzo
 ***/
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class SimpleOptionHandler extends TelnetOptionHandler
{
    /***
     * Constructor for the SimpleOptionHandler. Allows defining desired
     * initial setting for local/remote activation of this option and
     * behaviour in case a local/remote activation request for this
     * option is received.
     * <p>
     * @param optcode - option code.
     * @param initlocal - if set to true, a WILL is sent upon connection.
     * @param initremote - if set to true, a DO is sent upon connection.
     * @param acceptlocal - if set to true, any DO request is accepted.
     * @param acceptremote - if set to true, any WILL request is accepted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.283 -0500", hash_original_method = "F0EE9D39FACF7D0CC37B51524846E4E4", hash_generated_method = "D1D5923F9D632FE921973FEEEEE5CE71")
    
public SimpleOptionHandler(int optcode,
                                boolean initlocal,
                                boolean initremote,
                                boolean acceptlocal,
                                boolean acceptremote)
    {
        super(optcode, initlocal, initremote,
                                      acceptlocal, acceptremote);
    }

    /***
     * Constructor for the SimpleOptionHandler. Initial and accept
     * behaviour flags are set to false
     * <p>
     * @param optcode - option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.287 -0500", hash_original_method = "9F825F3536CFC5E71E2ECD33EECB6EAB", hash_generated_method = "E8C3340F7D009830AEB768F1F41797F3")
    
public SimpleOptionHandler(int optcode)
    {
        super(optcode, false, false, false, false);
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @param suboptionData - the sequence received, whithout IAC SB & IAC SE
     * @param suboptionLength - the length of data in suboption_data
     * <p>
     * @return always null (no response to subnegotiation)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.291 -0500", hash_original_method = "8E4AD7240C251CF428BBDBBDF32B610B", hash_generated_method = "2A2A56198B9E7D41956B2035F014B4D4")
    
public int[] answerSubnegotiation(int suboptionData[], int suboptionLength)
    {
        return null;
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @return always null (no response to subnegotiation)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.294 -0500", hash_original_method = "F400F1CB4F55C1DB38DB506118AEBF9E", hash_generated_method = "399E1A91FCB7925032E7C1A70F4E4379")
    
public int[] startSubnegotiationLocal()
    {
        return null;
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @return always null (no response to subnegotiation)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.298 -0500", hash_original_method = "13C71D739499D98499F08E0B68D72954", hash_generated_method = "3B4139C4D3E5EEAC06EE22EAA7358A3F")
    
public int[] startSubnegotiationRemote()
    {
        return null;
    }
}
