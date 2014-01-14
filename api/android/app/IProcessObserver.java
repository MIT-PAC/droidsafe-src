package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IProcessObserver extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IProcessObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.454 -0500", hash_original_field = "254830544641C80598FB481BA9AF7812", hash_generated_field = "5E83CA72720DEFB32CE59DDE994D35A7")

private static final java.lang.String DESCRIPTOR = "android.app.IProcessObserver";
/**
 * Cast an IBinder object into an android.app.IProcessObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.459 -0500", hash_original_method = "3D7CD1AA9B4A012353790D3B45E610FF", hash_generated_method = "681F8E156207E929DF7CAB8FBA79BE01")
        
public static android.app.IProcessObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IProcessObserver))) {
return ((android.app.IProcessObserver)iin);
}
return new android.app.IProcessObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.484 -0500", hash_original_field = "1F8133FEBC08B345E54B1B179FDA8C48", hash_generated_field = "2463CAE7B72C312B39BDF798DE680E07")

static final int TRANSACTION_onForegroundActivitiesChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.486 -0500", hash_original_field = "329B4F24598B970CFE12F870BD7FF457", hash_generated_field = "DCEEEACA349AE16F735814D3394545D8")

static final int TRANSACTION_onProcessDied = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.456 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.app.IProcessObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.467 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.470 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.472 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.474 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.477 -0500", hash_original_method = "90375E6CEF3F09CE697DDB82649ACCBA", hash_generated_method = "F52C663AB4CFA1CE455A669A88BE0420")
            
public void onForegroundActivitiesChanged(int pid, int uid, boolean foregroundActivities) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(pid);
_data.writeInt(uid);
_data.writeInt(((foregroundActivities)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onForegroundActivitiesChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.479 -0500", hash_original_method = "A4055B8A490EFAA4EF004CBE1E070099", hash_generated_method = "B2F2BF0C776380472C7BE9EF7A9CC6CE")
            
public void onProcessDied(int pid, int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(pid);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_onProcessDied, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.461 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.464 -0500", hash_original_method = "30FD1457B07367D53E1005B1A8DA841A", hash_generated_method = "1E32B3E92B3D628856C9A8E34F6DC214")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onForegroundActivitiesChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.onForegroundActivitiesChanged(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_onProcessDied:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.onProcessDied(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onForegroundActivitiesChanged(int pid, int uid, boolean foregroundActivities) throws android.os.RemoteException;
public void onProcessDied(int pid, int uid) throws android.os.RemoteException;
}
