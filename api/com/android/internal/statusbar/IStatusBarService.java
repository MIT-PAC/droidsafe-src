package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IStatusBarService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.statusbar.IStatusBarService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.023 -0500", hash_original_field = "58AC8A32536993F881DBE3CCBFD55913", hash_generated_field = "E915441CAF0164AED5EF5FD51DD1DC56")

private static final java.lang.String DESCRIPTOR = "com.android.internal.statusbar.IStatusBarService";
/**
 * Cast an IBinder object into an com.android.internal.statusbar.IStatusBarService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.027 -0500", hash_original_method = "0F8EF0BA633351B4C1E397ACA15CD1B5", hash_generated_method = "22DF6FB495C9A4B4DEFEA89673BE6BC9")
        
public static com.android.internal.statusbar.IStatusBarService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.statusbar.IStatusBarService))) {
return ((com.android.internal.statusbar.IStatusBarService)iin);
}
return new com.android.internal.statusbar.IStatusBarService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.141 -0500", hash_original_field = "8EF36F7D48A2454078180502CFBBD361", hash_generated_field = "B3B80540390E80F2767FB05EA20B110B")

static final int TRANSACTION_expand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.145 -0500", hash_original_field = "306C883FC98BFE5189F919D8DE909418", hash_generated_field = "7436B369090E5F7F2E25999749CBD0D2")

static final int TRANSACTION_collapse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.149 -0500", hash_original_field = "C2A3D7C5E8862D77E13F4D1417694CB0", hash_generated_field = "1F079E0809D320F5396DA45FCA502546")

static final int TRANSACTION_disable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.statusbar.IStatusBarService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.039 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.041 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.045 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.047 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.050 -0500", hash_original_method = "8D0B7707769FE1FAA40088E98844C3FC", hash_generated_method = "DCB3245A14CB4BD1FF00F05EDAFDA603")
            
public void expand() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_expand, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.052 -0500", hash_original_method = "691CCACE34514E750078BE31DFF18720", hash_generated_method = "704294FFDA8E4E8281547FFC063488C0")
            
public void collapse() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_collapse, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.055 -0500", hash_original_method = "8ED37278B7A0D5228542D2DD8FEBA08E", hash_generated_method = "E0917A25400114101758C1EAB55A6459")
            
public void disable(int what, android.os.IBinder token, java.lang.String pkg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(what);
_data.writeStrongBinder(token);
_data.writeString(pkg);
mRemote.transact(Stub.TRANSACTION_disable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.058 -0500", hash_original_method = "937995F5796B3C11A78B7AF356EF7290", hash_generated_method = "FFB36091BD404C471680CFFA76CE0946")
            
public void setIcon(java.lang.String slot, java.lang.String iconPackage, int iconId, int iconLevel, java.lang.String contentDescription) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(slot);
_data.writeString(iconPackage);
_data.writeInt(iconId);
_data.writeInt(iconLevel);
_data.writeString(contentDescription);
mRemote.transact(Stub.TRANSACTION_setIcon, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.060 -0500", hash_original_method = "0032DE418657CA01E68516222F27B481", hash_generated_method = "7687F4D8F266A1EECC54496707DBC2B0")
            
public void setIconVisibility(java.lang.String slot, boolean visible) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(slot);
_data.writeInt(((visible)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setIconVisibility, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.063 -0500", hash_original_method = "8D9051A0A3CF441FF5B436C2061D23C6", hash_generated_method = "3DE1444378C3F5A4C0568BE111E6908C")
            
public void removeIcon(java.lang.String slot) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(slot);
mRemote.transact(Stub.TRANSACTION_removeIcon, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.067 -0500", hash_original_method = "551B000507FCC04E949A374E26D3667E", hash_generated_method = "8649AA7E761CE6529E3B6ABD80A34C12")
            
public void topAppWindowChanged(boolean menuVisible) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((menuVisible)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_topAppWindowChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.070 -0500", hash_original_method = "C12A3C0E7EFDBE88F4327FF2D54C08E5", hash_generated_method = "9D339B167A36F4F9FCE460E4AF01D7A4")
            
public void setImeWindowStatus(android.os.IBinder token, int vis, int backDisposition) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(vis);
_data.writeInt(backDisposition);
mRemote.transact(Stub.TRANSACTION_setImeWindowStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// ---- Methods below are for use by the status bar policy services ----
// You need the STATUS_BAR_SERVICE permission

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.076 -0500", hash_original_method = "82D38241D96B0CAB9AF8A7F762296012", hash_generated_method = "2B633A53F9A677F6203AEDEC27AC71A9")
            
public void registerStatusBar(com.android.internal.statusbar.IStatusBar callbacks, com.android.internal.statusbar.StatusBarIconList iconList, java.util.List<android.os.IBinder> notificationKeys, java.util.List<com.android.internal.statusbar.StatusBarNotification> notifications, int[] switches, java.util.List<android.os.IBinder> binders) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callbacks!=null))?(callbacks.asBinder()):(null)));
if ((switches==null)) {
_data.writeInt(-1);
}
else {
_data.writeInt(switches.length);
}
mRemote.transact(Stub.TRANSACTION_registerStatusBar, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
iconList.readFromParcel(_reply);
}
_reply.readBinderList(notificationKeys);
_reply.readTypedList(notifications, com.android.internal.statusbar.StatusBarNotification.CREATOR);
_reply.readIntArray(switches);
_reply.readBinderList(binders);
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.080 -0500", hash_original_method = "83F4C5C1D63FE779012BAC39B451BBCB", hash_generated_method = "B47DFCC428FF7B8C5DFB7878CDC71548")
            
public void onPanelRevealed() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onPanelRevealed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.085 -0500", hash_original_method = "62B4E4A987D9D494BFC21A7A32CB53B9", hash_generated_method = "DF111FF72761C0402E5F2934717CE995")
            
public void onNotificationClick(java.lang.String pkg, java.lang.String tag, int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeString(tag);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_onNotificationClick, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.089 -0500", hash_original_method = "CA31317392C408C12DCDCF66A1936454", hash_generated_method = "3687B61A363ED27A9E7066A95C980F08")
            
public void onNotificationError(java.lang.String pkg, java.lang.String tag, int id, int uid, int initialPid, java.lang.String message) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeString(tag);
_data.writeInt(id);
_data.writeInt(uid);
_data.writeInt(initialPid);
_data.writeString(message);
mRemote.transact(Stub.TRANSACTION_onNotificationError, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.094 -0500", hash_original_method = "5843245C5991679F169D80E054824C43", hash_generated_method = "B814C3779066303DA86470F014A36E7F")
            
public void onClearAllNotifications() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onClearAllNotifications, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.099 -0500", hash_original_method = "A9684BC17428A03269A7A81105733BD5", hash_generated_method = "726314265ACFABAC01C5E107B177222E")
            
public void onNotificationClear(java.lang.String pkg, java.lang.String tag, int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeString(tag);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_onNotificationClear, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.103 -0500", hash_original_method = "8370F0324AF87A69E5D47B1C2C982121", hash_generated_method = "45C55A406B515C3CC959E410D57E4FE7")
            
public void setSystemUiVisibility(int vis) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(vis);
mRemote.transact(Stub.TRANSACTION_setSystemUiVisibility, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.108 -0500", hash_original_method = "6155018B2BA542AD2558CC7B25F44577", hash_generated_method = "273F78CB9D416FFB27AD4D52692EA930")
            
public void setHardKeyboardEnabled(boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setHardKeyboardEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.128 -0500", hash_original_method = "68BBC677CEC332C786C8F0E614AFEFB7", hash_generated_method = "7A5A7F4E92EEFA753442B4D0B0E0C278")
            
public void toggleRecentApps() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_toggleRecentApps, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.154 -0500", hash_original_field = "01D2376C111D26F48A413E7A8F7669F9", hash_generated_field = "CBC434B1E6EC7CA4BA331F08095D2B98")

static final int TRANSACTION_setIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.158 -0500", hash_original_field = "AE79C5952F5B20A334E4BD4AAA3323F0", hash_generated_field = "579390DD2916208E3518764D8C8BCCB1")

static final int TRANSACTION_setIconVisibility = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.162 -0500", hash_original_field = "7EED5B2EAAA7A35E717A2420B817B7BB", hash_generated_field = "FDA37F4FEC86D69AF90E259FD8346138")

static final int TRANSACTION_removeIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.167 -0500", hash_original_field = "C7ECC22080A990356FA988AFC7AE4272", hash_generated_field = "12FAF8037BB5FFCD66E63BCD02F59040")

static final int TRANSACTION_topAppWindowChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.171 -0500", hash_original_field = "728ADE2DD35D32C9A5D1B43C9BB56BB4", hash_generated_field = "8B5FE3B6D399E950CC32B3D8FF4B05D3")

static final int TRANSACTION_setImeWindowStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.175 -0500", hash_original_field = "B69B7A39E3E0F33FCF6638455CD7D14D", hash_generated_field = "819681050454B4C68E080D5DC9924F15")

static final int TRANSACTION_registerStatusBar = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.179 -0500", hash_original_field = "3E28D90B8DB7BE149020F9D55680EE3D", hash_generated_field = "850EB6C0DD0D2A3671069114BA906AAF")

static final int TRANSACTION_onPanelRevealed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.183 -0500", hash_original_field = "22DEBCB643409F977C716968E6F6D1DA", hash_generated_field = "476CE43CF47023A366F1E0E40CC3DD78")

static final int TRANSACTION_onNotificationClick = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.188 -0500", hash_original_field = "992C1612EB51DDA05C6A4A2F955CCB33", hash_generated_field = "72F329AD9CB6AB94562E430921115622")

static final int TRANSACTION_onNotificationError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.191 -0500", hash_original_field = "E274FFC73CCFDD10C72CAE3C192E8B92", hash_generated_field = "4CD652957960F92EBFDE7B6A510ADE61")

static final int TRANSACTION_onClearAllNotifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.195 -0500", hash_original_field = "BE65BD7DA2B8A544DB8B1A201428B64A", hash_generated_field = "344BBDFCC070F5EBF7C798003FF86D67")

static final int TRANSACTION_onNotificationClear = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.200 -0500", hash_original_field = "AE5A29AEEB43E6389516E50541075E81", hash_generated_field = "2DF1D89729B25BBCAB8DC3CC07E67445")

static final int TRANSACTION_setSystemUiVisibility = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.204 -0500", hash_original_field = "ADCBD57169FBA353F80C04DCABD7D429", hash_generated_field = "112240C19C297F3BFBFA2FE9B70CC9F6")

static final int TRANSACTION_setHardKeyboardEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.209 -0500", hash_original_field = "9B200B53F7028B99A5E27EDE2BF54033", hash_generated_field = "86B8B4EE8E9055310D67A02E3217D420")

static final int TRANSACTION_toggleRecentApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.025 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.029 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.035 -0500", hash_original_method = "75454714640D8F4D930F4DF5E6CD8BCD", hash_generated_method = "41C702CCFC93DA06329C3F7B39B937F2")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_expand:
{
data.enforceInterface(DESCRIPTOR);
this.expand();
reply.writeNoException();
return true;
}
case TRANSACTION_collapse:
{
data.enforceInterface(DESCRIPTOR);
this.collapse();
reply.writeNoException();
return true;
}
case TRANSACTION_disable:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
java.lang.String _arg2;
_arg2 = data.readString();
this.disable(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setIcon:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
java.lang.String _arg4;
_arg4 = data.readString();
this.setIcon(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_setIconVisibility:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setIconVisibility(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeIcon:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.removeIcon(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_topAppWindowChanged:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.topAppWindowChanged(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setImeWindowStatus:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.setImeWindowStatus(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_registerStatusBar:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.statusbar.IStatusBar _arg0;
_arg0 = com.android.internal.statusbar.IStatusBar.Stub.asInterface(data.readStrongBinder());
com.android.internal.statusbar.StatusBarIconList _arg1;
_arg1 = new com.android.internal.statusbar.StatusBarIconList();
java.util.List<android.os.IBinder> _arg2;
_arg2 = new java.util.ArrayList<android.os.IBinder>();
java.util.List<com.android.internal.statusbar.StatusBarNotification> _arg3;
_arg3 = new java.util.ArrayList<com.android.internal.statusbar.StatusBarNotification>();
int[] _arg4;
int _arg4_length = data.readInt();
if ((_arg4_length<0)) {
_arg4 = null;
}
else {
_arg4 = new int[_arg4_length];
}
java.util.List<android.os.IBinder> _arg5;
_arg5 = new java.util.ArrayList<android.os.IBinder>();
this.registerStatusBar(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
reply.writeBinderList(_arg2);
reply.writeTypedList(_arg3);
reply.writeIntArray(_arg4);
reply.writeBinderList(_arg5);
return true;
}
case TRANSACTION_onPanelRevealed:
{
data.enforceInterface(DESCRIPTOR);
this.onPanelRevealed();
reply.writeNoException();
return true;
}
case TRANSACTION_onNotificationClick:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.onNotificationClick(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onNotificationError:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
java.lang.String _arg5;
_arg5 = data.readString();
this.onNotificationError(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_onClearAllNotifications:
{
data.enforceInterface(DESCRIPTOR);
this.onClearAllNotifications();
reply.writeNoException();
return true;
}
case TRANSACTION_onNotificationClear:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.onNotificationClear(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setSystemUiVisibility:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setSystemUiVisibility(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setHardKeyboardEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setHardKeyboardEnabled(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_toggleRecentApps:
{
data.enforceInterface(DESCRIPTOR);
this.toggleRecentApps();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void expand() throws android.os.RemoteException;
public void collapse() throws android.os.RemoteException;
public void disable(int what, android.os.IBinder token, java.lang.String pkg) throws android.os.RemoteException;
public void setIcon(java.lang.String slot, java.lang.String iconPackage, int iconId, int iconLevel, java.lang.String contentDescription) throws android.os.RemoteException;
public void setIconVisibility(java.lang.String slot, boolean visible) throws android.os.RemoteException;
public void removeIcon(java.lang.String slot) throws android.os.RemoteException;
public void topAppWindowChanged(boolean menuVisible) throws android.os.RemoteException;
public void setImeWindowStatus(android.os.IBinder token, int vis, int backDisposition) throws android.os.RemoteException;



public void registerStatusBar(com.android.internal.statusbar.IStatusBar callbacks, com.android.internal.statusbar.StatusBarIconList iconList, java.util.List<android.os.IBinder> notificationKeys, java.util.List<com.android.internal.statusbar.StatusBarNotification> notifications, int[] switches, java.util.List<android.os.IBinder> binders) throws android.os.RemoteException;
public void onPanelRevealed() throws android.os.RemoteException;
public void onNotificationClick(java.lang.String pkg, java.lang.String tag, int id) throws android.os.RemoteException;
public void onNotificationError(java.lang.String pkg, java.lang.String tag, int id, int uid, int initialPid, java.lang.String message) throws android.os.RemoteException;
public void onClearAllNotifications() throws android.os.RemoteException;
public void onNotificationClear(java.lang.String pkg, java.lang.String tag, int id) throws android.os.RemoteException;
public void setSystemUiVisibility(int vis) throws android.os.RemoteException;
public void setHardKeyboardEnabled(boolean enabled) throws android.os.RemoteException;
public void toggleRecentApps() throws android.os.RemoteException;
}
