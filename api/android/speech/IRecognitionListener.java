package android.speech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IRecognitionListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.speech.IRecognitionListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.759 -0500", hash_original_field = "3A65D1D656E9EFA68D2D8FBB72C72F46", hash_generated_field = "3EE5E477DBDD116E1B9F14BFB37BAFF5")

private static final java.lang.String DESCRIPTOR = "android.speech.IRecognitionListener";
/**
 * Cast an IBinder object into an android.speech.IRecognitionListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.764 -0500", hash_original_method = "D3BC18241AFAFA16AC9DF7BEA7C00228", hash_generated_method = "3BA5FB6AF5040A8F74EB05D0506268C7")
        
public static android.speech.IRecognitionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.speech.IRecognitionListener))) {
return ((android.speech.IRecognitionListener)iin);
}
return new android.speech.IRecognitionListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.812 -0500", hash_original_field = "0A961F43794F498903F2B7E21D5B47E6", hash_generated_field = "C602E56B4341D2E2B56E528B4C17B8A8")

static final int TRANSACTION_onReadyForSpeech = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.814 -0500", hash_original_field = "D5FF834383C509FC71CE93F8428D4CDD", hash_generated_field = "C8132F8C9C40192C7EC75DB0A07352B2")

static final int TRANSACTION_onBeginningOfSpeech = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.817 -0500", hash_original_field = "001AB95CAF8EE38A042C63F317414C03", hash_generated_field = "5F950F56076474F6CFA94511887FFEA7")

static final int TRANSACTION_onRmsChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.speech.IRecognitionListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.774 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.777 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.779 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.781 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Called when the endpointer is ready for the user to start speaking.
     *
     * @param params parameters set by the recognition service. Reserved for future use.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.784 -0500", hash_original_method = "5E79CED792D509FA402EB28CB9724C98", hash_generated_method = "D1D86973A1A9035B4F2539E09861CE21")
            
public void onReadyForSpeech(android.os.Bundle params) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((params!=null)) {
_data.writeInt(1);
params.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onReadyForSpeech, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * The user has started to speak.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.787 -0500", hash_original_method = "4CEE92725CCE5BB7E67FCF758A0F678A", hash_generated_method = "115FA815463F4A075A5E01A1DA374225")
            
public void onBeginningOfSpeech() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onBeginningOfSpeech, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * The sound level in the audio stream has changed.
     *
     * @param rmsdB the new RMS dB value
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.789 -0500", hash_original_method = "71C2BFF0E1966BE0EF8D22A45A735233", hash_generated_method = "DD6879E938E842E8089D37E832B1C290")
            
public void onRmsChanged(float rmsdB) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeFloat(rmsdB);
mRemote.transact(Stub.TRANSACTION_onRmsChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * More sound has been received.
     *
     * @param buffer the byte buffer containing a sequence of 16-bit shorts.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.792 -0500", hash_original_method = "2FFAE6EB8C686BD7BF73B7E86E010813", hash_generated_method = "FED694D3E6A2DB4881CD5ED340232FBB")
            
public void onBufferReceived(byte[] buffer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(buffer);
mRemote.transact(Stub.TRANSACTION_onBufferReceived, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Called after the user stops speaking.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.795 -0500", hash_original_method = "4839E49827B2C23F8AE8754E92D10037", hash_generated_method = "5914DD08C203691645C2C05BBE991461")
            
public void onEndOfSpeech() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onEndOfSpeech, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * A network or recognition error occurred.
     *
     * @param error code is defined in {@link SpeechRecognizer}
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.797 -0500", hash_original_method = "29F2C870F0FAEAE413D33E34A846A6EC", hash_generated_method = "8C731C839539E3C3A18A5198EA61756D")
            
public void onError(int error) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(error);
mRemote.transact(Stub.TRANSACTION_onError, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Called when recognition results are ready.
     *
     * @param results a Bundle containing the most likely results (N-best list).
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.800 -0500", hash_original_method = "04DECC5749D12FC37B165B18426DBE53", hash_generated_method = "195796BEF52BE25F9C3874CD4C89FB5D")
            
public void onResults(android.os.Bundle results) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((results!=null)) {
_data.writeInt(1);
results.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onResults, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Called when recognition partial results are ready.
     *
     * @param results a Bundle containing the current most likely result.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.804 -0500", hash_original_method = "3A56F6FF4F045BD6993F342393802692", hash_generated_method = "1355783129C93A5508A99DC2CFA7E16A")
            
public void onPartialResults(android.os.Bundle results) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((results!=null)) {
_data.writeInt(1);
results.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onPartialResults, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Reserved for adding future events.
     *
     * @param eventType the type of the occurred event
     * @param params a Bundle containing the passed parameters
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.806 -0500", hash_original_method = "A8A951D6FA1FC7584016F7BD230C84F6", hash_generated_method = "7DED5097D189863FE6BCE5E36FE95E64")
            
public void onEvent(int eventType, android.os.Bundle params) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(eventType);
if ((params!=null)) {
_data.writeInt(1);
params.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onEvent, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.819 -0500", hash_original_field = "EFA0CC3994FDB25F368C1B74C22D69D8", hash_generated_field = "910793577DEDB905CFAA14691838CA13")

static final int TRANSACTION_onBufferReceived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.822 -0500", hash_original_field = "3A250BB0EC1F9E1C6FA97A7E1C702DF7", hash_generated_field = "1FB289AC275A9C7C38810DDD4BE08803")

static final int TRANSACTION_onEndOfSpeech = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.824 -0500", hash_original_field = "D002791BE173C0E1C2510B0875F462E0", hash_generated_field = "DB0CCF4109A616D430289E5DC2D88C92")

static final int TRANSACTION_onError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.827 -0500", hash_original_field = "B242BE5D8C4AC80BFC050C5A36AC364A", hash_generated_field = "6644217810009423885EF2B59025FFE0")

static final int TRANSACTION_onResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.829 -0500", hash_original_field = "AA91CABFCF90A20F1CA474397DD70988", hash_generated_field = "49F4D31AFBF5B583305864AD1ABB763B")

static final int TRANSACTION_onPartialResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.831 -0500", hash_original_field = "4AF985DFDE5E9DD8E4311613265C8201", hash_generated_field = "B6F430685C4FF55FE236F8461BF41B94")

static final int TRANSACTION_onEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.762 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.768 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.771 -0500", hash_original_method = "5227FF56D9B41E271E061A6954626A60", hash_generated_method = "C0C29C82A670431807C7FB93E10C28AA")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onReadyForSpeech:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onReadyForSpeech(_arg0);
return true;
}
case TRANSACTION_onBeginningOfSpeech:
{
data.enforceInterface(DESCRIPTOR);
this.onBeginningOfSpeech();
return true;
}
case TRANSACTION_onRmsChanged:
{
data.enforceInterface(DESCRIPTOR);
float _arg0;
_arg0 = data.readFloat();
this.onRmsChanged(_arg0);
return true;
}
case TRANSACTION_onBufferReceived:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
this.onBufferReceived(_arg0);
return true;
}
case TRANSACTION_onEndOfSpeech:
{
data.enforceInterface(DESCRIPTOR);
this.onEndOfSpeech();
return true;
}
case TRANSACTION_onError:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onError(_arg0);
return true;
}
case TRANSACTION_onResults:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onResults(_arg0);
return true;
}
case TRANSACTION_onPartialResults:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onPartialResults(_arg0);
return true;
}
case TRANSACTION_onEvent:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.Bundle _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.onEvent(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void onReadyForSpeech(android.os.Bundle params) throws android.os.RemoteException;

public void onBeginningOfSpeech() throws android.os.RemoteException;

public void onRmsChanged(float rmsdB) throws android.os.RemoteException;

public void onBufferReceived(byte[] buffer) throws android.os.RemoteException;

public void onEndOfSpeech() throws android.os.RemoteException;

public void onError(int error) throws android.os.RemoteException;

public void onResults(android.os.Bundle results) throws android.os.RemoteException;

public void onPartialResults(android.os.Bundle results) throws android.os.RemoteException;

public void onEvent(int eventType, android.os.Bundle params) throws android.os.RemoteException;
}
