package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IThumbnailReceiver extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IThumbnailReceiver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.338 -0500", hash_original_field = "69860D7EE22FBBD46B59E5070CB4308A", hash_generated_field = "C7F189EA1B71018F99C9E62098C55829")

private static final java.lang.String DESCRIPTOR = "android.app.IThumbnailReceiver";
/**
 * Cast an IBinder object into an android.app.IThumbnailReceiver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.343 -0500", hash_original_method = "08F86C50E7CB7A0D17E044DC197611BC", hash_generated_method = "6C8E3DD7918693ADDAC3BF0F3993CF86")
        
public static android.app.IThumbnailReceiver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IThumbnailReceiver))) {
return ((android.app.IThumbnailReceiver)iin);
}
return new android.app.IThumbnailReceiver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.369 -0500", hash_original_field = "3D8486B5EA841B1726ED55827A82B6B3", hash_generated_field = "1F1416562ED30176C3BA418BFDDB5854")

static final int TRANSACTION_newThumbnail = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.372 -0500", hash_original_field = "5CFC0B128A2884ACFEDB1D1944B26442", hash_generated_field = "CCF89F5F90876E1E360939308FAC0A74")

static final int TRANSACTION_finished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.340 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.app.IThumbnailReceiver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.351 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.355 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.357 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.359 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.362 -0500", hash_original_method = "3C1A66F9E97D59890BE73A7DAD000DDB", hash_generated_method = "74A1534354C80DC8EF3C5996C1C54629")
            
public void newThumbnail(int id, android.graphics.Bitmap thumbnail, java.lang.CharSequence description) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
if ((thumbnail!=null)) {
_data.writeInt(1);
thumbnail.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((description!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(description, _data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_newThumbnail, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.364 -0500", hash_original_method = "5CA6DFAE0F2153723673FF9BE8F19D32", hash_generated_method = "990782AD9EF8EBC2A6E90719DF1E3A22")
            
public void finished() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_finished, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.345 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.348 -0500", hash_original_method = "6AD7AA06A188B0B49074DD428F8D1597", hash_generated_method = "25064BE10C2FF646E057D57D77EF60A5")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_newThumbnail:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.graphics.Bitmap _arg1;
if ((0!=data.readInt())) {
_arg1 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.CharSequence _arg2;
if ((0!=data.readInt())) {
_arg2 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.newThumbnail(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_finished:
{
data.enforceInterface(DESCRIPTOR);
this.finished();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void newThumbnail(int id, android.graphics.Bitmap thumbnail, java.lang.CharSequence description) throws android.os.RemoteException;
public void finished() throws android.os.RemoteException;
}
