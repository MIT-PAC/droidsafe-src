package android.speech;

// Droidsafe Imports

public interface IRecognitionListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.speech.IRecognitionListener
{
private static final java.lang.String DESCRIPTOR = "android.speech.IRecognitionListener";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

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
public android.os.IBinder asBinder()
{
return this;
}
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
private static class Proxy implements android.speech.IRecognitionListener
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}

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
static final int TRANSACTION_onReadyForSpeech = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onBeginningOfSpeech = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onRmsChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onBufferReceived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onEndOfSpeech = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_onError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_onPartialResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_onEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
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
