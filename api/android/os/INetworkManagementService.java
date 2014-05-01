/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/os/INetworkManagementService.aidl
 */
package android.os;
/**
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface INetworkManagementService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.os.INetworkManagementService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.884 -0400", hash_original_field = "72EE7EC67842E19A225606BDB387E032", hash_generated_field = "55499049E7651CC460A1508DA5221561")

private static final java.lang.String DESCRIPTOR = "android.os.INetworkManagementService";
/**
 * Cast an IBinder object into an android.os.INetworkManagementService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.889 -0400", hash_original_method = "DA8F480471B311B6ECA47013FC1CC483", hash_generated_method = "66544AE20D5E52F0355EBC002B636263")
        
public static android.os.INetworkManagementService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.os.INetworkManagementService))) {
return ((android.os.INetworkManagementService)iin);
}
return new android.os.INetworkManagementService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.078 -0400", hash_original_field = "FCF1C55D41E665C33B36AB95BFBC8191", hash_generated_field = "E227C50885BDC5E4AFE55C324A8D28DC")

static final int TRANSACTION_registerObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.081 -0400", hash_original_field = "B26170D857A07EAF3FFFDC648B79EADA", hash_generated_field = "2719C0B37EC4E5A0E00EA6070C28F2C6")

static final int TRANSACTION_unregisterObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.084 -0400", hash_original_field = "83CA618C8B51CB4014BAB6F3F7443689", hash_generated_field = "840DC9B59F5BFCECF0F3DBAB240B77E7")

static final int TRANSACTION_listInterfaces = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.os.INetworkManagementService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.907 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.910 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.912 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.914 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     ** GENERAL
     *//**
     * Register an observer to receive events
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.917 -0400", hash_original_method = "33232B451DA052679F2029E225B76FC0", hash_generated_method = "E53A61492B9432BA9BCC361ACC418928")
            
public void registerObserver(android.net.INetworkManagementEventObserver obs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((obs!=null))?(obs.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerObserver, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Unregister an observer from receiving events.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.919 -0400", hash_original_method = "879BA075FBF712C61010CB4419A441B3", hash_generated_method = "0EF19C638EAF79DD2FE225EB2E0AF718")
            
public void unregisterObserver(android.net.INetworkManagementEventObserver obs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((obs!=null))?(obs.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterObserver, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Returns a list of currently known network interfaces
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.922 -0400", hash_original_method = "7DE960530F7CB2114FC5A9409FFB9161", hash_generated_method = "32C6C71E8A8856A7748BCC4412C76CED")
            
public java.lang.String[] listInterfaces() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_listInterfaces, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieves the specified interface config
     *
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.926 -0400", hash_original_method = "882530203C0655D40CB4C05B3D5A8BFB", hash_generated_method = "8B52FF76BB83C305B3D1199BEC30AFF8")
            
public android.net.InterfaceConfiguration getInterfaceConfig(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.InterfaceConfiguration _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_getInterfaceConfig, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.InterfaceConfiguration.CREATOR.createFromParcel(_reply);
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
/**
     * Sets the configuration of the specified interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.929 -0400", hash_original_method = "99FAB3537BDC537C1F81835DBD06C5E0", hash_generated_method = "B62D73A3DA5E5E63AB4CA372DBD38767")
            
public void setInterfaceConfig(java.lang.String iface, android.net.InterfaceConfiguration cfg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
if ((cfg!=null)) {
_data.writeInt(1);
cfg.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setInterfaceConfig, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Clear all IP addresses on the specified interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.931 -0400", hash_original_method = "D52ACC044E73D8FF6821C1C0FAA814B0", hash_generated_method = "4D58085A2DF114A816CECDD9FFB77BD0")
            
public void clearInterfaceAddresses(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_clearInterfaceAddresses, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set interface down
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.934 -0400", hash_original_method = "8A88B61440D0CC3F43A04233B446D4A6", hash_generated_method = "7778C73EDF0980118828B11E5F1FA2F9")
            
public void setInterfaceDown(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_setInterfaceDown, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set interface up
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.936 -0400", hash_original_method = "14A0FA05F26F45DD57A9F7DC83B9B1E5", hash_generated_method = "96CB61D05A9EA4C5DFBECE241B3363BF")
            
public void setInterfaceUp(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_setInterfaceUp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set interface IPv6 privacy extensions
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.939 -0400", hash_original_method = "50313B225A49DB1D4A045FF75FDB2A4E", hash_generated_method = "33C84ABF14BE2B8F0253B119FD079117")
            
public void setInterfaceIpv6PrivacyExtensions(java.lang.String iface, boolean enable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeInt(((enable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setInterfaceIpv6PrivacyExtensions, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Disable IPv6 on an interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.941 -0400", hash_original_method = "277F2E37A5EFD65A74CFBCECAF57482E", hash_generated_method = "B32E96A575D3BB1C797B8C69F2772DF2")
            
public void disableIpv6(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_disableIpv6, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Enable IPv6 on an interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.943 -0400", hash_original_method = "EE083BD794164BBA6AE87A58A24D0351", hash_generated_method = "236E78A5B9FB7FE9084C67363CE5C216")
            
public void enableIpv6(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_enableIpv6, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Retrieves the network routes currently configured on the specified
     * interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.946 -0400", hash_original_method = "730057A1DE72D1753F6B23CDF7234092", hash_generated_method = "6F85C73F715F19E147FE01B00FE62F23")
            
public android.net.RouteInfo[] getRoutes(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.RouteInfo[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_getRoutes, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.net.RouteInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Add the specified route to the interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.949 -0400", hash_original_method = "DA259FA649F6A8836BD0192FC35614CF", hash_generated_method = "E96F95EA0CD9B7273606F1B8E19B11F3")
            
public void addRoute(java.lang.String iface, android.net.RouteInfo route) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
if ((route!=null)) {
_data.writeInt(1);
route.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addRoute, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Remove the specified route from the interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.953 -0400", hash_original_method = "49CB6E9909168F9A902A9C14188BA653", hash_generated_method = "749113C8DB7581C76246B769645A0CF6")
            
public void removeRoute(java.lang.String iface, android.net.RouteInfo route) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
if ((route!=null)) {
_data.writeInt(1);
route.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removeRoute, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Add the specified route to a secondary interface
     * This will go into a special route table to be accessed
     * via ip rules
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.955 -0400", hash_original_method = "0E0DD29CA924DEFE360D3A2C2948C0F7", hash_generated_method = "C52BCF95E73939219B159C85AF5CE771")
            
public void addSecondaryRoute(java.lang.String iface, android.net.RouteInfo route) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
if ((route!=null)) {
_data.writeInt(1);
route.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addSecondaryRoute, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Remove the specified secondary route.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.958 -0400", hash_original_method = "7E1E4B25F40D659672FD7F3EFCDC8164", hash_generated_method = "58EA30A9E93BD026213FDC95471961DE")
            
public void removeSecondaryRoute(java.lang.String iface, android.net.RouteInfo route) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
if ((route!=null)) {
_data.writeInt(1);
route.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removeSecondaryRoute, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Shuts down the service
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.961 -0400", hash_original_method = "DC8345EC2BD430B834250ECEED6CBDB7", hash_generated_method = "4B9BB19DF0967F1D324715B60395B62A")
            
public void shutdown() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_shutdown, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     ** TETHERING RELATED
     *//**
     * Returns true if IP forwarding is enabled
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.963 -0400", hash_original_method = "263CF34CB80CB16C29B992C07F571A23", hash_generated_method = "4DDCA65B5485F7231E8B30F7DC75FA53")
            
public boolean getIpForwardingEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIpForwardingEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Enables/Disables IP Forwarding
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.966 -0400", hash_original_method = "34B9F5F763F685E2D52E7DBF67DF58E7", hash_generated_method = "44500130896EBE7BA4D9BCC4526700AE")
            
public void setIpForwardingEnabled(boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setIpForwardingEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Start tethering services with the specified dhcp server range
     * arg is a set of start end pairs defining the ranges.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.969 -0400", hash_original_method = "712932B9B797C9C4610FFDBB1038E41D", hash_generated_method = "14949E31292D41C4B6291917F995A163")
            
public void startTethering(java.lang.String[] dhcpRanges) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(dhcpRanges);
mRemote.transact(Stub.TRANSACTION_startTethering, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Stop currently running tethering services
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.971 -0400", hash_original_method = "69539F1B74699D633F8995CF2D855244", hash_generated_method = "5CA38C3E879B3DAE3B3FD5596107E63C")
            
public void stopTethering() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopTethering, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Returns true if tethering services are started
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.974 -0400", hash_original_method = "D3B5E67A5E9F4FCD8C0300668C51159A", hash_generated_method = "C00C83529E3D448A345AD11D02747379")
            
public boolean isTetheringStarted() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isTetheringStarted, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Tethers the specified interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.977 -0400", hash_original_method = "A77AF4CF208551278BEE47F9AFBE1A4E", hash_generated_method = "DF3443DEEC008D892E9AA20706E667A1")
            
public void tetherInterface(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_tetherInterface, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Untethers the specified interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.980 -0400", hash_original_method = "0D2FD5508D1AC76513C7952A446EFDF8", hash_generated_method = "CAC95532E4BF7867ED3A978D1393BCBB")
            
public void untetherInterface(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_untetherInterface, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Returns a list of currently tethered interfaces
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.983 -0400", hash_original_method = "8513686FCBC909FB5D33AD50394F499A", hash_generated_method = "2543733A5C69FF4F220C52D25C82216C")
            
public java.lang.String[] listTetheredInterfaces() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_listTetheredInterfaces, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Sets the list of DNS forwarders (in order of priority)
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.985 -0400", hash_original_method = "39DDCB1BBEB616882A571920D3B9DCBE", hash_generated_method = "A6814182C961E550E79AB007EDE5A8E2")
            
public void setDnsForwarders(java.lang.String[] dns) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(dns);
mRemote.transact(Stub.TRANSACTION_setDnsForwarders, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Returns the list of DNS fowarders (in order of priority)
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.988 -0400", hash_original_method = "A6A674C70AA28A685B300F06E356B70A", hash_generated_method = "38CBDAAFE73BFD4F921256E80F563703")
            
public java.lang.String[] getDnsForwarders() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDnsForwarders, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     *  Enables Network Address Translation between two interfaces.
     *  The address and netmask of the external interface is used for
     *  the NAT'ed network.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.991 -0400", hash_original_method = "9B0F6C9ADE03F25B0B6DC7DFE0706B79", hash_generated_method = "2B5FDF2C88C03DA6C26C3C72BB4D6622")
            
public void enableNat(java.lang.String internalInterface, java.lang.String externalInterface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(internalInterface);
_data.writeString(externalInterface);
mRemote.transact(Stub.TRANSACTION_enableNat, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     *  Disables Network Address Translation between two interfaces.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.994 -0400", hash_original_method = "B92CF0159AE000D8CEDD14C10503C44A", hash_generated_method = "43692802DD49353A7B136366532DC496")
            
public void disableNat(java.lang.String internalInterface, java.lang.String externalInterface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(internalInterface);
_data.writeString(externalInterface);
mRemote.transact(Stub.TRANSACTION_disableNat, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     ** PPPD
     *//**
     * Returns the list of currently known TTY devices on the system
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.997 -0400", hash_original_method = "AB740A7C35E05A4A4788596E947252E1", hash_generated_method = "39126DE2E5EF84C463B4AC718660202D")
            
public java.lang.String[] listTtys() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_listTtys, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Attaches a PPP server daemon to the specified TTY with the specified
     * local/remote addresses.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.999 -0400", hash_original_method = "AF01B5EC325AAB5935A075A408985187", hash_generated_method = "AEEF9807E82DA9DF88D4BFBF11019740")
            
public void attachPppd(java.lang.String tty, java.lang.String localAddr, java.lang.String remoteAddr, java.lang.String dns1Addr, java.lang.String dns2Addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tty);
_data.writeString(localAddr);
_data.writeString(remoteAddr);
_data.writeString(dns1Addr);
_data.writeString(dns2Addr);
mRemote.transact(Stub.TRANSACTION_attachPppd, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Detaches a PPP server daemon from the specified TTY.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.003 -0400", hash_original_method = "480A9DD31A371E0ACE186875E8C8B9B4", hash_generated_method = "147E6CB11E884E58C0ED2488170ED1AB")
            
public void detachPppd(java.lang.String tty) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tty);
mRemote.transact(Stub.TRANSACTION_detachPppd, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Load firmware for operation in the given mode. Currently the three
     * modes supported are "AP", "STA" and "P2P".
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.005 -0400", hash_original_method = "58A3BE9814B965DACDF4E8C478106442", hash_generated_method = "4C5ADB66D61206023728909E4716DACB")
            
public void wifiFirmwareReload(java.lang.String wlanIface, java.lang.String mode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(wlanIface);
_data.writeString(mode);
mRemote.transact(Stub.TRANSACTION_wifiFirmwareReload, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Start Wifi Access Point
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.008 -0400", hash_original_method = "28F4B826027092430FFB24FD1344FF28", hash_generated_method = "77EFEAEA00F821B88751F916B229AB8E")
            
public void startAccessPoint(android.net.wifi.WifiConfiguration wifiConfig, java.lang.String wlanIface, java.lang.String softapIface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((wifiConfig!=null)) {
_data.writeInt(1);
wifiConfig.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(wlanIface);
_data.writeString(softapIface);
mRemote.transact(Stub.TRANSACTION_startAccessPoint, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Stop Wifi Access Point
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.011 -0400", hash_original_method = "0F939829F66FC76344D9DCEA8177A0FA", hash_generated_method = "0750DCED759E3071774859EA49D0DC33")
            
public void stopAccessPoint(java.lang.String wlanIface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(wlanIface);
mRemote.transact(Stub.TRANSACTION_stopAccessPoint, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set Access Point config
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.013 -0400", hash_original_method = "DA4BC26D85598F8617BC47F13A19D3EE", hash_generated_method = "24E25E160FB32F7051A235549DAF7C20")
            
public void setAccessPoint(android.net.wifi.WifiConfiguration wifiConfig, java.lang.String wlanIface, java.lang.String softapIface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((wifiConfig!=null)) {
_data.writeInt(1);
wifiConfig.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(wlanIface);
_data.writeString(softapIface);
mRemote.transact(Stub.TRANSACTION_setAccessPoint, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     ** DATA USAGE RELATED
     *//**
     * Return global network statistics summarized at an interface level,
     * without any UID-level granularity.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.016 -0400", hash_original_method = "77507FEDA4C4F7DD083F51315DFFF7E8", hash_generated_method = "53D38EEAD11AF703AF0BC0B978AA58F7")
            
public android.net.NetworkStats getNetworkStatsSummary() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStats _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNetworkStatsSummary, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStats.CREATOR.createFromParcel(_reply);
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
/**
     * Return detailed network statistics with UID-level granularity,
     * including interface and tag details.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.019 -0400", hash_original_method = "4750F64F8B93C058B4640B46C7CE9B48", hash_generated_method = "A7EA0057C30A7487D2B46C589E954166")
            
public android.net.NetworkStats getNetworkStatsDetail() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStats _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNetworkStatsDetail, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStats.CREATOR.createFromParcel(_reply);
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
/**
     * Return detailed network statistics for the requested UID,
     * including interface and tag details.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.021 -0400", hash_original_method = "4902DD22C6C6B3D8C6551860EEE9D0A3", hash_generated_method = "94381D9D6803F3D1C15A6D6FE6388FBD")
            
public android.net.NetworkStats getNetworkStatsUidDetail(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStats _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getNetworkStatsUidDetail, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStats.CREATOR.createFromParcel(_reply);
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
/**
     * Return summary of network statistics for the requested pairs of
     * tethering interfaces.  Even indexes are remote interface, and odd
     * indexes are corresponding local interfaces.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.024 -0400", hash_original_method = "B2631D951A7BD0EFE27937401D42BE7E", hash_generated_method = "846E67E901FDF893C98A09F0D2D59AE0")
            
public android.net.NetworkStats getNetworkStatsTethering(java.lang.String[] ifacePairs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStats _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(ifacePairs);
mRemote.transact(Stub.TRANSACTION_getNetworkStatsTethering, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStats.CREATOR.createFromParcel(_reply);
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
/**
     * Set quota for an interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.027 -0400", hash_original_method = "25EFDB02C1C4AC31339ED6E2AE653AAE", hash_generated_method = "703EBDE81C8B2A39FE1266CFD9E44235")
            
public void setInterfaceQuota(java.lang.String iface, long quotaBytes) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeLong(quotaBytes);
mRemote.transact(Stub.TRANSACTION_setInterfaceQuota, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Remove quota for an interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.030 -0400", hash_original_method = "FF292CE0859350A8AD4AEC1D79E3F8E5", hash_generated_method = "64716712C3E3C142AD564742B6F2E5E3")
            
public void removeInterfaceQuota(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_removeInterfaceQuota, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set alert for an interface; requires that iface already has quota.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.033 -0400", hash_original_method = "2D91FAACFE6D4D76222C385ED7A87DFB", hash_generated_method = "4FE003F30B6477DA5BD4286E95F9774E")
            
public void setInterfaceAlert(java.lang.String iface, long alertBytes) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeLong(alertBytes);
mRemote.transact(Stub.TRANSACTION_setInterfaceAlert, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Remove alert for an interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.035 -0400", hash_original_method = "FCF818B4095B1911AC1C3881D83E0F42", hash_generated_method = "E5BE78E934E9405822272B34841FE3C3")
            
public void removeInterfaceAlert(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_removeInterfaceAlert, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set alert across all interfaces.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.039 -0400", hash_original_method = "0A49AF6670010824BD6D1BC434F6154A", hash_generated_method = "36A314D33E03A30BD36F19D1ED60CFFC")
            
public void setGlobalAlert(long alertBytes) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(alertBytes);
mRemote.transact(Stub.TRANSACTION_setGlobalAlert, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Control network activity of a UID over interfaces with a quota limit.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.041 -0400", hash_original_method = "86ACFD3BF43788507D151522687E4C1A", hash_generated_method = "E5E4F60A16C74906FFF893BBC7FF16F4")
            
public void setUidNetworkRules(int uid, boolean rejectOnQuotaInterfaces) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(((rejectOnQuotaInterfaces)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setUidNetworkRules, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Return status of bandwidth control module.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.044 -0400", hash_original_method = "93A718C170A40B80F95C76DB1CD0EF79", hash_generated_method = "2732CE290D29C7554742EB35FE5DF899")
            
public boolean isBandwidthControlEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isBandwidthControlEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Configures bandwidth throttling on an interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.046 -0400", hash_original_method = "C7F3811D55755FAC53A1740330D100B1", hash_generated_method = "5774042273DDE77D1FA24089C52BA19B")
            
public void setInterfaceThrottle(java.lang.String iface, int rxKbps, int txKbps) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeInt(rxKbps);
_data.writeInt(txKbps);
mRemote.transact(Stub.TRANSACTION_setInterfaceThrottle, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Returns the currently configured RX throttle values
     * for the specified interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.049 -0400", hash_original_method = "628B456558A1CD99D83EAD0E649DC757", hash_generated_method = "057C07A32BEA7460268AC9B820224213")
            
public int getInterfaceRxThrottle(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_getInterfaceRxThrottle, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Returns the currently configured TX throttle values
     * for the specified interface
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.052 -0400", hash_original_method = "E5D8D80A4315DBF6018F9E766A7B4793", hash_generated_method = "4AECD4227D9FF7C2673745784719BE25")
            
public int getInterfaceTxThrottle(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_getInterfaceTxThrottle, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Sets the name of the default interface in the DNS resolver.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.054 -0400", hash_original_method = "7CD8A09CB6809CF73AC4B5AEAC7CE243", hash_generated_method = "EFC47AEF3B0A0A42F8061A25567AAE07")
            
public void setDefaultInterfaceForDns(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_setDefaultInterfaceForDns, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Bind name servers to an interface in the DNS resolver.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.058 -0400", hash_original_method = "CF0F7FEB902FE66100361DB6E386E7DC", hash_generated_method = "2C3B9C0CE38440D2BC3F99199203DB75")
            
public void setDnsServersForInterface(java.lang.String iface, java.lang.String[] servers) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeStringArray(servers);
mRemote.transact(Stub.TRANSACTION_setDnsServersForInterface, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Flush the DNS cache associated with the default interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.061 -0400", hash_original_method = "7B45850D64B3E6284A636D6499E92198", hash_generated_method = "A66F6C6A84D5859D498449BA2C5CFF9F")
            
public void flushDefaultDnsCache() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_flushDefaultDnsCache, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Flush the DNS cache associated with the specified interface.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.063 -0400", hash_original_method = "44E64A7A480F300541DBDF85EEF4FCE5", hash_generated_method = "9F15541CF6ECE463603803B3FC30A176")
            
public void flushInterfaceDnsCache(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_flushInterfaceDnsCache, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.086 -0400", hash_original_field = "D1C87A14100A37F3857ABD897F9C4477", hash_generated_field = "D7190D6B4351D304B0C3FFD4FB205F9A")

static final int TRANSACTION_getInterfaceConfig = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.089 -0400", hash_original_field = "F3AC93F30DFD1F80C5B1509D9D101A30", hash_generated_field = "DD8B927BB199A56738C0774FF8702593")

static final int TRANSACTION_setInterfaceConfig = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.092 -0400", hash_original_field = "5713FA5B3A57BD3008A98E7E17AE4ADA", hash_generated_field = "527B70275C15F950DFBFA8626B81D8C1")

static final int TRANSACTION_clearInterfaceAddresses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.095 -0400", hash_original_field = "DE7C08AE0392C3775395DF80ACEE3DBB", hash_generated_field = "3F556BE3FA202B36312C62BE631AB401")

static final int TRANSACTION_setInterfaceDown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.098 -0400", hash_original_field = "37A28B231BC07508BE1ECD49D06F9E09", hash_generated_field = "99F8B95BD4B9B140049CDF0D81DE3463")

static final int TRANSACTION_setInterfaceUp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.101 -0400", hash_original_field = "49A083E1CBD9E553B7BD4E07FF66E1E1", hash_generated_field = "51981ED50C8FC82BCEFDC84D573F206A")

static final int TRANSACTION_setInterfaceIpv6PrivacyExtensions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.104 -0400", hash_original_field = "5B229874E7E5E90B41AD5DE3196B209D", hash_generated_field = "6A15FA30D261CA0C66125480E268F4A3")

static final int TRANSACTION_disableIpv6 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.106 -0400", hash_original_field = "9184997375DAC16D2FD633693D01A370", hash_generated_field = "5E6BC0980A05FAB075E81CA4AD2B33EC")

static final int TRANSACTION_enableIpv6 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.109 -0400", hash_original_field = "E104F854EC491A6F20F6B92C235A24AB", hash_generated_field = "88CF368D8B83872F1026C47245C0B56E")

static final int TRANSACTION_getRoutes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.112 -0400", hash_original_field = "8E6D3E7DB77319326EFE30BA2001188C", hash_generated_field = "9C13B019D506CDBB4F72B3A34025E86C")

static final int TRANSACTION_addRoute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.115 -0400", hash_original_field = "32099301A2F441A84DA6A12957A26BF7", hash_generated_field = "A2EBA3CEE5F7AC69D8B0DE373AF9D443")

static final int TRANSACTION_removeRoute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.118 -0400", hash_original_field = "2A0664BB10E502E9F364F32FC97B1BDB", hash_generated_field = "2C53C27A756266A332831F44F50CE36C")

static final int TRANSACTION_addSecondaryRoute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.121 -0400", hash_original_field = "7A7B66153DC4B6F6228A1BD4D692B127", hash_generated_field = "30E32F7BAB03CD19C2DDAAEBBBFC0200")

static final int TRANSACTION_removeSecondaryRoute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.123 -0400", hash_original_field = "77EBA7F203FF8E8FD50AACE5A5FB2457", hash_generated_field = "77A5C2F783D934E34268E0FC0E000BC8")

static final int TRANSACTION_shutdown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.125 -0400", hash_original_field = "CB37D644394D1D40DC46D7EA0A66B2E1", hash_generated_field = "41E61BFF7CA1406CC3031A2AFD98912B")

static final int TRANSACTION_getIpForwardingEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.129 -0400", hash_original_field = "83A0499ED62AE45572CB8B321E49C040", hash_generated_field = "D5223643C240AAFC399E10CF956B83D8")

static final int TRANSACTION_setIpForwardingEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.132 -0400", hash_original_field = "0BC9EA7EEE03CF4BEB21432339DCD1F6", hash_generated_field = "A9AAD4C343F760C4F8CEBCCD16422F08")

static final int TRANSACTION_startTethering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.134 -0400", hash_original_field = "744DD27CA825D6F03C5DBC188362728D", hash_generated_field = "3015A6EA5B1D6F39619ABB1EAAD73BC2")

static final int TRANSACTION_stopTethering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.137 -0400", hash_original_field = "68D2D315F3056BD0A469EFDC714642F6", hash_generated_field = "81193A976FA363233A2E0DA304A53C86")

static final int TRANSACTION_isTetheringStarted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.140 -0400", hash_original_field = "B4A1929B0CC868A0F88F9429EEBE4D57", hash_generated_field = "F1D534EED82D7655F861B53F202558A7")

static final int TRANSACTION_tetherInterface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.142 -0400", hash_original_field = "2940D74E3E5FED1091078A5834787B76", hash_generated_field = "55D15A0271A3AC5FDF00CA55158F4C5C")

static final int TRANSACTION_untetherInterface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.145 -0400", hash_original_field = "6FBCE4EAE75F4587C052929A96FC9B5A", hash_generated_field = "F51E314B081F6A5DDF6A6DC0A45655FE")

static final int TRANSACTION_listTetheredInterfaces = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.148 -0400", hash_original_field = "E84F74553C3261F86EC5FEB784C800DE", hash_generated_field = "0091BB63DAD89A93D8B29E584F523015")

static final int TRANSACTION_setDnsForwarders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.151 -0400", hash_original_field = "83650AA25028D4638C160FC37D12EC3F", hash_generated_field = "4C7BF8AEB3867957344D1CAECE06E34B")

static final int TRANSACTION_getDnsForwarders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.155 -0400", hash_original_field = "B1145100F4741B3A614B187B7C245401", hash_generated_field = "DFEFD16390EF0F687AD8F2B9859F098C")

static final int TRANSACTION_enableNat = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.157 -0400", hash_original_field = "0AEAB7F98448CB454D6BAA5DCAA52D87", hash_generated_field = "1A37AFF2666CE126059781FAC34CF4EF")

static final int TRANSACTION_disableNat = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.161 -0400", hash_original_field = "54F405B205B5CE15340144E52F2079B7", hash_generated_field = "29847644C3519B383EB0710E78C59709")

static final int TRANSACTION_listTtys = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.163 -0400", hash_original_field = "33929E26A795CEAB3624229F4BFCD064", hash_generated_field = "55D1644AC06A014910D5ABDF208791E8")

static final int TRANSACTION_attachPppd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.166 -0400", hash_original_field = "BF870982C5EBBDDD2C8F63464051B3D4", hash_generated_field = "C155A72AA5A753F831DE2D56E4F5A327")

static final int TRANSACTION_detachPppd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.169 -0400", hash_original_field = "76E7CC91B2FE2DD98D10391CE709796C", hash_generated_field = "F400FA17D3ADA27DCF4AFE8D7AB4B9B0")

static final int TRANSACTION_wifiFirmwareReload = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.173 -0400", hash_original_field = "7C24F7453F08CDA2748E094A49D4373D", hash_generated_field = "D0AE21838B6EE6E3C47EA5B985F32394")

static final int TRANSACTION_startAccessPoint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.175 -0400", hash_original_field = "FE41502735064D7DF17B6C6E4671085F", hash_generated_field = "44F3A25515B930FF0C2525A977E878A1")

static final int TRANSACTION_stopAccessPoint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.179 -0400", hash_original_field = "6962CB31E2987C94E98C18542E9DEA93", hash_generated_field = "A8DE81B33E797EEF74E78B9F84EF77E1")

static final int TRANSACTION_setAccessPoint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.182 -0400", hash_original_field = "69A6BF1F33422AB9F063A87743CB3245", hash_generated_field = "F036B471A2CCC48201167CBED5A62446")

static final int TRANSACTION_getNetworkStatsSummary = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.185 -0400", hash_original_field = "2D584EE56FAF10CE53F4E456C8B346D9", hash_generated_field = "280C89F88CFEB8091A9EDC49B81EDCB1")

static final int TRANSACTION_getNetworkStatsDetail = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.187 -0400", hash_original_field = "DAAF095B5DE32DC41706C50A1FD8D294", hash_generated_field = "9149631D5E5C5098C72DDD99EB1EF707")

static final int TRANSACTION_getNetworkStatsUidDetail = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.190 -0400", hash_original_field = "16AEFB74618375783951957BD37E06E6", hash_generated_field = "944C31DB08BC3E8B8760182F9EA8C9AF")

static final int TRANSACTION_getNetworkStatsTethering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.193 -0400", hash_original_field = "8FE83E395C5C09993579EAAECCA0F6B3", hash_generated_field = "D556A6BF2D3297C66BAAEACA38976E1A")

static final int TRANSACTION_setInterfaceQuota = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.196 -0400", hash_original_field = "528F3161C8C6AD55F99E5AA41205DFFD", hash_generated_field = "378C6B63DAC5265CC6AC7787B29C2C63")

static final int TRANSACTION_removeInterfaceQuota = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.199 -0400", hash_original_field = "AC02F19FBD4F14642DC1380BEC83B635", hash_generated_field = "14E6082686F32ED3443A2107E291FC6B")

static final int TRANSACTION_setInterfaceAlert = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.201 -0400", hash_original_field = "E591AC45D78ED26D4433ECAA4DA5ED73", hash_generated_field = "4A423E042B59F329EA24D5C3D2F7466D")

static final int TRANSACTION_removeInterfaceAlert = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.204 -0400", hash_original_field = "78BBA86207F1F46F190F4F57C6963F52", hash_generated_field = "F1B6D7B884E8B009930540B5278CBB8B")

static final int TRANSACTION_setGlobalAlert = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.207 -0400", hash_original_field = "4D2F24CD9F8E1D8DB6E8F1797E0E7CA5", hash_generated_field = "2C5FF19F44DF8E1F1926DAA28EC31DE1")

static final int TRANSACTION_setUidNetworkRules = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.210 -0400", hash_original_field = "1436FC0054437378017C4586A73A1103", hash_generated_field = "56EE45F4F9DC7D124216993C769D8D3A")

static final int TRANSACTION_isBandwidthControlEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.212 -0400", hash_original_field = "033EDA1B97AD9ECE7BE7541A595BA7C8", hash_generated_field = "B48790635363953EEBD2F36103CF8BA5")

static final int TRANSACTION_setInterfaceThrottle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.215 -0400", hash_original_field = "9763D42A543CA446E001081B2601D5ED", hash_generated_field = "D989D9F592DC1FCCA9D02F12A82750DB")

static final int TRANSACTION_getInterfaceRxThrottle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.219 -0400", hash_original_field = "B5DB49F653A18012F22ED9059D8AC636", hash_generated_field = "AA34B1BF8836AD67812068C9BA4A1ECD")

static final int TRANSACTION_getInterfaceTxThrottle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.221 -0400", hash_original_field = "D0C09529E4BC84DADFBC45F82E89D4BF", hash_generated_field = "665BF01BE6FC2A08F3D81BB728E2920D")

static final int TRANSACTION_setDefaultInterfaceForDns = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.225 -0400", hash_original_field = "9841F6CBEBCBF2894911C23C2BA6AFFE", hash_generated_field = "4E8D73E6243A23BA186CB2E6CF62D087")

static final int TRANSACTION_setDnsServersForInterface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.229 -0400", hash_original_field = "06B307F51292D4587F61189DC4C04984", hash_generated_field = "6DD8AB0103E4433C1B63B928E31A95BE")

static final int TRANSACTION_flushDefaultDnsCache = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.232 -0400", hash_original_field = "74E3485006F2971407BA44AFE163ED4D", hash_generated_field = "A019CDD87172F012B02614B7132E2A5E")

static final int TRANSACTION_flushInterfaceDnsCache = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.886 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.891 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:10.903 -0400", hash_original_method = "05FC83AC7766403A40272B33B5EDC5D9", hash_generated_method = "B6C709FC8A4204C68510EB528B0BE22F")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_registerObserver:
{
data.enforceInterface(DESCRIPTOR);
android.net.INetworkManagementEventObserver _arg0;
_arg0 = android.net.INetworkManagementEventObserver.Stub.asInterface(data.readStrongBinder());
this.registerObserver(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterObserver:
{
data.enforceInterface(DESCRIPTOR);
android.net.INetworkManagementEventObserver _arg0;
_arg0 = android.net.INetworkManagementEventObserver.Stub.asInterface(data.readStrongBinder());
this.unregisterObserver(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_listInterfaces:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.listInterfaces();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getInterfaceConfig:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.InterfaceConfiguration _result = this.getInterfaceConfig(_arg0);
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
case TRANSACTION_setInterfaceConfig:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.InterfaceConfiguration _arg1;
if ((0!=data.readInt())) {
_arg1 = android.net.InterfaceConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.setInterfaceConfig(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_clearInterfaceAddresses:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearInterfaceAddresses(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setInterfaceDown:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setInterfaceDown(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setInterfaceUp:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setInterfaceUp(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setInterfaceIpv6PrivacyExtensions:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setInterfaceIpv6PrivacyExtensions(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_disableIpv6:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.disableIpv6(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_enableIpv6:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.enableIpv6(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getRoutes:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.RouteInfo[] _result = this.getRoutes(_arg0);
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_addRoute:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.RouteInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = android.net.RouteInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.addRoute(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeRoute:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.RouteInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = android.net.RouteInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.removeRoute(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_addSecondaryRoute:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.RouteInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = android.net.RouteInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.addSecondaryRoute(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeSecondaryRoute:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.RouteInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = android.net.RouteInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.removeSecondaryRoute(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_shutdown:
{
data.enforceInterface(DESCRIPTOR);
this.shutdown();
reply.writeNoException();
return true;
}
case TRANSACTION_getIpForwardingEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getIpForwardingEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setIpForwardingEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setIpForwardingEnabled(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_startTethering:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
this.startTethering(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_stopTethering:
{
data.enforceInterface(DESCRIPTOR);
this.stopTethering();
reply.writeNoException();
return true;
}
case TRANSACTION_isTetheringStarted:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isTetheringStarted();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_tetherInterface:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.tetherInterface(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_untetherInterface:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.untetherInterface(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_listTetheredInterfaces:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.listTetheredInterfaces();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_setDnsForwarders:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
this.setDnsForwarders(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getDnsForwarders:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getDnsForwarders();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_enableNat:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.enableNat(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_disableNat:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.disableNat(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_listTtys:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.listTtys();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_attachPppd:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
this.attachPppd(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_detachPppd:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.detachPppd(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_wifiFirmwareReload:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.wifiFirmwareReload(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_startAccessPoint:
{
data.enforceInterface(DESCRIPTOR);
android.net.wifi.WifiConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.wifi.WifiConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.startAccessPoint(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_stopAccessPoint:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.stopAccessPoint(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setAccessPoint:
{
data.enforceInterface(DESCRIPTOR);
android.net.wifi.WifiConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.wifi.WifiConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.setAccessPoint(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getNetworkStatsSummary:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkStats _result = this.getNetworkStatsSummary();
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
case TRANSACTION_getNetworkStatsDetail:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkStats _result = this.getNetworkStatsDetail();
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
case TRANSACTION_getNetworkStatsUidDetail:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.net.NetworkStats _result = this.getNetworkStatsUidDetail(_arg0);
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
case TRANSACTION_getNetworkStatsTethering:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
android.net.NetworkStats _result = this.getNetworkStatsTethering(_arg0);
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
case TRANSACTION_setInterfaceQuota:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _arg1;
_arg1 = data.readLong();
this.setInterfaceQuota(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeInterfaceQuota:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.removeInterfaceQuota(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setInterfaceAlert:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _arg1;
_arg1 = data.readLong();
this.setInterfaceAlert(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeInterfaceAlert:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.removeInterfaceAlert(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setGlobalAlert:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
this.setGlobalAlert(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setUidNetworkRules:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setUidNetworkRules(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_isBandwidthControlEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isBandwidthControlEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setInterfaceThrottle:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.setInterfaceThrottle(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getInterfaceRxThrottle:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getInterfaceRxThrottle(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getInterfaceTxThrottle:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getInterfaceTxThrottle(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setDefaultInterfaceForDns:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setDefaultInterfaceForDns(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setDnsServersForInterface:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String[] _arg1;
_arg1 = data.createStringArray();
this.setDnsServersForInterface(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_flushDefaultDnsCache:
{
data.enforceInterface(DESCRIPTOR);
this.flushDefaultDnsCache();
reply.writeNoException();
return true;
}
case TRANSACTION_flushInterfaceDnsCache:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.flushInterfaceDnsCache(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
/**
     ** GENERAL
     *//**
     * Register an observer to receive events
     */
