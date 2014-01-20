package android.accessibilityservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAccessibilityServiceConnection extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.accessibilityservice.IAccessibilityServiceConnection
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.978 -0500", hash_original_field = "18CE01CADE2952197A8644E7061D793B", hash_generated_field = "D8F142D52FAD4D9B2BD02A9F9AE9C673")

private static final java.lang.String DESCRIPTOR = "android.accessibilityservice.IAccessibilityServiceConnection";
/**
 * Cast an IBinder object into an android.accessibilityservice.IAccessibilityServiceConnection interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.985 -0500", hash_original_method = "ADC25E12C76CE0D88A285246579678E3", hash_generated_method = "AB6A7B6035CEB133F6E742E27BCF0450")
        
public static android.accessibilityservice.IAccessibilityServiceConnection asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.accessibilityservice.IAccessibilityServiceConnection))) {
return ((android.accessibilityservice.IAccessibilityServiceConnection)iin);
}
return new android.accessibilityservice.IAccessibilityServiceConnection.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.030 -0500", hash_original_field = "EA75BF14D5C6C705A702E7D7373D1114", hash_generated_field = "971BFDF1FF47EE59A0386CF4E0C62FDC")

static final int TRANSACTION_setServiceInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.033 -0500", hash_original_field = "7B2D4AEDF5B29087A8D21E7B1B6437DF", hash_generated_field = "32F8DC5CB3EC27BD09B9A216B84E4921")

static final int TRANSACTION_findAccessibilityNodeInfoByAccessibilityId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.035 -0500", hash_original_field = "D125C7654CD4A3E62C7B5D54781D8EF4", hash_generated_field = "32BAA65EB4B3C41ADB94633E431FEDC0")

static final int TRANSACTION_findAccessibilityNodeInfosByViewText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.accessibilityservice.IAccessibilityServiceConnection
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.996 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.999 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.001 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.004 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.007 -0500", hash_original_method = "B71E6CCB11408735438C09A7524030F7", hash_generated_method = "E01B7AAD6267FEB27984D4505EAB26D4")
            
public void setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo info) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setServiceInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Finds an {@link AccessibilityNodeInfo} by accessibility id.
     *
     * @param accessibilityWindowId A unique window id.
     * @param accessibilityViewId A unique View accessibility id.
     * @param interactionId The id of the interaction for matching with the callback result.
     * @param callback Callback which to receive the result.
     * @param threadId The id of the calling thread.
     * @return The current window scale, where zero means a failure.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.011 -0500", hash_original_method = "55BA2A755153D827DCAA91699E15E33F", hash_generated_method = "6AEFCAE9B5B5FC9AD1C47C632DAEEDC0")
            
public float findAccessibilityNodeInfoByAccessibilityId(int accessibilityWindowId, int accessibilityViewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(accessibilityWindowId);
_data.writeInt(accessibilityViewId);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfoByAccessibilityId, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Finds {@link AccessibilityNodeInfo}s by View text. The match is case
     * insensitive containment. The search is performed in the window whose
     * id is specified and starts from the View whose accessibility id is
     * specified.
     *
     * @param text The searched text.
     * @param accessibilityWindowId A unique window id.
     * @param accessibilityViewId A unique View accessibility id from where to start the search.
     *        Use {@link android.view.View#NO_ID} to start from the root.
     * @param interactionId The id of the interaction for matching with the callback result.
     * @param callback Callback which to receive the result.
     * @param threadId The id of the calling thread.
     * @return The current window scale, where zero means a failure.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.014 -0500", hash_original_method = "ED963318450B6659A077D14F574A167B", hash_generated_method = "7E220A2BE5430AD182083C343D293B84")
            
public float findAccessibilityNodeInfosByViewText(java.lang.String text, int accessibilityWindowId, int accessibilityViewId, int interractionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeInt(accessibilityWindowId);
_data.writeInt(accessibilityViewId);
_data.writeInt(interractionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfosByViewText, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Finds {@link AccessibilityNodeInfo}s by View text. The match is case
     * insensitive containment. The search is performed in the currently
     * active window and start from the root View in the window.
     *
     * @param text The searched text.
     * @param accessibilityId The id of the view from which to start searching.
     *        Use {@link android.view.View#NO_ID} to start from the root.
     * @param interactionId The id of the interaction for matching with the callback result.
     * @param callback Callback which to receive the result.
     * @param threadId The id of the calling thread.
     * @return The current window scale, where zero means a failure.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.017 -0500", hash_original_method = "0D55FC0836B4177E84D20165B4035E88", hash_generated_method = "075F0E6BDA7A2D2B6DCC7377EE699386")
            
public float findAccessibilityNodeInfosByViewTextInActiveWindow(java.lang.String text, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfosByViewTextInActiveWindow, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Finds an {@link AccessibilityNodeInfo} by View id. The search is performed
     * in the currently active window and starts from the root View in the window.
     *
     * @param id The id of the node.
     * @param interactionId The id of the interaction for matching with the callback result.
     * @param callback Callback which to receive the result.
     * @param threadId The id of the calling thread.
     * @return The current window scale, where zero means a failure.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.021 -0500", hash_original_method = "299E26B9A3F7DC05F4D51610C4322DA3", hash_generated_method = "708F863981BA1B8F2A54521CBFE09AE2")
            
public float findAccessibilityNodeInfoByViewIdInActiveWindow(int viewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(viewId);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfoByViewIdInActiveWindow, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Performs an accessibility action on an {@link AccessibilityNodeInfo}.
     *
     * @param accessibilityWindowId The id of the window.
     * @param accessibilityViewId A unique View accessibility id.
     * @param action The action to perform.
     * @param interactionId The id of the interaction for matching with the callback result.
     * @param callback Callback which to receive the result.
     * @param threadId The id of the calling thread.
     * @return Whether the action was performed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.024 -0500", hash_original_method = "FFDFC033E7ECEBBE837B4A18FDB32156", hash_generated_method = "64AA1935329D21B1EE9FE30B6047E120")
            
public boolean performAccessibilityAction(int accessibilityWindowId, int accessibilityViewId, int action, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(accessibilityWindowId);
_data.writeInt(accessibilityViewId);
_data.writeInt(action);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_performAccessibilityAction, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.038 -0500", hash_original_field = "906824C976D3A14BEF7BFA420F53693F", hash_generated_field = "713C1F885E36AAB5EFE825AB876507AB")

static final int TRANSACTION_findAccessibilityNodeInfosByViewTextInActiveWindow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.041 -0500", hash_original_field = "30B1AE758CA477D8D4582B2FE91A17FC", hash_generated_field = "4AB9A342DA91DFB056FD4834256C237A")

static final int TRANSACTION_findAccessibilityNodeInfoByViewIdInActiveWindow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.043 -0500", hash_original_field = "409E557A8232934B0800FD0595FE6F2A", hash_generated_field = "EFB6B5BD801D594626F1E7B3030FDA10")

static final int TRANSACTION_performAccessibilityAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.981 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.987 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.992 -0500", hash_original_method = "0322F731EE5DA7A046278E2394FC07DD", hash_generated_method = "7F91E7971566785E3C847F7ECEC56B57")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setServiceInfo:
{
data.enforceInterface(DESCRIPTOR);
android.accessibilityservice.AccessibilityServiceInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accessibilityservice.AccessibilityServiceInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setServiceInfo(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_findAccessibilityNodeInfoByAccessibilityId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg3;
_arg3 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg4;
_arg4 = data.readLong();
float _result = this.findAccessibilityNodeInfoByAccessibilityId(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_findAccessibilityNodeInfosByViewText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg4;
_arg4 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg5;
_arg5 = data.readLong();
float _result = this.findAccessibilityNodeInfosByViewText(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_findAccessibilityNodeInfosByViewTextInActiveWindow:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg2;
_arg2 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg3;
_arg3 = data.readLong();
float _result = this.findAccessibilityNodeInfosByViewTextInActiveWindow(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_findAccessibilityNodeInfoByViewIdInActiveWindow:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg2;
_arg2 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg3;
_arg3 = data.readLong();
float _result = this.findAccessibilityNodeInfoByViewIdInActiveWindow(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_performAccessibilityAction:
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
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg4;
_arg4 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg5;
_arg5 = data.readLong();
boolean _result = this.performAccessibilityAction(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo info) throws android.os.RemoteException;

public float findAccessibilityNodeInfoByAccessibilityId(int accessibilityWindowId, int accessibilityViewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;

public float findAccessibilityNodeInfosByViewText(java.lang.String text, int accessibilityWindowId, int accessibilityViewId, int interractionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;

public float findAccessibilityNodeInfosByViewTextInActiveWindow(java.lang.String text, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;

public float findAccessibilityNodeInfoByViewIdInActiveWindow(int viewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;

public boolean performAccessibilityAction(int accessibilityWindowId, int accessibilityViewId, int action, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;
}
