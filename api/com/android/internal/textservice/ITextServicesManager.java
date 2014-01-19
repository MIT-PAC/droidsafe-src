package com.android.internal.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ITextServicesManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.textservice.ITextServicesManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.368 -0500", hash_original_field = "88D7D49C9BDFD419C02D50C90FAD6F86", hash_generated_field = "5E83916E3A8829E143EB02D6A4D6B2E7")

private static final java.lang.String DESCRIPTOR = "com.android.internal.textservice.ITextServicesManager";
/**
 * Cast an IBinder object into an com.android.internal.textservice.ITextServicesManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.373 -0500", hash_original_method = "CA274FB7382FEC7F97EB63B9F7E3C908", hash_generated_method = "14E7E8847785C3993C70952BF3691E2F")
        
public static com.android.internal.textservice.ITextServicesManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.textservice.ITextServicesManager))) {
return ((com.android.internal.textservice.ITextServicesManager)iin);
}
return new com.android.internal.textservice.ITextServicesManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.427 -0500", hash_original_field = "738141C73451B7DC38286126538A7AAE", hash_generated_field = "954887467E12E63CDD3CFE5C6C367135")

static final int TRANSACTION_getCurrentSpellChecker = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.429 -0500", hash_original_field = "70B4CFD342F4C06E50B4ECE1677EE8F2", hash_generated_field = "EB60057479098B54A9273F757B39E255")

static final int TRANSACTION_getCurrentSpellCheckerSubtype = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.432 -0500", hash_original_field = "E69E92A4387D940C22195D40B0FF5A7D", hash_generated_field = "0F63DE9F329EEADE51E3BE29BAEB83FA")

static final int TRANSACTION_getSpellCheckerService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.textservice.ITextServicesManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.383 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.386 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.389 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.391 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.394 -0500", hash_original_method = "E9E2F907D96A6259126861462530DD30", hash_generated_method = "2BC8F75DA527CCEF36A6BA57BD3A4393")
            
public android.view.textservice.SpellCheckerInfo getCurrentSpellChecker(java.lang.String locale) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.view.textservice.SpellCheckerInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(locale);
mRemote.transact(Stub.TRANSACTION_getCurrentSpellChecker, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.view.textservice.SpellCheckerInfo.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.396 -0500", hash_original_method = "66EDCFEE66E59B401130A1F390C7D72A", hash_generated_method = "B45604AEF2CC84F47672E9995443C407")
            
public android.view.textservice.SpellCheckerSubtype getCurrentSpellCheckerSubtype(java.lang.String locale, boolean allowImplicitlySelectedSubtype) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.view.textservice.SpellCheckerSubtype _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(locale);
_data.writeInt(((allowImplicitlySelectedSubtype)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_getCurrentSpellCheckerSubtype, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.view.textservice.SpellCheckerSubtype.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.399 -0500", hash_original_method = "72CBEF1DB1631CDEC2BAEB5039D5A9E5", hash_generated_method = "87F9B71116617EC0F33210DCC8F5EFA4")
            
public void getSpellCheckerService(java.lang.String sciId, java.lang.String locale, com.android.internal.textservice.ITextServicesSessionListener tsListener, com.android.internal.textservice.ISpellCheckerSessionListener scListener, android.os.Bundle bundle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sciId);
_data.writeString(locale);
_data.writeStrongBinder((((tsListener!=null))?(tsListener.asBinder()):(null)));
_data.writeStrongBinder((((scListener!=null))?(scListener.asBinder()):(null)));
if ((bundle!=null)) {
_data.writeInt(1);
bundle.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getSpellCheckerService, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.402 -0500", hash_original_method = "CD7BF7EAC2CFA8B6528A649B2EFE66EA", hash_generated_method = "A1BA07BBA3C541DF986904B5699D0EE0")
            
public void finishSpellCheckerService(com.android.internal.textservice.ISpellCheckerSessionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_finishSpellCheckerService, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.405 -0500", hash_original_method = "EA6EF2DA921343BAE948E9A7113ACCC6", hash_generated_method = "8581F04164A02FDAA71F7321CA79E350")
            
public void setCurrentSpellChecker(java.lang.String locale, java.lang.String sciId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(locale);
_data.writeString(sciId);
mRemote.transact(Stub.TRANSACTION_setCurrentSpellChecker, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.407 -0500", hash_original_method = "C42B098AB5A1704018DF773B6E9E82C2", hash_generated_method = "4B4692FFD3387248D8B5D13864CA4BE1")
            
public void setCurrentSpellCheckerSubtype(java.lang.String locale, int hashCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(locale);
_data.writeInt(hashCode);
mRemote.transact(Stub.TRANSACTION_setCurrentSpellCheckerSubtype, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.410 -0500", hash_original_method = "CCEA883A3E8D3FCE2564D4FA50F9D044", hash_generated_method = "96E3563B63AFCB506461BB190FE45DDD")
            
public void setSpellCheckerEnabled(boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setSpellCheckerEnabled, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.413 -0500", hash_original_method = "10136E7111695018C5D024F6B47494D7", hash_generated_method = "14DB613281172B82F4CB30D8AE988BC7")
            
public boolean isSpellCheckerEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isSpellCheckerEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.421 -0500", hash_original_method = "05E66A3B75941E801798B518C613B457", hash_generated_method = "1C7C87DD71B43525901AB30B189CDE89")
            
public android.view.textservice.SpellCheckerInfo[] getEnabledSpellCheckers() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.view.textservice.SpellCheckerInfo[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getEnabledSpellCheckers, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.view.textservice.SpellCheckerInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.435 -0500", hash_original_field = "85D623E0F2A61E51CD7F4897FC2F4202", hash_generated_field = "AFAAA4EDDBE22C1B5B2FCF35AACDBBBF")

static final int TRANSACTION_finishSpellCheckerService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.437 -0500", hash_original_field = "5BEEB2DD2A20EBF8662075E4665B4126", hash_generated_field = "C65D42380B0A4440793668A2E55A67F4")

static final int TRANSACTION_setCurrentSpellChecker = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.439 -0500", hash_original_field = "70A2228F045608DA9F15C1BC0261553B", hash_generated_field = "97B6463AE19B7C93C0FF0257B06E2D3A")

static final int TRANSACTION_setCurrentSpellCheckerSubtype = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.442 -0500", hash_original_field = "47EFDE936119B80C9502D20EFEB3F432", hash_generated_field = "965F09241E45E48D8D8BB124AEB0014A")

static final int TRANSACTION_setSpellCheckerEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.444 -0500", hash_original_field = "A256DC89773CA6439933F247F0C5CFE2", hash_generated_field = "A07FD5597BEC74BED475DBEF0B38D1CB")

static final int TRANSACTION_isSpellCheckerEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.447 -0500", hash_original_field = "636CA28C2BCC4034F0DE0A860AD0A89E", hash_generated_field = "F8741C8F8E9243C44518CC607649471E")

static final int TRANSACTION_getEnabledSpellCheckers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.370 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.375 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.380 -0500", hash_original_method = "F809859DF57095AEB868C942DA4A6EB7", hash_generated_method = "9C3B666B98DCA3E6DCD932B55661EBB5")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getCurrentSpellChecker:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.view.textservice.SpellCheckerInfo _result = this.getCurrentSpellChecker(_arg0);
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
case TRANSACTION_getCurrentSpellCheckerSubtype:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
android.view.textservice.SpellCheckerSubtype _result = this.getCurrentSpellCheckerSubtype(_arg0, _arg1);
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
case TRANSACTION_getSpellCheckerService:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.android.internal.textservice.ITextServicesSessionListener _arg2;
_arg2 = com.android.internal.textservice.ITextServicesSessionListener.Stub.asInterface(data.readStrongBinder());
com.android.internal.textservice.ISpellCheckerSessionListener _arg3;
_arg3 = com.android.internal.textservice.ISpellCheckerSessionListener.Stub.asInterface(data.readStrongBinder());
android.os.Bundle _arg4;
if ((0!=data.readInt())) {
_arg4 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
this.getSpellCheckerService(_arg0, _arg1, _arg2, _arg3, _arg4);
return true;
}
case TRANSACTION_finishSpellCheckerService:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.textservice.ISpellCheckerSessionListener _arg0;
_arg0 = com.android.internal.textservice.ISpellCheckerSessionListener.Stub.asInterface(data.readStrongBinder());
this.finishSpellCheckerService(_arg0);
return true;
}
case TRANSACTION_setCurrentSpellChecker:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.setCurrentSpellChecker(_arg0, _arg1);
return true;
}
case TRANSACTION_setCurrentSpellCheckerSubtype:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.setCurrentSpellCheckerSubtype(_arg0, _arg1);
return true;
}
case TRANSACTION_setSpellCheckerEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setSpellCheckerEnabled(_arg0);
return true;
}
case TRANSACTION_isSpellCheckerEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isSpellCheckerEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getEnabledSpellCheckers:
{
data.enforceInterface(DESCRIPTOR);
android.view.textservice.SpellCheckerInfo[] _result = this.getEnabledSpellCheckers();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public android.view.textservice.SpellCheckerInfo getCurrentSpellChecker(java.lang.String locale) throws android.os.RemoteException;
public android.view.textservice.SpellCheckerSubtype getCurrentSpellCheckerSubtype(java.lang.String locale, boolean allowImplicitlySelectedSubtype) throws android.os.RemoteException;
public void getSpellCheckerService(java.lang.String sciId, java.lang.String locale, com.android.internal.textservice.ITextServicesSessionListener tsListener, com.android.internal.textservice.ISpellCheckerSessionListener scListener, android.os.Bundle bundle) throws android.os.RemoteException;
public void finishSpellCheckerService(com.android.internal.textservice.ISpellCheckerSessionListener listener) throws android.os.RemoteException;
public void setCurrentSpellChecker(java.lang.String locale, java.lang.String sciId) throws android.os.RemoteException;
public void setCurrentSpellCheckerSubtype(java.lang.String locale, int hashCode) throws android.os.RemoteException;
public void setSpellCheckerEnabled(boolean enabled) throws android.os.RemoteException;
public boolean isSpellCheckerEnabled() throws android.os.RemoteException;
public android.view.textservice.SpellCheckerInfo[] getEnabledSpellCheckers() throws android.os.RemoteException;
}
