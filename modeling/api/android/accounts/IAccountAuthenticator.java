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
 * Original file: ./android/accounts/IAccountAuthenticator.aidl
 */
package android.accounts;
/**
 * Service that allows the interaction with an authentication server.
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IAccountAuthenticator extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.accounts.IAccountAuthenticator
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.443 -0500", hash_original_field = "2EBAA74AAE627228998E5043F005C494", hash_generated_field = "C82219D80FB0D1CAE5398A8916ABE44E")

private static final java.lang.String DESCRIPTOR = "android.accounts.IAccountAuthenticator";
/**
 * Cast an IBinder object into an android.accounts.IAccountAuthenticator interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.467 -0500", hash_original_method = "BE0CB3673AA17D0EDBF9B4F329A9B794", hash_generated_method = "92D3BDBFCE8085E345993850F8ADDDA4")
        
public static android.accounts.IAccountAuthenticator asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.accounts.IAccountAuthenticator))) {
return ((android.accounts.IAccountAuthenticator)iin);
}
return new android.accounts.IAccountAuthenticator.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.674 -0500", hash_original_field = "28B3F42C3E5F18F62DD7AF0DE8C45E0D", hash_generated_field = "FA928322FAD9038CB7233722D9C28353")

static final int TRANSACTION_addAccount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.681 -0500", hash_original_field = "6DAC5B8A9B855887965FD0DDAD87C712", hash_generated_field = "3C6EBB48EFBB323762F98FF3692BD7CC")

static final int TRANSACTION_confirmCredentials = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.688 -0500", hash_original_field = "CC488C0D828864E1F1D78FD841082B4A", hash_generated_field = "AAC9EB8B5D4293EEEA5CF12BD81C6176")

static final int TRANSACTION_getAuthToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.accounts.IAccountAuthenticator
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.538 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.558 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.566 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.573 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * prompts the user for account information and adds the result to the IAccountManager
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.586 -0500", hash_original_method = "81E599A16EEB720B8FC922E39863A58C", hash_generated_method = "C512717E6F4A8CC318627BB182096BA3")
            
public void addAccount(android.accounts.IAccountAuthenticatorResponse response, java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] requiredFeatures, android.os.Bundle options) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
_data.writeString(accountType);
_data.writeString(authTokenType);
_data.writeStringArray(requiredFeatures);
if ((options!=null)) {
_data.writeInt(1);
options.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addAccount, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * prompts the user for the credentials of the account
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.596 -0500", hash_original_method = "A953AF35F8B68E08B8DF45AAC21A8107", hash_generated_method = "9590654F581678880E09C7687637DD17")
            
public void confirmCredentials(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account, android.os.Bundle options) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((options!=null)) {
_data.writeInt(1);
options.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_confirmCredentials, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * gets the password by either prompting the user or querying the IAccountManager
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.608 -0500", hash_original_method = "3C2ACBF308688D27FE648757317C2AF1", hash_generated_method = "2E3587B99D04D7B5D68D2E19CBEE2DD8")
            
public void getAuthToken(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authTokenType);
if ((options!=null)) {
_data.writeInt(1);
options.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getAuthToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Gets the user-visible label of the given authtoken type.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.618 -0500", hash_original_method = "119619B55F597AEF9FE76F5ACB10689E", hash_generated_method = "6217C4E040B801A69F5F4742879D4EEA")
            
public void getAuthTokenLabel(android.accounts.IAccountAuthenticatorResponse response, java.lang.String authTokenType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
_data.writeString(authTokenType);
mRemote.transact(Stub.TRANSACTION_getAuthTokenLabel, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * prompts the user for a new password and writes it to the IAccountManager
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.627 -0500", hash_original_method = "2D6A99E8A6A8DF5F3D94AC20982FD4A1", hash_generated_method = "CEB2E6FDD1C935695ED9872E28B9CE8B")
            
public void updateCredentials(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authTokenType);
if ((options!=null)) {
_data.writeInt(1);
options.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateCredentials, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * launches an activity that lets the user edit and set the properties for an authenticator
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.635 -0500", hash_original_method = "D2CAFC11A7CDBEEDBEF0A9CFDA86AF51", hash_generated_method = "103EA914402CA65B93B1983FCAE91977")
            
public void editProperties(android.accounts.IAccountAuthenticatorResponse response, java.lang.String accountType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
_data.writeString(accountType);
mRemote.transact(Stub.TRANSACTION_editProperties, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * returns a Bundle where the boolean value BOOLEAN_RESULT_KEY is set if the account has the
     * specified features
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.643 -0500", hash_original_method = "3AFE1900DC8BA0B57924E046C13948D3", hash_generated_method = "216121C0433A0441D4596F8D405BDE16")
            
public void hasFeatures(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String[] features) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStringArray(features);
mRemote.transact(Stub.TRANSACTION_hasFeatures, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Gets whether or not the account is allowed to be removed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.653 -0500", hash_original_method = "4A12B5F9CB217E05193B43204A8D5B31", hash_generated_method = "0E2385835B28FE8D217DBF3C8E93BE3C")
            
public void getAccountRemovalAllowed(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getAccountRemovalAllowed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.695 -0500", hash_original_field = "016CC6ACB5F4D2B6A0145DAF0CBFA2BC", hash_generated_field = "91BC12EFDAF377969AC09C8B3AF9E746")

static final int TRANSACTION_getAuthTokenLabel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.703 -0500", hash_original_field = "9FF7B78089FDA1766D3F35BB46F308E9", hash_generated_field = "E5DF5A144B20148948D86CEC8EDC182D")

static final int TRANSACTION_updateCredentials = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.710 -0500", hash_original_field = "F7A10F7BAC64ADF58595925A7EDADB69", hash_generated_field = "5270F2FEE56C40A7ED98E1B435A717B7")

static final int TRANSACTION_editProperties = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.717 -0500", hash_original_field = "178B3404E85E7133D92C83EBF21DC71E", hash_generated_field = "7C7363F1FA959A05B2FEFC5AEAA69063")

static final int TRANSACTION_hasFeatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.724 -0500", hash_original_field = "D4BE4AFB319E12D6B6B01AF11B0315D1", hash_generated_field = "1274F02BC8EA817321FCAB770F3C33A7")

static final int TRANSACTION_getAccountRemovalAllowed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.455 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.474 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 11:31:33.528 -0500", hash_original_method = "9913AB46A267682B262E26C9354CAD9E", hash_generated_method = "4C8319A6E90E85B33FD0370752F359B1")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_addAccount:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountAuthenticatorResponse _arg0;
_arg0 = android.accounts.IAccountAuthenticatorResponse.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String[] _arg3;
_arg3 = data.createStringArray();
android.os.Bundle _arg4;
if ((0!=data.readInt())) {
_arg4 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
this.addAccount(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_confirmCredentials:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountAuthenticatorResponse _arg0;
_arg0 = android.accounts.IAccountAuthenticatorResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.confirmCredentials(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getAuthToken:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountAuthenticatorResponse _arg0;
_arg0 = android.accounts.IAccountAuthenticatorResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String _arg2;
_arg2 = data.readString();
android.os.Bundle _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.getAuthToken(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_getAuthTokenLabel:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountAuthenticatorResponse _arg0;
_arg0 = android.accounts.IAccountAuthenticatorResponse.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
this.getAuthTokenLabel(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_updateCredentials:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountAuthenticatorResponse _arg0;
_arg0 = android.accounts.IAccountAuthenticatorResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String _arg2;
_arg2 = data.readString();
android.os.Bundle _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.updateCredentials(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_editProperties:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountAuthenticatorResponse _arg0;
_arg0 = android.accounts.IAccountAuthenticatorResponse.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
this.editProperties(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_hasFeatures:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountAuthenticatorResponse _arg0;
_arg0 = android.accounts.IAccountAuthenticatorResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
this.hasFeatures(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getAccountRemovalAllowed:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountAuthenticatorResponse _arg0;
_arg0 = android.accounts.IAccountAuthenticatorResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.getAccountRemovalAllowed(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
/**
     * prompts the user for account information and adds the result to the IAccountManager
     */
