package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IServiceConnection extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IServiceConnection
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.102 -0500", hash_original_field = "8DA02D58408FA300B5FBDDDECE80492B", hash_generated_field = "BDABC4DD988CE38EAF0834E9AAF58D88")

private static final java.lang.String DESCRIPTOR = "android.app.IServiceConnection";
/**
 * Cast an IBinder object into an android.app.IServiceConnection interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.107 -0500", hash_original_method = "C680002E81A4AE91F3EAB42E13B7E8A2", hash_generated_method = "91730C23A70188AFA2251C2ED68E5D99")
        
public static android.app.IServiceConnection asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IServiceConnection))) {
return ((android.app.IServiceConnection)iin);
}
return new android.app.IServiceConnection.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.130 -0500", hash_original_field = "41C758F880481D123EF79AB9A82F9BCC", hash_generated_field = "6636D0D002DDE3B12E90A904D40FABDD")

static final int TRANSACTION_connected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.105 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.110 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.app.IServiceConnection
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.116 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.118 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.120 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.123 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.125 -0500", hash_original_method = "6E9CE3FCC127704F01F9B36139D6F57B", hash_generated_method = "6CB3A07BFF8F1B60DAD65CC2244868ED")
            
public void connected(android.content.ComponentName name, android.os.IBinder service) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((name!=null)) {
_data.writeInt(1);
name.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder(service);
mRemote.transact(Stub.TRANSACTION_connected, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.112 -0500", hash_original_method = "72A5CF5E570AE99CD861B8A8890C005F", hash_generated_method = "D78379B6BC6F595FF5B804BC6BB7E9C4")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_connected:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
this.connected(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void connected(android.content.ComponentName name, android.os.IBinder service) throws android.os.RemoteException;
}
