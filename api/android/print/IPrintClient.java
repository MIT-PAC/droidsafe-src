/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/IPrintClient.aidl
 */
package android.print;
/**
 * Interface for communication with a printing app.
 *
 * @see android.print.IPrintClientCallback
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintClient extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IPrintClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.133 -0400", hash_original_field = "4C8A703AB2AD2073E6375013007011CD", hash_generated_field = "7FED8E4C4E75CBD4DE020F4AD898C196")

private static final java.lang.String DESCRIPTOR = "android.print.IPrintClient";
/**
 * Cast an IBinder object into an android.print.IPrintClient interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.135 -0400", hash_original_method = "D68C9D7E1D50574D9DE49BAB6A2281AF", hash_generated_method = "AF72F95AD9A612562DBDDAE7BB439E65")
        
public static android.print.IPrintClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IPrintClient))) {
return ((android.print.IPrintClient)iin);
}
return new android.print.IPrintClient.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.145 -0400", hash_original_field = "F8BEDC3610C1F8801DCCCD3CCA73F7BB", hash_generated_field = "28B74E4A97E517494DDD8FF00CACC2FD")

static final int TRANSACTION_startPrintJobConfigActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.134 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.136 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.print.IPrintClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.139 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.140 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.141 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.142 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.143 -0400", hash_original_method = "A5EF851FCF70C12D6F6DEE742189A7C4", hash_generated_method = "612A93D6B337041BCBD06169622529AA")
            
@Override public void startPrintJobConfigActivity(android.content.IntentSender intent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_startPrintJobConfigActivity, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.138 -0400", hash_original_method = "189485A136860CF1443A306B776A2A3C", hash_generated_method = "FF5C59AA3E09049FDCA370D23D9E330E")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_startPrintJobConfigActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.IntentSender _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.IntentSender.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.startPrintJobConfigActivity(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void startPrintJobConfigActivity(android.content.IntentSender intent) throws android.os.RemoteException;
}
