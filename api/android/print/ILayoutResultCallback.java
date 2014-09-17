/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/ILayoutResultCallback.aidl
 */
package android.print;
/**
 * Callback for observing the result of android.print.PrintAdapter#onLayout.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface ILayoutResultCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.ILayoutResultCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.573 -0400", hash_original_field = "12EFDB5091452B38A13ABAAE0B09834D", hash_generated_field = "32CB1F407054962C3D7A45539FF180B7")

private static final java.lang.String DESCRIPTOR = "android.print.ILayoutResultCallback";
/**
 * Cast an IBinder object into an android.print.ILayoutResultCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.575 -0400", hash_original_method = "EB6C73FB88F031D57E912E2B6A4A9344", hash_generated_method = "44A8D97DB095CD6311877A93CBC30460")
        
public static android.print.ILayoutResultCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.ILayoutResultCallback))) {
return ((android.print.ILayoutResultCallback)iin);
}
return new android.print.ILayoutResultCallback.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.586 -0400", hash_original_field = "A36A7DAED9DF6DBD4273000129FB9E9D", hash_generated_field = "2E3F624FDA84AC28545035A705BD9245")

static final int TRANSACTION_onLayoutFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.587 -0400", hash_original_field = "238518FD6DCD0ABE232741C6746E2FC1", hash_generated_field = "9E08477CE9166F93637887D87A44A854")

static final int TRANSACTION_onLayoutFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.574 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.print.ILayoutResultCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.578 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.579 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.581 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.582 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.583 -0400", hash_original_method = "546B73B1D7BDEDFE7AF2718FBEB53A19", hash_generated_method = "2A3B75FA83C7FA916DC59053AD2B274D")
            
@Override public void onLayoutFinished(android.print.PrintDocumentInfo info, boolean changed, int sequence) throws android.os.RemoteException
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
_data.writeInt(((changed)?(1):(0)));
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onLayoutFinished, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.584 -0400", hash_original_method = "B63AB10AD5BA9DA40752CFF22FD977CC", hash_generated_method = "A676E66DCD9EB443F8F2060EE6624356")
            
@Override public void onLayoutFailed(java.lang.CharSequence error, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((error!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(error, _data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onLayoutFailed, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.576 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.577 -0400", hash_original_method = "3AEC0AD9D359955238DA08C01B15A254", hash_generated_method = "4989CF64281B1B7F3ABBF07F7D57C8B9")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onLayoutFinished:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintDocumentInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintDocumentInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
this.onLayoutFinished(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_onLayoutFailed:
{
data.enforceInterface(DESCRIPTOR);
java.lang.CharSequence _arg0;
if ((0!=data.readInt())) {
_arg0 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.onLayoutFailed(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onLayoutFinished(android.print.PrintDocumentInfo info, boolean changed, int sequence) throws android.os.RemoteException;
public void onLayoutFailed(java.lang.CharSequence error, int sequence) throws android.os.RemoteException;
}
