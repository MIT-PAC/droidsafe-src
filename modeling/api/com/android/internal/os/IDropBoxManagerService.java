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


package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IDropBoxManagerService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.os.IDropBoxManagerService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.285 -0500", hash_original_field = "3B8F7AD7D812A9360AB213CC77D6BC3C", hash_generated_field = "7356BD0063AA7872770BB3CA1C335C5C")

private static final java.lang.String DESCRIPTOR = "com.android.internal.os.IDropBoxManagerService";
/**
 * Cast an IBinder object into an com.android.internal.os.IDropBoxManagerService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.290 -0500", hash_original_method = "098AF8A66DCF8A4797B71EFFA9E96313", hash_generated_method = "31003077771BF25E1A16F53942531791")
        
public static com.android.internal.os.IDropBoxManagerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.os.IDropBoxManagerService))) {
return ((com.android.internal.os.IDropBoxManagerService)iin);
}
return new com.android.internal.os.IDropBoxManagerService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.319 -0500", hash_original_field = "3294D678F63ECE7CB024FDA46450F47D", hash_generated_field = "B526FEEF1E7774FD85C365D7C392D7D2")

static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.322 -0500", hash_original_field = "B1E5F1DABBE22ECB1F81FE2223685C9D", hash_generated_field = "298F0B0B6505881878805957C854FCAE")

static final int TRANSACTION_isTagEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.324 -0500", hash_original_field = "B852644614D9B43D892D41B6AE466016", hash_generated_field = "B4B49393452EFA717816E91B22FF4920")

static final int TRANSACTION_getNextEntry = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.os.IDropBoxManagerService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.299 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.301 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.304 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.307 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * @see DropBoxManager#addText
     * @see DropBoxManager#addData
     * @see DropBoxManager#addFile
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.309 -0500", hash_original_method = "64920B7D5B524D619D22D418466BE88D", hash_generated_method = "F55A9225F1AF4BA2CC1ADAF2E16FF985")
            
public void add(android.os.DropBoxManager.Entry entry) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((entry!=null)) {
_data.writeInt(1);
entry.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** @see DropBoxManager#getNextEntry */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.312 -0500", hash_original_method = "48D27E1B964E8B49ED44AF316C07C95E", hash_generated_method = "3D90429E74FDBB5E91C51EE5D566A98C")
            
public boolean isTagEnabled(java.lang.String tag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tag);
mRemote.transact(Stub.TRANSACTION_isTagEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** @see DropBoxManager#getNextEntry */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.315 -0500", hash_original_method = "2ABA53D07182C0A7C347E26200702976", hash_generated_method = "3B977BB0B52CB2CF2A2E85E15BB09D5B")
            
public android.os.DropBoxManager.Entry getNextEntry(java.lang.String tag, long millis) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.DropBoxManager.Entry _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tag);
_data.writeLong(millis);
mRemote.transact(Stub.TRANSACTION_getNextEntry, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.DropBoxManager.Entry.CREATOR.createFromParcel(_reply);
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
}
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.287 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.292 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.295 -0500", hash_original_method = "39A04C5CCDDC4A52FC9601B3F1C05DE5", hash_generated_method = "3D1AB04B85A5B6B73C7583A7D886CE5F")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_add:
{
data.enforceInterface(DESCRIPTOR);
android.os.DropBoxManager.Entry _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.DropBoxManager.Entry.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.add(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isTagEnabled:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isTagEnabled(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getNextEntry:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _arg1;
_arg1 = data.readLong();
android.os.DropBoxManager.Entry _result = this.getNextEntry(_arg0, _arg1);
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
}
return super.onTransact(code, data, reply, flags);
}
}

public void add(android.os.DropBoxManager.Entry entry) throws android.os.RemoteException;

public boolean isTagEnabled(java.lang.String tag) throws android.os.RemoteException;

public android.os.DropBoxManager.Entry getNextEntry(java.lang.String tag, long millis) throws android.os.RemoteException;
}
