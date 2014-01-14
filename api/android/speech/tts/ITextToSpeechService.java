package android.speech.tts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ITextToSpeechService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.speech.tts.ITextToSpeechService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.858 -0500", hash_original_field = "81DD0E2D071E59F47AD97FE2FC4A9ACD", hash_generated_field = "A92BC81C5A6CA1339938BC9DE3BCE971")

private static final java.lang.String DESCRIPTOR = "android.speech.tts.ITextToSpeechService";
/**
 * Cast an IBinder object into an android.speech.tts.ITextToSpeechService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.864 -0500", hash_original_method = "3EFA2A17E3A9AF2C6729813563746DCE", hash_generated_method = "BE7F361970A72EBD7ADE85E1A828D861")
        
public static android.speech.tts.ITextToSpeechService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.speech.tts.ITextToSpeechService))) {
return ((android.speech.tts.ITextToSpeechService)iin);
}
return new android.speech.tts.ITextToSpeechService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.920 -0500", hash_original_field = "EA84F9ADB9C5ED128CE34ECFBFE2E3B2", hash_generated_field = "90250B918A81CEE86AE1248DCADB5B40")

static final int TRANSACTION_speak = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.923 -0500", hash_original_field = "F991BBA0B0E4425849674A075601326D", hash_generated_field = "59517F232AA83AFDE31C2F17C97AB65C")

static final int TRANSACTION_synthesizeToFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.926 -0500", hash_original_field = "BF9656BBCE4AE808189400CAC1C47EEA", hash_generated_field = "F95997902D58CCCE4238996279BEF61C")

static final int TRANSACTION_playAudio = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.speech.tts.ITextToSpeechService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.875 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.878 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.880 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.882 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Tells the engine to synthesize some speech and play it back.
     *
     * @param callingApp The package name of the calling app. Used to connect requests
     *         callbacks and to clear requests when the calling app is stopping.
     * @param text The text to synthesize.
     * @param queueMode Determines what to do to requests already in the queue.
     * @param param Request parameters.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.885 -0500", hash_original_method = "09BD97D1334819A4DE3A96DF841A6DA4", hash_generated_method = "D7C9397ACADFCBF6420BA8077B66809A")
            
public int speak(java.lang.String callingApp, java.lang.String text, int queueMode, android.os.Bundle params) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(callingApp);
_data.writeString(text);
_data.writeInt(queueMode);
if ((params!=null)) {
_data.writeInt(1);
params.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_speak, _data, _reply, 0);
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
     * Tells the engine to synthesize some speech and write it to a file.
     *
     * @param callingApp The package name of the calling app. Used to connect requests
     *         callbacks and to clear requests when the calling app is stopping.
     * @param text The text to synthesize.
     * @param filename The file to write the synthesized audio to.
     * @param param Request parameters.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.888 -0500", hash_original_method = "135DDF34F6D4D02FC5F03BE333330523", hash_generated_method = "B4B1CCB591446789BA93C9F0D38EF6CD")
            
public int synthesizeToFile(java.lang.String callingApp, java.lang.String text, java.lang.String filename, android.os.Bundle params) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(callingApp);
_data.writeString(text);
_data.writeString(filename);
if ((params!=null)) {
_data.writeInt(1);
params.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_synthesizeToFile, _data, _reply, 0);
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
     * Plays an existing audio resource.
     *
     * @param callingApp The package name of the calling app. Used to connect requests
     *         callbacks and to clear requests when the calling app is stopping.
     * @param audioUri URI for the audio resource (a file or android.resource URI)
     * @param queueMode Determines what to do to requests already in the queue.
     * @param param Request parameters.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.892 -0500", hash_original_method = "FA0C2E0A552D3BCC4F4E3EE7FDA48C7B", hash_generated_method = "2C87A4D6B3277742BB778DA6CC3E177D")
            
public int playAudio(java.lang.String callingApp, android.net.Uri audioUri, int queueMode, android.os.Bundle params) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(callingApp);
if ((audioUri!=null)) {
_data.writeInt(1);
audioUri.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(queueMode);
if ((params!=null)) {
_data.writeInt(1);
params.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_playAudio, _data, _reply, 0);
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
     * Plays silence.
     *
     * @param callingApp The package name of the calling app. Used to connect requests
     *         callbacks and to clear requests when the calling app is stopping.
     * @param duration Number of milliseconds of silence to play.
     * @param queueMode Determines what to do to requests already in the queue.
     * @param param Request parameters.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.894 -0500", hash_original_method = "1CAE9DD480E137E74A91EABE2D915456", hash_generated_method = "B6F11F3BEE007FEA755FB29193EFC79D")
            
public int playSilence(java.lang.String callingApp, long duration, int queueMode, android.os.Bundle params) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(callingApp);
_data.writeLong(duration);
_data.writeInt(queueMode);
if ((params!=null)) {
_data.writeInt(1);
params.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_playSilence, _data, _reply, 0);
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
     * Checks whether the service is currently playing some audio.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.897 -0500", hash_original_method = "DA5E6B693FBEEF5B1E48FC45AB1713D1", hash_generated_method = "8CAA3955B4E19ED0BD1309F411A05843")
            
public boolean isSpeaking() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isSpeaking, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Interrupts the current utterance (if from the given app) and removes any utterances
     * in the queue that are from the given app.
     *
     * @param callingApp Package name of the app whose utterances
     *        should be interrupted and cleared.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.899 -0500", hash_original_method = "9859905843839781A8B87AA6F465024C", hash_generated_method = "284290B50F76833347CC09DE038635D6")
            
public int stop(java.lang.String callingApp) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(callingApp);
mRemote.transact(Stub.TRANSACTION_stop, _data, _reply, 0);
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
     * Returns the language, country and variant currently being used by the TTS engine.
     *
     * Can be called from multiple threads.
     *
     * @return A 3-element array, containing language (ISO 3-letter code),
     *         country (ISO 3-letter code) and variant used by the engine.
     *         The country and variant may be {@code ""}. If country is empty, then variant must
     *         be empty too.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.902 -0500", hash_original_method = "C569A45F37C99B6F9C602D91F256E18B", hash_generated_method = "9025E5D36B5C831FE62F0750C27B378D")
            
public java.lang.String[] getLanguage() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLanguage, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Checks whether the engine supports a given language.
     *
     * @param lang ISO-3 language code.
     * @param country ISO-3 country code. May be empty or null.
     * @param variant Language variant. May be empty or null.
     * @return Code indicating the support status for the locale.
     *         One of {@link TextToSpeech#LANG_AVAILABLE},
     *         {@link TextToSpeech#LANG_COUNTRY_AVAILABLE},
     *         {@link TextToSpeech#LANG_COUNTRY_VAR_AVAILABLE},
     *         {@link TextToSpeech#LANG_MISSING_DATA}
     *         {@link TextToSpeech#LANG_NOT_SUPPORTED}.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.904 -0500", hash_original_method = "7913CAD8BCC780BF05B2FE9B44B9A1B3", hash_generated_method = "17ED0F06197C57D4B2B238A2A16743CD")
            
public int isLanguageAvailable(java.lang.String lang, java.lang.String country, java.lang.String variant) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(lang);
_data.writeString(country);
_data.writeString(variant);
mRemote.transact(Stub.TRANSACTION_isLanguageAvailable, _data, _reply, 0);
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
     * Returns a list of features available for a given language. Elements of the returned
     * string array can be passed in as keys to {@link TextToSpeech#speak} and
     * {@link TextToSpeech#synthesizeToFile} to select a given feature or features to be
     * used during synthesis.
     *
     * @param lang ISO-3 language code.
     * @param country ISO-3 country code. May be empty or null.
     * @param variant Language variant. May be empty or null.
     * @return An array of strings containing the set of features supported for
     *         the supplied locale. The array of strings must not contain 
     *         duplicates.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.908 -0500", hash_original_method = "FE2BB20EC8B6AA673E11F37A3F20D812", hash_generated_method = "60D596B86DC92BF1CD5D540698D93A8E")
            
public java.lang.String[] getFeaturesForLanguage(java.lang.String lang, java.lang.String country, java.lang.String variant) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(lang);
_data.writeString(country);
_data.writeString(variant);
mRemote.transact(Stub.TRANSACTION_getFeaturesForLanguage, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Notifies the engine that it should load a speech synthesis language.
     *
     * @param lang ISO-3 language code.
     * @param country ISO-3 country code. May be empty or null.
     * @param variant Language variant. May be empty or null.
     * @return Code indicating the support status for the locale.
     *         One of {@link TextToSpeech#LANG_AVAILABLE},
     *         {@link TextToSpeech#LANG_COUNTRY_AVAILABLE},
     *         {@link TextToSpeech#LANG_COUNTRY_VAR_AVAILABLE},
     *         {@link TextToSpeech#LANG_MISSING_DATA}
     *         {@link TextToSpeech#LANG_NOT_SUPPORTED}.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.910 -0500", hash_original_method = "B689DC29DF9C0768C6D0F180732D8140", hash_generated_method = "60297672CD57FDA6045D5B2232C93531")
            
public int loadLanguage(java.lang.String lang, java.lang.String country, java.lang.String variant) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(lang);
_data.writeString(country);
_data.writeString(variant);
mRemote.transact(Stub.TRANSACTION_loadLanguage, _data, _reply, 0);
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
     * Sets the callback that will be notified when playback of utterance from the
     * given app are completed.
     *
     * @param callingApp Package name for the app whose utterance the callback will handle.
     * @param cb The callback.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.913 -0500", hash_original_method = "C0EEB754D53CBF8A296618A623FC836C", hash_generated_method = "564ABAAE9BF3BA158356D1B57979ECEB")
            
public void setCallback(java.lang.String callingApp, android.speech.tts.ITextToSpeechCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(callingApp);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.928 -0500", hash_original_field = "192BE4CB081988FDC1B1BE41E13CF4EB", hash_generated_field = "981AC4B455106D71F5639EFBB000F244")

static final int TRANSACTION_playSilence = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.931 -0500", hash_original_field = "732027B164F34DFE3FD9BB3F26225885", hash_generated_field = "7C7CCACBF229A44CBCA0914A2681FC44")

static final int TRANSACTION_isSpeaking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.933 -0500", hash_original_field = "BE61F621723C243DE7622C3AFF877083", hash_generated_field = "4B6F5499A021BC3192FF934EA599D817")

static final int TRANSACTION_stop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.936 -0500", hash_original_field = "32FF0DDCBFB3B988D2F51DCDCEED1B4C", hash_generated_field = "90DA0EB884AEE9913FF07BF4875A8DDD")

static final int TRANSACTION_getLanguage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.938 -0500", hash_original_field = "AB232A5F24022CB118BD8BEACABFEFE6", hash_generated_field = "238991933AE4271360E8757103E4F2B2")

static final int TRANSACTION_isLanguageAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.940 -0500", hash_original_field = "65D83D4276AFD9ACE963F31F56809CF9", hash_generated_field = "C99D0897DE12385E48BBD3F1AD8C5CDB")

static final int TRANSACTION_getFeaturesForLanguage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.943 -0500", hash_original_field = "7F54885E866A0DCAC10BD3A7603D6775", hash_generated_field = "B95EEAAD05469F4F8CCED7DAA701303C")

static final int TRANSACTION_loadLanguage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.945 -0500", hash_original_field = "171294B20A5DF6F57EF43909070A6229", hash_generated_field = "00853EE40E234CB9228E9D78DF42F9F4")

static final int TRANSACTION_setCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.861 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.866 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:54.872 -0500", hash_original_method = "01C1950B898344CC31DFBAEB904BB96C", hash_generated_method = "9DC5C74CF85847C17075331480A1EE9A")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_speak:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
android.os.Bundle _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _result = this.speak(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_synthesizeToFile:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
android.os.Bundle _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _result = this.synthesizeToFile(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_playAudio:
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
int _arg2;
_arg2 = data.readInt();
android.os.Bundle _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _result = this.playAudio(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_playSilence:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _arg1;
_arg1 = data.readLong();
int _arg2;
_arg2 = data.readInt();
android.os.Bundle _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _result = this.playSilence(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isSpeaking:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isSpeaking();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_stop:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.stop(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getLanguage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getLanguage();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_isLanguageAvailable:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
int _result = this.isLanguageAvailable(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getFeaturesForLanguage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String[] _result = this.getFeaturesForLanguage(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_loadLanguage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
int _result = this.loadLanguage(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setCallback:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.speech.tts.ITextToSpeechCallback _arg1;
_arg1 = android.speech.tts.ITextToSpeechCallback.Stub.asInterface(data.readStrongBinder());
this.setCallback(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public int speak(java.lang.String callingApp, java.lang.String text, int queueMode, android.os.Bundle params) throws android.os.RemoteException;

public int synthesizeToFile(java.lang.String callingApp, java.lang.String text, java.lang.String filename, android.os.Bundle params) throws android.os.RemoteException;

public int playAudio(java.lang.String callingApp, android.net.Uri audioUri, int queueMode, android.os.Bundle params) throws android.os.RemoteException;

public int playSilence(java.lang.String callingApp, long duration, int queueMode, android.os.Bundle params) throws android.os.RemoteException;

public boolean isSpeaking() throws android.os.RemoteException;

public int stop(java.lang.String callingApp) throws android.os.RemoteException;

public java.lang.String[] getLanguage() throws android.os.RemoteException;

public int isLanguageAvailable(java.lang.String lang, java.lang.String country, java.lang.String variant) throws android.os.RemoteException;

public java.lang.String[] getFeaturesForLanguage(java.lang.String lang, java.lang.String country, java.lang.String variant) throws android.os.RemoteException;

public int loadLanguage(java.lang.String lang, java.lang.String country, java.lang.String variant) throws android.os.RemoteException;

public void setCallback(java.lang.String callingApp, android.speech.tts.ITextToSpeechCallback cb) throws android.os.RemoteException;
}
