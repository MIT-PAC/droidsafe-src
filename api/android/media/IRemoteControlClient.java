package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IRemoteControlClient extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.media.IRemoteControlClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.816 -0500", hash_original_field = "C3A767101D5DA2BD926498FE338929A4", hash_generated_field = "3C0AB104298884C1C3F65C48ABB83E0E")

private static final java.lang.String DESCRIPTOR = "android.media.IRemoteControlClient";
/**
 * Cast an IBinder object into an android.media.IRemoteControlClient interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.822 -0500", hash_original_method = "BF0D19EA74FC21FF6C1BBD313A4C4234", hash_generated_method = "BDE599F14F978A982072354E66A02EB1")
        
public static android.media.IRemoteControlClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.media.IRemoteControlClient))) {
return ((android.media.IRemoteControlClient)iin);
}
return new android.media.IRemoteControlClient.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.856 -0500", hash_original_field = "FF657DD644354C885DDB0863B2049796", hash_generated_field = "1C440F689B7EAFD6BE1BC6DA3DB9BDC1")

static final int TRANSACTION_onInformationRequested = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.859 -0500", hash_original_field = "A1A1DDE39C7AF9676B253832DD18CAFC", hash_generated_field = "E4B5D86ACF7B64F0430284D3636DDCAB")

static final int TRANSACTION_setCurrentClientGenerationId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.862 -0500", hash_original_field = "F43B5B053278B414AFEB9CA382530D33", hash_generated_field = "0E5D48F98A3BFDCCA602E145377CDDCB")

static final int TRANSACTION_plugRemoteControlDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.media.IRemoteControlClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.831 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.834 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.837 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.840 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Notifies a remote control client that information for the given generation ID is
     * requested. If the flags contains
     * {@link RemoteControlClient#FLAG_INFORMATION_REQUESTED_ALBUM_ART} then the width and height
     *   parameters are valid.
     * @param generationId
     * @param infoFlags
     * @param artWidth if > 0, artHeight must be > 0 too.
     * @param artHeight
     * FIXME: is infoFlags required? since the RCC pushes info, this might always be called
     *        with RC_INFO_ALL
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.842 -0500", hash_original_method = "D08CEA61B374EE099B71DDD08D23E823", hash_generated_method = "89D97FDB855EE060613CCD1550E2E715")
            
public void onInformationRequested(int generationId, int infoFlags, int artWidth, int artHeight) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(generationId);
_data.writeInt(infoFlags);
_data.writeInt(artWidth);
_data.writeInt(artHeight);
mRemote.transact(Stub.TRANSACTION_onInformationRequested, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Sets the generation counter of the current client that is displayed on the remote control.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.846 -0500", hash_original_method = "E380BD6721F18245DB360491CAFF2EB5", hash_generated_method = "8F45C01F42F369DD296A6CF061EAA556")
            
public void setCurrentClientGenerationId(int clientGeneration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(clientGeneration);
mRemote.transact(Stub.TRANSACTION_setCurrentClientGenerationId, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.849 -0500", hash_original_method = "5D3C037923CE9EBA428C845631292DEA", hash_generated_method = "81B8CE7D2480E4FB8926D44975D7C94D")
            
public void plugRemoteControlDisplay(android.media.IRemoteControlDisplay rcd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((rcd!=null))?(rcd.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_plugRemoteControlDisplay, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.852 -0500", hash_original_method = "509AE12CE044F0EBA7A20BCE6E6BBE19", hash_generated_method = "8BE0F8C9FFF8CAE1475A8F287E8E95FA")
            
public void unplugRemoteControlDisplay(android.media.IRemoteControlDisplay rcd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((rcd!=null))?(rcd.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unplugRemoteControlDisplay, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.865 -0500", hash_original_field = "583177F29BDCD9AC72C61CA286C060EF", hash_generated_field = "BA805483C6491731A51255A099D14568")

static final int TRANSACTION_unplugRemoteControlDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.819 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.824 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.828 -0500", hash_original_method = "D4DEE9178C87191535EACF45A65B94D8", hash_generated_method = "3B3F9F816ABB370C705CE7CA7D572CFA")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onInformationRequested:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.onInformationRequested(_arg0, _arg1, _arg2, _arg3);
return true;
}
case TRANSACTION_setCurrentClientGenerationId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setCurrentClientGenerationId(_arg0);
return true;
}
case TRANSACTION_plugRemoteControlDisplay:
{
data.enforceInterface(DESCRIPTOR);
android.media.IRemoteControlDisplay _arg0;
_arg0 = android.media.IRemoteControlDisplay.Stub.asInterface(data.readStrongBinder());
this.plugRemoteControlDisplay(_arg0);
return true;
}
case TRANSACTION_unplugRemoteControlDisplay:
{
data.enforceInterface(DESCRIPTOR);
android.media.IRemoteControlDisplay _arg0;
_arg0 = android.media.IRemoteControlDisplay.Stub.asInterface(data.readStrongBinder());
this.unplugRemoteControlDisplay(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void onInformationRequested(int generationId, int infoFlags, int artWidth, int artHeight) throws android.os.RemoteException;

public void setCurrentClientGenerationId(int clientGeneration) throws android.os.RemoteException;
public void plugRemoteControlDisplay(android.media.IRemoteControlDisplay rcd) throws android.os.RemoteException;
public void unplugRemoteControlDisplay(android.media.IRemoteControlDisplay rcd) throws android.os.RemoteException;
}
