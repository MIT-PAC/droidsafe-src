package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IRemoteViewsAdapterConnection extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.widget.IRemoteViewsAdapterConnection
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.499 -0500", hash_original_field = "D5AFF62E2E307D90341284E958C6BF59", hash_generated_field = "B9F30E377A5082772308D3E8430DB642")

private static final java.lang.String DESCRIPTOR = "com.android.internal.widget.IRemoteViewsAdapterConnection";
/**
 * Cast an IBinder object into an com.android.internal.widget.IRemoteViewsAdapterConnection interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.505 -0500", hash_original_method = "6AB09997C8B5D6291ABDE939D13F2858", hash_generated_method = "7F1194DD2AF0391E99352BC9C29E0D80")
        
public static com.android.internal.widget.IRemoteViewsAdapterConnection asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.widget.IRemoteViewsAdapterConnection))) {
return ((com.android.internal.widget.IRemoteViewsAdapterConnection)iin);
}
return new com.android.internal.widget.IRemoteViewsAdapterConnection.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.532 -0500", hash_original_field = "75717EBA9827695882150C3144756037", hash_generated_field = "70F177E84AB0EB2D64F4E97C70CB56C4")

static final int TRANSACTION_onServiceConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.535 -0500", hash_original_field = "90A9521EEF62836B072FCE46702A2DFF", hash_generated_field = "23A39E067C3329D042899CEA24197BF2")

static final int TRANSACTION_onServiceDisconnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.502 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements com.android.internal.widget.IRemoteViewsAdapterConnection
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.513 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.516 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.520 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.522 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.524 -0500", hash_original_method = "556A8A343D84FF8594D48950C217CBA7", hash_generated_method = "29FFB28C12E7BAE1A20FA334276D55DD")
            
public void onServiceConnected(android.os.IBinder service) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(service);
mRemote.transact(Stub.TRANSACTION_onServiceConnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.527 -0500", hash_original_method = "6862926BE2A8BE2FBBA7281A1BB26442", hash_generated_method = "F0356E3C3342962F5799F6B2F7AF5BD3")
            
public void onServiceDisconnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onServiceDisconnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.507 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:42.510 -0500", hash_original_method = "BA6A56816928976581A8864331AB6F45", hash_generated_method = "1A2573D8EA23CFBAA91454BAF190C519")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onServiceConnected:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.onServiceConnected(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onServiceDisconnected:
{
data.enforceInterface(DESCRIPTOR);
this.onServiceDisconnected();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onServiceConnected(android.os.IBinder service) throws android.os.RemoteException;
public void onServiceDisconnected() throws android.os.RemoteException;
}