public void registerObserver(android.net.INetworkManagementEventObserver obs) throws android.os.RemoteException;
/**
     * Unregister an observer from receiving events.
     */
public void unregisterObserver(android.net.INetworkManagementEventObserver obs) throws android.os.RemoteException;
/**
     * Returns a list of currently known network interfaces
     */
public java.lang.String[] listInterfaces() throws android.os.RemoteException;
/**
     * Retrieves the specified interface config
     *
     */
public android.net.InterfaceConfiguration getInterfaceConfig(java.lang.String iface) throws android.os.RemoteException;
/**
     * Sets the configuration of the specified interface
     */
public void setInterfaceConfig(java.lang.String iface, android.net.InterfaceConfiguration cfg) throws android.os.RemoteException;
/**
     * Clear all IP addresses on the specified interface
     */
public void clearInterfaceAddresses(java.lang.String iface) throws android.os.RemoteException;
/**
     * Set interface down
     */
public void setInterfaceDown(java.lang.String iface) throws android.os.RemoteException;
/**
     * Set interface up
     */
public void setInterfaceUp(java.lang.String iface) throws android.os.RemoteException;
/**
     * Set interface IPv6 privacy extensions
     */
public void setInterfaceIpv6PrivacyExtensions(java.lang.String iface, boolean enable) throws android.os.RemoteException;
/**
     * Disable IPv6 on an interface
     */
