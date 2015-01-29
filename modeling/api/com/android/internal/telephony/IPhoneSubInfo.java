package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IPhoneSubInfo extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.IPhoneSubInfo
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.171 -0500", hash_original_field = "69906E16D25AC896A152CC9B7E7E207E", hash_generated_field = "8ED1E18294A3301313957A470B20BC63")

private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.IPhoneSubInfo";
/**
 * Cast an IBinder object into an com.android.internal.telephony.IPhoneSubInfo interface,
 * generating a proxy if needed.
 */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.176 -0500", hash_original_method = "10BDF9FA5C8C3CD66DD32BC8788172C4", hash_generated_method = "77EB9ED3EF9994F138004C7DE0A0A940")
        
public static com.android.internal.telephony.IPhoneSubInfo asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.IPhoneSubInfo))) {
return ((com.android.internal.telephony.IPhoneSubInfo)iin);
}
return new com.android.internal.telephony.IPhoneSubInfo.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.238 -0500", hash_original_field = "07D90020540D8DD0E98A40C07B14BEA0", hash_generated_field = "1AB79C23CAAD69523572B4A5D7783B4E")

static final int TRANSACTION_getDeviceId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.240 -0500", hash_original_field = "2758922B112781AACEA531205206DF20", hash_generated_field = "E69F9336A0F6B9B5AABBDB5D58309E1D")

static final int TRANSACTION_getDeviceSvn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.243 -0500", hash_original_field = "B98797415F0446DFAB7F9192F83D4A8C", hash_generated_field = "70BF9F454CCDAC9690A6B8F950317E6C")

static final int TRANSACTION_getSubscriberId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.telephony.IPhoneSubInfo
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.187 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.189 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.192 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.194 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Retrieves the unique device ID, e.g., IMEI for GSM phones.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.196 -0500", hash_original_method = "65744AF5DBCE0B9D6D98059D1D3FAF66", hash_generated_method = "24384C238F2FEBED45639BD8F3ACB9E1")
            
public java.lang.String getDeviceId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDeviceId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the software version number for the device, e.g., IMEI/SV
     * for GSM phones.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.199 -0500", hash_original_method = "B79489F6155D0EA7CA2FD341614F611C", hash_generated_method = "0E3083E716F91C56916FB930D32BB0E4")
            
public java.lang.String getDeviceSvn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDeviceSvn, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the unique sbuscriber ID, e.g., IMSI for GSM phones.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.203 -0500", hash_original_method = "D5111E08142C3FDFF0A178F153D643B1", hash_generated_method = "29F7D0DBA3B9284E2E6546C43477CC97")
            
public java.lang.String getSubscriberId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSubscriberId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the serial number of the ICC, if applicable.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.206 -0500", hash_original_method = "EFE96A589FAB726A2DAC72FA60339D3E", hash_generated_method = "9C2582BD8689BDB40B5C3B49CB0F5944")
            
public java.lang.String getIccSerialNumber() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIccSerialNumber, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the phone number string for line 1.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.208 -0500", hash_original_method = "AF2DE59FB7AE604ED58655004545795B", hash_generated_method = "756DAD2458150A1DA5CFE879419D7E32")
            
public java.lang.String getLine1Number() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLine1Number, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the alpha identifier for line 1.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.211 -0500", hash_original_method = "157B837F1A43690F94312AB376F3D0AA", hash_generated_method = "FAD3E937BE248BB8FC962FB32B0B6538")
            
public java.lang.String getLine1AlphaTag() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLine1AlphaTag, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves MSISDN Number.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.214 -0500", hash_original_method = "467AF8F43FBF9FE6FC4330AC85227759", hash_generated_method = "2DC3C2255097724AF058B762EC2BBF41")
            
public java.lang.String getMsisdn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMsisdn, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the voice mail number.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.217 -0500", hash_original_method = "0F8B01FD42886F0F73AC0E3D3578DE6F", hash_generated_method = "D251A385BEC83BA37A0B9771D201936F")
            
public java.lang.String getVoiceMailNumber() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVoiceMailNumber, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the complete voice mail number.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.220 -0500", hash_original_method = "4035A12AB3A7C86C04A72003EAD769F5", hash_generated_method = "2CC1F6A9615867A8FC53FB2621407764")
            
public java.lang.String getCompleteVoiceMailNumber() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCompleteVoiceMailNumber, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the alpha identifier associated with the voice mail number.
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.222 -0500", hash_original_method = "E2A061D1660455865738FB6B9B2DE798", hash_generated_method = "5AC7AC52CF3D4BD85F38141E813E72C5")
            
public java.lang.String getVoiceMailAlphaTag() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVoiceMailAlphaTag, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Returns the IMS private user identity (IMPI) that was loaded from the ISIM.
     * @return the IMPI, or null if not present or not loaded
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.224 -0500", hash_original_method = "25FC15DEA5E6AC7E8B0567781EDDCD0A", hash_generated_method = "3B4E4546B111DB6AE7C9E6922AF3E34E")
            
