package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAccessibilityManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.accessibility.IAccessibilityManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.758 -0500", hash_original_field = "431AA76113946587B1387EE33EA3006F", hash_generated_field = "8FDE2ACB4C030FCDFD38B19EDB616E0C")

private static final java.lang.String DESCRIPTOR = "android.view.accessibility.IAccessibilityManager";
/**
 * Cast an IBinder object into an android.view.accessibility.IAccessibilityManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.764 -0500", hash_original_method = "2C41A84143E15AB50B62964D4E6BC6B2", hash_generated_method = "5B9C767ABA31069AFB7D997D33DCBCFA")
        
public static android.view.accessibility.IAccessibilityManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.accessibility.IAccessibilityManager))) {
return ((android.view.accessibility.IAccessibilityManager)iin);
}
return new android.view.accessibility.IAccessibilityManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.811 -0500", hash_original_field = "121267C301F410A582EAFE4F57B11350", hash_generated_field = "024C6C7FBE3AC95F61A5218926D33ABF")

static final int TRANSACTION_addClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.813 -0500", hash_original_field = "BA1BD41BB48C32E7E8B88329F8CD3710", hash_generated_field = "37F809A5B49AB99CE7699877095F5E46")

static final int TRANSACTION_sendAccessibilityEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.816 -0500", hash_original_field = "ACCAD854A58DC6118C3688F300C503A9", hash_generated_field = "544512791B96475B690040088F01E2B2")

static final int TRANSACTION_getInstalledAccessibilityServiceList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.view.accessibility.IAccessibilityManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.773 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.776 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.779 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.781 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.785 -0500", hash_original_method = "C0AABF28A01D74CCDCBD99D974F10D26", hash_generated_method = "CAF800F538BE9C78C10337D34B34D54F")
            
public int addClient(android.view.accessibility.IAccessibilityManagerClient client) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addClient, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.787 -0500", hash_original_method = "B29657CA1E55016BFF93FAD5BB24A8ED", hash_generated_method = "0827BFD1CE262F213BBBCDF3886B994D")
            
public boolean sendAccessibilityEvent(android.view.accessibility.AccessibilityEvent uiEvent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((uiEvent!=null)) {
_data.writeInt(1);
uiEvent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendAccessibilityEvent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.790 -0500", hash_original_method = "B94DDD3E105C0C224474F520EE80F369", hash_generated_method = "80E3AA4EFDF5B7089CEA79566D5315CF")
            
public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getInstalledAccessibilityServiceList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.accessibilityservice.AccessibilityServiceInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInstalledAccessibilityServiceList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.accessibilityservice.AccessibilityServiceInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.793 -0500", hash_original_method = "95146969FAB79D48FF28243911E02584", hash_generated_method = "38B3C3A465DF6424B681E2DD443761D2")
            
public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int feedbackType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.accessibilityservice.AccessibilityServiceInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(feedbackType);
mRemote.transact(Stub.TRANSACTION_getEnabledAccessibilityServiceList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.accessibilityservice.AccessibilityServiceInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.796 -0500", hash_original_method = "97A99A3A4ADD62B329D16F134AEA182E", hash_generated_method = "E5DAFCB2729F6F94DF3AF2764B9A31B1")
            
public void interrupt() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_interrupt, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.798 -0500", hash_original_method = "8F9F7F592202AE7E4E2C35341358E177", hash_generated_method = "1C759DDC9EA9B552142206FF1B5E943A")
            
public int addAccessibilityInteractionConnection(android.view.IWindow windowToken, android.view.accessibility.IAccessibilityInteractionConnection connection) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((windowToken!=null))?(windowToken.asBinder()):(null)));
_data.writeStrongBinder((((connection!=null))?(connection.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addAccessibilityInteractionConnection, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.801 -0500", hash_original_method = "A2E76C6D6D47D8BB67C8328FAD350821", hash_generated_method = "06CDA3E13CCB62D3704C920EA1AE276D")
            
public void removeAccessibilityInteractionConnection(android.view.IWindow windowToken) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((windowToken!=null))?(windowToken.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeAccessibilityInteractionConnection, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.804 -0500", hash_original_method = "F39BDDD611F1EA87EA808297FD3031CF", hash_generated_method = "459BB5A357BDFA055CF325B0EE53092F")
            
public void registerEventListener(android.accessibilityservice.IEventListener client) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerEventListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.818 -0500", hash_original_field = "F2905CE2F67C44D1F9B278FEDAB04C37", hash_generated_field = "406B999A3BE1CAFF6EF8834F2187D4F0")

static final int TRANSACTION_getEnabledAccessibilityServiceList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.820 -0500", hash_original_field = "D861C7175B49AAC271D795F877A39548", hash_generated_field = "916BB595635F88078EBD833F75823BC9")

static final int TRANSACTION_interrupt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.823 -0500", hash_original_field = "CFE3C3C5FC5C52D7C3F5B8AA69A2D78F", hash_generated_field = "B9BE8F4E148DC7957DD1551A30222116")

static final int TRANSACTION_addAccessibilityInteractionConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.825 -0500", hash_original_field = "7DDBB0652036223A346D625DEC9723F2", hash_generated_field = "7F86C765726010F55C96F9EC1071033F")

static final int TRANSACTION_removeAccessibilityInteractionConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.829 -0500", hash_original_field = "229F5411228A48149447DA34C6732B1F", hash_generated_field = "DF94CABAD68652455012D8355E7F3EC3")

static final int TRANSACTION_registerEventListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.761 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.766 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.770 -0500", hash_original_method = "9FE6277C1990A4D8C975FC55D251A642", hash_generated_method = "D78825EC1600A03C0EDA1D725A848D30")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_addClient:
{
data.enforceInterface(DESCRIPTOR);
android.view.accessibility.IAccessibilityManagerClient _arg0;
_arg0 = android.view.accessibility.IAccessibilityManagerClient.Stub.asInterface(data.readStrongBinder());
int _result = this.addClient(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_sendAccessibilityEvent:
{
data.enforceInterface(DESCRIPTOR);
android.view.accessibility.AccessibilityEvent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.accessibility.AccessibilityEvent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.sendAccessibilityEvent(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getInstalledAccessibilityServiceList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.accessibilityservice.AccessibilityServiceInfo> _result = this.getInstalledAccessibilityServiceList();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getEnabledAccessibilityServiceList:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<android.accessibilityservice.AccessibilityServiceInfo> _result = this.getEnabledAccessibilityServiceList(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_interrupt:
{
data.enforceInterface(DESCRIPTOR);
this.interrupt();
reply.writeNoException();
return true;
}
case TRANSACTION_addAccessibilityInteractionConnection:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
android.view.accessibility.IAccessibilityInteractionConnection _arg1;
_arg1 = android.view.accessibility.IAccessibilityInteractionConnection.Stub.asInterface(data.readStrongBinder());
int _result = this.addAccessibilityInteractionConnection(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_removeAccessibilityInteractionConnection:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
this.removeAccessibilityInteractionConnection(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerEventListener:
{
data.enforceInterface(DESCRIPTOR);
android.accessibilityservice.IEventListener _arg0;
_arg0 = android.accessibilityservice.IEventListener.Stub.asInterface(data.readStrongBinder());
this.registerEventListener(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public int addClient(android.view.accessibility.IAccessibilityManagerClient client) throws android.os.RemoteException;
public boolean sendAccessibilityEvent(android.view.accessibility.AccessibilityEvent uiEvent) throws android.os.RemoteException;
public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getInstalledAccessibilityServiceList() throws android.os.RemoteException;
public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int feedbackType) throws android.os.RemoteException;
public void interrupt() throws android.os.RemoteException;
public int addAccessibilityInteractionConnection(android.view.IWindow windowToken, android.view.accessibility.IAccessibilityInteractionConnection connection) throws android.os.RemoteException;
public void removeAccessibilityInteractionConnection(android.view.IWindow windowToken) throws android.os.RemoteException;
public void registerEventListener(android.accessibilityservice.IEventListener client) throws android.os.RemoteException;
}
