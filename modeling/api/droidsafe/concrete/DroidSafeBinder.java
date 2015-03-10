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
 */

package droidsafe.concrete;

import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.*;
import java.io.FileDescriptor;

public class DroidSafeBinder implements IBinder {

    private Messenger mMessenger;

    @DSBan
    public DroidSafeBinder(DSOnlyType dontcare) {
    	Parcel p = new Parcel(DSOnlyType.DONTCARE);
    	this.mMessenger = Messenger.CREATOR.createFromParcel(p);
    }

    @DSBan
    public DroidSafeBinder(Messenger messenger) {
        this.mMessenger = messenger;
    }

    public Messenger getMessenger() {
        return mMessenger;
    }

    public String getInterfaceDescriptor() throws RemoteException {
        return new String("<DroidSafeBinder.getInterfaceDescription>");
    }
    
    public boolean pingBinder() {
        return true;
    }
    
    public boolean isBinderAlive() {
        return true;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public IInterface queryLocalInterface(String descriptor) {
        //something with AIDL?

        //might need to implement at some point
        return null;
    }
    
    public void dump(FileDescriptor fd, String[] args) throws RemoteException {
        fd.addTaint(args[0].getTaint());
    }
    
    public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException {
        fd.addTaint(args[0].getTaint());
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public boolean transact(int code, Parcel data, Parcel reply, int flags)
        throws RemoteException {
        //don't know what calls this???
        //don't know what to do...
        reply.addTaint(data.getTaint());
        return true;
    }
    
    public void linkToDeath(DeathRecipient recipient, int flags)
        throws RemoteException {
        //don't know what to do
    }
    
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        return true;
    }
}
