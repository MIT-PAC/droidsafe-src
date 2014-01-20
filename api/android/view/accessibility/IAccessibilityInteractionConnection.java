package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAccessibilityInteractionConnection extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.accessibility.IAccessibilityInteractionConnection
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.650 -0500", hash_original_field = "397013CFDD96033D06CF6AA706B8F8AC", hash_generated_field = "32BDBA9FD1E99F2CDB25FC13EE3BDC73")

private static final java.lang.String DESCRIPTOR = "android.view.accessibility.IAccessibilityInteractionConnection";
/**
 * Cast an IBinder object into an android.view.accessibility.IAccessibilityInteractionConnection interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.656 -0500", hash_original_method = "4B2EC0D520708F4CEB9B77426B3A4ABC", hash_generated_method = "90CC92580716F788016B405798A7807A")
        
public static android.view.accessibility.IAccessibilityInteractionConnection asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.accessibility.IAccessibilityInteractionConnection))) {
return ((android.view.accessibility.IAccessibilityInteractionConnection)iin);
}
return new android.view.accessibility.IAccessibilityInteractionConnection.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.691 -0500", hash_original_field = "5CDE4229990733FB2313505B041BE5FC", hash_generated_field = "EC266DCB1FECA32A9BC738E384F58DEF")

static final int TRANSACTION_findAccessibilityNodeInfoByAccessibilityId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.693 -0500", hash_original_field = "17464B463094DC97B74BE4E2583766DF", hash_generated_field = "C23B80394BB7E8D951199ADF8B27A3BB")

static final int TRANSACTION_findAccessibilityNodeInfoByViewId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.696 -0500", hash_original_field = "D125C7654CD4A3E62C7B5D54781D8EF4", hash_generated_field = "32BAA65EB4B3C41ADB94633E431FEDC0")

static final int TRANSACTION_findAccessibilityNodeInfosByViewText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.view.accessibility.IAccessibilityInteractionConnection
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.666 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.669 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.671 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.673 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.677 -0500", hash_original_method = "4DF065CAA51041FF36589991393B9E1B", hash_generated_method = "5AD9521EDA8787E23E1931C9C5E3C83D")
            
public void findAccessibilityNodeInfoByAccessibilityId(int accessibilityViewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, int interrogatingPid, long interrogatingTid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(accessibilityViewId);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(interrogatingPid);
_data.writeLong(interrogatingTid);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfoByAccessibilityId, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.680 -0500", hash_original_method = "A6EC0D4E864927B7E41D2F9B2D2E634C", hash_generated_method = "AAC077339AE8032A6B3E0A02AB4D7B94")
            
public void findAccessibilityNodeInfoByViewId(int id, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, int interrogatingPid, long interrogatingTid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(interrogatingPid);
_data.writeLong(interrogatingTid);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfoByViewId, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.683 -0500", hash_original_method = "7AC8160799E0A98FF75FCE798A2E647F", hash_generated_method = "7402A3304525A5BC947C298A240F7479")
            
public void findAccessibilityNodeInfosByViewText(java.lang.String text, int accessibilityViewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, int interrogatingPid, long interrogatingTid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeInt(accessibilityViewId);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(interrogatingPid);
_data.writeLong(interrogatingTid);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfosByViewText, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.686 -0500", hash_original_method = "7AD10849B51B79736A7B13A4894A67BE", hash_generated_method = "3F54B191BF49EADEC017812A2ABBA82A")
            
public void performAccessibilityAction(int accessibilityId, int action, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, int interrogatingPid, long interrogatingTid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(accessibilityId);
_data.writeInt(action);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(interrogatingPid);
_data.writeLong(interrogatingTid);
mRemote.transact(Stub.TRANSACTION_performAccessibilityAction, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.699 -0500", hash_original_field = "CFC1A3AC13955572C57F4418BC97DCA5", hash_generated_field = "AF09821C4A6F5FBCA6FD2CBBE5048DC4")

static final int TRANSACTION_performAccessibilityAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.653 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.659 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.663 -0500", hash_original_method = "B80869BDC5438DE728623693A8C92572", hash_generated_method = "1B5948D0CA168AD6EAC66E331064AB6F")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_findAccessibilityNodeInfoByAccessibilityId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg2;
_arg2 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
int _arg3;
_arg3 = data.readInt();
long _arg4;
_arg4 = data.readLong();
this.findAccessibilityNodeInfoByAccessibilityId(_arg0, _arg1, _arg2, _arg3, _arg4);
return true;
}
case TRANSACTION_findAccessibilityNodeInfoByViewId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg2;
_arg2 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
int _arg3;
_arg3 = data.readInt();
long _arg4;
_arg4 = data.readLong();
this.findAccessibilityNodeInfoByViewId(_arg0, _arg1, _arg2, _arg3, _arg4);
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
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg3;
_arg3 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
int _arg4;
_arg4 = data.readInt();
long _arg5;
_arg5 = data.readLong();
this.findAccessibilityNodeInfosByViewText(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg3;
_arg3 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
int _arg4;
_arg4 = data.readInt();
long _arg5;
_arg5 = data.readLong();
this.performAccessibilityAction(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void findAccessibilityNodeInfoByAccessibilityId(int accessibilityViewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, int interrogatingPid, long interrogatingTid) throws android.os.RemoteException;
public void findAccessibilityNodeInfoByViewId(int id, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, int interrogatingPid, long interrogatingTid) throws android.os.RemoteException;
public void findAccessibilityNodeInfosByViewText(java.lang.String text, int accessibilityViewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, int interrogatingPid, long interrogatingTid) throws android.os.RemoteException;
public void performAccessibilityAction(int accessibilityId, int action, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, int interrogatingPid, long interrogatingTid) throws android.os.RemoteException;
}
