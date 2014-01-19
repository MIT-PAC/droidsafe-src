package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IClipboard extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.IClipboard
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.163 -0500", hash_original_field = "15702774EC483F4D538772D3E6EB5E08", hash_generated_field = "E35ED7D99943595C5AA1990FE903A6BB")

private static final java.lang.String DESCRIPTOR = "android.content.IClipboard";
/**
 * Cast an IBinder object into an android.content.IClipboard interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.168 -0500", hash_original_method = "907143141BE238C90507063893E4C60A", hash_generated_method = "0D0350EB44E3C688F419B4140269BC33")
        
public static android.content.IClipboard asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.IClipboard))) {
return ((android.content.IClipboard)iin);
}
return new android.content.IClipboard.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.209 -0500", hash_original_field = "E4F8681A2127CD44F69782542D939C7C", hash_generated_field = "5A808D62003B79F4357BC9A014320496")

static final int TRANSACTION_setPrimaryClip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.211 -0500", hash_original_field = "CA922F520318AE48BEDFB1334F338366", hash_generated_field = "792D3B4A44A3CD1F766E35F88F2DBA08")

static final int TRANSACTION_getPrimaryClip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.214 -0500", hash_original_field = "86164AC30EA80F46A02A548C7169728E", hash_generated_field = "AC019245759CAE0D1AC5437284A2C41E")

static final int TRANSACTION_getPrimaryClipDescription = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.content.IClipboard
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.178 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.180 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.183 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.185 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.187 -0500", hash_original_method = "89164314925687D2BAC37DD0B7018B00", hash_generated_method = "806DB3D73C40C144DBC2E3A528753C5D")
            
public void setPrimaryClip(android.content.ClipData clip) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((clip!=null)) {
_data.writeInt(1);
clip.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setPrimaryClip, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.190 -0500", hash_original_method = "8BDAEF067310D45BC155356367B8597A", hash_generated_method = "2FBB695B15D036008E32263B3D409D3A")
            
public android.content.ClipData getPrimaryClip(java.lang.String pkg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ClipData _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
mRemote.transact(Stub.TRANSACTION_getPrimaryClip, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ClipData.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.193 -0500", hash_original_method = "C4723F0119539FE54FF62A744DFC45AA", hash_generated_method = "AB6C842835F30EDF49B06108216C1BF1")
            
public android.content.ClipDescription getPrimaryClipDescription() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ClipDescription _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrimaryClipDescription, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ClipDescription.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.195 -0500", hash_original_method = "F10D86ED57D9AAEC94DB699A78B58F7C", hash_generated_method = "7536A994D4399FECABE1655031EE8F8D")
            
public boolean hasPrimaryClip() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hasPrimaryClip, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.197 -0500", hash_original_method = "9138B26F27B1F8B83EFEF10FAB38C356", hash_generated_method = "F3F2B858FD08EC97F3A2B0CDAD5DE993")
            
public void addPrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addPrimaryClipChangedListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.201 -0500", hash_original_method = "174226EB91B34C5C162050C23F224EF1", hash_generated_method = "8088055AB580F205E75D6FE0CE77C4A4")
            
public void removePrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removePrimaryClipChangedListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Returns true if the clipboard contains text; false otherwise.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.203 -0500", hash_original_method = "75D0355B73BE9008A846074F463A5508", hash_generated_method = "EE200B89C8E3823D17D6C47A7A074C3F")
            
public boolean hasClipboardText() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hasClipboardText, _data, _reply, 0);
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.217 -0500", hash_original_field = "7FD3C244DA41A65027283BA1D7163129", hash_generated_field = "203A914D65E3AC68FB068013F62EF8FF")

static final int TRANSACTION_hasPrimaryClip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.219 -0500", hash_original_field = "83979274A082A1ACDB0732641DD30049", hash_generated_field = "5340DE56AB9E595D528F8F2C8B0BFB5E")

static final int TRANSACTION_addPrimaryClipChangedListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.221 -0500", hash_original_field = "2E9E02884C054C0B5EA7BC1B3416D0DE", hash_generated_field = "398687637BB9560DA2BFFD3914E33279")

static final int TRANSACTION_removePrimaryClipChangedListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.223 -0500", hash_original_field = "13F68D1EBBF0ACB5572711C2F9897CA3", hash_generated_field = "ACA3A55E8A922FEBEA2678C45196AA9C")

static final int TRANSACTION_hasClipboardText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.165 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.170 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.174 -0500", hash_original_method = "F0C3D1B61F44F2CE9FE63DCA4F1A013E", hash_generated_method = "7C5FDCDBADFF6AD481C644554AFD6788")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setPrimaryClip:
{
data.enforceInterface(DESCRIPTOR);
android.content.ClipData _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ClipData.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setPrimaryClip(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPrimaryClip:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.ClipData _result = this.getPrimaryClip(_arg0);
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
case TRANSACTION_getPrimaryClipDescription:
{
data.enforceInterface(DESCRIPTOR);
android.content.ClipDescription _result = this.getPrimaryClipDescription();
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
case TRANSACTION_hasPrimaryClip:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasPrimaryClip();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_addPrimaryClipChangedListener:
{
data.enforceInterface(DESCRIPTOR);
android.content.IOnPrimaryClipChangedListener _arg0;
_arg0 = android.content.IOnPrimaryClipChangedListener.Stub.asInterface(data.readStrongBinder());
this.addPrimaryClipChangedListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removePrimaryClipChangedListener:
{
data.enforceInterface(DESCRIPTOR);
android.content.IOnPrimaryClipChangedListener _arg0;
_arg0 = android.content.IOnPrimaryClipChangedListener.Stub.asInterface(data.readStrongBinder());
this.removePrimaryClipChangedListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_hasClipboardText:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasClipboardText();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void setPrimaryClip(android.content.ClipData clip) throws android.os.RemoteException;
public android.content.ClipData getPrimaryClip(java.lang.String pkg) throws android.os.RemoteException;
public android.content.ClipDescription getPrimaryClipDescription() throws android.os.RemoteException;
public boolean hasPrimaryClip() throws android.os.RemoteException;
public void addPrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener) throws android.os.RemoteException;
public void removePrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener) throws android.os.RemoteException;

public boolean hasClipboardText() throws android.os.RemoteException;
}
