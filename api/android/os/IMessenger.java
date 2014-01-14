package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IMessenger extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.os.IMessenger
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.165 -0500", hash_original_field = "DF849814D4BB6B092CCB3F421C96788A", hash_generated_field = "D507E30E59CFDA7C821864CB6B893FC0")

private static final java.lang.String DESCRIPTOR = "android.os.IMessenger";
/**
 * Cast an IBinder object into an android.os.IMessenger interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.171 -0500", hash_original_method = "9EEB94A5F867AE66BB9F2402734B3028", hash_generated_method = "3FAC0A872A86DE0F8F6E05F208E516D4")
        
public static android.os.IMessenger asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.os.IMessenger))) {
return ((android.os.IMessenger)iin);
}
return new android.os.IMessenger.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.192 -0500", hash_original_field = "49366EFE0D28C045154926D644CFD02D", hash_generated_field = "52E1D852A9DAE5C062A6C702520EC61E")

static final int TRANSACTION_send = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.168 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.173 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.os.IMessenger
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.179 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.181 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.184 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.186 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.188 -0500", hash_original_method = "0B9407E4F047F89A98FEBC2D73FE3E35", hash_generated_method = "3CBC19891766532024F2C18A97124E0A")
            
public void send(android.os.Message msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((msg!=null)) {
_data.writeInt(1);
msg.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_send, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.176 -0500", hash_original_method = "59DE1A9210D9695DF72D5AC771ACC7B0", hash_generated_method = "9F628AD840C4E373B79B08F385B9259C")
        
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
android.os.Message _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Message.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.send(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void send(android.os.Message msg) throws android.os.RemoteException;
}
