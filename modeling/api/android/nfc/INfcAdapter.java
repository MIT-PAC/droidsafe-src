package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface INfcAdapter extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.nfc.INfcAdapter
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.021 -0500", hash_original_field = "A2C314F2C5686CD26B20832F848F4B93", hash_generated_field = "DC7D5C73FCA31CFAB0408BADE46AAB07")

private static final java.lang.String DESCRIPTOR = "android.nfc.INfcAdapter";
/**
 * Cast an IBinder object into an android.nfc.INfcAdapter interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.026 -0500", hash_original_method = "97148B61919CE8A0D07BD6B5DE2CD3B4", hash_generated_method = "89131D0BD62B686DDAE32BDF5DF9891C")
        
public static android.nfc.INfcAdapter asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.nfc.INfcAdapter))) {
return ((android.nfc.INfcAdapter)iin);
}
return new android.nfc.INfcAdapter.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.076 -0500", hash_original_field = "A3207C90A1AA99822DF2AE60F4DBB6F0", hash_generated_field = "E3574925B5249DF6C625E01AF6CFAA60")

static final int TRANSACTION_getNfcTagInterface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.078 -0500", hash_original_field = "7A9903F88331DD4CF13C4B830F3588D5", hash_generated_field = "6071FB4EC4438E9A2CC39A7E43791864")

static final int TRANSACTION_getNfcAdapterExtrasInterface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.081 -0500", hash_original_field = "C308B735FB1CB721C8CD0B93F9A8DDC0", hash_generated_field = "C6245FAFDB8800BB29E90D765128ADEF")

static final int TRANSACTION_getState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.nfc.INfcAdapter
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.035 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.039 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.041 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.043 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.046 -0500", hash_original_method = "C383684F87B1D9B063C4D9022F69F6DA", hash_generated_method = "34102C60B9905F0D548B4DE6442DF83F")
            
public android.nfc.INfcTag getNfcTagInterface() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.nfc.INfcTag _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNfcTagInterface, _data, _reply, 0);
_reply.readException();
_result = android.nfc.INfcTag.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.049 -0500", hash_original_method = "419333D359381B04978A7F0245F6D40D", hash_generated_method = "FD1AC2A14ABE87E4B48264117197B8D2")
            
public android.nfc.INfcAdapterExtras getNfcAdapterExtrasInterface(java.lang.String pkg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.nfc.INfcAdapterExtras _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
mRemote.transact(Stub.TRANSACTION_getNfcAdapterExtrasInterface, _data, _reply, 0);
_reply.readException();
_result = android.nfc.INfcAdapterExtras.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.051 -0500", hash_original_method = "34C8BE8866555A4E37FB3BE07D3804F6", hash_generated_method = "52D8D043CF1FF87ECD04698A0AB87331")
            
public int getState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.054 -0500", hash_original_method = "FAE070426B4C804DFFABD68A1550AAD4", hash_generated_method = "3522C6F132A03798DB924E07CCAE612D")
            
public boolean disable() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.057 -0500", hash_original_method = "E176D54325F4FAFD3800D4282E32E90B", hash_generated_method = "4F1C5D253A6C2E9510E283D9D9BF4B47")
            
public boolean enable() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_enable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.059 -0500", hash_original_method = "AE5F4A164BE7C3292455673E61423581", hash_generated_method = "4888C0A7B70D32C62CB681F55BF21396")
            
public boolean enableNdefPush() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_enableNdefPush, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.062 -0500", hash_original_method = "C56F09C405B4B0ED098B986E53B98EB3", hash_generated_method = "6F536AAABAB6CFE95F140E6C9A8A9043")
            
public boolean disableNdefPush() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disableNdefPush, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.065 -0500", hash_original_method = "154E38CCEBFD1C0E6312D86398CE50E0", hash_generated_method = "293F0D69D109A134F70103C43B42E052")
            
public boolean isNdefPushEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isNdefPushEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.068 -0500", hash_original_method = "963B00C49BF76B5FB197C27DBFB2DA14", hash_generated_method = "CE561BFD205180CC9F8943265321B728")
            
public void setForegroundDispatch(android.app.PendingIntent intent, android.content.IntentFilter[] filters, android.nfc.TechListParcel techLists) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeTypedArray(filters, 0);
if ((techLists!=null)) {
_data.writeInt(1);
techLists.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setForegroundDispatch, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.071 -0500", hash_original_method = "199FCBAD6FD2430E7316164B63486FEC", hash_generated_method = "279FB6EEE2D95241DD4DBC90418347B0")
            
public void setForegroundNdefPush(android.nfc.NdefMessage msg, android.nfc.INdefPushCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((msg!=null)) {
_data.writeInt(1);
msg.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setForegroundNdefPush, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.084 -0500", hash_original_field = "CBCA1481D03CA3EBB893B02AE60F5E82", hash_generated_field = "35A7EDCD5BB678BA75C8F971335C7242")

static final int TRANSACTION_disable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.087 -0500", hash_original_field = "D6097885D1A8B46C23EB19208B4E7157", hash_generated_field = "95C03F8D2735B386C9252329F9BCA111")

static final int TRANSACTION_enable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.089 -0500", hash_original_field = "E96F4C7F1FEE8155CDFA90C39D1885DD", hash_generated_field = "C7F199040B0AF5736E5046C156AA26A7")

static final int TRANSACTION_enableNdefPush = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.092 -0500", hash_original_field = "23D5748B46C0E05CC120ACA50455ECB3", hash_generated_field = "E3B59C2E6A7517ECF6C40F781AA014C8")

static final int TRANSACTION_disableNdefPush = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.094 -0500", hash_original_field = "C4CB13D591DF17DBF171A7E1BB5CF9AE", hash_generated_field = "7D83349E0D5E0CA51C2D1B1A554C63CB")

static final int TRANSACTION_isNdefPushEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.096 -0500", hash_original_field = "F07F846842E31EC9FFB556D5D684019A", hash_generated_field = "62F9FA05DC31FBC6CEB07266DB0E03D3")

static final int TRANSACTION_setForegroundDispatch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.099 -0500", hash_original_field = "18E333CCAAA1E5154DF516DC32DDED95", hash_generated_field = "1B9BF83243B487EE45552840AB8C86AA")

static final int TRANSACTION_setForegroundNdefPush = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.023 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NFC})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.028 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.032 -0500", hash_original_method = "1FD1100E12B9908106A1C9A4D9992784", hash_generated_method = "E4ECFD2DB0324DFD26ADF75E986DE45D")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getNfcTagInterface:
{
data.enforceInterface(DESCRIPTOR);
android.nfc.INfcTag _result = this.getNfcTagInterface();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getNfcAdapterExtrasInterface:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.nfc.INfcAdapterExtras _result = this.getNfcAdapterExtrasInterface(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_disable:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.disable();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enable:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.enable();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enableNdefPush:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.enableNdefPush();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disableNdefPush:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.disableNdefPush();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isNdefPushEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isNdefPushEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setForegroundDispatch:
{
data.enforceInterface(DESCRIPTOR);
android.app.PendingIntent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.IntentFilter[] _arg1;
_arg1 = data.createTypedArray(android.content.IntentFilter.CREATOR);
android.nfc.TechListParcel _arg2;
if ((0!=data.readInt())) {
_arg2 = android.nfc.TechListParcel.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.setForegroundDispatch(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setForegroundNdefPush:
{
data.enforceInterface(DESCRIPTOR);
android.nfc.NdefMessage _arg0;
if ((0!=data.readInt())) {
_arg0 = android.nfc.NdefMessage.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.nfc.INdefPushCallback _arg1;
_arg1 = android.nfc.INdefPushCallback.Stub.asInterface(data.readStrongBinder());
this.setForegroundNdefPush(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public android.nfc.INfcTag getNfcTagInterface() throws android.os.RemoteException;
public android.nfc.INfcAdapterExtras getNfcAdapterExtrasInterface(java.lang.String pkg) throws android.os.RemoteException;
public int getState() throws android.os.RemoteException;
public boolean disable() throws android.os.RemoteException;
public boolean enable() throws android.os.RemoteException;
public boolean enableNdefPush() throws android.os.RemoteException;
public boolean disableNdefPush() throws android.os.RemoteException;
public boolean isNdefPushEnabled() throws android.os.RemoteException;
public void setForegroundDispatch(android.app.PendingIntent intent, android.content.IntentFilter[] filters, android.nfc.TechListParcel techLists) throws android.os.RemoteException;
public void setForegroundNdefPush(android.nfc.NdefMessage msg, android.nfc.INdefPushCallback callback) throws android.os.RemoteException;
}
