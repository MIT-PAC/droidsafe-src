package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IRemoteViewsFactory extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.widget.IRemoteViewsFactory
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.616 -0500", hash_original_field = "5A9D2D2DBDCC4332AE76703321F8705E", hash_generated_field = "948A0B2283CE5A10E2C3331FE44B053E")

private static final java.lang.String DESCRIPTOR = "com.android.internal.widget.IRemoteViewsFactory";
/**
 * Cast an IBinder object into an com.android.internal.widget.IRemoteViewsFactory interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.622 -0500", hash_original_method = "43A26E10D1522F4E72197EA00C034E3F", hash_generated_method = "F2490E6F280CCFC1DBBB840C7121263A")
        
public static com.android.internal.widget.IRemoteViewsFactory asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.widget.IRemoteViewsFactory))) {
return ((com.android.internal.widget.IRemoteViewsFactory)iin);
}
return new com.android.internal.widget.IRemoteViewsFactory.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.676 -0500", hash_original_field = "69EEF1B53B4CC368480C20426E1546BE", hash_generated_field = "A47CA702CC0C3AE1066DF4EC84325558")

static final int TRANSACTION_onDataSetChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.679 -0500", hash_original_field = "5B48BEFF2F65BA97DB1B70C634CB0E90", hash_generated_field = "D79511A402C864DB874CEA6160E82D24")

static final int TRANSACTION_onDataSetChangedAsync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.681 -0500", hash_original_field = "3FE66D4BCF5D075B9BB5853375D7AD64", hash_generated_field = "479272C4DBA6EA95EA47C30BDD7C8084")

static final int TRANSACTION_onDestroy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.widget.IRemoteViewsFactory
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.633 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.636 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.638 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.640 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.643 -0500", hash_original_method = "B6DF3AA1DE2D352C035C5CDBCE496E1A", hash_generated_method = "81F1FE526223F514C50136CF8C57EEB0")
            
public void onDataSetChanged() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onDataSetChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.646 -0500", hash_original_method = "A6348BBA6713BFC92A7AE0A38B392CC2", hash_generated_method = "3B8E96428752DEFCB4639787E3FD77CD")
            
public void onDataSetChangedAsync() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onDataSetChangedAsync, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.649 -0500", hash_original_method = "4705930DD87BDE06E815999C15ACD41C", hash_generated_method = "2DEBDD8B1F37D1D0ADB01E67B479E408")
            
public void onDestroy(android.content.Intent intent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onDestroy, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.652 -0500", hash_original_method = "8F75DEE90D77050C4310F7910F15DF05", hash_generated_method = "CF1DD4C68CEEEF2CEBCC892B1AD60B7C")
            
public int getCount() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.655 -0500", hash_original_method = "BA333F7F5D07AC2A58CE75793633866C", hash_generated_method = "54EA236C4F3EAF26C18D7E76CADC8DA7")
            
public android.widget.RemoteViews getViewAt(int position) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.widget.RemoteViews _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(position);
mRemote.transact(Stub.TRANSACTION_getViewAt, _data, _reply, 0);
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
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.658 -0500", hash_original_method = "F702B727011CDFB63BDFB32B1FE7B2A5", hash_generated_method = "C266DDE36430753EF06153C0F080D4F3")
            
public android.widget.RemoteViews getLoadingView() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.widget.RemoteViews _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLoadingView, _data, _reply, 0);
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
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.661 -0500", hash_original_method = "E651AF580573ED5B04D1A5927CC9A606", hash_generated_method = "CF42F48DB461484CA63EAFA55B72754E")
            
public int getViewTypeCount() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getViewTypeCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.663 -0500", hash_original_method = "ACF825C65D44E45C2D369BEBD643C7EE", hash_generated_method = "A1EA02CF79818EACBA2C21B1FE09B56F")
            
public long getItemId(int position) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(position);
mRemote.transact(Stub.TRANSACTION_getItemId, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.667 -0500", hash_original_method = "313940FF486368F815DE3F23098C9469", hash_generated_method = "4B4DAA9B9F74E7BC23DEC655D7736901")
            
public boolean hasStableIds() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hasStableIds, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.670 -0500", hash_original_method = "DD2A6BA2F158F2AC7C7847CEE433BA01", hash_generated_method = "AF7E5F1EA4934EC5898221BCFA9F7149")
            
public boolean isCreated() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isCreated, _data, _reply, 0);
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.684 -0500", hash_original_field = "BA9459D140CDA83760C35ED775AC5568", hash_generated_field = "AC21746800880BED94211ED0CCE7D541")

static final int TRANSACTION_getCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.686 -0500", hash_original_field = "4BC91C76CF02F5CB2CD1FD6BF8BFC8DC", hash_generated_field = "97FB2EED4FE27B69B03694B50144B260")

static final int TRANSACTION_getViewAt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.688 -0500", hash_original_field = "4068878951CBC0B26AC13DD383496F74", hash_generated_field = "78F93BE0B5F625EA51DA8F03A6953317")

static final int TRANSACTION_getLoadingView = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.691 -0500", hash_original_field = "3B615020DFEE0FED984E297D3A630447", hash_generated_field = "3AA8B19A872F3C879AED30C8A4B7D69B")

static final int TRANSACTION_getViewTypeCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.694 -0500", hash_original_field = "A1363EBFDC2C03BFFE50D00FB416C83D", hash_generated_field = "ACCDD9901A4E7B1250693F2F87B009A3")

static final int TRANSACTION_getItemId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.696 -0500", hash_original_field = "5E6AA319450B261AB601E988185F6E74", hash_generated_field = "0961304CC32F5E59EB770866A17B9EDC")

static final int TRANSACTION_hasStableIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.699 -0500", hash_original_field = "ECB2CD254EABEC22C9803C600B85D561", hash_generated_field = "BA2DD78C101A466AA1F100EAD163491C")

static final int TRANSACTION_isCreated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.619 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.624 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:41.628 -0500", hash_original_method = "A5844ECD7A1735F8D83694E0B059C083", hash_generated_method = "FC35DC049969E22C9A9816BB43B7AF99")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onDataSetChanged:
{
data.enforceInterface(DESCRIPTOR);
this.onDataSetChanged();
reply.writeNoException();
return true;
}
case TRANSACTION_onDataSetChangedAsync:
{
data.enforceInterface(DESCRIPTOR);
this.onDataSetChangedAsync();
return true;
}
case TRANSACTION_onDestroy:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onDestroy(_arg0);
return true;
}
case TRANSACTION_getCount:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCount();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getViewAt:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.widget.RemoteViews _result = this.getViewAt(_arg0);
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
case TRANSACTION_getLoadingView:
{
data.enforceInterface(DESCRIPTOR);
android.widget.RemoteViews _result = this.getLoadingView();
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
case TRANSACTION_getViewTypeCount:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getViewTypeCount();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getItemId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
long _result = this.getItemId(_arg0);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_hasStableIds:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasStableIds();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isCreated:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isCreated();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onDataSetChanged() throws android.os.RemoteException;
public void onDataSetChangedAsync() throws android.os.RemoteException;
public void onDestroy(android.content.Intent intent) throws android.os.RemoteException;
public int getCount() throws android.os.RemoteException;
public android.widget.RemoteViews getViewAt(int position) throws android.os.RemoteException;
public android.widget.RemoteViews getLoadingView() throws android.os.RemoteException;
public int getViewTypeCount() throws android.os.RemoteException;
public long getItemId(int position) throws android.os.RemoteException;
public boolean hasStableIds() throws android.os.RemoteException;
public boolean isCreated() throws android.os.RemoteException;
}
