package android.hardware.usb;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IUsbManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.hardware.usb.IUsbManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.039 -0500", hash_original_field = "04E9BADD7281D3CEA669FBA9AE1CF99F", hash_generated_field = "C0AD9FFA85C626AE243EF343FF114146")

private static final java.lang.String DESCRIPTOR = "android.hardware.usb.IUsbManager";
/**
 * Cast an IBinder object into an android.hardware.usb.IUsbManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.046 -0500", hash_original_method = "04A9200E3FEA377B5BCD10FE311F2B3D", hash_generated_method = "E168CE2F9472135BBECA4DD151B6E108")
        
public static android.hardware.usb.IUsbManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.hardware.usb.IUsbManager))) {
return ((android.hardware.usb.IUsbManager)iin);
}
return new android.hardware.usb.IUsbManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.132 -0500", hash_original_field = "4524C75761CD2EE8201389C4D14F1D55", hash_generated_field = "853A87470BE39317ABBCEF1BE5FF39D6")

static final int TRANSACTION_getDeviceList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.135 -0500", hash_original_field = "AB343874FF0843723E1B0B92FA405453", hash_generated_field = "8F5E5C12D52387E26369DC00774AA6E9")

static final int TRANSACTION_openDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.137 -0500", hash_original_field = "2A9C299F9E9F3AD1BDE2AFDEE1930457", hash_generated_field = "93515A1FC1BDC9B5EFAB78569DD7B111")

static final int TRANSACTION_getCurrentAccessory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.hardware.usb.IUsbManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.059 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.063 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.066 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.069 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/* Returns a list of all currently attached USB devices */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.073 -0500", hash_original_method = "9D2803F4CAA429A675203EF51EAF7234", hash_generated_method = "9C554C2451B8B169AB3CC0AC14504DA4")
            
public void getDeviceList(android.os.Bundle devices) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDeviceList, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
devices.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Returns a file descriptor for communicating with the USB device.
     * The native fd can be passed to usb_device_new() in libusbhost.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.076 -0500", hash_original_method = "6531DD15A9DAF1E7160F65A4D62D5C33", hash_generated_method = "6E0488910F26333833713C7A0A0486AA")
            
public android.os.ParcelFileDescriptor openDevice(java.lang.String deviceName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelFileDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceName);
mRemote.transact(Stub.TRANSACTION_openDevice, _data, _reply, 0);
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
/* Returns the currently attached USB accessory */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.079 -0500", hash_original_method = "ED1A2E11D50840822A2B7466F050282E", hash_generated_method = "5C7B3F33F40A64F5805C3C52E16313AF")
            
public android.hardware.usb.UsbAccessory getCurrentAccessory() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.hardware.usb.UsbAccessory _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentAccessory, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.hardware.usb.UsbAccessory.CREATOR.createFromParcel(_reply);
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
/* Returns a file descriptor for communicating with the USB accessory.
     * This file descriptor can be used with standard Java file operations.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.082 -0500", hash_original_method = "E2A714CC6F90168343671E5DE8E2FBA3", hash_generated_method = "BEA9900ABDD828F788F45EFA6FF8AADC")
            
public android.os.ParcelFileDescriptor openAccessory(android.hardware.usb.UsbAccessory accessory) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelFileDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((accessory!=null)) {
_data.writeInt(1);
accessory.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_openAccessory, _data, _reply, 0);
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
/* Sets the default package for a USB device
     * (or clears it if the package name is null)
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.086 -0500", hash_original_method = "4A7AA16DA9C9EB00BA94CAA35438A459", hash_generated_method = "A0EB69210314CC1FB97024D267CCD920")
            
public void setDevicePackage(android.hardware.usb.UsbDevice device, java.lang.String packageName) throws android.os.RemoteException
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
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_setDevicePackage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Sets the default package for a USB accessory
     * (or clears it if the package name is null)
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.089 -0500", hash_original_method = "026C669900E2B55DA2698813708A6D4D", hash_generated_method = "8EB550FF657A55648C9DC469714233E5")
            
public void setAccessoryPackage(android.hardware.usb.UsbAccessory accessory, java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((accessory!=null)) {
_data.writeInt(1);
accessory.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_setAccessoryPackage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Returns true if the caller has permission to access the device. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.092 -0500", hash_original_method = "ED58F7B85B5B464C372E2F6212EE3D80", hash_generated_method = "A9B43E095C9D21BE34117FB04A662271")
            
public boolean hasDevicePermission(android.hardware.usb.UsbDevice device) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_hasDevicePermission, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/* Returns true if the caller has permission to access the accessory. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.095 -0500", hash_original_method = "5C1B5AD999E2BDFB6B40F35675DAA210", hash_generated_method = "BD8C38C2EFC59B0BF299A0EC064463CE")
            
public boolean hasAccessoryPermission(android.hardware.usb.UsbAccessory accessory) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((accessory!=null)) {
_data.writeInt(1);
accessory.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_hasAccessoryPermission, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/* Requests permission for the given package to access the device.
     * Will display a system dialog to query the user if permission
     * had not already been given.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.098 -0500", hash_original_method = "E289321CA4F9269177E8CBACBBB16F71", hash_generated_method = "DF668ED88E734835E0C1DF197BDA8F74")
            
public void requestDevicePermission(android.hardware.usb.UsbDevice device, java.lang.String packageName, android.app.PendingIntent pi) throws android.os.RemoteException
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
_data.writeString(packageName);
if ((pi!=null)) {
_data.writeInt(1);
pi.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_requestDevicePermission, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Requests permission for the given package to access the accessory.
     * Will display a system dialog to query the user if permission
     * had not already been given. Result is returned via pi.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.101 -0500", hash_original_method = "840FA7837BFA6C773AD57BAB75BE0B4A", hash_generated_method = "E3A801CE45E86EDBB96DA4D593246C16")
            
public void requestAccessoryPermission(android.hardware.usb.UsbAccessory accessory, java.lang.String packageName, android.app.PendingIntent pi) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((accessory!=null)) {
_data.writeInt(1);
accessory.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(packageName);
if ((pi!=null)) {
_data.writeInt(1);
pi.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_requestAccessoryPermission, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Grants permission for the given UID to access the device */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.105 -0500", hash_original_method = "D5486B8892CEC301752119034DCA6A5E", hash_generated_method = "7699B8A631B6F99FB56CEDF6041BC7F6")
            
