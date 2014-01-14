package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAccessibilityInteractionConnectionCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.accessibility.IAccessibilityInteractionConnectionCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.398 -0500", hash_original_field = "672FBB2A25CD6D07367CFADA4510FC41", hash_generated_field = "DEE8CCC422475350B9D83EDFB7A985E2")

private static final java.lang.String DESCRIPTOR = "android.view.accessibility.IAccessibilityInteractionConnectionCallback";
/**
 * Cast an IBinder object into an android.view.accessibility.IAccessibilityInteractionConnectionCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.403 -0500", hash_original_method = "A6F1A55BD333E760C4BC63BEEFD4592A", hash_generated_method = "6604F86282BE81B5DB95C61B409B0CDD")
        
public static android.view.accessibility.IAccessibilityInteractionConnectionCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.accessibility.IAccessibilityInteractionConnectionCallback))) {
return ((android.view.accessibility.IAccessibilityInteractionConnectionCallback)iin);
}
return new android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.435 -0500", hash_original_field = "B0BD93663E0A94D3AF2B4CB6B81613E3", hash_generated_field = "F557233E94AE5253668D026BB363E9A5")

static final int TRANSACTION_setFindAccessibilityNodeInfoResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.437 -0500", hash_original_field = "FD3B96180CACE69103FEC34CE503D93B", hash_generated_field = "1E116AC57AAB676706E4AB483E7E9649")

static final int TRANSACTION_setFindAccessibilityNodeInfosResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.440 -0500", hash_original_field = "D5D780078D6E4DDF74C79F11507099A4", hash_generated_field = "3FED6BFE552ED791C1961F638E921B83")

static final int TRANSACTION_setPerformAccessibilityActionResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.view.accessibility.IAccessibilityInteractionConnectionCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.412 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.415 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.417 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.421 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Sets the result of an async request that returns an {@link AccessibilityNodeInfo}.
     *
     * @param infos The result {@link AccessibilityNodeInfo}.
     * @param interactionId The interaction id to match the result with the request.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.424 -0500", hash_original_method = "93F6A64A2549612DC53BB1F2BE28FAF1", hash_generated_method = "2A90BD62D839D8F264F6A380942EE6E2")
            
public void setFindAccessibilityNodeInfoResult(android.view.accessibility.AccessibilityNodeInfo info, int interactionId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(interactionId);
mRemote.transact(Stub.TRANSACTION_setFindAccessibilityNodeInfoResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Sets the result of an async request that returns {@link AccessibilityNodeInfo}s.
     *
     * @param infos The result {@link AccessibilityNodeInfo}s.
     * @param interactionId The interaction id to match the result with the request.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.427 -0500", hash_original_method = "B271FBE34B7884538110ED9E7BA40205", hash_generated_method = "0AE01A2B38FA14064E17F7E4D7609339")
            
public void setFindAccessibilityNodeInfosResult(java.util.List<android.view.accessibility.AccessibilityNodeInfo> infos, int interactionId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(infos);
_data.writeInt(interactionId);
mRemote.transact(Stub.TRANSACTION_setFindAccessibilityNodeInfosResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Sets the result of a request to perform an accessibility action.
     *
     * @param Whether the action was performed.
     * @param interactionId The interaction id to match the result with the request.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.430 -0500", hash_original_method = "B361DB54FD06FE2AC0B3B6ED370A5CFC", hash_generated_method = "DD4DCF877B5EBF16DA1133726AD2C30E")
            
public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((succeeded)?(1):(0)));
_data.writeInt(interactionId);
mRemote.transact(Stub.TRANSACTION_setPerformAccessibilityActionResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.401 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.406 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.409 -0500", hash_original_method = "BF0E91748A233369F635E8512683A2D7", hash_generated_method = "C8C0F1F987B3FCAEEB55A006FD0B18FE")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setFindAccessibilityNodeInfoResult:
{
data.enforceInterface(DESCRIPTOR);
android.view.accessibility.AccessibilityNodeInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.accessibility.AccessibilityNodeInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setFindAccessibilityNodeInfoResult(_arg0, _arg1);
return true;
}
case TRANSACTION_setFindAccessibilityNodeInfosResult:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.view.accessibility.AccessibilityNodeInfo> _arg0;
_arg0 = data.createTypedArrayList(android.view.accessibility.AccessibilityNodeInfo.CREATOR);
int _arg1;
_arg1 = data.readInt();
this.setFindAccessibilityNodeInfosResult(_arg0, _arg1);
return true;
}
case TRANSACTION_setPerformAccessibilityActionResult:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
int _arg1;
_arg1 = data.readInt();
this.setPerformAccessibilityActionResult(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void setFindAccessibilityNodeInfoResult(android.view.accessibility.AccessibilityNodeInfo info, int interactionId) throws android.os.RemoteException;

public void setFindAccessibilityNodeInfosResult(java.util.List<android.view.accessibility.AccessibilityNodeInfo> infos, int interactionId) throws android.os.RemoteException;

public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) throws android.os.RemoteException;
}
