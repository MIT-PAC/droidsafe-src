package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IContentService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.IContentService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.745 -0500", hash_original_field = "B9B74321EE4A6873D2884AF535EE3FA9", hash_generated_field = "6082B51CE7BF50A684678B55BF69106E")

private static final java.lang.String DESCRIPTOR = "android.content.IContentService";
/**
 * Cast an IBinder object into an android.content.IContentService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.747 -0500", hash_original_method = "D128FBB2A54EF1AFF2DC66CE2DBE0AD0", hash_generated_method = "E10274D64469CF27EEFF86DB8ABD1E21")
        public static android.content.IContentService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.IContentService))) {
return ((android.content.IContentService)iin);
}
return new android.content.IContentService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.780 -0500", hash_original_field = "3A436059D33FD00C046417FD4FF37F07", hash_generated_field = "F75552E7F5EA4227B785169CB7757A2F")

static final int TRANSACTION_registerContentObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.781 -0500", hash_original_field = "C5B64AC1641C9C2A19E70D737EF03EAB", hash_generated_field = "F403D5A1A4905A7176E3098BDBEC6D8C")

static final int TRANSACTION_unregisterContentObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.782 -0500", hash_original_field = "A49013D03D085ABD8BB20FAB3E5B1231", hash_generated_field = "78A6055B16F723D4FB4E626370256744")

static final int TRANSACTION_notifyChange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.content.IContentService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.751 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.753 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.754 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.755 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.756 -0500", hash_original_method = "98F6D5FBA3C130B773B64BD71B716279", hash_generated_method = "BDB96BBD8CCC654127FE03A4570E35F9")
            public void registerContentObserver(android.net.Uri uri, boolean notifyForDescendentsn, android.database.IContentObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((uri!=null)) {
_data.writeInt(1);
uri.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((notifyForDescendentsn)?(1):(0)));
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerContentObserver, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.757 -0500", hash_original_method = "8DC676DACA9CE9596C9AE86151BCE018", hash_generated_method = "06826CF6ADA40BBE7E68F6DE21051FD8")
            public void unregisterContentObserver(android.database.IContentObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterContentObserver, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.758 -0500", hash_original_method = "0D0FB4CBC277590D4C18C2907F59991F", hash_generated_method = "2602D596C621B695E4D3B9714A070605")
            public void notifyChange(android.net.Uri uri, android.database.IContentObserver observer, boolean observerWantsSelfNotifications, boolean syncToNetwork) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((uri!=null)) {
_data.writeInt(1);
uri.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(((observerWantsSelfNotifications)?(1):(0)));
_data.writeInt(((syncToNetwork)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_notifyChange, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.759 -0500", hash_original_method = "6430296507E764D77D2E563CFF698B5C", hash_generated_method = "9156B2939405BC05B837EA1D8877A357")
            public void requestSync(android.accounts.Account account, java.lang.String authority, android.os.Bundle extras) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authority);
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_requestSync, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.760 -0500", hash_original_method = "72E9AB86DA161E1C51BCD9EB57CA0025", hash_generated_method = "2A5ED4C4F9DB760B550ECEA6363B2C5D")
            public void cancelSync(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authority);
mRemote.transact(Stub.TRANSACTION_cancelSync, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Check if the provider should be synced when a network tickle is received
     * @param providerName the provider whose setting we are querying
     * @return true if the provider should be synced when a network tickle is received
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.761 -0500", hash_original_method = "F0C8A9E30E3EFA370B71D9A762B582B2", hash_generated_method = "06FE476704AD454BAE87C09A88EAF415")
            public boolean getSyncAutomatically(android.accounts.Account account, java.lang.String providerName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(providerName);
mRemote.transact(Stub.TRANSACTION_getSyncAutomatically, _data, _reply, 0);
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
     * Set whether or not the provider is synced when it receives a network tickle.
     *
     * @param providerName the provider whose behavior is being controlled
     * @param sync true if the provider should be synced when tickles are received for it
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.762 -0500", hash_original_method = "40EB513C6C3E4C7153CB9920D108E680", hash_generated_method = "B56B959E29BABCC158BA393FD16C717C")
            public void setSyncAutomatically(android.accounts.Account account, java.lang.String providerName, boolean sync) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(providerName);
_data.writeInt(((sync)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setSyncAutomatically, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Get the frequency of the periodic poll, if any.
     * @param providerName the provider whose setting we are querying
     * @return the frequency of the periodic sync in seconds. If 0 then no periodic syncs
     * will take place.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.763 -0500", hash_original_method = "2C105B192D3709B9CAEE82874F186131", hash_generated_method = "FF7283CE430821F809359DA2CDB7B05B")
            public java.util.List<android.content.PeriodicSync> getPeriodicSyncs(android.accounts.Account account, java.lang.String providerName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.PeriodicSync> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(providerName);
mRemote.transact(Stub.TRANSACTION_getPeriodicSyncs, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.PeriodicSync.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Set whether or not the provider is to be synced on a periodic basis.
     *
     * @param providerName the provider whose behavior is being controlled
     * @param pollFrequency the period that a sync should be performed, in seconds. If this is
     * zero or less then no periodic syncs will be performed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.764 -0500", hash_original_method = "E9A18E1F0577FCBFAE0692012B484C3D", hash_generated_method = "C3C6E065B0B238D85D7EE1C2FCC2C3B6")
            public void addPeriodicSync(android.accounts.Account account, java.lang.String providerName, android.os.Bundle extras, long pollFrequency) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(providerName);
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(pollFrequency);
mRemote.transact(Stub.TRANSACTION_addPeriodicSync, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set whether or not the provider is to be synced on a periodic basis.
     *
     * @param providerName the provider whose behavior is being controlled
     * @param pollFrequency the period that a sync should be performed, in seconds. If this is
     * zero or less then no periodic syncs will be performed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.766 -0500", hash_original_method = "13C1F487E436DF26C4257523404A7638", hash_generated_method = "A4C91A8FC7D1B3AB43FE8649838210CD")
            public void removePeriodicSync(android.accounts.Account account, java.lang.String providerName, android.os.Bundle extras) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(providerName);
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removePeriodicSync, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Check if this account/provider is syncable.
     * @return >0 if it is syncable, 0 if not, and <0 if the state isn't known yet.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.767 -0500", hash_original_method = "C3E1300E3F395193B957E95D414A4830", hash_generated_method = "943CB9AFC242B5679B47FE07FF245956")
            public int getIsSyncable(android.accounts.Account account, java.lang.String providerName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(providerName);
mRemote.transact(Stub.TRANSACTION_getIsSyncable, _data, _reply, 0);
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
     * Set whether this account/provider is syncable.
     * @param syncable, >0 denotes syncable, 0 means not syncable, <0 means unknown
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.768 -0500", hash_original_method = "E4AA6A917F485664D036CCBAC48A3FD2", hash_generated_method = "11DEA7DCFC5176DB8B8E1337CBDE8B96")
            public void setIsSyncable(android.accounts.Account account, java.lang.String providerName, int syncable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(providerName);
_data.writeInt(syncable);
mRemote.transact(Stub.TRANSACTION_setIsSyncable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.769 -0500", hash_original_method = "2C327CA33D135EC03E87F915E44307FB", hash_generated_method = "37A335B25AFECC947D77C66E1D09E7F1")
            public void setMasterSyncAutomatically(boolean flag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((flag)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setMasterSyncAutomatically, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.770 -0500", hash_original_method = "6B4376F5B789CBEBF89033DCFFA4913A", hash_generated_method = "414223486F882292D645E601A869E277")
            public boolean getMasterSyncAutomatically() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMasterSyncAutomatically, _data, _reply, 0);
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
     * Returns true if there is currently a sync operation for the given
     * account or authority in the pending list, or actively being processed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.771 -0500", hash_original_method = "3F2909A0567738465BBE3C87AE567009", hash_generated_method = "2A28780E0F9DA863704BE4DA425D6377")
            public boolean isSyncActive(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authority);
mRemote.transact(Stub.TRANSACTION_isSyncActive, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.772 -0500", hash_original_method = "EB7C6ADACD5DA97C34AEA66F1B0F503F", hash_generated_method = "1DD9501E56F291E232D61DE1F875410E")
            public java.util.List<android.content.SyncInfo> getCurrentSyncs() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.SyncInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentSyncs, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.SyncInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Returns the types of the SyncAdapters that are registered with the system.
     * @return Returns the types of the SyncAdapters that are registered with the system.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.773 -0500", hash_original_method = "669780B96A1C2E39C10A25A6031BE642", hash_generated_method = "1FB2D8C44D3239C9A4E6D03BF8A43C05")
            public android.content.SyncAdapterType[] getSyncAdapterTypes() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.SyncAdapterType[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSyncAdapterTypes, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.content.SyncAdapterType.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Returns the status that matches the authority. If there are multiples accounts for
     * the authority, the one with the latest "lastSuccessTime" status is returned.
     * @param authority the authority whose row should be selected
     * @return the SyncStatusInfo for the authority, or null if none exists
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.774 -0500", hash_original_method = "71F08B4B9B3705E4B2E23B818EAA58F1", hash_generated_method = "F09E51A590A2CFA2F0CFF9C0734F0F94")
            public android.content.SyncStatusInfo getSyncStatus(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.SyncStatusInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authority);
mRemote.transact(Stub.TRANSACTION_getSyncStatus, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.SyncStatusInfo.CREATOR.createFromParcel(_reply);
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
     * Return true if the pending status is true of any matching authorities.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.775 -0500", hash_original_method = "1BBCB05C24161C7D0B4312E4968244D3", hash_generated_method = "6F29C1C365EBDD510DAF613E5A7131D5")
            public boolean isSyncPending(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authority);
mRemote.transact(Stub.TRANSACTION_isSyncPending, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.776 -0500", hash_original_method = "A263BCF2D258B542ED2FE1A0A4167606", hash_generated_method = "5E4DDFCFA4E77F92F308C5DFAA85CCAE")
            public void addStatusChangeListener(int mask, android.content.ISyncStatusObserver callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mask);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addStatusChangeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.777 -0500", hash_original_method = "13147157B90DF206295129A0D8922AD4", hash_generated_method = "EE589709989AB1AEC256831CB4B8594E")
            public void removeStatusChangeListener(android.content.ISyncStatusObserver callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeStatusChangeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.782 -0500", hash_original_field = "D74D875C9189BCC3EBF36C9758D8A6B1", hash_generated_field = "24980E0E0E07B3DA7EB6111FD8A35A07")

static final int TRANSACTION_requestSync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.783 -0500", hash_original_field = "46A889DC647AC0779966361B1F2E5595", hash_generated_field = "253F2392D37A9D2B884A67EF649617F0")

static final int TRANSACTION_cancelSync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.784 -0500", hash_original_field = "DD3D431908BA8FC9483F855C15BB7C70", hash_generated_field = "B185F6870F34707C5D7704F91EC7D4B1")

static final int TRANSACTION_getSyncAutomatically = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.785 -0500", hash_original_field = "6098C2592487A7C0936D7B7171BC6E26", hash_generated_field = "EC83D7F1F398DDB771B71010ADE70EDE")

static final int TRANSACTION_setSyncAutomatically = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.786 -0500", hash_original_field = "E0CDEBEFAA9946D2A61EFB51961BA520", hash_generated_field = "FE6C2367E8874F38C94D8C93714C7784")

static final int TRANSACTION_getPeriodicSyncs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.787 -0500", hash_original_field = "478BE010DDF9CF11C4E46B8E7A4FCAD8", hash_generated_field = "9DBD270528E379F157E2A8DFA09066D1")

static final int TRANSACTION_addPeriodicSync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.787 -0500", hash_original_field = "0A70873DD49D089EC869C00B96F29A20", hash_generated_field = "C442385602905ADF37422094CE3680D8")

static final int TRANSACTION_removePeriodicSync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.788 -0500", hash_original_field = "E367C3D47059B0F990328C620E2B23AB", hash_generated_field = "685B81582205C89D7E9EAC158C2C3E79")

static final int TRANSACTION_getIsSyncable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.789 -0500", hash_original_field = "8B84183E014D96C13F2D89BD546AE5AF", hash_generated_field = "738CFCC34676634AC8E4596549403493")

static final int TRANSACTION_setIsSyncable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.791 -0500", hash_original_field = "9C24AAE51C5BF54ED936F8747F15B3EE", hash_generated_field = "58D5BF6F20B73F9F9D304CE57CB95452")

static final int TRANSACTION_setMasterSyncAutomatically = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.792 -0500", hash_original_field = "EDDE872C957D5044E8EE4B3E44525686", hash_generated_field = "622BB18E3FAFFC8361299AB1015A72B9")

static final int TRANSACTION_getMasterSyncAutomatically = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.793 -0500", hash_original_field = "FBB1E2FB7CC4BCBAC532989702D15DF4", hash_generated_field = "1D0E14D446C067A206CAD8DCA9663830")

static final int TRANSACTION_isSyncActive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.793 -0500", hash_original_field = "C4EBE19A9731CD85B3A2E41930929E17", hash_generated_field = "92E679E422D43DD6B970A79630F697A4")

static final int TRANSACTION_getCurrentSyncs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.794 -0500", hash_original_field = "A55A6886CBFBB435382D92B63B3C29E1", hash_generated_field = "525995710FC9D6DF0F6806810FEA0A4C")

static final int TRANSACTION_getSyncAdapterTypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.795 -0500", hash_original_field = "FA35FC56E90E90CC2EE0055BEE65D8AE", hash_generated_field = "AE7BD11107BDC04EDF7D36D80E5D424F")

static final int TRANSACTION_getSyncStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.796 -0500", hash_original_field = "3D1045779A6A281E15194D3162D939C8", hash_generated_field = "18573B55E87AE6B5113057690670E463")

static final int TRANSACTION_isSyncPending = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.797 -0500", hash_original_field = "C7A985B2253F9ED0F12BBAB562064865", hash_generated_field = "E0FB12CF04F2A6F04BC9E1D633E6F171")

static final int TRANSACTION_addStatusChangeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.797 -0500", hash_original_field = "A4338566E5F09DD7CB8190E6AB269398", hash_generated_field = "B7457580A934FF0425A61E181676B20F")

static final int TRANSACTION_removeStatusChangeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.746 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.748 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:57.750 -0500", hash_original_method = "AF8242BA2D3F5AE27AC96AA7DD24E2F8", hash_generated_method = "99504247053E454E46E70514FDE62F32")
        @Override
public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_registerContentObserver:
{
data.enforceInterface(DESCRIPTOR);
android.net.Uri _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.Uri.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
android.database.IContentObserver _arg2;
_arg2 = android.database.IContentObserver.Stub.asInterface(data.readStrongBinder());
this.registerContentObserver(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterContentObserver:
{
data.enforceInterface(DESCRIPTOR);
android.database.IContentObserver _arg0;
_arg0 = android.database.IContentObserver.Stub.asInterface(data.readStrongBinder());
this.unregisterContentObserver(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyChange:
{
data.enforceInterface(DESCRIPTOR);
android.net.Uri _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.Uri.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.database.IContentObserver _arg1;
_arg1 = android.database.IContentObserver.Stub.asInterface(data.readStrongBinder());
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
this.notifyChange(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_requestSync:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.requestSync(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_cancelSync:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
this.cancelSync(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getSyncAutomatically:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.getSyncAutomatically(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setSyncAutomatically:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.setSyncAutomatically(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getPeriodicSyncs:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.util.List<android.content.PeriodicSync> _result = this.getPeriodicSyncs(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_addPeriodicSync:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
long _arg3;
_arg3 = data.readLong();
this.addPeriodicSync(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_removePeriodicSync:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.removePeriodicSync(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getIsSyncable:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.getIsSyncable(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setIsSyncable:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.setIsSyncable(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setMasterSyncAutomatically:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setMasterSyncAutomatically(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getMasterSyncAutomatically:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getMasterSyncAutomatically();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isSyncActive:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.isSyncActive(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getCurrentSyncs:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.content.SyncInfo> _result = this.getCurrentSyncs();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getSyncAdapterTypes:
{
data.enforceInterface(DESCRIPTOR);
android.content.SyncAdapterType[] _result = this.getSyncAdapterTypes();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_getSyncStatus:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
android.content.SyncStatusInfo _result = this.getSyncStatus(_arg0, _arg1);
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
case TRANSACTION_isSyncPending:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.isSyncPending(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_addStatusChangeListener:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.content.ISyncStatusObserver _arg1;
_arg1 = android.content.ISyncStatusObserver.Stub.asInterface(data.readStrongBinder());
this.addStatusChangeListener(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeStatusChangeListener:
{
data.enforceInterface(DESCRIPTOR);
android.content.ISyncStatusObserver _arg0;
_arg0 = android.content.ISyncStatusObserver.Stub.asInterface(data.readStrongBinder());
this.removeStatusChangeListener(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void registerContentObserver(android.net.Uri uri, boolean notifyForDescendentsn, android.database.IContentObserver observer) throws android.os.RemoteException;
public void unregisterContentObserver(android.database.IContentObserver observer) throws android.os.RemoteException;
public void notifyChange(android.net.Uri uri, android.database.IContentObserver observer, boolean observerWantsSelfNotifications, boolean syncToNetwork) throws android.os.RemoteException;
public void requestSync(android.accounts.Account account, java.lang.String authority, android.os.Bundle extras) throws android.os.RemoteException;
public void cancelSync(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException;

public boolean getSyncAutomatically(android.accounts.Account account, java.lang.String providerName) throws android.os.RemoteException;

public void setSyncAutomatically(android.accounts.Account account, java.lang.String providerName, boolean sync) throws android.os.RemoteException;

public java.util.List<android.content.PeriodicSync> getPeriodicSyncs(android.accounts.Account account, java.lang.String providerName) throws android.os.RemoteException;

public void addPeriodicSync(android.accounts.Account account, java.lang.String providerName, android.os.Bundle extras, long pollFrequency) throws android.os.RemoteException;

public void removePeriodicSync(android.accounts.Account account, java.lang.String providerName, android.os.Bundle extras) throws android.os.RemoteException;

public int getIsSyncable(android.accounts.Account account, java.lang.String providerName) throws android.os.RemoteException;

public void setIsSyncable(android.accounts.Account account, java.lang.String providerName, int syncable) throws android.os.RemoteException;
public void setMasterSyncAutomatically(boolean flag) throws android.os.RemoteException;
public boolean getMasterSyncAutomatically() throws android.os.RemoteException;

public boolean isSyncActive(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException;
public java.util.List<android.content.SyncInfo> getCurrentSyncs() throws android.os.RemoteException;

public android.content.SyncAdapterType[] getSyncAdapterTypes() throws android.os.RemoteException;

public android.content.SyncStatusInfo getSyncStatus(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException;

public boolean isSyncPending(android.accounts.Account account, java.lang.String authority) throws android.os.RemoteException;
public void addStatusChangeListener(int mask, android.content.ISyncStatusObserver callback) throws android.os.RemoteException;
public void removeStatusChangeListener(android.content.ISyncStatusObserver callback) throws android.os.RemoteException;
}
