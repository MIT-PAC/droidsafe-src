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


package org.apache.commons.net.tftp;

/***
 * A class used to signify the occurrence of an error in the creation of
 * a TFTP packet.  It is not declared final so that it may be subclassed
 * to identify more specific errors.  You would only want to do this if
 * you were building your own TFTP client or server on top of the
 * {@link org.apache.commons.net.tftp.TFTP}
 * class if you
 * wanted more functionality than the
 * {@link org.apache.commons.net.tftp.TFTPClient#receiveFile receiveFile()}
 * and
 * {@link org.apache.commons.net.tftp.TFTPClient#sendFile sendFile()}
 * methods provide.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see TFTPPacket
 * @see TFTP
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class TFTPPacketException extends Exception
{

    /***
     * Simply calls the corresponding constructor of its superclass.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.312 -0500", hash_original_method = "920DD3340F1E0137F4765138B1C75566", hash_generated_method = "46D0CA645E4940709444F87FC684C99E")
    
public TFTPPacketException()
    {
        super();
    }

    /***
     * Simply calls the corresponding constructor of its superclass.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.319 -0500", hash_original_method = "03263E664C0E0B65A45F88CCBC8C3A51", hash_generated_method = "E10EA6EEC145B90EF9BB144F87311C5E")
    
public TFTPPacketException(String message)
    {
        super(message);
    }
}
