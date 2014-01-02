package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ISearchManager extends android.os.IInterface
{

    public static abstract class Stub extends android.os.Binder implements android.app.ISearchManager
    {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.415 -0500", hash_original_field = "B1A71DECCF2AE2CBDFD88910F5E8879F", hash_generated_field = "B9BE4D9D5D90254E56656BDFFE77D16F")

private static final java.lang.String DESCRIPTOR = "android.app.ISearchManager";
/**
 * Cast an IBinder object into an android.app.ISearchManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.420 -0500", hash_original_method = "222B4743F6FDF973482E2BCAF508E175", hash_generated_method = "96A475CD5B1E78E0C4FDA5FC8708703C")
        
public static android.app.ISearchManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.ISearchManager))) {
return ((android.app.ISearchManager)iin);
}
return new android.app.ISearchManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.458 -0500", hash_original_field = "59A3DC4FD036C94A07D40E629C5ACAE1", hash_generated_field = "7586F0AC735D3CBE0EEDB8318728D7EA")

static final int TRANSACTION_getSearchableInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.460 -0500", hash_original_field = "F03E68F7F81F26B72A4EAB4AB01C4F1F", hash_generated_field = "EDA31A4EBD8BEEBA070A0C2BE4F0AB29")

static final int TRANSACTION_getSearchablesInGlobalSearch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.463 -0500", hash_original_field = "6010EB910BD03AA6D7B98889DC23A2D2", hash_generated_field = "F449168034C5CF5692788A73C09960B2")

static final int TRANSACTION_getGlobalSearchActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        private static class Proxy implements android.app.ISearchManager
        {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.429 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.432 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.435 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.437 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.440 -0500", hash_original_method = "EAD3F49B66EEAA021C67A273D2AB7E4A", hash_generated_method = "FFB72799741795FCB61D837430B99E5B")
            
public android.app.SearchableInfo getSearchableInfo(android.content.ComponentName launchActivity) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.app.SearchableInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((launchActivity!=null)) {
_data.writeInt(1);
launchActivity.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getSearchableInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.app.SearchableInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.443 -0500", hash_original_method = "868D6CF9DDCAE02A6BB3963E8B3F0BA3", hash_generated_method = "89837DD9D4A37217B607022B383C257B")
            
public java.util.List<android.app.SearchableInfo> getSearchablesInGlobalSearch() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.app.SearchableInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSearchablesInGlobalSearch, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.app.SearchableInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.446 -0500", hash_original_method = "B2BC7ABF4F4D4E838487A39402A346A2", hash_generated_method = "3A5851D410CD57618D4DC5B60A3C9642")
            
public java.util.List<android.content.pm.ResolveInfo> getGlobalSearchActivities() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.ResolveInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getGlobalSearchActivities, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.ResolveInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
            @DSModeled(DSC.BAN)
            public android.content.ComponentName getGlobalSearchActivity() throws android.os.RemoteException
            {
                android.content.ComponentName cn = new android.content.ComponentName("android.app", "SearchManager");
                return cn;
            }
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.452 -0500", hash_original_method = "3D16FAD592053EDC352B66C633AA75A8", hash_generated_method = "B601969D218ABB109E928ED68576B94B")
            
public android.content.ComponentName getWebSearchActivity() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ComponentName _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getWebSearchActivity, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.465 -0500", hash_original_field = "B997941C8A07B5CEDE56A0C948EEBFAC", hash_generated_field = "AA2E05566A25736A24819DDFB1C9DCBB")

static final int TRANSACTION_getGlobalSearchActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.468 -0500", hash_original_field = "1A1AC476EE734DFBF5AB37BE491BBB60", hash_generated_field = "ABD779FDF7AFC7703C55779E396AD3BD")

static final int TRANSACTION_getWebSearchActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.418 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.422 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.426 -0500", hash_original_method = "F83A7C3F8CE8E1FFA11C0B01CBB0101C", hash_generated_method = "BA48B0CA6A46F0B82381B7BCAD9068F8")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getSearchableInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.app.SearchableInfo _result = this.getSearchableInfo(_arg0);
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
case TRANSACTION_getSearchablesInGlobalSearch:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.app.SearchableInfo> _result = this.getSearchablesInGlobalSearch();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getGlobalSearchActivities:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.content.pm.ResolveInfo> _result = this.getGlobalSearchActivities();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getGlobalSearchActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _result = this.getGlobalSearchActivity();
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
case TRANSACTION_getWebSearchActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _result = this.getWebSearchActivity();
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
    public android.app.SearchableInfo getSearchableInfo(android.content.ComponentName launchActivity) throws android.os.RemoteException;
    public java.util.List<android.app.SearchableInfo> getSearchablesInGlobalSearch() throws android.os.RemoteException;
    public java.util.List<android.content.pm.ResolveInfo> getGlobalSearchActivities() throws android.os.RemoteException;
    public android.content.ComponentName getGlobalSearchActivity() throws android.os.RemoteException;
    public android.content.ComponentName getWebSearchActivity() throws android.os.RemoteException;
}
