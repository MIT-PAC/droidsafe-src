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
 * The TelnetOptionHandler class is the base class to be used
 * for implementing handlers for telnet options.
 * <p>
 * TelnetOptionHandler implements basic option handling
 * functionality and defines abstract methods that must be
 * implemented to define subnegotiation behaviour.
 * <p>
 * @author Bruno D'Avanzo
 ***/
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class TelnetOptionHandler
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.120 -0500", hash_original_field = "5274FE04EC28C0D01E1ABB2375F518DE", hash_generated_field = "E2BC2A2A9ADF0E2BAAE3223EBE6ACB3D")

    private int optionCode = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.126 -0500", hash_original_field = "59357F3A5B4F46F461BE283EC6F68876", hash_generated_field = "848CE3A8D272EA1A16E67C2D1792C596")

    private boolean initialLocal = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.134 -0500", hash_original_field = "9B96C4F5AD6B5644108B22784D99260E", hash_generated_field = "5F259DCA121D68A3ECD91A2DCB744D3A")

    private boolean initialRemote = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.140 -0500", hash_original_field = "F1929B7DF8AC90B37C01B4DCF155E71C", hash_generated_field = "CB9798EA932617118401227A919BE68B")

    private boolean acceptLocal = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.147 -0500", hash_original_field = "045D3840426C4B2E6471669751E2C2F6", hash_generated_field = "91E1581707B04B6856F500073134EEFB")

    private boolean acceptRemote = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.153 -0500", hash_original_field = "2F614700563C8B57AAC54FBE6F027FB1", hash_generated_field = "CEEBAC8AA70562164E0B2A067A080146")

    private boolean doFlag = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.159 -0500", hash_original_field = "FA47F44E824A1E79910414CB155AAFEA", hash_generated_field = "BADF1D0B38583F3BD9AC504F0D7AD861")

    private boolean willFlag = false;

    /***
     * Constructor for the TelnetOptionHandler. Allows defining desired
     * initial setting for local/remote activation of this option and
     * behaviour in case a local/remote activation request for this
     * option is received.
     * <p>
     * @param optcode - Option code.
     * @param initlocal - if set to true, a WILL is sent upon connection.
     * @param initremote - if set to true, a DO is sent upon connection.
     * @param acceptlocal - if set to true, any DO request is accepted.
     * @param acceptremote - if set to true, any WILL request is accepted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.166 -0500", hash_original_method = "376C9C265C4B15E9F77096E35E4AD1B4", hash_generated_method = "9157C77F89FD6D51419DB6D690BB0B07")
    
public TelnetOptionHandler(int optcode,
                                boolean initlocal,
                                boolean initremote,
                                boolean acceptlocal,
                                boolean acceptremote)
    {
        optionCode = optcode;
        initialLocal = initlocal;
        initialRemote = initremote;
        acceptLocal = acceptlocal;
        acceptRemote = acceptremote;
    }


    /***
     * Returns the option code for this option.
     * <p>
     * @return Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.170 -0500", hash_original_method = "330F9D12709AE6A768D3181E772B18F2", hash_generated_method = "54BD2DCA29BD29358ED95B7B65C36817")
    
public int getOptionCode()
    {
        return (optionCode);
    }

    /***
     * Returns a boolean indicating whether to accept a DO
     * request coming from the other end.
     * <p>
     * @return true if a DO request shall be accepted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.174 -0500", hash_original_method = "9B67208E548E5B9C746FAC194B519BCA", hash_generated_method = "8BD061D4E72446DF0911202AD4E22B44")
    
public boolean getAcceptLocal()
    {
        return (acceptLocal);
    }

    /***
     * Returns a boolean indicating whether to accept a WILL
     * request coming from the other end.
     * <p>
     * @return true if a WILL request shall be accepted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.179 -0500", hash_original_method = "679DFF5C63101B0EC9E9A018503B318A", hash_generated_method = "B2224A14797BD80E8ADE29DBDEFC32D1")
    
public boolean getAcceptRemote()
    {
        return (acceptRemote);
    }

    /***
     * Set behaviour of the option for DO requests coming from
     * the other end.
     * <p>
     * @param accept - if true, subsequent DO requests will be accepted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.185 -0500", hash_original_method = "4D78DE570E76097E857FBFAE2DBA2E7C", hash_generated_method = "DFE5BD817D53C749BF0E090E8A73EEB9")
    
public void setAcceptLocal(boolean accept)
    {
        acceptLocal = accept;
    }

    /***
     * Set behaviour of the option for WILL requests coming from
     * the other end.
     * <p>
     * @param accept - if true, subsequent WILL requests will be accepted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.190 -0500", hash_original_method = "DE5C2258DBEBA757A3A4E3862C783ADE", hash_generated_method = "DBE90B19E63DF1E12756609206982775")
    
public void setAcceptRemote(boolean accept)
    {
        acceptRemote = accept;
    }

    /***
     * Returns a boolean indicating whether to send a WILL request
     * to the other end upon connection.
     * <p>
     * @return true if a WILL request shall be sent upon connection.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.195 -0500", hash_original_method = "9B2CF9A9355DDBAFAD3F951B5867C1F2", hash_generated_method = "3CFE5839E6FACB7D14FABF973DD06D5E")
    
public boolean getInitLocal()
    {
        return (initialLocal);
    }

    /***
     * Returns a boolean indicating whether to send a DO request
     * to the other end upon connection.
     * <p>
     * @return true if a DO request shall be sent upon connection.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.200 -0500", hash_original_method = "28856226CFC412EF136376D05237A0EC", hash_generated_method = "59C9C6F0B02F40B367A7F6CC1BA36F42")
    
public boolean getInitRemote()
    {
        return (initialRemote);
    }

    /***
     * Tells this option whether to send a WILL request upon connection.
     * <p>
     * @param init - if true, a WILL request will be sent upon subsequent
     * connections.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.204 -0500", hash_original_method = "577AD058948A557DD4A670548525E6EE", hash_generated_method = "4B20DFA38F62FAD8356C44799288AFD7")
    
public void setInitLocal(boolean init)
    {
        initialLocal = init;
    }

    /***
     * Tells this option whether to send a DO request upon connection.
     * <p>
     * @param init - if true, a DO request will be sent upon subsequent
     * connections.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.207 -0500", hash_original_method = "74856F0617E3BFAF30B3F68A27E3FD92", hash_generated_method = "6E193028DD135AEA09173D56E0A63147")
    
public void setInitRemote(boolean init)
    {
        initialRemote = init;
    }

    /***
     * Method called upon reception of a subnegotiation for this option
     * coming from the other end.
     * Must be implemented by the actual TelnetOptionHandler to specify
     * which response must be sent for the subnegotiation request.
     * <p>
     * @param suboptionData - the sequence received, whithout IAC SB & IAC SE
     * @param suboptionLength - the length of data in suboption_data
     * <p>
     * @return response to be sent to the subnegotiation sequence. TelnetClient
     * will add IAC SB & IAC SE. null means no response
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.213 -0500", hash_original_method = "1EDDD1835E69AD096D1B6C3EFB44CDB0", hash_generated_method = "E57EB9D407810650FE64BEB32394CA5A")
    
public abstract int[] answerSubnegotiation(int suboptionData[],
                            int suboptionLength);

    /***
     * This method is invoked whenever this option is acknowledged active on
     * the local end (TelnetClient sent a WILL, remote side sent a DO).
     * The method is used to specify a subnegotiation sequence that will be
     * sent by TelnetClient when the option is activated.
     * <p>
     * @return subnegotiation sequence to be sent by TelnetClient. TelnetClient
     * will add IAC SB & IAC SE. null means no subnegotiation.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.218 -0500", hash_original_method = "01FD4B2943DD59F3D26E8D5F326A2816", hash_generated_method = "D60A1DFE1D49031EB0D5ED5E9437066E")
    
public abstract int[] startSubnegotiationLocal();

    /***
     * This method is invoked whenever this option is acknowledged active on
     * the remote end (TelnetClient sent a DO, remote side sent a WILL).
     * The method is used to specify a subnegotiation sequence that will be
     * sent by TelnetClient when the option is activated.
     * <p>
     * @return subnegotiation sequence to be sent by TelnetClient. TelnetClient
     * will add IAC SB & IAC SE. null means no subnegotiation.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.222 -0500", hash_original_method = "25BE0B80382E4880C7A8316062A5D977", hash_generated_method = "11D24A683D53CEB2DF8852F41A855608")
    
public abstract int[] startSubnegotiationRemote();

    /***
     * Returns a boolean indicating whether a WILL request sent to the other
     * side has been acknowledged.
     * <p>
     * @return true if a WILL sent to the other side has been acknowledged.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.226 -0500", hash_original_method = "A1B03F715672E6494B29AD9272F10307", hash_generated_method = "A1B03F715672E6494B29AD9272F10307")
    
boolean getWill()
    {
        return willFlag;
    }

    /***
     * Tells this option whether a WILL request sent to the other
     * side has been acknowledged (invoked by TelnetClient).
     * <p>
     * @param state - if true, a WILL request has been acknowledged.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.230 -0500", hash_original_method = "7B33F7C5F140ED29B1369D3FE4B0B9E3", hash_generated_method = "7B33F7C5F140ED29B1369D3FE4B0B9E3")
    
void setWill(boolean state)
    {
        willFlag = state;
    }

    /***
     * Returns a boolean indicating whether a DO request sent to the other
     * side has been acknowledged.
     * <p>
     * @return true if a DO sent to the other side has been acknowledged.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.233 -0500", hash_original_method = "EFB130E4132BDE10E222DF6CBC97AF1A", hash_generated_method = "EFB130E4132BDE10E222DF6CBC97AF1A")
    
boolean getDo()
    {
        return doFlag;
    }


    /***
     * Tells this option whether a DO request sent to the other
     * side has been acknowledged (invoked by TelnetClient).
     * <p>
     * @param state - if true, a DO request has been acknowledged.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.237 -0500", hash_original_method = "7F314575E7FC23B0D8DDCD6D10E70588", hash_generated_method = "7F314575E7FC23B0D8DDCD6D10E70588")
    
void setDo(boolean state)
    {
        doFlag = state;
    }
}
