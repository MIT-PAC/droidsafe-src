package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface INfcAdapterExtras extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.nfc.INfcAdapterExtras
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.580 -0500", hash_original_field = "1DC1272AE92C3084C330F15FD1487AEE", hash_generated_field = "E086B4DB198CA8AD75757A473F8279F2")

private static final java.lang.String DESCRIPTOR = "android.nfc.INfcAdapterExtras";
/**
 * Cast an IBinder object into an android.nfc.INfcAdapterExtras interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.585 -0500", hash_original_method = "65D4FE8D204F3123E94EAA8D619D0401", hash_generated_method = "BF8A32E0BC4D2A1F46AA657A34EFB091")
        
public static android.nfc.INfcAdapterExtras asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.nfc.INfcAdapterExtras))) {
return ((android.nfc.INfcAdapterExtras)iin);
}
return new android.nfc.INfcAdapterExtras.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.624 -0500", hash_original_field = "5759229C592FC14E357D14B4C89AC9A0", hash_generated_field = "09EA03F0C4FDF727C5BCAF1BAB89D4AA")

static final int TRANSACTION_open = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.627 -0500", hash_original_field = "29D27AA451269EB48A22559601F19E05", hash_generated_field = "82C82C3C0D133709083BBD2200A725CE")

static final int TRANSACTION_close = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.629 -0500", hash_original_field = "7D9DB588559A9AA8527DE4CF59CDC2C7", hash_generated_field = "3359D830F3E27991FAC684CC79FC7955")

static final int TRANSACTION_transceive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.nfc.INfcAdapterExtras
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.595 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.597 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.599 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.602 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.605 -0500", hash_original_method = "8CA8E7A428AE977A904F4441A385961C", hash_generated_method = "1CB06127BCE812DB6E4B47E06BED1905")
            
public android.os.Bundle open(java.lang.String pkg, android.os.IBinder b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Bundle _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeStrongBinder(b);
mRemote.transact(Stub.TRANSACTION_open, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.Bundle.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.608 -0500", hash_original_method = "03B909E67F124C7DBC455ED773561F63", hash_generated_method = "CDCECA0C2E1CB15DDC47A3332B921A8F")
            
public android.os.Bundle close(java.lang.String pkg, android.os.IBinder b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Bundle _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeStrongBinder(b);
mRemote.transact(Stub.TRANSACTION_close, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.Bundle.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.610 -0500", hash_original_method = "FC69E30FC5D4CC9EB9DDA7AF648F46CD", hash_generated_method = "1CBEC85DFE1F95779977D1B537C266F7")
            
public android.os.Bundle transceive(java.lang.String pkg, byte[] data_in) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Bundle _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeByteArray(data_in);
mRemote.transact(Stub.TRANSACTION_transceive, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.Bundle.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.613 -0500", hash_original_method = "4F82839D40ADF80D169D87FFD486DC8A", hash_generated_method = "9209A4D932D76F97AF982264717E1EF7")
            
public int getCardEmulationRoute(java.lang.String pkg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
mRemote.transact(Stub.TRANSACTION_getCardEmulationRoute, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.616 -0500", hash_original_method = "D3CFC82C8BBCECF42D26ED8FC11CC5D1", hash_generated_method = "D43C36989BCDE367AE8E54893D8C8DAE")
            
public void setCardEmulationRoute(java.lang.String pkg, int route) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeInt(route);
mRemote.transact(Stub.TRANSACTION_setCardEmulationRoute, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.618 -0500", hash_original_method = "ACB65093593AE31B8FA2F565E31DE8F0", hash_generated_method = "3EBEA2965C4C6A89B9021C8AC444C213")
            
public void authenticate(java.lang.String pkg, byte[] token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeByteArray(token);
mRemote.transact(Stub.TRANSACTION_authenticate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.632 -0500", hash_original_field = "C9565C8963D57A718BC77C5D7F8C4832", hash_generated_field = "921E2205906DDE3D05C33FDE1066F094")

static final int TRANSACTION_getCardEmulationRoute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.634 -0500", hash_original_field = "38E491A7DEBBEC84510F51C37701AF98", hash_generated_field = "CB35E6E585C908063CCA742F38DBA40C")

static final int TRANSACTION_setCardEmulationRoute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.636 -0500", hash_original_field = "41397D05B62EE904D78C7C15CAFE071B", hash_generated_field = "4000EAC78E5ACDAEACC1828D5F0FB31F")

static final int TRANSACTION_authenticate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.582 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NFC})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.588 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.NFC})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.591 -0500", hash_original_method = "43FE2A337D8D0168B5A31561A04826DF", hash_generated_method = "AEC5BE78745FF215A85033D6B65A6B7E")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_open:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
android.os.Bundle _result = this.open(_arg0, _arg1);
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
case TRANSACTION_close:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
android.os.Bundle _result = this.close(_arg0, _arg1);
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
case TRANSACTION_transceive:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
android.os.Bundle _result = this.transceive(_arg0, _arg1);
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
case TRANSACTION_getCardEmulationRoute:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getCardEmulationRoute(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setCardEmulationRoute:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.setCardEmulationRoute(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_authenticate:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
this.authenticate(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public android.os.Bundle open(java.lang.String pkg, android.os.IBinder b) throws android.os.RemoteException;
public android.os.Bundle close(java.lang.String pkg, android.os.IBinder b) throws android.os.RemoteException;
public android.os.Bundle transceive(java.lang.String pkg, byte[] data_in) throws android.os.RemoteException;
public int getCardEmulationRoute(java.lang.String pkg) throws android.os.RemoteException;
public void setCardEmulationRoute(java.lang.String pkg, int route) throws android.os.RemoteException;
public void authenticate(java.lang.String pkg, byte[] token) throws android.os.RemoteException;
}
