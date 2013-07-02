package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface IIccPhoneBook extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.IIccPhoneBook
{
private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.IIccPhoneBook";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static com.android.internal.telephony.IIccPhoneBook asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.IIccPhoneBook))) {
return ((com.android.internal.telephony.IIccPhoneBook)iin);
}
return new com.android.internal.telephony.IIccPhoneBook.Stub.Proxy(obj);
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
case TRANSACTION_getAdnRecordsInEf:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<com.android.internal.telephony.AdnRecord> _result = this.getAdnRecordsInEf(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_updateAdnRecordsInEfBySearch:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
java.lang.String _arg5;
_arg5 = data.readString();
boolean _result = this.updateAdnRecordsInEfBySearch(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_updateAdnRecordsInEfByIndex:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
int _arg3;
_arg3 = data.readInt();
java.lang.String _arg4;
_arg4 = data.readString();
boolean _result = this.updateAdnRecordsInEfByIndex(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAdnRecordsSize:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int[] _result = this.getAdnRecordsSize(_arg0);
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.android.internal.telephony.IIccPhoneBook
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

public java.util.List<com.android.internal.telephony.AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.android.internal.telephony.AdnRecord> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(efid);
mRemote.transact(Stub.TRANSACTION_getAdnRecordsInEf, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.android.internal.telephony.AdnRecord.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public boolean updateAdnRecordsInEfBySearch(int efid, java.lang.String oldTag, java.lang.String oldPhoneNumber, java.lang.String newTag, java.lang.String newPhoneNumber, java.lang.String pin2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(efid);
_data.writeString(oldTag);
_data.writeString(oldPhoneNumber);
_data.writeString(newTag);
_data.writeString(newPhoneNumber);
_data.writeString(pin2);
mRemote.transact(Stub.TRANSACTION_updateAdnRecordsInEfBySearch, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public boolean updateAdnRecordsInEfByIndex(int efid, java.lang.String newTag, java.lang.String newPhoneNumber, int index, java.lang.String pin2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(efid);
_data.writeString(newTag);
_data.writeString(newPhoneNumber);
_data.writeInt(index);
_data.writeString(pin2);
mRemote.transact(Stub.TRANSACTION_updateAdnRecordsInEfByIndex, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(efid);
mRemote.transact(Stub.TRANSACTION_getAdnRecordsSize, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getAdnRecordsInEf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_updateAdnRecordsInEfBySearch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_updateAdnRecordsInEfByIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getAdnRecordsSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}

public java.util.List<com.android.internal.telephony.AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException;

public boolean updateAdnRecordsInEfBySearch(int efid, java.lang.String oldTag, java.lang.String oldPhoneNumber, java.lang.String newTag, java.lang.String newPhoneNumber, java.lang.String pin2) throws android.os.RemoteException;

public boolean updateAdnRecordsInEfByIndex(int efid, java.lang.String newTag, java.lang.String newPhoneNumber, int index, java.lang.String pin2) throws android.os.RemoteException;

public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException;
}