public void disableIpv6(java.lang.String iface) throws android.os.RemoteException;
/**
     * Enable IPv6 on an interface
     */
public void enableIpv6(java.lang.String iface) throws android.os.RemoteException;
/**
     * Retrieves the network routes currently configured on the specified
     * interface
     */
public android.net.RouteInfo[] getRoutes(java.lang.String iface) throws android.os.RemoteException;
/**
     * Add the specified route to the interface.
     */
public void addRoute(java.lang.String iface, android.net.RouteInfo route) throws android.os.RemoteException;
/**
     * Remove the specified route from the interface.
     */
public void removeRoute(java.lang.String iface, android.net.RouteInfo route) throws android.os.RemoteException;
/**
     * Add the specified route to a secondary interface
     * This will go into a special route table to be accessed
     * via ip rules
     */
public void addSecondaryRoute(java.lang.String iface, android.net.RouteInfo route) throws android.os.RemoteException;
/**
     * Remove the specified secondary route.
     */
public void removeSecondaryRoute(java.lang.String iface, android.net.RouteInfo route) throws android.os.RemoteException;
/**
     * Shuts down the service
     */
public void shutdown() throws android.os.RemoteException;
/**
     ** TETHERING RELATED
     *//**
     * Returns true if IP forwarding is enabled
     */
