package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ILocationManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.location.ILocationManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.781 -0500", hash_original_field = "90BD957352A59A33FC1C4987F2DF5B2A", hash_generated_field = "8B1A549765C2156D604BFAEEE110DC66")

private static final java.lang.String DESCRIPTOR = "android.location.ILocationManager";
/**
 * Cast an IBinder object into an android.location.ILocationManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.787 -0500", hash_original_method = "8AC46237B4EEA0001FF61FEA5F29B28E", hash_generated_method = "03348E7F7CA68698A90D834FB46B6A2E")
        
public static android.location.ILocationManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.location.ILocationManager))) {
return ((android.location.ILocationManager)iin);
}
return new android.location.ILocationManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.924 -0500", hash_original_field = "53D71325E35B81A8CACEBE761FDFBF75", hash_generated_field = "C3B758FDD76283DE1392B1693D53A435")

static final int TRANSACTION_getAllProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.927 -0500", hash_original_field = "08E34DAED31F54BF46C466BEA6CD7580", hash_generated_field = "7C722CAA70B1A775C6938DC60FAFC54C")

static final int TRANSACTION_getProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.929 -0500", hash_original_field = "BF1686E3CE9EB45F1EC715D2FACAE65E", hash_generated_field = "FC6265C3BE6EC2CFAEB56E9D67A345CD")

static final int TRANSACTION_getBestProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.location.ILocationManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.819 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.821 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.824 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.827 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.830 -0500", hash_original_method = "C0821E6A5255491206B2EFC6C4EB022C", hash_generated_method = "FC719B38411B7367D58109BD0843C9C8")
            
public java.util.List<java.lang.String> getAllProviders() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<java.lang.String> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllProviders, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.833 -0500", hash_original_method = "2397F212ABA8C21D905B6D7D8B121F1E", hash_generated_method = "87ECD498E2CF942F2C50F7E62FF80036")
            
public java.util.List<java.lang.String> getProviders(android.location.Criteria criteria, boolean enabledOnly) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<java.lang.String> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((criteria!=null)) {
_data.writeInt(1);
criteria.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((enabledOnly)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_getProviders, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.836 -0500", hash_original_method = "5D9097856CC334CCD4DD2A2D4A212E00", hash_generated_method = "DD6A4EC3335D5406EEF613ABB3A0ABB4")
            
public java.lang.String getBestProvider(android.location.Criteria criteria, boolean enabledOnly) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((criteria!=null)) {
_data.writeInt(1);
criteria.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((enabledOnly)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_getBestProvider, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.839 -0500", hash_original_method = "3AE2094B951586968F7F41D089D7E47A", hash_generated_method = "12A106BE312C2F8556AABF12A7605725")
            
public boolean providerMeetsCriteria(java.lang.String provider, android.location.Criteria criteria) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
if ((criteria!=null)) {
_data.writeInt(1);
criteria.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_providerMeetsCriteria, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.843 -0500", hash_original_method = "77673AC87FDF20D1AC5C5543B8964807", hash_generated_method = "4958407C78BAF27752F4A88E94D40001")
            
public void requestLocationUpdates(java.lang.String provider, android.location.Criteria criteria, long minTime, float minDistance, boolean singleShot, android.location.ILocationListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
if ((criteria!=null)) {
_data.writeInt(1);
criteria.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(minTime);
_data.writeFloat(minDistance);
_data.writeInt(((singleShot)?(1):(0)));
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_requestLocationUpdates, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.846 -0500", hash_original_method = "09D334B698679F93B4EF5BD4FC984033", hash_generated_method = "9EB0C0164EAA8490D3FBD5F4ACD688D3")
            
public void requestLocationUpdatesPI(java.lang.String provider, android.location.Criteria criteria, long minTime, float minDistance, boolean singleShot, android.app.PendingIntent intent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
if ((criteria!=null)) {
_data.writeInt(1);
criteria.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(minTime);
_data.writeFloat(minDistance);
_data.writeInt(((singleShot)?(1):(0)));
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_requestLocationUpdatesPI, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.849 -0500", hash_original_method = "F4442D8DFCB9739D903465424F8153D8", hash_generated_method = "A3F88EDAC36C963CF53F34341704AF92")
            
public void removeUpdates(android.location.ILocationListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeUpdates, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.852 -0500", hash_original_method = "30FBB8F64131D6FBD545AD9CF88F39FD", hash_generated_method = "15BD45226DEC89EC919753C412A55656")
            
public void removeUpdatesPI(android.app.PendingIntent intent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removeUpdatesPI, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.854 -0500", hash_original_method = "98B83E363897B616D7D3F082F44F2D0C", hash_generated_method = "777ABA746CFF035E9723DD6024F3D7A8")
            
public boolean addGpsStatusListener(android.location.IGpsStatusListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addGpsStatusListener, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.857 -0500", hash_original_method = "29A243B324F98101DD594847221748B4", hash_generated_method = "B1451D00FFE7CC8FB6D143EF3FB387C0")
            
public void removeGpsStatusListener(android.location.IGpsStatusListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeGpsStatusListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// for reporting callback completion

@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.859 -0500", hash_original_method = "F02DC28371AAB51C29192A7A1A6F627E", hash_generated_method = "762063B50B5FE93F73FD305EC704489F")
            
public void locationCallbackFinished(android.location.ILocationListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_locationCallbackFinished, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.862 -0500", hash_original_method = "CCF773B16DAF1A5CE8FCB9A7503FF2EA", hash_generated_method = "65E944A8045983421148FC31A4141DA2")
            
public boolean sendExtraCommand(java.lang.String provider, java.lang.String command, android.os.Bundle extras) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
_data.writeString(command);
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendExtraCommand, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
extras.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.865 -0500", hash_original_method = "67C310D269EC71C791C9CFC4DA54EB52", hash_generated_method = "C877086A506FBAF62D955600E572C3D5")
            
public void addProximityAlert(double latitude, double longitude, float distance, long expiration, android.app.PendingIntent intent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeDouble(latitude);
_data.writeDouble(longitude);
_data.writeFloat(distance);
_data.writeLong(expiration);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addProximityAlert, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.867 -0500", hash_original_method = "0D2B499C707B92787AEE9C3C741AD146", hash_generated_method = "62EDA5216D43803F7B5107A8493F0722")
            
public void removeProximityAlert(android.app.PendingIntent intent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removeProximityAlert, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.871 -0500", hash_original_method = "8561549F0D7D3647A0433F055079F841", hash_generated_method = "968A663E700AA1F4263AD0259839CB40")
            
public android.os.Bundle getProviderInfo(java.lang.String provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Bundle _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
mRemote.transact(Stub.TRANSACTION_getProviderInfo, _data, _reply, 0);
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
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.873 -0500", hash_original_method = "D37CE27A6627CE482E63A2B351273E94", hash_generated_method = "512BA3F77FD2EFDB7B830FE6B26C6368")
            
public boolean isProviderEnabled(java.lang.String provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
mRemote.transact(Stub.TRANSACTION_isProviderEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.876 -0500", hash_original_method = "092051C33398BDF0E69B5E7CC5BDDACC", hash_generated_method = "05A50DE9F4C43434E960AE744C370B9E")
            
public android.location.Location getLastKnownLocation(java.lang.String provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.location.Location _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
mRemote.transact(Stub.TRANSACTION_getLastKnownLocation, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.location.Location.CREATOR.createFromParcel(_reply);
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
// Used by location providers to tell the location manager when it has a new location.
// Passive is true if the location is coming from the passive provider, in which case
// it need not be shared with other providers.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.879 -0500", hash_original_method = "15D1C977C494231E56E7F5ACA8A5EB4E", hash_generated_method = "CB29446C15021DA1DE647F1AD9939AEF")
            
public void reportLocation(android.location.Location location, boolean passive) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((location!=null)) {
_data.writeInt(1);
location.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((passive)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reportLocation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.882 -0500", hash_original_method = "A950F24C4C7C1F70AFEBB4609C4FE17F", hash_generated_method = "8EB9045C26ABB051BD249447A499AE7F")
            
public boolean geocoderIsPresent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_geocoderIsPresent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.884 -0500", hash_original_method = "2DF226641C501E2DF3982B08ACBDFB2C", hash_generated_method = "CB0AED64C2E34BE831C7A0EF05EAA592")
            
public java.lang.String getFromLocation(double latitude, double longitude, int maxResults, android.location.GeocoderParams params, java.util.List<android.location.Address> addrs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeDouble(latitude);
_data.writeDouble(longitude);
_data.writeInt(maxResults);
if ((params!=null)) {
_data.writeInt(1);
params.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getFromLocation, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
_reply.readTypedList(addrs, android.location.Address.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.888 -0500", hash_original_method = "5DADE8908487DDF7E2BA674715DF38C6", hash_generated_method = "3654563F6847250746726F6AB6CFCC74")
            
public java.lang.String getFromLocationName(java.lang.String locationName, double lowerLeftLatitude, double lowerLeftLongitude, double upperRightLatitude, double upperRightLongitude, int maxResults, android.location.GeocoderParams params, java.util.List<android.location.Address> addrs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(locationName);
_data.writeDouble(lowerLeftLatitude);
_data.writeDouble(lowerLeftLongitude);
_data.writeDouble(upperRightLatitude);
_data.writeDouble(upperRightLongitude);
_data.writeInt(maxResults);
if ((params!=null)) {
_data.writeInt(1);
params.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getFromLocationName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
_reply.readTypedList(addrs, android.location.Address.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.891 -0500", hash_original_method = "E70F46CA4ECF264DA5F455328E1411E1", hash_generated_method = "A84BC4C9BFA8CF888F467DE1922527C1")
            
public void addTestProvider(java.lang.String name, boolean requiresNetwork, boolean requiresSatellite, boolean requiresCell, boolean hasMonetaryCost, boolean supportsAltitude, boolean supportsSpeed, boolean supportsBearing, int powerRequirement, int accuracy) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(((requiresNetwork)?(1):(0)));
_data.writeInt(((requiresSatellite)?(1):(0)));
_data.writeInt(((requiresCell)?(1):(0)));
_data.writeInt(((hasMonetaryCost)?(1):(0)));
_data.writeInt(((supportsAltitude)?(1):(0)));
_data.writeInt(((supportsSpeed)?(1):(0)));
_data.writeInt(((supportsBearing)?(1):(0)));
_data.writeInt(powerRequirement);
_data.writeInt(accuracy);
mRemote.transact(Stub.TRANSACTION_addTestProvider, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.894 -0500", hash_original_method = "4DB798D13E868A9E5524A40067A078CE", hash_generated_method = "AD814CC531F101D237971A04E0F38706")
            
public void removeTestProvider(java.lang.String provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
mRemote.transact(Stub.TRANSACTION_removeTestProvider, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.897 -0500", hash_original_method = "E87965F36D9699870FA61F47CC45832C", hash_generated_method = "B759FDDD068B03971143F272F7DAC70B")
            
public void setTestProviderLocation(java.lang.String provider, android.location.Location loc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
if ((loc!=null)) {
_data.writeInt(1);
loc.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setTestProviderLocation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.899 -0500", hash_original_method = "07F4A5EDBE4507C88E05F1E69937F59E", hash_generated_method = "D15DF376A181A1E25E69FC9DAAA8ADE8")
            
public void clearTestProviderLocation(java.lang.String provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
mRemote.transact(Stub.TRANSACTION_clearTestProviderLocation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.902 -0500", hash_original_method = "8B62FDF312787A591978F93156A3670B", hash_generated_method = "BD1FAF3B0BEA2E6BD8AE2EAD50BD64E5")
            
public void setTestProviderEnabled(java.lang.String provider, boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setTestProviderEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.904 -0500", hash_original_method = "F7E11C1B9FB348C434B5298523BF8B45", hash_generated_method = "48AFE355EEE83D3A65F2D04660B897A6")
            
public void clearTestProviderEnabled(java.lang.String provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
mRemote.transact(Stub.TRANSACTION_clearTestProviderEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.907 -0500", hash_original_method = "13C2636743B7D3CB2E90FDE593203174", hash_generated_method = "BBCDBCD8E40C23168FA4A45F63D040C9")
            
public void setTestProviderStatus(java.lang.String provider, int status, android.os.Bundle extras, long updateTime) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
_data.writeInt(status);
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(updateTime);
mRemote.transact(Stub.TRANSACTION_setTestProviderStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.909 -0500", hash_original_method = "3BD17C739C653288AE432E00A19B2936", hash_generated_method = "7473A04F59F44EA861F1CC83565C6930")
            
public void clearTestProviderStatus(java.lang.String provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
mRemote.transact(Stub.TRANSACTION_clearTestProviderStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// for NI support

@DSSink({DSSinkKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.912 -0500", hash_original_method = "13C4B3EC0B5D91128701C302A6E283C6", hash_generated_method = "BC55F5739F1F77D3E0061B6B3D277852")
            
public boolean sendNiResponse(int notifId, int userResponse) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(notifId);
_data.writeInt(userResponse);
mRemote.transact(Stub.TRANSACTION_sendNiResponse, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.932 -0500", hash_original_field = "8AF4661F62125D5228EAF5D057566732", hash_generated_field = "93B29749CB64028951F2129F392AEA09")

static final int TRANSACTION_providerMeetsCriteria = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.934 -0500", hash_original_field = "DAA579831A6D023D25EEAD4E76377225", hash_generated_field = "4C9E686F3A20028F51E57494981E3E06")

static final int TRANSACTION_requestLocationUpdates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.937 -0500", hash_original_field = "CFE028EDA440461012F47A972AC358D5", hash_generated_field = "A7E0E6BE09AD298BC265E868CBC7552C")

static final int TRANSACTION_requestLocationUpdatesPI = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.939 -0500", hash_original_field = "80457346D63CE6D23312C1E8227FE544", hash_generated_field = "26153C1986F86D5693A269D785C26D51")

static final int TRANSACTION_removeUpdates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.941 -0500", hash_original_field = "6F8816B477615DE952580B450920F9BF", hash_generated_field = "711A9DB8D9BB84A4A18EDCA1FDA046CF")

static final int TRANSACTION_removeUpdatesPI = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.944 -0500", hash_original_field = "4BD58E50C0E3C1418F2DB4A1CD5A0AC8", hash_generated_field = "CBB09E4605C0C250C6BDFBA8FD25BFF8")

static final int TRANSACTION_addGpsStatusListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.946 -0500", hash_original_field = "8E27FE80B786E46D3A526D387FD07D80", hash_generated_field = "45506DF4E2B27F20407E17926DA73C6F")

static final int TRANSACTION_removeGpsStatusListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.949 -0500", hash_original_field = "570BC0278052B1BAFB046FBC25FD2712", hash_generated_field = "3A7BD39AD3361A79953F01CCFD3D060F")

static final int TRANSACTION_locationCallbackFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.951 -0500", hash_original_field = "2E582369D699FAD7DCBC450AE6318C9E", hash_generated_field = "3DCA82E35DB3B19786228A04D576C988")

static final int TRANSACTION_sendExtraCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.953 -0500", hash_original_field = "33011F4C6DA57F25A59F8BF8D66AC790", hash_generated_field = "DF6591057B24EB7D8A5EEE90FF05AE2A")

static final int TRANSACTION_addProximityAlert = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.956 -0500", hash_original_field = "785BEE6D31E1FC20AE88E0921A19F272", hash_generated_field = "A8FEF1A61F6C8655FC189516A13653B9")

static final int TRANSACTION_removeProximityAlert = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.958 -0500", hash_original_field = "1B7EC571C2071AB17C44003B4701616A", hash_generated_field = "D3DEC12BC921B746C7E8096D4C7E7A15")

static final int TRANSACTION_getProviderInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.961 -0500", hash_original_field = "E86C63FD277F244645B92B9EE05579BB", hash_generated_field = "0F7CD3FE4180C5DC2CF5EFF7AA7A2963")

static final int TRANSACTION_isProviderEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.963 -0500", hash_original_field = "BDBE57F33C1F1310386A8E751E427758", hash_generated_field = "74823EADCC9F6F77963BC071C44020F0")

static final int TRANSACTION_getLastKnownLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.966 -0500", hash_original_field = "22B7F767107F472FB5670A131966BC45", hash_generated_field = "5F2CB1B36FCF14256836084098CA24ED")

static final int TRANSACTION_reportLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.969 -0500", hash_original_field = "B66084AA885E1492A493B21AD0A4816C", hash_generated_field = "C044551C165CEDDEBACFE19323A8BC05")

static final int TRANSACTION_geocoderIsPresent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.972 -0500", hash_original_field = "A7096E8F18362AC9E5E7DE51829AFC97", hash_generated_field = "5157EA4FCC905DF0EDF64C7479436869")

static final int TRANSACTION_getFromLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.974 -0500", hash_original_field = "D3FCE2E053E111B0820536068BBF787F", hash_generated_field = "39C260BFB4B49708FF72260E97F5FF19")

static final int TRANSACTION_getFromLocationName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.976 -0500", hash_original_field = "230569EF31734E746E04442046951BBB", hash_generated_field = "4C94EE4738E8E4F6FFA0F1BAA5A7F2A5")

static final int TRANSACTION_addTestProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.979 -0500", hash_original_field = "00AC81604C19CBBE0C750594D6036317", hash_generated_field = "40E5C38F9BD672619491CA33894C1878")

static final int TRANSACTION_removeTestProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.981 -0500", hash_original_field = "59DAA73F970FA63A51D3874DF2F31264", hash_generated_field = "5D537D0CD9A9097A4CA701A7B30B3E3E")

static final int TRANSACTION_setTestProviderLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.983 -0500", hash_original_field = "DF026E85EF00513E48D665982675475B", hash_generated_field = "BC20D143B2F5138C008C81529D4E3786")

static final int TRANSACTION_clearTestProviderLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.986 -0500", hash_original_field = "A96A7577D6B987DA9EC83807BC591A7C", hash_generated_field = "8864320F44CD50598727898249CD3845")

static final int TRANSACTION_setTestProviderEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.988 -0500", hash_original_field = "02BB815E700DA3A9B6AB8CB2A5E23932", hash_generated_field = "12540F7C5A40B3964638873581DE403B")

static final int TRANSACTION_clearTestProviderEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.991 -0500", hash_original_field = "1CAEEE2A009EBE85845EAA22232157F0", hash_generated_field = "24F81DAED5033FDDA6C4C9983F1EF3E7")

static final int TRANSACTION_setTestProviderStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.994 -0500", hash_original_field = "D55AB64700D0653ABA72B8CB0B8D7FB6", hash_generated_field = "5793584D5AF6F234799E102F6684FDF8")

static final int TRANSACTION_clearTestProviderStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.996 -0500", hash_original_field = "C94A5ED06E871972B7DD3566D45852BD", hash_generated_field = "FAFBF8755D3DDBC5C41C86BCE1FD5FBD")

static final int TRANSACTION_sendNiResponse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.784 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.789 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.LOCATION_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:59.799 -0500", hash_original_method = "AB61A075AE242D91D53C4E2823482495", hash_generated_method = "96B42CB6376E569B9365F7AAF7A5EBE8")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getAllProviders:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<java.lang.String> _result = this.getAllProviders();
reply.writeNoException();
reply.writeStringList(_result);
return true;
}
case TRANSACTION_getProviders:
{
data.enforceInterface(DESCRIPTOR);
android.location.Criteria _arg0;
if ((0!=data.readInt())) {
_arg0 = android.location.Criteria.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
java.util.List<java.lang.String> _result = this.getProviders(_arg0, _arg1);
reply.writeNoException();
reply.writeStringList(_result);
return true;
}
case TRANSACTION_getBestProvider:
{
data.enforceInterface(DESCRIPTOR);
android.location.Criteria _arg0;
if ((0!=data.readInt())) {
_arg0 = android.location.Criteria.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
java.lang.String _result = this.getBestProvider(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_providerMeetsCriteria:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.location.Criteria _arg1;
if ((0!=data.readInt())) {
_arg1 = android.location.Criteria.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _result = this.providerMeetsCriteria(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_requestLocationUpdates:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.location.Criteria _arg1;
if ((0!=data.readInt())) {
_arg1 = android.location.Criteria.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
long _arg2;
_arg2 = data.readLong();
float _arg3;
_arg3 = data.readFloat();
boolean _arg4;
_arg4 = (0!=data.readInt());
android.location.ILocationListener _arg5;
_arg5 = android.location.ILocationListener.Stub.asInterface(data.readStrongBinder());
this.requestLocationUpdates(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_requestLocationUpdatesPI:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.location.Criteria _arg1;
if ((0!=data.readInt())) {
_arg1 = android.location.Criteria.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
long _arg2;
_arg2 = data.readLong();
float _arg3;
_arg3 = data.readFloat();
boolean _arg4;
_arg4 = (0!=data.readInt());
android.app.PendingIntent _arg5;
if ((0!=data.readInt())) {
_arg5 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
this.requestLocationUpdatesPI(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_removeUpdates:
{
data.enforceInterface(DESCRIPTOR);
android.location.ILocationListener _arg0;
_arg0 = android.location.ILocationListener.Stub.asInterface(data.readStrongBinder());
this.removeUpdates(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeUpdatesPI:
{
data.enforceInterface(DESCRIPTOR);
android.app.PendingIntent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.removeUpdatesPI(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_addGpsStatusListener:
{
data.enforceInterface(DESCRIPTOR);
android.location.IGpsStatusListener _arg0;
_arg0 = android.location.IGpsStatusListener.Stub.asInterface(data.readStrongBinder());
boolean _result = this.addGpsStatusListener(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_removeGpsStatusListener:
{
data.enforceInterface(DESCRIPTOR);
android.location.IGpsStatusListener _arg0;
_arg0 = android.location.IGpsStatusListener.Stub.asInterface(data.readStrongBinder());
this.removeGpsStatusListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_locationCallbackFinished:
{
data.enforceInterface(DESCRIPTOR);
android.location.ILocationListener _arg0;
_arg0 = android.location.ILocationListener.Stub.asInterface(data.readStrongBinder());
this.locationCallbackFinished(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendExtraCommand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
boolean _result = this.sendExtraCommand(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addProximityAlert:
{
data.enforceInterface(DESCRIPTOR);
double _arg0;
_arg0 = data.readDouble();
double _arg1;
_arg1 = data.readDouble();
float _arg2;
_arg2 = data.readFloat();
long _arg3;
_arg3 = data.readLong();
android.app.PendingIntent _arg4;
if ((0!=data.readInt())) {
_arg4 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
this.addProximityAlert(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_removeProximityAlert:
{
data.enforceInterface(DESCRIPTOR);
android.app.PendingIntent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.removeProximityAlert(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getProviderInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.Bundle _result = this.getProviderInfo(_arg0);
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
case TRANSACTION_isProviderEnabled:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isProviderEnabled(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getLastKnownLocation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.location.Location _result = this.getLastKnownLocation(_arg0);
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
case TRANSACTION_reportLocation:
{
data.enforceInterface(DESCRIPTOR);
android.location.Location _arg0;
if ((0!=data.readInt())) {
_arg0 = android.location.Location.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
this.reportLocation(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_geocoderIsPresent:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.geocoderIsPresent();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getFromLocation:
{
data.enforceInterface(DESCRIPTOR);
double _arg0;
_arg0 = data.readDouble();
double _arg1;
_arg1 = data.readDouble();
int _arg2;
_arg2 = data.readInt();
android.location.GeocoderParams _arg3;
if ((0!=data.readInt())) {
_arg3 = android.location.GeocoderParams.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
java.util.List<android.location.Address> _arg4;
_arg4 = new java.util.ArrayList<android.location.Address>();
java.lang.String _result = this.getFromLocation(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeString(_result);
reply.writeTypedList(_arg4);
return true;
}
case TRANSACTION_getFromLocationName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
double _arg1;
_arg1 = data.readDouble();
double _arg2;
_arg2 = data.readDouble();
double _arg3;
_arg3 = data.readDouble();
double _arg4;
_arg4 = data.readDouble();
int _arg5;
_arg5 = data.readInt();
android.location.GeocoderParams _arg6;
if ((0!=data.readInt())) {
_arg6 = android.location.GeocoderParams.CREATOR.createFromParcel(data);
}
else {
_arg6 = null;
}
java.util.List<android.location.Address> _arg7;
_arg7 = new java.util.ArrayList<android.location.Address>();
java.lang.String _result = this.getFromLocationName(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
reply.writeNoException();
reply.writeString(_result);
reply.writeTypedList(_arg7);
return true;
}
case TRANSACTION_addTestProvider:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _arg4;
_arg4 = (0!=data.readInt());
boolean _arg5;
_arg5 = (0!=data.readInt());
boolean _arg6;
_arg6 = (0!=data.readInt());
boolean _arg7;
_arg7 = (0!=data.readInt());
int _arg8;
_arg8 = data.readInt();
int _arg9;
_arg9 = data.readInt();
this.addTestProvider(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9);
reply.writeNoException();
return true;
}
case TRANSACTION_removeTestProvider:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.removeTestProvider(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setTestProviderLocation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.location.Location _arg1;
if ((0!=data.readInt())) {
_arg1 = android.location.Location.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.setTestProviderLocation(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_clearTestProviderLocation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearTestProviderLocation(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setTestProviderEnabled:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setTestProviderEnabled(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_clearTestProviderEnabled:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearTestProviderEnabled(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setTestProviderStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
long _arg3;
_arg3 = data.readLong();
this.setTestProviderStatus(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_clearTestProviderStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearTestProviderStatus(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendNiResponse:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.sendNiResponse(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public java.util.List<java.lang.String> getAllProviders() throws android.os.RemoteException;
public java.util.List<java.lang.String> getProviders(android.location.Criteria criteria, boolean enabledOnly) throws android.os.RemoteException;
public java.lang.String getBestProvider(android.location.Criteria criteria, boolean enabledOnly) throws android.os.RemoteException;
public boolean providerMeetsCriteria(java.lang.String provider, android.location.Criteria criteria) throws android.os.RemoteException;
public void requestLocationUpdates(java.lang.String provider, android.location.Criteria criteria, long minTime, float minDistance, boolean singleShot, android.location.ILocationListener listener) throws android.os.RemoteException;
public void requestLocationUpdatesPI(java.lang.String provider, android.location.Criteria criteria, long minTime, float minDistance, boolean singleShot, android.app.PendingIntent intent) throws android.os.RemoteException;
public void removeUpdates(android.location.ILocationListener listener) throws android.os.RemoteException;
public void removeUpdatesPI(android.app.PendingIntent intent) throws android.os.RemoteException;
public boolean addGpsStatusListener(android.location.IGpsStatusListener listener) throws android.os.RemoteException;
public void removeGpsStatusListener(android.location.IGpsStatusListener listener) throws android.os.RemoteException;

public void locationCallbackFinished(android.location.ILocationListener listener) throws android.os.RemoteException;
public boolean sendExtraCommand(java.lang.String provider, java.lang.String command, android.os.Bundle extras) throws android.os.RemoteException;
public void addProximityAlert(double latitude, double longitude, float distance, long expiration, android.app.PendingIntent intent) throws android.os.RemoteException;
public void removeProximityAlert(android.app.PendingIntent intent) throws android.os.RemoteException;
public android.os.Bundle getProviderInfo(java.lang.String provider) throws android.os.RemoteException;
public boolean isProviderEnabled(java.lang.String provider) throws android.os.RemoteException;
public android.location.Location getLastKnownLocation(java.lang.String provider) throws android.os.RemoteException;

public void reportLocation(android.location.Location location, boolean passive) throws android.os.RemoteException;
public boolean geocoderIsPresent() throws android.os.RemoteException;
public java.lang.String getFromLocation(double latitude, double longitude, int maxResults, android.location.GeocoderParams params, java.util.List<android.location.Address> addrs) throws android.os.RemoteException;
public java.lang.String getFromLocationName(java.lang.String locationName, double lowerLeftLatitude, double lowerLeftLongitude, double upperRightLatitude, double upperRightLongitude, int maxResults, android.location.GeocoderParams params, java.util.List<android.location.Address> addrs) throws android.os.RemoteException;
public void addTestProvider(java.lang.String name, boolean requiresNetwork, boolean requiresSatellite, boolean requiresCell, boolean hasMonetaryCost, boolean supportsAltitude, boolean supportsSpeed, boolean supportsBearing, int powerRequirement, int accuracy) throws android.os.RemoteException;
public void removeTestProvider(java.lang.String provider) throws android.os.RemoteException;
public void setTestProviderLocation(java.lang.String provider, android.location.Location loc) throws android.os.RemoteException;
public void clearTestProviderLocation(java.lang.String provider) throws android.os.RemoteException;
public void setTestProviderEnabled(java.lang.String provider, boolean enabled) throws android.os.RemoteException;
public void clearTestProviderEnabled(java.lang.String provider) throws android.os.RemoteException;
public void setTestProviderStatus(java.lang.String provider, int status, android.os.Bundle extras, long updateTime) throws android.os.RemoteException;
public void clearTestProviderStatus(java.lang.String provider) throws android.os.RemoteException;

public boolean sendNiResponse(int notifId, int userResponse) throws android.os.RemoteException;
}
