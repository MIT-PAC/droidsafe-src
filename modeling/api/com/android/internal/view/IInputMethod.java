/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IInputMethod extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.view.IInputMethod
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.881 -0500", hash_original_field = "BF5BBEBA0823BCBC4B0069F26D810E6D", hash_generated_field = "531A25CA5EA0FE95067719905F947741")

private static final java.lang.String DESCRIPTOR = "com.android.internal.view.IInputMethod";
/**
 * Cast an IBinder object into an com.android.internal.view.IInputMethod interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.887 -0500", hash_original_method = "E991E9EA43DDD4058102DF00CDF6B72E", hash_generated_method = "58FF064DA278F7E3C8104C79B33CE98C")
        
public static com.android.internal.view.IInputMethod asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.view.IInputMethod))) {
return ((com.android.internal.view.IInputMethod)iin);
}
return new com.android.internal.view.IInputMethod.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.943 -0500", hash_original_field = "2673411A817B20E95AD77327AB4C4CC0", hash_generated_field = "A70EFE6652AC79D9DBBEDF63BDA8AD41")

static final int TRANSACTION_attachToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.946 -0500", hash_original_field = "FDE822DB73DA49C944F7726D225D9E59", hash_generated_field = "81A876652C5C26F036B328CA7A80301C")

static final int TRANSACTION_bindInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.948 -0500", hash_original_field = "09453081BEC4F2A5C5604F117B276D5B", hash_generated_field = "25D03C9ABC82D049393E76EFB62D4AA8")

static final int TRANSACTION_unbindInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.view.IInputMethod
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.897 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.900 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.902 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.905 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.907 -0500", hash_original_method = "BD2901B85E99C27164362D351EB91941", hash_generated_method = "5ACE98CDFEA488279ACA0FBBA540730E")
            
public void attachToken(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_attachToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.910 -0500", hash_original_method = "D08882A4104CA89B222DEA0B609DFF8F", hash_generated_method = "98372B924DBA9DEC8DBF4F3329E53D2A")
            
public void bindInput(android.view.inputmethod.InputBinding binding) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((binding!=null)) {
_data.writeInt(1);
binding.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_bindInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.912 -0500", hash_original_method = "46BFEB9F8F159DE6130A11F97873D775", hash_generated_method = "DC58BBCDA6D3DC324AEFBEA249ED4FE1")
            
public void unbindInput() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_unbindInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.916 -0500", hash_original_method = "DD64568754409DC73FFA10D75037EFAB", hash_generated_method = "3E61A59D87A90EBC59E79619554D467C")
            
public void startInput(com.android.internal.view.IInputContext inputContext, android.view.inputmethod.EditorInfo attribute) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((inputContext!=null))?(inputContext.asBinder()):(null)));
if ((attribute!=null)) {
_data.writeInt(1);
attribute.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_startInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.919 -0500", hash_original_method = "35AC32F070EA1776864F70868516D60D", hash_generated_method = "3521396DE9FD9DFEACFF7CF1DE25530F")
            
public void restartInput(com.android.internal.view.IInputContext inputContext, android.view.inputmethod.EditorInfo attribute) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((inputContext!=null))?(inputContext.asBinder()):(null)));
if ((attribute!=null)) {
_data.writeInt(1);
attribute.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_restartInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.922 -0500", hash_original_method = "3B7B9C876A0DA909247565AE6F24E649", hash_generated_method = "1269E400DB5B84A5AE3DDCA937594C0B")
            
public void createSession(com.android.internal.view.IInputMethodCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_createSession, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.925 -0500", hash_original_method = "D36424B186DB342D5F1F2570B23D1E17", hash_generated_method = "603D34C8C83E14008B2617A6A9D77399")
            
public void setSessionEnabled(com.android.internal.view.IInputMethodSession session, boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setSessionEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.928 -0500", hash_original_method = "27DF86E63795A5E7A92E577F440181AC", hash_generated_method = "BCE294308BF82870B0F3EDA6E3A965C6")
            
public void revokeSession(com.android.internal.view.IInputMethodSession session) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_revokeSession, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.931 -0500", hash_original_method = "03CD0E834001BC9A465755F3895CFCCD", hash_generated_method = "33E9D3E83EF56D94BF8BA917D31C6B54")
            
public void showSoftInput(int flags, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
if ((resultReceiver!=null)) {
_data.writeInt(1);
resultReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_showSoftInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.933 -0500", hash_original_method = "B0FB0438C5B5D7E465AA03D0D5018968", hash_generated_method = "183C829E7D2C9ECCB4215423A4F3073F")
            
public void hideSoftInput(int flags, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
if ((resultReceiver!=null)) {
_data.writeInt(1);
resultReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_hideSoftInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.936 -0500", hash_original_method = "2445D74D09C329719414652775EAE5F7", hash_generated_method = "A1CC5264341E4DCEC14496CB45E7C3D1")
            
public void changeInputMethodSubtype(android.view.inputmethod.InputMethodSubtype subtype) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((subtype!=null)) {
_data.writeInt(1);
subtype.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_changeInputMethodSubtype, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.951 -0500", hash_original_field = "AB74242F81426F529E3EF96BF3EB2598", hash_generated_field = "406D24518AB9D8657DDE6DF6492C1C09")

static final int TRANSACTION_startInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.953 -0500", hash_original_field = "EF352729D5EF86D270CB6B3A68FB854D", hash_generated_field = "23B49C8ADA07F79BCC18876B4F709274")

static final int TRANSACTION_restartInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.956 -0500", hash_original_field = "85459E9C2015B335810959A899253EB7", hash_generated_field = "D630D99ACE7D763673C14F606E7E1610")

static final int TRANSACTION_createSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.958 -0500", hash_original_field = "14244025C3C1270601E378E4ED6245FA", hash_generated_field = "C9B5974EECDE1D40E0FC6DFDE7883F51")

static final int TRANSACTION_setSessionEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.961 -0500", hash_original_field = "546BE3FC58C4192F36A5EDB4DDE1B263", hash_generated_field = "4E88F00EC1854E7F31152F8B76BCD8F6")

static final int TRANSACTION_revokeSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.963 -0500", hash_original_field = "9B454EA8943BA6958D78ACE63D5E58AD", hash_generated_field = "F2C07E84F8C820F03ADC86EA6102C5B6")

static final int TRANSACTION_showSoftInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.966 -0500", hash_original_field = "35EA7900B4B73C280E004A4BB9B18F9E", hash_generated_field = "20423E2D9DE70CC3D8ED3D5B93CF4498")

static final int TRANSACTION_hideSoftInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.969 -0500", hash_original_field = "BF3EF650B8A97DD4BBBE10E190EEC2C2", hash_generated_field = "AD2CF2458B36878678203CBFAC12C39A")

static final int TRANSACTION_changeInputMethodSubtype = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.884 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.889 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.893 -0500", hash_original_method = "0BF30036998CFA2E4A68DCBFB3A02BE6", hash_generated_method = "E5AA362201DC3C0E4D2DC5BC0B9DA769")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_attachToken:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.attachToken(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_bindInput:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.InputBinding _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.inputmethod.InputBinding.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.bindInput(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unbindInput:
{
data.enforceInterface(DESCRIPTOR);
this.unbindInput();
reply.writeNoException();
return true;
}
case TRANSACTION_startInput:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputContext _arg0;
_arg0 = com.android.internal.view.IInputContext.Stub.asInterface(data.readStrongBinder());
android.view.inputmethod.EditorInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = android.view.inputmethod.EditorInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.startInput(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_restartInput:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputContext _arg0;
_arg0 = com.android.internal.view.IInputContext.Stub.asInterface(data.readStrongBinder());
android.view.inputmethod.EditorInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = android.view.inputmethod.EditorInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.restartInput(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_createSession:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodCallback _arg0;
_arg0 = com.android.internal.view.IInputMethodCallback.Stub.asInterface(data.readStrongBinder());
this.createSession(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setSessionEnabled:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodSession _arg0;
_arg0 = com.android.internal.view.IInputMethodSession.Stub.asInterface(data.readStrongBinder());
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setSessionEnabled(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_revokeSession:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodSession _arg0;
_arg0 = com.android.internal.view.IInputMethodSession.Stub.asInterface(data.readStrongBinder());
this.revokeSession(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_showSoftInput:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.ResultReceiver _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ResultReceiver.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.showSoftInput(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_hideSoftInput:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.ResultReceiver _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ResultReceiver.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.hideSoftInput(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_changeInputMethodSubtype:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.InputMethodSubtype _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.inputmethod.InputMethodSubtype.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.changeInputMethodSubtype(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void attachToken(android.os.IBinder token) throws android.os.RemoteException;
public void bindInput(android.view.inputmethod.InputBinding binding) throws android.os.RemoteException;
public void unbindInput() throws android.os.RemoteException;
public void startInput(com.android.internal.view.IInputContext inputContext, android.view.inputmethod.EditorInfo attribute) throws android.os.RemoteException;
public void restartInput(com.android.internal.view.IInputContext inputContext, android.view.inputmethod.EditorInfo attribute) throws android.os.RemoteException;
public void createSession(com.android.internal.view.IInputMethodCallback callback) throws android.os.RemoteException;
public void setSessionEnabled(com.android.internal.view.IInputMethodSession session, boolean enabled) throws android.os.RemoteException;
public void revokeSession(com.android.internal.view.IInputMethodSession session) throws android.os.RemoteException;
public void showSoftInput(int flags, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException;
public void hideSoftInput(int flags, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException;
public void changeInputMethodSubtype(android.view.inputmethod.InputMethodSubtype subtype) throws android.os.RemoteException;
}