public boolean getIpForwardingEnabled() throws android.os.RemoteException;
/**
     * Enables/Disables IP Forwarding
     */
public void setIpForwardingEnabled(boolean enabled) throws android.os.RemoteException;
/**
     * Start tethering services with the specified dhcp server range
     * arg is a set of start end pairs defining the ranges.
     */
public void startTethering(java.lang.String[] dhcpRanges) throws android.os.RemoteException;
/**
     * Stop currently running tethering services
     */
public void stopTethering() throws android.os.RemoteException;
/**
     * Returns true if tethering services are started
     */
public boolean isTetheringStarted() throws android.os.RemoteException;
/**
     * Tethers the specified interface
     */
public void tetherInterface(java.lang.String iface) throws android.os.RemoteException;
/**
     * Untethers the specified interface
     */
public void untetherInterface(java.lang.String iface) throws android.os.RemoteException;
/**
     * Returns a list of currently tethered interfaces
     */
public java.lang.String[] listTetheredInterfaces() throws android.os.RemoteException;
/**
     * Sets the list of DNS forwarders (in order of priority)
     */
public void setDnsForwarders(java.lang.String[] dns) throws android.os.RemoteException;
/**
     * Returns the list of DNS fowarders (in order of priority)
     */
public java.lang.String[] getDnsForwarders() throws android.os.RemoteException;
/**
     *  Enables Network Address Translation between two interfaces.
     *  The address and netmask of the external interface is used for
     *  the NAT'ed network.
     */
