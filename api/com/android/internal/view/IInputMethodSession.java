package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IInputMethodSession extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.view.IInputMethodSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.653 -0500", hash_original_field = "94B3E93FC26103DFE6233CAFA2F8F2FA", hash_generated_field = "FE8B88E01134D0C5E342528ABB0EAC0A")

private static final java.lang.String DESCRIPTOR = "com.android.internal.view.IInputMethodSession";
/**
 * Cast an IBinder object into an com.android.internal.view.IInputMethodSession interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.660 -0500", hash_original_method = "8C71E6F470995CC482B9A351C67242E9", hash_generated_method = "E25476224DDCBB6A823F64220061CBDC")
        
public static com.android.internal.view.IInputMethodSession asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.view.IInputMethodSession))) {
return ((com.android.internal.view.IInputMethodSession)iin);
}
return new com.android.internal.view.IInputMethodSession.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.718 -0500", hash_original_field = "4D10405316A5B72BFA2659AEA41FD963", hash_generated_field = "9C94092E9C63C0FDA5B0E031A340DF9D")

static final int TRANSACTION_finishInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.721 -0500", hash_original_field = "643A574B0CE37CF46489C13590F5EBE6", hash_generated_field = "9B43753C141382B542883F5FE70219E6")

static final int TRANSACTION_updateExtractedText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.723 -0500", hash_original_field = "4BC1625317AEA1FE22B998950684972E", hash_generated_field = "F1AA20118543DE36DDD4DA99A40E23D4")

static final int TRANSACTION_updateSelection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.view.IInputMethodSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.671 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.673 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.676 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.678 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.681 -0500", hash_original_method = "76BECB5683B8F9DC0E4E72482EF263E6", hash_generated_method = "BA4A05B4F3CF27CFB8D26C82B53846C2")
            
public void finishInput() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_finishInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.685 -0500", hash_original_method = "63688C191DF956999E36B175D0CE4DE4", hash_generated_method = "30C39FFAD7DBF6D80302CB76DDB6D847")
            
public void updateExtractedText(int token, android.view.inputmethod.ExtractedText text) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(token);
if ((text!=null)) {
_data.writeInt(1);
text.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateExtractedText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.688 -0500", hash_original_method = "3B75D127BDDEB2BCCF4058A50F624C2F", hash_generated_method = "A0E0A6373C5C868A9C4C28F0609D66AF")
            
public void updateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(oldSelStart);
_data.writeInt(oldSelEnd);
_data.writeInt(newSelStart);
_data.writeInt(newSelEnd);
_data.writeInt(candidatesStart);
_data.writeInt(candidatesEnd);
mRemote.transact(Stub.TRANSACTION_updateSelection, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.691 -0500", hash_original_method = "AD062A56CF31F1604CFC2C85D270FB66", hash_generated_method = "CA22DBEF41E87E676AF9A94B00238F6F")
            
public void viewClicked(boolean focusChanged) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((focusChanged)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_viewClicked, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.693 -0500", hash_original_method = "9A70B6FAF68A3B1FEC69492959357545", hash_generated_method = "D36A4340CD3140E91E1EB2D826E208CA")
            
public void updateCursor(android.graphics.Rect newCursor) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((newCursor!=null)) {
_data.writeInt(1);
newCursor.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateCursor, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.696 -0500", hash_original_method = "17230B25CAE34D9A132D4334482FBF12", hash_generated_method = "FA87CE071DFD567DFEAF2387C2BC7F0E")
            
public void displayCompletions(android.view.inputmethod.CompletionInfo[] completions) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(completions, 0);
mRemote.transact(Stub.TRANSACTION_displayCompletions, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.699 -0500", hash_original_method = "8535A81DE6F1B4CCB8EE6162C6308D1B", hash_generated_method = "9D24DA6FF73F6B757FA0888BD1500A59")
            
public void dispatchKeyEvent(int seq, android.view.KeyEvent event, com.android.internal.view.IInputMethodCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(seq);
if ((event!=null)) {
_data.writeInt(1);
event.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_dispatchKeyEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.702 -0500", hash_original_method = "6D36B4F577208C9EF30A9C7F8A238DC0", hash_generated_method = "DA485A28536E0D01DBC6DB169343AE88")
            
public void dispatchTrackballEvent(int seq, android.view.MotionEvent event, com.android.internal.view.IInputMethodCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(seq);
if ((event!=null)) {
_data.writeInt(1);
event.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_dispatchTrackballEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.705 -0500", hash_original_method = "984C45460A707C51646DD22F54A2053C", hash_generated_method = "FFE795E7391A11B712736208929ABCD7")
            
public void appPrivateCommand(java.lang.String action, android.os.Bundle data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(action);
if ((data!=null)) {
_data.writeInt(1);
data.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_appPrivateCommand, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.709 -0500", hash_original_method = "A6B79DF9DED6BCC928CD6E276E7F088F", hash_generated_method = "50BFBB05DA1EB19778D15CB0A1C13BFD")
            
public void toggleSoftInput(int showFlags, int hideFlags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(showFlags);
_data.writeInt(hideFlags);
mRemote.transact(Stub.TRANSACTION_toggleSoftInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.712 -0500", hash_original_method = "A8106C8710EDF35ED9F387FD5659C2A1", hash_generated_method = "AE71D5C807F0B3DE357BC2E9D34200DD")
            
public void finishSession() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_finishSession, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.726 -0500", hash_original_field = "67B8AF57D25EDC0BB4CE44689DCC9688", hash_generated_field = "84C9AFD7FF9A8F10EE3324457B24BB3F")

static final int TRANSACTION_viewClicked = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.729 -0500", hash_original_field = "F07A9B48A71025DCDECE892BDF7603D9", hash_generated_field = "0EA32E72DAD7A34329465288F10F5909")

static final int TRANSACTION_updateCursor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.732 -0500", hash_original_field = "9B55C3728E0E30347250BB45D301B88F", hash_generated_field = "BB341178368570513B801FBBA46FCB16")

static final int TRANSACTION_displayCompletions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.734 -0500", hash_original_field = "7A63553392C3399666A7E97710CC41D6", hash_generated_field = "C31CAD8648AAC8FEB39A1159B82B13A4")

static final int TRANSACTION_dispatchKeyEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.737 -0500", hash_original_field = "1BDD3E7E05AA493A2B494E92FB0E47A3", hash_generated_field = "FE51A5E11DC441E7553C5DE727214828")

static final int TRANSACTION_dispatchTrackballEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.739 -0500", hash_original_field = "AD0393DFE9125ACA83ED1FF9F8502954", hash_generated_field = "48DA5895A50C3F0F8A7938FB9B05EF63")

static final int TRANSACTION_appPrivateCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.742 -0500", hash_original_field = "93E624AC611DF910A3387D2D7936FAE6", hash_generated_field = "8461DD696BC82D594057FE3EA8756606")

static final int TRANSACTION_toggleSoftInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.744 -0500", hash_original_field = "9E492C1C5ADCE41DA73E02E734E7DD3C", hash_generated_field = "294DBE754F604513E9626DF022EE641D")

static final int TRANSACTION_finishSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.658 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.663 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.667 -0500", hash_original_method = "08EECC56BA7D5856DF5BE23D8B4631E1", hash_generated_method = "8297BC13212C9F88D973DDE06498B832")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_finishInput:
{
data.enforceInterface(DESCRIPTOR);
this.finishInput();
reply.writeNoException();
return true;
}
case TRANSACTION_updateExtractedText:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.view.inputmethod.ExtractedText _arg1;
if ((0!=data.readInt())) {
_arg1 = android.view.inputmethod.ExtractedText.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.updateExtractedText(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_updateSelection:
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
int _arg4;
_arg4 = data.readInt();
int _arg5;
_arg5 = data.readInt();
this.updateSelection(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_viewClicked:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.viewClicked(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_updateCursor:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Rect _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Rect.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.updateCursor(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_displayCompletions:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.CompletionInfo[] _arg0;
_arg0 = data.createTypedArray(android.view.inputmethod.CompletionInfo.CREATOR);
this.displayCompletions(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_dispatchKeyEvent:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.view.KeyEvent _arg1;
if ((0!=data.readInt())) {
_arg1 = android.view.KeyEvent.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.android.internal.view.IInputMethodCallback _arg2;
_arg2 = com.android.internal.view.IInputMethodCallback.Stub.asInterface(data.readStrongBinder());
this.dispatchKeyEvent(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_dispatchTrackballEvent:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.view.MotionEvent _arg1;
if ((0!=data.readInt())) {
_arg1 = android.view.MotionEvent.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.android.internal.view.IInputMethodCallback _arg2;
_arg2 = com.android.internal.view.IInputMethodCallback.Stub.asInterface(data.readStrongBinder());
this.dispatchTrackballEvent(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_appPrivateCommand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.Bundle _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.appPrivateCommand(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_toggleSoftInput:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.toggleSoftInput(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_finishSession:
{
data.enforceInterface(DESCRIPTOR);
this.finishSession();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void finishInput() throws android.os.RemoteException;
public void updateExtractedText(int token, android.view.inputmethod.ExtractedText text) throws android.os.RemoteException;
public void updateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) throws android.os.RemoteException;
public void viewClicked(boolean focusChanged) throws android.os.RemoteException;
public void updateCursor(android.graphics.Rect newCursor) throws android.os.RemoteException;
public void displayCompletions(android.view.inputmethod.CompletionInfo[] completions) throws android.os.RemoteException;
public void dispatchKeyEvent(int seq, android.view.KeyEvent event, com.android.internal.view.IInputMethodCallback callback) throws android.os.RemoteException;
public void dispatchTrackballEvent(int seq, android.view.MotionEvent event, com.android.internal.view.IInputMethodCallback callback) throws android.os.RemoteException;
public void appPrivateCommand(java.lang.String action, android.os.Bundle data) throws android.os.RemoteException;
public void toggleSoftInput(int showFlags, int hideFlags) throws android.os.RemoteException;
public void finishSession() throws android.os.RemoteException;
}
