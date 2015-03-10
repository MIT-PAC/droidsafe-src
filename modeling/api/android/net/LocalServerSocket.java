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


package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;

public class LocalServerSocket {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.236 -0500", hash_original_field = "408790E787214E00C0BEAB2B510EDC0A", hash_generated_field = "CF3B17719A06AE9E2539F6BC60A2C73B")

    private static final int LISTEN_BACKLOG = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.231 -0500", hash_original_field = "C64187E1E8E3968144AF18D9B41A1645", hash_generated_field = "9FC425CCAE80D9162FEB6CEC3E95B3C0")

    private  LocalSocketImpl impl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.233 -0500", hash_original_field = "6EA039161543E3A8643CEA026FAED862", hash_generated_field = "998A409B350B5C2296F10AA66491F7E9")

    private  LocalSocketAddress localAddress;

    /**
     * Crewates a new server socket listening at specified name.
     * On the Android platform, the name is created in the Linux
     * abstract namespace (instead of on the filesystem).
     * 
     * @param name address for socket
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.239 -0500", hash_original_method = "84F635671A3C26E6B4F1228C3E17A491", hash_generated_method = "544C09CA031344D5713194550EB2CB9D")
    
public LocalServerSocket(String name) throws IOException
    {
        impl = new LocalSocketImpl();

        impl.create(true);

        localAddress = new LocalSocketAddress(name);
        impl.bind(localAddress);

        impl.listen(LISTEN_BACKLOG);
    }

    /**
     * Create a LocalServerSocket from a file descriptor that's already
     * been created and bound. listen() will be called immediately on it.
     * Used for cases where file descriptors are passed in via environment
     * variables
     *
     * @param fd bound file descriptor
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.241 -0500", hash_original_method = "40EEF7A0A264136F662D7E1DA715A559", hash_generated_method = "73B4F21232108BF5282CD85457539E41")
    
public LocalServerSocket(FileDescriptor fd) throws IOException
    {
        impl = new LocalSocketImpl(fd);
        impl.listen(LISTEN_BACKLOG);
        localAddress = impl.getSockAddress();
    }

    /**
     * Obtains the socket's local address
     *
     * @return local address
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.243 -0500", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "7955BA736BD8AD783B98FFDED7E574D5")
    
public LocalSocketAddress getLocalSocketAddress()
    {
        return localAddress;
    }

    /**
     * Accepts a new connection to the socket. Blocks until a new
     * connection arrives.
     *
     * @return a socket representing the new connection.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.245 -0500", hash_original_method = "4C7BE72C58D9A70D111AB53708810EA4", hash_generated_method = "AF157A7772AD2D9C1E3D30BCBFFC6CCE")
    
public LocalSocket accept() throws IOException
    {
        LocalSocketImpl acceptedImpl = new LocalSocketImpl();

        impl.accept (acceptedImpl);

        return new LocalSocket(acceptedImpl);
    }

    /**
     * Returns file descriptor or null if not yet open/already closed
     *
     * @return fd or null
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.247 -0500", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "0FA483774DCFD89C5E0A6792E5C45D30")
    
public FileDescriptor getFileDescriptor() {
        return impl.getFileDescriptor();
    }

    /**
     * Closes server socket.
     * 
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.249 -0500", hash_original_method = "CB913E335DEA23070E332AEE6AD401FB", hash_generated_method = "6011C7E32F9FE962048F224607A5A908")
    
public void close() throws IOException
    {
        impl.close();
    }
}

