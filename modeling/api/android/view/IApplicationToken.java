package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IApplicationToken extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.IApplicationToken
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.786 -0500", hash_original_field = "F2F5FD9B10B683D8EDC80564E3D5B514", hash_generated_field = "37238863309769F2DF80FA5E5A76B04D")

private static final java.lang.String DESCRIPTOR = "android.view.IApplicationToken";
/**
 * Cast an IBinder object into an android.view.IApplicationToken interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.792 -0500", hash_original_method = "58E4D30DA2D8F7140536560B707442E1", hash_generated_method = "230FCF890ED8CD6BD0A35E3C4F69D723")
        
public static android.view.IApplicationToken asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.IApplicationToken))) {
return ((android.view.IApplicationToken)iin);
}
return new android.view.IApplicationToken.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.828 -0500", hash_original_field = "329E87FDF641F1D8C259D035D65B9910", hash_generated_field = "F8DF5752559BD4A0AEF141B3EEBD7C71")

static final int TRANSACTION_windowsDrawn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.830 -0500", hash_original_field = "5684466740AF7C189EA5D7DDA86BC5E5", hash_generated_field = "9EB6DD166A709E1AA3EC190EBFF8582E")

static final int TRANSACTION_windowsVisible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.833 -0500", hash_original_field = "54C00C8F3949290FCF7AD5E5B1D75088", hash_generated_field = "16F580063484EB4A1213BCC62A5DA4BF")

static final int TRANSACTION_windowsGone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.view.IApplicationToken
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.801 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.804 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.806 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.808 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.811 -0500", hash_original_method = "5E844EABFAD529FFED7CAE37CF4EB835", hash_generated_method = "4D5F572119D5C1DD95DDFD6A53094C38")
            
public void windowsDrawn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_windowsDrawn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.813 -0500", hash_original_method = "B3DDA5CA916C711ED3FC7C686259C0A3", hash_generated_method = "7FF7AF2C77DF2A2EA7D71C783021C7A5")
            
public void windowsVisible() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_windowsVisible, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.816 -0500", hash_original_method = "38FEF650EC16F1E5039E5FAD58A379F4", hash_generated_method = "B5C5546C2DF1F64D816331E73B8687EB")
            
public void windowsGone() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_windowsGone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.819 -0500", hash_original_method = "483150DF1E8C12AC360A829068930990", hash_generated_method = "BB5AE1ADC3A2BC6CC462F2890152A6FF")
            
public boolean keyDispatchingTimedOut() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_keyDispatchingTimedOut, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.823 -0500", hash_original_method = "278FD30504A338610305AC113150BB7A", hash_generated_method = "E7674E0AD353102655CD7A578DABC5BF")
            
public long getKeyDispatchingTimeout() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getKeyDispatchingTimeout, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.835 -0500", hash_original_field = "290E1CAD5C569CD98B3315217934C1A2", hash_generated_field = "1B36FA5E8EB25E8A1B0B3D06BD76AD61")

static final int TRANSACTION_keyDispatchingTimedOut = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.838 -0500", hash_original_field = "78AFFCC2CC06C3F997DF55C5A338FDBF", hash_generated_field = "A032BB3E30A75405EEF133C30565D15F")

static final int TRANSACTION_getKeyDispatchingTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.789 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.795 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.798 -0500", hash_original_method = "7E016E86AAECF7E3FCCE37A0C8C76373", hash_generated_method = "94944A90AB7404381257BB597E3EC468")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_windowsDrawn:
{
data.enforceInterface(DESCRIPTOR);
this.windowsDrawn();
reply.writeNoException();
return true;
}
case TRANSACTION_windowsVisible:
{
data.enforceInterface(DESCRIPTOR);
this.windowsVisible();
reply.writeNoException();
return true;
}
case TRANSACTION_windowsGone:
{
data.enforceInterface(DESCRIPTOR);
this.windowsGone();
reply.writeNoException();
return true;
}
case TRANSACTION_keyDispatchingTimedOut:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.keyDispatchingTimedOut();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getKeyDispatchingTimeout:
{
data.enforceInterface(DESCRIPTOR);
long _result = this.getKeyDispatchingTimeout();
reply.writeNoException();
reply.writeLong(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void windowsDrawn() throws android.os.RemoteException;
public void windowsVisible() throws android.os.RemoteException;
public void windowsGone() throws android.os.RemoteException;
public boolean keyDispatchingTimedOut() throws android.os.RemoteException;
public long getKeyDispatchingTimeout() throws android.os.RemoteException;
}
