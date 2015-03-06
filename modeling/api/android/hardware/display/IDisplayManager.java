/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: frameworks/base/core/java/android/hardware/display/IDisplayManager.aidl
 */
package android.hardware.display;
/** @hide */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IDisplayManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.hardware.display.IDisplayManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.052 -0500", hash_original_field = "BEEBB114E6E2148811CFA9D8BBB90274", hash_generated_field = "837DB826E46463A96078C69FD8F1A07B")

private static final java.lang.String DESCRIPTOR = "android.hardware.display.IDisplayManager";
/**
 * Cast an IBinder object into an android.hardware.display.IDisplayManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.058 -0500", hash_original_method = "FC2F0A22F1E3BBF3C6B6CD45EEA1B092", hash_generated_method = "B81E66C7715D7062B0A1CD859BED6756")
        
public static android.hardware.display.IDisplayManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.hardware.display.IDisplayManager))) {
return ((android.hardware.display.IDisplayManager)iin);
}
return new android.hardware.display.IDisplayManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.107 -0500", hash_original_field = "18DA74FF9406A2E210924EC9EB596125", hash_generated_field = "53D6F62AB7F81B3BD65B7E20BA9BB409")

static final int TRANSACTION_getDisplayInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.109 -0500", hash_original_field = "18090791C06113860506CC9C56A1CBAA", hash_generated_field = "326F7A4B511313BD9469528DC2877D1B")

static final int TRANSACTION_getDisplayIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.112 -0500", hash_original_field = "9D891B071B3978A9407DEE30792E4A61", hash_generated_field = "D0FB06D9117AEA507097739A40AC075C")

static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.hardware.display.IDisplayManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.068 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.071 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.073 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.075 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.078 -0500", hash_original_method = "1E496126D9BB9F9FEA2DBA4C119504F6", hash_generated_method = "14EBEA56FBD7DAB77A22F60E630EF512")
            
@Override public android.view.DisplayInfo getDisplayInfo(int displayId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.view.DisplayInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(displayId);
mRemote.transact(Stub.TRANSACTION_getDisplayInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.view.DisplayInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.081 -0500", hash_original_method = "8127A8FAA17882F2F91595B7D3DE4257", hash_generated_method = "D7DB6217D72E4F614A7872CC1EBDEB5A")
            
@Override public int[] getDisplayIds() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDisplayIds, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.084 -0500", hash_original_method = "23829F0466F65DB74B453B6A9E6FA915", hash_generated_method = "76AC9347279986E4FE8A974BA11E1B0C")
            
@Override public void registerCallback(android.hardware.display.IDisplayManagerCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// No permissions required.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.087 -0500", hash_original_method = "D3D2251E14706D55BB7FB59F9E51CCAB", hash_generated_method = "50C7F00DE2BFBCF9301E44F7ADF0F285")
            
@Override public void scanWifiDisplays() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_scanWifiDisplays, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Requires CONFIGURE_WIFI_DISPLAY permission to connect to an unknown device.
// No permissions required to connect to a known device.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.089 -0500", hash_original_method = "762488CC25E2479E8374D6F442864758", hash_generated_method = "6FCB0C58865DC561BFD67C865822C9E1")
            
@Override public void connectWifiDisplay(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_connectWifiDisplay, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// No permissions required.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.091 -0500", hash_original_method = "3B9F2710F03C4DA25699666C37084315", hash_generated_method = "51C7B15E18C4EA17B71E2C36C6DAB884")
            
@Override public void disconnectWifiDisplay() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disconnectWifiDisplay, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Requires CONFIGURE_WIFI_DISPLAY permission.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.095 -0500", hash_original_method = "C94A8E1FE0DF4EF6578926A26A93CD84", hash_generated_method = "38044F2AB8FC1E6AFCE9167CF86F09F1")
            
@Override public void renameWifiDisplay(java.lang.String address, java.lang.String alias) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(alias);
mRemote.transact(Stub.TRANSACTION_renameWifiDisplay, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Requires CONFIGURE_WIFI_DISPLAY permission.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.098 -0500", hash_original_method = "DA978A435F69B2C5FE181CAB8CDD0B46", hash_generated_method = "D3C5B8DE622460F0E06E1D4993114AB6")
            
@Override public void forgetWifiDisplay(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_forgetWifiDisplay, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// No permissions required.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.101 -0500", hash_original_method = "3072BE19D7A311EFE77A3ECE64CFDB13", hash_generated_method = "DC1C49A36EA8BA03B7F01B824C9CF79D")
            
@Override public android.hardware.display.WifiDisplayStatus getWifiDisplayStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.hardware.display.WifiDisplayStatus _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getWifiDisplayStatus, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.hardware.display.WifiDisplayStatus.CREATOR.createFromParcel(_reply);
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
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.114 -0500", hash_original_field = "E407A971D06BDFC2D1A17AB80AF6D759", hash_generated_field = "6759D670BA65DC59536BB7CCEF4B02C0")

static final int TRANSACTION_scanWifiDisplays = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.116 -0500", hash_original_field = "D1128B65DCAECAA3B7BB2F0283717DE3", hash_generated_field = "69C9FBEE777135559F9AF56C873D2CFC")

static final int TRANSACTION_connectWifiDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.119 -0500", hash_original_field = "4204437DE75354E0B64B53E637C24311", hash_generated_field = "3786A88F8BD64687FEFB15694E86C503")

static final int TRANSACTION_disconnectWifiDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.121 -0500", hash_original_field = "E87BF2D288DCE53191539B4AC94660BA", hash_generated_field = "B3F5A12E4BE0EA6FB858B566D062A7BD")

static final int TRANSACTION_renameWifiDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.123 -0500", hash_original_field = "245CEADEE03E4F991A883D46F2F14F25", hash_generated_field = "9AD590090980E38EDA1629B82B99F29D")

static final int TRANSACTION_forgetWifiDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.126 -0500", hash_original_field = "CFC94ECEA6291F93428A3DC9A0AE3894", hash_generated_field = "E839BF4BFAB1B7FADFF2F2952840984F")

static final int TRANSACTION_getWifiDisplayStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.055 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.060 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.065 -0500", hash_original_method = "16AE1D587301AF8618CF5CE1408675F4", hash_generated_method = "BA8520E6F367629B95EE27E769010FB7")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getDisplayInfo:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.view.DisplayInfo _result = this.getDisplayInfo(_arg0);
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
case TRANSACTION_getDisplayIds:
{
data.enforceInterface(DESCRIPTOR);
int[] _result = this.getDisplayIds();
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.display.IDisplayManagerCallback _arg0;
_arg0 = android.hardware.display.IDisplayManagerCallback.Stub.asInterface(data.readStrongBinder());
this.registerCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_scanWifiDisplays:
{
data.enforceInterface(DESCRIPTOR);
this.scanWifiDisplays();
reply.writeNoException();
return true;
}
case TRANSACTION_connectWifiDisplay:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.connectWifiDisplay(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_disconnectWifiDisplay:
{
data.enforceInterface(DESCRIPTOR);
this.disconnectWifiDisplay();
reply.writeNoException();
return true;
}
case TRANSACTION_renameWifiDisplay:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.renameWifiDisplay(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_forgetWifiDisplay:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.forgetWifiDisplay(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getWifiDisplayStatus:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.display.WifiDisplayStatus _result = this.getWifiDisplayStatus();
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
}
return super.onTransact(code, data, reply, flags);
}
}
public android.view.DisplayInfo getDisplayInfo(int displayId) throws android.os.RemoteException;
public int[] getDisplayIds() throws android.os.RemoteException;
public void registerCallback(android.hardware.display.IDisplayManagerCallback callback) throws android.os.RemoteException;
// No permissions required.

public void scanWifiDisplays() throws android.os.RemoteException;
// Requires CONFIGURE_WIFI_DISPLAY permission to connect to an unknown device.
// No permissions required to connect to a known device.

public void connectWifiDisplay(java.lang.String address) throws android.os.RemoteException;
// No permissions required.

public void disconnectWifiDisplay() throws android.os.RemoteException;
// Requires CONFIGURE_WIFI_DISPLAY permission.

public void renameWifiDisplay(java.lang.String address, java.lang.String alias) throws android.os.RemoteException;
// Requires CONFIGURE_WIFI_DISPLAY permission.

public void forgetWifiDisplay(java.lang.String address) throws android.os.RemoteException;
// No permissions required.

public android.hardware.display.WifiDisplayStatus getWifiDisplayStatus() throws android.os.RemoteException;
}
