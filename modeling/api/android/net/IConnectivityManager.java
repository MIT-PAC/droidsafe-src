package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IConnectivityManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.net.IConnectivityManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.071 -0500", hash_original_field = "CC453FBF33EB83483C847952D270A164", hash_generated_field = "CA025BD7024E39C3220DB07572C004ED")

private static final java.lang.String DESCRIPTOR = "android.net.IConnectivityManager";
/**
 * Cast an IBinder object into an android.net.IConnectivityManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.076 -0500", hash_original_method = "778858588B29D682D5478284A4C82711", hash_generated_method = "BB051CD5382BA19ADECC6790FBA793C7")
        
public static android.net.IConnectivityManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.IConnectivityManager))) {
return ((android.net.IConnectivityManager)iin);
}
return new android.net.IConnectivityManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.230 -0500", hash_original_field = "86C1A21D23844764F907ACAB696AB1B2", hash_generated_field = "D1CFEC76C581BF50E68C5887A8EE1C0F")

static final int TRANSACTION_setNetworkPreference = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.233 -0500", hash_original_field = "A70E799DD59BEA949785F3B5F01AC9D7", hash_generated_field = "47D1F1D907FCEA1AB8AD03F0D27FE625")

static final int TRANSACTION_getNetworkPreference = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.235 -0500", hash_original_field = "BB1BB130AF52551431675E89D29F2CDE", hash_generated_field = "DFA17995FD839A4F97448A96E06D5199")

static final int TRANSACTION_getActiveNetworkInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.IConnectivityManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.091 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.094 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.097 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.099 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.102 -0500", hash_original_method = "E2072CA5497F88FC2F3D2C51E8086A72", hash_generated_method = "D9781252050B0F159F9352D837388FA9")
            
public void setNetworkPreference(int pref) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(pref);
mRemote.transact(Stub.TRANSACTION_setNetworkPreference, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.105 -0500", hash_original_method = "11466C887EDCE56F951611BAEB038DCA", hash_generated_method = "AAB25DA3244D1A77DC8319BADD58CC19")
            
public int getNetworkPreference() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNetworkPreference, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.108 -0500", hash_original_method = "2C866B15C0F0E84CFC797122654D18E4", hash_generated_method = "71E89013D043917DBD4A5605B0AAD677")
            
public android.net.NetworkInfo getActiveNetworkInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getActiveNetworkInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkInfo.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.110 -0500", hash_original_method = "245256CEE453C289CB612BC38E0B03D3", hash_generated_method = "BFC6835B298CCD3A5AB9FD595751EC82")
            
public android.net.NetworkInfo getActiveNetworkInfoForUid(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getActiveNetworkInfoForUid, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkInfo.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.113 -0500", hash_original_method = "3BB2E777115B511364750C26EF96F9DD", hash_generated_method = "305C07975CB0889396725BE9A853CF19")
            
public android.net.NetworkInfo getNetworkInfo(int networkType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
mRemote.transact(Stub.TRANSACTION_getNetworkInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkInfo.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.115 -0500", hash_original_method = "83A322ABF4E70B4590000EB3F62A913A", hash_generated_method = "942FBDBB06BD2C2B299FBAF0AD1C992C")
            
public android.net.NetworkInfo[] getAllNetworkInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkInfo[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllNetworkInfo, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.net.NetworkInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.118 -0500", hash_original_method = "B35686F5F5063B18220A8B47F3474962", hash_generated_method = "1ED388D4461B7187E6EF9D41AC7C8C68")
            
public boolean isNetworkSupported(int networkType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
mRemote.transact(Stub.TRANSACTION_isNetworkSupported, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.121 -0500", hash_original_method = "4F93D9C60C587373BC1ECAD9BC8AAF85", hash_generated_method = "6AA4CE3902B9457883A8677ADFADB331")
            
public android.net.LinkProperties getActiveLinkProperties() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.LinkProperties _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getActiveLinkProperties, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.LinkProperties.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.123 -0500", hash_original_method = "FADCDC2562560BB75F2AE477FEB4F2FB", hash_generated_method = "0A0ABFD81B5B412D403F15C40F85C46B")
            
public android.net.LinkProperties getLinkProperties(int networkType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.LinkProperties _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
mRemote.transact(Stub.TRANSACTION_getLinkProperties, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.LinkProperties.CREATOR.createFromParcel(_reply);
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
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.127 -0500", hash_original_method = "C7466FFFDD7764B92FDB9A5132EC8CFA", hash_generated_method = "5B4335A74AC34AFC12EA5EECF959FE25")
            
public android.net.NetworkState[] getAllNetworkState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkState[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllNetworkState, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.net.NetworkState.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.130 -0500", hash_original_method = "2C487FAD8758D39B1B9E2E9B56FBA4F2", hash_generated_method = "994737E6D2639F7FFDDF460840B712B3")
            
public android.net.NetworkQuotaInfo getActiveNetworkQuotaInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkQuotaInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getActiveNetworkQuotaInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkQuotaInfo.CREATOR.createFromParcel(_reply);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.133 -0500", hash_original_method = "5E1595DD97CB3E94E1151A3EF21873EF", hash_generated_method = "D8AEA685BFE9CEBF5D1CF24B0926E4E3")
            
public boolean setRadios(boolean onOff) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((onOff)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setRadios, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.135 -0500", hash_original_method = "48755B59A69A0C1177ED78770B9969CD", hash_generated_method = "8F25D85B8F1C1EE47FBF42AFA593BABA")
            
public boolean setRadio(int networkType, boolean turnOn) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
_data.writeInt(((turnOn)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setRadio, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.138 -0500", hash_original_method = "58645E717EB1D6419C3441F088F6AD02", hash_generated_method = "A0594B8289DC091476CCED681CA046D1")
            
public int startUsingNetworkFeature(int networkType, java.lang.String feature, android.os.IBinder binder) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
_data.writeString(feature);
_data.writeStrongBinder(binder);
mRemote.transact(Stub.TRANSACTION_startUsingNetworkFeature, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.140 -0500", hash_original_method = "C2E8D74F9C3D15240246B595035D1B0D", hash_generated_method = "475DB8393A30D082DA8D5A5AB9BA6F8A")
            
public int stopUsingNetworkFeature(int networkType, java.lang.String feature) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
_data.writeString(feature);
mRemote.transact(Stub.TRANSACTION_stopUsingNetworkFeature, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.143 -0500", hash_original_method = "DCC6BA63EB3C7934C6039FB2BA3F063B", hash_generated_method = "CDF56C37A22C819B4790A26BDFBD303F")
            
public boolean requestRouteToHost(int networkType, int hostAddress) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
_data.writeInt(hostAddress);
mRemote.transact(Stub.TRANSACTION_requestRouteToHost, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.146 -0500", hash_original_method = "4AC77373479A3B08CAAC42BA163DD06B", hash_generated_method = "2291590B47A4FDDB76913B07868B1AAA")
            
public boolean requestRouteToHostAddress(int networkType, byte[] hostAddress) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
_data.writeByteArray(hostAddress);
mRemote.transact(Stub.TRANSACTION_requestRouteToHostAddress, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.149 -0500", hash_original_method = "738E1F76A6DCACCE67478C03A23287A2", hash_generated_method = "2F15DE86759699EAD85E0C914724B125")
            
public boolean getMobileDataEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMobileDataEnabled, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.151 -0500", hash_original_method = "57F4896B233F49218B691D59C890D8B1", hash_generated_method = "918EB5FF4786AB6A763A6419579B79FA")
            
public void setMobileDataEnabled(boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setMobileDataEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** Policy control over specific {@link NetworkStateTracker}. */
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.155 -0500", hash_original_method = "1A06A3F1B629397DA90C1C0FA87B9EF8", hash_generated_method = "E44A1ADAAE72D420F90252566040C8EA")
            
