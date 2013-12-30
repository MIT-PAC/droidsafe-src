package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IWallpaperManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IWallpaperManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.423 -0500", hash_original_field = "157A482D5E9BD5E0F21C409403715CEF", hash_generated_field = "2AF11212BFAB2BB128D1BEF0B0C9B956")

private static final java.lang.String DESCRIPTOR = "android.app.IWallpaperManager";
/**
 * Cast an IBinder object into an android.app.IWallpaperManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.429 -0500", hash_original_method = "DF1AFCCB9F9E03866438A1376FD2227A", hash_generated_method = "57B89D37B84262A0C7D9C65CCF7EC818")
        
public static android.app.IWallpaperManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IWallpaperManager))) {
return ((android.app.IWallpaperManager)iin);
}
return new android.app.IWallpaperManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.474 -0500", hash_original_field = "DE7676C379B5B3B7FEE0A8572D34D750", hash_generated_field = "FAFBD50CAD5EE58C3A3D67FF241533E1")

static final int TRANSACTION_setWallpaper = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.476 -0500", hash_original_field = "A0C95FC4234271172493BBB4A09EF99C", hash_generated_field = "E7E1D5CDBC0B4A40B8FD52261F03A795")

static final int TRANSACTION_setWallpaperComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.479 -0500", hash_original_field = "9E8DA3253E1A4642441EF78D48868922", hash_generated_field = "EF25BE413CD383493611C503A75ACCA3")

static final int TRANSACTION_getWallpaper = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.IWallpaperManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.439 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.442 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.444 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.447 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Set the wallpaper.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.449 -0500", hash_original_method = "A86853855F485A45409B5851C15136DA", hash_generated_method = "358203C68684C748CAD4B3C3A20A7E17")
            
public android.os.ParcelFileDescriptor setWallpaper(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelFileDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_setWallpaper, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(_reply);
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
/**
     * Set the live wallpaper.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.452 -0500", hash_original_method = "F8F13C3B79CD3BDF3EEC6AE5D63F1210", hash_generated_method = "BD8CE49075D6B659CC1813F4F0CCE9A2")
            
public void setWallpaperComponent(android.content.ComponentName name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((name!=null)) {
_data.writeInt(1);
name.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setWallpaperComponent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Get the wallpaper.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.455 -0500", hash_original_method = "438F4BB728C29A51E9B9DDAAE8D525D7", hash_generated_method = "079612FD76595469F2FEDAAE1DD72C2C")
            
public android.os.ParcelFileDescriptor getWallpaper(android.app.IWallpaperManagerCallback cb, android.os.Bundle outParams) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelFileDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getWallpaper, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
outParams.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Get information about a live wallpaper.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.458 -0500", hash_original_method = "9B56268755DBFDA825B02C32BA1C078F", hash_generated_method = "11C58279F9A2C4BEF9D4534BED3B2A07")
            
public android.app.WallpaperInfo getWallpaperInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.app.WallpaperInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getWallpaperInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.app.WallpaperInfo.CREATOR.createFromParcel(_reply);
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
/**
     * Clear the wallpaper.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.460 -0500", hash_original_method = "5387EB561AF20BCBB6A9F308409AF7AE", hash_generated_method = "72DFD1C22ECCF2265B3BC8AE0C04DB2C")
            
public void clearWallpaper() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_clearWallpaper, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Sets the dimension hint for the wallpaper. These hints indicate the desired
     * minimum width and height for the wallpaper.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.462 -0500", hash_original_method = "10583B77FC48A46EC6D3FAECAF53B276", hash_generated_method = "2C5D90E398A884CB3A2C483A0FFA9A24")
            
public void setDimensionHints(int width, int height) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(width);
_data.writeInt(height);
mRemote.transact(Stub.TRANSACTION_setDimensionHints, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Returns the desired minimum width for the wallpaper.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.465 -0500", hash_original_method = "D73A3C3086936198B4BDC06D8C79FD67", hash_generated_method = "FB2152EAE42BAC16633B9EDD01B67D9A")
            
public int getWidthHint() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getWidthHint, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Returns the desired minimum height for the wallpaper.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.467 -0500", hash_original_method = "113ADBD0B4965B1159BBDE4A892B50AA", hash_generated_method = "0AB0D46FE47B512ADFC4D41C9769F035")
            
public int getHeightHint() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHeightHint, _data, _reply, 0);
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.481 -0500", hash_original_field = "988B8E7C4A3F54339F08545253AC7EBC", hash_generated_field = "2A3C9315C98C8EF185590428453E68C0")

static final int TRANSACTION_getWallpaperInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.483 -0500", hash_original_field = "D38E8A24B95575783B2B6FE9B2CBA7AD", hash_generated_field = "5E232AFCA7B6ECCC0F861FC7F20161DF")

static final int TRANSACTION_clearWallpaper = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.486 -0500", hash_original_field = "7FF12ADB46479B653B97C13A8CAE6EC6", hash_generated_field = "BE580114DC1775E393D6D3A5D70EF20B")

static final int TRANSACTION_setDimensionHints = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.488 -0500", hash_original_field = "5AF7F037E3BAE109E8988F6BBB22AC5A", hash_generated_field = "50A4B71FAA27E0738480BC7DD71E1B0B")

static final int TRANSACTION_getWidthHint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.490 -0500", hash_original_field = "502BA304F7581D4E37593E9DE790253C", hash_generated_field = "4AA04D8E2E73D417E39B68F59EB640F8")

static final int TRANSACTION_getHeightHint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.427 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.431 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.436 -0500", hash_original_method = "ED4FBCDB03B60258A0C28E74BE982E49", hash_generated_method = "4BFA58A0EFA54922AF4F9C4A420F9527")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setWallpaper:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.ParcelFileDescriptor _result = this.setWallpaper(_arg0);
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
case TRANSACTION_setWallpaperComponent:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setWallpaperComponent(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getWallpaper:
{
data.enforceInterface(DESCRIPTOR);
android.app.IWallpaperManagerCallback _arg0;
_arg0 = android.app.IWallpaperManagerCallback.Stub.asInterface(data.readStrongBinder());
android.os.Bundle _arg1;
_arg1 = new android.os.Bundle();
android.os.ParcelFileDescriptor _result = this.getWallpaper(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getWallpaperInfo:
{
data.enforceInterface(DESCRIPTOR);
android.app.WallpaperInfo _result = this.getWallpaperInfo();
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
case TRANSACTION_clearWallpaper:
{
data.enforceInterface(DESCRIPTOR);
this.clearWallpaper();
reply.writeNoException();
return true;
}
case TRANSACTION_setDimensionHints:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.setDimensionHints(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getWidthHint:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getWidthHint();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getHeightHint:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getHeightHint();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public android.os.ParcelFileDescriptor setWallpaper(java.lang.String name) throws android.os.RemoteException;

public void setWallpaperComponent(android.content.ComponentName name) throws android.os.RemoteException;

public android.os.ParcelFileDescriptor getWallpaper(android.app.IWallpaperManagerCallback cb, android.os.Bundle outParams) throws android.os.RemoteException;

public android.app.WallpaperInfo getWallpaperInfo() throws android.os.RemoteException;

public void clearWallpaper() throws android.os.RemoteException;

public void setDimensionHints(int width, int height) throws android.os.RemoteException;

public int getWidthHint() throws android.os.RemoteException;

public int getHeightHint() throws android.os.RemoteException;
}
