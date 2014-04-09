/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/bluetooth/IBluetoothPbap.aidl
 */
package android.bluetooth;
/**
 * System private API for Bluetooth pbap service
 *
 * {@hide}
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IBluetoothPbap extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.bluetooth.IBluetoothPbap
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.394 -0400", hash_original_field = "A052B6384A46AA0CE98623559338A1FE", hash_generated_field = "AE35BB6FE018517EB94C0BCC96786E89")

private static final java.lang.String DESCRIPTOR = "android.bluetooth.IBluetoothPbap";
/**
 * Cast an IBinder object into an android.bluetooth.IBluetoothPbap interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.397 -0400", hash_original_method = "B4B5C4F4E95319C5C7FBEAA6A25C7F8C", hash_generated_method = "E0E37E3A3667D37C401631F613E919E9")
        
public static android.bluetooth.IBluetoothPbap asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.bluetooth.IBluetoothPbap))) {
return ((android.bluetooth.IBluetoothPbap)iin);
}
return new android.bluetooth.IBluetoothPbap.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.418 -0400", hash_original_field = "34BF224D239ECDC645C959817EDCC047", hash_generated_field = "4B1CF98C879D2FC3A98A24F7D956CD3E")

static final int TRANSACTION_getState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.419 -0400", hash_original_field = "D481ACF7E8D626F6F67641BC8439D73C", hash_generated_field = "68601A4D9C45D6AF83CFCF3F1505D2DA")

static final int TRANSACTION_getClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.421 -0400", hash_original_field = "64B2331B150589AF69E71584FC98F412", hash_generated_field = "888F875E3AF2A88E8C7B9A8A0FCE1C93")

static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.bluetooth.IBluetoothPbap
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.403 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.404 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.405 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.406 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.408 -0400", hash_original_method = "34C8BE8866555A4E37FB3BE07D3804F6", hash_generated_method = "52D8D043CF1FF87ECD04698A0AB87331")
            
public int getState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.410 -0400", hash_original_method = "047787E8BF421CBAFBB4EC2ED07CC1FD", hash_generated_method = "D96F15A93223E3393CE888004F3B2CE9")
            
public android.bluetooth.BluetoothDevice getClient() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.bluetooth.BluetoothDevice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getClient, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.411 -0400", hash_original_method = "598071C6BEA3D7D14B3A2BD639C22F36", hash_generated_method = "5E50EE0456B2D1F42D9481B1951CEDE6")
            
public boolean connect(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.413 -0400", hash_original_method = "7356A426A0B7750490239D3760AB18D1", hash_generated_method = "E0D96A385B0D2413763CB4B9EC8F9640")
            
public void disconnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.415 -0400", hash_original_method = "62570772BD94392ADBF38E32936DB648", hash_generated_method = "E5A8FDC87A6BD6699850BA319F3174BD")
            
public boolean isConnected(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_isConnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.422 -0400", hash_original_field = "4EFED34BD3A988454F8AA9E42411788E", hash_generated_field = "4F10477D831DD1F9B344CA24EE9CE771")

static final int TRANSACTION_disconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.423 -0400", hash_original_field = "30457CCBD90EAAB0DF01CDECF43DE02C", hash_generated_field = "D3163EB07CF4A3ED89DD73AFF5071136")

static final int TRANSACTION_isConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.395 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.398 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.401 -0400", hash_original_method = "225C8689FE381598ABC8C4A2C9952A99", hash_generated_method = "79B7A2C0F3839AB516A4B5C0694860A4")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getClient:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _result = this.getClient();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.connect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disconnect:
{
data.enforceInterface(DESCRIPTOR);
this.disconnect();
reply.writeNoException();
return true;
}
case TRANSACTION_isConnected:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.isConnected(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public int getState() throws android.os.RemoteException;
public android.bluetooth.BluetoothDevice getClient() throws android.os.RemoteException;
public boolean connect(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
public void disconnect() throws android.os.RemoteException;
public boolean isConnected(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
}
