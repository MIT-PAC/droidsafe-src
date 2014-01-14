package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IIntentSender extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.IIntentSender
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.157 -0500", hash_original_field = "2074D2BB42EC445459359681A7AB299E", hash_generated_field = "8EF31B877A498A419872D571CF2662CF")

private static final java.lang.String DESCRIPTOR = "android.content.IIntentSender";
/**
 * Cast an IBinder object into an android.content.IIntentSender interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.162 -0500", hash_original_method = "5AA2F4956AB0B41C94C2AC2B931E32D0", hash_generated_method = "991CDFCCAD09E7A3198B408E586166AC")
        
public static android.content.IIntentSender asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.IIntentSender))) {
return ((android.content.IIntentSender)iin);
}
return new android.content.IIntentSender.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.186 -0500", hash_original_field = "49366EFE0D28C045154926D644CFD02D", hash_generated_field = "52E1D852A9DAE5C062A6C702520EC61E")

static final int TRANSACTION_send = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.160 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.165 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.content.IIntentSender
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.171 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.174 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.176 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.179 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.182 -0500", hash_original_method = "E630EB1DDC4CFC2AE226C005A5E9FCFB", hash_generated_method = "C67EC575FBE66FA93FE1B3524EFAD705")
            
public int send(int code, android.content.Intent intent, java.lang.String resolvedType, android.content.IIntentReceiver finishedReceiver, java.lang.String requiredPermission) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(code);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeStrongBinder((((finishedReceiver!=null))?(finishedReceiver.asBinder()):(null)));
_data.writeString(requiredPermission);
mRemote.transact(Stub.TRANSACTION_send, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.168 -0500", hash_original_method = "E31851C649D163E7C22CA1F5F0C09D4A", hash_generated_method = "034D71EA3846C16FDB91CD1686F6FD57")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_send:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.content.Intent _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String _arg2;
_arg2 = data.readString();
android.content.IIntentReceiver _arg3;
_arg3 = android.content.IIntentReceiver.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg4;
_arg4 = data.readString();
int _result = this.send(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public int send(int code, android.content.Intent intent, java.lang.String resolvedType, android.content.IIntentReceiver finishedReceiver, java.lang.String requiredPermission) throws android.os.RemoteException;
}
