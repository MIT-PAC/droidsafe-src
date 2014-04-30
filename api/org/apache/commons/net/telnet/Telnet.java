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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import org.apache.commons.net.SocketClient;

/**
 * @author Daniel F. Savarese
 * @author Bruno D'Avanzo
 */

class Telnet extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.746 -0500", hash_original_field = "1D26EAE68CED0DB1FB96EFFC9C24F00B", hash_generated_field = "8ECD18E9F314F4030E8E216046A33494")

    static final boolean debug =  /*true;*/ false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.750 -0500", hash_original_field = "2302F10CB970FB02521D8AC6E65838C2", hash_generated_field = "070BB9656068DAA7C13D62EA236530EC")

    static final boolean debugoptions =  /*true;*/ false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.754 -0500", hash_original_field = "377ACED9D4E3F0D127A1BAD30FF4E24C", hash_generated_field = "226458ED41759A560CDB74720E87408C")

    static final byte[] _COMMAND_DO = {
                                          (byte)TelnetCommand.IAC, (byte)TelnetCommand.DO
                                      };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.758 -0500", hash_original_field = "159FAC1703E61124ADF633BACB64C160", hash_generated_field = "424A6524537D32CC236C0431379CE118")

    static final byte[] _COMMAND_DONT = {
                                            (byte)TelnetCommand.IAC, (byte)TelnetCommand.DONT
                                        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.762 -0500", hash_original_field = "A002F7E63078DD61D6A508B106297C61", hash_generated_field = "47ACD082BD298E56411C494C3FC88BF9")

    static final byte[] _COMMAND_WILL = {
                                            (byte)TelnetCommand.IAC, (byte)TelnetCommand.WILL
                                        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.766 -0500", hash_original_field = "D4B7C42E4C22224A1F41DF252523321D", hash_generated_field = "8022CE433A7FE540520C11BA0183EB77")

    static final byte[] _COMMAND_WONT = {
                                            (byte)TelnetCommand.IAC, (byte)TelnetCommand.WONT
                                        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.773 -0500", hash_original_field = "AE3C091A5A4C65F7EDB967D5572927BB", hash_generated_field = "442350C77B149B1CC4B823A9C55D1905")

    static final byte[] _COMMAND_SB = {
                                          (byte)TelnetCommand.IAC, (byte)TelnetCommand.SB
                                      };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.777 -0500", hash_original_field = "1DBE3DAEC31843C54A9ECCFF712FDF32", hash_generated_field = "BE40414E92F86AE41F57D16638CAB32D")

    static final byte[] _COMMAND_SE = {
                                          (byte)TelnetCommand.IAC, (byte)TelnetCommand.SE
                                      };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.781 -0500", hash_original_field = "44EB3E88505D0CAF0E56406633A3FCB4", hash_generated_field = "8842AD718050C188CA7F491B114BAC63")

    static final int _WILL_MASK = 0x01, _DO_MASK = 0x02,
                                  _REQUESTED_WILL_MASK = 0x04, _REQUESTED_DO_MASK = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.785 -0500", hash_original_field = "EC23DD44C7DDECD4F5403190BDC2AB0A", hash_generated_field = "EA438EDB9D00B8382BC94C1A292895D4")

    static final int DEFAULT_PORT =  23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.793 -0500", hash_original_field = "5BF2E6521F87CF5738C74E2A6D189DC7", hash_generated_field = "891023254BE301582493F1C3F1C0E5AA")

    /***
     * Terminal type option
     ***/
    protected static final int TERMINAL_TYPE = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.798 -0500", hash_original_field = "A89462D97D2931971734486B1514C30D", hash_generated_field = "5027F6B1616AA53A706CCDD9FFC03565")

    protected static final int TERMINAL_TYPE_SEND =  1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.803 -0500", hash_original_field = "FE03FA125483B4B3CBF0DBDF39C8A1F1", hash_generated_field = "5D69BE2CF4BE83AF43F50978F09F86E9")

    protected static final int TERMINAL_TYPE_IS =  0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.806 -0500", hash_original_field = "DF68CDA8E735BA5ADF6F4EC722D8E490", hash_generated_field = "2CB2C861A259D097EA75F4F6C5DA6930")

    static final byte[] _COMMAND_IS = {
                                          (byte) TERMINAL_TYPE, (byte) TERMINAL_TYPE_IS
                                      };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.818 -0500", hash_original_field = "6E6FBB4934A2D7F27D0860BC3AECF904", hash_generated_field = "46B77C62454086C9AAFFCE686E3AD462")

    /* Code Section added for supporting AYT (start)*/
    /***
     * AYT sequence
     ***/
    static final byte[] _COMMAND_AYT = {
                                          (byte) TelnetCommand.IAC, (byte) TelnetCommand.AYT
                                       };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.789 -0500", hash_original_field = "FD0A66AD6E5F8C5711ECAD8EDA689414", hash_generated_field = "FD0A66AD6E5F8C5711ECAD8EDA689414")

    int[] _doResponse, _willResponse, _options;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.810 -0500", hash_original_field = "A0EC44D2AB09F876C99A04C7147D3653", hash_generated_field = "EADC10CEA41F1D22A9F31DFE2829DB17")

    private String terminalType = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.813 -0500", hash_original_field = "7FC933476A9E71D352343580ED23A35D", hash_generated_field = "EF47F444A23B4B5F660B09B559162FA7")

    /* open TelnetOptionHandler functionality (start)*/
    /***
     * Array of option handlers
     ***/
    private TelnetOptionHandler optionHandlers[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.822 -0500", hash_original_field = "B0C1FAEBA397E2254F59F9C8A98C77B7", hash_generated_field = "913C60631158DE36F1F13C36070BE78C")

    private Object aytMonitor = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.826 -0500", hash_original_field = "A8821603B59C84F812F700A0F84CA9FC", hash_generated_field = "192551A92491E98A82375503859D91FB")

    private boolean aytFlag = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.830 -0500", hash_original_field = "47700E7A40FB1245C5D9648875615794", hash_generated_field = "D822518F313C2AE18EABF3F916C1945D")

    /***
     * The stream on which to spy
     ***/
    private OutputStream spyStream = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.834 -0500", hash_original_field = "03742723D050A27E4767E31854E420A3", hash_generated_field = "77BD3824185748186EB2A2A32BD7CB95")

    private TelnetNotificationHandler __notifhand = null;
    /***
     * Empty Constructor
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.838 -0500", hash_original_method = "509AF80E298ABDF2249B5169E1218601", hash_generated_method = "509AF80E298ABDF2249B5169E1218601")
    
Telnet()
    {
        setDefaultPort(DEFAULT_PORT);
        _doResponse = new int[TelnetOption.MAX_OPTION_VALUE + 1];
        _willResponse = new int[TelnetOption.MAX_OPTION_VALUE + 1];
        _options = new int[TelnetOption.MAX_OPTION_VALUE + 1];
        optionHandlers =
            new TelnetOptionHandler[TelnetOption.MAX_OPTION_VALUE + 1];
    }

    /* TERMINAL-TYPE option (start)*/
    /***
     * This constructor lets you specify the terminal type.
     * <p>
     * @param termtype - terminal type to be negotiated (ej. VT100)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.849 -0500", hash_original_method = "C59572E0D2DD4BA1715B43B848EDE184", hash_generated_method = "C59572E0D2DD4BA1715B43B848EDE184")
    
Telnet(String termtype)
    {
        setDefaultPort(DEFAULT_PORT);
        _doResponse = new int[TelnetOption.MAX_OPTION_VALUE + 1];
        _willResponse = new int[TelnetOption.MAX_OPTION_VALUE + 1];
        _options = new int[TelnetOption.MAX_OPTION_VALUE + 1];
        terminalType = termtype;
        optionHandlers =
            new TelnetOptionHandler[TelnetOption.MAX_OPTION_VALUE + 1];
    }
    /* TERMINAL-TYPE option (end)*/

    /***
     * Looks for the state of the option.
     * <p>
     * @return returns true if a will has been acknowledged
     * <p>
     * @param option - option code to be looked up.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.856 -0500", hash_original_method = "AA1BAEFA825191F183CB3AF9DE3464B2", hash_generated_method = "AA1BAEFA825191F183CB3AF9DE3464B2")
    
boolean _stateIsWill(int option)
    {
        return ((_options[option] & _WILL_MASK) != 0);
    }

    /***
     * Looks for the state of the option.
     * <p>
     * @return returns true if a wont has been acknowledged
     * <p>
     * @param option - option code to be looked up.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.859 -0500", hash_original_method = "4DC647D2F13B88E4867C33AA162D4CA1", hash_generated_method = "4DC647D2F13B88E4867C33AA162D4CA1")
    
boolean _stateIsWont(int option)
    {
        return !_stateIsWill(option);
    }

    /***
     * Looks for the state of the option.
     * <p>
     * @return returns true if a do has been acknowledged
     * <p>
     * @param option - option code to be looked up.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.863 -0500", hash_original_method = "C232E4248F912FE02D45D4BF75A57DF4", hash_generated_method = "C232E4248F912FE02D45D4BF75A57DF4")
    
boolean _stateIsDo(int option)
    {
        return ((_options[option] & _DO_MASK) != 0);
    }

    /***
     * Looks for the state of the option.
     * <p>
     * @return returns true if a dont has been acknowledged
     * <p>
     * @param option - option code to be looked up.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.867 -0500", hash_original_method = "6C22D1F22186A9470913B31F85269FC3", hash_generated_method = "6C22D1F22186A9470913B31F85269FC3")
    
boolean _stateIsDont(int option)
    {
        return !_stateIsDo(option);
    }

    /***
     * Looks for the state of the option.
     * <p>
     * @return returns true if a will has been reuqested
     * <p>
     * @param option - option code to be looked up.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.871 -0500", hash_original_method = "CA8894215D990DF5BEA93D6F4DD7C790", hash_generated_method = "CA8894215D990DF5BEA93D6F4DD7C790")
    
boolean _requestedWill(int option)
    {
        return ((_options[option] & _REQUESTED_WILL_MASK) != 0);
    }

    /***
     * Looks for the state of the option.
     * <p>
     * @return returns true if a wont has been reuqested
     * <p>
     * @param option - option code to be looked up.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.874 -0500", hash_original_method = "DB4617691A261C8EE4F48E744A2721BA", hash_generated_method = "DB4617691A261C8EE4F48E744A2721BA")
    
boolean _requestedWont(int option)
    {
        return !_requestedWill(option);
    }

    /***
     * Looks for the state of the option.
     * <p>
     * @return returns true if a do has been reuqested
     * <p>
     * @param option - option code to be looked up.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.877 -0500", hash_original_method = "BCC81355363782E84A460D40E9FAB2BD", hash_generated_method = "BCC81355363782E84A460D40E9FAB2BD")
    
boolean _requestedDo(int option)
    {
        return ((_options[option] & _REQUESTED_DO_MASK) != 0);
    }

    /***
     * Looks for the state of the option.
     * <p>
     * @return returns true if a dont has been reuqested
     * <p>
     * @param option - option code to be looked up.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.881 -0500", hash_original_method = "5377041F441259BEB33F3B708C681E3C", hash_generated_method = "5377041F441259BEB33F3B708C681E3C")
    
boolean _requestedDont(int option)
    {
        return !_requestedDo(option);
    }

    /***
     * Sets the state of the option.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.885 -0500", hash_original_method = "E356737CB3535B3C8BFC1602D5F609BC", hash_generated_method = "95A2F54546DE3BDDF386F60F6C7576D6")
    
void _setWill(int option)
    {
        _options[option] |= _WILL_MASK;

        /* open TelnetOptionHandler functionality (start)*/
        if (_requestedWill(option))
        {
            if (optionHandlers[option] != null)
            {
                optionHandlers[option].setWill(true);

                int subneg[] =
                    optionHandlers[option].startSubnegotiationLocal();

                if (subneg != null)
                {
                    try
                    {
                        _sendSubnegotiation(subneg);
                    }
                    catch (Exception e)
                    {
                        System.err.println(
                            "Exception in option subnegotiation"
                            + e.getMessage());
                    }
                }
            }
        }
        /* open TelnetOptionHandler functionality (end)*/
    }

    /***
     * Sets the state of the option.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.889 -0500", hash_original_method = "8D1A748741E986595DDAF37DACF7707E", hash_generated_method = "56022E42011686843A810B775EA12434")
    
void _setDo(int option)
    {
        _options[option] |= _DO_MASK;

        /* open TelnetOptionHandler functionality (start)*/
        if (_requestedDo(option))
        {
            if (optionHandlers[option] != null)
            {
                optionHandlers[option].setDo(true);

                int subneg[] =
                    optionHandlers[option].startSubnegotiationRemote();

                if (subneg != null)
                {
                    try
                    {
                        _sendSubnegotiation(subneg);
                    }
                    catch (Exception e)
                    {
                        System.err.println("Exception in option subnegotiation"
                            + e.getMessage());
                    }
                }
            }
        }
        /* open TelnetOptionHandler functionality (end)*/
    }

    /***
     * Sets the state of the option.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.893 -0500", hash_original_method = "8D3B8F5535B73CDDF9BF8D27D7CC497B", hash_generated_method = "8D3B8F5535B73CDDF9BF8D27D7CC497B")
    
void _setWantWill(int option)
    {
        _options[option] |= _REQUESTED_WILL_MASK;
    }

    /***
     * Sets the state of the option.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.896 -0500", hash_original_method = "838B8546D14F7398B1EA6F37263E6517", hash_generated_method = "838B8546D14F7398B1EA6F37263E6517")
    
void _setWantDo(int option)
    {
        _options[option] |= _REQUESTED_DO_MASK;
    }

    /***
     * Sets the state of the option.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.900 -0500", hash_original_method = "C3ACE95402618EF7B8AAEF2B97B3E8C3", hash_generated_method = "EE677DA5C5FB5E5D66B5C1AA51C4AA62")
    
void _setWont(int option)
    {
        _options[option] &= ~_WILL_MASK;

        /* open TelnetOptionHandler functionality (start)*/
        if (optionHandlers[option] != null)
        {
            optionHandlers[option].setWill(false);
        }
        /* open TelnetOptionHandler functionality (end)*/
    }

    /***
     * Sets the state of the option.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.903 -0500", hash_original_method = "9272E1238094C237769096913B5B22FF", hash_generated_method = "DB6B3FEA0F8483C218336ADDCC728D71")
    
void _setDont(int option)
    {
        _options[option] &= ~_DO_MASK;

        /* open TelnetOptionHandler functionality (start)*/
        if (optionHandlers[option] != null)
        {
            optionHandlers[option].setDo(false);
        }
        /* open TelnetOptionHandler functionality (end)*/
    }

    /***
     * Sets the state of the option.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.907 -0500", hash_original_method = "322DCBCAE81D964565C547E136E2F152", hash_generated_method = "322DCBCAE81D964565C547E136E2F152")
    
void _setWantWont(int option)
    {
        _options[option] &= ~_REQUESTED_WILL_MASK;
    }

    /***
     * Sets the state of the option.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.911 -0500", hash_original_method = "E1712F68819C23F51EC20285F128AE0A", hash_generated_method = "E1712F68819C23F51EC20285F128AE0A")
    
void _setWantDont(int option)
    {
        _options[option] &= ~_REQUESTED_DO_MASK;
    }

    /***
     * Processes a DO request.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.915 -0500", hash_original_method = "72486AD20E48663272D3893E4646E398", hash_generated_method = "A8DB86084E9D6FD8B24832A28EC67FF9")
    
void _processDo(int option) throws IOException
    {
        if (debugoptions)
        {
            System.err.println("RECEIVED DO: "
                + TelnetOption.getOption(option));
        }

        if (__notifhand != null)
        {
            __notifhand.receivedNegotiation(
                TelnetNotificationHandler.RECEIVED_DO,
                option);
        }

        boolean acceptNewState = false;

        /* open TelnetOptionHandler functionality (start)*/
        if (optionHandlers[option] != null)
        {
            acceptNewState = optionHandlers[option].getAcceptLocal();
        }
        else
        {
        /* open TelnetOptionHandler functionality (end)*/
            /* TERMINAL-TYPE option (start)*/
            if (option == TERMINAL_TYPE)
            {
                if ((terminalType != null) && (terminalType.length() > 0))
                {
                    acceptNewState = true;
                }
            }
            /* TERMINAL-TYPE option (end)*/
        /* open TelnetOptionHandler functionality (start)*/
        }
        /* open TelnetOptionHandler functionality (end)*/

        if (_willResponse[option] > 0)
        {
            --_willResponse[option];
            if (_willResponse[option] > 0 && _stateIsWill(option))
            {
                --_willResponse[option];
            }
        }

        if (_willResponse[option] == 0)
        {
            if (_requestedWont(option))
            {

                switch (option)
                {

                default:
                    break;

                }

                if (acceptNewState)
                {
                    _setWantWill(option);
                    _sendWill(option);
                }
                else
                {
                    ++_willResponse[option];
                    _sendWont(option);
                }
            }
            else
            {
                // Other end has acknowledged option.

                switch (option)
                {

                default:
                    break;

                }

            }
        }

        _setWill(option);
    }

    /***
     * Processes a DONT request.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.921 -0500", hash_original_method = "23EF5170DA61C11337832D08CCCAA115", hash_generated_method = "E55605A6E191EC711CE6EAA47E805880")
    
void _processDont(int option) throws IOException
    {
        if (debugoptions)
        {
            System.err.println("RECEIVED DONT: "
                + TelnetOption.getOption(option));
        }
        if (__notifhand != null)
        {
            __notifhand.receivedNegotiation(
                TelnetNotificationHandler.RECEIVED_DONT,
                option);
        }
        if (_willResponse[option] > 0)
        {
            --_willResponse[option];
            if (_willResponse[option] > 0 && _stateIsWont(option))
            {
                --_willResponse[option];
            }
        }

        if (_willResponse[option] == 0 && _requestedWill(option))
        {

            switch (option)
            {

            default:
                break;

            }

            /* FIX for a BUG in the negotiation (start)*/
            if ((_stateIsWill(option)) || (_requestedWill(option)))
            {
                _sendWont(option);
            }

            _setWantWont(option);
            /* FIX for a BUG in the negotiation (end)*/
        }

        _setWont(option);
    }

    /***
     * Processes a WILL request.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.925 -0500", hash_original_method = "9793E04705FFD088D66045627DCAA850", hash_generated_method = "2F742925FADB1FDDF79355A7C4F82E50")
    
void _processWill(int option) throws IOException
    {
        if (debugoptions)
        {
            System.err.println("RECEIVED WILL: "
                + TelnetOption.getOption(option));
        }

        if (__notifhand != null)
        {
            __notifhand.receivedNegotiation(
                TelnetNotificationHandler.RECEIVED_WILL,
                option);
        }

        boolean acceptNewState = false;

        /* open TelnetOptionHandler functionality (start)*/
        if (optionHandlers[option] != null)
        {
            acceptNewState = optionHandlers[option].getAcceptRemote();
        }
        /* open TelnetOptionHandler functionality (end)*/

        if (_doResponse[option] > 0)
        {
            --_doResponse[option];
            if (_doResponse[option] > 0 && _stateIsDo(option))
            {
                --_doResponse[option];
            }
        }

        if (_doResponse[option] == 0 && _requestedDont(option))
        {

            switch (option)
            {

            default:
                break;

            }

            if (acceptNewState)
            {
                _setWantDo(option);
                _sendDo(option);
            }
            else
            {
                ++_doResponse[option];
                _sendDont(option);
            }
        }

        _setDo(option);
    }

    /***
     * Processes a WONT request.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - option code to be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.930 -0500", hash_original_method = "AF7DAD1D714DF080FC565FAE96651A27", hash_generated_method = "CDF7686F09824C4D3C14E96620EC69D0")
    
void _processWont(int option) throws IOException
    {
        if (debugoptions)
        {
            System.err.println("RECEIVED WONT: "
                + TelnetOption.getOption(option));
        }

        if (__notifhand != null)
        {
            __notifhand.receivedNegotiation(
                TelnetNotificationHandler.RECEIVED_WONT,
                option);
        }

        if (_doResponse[option] > 0)
        {
            --_doResponse[option];
            if (_doResponse[option] > 0 && _stateIsDont(option))
            {
                --_doResponse[option];
            }
        }

        if (_doResponse[option] == 0 && _requestedDo(option))
        {

            switch (option)
            {

            default:
                break;

            }

            /* FIX for a BUG in the negotiation (start)*/
            if ((_stateIsDo(option)) || (_requestedDo(option)))
            {
                _sendDont(option);
            }

            _setWantDont(option);
            /* FIX for a BUG in the negotiation (end)*/
        }

        _setDont(option);
    }

    /* TERMINAL-TYPE option (start)*/
    /***
     * Processes a suboption negotiation.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param suboption - subnegotiation data received
     * @param suboptionLength - length of data received
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.935 -0500", hash_original_method = "1B461CFEDE108391BF18561515EECEBE", hash_generated_method = "3B8450A4C591D8C488E7034E2A5D10D7")
    
void _processSuboption(int suboption[], int suboptionLength)
    throws IOException
    {
        if (debug)
        {
            System.err.println("PROCESS SUBOPTION.");
        }

        /* open TelnetOptionHandler functionality (start)*/
        if (suboptionLength > 0)
        {
            if (optionHandlers[suboption[0]] != null)
            {
                int responseSuboption[] =
                  optionHandlers[suboption[0]].answerSubnegotiation(suboption,
                  suboptionLength);
                _sendSubnegotiation(responseSuboption);
            }
            else
            {
                if (suboptionLength > 1)
                {
                    if (debug)
                    {
                        for (int ii = 0; ii < suboptionLength; ii++)
                        {
                            System.err.println("SUB[" + ii + "]: "
                                + suboption[ii]);
                        }
                    }
                    if ((suboption[0] == TERMINAL_TYPE)
                        && (suboption[1] == TERMINAL_TYPE_SEND))
                    {
                        _sendTerminalType();
                    }
                }
            }
        }
        /* open TelnetOptionHandler functionality (end)*/
    }

    /***
     * Sends terminal type information.
     * <p>
     * @throws IOException - Exception in I/O.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.939 -0500", hash_original_method = "0B827177ECCFED838980DBF1AB09B4A3", hash_generated_method = "13E56EFD1A50068D82DD2473E890041A")
    
final synchronized void _sendTerminalType()
    throws IOException
    {
        if (debug)
        {
            System.err.println("SEND TERMINAL-TYPE: " + terminalType);
        }
        if (terminalType != null)
        {
            _output_.write(_COMMAND_SB);
            _output_.write(_COMMAND_IS);
            _output_.write(terminalType.getBytes());
            _output_.write(_COMMAND_SE);
            _output_.flush();
        }
    }

    /* TERMINAL-TYPE option (end)*/

    /* open TelnetOptionHandler functionality (start)*/
    /***
     * Manages subnegotiation for Terminal Type.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param subn - subnegotiation data to be sent
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.944 -0500", hash_original_method = "F90E0E400E4B2900768FED2E3201C465", hash_generated_method = "8DD0927B2454292A063335F6E08625C5")
    
final synchronized void _sendSubnegotiation(int subn[])
    throws IOException
    {
        if (debug)
        {
            System.err.println("SEND SUBNEGOTIATION: ");
            if (subn != null)
            {
                for (int ii = 0; ii < subn.length; ii++)
                {
                    System.err.println("subn["  + ii + "]=" + subn[ii]);
                }
            }
        }
        if (subn != null)
        {
            byte byteresp[] = new byte[subn.length];
            for (int ii = 0; ii < subn.length; ii++)
            {
                byteresp[ii] = (byte) subn[ii];
            }

            _output_.write(_COMMAND_SB);
            _output_.write(byteresp);
            _output_.write(_COMMAND_SE);

            /* Code Section added for sending the negotiation ASAP (start)*/
            _output_.flush();
            /* Code Section added for sending the negotiation ASAP (end)*/
        }
    }
    /* open TelnetOptionHandler functionality (end)*/

    /* Code Section added for supporting AYT (start)*/
    /***
     * Processes the response of an AYT
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.948 -0500", hash_original_method = "4CC5BDD9AC3F3A042B96690CFA963EE6", hash_generated_method = "AED4949FE3AAE1572680227DF7B4BA1E")
    
final synchronized void _processAYTResponse()
    {
        if (!aytFlag)
        {
            synchronized (aytMonitor)
            {
                aytFlag = true;
                try
                {
                    aytMonitor.notifyAll();
                }
                catch (Exception e)
                {
                    System.err.println("Exception notifying:" + e.getMessage());
                }
            }
        }
    }
    /* Code Section added for supporting AYT (end)*/

    /***
     * Called upon connection.
     * <p>
     * @throws IOException - Exception in I/O.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.956 -0500", hash_original_method = "8F401E92E0D1BB2B74D2C1DBF9D3F65E", hash_generated_method = "20F53E70F695FB0DB8855F1E77E63F38")
    
protected void _connectAction_() throws IOException
    {
        /* (start). BUGFIX: clean the option info for each connection*/
        for (int ii = 0; ii < TelnetOption.MAX_OPTION_VALUE + 1; ii++)
        {
            _doResponse[ii] = 0;
            _willResponse[ii] = 0;
            _options[ii] = 0;
            if (optionHandlers[ii] != null)
            {
                optionHandlers[ii].setDo(false);
                optionHandlers[ii].setWill(false);
            }
        }
        /* (end). BUGFIX: clean the option info for each connection*/

        super._connectAction_();
        _input_ = new BufferedInputStream(_input_);
        _output_ = new BufferedOutputStream(_output_);

        /* open TelnetOptionHandler functionality (start)*/
        for (int ii = 0; ii < TelnetOption.MAX_OPTION_VALUE + 1; ii++)
        {
            if (optionHandlers[ii] != null)
            {
                if (optionHandlers[ii].getInitLocal())
                {
                    try
                    {
                        _requestWill(optionHandlers[ii].getOptionCode());
                    }
                    catch (IOException e)
                    {
                        System.err.println(
                            "Exception while initializing option: "
                            + e.getMessage());
                    }
                }

                if (optionHandlers[ii].getInitRemote())
                {
                    try
                    {
                        _requestDo(optionHandlers[ii].getOptionCode());
                    }
                    catch (IOException e)
                    {
                        System.err.println(
                            "Exception while initializing option: "
                            + e.getMessage());
                    }
                }
            }
        }
        /* open TelnetOptionHandler functionality (end)*/
    }

    /***
     * Sends a DO.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.963 -0500", hash_original_method = "C2CB13972600F76BB48639CA034B1C26", hash_generated_method = "BE93D2D64BA5AB54040206A47E6A751C")
    
final synchronized void _sendDo(int option)
    throws IOException
    {
        if (debug || debugoptions)
        {
            System.err.println("DO: " + TelnetOption.getOption(option));
        }
        _output_.write(_COMMAND_DO);
        _output_.write(option);

        /* Code Section added for sending the negotiation ASAP (start)*/
        _output_.flush();
        /* Code Section added for sending the negotiation ASAP (end)*/
    }

    /***
     * Requests a DO.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.970 -0500", hash_original_method = "63EE6428D057E56283BE6B5B9916525D", hash_generated_method = "34E134139BD75D64FCA74CAA33B9DB05")
    
final synchronized void _requestDo(int option)
    throws IOException
    {
        if ((_doResponse[option] == 0 && _stateIsDo(option))
            || _requestedDo(option))
        {
            return ;
        }
        _setWantDo(option);
        ++_doResponse[option];
        _sendDo(option);
    }

    /***
     * Sends a DONT.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.977 -0500", hash_original_method = "CFB1A151895061CB7F5CB4DF56AD3E67", hash_generated_method = "6EF3DDDF1A50D65D4C137EFF052DB3F8")
    
final synchronized void _sendDont(int option)
    throws IOException
    {
        if (debug || debugoptions)
        {
            System.err.println("DONT: " + TelnetOption.getOption(option));
        }
        _output_.write(_COMMAND_DONT);
        _output_.write(option);

        /* Code Section added for sending the negotiation ASAP (start)*/
        _output_.flush();
        /* Code Section added for sending the negotiation ASAP (end)*/
    }

    /***
     * Requests a DONT.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.982 -0500", hash_original_method = "82E37ECA0641DACABA32320F806C2144", hash_generated_method = "3EA9F7A19013669A6C71154EC0034F8C")
    
final synchronized void _requestDont(int option)
    throws IOException
    {
        if ((_doResponse[option] == 0 && _stateIsDont(option))
            || _requestedDont(option))
        {
            return ;
        }
        _setWantDont(option);
        ++_doResponse[option];
        _sendDont(option);
    }

    /***
     * Sends a WILL.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.986 -0500", hash_original_method = "6336C9E152BF9657042270231049327C", hash_generated_method = "F7106332090212C97007C6DDFFEF2CB5")
    
final synchronized void _sendWill(int option)
    throws IOException
    {
        if (debug || debugoptions)
        {
            System.err.println("WILL: " + TelnetOption.getOption(option));
        }
        _output_.write(_COMMAND_WILL);
        _output_.write(option);

        /* Code Section added for sending the negotiation ASAP (start)*/
        _output_.flush();
        /* Code Section added for sending the negotiation ASAP (end)*/
    }

    /***
     * Requests a WILL.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.990 -0500", hash_original_method = "9F4DF343DCBEC04991EBDE6ED7288C44", hash_generated_method = "6F00E9C69051D804E6CB090610FEE3B0")
    
final synchronized void _requestWill(int option)
    throws IOException
    {
        if ((_willResponse[option] == 0 && _stateIsWill(option))
            || _requestedWill(option))
        {
            return ;
        }
        _setWantWill(option);
        ++_doResponse[option];
        _sendWill(option);
    }

    /***
     * Sends a WONT.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.993 -0500", hash_original_method = "78058D86B1DA19EC155CBECCBB2F5E73", hash_generated_method = "D250ACA0374EC8B1DFB7E338C6A2433B")
    
final synchronized void _sendWont(int option)
    throws IOException
    {
        if (debug || debugoptions)
        {
            System.err.println("WONT: " + TelnetOption.getOption(option));
        }
        _output_.write(_COMMAND_WONT);
        _output_.write(option);

        /* Code Section added for sending the negotiation ASAP (start)*/
        _output_.flush();
        /* Code Section added for sending the negotiation ASAP (end)*/
    }

    /***
     * Requests a WONT.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param option - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:58.998 -0500", hash_original_method = "35265A493F0E0565DD01B430CD5CF199", hash_generated_method = "D16A86D975EB7971AAFB535B139AEDDF")
    
final synchronized void _requestWont(int option)
    throws IOException
    {
        if ((_willResponse[option] == 0 && _stateIsWont(option))
            || _requestedWont(option))
        {
            return ;
        }
        _setWantWont(option);
        ++_doResponse[option];
        _sendWont(option);
    }

    /***
     * Sends a byte.
     * <p>
     * @throws IOException - Exception in I/O.
     * <p>
     * @param b - byte to send
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.003 -0500", hash_original_method = "8841F2E44383E41481F2ECC220E4B721", hash_generated_method = "8571C7E45CC46B8D5860C4127F049779")
    
final synchronized void _sendByte(int b)
    throws IOException
    {
        _output_.write(b);

        /* Code Section added for supporting spystreams (start)*/
        _spyWrite(b);
        /* Code Section added for supporting spystreams (end)*/

    }

    /* Code Section added for supporting AYT (start)*/
    /***
     * Sends an Are You There sequence and waits for the result.
     * <p>
     * @throws IOException - Exception in I/O.
     * @throws IllegalArgumentException - Illegal argument
     * @throws InterruptedException - Interrupted during wait.
     * <p>
     * @param timeout - Time to wait for a response (millis.)
     * <p>
     * @return true if AYT received a response, false otherwise
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.007 -0500", hash_original_method = "39D4FA4E53CEE799776950AA9CB6A596", hash_generated_method = "A41F7A84816F870251D88012C856C818")
    
final boolean _sendAYT(long timeout)
    throws IOException, IllegalArgumentException, InterruptedException
    {
        boolean retValue = false;
        synchronized (aytMonitor)
        {
            synchronized (this)
            {
                aytFlag = false;
                _output_.write(_COMMAND_AYT);
                _output_.flush();
            }

            try
            {
                aytMonitor.wait(timeout);
                if (aytFlag == false)
                {
                    retValue = false;
                    aytFlag = true;
                }
                else
                {
                    retValue = true;
                }
            }
            catch (IllegalMonitorStateException e)
            {
                System.err.println("Exception processing AYT:"
                    + e.getMessage());
            }
        }

        return (retValue);
    }
    /* Code Section added for supporting AYT (end)*/

    /* open TelnetOptionHandler functionality (start)*/

    /***
     * Registers a new TelnetOptionHandler for this telnet  to use.
     * <p>
     * @throws InvalidTelnetOptionException - The option code is invalid.
     * <p>
     * @param opthand - option handler to be registered.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.011 -0500", hash_original_method = "6342C2CFD6C87CB10ADDB26CDC52A77E", hash_generated_method = "6342C2CFD6C87CB10ADDB26CDC52A77E")
    
void addOptionHandler(TelnetOptionHandler opthand)
    throws InvalidTelnetOptionException
    {
        int optcode = opthand.getOptionCode();
        if (TelnetOption.isValidOption(optcode))
        {
            if (optionHandlers[optcode] == null)
            {
                optionHandlers[optcode] = opthand;
                if (isConnected())
                {
                    if (opthand.getInitLocal())
                    {
                        try
                        {
                            _requestWill(optcode);
                        }
                        catch (IOException e)
                        {
                            System.err.println(
                                "Exception while initializing option: "
                                + e.getMessage());
                        }
                    }

                    if (opthand.getInitRemote())
                    {
                        try
                        {
                            _requestDo(optcode);
                        }
                        catch (IOException e)
                        {
                            System.err.println(
                                "Exception while initializing option: "
                                + e.getMessage());
                        }
                    }
                }
            }
            else
            {
                throw (new InvalidTelnetOptionException(
                    "Already registered option", optcode));
            }
        }
        else
        {
            throw (new InvalidTelnetOptionException(
                "Invalid Option Code", optcode));
        }
    }

    /***
     * Unregisters a  TelnetOptionHandler.
     * <p>
     * @throws InvalidTelnetOptionException - The option code is invalid.
     * <p>
     * @param optcode - Code of the option to be unregistered.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.016 -0500", hash_original_method = "6EA2A1EF33A119B08A2C10DE631D1BE2", hash_generated_method = "6EA2A1EF33A119B08A2C10DE631D1BE2")
    
void deleteOptionHandler(int optcode)
    throws InvalidTelnetOptionException
    {
        if (TelnetOption.isValidOption(optcode))
        {
            if (optionHandlers[optcode] == null)
            {
                throw (new InvalidTelnetOptionException(
                    "Unregistered option", optcode));
            }
            else
            {
                TelnetOptionHandler opthand = optionHandlers[optcode];
                optionHandlers[optcode] = null;

                if (opthand.getWill())
                {
                    try
                    {
                        _requestWont(optcode);
                    }
                    catch (IOException e)
                    {
                        System.err.println(
                            "Exception while turning off option: "
                            + e.getMessage());
                    }
                }

                if (opthand.getDo())
                {
                    try
                    {
                        _requestDont(optcode);
                    }
                    catch (IOException e)
                    {
                        System.err.println(
                            "Exception while turning off option: "
                            + e.getMessage());
                    }
                }
            }
        }
        else
        {
            throw (new InvalidTelnetOptionException(
                "Invalid Option Code", optcode));
        }
    }
    /* open TelnetOptionHandler functionality (end)*/

    /* Code Section added for supporting spystreams (start)*/
    /***
     * Registers an OutputStream for spying what's going on in
     * the Telnet session.
     * <p>
     * @param spystream - OutputStream on which session activity
     * will be echoed.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.022 -0500", hash_original_method = "D017ED5C17A9CECD66D6C4AE3017BF4F", hash_generated_method = "D017ED5C17A9CECD66D6C4AE3017BF4F")
    
void _registerSpyStream(OutputStream  spystream)
    {
        spyStream = spystream;
    }

    /***
     * Stops spying this Telnet.
     * <p>
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.027 -0500", hash_original_method = "69E83F9740A898EB53687AFE8414C4DE", hash_generated_method = "69E83F9740A898EB53687AFE8414C4DE")
    
void _stopSpyStream()
    {
        spyStream = null;
    }

    /***
     * Sends a read char on the spy stream.
     * <p>
     * @param ch - character read from the session
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.032 -0500", hash_original_method = "5AEB6F027685AF0CCAB12374EBFEEB6C", hash_generated_method = "5AEB6F027685AF0CCAB12374EBFEEB6C")
    
void _spyRead(int ch)
    {
        if (spyStream != null)
        {
            try
            {
                if (ch != (int) '\r')
                {
                    spyStream.write(ch);
                    if (ch == (int) '\n')
                    {
                        spyStream.write((int) '\r');
                    }
                    spyStream.flush();
                }
            }
            catch (Exception e)
            {
                spyStream = null;
            }
        }
    }

    /***
     * Sends a written char on the spy stream.
     * <p>
     * @param ch - character written to the session
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.036 -0500", hash_original_method = "C02000F90B17D3CB29391F2C5B8E021A", hash_generated_method = "C02000F90B17D3CB29391F2C5B8E021A")
    
void _spyWrite(int ch)
    {
        if (!(_stateIsDo(TelnetOption.ECHO)
            && _requestedDo(TelnetOption.ECHO)))
        {
            if (spyStream != null)
            {
                try
                {
                    spyStream.write(ch);
                    spyStream.flush();
                }
                catch (Exception e)
                {
                    spyStream = null;
                }
            }
        }
    }
    /* Code Section added for supporting spystreams (end)*/

    /***
     * Registers a notification handler to which will be sent
     * notifications of received telnet option negotiation commands.
     * <p>
     * @param notifhand - TelnetNotificationHandler to be registered
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.039 -0500", hash_original_method = "64C4C862491F960E8DEBBD66833128C1", hash_generated_method = "0AEFB87EE015AAA01F35FE44F6807EAF")
    
public void registerNotifHandler(TelnetNotificationHandler  notifhand)
    {
        __notifhand = notifhand;
    }

    /***
     * Unregisters the current notification handler.
     * <p>
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.045 -0500", hash_original_method = "80BC7186A49A4C21DCD2AD9B9D266EE5", hash_generated_method = "DFA59F9CD1F3FB4E73932E49179602A6")
    
public void unregisterNotifHandler()
    {
        __notifhand = null;
    }
}
