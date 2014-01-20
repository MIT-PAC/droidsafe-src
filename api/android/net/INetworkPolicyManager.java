package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface INetworkPolicyManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.net.INetworkPolicyManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.459 -0500", hash_original_field = "4B0F4B39E86E6959F72A3EA2D0577BE0", hash_generated_field = "0947F852ACC724B069122D2B8EA5ED5E")

private static final java.lang.String DESCRIPTOR = "android.net.INetworkPolicyManager";
/**
 * Cast an IBinder object into an android.net.INetworkPolicyManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.464 -0500", hash_original_method = "C3A485327AC8189E7C41B88DA6135075", hash_generated_method = "A202BCEAB7D5FB9C2AF502EA774CB63F")
        
public static android.net.INetworkPolicyManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.INetworkPolicyManager))) {
return ((android.net.INetworkPolicyManager)iin);
}
return new android.net.INetworkPolicyManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.519 -0500", hash_original_field = "504713D2A0B456E8819621E7509FBF11", hash_generated_field = "50692D8A705094240B486D4A0923777C")

static final int TRANSACTION_setUidPolicy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.521 -0500", hash_original_field = "D7F60A8A1DB73151D1670140249FCD4D", hash_generated_field = "0CCA130D160723982EAB8C12E7E74B09")

static final int TRANSACTION_getUidPolicy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.524 -0500", hash_original_field = "CA1909D295B2C918C21B45D0DA6EA615", hash_generated_field = "41F170F5B09A2D6CABC4636831EF7102")

static final int TRANSACTION_isUidForeground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.INetworkPolicyManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.474 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.477 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.479 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.481 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/** Control UID policies. */
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.484 -0500", hash_original_method = "F5900E4FC1E6E083433DA9A50E3DA8F9", hash_generated_method = "F5CE0B303F9D811C9DFA7EAA1712A70F")
            
