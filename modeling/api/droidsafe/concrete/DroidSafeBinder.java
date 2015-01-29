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
