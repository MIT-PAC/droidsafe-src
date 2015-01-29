/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./com/android/internal/app/IBatteryStats.aidl
 */
package com.android.internal.app;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IBatteryStats extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.android.internal.app.IBatteryStats
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.666 -0400", hash_original_field = "E95233E97A6420269A71F5CBBD4290E5", hash_generated_field = "024B9458208B03FC78BFFDDC713A2295")

private static final java.lang.String DESCRIPTOR = "com.android.internal.app.IBatteryStats";
/**
 * Cast an IBinder object into an com.android.internal.app.IBatteryStats interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.671 -0400", hash_original_method = "4659BC88E67B8E28BE59AF81D3BF633B", hash_generated_method = "F9E813FCA0C5EBF0689D838632584356")
        
public static com.android.internal.app.IBatteryStats asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.app.IBatteryStats))) {
return ((com.android.internal.app.IBatteryStats)iin);
}
return new com.android.internal.app.IBatteryStats.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.830 -0400", hash_original_field = "74471BC86DFC6133C7472AE0358074A1", hash_generated_field = "E8667F4928AF68AAC765900BEBE49A3F")

static final int TRANSACTION_getStatistics = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.833 -0400", hash_original_field = "9CB5D428E9C41BD4269312F6DE1B1001", hash_generated_field = "EAB25C53E249BEB0DA601DF36D0522DE")

static final int TRANSACTION_noteStartWakelock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.835 -0400", hash_original_field = "C1A5FD2E51F0B4343B810AA744505392", hash_generated_field = "A55D4F002C0F1475A445A0CA97809003")

static final int TRANSACTION_noteStopWakelock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.app.IBatteryStats
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.688 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.691 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.693 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.696 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.699 -0400", hash_original_method = "04C46D704E89AAA0874302F4FE5C7863", hash_generated_method = "4B8ACA189424DB7EAEF6A105F904B598")
            
public byte[] getStatistics() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getStatistics, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.702 -0400", hash_original_method = "C66021B1880905A98A6EA90E971BC0DC", hash_generated_method = "9428E893273A0FF895A2FD5EA3BD9DB9")
            
public void noteStartWakelock(int uid, int pid, java.lang.String name, int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(pid);
_data.writeString(name);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_noteStartWakelock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.705 -0400", hash_original_method = "A03BE02896A3141AF51E1491D9B7DB9D", hash_generated_method = "75BD4935BAB17035AA6108C8999DFCF4")
            
public void noteStopWakelock(int uid, int pid, java.lang.String name, int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(pid);
_data.writeString(name);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_noteStopWakelock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* DO NOT CHANGE the position of noteStartSensor without updating
       SensorService.cpp */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.708 -0400", hash_original_method = "E0E4442E29CB75E15E47E23EC44E4DEC", hash_generated_method = "201238C0874264096A9F824976FBA92A")
            
