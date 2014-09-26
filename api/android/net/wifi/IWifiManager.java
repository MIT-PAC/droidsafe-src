package android.net.wifi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IWifiManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.net.wifi.IWifiManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.863 -0500", hash_original_field = "18A9DACE2FECF63044E62EC6A7C72A44", hash_generated_field = "664E01E7445DC17B86608D6F615C94E9")

private static final java.lang.String DESCRIPTOR = "android.net.wifi.IWifiManager";
/**
 * Cast an IBinder object into an android.net.wifi.IWifiManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.868 -0500", hash_original_method = "E552E8F41A6230395AD2464B82A88215", hash_generated_method = "B474121E171E0C15AB9C9C17C2686C0E")
        
public static android.net.wifi.IWifiManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.wifi.IWifiManager))) {
return ((android.net.wifi.IWifiManager)iin);
}
return new android.net.wifi.IWifiManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.999 -0500", hash_original_field = "B4C309FC57903F6778D247AB093CC0E1", hash_generated_field = "F8949954D16839D43E1F9805D8A1D7B5")

static final int TRANSACTION_getConfiguredNetworks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.001 -0500", hash_original_field = "2B015E76F3A8348F6975F29BDFC0D045", hash_generated_field = "DCCD25075B72E560927BD5E1F56C8F91")

static final int TRANSACTION_addOrUpdateNetwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.004 -0500", hash_original_field = "332B611C3F81B9C596B88083C76EA216", hash_generated_field = "AB346D0BB4FEF6A94C61C852D9A9C8E8")

static final int TRANSACTION_removeNetwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.wifi.IWifiManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.882 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.885 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.887 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.889 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.892 -0500", hash_original_method = "7224459B2FB171AD560AA8DA622A14B6", hash_generated_method = "EB60030E85258629A1E6F77EC5A99438")
            
public java.util.List<android.net.wifi.WifiConfiguration> getConfiguredNetworks() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.net.wifi.WifiConfiguration> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConfiguredNetworks, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.net.wifi.WifiConfiguration.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.895 -0500", hash_original_method = "2452AB9EFBA01D79CEAE0A92ABE1B73B", hash_generated_method = "F349D0DA857E53DF66674319DF4E2402")
            
public int addOrUpdateNetwork(android.net.wifi.WifiConfiguration config) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addOrUpdateNetwork, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.898 -0500", hash_original_method = "A2D879A312B92175D373B3DDDFC3FB74", hash_generated_method = "15E0DF47A10F0A9EAF0888A815C67777")
            
public boolean removeNetwork(int netId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(netId);
mRemote.transact(Stub.TRANSACTION_removeNetwork, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.901 -0500", hash_original_method = "2F01ADE0D5238742A2A06430CA5FDA2A", hash_generated_method = "090ECFEA207DA08E13ABFEC48B5B8127")
            
public boolean enableNetwork(int netId, boolean disableOthers) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(netId);
_data.writeInt(((disableOthers)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_enableNetwork, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.903 -0500", hash_original_method = "712036BC1E5B461021925866225BA9A6", hash_generated_method = "AD0599445B6282BFCF47D1ED61BBBD8C")
            
public boolean disableNetwork(int netId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(netId);
mRemote.transact(Stub.TRANSACTION_disableNetwork, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.906 -0500", hash_original_method = "9E9195C0851267D0B19CCFBDC205556C", hash_generated_method = "80D2F96DF996E6051098696E57D32D5B")
            
public boolean pingSupplicant() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pingSupplicant, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.908 -0500", hash_original_method = "098F47992FD588354D8966FB32D99C2D", hash_generated_method = "B62F39429C956C0000DFFF6C88A2CF09")
            
public void startScan(boolean forceActive) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((forceActive)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_startScan, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.911 -0500", hash_original_method = "05F4B4B956B6077DC22A1733AEF1C28F", hash_generated_method = "B99D06BDC54C9E1D5E4BA8A6D573A3B5")
            
public java.util.List<android.net.wifi.ScanResult> getScanResults() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.net.wifi.ScanResult> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getScanResults, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.net.wifi.ScanResult.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.913 -0500", hash_original_method = "7356A426A0B7750490239D3760AB18D1", hash_generated_method = "E0D96A385B0D2413763CB4B9EC8F9640")
            
public void disconnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.916 -0500", hash_original_method = "C1CA6CBA8C34D087C03C41521AA666F4", hash_generated_method = "CDA90F23EC5A5C694A38435BBF20FA99")
            
public void reconnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.919 -0500", hash_original_method = "561DEF092C94F55A914CA371B7954437", hash_generated_method = "8C76B663BA8A3B372CF7E2C3BF1E0523")
            
public void reassociate() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reassociate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.921 -0500", hash_original_method = "979CB2E743FC92CA350898E1F54FCD04", hash_generated_method = "50FE9638A34C9E6BC3291E5389F45DD3")
            
public android.net.wifi.WifiInfo getConnectionInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.wifi.WifiInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConnectionInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.wifi.WifiInfo.CREATOR.createFromParcel(_reply);
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
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.924 -0500", hash_original_method = "E38116801EBEEAFF405131D95791C467", hash_generated_method = "DFB0A7694C85919A8B9030BFAAAD212D")
            
public boolean setWifiEnabled(boolean enable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setWifiEnabled, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.927 -0500", hash_original_method = "5B565B0B8C2E2305A1BBE16A7E4A11F8", hash_generated_method = "C8C8A3EA5F69C0E3EE6A9958B7D2EDCE")
            
public int getWifiEnabledState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getWifiEnabledState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.929 -0500", hash_original_method = "BA29774759066895F50E599F0D8A9CBC", hash_generated_method = "5B572771EF2ED4BC760829541F18A15B")
            
public void setCountryCode(java.lang.String country, boolean persist) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(country);
_data.writeInt(((persist)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setCountryCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.933 -0500", hash_original_method = "29C27631151EC35EA5CF80AF64AD0DCA", hash_generated_method = "A78285BC239949E4B8C3C84AB7A43DD7")
            
public void setFrequencyBand(int band, boolean persist) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(band);
_data.writeInt(((persist)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setFrequencyBand, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.935 -0500", hash_original_method = "12DB500C126AE98092B540C6E89D4377", hash_generated_method = "EAB5F0174AAADCB537B433C4B55FAE9A")
            
public int getFrequencyBand() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getFrequencyBand, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.938 -0500", hash_original_method = "275F8543C0BA14A718DE5C64EE96A13E", hash_generated_method = "C44A642EA1F2EB71E0A357B478281764")
            
public boolean isDualBandSupported() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isDualBandSupported, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.940 -0500", hash_original_method = "5F00671A81962A57F1B34D4EE70C4DEF", hash_generated_method = "492E05443FA3B2CE281C81E9A7A5B7B4")
            
public boolean saveConfiguration() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_saveConfiguration, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.943 -0500", hash_original_method = "7F8B92FD955BC1E10FEF328A45F74BBA", hash_generated_method = "955A02C7081109C3E3ED0E5848B4AC86")
            
public android.net.DhcpInfo getDhcpInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.DhcpInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDhcpInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.DhcpInfo.CREATOR.createFromParcel(_reply);
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
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.946 -0500", hash_original_method = "F3590FCF850A842EBDF486D6D170A182", hash_generated_method = "47184626C2194ECE28B2DA5E4E137D79")
            
public boolean acquireWifiLock(android.os.IBinder lock, int lockType, java.lang.String tag, android.os.WorkSource ws) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(lock);
_data.writeInt(lockType);
_data.writeString(tag);
if ((ws!=null)) {
_data.writeInt(1);
ws.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_acquireWifiLock, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.948 -0500", hash_original_method = "09749AF7214DFF05F760A29A17BEF910", hash_generated_method = "183F69D883C52525CDAEC19D05F67F05")
            
public void updateWifiLockWorkSource(android.os.IBinder lock, android.os.WorkSource ws) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_updateWifiLockWorkSource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.951 -0500", hash_original_method = "05C7F0623232DE5161FA9A10D90928B0", hash_generated_method = "9EAD9C7E5BCB06EA89E5607EDDD80A84")
            
public boolean releaseWifiLock(android.os.IBinder lock) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(lock);
mRemote.transact(Stub.TRANSACTION_releaseWifiLock, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.953 -0500", hash_original_method = "F3EE05CB1DF1E0AAA06AD640865CBCCD", hash_generated_method = "5D0520ABC2B45B515FF349ADB6CF8AD1")
            
public void initializeMulticastFiltering() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_initializeMulticastFiltering, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.956 -0500", hash_original_method = "270B4872B565A17C22C8CA80479B355B", hash_generated_method = "EDE22A80A95E8FF92363904FBCCF4AA3")
            
public boolean isMulticastEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isMulticastEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.958 -0500", hash_original_method = "F0405C2C686D95F89984CC62DA7F4AB2", hash_generated_method = "44B79B53DB10D941C7D174344CD96458")
            
public void acquireMulticastLock(android.os.IBinder binder, java.lang.String tag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(binder);
_data.writeString(tag);
mRemote.transact(Stub.TRANSACTION_acquireMulticastLock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.961 -0500", hash_original_method = "9275E0661C2D59E1689BCAA890C9067B", hash_generated_method = "2EB3D97567683F588CF972B7759DD8B2")
            
public void releaseMulticastLock() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_releaseMulticastLock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.964 -0500", hash_original_method = "9B8A894AA8BD2F0CCD1815FE47F3609A", hash_generated_method = "A370A8BC4976367A3ACE35EC0D44699B")
            
public void setWifiApEnabled(android.net.wifi.WifiConfiguration wifiConfig, boolean enable) throws android.os.RemoteException
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
_data.writeInt(((enable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setWifiApEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.967 -0500", hash_original_method = "52F768A33D659ED3D3EC812487DB576C", hash_generated_method = "2131B687AC2FC3DFC20631712A5E6C21")
            
public int getWifiApEnabledState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getWifiApEnabledState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.970 -0500", hash_original_method = "47E381783395EBE4F8BB5E78E6C0DC95", hash_generated_method = "60D6044E67D32E7E3A760D14B9909108")
            
public android.net.wifi.WifiConfiguration getWifiApConfiguration() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.wifi.WifiConfiguration _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getWifiApConfiguration, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.wifi.WifiConfiguration.CREATOR.createFromParcel(_reply);
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
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.973 -0500", hash_original_method = "B8662F4E8872C92EBC31C9FD4BB01DC6", hash_generated_method = "BDE48C511CAD97DBF969501666C7DBA8")
            
public void setWifiApConfiguration(android.net.wifi.WifiConfiguration wifiConfig) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_setWifiApConfiguration, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.975 -0500", hash_original_method = "FFD0FBCC1E61CD8EC0F9A65B8A55A6DF", hash_generated_method = "7C07F500CF8A833B289EAAC173473906")
            
public void startWifi() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startWifi, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.978 -0500", hash_original_method = "6B8582DD573BFC52850A06112F5915BD", hash_generated_method = "78215127C6D643F144B89523FACE14E2")
            
public void stopWifi() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopWifi, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.980 -0500", hash_original_method = "A95A2F6537EDB001A82898C0F16435B5", hash_generated_method = "86AB1780E1EDCF2E63575050B7ADC394")
            
public void addToBlacklist(java.lang.String bssid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(bssid);
mRemote.transact(Stub.TRANSACTION_addToBlacklist, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.983 -0500", hash_original_method = "374B63D5D06AA9BFD35BA7CBBCD59C13", hash_generated_method = "C9DD5DE524DB67C643F1B10D51AA7605")
            
public void clearBlacklist() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_clearBlacklist, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.986 -0500", hash_original_method = "203EF918F85C35DE4F9F699730711CF3", hash_generated_method = "91B0C0F4996EB2E3EE731D4105C27D08")
            
public android.os.Messenger getMessenger() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Messenger _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMessenger, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.Messenger.CREATOR.createFromParcel(_reply);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.988 -0500", hash_original_method = "FB5865C63169ED7F200C6670E7908954", hash_generated_method = "453ABDE7E94E64C9ABD20495891D5353")
            
public java.lang.String getConfigFile() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConfigFile, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.007 -0500", hash_original_field = "3C794AF2650CDDE035E4E8D2BF751CCC", hash_generated_field = "93DD7988F76B99CE98AC591CAB5A62EB")

static final int TRANSACTION_enableNetwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.009 -0500", hash_original_field = "765832BB112580E246E449B14400DB1F", hash_generated_field = "E7B51469AEC9E30913C08C6A967E8DC6")

static final int TRANSACTION_disableNetwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.011 -0500", hash_original_field = "F31ED5A0326B9F42A08FDAC0EFE0E564", hash_generated_field = "5C95CCC9F1310BE9FA4A69CB9538A954")

static final int TRANSACTION_pingSupplicant = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.014 -0500", hash_original_field = "DB7D76CE12D855DF5971401A5E09B827", hash_generated_field = "570F14DE3BEBDAA5CE5A0A3CFF76FC07")

static final int TRANSACTION_startScan = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.016 -0500", hash_original_field = "454296BB7A2D6F85AE964066E5870AD5", hash_generated_field = "C9333F0BB95BA94FC0DA591AB61F3633")

static final int TRANSACTION_getScanResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.018 -0500", hash_original_field = "ED2DCCD23A85FA651A2F005AC3D06B1F", hash_generated_field = "73C43DF7C41D18EF1BE4CC9E06CFEFCD")

static final int TRANSACTION_disconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.021 -0500", hash_original_field = "37C976941419B4F85513073EAB824BB9", hash_generated_field = "A6A84422ED1B21ED6469FF6D3BC2DF79")

static final int TRANSACTION_reconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.023 -0500", hash_original_field = "400CB4DCF83647F32EB8265DCA54DA75", hash_generated_field = "706F547386187C97DF1B3547E82856F4")

static final int TRANSACTION_reassociate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.025 -0500", hash_original_field = "C810384253E95906F84A7AD29DD8F0BB", hash_generated_field = "9CD1883059DA5208C7EC643376E8B0D4")

static final int TRANSACTION_getConnectionInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.028 -0500", hash_original_field = "9C825DBD590758DC0BF7E507973BB777", hash_generated_field = "056AF0A385A2469226FB19A1F89FC99A")

static final int TRANSACTION_setWifiEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.030 -0500", hash_original_field = "E0DEC3BE9F6FE103689DB44CC77DA4E2", hash_generated_field = "95F28891A7218AD6F978F437B3A6566F")

static final int TRANSACTION_getWifiEnabledState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.032 -0500", hash_original_field = "1B0297EAEB3F7E6BC68E863116BD41CC", hash_generated_field = "AADD9BC7074EE1CE7903A8B88B0F9F37")

static final int TRANSACTION_setCountryCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.036 -0500", hash_original_field = "764DF84F9D7AF37E8230B19BCAB3ADE8", hash_generated_field = "7B065C6456ACEA9C8D5C44A8A360C1E5")

static final int TRANSACTION_setFrequencyBand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.038 -0500", hash_original_field = "63052BD321F70EA6073EDED25DD65722", hash_generated_field = "217522078CCEF27998F557698D08C69A")

static final int TRANSACTION_getFrequencyBand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.041 -0500", hash_original_field = "69F2C08078CEC1B3DD23595F2E0A6DF3", hash_generated_field = "E1F5751B863447A008B86AF76D6DBAE8")

static final int TRANSACTION_isDualBandSupported = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.043 -0500", hash_original_field = "A90D91F0C2C80F8BFABB10BBED17E65C", hash_generated_field = "3C94F7DA8CEBD4B6568999111FD50345")

static final int TRANSACTION_saveConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.045 -0500", hash_original_field = "D1D17E93AA38E354125BAB87BBD10FBE", hash_generated_field = "6441D9F80B9CC9E74F901116E249724F")

static final int TRANSACTION_getDhcpInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.047 -0500", hash_original_field = "2ECB1ACEA7D36770381EF3880C11C1DE", hash_generated_field = "2E6A29EC03BC142F8CB0D1456CDC28A4")

static final int TRANSACTION_acquireWifiLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.050 -0500", hash_original_field = "DF85957F05EF3242D1877757060765A3", hash_generated_field = "8CC9B227EBB71C76D0E4B4A22C37B9E3")

static final int TRANSACTION_updateWifiLockWorkSource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.052 -0500", hash_original_field = "4055C1AD5D390BB775484B0C64D3D2FE", hash_generated_field = "5D41197B8AE97B72C5A660FA14CEBC7F")

static final int TRANSACTION_releaseWifiLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.054 -0500", hash_original_field = "EBC84DA2D01449F90A69C513FDD4B7EE", hash_generated_field = "921C60DE12AE534F3EE5AF98E79B3D01")

static final int TRANSACTION_initializeMulticastFiltering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.057 -0500", hash_original_field = "CE37CCD9B7FB018CDD1A9EE1A0A9E61D", hash_generated_field = "14408A08D7327E15FF1C7B89300AF11D")

static final int TRANSACTION_isMulticastEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.059 -0500", hash_original_field = "2D524C1CDF5B073E8D52CF33F6D6127C", hash_generated_field = "7DB1A603C6FBDADF15027727CE754CE1")

static final int TRANSACTION_acquireMulticastLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.062 -0500", hash_original_field = "27CDBB8CA215A56EF8C3572525EFE834", hash_generated_field = "55E4CD7760A4D7151BFB0773F870204E")

static final int TRANSACTION_releaseMulticastLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.065 -0500", hash_original_field = "375FCA73F00163575AB5EB975BB74AD8", hash_generated_field = "52DC910DD2F471CF599E4A044903C38C")

static final int TRANSACTION_setWifiApEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.067 -0500", hash_original_field = "6B62216BD9C3994D77A724D2047CCB31", hash_generated_field = "52AA48F4950BBD6202D1501479916797")

static final int TRANSACTION_getWifiApEnabledState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.069 -0500", hash_original_field = "EBC8B36FDB96FD99D1234A3957CA9060", hash_generated_field = "60DDB75F53DBB1130E75185BCA29E771")

static final int TRANSACTION_getWifiApConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.072 -0500", hash_original_field = "00E2CE21CF6D279C821A1F9288EDAD54", hash_generated_field = "1562EC2FB7E5A26D2A9F26FF6A49439D")

static final int TRANSACTION_setWifiApConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.074 -0500", hash_original_field = "00745868A29DCD26B4D2DD2E3DCA8C34", hash_generated_field = "D44AE55179C798D7DF087CA40C7427E5")

static final int TRANSACTION_startWifi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.076 -0500", hash_original_field = "293F529913E01A3108AFD0E81DF17670", hash_generated_field = "C97C7A99FD463856B8879A5FD3BD00CD")

static final int TRANSACTION_stopWifi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.078 -0500", hash_original_field = "B5D6AE581ADB2493407FF72BE660D845", hash_generated_field = "19CE8CB4EF03A1D83B85CEF1FC596C8B")

static final int TRANSACTION_addToBlacklist = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.081 -0500", hash_original_field = "D794BDEE309ECCC5246D0BB24BB2B4B0", hash_generated_field = "CE20A632465FE33F6830E7CF1722E578")

static final int TRANSACTION_clearBlacklist = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.084 -0500", hash_original_field = "223BC12C41C6B37C31419CD94A698E5D", hash_generated_field = "28DA3D0AEB44B11EB6308977911E2A51")

static final int TRANSACTION_getMessenger = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.086 -0500", hash_original_field = "2F345A816EACA476BD5E0C71C96984AC", hash_generated_field = "E73A803C5D665119F66E8C7336BF6BAF")

static final int TRANSACTION_getConfigFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.865 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.870 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.879 -0500", hash_original_method = "91790B824725080608292A62C65F32E4", hash_generated_method = "DE048F12673804EC8E7802FE586D13CF")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getConfiguredNetworks:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.net.wifi.WifiConfiguration> _result = this.getConfiguredNetworks();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_addOrUpdateNetwork:
{
data.enforceInterface(DESCRIPTOR);
android.net.wifi.WifiConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.wifi.WifiConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.addOrUpdateNetwork(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_removeNetwork:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.removeNetwork(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enableNetwork:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.enableNetwork(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disableNetwork:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.disableNetwork(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_pingSupplicant:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.pingSupplicant();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_startScan:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.startScan(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getScanResults:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.net.wifi.ScanResult> _result = this.getScanResults();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_disconnect:
{
data.enforceInterface(DESCRIPTOR);
this.disconnect();
reply.writeNoException();
return true;
}
case TRANSACTION_reconnect:
{
data.enforceInterface(DESCRIPTOR);
this.reconnect();
reply.writeNoException();
return true;
}
case TRANSACTION_reassociate:
{
data.enforceInterface(DESCRIPTOR);
this.reassociate();
reply.writeNoException();
return true;
}
case TRANSACTION_getConnectionInfo:
{
data.enforceInterface(DESCRIPTOR);
android.net.wifi.WifiInfo _result = this.getConnectionInfo();
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
case TRANSACTION_setWifiEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.setWifiEnabled(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getWifiEnabledState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getWifiEnabledState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setCountryCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setCountryCode(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setFrequencyBand:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setFrequencyBand(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getFrequencyBand:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getFrequencyBand();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isDualBandSupported:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isDualBandSupported();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_saveConfiguration:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.saveConfiguration();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getDhcpInfo:
{
data.enforceInterface(DESCRIPTOR);
android.net.DhcpInfo _result = this.getDhcpInfo();
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
case TRANSACTION_acquireWifiLock:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
android.os.WorkSource _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.WorkSource.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
boolean _result = this.acquireWifiLock(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_updateWifiLockWorkSource:
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
this.updateWifiLockWorkSource(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_releaseWifiLock:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
boolean _result = this.releaseWifiLock(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_initializeMulticastFiltering:
{
data.enforceInterface(DESCRIPTOR);
this.initializeMulticastFiltering();
reply.writeNoException();
return true;
}
case TRANSACTION_isMulticastEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isMulticastEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_acquireMulticastLock:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
java.lang.String _arg1;
_arg1 = data.readString();
this.acquireMulticastLock(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_releaseMulticastLock:
{
data.enforceInterface(DESCRIPTOR);
this.releaseMulticastLock();
reply.writeNoException();
return true;
}
case TRANSACTION_setWifiApEnabled:
{
data.enforceInterface(DESCRIPTOR);
android.net.wifi.WifiConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.wifi.WifiConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setWifiApEnabled(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getWifiApEnabledState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getWifiApEnabledState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getWifiApConfiguration:
{
data.enforceInterface(DESCRIPTOR);
android.net.wifi.WifiConfiguration _result = this.getWifiApConfiguration();
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
case TRANSACTION_setWifiApConfiguration:
{
data.enforceInterface(DESCRIPTOR);
android.net.wifi.WifiConfiguration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.wifi.WifiConfiguration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setWifiApConfiguration(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_startWifi:
{
data.enforceInterface(DESCRIPTOR);
this.startWifi();
reply.writeNoException();
return true;
}
case TRANSACTION_stopWifi:
{
data.enforceInterface(DESCRIPTOR);
this.stopWifi();
reply.writeNoException();
return true;
}
case TRANSACTION_addToBlacklist:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.addToBlacklist(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_clearBlacklist:
{
data.enforceInterface(DESCRIPTOR);
this.clearBlacklist();
reply.writeNoException();
return true;
}
case TRANSACTION_getMessenger:
{
data.enforceInterface(DESCRIPTOR);
android.os.Messenger _result = this.getMessenger();
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
case TRANSACTION_getConfigFile:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getConfigFile();
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public java.util.List<android.net.wifi.WifiConfiguration> getConfiguredNetworks() throws android.os.RemoteException;
public int addOrUpdateNetwork(android.net.wifi.WifiConfiguration config) throws android.os.RemoteException;
public boolean removeNetwork(int netId) throws android.os.RemoteException;
public boolean enableNetwork(int netId, boolean disableOthers) throws android.os.RemoteException;
public boolean disableNetwork(int netId) throws android.os.RemoteException;
public boolean pingSupplicant() throws android.os.RemoteException;
public void startScan(boolean forceActive) throws android.os.RemoteException;
public java.util.List<android.net.wifi.ScanResult> getScanResults() throws android.os.RemoteException;
public void disconnect() throws android.os.RemoteException;
public void reconnect() throws android.os.RemoteException;
public void reassociate() throws android.os.RemoteException;
public android.net.wifi.WifiInfo getConnectionInfo() throws android.os.RemoteException;
public boolean setWifiEnabled(boolean enable) throws android.os.RemoteException;
public int getWifiEnabledState() throws android.os.RemoteException;
public void setCountryCode(java.lang.String country, boolean persist) throws android.os.RemoteException;
public void setFrequencyBand(int band, boolean persist) throws android.os.RemoteException;
public int getFrequencyBand() throws android.os.RemoteException;
public boolean isDualBandSupported() throws android.os.RemoteException;
public boolean saveConfiguration() throws android.os.RemoteException;
public android.net.DhcpInfo getDhcpInfo() throws android.os.RemoteException;
public boolean acquireWifiLock(android.os.IBinder lock, int lockType, java.lang.String tag, android.os.WorkSource ws) throws android.os.RemoteException;
public void updateWifiLockWorkSource(android.os.IBinder lock, android.os.WorkSource ws) throws android.os.RemoteException;
public boolean releaseWifiLock(android.os.IBinder lock) throws android.os.RemoteException;
public void initializeMulticastFiltering() throws android.os.RemoteException;
public boolean isMulticastEnabled() throws android.os.RemoteException;
public void acquireMulticastLock(android.os.IBinder binder, java.lang.String tag) throws android.os.RemoteException;
public void releaseMulticastLock() throws android.os.RemoteException;
public void setWifiApEnabled(android.net.wifi.WifiConfiguration wifiConfig, boolean enable) throws android.os.RemoteException;
public int getWifiApEnabledState() throws android.os.RemoteException;
public android.net.wifi.WifiConfiguration getWifiApConfiguration() throws android.os.RemoteException;
public void setWifiApConfiguration(android.net.wifi.WifiConfiguration wifiConfig) throws android.os.RemoteException;
public void startWifi() throws android.os.RemoteException;
public void stopWifi() throws android.os.RemoteException;
public void addToBlacklist(java.lang.String bssid) throws android.os.RemoteException;
public void clearBlacklist() throws android.os.RemoteException;
public android.os.Messenger getMessenger() throws android.os.RemoteException;
public java.lang.String getConfigFile() throws android.os.RemoteException;
}
