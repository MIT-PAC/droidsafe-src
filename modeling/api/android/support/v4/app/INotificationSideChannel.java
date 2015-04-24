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
 * Original file: /usr/local/google/buildbot/repo_clients/https___googleplex-android.googlesource.com_a_platform_manifest.git/klp-modular-release/frameworks/support/v4/java/android/support/v4/app/INotificationSideChannel.aidl
 */
package android.support.v4.app;
/**
 * Interface used for delivering notifications via a side channel that bypasses
 * the NotificationManagerService.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface INotificationSideChannel extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.support.v4.app.INotificationSideChannel
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.245 -0400", hash_original_field = "AD8B0832D223E721A5D5D234C86E9BAA", hash_generated_field = "BCA40596DA6921415F0C45BECFAB21AE")

private static final java.lang.String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
/**
 * Cast an IBinder object into an android.support.v4.app.INotificationSideChannel interface,
 * generating a proxy if needed.
 */
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.254 -0400", hash_original_method = "15AD5F2E186907E0C05A7D99A8035997", hash_generated_method = "4E27867674AF0763BCC9E8D6AF398E78")
        
public static android.support.v4.app.INotificationSideChannel asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.support.v4.app.INotificationSideChannel))) {
return ((android.support.v4.app.INotificationSideChannel)iin);
}
return new android.support.v4.app.INotificationSideChannel.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.336 -0400", hash_original_field = "1A068B16542FFF4B9847DDCC592D7A4F", hash_generated_field = "A7EFCDE8352EC95BBCF77B26BCF9724B")

static final int TRANSACTION_notify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.341 -0400", hash_original_field = "DC142BC62E96A462955E1E7F7172CD9A", hash_generated_field = "EBD2A87C8218E3D82D03122429B301B4")

static final int TRANSACTION_cancel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.345 -0400", hash_original_field = "8DD532C3DBCBB8745E637A7BF7584F8A", hash_generated_field = "6C931DCFF32B4E769D5501CD513E8F98")

static final int TRANSACTION_cancelAll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.support.v4.app.INotificationSideChannel
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Send an ambient notification to the service.
     */
@DSSafe(DSCat.SAFE_LIST)
            @Override public void notify(java.lang.String packageName, int id, java.lang.String tag, android.app.Notification notification) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(id);
_data.writeString(tag);
if ((notification!=null)) {
_data.writeInt(1);
notification.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_notify, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Cancel an already-notified notification.
     */
@DSSafe(DSCat.SAFE_LIST)
            @Override public void cancel(java.lang.String packageName, int id, java.lang.String tag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(id);
_data.writeString(tag);
mRemote.transact(Stub.TRANSACTION_cancel, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Cancel all notifications for the given package.
     */
@DSSafe(DSCat.SAFE_LIST)
            @Override public void cancelAll(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_cancelAll, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.248 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.260 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.267 -0400", hash_original_method = "76C63006A066906C0D90A3D937EA36BD", hash_generated_method = "E4DC296E0E2C4392E875E5F6F453D6AF")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_notify:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
android.app.Notification _arg3;
if ((0!=data.readInt())) {
_arg3 = android.app.Notification.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.notify(_arg0, _arg1, _arg2, _arg3);
return true;
}
case TRANSACTION_cancel:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
this.cancel(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_cancelAll:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.cancelAll(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
/**
     * Send an ambient notification to the service.
     */
public void notify(java.lang.String packageName, int id, java.lang.String tag, android.app.Notification notification) throws android.os.RemoteException;
/**
     * Cancel an already-notified notification.
     */
public void cancel(java.lang.String packageName, int id, java.lang.String tag) throws android.os.RemoteException;
/**
     * Cancel all notifications for the given package.
     */
public void cancelAll(java.lang.String packageName) throws android.os.RemoteException;
}