public void enableNat(java.lang.String internalInterface, java.lang.String externalInterface) throws android.os.RemoteException;
/**
     *  Disables Network Address Translation between two interfaces.
     */
public void disableNat(java.lang.String internalInterface, java.lang.String externalInterface) throws android.os.RemoteException;
/**
     ** PPPD
     *//**
     * Returns the list of currently known TTY devices on the system
     */
public java.lang.String[] listTtys() throws android.os.RemoteException;
/**
     * Attaches a PPP server daemon to the specified TTY with the specified
     * local/remote addresses.
     */
public void attachPppd(java.lang.String tty, java.lang.String localAddr, java.lang.String remoteAddr, java.lang.String dns1Addr, java.lang.String dns2Addr) throws android.os.RemoteException;
/**
     * Detaches a PPP server daemon from the specified TTY.
     */
public void detachPppd(java.lang.String tty) throws android.os.RemoteException;
/**
     * Load firmware for operation in the given mode. Currently the three
     * modes supported are "AP", "STA" and "P2P".
     */
public void wifiFirmwareReload(java.lang.String wlanIface, java.lang.String mode) throws android.os.RemoteException;
/**
     * Start Wifi Access Point
     */
public void startAccessPoint(android.net.wifi.WifiConfiguration wifiConfig, java.lang.String wlanIface, java.lang.String softapIface) throws android.os.RemoteException;
/**
     * Stop Wifi Access Point
     */