public void grantDevicePermission(android.hardware.usb.UsbDevice device, int uid) throws android.os.RemoteException
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
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_grantDevicePermission, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Grants permission for the given UID to access the accessory */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.109 -0500", hash_original_method = "0B326377BAAEC3A9D46812988FF76719", hash_generated_method = "5D103C2488DC55F5CCCBC26D9D716EAE")
            
public void grantAccessoryPermission(android.hardware.usb.UsbAccessory accessory, int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((accessory!=null)) {
_data.writeInt(1);
accessory.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_grantAccessoryPermission, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Returns true if the USB manager has default preferences or permissions for the package */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.111 -0500", hash_original_method = "E5B99C02151D61D7E10819090FB78D72", hash_generated_method = "C1A8CC15740C3F2DAB2D2E7E982AD8C3")
            
public boolean hasDefaults(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_hasDefaults, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/* Clears default preferences and permissions for the package */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.115 -0500", hash_original_method = "1155A169E4BD4C2E6256F25B48EC2E47", hash_generated_method = "ED0FB090D153E52694665A06B93E7046")
            
public void clearDefaults(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_clearDefaults, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Sets the current USB function. */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.118 -0500", hash_original_method = "F1E9C3A75F42EB012931CF5A5556E395", hash_generated_method = "FE94F841BE6665B1658E0D9188B73252")
            
public void setCurrentFunction(java.lang.String function, boolean makeDefault) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(function);
_data.writeInt(((makeDefault)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setCurrentFunction, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Sets the file path for USB mass storage backing file. */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.121 -0500", hash_original_method = "34469F6A0831921C640AA6CBAC8DFBCD", hash_generated_method = "19294A2B4C294F9EFA9046E93165A59C")
            
public void setMassStorageBackingFile(java.lang.String path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
mRemote.transact(Stub.TRANSACTION_setMassStorageBackingFile, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.140 -0500", hash_original_field = "80A6A429E718F0DFCC30F194C529E3D9", hash_generated_field = "0F44DAF2BDEC2CE0E243119DEB1C987B")

static final int TRANSACTION_openAccessory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.142 -0500", hash_original_field = "F3652849C7A17BB66CDC641FD72AD6E0", hash_generated_field = "01084ED7E7FDEC9D776C85600D59D788")

static final int TRANSACTION_setDevicePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.145 -0500", hash_original_field = "404F70C0EE79DB88212D649770D077EA", hash_generated_field = "FAB6C3E38A6BF91C9EB45EC63C3506D7")

static final int TRANSACTION_setAccessoryPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.147 -0500", hash_original_field = "25B89173E2F551F14B0607AA8B3A1E09", hash_generated_field = "EAD6F5F220BEAE03AA1D510CF349B0C2")

static final int TRANSACTION_hasDevicePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.151 -0500", hash_original_field = "DFFF5797454488464E10B5CFEE0370F0", hash_generated_field = "8814E50EA42A1626831DAB8EF5EE8F12")

static final int TRANSACTION_hasAccessoryPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.153 -0500", hash_original_field = "9F93409156F1AC29BE5C64111BC96DE2", hash_generated_field = "370D8026E7E2D9F7BC2A7BF79319E34F")

static final int TRANSACTION_requestDevicePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.156 -0500", hash_original_field = "965B575A13D2073BD3AD943DDCA19798", hash_generated_field = "8C566A32019B83546EF295A696664F9B")

static final int TRANSACTION_requestAccessoryPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.159 -0500", hash_original_field = "B8AF2A9194C2A9637A06D861B8AEB42E", hash_generated_field = "62DF9458A0F191D4D520BE1C17ACC913")

static final int TRANSACTION_grantDevicePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.162 -0500", hash_original_field = "8285DEB2B6F8B9BDD0C707F5B31367CD", hash_generated_field = "B6E62E3978D36FDABF9EE33ED0036E1D")

static final int TRANSACTION_grantAccessoryPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.165 -0500", hash_original_field = "FBCC8A5BC8861E6BA511408834EAAC0E", hash_generated_field = "2665DDAA2B0CE8F62022DA1273B6983D")

static final int TRANSACTION_hasDefaults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.168 -0500", hash_original_field = "E9D42A2A0CDC5AEDD4881240B865C13E", hash_generated_field = "006BC04F04ABB6C630A33B387BB4252A")

static final int TRANSACTION_clearDefaults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.170 -0500", hash_original_field = "10136BEEEB927064F073D371EA9F2933", hash_generated_field = "EE45FBEC3FCB8E81DF6FC9F5159C5F67")

static final int TRANSACTION_setCurrentFunction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.173 -0500", hash_original_field = "FF93AD9197E41871928F86BE72D4938D", hash_generated_field = "D36C6197C0AB096250A5435C241D503C")

static final int TRANSACTION_setMassStorageBackingFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.042 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.048 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.055 -0500", hash_original_method = "706A07E0AFCE5268589DECA041167E21", hash_generated_method = "B611CDAA2B458C265F6D5C283960F7B5")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getDeviceList:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _arg0;
_arg0 = new android.os.Bundle();
this.getDeviceList(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_openDevice:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.ParcelFileDescriptor _result = this.openDevice(_arg0);
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
case TRANSACTION_getCurrentAccessory:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbAccessory _result = this.getCurrentAccessory();
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
case TRANSACTION_openAccessory:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbAccessory _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbAccessory.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.ParcelFileDescriptor _result = this.openAccessory(_arg0);
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
case TRANSACTION_setDevicePackage:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
this.setDevicePackage(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setAccessoryPackage:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbAccessory _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbAccessory.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
this.setAccessoryPackage(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_hasDevicePermission:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.hasDevicePermission(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_hasAccessoryPermission:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbAccessory _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbAccessory.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.hasAccessoryPermission(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_requestDevicePermission:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
android.app.PendingIntent _arg2;
if ((0!=data.readInt())) {
_arg2 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.requestDevicePermission(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_requestAccessoryPermission:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbAccessory _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbAccessory.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
android.app.PendingIntent _arg2;
if ((0!=data.readInt())) {
_arg2 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.requestAccessoryPermission(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_grantDevicePermission:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbDevice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbDevice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.grantDevicePermission(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_grantAccessoryPermission:
{
data.enforceInterface(DESCRIPTOR);
android.hardware.usb.UsbAccessory _arg0;
if ((0!=data.readInt())) {
_arg0 = android.hardware.usb.UsbAccessory.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.grantAccessoryPermission(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_hasDefaults:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.hasDefaults(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_clearDefaults:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearDefaults(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setCurrentFunction:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setCurrentFunction(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setMassStorageBackingFile:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setMassStorageBackingFile(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void getDeviceList(android.os.Bundle devices) throws android.os.RemoteException;

public android.os.ParcelFileDescriptor openDevice(java.lang.String deviceName) throws android.os.RemoteException;

public android.hardware.usb.UsbAccessory getCurrentAccessory() throws android.os.RemoteException;

public android.os.ParcelFileDescriptor openAccessory(android.hardware.usb.UsbAccessory accessory) throws android.os.RemoteException;

public void setDevicePackage(android.hardware.usb.UsbDevice device, java.lang.String packageName) throws android.os.RemoteException;

public void setAccessoryPackage(android.hardware.usb.UsbAccessory accessory, java.lang.String packageName) throws android.os.RemoteException;

public boolean hasDevicePermission(android.hardware.usb.UsbDevice device) throws android.os.RemoteException;

public boolean hasAccessoryPermission(android.hardware.usb.UsbAccessory accessory) throws android.os.RemoteException;

public void requestDevicePermission(android.hardware.usb.UsbDevice device, java.lang.String packageName, android.app.PendingIntent pi) throws android.os.RemoteException;

public void requestAccessoryPermission(android.hardware.usb.UsbAccessory accessory, java.lang.String packageName, android.app.PendingIntent pi) throws android.os.RemoteException;

public void grantDevicePermission(android.hardware.usb.UsbDevice device, int uid) throws android.os.RemoteException;

public void grantAccessoryPermission(android.hardware.usb.UsbAccessory accessory, int uid) throws android.os.RemoteException;

public boolean hasDefaults(java.lang.String packageName) throws android.os.RemoteException;

public void clearDefaults(java.lang.String packageName) throws android.os.RemoteException;

public void setCurrentFunction(java.lang.String function, boolean makeDefault) throws android.os.RemoteException;

public void setMassStorageBackingFile(java.lang.String path) throws android.os.RemoteException;
}
