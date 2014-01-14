package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IPackageManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.pm.IPackageManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.916 -0500", hash_original_field = "6B603E3B5BF249E3465071D35A63CA56", hash_generated_field = "DA2F7599D5F617C5E7BCCFFBD8ED5DD0")

private static final java.lang.String DESCRIPTOR = "android.content.pm.IPackageManager";
/**
 * Cast an IBinder object into an android.content.pm.IPackageManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.922 -0500", hash_original_method = "9EF37178A95C372A5D23A88C2D60A8BE", hash_generated_method = "7FA08E72092520BEB6D62B0C562E7CC9")
        
public static android.content.pm.IPackageManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.pm.IPackageManager))) {
return ((android.content.pm.IPackageManager)iin);
}
return new android.content.pm.IPackageManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.211 -0500", hash_original_field = "5631622C8BDE3B622538D92EE6AE42C2", hash_generated_field = "0449118CD64DC12C5CABF681CD8CC980")

static final int TRANSACTION_getPackageInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.213 -0500", hash_original_field = "46A4024B7BB741413B33B7A57C151A2E", hash_generated_field = "F1C507D1B83462B588897A6CC3C40332")

static final int TRANSACTION_getPackageUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.215 -0500", hash_original_field = "37E179C092E05F2C9CA6D99A23DB3F37", hash_generated_field = "4AE09EC6C06867076D5A25933A4AC8E1")

static final int TRANSACTION_getPackageGids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.content.pm.IPackageManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.948 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.951 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.953 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.955 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.958 -0500", hash_original_method = "B8B0EEFE145CAFEA43E188F6E276C92F", hash_generated_method = "885907E7503819CBEC98D325FF6EF32B")
            
public android.content.pm.PackageInfo getPackageInfo(java.lang.String packageName, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.PackageInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getPackageInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.PackageInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.960 -0500", hash_original_method = "FF0260E6A341318D8BF19BDDD6AB0883", hash_generated_method = "1DB7620E025C83051D2685DF0AE3FC38")
            
public int getPackageUid(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getPackageUid, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.963 -0500", hash_original_method = "32EA0EAE836CC9529DE9DA450AA96C63", hash_generated_method = "A3EEAAABDDC14E64E3F6EED078D0B53A")
            
public int[] getPackageGids(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getPackageGids, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.966 -0500", hash_original_method = "01CC4D9AC63BA9A36B2EC1E5D0B4F6F3", hash_generated_method = "B09A1E2A1DA97135DA580B8793166412")
            
public java.lang.String[] currentToCanonicalPackageNames(java.lang.String[] names) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(names);
mRemote.transact(Stub.TRANSACTION_currentToCanonicalPackageNames, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.969 -0500", hash_original_method = "CED6A60F1084551B003E4E7993339C1A", hash_generated_method = "37969836495383F19DDCBDB25323965E")
            
public java.lang.String[] canonicalToCurrentPackageNames(java.lang.String[] names) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(names);
mRemote.transact(Stub.TRANSACTION_canonicalToCurrentPackageNames, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.972 -0500", hash_original_method = "BF1E1CE03EF7F51C5BFCD403B774F17E", hash_generated_method = "EB7C6259E6AD8BCFDF523BEF7243A8A4")
            
public android.content.pm.PermissionInfo getPermissionInfo(java.lang.String name, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.PermissionInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getPermissionInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.PermissionInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.975 -0500", hash_original_method = "8CD21A48D4C2CFE43EBEF9B72BE15C21", hash_generated_method = "F50250F823CE3BB7CD04F03F2442C6FE")
            
public java.util.List<android.content.pm.PermissionInfo> queryPermissionsByGroup(java.lang.String group, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.PermissionInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(group);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryPermissionsByGroup, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.PermissionInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.978 -0500", hash_original_method = "02E19EE3F6BDCD36E8AD077D742AC94F", hash_generated_method = "D577F8BDD457F1A050FFDF121C8439C3")
            
public android.content.pm.PermissionGroupInfo getPermissionGroupInfo(java.lang.String name, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.PermissionGroupInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getPermissionGroupInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.PermissionGroupInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.980 -0500", hash_original_method = "289B61F0B5F75BD2418D76EB8FAAD5EA", hash_generated_method = "BD04A003627E2032E3478EA0E7825DF1")
            
public java.util.List<android.content.pm.PermissionGroupInfo> getAllPermissionGroups(int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.PermissionGroupInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getAllPermissionGroups, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.PermissionGroupInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.983 -0500", hash_original_method = "2398D13CB28BEE0EB800F4FBD1DE7A78", hash_generated_method = "C6414F36E5DFAD39E898A94F4F76AE82")
            
public android.content.pm.ApplicationInfo getApplicationInfo(java.lang.String packageName, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ApplicationInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getApplicationInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ApplicationInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.986 -0500", hash_original_method = "6396C9F5C2E551F82EF1C1185BD5888B", hash_generated_method = "6634EE231746F885511298B8D25EDD2E")
            
public android.content.pm.ActivityInfo getActivityInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ActivityInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getActivityInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ActivityInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.989 -0500", hash_original_method = "E1E29B2EEE73DD3843284F28D53C9D22", hash_generated_method = "BF135F61473098C667A8C81130D277ED")
            
public android.content.pm.ActivityInfo getReceiverInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ActivityInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getReceiverInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ActivityInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.992 -0500", hash_original_method = "5F0D628CA033555B468988832F639A59", hash_generated_method = "5B38507A1686D2A28620722DC78210A6")
            
public android.content.pm.ServiceInfo getServiceInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ServiceInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getServiceInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ServiceInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.995 -0500", hash_original_method = "921AEAAE6F3A37AFBEFBDA396276FFBF", hash_generated_method = "694DD9AE3B4BF7DE193F73D7D68BA64D")
            
public android.content.pm.ProviderInfo getProviderInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ProviderInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getProviderInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ProviderInfo.CREATOR.createFromParcel(_reply);
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
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.997 -0500", hash_original_method = "22D8F598C36D5FE5111EAB14655B4427", hash_generated_method = "9138DF14242181439C7CE2666ACD374C")
            
public int checkPermission(java.lang.String permName, java.lang.String pkgName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permName);
_data.writeString(pkgName);
mRemote.transact(Stub.TRANSACTION_checkPermission, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.001 -0500", hash_original_method = "699BFFCCBB9F06DC9DB411033B1D731D", hash_generated_method = "B93A008F51C60927006CA8604AAC7156")
            
public int checkUidPermission(java.lang.String permName, int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permName);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_checkUidPermission, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.004 -0500", hash_original_method = "6020569631D287A3EFEB520654075B30", hash_generated_method = "0076D7B26DB3D0244227E22825239EF6")
            
public boolean addPermission(android.content.pm.PermissionInfo info) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPermission, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.006 -0500", hash_original_method = "CB5F747025027D2E5251365099A5BC49", hash_generated_method = "8AE5EDDCFC66B4C495F8B7F753709C4D")
            
public void removePermission(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_removePermission, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.009 -0500", hash_original_method = "7E39ECAD55BE3263D31FEFAFF281E16A", hash_generated_method = "B3327B74CA88D4FA61EAFC8E3A4BAE5C")
            
public boolean isProtectedBroadcast(java.lang.String actionName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(actionName);
mRemote.transact(Stub.TRANSACTION_isProtectedBroadcast, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.012 -0500", hash_original_method = "B9D98AF50C5ECF4C984B7AB9A1A72293", hash_generated_method = "6D4BA8CC7E98B1BC123C2F93C29E569E")
            
public int checkSignatures(java.lang.String pkg1, java.lang.String pkg2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg1);
_data.writeString(pkg2);
mRemote.transact(Stub.TRANSACTION_checkSignatures, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.014 -0500", hash_original_method = "8B921ADB812F83DA38D44E4F3BE81409", hash_generated_method = "E4C591308849C0DE6B9D4706D22B85E6")
            
public int checkUidSignatures(int uid1, int uid2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid1);
_data.writeInt(uid2);
mRemote.transact(Stub.TRANSACTION_checkUidSignatures, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.017 -0500", hash_original_method = "CFE5B6F4BC77F0B77FBFE4A88CEFF6AF", hash_generated_method = "3D24C9017EBA11245D64B02F57A875DD")
            
public java.lang.String[] getPackagesForUid(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getPackagesForUid, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.020 -0500", hash_original_method = "7BBB4D10C6E1668851AC4AE8EDFD652D", hash_generated_method = "CBB9446E6A219AF37C415B57119126B7")
            
public java.lang.String getNameForUid(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getNameForUid, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.022 -0500", hash_original_method = "418A71B1B6331B4B823E10ADD8E0B000", hash_generated_method = "EAE211457A803B941F5F02BF37B2A988")
            
public int getUidForSharedUser(java.lang.String sharedUserName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sharedUserName);
mRemote.transact(Stub.TRANSACTION_getUidForSharedUser, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.025 -0500", hash_original_method = "CDE776C07BA988AE5A07591BEF9FBAAD", hash_generated_method = "A952471451918ABE3B6BD2A8825D043D")
            
public android.content.pm.ResolveInfo resolveIntent(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ResolveInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_resolveIntent, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ResolveInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.028 -0500", hash_original_method = "DA81DFF872E413D4D95C8C7907771FB1", hash_generated_method = "8166C71992FC1AAD29D01AAC2E979BDC")
            
public java.util.List<android.content.pm.ResolveInfo> queryIntentActivities(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.ResolveInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryIntentActivities, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.ResolveInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.032 -0500", hash_original_method = "62D156CDB34B993BFC30596F4CD8825A", hash_generated_method = "F3C044203636C9ABF599E01BF969D5A2")
            
public java.util.List<android.content.pm.ResolveInfo> queryIntentActivityOptions(android.content.ComponentName caller, android.content.Intent[] specifics, java.lang.String[] specificTypes, android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.ResolveInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((caller!=null)) {
_data.writeInt(1);
caller.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeTypedArray(specifics, 0);
_data.writeStringArray(specificTypes);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryIntentActivityOptions, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.ResolveInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.035 -0500", hash_original_method = "474557CC8C1E42683BF09B2B99F4A2F2", hash_generated_method = "98E35B3D7179547ABBF0F9C3D68F7721")
            
public java.util.List<android.content.pm.ResolveInfo> queryIntentReceivers(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.ResolveInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryIntentReceivers, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.ResolveInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.038 -0500", hash_original_method = "D4FB17100BFA11C646150AF4038C5E6F", hash_generated_method = "4B3A7AB327A54C5D2C0FD6C8EEA43305")
            
public android.content.pm.ResolveInfo resolveService(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ResolveInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_resolveService, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ResolveInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.041 -0500", hash_original_method = "0F2E266DBE41AADC32D29480F5FBED3C", hash_generated_method = "9A90B31ADBD598A2706D1F17FFF1580B")
            
public java.util.List<android.content.pm.ResolveInfo> queryIntentServices(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.ResolveInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryIntentServices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.ResolveInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * This implements getInstalledPackages via a "last returned row"
     * mechanism that is not exposed in the API. This is to get around the IPC
     * limit that kicks in when flags are included that bloat up the data
     * returned.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.043 -0500", hash_original_method = "36DEA750C224104D94FC6F7300635061", hash_generated_method = "95CADF1C16D3CE9B8470CFE08CE1BC0A")
            
public android.content.pm.ParceledListSlice getInstalledPackages(int flags, java.lang.String lastRead) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
_data.writeString(lastRead);
mRemote.transact(Stub.TRANSACTION_getInstalledPackages, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
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
     * This implements getInstalledApplications via a "last returned row"
     * mechanism that is not exposed in the API. This is to get around the IPC
     * limit that kicks in when flags are included that bloat up the data
     * returned.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.046 -0500", hash_original_method = "EA01E1C1384073D4B24C87D2B1195FC1", hash_generated_method = "01C80FB76C32E859154E66323D527A5D")
            
public android.content.pm.ParceledListSlice getInstalledApplications(int flags, java.lang.String lastRead) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
_data.writeString(lastRead);
mRemote.transact(Stub.TRANSACTION_getInstalledApplications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
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
     * Retrieve all applications that are marked as persistent.
     * 
     * @return A List&lt;applicationInfo> containing one entry for each persistent
     *         application.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.049 -0500", hash_original_method = "BD0A36BB5D985A95391979251ED30BD6", hash_generated_method = "EE18A9EEB75C0B19349F9AB7B441E8D8")
            
public java.util.List<android.content.pm.ApplicationInfo> getPersistentApplications(int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.ApplicationInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getPersistentApplications, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.ApplicationInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.052 -0500", hash_original_method = "001EB4DF76968EECACC24D3D82325080", hash_generated_method = "BE832B940404F1F1CF6FA33FBBD3481A")
            
public android.content.pm.ProviderInfo resolveContentProvider(java.lang.String name, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ProviderInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_resolveContentProvider, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ProviderInfo.CREATOR.createFromParcel(_reply);
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
     * Retrieve sync information for all content providers.
     * 
     * @param outNames Filled in with a list of the root names of the content
     *                 providers that can sync.
     * @param outInfo Filled in with a list of the ProviderInfo for each
     *                name in 'outNames'.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.055 -0500", hash_original_method = "D05215F817EA48B457F6A33F51B8A340", hash_generated_method = "7A99F958D4E40629AA7512D0E380CD93")
            
public void querySyncProviders(java.util.List<java.lang.String> outNames, java.util.List<android.content.pm.ProviderInfo> outInfo) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringList(outNames);
_data.writeTypedList(outInfo);
mRemote.transact(Stub.TRANSACTION_querySyncProviders, _data, _reply, 0);
_reply.readException();
_reply.readStringList(outNames);
_reply.readTypedList(outInfo, android.content.pm.ProviderInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.058 -0500", hash_original_method = "18CDE71419F1859750C078A99EFB168A", hash_generated_method = "36DBB73A393D0C95DCC955620CC0A575")
            
public java.util.List<android.content.pm.ProviderInfo> queryContentProviders(java.lang.String processName, int uid, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.ProviderInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(processName);
_data.writeInt(uid);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryContentProviders, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.ProviderInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.061 -0500", hash_original_method = "435C3E9EAA9F4037EA5A0FB1AB0B62BB", hash_generated_method = "C8EFEB15061A429E317FAF1F8937CE57")
            
public android.content.pm.InstrumentationInfo getInstrumentationInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.InstrumentationInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getInstrumentationInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.InstrumentationInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.064 -0500", hash_original_method = "18F0317F4E0227DC2040EB6B4E407E43", hash_generated_method = "59EFE93DB454364649C4A5717D65F8D8")
            
public java.util.List<android.content.pm.InstrumentationInfo> queryInstrumentation(java.lang.String targetPackage, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.InstrumentationInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(targetPackage);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryInstrumentation, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.InstrumentationInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Install a package.
     *
     * @param packageURI The location of the package file to install.
     * @param observer a callback to use to notify when the package installation in finished.
     * @param flags - possible values: {@link #FORWARD_LOCK_PACKAGE},
     * {@link #REPLACE_EXISITING_PACKAGE}
     * @param installerPackageName Optional package name of the application that is performing the
     * installation. This identifies which market the package came from.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.066 -0500", hash_original_method = "3791919BA141E5BF47122F6508CE71F4", hash_generated_method = "2F883C7842BEBD832131FAB44D3AB0D7")
            
public void installPackage(android.net.Uri packageURI, android.content.pm.IPackageInstallObserver observer, int flags, java.lang.String installerPackageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((packageURI!=null)) {
_data.writeInt(1);
packageURI.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(flags);
_data.writeString(installerPackageName);
mRemote.transact(Stub.TRANSACTION_installPackage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.069 -0500", hash_original_method = "B024BC53B7D6F08164E226649DDDE6A8", hash_generated_method = "D85F3CE63208A1A83AFCA562781560A1")
            
public void finishPackageInstall(int token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(token);
mRemote.transact(Stub.TRANSACTION_finishPackageInstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.076 -0500", hash_original_method = "DF272E657296DABF9C6466BCC6FAFE99", hash_generated_method = "D6D5971C75B082A64A1F885973CD9DEA")
            
public void setInstallerPackageName(java.lang.String targetPackage, java.lang.String installerPackageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(targetPackage);
_data.writeString(installerPackageName);
mRemote.transact(Stub.TRANSACTION_setInstallerPackageName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Delete a package.
     *
     * @param packageName The fully qualified name of the package to delete.
     * @param observer a callback to use to notify when the package deletion in finished.
     * @param flags - possible values: {@link #DONT_DELETE_DATA}
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.079 -0500", hash_original_method = "179E63AB494F6DD878955E6D6480CBBF", hash_generated_method = "8FA1F94686AC098826FC979839430C38")
            
public void deletePackage(java.lang.String packageName, android.content.pm.IPackageDeleteObserver observer, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_deletePackage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.082 -0500", hash_original_method = "9D4541403ADDA28864E30BA877492DD1", hash_generated_method = "620E563F6D935A8D4EB9C375388AF89D")
            
public java.lang.String getInstallerPackageName(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getInstallerPackageName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.084 -0500", hash_original_method = "58C5B8A3C81B1560A49DD325FC039BC4", hash_generated_method = "47C052EBA86995F34E2CD60823784893")
            
public void addPackageToPreferred(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_addPackageToPreferred, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.087 -0500", hash_original_method = "185D036307E1EF7B6A484D26E08A50EA", hash_generated_method = "72BD6F3146F89C7A5E4AB9B393D83F25")
            
public void removePackageFromPreferred(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_removePackageFromPreferred, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.090 -0500", hash_original_method = "6D27A98BBB76D9E905538887D353A68A", hash_generated_method = "F735300BBCDDB64D74A2B3C875A5D497")
            
public java.util.List<android.content.pm.PackageInfo> getPreferredPackages(int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.pm.PackageInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getPreferredPackages, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.pm.PackageInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.092 -0500", hash_original_method = "ABA87C5116DFC40BB502476BF20913A0", hash_generated_method = "2483E8A50C657DECE777C9EC64AA4A10")
            
public void addPreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((filter!=null)) {
_data.writeInt(1);
filter.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(match);
_data.writeTypedArray(set, 0);
if ((activity!=null)) {
_data.writeInt(1);
activity.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPreferredActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.095 -0500", hash_original_method = "73C7AE992CAD30A79CF44D849B6780DE", hash_generated_method = "156CA7F2CD02CE0271660BBAF12B885E")
            
public void replacePreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((filter!=null)) {
_data.writeInt(1);
filter.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(match);
_data.writeTypedArray(set, 0);
if ((activity!=null)) {
_data.writeInt(1);
activity.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_replacePreferredActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.098 -0500", hash_original_method = "1F23EB00448BD7E4C49DFC507B4C6380", hash_generated_method = "FE9EDA64082A94A00E84AC6523D90453")
            
public void clearPackagePreferredActivities(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_clearPackagePreferredActivities, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.101 -0500", hash_original_method = "7F7F6F29BCC02C5316F448392F2A1DA6", hash_generated_method = "6DDBEA619CCFB8ACBEB109902EE494F6")
            
public int getPreferredActivities(java.util.List<android.content.IntentFilter> outFilters, java.util.List<android.content.ComponentName> outActivities, java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getPreferredActivities, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
_reply.readTypedList(outFilters, android.content.IntentFilter.CREATOR);
_reply.readTypedList(outActivities, android.content.ComponentName.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * As per {@link android.content.pm.PackageManager#setComponentEnabledSetting}.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.104 -0500", hash_original_method = "30E85C8BB554C3F8158F487C607590D2", hash_generated_method = "AF0AC9F5E1FFDAE3600540F4B0D96F6B")
            
public void setComponentEnabledSetting(android.content.ComponentName componentName, int newState, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(newState);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_setComponentEnabledSetting, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * As per {@link android.content.pm.PackageManager#getComponentEnabledSetting}.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.107 -0500", hash_original_method = "4D1C3B908B528C3C3BF5A830B15ED95A", hash_generated_method = "4F134E6CA52FC4D4D62EB0E2F0247D59")
            
public int getComponentEnabledSetting(android.content.ComponentName componentName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getComponentEnabledSetting, _data, _reply, 0);
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
     * As per {@link android.content.pm.PackageManager#setApplicationEnabledSetting}.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.109 -0500", hash_original_method = "84587D9CC7A15E6605457F5C8A45BDCF", hash_generated_method = "69465A30D4FD445CF91AFF3B93B81B2D")
            
public void setApplicationEnabledSetting(java.lang.String packageName, int newState, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(newState);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_setApplicationEnabledSetting, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * As per {@link android.content.pm.PackageManager#getApplicationEnabledSetting}.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.112 -0500", hash_original_method = "75A4221E2F19BAA83A9E06271D02A33A", hash_generated_method = "116996EEF956146326B6E0ACE315076A")
            
public int getApplicationEnabledSetting(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getApplicationEnabledSetting, _data, _reply, 0);
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
     * Set whether the given package should be considered stopped, making
     * it not visible to implicit intents that filter out stopped packages.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.114 -0500", hash_original_method = "2D8E6E013B01ACEBF5FD2CAC7C143619", hash_generated_method = "CE999CA288288F49A7D8274B1E40E2C0")
            
public void setPackageStoppedState(java.lang.String packageName, boolean stopped) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(((stopped)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setPackageStoppedState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Free storage by deleting LRU sorted list of cache files across
     * all applications. If the currently available free storage
     * on the device is greater than or equal to the requested
     * free storage, no cache files are cleared. If the currently
     * available storage on the device is less than the requested
     * free storage, some or all of the cache files across
     * all applications are deleted (based on last accessed time)
     * to increase the free storage space on the device to
     * the requested value. There is no guarantee that clearing all
     * the cache files from all applications will clear up
     * enough storage to achieve the desired value.
     * @param freeStorageSize The number of bytes of storage to be
     * freed by the system. Say if freeStorageSize is XX,
     * and the current free storage is YY,
     * if XX is less than YY, just return. if not free XX-YY number
     * of bytes if possible.
     * @param observer call back used to notify when
     * the operation is completed
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.117 -0500", hash_original_method = "2538AD6289648D00C03567EED9B122B6", hash_generated_method = "54E0509AB8BF649D6C0D2BCB20AB7F84")
            
public void freeStorageAndNotify(long freeStorageSize, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(freeStorageSize);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_freeStorageAndNotify, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Free storage by deleting LRU sorted list of cache files across
     * all applications. If the currently available free storage
     * on the device is greater than or equal to the requested
     * free storage, no cache files are cleared. If the currently
     * available storage on the device is less than the requested
     * free storage, some or all of the cache files across
     * all applications are deleted (based on last accessed time)
     * to increase the free storage space on the device to
     * the requested value. There is no guarantee that clearing all
     * the cache files from all applications will clear up
     * enough storage to achieve the desired value.
     * @param freeStorageSize The number of bytes of storage to be
     * freed by the system. Say if freeStorageSize is XX,
     * and the current free storage is YY,
     * if XX is less than YY, just return. if not free XX-YY number
     * of bytes if possible.
     * @param pi IntentSender call back used to
     * notify when the operation is completed.May be null
     * to indicate that no call back is desired.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.121 -0500", hash_original_method = "86B357A7E242A364B856CDEBC6B8EB52", hash_generated_method = "A16BBBEED6F06ADD083E241C8D641B27")
            
public void freeStorage(long freeStorageSize, android.content.IntentSender pi) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(freeStorageSize);
if ((pi!=null)) {
_data.writeInt(1);
pi.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_freeStorage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Delete all the cache files in an applications cache directory
     * @param packageName The package name of the application whose cache
     * files need to be deleted
     * @param observer a callback used to notify when the deletion is finished.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.123 -0500", hash_original_method = "5F6BC2B946ABEC71B6A1E6E6D4DDDCCD", hash_generated_method = "E6550E6814A9D22A6F8BA5EABC18B5B3")
            
public void deleteApplicationCacheFiles(java.lang.String packageName, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_deleteApplicationCacheFiles, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Clear the user data directory of an application.
     * @param packageName The package name of the application whose cache
     * files need to be deleted
     * @param observer a callback used to notify when the operation is completed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.126 -0500", hash_original_method = "CE95A0D9FDD42B1098E58E7C3E88E8E2", hash_generated_method = "A3EE5D683427C85F6E9ED4C370181A45")
            
public void clearApplicationUserData(java.lang.String packageName, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_clearApplicationUserData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Get package statistics including the code, data and cache size for
     * an already installed package
     * @param packageName The package name of the application
     * @param observer a callback to use to notify when the asynchronous
     * retrieval of information is complete.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.129 -0500", hash_original_method = "8F7B885DD6D9806EC5F3666FC10CDC51", hash_generated_method = "3B4FE840A31FF48500E5CC40061B53A7")
            
public void getPackageSizeInfo(java.lang.String packageName, android.content.pm.IPackageStatsObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getPackageSizeInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Get a list of shared libraries that are available on the
     * system.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.131 -0500", hash_original_method = "73E1EE5C733FEE38A2D75272B8615722", hash_generated_method = "0634E0A965FF386191C245651009E894")
            
public java.lang.String[] getSystemSharedLibraryNames() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSystemSharedLibraryNames, _data, _reply, 0);
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
     * Get a list of features that are available on the
     * system.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.134 -0500", hash_original_method = "CC1D6B70DA8A274BF7A850F075A9E1BF", hash_generated_method = "15828D2BF84F6C605AB87BE463705C98")
            
public android.content.pm.FeatureInfo[] getSystemAvailableFeatures() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.FeatureInfo[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSystemAvailableFeatures, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.content.pm.FeatureInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.137 -0500", hash_original_method = "6F22D0C0307D8B9CD5F8C0D8C4E3243C", hash_generated_method = "BC27C6553E5ADC9EBC04DE51AA135CAA")
            
public boolean hasSystemFeature(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_hasSystemFeature, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.140 -0500", hash_original_method = "E139E1BDD08C3254CFD75A1F2C97E18C", hash_generated_method = "4422472D8AC45F3E36ED9E9A847105DA")
            
public void enterSafeMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_enterSafeMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.142 -0500", hash_original_method = "EDC2F9E92E72CEE710C9DD4E47876100", hash_generated_method = "803FF4424175579C4FFF36EA0C49F15E")
            
public boolean isSafeMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isSafeMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.145 -0500", hash_original_method = "324992B6A5E425EF1EEF3A96ED4B3F55", hash_generated_method = "1BCE1D4D163087BB0CDB972D0F09546D")
            
public void systemReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_systemReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.147 -0500", hash_original_method = "6C7666CF529AB688A161839F75600EFC", hash_generated_method = "89B6DF19EA55B57D58E9817608EA6FBB")
            
public boolean hasSystemUidErrors() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hasSystemUidErrors, _data, _reply, 0);
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
     * Ask the package manager to perform boot-time dex-opt of all
     * existing packages.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.151 -0500", hash_original_method = "1A10050BDCE16DB2811FC6676C6373E4", hash_generated_method = "CF2C093CC72B567698D0D730CBF73E6C")
            
public void performBootDexOpt() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_performBootDexOpt, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Ask the package manager to perform dex-opt (if needed) on the given
     * package, if it already hasn't done mode.  Only does this if running
     * in the special development "no pre-dexopt" mode.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.153 -0500", hash_original_method = "986393659E4FB549F9A85A407FB95645", hash_generated_method = "270E415B63094C6D1E91E97CF9B60528")
            
public boolean performDexOpt(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_performDexOpt, _data, _reply, 0);
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
     * Update status of external media on the package manager to scan and
     * install packages installed on the external media. Like say the
     * MountService uses this to call into the package manager to update
     * status of sdcard.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.156 -0500", hash_original_method = "1BDDB9E948B75E60CCC419BFC02EA706", hash_generated_method = "E16AFBF90F902013E596FCE541B5176D")
            
public void updateExternalMediaStatus(boolean mounted, boolean reportStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((mounted)?(1):(0)));
_data.writeInt(((reportStatus)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_updateExternalMediaStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.159 -0500", hash_original_method = "C7F66A5B0677E90D52CD3D84696C88C7", hash_generated_method = "65B54B90DCC7E7C5D5E9AB4E13F5875B")
            
public java.lang.String nextPackageToClean(java.lang.String lastPackage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(lastPackage);
mRemote.transact(Stub.TRANSACTION_nextPackageToClean, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.161 -0500", hash_original_method = "2B886162EBDAC490C449780FD8FAEE54", hash_generated_method = "D8F64AF12C2DC6FD044BDBEFC0D6CB85")
            
public void movePackage(java.lang.String packageName, android.content.pm.IPackageMoveObserver observer, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_movePackage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.164 -0500", hash_original_method = "031FF3809E4A1D0C3D7DFB840F3F5040", hash_generated_method = "756A94A452D4A99A9AB60B9BB13D1F0C")
            
public boolean addPermissionAsync(android.content.pm.PermissionInfo info) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPermissionAsync, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.167 -0500", hash_original_method = "24E258A2289FF38F55D2F72ABABB2118", hash_generated_method = "10601A9FF44B3C8B3B67F67F31FD7C0E")
            
public boolean setInstallLocation(int loc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(loc);
mRemote.transact(Stub.TRANSACTION_setInstallLocation, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.169 -0500", hash_original_method = "9F41FCAE0608706A8A890BEF27E46DCA", hash_generated_method = "86F6A6F70C58DBBF608542D238705360")
            
public int getInstallLocation() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInstallLocation, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.172 -0500", hash_original_method = "28A9F5A2C264D5F64A708FA2436DFEF9", hash_generated_method = "800C0E2A26500958D44C6A36827601AD")
            
public android.content.pm.UserInfo createUser(java.lang.String name, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.UserInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_createUser, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.UserInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.176 -0500", hash_original_method = "91F27C738419959B0045450F32007B10", hash_generated_method = "1622B83165A06BE6977D43EBE1380701")
            
public boolean removeUser(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_removeUser, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.179 -0500", hash_original_method = "1D58E6B1EE7B06A893C543C9A5DF8AEC", hash_generated_method = "2A75FD3F19EAA7FD0B0FAB52CF29DBD6")
            
public void installPackageWithVerification(android.net.Uri packageURI, android.content.pm.IPackageInstallObserver observer, int flags, java.lang.String installerPackageName, android.net.Uri verificationURI, android.content.pm.ManifestDigest manifestDigest) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((packageURI!=null)) {
_data.writeInt(1);
packageURI.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(flags);
_data.writeString(installerPackageName);
if ((verificationURI!=null)) {
_data.writeInt(1);
verificationURI.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((manifestDigest!=null)) {
_data.writeInt(1);
manifestDigest.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_installPackageWithVerification, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.181 -0500", hash_original_method = "9F4C08E7817C97D4BB8FC64DC3989C71", hash_generated_method = "42689150924A846EB1DA3BCB132248D2")
            
public void verifyPendingInstall(int id, int verificationCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(verificationCode);
mRemote.transact(Stub.TRANSACTION_verifyPendingInstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.184 -0500", hash_original_method = "8283D4C75DD271EA4933EA3DBD9A7AE6", hash_generated_method = "6C8BA98C4CFF24A00D534205BEC7E7E7")
            
public android.content.pm.VerifierDeviceIdentity getVerifierDeviceIdentity() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.VerifierDeviceIdentity _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVerifierDeviceIdentity, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.VerifierDeviceIdentity.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.187 -0500", hash_original_method = "1B9CA84CA1F2B56865C9A3EAE6AB6F91", hash_generated_method = "9CF9D2A28B38C9A4C97C2DF8277061A9")
            
public boolean isFirstBoot() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isFirstBoot, _data, _reply, 0);
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.218 -0500", hash_original_field = "29A59ADC94E3C3FFAA6EF98E0FDA9425", hash_generated_field = "ED994EA0812381B2891384C0A4A4194F")

static final int TRANSACTION_currentToCanonicalPackageNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.220 -0500", hash_original_field = "6A3A24A552145EAE35DFF37F7A5390C6", hash_generated_field = "76D1789666C01F378887F70711059FEA")

static final int TRANSACTION_canonicalToCurrentPackageNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.223 -0500", hash_original_field = "B796BFD56A4076123101B8B76ABF6351", hash_generated_field = "87D0849A9AA9ED2B364456A181AAD5C0")

static final int TRANSACTION_getPermissionInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.225 -0500", hash_original_field = "19FC10F6C0522FC82B1C719D189F0BFD", hash_generated_field = "C01791C0BE95003FA99130ABEBC50177")

static final int TRANSACTION_queryPermissionsByGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.228 -0500", hash_original_field = "F6F74FFFE975E44175AB024F5D8B738A", hash_generated_field = "4C99B2C4A0876F8CC77AC9F52155F3B7")

static final int TRANSACTION_getPermissionGroupInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.230 -0500", hash_original_field = "FC26092C9A913B7A74706F07CC281218", hash_generated_field = "5992BF3EA91FD1A8AC420C8170030F14")

static final int TRANSACTION_getAllPermissionGroups = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.232 -0500", hash_original_field = "CDDF03402F15E41D060481DA53C57456", hash_generated_field = "94FBEF12BBEFBD4F1E2A6AADEC0FCEA6")

static final int TRANSACTION_getApplicationInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.235 -0500", hash_original_field = "C6B8C86B1811833B853B83D80C440F1F", hash_generated_field = "8D8D2212F6D61083EF7E310548604369")

static final int TRANSACTION_getActivityInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.237 -0500", hash_original_field = "248CE9AAC293ED50755160BECAE7DB4C", hash_generated_field = "105CF4FDD85BADF54CD77BC2476860F5")

static final int TRANSACTION_getReceiverInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.240 -0500", hash_original_field = "4256482AC7C0EA5D595CF8C05D3E2ACF", hash_generated_field = "A3013EE0BAC7D05EE272C4E3ECE068EB")

static final int TRANSACTION_getServiceInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.243 -0500", hash_original_field = "254C7CEF8BE01907FF2F34CC47B6CC19", hash_generated_field = "5BE6CAB31C5B0E72FE45778959F0D132")

static final int TRANSACTION_getProviderInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.245 -0500", hash_original_field = "BAC8FBB167D85A8BE5103AB1FF6FE0D5", hash_generated_field = "CDA126265E3F4373645F1C9531FBDE2D")

static final int TRANSACTION_checkPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.247 -0500", hash_original_field = "49A426AB084761D67455005B7C062A21", hash_generated_field = "8E4510B41EFE7999B1864FCA8F9FB0BD")

static final int TRANSACTION_checkUidPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.250 -0500", hash_original_field = "FBD072DC7680497DD0FAC53611A13D5F", hash_generated_field = "23A87BE1C2233C11C70D4492B2ACB2C8")

static final int TRANSACTION_addPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.252 -0500", hash_original_field = "6B264065EAAE04C4FD78CFE59161416E", hash_generated_field = "6C57A89355D195FDDFBFC31AF380CDC7")

static final int TRANSACTION_removePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.254 -0500", hash_original_field = "677CF93C1EC8E21A130FEC166BE9B703", hash_generated_field = "751CC6D62EEFD1656E17E89919CF1DC9")

static final int TRANSACTION_isProtectedBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.257 -0500", hash_original_field = "B050139C31D99BF8D031C1EF7CDB1414", hash_generated_field = "97C981C59E5C1161EF665911B02C350E")

static final int TRANSACTION_checkSignatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.260 -0500", hash_original_field = "9C281BC6B836FE5632C84FE58D1EA0AE", hash_generated_field = "889D3B6127D30F7A66EAD2710F8C102E")

static final int TRANSACTION_checkUidSignatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.262 -0500", hash_original_field = "17AEFF5954AF3F93BEBCFCC30D404213", hash_generated_field = "C1D5878CE4CE44179297FC57641EB713")

static final int TRANSACTION_getPackagesForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.264 -0500", hash_original_field = "725D1BCFC9F4B9CEE6314ACDAF085FAF", hash_generated_field = "30D29DABF8D8F3F7B413499E28F86C41")

static final int TRANSACTION_getNameForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.267 -0500", hash_original_field = "8CA7948676AD636DCDBE65170434ED2A", hash_generated_field = "CC3533D21944452152F4DD961DC60DE0")

static final int TRANSACTION_getUidForSharedUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.269 -0500", hash_original_field = "A0D8F8627912C439C3387B904161D466", hash_generated_field = "62112D3CFE4D7284FBFF2DEB3264FCAB")

static final int TRANSACTION_resolveIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.272 -0500", hash_original_field = "80B302EF2F6242DAB6CEA3A27536087D", hash_generated_field = "699A151382CB9DE91352EE46F41E75D6")

static final int TRANSACTION_queryIntentActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.274 -0500", hash_original_field = "99B074530AFC148ADF209D6D89B97A7A", hash_generated_field = "360B5DA4B46841546DD1F01DB5FCE983")

static final int TRANSACTION_queryIntentActivityOptions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.276 -0500", hash_original_field = "29231B22ED59B9469EE010F2CEFAF0CC", hash_generated_field = "A6B93804E1BB9C86F9FD18B6942C1B45")

static final int TRANSACTION_queryIntentReceivers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.279 -0500", hash_original_field = "F968C6FE40B9EF1ABF0ECE101B43DFF8", hash_generated_field = "C0F08F12117A7EA9727764AE3A4C9DB2")

static final int TRANSACTION_resolveService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.281 -0500", hash_original_field = "2B8896DAB80104BE5619857DD2B41A03", hash_generated_field = "A356101DAA5B18956E88E849A981E18D")

static final int TRANSACTION_queryIntentServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.283 -0500", hash_original_field = "954A5B79110FD06B3B1AE4C1C0C3EF05", hash_generated_field = "50A526E9C1531CB8D8ECFF6A72F438E8")

static final int TRANSACTION_getInstalledPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.286 -0500", hash_original_field = "085E8480D3639E7433D0AA5BBF8E7951", hash_generated_field = "1DAE9458228162128EC5F01210EA435E")

static final int TRANSACTION_getInstalledApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.289 -0500", hash_original_field = "97104C2568765BB982CDED4F1DB0446C", hash_generated_field = "CBB4102552B8CA8D8D43B0C4C536F45E")

static final int TRANSACTION_getPersistentApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.291 -0500", hash_original_field = "34B348D38EFE5E7B91ACCEC700AF5620", hash_generated_field = "3AAE6103281D0E73547B30785CC95763")

static final int TRANSACTION_resolveContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.293 -0500", hash_original_field = "FF6DD7BC4BD25A64165016D48C575D56", hash_generated_field = "CC6FDF37FFAFB6D51B4B7D3985F217ED")

static final int TRANSACTION_querySyncProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.296 -0500", hash_original_field = "AF256C2FDF20A89CA62A2F4DCAB723F4", hash_generated_field = "FD790795FDBD4803A9F5C801EB3AF73F")

static final int TRANSACTION_queryContentProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.299 -0500", hash_original_field = "2C4DA15E26E685C87FA8C9AB28356D33", hash_generated_field = "32E29F3B707A26F9ACB717DD3F9DA50C")

static final int TRANSACTION_getInstrumentationInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.301 -0500", hash_original_field = "177E639B3CB13214B95BE3E9A506EB59", hash_generated_field = "A6D6A3691167286C17C5D7DE5937C2AF")

static final int TRANSACTION_queryInstrumentation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.303 -0500", hash_original_field = "E7D76B2390FFCB7F55C3286312477097", hash_generated_field = "C42E6B7529E0FEA0978203172884F6DD")

static final int TRANSACTION_installPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.306 -0500", hash_original_field = "E088EA203245CD9632087B741F4B5DD0", hash_generated_field = "F27FC21D5949D4D376ED50C1A1609F7B")

static final int TRANSACTION_finishPackageInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.308 -0500", hash_original_field = "FE5A9A08CCD51087AA0EF90605158F55", hash_generated_field = "1E9ACEC8EB37F928D12DE9028BCCACAD")

static final int TRANSACTION_setInstallerPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.310 -0500", hash_original_field = "274B0E8CC01902A556F3E54BF48689A5", hash_generated_field = "D96C664A1EE47E008DE1967770554E67")

static final int TRANSACTION_deletePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.313 -0500", hash_original_field = "37364314915D5D2DEEA3660AA4B258AA", hash_generated_field = "F541AE9D640B6351955AA33DA58ABBE9")

static final int TRANSACTION_getInstallerPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.316 -0500", hash_original_field = "88DBEC39A69C0489B0D4A59D165FB1A1", hash_generated_field = "6B904B43832BFBB2637374365780FD8F")

static final int TRANSACTION_addPackageToPreferred = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.318 -0500", hash_original_field = "F5BF600AC5AA7310B758BDBA52DD54DC", hash_generated_field = "C1B40C2FCFAF13C42D3D15E639B2BB1F")

static final int TRANSACTION_removePackageFromPreferred = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.320 -0500", hash_original_field = "0B0387239EDB06877A78323ED9D39C27", hash_generated_field = "C61D5C76ED956EC1E4A1D19E88DBD4E0")

static final int TRANSACTION_getPreferredPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.322 -0500", hash_original_field = "A5919E319ECC8F007B4C7721C96BF60A", hash_generated_field = "5579F6B5E2D7896D13269796EAE466E3")

static final int TRANSACTION_addPreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.325 -0500", hash_original_field = "F63EA7FC4C9A689C9FE2FA3EE578777E", hash_generated_field = "363CE877D74422797711C755ACEDD80D")

static final int TRANSACTION_replacePreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.327 -0500", hash_original_field = "90996D71947DA33728C3712CED0ABC09", hash_generated_field = "94286D1200644C349B3BB2C544691A92")

static final int TRANSACTION_clearPackagePreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.329 -0500", hash_original_field = "877D4CCDF70FE329D2FDE546DCB7F60C", hash_generated_field = "C81AF22D2ADBAC892C72CC8D6BC696DD")

static final int TRANSACTION_getPreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.332 -0500", hash_original_field = "CDFC6F6BD205953A93DB5D239800FEA0", hash_generated_field = "DB2A547724B6EF13BE9BFEDAABCE9D91")

static final int TRANSACTION_setComponentEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.334 -0500", hash_original_field = "EB6FF180B7E77EA76AA4D1581F55B954", hash_generated_field = "F3DFD4BD4F2E6A895D0057357B6B032D")

static final int TRANSACTION_getComponentEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.336 -0500", hash_original_field = "A5451C86854942C7ADABF69D20E43A2B", hash_generated_field = "963B791C054816E55E4E83AFC1AC53C4")

static final int TRANSACTION_setApplicationEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.340 -0500", hash_original_field = "21F0A80006CE3B355C65FA185FA95E78", hash_generated_field = "EDEBFE0D89D161A5D8B2088785A19BDB")

static final int TRANSACTION_getApplicationEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.343 -0500", hash_original_field = "69ECF488AFE3B5FC88D872215ACEB845", hash_generated_field = "887383EE80344CBE2F75E8795A06F381")

static final int TRANSACTION_setPackageStoppedState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.345 -0500", hash_original_field = "767B786806B8652A29A9F8CAFF53B80A", hash_generated_field = "B5BB2A34CEC4B6ED0388CBEC34C138F9")

static final int TRANSACTION_freeStorageAndNotify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.347 -0500", hash_original_field = "AED7D6634BF237044B11516661655CF7", hash_generated_field = "13BBC4E55F01D791C9316C9FD7DFB43A")

static final int TRANSACTION_freeStorage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.350 -0500", hash_original_field = "67B01345946D096F437DDF6F6A121F78", hash_generated_field = "D5332590EFB8F298EA1BFA19538F660A")

static final int TRANSACTION_deleteApplicationCacheFiles = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.352 -0500", hash_original_field = "1B3889C1E9A46D74F118B69EDD331417", hash_generated_field = "7CBE04CC87EF632C03E086701D0A9426")

static final int TRANSACTION_clearApplicationUserData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.355 -0500", hash_original_field = "8CA2A77C85A2FF9499E73B9F5D5FBDAB", hash_generated_field = "F670A6161D8F81C2AEF2BA5BD617BE78")

static final int TRANSACTION_getPackageSizeInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.357 -0500", hash_original_field = "6245504E849A76E8AF67AF88614363D0", hash_generated_field = "46F465D9C666BD435F2CD331A6C48D2A")

static final int TRANSACTION_getSystemSharedLibraryNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.359 -0500", hash_original_field = "09CC3901578342C341DDBAE273C1D3EC", hash_generated_field = "F1EBA92047BD4C526B9866DF5D2E2B0F")

static final int TRANSACTION_getSystemAvailableFeatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.362 -0500", hash_original_field = "E597725A2B13918EAB44667AA6AAE20B", hash_generated_field = "6DBDFADF94187DCC5362C3E55C3A7FEE")

static final int TRANSACTION_hasSystemFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.364 -0500", hash_original_field = "027FFEF05DF58A1DFC5022CED85406A8", hash_generated_field = "7DC5187FE3E387331739C25314C4EC3F")

static final int TRANSACTION_enterSafeMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.366 -0500", hash_original_field = "3E8AF50C0B093E723008D95715BE82CF", hash_generated_field = "F0103AF07AE0F483762C9F64FDE6CE61")

static final int TRANSACTION_isSafeMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.369 -0500", hash_original_field = "2B3E18451C0A80924D0A9655BE1EFABD", hash_generated_field = "369711FE9F9D7595E5A9B50AF0F6024E")

static final int TRANSACTION_systemReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.371 -0500", hash_original_field = "7D712CE968CF9C93EA10CD9E625D8489", hash_generated_field = "07E434F646CC9DDB1109A5F8F72F9DE2")

static final int TRANSACTION_hasSystemUidErrors = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.373 -0500", hash_original_field = "1622F43876F0905FAE1A1F64D78727A9", hash_generated_field = "5488230AF628D459D3E60D8C6B85F734")

static final int TRANSACTION_performBootDexOpt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.376 -0500", hash_original_field = "7B9A9808521475A1FA8271F11D409427", hash_generated_field = "DB288C4ABE5291FE61C02F0F7184ABE6")

static final int TRANSACTION_performDexOpt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.378 -0500", hash_original_field = "B522F282D2BBACDF920BF9CF4ED0BCED", hash_generated_field = "908E9C6B2746FE7695B2CE2CDE92B2B6")

static final int TRANSACTION_updateExternalMediaStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.381 -0500", hash_original_field = "BC0437239CBB20A5352AD4DAF11AF02C", hash_generated_field = "16CA3C9A405793C0FA0BF4705270E366")

static final int TRANSACTION_nextPackageToClean = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.383 -0500", hash_original_field = "730BC4629EC123D9046CB5A390AC4F5A", hash_generated_field = "67FF20976E20B7D4569BE73AAFC65061")

static final int TRANSACTION_movePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.385 -0500", hash_original_field = "FA0F61A4690C9909745AA3ED978A717B", hash_generated_field = "65366C0CFE98A0D803545F9CEB069A5E")

static final int TRANSACTION_addPermissionAsync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.388 -0500", hash_original_field = "33180BA683E16E20B60E66C286E3F79B", hash_generated_field = "A00C544B83569171593205D9444DA7CA")

static final int TRANSACTION_setInstallLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.390 -0500", hash_original_field = "F312A8A620B8AF3843431EDD224F1992", hash_generated_field = "13E0D9E005CCD98CF25740C40D1718FD")

static final int TRANSACTION_getInstallLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.392 -0500", hash_original_field = "32BC41BBA0847339B404F01898AC6BB3", hash_generated_field = "1A7386865318EE505BE879CEBB9207EE")

static final int TRANSACTION_createUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 75);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.395 -0500", hash_original_field = "5737E34E3C799C60E1D8E87A84CB7A7A", hash_generated_field = "06E91899C784D38A5D37411183111874")

static final int TRANSACTION_removeUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 76);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.397 -0500", hash_original_field = "5A520C3ECDD199323ECC4F6111DF91A9", hash_generated_field = "651A13819680447327A3029433FCB2BE")

static final int TRANSACTION_installPackageWithVerification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 77);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.400 -0500", hash_original_field = "355230C850AB36EB468751B91EAA19F9", hash_generated_field = "1008043CD97F7F2BA6CAE0BF1B298D2A")

static final int TRANSACTION_verifyPendingInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 78);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.402 -0500", hash_original_field = "51CCA2CD2450806C05B2CA83D9965D26", hash_generated_field = "A5F70D5D264109E817BD7C2B2815D210")

static final int TRANSACTION_getVerifierDeviceIdentity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 79);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:47.404 -0500", hash_original_field = "CCEDF607D65ED931732C5187CCBD0186", hash_generated_field = "136D5993C3F61B23A500EA4990D40ACA")

static final int TRANSACTION_isFirstBoot = (android.os.IBinder.FIRST_CALL_TRANSACTION + 80);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.919 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.924 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:46.943 -0500", hash_original_method = "982ED5337DCDF0DAF3049B946D0D0963", hash_generated_method = "267F249CE419A1157A43E6EB238910C3")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getPackageInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.PackageInfo _result = this.getPackageInfo(_arg0, _arg1);
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
case TRANSACTION_getPackageUid:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getPackageUid(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getPackageGids:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int[] _result = this.getPackageGids(_arg0);
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
case TRANSACTION_currentToCanonicalPackageNames:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
java.lang.String[] _result = this.currentToCanonicalPackageNames(_arg0);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_canonicalToCurrentPackageNames:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
java.lang.String[] _result = this.canonicalToCurrentPackageNames(_arg0);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getPermissionInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.PermissionInfo _result = this.getPermissionInfo(_arg0, _arg1);
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
case TRANSACTION_queryPermissionsByGroup:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.util.List<android.content.pm.PermissionInfo> _result = this.queryPermissionsByGroup(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getPermissionGroupInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.PermissionGroupInfo _result = this.getPermissionGroupInfo(_arg0, _arg1);
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
case TRANSACTION_getAllPermissionGroups:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<android.content.pm.PermissionGroupInfo> _result = this.getAllPermissionGroups(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getApplicationInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.ApplicationInfo _result = this.getApplicationInfo(_arg0, _arg1);
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
case TRANSACTION_getActivityInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.pm.ActivityInfo _result = this.getActivityInfo(_arg0, _arg1);
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
case TRANSACTION_getReceiverInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.pm.ActivityInfo _result = this.getReceiverInfo(_arg0, _arg1);
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
case TRANSACTION_getServiceInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.pm.ServiceInfo _result = this.getServiceInfo(_arg0, _arg1);
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
case TRANSACTION_getProviderInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.pm.ProviderInfo _result = this.getProviderInfo(_arg0, _arg1);
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
case TRANSACTION_checkPermission:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.checkPermission(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_checkUidPermission:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _result = this.checkUidPermission(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_addPermission:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.PermissionInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.PermissionInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.addPermission(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_removePermission:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.removePermission(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isProtectedBroadcast:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isProtectedBroadcast(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_checkSignatures:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.checkSignatures(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_checkUidSignatures:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.checkUidSignatures(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getPackagesForUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String[] _result = this.getPackagesForUid(_arg0);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getNameForUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.getNameForUid(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getUidForSharedUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getUidForSharedUser(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_resolveIntent:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ResolveInfo _result = this.resolveIntent(_arg0, _arg1, _arg2);
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
case TRANSACTION_queryIntentActivities:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
java.util.List<android.content.pm.ResolveInfo> _result = this.queryIntentActivities(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_queryIntentActivityOptions:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.Intent[] _arg1;
_arg1 = data.createTypedArray(android.content.Intent.CREATOR);
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
android.content.Intent _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
java.lang.String _arg4;
_arg4 = data.readString();
int _arg5;
_arg5 = data.readInt();
java.util.List<android.content.pm.ResolveInfo> _result = this.queryIntentActivityOptions(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_queryIntentReceivers:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
java.util.List<android.content.pm.ResolveInfo> _result = this.queryIntentReceivers(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_resolveService:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ResolveInfo _result = this.resolveService(_arg0, _arg1, _arg2);
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
case TRANSACTION_queryIntentServices:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
java.util.List<android.content.pm.ResolveInfo> _result = this.queryIntentServices(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getInstalledPackages:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
android.content.pm.ParceledListSlice _result = this.getInstalledPackages(_arg0, _arg1);
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
case TRANSACTION_getInstalledApplications:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
android.content.pm.ParceledListSlice _result = this.getInstalledApplications(_arg0, _arg1);
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
case TRANSACTION_getPersistentApplications:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<android.content.pm.ApplicationInfo> _result = this.getPersistentApplications(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_resolveContentProvider:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.ProviderInfo _result = this.resolveContentProvider(_arg0, _arg1);
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
case TRANSACTION_querySyncProviders:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<java.lang.String> _arg0;
_arg0 = data.createStringArrayList();
java.util.List<android.content.pm.ProviderInfo> _arg1;
_arg1 = data.createTypedArrayList(android.content.pm.ProviderInfo.CREATOR);
this.querySyncProviders(_arg0, _arg1);
reply.writeNoException();
reply.writeStringList(_arg0);
reply.writeTypedList(_arg1);
return true;
}
case TRANSACTION_queryContentProviders:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
java.util.List<android.content.pm.ProviderInfo> _result = this.queryContentProviders(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getInstrumentationInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.pm.InstrumentationInfo _result = this.getInstrumentationInfo(_arg0, _arg1);
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
case TRANSACTION_queryInstrumentation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.util.List<android.content.pm.InstrumentationInfo> _result = this.queryInstrumentation(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_installPackage:
{
data.enforceInterface(DESCRIPTOR);
android.net.Uri _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.Uri.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.pm.IPackageInstallObserver _arg1;
_arg1 = android.content.pm.IPackageInstallObserver.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
java.lang.String _arg3;
_arg3 = data.readString();
this.installPackage(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_finishPackageInstall:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.finishPackageInstall(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setInstallerPackageName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.setInstallerPackageName(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_deletePackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.IPackageDeleteObserver _arg1;
_arg1 = android.content.pm.IPackageDeleteObserver.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
this.deletePackage(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getInstallerPackageName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.getInstallerPackageName(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_addPackageToPreferred:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.addPackageToPreferred(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removePackageFromPreferred:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.removePackageFromPreferred(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPreferredPackages:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<android.content.pm.PackageInfo> _result = this.getPreferredPackages(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_addPreferredActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.IntentFilter _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.IntentFilter.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.ComponentName[] _arg2;
_arg2 = data.createTypedArray(android.content.ComponentName.CREATOR);
android.content.ComponentName _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.addPreferredActivity(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_replacePreferredActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.IntentFilter _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.IntentFilter.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.ComponentName[] _arg2;
_arg2 = data.createTypedArray(android.content.ComponentName.CREATOR);
android.content.ComponentName _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.replacePreferredActivity(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_clearPackagePreferredActivities:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearPackagePreferredActivities(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPreferredActivities:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.content.IntentFilter> _arg0;
_arg0 = new java.util.ArrayList<android.content.IntentFilter>();
java.util.List<android.content.ComponentName> _arg1;
_arg1 = new java.util.ArrayList<android.content.ComponentName>();
java.lang.String _arg2;
_arg2 = data.readString();
int _result = this.getPreferredActivities(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
reply.writeTypedList(_arg0);
reply.writeTypedList(_arg1);
return true;
}
case TRANSACTION_setComponentEnabledSetting:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.setComponentEnabledSetting(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getComponentEnabledSetting:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getComponentEnabledSetting(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setApplicationEnabledSetting:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.setApplicationEnabledSetting(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getApplicationEnabledSetting:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getApplicationEnabledSetting(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPackageStoppedState:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setPackageStoppedState(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_freeStorageAndNotify:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
android.content.pm.IPackageDataObserver _arg1;
_arg1 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
this.freeStorageAndNotify(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_freeStorage:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
android.content.IntentSender _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.IntentSender.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.freeStorage(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_deleteApplicationCacheFiles:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.IPackageDataObserver _arg1;
_arg1 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
this.deleteApplicationCacheFiles(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_clearApplicationUserData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.IPackageDataObserver _arg1;
_arg1 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
this.clearApplicationUserData(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPackageSizeInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.IPackageStatsObserver _arg1;
_arg1 = android.content.pm.IPackageStatsObserver.Stub.asInterface(data.readStrongBinder());
this.getPackageSizeInfo(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getSystemSharedLibraryNames:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getSystemSharedLibraryNames();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getSystemAvailableFeatures:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.FeatureInfo[] _result = this.getSystemAvailableFeatures();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_hasSystemFeature:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.hasSystemFeature(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enterSafeMode:
{
data.enforceInterface(DESCRIPTOR);
this.enterSafeMode();
reply.writeNoException();
return true;
}
case TRANSACTION_isSafeMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isSafeMode();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_systemReady:
{
data.enforceInterface(DESCRIPTOR);
this.systemReady();
reply.writeNoException();
return true;
}
case TRANSACTION_hasSystemUidErrors:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasSystemUidErrors();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_performBootDexOpt:
{
data.enforceInterface(DESCRIPTOR);
this.performBootDexOpt();
reply.writeNoException();
return true;
}
case TRANSACTION_performDexOpt:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.performDexOpt(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_updateExternalMediaStatus:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _arg1;
_arg1 = (0!=data.readInt());
this.updateExternalMediaStatus(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_nextPackageToClean:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.nextPackageToClean(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_movePackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.IPackageMoveObserver _arg1;
_arg1 = android.content.pm.IPackageMoveObserver.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
this.movePackage(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_addPermissionAsync:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.PermissionInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.PermissionInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.addPermissionAsync(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setInstallLocation:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setInstallLocation(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getInstallLocation:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getInstallLocation();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_createUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.UserInfo _result = this.createUser(_arg0, _arg1);
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
case TRANSACTION_removeUser:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.removeUser(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_installPackageWithVerification:
{
data.enforceInterface(DESCRIPTOR);
android.net.Uri _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.Uri.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.pm.IPackageInstallObserver _arg1;
_arg1 = android.content.pm.IPackageInstallObserver.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
java.lang.String _arg3;
_arg3 = data.readString();
android.net.Uri _arg4;
if ((0!=data.readInt())) {
_arg4 = android.net.Uri.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
android.content.pm.ManifestDigest _arg5;
if ((0!=data.readInt())) {
_arg5 = android.content.pm.ManifestDigest.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
this.installPackageWithVerification(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_verifyPendingInstall:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.verifyPendingInstall(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getVerifierDeviceIdentity:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.VerifierDeviceIdentity _result = this.getVerifierDeviceIdentity();
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
case TRANSACTION_isFirstBoot:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isFirstBoot();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public android.content.pm.PackageInfo getPackageInfo(java.lang.String packageName, int flags) throws android.os.RemoteException;
public int getPackageUid(java.lang.String packageName) throws android.os.RemoteException;
public int[] getPackageGids(java.lang.String packageName) throws android.os.RemoteException;
public java.lang.String[] currentToCanonicalPackageNames(java.lang.String[] names) throws android.os.RemoteException;
public java.lang.String[] canonicalToCurrentPackageNames(java.lang.String[] names) throws android.os.RemoteException;
public android.content.pm.PermissionInfo getPermissionInfo(java.lang.String name, int flags) throws android.os.RemoteException;
public java.util.List<android.content.pm.PermissionInfo> queryPermissionsByGroup(java.lang.String group, int flags) throws android.os.RemoteException;
public android.content.pm.PermissionGroupInfo getPermissionGroupInfo(java.lang.String name, int flags) throws android.os.RemoteException;
public java.util.List<android.content.pm.PermissionGroupInfo> getAllPermissionGroups(int flags) throws android.os.RemoteException;
public android.content.pm.ApplicationInfo getApplicationInfo(java.lang.String packageName, int flags) throws android.os.RemoteException;
public android.content.pm.ActivityInfo getActivityInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException;
public android.content.pm.ActivityInfo getReceiverInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException;
public android.content.pm.ServiceInfo getServiceInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException;
public android.content.pm.ProviderInfo getProviderInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException;
public int checkPermission(java.lang.String permName, java.lang.String pkgName) throws android.os.RemoteException;
public int checkUidPermission(java.lang.String permName, int uid) throws android.os.RemoteException;
public boolean addPermission(android.content.pm.PermissionInfo info) throws android.os.RemoteException;
public void removePermission(java.lang.String name) throws android.os.RemoteException;
public boolean isProtectedBroadcast(java.lang.String actionName) throws android.os.RemoteException;
public int checkSignatures(java.lang.String pkg1, java.lang.String pkg2) throws android.os.RemoteException;
public int checkUidSignatures(int uid1, int uid2) throws android.os.RemoteException;
public java.lang.String[] getPackagesForUid(int uid) throws android.os.RemoteException;
public java.lang.String getNameForUid(int uid) throws android.os.RemoteException;
public int getUidForSharedUser(java.lang.String sharedUserName) throws android.os.RemoteException;
public android.content.pm.ResolveInfo resolveIntent(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException;
public java.util.List<android.content.pm.ResolveInfo> queryIntentActivities(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException;
public java.util.List<android.content.pm.ResolveInfo> queryIntentActivityOptions(android.content.ComponentName caller, android.content.Intent[] specifics, java.lang.String[] specificTypes, android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException;
public java.util.List<android.content.pm.ResolveInfo> queryIntentReceivers(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException;
public android.content.pm.ResolveInfo resolveService(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException;
public java.util.List<android.content.pm.ResolveInfo> queryIntentServices(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException;

public android.content.pm.ParceledListSlice getInstalledPackages(int flags, java.lang.String lastRead) throws android.os.RemoteException;

public android.content.pm.ParceledListSlice getInstalledApplications(int flags, java.lang.String lastRead) throws android.os.RemoteException;

public java.util.List<android.content.pm.ApplicationInfo> getPersistentApplications(int flags) throws android.os.RemoteException;
public android.content.pm.ProviderInfo resolveContentProvider(java.lang.String name, int flags) throws android.os.RemoteException;

public void querySyncProviders(java.util.List<java.lang.String> outNames, java.util.List<android.content.pm.ProviderInfo> outInfo) throws android.os.RemoteException;
public java.util.List<android.content.pm.ProviderInfo> queryContentProviders(java.lang.String processName, int uid, int flags) throws android.os.RemoteException;
public android.content.pm.InstrumentationInfo getInstrumentationInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException;
public java.util.List<android.content.pm.InstrumentationInfo> queryInstrumentation(java.lang.String targetPackage, int flags) throws android.os.RemoteException;

public void installPackage(android.net.Uri packageURI, android.content.pm.IPackageInstallObserver observer, int flags, java.lang.String installerPackageName) throws android.os.RemoteException;
public void finishPackageInstall(int token) throws android.os.RemoteException;
public void setInstallerPackageName(java.lang.String targetPackage, java.lang.String installerPackageName) throws android.os.RemoteException;

public void deletePackage(java.lang.String packageName, android.content.pm.IPackageDeleteObserver observer, int flags) throws android.os.RemoteException;
public java.lang.String getInstallerPackageName(java.lang.String packageName) throws android.os.RemoteException;
public void addPackageToPreferred(java.lang.String packageName) throws android.os.RemoteException;
public void removePackageFromPreferred(java.lang.String packageName) throws android.os.RemoteException;
public java.util.List<android.content.pm.PackageInfo> getPreferredPackages(int flags) throws android.os.RemoteException;
public void addPreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity) throws android.os.RemoteException;
public void replacePreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity) throws android.os.RemoteException;
public void clearPackagePreferredActivities(java.lang.String packageName) throws android.os.RemoteException;
public int getPreferredActivities(java.util.List<android.content.IntentFilter> outFilters, java.util.List<android.content.ComponentName> outActivities, java.lang.String packageName) throws android.os.RemoteException;

public void setComponentEnabledSetting(android.content.ComponentName componentName, int newState, int flags) throws android.os.RemoteException;

public int getComponentEnabledSetting(android.content.ComponentName componentName) throws android.os.RemoteException;

public void setApplicationEnabledSetting(java.lang.String packageName, int newState, int flags) throws android.os.RemoteException;

public int getApplicationEnabledSetting(java.lang.String packageName) throws android.os.RemoteException;

public void setPackageStoppedState(java.lang.String packageName, boolean stopped) throws android.os.RemoteException;

public void freeStorageAndNotify(long freeStorageSize, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException;

public void freeStorage(long freeStorageSize, android.content.IntentSender pi) throws android.os.RemoteException;

public void deleteApplicationCacheFiles(java.lang.String packageName, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException;

public void clearApplicationUserData(java.lang.String packageName, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException;

public void getPackageSizeInfo(java.lang.String packageName, android.content.pm.IPackageStatsObserver observer) throws android.os.RemoteException;

public java.lang.String[] getSystemSharedLibraryNames() throws android.os.RemoteException;

public android.content.pm.FeatureInfo[] getSystemAvailableFeatures() throws android.os.RemoteException;
public boolean hasSystemFeature(java.lang.String name) throws android.os.RemoteException;
public void enterSafeMode() throws android.os.RemoteException;
public boolean isSafeMode() throws android.os.RemoteException;
public void systemReady() throws android.os.RemoteException;
public boolean hasSystemUidErrors() throws android.os.RemoteException;

public void performBootDexOpt() throws android.os.RemoteException;

public boolean performDexOpt(java.lang.String packageName) throws android.os.RemoteException;

public void updateExternalMediaStatus(boolean mounted, boolean reportStatus) throws android.os.RemoteException;
public java.lang.String nextPackageToClean(java.lang.String lastPackage) throws android.os.RemoteException;
public void movePackage(java.lang.String packageName, android.content.pm.IPackageMoveObserver observer, int flags) throws android.os.RemoteException;
public boolean addPermissionAsync(android.content.pm.PermissionInfo info) throws android.os.RemoteException;
public boolean setInstallLocation(int loc) throws android.os.RemoteException;
public int getInstallLocation() throws android.os.RemoteException;
public android.content.pm.UserInfo createUser(java.lang.String name, int flags) throws android.os.RemoteException;
public boolean removeUser(int userId) throws android.os.RemoteException;
public void installPackageWithVerification(android.net.Uri packageURI, android.content.pm.IPackageInstallObserver observer, int flags, java.lang.String installerPackageName, android.net.Uri verificationURI, android.content.pm.ManifestDigest manifestDigest) throws android.os.RemoteException;
public void verifyPendingInstall(int id, int verificationCode) throws android.os.RemoteException;
public android.content.pm.VerifierDeviceIdentity getVerifierDeviceIdentity() throws android.os.RemoteException;
public boolean isFirstBoot() throws android.os.RemoteException;
}
