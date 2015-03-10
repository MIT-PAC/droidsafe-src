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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import libcore.util.EmptyArray;

class DefaultSSLSocketFactory extends SSLSocketFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.472 -0500", hash_original_field = "E54DFF2DC8E1BA5EA237533EDA39F4E1", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")

    private  String errMessage;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.475 -0500", hash_original_method = "518A173F954BA705CC3BF505F9E13E1E", hash_generated_method = "518A173F954BA705CC3BF505F9E13E1E")
    
DefaultSSLSocketFactory(String mes) {
        errMessage = mes;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.477 -0500", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "75E10C557E5ED421A6A96DF7BC668ED0")
    
@Override
    public String[] getDefaultCipherSuites() {
        return EmptyArray.STRING;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.479 -0500", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "EF7DACA8298C2A694CB6406898565668")
    
@Override
    public String[] getSupportedCipherSuites() {
        return EmptyArray.STRING;
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.482 -0500", hash_original_method = "80973C4D16E76F8CBD9DC9AFB2C6FFD0", hash_generated_method = "6EBAF01E1F87B4F98807BB35F93C5767")
    
@Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose)
            throws IOException {
        throw new SocketException(errMessage);
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.484 -0500", hash_original_method = "DA3DD563FBA8107A1A984067F5EE0D59", hash_generated_method = "CF2B7BD2E499DE8EDAF1497936B5E575")
    
@Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        throw new SocketException(errMessage);
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.486 -0500", hash_original_method = "8FF7B0825A4C1BFCEAEA97A8A771852A", hash_generated_method = "E792147CB79D4084BA10F628E05558E0")
    
@Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException, UnknownHostException {
        throw new SocketException(errMessage);
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.488 -0500", hash_original_method = "F1FA6E0F26B33554BE365A5605459FC6", hash_generated_method = "01E657A444AE33450DAAD4FCDC864D9F")
    
@Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        throw new SocketException(errMessage);
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.491 -0500", hash_original_method = "5A01435F50BC90BAF50A86E164E9FD29", hash_generated_method = "8B1E74E365203C30AD925F3436ECAFC3")
    
@Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        throw new SocketException(errMessage);
    }
    
}

