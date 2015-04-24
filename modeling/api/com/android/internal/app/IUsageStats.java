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


package com.android.internal.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IUsageStats extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.app.IUsageStats
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.927 -0500", hash_original_field = "752B7471AE81B6F5CFE68C82C50E6B5A", hash_generated_field = "C4F852716791B1C6DD485825FDD987D0")

private static final java.lang.String DESCRIPTOR = "com.android.internal.app.IUsageStats";
/**
 * Cast an IBinder object into an com.android.internal.app.IUsageStats interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.932 -0500", hash_original_method = "80FCAC2E552D133B7C2A0F0B5E4BAD38", hash_generated_method = "15F8C5B8085E003217ABD5C6DF0687FA")
        
public static com.android.internal.app.IUsageStats asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.app.IUsageStats))) {
return ((com.android.internal.app.IUsageStats)iin);
}
return new com.android.internal.app.IUsageStats.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.968 -0500", hash_original_field = "4B762DFF8451E9D7845ACF7001B811AA", hash_generated_field = "469E25E0A4C27CBD22BDAD254D5913CE")

static final int TRANSACTION_noteResumeComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.972 -0500", hash_original_field = "9188A0C9728EA659DD88278125A5544E", hash_generated_field = "BE8B4F95245BD4D2EF284B1070349F22")

static final int TRANSACTION_notePauseComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.974 -0500", hash_original_field = "CD634B5526B026605C7DCE46808AADBF", hash_generated_field = "B2346E3E28229E30B5BBD59F1C8B0502")

static final int TRANSACTION_noteLaunchTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.app.IUsageStats
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.941 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.944 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.946 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.949 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.952 -0500", hash_original_method = "E54847C85B1CB5E82E58EBDE04D617B4", hash_generated_method = "18207E6F7B497595CB1669C3225521CB")
            
public void noteResumeComponent(android.content.ComponentName componentName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteResumeComponent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.955 -0500", hash_original_method = "B5334CF3D3F9F065AD4FA28AFB764BE5", hash_generated_method = "06123705E4763456ACC6F41AE2F0E117")
            
public void notePauseComponent(android.content.ComponentName componentName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_notePauseComponent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.958 -0500", hash_original_method = "A8479B9C64D676EB96B3BEF7D379D0F7", hash_generated_method = "3B699A953803CE506CEC259555DDA8D4")
            
public void noteLaunchTime(android.content.ComponentName componentName, int millis) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(millis);
mRemote.transact(Stub.TRANSACTION_noteLaunchTime, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.961 -0500", hash_original_method = "569EC051315B8D884B1D2B0ECFC1072C", hash_generated_method = "2F7AC7E762EB0344EFB846DD94DB8152")
            
public com.android.internal.os.PkgUsageStats getPkgUsageStats(android.content.ComponentName componentName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.android.internal.os.PkgUsageStats _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPkgUsageStats, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.android.internal.os.PkgUsageStats.CREATOR.createFromParcel(_reply);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.963 -0500", hash_original_method = "C2E717311C17EC3E055F8FD110F98F54", hash_generated_method = "6337BA3604E124F32FC7DB7677EABBAC")
            
public com.android.internal.os.PkgUsageStats[] getAllPkgUsageStats() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.android.internal.os.PkgUsageStats[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllPkgUsageStats, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(com.android.internal.os.PkgUsageStats.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.976 -0500", hash_original_field = "ED4D64F2253AFF6D0117F9E1411D1853", hash_generated_field = "613826A1E3E808997CA31BE400E3E195")

static final int TRANSACTION_getPkgUsageStats = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.979 -0500", hash_original_field = "CB1E4A04BDB7C5BFE40A1158E0E1789B", hash_generated_field = "348D8191BC0294BF3FBA35F12837B23D")

static final int TRANSACTION_getAllPkgUsageStats = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.929 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.934 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.937 -0500", hash_original_method = "9F794B00884D1ED62630ADA17103CEA8", hash_generated_method = "0DDBBC48224D866FFDDE04DBC3F4E83B")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_noteResumeComponent:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteResumeComponent(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notePauseComponent:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.notePauseComponent(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteLaunchTime:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.noteLaunchTime(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPkgUsageStats:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.android.internal.os.PkgUsageStats _result = this.getPkgUsageStats(_arg0);
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
case TRANSACTION_getAllPkgUsageStats:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.os.PkgUsageStats[] _result = this.getAllPkgUsageStats();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void noteResumeComponent(android.content.ComponentName componentName) throws android.os.RemoteException;
public void notePauseComponent(android.content.ComponentName componentName) throws android.os.RemoteException;
public void noteLaunchTime(android.content.ComponentName componentName, int millis) throws android.os.RemoteException;
public com.android.internal.os.PkgUsageStats getPkgUsageStats(android.content.ComponentName componentName) throws android.os.RemoteException;
public com.android.internal.os.PkgUsageStats[] getAllPkgUsageStats() throws android.os.RemoteException;
}
