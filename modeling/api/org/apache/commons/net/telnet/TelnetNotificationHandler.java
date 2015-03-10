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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.net.telnet;

/***
 * The TelnetNotificationHandler interface can be used to handle
 * notification of options negotiation commands received on a telnet
 * session.
 * <p>
 * The user can implement this interface and register a
 * TelnetNotificationHandler by using the registerNotificationHandler()
 * of TelnetClient to be notified of option negotiation commands.
 * <p>
 * <p>
 * @author Bruno D'Avanzo
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface TelnetNotificationHandler
{
    /***
     * The remote party sent a DO command.
     ***/
    public static final int RECEIVED_DO =   1;

    /***
     * The remote party sent a DONT command.
     ***/
    public static final int RECEIVED_DONT = 2;

    /***
     * The remote party sent a WILL command.
     ***/
    public static final int RECEIVED_WILL = 3;

    /***
     * The remote party sent a WONT command.
     ***/
    public static final int RECEIVED_WONT = 4;

    /***
     * Callback method called when TelnetClient receives an option
     * negotiation command.
     * <p>
     * @param negotiation_code - type of negotiation command received
     * (RECEIVED_DO, RECEIVED_DONT, RECEIVED_WILL, RECEIVED_WONT)
     * <p>
     * @param option_code - code of the option negotiated
     * <p>
     ***/
    public void receivedNegotiation(int negotiation_code, int option_code);
}
