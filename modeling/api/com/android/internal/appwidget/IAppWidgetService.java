package com.android.internal.appwidget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAppWidgetService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.appwidget.IAppWidgetService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.424 -0500", hash_original_field = "17540352B19E442215A7EAB33C9E59AC", hash_generated_field = "8B43E645E0488E5FBB1C340A5E71CD48")

private static final java.lang.String DESCRIPTOR = "com.android.internal.appwidget.IAppWidgetService";
/**
 * Cast an IBinder object into an com.android.internal.appwidget.IAppWidgetService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.430 -0500", hash_original_method = "05DBF8B609F924963CC983A354FF7515", hash_generated_method = "B33C2A242F4EF32F931518589BC994F9")
        
public static com.android.internal.appwidget.IAppWidgetService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.appwidget.IAppWidgetService))) {
return ((com.android.internal.appwidget.IAppWidgetService)iin);
}
return new com.android.internal.appwidget.IAppWidgetService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.508 -0500", hash_original_field = "74955C7CB165DEC2A72F0CB6337BEDA4", hash_generated_field = "41FEC88E3E2593DD3CFC525EA2008432")

static final int TRANSACTION_startListening = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.511 -0500", hash_original_field = "935FA1F2F338B25DAAC7692B28780C6D", hash_generated_field = "5FF0FA5FBC09CDB8B4B0E7AEE1EC4912")

static final int TRANSACTION_stopListening = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.514 -0500", hash_original_field = "AED14AA09D49828A11D39BDC6511F498", hash_generated_field = "A83CE0E2D491205D9BDE1F51E2D33096")

static final int TRANSACTION_allocateAppWidgetId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.appwidget.IAppWidgetService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.441 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.444 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.448 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.450 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
//
// for AppWidgetHost
//

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.453 -0500", hash_original_method = "59E8482C0D9C34A101A9985C5633A3F9", hash_generated_method = "36025A2ABF14911B84816C57839B1FEB")
            
public int[] startListening(com.android.internal.appwidget.IAppWidgetHost host, java.lang.String packageName, int hostId, java.util.List<android.widget.RemoteViews> updatedViews) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((host!=null))?(host.asBinder()):(null)));
_data.writeString(packageName);
_data.writeInt(hostId);
mRemote.transact(Stub.TRANSACTION_startListening, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
_reply.readTypedList(updatedViews, android.widget.RemoteViews.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.457 -0500", hash_original_method = "E86DF44A4F83B33A3FFA45572028DB31", hash_generated_method = "4A31A60B2239AF844AE581371FD4925F")
            
public void stopListening(int hostId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(hostId);
mRemote.transact(Stub.TRANSACTION_stopListening, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.459 -0500", hash_original_method = "597322E1017D219F30C8DD7C81B9A0DB", hash_generated_method = "55FFC6FCD04B7B814745A5967177D9AD")
            
public int allocateAppWidgetId(java.lang.String packageName, int hostId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(hostId);
mRemote.transact(Stub.TRANSACTION_allocateAppWidgetId, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.462 -0500", hash_original_method = "DBA0AF54C13F068397071FB7900C0CF7", hash_generated_method = "BB76DC6C090FDBA20CC305881F49369C")
            
public void deleteAppWidgetId(int appWidgetId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
mRemote.transact(Stub.TRANSACTION_deleteAppWidgetId, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.465 -0500", hash_original_method = "708471E5CC5B872F46398A80A1AD2740", hash_generated_method = "8E709EBAF907DA0C65E7EE6418702CBD")
            
public void deleteHost(int hostId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(hostId);
mRemote.transact(Stub.TRANSACTION_deleteHost, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.467 -0500", hash_original_method = "2B50E47C079F14ADDF866B17A5BC4208", hash_generated_method = "44A0286945A7E02F90C3661F71D2484B")
            
public void deleteAllHosts() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_deleteAllHosts, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.471 -0500", hash_original_method = "D0DD0FB2C94CCD7AB044CBAB2624A902", hash_generated_method = "72C594FC501B751DF5B9BA7321AA3BE0")
            
public android.widget.RemoteViews getAppWidgetViews(int appWidgetId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.widget.RemoteViews _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
mRemote.transact(Stub.TRANSACTION_getAppWidgetViews, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.widget.RemoteViews.CREATOR.createFromParcel(_reply);
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
//
// for AppWidgetManager
//

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.473 -0500", hash_original_method = "9C748B9C4D2399A263A93F9188EA36B7", hash_generated_method = "AF5159DBB6DBE4B00887F347C6DDB032")
            
public void updateAppWidgetIds(int[] appWidgetIds, android.widget.RemoteViews views) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(appWidgetIds);
if ((views!=null)) {
_data.writeInt(1);
views.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateAppWidgetIds, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.477 -0500", hash_original_method = "DB0AA9ACAC8009AACE5E703FC0AE247A", hash_generated_method = "38F76D25405AE5B06D97065AA4F88D22")
            
public void partiallyUpdateAppWidgetIds(int[] appWidgetIds, android.widget.RemoteViews views) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(appWidgetIds);
if ((views!=null)) {
_data.writeInt(1);
views.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_partiallyUpdateAppWidgetIds, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.480 -0500", hash_original_method = "6890A7A16E2DA76174C6C78658BF5699", hash_generated_method = "CD07F3A70EF10E32EC748D0019187969")
            
public void updateAppWidgetProvider(android.content.ComponentName provider, android.widget.RemoteViews views) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((provider!=null)) {
_data.writeInt(1);
provider.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((views!=null)) {
_data.writeInt(1);
views.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateAppWidgetProvider, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.483 -0500", hash_original_method = "44B39EC2C960D8569FAA473100E620C4", hash_generated_method = "9AF63FB6DE7E9262A5542F555D84471C")
            
public void notifyAppWidgetViewDataChanged(int[] appWidgetIds, int viewId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(appWidgetIds);
_data.writeInt(viewId);
mRemote.transact(Stub.TRANSACTION_notifyAppWidgetViewDataChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.486 -0500", hash_original_method = "A802C05E2CE4041E5A28A5AB3FFFFC1A", hash_generated_method = "C91D94D00D8374BFB569668DD092E4F4")
            
public java.util.List<android.appwidget.AppWidgetProviderInfo> getInstalledProviders() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.appwidget.AppWidgetProviderInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInstalledProviders, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.appwidget.AppWidgetProviderInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.489 -0500", hash_original_method = "E92A6C4C68CBA0593E24127FB7BCD9B8", hash_generated_method = "271BC2D418C7CD87B889D6A7E4793803")
            
public android.appwidget.AppWidgetProviderInfo getAppWidgetInfo(int appWidgetId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.appwidget.AppWidgetProviderInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
mRemote.transact(Stub.TRANSACTION_getAppWidgetInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.appwidget.AppWidgetProviderInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.492 -0500", hash_original_method = "8401D1BD89BB51E0A05029F4E4403801", hash_generated_method = "1A272F683426213F85CF266A809364C1")
            
public void bindAppWidgetId(int appWidgetId, android.content.ComponentName provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
if ((provider!=null)) {
_data.writeInt(1);
provider.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_bindAppWidgetId, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.495 -0500", hash_original_method = "DCDF92E1D2CC11E86100E31C5F34442A", hash_generated_method = "1A91B978A14D4F3AD87F64B1ADB2BAEE")
            
public void bindRemoteViewsService(int appWidgetId, android.content.Intent intent, android.os.IBinder connection) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder(connection);
mRemote.transact(Stub.TRANSACTION_bindRemoteViewsService, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.497 -0500", hash_original_method = "EA603553055D1A0FC447763774DF3B76", hash_generated_method = "36F5994C7610BAF57C326FC52D01ED29")
            
public void unbindRemoteViewsService(int appWidgetId, android.content.Intent intent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_unbindRemoteViewsService, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.501 -0500", hash_original_method = "348F8C28338B91239F488723D790F7C3", hash_generated_method = "175D98C0F60357CA31A8253B33A5214E")
            
public int[] getAppWidgetIds(android.content.ComponentName provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((provider!=null)) {
_data.writeInt(1);
provider.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getAppWidgetIds, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.517 -0500", hash_original_field = "592037FF858FA62BC2E897F435CDD01B", hash_generated_field = "2B7D16D58CA6DF2EA77B1A8498FE9E14")

static final int TRANSACTION_deleteAppWidgetId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.520 -0500", hash_original_field = "BDE057A8C33DB0F20EDFBE79BA980AF1", hash_generated_field = "04074657BC77C696352AD865D8AEC35B")

static final int TRANSACTION_deleteHost = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.523 -0500", hash_original_field = "042F69752DF32C0A2BE23DC817291F58", hash_generated_field = "F6EB871791E765586F92211FF362BBF8")

static final int TRANSACTION_deleteAllHosts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.525 -0500", hash_original_field = "86FF6932C4BD1D9F9316AB2AD33B1FB2", hash_generated_field = "E11800F245C656E832AE00533273E30E")

static final int TRANSACTION_getAppWidgetViews = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.528 -0500", hash_original_field = "7FB0F16C8484692167B1A348BA5E2486", hash_generated_field = "A68EA87CB40D3AF1B09BE8B44A76C0B5")

static final int TRANSACTION_updateAppWidgetIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.531 -0500", hash_original_field = "030297C00AB64FE6CB7DFB2B2BC7B835", hash_generated_field = "C071F83B36DECB1F482B20433BB387A9")

static final int TRANSACTION_partiallyUpdateAppWidgetIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.533 -0500", hash_original_field = "13B6AEE1096C7EAE77A32A747D898E0E", hash_generated_field = "0AE2B067FBB37BA9FC4EA32C7859D8DB")

static final int TRANSACTION_updateAppWidgetProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.536 -0500", hash_original_field = "1F87922DFF3AA610D116DBB33F96EF34", hash_generated_field = "BA682515DC9622460B41B115D882C426")

static final int TRANSACTION_notifyAppWidgetViewDataChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.538 -0500", hash_original_field = "D6226008B321D2FB298D50BD076472CE", hash_generated_field = "1D6330B4B52F041960053B3555890FDB")

static final int TRANSACTION_getInstalledProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.541 -0500", hash_original_field = "78F4D52610EBC915C9445D6F67E320DB", hash_generated_field = "885A92F118EC67F049DC38AF8708E95A")

static final int TRANSACTION_getAppWidgetInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.543 -0500", hash_original_field = "3012BD08DBC1E10DB65A73C359F440BF", hash_generated_field = "151E23D3859D76DC7AB8441AF977D7F1")

static final int TRANSACTION_bindAppWidgetId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.547 -0500", hash_original_field = "F2FF72F5B47F46F097C555B12347BE7B", hash_generated_field = "4210657D2CFA10BD7DC7EC8D45406BB5")

static final int TRANSACTION_bindRemoteViewsService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.549 -0500", hash_original_field = "9B70966BB189AFC5978251D01889C897", hash_generated_field = "52677FF7CB72F498D85FE4700537B2DF")

static final int TRANSACTION_unbindRemoteViewsService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.551 -0500", hash_original_field = "320AF9611FBE5B963A1662B9EF9C2B03", hash_generated_field = "1A5DBD88857F419771D5945E42BF197E")

static final int TRANSACTION_getAppWidgetIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.427 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.432 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.437 -0500", hash_original_method = "58E2E5121AA0A4D493DD4D8F67A175F9", hash_generated_method = "FBE56DA644216D9701740185883E7003")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_startListening:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.appwidget.IAppWidgetHost _arg0;
_arg0 = com.android.internal.appwidget.IAppWidgetHost.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
java.util.List<android.widget.RemoteViews> _arg3;
_arg3 = new java.util.ArrayList<android.widget.RemoteViews>();
int[] _result = this.startListening(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeIntArray(_result);
reply.writeTypedList(_arg3);
return true;
}
case TRANSACTION_stopListening:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.stopListening(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_allocateAppWidgetId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _result = this.allocateAppWidgetId(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_deleteAppWidgetId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.deleteAppWidgetId(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_deleteHost:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.deleteHost(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_deleteAllHosts:
{
data.enforceInterface(DESCRIPTOR);
this.deleteAllHosts();
reply.writeNoException();
return true;
}
case TRANSACTION_getAppWidgetViews:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.widget.RemoteViews _result = this.getAppWidgetViews(_arg0);
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
case TRANSACTION_updateAppWidgetIds:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
android.widget.RemoteViews _arg1;
if ((0!=data.readInt())) {
_arg1 = android.widget.RemoteViews.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.updateAppWidgetIds(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_partiallyUpdateAppWidgetIds:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
android.widget.RemoteViews _arg1;
if ((0!=data.readInt())) {
_arg1 = android.widget.RemoteViews.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.partiallyUpdateAppWidgetIds(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_updateAppWidgetProvider:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.widget.RemoteViews _arg1;
if ((0!=data.readInt())) {
_arg1 = android.widget.RemoteViews.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.updateAppWidgetProvider(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyAppWidgetViewDataChanged:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
int _arg1;
_arg1 = data.readInt();
this.notifyAppWidgetViewDataChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getInstalledProviders:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.appwidget.AppWidgetProviderInfo> _result = this.getInstalledProviders();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getAppWidgetInfo:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.appwidget.AppWidgetProviderInfo _result = this.getAppWidgetInfo(_arg0);
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
case TRANSACTION_bindAppWidgetId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.content.ComponentName _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.bindAppWidgetId(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_bindRemoteViewsService:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.content.Intent _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.os.IBinder _arg2;
_arg2 = data.readStrongBinder();
this.bindRemoteViewsService(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_unbindRemoteViewsService:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.content.Intent _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.unbindRemoteViewsService(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getAppWidgetIds:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int[] _result = this.getAppWidgetIds(_arg0);
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public int[] startListening(com.android.internal.appwidget.IAppWidgetHost host, java.lang.String packageName, int hostId, java.util.List<android.widget.RemoteViews> updatedViews) throws android.os.RemoteException;
public void stopListening(int hostId) throws android.os.RemoteException;
public int allocateAppWidgetId(java.lang.String packageName, int hostId) throws android.os.RemoteException;
public void deleteAppWidgetId(int appWidgetId) throws android.os.RemoteException;
public void deleteHost(int hostId) throws android.os.RemoteException;
public void deleteAllHosts() throws android.os.RemoteException;
public android.widget.RemoteViews getAppWidgetViews(int appWidgetId) throws android.os.RemoteException;

public void updateAppWidgetIds(int[] appWidgetIds, android.widget.RemoteViews views) throws android.os.RemoteException;
public void partiallyUpdateAppWidgetIds(int[] appWidgetIds, android.widget.RemoteViews views) throws android.os.RemoteException;
public void updateAppWidgetProvider(android.content.ComponentName provider, android.widget.RemoteViews views) throws android.os.RemoteException;
public void notifyAppWidgetViewDataChanged(int[] appWidgetIds, int viewId) throws android.os.RemoteException;
public java.util.List<android.appwidget.AppWidgetProviderInfo> getInstalledProviders() throws android.os.RemoteException;
public android.appwidget.AppWidgetProviderInfo getAppWidgetInfo(int appWidgetId) throws android.os.RemoteException;
public void bindAppWidgetId(int appWidgetId, android.content.ComponentName provider) throws android.os.RemoteException;
public void bindRemoteViewsService(int appWidgetId, android.content.Intent intent, android.os.IBinder connection) throws android.os.RemoteException;
public void unbindRemoteViewsService(int appWidgetId, android.content.Intent intent) throws android.os.RemoteException;
public int[] getAppWidgetIds(android.content.ComponentName provider) throws android.os.RemoteException;
}
