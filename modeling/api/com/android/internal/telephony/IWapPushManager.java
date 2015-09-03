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


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IWapPushManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.IWapPushManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.905 -0500", hash_original_field = "1FEB2D0B3D05A8F2288AA28FA17F7291", hash_generated_field = "7C9FFCA8466AEF9457D0174E718B7DD6")

private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.IWapPushManager";
/**
 * Cast an IBinder object into an com.android.internal.telephony.IWapPushManager interface,
 * generating a proxy if needed.
 */
@DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.911 -0500", hash_original_method = "6E0F16370990FA86C30D2EF47197D85E", hash_generated_method = "0EBC445F5C5A7739B58515C0BC81D19F")
        
public static com.android.internal.telephony.IWapPushManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.IWapPushManager))) {
return ((com.android.internal.telephony.IWapPushManager)iin);
}
return new com.android.internal.telephony.IWapPushManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.947 -0500", hash_original_field = "AAA20DF2A90E24D7B4A230C65F726859", hash_generated_field = "F54A21DC72E043536BCED9DD06AED702")

static final int TRANSACTION_processMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.950 -0500", hash_original_field = "996CC8702A2695F6396065944C223D39", hash_generated_field = "56E5B0F45F026D997358B6EE7C1400E7")

static final int TRANSACTION_addPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.953 -0500", hash_original_field = "B08082FA6870D55228EE4989F99D1BBF", hash_generated_field = "A08329DAFD44575797D008580328E5E2")

static final int TRANSACTION_updatePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.telephony.IWapPushManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.921 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.923 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.926 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.928 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Processes WAP push message and triggers the receiver application registered
     * in the application ID table.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.931 -0500", hash_original_method = "79C733037BFBA6C3FAE684CBC0D8C161", hash_generated_method = "F1A8031B585626078763E9A73D9F3413")
            
public int processMessage(java.lang.String app_id, java.lang.String content_type, android.content.Intent intent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(app_id);
_data.writeString(content_type);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_processMessage, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Add receiver application into the application ID table.
     * Returns true if inserting the information is successfull. Inserting the duplicated
     * record in the application ID table is not allowed. Use update/delete method.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.935 -0500", hash_original_method = "8D36FB2105488AEF61C466DAC43F37FA", hash_generated_method = "4B8B66AEBE4402CF3D66D1297C0BB2D6")
            
public boolean addPackage(java.lang.String x_app_id, java.lang.String content_type, java.lang.String package_name, java.lang.String class_name, int app_type, boolean need_signature, boolean further_processing) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(x_app_id);
_data.writeString(content_type);
_data.writeString(package_name);
_data.writeString(class_name);
_data.writeInt(app_type);
_data.writeInt(((need_signature)?(1):(0)));
_data.writeInt(((further_processing)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_addPackage, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Updates receiver application that is last added.
     * Returns true if updating the information is successfull.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.938 -0500", hash_original_method = "582539EE273DCC102586E21AD33366D4", hash_generated_method = "C77F56B71AC8B35FE172689CF5A6AED7")
            
public boolean updatePackage(java.lang.String x_app_id, java.lang.String content_type, java.lang.String package_name, java.lang.String class_name, int app_type, boolean need_signature, boolean further_processing) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(x_app_id);
_data.writeString(content_type);
_data.writeString(package_name);
_data.writeString(class_name);
_data.writeInt(app_type);
_data.writeInt(((need_signature)?(1):(0)));
_data.writeInt(((further_processing)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_updatePackage, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Delites receiver application information.
     * Returns true if deleting is successfull.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.940 -0500", hash_original_method = "5DF7489F58C12D60475D0E2B570C313B", hash_generated_method = "BBB6955C1368D262314C34F554401FE1")
            
public boolean deletePackage(java.lang.String x_app_id, java.lang.String content_type, java.lang.String package_name, java.lang.String class_name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(x_app_id);
_data.writeString(content_type);
_data.writeString(package_name);
_data.writeString(class_name);
mRemote.transact(Stub.TRANSACTION_deletePackage, _data, _reply, 0);
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.955 -0500", hash_original_field = "2F04A3AF69A209F58D99D993692D75F0", hash_generated_field = "B29810C18E1E532B8B53171FC34CAECB")

static final int TRANSACTION_deletePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.908 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.913 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.918 -0500", hash_original_method = "7303448824E3B1DA9CA5C8FD265D85E4", hash_generated_method = "F54E86A445A2E36FCBC6E8B4888E01BB")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_processMessage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
android.content.Intent _arg2;
if ((0!=data.readInt())) {
_arg2 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _result = this.processMessage(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_addPackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
int _arg4;
_arg4 = data.readInt();
boolean _arg5;
_arg5 = (0!=data.readInt());
boolean _arg6;
_arg6 = (0!=data.readInt());
boolean _result = this.addPackage(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_updatePackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
int _arg4;
_arg4 = data.readInt();
boolean _arg5;
_arg5 = (0!=data.readInt());
boolean _arg6;
_arg6 = (0!=data.readInt());
boolean _result = this.updatePackage(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_deletePackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
boolean _result = this.deletePackage(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public int processMessage(java.lang.String app_id, java.lang.String content_type, android.content.Intent intent) throws android.os.RemoteException;

public boolean addPackage(java.lang.String x_app_id, java.lang.String content_type, java.lang.String package_name, java.lang.String class_name, int app_type, boolean need_signature, boolean further_processing) throws android.os.RemoteException;

public boolean updatePackage(java.lang.String x_app_id, java.lang.String content_type, java.lang.String package_name, java.lang.String class_name, int app_type, boolean need_signature, boolean further_processing) throws android.os.RemoteException;

public boolean deletePackage(java.lang.String x_app_id, java.lang.String content_type, java.lang.String package_name, java.lang.String class_name) throws android.os.RemoteException;
}