public void addAccount(android.accounts.IAccountAuthenticatorResponse response, java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] requiredFeatures, android.os.Bundle options) throws android.os.RemoteException;
/**
     * prompts the user for the credentials of the account
     */
public void confirmCredentials(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account, android.os.Bundle options) throws android.os.RemoteException;
/**
     * gets the password by either prompting the user or querying the IAccountManager
     */
public void getAuthToken(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options) throws android.os.RemoteException;
/**
     * Gets the user-visible label of the given authtoken type.
     */
public void getAuthTokenLabel(android.accounts.IAccountAuthenticatorResponse response, java.lang.String authTokenType) throws android.os.RemoteException;
/**
     * prompts the user for a new password and writes it to the IAccountManager
     */
public void updateCredentials(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options) throws android.os.RemoteException;
/**
     * launches an activity that lets the user edit and set the properties for an authenticator
     */
public void editProperties(android.accounts.IAccountAuthenticatorResponse response, java.lang.String accountType) throws android.os.RemoteException;
/**
     * returns a Bundle where the boolean value BOOLEAN_RESULT_KEY is set if the account has the
     * specified features
     */
public void hasFeatures(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String[] features) throws android.os.RemoteException;
/**
     * Gets whether or not the account is allowed to be removed.
     */
public void getAccountRemovalAllowed(android.accounts.IAccountAuthenticatorResponse response, android.accounts.Account account) throws android.os.RemoteException;
}
