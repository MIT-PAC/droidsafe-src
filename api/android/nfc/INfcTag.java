package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface INfcTag extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.nfc.INfcTag
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.641 -0500", hash_original_field = "0C411F7941A2D8410830E064D70F9FE1", hash_generated_field = "1511C770B2174BBEFB4ED0BD7D640458")

private static final java.lang.String DESCRIPTOR = "android.nfc.INfcTag";
/**
 * Cast an IBinder object into an android.nfc.INfcTag interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.646 -0500", hash_original_method = "0FEC4370388DE045A974C05A11289A61", hash_generated_method = "0ED5773BB9FB8823FA43E28EB260943D")
        
public static android.nfc.INfcTag asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.nfc.INfcTag))) {
return ((android.nfc.INfcTag)iin);
}
return new android.nfc.INfcTag.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.728 -0500", hash_original_field = "2AB3C4E1400B740493E5B9117089583B", hash_generated_field = "381C05C25261C1AC7EA0ACC294609467")

static final int TRANSACTION_close = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.730 -0500", hash_original_field = "2AFD2BE0153841FF92DDCD283CDAAF66", hash_generated_field = "AFBA074CD6009C5B32DE8C78DECDDA6F")

static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.733 -0500", hash_original_field = "3C41AC03D582BFE623632FC387E4FDE5", hash_generated_field = "93EBD91F2E9CD213696203030495104F")

static final int TRANSACTION_reconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.nfc.INfcTag
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.657 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.660 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.662 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.665 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.667 -0500", hash_original_method = "F249DAE7AA273F52F293E5540E1015B8", hash_generated_method = "79BD3BE70462A86FDF769576A88280B2")
            
public int close(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_close, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.670 -0500", hash_original_method = "E41A918861346848830C958DEC18C336", hash_generated_method = "9BACF9503B29B78237008EC1AE600D17")
            
public int connect(int nativeHandle, int technology) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
_data.writeInt(technology);
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.673 -0500", hash_original_method = "66BD267405149A0BED0799EF7D46F58E", hash_generated_method = "F5B7AD647B551DA3559222B547E2D940")
            
public int reconnect(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_reconnect, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.676 -0500", hash_original_method = "290237D5F757E3F8B947D7D8C8A66959", hash_generated_method = "24A7118AC54F2DD475E80512C9D460F1")
            
public int[] getTechList(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_getTechList, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.679 -0500", hash_original_method = "38E81ABE3DF3668240FDDF9C12C2BA01", hash_generated_method = "B633CAB099E4FE295BB8FC6D9E60A86D")
            
public byte[] getUid(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_getUid, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.681 -0500", hash_original_method = "BA755BBCDD4D48CA7E56187BB15D9F1A", hash_generated_method = "1659A3DD6FCB5808AD5BF3DBE4528B8B")
            
public boolean isNdef(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_isNdef, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.684 -0500", hash_original_method = "7B49AC2CFC2F95FB2EC463E219CD4FC1", hash_generated_method = "15F5663C5F8A0E47EC9F333BE7501A40")
            
public boolean isPresent(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_isPresent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.687 -0500", hash_original_method = "EC9298AC762C356AF6A942EEED7A8515", hash_generated_method = "0FF57B1E6C3B7D60E5B1F35E4AD4F762")
            
public android.nfc.TransceiveResult transceive(int nativeHandle, byte[] data, boolean raw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.nfc.TransceiveResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
_data.writeByteArray(data);
_data.writeInt(((raw)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_transceive, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.nfc.TransceiveResult.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.689 -0500", hash_original_method = "6CDCC8B5307F416D8C4C619B19B4810C", hash_generated_method = "7931CE44C445DCBC7F4AE706D39FA00D")
            
public int getLastError(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_getLastError, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.692 -0500", hash_original_method = "7F86138D9B4D33111EDF3E6829174E5A", hash_generated_method = "7304606DFFAE355BCE198F91A47456FE")
            
public android.nfc.NdefMessage ndefRead(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.nfc.NdefMessage _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_ndefRead, _data, _reply, 0);
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
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.696 -0500", hash_original_method = "830B9D48EB1B5E9BA0162311D6556148", hash_generated_method = "6491E6F2B4AA44F03C753D17419F3BC0")
            
public int ndefWrite(int nativeHandle, android.nfc.NdefMessage msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
if ((msg!=null)) {
_data.writeInt(1);
msg.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_ndefWrite, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.698 -0500", hash_original_method = "D5DE743DC973C85B2CFD6B25A20C316A", hash_generated_method = "DD014A96446BC709EAEA60EC4B91AD8C")
            
public int ndefMakeReadOnly(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_ndefMakeReadOnly, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.701 -0500", hash_original_method = "C8F2F9938FEC27B4D5552A7A93850C66", hash_generated_method = "7955A9B2CFBD60DA0081D1EF0FDBB3D1")
            
public boolean ndefIsWritable(int nativeHandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
mRemote.transact(Stub.TRANSACTION_ndefIsWritable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.704 -0500", hash_original_method = "5BDC99DDE1322A3E53C4872F49C79898", hash_generated_method = "50B31613B8D20F0B7061084DC68B1E40")
            
public int formatNdef(int nativeHandle, byte[] key) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativeHandle);
_data.writeByteArray(key);
mRemote.transact(Stub.TRANSACTION_formatNdef, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.707 -0500", hash_original_method = "9D906DAA11C565AD566BB27A04C2B396", hash_generated_method = "0F0434EE51CCBD6EF5C360BD0B81D8F2")
            
public android.nfc.Tag rediscover(int nativehandle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.nfc.Tag _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nativehandle);
mRemote.transact(Stub.TRANSACTION_rediscover, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.nfc.Tag.CREATOR.createFromParcel(_reply);
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
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.710 -0500", hash_original_method = "739D29510EC5D9319567AF1A74EA5BE3", hash_generated_method = "0EA56D7AE66921D8DA5A4A31942135BB")
            
public int setTimeout(int technology, int timeout) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(technology);
_data.writeInt(timeout);
mRemote.transact(Stub.TRANSACTION_setTimeout, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.712 -0500", hash_original_method = "BFEB96D45B45315FF3FBC053A7422D64", hash_generated_method = "E293EC7DC2808BE0C413A583B0D640A3")
            
public int getTimeout(int technology) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(technology);
mRemote.transact(Stub.TRANSACTION_getTimeout, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.715 -0500", hash_original_method = "F09E572C85935F35FADB1B0D1B499C45", hash_generated_method = "63732B0E353565AD1EA56FA9B33076C7")
            
public void resetTimeouts() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_resetTimeouts, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NFC})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.718 -0500", hash_original_method = "ABC4FF8DE79B1FF5CD9512E1FC3564DF", hash_generated_method = "C16F42892AF4069FB2917B6AC1683353")
            
public boolean canMakeReadOnly(int ndefType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(ndefType);
mRemote.transact(Stub.TRANSACTION_canMakeReadOnly, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.720 -0500", hash_original_method = "C32BD00384E94164C88AF022F68DEB95", hash_generated_method = "A58381B277571D3DF744D3B0174A1CC0")
            
public int getMaxTransceiveLength(int technology) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(technology);
mRemote.transact(Stub.TRANSACTION_getMaxTransceiveLength, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.735 -0500", hash_original_field = "043675A89843964CF993906752174123", hash_generated_field = "AAC09B604EF9A610F26FB0F3888E1BDF")

static final int TRANSACTION_getTechList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.737 -0500", hash_original_field = "4DF3E87DE2A3DF89CC6482335CA42130", hash_generated_field = "5887C493374943FA41FBAAF3F72644DA")

static final int TRANSACTION_getUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.740 -0500", hash_original_field = "0255537769869C1F5E7F0FEDDDC94AFD", hash_generated_field = "0A5C637EFC44461305729237B04E980C")

static final int TRANSACTION_isNdef = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.743 -0500", hash_original_field = "EBE0E05AFA2898E54A6CE42E0232800F", hash_generated_field = "90DC6B70389AD4EC280290A50262F4F3")

static final int TRANSACTION_isPresent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.745 -0500", hash_original_field = "BC4B96D63AB5D305EB049B8BA51A86D6", hash_generated_field = "B022FBD047E76551DC2A62D67CE38777")

static final int TRANSACTION_transceive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.748 -0500", hash_original_field = "3EB879A3F27501434E930FC85AF443D4", hash_generated_field = "4C8C830930C54DDC599B9ED0CF878B07")

static final int TRANSACTION_getLastError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.751 -0500", hash_original_field = "8E7838EE2F4B93995FA0796C62A5B08B", hash_generated_field = "3D493A4FB81E97E6ED83DDD2082D56C0")

static final int TRANSACTION_ndefRead = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.753 -0500", hash_original_field = "86C773538C3495BEA66C4BA30648158E", hash_generated_field = "944D15365B52C6D7E93DA4716DD2A7F2")

static final int TRANSACTION_ndefWrite = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.756 -0500", hash_original_field = "28B7C054ED894AEB7E0F7A8F4F930766", hash_generated_field = "B53F7A7F0408CCEC071831A6983044F0")

static final int TRANSACTION_ndefMakeReadOnly = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.758 -0500", hash_original_field = "CD2790614A992A9DF3F1A189E43D8133", hash_generated_field = "690342D60F0AE0E0A723410E3DEADF49")

static final int TRANSACTION_ndefIsWritable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.761 -0500", hash_original_field = "7EF5808A41DA61D6F94014CEB86EE065", hash_generated_field = "00145229B8138A4DD4CDE14088E9416E")

static final int TRANSACTION_formatNdef = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.763 -0500", hash_original_field = "40A6B2D84D3DA0D7B48549B1CF590023", hash_generated_field = "5697CCA693E12A96D2B98EBDCC398095")

static final int TRANSACTION_rediscover = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.765 -0500", hash_original_field = "AEFC1258FC2BEE85CFE3959E1D9BDED4", hash_generated_field = "606BA8960B8C7857BCD0AE08088E2568")

static final int TRANSACTION_setTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.768 -0500", hash_original_field = "E76181328B35CD1207E3AFF691B5B234", hash_generated_field = "7EC7714906E935109120FBF24FB35F22")

static final int TRANSACTION_getTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.771 -0500", hash_original_field = "F92EB4B4008620534A49272B063F6B70", hash_generated_field = "30A93AEB386C0D77D01BC1D9669047B7")

static final int TRANSACTION_resetTimeouts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.773 -0500", hash_original_field = "D1A96EAF044380C052E14E9272A2BA77", hash_generated_field = "59CFB5CB120822D4038F0BD1C1D40738")

static final int TRANSACTION_canMakeReadOnly = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.776 -0500", hash_original_field = "4DEF85DCABD00E7802E813E68271FDE5", hash_generated_field = "299877FB86A685A61439D19FB65CA98B")

static final int TRANSACTION_getMaxTransceiveLength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.643 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.648 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.NFC})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:51.654 -0500", hash_original_method = "08DD9852BED4609CDF9A0EDAFEDBBB9E", hash_generated_method = "DF4751ABD70A7BDF2A8434109062D4AD")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_close:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.close(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.connect(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_reconnect:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.reconnect(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getTechList:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int[] _result = this.getTechList(_arg0);
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
case TRANSACTION_getUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _result = this.getUid(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_isNdef:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.isNdef(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isPresent:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.isPresent(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_transceive:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _arg1;
_arg1 = data.createByteArray();
boolean _arg2;
_arg2 = (0!=data.readInt());
android.nfc.TransceiveResult _result = this.transceive(_arg0, _arg1, _arg2);
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
case TRANSACTION_getLastError:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getLastError(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_ndefRead:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.nfc.NdefMessage _result = this.ndefRead(_arg0);
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
case TRANSACTION_ndefWrite:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.nfc.NdefMessage _arg1;
if ((0!=data.readInt())) {
_arg1 = android.nfc.NdefMessage.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _result = this.ndefWrite(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_ndefMakeReadOnly:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.ndefMakeReadOnly(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_ndefIsWritable:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.ndefIsWritable(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_formatNdef:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _arg1;
_arg1 = data.createByteArray();
int _result = this.formatNdef(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_rediscover:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.nfc.Tag _result = this.rediscover(_arg0);
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
case TRANSACTION_setTimeout:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.setTimeout(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getTimeout:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getTimeout(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_resetTimeouts:
{
data.enforceInterface(DESCRIPTOR);
this.resetTimeouts();
reply.writeNoException();
return true;
}
case TRANSACTION_canMakeReadOnly:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.canMakeReadOnly(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getMaxTransceiveLength:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getMaxTransceiveLength(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public int close(int nativeHandle) throws android.os.RemoteException;
public int connect(int nativeHandle, int technology) throws android.os.RemoteException;
public int reconnect(int nativeHandle) throws android.os.RemoteException;
public int[] getTechList(int nativeHandle) throws android.os.RemoteException;
public byte[] getUid(int nativeHandle) throws android.os.RemoteException;
public boolean isNdef(int nativeHandle) throws android.os.RemoteException;
public boolean isPresent(int nativeHandle) throws android.os.RemoteException;
public android.nfc.TransceiveResult transceive(int nativeHandle, byte[] data, boolean raw) throws android.os.RemoteException;
public int getLastError(int nativeHandle) throws android.os.RemoteException;
public android.nfc.NdefMessage ndefRead(int nativeHandle) throws android.os.RemoteException;
public int ndefWrite(int nativeHandle, android.nfc.NdefMessage msg) throws android.os.RemoteException;
public int ndefMakeReadOnly(int nativeHandle) throws android.os.RemoteException;
public boolean ndefIsWritable(int nativeHandle) throws android.os.RemoteException;
public int formatNdef(int nativeHandle, byte[] key) throws android.os.RemoteException;
public android.nfc.Tag rediscover(int nativehandle) throws android.os.RemoteException;
public int setTimeout(int technology, int timeout) throws android.os.RemoteException;
public int getTimeout(int technology) throws android.os.RemoteException;
public void resetTimeouts() throws android.os.RemoteException;
public boolean canMakeReadOnly(int ndefType) throws android.os.RemoteException;
public int getMaxTransceiveLength(int technology) throws android.os.RemoteException;
}
