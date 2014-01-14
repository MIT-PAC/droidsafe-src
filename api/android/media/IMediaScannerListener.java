package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IMediaScannerListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.media.IMediaScannerListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.653 -0500", hash_original_field = "289C72B2ABBCE087551AB9C69C026BBD", hash_generated_field = "581BA1C21FC56647C46FDF364FC2FB36")

private static final java.lang.String DESCRIPTOR = "android.media.IMediaScannerListener";
/**
 * Cast an IBinder object into an android.media.IMediaScannerListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.659 -0500", hash_original_method = "E9B4A798B44B2A3B466CF3A64F196A11", hash_generated_method = "DE5C387B1AAC980E1F6C57E46147FF63")
        
public static android.media.IMediaScannerListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.media.IMediaScannerListener))) {
return ((android.media.IMediaScannerListener)iin);
}
return new android.media.IMediaScannerListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.684 -0500", hash_original_field = "20B9AF840D4CB40445BF6FFE28AAC46F", hash_generated_field = "AEBCB9AE6DC9607595CCC194786DC1D1")

static final int TRANSACTION_scanCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.656 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.661 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.media.IMediaScannerListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.667 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.671 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.674 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.676 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Called when a IMediaScannerService.scanFile() call has completed.
     * @param path the path to the file that has been scanned.
     * @param uri the Uri for the file if the scanning operation succeeded 
     * and the file was added to the media database, or null if scanning failed. 
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.679 -0500", hash_original_method = "657FC88ED2F4371BF2FB50026348A78B", hash_generated_method = "3E675EB9C1687F8DDF211B695A37E67C")
            
public void scanCompleted(java.lang.String path, android.net.Uri uri) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
if ((uri!=null)) {
_data.writeInt(1);
uri.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_scanCompleted, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.664 -0500", hash_original_method = "22B007E0075DC98776064E303F736CD9", hash_generated_method = "4CD90E8C470004B278A373E736E32B54")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_scanCompleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.Uri _arg1;
if ((0!=data.readInt())) {
_arg1 = android.net.Uri.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.scanCompleted(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void scanCompleted(java.lang.String path, android.net.Uri uri) throws android.os.RemoteException;
}
