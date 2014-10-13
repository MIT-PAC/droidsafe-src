package android.speech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IRecognitionService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.speech.IRecognitionService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.264 -0500", hash_original_field = "2BA662EDD419AC61BA6F5DD88EE3BCDB", hash_generated_field = "F0CD066077924305AB7AAE8F9A9D6982")

private static final java.lang.String DESCRIPTOR = "android.speech.IRecognitionService";
/**
 * Cast an IBinder object into an android.speech.IRecognitionService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.270 -0500", hash_original_method = "85242D3EEFFA7896CFA7CA02733DF1CC", hash_generated_method = "A558C64471BC2C6526E1314620E02E51")
        
public static android.speech.IRecognitionService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.speech.IRecognitionService))) {
return ((android.speech.IRecognitionService)iin);
}
return new android.speech.IRecognitionService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.298 -0500", hash_original_field = "74955C7CB165DEC2A72F0CB6337BEDA4", hash_generated_field = "41FEC88E3E2593DD3CFC525EA2008432")

static final int TRANSACTION_startListening = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.302 -0500", hash_original_field = "935FA1F2F338B25DAAC7692B28780C6D", hash_generated_field = "5FF0FA5FBC09CDB8B4B0E7AEE1EC4912")

static final int TRANSACTION_stopListening = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.304 -0500", hash_original_field = "69771F887D021F3369C68ECDA4691C0B", hash_generated_field = "17701F515D235ADD4245BCE52A2D0C56")

static final int TRANSACTION_cancel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.speech.IRecognitionService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.278 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.281 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.283 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.286 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Starts listening for speech. Please note that the recognition service supports
     * one listener only, therefore, if this function is called from two different threads,
     * only the latest one will get the notifications
     *
     * @param recognizerIntent the intent from which the invocation occurred. Additionally,
     *        this intent can contain extra parameters to manipulate the behavior of the recognition
     *        client. For more information see {@link RecognizerIntent}.
     * @param listener to receive callbacks, note that this must be non-null
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.288 -0500", hash_original_method = "DE379CA29EFD7E81E11BB0B1B68633AA", hash_generated_method = "C7AE5FF5A7A9058DC14CBAD708D34655")
            
public void startListening(android.content.Intent recognizerIntent, android.speech.IRecognitionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((recognizerIntent!=null)) {
_data.writeInt(1);
recognizerIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_startListening, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Stops listening for speech. Speech captured so far will be recognized as
     * if the user had stopped speaking at this point. The function has no effect unless it
     * is called during the speech capturing.
     *
     * @param listener to receive callbacks, note that this must be non-null
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.291 -0500", hash_original_method = "BA3FEE0D9892C9FD7CAD03BDAB3E05F6", hash_generated_method = "42785CA42533B079B27C7A80078C0B94")
            
public void stopListening(android.speech.IRecognitionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_stopListening, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Cancels the speech recognition.
     *
     * @param listener to receive callbacks, note that this must be non-null
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.293 -0500", hash_original_method = "A2F7F58746A0C28F190269909AE8BB60", hash_generated_method = "73DFD95CC991692B314E6581668ED8C1")
            
public void cancel(android.speech.IRecognitionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_cancel, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.267 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.272 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.275 -0500", hash_original_method = "CCAA3BD7E9084293A1EEE659178CAAB8", hash_generated_method = "712FBA910335E5C01553E15AF67DFF8C")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_startListening:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.speech.IRecognitionListener _arg1;
_arg1 = android.speech.IRecognitionListener.Stub.asInterface(data.readStrongBinder());
this.startListening(_arg0, _arg1);
return true;
}
case TRANSACTION_stopListening:
{
data.enforceInterface(DESCRIPTOR);
android.speech.IRecognitionListener _arg0;
_arg0 = android.speech.IRecognitionListener.Stub.asInterface(data.readStrongBinder());
this.stopListening(_arg0);
return true;
}
case TRANSACTION_cancel:
{
data.enforceInterface(DESCRIPTOR);
android.speech.IRecognitionListener _arg0;
_arg0 = android.speech.IRecognitionListener.Stub.asInterface(data.readStrongBinder());
this.cancel(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void startListening(android.content.Intent recognizerIntent, android.speech.IRecognitionListener listener) throws android.os.RemoteException;

public void stopListening(android.speech.IRecognitionListener listener) throws android.os.RemoteException;

public void cancel(android.speech.IRecognitionListener listener) throws android.os.RemoteException;
}
