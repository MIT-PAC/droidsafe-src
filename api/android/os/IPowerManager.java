package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IPowerManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.os.IPowerManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.666 -0500", hash_original_field = "CE6B02A53D642B01D5E709FBF403574A", hash_generated_field = "32812C226DF3D2F6C41C39ED03276BE4")

private static final java.lang.String DESCRIPTOR = "android.os.IPowerManager";
/**
 * Cast an IBinder object into an android.os.IPowerManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.671 -0500", hash_original_method = "ACACDB9C6A670BEF46AC15C5D0CB5351", hash_generated_method = "D7C321755BE308F73F116F299F769598")
        
public static android.os.IPowerManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.os.IPowerManager))) {
return ((android.os.IPowerManager)iin);
}
return new android.os.IPowerManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.747 -0500", hash_original_field = "E7B6F3760B15B3B82326CBBBD1797368", hash_generated_field = "284F7F3A093B3ABEF8E1883EB726E643")

static final int TRANSACTION_acquireWakeLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.749 -0500", hash_original_field = "1908CDD829AB4B6367DB7A2F53CD4817", hash_generated_field = "37CAE19157D2E4D9AB286D2C85AB4DEB")

static final int TRANSACTION_updateWakeLockWorkSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.752 -0500", hash_original_field = "678ACDEB71C0BC6BDD81DB22E60FDC8C", hash_generated_field = "2F0FAB24F6685EBA4CB8717DF3FA3F16")

static final int TRANSACTION_goToSleep = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.os.IPowerManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.683 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.685 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.688 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.690 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
// WARNING: changes in acquireWakeLock() signature must be reflected in IPowerManager.cpp/h

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.693 -0500", hash_original_method = "2E3DCB2E8915583F864D42CBBB5B10B7", hash_generated_method = "BB968BA0C0DD99B7E0BB3C4244B262E1")
            
public void acquireWakeLock(int flags, android.os.IBinder lock, java.lang.String tag, android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
_data.writeStrongBinder(lock);
_data.writeString(tag);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_acquireWakeLock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.697 -0500", hash_original_method = "2697FC21298609AA68259968ECB0FA18", hash_generated_method = "FFD65838395BD795F47CCD5760F206B1")
            
public void updateWakeLockWorkSource(android.os.IBinder lock, android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(lock);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateWakeLockWorkSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.699 -0500", hash_original_method = "476837F817260B8290DC49CD357701D3", hash_generated_method = "C4109AD7FF011227B3BCD671B336450D")
            
public void goToSleep(long time) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(time);
mRemote.transact(Stub.TRANSACTION_goToSleep, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.702 -0500", hash_original_method = "69A225F6C520E50FA72821635F69451D", hash_generated_method = "BD5C41864DF31BBE6D3EC8B518B50C28")
            
public void goToSleepWithReason(long time, int reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(time);
_data.writeInt(reason);
mRemote.transact(Stub.TRANSACTION_goToSleepWithReason, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// WARNING: changes in releaseWakeLock() signature must be reflected in IPowerManager.cpp/h

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.705 -0500", hash_original_method = "430926DC207045F64753E85DD81FDCC2", hash_generated_method = "7EC34EA23CE15968A7E44AE49C543454")
            
public void releaseWakeLock(android.os.IBinder lock, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(lock);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_releaseWakeLock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.707 -0500", hash_original_method = "A21210FACACC371B3E46B781A1003899", hash_generated_method = "118D2A3CDCC728D1B23A1B69FB5B9750")
            
public void userActivity(long when, boolean noChangeLights) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(when);
_data.writeInt(((noChangeLights)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_userActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.710 -0500", hash_original_method = "5CA1E939D623DC45D40AD9CD912E85E1", hash_generated_method = "625104CD30F4BE2C1F517B336CC6FF41")
            
public void userActivityWithForce(long when, boolean noChangeLights, boolean force) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(when);
_data.writeInt(((noChangeLights)?(1):(0)));
_data.writeInt(((force)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_userActivityWithForce, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.713 -0500", hash_original_method = "6DB0B750499BFC5609A828B277950A00", hash_generated_method = "293E721495C6F354D042A381BAC4BEC0")
            
public void clearUserActivityTimeout(long now, long timeout) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(now);
_data.writeLong(timeout);
mRemote.transact(Stub.TRANSACTION_clearUserActivityTimeout, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.715 -0500", hash_original_method = "32F9CB73F682C9FE44633E7C4409F5DE", hash_generated_method = "1661F73FD4075A29B4D154B3B9420241")
            
public void setPokeLock(int pokey, android.os.IBinder lock, java.lang.String tag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(pokey);
_data.writeStrongBinder(lock);
_data.writeString(tag);
mRemote.transact(Stub.TRANSACTION_setPokeLock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.718 -0500", hash_original_method = "ABE67F55F3E92E9A3E2523D272345544", hash_generated_method = "1E4E5A7558FC1A06D7ECDE0CAB8EA72E")
            
public int getSupportedWakeLockFlags() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSupportedWakeLockFlags, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.721 -0500", hash_original_method = "11D3B4096A793234D099D31D68C96461", hash_generated_method = "EADE558A2B052148AB289F610A804134")
            
public void setStayOnSetting(int val) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(val);
mRemote.transact(Stub.TRANSACTION_setStayOnSetting, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.723 -0500", hash_original_method = "75E55A5F4A2243CDF485C911B9E1B09D", hash_generated_method = "921545D5912D5E0E0E7460CF1BE19198")
            
public void setMaximumScreenOffTimeount(int timeMs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(timeMs);
mRemote.transact(Stub.TRANSACTION_setMaximumScreenOffTimeount, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.726 -0500", hash_original_method = "2586F1E20B05F34FF4789E202BB76557", hash_generated_method = "B4FF361241B379D7F3DD692065701071")
            
public void preventScreenOn(boolean prevent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((prevent)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_preventScreenOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.728 -0500", hash_original_method = "C09DF29E849C73979422F7D5425410B9", hash_generated_method = "742467430126ED29E2A7C0828B26A7B2")
            
public boolean isScreenOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isScreenOn, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.731 -0500", hash_original_method = "29CDE2B9F197307A8708BA4B35BB3A2B", hash_generated_method = "983C6299CA2E672BA19C5988B655FE46")
            
public void reboot(java.lang.String reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(reason);
mRemote.transact(Stub.TRANSACTION_reboot, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.733 -0500", hash_original_method = "035146ECEFAD1D48140EC9098F25754C", hash_generated_method = "6898D1D941818B124D89707285C3A0D2")
            
public void crash(java.lang.String message) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(message);
mRemote.transact(Stub.TRANSACTION_crash, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// sets the brightness of the backlights (screen, keyboard, button) 0-255

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.737 -0500", hash_original_method = "2B656AE13CC0B08FF51F7DF34F17B4B1", hash_generated_method = "A15EFFDA62D641B84A8BFD9C16CA8487")
            
public void setBacklightBrightness(int brightness) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(brightness);
mRemote.transact(Stub.TRANSACTION_setBacklightBrightness, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.740 -0500", hash_original_method = "D5C2B4A45F56782BDD1B1F1560319665", hash_generated_method = "4A11309A76B6A9830A5BF6E705322CF3")
            
public void setAttentionLight(boolean on, int color) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((on)?(1):(0)));
_data.writeInt(color);
mRemote.transact(Stub.TRANSACTION_setAttentionLight, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.754 -0500", hash_original_field = "29C4F8965AB230AE37094870982AE3F1", hash_generated_field = "9C5038F661C35748F8748A132C75355C")

static final int TRANSACTION_goToSleepWithReason = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.757 -0500", hash_original_field = "7D048E5DF823CF691520C9C95F077F15", hash_generated_field = "FE43F00EEEAA87766BBAE67D49A27CD8")

static final int TRANSACTION_releaseWakeLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.759 -0500", hash_original_field = "043F4E28C22511739BDE3D7C713830BF", hash_generated_field = "D5B26DF2E8E9861C0356731596037558")

static final int TRANSACTION_userActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.761 -0500", hash_original_field = "F606AFF67176FE1E84B5AC7A81A0F7CB", hash_generated_field = "9D148D2FAC474321D10ABF6E0E4991E8")

static final int TRANSACTION_userActivityWithForce = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.764 -0500", hash_original_field = "FA4F89587DDB730D70B95658BCC72BCD", hash_generated_field = "A23A902E3C781868C62772600F7DF932")

static final int TRANSACTION_clearUserActivityTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.766 -0500", hash_original_field = "A8317D1D7B49B7623B0602F9B491E7B5", hash_generated_field = "221018E241A2D47D17E4690BBD28CC5B")

static final int TRANSACTION_setPokeLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.769 -0500", hash_original_field = "2835BFFAD2952BA99D3A2A23CBD55E64", hash_generated_field = "5048D2F7EFEBFE740B732B4193AC4563")

static final int TRANSACTION_getSupportedWakeLockFlags = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.772 -0500", hash_original_field = "EEE6811F7EF7ABC2B6D9A5901A81B830", hash_generated_field = "F9B840B11997B156054BBEAAB0C3FCEC")

static final int TRANSACTION_setStayOnSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.774 -0500", hash_original_field = "800C624F0F38591FB0216D73C2CB90A5", hash_generated_field = "D3DBC5FC18B91C60DFD80238FD97AA2C")

static final int TRANSACTION_setMaximumScreenOffTimeount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.776 -0500", hash_original_field = "57E78519BC4F5ECB63D938B2E3BC598B", hash_generated_field = "6BC9F7F183ADC1CA5B3B7951733128CE")

static final int TRANSACTION_preventScreenOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.778 -0500", hash_original_field = "FAB20AAF7F354F7D9BD3220D6C7C2266", hash_generated_field = "2AF52C596A74E4E585019C42F9408108")

static final int TRANSACTION_isScreenOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.788 -0500", hash_original_field = "50FBBA63B52812D78B5856F48719E269", hash_generated_field = "781580D5C18B267831421BF4A1BF945E")

static final int TRANSACTION_reboot = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.791 -0500", hash_original_field = "45380D19BD42BDA5BBA0E53A71235394", hash_generated_field = "9013C1B41EA13A990FEBEA46E7363512")

static final int TRANSACTION_crash = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.793 -0500", hash_original_field = "523067A714543027E2D9F95C20471BA9", hash_generated_field = "8DA97EAA6210FF50360DC76B06C45424")

static final int TRANSACTION_setBacklightBrightness = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.796 -0500", hash_original_field = "216FB84D27612819215276E341823F45", hash_generated_field = "5BEFDDCB8A940A794DE623A06D44BFAA")

static final int TRANSACTION_setAttentionLight = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.669 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.674 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.679 -0500", hash_original_method = "3AD486EE648D270801B5D455FCFB6861", hash_generated_method = "BD135F5A8EEDF503B62B4576BEDBBC7C")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_acquireWakeLock:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
java.lang.String _arg2;
_arg2 = data.readString();
android.os.WorkSource _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.acquireWakeLock(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_updateWakeLockWorkSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
android.os.WorkSource _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.updateWakeLockWorkSource(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_goToSleep:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
this.goToSleep(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_goToSleepWithReason:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
int _arg1;
_arg1 = data.readInt();
this.goToSleepWithReason(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_releaseWakeLock:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
this.releaseWakeLock(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_userActivity:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.userActivity(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_userActivityWithForce:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _arg2;
_arg2 = (0!=data.readInt());
this.userActivityWithForce(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_clearUserActivityTimeout:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
long _arg1;
_arg1 = data.readLong();
this.clearUserActivityTimeout(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setPokeLock:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
java.lang.String _arg2;
_arg2 = data.readString();
this.setPokeLock(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getSupportedWakeLockFlags:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getSupportedWakeLockFlags();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setStayOnSetting:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setStayOnSetting(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setMaximumScreenOffTimeount:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setMaximumScreenOffTimeount(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_preventScreenOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.preventScreenOn(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isScreenOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isScreenOn();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reboot:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.reboot(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_crash:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.crash(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setBacklightBrightness:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setBacklightBrightness(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setAttentionLight:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
int _arg1;
_arg1 = data.readInt();
this.setAttentionLight(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void acquireWakeLock(int flags, android.os.IBinder lock, java.lang.String tag, android.os.WorkSource ws) throws android.os.RemoteException;
public void updateWakeLockWorkSource(android.os.IBinder lock, android.os.WorkSource ws) throws android.os.RemoteException;
public void goToSleep(long time) throws android.os.RemoteException;
public void goToSleepWithReason(long time, int reason) throws android.os.RemoteException;

public void releaseWakeLock(android.os.IBinder lock, int flags) throws android.os.RemoteException;
public void userActivity(long when, boolean noChangeLights) throws android.os.RemoteException;
public void userActivityWithForce(long when, boolean noChangeLights, boolean force) throws android.os.RemoteException;
public void clearUserActivityTimeout(long now, long timeout) throws android.os.RemoteException;
public void setPokeLock(int pokey, android.os.IBinder lock, java.lang.String tag) throws android.os.RemoteException;
public int getSupportedWakeLockFlags() throws android.os.RemoteException;
public void setStayOnSetting(int val) throws android.os.RemoteException;
public void setMaximumScreenOffTimeount(int timeMs) throws android.os.RemoteException;
public void preventScreenOn(boolean prevent) throws android.os.RemoteException;
public boolean isScreenOn() throws android.os.RemoteException;
public void reboot(java.lang.String reason) throws android.os.RemoteException;
public void crash(java.lang.String message) throws android.os.RemoteException;

public void setBacklightBrightness(int brightness) throws android.os.RemoteException;
public void setAttentionLight(boolean on, int color) throws android.os.RemoteException;
}
