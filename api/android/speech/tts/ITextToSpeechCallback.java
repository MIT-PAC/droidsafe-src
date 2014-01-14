package android.speech.tts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ITextToSpeechCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.speech.tts.ITextToSpeechCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.181 -0500", hash_original_field = "2BC3BD40E5F6C1DCDF775044B10F6FE2", hash_generated_field = "41AF712B12DD90012198F26737B2915B")

private static final java.lang.String DESCRIPTOR = "android.speech.tts.ITextToSpeechCallback";
/**
 * Cast an IBinder object into an android.speech.tts.ITextToSpeechCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.186 -0500", hash_original_method = "616D2666E99ED4DFB4FA53347A8F27D7", hash_generated_method = "A328C9B431BAD66D7DDC13FA905CD471")
        
public static android.speech.tts.ITextToSpeechCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.speech.tts.ITextToSpeechCallback))) {
return ((android.speech.tts.ITextToSpeechCallback)iin);
}
return new android.speech.tts.ITextToSpeechCallback.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.215 -0500", hash_original_field = "75BD17C5B7A60CE8F0625C0C70260318", hash_generated_field = "70952B2E9F9A5641AA60FBA40C7ABFC2")

static final int TRANSACTION_onStart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.218 -0500", hash_original_field = "928612FA8381B7F06CA0AEB00C74BB7B", hash_generated_field = "B1E1C3CFC8850A996ABF8A5578A2910A")

static final int TRANSACTION_onDone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.220 -0500", hash_original_field = "010C318F34F5BE3B75D0B61B80CE3FBB", hash_generated_field = "13FA9246B1CF9AAB74DF5FED4BFE0290")

static final int TRANSACTION_onError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.speech.tts.ITextToSpeechCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.195 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.198 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.201 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.203 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.206 -0500", hash_original_method = "0625570A315B9749FDA4D5267899B01D", hash_generated_method = "7A8B934BA778B023CB501A00ED980D63")
            
public void onStart(java.lang.String utteranceId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(utteranceId);
mRemote.transact(Stub.TRANSACTION_onStart, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.208 -0500", hash_original_method = "8F1EC040EED3DFF4E4C0DB6D3640ED4E", hash_generated_method = "C2410CF2B8590AF781B3BDAC01E3C83A")
            
public void onDone(java.lang.String utteranceId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(utteranceId);
mRemote.transact(Stub.TRANSACTION_onDone, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.211 -0500", hash_original_method = "681FD5EFD4AC05FD3628F206E4D4465E", hash_generated_method = "FA2D0A3527F942E7C8CFF0B13FB9ACCF")
            
public void onError(java.lang.String utteranceId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(utteranceId);
mRemote.transact(Stub.TRANSACTION_onError, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.183 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.188 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.191 -0500", hash_original_method = "62007429830917F8E3A63B556A82DE6F", hash_generated_method = "E2702B0464607B6CB9284D63939CFC68")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onStart:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onStart(_arg0);
return true;
}
case TRANSACTION_onDone:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onDone(_arg0);
return true;
}
case TRANSACTION_onError:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onError(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onStart(java.lang.String utteranceId) throws android.os.RemoteException;
public void onDone(java.lang.String utteranceId) throws android.os.RemoteException;
public void onError(java.lang.String utteranceId) throws android.os.RemoteException;
}
