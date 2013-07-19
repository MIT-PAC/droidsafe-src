package com.android.internal.telephony;

// Droidsafe Imports

public interface IPhoneSubInfo extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.IPhoneSubInfo
{
private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.IPhoneSubInfo";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static com.android.internal.telephony.IPhoneSubInfo asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.IPhoneSubInfo))) {
return ((com.android.internal.telephony.IPhoneSubInfo)iin);
}
return new com.android.internal.telephony.IPhoneSubInfo.Stub.Proxy(obj);
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
case TRANSACTION_getDeviceId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDeviceId();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getDeviceSvn:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDeviceSvn();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getSubscriberId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getSubscriberId();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getIccSerialNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getIccSerialNumber();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getLine1Number:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getLine1Number();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getLine1AlphaTag:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getLine1AlphaTag();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getMsisdn:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getMsisdn();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getVoiceMailNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getVoiceMailNumber();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getCompleteVoiceMailNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCompleteVoiceMailNumber();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getVoiceMailAlphaTag:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getVoiceMailAlphaTag();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getIsimImpi:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getIsimImpi();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getIsimDomain:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getIsimDomain();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getIsimImpu:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getIsimImpu();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.android.internal.telephony.IPhoneSubInfo
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

public java.lang.String getDeviceId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDeviceId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getDeviceSvn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDeviceSvn, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getSubscriberId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSubscriberId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getIccSerialNumber() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIccSerialNumber, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getLine1Number() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLine1Number, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getLine1AlphaTag() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLine1AlphaTag, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getMsisdn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMsisdn, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getVoiceMailNumber() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVoiceMailNumber, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getCompleteVoiceMailNumber() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCompleteVoiceMailNumber, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getVoiceMailAlphaTag() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVoiceMailAlphaTag, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getIsimImpi() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIsimImpi, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String getIsimDomain() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIsimDomain, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public java.lang.String[] getIsimImpu() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIsimImpu, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getDeviceId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getDeviceSvn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getSubscriberId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getIccSerialNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getLine1Number = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getLine1AlphaTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getMsisdn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_getVoiceMailNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getCompleteVoiceMailNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getVoiceMailAlphaTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_getIsimImpi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_getIsimDomain = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_getIsimImpu = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
}

public java.lang.String getDeviceId() throws android.os.RemoteException;

public java.lang.String getDeviceSvn() throws android.os.RemoteException;

public java.lang.String getSubscriberId() throws android.os.RemoteException;

public java.lang.String getIccSerialNumber() throws android.os.RemoteException;

public java.lang.String getLine1Number() throws android.os.RemoteException;

public java.lang.String getLine1AlphaTag() throws android.os.RemoteException;

public java.lang.String getMsisdn() throws android.os.RemoteException;

public java.lang.String getVoiceMailNumber() throws android.os.RemoteException;

public java.lang.String getCompleteVoiceMailNumber() throws android.os.RemoteException;

public java.lang.String getVoiceMailAlphaTag() throws android.os.RemoteException;

public java.lang.String getIsimImpi() throws android.os.RemoteException;

public java.lang.String getIsimDomain() throws android.os.RemoteException;

public java.lang.String[] getIsimImpu() throws android.os.RemoteException;
}
