package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface ISms extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.ISms
{
private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.ISms";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static com.android.internal.telephony.ISms asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.ISms))) {
return ((com.android.internal.telephony.ISms)iin);
}
return new com.android.internal.telephony.ISms.Stub.Proxy(obj);
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
case TRANSACTION_getAllMessagesFromIccEf:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.android.internal.telephony.SmsRawData> _result = this.getAllMessagesFromIccEf();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_updateMessageOnIccEf:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
byte[] _arg2;
_arg2 = data.createByteArray();
boolean _result = this.updateMessageOnIccEf(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_copyMessageToIccEf:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _arg1;
_arg1 = data.createByteArray();
byte[] _arg2;
_arg2 = data.createByteArray();
boolean _result = this.copyMessageToIccEf(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_sendData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
byte[] _arg3;
_arg3 = data.createByteArray();
android.app.PendingIntent _arg4;
if ((0!=data.readInt())) {
_arg4 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
android.app.PendingIntent _arg5;
if ((0!=data.readInt())) {
_arg5 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
this.sendData(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_sendText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
android.app.PendingIntent _arg3;
if ((0!=data.readInt())) {
_arg3 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
android.app.PendingIntent _arg4;
if ((0!=data.readInt())) {
_arg4 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
this.sendText(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_sendMultipartText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
java.util.List<android.app.PendingIntent> _arg3;
_arg3 = data.createTypedArrayList(android.app.PendingIntent.CREATOR);
java.util.List<android.app.PendingIntent> _arg4;
_arg4 = data.createTypedArrayList(android.app.PendingIntent.CREATOR);
this.sendMultipartText(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_enableCellBroadcast:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.enableCellBroadcast(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disableCellBroadcast:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.disableCellBroadcast(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enableCellBroadcastRange:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.enableCellBroadcastRange(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disableCellBroadcastRange:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.disableCellBroadcastRange(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.android.internal.telephony.ISms
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

public java.util.List<com.android.internal.telephony.SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.android.internal.telephony.SmsRawData> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllMessagesFromIccEf, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.android.internal.telephony.SmsRawData.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public boolean updateMessageOnIccEf(int messageIndex, int newStatus, byte[] pdu) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(messageIndex);
_data.writeInt(newStatus);
_data.writeByteArray(pdu);
mRemote.transact(Stub.TRANSACTION_updateMessageOnIccEf, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
_data.writeByteArray(pdu);
_data.writeByteArray(smsc);
mRemote.transact(Stub.TRANSACTION_copyMessageToIccEf, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public void sendData(java.lang.String destAddr, java.lang.String scAddr, int destPort, byte[] data, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(destAddr);
_data.writeString(scAddr);
_data.writeInt(destPort);
_data.writeByteArray(data);
if ((sentIntent!=null)) {
_data.writeInt(1);
sentIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((deliveryIntent!=null)) {
_data.writeInt(1);
deliveryIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}

public void sendText(java.lang.String destAddr, java.lang.String scAddr, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(destAddr);
_data.writeString(scAddr);
_data.writeString(text);
if ((sentIntent!=null)) {
_data.writeInt(1);
sentIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((deliveryIntent!=null)) {
_data.writeInt(1);
deliveryIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}

public void sendMultipartText(java.lang.String destinationAddress, java.lang.String scAddress, java.util.List<java.lang.String> parts, java.util.List<android.app.PendingIntent> sentIntents, java.util.List<android.app.PendingIntent> deliveryIntents) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(destinationAddress);
_data.writeString(scAddress);
_data.writeStringList(parts);
_data.writeTypedList(sentIntents);
_data.writeTypedList(deliveryIntents);
mRemote.transact(Stub.TRANSACTION_sendMultipartText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}

public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(messageIdentifier);
mRemote.transact(Stub.TRANSACTION_enableCellBroadcast, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(messageIdentifier);
mRemote.transact(Stub.TRANSACTION_disableCellBroadcast, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(startMessageId);
_data.writeInt(endMessageId);
mRemote.transact(Stub.TRANSACTION_enableCellBroadcastRange, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(startMessageId);
_data.writeInt(endMessageId);
mRemote.transact(Stub.TRANSACTION_disableCellBroadcastRange, _data, _reply, 0);
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
static final int TRANSACTION_getAllMessagesFromIccEf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_updateMessageOnIccEf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_copyMessageToIccEf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_sendData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_sendText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_sendMultipartText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_enableCellBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_disableCellBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_enableCellBroadcastRange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_disableCellBroadcastRange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
}

public java.util.List<com.android.internal.telephony.SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException;

public boolean updateMessageOnIccEf(int messageIndex, int newStatus, byte[] pdu) throws android.os.RemoteException;

public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) throws android.os.RemoteException;

public void sendData(java.lang.String destAddr, java.lang.String scAddr, int destPort, byte[] data, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) throws android.os.RemoteException;

public void sendText(java.lang.String destAddr, java.lang.String scAddr, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) throws android.os.RemoteException;

public void sendMultipartText(java.lang.String destinationAddress, java.lang.String scAddress, java.util.List<java.lang.String> parts, java.util.List<android.app.PendingIntent> sentIntents, java.util.List<android.app.PendingIntent> deliveryIntents) throws android.os.RemoteException;

public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException;

public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException;

public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException;

public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException;
}

