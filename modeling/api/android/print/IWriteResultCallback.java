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


/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/IWriteResultCallback.aidl
 */
package android.print;
/**
 * Callback for observing the result of android.print.DocuemntAdapter#onWrite.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IWriteResultCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IWriteResultCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.226 -0400", hash_original_field = "129D58A19DD959BB65305D708806994D", hash_generated_field = "FDB0B145FC0BBD542373BCD10745D814")

private static final java.lang.String DESCRIPTOR = "android.print.IWriteResultCallback";
/**
 * Cast an IBinder object into an android.print.IWriteResultCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.228 -0400", hash_original_method = "4921D1DA848E2E5927E41D9DFDF48DBA", hash_generated_method = "90FA1095329099C10C713BA4E6876397")
        
public static android.print.IWriteResultCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IWriteResultCallback))) {
return ((android.print.IWriteResultCallback)iin);
}
return new android.print.IWriteResultCallback.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.240 -0400", hash_original_field = "229136BD20267A872B0F9CC15C3E0AD8", hash_generated_field = "CF39B31F7524E46691DDBD6032A134A0")

static final int TRANSACTION_onWriteFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.241 -0400", hash_original_field = "AD038F10966C0D52238131B231FE6BF5", hash_generated_field = "4C69A53E07395850B751A3CC845453F5")

static final int TRANSACTION_onWriteFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.227 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.print.IWriteResultCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.231 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.232 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.233 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.234 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.237 -0400", hash_original_method = "F6A30E3B73BFE8B0C4B55631A186AC7E", hash_generated_method = "0D88FF6256237E74ED942DD8148E0027")
            
@Override public void onWriteFinished(android.print.PageRange[] pages, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(pages, 0);
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onWriteFinished, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.238 -0400", hash_original_method = "9A672C3BDF5D6C18C2D377776D359480", hash_generated_method = "5AF507A595ACDAAA0B6DECF968C01FA8")
            
@Override public void onWriteFailed(java.lang.CharSequence error, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((error!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(error, _data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onWriteFailed, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.229 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.230 -0400", hash_original_method = "B259939546A3D7C32E9A2A174C63FD9E", hash_generated_method = "947A899FC3DFD6F9825FCF88181CCB36")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onWriteFinished:
{
data.enforceInterface(DESCRIPTOR);
android.print.PageRange[] _arg0;
_arg0 = data.createTypedArray(android.print.PageRange.CREATOR);
int _arg1;
_arg1 = data.readInt();
this.onWriteFinished(_arg0, _arg1);
return true;
}
case TRANSACTION_onWriteFailed:
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
this.onWriteFailed(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onWriteFinished(android.print.PageRange[] pages, int sequence) throws android.os.RemoteException;
public void onWriteFailed(java.lang.CharSequence error, int sequence) throws android.os.RemoteException;
}
