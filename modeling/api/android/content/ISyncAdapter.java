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


package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ISyncAdapter extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.ISyncAdapter
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.973 -0500", hash_original_field = "470372019BEFC54A1889A8445CD2107E", hash_generated_field = "B57CE36C5AAFEDA34ECC57037A88B1DA")

private static final java.lang.String DESCRIPTOR = "android.content.ISyncAdapter";
/**
 * Cast an IBinder object into an android.content.ISyncAdapter interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.978 -0500", hash_original_method = "6418ECE0E0EEC9B65965CF26152CCCEC", hash_generated_method = "8B51C921C285DFD75A7FE191E2314344")
        
public static android.content.ISyncAdapter asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.ISyncAdapter))) {
return ((android.content.ISyncAdapter)iin);
}
return new android.content.ISyncAdapter.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.008 -0500", hash_original_field = "8DEC85F60D49B3A9E6A1DFCEDAC76407", hash_generated_field = "FF77F50A5BE1030ED69BDD741379266C")

static final int TRANSACTION_startSync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.011 -0500", hash_original_field = "A773BB8960BF7893474FF2CF094246D4", hash_generated_field = "3E711B93B23D331DE40C664F1F138191")

static final int TRANSACTION_cancelSync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.013 -0500", hash_original_field = "6F0193EBF5244D6AD8E48FA5B8CF5553", hash_generated_field = "E66C30A2930743C0CAA0B9A89E91F7B9")

static final int TRANSACTION_initialize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.content.ISyncAdapter
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.987 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.989 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.992 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.994 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Initiate a sync for this account. SyncAdapter-specific parameters may
     * be specified in extras, which is guaranteed to not be null.
     *
     * @param syncContext the ISyncContext used to indicate the progress of the sync. When
     *   the sync is finished (successfully or not) ISyncContext.onFinished() must be called.
     * @param authority the authority that should be synced
     * @param account the account that should be synced
     * @param extras SyncAdapter-specific parameters
     */
@DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.997 -0500", hash_original_method = "AFE3E35F715C728989C1A49E4DBE62B4", hash_generated_method = "3A973945D953AD09204643E42A5623F6")
            
public void startSync(android.content.ISyncContext syncContext, java.lang.String authority, android.accounts.Account account, android.os.Bundle extras) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((syncContext!=null))?(syncContext.asBinder()):(null)));
_data.writeString(authority);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_startSync, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Cancel the most recently initiated sync. Due to race conditions, this may arrive
     * after the ISyncContext.onFinished() for that sync was called.
     * @param syncContext the ISyncContext that was passed to {@link #startSync}
     */
@DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.000 -0500", hash_original_method = "5042A6AAF50A45B707F79CF440A8564D", hash_generated_method = "36B6404DA82B72439366B84A7927FDB5")
            
public void cancelSync(android.content.ISyncContext syncContext) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((syncContext!=null))?(syncContext.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_cancelSync, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Initialize the SyncAdapter for this account and authority.
     *
     * @param account the account that should be synced
     * @param authority the authority that should be synced
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.003 -0500", hash_original_method = "37FEB73D5689D3FED93EDB27406C9B51", hash_generated_method = "1F3CBD82E89B62E3C2E1AFBEF77A0FDC")
            
public void initialize(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authority);
mRemote.transact(Stub.TRANSACTION_initialize, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.976 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.980 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.983 -0500", hash_original_method = "68790805D1FD10475DD26765EBD2C9D9", hash_generated_method = "F1FB1EB8ECC47852461C434874262171")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_startSync:
{
data.enforceInterface(DESCRIPTOR);
android.content.ISyncContext _arg0;
_arg0 = android.content.ISyncContext.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
android.accounts.Account _arg2;
if ((0!=data.readInt())) {
_arg2 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
android.os.Bundle _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.startSync(_arg0, _arg1, _arg2, _arg3);
return true;
}
case TRANSACTION_cancelSync:
{
data.enforceInterface(DESCRIPTOR);
android.content.ISyncContext _arg0;
_arg0 = android.content.ISyncContext.Stub.asInterface(data.readStrongBinder());
this.cancelSync(_arg0);
return true;
}
case TRANSACTION_initialize:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
this.initialize(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void startSync(android.content.ISyncContext syncContext, java.lang.String authority, android.accounts.Account account, android.os.Bundle extras) throws android.os.RemoteException;

public void cancelSync(android.content.ISyncContext syncContext) throws android.os.RemoteException;

public void initialize(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException;
}