public void noteStartSensor(int uid, int sensor) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(sensor);
mRemote.transact(Stub.TRANSACTION_noteStartSensor, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* DO NOT CHANGE the position of noteStopSensor without updating
       SensorService.cpp */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.711 -0400", hash_original_method = "7C4B916BB0FA1860A1A7A481CD13D5D9", hash_generated_method = "7A87BB466939F8EA07A1E057EA4D15CA")
            
public void noteStopSensor(int uid, int sensor) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(sensor);
mRemote.transact(Stub.TRANSACTION_noteStopSensor, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.714 -0400", hash_original_method = "795BE35DC108C1BC0B8398590A1C253C", hash_generated_method = "A45311ADEA51C7EA2EEF0F665F7FC9F3")
            
public void noteStartWakelockFromSource(android.os.WorkSource ws, int pid, java.lang.String name, int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(pid);
_data.writeString(name);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_noteStartWakelockFromSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.717 -0400", hash_original_method = "BD3BE7A4F559EAE824B3A04C827E6306", hash_generated_method = "12ECEEBEF943E128EA5E50270BD22F5E")
            
public void noteStopWakelockFromSource(android.os.WorkSource ws, int pid, java.lang.String name, int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(pid);
_data.writeString(name);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_noteStopWakelockFromSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.719 -0400", hash_original_method = "419654A520FDF15B8FC6F32587538416", hash_generated_method = "E5C1C38BCA71775585572B808336DCB9")
            
public void noteStartGps(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_noteStartGps, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.722 -0400", hash_original_method = "9BB78A9ED28A29ED6579DD0F69855771", hash_generated_method = "D1970A6A32F39D594A80D212B5C7FCBB")
            
public void noteStopGps(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_noteStopGps, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.725 -0400", hash_original_method = "07978EC68259BFE4F9260D4DB4224D0D", hash_generated_method = "DEFD6F9C73C64323786204E1232C256B")
            
public void noteScreenOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_noteScreenOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.727 -0400", hash_original_method = "98B13E87B0571009284966E54D103021", hash_generated_method = "4B23581836BF426DBD643B49DD02FB04")
            
public void noteScreenBrightness(int brightness) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(brightness);
mRemote.transact(Stub.TRANSACTION_noteScreenBrightness, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.731 -0400", hash_original_method = "665897D2D29E2962396FD285DA425503", hash_generated_method = "1004A3C69903B888617C30A7BAFAA9B8")
            
public void noteScreenOff() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_noteScreenOff, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.733 -0400", hash_original_method = "111115DC3A969DA828C2047A3724B5F8", hash_generated_method = "80B1188C0DC36321A21857C27A37FDBE")
            
public void noteInputEvent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_noteInputEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.736 -0400", hash_original_method = "F569368DAD3E1925E89274E6FA4A7982", hash_generated_method = "F9E5F97A348D94DC30E551B2619CAF7F")
            
public void noteUserActivity(int uid, int event) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(event);
mRemote.transact(Stub.TRANSACTION_noteUserActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.739 -0400", hash_original_method = "D8D52B968DBF35F858B0D3029C504EF8", hash_generated_method = "68F7F8DEF92FE472B2BAEE3C83C62A79")
            
public void notePhoneOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_notePhoneOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.743 -0400", hash_original_method = "D298141A8A4A699740872DBCABCE61D5", hash_generated_method = "6795951A1547DBB5C42A159F4640FEDC")
            
public void notePhoneOff() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_notePhoneOff, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.746 -0400", hash_original_method = "2FA3BEC2D9D02D7C238DC65711F9CC1D", hash_generated_method = "7EF260A6D23A7AE72ACC0BC8C82FC03D")
            
public void notePhoneSignalStrength(android.telephony.SignalStrength signalStrength) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((signalStrength!=null)) {
_data.writeInt(1);
signalStrength.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_notePhoneSignalStrength, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.749 -0400", hash_original_method = "EC23C2A7767326863DB26CBD105FD9EB", hash_generated_method = "C5336CBA75B95E77E4CD303ADA2F5F12")
            
public void notePhoneDataConnectionState(int dataType, boolean hasData) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(dataType);
_data.writeInt(((hasData)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_notePhoneDataConnectionState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.753 -0400", hash_original_method = "73B0A966CDD7DC50729542D340F8B06E", hash_generated_method = "685DBBF9243FC3901708CFCF4E1CA89B")
            
public void notePhoneState(int phoneState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(phoneState);
mRemote.transact(Stub.TRANSACTION_notePhoneState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.756 -0400", hash_original_method = "14F890A70E89772126D330EB19FFE228", hash_generated_method = "9A20E49AD3131D88521E6E36D08175F0")
            
public void noteWifiOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_noteWifiOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.758 -0400", hash_original_method = "C5AF8BC1D6C12F7C8CA74FA0E96B9E26", hash_generated_method = "E461A7AE79FDB748FD7DBF8DE19CA874")
            
public void noteWifiOff() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_noteWifiOff, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.761 -0400", hash_original_method = "2560EC39A0E985EF6A92452B7F09518C", hash_generated_method = "5D3AEA5791DC71F10983970986B14412")
            
public void noteWifiRunning(android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteWifiRunning, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.763 -0400", hash_original_method = "734AF34E44EECAC0862CB70078ECC380", hash_generated_method = "145B960DD0C786650A97F381D2B2C20C")
            
public void noteWifiRunningChanged(android.os.WorkSource oldWs, android.os.WorkSource newWs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((oldWs!=null)) {
_data.writeInt(1);
oldWs.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((newWs!=null)) {
_data.writeInt(1);
newWs.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteWifiRunningChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.766 -0400", hash_original_method = "F53F012DEF38747952BBEB1364D41C29", hash_generated_method = "BA98F42F029A7AD90835861702B7BC12")
            
public void noteWifiStopped(android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteWifiStopped, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.769 -0400", hash_original_method = "C928BD3AE4A903DF96A78674EFA0567F", hash_generated_method = "51BD55A9340BA598BC30C55B4C9406D2")
            
public void noteBluetoothOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_noteBluetoothOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.772 -0400", hash_original_method = "51C55A93ECB7A8989C7E883F267CB9F9", hash_generated_method = "4DE100E27236223B18E7F220F39A10A2")
            
public void noteBluetoothOff() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_noteBluetoothOff, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.775 -0400", hash_original_method = "6D1B6016A206919738C3BA0AED72ED0F", hash_generated_method = "DADCB444E4B204E545A4E37D5B5D8CAD")
            
public void noteFullWifiLockAcquired(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_noteFullWifiLockAcquired, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.778 -0400", hash_original_method = "3091DC2FE1F8A3C0B9534E131566CB29", hash_generated_method = "3D37502EAF60841F84B2970F54D23DCB")
            
public void noteFullWifiLockReleased(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_noteFullWifiLockReleased, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.781 -0400", hash_original_method = "147731549F7D30A6801E731C4F0AACEE", hash_generated_method = "896329A5DD33165C1EE8A281C8D74710")
            
public void noteScanWifiLockAcquired(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_noteScanWifiLockAcquired, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.783 -0400", hash_original_method = "9201388A84504DA4367F862B49FA61B6", hash_generated_method = "F2E404E2907DC843B07B9BBB08644E1C")
            
public void noteScanWifiLockReleased(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_noteScanWifiLockReleased, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.786 -0400", hash_original_method = "33ECB0A137E26CC61591995FC5D2D783", hash_generated_method = "CC5404345B53149CF4EB99347E4CF4F2")
            
public void noteWifiMulticastEnabled(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_noteWifiMulticastEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.789 -0400", hash_original_method = "F4B7ED106E358C8CBB23C032EAB04B57", hash_generated_method = "AA1A462157FC98E71CE1BD6EFD259D9E")
            
public void noteWifiMulticastDisabled(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_noteWifiMulticastDisabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.792 -0400", hash_original_method = "20E3F608CD095F422460240467D5AFDE", hash_generated_method = "9A90FC791323011B29FB22818EE28983")
            
public void noteFullWifiLockAcquiredFromSource(android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteFullWifiLockAcquiredFromSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.795 -0400", hash_original_method = "B8EACE3A9A2B5BC32BE2C928051571DB", hash_generated_method = "5DED20A0419B99DE5129E5705B51E2BA")
            
public void noteFullWifiLockReleasedFromSource(android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteFullWifiLockReleasedFromSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.798 -0400", hash_original_method = "FEAFDC9A7D2AC530427C029CFD548A43", hash_generated_method = "54D50BC53A4F294C2F41744DAC90400D")
            
public void noteScanWifiLockAcquiredFromSource(android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteScanWifiLockAcquiredFromSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.801 -0400", hash_original_method = "023395E6A4B8B7BF161859BF99E85C2E", hash_generated_method = "E297A1EFB20B150D7F0FEDF01787E172")
            
public void noteScanWifiLockReleasedFromSource(android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteScanWifiLockReleasedFromSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.803 -0400", hash_original_method = "D6F963649219C3E1D94ED5F995E0F8AA", hash_generated_method = "D600192A790531BADBFB7620A0F75692")
            
public void noteWifiMulticastEnabledFromSource(android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteWifiMulticastEnabledFromSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.806 -0400", hash_original_method = "627B8FE92D731F18D806500BEA36CC19", hash_generated_method = "161709CAE22546139622A8781E25A9A1")
            
public void noteWifiMulticastDisabledFromSource(android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_noteWifiMulticastDisabledFromSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.809 -0400", hash_original_method = "D3E6C7C4BBF1C90E55C2A1DF88F8157B", hash_generated_method = "38070B93FAB2178E297E12024F305F60")
            
public void noteNetworkInterfaceType(java.lang.String iface, int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_noteNetworkInterfaceType, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.812 -0400", hash_original_method = "2F0923C0EEE138971EEA59D3931DADEF", hash_generated_method = "DA70FBEE759F5DD4C8A0FCD11D17BCFD")
            
public void setBatteryState(int status, int health, int plugType, int level, int temp, int volt) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
_data.writeInt(health);
_data.writeInt(plugType);
_data.writeInt(level);
_data.writeInt(temp);
_data.writeInt(volt);
mRemote.transact(Stub.TRANSACTION_setBatteryState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.815 -0400", hash_original_method = "79A2342EE9D517DC19E13FF7C286E752", hash_generated_method = "B954AA658711C504878D63F58B096C81")
            
public long getAwakeTimeBattery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAwakeTimeBattery, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.818 -0400", hash_original_method = "4517071D5061CDF0EAC7AAE7A31F9030", hash_generated_method = "96FEA611A849A2CA9F5378432516F853")
            
public long getAwakeTimePlugged() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAwakeTimePlugged, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.838 -0400", hash_original_field = "BB3C510CDD5E43CBB22BCDCB151DB280", hash_generated_field = "C319316E28288DAE1AB07D2C7F155E2C")

static final int TRANSACTION_noteStartSensor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.841 -0400", hash_original_field = "77F6FC6CFB13E1E16DAB23EEBC6B794F", hash_generated_field = "EA6AC1D91DCF5E901F37A534DDCC89CA")

static final int TRANSACTION_noteStopSensor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.844 -0400", hash_original_field = "C15DDFA2F0B677164F9D17A8B7CD57BF", hash_generated_field = "210128C59A1F014AFD5CD0FE34CABB37")

static final int TRANSACTION_noteStartWakelockFromSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.847 -0400", hash_original_field = "2D8C2C92C216DB8225583BFB3304B6F0", hash_generated_field = "7DDA314D31D9BF9A53D718F5D4F9F6E7")

static final int TRANSACTION_noteStopWakelockFromSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.849 -0400", hash_original_field = "4F6C71EBC50EE2FB7D245D4F70F5F2F9", hash_generated_field = "49B3F10A9130F73EDC1D84F32F161D46")

static final int TRANSACTION_noteStartGps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.853 -0400", hash_original_field = "3B1953BE3A60089C7682877CCEA80A4A", hash_generated_field = "D95A3F877D9E1F66F0A4A5C89C852C39")

static final int TRANSACTION_noteStopGps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.855 -0400", hash_original_field = "FA7296CC087DBF0385B00D841A96112B", hash_generated_field = "9EFD8E1DFE3727719350E4CA703B73BD")

static final int TRANSACTION_noteScreenOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.859 -0400", hash_original_field = "A1A42A8C0787E6E3B21FD953CFC96296", hash_generated_field = "A851AB1F6B62700F705E300570139AB0")

static final int TRANSACTION_noteScreenBrightness = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.862 -0400", hash_original_field = "D5629B5E1D0EE081D4562EBDC411A762", hash_generated_field = "555B960F5EDE1831751D84B7EF680BF2")

static final int TRANSACTION_noteScreenOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.864 -0400", hash_original_field = "667643DE23C6749F85340F2FB78711CB", hash_generated_field = "4BD3794C2E8B8A4592EF075F274F19A9")

static final int TRANSACTION_noteInputEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.867 -0400", hash_original_field = "7F2408A23F99606CB1797D26F5A50725", hash_generated_field = "811EADF25B283AC424F78273B4C6829F")

static final int TRANSACTION_noteUserActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.870 -0400", hash_original_field = "C151F417019357871DB572D7540FC3C4", hash_generated_field = "96C1EC30C865D66663FDF19C2689C987")

static final int TRANSACTION_notePhoneOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.873 -0400", hash_original_field = "AD59C24B513D273F6FC7FD458D89D82A", hash_generated_field = "5BE2FC06AD877E4503441CD62880D81F")

static final int TRANSACTION_notePhoneOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.875 -0400", hash_original_field = "A081689551779867B3E587A070B3352F", hash_generated_field = "FC7D967D760596EC3F7355A2A5CCFDD8")

static final int TRANSACTION_notePhoneSignalStrength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.878 -0400", hash_original_field = "213940F5B863BFF6009838B7B9EF0746", hash_generated_field = "4A5F312DB61AA496D2F2F16BC994C030")

static final int TRANSACTION_notePhoneDataConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.881 -0400", hash_original_field = "FCC24063BCABABC1C709CFA5A737D05E", hash_generated_field = "CD293CF0EC4C24EBC30D9BE8D232766A")

static final int TRANSACTION_notePhoneState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.884 -0400", hash_original_field = "B1FD9C87C1BB5F839DABB9C41EEDC7D2", hash_generated_field = "A11EEA92FF0A53A39B8F1D47569B6FDB")

static final int TRANSACTION_noteWifiOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.887 -0400", hash_original_field = "9BDE607A751C769272E3C87B4E0FD6D0", hash_generated_field = "7470450FC7A21C27A53E9AB842E87FC1")

static final int TRANSACTION_noteWifiOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.890 -0400", hash_original_field = "7C5D5D584DF17308161F91BD84F7FC35", hash_generated_field = "49396C9A4B787E14FB65801C46E032A4")

static final int TRANSACTION_noteWifiRunning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.893 -0400", hash_original_field = "DF8FFC64FC1B5D40C1BAD434BE3F164D", hash_generated_field = "4B1B0693B83321D540FE151598207899")

static final int TRANSACTION_noteWifiRunningChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.896 -0400", hash_original_field = "6DCB7B2634D8D279A1050ABDA3381F5B", hash_generated_field = "EE2A6E8DE2E1D9C2AFA354BAF6DDBCC9")

static final int TRANSACTION_noteWifiStopped = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.899 -0400", hash_original_field = "F98A893A274DA5E17D88076C34819BE9", hash_generated_field = "F07F0D792F84D63D246845ED7A21F0EF")

static final int TRANSACTION_noteBluetoothOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.901 -0400", hash_original_field = "F84A27E2EDF2669AA1DB50363C06B173", hash_generated_field = "9829910A620011E13D8486CB3CC994CD")

static final int TRANSACTION_noteBluetoothOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.905 -0400", hash_original_field = "1C17489CA6D165AFDE2E49CB4ECD0B63", hash_generated_field = "D29CE4B8A4BA98972AEC93626DB8D5F4")

static final int TRANSACTION_noteFullWifiLockAcquired = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.908 -0400", hash_original_field = "E9488498CB3748E26031AB674C749808", hash_generated_field = "389E00CDD85DA76C38BE08AB41B930BC")

static final int TRANSACTION_noteFullWifiLockReleased = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.910 -0400", hash_original_field = "7D702CB21158C5CD22C4FDE9A17DDEE1", hash_generated_field = "A39D1DB6243032AD67118171A8008F88")

static final int TRANSACTION_noteScanWifiLockAcquired = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.915 -0400", hash_original_field = "A128323BD0EAFCCFE5F8CBB159DE8F3D", hash_generated_field = "ACA7D7CE8C1A1AAD9288A3F1B22860A4")

static final int TRANSACTION_noteScanWifiLockReleased = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.917 -0400", hash_original_field = "4CB74ED66891CADFA832BFD3CD1297EA", hash_generated_field = "A81D767EAC4308DD24CD09BBDEE94065")

static final int TRANSACTION_noteWifiMulticastEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.921 -0400", hash_original_field = "CA73CC4331F419912A0CF7B8CFF773D0", hash_generated_field = "36348C2533BAFCF9902DAD2F33221CFB")

static final int TRANSACTION_noteWifiMulticastDisabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.923 -0400", hash_original_field = "E6707C131DD6C385CE5ECD7A0D01B161", hash_generated_field = "6ADADB732851D3040DFAF55FB2444D20")

static final int TRANSACTION_noteFullWifiLockAcquiredFromSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.926 -0400", hash_original_field = "DE9B8336D6A7D215FF19B55D082799D9", hash_generated_field = "C7A8FBA8D94A7453D46E92A825823D8D")

static final int TRANSACTION_noteFullWifiLockReleasedFromSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.930 -0400", hash_original_field = "C8F355A9DC55273EB0996F8FBC7711F3", hash_generated_field = "3F9902253F05D030BD552713041F7245")

static final int TRANSACTION_noteScanWifiLockAcquiredFromSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.932 -0400", hash_original_field = "7296867E8936F419794ECFFFC436558B", hash_generated_field = "E200AE2772D23A3754025AC9B17BDA96")

static final int TRANSACTION_noteScanWifiLockReleasedFromSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.935 -0400", hash_original_field = "45D5DD56FC0AD88FF18428379EABA459", hash_generated_field = "97CDC15257118F0E444DC674ADD956C7")

static final int TRANSACTION_noteWifiMulticastEnabledFromSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.938 -0400", hash_original_field = "3E36C7F4F04B571EBF062A569A4168DF", hash_generated_field = "38DBAC743B9A51B87F4D8DDB4DE013CD")

static final int TRANSACTION_noteWifiMulticastDisabledFromSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.940 -0400", hash_original_field = "05B12E42041495FEE8BF251080246E26", hash_generated_field = "F8E9FE57C4B4C22EE6CF839BC695C64B")

static final int TRANSACTION_noteNetworkInterfaceType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.943 -0400", hash_original_field = "E60229CDB864DF17E0D71A63A0A18315", hash_generated_field = "5BD8E0BCEA746CCFFAC3CCCBCFE9D251")

static final int TRANSACTION_setBatteryState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.946 -0400", hash_original_field = "A8A0E0D71E9CCB7D9ECC15ED34A1E5F9", hash_generated_field = "958C8C979BC5F0CE881AE076A7E7CD5C")

static final int TRANSACTION_getAwakeTimeBattery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.949 -0400", hash_original_field = "16714E4A9C49A223D1A4F3A4C17B79EA", hash_generated_field = "9998D9785E651B791D2F73FBD09567F0")

static final int TRANSACTION_getAwakeTimePlugged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.668 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.673 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:07.684 -0400", hash_original_method = "CDE64C1A626010D6A59C4E81A9755362", hash_generated_method = "D0E1B7FB2D83C2C314200785651AC5FB")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getStatistics:
{
data.enforceInterface(DESCRIPTOR);
byte[] _result = this.getStatistics();
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_noteStartWakelock:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
int _arg3;
_arg3 = data.readInt();
this.noteStartWakelock(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_noteStopWakelock:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
int _arg3;
_arg3 = data.readInt();
this.noteStopWakelock(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_noteStartSensor:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.noteStartSensor(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_noteStopSensor:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.noteStopSensor(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_noteStartWakelockFromSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
int _arg3;
_arg3 = data.readInt();
this.noteStartWakelockFromSource(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_noteStopWakelockFromSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
int _arg3;
_arg3 = data.readInt();
this.noteStopWakelockFromSource(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_noteStartGps:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteStartGps(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteStopGps:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteStopGps(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteScreenOn:
{
data.enforceInterface(DESCRIPTOR);
this.noteScreenOn();
reply.writeNoException();
return true;
}
case TRANSACTION_noteScreenBrightness:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteScreenBrightness(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteScreenOff:
{
data.enforceInterface(DESCRIPTOR);
this.noteScreenOff();
reply.writeNoException();
return true;
}
case TRANSACTION_noteInputEvent:
{
data.enforceInterface(DESCRIPTOR);
this.noteInputEvent();
reply.writeNoException();
return true;
}
case TRANSACTION_noteUserActivity:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.noteUserActivity(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_notePhoneOn:
{
data.enforceInterface(DESCRIPTOR);
this.notePhoneOn();
reply.writeNoException();
return true;
}
case TRANSACTION_notePhoneOff:
{
data.enforceInterface(DESCRIPTOR);
this.notePhoneOff();
reply.writeNoException();
return true;
}
case TRANSACTION_notePhoneSignalStrength:
{
data.enforceInterface(DESCRIPTOR);
android.telephony.SignalStrength _arg0;
if ((0!=data.readInt())) {
_arg0 = android.telephony.SignalStrength.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.notePhoneSignalStrength(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notePhoneDataConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.notePhoneDataConnectionState(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_notePhoneState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.notePhoneState(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiOn:
{
data.enforceInterface(DESCRIPTOR);
this.noteWifiOn();
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiOff:
{
data.enforceInterface(DESCRIPTOR);
this.noteWifiOff();
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiRunning:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteWifiRunning(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiRunningChanged:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.WorkSource _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.noteWifiRunningChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiStopped:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteWifiStopped(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteBluetoothOn:
{
data.enforceInterface(DESCRIPTOR);
this.noteBluetoothOn();
reply.writeNoException();
return true;
}
case TRANSACTION_noteBluetoothOff:
{
data.enforceInterface(DESCRIPTOR);
this.noteBluetoothOff();
reply.writeNoException();
return true;
}
case TRANSACTION_noteFullWifiLockAcquired:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteFullWifiLockAcquired(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteFullWifiLockReleased:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteFullWifiLockReleased(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteScanWifiLockAcquired:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteScanWifiLockAcquired(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteScanWifiLockReleased:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteScanWifiLockReleased(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiMulticastEnabled:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteWifiMulticastEnabled(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiMulticastDisabled:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.noteWifiMulticastDisabled(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteFullWifiLockAcquiredFromSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteFullWifiLockAcquiredFromSource(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteFullWifiLockReleasedFromSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteFullWifiLockReleasedFromSource(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteScanWifiLockAcquiredFromSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteScanWifiLockAcquiredFromSource(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteScanWifiLockReleasedFromSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteScanWifiLockReleasedFromSource(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiMulticastEnabledFromSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteWifiMulticastEnabledFromSource(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteWifiMulticastDisabledFromSource:
{
data.enforceInterface(DESCRIPTOR);
android.os.WorkSource _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.noteWifiMulticastDisabledFromSource(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_noteNetworkInterfaceType:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.noteNetworkInterfaceType(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setBatteryState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
int _arg5;
_arg5 = data.readInt();
this.setBatteryState(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_getAwakeTimeBattery:
{
data.enforceInterface(DESCRIPTOR);
long _result = this.getAwakeTimeBattery();
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_getAwakeTimePlugged:
{
data.enforceInterface(DESCRIPTOR);
long _result = this.getAwakeTimePlugged();
reply.writeNoException();
reply.writeLong(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public byte[] getStatistics() throws android.os.RemoteException;
public void noteStartWakelock(int uid, int pid, java.lang.String name, int type) throws android.os.RemoteException;
public void noteStopWakelock(int uid, int pid, java.lang.String name, int type) throws android.os.RemoteException;
/* DO NOT CHANGE the position of noteStartSensor without updating
       SensorService.cpp */
public void noteStartSensor(int uid, int sensor) throws android.os.RemoteException;
/* DO NOT CHANGE the position of noteStopSensor without updating
       SensorService.cpp */
public void noteStopSensor(int uid, int sensor) throws android.os.RemoteException;
public void noteStartWakelockFromSource(android.os.WorkSource ws, int pid, java.lang.String name, int type) throws android.os.RemoteException;
public void noteStopWakelockFromSource(android.os.WorkSource ws, int pid, java.lang.String name, int type) throws android.os.RemoteException;
public void noteStartGps(int uid) throws android.os.RemoteException;
public void noteStopGps(int uid) throws android.os.RemoteException;
public void noteScreenOn() throws android.os.RemoteException;
public void noteScreenBrightness(int brightness) throws android.os.RemoteException;
public void noteScreenOff() throws android.os.RemoteException;
public void noteInputEvent() throws android.os.RemoteException;
public void noteUserActivity(int uid, int event) throws android.os.RemoteException;
public void notePhoneOn() throws android.os.RemoteException;
public void notePhoneOff() throws android.os.RemoteException;
public void notePhoneSignalStrength(android.telephony.SignalStrength signalStrength) throws android.os.RemoteException;
public void notePhoneDataConnectionState(int dataType, boolean hasData) throws android.os.RemoteException;
public void notePhoneState(int phoneState) throws android.os.RemoteException;
public void noteWifiOn() throws android.os.RemoteException;
public void noteWifiOff() throws android.os.RemoteException;
public void noteWifiRunning(android.os.WorkSource ws) throws android.os.RemoteException;
public void noteWifiRunningChanged(android.os.WorkSource oldWs, android.os.WorkSource newWs) throws android.os.RemoteException;
public void noteWifiStopped(android.os.WorkSource ws) throws android.os.RemoteException;
public void noteBluetoothOn() throws android.os.RemoteException;
public void noteBluetoothOff() throws android.os.RemoteException;
public void noteFullWifiLockAcquired(int uid) throws android.os.RemoteException;
public void noteFullWifiLockReleased(int uid) throws android.os.RemoteException;
public void noteScanWifiLockAcquired(int uid) throws android.os.RemoteException;
public void noteScanWifiLockReleased(int uid) throws android.os.RemoteException;
public void noteWifiMulticastEnabled(int uid) throws android.os.RemoteException;
public void noteWifiMulticastDisabled(int uid) throws android.os.RemoteException;
public void noteFullWifiLockAcquiredFromSource(android.os.WorkSource ws) throws android.os.RemoteException;
public void noteFullWifiLockReleasedFromSource(android.os.WorkSource ws) throws android.os.RemoteException;
public void noteScanWifiLockAcquiredFromSource(android.os.WorkSource ws) throws android.os.RemoteException;
public void noteScanWifiLockReleasedFromSource(android.os.WorkSource ws) throws android.os.RemoteException;
public void noteWifiMulticastEnabledFromSource(android.os.WorkSource ws) throws android.os.RemoteException;
public void noteWifiMulticastDisabledFromSource(android.os.WorkSource ws) throws android.os.RemoteException;
public void noteNetworkInterfaceType(java.lang.String iface, int type) throws android.os.RemoteException;
public void setBatteryState(int status, int health, int plugType, int level, int temp, int volt) throws android.os.RemoteException;
public long getAwakeTimeBattery() throws android.os.RemoteException;
public long getAwakeTimePlugged() throws android.os.RemoteException;
}
