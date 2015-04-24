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


package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ICountryDetector extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.location.ICountryDetector
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.646 -0500", hash_original_field = "07C9365E892956CEDE079EF8F10AF8A7", hash_generated_field = "D9AB3C1185CCEA14802517F497BD9041")

private static final java.lang.String DESCRIPTOR = "android.location.ICountryDetector";
/**
 * Cast an IBinder object into an android.location.ICountryDetector interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.651 -0500", hash_original_method = "57E529D856FC38C3E3AF40595923053F", hash_generated_method = "BB08019924A3B04AFC23A4C625C58C7C")
        
public static android.location.ICountryDetector asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.location.ICountryDetector))) {
return ((android.location.ICountryDetector)iin);
}
return new android.location.ICountryDetector.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.680 -0500", hash_original_field = "6219939CF8ABC3E9F6EE395BF2BED030", hash_generated_field = "01D811907AEA4E0F2DEFD2A0E34221C8")

static final int TRANSACTION_detectCountry = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.683 -0500", hash_original_field = "6237F1116B14326E028211E05593323A", hash_generated_field = "3F16261ACB53242590EEFA918A9AAA92")

static final int TRANSACTION_addCountryListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.685 -0500", hash_original_field = "676169126FAAB990B45A498C49628728", hash_generated_field = "BE6B25899C2E5F9A4B027EC6CBB97373")

static final int TRANSACTION_removeCountryListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.location.ICountryDetector
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.660 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.663 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.665 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.LOCATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.667 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Start detecting the country that the user is in.
     * @return the country if it is available immediately, otherwise null will be returned.
     */
@DSSource({DSSourceKind.LOCATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.670 -0500", hash_original_method = "A28BDDBF00AA3279A8205DA7A1FF9FD6", hash_generated_method = "EDF3E952A6E9BA582F57CD6AC2AE84BF")
            
public android.location.Country detectCountry() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.location.Country _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_detectCountry, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.location.Country.CREATOR.createFromParcel(_reply);
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
/**
     * Add a listener to receive the notification when the country is detected or changed.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.672 -0500", hash_original_method = "8F996812D865A186315B11FBCF63DE94", hash_generated_method = "B314187CA280C74F936719D706C7C324")
            
public void addCountryListener(android.location.ICountryListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addCountryListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Remove the listener
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.675 -0500", hash_original_method = "3968F00607CE708B05B6A78B24E24EF2", hash_generated_method = "63E558D8B91587BBE7A3E123372D3D62")
            
public void removeCountryListener(android.location.ICountryListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeCountryListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.648 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.LOCATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.653 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.656 -0500", hash_original_method = "B11C88C3F3B9A7F3F2701DE3F49022D6", hash_generated_method = "C621D8D79FC4C410691483F0ACCC1C40")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_detectCountry:
{
data.enforceInterface(DESCRIPTOR);
android.location.Country _result = this.detectCountry();
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
case TRANSACTION_addCountryListener:
{
data.enforceInterface(DESCRIPTOR);
android.location.ICountryListener _arg0;
_arg0 = android.location.ICountryListener.Stub.asInterface(data.readStrongBinder());
this.addCountryListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeCountryListener:
{
data.enforceInterface(DESCRIPTOR);
android.location.ICountryListener _arg0;
_arg0 = android.location.ICountryListener.Stub.asInterface(data.readStrongBinder());
this.removeCountryListener(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public android.location.Country detectCountry() throws android.os.RemoteException;

public void addCountryListener(android.location.ICountryListener listener) throws android.os.RemoteException;

public void removeCountryListener(android.location.ICountryListener listener) throws android.os.RemoteException;
}
