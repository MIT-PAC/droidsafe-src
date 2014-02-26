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
 * Implements the telnet suppress go ahead option RFC 858.
 * <p>
 * @author Bruno D'Avanzo
 ***/
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class SuppressGAOptionHandler extends TelnetOptionHandler
{
    /***
     * Constructor for the SuppressGAOptionHandler. Allows defining desired
     * initial setting for local/remote activation of this option and
     * behaviour in case a local/remote activation request for this
     * option is received.
     * <p>
     * @param initlocal - if set to true, a WILL is sent upon connection.
     * @param initremote - if set to true, a DO is sent upon connection.
     * @param acceptlocal - if set to true, any DO request is accepted.
     * @param acceptremote - if set to true, any WILL request is accepted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.133 -0500", hash_original_method = "687D3CC35403AB8BC636CB8710D73128", hash_generated_method = "DFCCD8A01F88920EDF4E8D7806FB4ECC")
    
public SuppressGAOptionHandler(boolean initlocal, boolean initremote,
                                boolean acceptlocal, boolean acceptremote)
    {
        super(TelnetOption.SUPPRESS_GO_AHEAD, initlocal, initremote,
                                      acceptlocal, acceptremote);
    }

    /***
     * Constructor for the SuppressGAOptionHandler. Initial and accept
     * behaviour flags are set to false
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.138 -0500", hash_original_method = "865A5634A871639454EF2E313098786A", hash_generated_method = "DBAAC143854D428B9525897993FCCF6A")
    
public SuppressGAOptionHandler()
    {
        super(TelnetOption.SUPPRESS_GO_AHEAD, false, false, false, false);
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @param suboptionData - the sequence received, whithout IAC SB & IAC SE
     * @param suboptionLength - the length of data in suboption_data
     * <p>
     * @return always null (no response to subnegotiation)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.143 -0500", hash_original_method = "8E4AD7240C251CF428BBDBBDF32B610B", hash_generated_method = "2A2A56198B9E7D41956B2035F014B4D4")
    
public int[] answerSubnegotiation(int suboptionData[], int suboptionLength)
    {
        return null;
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @return always null (no response to subnegotiation)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.147 -0500", hash_original_method = "F400F1CB4F55C1DB38DB506118AEBF9E", hash_generated_method = "399E1A91FCB7925032E7C1A70F4E4379")
    
public int[] startSubnegotiationLocal()
    {
        return null;
    }

    /***
     * Implements the abstract method of TelnetOptionHandler.
     * <p>
     * @return always null (no response to subnegotiation)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.151 -0500", hash_original_method = "13C71D739499D98499F08E0B68D72954", hash_generated_method = "3B4139C4D3E5EEAC06EE22EAA7358A3F")
    
public int[] startSubnegotiationRemote()
    {
        return null;
    }
}
