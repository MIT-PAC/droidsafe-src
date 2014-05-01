package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IBluetoothHealthCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.bluetooth.IBluetoothHealthCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.601 -0500", hash_original_field = "E812ED18F4A075C5EA7F38426C1CE556", hash_generated_field = "BA342A4C75CBAAD254D48D2561C31E16")

private static final java.lang.String DESCRIPTOR = "android.bluetooth.IBluetoothHealthCallback";
/**
 * Cast an IBinder object into an android.bluetooth.IBluetoothHealthCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.607 -0500", hash_original_method = "3F372B11B59C6904126BA4CB1C0FEFC8", hash_generated_method = "109C06FF9A79CE3131C604A71FC61006")
        
public static android.bluetooth.IBluetoothHealthCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.bluetooth.IBluetoothHealthCallback))) {
return ((android.bluetooth.IBluetoothHealthCallback)iin);
}
return new android.bluetooth.IBluetoothHealthCallback.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.633 -0500", hash_original_field = "E69A89EC23366A741C54A1560389A421", hash_generated_field = "0B4A8F9A3F7D164C1751884F9A4AB398")

static final int TRANSACTION_onHealthAppConfigurationStatusChange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.635 -0500", hash_original_field = "3541C38C63465B65E3E000027B414EE9", hash_generated_field = "A90A42ECEE92BEA821B8A8C9C846F791")

static final int TRANSACTION_onHealthChannelStateChange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.604 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.bluetooth.IBluetoothHealthCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.616 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.618 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.620 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.622 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.BLUETOOTH})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.625 -0500", hash_original_method = "F977413C74A94F6A0339EC8ADB46ADAB", hash_generated_method = "1D8AC33EB6B975064DCC25DE1EF51CA2")
            
public void onHealthAppConfigurationStatusChange(android.bluetooth.BluetoothHealthAppConfiguration config, int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_onHealthAppConfigurationStatusChange, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.BLUETOOTH})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.628 -0500", hash_original_method = "01046949F354348939608685292C2391", hash_generated_method = "A2158528987D513CA0421EE93BA8915D")
            
public void onHealthChannelStateChange(android.bluetooth.BluetoothHealthAppConfiguration config, android.bluetooth.BluetoothDevice device, int prevState, int newState, android.os.ParcelFileDescriptor fd, int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(prevState);
_data.writeInt(newState);
if ((fd!=null)) {
_data.writeInt(1);
fd.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_onHealthChannelStateChange, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.609 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.612 -0500", hash_original_method = "4338943326FB552307DFDE6E43A4FD8C", hash_generated_method = "6613C77477569E68498100CFA6721941")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onHealthAppConfigurationStatusChange:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothHealthAppConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothHealthAppConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.onHealthAppConfigurationStatusChange(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onHealthChannelStateChange:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothHealthAppConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothHealthAppConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.bluetooth.BluetoothDevice _arg1;
if ((0!=data.readInt())) {
_arg1 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.os.ParcelFileDescriptor _arg4;
if ((0!=data.readInt())) {
_arg4 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
int _arg5;
_arg5 = data.readInt();
this.onHealthChannelStateChange(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onHealthAppConfigurationStatusChange(android.bluetooth.BluetoothHealthAppConfiguration config, int status) throws android.os.RemoteException;
public void onHealthChannelStateChange(android.bluetooth.BluetoothHealthAppConfiguration config, android.bluetooth.BluetoothDevice device, int prevState, int newState, android.os.ParcelFileDescriptor fd, int id) throws android.os.RemoteException;
}
