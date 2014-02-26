/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/accounts/IAccountAuthenticatorResponse.aidl
 */
package android.accounts;
/**
 * The interface used to return responses from an {@link IAccountAuthenticator}
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IAccountAuthenticatorResponse extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.accounts.IAccountAuthenticatorResponse
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.343 -0500", hash_original_field = "9D115E7F1A3124FB8757A80325C8C91E", hash_generated_field = "8222BE0DB45279E6753FD8EA34947EC0")

private static final java.lang.String DESCRIPTOR = "android.accounts.IAccountAuthenticatorResponse";
/**
 * Cast an IBinder object into an android.accounts.IAccountAuthenticatorResponse interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.357 -0500", hash_original_method = "6C93CEB0A2D309A6AA1A74065609FEB9", hash_generated_method = "07782F018E2B47A943E4D79836D6BF10")
        
public static android.accounts.IAccountAuthenticatorResponse asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.accounts.IAccountAuthenticatorResponse))) {
return ((android.accounts.IAccountAuthenticatorResponse)iin);
}
return new android.accounts.IAccountAuthenticatorResponse.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.431 -0500", hash_original_field = "8920A5B93185A18C209E85D608437CFD", hash_generated_field = "79F6C99FA82A356E25068F7EA9DDC170")

static final int TRANSACTION_onResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.438 -0500", hash_original_field = "EC42969981B7D7B7612C9D3E7D4B3423", hash_generated_field = "A78C01F9798F237294FC1B9E0136F0D2")

static final int TRANSACTION_onRequestContinued = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.444 -0500", hash_original_field = "010C318F34F5BE3B75D0B61B80CE3FBB", hash_generated_field = "13FA9246B1CF9AAB74DF5FED4BFE0290")

static final int TRANSACTION_onError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.accounts.IAccountAuthenticatorResponse
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.379 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.385 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.391 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.397 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.404 -0500", hash_original_method = "FFD3991DFE2F41DDED9E5470E4D31B97", hash_generated_method = "5EB8181A9CD7A05C4B6295F2F14052D6")
            
public void onResult(android.os.Bundle value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((value!=null)) {
_data.writeInt(1);
value.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onResult, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.410 -0500", hash_original_method = "92AF3701D801BE79781F7213E382E199", hash_generated_method = "E85D0D35760DB8FC608FC916632760DD")
            
public void onRequestContinued() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onRequestContinued, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.417 -0500", hash_original_method = "CAA0AED8626F51640A0BB092514C1C12", hash_generated_method = "588A826851E5E73D37BF02487D43A026")
            
public void onError(int errorCode, java.lang.String errorMessage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(errorCode);
_data.writeString(errorMessage);
mRemote.transact(Stub.TRANSACTION_onError, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.350 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.362 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:34.370 -0500", hash_original_method = "7757AE8398886443381BAD8ADC7283A9", hash_generated_method = "662FA2C21C9EC77491257B3BF058B5C1")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onResult:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onResult(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onRequestContinued:
{
data.enforceInterface(DESCRIPTOR);
this.onRequestContinued();
reply.writeNoException();
return true;
}
case TRANSACTION_onError:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.onError(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onResult(android.os.Bundle value) throws android.os.RemoteException;
public void onRequestContinued() throws android.os.RemoteException;
public void onError(int errorCode, java.lang.String errorMessage) throws android.os.RemoteException;
}
