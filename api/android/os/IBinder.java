package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;

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
