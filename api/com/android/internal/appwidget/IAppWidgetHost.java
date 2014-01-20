package com.android.internal.appwidget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAppWidgetHost extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.appwidget.IAppWidgetHost
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.906 -0500", hash_original_field = "D09A999A3D0330E1514845A6ACB632BF", hash_generated_field = "B79723FFCFF8FECAA4B26730BE186029")

private static final java.lang.String DESCRIPTOR = "com.android.internal.appwidget.IAppWidgetHost";
/**
 * Cast an IBinder object into an com.android.internal.appwidget.IAppWidgetHost interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.912 -0500", hash_original_method = "2D12236C640379814C1A67B246F19708", hash_generated_method = "A5004D6779B7A74163D4312520A0AC70")
        
public static com.android.internal.appwidget.IAppWidgetHost asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.appwidget.IAppWidgetHost))) {
return ((com.android.internal.appwidget.IAppWidgetHost)iin);
}
return new com.android.internal.appwidget.IAppWidgetHost.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.943 -0500", hash_original_field = "9016546BBE71E8A7BABBD890AA36E8AD", hash_generated_field = "9933D162B19147292951F2B762AE459B")

static final int TRANSACTION_updateAppWidget = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.945 -0500", hash_original_field = "F15C8E6E429294986664D0CC3B8660DD", hash_generated_field = "9A78F1C9C8F0425EFCF264E072CBDF61")

static final int TRANSACTION_providerChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.948 -0500", hash_original_field = "FE6F41096784C4B4AB8208FB94008E69", hash_generated_field = "F286B6650132F196BCF3B59A35D0884B")

static final int TRANSACTION_viewDataChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.appwidget.IAppWidgetHost
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.920 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.923 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.926 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.929 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.931 -0500", hash_original_method = "02C6507D074497BF089DBAA331A24342", hash_generated_method = "3F1BE24B973E1941CBE8ACB290B88E74")
            
public void updateAppWidget(int appWidgetId, android.widget.RemoteViews views) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
if ((views!=null)) {
_data.writeInt(1);
views.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateAppWidget, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.935 -0500", hash_original_method = "F49E6ECAC7A22BF94D71C102CF2E2AA9", hash_generated_method = "E35BEC16CF8F2F023013AA6F7320BC54")
            
public void providerChanged(int appWidgetId, android.appwidget.AppWidgetProviderInfo info) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_providerChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.938 -0500", hash_original_method = "3620FD325E02E952B3478FFE0DA55A21", hash_generated_method = "677E08CB6361B22A04D03C98EEA91683")
            
public void viewDataChanged(int appWidgetId, int viewId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appWidgetId);
_data.writeInt(viewId);
mRemote.transact(Stub.TRANSACTION_viewDataChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.909 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.914 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:27.917 -0500", hash_original_method = "3428B59A88628F3800F5B049DFC58054", hash_generated_method = "CFF9F98D2FC2D5A2024C7BB8B8DA45A6")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_updateAppWidget:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.widget.RemoteViews _arg1;
if ((0!=data.readInt())) {
_arg1 = android.widget.RemoteViews.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.updateAppWidget(_arg0, _arg1);
return true;
}
case TRANSACTION_providerChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.appwidget.AppWidgetProviderInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = android.appwidget.AppWidgetProviderInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.providerChanged(_arg0, _arg1);
return true;
}
case TRANSACTION_viewDataChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.viewDataChanged(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void updateAppWidget(int appWidgetId, android.widget.RemoteViews views) throws android.os.RemoteException;
public void providerChanged(int appWidgetId, android.appwidget.AppWidgetProviderInfo info) throws android.os.RemoteException;
public void viewDataChanged(int appWidgetId, int viewId) throws android.os.RemoteException;
}
