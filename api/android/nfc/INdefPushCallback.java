package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface INdefPushCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.nfc.INdefPushCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.309 -0500", hash_original_field = "CFCE59EABA7E5F57F22F2738E964BBB2", hash_generated_field = "B5F237FDB39FA48A71840DF35AA99B8F")

private static final java.lang.String DESCRIPTOR = "android.nfc.INdefPushCallback";
/**
 * Cast an IBinder object into an android.nfc.INdefPushCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.314 -0500", hash_original_method = "DAE01D1E9D0E07F18B38FF57C144AE06", hash_generated_method = "9F8BA463E30EBB2A232A8D4CDBF7AD63")
        
public static android.nfc.INdefPushCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.nfc.INdefPushCallback))) {
return ((android.nfc.INdefPushCallback)iin);
}
return new android.nfc.INdefPushCallback.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.341 -0500", hash_original_field = "DBC2978C840DBA190FAEBA46F7E79769", hash_generated_field = "60F27C02A785CDFE036DF05ED5B2BFD6")

static final int TRANSACTION_createMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.343 -0500", hash_original_field = "52E90F64ABC2BD5125CFDA92FAC7B98C", hash_generated_field = "A4896DD4591A7F5BD0CF058AF187502F")

static final int TRANSACTION_onNdefPushComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.312 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.nfc.INdefPushCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.323 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.326 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.328 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.331 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.333 -0500", hash_original_method = "C18221D5AA54CA68183EAF0C19ABDCA2", hash_generated_method = "E84795E5E1F2739407E027D8FC746E68")
            
public android.nfc.NdefMessage createMessage() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.nfc.NdefMessage _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_createMessage, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.nfc.NdefMessage.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.337 -0500", hash_original_method = "995C98957BB83FF3BBA62E4A1915C70A", hash_generated_method = "E197585FCEE10CF79B11CC88A2BAF5E6")
            
public void onNdefPushComplete() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onNdefPushComplete, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSSource({DSSourceKind.NFC})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.316 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.NFC})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.320 -0500", hash_original_method = "DD8886CE53239E22B63657BB18825424", hash_generated_method = "E3C56F90878525A3FB671613F40DC5D8")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_createMessage:
{
data.enforceInterface(DESCRIPTOR);
android.nfc.NdefMessage _result = this.createMessage();
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
case TRANSACTION_onNdefPushComplete:
{
data.enforceInterface(DESCRIPTOR);
this.onNdefPushComplete();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public android.nfc.NdefMessage createMessage() throws android.os.RemoteException;
public void onNdefPushComplete() throws android.os.RemoteException;
}
