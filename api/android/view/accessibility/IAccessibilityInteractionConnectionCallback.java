package android.view.accessibility;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface IAccessibilityInteractionConnectionCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.accessibility.IAccessibilityInteractionConnectionCallback
{
private static final java.lang.String DESCRIPTOR = "android.view.accessibility.IAccessibilityInteractionConnectionCallback";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

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
private static class Proxy implements android.view.accessibility.IAccessibilityInteractionConnectionCallback
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
static final int TRANSACTION_setFindAccessibilityNodeInfoResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_setFindAccessibilityNodeInfosResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setPerformAccessibilityActionResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}

public void setFindAccessibilityNodeInfoResult(android.view.accessibility.AccessibilityNodeInfo info, int interactionId) throws android.os.RemoteException;

public void setFindAccessibilityNodeInfosResult(java.util.List<android.view.accessibility.AccessibilityNodeInfo> infos, int interactionId) throws android.os.RemoteException;

public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) throws android.os.RemoteException;
}