public void stopAccessPoint(java.lang.String wlanIface) throws android.os.RemoteException;
/**
     * Set Access Point config
     */
public void setAccessPoint(android.net.wifi.WifiConfiguration wifiConfig, java.lang.String wlanIface, java.lang.String softapIface) throws android.os.RemoteException;
/**
     ** DATA USAGE RELATED
     *//**
     * Return global network statistics summarized at an interface level,
     * without any UID-level granularity.
     */
public android.net.NetworkStats getNetworkStatsSummary() throws android.os.RemoteException;
/**
     * Return detailed network statistics with UID-level granularity,
     * including interface and tag details.
     */
public android.net.NetworkStats getNetworkStatsDetail() throws android.os.RemoteException;
/**
     * Return detailed network statistics for the requested UID,
     * including interface and tag details.
     */
public android.net.NetworkStats getNetworkStatsUidDetail(int uid) throws android.os.RemoteException;
/**
     * Return summary of network statistics for the requested pairs of
     * tethering interfaces.  Even indexes are remote interface, and odd
     * indexes are corresponding local interfaces.
     */
public android.net.NetworkStats getNetworkStatsTethering(java.lang.String[] ifacePairs) throws android.os.RemoteException;
/**
     * Set quota for an interface.
     */
public void setInterfaceQuota(java.lang.String iface, long quotaBytes) throws android.os.RemoteException;
/**
     * Remove quota for an interface.
     */
