package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IInputContextCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.view.IInputContextCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.337 -0500", hash_original_field = "084468E1A9A45658679830378B814F57", hash_generated_field = "5F26FBF73201A2BD0DE6A834B5DAC429")

private static final java.lang.String DESCRIPTOR = "com.android.internal.view.IInputContextCallback";
/**
 * Cast an IBinder object into an com.android.internal.view.IInputContextCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.342 -0500", hash_original_method = "45425F78E1DF1901213D7EB293E1B87C", hash_generated_method = "D6D600697B70148F0FC7DD8F29433963")
        
public static com.android.internal.view.IInputContextCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.view.IInputContextCallback))) {
return ((com.android.internal.view.IInputContextCallback)iin);
}
return new com.android.internal.view.IInputContextCallback.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.381 -0500", hash_original_field = "A813A01D7D995604D6DAA3159627D253", hash_generated_field = "CF47DCCD4158B00C03E4BD29B1221925")

static final int TRANSACTION_setTextBeforeCursor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.383 -0500", hash_original_field = "2AADECE9CD6E6D2754E63EB9729D9919", hash_generated_field = "C412251A70F2548E2FA34248620B69B7")

static final int TRANSACTION_setTextAfterCursor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.385 -0500", hash_original_field = "177DC1BE96B508020B2C2E8A16412018", hash_generated_field = "BF0039B9016464CF09EBD74AD5361BFB")

static final int TRANSACTION_setCursorCapsMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.view.IInputContextCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.353 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.356 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.358 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.361 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.364 -0500", hash_original_method = "61E4C223B61A29BF238CCAEED9FB666D", hash_generated_method = "68C47669EBBB8A86344DC244C7B87A56")
            
public void setTextBeforeCursor(java.lang.CharSequence textBeforeCursor, int seq) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((textBeforeCursor!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(textBeforeCursor, _data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(seq);
mRemote.transact(Stub.TRANSACTION_setTextBeforeCursor, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.367 -0500", hash_original_method = "E90DAED888676008DD76042EEBD09DBD", hash_generated_method = "F42CE31ADEFF1FCC60A319BD0BA16688")
            
public void setTextAfterCursor(java.lang.CharSequence textAfterCursor, int seq) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((textAfterCursor!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(textAfterCursor, _data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(seq);
mRemote.transact(Stub.TRANSACTION_setTextAfterCursor, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.370 -0500", hash_original_method = "BCF4FD735627170346CED3C8D10DBFEA", hash_generated_method = "7BE7512EEB655FC523E5E553F84263CD")
            
public void setCursorCapsMode(int capsMode, int seq) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(capsMode);
_data.writeInt(seq);
mRemote.transact(Stub.TRANSACTION_setCursorCapsMode, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.372 -0500", hash_original_method = "0B74B92A95EB945C25801EDA2492AD28", hash_generated_method = "96D47D46F24737C3D61338F51AF4B619")
            
public void setExtractedText(android.view.inputmethod.ExtractedText extractedText, int seq) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((extractedText!=null)) {
_data.writeInt(1);
extractedText.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(seq);
mRemote.transact(Stub.TRANSACTION_setExtractedText, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.375 -0500", hash_original_method = "1E92BEBD008B14D6DE8BD419DB2F2737", hash_generated_method = "0F177925B5B164C076612FD8F3FB568C")
            
public void setSelectedText(java.lang.CharSequence selectedText, int seq) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((selectedText!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(selectedText, _data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(seq);
mRemote.transact(Stub.TRANSACTION_setSelectedText, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.389 -0500", hash_original_field = "C62F857B8DCC55A8A5843D37C61F54A0", hash_generated_field = "2E18E0D88B53531CDAF226B2A693A116")

static final int TRANSACTION_setExtractedText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.391 -0500", hash_original_field = "D33B31E1BB793720561823B0D56DE7CC", hash_generated_field = "AD97C9F51D2735184FD5F13F2769B4E6")

static final int TRANSACTION_setSelectedText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.340 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.344 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.348 -0500", hash_original_method = "18A43A813DD507C47B12672B602F2139", hash_generated_method = "37F52D3B9B37ADE1052FA16E281BC4D6")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setTextBeforeCursor:
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
this.setTextBeforeCursor(_arg0, _arg1);
return true;
}
case TRANSACTION_setTextAfterCursor:
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
this.setTextAfterCursor(_arg0, _arg1);
return true;
}
case TRANSACTION_setCursorCapsMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.setCursorCapsMode(_arg0, _arg1);
return true;
}
case TRANSACTION_setExtractedText:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.ExtractedText _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.inputmethod.ExtractedText.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setExtractedText(_arg0, _arg1);
return true;
}
case TRANSACTION_setSelectedText:
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
this.setSelectedText(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void setTextBeforeCursor(java.lang.CharSequence textBeforeCursor, int seq) throws android.os.RemoteException;
public void setTextAfterCursor(java.lang.CharSequence textAfterCursor, int seq) throws android.os.RemoteException;
public void setCursorCapsMode(int capsMode, int seq) throws android.os.RemoteException;
public void setExtractedText(android.view.inputmethod.ExtractedText extractedText, int seq) throws android.os.RemoteException;
public void setSelectedText(java.lang.CharSequence selectedText, int seq) throws android.os.RemoteException;
}
