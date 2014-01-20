package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IBluetooth extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.bluetooth.IBluetooth
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.484 -0500", hash_original_field = "D582D83CABA0C10757B4C25B6AC1B2D0", hash_generated_field = "C4915575E75E552CAFEA0338F602408C")

private static final java.lang.String DESCRIPTOR = "android.bluetooth.IBluetooth";
/**
 * Cast an IBinder object into an android.bluetooth.IBluetooth interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.489 -0500", hash_original_method = "7300648CA1549130C106A4B7C9E18C4B", hash_generated_method = "F532C970D0737F221414707D3BCBBD17")
        
public static android.bluetooth.IBluetooth asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.bluetooth.IBluetooth))) {
return ((android.bluetooth.IBluetooth)iin);
}
return new android.bluetooth.IBluetooth.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.733 -0500", hash_original_field = "4B52FDA37ECD613794770ABB0B730C3F", hash_generated_field = "B676559B3BAE123F870DCB9FDE40C575")

static final int TRANSACTION_isEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.735 -0500", hash_original_field = "8A510A76EFA229A867CDA7CBBC99F2C0", hash_generated_field = "CC0EF1706A70AA30A183A61473774287")

static final int TRANSACTION_getBluetoothState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.737 -0500", hash_original_field = "34D8BF28B62CB8362469DF22C720BC66", hash_generated_field = "97F7B5CDF0DD083E4F569FBCE1089400")

static final int TRANSACTION_enable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.bluetooth.IBluetooth
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.512 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.514 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.516 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.518 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.522 -0500", hash_original_method = "10F543ED6E4352AB9E077E862EC2BEAB", hash_generated_method = "5DCABE1E3F2C9A616AA1DBED82AA7A9E")
            
public boolean isEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.524 -0500", hash_original_method = "48AF69006EF9D232A152593D37E31B9F", hash_generated_method = "629CBA62B3216951A669E9C66716AD65")
            
public int getBluetoothState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBluetoothState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.527 -0500", hash_original_method = "E176D54325F4FAFD3800D4282E32E90B", hash_generated_method = "4F1C5D253A6C2E9510E283D9D9BF4B47")
            
public boolean enable() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_enable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.529 -0500", hash_original_method = "FC284B931B539DE929896E3FEED18D07", hash_generated_method = "A2D974F11DBCDA509484E502BCF089ED")
            
public boolean disable(boolean persistSetting) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((persistSetting)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_disable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.532 -0500", hash_original_method = "2B6D7896390E0E591A4D24FED4FCDDCD", hash_generated_method = "E1F6CB617432FE2B9BF8B49A3D3C07AE")
            
public java.lang.String getAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.535 -0500", hash_original_method = "A67828AD51D979CC6F8946A01285E84F", hash_generated_method = "25DAF405E323107535B9AE95A16E9694")
            
public java.lang.String getName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.BLUETOOTH})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.537 -0500", hash_original_method = "5F60C5D3E1D6DB9F3BBDADFC34A5203D", hash_generated_method = "C4C1058D0D2B768E48BC3D30871BACCE")
            
public boolean setName(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_setName, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.540 -0500", hash_original_method = "6B348B78D645B1D6FD4755C05799839B", hash_generated_method = "BE54EF7317507BF019486008D151B3FC")
            
public android.os.ParcelUuid[] getUuids() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelUuid[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getUuids, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.os.ParcelUuid.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.543 -0500", hash_original_method = "BED317E54AA36D826AA486D7B3FE1704", hash_generated_method = "4A601F8D21E067216E97FE006E21B4EC")
            
public int getScanMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getScanMode, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.BLUETOOTH})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.546 -0500", hash_original_method = "3AF4D809408DDF569F94C16D239D69B2", hash_generated_method = "2944DDC99F94B54093FCDD2A084FBF8C")
            
public boolean setScanMode(int mode, int duration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mode);
_data.writeInt(duration);
mRemote.transact(Stub.TRANSACTION_setScanMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.548 -0500", hash_original_method = "1ABD785BBAEC60CBDB187114D2CFC410", hash_generated_method = "60FC0FEC66519202A44A32D83E04F19C")
            
public int getDiscoverableTimeout() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDiscoverableTimeout, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.BLUETOOTH})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.551 -0500", hash_original_method = "602003EEDCB0463F9E8AB0F0BA8D1DBE", hash_generated_method = "39821C8AB624B956ABEF5FF2047011BA")
            
public boolean setDiscoverableTimeout(int timeout) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(timeout);
mRemote.transact(Stub.TRANSACTION_setDiscoverableTimeout, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.554 -0500", hash_original_method = "D35330977288805B8EFFA891898F0EE7", hash_generated_method = "9CDB46D2FDA05D930A88626565232509")
            
public boolean startDiscovery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startDiscovery, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.556 -0500", hash_original_method = "BF89D6E5A78BAB777540A24896549BE2", hash_generated_method = "271E7A29D5D7AC76DF2B4926D60C0BB8")
            
public boolean cancelDiscovery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_cancelDiscovery, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.558 -0500", hash_original_method = "A4D644A05A15D6C9EF86DDCFE8D1FC84", hash_generated_method = "0382D0FE89C383D4E6E9BC2C2B7BA112")
            
public boolean isDiscovering() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isDiscovering, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.561 -0500", hash_original_method = "D1DC87181CAAE6B31D5F20E5B3D267F5", hash_generated_method = "FE2F84746D2A9922349DF3833B634009")
            
public byte[] readOutOfBandData() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_readOutOfBandData, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.563 -0500", hash_original_method = "5AA710B1CBDAA77C26BE243C8B5F50D5", hash_generated_method = "6145EFEC4947B21D6A3FD5707BC4A221")
            
public int getAdapterConnectionState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAdapterConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.566 -0500", hash_original_method = "29BFD22E3A57E196A17CAB6325A68CDB", hash_generated_method = "0FA3CCE9ACC1972E194B85FBC4335540")
            
public int getProfileConnectionState(int profile) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(profile);
mRemote.transact(Stub.TRANSACTION_getProfileConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.569 -0500", hash_original_method = "D13A123B0BEBA1D390E7868FDD879E16", hash_generated_method = "04A42EF0407B0D9338998AB0238FF138")
            
public boolean changeApplicationBluetoothState(boolean on, android.bluetooth.IBluetoothStateChangeCallback callback, android.os.IBinder b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((on)?(1):(0)));
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeStrongBinder(b);
mRemote.transact(Stub.TRANSACTION_changeApplicationBluetoothState, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.572 -0500", hash_original_method = "34BCA116E3278F9283E383C53778CF1D", hash_generated_method = "E64F5FD62F95C7D1E11F03B418D58213")
            
public boolean createBond(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_createBond, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.575 -0500", hash_original_method = "A1E41A2889E279916D013A0F11925F2A", hash_generated_method = "93152E69A5A10FB30981C64224C308B3")
            
public boolean createBondOutOfBand(java.lang.String address, byte[] hash, byte[] randomizer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeByteArray(hash);
_data.writeByteArray(randomizer);
mRemote.transact(Stub.TRANSACTION_createBondOutOfBand, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.578 -0500", hash_original_method = "A3E921CEE4207FC2311A31B7D64EF3C9", hash_generated_method = "241C39D9173F8E35FBABAB521B144C70")
            
public boolean cancelBondProcess(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_cancelBondProcess, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.580 -0500", hash_original_method = "171546B024C74DF21A07B5CF852E5F58", hash_generated_method = "882A806E334E8CEF0DE9D97E81546E00")
            
public boolean removeBond(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_removeBond, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.583 -0500", hash_original_method = "8548F7AB6FAF3F18086472F5BDDA4387", hash_generated_method = "4A23B115E7ECC2BEDBC39441D948F533")
            
public java.lang.String[] listBonds() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_listBonds, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.586 -0500", hash_original_method = "BA978B5482696F6E67EA0C1068137B6F", hash_generated_method = "E3EC76A2201D769BD0072A02085E4DE5")
            
public int getBondState(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getBondState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.588 -0500", hash_original_method = "2092EB4305FDD761CF99528D8323798E", hash_generated_method = "F5EE5DA881D14EDB310F5A89F6C21207")
            
public boolean setDeviceOutOfBandData(java.lang.String address, byte[] hash, byte[] randomizer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeByteArray(hash);
_data.writeByteArray(randomizer);
mRemote.transact(Stub.TRANSACTION_setDeviceOutOfBandData, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.591 -0500", hash_original_method = "4F3CB5C2DF811CED8BECC61FB94AF81C", hash_generated_method = "BB324A7E3BCBB72AEF98A0C72D3341BC")
            
public java.lang.String getRemoteName(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getRemoteName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.594 -0500", hash_original_method = "3FAD35930FEA91DCCE4FDE77376615CA", hash_generated_method = "74775A26D663F069DBD52D88CE97EB3C")
            
public java.lang.String getRemoteAlias(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getRemoteAlias, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.597 -0500", hash_original_method = "94462DDA66C3B1C7AA493E3D965A2C4E", hash_generated_method = "194C835E889BC57316DDFEF997A8A189")
            
public boolean setRemoteAlias(java.lang.String address, java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_setRemoteAlias, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.599 -0500", hash_original_method = "65E2E7470D0C16BC25F7FE8012DC76F8", hash_generated_method = "29DBEBE19427AEA49A3FCE8590EDBE59")
            
public int getRemoteClass(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getRemoteClass, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.602 -0500", hash_original_method = "1F7BF9B5A425141717533FB72F551E5C", hash_generated_method = "14628E3A2D284689CF0D67F4EE5EA2A1")
            
public android.os.ParcelUuid[] getRemoteUuids(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelUuid[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getRemoteUuids, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.os.ParcelUuid.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.604 -0500", hash_original_method = "F0CC58CC96F73A9D12FE45A5CFDABE5A", hash_generated_method = "FABA75459C148EA8FABF4796B3B23468")
            
public boolean fetchRemoteUuids(java.lang.String address, android.os.ParcelUuid uuid, android.bluetooth.IBluetoothCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
if ((uuid!=null)) {
_data.writeInt(1);
uuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_fetchRemoteUuids, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.607 -0500", hash_original_method = "5044B18B433FE920D4206FD2C771B2CC", hash_generated_method = "8B2115E4C2B82DFA170732BC0A7217B4")
            
public int getRemoteServiceChannel(java.lang.String address, android.os.ParcelUuid uuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
if ((uuid!=null)) {
_data.writeInt(1);
uuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getRemoteServiceChannel, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.610 -0500", hash_original_method = "41ECACEC34BBCDFFD5A423C8054F47C5", hash_generated_method = "FBC6B17476BA8DEBBF1C94DFA43385DD")
            
public boolean setPin(java.lang.String address, byte[] pin) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeByteArray(pin);
mRemote.transact(Stub.TRANSACTION_setPin, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.613 -0500", hash_original_method = "C51064B962F39B6632BEB588D33FC3CA", hash_generated_method = "63B94F6B4F97CE1D0C7C2C8DD4BE8F32")
            
public boolean setPasskey(java.lang.String address, int passkey) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(passkey);
mRemote.transact(Stub.TRANSACTION_setPasskey, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.616 -0500", hash_original_method = "8BDFED9B9EEAAEEFD1E6850726994525", hash_generated_method = "05C929ACFD471656962CF5B923F156E7")
            
public boolean setPairingConfirmation(java.lang.String address, boolean confirm) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((confirm)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setPairingConfirmation, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.619 -0500", hash_original_method = "8AB859E62C62993A90A8F87EF5C3F3CF", hash_generated_method = "B1BEF82E7C91EA4056BE160DC1F3E131")
            
public boolean setRemoteOutOfBandData(java.lang.String addres) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addres);
mRemote.transact(Stub.TRANSACTION_setRemoteOutOfBandData, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.621 -0500", hash_original_method = "7977B3403CA4E5C6D5AEC9564E9DA58E", hash_generated_method = "4CF58B3BBACC2D3A80C145996EE2F320")
            
public boolean cancelPairingUserInput(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_cancelPairingUserInput, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.624 -0500", hash_original_method = "F5E6F92EF5FEF7F5B7CD98CE10BB6B5F", hash_generated_method = "C49CE0D3D6ABF64F06C2C9A656BC78B8")
            
public boolean setTrust(java.lang.String address, boolean value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((value)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setTrust, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.626 -0500", hash_original_method = "C6DB75101BE98A4A505CA59E5A1E2D61", hash_generated_method = "9A83D0268CBEE7B4F40CA5D22278DAB1")
            
public boolean getTrustState(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getTrustState, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.629 -0500", hash_original_method = "396E47D8B754CF23DB296894C49D916B", hash_generated_method = "B4744F24C4A0F2324151202DD5202160")
            
public boolean isBluetoothDock(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_isBluetoothDock, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.632 -0500", hash_original_method = "C88539BCAC4DC0B8E6F0AAA83278A217", hash_generated_method = "806491FDBC19885743B99E1A90B0A2AD")
            
public int addRfcommServiceRecord(java.lang.String serviceName, android.os.ParcelUuid uuid, int channel, android.os.IBinder b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(serviceName);
if ((uuid!=null)) {
_data.writeInt(1);
uuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(channel);
_data.writeStrongBinder(b);
mRemote.transact(Stub.TRANSACTION_addRfcommServiceRecord, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.634 -0500", hash_original_method = "A910DD9A828102FF1BC25959E498F648", hash_generated_method = "FDCCD4443FEC6F926A9C4A59DD361EBC")
            
public void removeServiceRecord(int handle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(handle);
mRemote.transact(Stub.TRANSACTION_removeServiceRecord, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.637 -0500", hash_original_method = "588AF0C6F4A1FC837F732DF445EC44BD", hash_generated_method = "9096D802113271CDBC1BCFD820FFB7B1")
            
public boolean allowIncomingProfileConnect(android.bluetooth.BluetoothDevice device, boolean value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((value)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_allowIncomingProfileConnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.640 -0500", hash_original_method = "98AAF9DF2D6E21256E484154B42F9D8D", hash_generated_method = "81411104360256309B5B8F4E8519F80A")
            
public boolean connectHeadset(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_connectHeadset, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.643 -0500", hash_original_method = "C96062571BB7AFCB8EA6558EB61131A8", hash_generated_method = "6633AC9933274A739C56B67F0DB23069")
            
public boolean disconnectHeadset(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_disconnectHeadset, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.646 -0500", hash_original_method = "0D5DA4068B8342E29514B00D615691CC", hash_generated_method = "A26C96AD6ED73EFFE94D40727E0660E9")
            
public boolean notifyIncomingConnection(java.lang.String address, boolean rejected) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((rejected)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_notifyIncomingConnection, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// HID profile APIs

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.648 -0500", hash_original_method = "4681625AEAF2EB1CD2080FF50C7F303F", hash_generated_method = "1CAD9409513A60B76608002C67BA7312")
            
public boolean connectInputDevice(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_connectInputDevice, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.651 -0500", hash_original_method = "D3F089F1826DD7B38093EB4F53429ED9", hash_generated_method = "C83ED35D23968A50A579272EADD461F9")
            
public boolean disconnectInputDevice(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_disconnectInputDevice, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.653 -0500", hash_original_method = "EA2CE187F1974733CFA3E8EDE33B8435", hash_generated_method = "149440B82A02EFFEC708E8A33D990937")
            
public java.util.List<android.bluetooth.BluetoothDevice> getConnectedInputDevices() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.bluetooth.BluetoothDevice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConnectedInputDevices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.bluetooth.BluetoothDevice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.657 -0500", hash_original_method = "7FC0336E7A9F57B70C21E0A4D2870D91", hash_generated_method = "3D91DA83467454D7F9793B0B2FFDCDEE")
            
public java.util.List<android.bluetooth.BluetoothDevice> getInputDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.bluetooth.BluetoothDevice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(states);
mRemote.transact(Stub.TRANSACTION_getInputDevicesMatchingConnectionStates, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.bluetooth.BluetoothDevice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.659 -0500", hash_original_method = "D80E305923C8FABE4A8A36C99CB945CA", hash_generated_method = "EB23A5032F8DF4345BA0AB5A4600FC52")
            
public int getInputDeviceConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getInputDeviceConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.662 -0500", hash_original_method = "0B8C0425C3CBB97763F7C1AACF89E7B7", hash_generated_method = "5CA421963CDC5186A769F5DD75D78C08")
            
public boolean setInputDevicePriority(android.bluetooth.BluetoothDevice device, int priority) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(priority);
mRemote.transact(Stub.TRANSACTION_setInputDevicePriority, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.665 -0500", hash_original_method = "51B63CCB5B9B2127BB343AF7FDA4FD7B", hash_generated_method = "69A051FDCAC3712ED4D1B57F85B4A51B")
            
public int getInputDevicePriority(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getInputDevicePriority, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.667 -0500", hash_original_method = "53268C8FBE704A8B49CA77CB6E94C0EC", hash_generated_method = "D481E4230B4C1BF94C3B6D85BB85CD4B")
            
public boolean isTetheringOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isTetheringOn, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.670 -0500", hash_original_method = "806E083BBB64050F71B72171779D71E7", hash_generated_method = "4B296BD9D303B253C3D433C89BFD86A2")
            
public void setBluetoothTethering(boolean value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((value)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setBluetoothTethering, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.673 -0500", hash_original_method = "A32B4CD7581C69C43940EFD8964DB023", hash_generated_method = "D6F2535057C808D71BE9244BF6954E80")
            
public int getPanDeviceConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPanDeviceConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.676 -0500", hash_original_method = "3DA5F91642C9D9E4F860AB2EBE5066F1", hash_generated_method = "CA37FD9AE62233C84C3B1B74D2E40A64")
            
public java.util.List<android.bluetooth.BluetoothDevice> getConnectedPanDevices() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.bluetooth.BluetoothDevice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConnectedPanDevices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.bluetooth.BluetoothDevice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.678 -0500", hash_original_method = "AC14B6D9BEE667A38B550F40BEB75B29", hash_generated_method = "739EDEFB2A62426FDFD15DF78125C9FE")
            
public java.util.List<android.bluetooth.BluetoothDevice> getPanDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.bluetooth.BluetoothDevice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(states);
mRemote.transact(Stub.TRANSACTION_getPanDevicesMatchingConnectionStates, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.bluetooth.BluetoothDevice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.681 -0500", hash_original_method = "8AD51C035A7B4AF1D51E4D46CBD99533", hash_generated_method = "5025084B7AAB4D0D1A9D966AF37C674E")
            
public boolean connectPanDevice(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_connectPanDevice, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.684 -0500", hash_original_method = "4162D9BF98AEF21BD08FC20C23EBF464", hash_generated_method = "E2993936E2B06FEDA9DFB2FFD20BAD3D")
            
public boolean disconnectPanDevice(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_disconnectPanDevice, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// HDP profile APIs

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.687 -0500", hash_original_method = "2A69992D757EAE24B53CE9F3A25C455F", hash_generated_method = "9FF11024D23B74B525FDE890548DBDA6")
            
public boolean registerAppConfiguration(android.bluetooth.BluetoothHealthAppConfiguration config, android.bluetooth.IBluetoothHealthCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerAppConfiguration, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.689 -0500", hash_original_method = "C6D922CE8C9A57D6F77DE7F7F17CA673", hash_generated_method = "7ACF54E0DFA8882116D033A406887F9E")
            
public boolean unregisterAppConfiguration(android.bluetooth.BluetoothHealthAppConfiguration config) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_unregisterAppConfiguration, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.692 -0500", hash_original_method = "460D1AF02A1964589FD713ED49C3FCB8", hash_generated_method = "B2AD10D6EFF09EF2B1992C0FAA71DB3F")
            
public boolean connectChannelToSource(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_connectChannelToSource, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.695 -0500", hash_original_method = "3D3A5B1417DA7BDC63D6426D47D739B8", hash_generated_method = "8FABE5439F033ED20C755E7BCD6B0C3F")
            
public boolean connectChannelToSink(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config, int channelType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(channelType);
mRemote.transact(Stub.TRANSACTION_connectChannelToSink, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.698 -0500", hash_original_method = "1C4A10CA3AC81CE6F710C43440634A8E", hash_generated_method = "1446D495BF76DC9589DAD3C6774BF269")
            
public boolean disconnectChannel(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config, int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_disconnectChannel, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.701 -0500", hash_original_method = "432007E45C64CFDFBD99B6EF5E0692D1", hash_generated_method = "7F824092529CD168A568CA318F3A097B")
            
public android.os.ParcelFileDescriptor getMainChannelFd(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelFileDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getMainChannelFd, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.704 -0500", hash_original_method = "EA9730EDEE4AB21783C53F8EE1173E0B", hash_generated_method = "9B77D78132226885DBBF7211A63C4112")
            
public java.util.List<android.bluetooth.BluetoothDevice> getConnectedHealthDevices() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.bluetooth.BluetoothDevice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConnectedHealthDevices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.bluetooth.BluetoothDevice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.707 -0500", hash_original_method = "BA5BEC28B699281F6EEACD43520A617E", hash_generated_method = "F5C2227F5ED64AB207EF5315E924C57B")
            
public java.util.List<android.bluetooth.BluetoothDevice> getHealthDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.bluetooth.BluetoothDevice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(states);
mRemote.transact(Stub.TRANSACTION_getHealthDevicesMatchingConnectionStates, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.bluetooth.BluetoothDevice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.709 -0500", hash_original_method = "05351CF7FB0B28331963DAD24D3D7542", hash_generated_method = "7E7A5A5B022BA380DF33D4BBB88C6FFD")
            
public int getHealthDeviceConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getHealthDeviceConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.BLUETOOTH})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.712 -0500", hash_original_method = "FBF8996C99312133B44A7E0F55A9D306", hash_generated_method = "6D5392BFF15A6813C2100CDC720735D5")
            
public void sendConnectionStateChange(android.bluetooth.BluetoothDevice device, int profile, int state, int prevState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((device!=null)) {
_data.writeInt(1);
device.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(profile);
_data.writeInt(state);
_data.writeInt(prevState);
mRemote.transact(Stub.TRANSACTION_sendConnectionStateChange, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.739 -0500", hash_original_field = "CBCA1481D03CA3EBB893B02AE60F5E82", hash_generated_field = "35A7EDCD5BB678BA75C8F971335C7242")

static final int TRANSACTION_disable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.741 -0500", hash_original_field = "D9C0BF359CC717D198A6D7656780742B", hash_generated_field = "84AF56A53A075C83266217AD5178EB6C")

static final int TRANSACTION_getAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.744 -0500", hash_original_field = "60EF6CEEB99F04B41A73E2E64D31B7B6", hash_generated_field = "4E066DC3CD5BB0833414A21C2F7F4CBA")

static final int TRANSACTION_getName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.747 -0500", hash_original_field = "AC733609F9D2CF5ECFCF4449570141C7", hash_generated_field = "C0A3CE9951D865E5D6639F706F176976")

static final int TRANSACTION_setName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.749 -0500", hash_original_field = "B9F445FD2A03FE59FBE862E90B144DE3", hash_generated_field = "48C46F186A5F1FF9BEE1DF5A8B82109A")

static final int TRANSACTION_getUuids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.751 -0500", hash_original_field = "02530A352168D983A330900A9E8D7AB4", hash_generated_field = "F8617940E82DB5324AE0F1A59964B4D9")

static final int TRANSACTION_getScanMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.754 -0500", hash_original_field = "D98AD3097F868796E25DBBA304B31E64", hash_generated_field = "501BEED76402759F956F218C18FF83DA")

static final int TRANSACTION_setScanMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.756 -0500", hash_original_field = "C3DF65F3C85635CBB9791792A3710111", hash_generated_field = "FE096FF87CD9E19986811346D89B332B")

static final int TRANSACTION_getDiscoverableTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.758 -0500", hash_original_field = "35722BE2B3BCB32FD479C4F3D0944CDB", hash_generated_field = "FA3328CAE36CEF016329BFD96C934B22")

static final int TRANSACTION_setDiscoverableTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.760 -0500", hash_original_field = "687075C5CEFB60BF4A291249DD200267", hash_generated_field = "48D8884A30F984A0A1B6C2EFA7D0C82B")

static final int TRANSACTION_startDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.763 -0500", hash_original_field = "5EA3DF1B8C3015125E94FDC57D23C636", hash_generated_field = "FCD8EA460926E094CA790F2508FB1459")

static final int TRANSACTION_cancelDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.766 -0500", hash_original_field = "5D68A3E4DD9F1092CC583D44DF947DFD", hash_generated_field = "6B3E5DFE320789E16F7C00DB8A77A6A9")

static final int TRANSACTION_isDiscovering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.768 -0500", hash_original_field = "19CD1F56B8BD1EC9642340A9ADEC09E1", hash_generated_field = "DA11A806BE8CB68E4D4BA93FA7037E9B")

static final int TRANSACTION_readOutOfBandData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.771 -0500", hash_original_field = "8B9825D740150451F5A40B4E9F62E64D", hash_generated_field = "02AF45CEDD1169FA0504EE88698DAFC9")

static final int TRANSACTION_getAdapterConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.773 -0500", hash_original_field = "03CA97E02F04540456251DC484B98C74", hash_generated_field = "02C1ED40A6EB700E0B3F6A741E601028")

static final int TRANSACTION_getProfileConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.776 -0500", hash_original_field = "C07BF2EC0F13DB60DF237A6B7A8EFCD3", hash_generated_field = "D0BA515D11B4993BFA6B3C5D47D466BC")

static final int TRANSACTION_changeApplicationBluetoothState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.778 -0500", hash_original_field = "F3507077258400BBEDED822F20E1C362", hash_generated_field = "33D3430D4ED2C9224518AD60C33660B3")

static final int TRANSACTION_createBond = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.780 -0500", hash_original_field = "0A078852B58EA062E8FC8A3A11F24137", hash_generated_field = "D7F8A63DD696CE52E25414F6EA8AF7F2")

static final int TRANSACTION_createBondOutOfBand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.783 -0500", hash_original_field = "0AB0C28CFD58DAA17A1BC897470CACCE", hash_generated_field = "022F204A03F55F2F276FE0E2D1076573")

static final int TRANSACTION_cancelBondProcess = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.785 -0500", hash_original_field = "81622493FE1A958EEE18DD04E8CE1836", hash_generated_field = "E42140554406BE85F83662CD7B1935F6")

static final int TRANSACTION_removeBond = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.787 -0500", hash_original_field = "15B5800F0712E9B9B0F81C858F53C9DB", hash_generated_field = "91C40446F5579C590123AB19B195845C")

static final int TRANSACTION_listBonds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.789 -0500", hash_original_field = "736A7CF0294340DC45A9DEE56DAC2997", hash_generated_field = "92BFCA89C94B36E062AF6556AA1A1544")

static final int TRANSACTION_getBondState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.792 -0500", hash_original_field = "4DE37527D1D1C37FBF3D910E6B92D3F6", hash_generated_field = "E33C4EA652BF2F5B8477CB37B53CDA81")

static final int TRANSACTION_setDeviceOutOfBandData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.795 -0500", hash_original_field = "0600692A95DE39D66412BF2B9F34991D", hash_generated_field = "0B2453CA77DD11AAEF21F4F1F77D7E06")

static final int TRANSACTION_getRemoteName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.797 -0500", hash_original_field = "A1E064678EE5C9540E1554C3CBBAF3FC", hash_generated_field = "18EF791EC82505B76E3D9E0D2B9DF176")

static final int TRANSACTION_getRemoteAlias = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.799 -0500", hash_original_field = "1240FD0C41E25C63613B7F79F52EE8B5", hash_generated_field = "840AA58AAFB0AD07399D0FB6C6561476")

static final int TRANSACTION_setRemoteAlias = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.802 -0500", hash_original_field = "CCA74706FE36F2C7FDC12727F02BE5B0", hash_generated_field = "F44E2B31864291270A3C3709DE16E6C6")

static final int TRANSACTION_getRemoteClass = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.804 -0500", hash_original_field = "6A0434D14D1AE842F4538E8DCB2DB5AD", hash_generated_field = "89C3F3CD0647A74BD26A8B8856D2402C")

static final int TRANSACTION_getRemoteUuids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.806 -0500", hash_original_field = "8E14AD404E386DC03D751F199C08FAD3", hash_generated_field = "7233EBB8C21956EF856E949E7EBE4ED1")

static final int TRANSACTION_fetchRemoteUuids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.809 -0500", hash_original_field = "5B3A58699B6D22CFBB1D7778A7F6FE2B", hash_generated_field = "C9DB2ECF3008618B65733D41A2D63107")

static final int TRANSACTION_getRemoteServiceChannel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.812 -0500", hash_original_field = "355E0F2942EC39F5B3B94FAC39BB152C", hash_generated_field = "27A075D3F478CAC2A66E585AF1D06131")

static final int TRANSACTION_setPin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.814 -0500", hash_original_field = "29DBA2848BB63C31E18CE50FE687123C", hash_generated_field = "7E5305A17830C3A67F0355C0A822B80C")

static final int TRANSACTION_setPasskey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.816 -0500", hash_original_field = "9A36B5934AA76B61484ED530B3BDCC20", hash_generated_field = "99E8A4BAB0B2F0ED62570C6C5ED8CA96")

static final int TRANSACTION_setPairingConfirmation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.818 -0500", hash_original_field = "DA39131D8B031FE04B1AECEE7D16DA45", hash_generated_field = "7855B12970F1AA54F50B626DA31E6AF1")

static final int TRANSACTION_setRemoteOutOfBandData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.821 -0500", hash_original_field = "07BE1F1E4E972D9E9C56D456D9EB95B5", hash_generated_field = "62183106D2F954C1B475A922D460A6CF")

static final int TRANSACTION_cancelPairingUserInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.823 -0500", hash_original_field = "2D8E18D3F1FCBA3748061ECB6F0FAD36", hash_generated_field = "545F2135B694BAB810141E354DFBE9C8")

static final int TRANSACTION_setTrust = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.826 -0500", hash_original_field = "56716A6C255DDA6A3408FA897302C3BF", hash_generated_field = "C7429F40B1B776DDD4A63DE71B8851BE")

static final int TRANSACTION_getTrustState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.828 -0500", hash_original_field = "9904A592B189EDAFA9F28CC9F5F9D285", hash_generated_field = "D78A52EB3EF09EE124200D647487CFC6")

static final int TRANSACTION_isBluetoothDock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.831 -0500", hash_original_field = "2DC61ABB3A2FB29926366E67D0F54729", hash_generated_field = "B7C2AD0595D2E987DB59B6DB60903C0B")

static final int TRANSACTION_addRfcommServiceRecord = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.833 -0500", hash_original_field = "55E0F8848D6BD82F1667417B3E0FA0A4", hash_generated_field = "C90DC3A6E4CA159D0A85338A2DBC093C")

static final int TRANSACTION_removeServiceRecord = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.835 -0500", hash_original_field = "E18E5D52F3C6E049B6592FFC755059EB", hash_generated_field = "925148121AE86DD81D04CC37CA39846E")

static final int TRANSACTION_allowIncomingProfileConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.838 -0500", hash_original_field = "79A5040B7F6AB151C86BD41C6FC24609", hash_generated_field = "4E8E32E24E502645EDEE5A672E56E028")

static final int TRANSACTION_connectHeadset = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.841 -0500", hash_original_field = "910846568FF7ED3FF748C9A75F2110B4", hash_generated_field = "37F7B1DD4FCA6A0C42AD5CD3B3124FCB")

static final int TRANSACTION_disconnectHeadset = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.843 -0500", hash_original_field = "C1ADE99ADEFB5DE1E9EDBC6C593F796C", hash_generated_field = "12E6C6D848189EFCF138D5EA39063E67")

static final int TRANSACTION_notifyIncomingConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.845 -0500", hash_original_field = "D17194BA447291B48AD44B21CC6A9A49", hash_generated_field = "B07BF1A96194ED2A3AA044C13BB71107")

static final int TRANSACTION_connectInputDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.848 -0500", hash_original_field = "7F03CF96B6F8E2EAFA3AC978B3A2D25A", hash_generated_field = "816A41E8A0544475787E858C0793F492")

static final int TRANSACTION_disconnectInputDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.850 -0500", hash_original_field = "5CD144FE71D4817462E1095EDFE7CCB4", hash_generated_field = "C6BBCE56D4C352F35660133CA026C42A")

static final int TRANSACTION_getConnectedInputDevices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.853 -0500", hash_original_field = "CEC27698FDD4246D01F45D4542B305C1", hash_generated_field = "35FEA795313AA1365275CF89571142B4")

static final int TRANSACTION_getInputDevicesMatchingConnectionStates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.855 -0500", hash_original_field = "952649AD16FB97ABEF82E0C73551B962", hash_generated_field = "941D46F10A2CB278298E2711189F3BF7")

static final int TRANSACTION_getInputDeviceConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.857 -0500", hash_original_field = "5C33B3BFFDECB608164DA3285301DF50", hash_generated_field = "51CCF81AEFB77AD1269FF570A5AC704A")

static final int TRANSACTION_setInputDevicePriority = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.859 -0500", hash_original_field = "6ABA57344D828DCBD3E2C24D88C8A175", hash_generated_field = "D7B6B0304F44617D533D2F5A4E3DF427")

static final int TRANSACTION_getInputDevicePriority = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.861 -0500", hash_original_field = "8EDB802FB52CA6003BB9CD85591C7D36", hash_generated_field = "14A51FE0BD2D2245C4E4C2902CB52B70")

static final int TRANSACTION_isTetheringOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.864 -0500", hash_original_field = "2A72C562303F67438935DB828419D4A0", hash_generated_field = "600B623C23A32071728D6389BB3DAC15")

static final int TRANSACTION_setBluetoothTethering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.867 -0500", hash_original_field = "4BC615DAFDCF4EBDEDF08CAF514366CA", hash_generated_field = "61FE36233530ECDC18A17D4370CC2FC5")

static final int TRANSACTION_getPanDeviceConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.869 -0500", hash_original_field = "AD06E3C479F2214F6BECD77A3B7C3008", hash_generated_field = "E7D214B5A3105E9554189DA39AC4E45C")

static final int TRANSACTION_getConnectedPanDevices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.871 -0500", hash_original_field = "2E440FA8684A8A8FF29A31C219BBF91C", hash_generated_field = "F110E2A17763B3AD788CAC4FA2341FD2")

static final int TRANSACTION_getPanDevicesMatchingConnectionStates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.874 -0500", hash_original_field = "99FC90B59A74E77418CC197E06A95554", hash_generated_field = "8D3178A162376BCB5495AA009145D4E7")

static final int TRANSACTION_connectPanDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.876 -0500", hash_original_field = "D49AD64ACFBDC58DCD522BEFBD963D42", hash_generated_field = "250CF8AED49813FFB78EB6EB1D8CF0DE")

static final int TRANSACTION_disconnectPanDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.879 -0500", hash_original_field = "1759B0D761DE3D2319169C9A791406A5", hash_generated_field = "BFF5C516EF1238DBDC1160DA2CDC252A")

static final int TRANSACTION_registerAppConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.881 -0500", hash_original_field = "247314A767561CE6D33AC5B53E4286A9", hash_generated_field = "BCF8E32C4D2543515D81563B080B6B9D")

static final int TRANSACTION_unregisterAppConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.883 -0500", hash_original_field = "226A438D02F9DB140E9B50AA9D63DE55", hash_generated_field = "B4F98226C8CE7842A2657F97CD0C1891")

static final int TRANSACTION_connectChannelToSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.886 -0500", hash_original_field = "DA2A0238D147FCC0CB8AB7F7302BE7A0", hash_generated_field = "3714054DADC5C604FA5D58EE304802E6")

static final int TRANSACTION_connectChannelToSink = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.888 -0500", hash_original_field = "C46CABC5C264EF2F34FCEE1A8CEF6FA4", hash_generated_field = "2DE3ACAC97F41829A67B8E20FE24A9B4")

static final int TRANSACTION_disconnectChannel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.891 -0500", hash_original_field = "F6C575EBBC56CB36DDA03A62118407F5", hash_generated_field = "C3C00FFD57E70383DA7077F6FAB35091")

static final int TRANSACTION_getMainChannelFd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.893 -0500", hash_original_field = "2A6E20F0F324F0E1E0D03A5CCC4BCE99", hash_generated_field = "E4C9A6F10E5D12BF2F26ABDA8F55CDE4")

static final int TRANSACTION_getConnectedHealthDevices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.895 -0500", hash_original_field = "2147A4DEAA7D8C054FC033023F24BDF1", hash_generated_field = "22302C56BF9A0881A75282722FDD8718")

static final int TRANSACTION_getHealthDevicesMatchingConnectionStates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.898 -0500", hash_original_field = "70A7A55F2D374CBB5317E14A651AA66F", hash_generated_field = "B42A12F8EAEFA4026C829DB28E579583")

static final int TRANSACTION_getHealthDeviceConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.900 -0500", hash_original_field = "D03244965FBF075DBA89EAF7606B12FD", hash_generated_field = "C120611CC3118F3306FB3342DB2E442C")

static final int TRANSACTION_sendConnectionStateChange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.487 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.492 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.BLUETOOTH})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:37.507 -0500", hash_original_method = "DBBC3947D4B873274E47917EB4489E0B", hash_generated_method = "7D0EA8539B1C24E86B8AC1D268E96B9B")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_isEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getBluetoothState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getBluetoothState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_enable:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.enable();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disable:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.disable(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.setName(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getUuids:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelUuid[] _result = this.getUuids();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_getScanMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getScanMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setScanMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.setScanMode(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getDiscoverableTimeout:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getDiscoverableTimeout();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setDiscoverableTimeout:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setDiscoverableTimeout(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_startDiscovery:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.startDiscovery();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_cancelDiscovery:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.cancelDiscovery();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isDiscovering:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isDiscovering();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_readOutOfBandData:
{
data.enforceInterface(DESCRIPTOR);
byte[] _result = this.readOutOfBandData();
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_getAdapterConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getAdapterConnectionState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getProfileConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getProfileConnectionState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_changeApplicationBluetoothState:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
android.bluetooth.IBluetoothStateChangeCallback _arg1;
_arg1 = android.bluetooth.IBluetoothStateChangeCallback.Stub.asInterface(data.readStrongBinder());
android.os.IBinder _arg2;
_arg2 = data.readStrongBinder();
boolean _result = this.changeApplicationBluetoothState(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_createBond:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.createBond(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_createBondOutOfBand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
byte[] _arg2;
_arg2 = data.createByteArray();
boolean _result = this.createBondOutOfBand(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_cancelBondProcess:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.cancelBondProcess(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_removeBond:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.removeBond(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_listBonds:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.listBonds();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getBondState:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getBondState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setDeviceOutOfBandData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
byte[] _arg2;
_arg2 = data.createByteArray();
boolean _result = this.setDeviceOutOfBandData(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getRemoteName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.getRemoteName(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getRemoteAlias:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.getRemoteAlias(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setRemoteAlias:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.setRemoteAlias(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getRemoteClass:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getRemoteClass(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getRemoteUuids:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.ParcelUuid[] _result = this.getRemoteUuids(_arg0);
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_fetchRemoteUuids:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.ParcelUuid _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.bluetooth.IBluetoothCallback _arg2;
_arg2 = android.bluetooth.IBluetoothCallback.Stub.asInterface(data.readStrongBinder());
boolean _result = this.fetchRemoteUuids(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getRemoteServiceChannel:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.ParcelUuid _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _result = this.getRemoteServiceChannel(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPin:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
boolean _result = this.setPin(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setPasskey:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.setPasskey(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setPairingConfirmation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.setPairingConfirmation(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setRemoteOutOfBandData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.setRemoteOutOfBandData(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_cancelPairingUserInput:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.cancelPairingUserInput(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setTrust:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.setTrust(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getTrustState:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.getTrustState(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isBluetoothDock:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isBluetoothDock(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_addRfcommServiceRecord:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.ParcelUuid _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _arg2;
_arg2 = data.readInt();
android.os.IBinder _arg3;
_arg3 = data.readStrongBinder();
int _result = this.addRfcommServiceRecord(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_removeServiceRecord:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.removeServiceRecord(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_allowIncomingProfileConnect:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.allowIncomingProfileConnect(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_connectHeadset:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.connectHeadset(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disconnectHeadset:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.disconnectHeadset(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_notifyIncomingConnection:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.notifyIncomingConnection(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_connectInputDevice:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.connectInputDevice(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disconnectInputDevice:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.disconnectInputDevice(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getConnectedInputDevices:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.bluetooth.BluetoothDevice> _result = this.getConnectedInputDevices();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getInputDevicesMatchingConnectionStates:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
java.util.List<android.bluetooth.BluetoothDevice> _result = this.getInputDevicesMatchingConnectionStates(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getInputDeviceConnectionState:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getInputDeviceConnectionState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setInputDevicePriority:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
boolean _result = this.setInputDevicePriority(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getInputDevicePriority:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getInputDevicePriority(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isTetheringOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isTetheringOn();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setBluetoothTethering:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setBluetoothTethering(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPanDeviceConnectionState:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPanDeviceConnectionState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getConnectedPanDevices:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.bluetooth.BluetoothDevice> _result = this.getConnectedPanDevices();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getPanDevicesMatchingConnectionStates:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
java.util.List<android.bluetooth.BluetoothDevice> _result = this.getPanDevicesMatchingConnectionStates(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_connectPanDevice:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.connectPanDevice(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disconnectPanDevice:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.disconnectPanDevice(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerAppConfiguration:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothHealthAppConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothHealthAppConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.bluetooth.IBluetoothHealthCallback _arg1;
_arg1 = android.bluetooth.IBluetoothHealthCallback.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerAppConfiguration(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterAppConfiguration:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothHealthAppConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothHealthAppConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.unregisterAppConfiguration(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_connectChannelToSource:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.bluetooth.BluetoothHealthAppConfiguration _arg1;
if ((0!=data.readInt())) {
_arg1 = android.bluetooth.BluetoothHealthAppConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _result = this.connectChannelToSource(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_connectChannelToSink:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.bluetooth.BluetoothHealthAppConfiguration _arg1;
if ((0!=data.readInt())) {
_arg1 = android.bluetooth.BluetoothHealthAppConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _arg2;
_arg2 = data.readInt();
boolean _result = this.connectChannelToSink(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disconnectChannel:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.bluetooth.BluetoothHealthAppConfiguration _arg1;
if ((0!=data.readInt())) {
_arg1 = android.bluetooth.BluetoothHealthAppConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _arg2;
_arg2 = data.readInt();
boolean _result = this.disconnectChannel(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getMainChannelFd:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.bluetooth.BluetoothHealthAppConfiguration _arg1;
if ((0!=data.readInt())) {
_arg1 = android.bluetooth.BluetoothHealthAppConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.os.ParcelFileDescriptor _result = this.getMainChannelFd(_arg0, _arg1);
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
case TRANSACTION_getConnectedHealthDevices:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.bluetooth.BluetoothDevice> _result = this.getConnectedHealthDevices();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getHealthDevicesMatchingConnectionStates:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
java.util.List<android.bluetooth.BluetoothDevice> _result = this.getHealthDevicesMatchingConnectionStates(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getHealthDeviceConnectionState:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getHealthDeviceConnectionState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_sendConnectionStateChange:
{
data.enforceInterface(DESCRIPTOR);
android.bluetooth.BluetoothDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.sendConnectionStateChange(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public boolean isEnabled() throws android.os.RemoteException;
public int getBluetoothState() throws android.os.RemoteException;
public boolean enable() throws android.os.RemoteException;
public boolean disable(boolean persistSetting) throws android.os.RemoteException;
public java.lang.String getAddress() throws android.os.RemoteException;
public java.lang.String getName() throws android.os.RemoteException;
public boolean setName(java.lang.String name) throws android.os.RemoteException;
public android.os.ParcelUuid[] getUuids() throws android.os.RemoteException;
public int getScanMode() throws android.os.RemoteException;
public boolean setScanMode(int mode, int duration) throws android.os.RemoteException;
public int getDiscoverableTimeout() throws android.os.RemoteException;
public boolean setDiscoverableTimeout(int timeout) throws android.os.RemoteException;
public boolean startDiscovery() throws android.os.RemoteException;
public boolean cancelDiscovery() throws android.os.RemoteException;
public boolean isDiscovering() throws android.os.RemoteException;
public byte[] readOutOfBandData() throws android.os.RemoteException;
public int getAdapterConnectionState() throws android.os.RemoteException;
public int getProfileConnectionState(int profile) throws android.os.RemoteException;
public boolean changeApplicationBluetoothState(boolean on, android.bluetooth.IBluetoothStateChangeCallback callback, android.os.IBinder b) throws android.os.RemoteException;
public boolean createBond(java.lang.String address) throws android.os.RemoteException;
public boolean createBondOutOfBand(java.lang.String address, byte[] hash, byte[] randomizer) throws android.os.RemoteException;
public boolean cancelBondProcess(java.lang.String address) throws android.os.RemoteException;
public boolean removeBond(java.lang.String address) throws android.os.RemoteException;
public java.lang.String[] listBonds() throws android.os.RemoteException;
public int getBondState(java.lang.String address) throws android.os.RemoteException;
public boolean setDeviceOutOfBandData(java.lang.String address, byte[] hash, byte[] randomizer) throws android.os.RemoteException;
public java.lang.String getRemoteName(java.lang.String address) throws android.os.RemoteException;
public java.lang.String getRemoteAlias(java.lang.String address) throws android.os.RemoteException;
public boolean setRemoteAlias(java.lang.String address, java.lang.String name) throws android.os.RemoteException;
public int getRemoteClass(java.lang.String address) throws android.os.RemoteException;
public android.os.ParcelUuid[] getRemoteUuids(java.lang.String address) throws android.os.RemoteException;
public boolean fetchRemoteUuids(java.lang.String address, android.os.ParcelUuid uuid, android.bluetooth.IBluetoothCallback callback) throws android.os.RemoteException;
public int getRemoteServiceChannel(java.lang.String address, android.os.ParcelUuid uuid) throws android.os.RemoteException;
public boolean setPin(java.lang.String address, byte[] pin) throws android.os.RemoteException;
public boolean setPasskey(java.lang.String address, int passkey) throws android.os.RemoteException;
public boolean setPairingConfirmation(java.lang.String address, boolean confirm) throws android.os.RemoteException;
public boolean setRemoteOutOfBandData(java.lang.String addres) throws android.os.RemoteException;
public boolean cancelPairingUserInput(java.lang.String address) throws android.os.RemoteException;
public boolean setTrust(java.lang.String address, boolean value) throws android.os.RemoteException;
public boolean getTrustState(java.lang.String address) throws android.os.RemoteException;
public boolean isBluetoothDock(java.lang.String address) throws android.os.RemoteException;
public int addRfcommServiceRecord(java.lang.String serviceName, android.os.ParcelUuid uuid, int channel, android.os.IBinder b) throws android.os.RemoteException;
public void removeServiceRecord(int handle) throws android.os.RemoteException;
public boolean allowIncomingProfileConnect(android.bluetooth.BluetoothDevice device, boolean value) throws android.os.RemoteException;
public boolean connectHeadset(java.lang.String address) throws android.os.RemoteException;
public boolean disconnectHeadset(java.lang.String address) throws android.os.RemoteException;
public boolean notifyIncomingConnection(java.lang.String address, boolean rejected) throws android.os.RemoteException;

public boolean connectInputDevice(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
public boolean disconnectInputDevice(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
public java.util.List<android.bluetooth.BluetoothDevice> getConnectedInputDevices() throws android.os.RemoteException;
public java.util.List<android.bluetooth.BluetoothDevice> getInputDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException;
public int getInputDeviceConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
public boolean setInputDevicePriority(android.bluetooth.BluetoothDevice device, int priority) throws android.os.RemoteException;
public int getInputDevicePriority(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
public boolean isTetheringOn() throws android.os.RemoteException;
public void setBluetoothTethering(boolean value) throws android.os.RemoteException;
public int getPanDeviceConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
public java.util.List<android.bluetooth.BluetoothDevice> getConnectedPanDevices() throws android.os.RemoteException;
public java.util.List<android.bluetooth.BluetoothDevice> getPanDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException;
public boolean connectPanDevice(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
public boolean disconnectPanDevice(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;

public boolean registerAppConfiguration(android.bluetooth.BluetoothHealthAppConfiguration config, android.bluetooth.IBluetoothHealthCallback callback) throws android.os.RemoteException;
public boolean unregisterAppConfiguration(android.bluetooth.BluetoothHealthAppConfiguration config) throws android.os.RemoteException;
public boolean connectChannelToSource(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config) throws android.os.RemoteException;
public boolean connectChannelToSink(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config, int channelType) throws android.os.RemoteException;
public boolean disconnectChannel(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config, int id) throws android.os.RemoteException;
public android.os.ParcelFileDescriptor getMainChannelFd(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config) throws android.os.RemoteException;
public java.util.List<android.bluetooth.BluetoothDevice> getConnectedHealthDevices() throws android.os.RemoteException;
public java.util.List<android.bluetooth.BluetoothDevice> getHealthDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException;
public int getHealthDeviceConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
public void sendConnectionStateChange(android.bluetooth.BluetoothDevice device, int profile, int state, int prevState) throws android.os.RemoteException;
}
