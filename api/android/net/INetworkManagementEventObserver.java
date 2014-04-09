/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/net/INetworkManagementEventObserver.aidl
 */
package android.net;
/**
 * Callback class for receiving events from an INetworkManagementService
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface INetworkManagementEventObserver extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.net.INetworkManagementEventObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.369 -0400", hash_original_field = "47977D459687DA835892924E0E0CE3A5", hash_generated_field = "B87AB7D4D283631E9AC47337E9B2F1C8")

private static final java.lang.String DESCRIPTOR = "android.net.INetworkManagementEventObserver";
/**
 * Cast an IBinder object into an android.net.INetworkManagementEventObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.379 -0400", hash_original_method = "A4100E0E7F872FC7A5F68DCA30BB7350", hash_generated_method = "9B0C11A64A06407B59478462BF775B81")
        
public static android.net.INetworkManagementEventObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.INetworkManagementEventObserver))) {
return ((android.net.INetworkManagementEventObserver)iin);
}
return new android.net.INetworkManagementEventObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.438 -0400", hash_original_field = "A624F6D11275FE2BEBF495D133E2F9E3", hash_generated_field = "A9D85D164B42DD7DCE888EBFD61DD0F1")

static final int TRANSACTION_interfaceStatusChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.443 -0400", hash_original_field = "E52B297E48D8E4F3649D3B2A1DA1F342", hash_generated_field = "1E94B8B1ADC81C92DCC0B4F73B99D7FD")

static final int TRANSACTION_interfaceLinkStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.447 -0400", hash_original_field = "753ED2EFFA5C7283E2D850B90D55DA4C", hash_generated_field = "392D28CE1B9BA8C3B4A223CCA99F5E27")

static final int TRANSACTION_interfaceAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.INetworkManagementEventObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.394 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.398 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.402 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.405 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Interface configuration status has changed.
     *
     * @param iface The interface.
     * @param up True if the interface has been enabled.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.410 -0400", hash_original_method = "129B10AE1EC2120C49808B1716FF8FB5", hash_generated_method = "C2E3F3CB4D83AE125F032725B19B3C64")
            
public void interfaceStatusChanged(java.lang.String iface, boolean up) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeInt(((up)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_interfaceStatusChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Interface physical-layer link state has changed.  For Ethernet,
     * this method is invoked when the cable is plugged in or unplugged.
     *
     * @param iface The interface.
     * @param up  True if the physical link-layer connection signal is valid.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.414 -0400", hash_original_method = "C8BD1E4EDBEDBBEA6FB1769D59B2FF06", hash_generated_method = "A0D1E60B43A8E622405E5F1D1C5C7993")
            
public void interfaceLinkStateChanged(java.lang.String iface, boolean up) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeInt(((up)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_interfaceLinkStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * An interface has been added to the system
     *
     * @param iface The interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.419 -0400", hash_original_method = "BA2465F158A2C27F5A4E020A1781BEAD", hash_generated_method = "18AF59003EA12DDF013FD189591BDE23")
            
public void interfaceAdded(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_interfaceAdded, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * An interface has been removed from the system
     *
     * @param iface The interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.423 -0400", hash_original_method = "AF66F2637EA5BAD46B315C54AEBB3808", hash_generated_method = "9D3B2A7F34640FEABC499B506D0DDD82")
            
public void interfaceRemoved(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_interfaceRemoved, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * A networking quota limit has been reached. The quota might not
     * be specific to an interface.
     *
     * @param limitName The name of the limit that triggered.
     * @param iface The interface on which the limit was detected.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.427 -0400", hash_original_method = "370EC4B2BC8EA5AD49E0C16862D5AA49", hash_generated_method = "CFF3DDCA1807EF350F8888500AD4551D")
            
public void limitReached(java.lang.String limitName, java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(limitName);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_limitReached, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.452 -0400", hash_original_field = "5FCCC00E8A62F53ACE6C522385D3CCF6", hash_generated_field = "48274DEFCE1C7F77271E10AB53608816")

static final int TRANSACTION_interfaceRemoved = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.457 -0400", hash_original_field = "08A7D0F92B8C35892E570DCE7A53DCB0", hash_generated_field = "1D94BE2A2E181DE8B118C981467201FC")

static final int TRANSACTION_limitReached = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.374 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.382 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:21.389 -0400", hash_original_method = "D16BE43BA6BD82E89BDAED2A7EBBEC46", hash_generated_method = "FC229144C63810A0D2329D4B1800076D")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_interfaceStatusChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.interfaceStatusChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_interfaceLinkStateChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.interfaceLinkStateChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_interfaceAdded:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.interfaceAdded(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_interfaceRemoved:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.interfaceRemoved(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_limitReached:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.limitReached(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
/**
     * Interface configuration status has changed.
     *
     * @param iface The interface.
     * @param up True if the interface has been enabled.
     */
public void interfaceStatusChanged(java.lang.String iface, boolean up) throws android.os.RemoteException;
/**
     * Interface physical-layer link state has changed.  For Ethernet,
     * this method is invoked when the cable is plugged in or unplugged.
     *
     * @param iface The interface.
     * @param up  True if the physical link-layer connection signal is valid.
     */
public void interfaceLinkStateChanged(java.lang.String iface, boolean up) throws android.os.RemoteException;
/**
     * An interface has been added to the system
     *
     * @param iface The interface.
     */
public void interfaceAdded(java.lang.String iface) throws android.os.RemoteException;
/**
     * An interface has been removed from the system
     *
     * @param iface The interface.
     */
public void interfaceRemoved(java.lang.String iface) throws android.os.RemoteException;
/**
     * A networking quota limit has been reached. The quota might not
     * be specific to an interface.
     *
     * @param limitName The name of the limit that triggered.
     * @param iface The interface on which the limit was detected.
     */
public void limitReached(java.lang.String limitName, java.lang.String iface) throws android.os.RemoteException;
}