public java.lang.String getIsimImpi() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIsimImpi, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Returns the IMS home network domain name that was loaded from the ISIM.
     * @return the IMS domain name, or null if not present or not loaded
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.227 -0500", hash_original_method = "F69E5EE22231791ABF991ACA52DE6C54", hash_generated_method = "F19CBCB260214D67BB206AD31D37A5E1")
            
public java.lang.String getIsimDomain() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIsimDomain, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Returns the IMS public user identities (IMPU) that were loaded from the ISIM.
     * @return an array of IMPU strings, with one IMPU per string, or null if
     *      not present or not loaded
     */
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.230 -0500", hash_original_method = "4ACFF3291EAA3DCDA25B98C23487474C", hash_generated_method = "82BB4A25FF6EE5ED812FCCEC980EE230")
            
public java.lang.String[] getIsimImpu() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIsimImpu, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.245 -0500", hash_original_field = "8AF21F8F2BB9E13C7A80FD245FA14189", hash_generated_field = "D806E854E061FC8F2398D8779A98766E")

static final int TRANSACTION_getIccSerialNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.248 -0500", hash_original_field = "74A0C7B42E7C4695E61195088DDCAA51", hash_generated_field = "1C84A9A8532ECA9A4D2EE2F3B9492DA4")

static final int TRANSACTION_getLine1Number = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.250 -0500", hash_original_field = "4790AE46E13CA77B53D0851BD97989CD", hash_generated_field = "9B78A402396A832431D011E22D590FE9")

static final int TRANSACTION_getLine1AlphaTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.253 -0500", hash_original_field = "2E9A8139FCF9D46815F2C4093CB37830", hash_generated_field = "A80C4361723447044687292034CA5EA7")

static final int TRANSACTION_getMsisdn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.255 -0500", hash_original_field = "A9BE4DB8B7B777446C103599F87380FA", hash_generated_field = "A7752480E66D88E3100F4D1916150337")

static final int TRANSACTION_getVoiceMailNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.258 -0500", hash_original_field = "A86061E959C93C162832CF4A4DE43553", hash_generated_field = "8AA97DD1952AFCD8D8F3981D031F0480")

static final int TRANSACTION_getCompleteVoiceMailNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.260 -0500", hash_original_field = "C680917929CE1BDA7F19BA027AD7A3F6", hash_generated_field = "D534A63524ACBF081779741D58613CF1")

static final int TRANSACTION_getVoiceMailAlphaTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.263 -0500", hash_original_field = "83638C7AB83B21C28B18ED7649A9ABDB", hash_generated_field = "385423E54EE28F4BBDB22CBEFD963D68")

static final int TRANSACTION_getIsimImpi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.265 -0500", hash_original_field = "9CF0F231524C2802EE1BFC32E5776BAA", hash_generated_field = "950D98CA0BC9EC1F616F3F0158A55205")

static final int TRANSACTION_getIsimDomain = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.268 -0500", hash_original_field = "9674185F5CFB03E037E72EC4364FA9B4", hash_generated_field = "B86E955F3F9F5BD955DEC0B497F99C0B")

static final int TRANSACTION_getIsimImpu = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.174 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.179 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:18.183 -0500", hash_original_method = "9FB24A2883B5E6DEC4D7829EC0E441D5", hash_generated_method = "D0D42539781F44CC6585FA6F1F8FB2E5")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getDeviceId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDeviceId();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getDeviceSvn:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDeviceSvn();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getSubscriberId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getSubscriberId();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getIccSerialNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getIccSerialNumber();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getLine1Number:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getLine1Number();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getLine1AlphaTag:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getLine1AlphaTag();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getMsisdn:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getMsisdn();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getVoiceMailNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getVoiceMailNumber();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getCompleteVoiceMailNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCompleteVoiceMailNumber();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getVoiceMailAlphaTag:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getVoiceMailAlphaTag();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getIsimImpi:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getIsimImpi();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getIsimDomain:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getIsimDomain();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getIsimImpu:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getIsimImpu();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public java.lang.String getDeviceId() throws android.os.RemoteException;

public java.lang.String getDeviceSvn() throws android.os.RemoteException;

public java.lang.String getSubscriberId() throws android.os.RemoteException;

public java.lang.String getIccSerialNumber() throws android.os.RemoteException;

public java.lang.String getLine1Number() throws android.os.RemoteException;

public java.lang.String getLine1AlphaTag() throws android.os.RemoteException;

public java.lang.String getMsisdn() throws android.os.RemoteException;

public java.lang.String getVoiceMailNumber() throws android.os.RemoteException;

public java.lang.String getCompleteVoiceMailNumber() throws android.os.RemoteException;

public java.lang.String getVoiceMailAlphaTag() throws android.os.RemoteException;

public java.lang.String getIsimImpi() throws android.os.RemoteException;

public java.lang.String getIsimDomain() throws android.os.RemoteException;

public java.lang.String[] getIsimImpu() throws android.os.RemoteException;
}