public void setPolicyDataEnable(int networkType, boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setPolicyDataEnable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.157 -0500", hash_original_method = "B966AADB7F52E4FAD9C498BE0705847D", hash_generated_method = "431A3C0A59C92692B602CF54D50C3551")
            
public int tether(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_tether, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.160 -0500", hash_original_method = "A8799F0C23B56CBB44C4F46F46428E0D", hash_generated_method = "0079166B5D939E8377B12886C81F0CC3")
            
public int untether(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_untether, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.162 -0500", hash_original_method = "8E6CFF8921DC4C5726E88520E77F6BA2", hash_generated_method = "23C289A93D4695758123DD56BF4C148A")
            
public int getLastTetherError(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_getLastTetherError, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.165 -0500", hash_original_method = "13E84AFFD4C7ED9D1F73C0B99FB5DA19", hash_generated_method = "0D9FA8647B70C7C3F8D3DB288CD74A7A")
            
public boolean isTetheringSupported() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isTetheringSupported, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.167 -0500", hash_original_method = "46BE56AD97DA289CB966E7AEABE89447", hash_generated_method = "747224CE3BAA6AF5A312A548E37760E6")
            
public java.lang.String[] getTetherableIfaces() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTetherableIfaces, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.170 -0500", hash_original_method = "1723F088EDD7D352298514D8224B024B", hash_generated_method = "CAFEEB46FA8A66C91F5A3DCE3C2D4BA9")
            
public java.lang.String[] getTetheredIfaces() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTetheredIfaces, _data, _reply, 0);
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
     * Return list of interface pairs that are actively tethered.  Even indexes are
     * remote interface, and odd indexes are corresponding local interfaces.
     */
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.173 -0500", hash_original_method = "27515C98554D40B93E384090A9844A68", hash_generated_method = "5CD114F6F0C4129B1C443078391408FB")
            
public java.lang.String[] getTetheredIfacePairs() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTetheredIfacePairs, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.175 -0500", hash_original_method = "07E89C6716B90D4E96A267F4A607CD3B", hash_generated_method = "68E3E6FC6938904093D4F0228CEAF538")
            
public java.lang.String[] getTetheringErroredIfaces() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTetheringErroredIfaces, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.179 -0500", hash_original_method = "8BA54E846E048C44DCBA4D87F7B77D73", hash_generated_method = "65EC4ED850161C95803B8036C709D15B")
            
public java.lang.String[] getTetherableUsbRegexs() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTetherableUsbRegexs, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.181 -0500", hash_original_method = "C44F911867E671E6B784C565E4E76188", hash_generated_method = "8FDFA4CF8DA5D7A23561EFF45013E541")
            
public java.lang.String[] getTetherableWifiRegexs() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTetherableWifiRegexs, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.184 -0500", hash_original_method = "8DE5AED6522A8FB1C6C9BF6022A27E44", hash_generated_method = "35AF34BCF145E427AE13D5EA96A600ED")
            
public java.lang.String[] getTetherableBluetoothRegexs() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTetherableBluetoothRegexs, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.187 -0500", hash_original_method = "AC6F79AB524EA10BED37B620B5F5F180", hash_generated_method = "1CEDC7BE2C254F9E0E92B52A58CBD053")
            
public int setUsbTethering(boolean enable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setUsbTethering, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.189 -0500", hash_original_method = "302E4BC045257356E3088970226F401F", hash_generated_method = "DA7C50248B4F5A1DADFC91F0F937728F")
            
public void requestNetworkTransitionWakelock(java.lang.String forWhom) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(forWhom);
mRemote.transact(Stub.TRANSACTION_requestNetworkTransitionWakelock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.192 -0500", hash_original_method = "ED0CB56EFBB65A101B05657EB92DB1B1", hash_generated_method = "BD10BA77993BED4BEE6442F949971ABE")
            
public void reportInetCondition(int networkType, int percentage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
_data.writeInt(percentage);
mRemote.transact(Stub.TRANSACTION_reportInetCondition, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.195 -0500", hash_original_method = "118F75D1CC49CCA58F8233A5AB19C3C4", hash_generated_method = "41DB1C3703A76CD5E3071A9732DDDEB6")
            
public android.net.ProxyProperties getGlobalProxy() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.ProxyProperties _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getGlobalProxy, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.ProxyProperties.CREATOR.createFromParcel(_reply);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.197 -0500", hash_original_method = "9CAD2BFB3B993B60E36C32B1472B9440", hash_generated_method = "9A7AC87A79FF08100A8C73F1134DE0C2")
            
public void setGlobalProxy(android.net.ProxyProperties p) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((p!=null)) {
_data.writeInt(1);
p.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setGlobalProxy, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.200 -0500", hash_original_method = "84939E329FCE5EEFABDE13A09ED346C3", hash_generated_method = "928E6AEC5E2A0FEE6ED0E14E516B988F")
            
public android.net.ProxyProperties getProxy() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.ProxyProperties _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getProxy, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.ProxyProperties.CREATOR.createFromParcel(_reply);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.203 -0500", hash_original_method = "EB7AF8D19EDBB545492B6FAD291F081B", hash_generated_method = "5445291B0B3E07882BD9330794A89901")
            
public void setDataDependency(int networkType, boolean met) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(networkType);
_data.writeInt(((met)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setDataDependency, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.205 -0500", hash_original_method = "170DFE5DBFA71E4F699CD5DB44392A38", hash_generated_method = "9E66496664E0D3853E9F77C13EFA16FF")
            
public boolean protectVpn(android.os.ParcelFileDescriptor socket) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((socket!=null)) {
_data.writeInt(1);
socket.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_protectVpn, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.208 -0500", hash_original_method = "2321E94361050124ADA0AF1C65354D8C", hash_generated_method = "6D20FD286C611E6B772E7B3114F01400")
            
public boolean prepareVpn(java.lang.String oldPackage, java.lang.String newPackage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(oldPackage);
_data.writeString(newPackage);
mRemote.transact(Stub.TRANSACTION_prepareVpn, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.211 -0500", hash_original_method = "4B1094BFD9B1C617CE0058EF088DDED1", hash_generated_method = "F2023B4A8305C37D157C9CECDFEC667D")
            
public android.os.ParcelFileDescriptor establishVpn(com.android.internal.net.VpnConfig config) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelFileDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_establishVpn, _data, _reply, 0);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.213 -0500", hash_original_method = "89300AFE21DEA587D6B94FC56F891048", hash_generated_method = "9CBE76955C568964FC43114EA88A12A1")
            
public void startLegacyVpn(com.android.internal.net.VpnConfig config, java.lang.String[] racoon, java.lang.String[] mtpd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStringArray(racoon);
_data.writeStringArray(mtpd);
mRemote.transact(Stub.TRANSACTION_startLegacyVpn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.217 -0500", hash_original_method = "27BBB95F463959CB8AF214A6D38B7EC6", hash_generated_method = "4080535BD707C3805045E00DF939ED0F")
            
public com.android.internal.net.LegacyVpnInfo getLegacyVpnInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.android.internal.net.LegacyVpnInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLegacyVpnInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.android.internal.net.LegacyVpnInfo.CREATOR.createFromParcel(_reply);
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
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.237 -0500", hash_original_field = "A8026E65995F1BB0B6E766CAB2790A93", hash_generated_field = "121BCF6E91E78C2D65B73CCAA9CCAB8E")

static final int TRANSACTION_getActiveNetworkInfoForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.240 -0500", hash_original_field = "C79EDF2E18B4A5B46E2B605EA3D37EE9", hash_generated_field = "D6F4123D7ABD676FE271E10867B5CEAD")

static final int TRANSACTION_getNetworkInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.242 -0500", hash_original_field = "1196F610E519AA2B3F8A81AC64181A7E", hash_generated_field = "1305B00F8F56318D451FCB264573549E")

static final int TRANSACTION_getAllNetworkInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.244 -0500", hash_original_field = "6E8F930C36F2A4A3547A0F939632D810", hash_generated_field = "AABC94664DC3B44CF56F4AEC56AABC0E")

static final int TRANSACTION_isNetworkSupported = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.247 -0500", hash_original_field = "7FCE6D2752919922EF217F44BBABDE60", hash_generated_field = "387AFEE9E23B9E1E9958F146608385D6")

static final int TRANSACTION_getActiveLinkProperties = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.249 -0500", hash_original_field = "23B3E54A4599347E5DDDFB427AD61022", hash_generated_field = "E09FD37104ED6365F19C2510F9BC2189")

static final int TRANSACTION_getLinkProperties = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.252 -0500", hash_original_field = "D431603307FAC78C1D4D890EF032CE61", hash_generated_field = "D1B42991754B2B8526308FD3AF52DEB3")

static final int TRANSACTION_getAllNetworkState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.258 -0500", hash_original_field = "0120980929F6A2F27AA1AB159B125810", hash_generated_field = "C041FD69737EEFB0B6887F715616A210")

static final int TRANSACTION_getActiveNetworkQuotaInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.261 -0500", hash_original_field = "B911871D640455D4E4C658E5E9AE53E7", hash_generated_field = "A0C9B28931A238D9D595165FA4634C88")

static final int TRANSACTION_setRadios = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.264 -0500", hash_original_field = "8DDDA0433836D1E744A23FCA4B1D1397", hash_generated_field = "C1C05991C97ADE46B557FFDA9125777D")

static final int TRANSACTION_setRadio = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.266 -0500", hash_original_field = "A628EC22AF55A9EC555401E006138A48", hash_generated_field = "9E1B6EC60CFE293BE724ECCD85E909C7")

static final int TRANSACTION_startUsingNetworkFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.268 -0500", hash_original_field = "F36F3B1F55EB688A172F8A5A328B7959", hash_generated_field = "7D0797DE2FFA85C36698E3538482E2D0")

static final int TRANSACTION_stopUsingNetworkFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.271 -0500", hash_original_field = "48D35EAF496DD3FCA979CC926EEC6EF1", hash_generated_field = "EE69FCA24C0DEEC528D377CEC835E8CC")

static final int TRANSACTION_requestRouteToHost = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.273 -0500", hash_original_field = "5991B7DEE0446CF2CA8F1C53D5B18A37", hash_generated_field = "EB9B59E4D5598DAF8D2589F181606455")

static final int TRANSACTION_requestRouteToHostAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.275 -0500", hash_original_field = "C63D7DA1B531ED04C19E1C2AE78DE8D7", hash_generated_field = "0D892602098FEE03EE1D0970FA0AA7D3")

static final int TRANSACTION_getMobileDataEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.278 -0500", hash_original_field = "C58E93CA2CD60DF7BF8D2EE842BBD292", hash_generated_field = "0FE50AA90D25016121E842532D8ABC51")

static final int TRANSACTION_setMobileDataEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.280 -0500", hash_original_field = "4D6098ADFA7D6972FB14E8C688B985CC", hash_generated_field = "CF2F7EBCA479278C6B46EAF08031363F")

static final int TRANSACTION_setPolicyDataEnable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.283 -0500", hash_original_field = "48009EDC9E5F0C0D06827F388193F4C0", hash_generated_field = "2E731653998F6FE8A5E56D16DB1E679D")

static final int TRANSACTION_tether = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.285 -0500", hash_original_field = "71ABF188F5AAE998E40328D0498F7976", hash_generated_field = "68E20A579469C4A8F5959818E51DB068")

static final int TRANSACTION_untether = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.287 -0500", hash_original_field = "43EDEABB26BD815E63618DBC1CBC218F", hash_generated_field = "D1808EFE51E9D421110827D88E0A8361")

static final int TRANSACTION_getLastTetherError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.290 -0500", hash_original_field = "9ADB932C3ED70158DD701D7FF2814A7B", hash_generated_field = "D3AF23F74109D9842CA83C348CFA23AC")

static final int TRANSACTION_isTetheringSupported = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.293 -0500", hash_original_field = "7154CC236C6A21D20CA394F38FC05130", hash_generated_field = "2254755C0004031F0F3002155B729967")

static final int TRANSACTION_getTetherableIfaces = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.295 -0500", hash_original_field = "2AF6965830E5C82087BAB4E490C6DB32", hash_generated_field = "60D8CE9ABCCDE2B5483DE1659DE62F9A")

static final int TRANSACTION_getTetheredIfaces = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.297 -0500", hash_original_field = "BCF273CEBEEDDBFCB59458320F2864EC", hash_generated_field = "2B2DB5C37D422FEB9B9AE95CD96A5DCE")

static final int TRANSACTION_getTetheredIfacePairs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.300 -0500", hash_original_field = "37A38C6C278030569324DA44CC50B2A4", hash_generated_field = "EDE03EE5070E9C33E0120F69050DF304")

static final int TRANSACTION_getTetheringErroredIfaces = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.302 -0500", hash_original_field = "A33E99B1EBB91B0F4E0529EC729C59E5", hash_generated_field = "DB12F2EB2DA9437951C36E5626ED186F")

static final int TRANSACTION_getTetherableUsbRegexs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.304 -0500", hash_original_field = "D23A83C50C3C464F7AA5017BF8A5E707", hash_generated_field = "B33F0BF95978F0B1A511E1D5AD3A5A50")

static final int TRANSACTION_getTetherableWifiRegexs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.307 -0500", hash_original_field = "455A931013A98964B4167BFFABF59844", hash_generated_field = "8FFA89FEBE0D681682339D460D4F54EA")

static final int TRANSACTION_getTetherableBluetoothRegexs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.309 -0500", hash_original_field = "9E802841838B57CC05C62ED9FD9A1E61", hash_generated_field = "97161E51D6796E7E931D064EC712BA42")

static final int TRANSACTION_setUsbTethering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.312 -0500", hash_original_field = "FF7245647BE0E55AB5BBE4BACA7F5A70", hash_generated_field = "DB5AA98E315D9DD45A91221117269785")

static final int TRANSACTION_requestNetworkTransitionWakelock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.314 -0500", hash_original_field = "B742F3F55C884233E63B9CC4A7455A14", hash_generated_field = "E2DFD6A334630A4D2A384465BDCCDE96")

static final int TRANSACTION_reportInetCondition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.317 -0500", hash_original_field = "8A0E2CBAFE38BD07AB704E8084DE4424", hash_generated_field = "A73AAB16A1C2E7F92B3F23F2F7DED6EF")

static final int TRANSACTION_getGlobalProxy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.319 -0500", hash_original_field = "CD31F5EF80EC36E91499DD0CAAAC2226", hash_generated_field = "C99B5009F05AAB9EE0EACB59C7B2F52A")

static final int TRANSACTION_setGlobalProxy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.321 -0500", hash_original_field = "AF843B3CC27C92BF163CB6E5A540389B", hash_generated_field = "D1A35BD4C52F3DE1804D8E9DF8410C7E")

static final int TRANSACTION_getProxy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.324 -0500", hash_original_field = "1A89B5AFCFF58B5EBF453E25AAC75CC9", hash_generated_field = "25728063C4866967D23066F070FB6E2E")

static final int TRANSACTION_setDataDependency = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.327 -0500", hash_original_field = "4D56228340C6D2BF2A8042EBDB4C9B34", hash_generated_field = "F0F5DE1B9166767EDEFC8B2FEA15F0B5")

static final int TRANSACTION_protectVpn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.329 -0500", hash_original_field = "1B02B4F330F153BA563DBE7D52002768", hash_generated_field = "13836107868627AE9F07678C7114DB92")

static final int TRANSACTION_prepareVpn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.331 -0500", hash_original_field = "8A3F41C0AAD6CA751CD95B116640907F", hash_generated_field = "D8D50B4C6857760A55C7BAA77F3279FC")

static final int TRANSACTION_establishVpn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.334 -0500", hash_original_field = "A4EF07D8F315F40870D3AE3D2D0CD490", hash_generated_field = "1F107553B02B9B2FE0A059C0BC1E45F1")

static final int TRANSACTION_startLegacyVpn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.336 -0500", hash_original_field = "E32D994451BCD13DD7C955ACEE247300", hash_generated_field = "E5EF68F086583959948727A105D435A5")

static final int TRANSACTION_getLegacyVpnInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.073 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.078 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.088 -0500", hash_original_method = "C00C1CF50FDCBD9DE513CA4CBBD3737E", hash_generated_method = "8CEB1BF0BDE7658E52109845ED170B82")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setNetworkPreference:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setNetworkPreference(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getNetworkPreference:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getNetworkPreference();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getActiveNetworkInfo:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkInfo _result = this.getActiveNetworkInfo();
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
case TRANSACTION_getActiveNetworkInfoForUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.net.NetworkInfo _result = this.getActiveNetworkInfoForUid(_arg0);
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
case TRANSACTION_getNetworkInfo:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.net.NetworkInfo _result = this.getNetworkInfo(_arg0);
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
case TRANSACTION_getAllNetworkInfo:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkInfo[] _result = this.getAllNetworkInfo();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_isNetworkSupported:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.isNetworkSupported(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getActiveLinkProperties:
{
data.enforceInterface(DESCRIPTOR);
android.net.LinkProperties _result = this.getActiveLinkProperties();
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
case TRANSACTION_getLinkProperties:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.net.LinkProperties _result = this.getLinkProperties(_arg0);
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
case TRANSACTION_getAllNetworkState:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkState[] _result = this.getAllNetworkState();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_getActiveNetworkQuotaInfo:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkQuotaInfo _result = this.getActiveNetworkQuotaInfo();
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
case TRANSACTION_setRadios:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.setRadios(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setRadio:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.setRadio(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_startUsingNetworkFeature:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
android.os.IBinder _arg2;
_arg2 = data.readStrongBinder();
int _result = this.startUsingNetworkFeature(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_stopUsingNetworkFeature:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.stopUsingNetworkFeature(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_requestRouteToHost:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.requestRouteToHost(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_requestRouteToHostAddress:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _arg1;
_arg1 = data.createByteArray();
boolean _result = this.requestRouteToHostAddress(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getMobileDataEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getMobileDataEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setMobileDataEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setMobileDataEnabled(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setPolicyDataEnable:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setPolicyDataEnable(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_tether:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.tether(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_untether:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.untether(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getLastTetherError:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getLastTetherError(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isTetheringSupported:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isTetheringSupported();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getTetherableIfaces:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getTetherableIfaces();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getTetheredIfaces:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getTetheredIfaces();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getTetheredIfacePairs:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getTetheredIfacePairs();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getTetheringErroredIfaces:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getTetheringErroredIfaces();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getTetherableUsbRegexs:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getTetherableUsbRegexs();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getTetherableWifiRegexs:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getTetherableWifiRegexs();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getTetherableBluetoothRegexs:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getTetherableBluetoothRegexs();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_setUsbTethering:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
int _result = this.setUsbTethering(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_requestNetworkTransitionWakelock:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.requestNetworkTransitionWakelock(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_reportInetCondition:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.reportInetCondition(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getGlobalProxy:
{
data.enforceInterface(DESCRIPTOR);
android.net.ProxyProperties _result = this.getGlobalProxy();
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
case TRANSACTION_setGlobalProxy:
{
data.enforceInterface(DESCRIPTOR);
android.net.ProxyProperties _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.ProxyProperties.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setGlobalProxy(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getProxy:
{
data.enforceInterface(DESCRIPTOR);
android.net.ProxyProperties _result = this.getProxy();
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
case TRANSACTION_setDataDependency:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setDataDependency(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_protectVpn:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.protectVpn(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_prepareVpn:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.prepareVpn(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_establishVpn:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.net.VpnConfig _arg0;
if ((0!=data.readInt())) {
_arg0 = com.android.internal.net.VpnConfig.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.ParcelFileDescriptor _result = this.establishVpn(_arg0);
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
case TRANSACTION_startLegacyVpn:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.net.VpnConfig _arg0;
if ((0!=data.readInt())) {
_arg0 = com.android.internal.net.VpnConfig.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String[] _arg1;
_arg1 = data.createStringArray();
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
this.startLegacyVpn(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getLegacyVpnInfo:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.net.LegacyVpnInfo _result = this.getLegacyVpnInfo();
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
}
return super.onTransact(code, data, reply, flags);
}
}
public void setNetworkPreference(int pref) throws android.os.RemoteException;
public int getNetworkPreference() throws android.os.RemoteException;
public android.net.NetworkInfo getActiveNetworkInfo() throws android.os.RemoteException;
public android.net.NetworkInfo getActiveNetworkInfoForUid(int uid) throws android.os.RemoteException;
public android.net.NetworkInfo getNetworkInfo(int networkType) throws android.os.RemoteException;
public android.net.NetworkInfo[] getAllNetworkInfo() throws android.os.RemoteException;
public boolean isNetworkSupported(int networkType) throws android.os.RemoteException;
public android.net.LinkProperties getActiveLinkProperties() throws android.os.RemoteException;
public android.net.LinkProperties getLinkProperties(int networkType) throws android.os.RemoteException;
public android.net.NetworkState[] getAllNetworkState() throws android.os.RemoteException;
public android.net.NetworkQuotaInfo getActiveNetworkQuotaInfo() throws android.os.RemoteException;
public boolean setRadios(boolean onOff) throws android.os.RemoteException;
public boolean setRadio(int networkType, boolean turnOn) throws android.os.RemoteException;
public int startUsingNetworkFeature(int networkType, java.lang.String feature, android.os.IBinder binder) throws android.os.RemoteException;
public int stopUsingNetworkFeature(int networkType, java.lang.String feature) throws android.os.RemoteException;
public boolean requestRouteToHost(int networkType, int hostAddress) throws android.os.RemoteException;
public boolean requestRouteToHostAddress(int networkType, byte[] hostAddress) throws android.os.RemoteException;
public boolean getMobileDataEnabled() throws android.os.RemoteException;
public void setMobileDataEnabled(boolean enabled) throws android.os.RemoteException;

public void setPolicyDataEnable(int networkType, boolean enabled) throws android.os.RemoteException;
public int tether(java.lang.String iface) throws android.os.RemoteException;
public int untether(java.lang.String iface) throws android.os.RemoteException;
public int getLastTetherError(java.lang.String iface) throws android.os.RemoteException;
public boolean isTetheringSupported() throws android.os.RemoteException;
public java.lang.String[] getTetherableIfaces() throws android.os.RemoteException;
public java.lang.String[] getTetheredIfaces() throws android.os.RemoteException;

public java.lang.String[] getTetheredIfacePairs() throws android.os.RemoteException;
public java.lang.String[] getTetheringErroredIfaces() throws android.os.RemoteException;
public java.lang.String[] getTetherableUsbRegexs() throws android.os.RemoteException;
public java.lang.String[] getTetherableWifiRegexs() throws android.os.RemoteException;
public java.lang.String[] getTetherableBluetoothRegexs() throws android.os.RemoteException;
public int setUsbTethering(boolean enable) throws android.os.RemoteException;
public void requestNetworkTransitionWakelock(java.lang.String forWhom) throws android.os.RemoteException;
public void reportInetCondition(int networkType, int percentage) throws android.os.RemoteException;
public android.net.ProxyProperties getGlobalProxy() throws android.os.RemoteException;
public void setGlobalProxy(android.net.ProxyProperties p) throws android.os.RemoteException;
public android.net.ProxyProperties getProxy() throws android.os.RemoteException;
public void setDataDependency(int networkType, boolean met) throws android.os.RemoteException;
public boolean protectVpn(android.os.ParcelFileDescriptor socket) throws android.os.RemoteException;
public boolean prepareVpn(java.lang.String oldPackage, java.lang.String newPackage) throws android.os.RemoteException;
public android.os.ParcelFileDescriptor establishVpn(com.android.internal.net.VpnConfig config) throws android.os.RemoteException;
public void startLegacyVpn(com.android.internal.net.VpnConfig config, java.lang.String[] racoon, java.lang.String[] mtpd) throws android.os.RemoteException;
public com.android.internal.net.LegacyVpnInfo getLegacyVpnInfo() throws android.os.RemoteException;
}
