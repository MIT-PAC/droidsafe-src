package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IStatusBar extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.statusbar.IStatusBar
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.984 -0500", hash_original_field = "62C47C3DAAAFA0DADEBB67596138B6B3", hash_generated_field = "A0C325FCE215EA59BAE0A73A0703C032")

private static final java.lang.String DESCRIPTOR = "com.android.internal.statusbar.IStatusBar";
/**
 * Cast an IBinder object into an com.android.internal.statusbar.IStatusBar interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.989 -0500", hash_original_method = "5AEBF5E362855C251E5B395F643A9E2C", hash_generated_method = "F30CC950422DC043A4DAC3FA2CB45C8C")
        
public static com.android.internal.statusbar.IStatusBar asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.statusbar.IStatusBar))) {
return ((com.android.internal.statusbar.IStatusBar)iin);
}
return new com.android.internal.statusbar.IStatusBar.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.047 -0500", hash_original_field = "16BBA2F716F9BF6554FF6A8BDCD5088A", hash_generated_field = "5794CF961FC2AEC9E22754D37034B76E")

static final int TRANSACTION_setIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.050 -0500", hash_original_field = "364711CE4707F91D0B435873D04189F2", hash_generated_field = "37611D07420619B9FE5EF10CFF27436B")

static final int TRANSACTION_removeIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.052 -0500", hash_original_field = "28A5CB2BCDF3A55F979D7EA578FE09DE", hash_generated_field = "597519358B109477A4621B236C48B740")

static final int TRANSACTION_addNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.statusbar.IStatusBar
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.999 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.002 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.004 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.007 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.009 -0500", hash_original_method = "B4BCC3F7E76F55EC817E2AE2186167B3", hash_generated_method = "FF2D40B56F30281480E115735DA1EEC4")
            
public void setIcon(int index, com.android.internal.statusbar.StatusBarIcon icon) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
if ((icon!=null)) {
_data.writeInt(1);
icon.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setIcon, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.012 -0500", hash_original_method = "AFC9F2D85E244CC584C3B222D50E711B", hash_generated_method = "989960112D53A58EC75462BD75E37AFA")
            
public void removeIcon(int index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
mRemote.transact(Stub.TRANSACTION_removeIcon, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.015 -0500", hash_original_method = "7369BD7BBFBCC50A18B7720E89EDFF76", hash_generated_method = "AF131A612E1EBE329F99995FB6C6E3A5")
            
public void addNotification(android.os.IBinder key, com.android.internal.statusbar.StatusBarNotification notification) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(key);
if ((notification!=null)) {
_data.writeInt(1);
notification.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addNotification, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.017 -0500", hash_original_method = "973004AC37A497E4ED157A0C682B0B45", hash_generated_method = "DF2125A0B69A03EF14C370C9264E0C11")
            
public void updateNotification(android.os.IBinder key, com.android.internal.statusbar.StatusBarNotification notification) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(key);
if ((notification!=null)) {
_data.writeInt(1);
notification.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateNotification, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.020 -0500", hash_original_method = "619026D0F5B28063A3AC080905D9E7A3", hash_generated_method = "D1B8FAA70306B400993478B043A223D5")
            
public void removeNotification(android.os.IBinder key) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(key);
mRemote.transact(Stub.TRANSACTION_removeNotification, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.022 -0500", hash_original_method = "F231306D662FDD9E12FF73FE30E9D6DE", hash_generated_method = "BCF0CE8246889357FF65D1B7CC1A80DD")
            
public void disable(int state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(state);
mRemote.transact(Stub.TRANSACTION_disable, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.025 -0500", hash_original_method = "A3D50800EEE57EA238EBEB52E833268E", hash_generated_method = "7340FA2635285578DB72EE7C1FF19F0D")
            
public void animateExpand() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_animateExpand, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.028 -0500", hash_original_method = "02342EFA07C09DBB9ABF4D22DEE3B780", hash_generated_method = "3037544F431E4CB9A7448B15B6E047EE")
            
public void animateCollapse() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_animateCollapse, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.031 -0500", hash_original_method = "BB83542AB626B23784684B733CFCDED2", hash_generated_method = "FE20DD93A1C8334154B618161C9BD041")
            
public void setSystemUiVisibility(int vis) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(vis);
mRemote.transact(Stub.TRANSACTION_setSystemUiVisibility, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.034 -0500", hash_original_method = "889EDB0CF8A5BB21AC7972EB3E00E079", hash_generated_method = "5A77B20C5310208F925135C35865DA74")
            
public void topAppWindowChanged(boolean menuVisible) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((menuVisible)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_topAppWindowChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.036 -0500", hash_original_method = "4F4708ED66E0166C018C6AD96B485D94", hash_generated_method = "14EF219DAA20B008EB1BDF43A4B3C94F")
            
public void setImeWindowStatus(android.os.IBinder token, int vis, int backDisposition) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(vis);
_data.writeInt(backDisposition);
mRemote.transact(Stub.TRANSACTION_setImeWindowStatus, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.039 -0500", hash_original_method = "94C5BD4CBCB3B6B5B2F3618C3DBF1EE5", hash_generated_method = "4FBF898C28092F3DB136B1DE5B491A59")
            
public void setHardKeyboardStatus(boolean available, boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((available)?(1):(0)));
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setHardKeyboardStatus, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.042 -0500", hash_original_method = "A180AC85247B5922A5E01713C577726E", hash_generated_method = "4F75D2ABEAFF583BE8974E72EABC5D4C")
            
public void toggleRecentApps() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_toggleRecentApps, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.055 -0500", hash_original_field = "0F683AEEAFA9CFB604CC70D9B7223524", hash_generated_field = "15B93AB2396C14C9ACB57CB0F4C1D68C")

static final int TRANSACTION_updateNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.057 -0500", hash_original_field = "B848E258641EB5A261C9A3FD2B95A7E4", hash_generated_field = "6A5A7565D9E8DDA04E43594FACFB85F2")

static final int TRANSACTION_removeNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.060 -0500", hash_original_field = "B297677CE2D859DA435AD9A1E075FE78", hash_generated_field = "0DDB2405D28891F354B03F551D9BF74B")

static final int TRANSACTION_disable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.062 -0500", hash_original_field = "44790896D885D84C0C40DA041F272904", hash_generated_field = "8D458F5E81317FD5AA244306A5A92E03")

static final int TRANSACTION_animateExpand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.064 -0500", hash_original_field = "075FDAAB16CEFF860575EF4357DB397A", hash_generated_field = "C3CA6F0BAEA4AAFA5E3159B720AABDA3")

static final int TRANSACTION_animateCollapse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.067 -0500", hash_original_field = "2766A485FBACD8319C2BCE4E463E8BB6", hash_generated_field = "722B1591FEAA9263953EC6A05F732C1D")

static final int TRANSACTION_setSystemUiVisibility = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.069 -0500", hash_original_field = "B4840AA87F07150FEF1DCDE8004657F8", hash_generated_field = "AEA828BE5795CA4D14D8E375E3314E40")

static final int TRANSACTION_topAppWindowChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.072 -0500", hash_original_field = "906A32FFB80D1B7832E9279C646501FA", hash_generated_field = "6D3E7982B0B270A2A853C07EB81ABC49")

static final int TRANSACTION_setImeWindowStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.075 -0500", hash_original_field = "94EB83CB1217EA579464335ADFD61B30", hash_generated_field = "0538E0139DE9E10005C742103026127C")

static final int TRANSACTION_setHardKeyboardStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.078 -0500", hash_original_field = "B6964FB40C4764E07DD48713DFB99C45", hash_generated_field = "5DC9FA71E32F5A3F055EEFEBC81611D9")

static final int TRANSACTION_toggleRecentApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.986 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.991 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.995 -0500", hash_original_method = "DCABE9BD3E641080DC0F0407EE7CA6A1", hash_generated_method = "5C238B84F58BF9162168D303D6CC9B4F")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setIcon:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.android.internal.statusbar.StatusBarIcon _arg1;
if ((0!=data.readInt())) {
_arg1 = com.android.internal.statusbar.StatusBarIcon.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.setIcon(_arg0, _arg1);
return true;
}
case TRANSACTION_removeIcon:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.removeIcon(_arg0);
return true;
}
case TRANSACTION_addNotification:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
com.android.internal.statusbar.StatusBarNotification _arg1;
if ((0!=data.readInt())) {
_arg1 = com.android.internal.statusbar.StatusBarNotification.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.addNotification(_arg0, _arg1);
return true;
}
case TRANSACTION_updateNotification:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
com.android.internal.statusbar.StatusBarNotification _arg1;
if ((0!=data.readInt())) {
_arg1 = com.android.internal.statusbar.StatusBarNotification.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.updateNotification(_arg0, _arg1);
return true;
}
case TRANSACTION_removeNotification:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.removeNotification(_arg0);
return true;
}
case TRANSACTION_disable:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.disable(_arg0);
return true;
}
case TRANSACTION_animateExpand:
{
data.enforceInterface(DESCRIPTOR);
this.animateExpand();
return true;
}
case TRANSACTION_animateCollapse:
{
data.enforceInterface(DESCRIPTOR);
this.animateCollapse();
return true;
}
case TRANSACTION_setSystemUiVisibility:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setSystemUiVisibility(_arg0);
return true;
}
case TRANSACTION_topAppWindowChanged:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.topAppWindowChanged(_arg0);
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
return true;
}
case TRANSACTION_setHardKeyboardStatus:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setHardKeyboardStatus(_arg0, _arg1);
return true;
}
case TRANSACTION_toggleRecentApps:
{
data.enforceInterface(DESCRIPTOR);
this.toggleRecentApps();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void setIcon(int index, com.android.internal.statusbar.StatusBarIcon icon) throws android.os.RemoteException;
public void removeIcon(int index) throws android.os.RemoteException;
public void addNotification(android.os.IBinder key, com.android.internal.statusbar.StatusBarNotification notification) throws android.os.RemoteException;
public void updateNotification(android.os.IBinder key, com.android.internal.statusbar.StatusBarNotification notification) throws android.os.RemoteException;
public void removeNotification(android.os.IBinder key) throws android.os.RemoteException;
public void disable(int state) throws android.os.RemoteException;
public void animateExpand() throws android.os.RemoteException;
public void animateCollapse() throws android.os.RemoteException;
public void setSystemUiVisibility(int vis) throws android.os.RemoteException;
public void topAppWindowChanged(boolean menuVisible) throws android.os.RemoteException;
public void setImeWindowStatus(android.os.IBinder token, int vis, int backDisposition) throws android.os.RemoteException;
public void setHardKeyboardStatus(boolean available, boolean enabled) throws android.os.RemoteException;
public void toggleRecentApps() throws android.os.RemoteException;
}
