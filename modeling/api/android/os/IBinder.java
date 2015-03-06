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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;

public interface IBinder {
    
    int FIRST_CALL_TRANSACTION  = 0x00000001;
    
    int LAST_CALL_TRANSACTION   = 0x00ffffff;
    
    
    int PING_TRANSACTION        = ('_'<<24)|('P'<<16)|('N'<<8)|'G';
    
    
    int DUMP_TRANSACTION        = ('_'<<24)|('D'<<16)|('M'<<8)|'P';
    
    
    int INTERFACE_TRANSACTION   = ('_'<<24)|('N'<<16)|('T'<<8)|'F';

    
    int TWEET_TRANSACTION   = ('_'<<24)|('T'<<16)|('W'<<8)|'T';

    
    int LIKE_TRANSACTION   = ('_'<<24)|('L'<<16)|('I'<<8)|'K';

    
    int FLAG_ONEWAY             = 0x00000001;
    
    
    public String getInterfaceDescriptor() throws RemoteException;

    
    public boolean pingBinder();

    
    public boolean isBinderAlive();
    
    
    public IInterface queryLocalInterface(String descriptor);
    
    
    public void dump(FileDescriptor fd, String[] args) throws RemoteException;
    
    
    public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException;

    
    public boolean transact(int code, Parcel data, Parcel reply, int flags)
        throws RemoteException;

    
    public interface DeathRecipient {
        public void binderDied();
    }

    
    public void linkToDeath(DeathRecipient recipient, int flags)
            throws RemoteException;

    
    public boolean unlinkToDeath(DeathRecipient recipient, int flags);
}
