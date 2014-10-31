package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IMediaScannerService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.media.IMediaScannerService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.663 -0500", hash_original_field = "37FCD72BDC9000958AAD4DFF4A245FA4", hash_generated_field = "BB343C7A0BC036123549CD684BB4855F")

private static final java.lang.String DESCRIPTOR = "android.media.IMediaScannerService";
/**
 * Cast an IBinder object into an android.media.IMediaScannerService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.669 -0500", hash_original_method = "23863F8BC0D952F6151ADD33A25A23AA", hash_generated_method = "A4B2DD0782283546305C100BBFF73492")
        
public static android.media.IMediaScannerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.media.IMediaScannerService))) {
return ((android.media.IMediaScannerService)iin);
}
return new android.media.IMediaScannerService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.697 -0500", hash_original_field = "23189374F6048D58D9927B5AB96F0FF9", hash_generated_field = "5DD842610698443D61A4A9BF56A4FC97")

static final int TRANSACTION_requestScanFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.701 -0500", hash_original_field = "B32EEDEA3B71700D47C64D4E85180CA9", hash_generated_field = "BA9CAB5EAFFBFD23CBFB3D5629348952")

static final int TRANSACTION_scanFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.666 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.media.IMediaScannerService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.679 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.682 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.684 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.687 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Requests the media scanner to scan a file.
     * @param path the path to the file to be scanned.
     * @param mimeType  an optional mimeType for the file.
     * If mimeType is null, then the mimeType will be inferred from the file extension.
     * @param listener an optional IMediaScannerListener. 
     * If specified, the caller will be notified when scanning is complete via the listener.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.690 -0500", hash_original_method = "426DDDF6C08440FABBC7DFD10027AFEC", hash_generated_method = "76AAD4EE9DE92DE13BAF3D0084C5CCF3")
            
public void requestScanFile(java.lang.String path, java.lang.String mimeType, android.media.IMediaScannerListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
_data.writeString(mimeType);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_requestScanFile, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Older API, left in for backward compatibility.
     * Requests the media scanner to scan a file.
     * @param path the path to the file to be scanned.
     * @param mimeType  an optional mimeType for the file.
     * If mimeType is null, then the mimeType will be inferred from the file extension.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.693 -0500", hash_original_method = "D0538B7B1393227D6E2924CAF9227DDA", hash_generated_method = "B3939345B662E8390BFB345F96B192DD")
            
public void scanFile(java.lang.String path, java.lang.String mimeType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
_data.writeString(mimeType);
mRemote.transact(Stub.TRANSACTION_scanFile, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.672 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.675 -0500", hash_original_method = "4E486E3722A63FF36BCA85CCE7160A0A", hash_generated_method = "C0202EFAD1D2FAAB8AB4DFF35C656DD8")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_requestScanFile:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
android.media.IMediaScannerListener _arg2;
_arg2 = android.media.IMediaScannerListener.Stub.asInterface(data.readStrongBinder());
this.requestScanFile(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_scanFile:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.scanFile(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void requestScanFile(java.lang.String path, java.lang.String mimeType, android.media.IMediaScannerListener listener) throws android.os.RemoteException;

public void scanFile(java.lang.String path, java.lang.String mimeType) throws android.os.RemoteException;
}