public void setUidPolicy(int uid, int policy) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(policy);
mRemote.transact(Stub.TRANSACTION_setUidPolicy, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.487 -0500", hash_original_method = "D2F77A83601324CC33F08FD17E647056", hash_generated_method = "DF41DF3CEB8C4FA5A48F9B256601A53F")
            
public int getUidPolicy(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getUidPolicy, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.489 -0500", hash_original_method = "B9844D92D9F0FDE18E63B5A8061CE066", hash_generated_method = "6A959C261922918A00BBA570CE86BFF4")
            
public boolean isUidForeground(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_isUidForeground, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.492 -0500", hash_original_method = "217B7E6A80257783BC0154FFB9062AD0", hash_generated_method = "6607EBD55E8894899EE4E941E1BE2B46")
            
public void registerListener(android.net.INetworkPolicyListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.496 -0500", hash_original_method = "13CB24254CFB5C06AEC79035A6D92342", hash_generated_method = "0302D99DF3C292309CFEA4FDA99D1093")
            
public void unregisterListener(android.net.INetworkPolicyListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** Control network policies atomically. */
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.499 -0500", hash_original_method = "B234C89B0F7751F5E9F4B34D18F040B2", hash_generated_method = "78C7ECC5CC96490F92C494F1C40331DC")
            
public void setNetworkPolicies(android.net.NetworkPolicy[] policies) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(policies, 0);
mRemote.transact(Stub.TRANSACTION_setNetworkPolicies, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.502 -0500", hash_original_method = "FE4BC10598D04CB1FDAF5F3C362FB674", hash_generated_method = "6F956E87296D405F0FC72B59B6B40EBE")
            
public android.net.NetworkPolicy[] getNetworkPolicies() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkPolicy[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNetworkPolicies, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.net.NetworkPolicy.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** Snooze limit on policy matching given template. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.504 -0500", hash_original_method = "E267E626DFFF081B0FBEEAF0C298FE81", hash_generated_method = "5043F46682731803140A9926CFA67155")
            
public void snoozePolicy(android.net.NetworkTemplate template) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((template!=null)) {
_data.writeInt(1);
template.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_snoozePolicy, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** Control if background data is restricted system-wide. */
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.507 -0500", hash_original_method = "965C77F86EA0A588BDD3C3BB9EBBCCFB", hash_generated_method = "52F7EB507FE1FA0E0A64672CA2AEE121")
            
public void setRestrictBackground(boolean restrictBackground) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((restrictBackground)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setRestrictBackground, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.509 -0500", hash_original_method = "DC10D4823985AAE86008F074A0AEBED7", hash_generated_method = "A0D484CE58D03CB2DA057B5A33CBCC41")
            
public boolean getRestrictBackground() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRestrictBackground, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.512 -0500", hash_original_method = "AB0519972ECDCC0F8A61F037F37779DA", hash_generated_method = "C5C25F830D8B58C6C113391BA0FD8DA9")
            
public android.net.NetworkQuotaInfo getNetworkQuotaInfo(android.net.NetworkState state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkQuotaInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((state!=null)) {
_data.writeInt(1);
state.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getNetworkQuotaInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkQuotaInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.527 -0500", hash_original_field = "78429321A627B1FDD46F15187ABEA10F", hash_generated_field = "986552A977A36D17EF9793C412EAF42D")

static final int TRANSACTION_registerListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.529 -0500", hash_original_field = "EEE02864E1289670AB2F420E59F61C09", hash_generated_field = "EB3E83EEF16EC66F2EA820B301DC1CE2")

static final int TRANSACTION_unregisterListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.532 -0500", hash_original_field = "72FC041701580E80F0A64515419E3734", hash_generated_field = "1310BAD68FCB372E1C9947EE83C46D81")

static final int TRANSACTION_setNetworkPolicies = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.534 -0500", hash_original_field = "AEE76B690F346F4532B81680C59E4880", hash_generated_field = "484FD2178E51A5DDBFDA555FB1EDC7B9")

static final int TRANSACTION_getNetworkPolicies = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.537 -0500", hash_original_field = "37B8BF1B9F65379574961F3DD818095A", hash_generated_field = "22DA3807A088E3E3A35B0B6DA7179021")

static final int TRANSACTION_snoozePolicy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.539 -0500", hash_original_field = "6FBC631FFCD52C76FADE62B0D0436868", hash_generated_field = "16E2A23E6C77B4DBD987E09F0974ED58")

static final int TRANSACTION_setRestrictBackground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.541 -0500", hash_original_field = "E873DD0EA48ED8CD873950FCE123496F", hash_generated_field = "DBEC7519268F30B58111A946604ECE49")

static final int TRANSACTION_getRestrictBackground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.544 -0500", hash_original_field = "AC11F679D814A31FE7F066528B28C25C", hash_generated_field = "B1B09AA1077C6C6D1EB4B430A72084C5")

static final int TRANSACTION_getNetworkQuotaInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.462 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.466 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.471 -0500", hash_original_method = "59D8BA3B5CCE64C041ECC36AE80161BE", hash_generated_method = "73C33FF99E07A61A70368D62EC9EF8BE")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setUidPolicy:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.setUidPolicy(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getUidPolicy:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getUidPolicy(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isUidForeground:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.isUidForeground(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerListener:
{
data.enforceInterface(DESCRIPTOR);
android.net.INetworkPolicyListener _arg0;
_arg0 = android.net.INetworkPolicyListener.Stub.asInterface(data.readStrongBinder());
this.registerListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterListener:
{
data.enforceInterface(DESCRIPTOR);
android.net.INetworkPolicyListener _arg0;
_arg0 = android.net.INetworkPolicyListener.Stub.asInterface(data.readStrongBinder());
this.unregisterListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setNetworkPolicies:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkPolicy[] _arg0;
_arg0 = data.createTypedArray(android.net.NetworkPolicy.CREATOR);
this.setNetworkPolicies(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getNetworkPolicies:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkPolicy[] _result = this.getNetworkPolicies();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_snoozePolicy:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkTemplate _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.NetworkTemplate.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.snoozePolicy(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setRestrictBackground:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setRestrictBackground(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getRestrictBackground:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getRestrictBackground();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getNetworkQuotaInfo:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkState _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.NetworkState.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.net.NetworkQuotaInfo _result = this.getNetworkQuotaInfo(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void setUidPolicy(int uid, int policy) throws android.os.RemoteException;
public int getUidPolicy(int uid) throws android.os.RemoteException;
public boolean isUidForeground(int uid) throws android.os.RemoteException;
public void registerListener(android.net.INetworkPolicyListener listener) throws android.os.RemoteException;
public void unregisterListener(android.net.INetworkPolicyListener listener) throws android.os.RemoteException;

public void setNetworkPolicies(android.net.NetworkPolicy[] policies) throws android.os.RemoteException;
public android.net.NetworkPolicy[] getNetworkPolicies() throws android.os.RemoteException;

public void snoozePolicy(android.net.NetworkTemplate template) throws android.os.RemoteException;

public void setRestrictBackground(boolean restrictBackground) throws android.os.RemoteException;
public boolean getRestrictBackground() throws android.os.RemoteException;
public android.net.NetworkQuotaInfo getNetworkQuotaInfo(android.net.NetworkState state) throws android.os.RemoteException;
}