public void removeInterfaceQuota(java.lang.String iface) throws android.os.RemoteException;
/**
     * Set alert for an interface; requires that iface already has quota.
     */
public void setInterfaceAlert(java.lang.String iface, long alertBytes) throws android.os.RemoteException;
/**
     * Remove alert for an interface.
     */
public void removeInterfaceAlert(java.lang.String iface) throws android.os.RemoteException;
/**
     * Set alert across all interfaces.
     */
public void setGlobalAlert(long alertBytes) throws android.os.RemoteException;
/**
     * Control network activity of a UID over interfaces with a quota limit.
     */
public void setUidNetworkRules(int uid, boolean rejectOnQuotaInterfaces) throws android.os.RemoteException;
/**
     * Return status of bandwidth control module.
     */
public boolean isBandwidthControlEnabled() throws android.os.RemoteException;
/**
     * Configures bandwidth throttling on an interface.
     */
public void setInterfaceThrottle(java.lang.String iface, int rxKbps, int txKbps) throws android.os.RemoteException;
/**
     * Returns the currently configured RX throttle values
     * for the specified interface
     */
public int getInterfaceRxThrottle(java.lang.String iface) throws android.os.RemoteException;
/**
     * Returns the currently configured TX throttle values
     * for the specified interface
     */
public int getInterfaceTxThrottle(java.lang.String iface) throws android.os.RemoteException;
/**
     * Sets the name of the default interface in the DNS resolver.
     */
public void setDefaultInterfaceForDns(java.lang.String iface) throws android.os.RemoteException;
/**
     * Bind name servers to an interface in the DNS resolver.
     */
public void setDnsServersForInterface(java.lang.String iface, java.lang.String[] servers) throws android.os.RemoteException;
/**
     * Flush the DNS cache associated with the default interface.
     */
public void flushDefaultDnsCache() throws android.os.RemoteException;
/**
     * Flush the DNS cache associated with the specified interface.
     */
public void flushInterfaceDnsCache(java.lang.String iface) throws android.os.RemoteException;
}
