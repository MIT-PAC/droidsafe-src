package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IInputMethodClient extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.view.IInputMethodClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.799 -0500", hash_original_field = "03E5C08850772EC50EF931A2CB67627A", hash_generated_field = "E524380DDB39CE47CB95D8A57E053EBF")

private static final java.lang.String DESCRIPTOR = "com.android.internal.view.IInputMethodClient";
/**
 * Cast an IBinder object into an com.android.internal.view.IInputMethodClient interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.801 -0500", hash_original_method = "4797AC723C9E618A0B2A9A55FCC7BFA8", hash_generated_method = "B9F0009A22C4F5774CFA54B3593FB3D9")
        public static com.android.internal.view.IInputMethodClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.view.IInputMethodClient))) {
return ((com.android.internal.view.IInputMethodClient)iin);
}
return new com.android.internal.view.IInputMethodClient.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.814 -0500", hash_original_field = "6998ECA4C57D843A6B97B7041786B389", hash_generated_field = "EDE2AA1CC3616AE457A6377988C549F6")

static final int TRANSACTION_setUsingInputMethod = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.815 -0500", hash_original_field = "D2E553530EACA51AA014D9642B90C0DA", hash_generated_field = "D4836ADC2F536E98845760B69C10FC05")

static final int TRANSACTION_onBindMethod = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.815 -0500", hash_original_field = "6029940ABDA0651C50EE7C043AE621F4", hash_generated_field = "4EFC2236F140125AAA447132FB2FF0CC")

static final int TRANSACTION_onUnbindMethod = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.view.IInputMethodClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.805 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.806 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.807 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.807 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.808 -0500", hash_original_method = "FDC01911E345BF2C4A84D7D4D171141B", hash_generated_method = "2356F3A1A4ACABD37D9922534BFB5090")
            public void setUsingInputMethod(boolean state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((state)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setUsingInputMethod, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.809 -0500", hash_original_method = "7C7757CF7C11E00629E2450983AF21B8", hash_generated_method = "4F5FA305328AFFCB2D9C385A0DEB68F0")
            public void onBindMethod(com.android.internal.view.InputBindResult res) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((res!=null)) {
_data.writeInt(1);
res.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onBindMethod, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.811 -0500", hash_original_method = "943D891106AEA821FF184BD1333B3BB3", hash_generated_method = "BFD2D23944CB0716255841F39D2F3596")
            public void onUnbindMethod(int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onUnbindMethod, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.812 -0500", hash_original_method = "13A6806C791EA848D556E543C155A89C", hash_generated_method = "2A1F327D6F9976A6C197C2CC90AE7596")
            public void setActive(boolean active) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((active)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setActive, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.816 -0500", hash_original_field = "ED6913F5BDAEC76A7DFB7097C1739F15", hash_generated_field = "841FEFB669B125A6E025B00CF5C21DA0")

static final int TRANSACTION_setActive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.800 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.802 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:37.804 -0500", hash_original_method = "508A0DC5C758195533AB598184935B9F", hash_generated_method = "CBAF8AA578D45C18C7B29A51470EF241")
        @Override
public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setUsingInputMethod:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setUsingInputMethod(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onBindMethod:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.InputBindResult _arg0;
if ((0!=data.readInt())) {
_arg0 = com.android.internal.view.InputBindResult.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onBindMethod(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onUnbindMethod:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onUnbindMethod(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setActive:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setActive(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void setUsingInputMethod(boolean state) throws android.os.RemoteException;
public void onBindMethod(com.android.internal.view.InputBindResult res) throws android.os.RemoteException;
public void onUnbindMethod(int sequence) throws android.os.RemoteException;
public void setActive(boolean active) throws android.os.RemoteException;
}
