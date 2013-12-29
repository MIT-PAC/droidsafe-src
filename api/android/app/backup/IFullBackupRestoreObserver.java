package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IFullBackupRestoreObserver extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.backup.IFullBackupRestoreObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.444 -0500", hash_original_field = "8D0FCC85A032E366A0690B1E335DB434", hash_generated_field = "6F61E88CAFE2DFAD701F9A45F51CD655")

private static final java.lang.String DESCRIPTOR = "android.app.backup.IFullBackupRestoreObserver";
/**
 * Cast an IBinder object into an android.app.backup.IFullBackupRestoreObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.446 -0500", hash_original_method = "30525B9DBD289D393D2F803812A36E0A", hash_generated_method = "6941F07E6DAF0E784A7523D0D5E06640")
        public static android.app.backup.IFullBackupRestoreObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.backup.IFullBackupRestoreObserver))) {
return ((android.app.backup.IFullBackupRestoreObserver)iin);
}
return new android.app.backup.IFullBackupRestoreObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.461 -0500", hash_original_field = "C2DDBD1E5077FC2E0B172F9D6167B26F", hash_generated_field = "5592ED714422FFC4DFB8FABDEB66677F")

static final int TRANSACTION_onStartBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.462 -0500", hash_original_field = "27385967D46FCAB6AB77972D7816C54F", hash_generated_field = "997DE75B7A1676BC25A1F4A71AC3E305")

static final int TRANSACTION_onBackupPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.463 -0500", hash_original_field = "34B27CD2B6A772D59CBADFAD78972B81", hash_generated_field = "01A5B13741F160A2B7270393C6D43F05")

static final int TRANSACTION_onEndBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.backup.IFullBackupRestoreObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.449 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.450 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.451 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.452 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Notification: a full backup operation has begun.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.453 -0500", hash_original_method = "09C4E744CC0748FDD30572905D1384BC", hash_generated_method = "A2DEFCC6CAA9E5EB5E1590D50013D524")
            public void onStartBackup() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onStartBackup, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Notification: the system has begun backing up the given package.
     *
     * @param name The name of the application being saved.  This will typically be a
     *     user-meaningful name such as "Browser" rather than a package name such as
     *     "com.android.browser", though this is not guaranteed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.454 -0500", hash_original_method = "F1831C1B069CC3452C1FD1444B4AD156", hash_generated_method = "68D908ABE319BD54983B406078E52AB9")
            public void onBackupPackage(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_onBackupPackage, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Notification: the full backup operation has ended.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.455 -0500", hash_original_method = "1C675E72760547DC2F4C1E8BA5671F27", hash_generated_method = "039740807119F25B9ED293C91331171E")
            public void onEndBackup() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onEndBackup, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Notification: a restore-from-full-backup operation has begun.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.456 -0500", hash_original_method = "D06D40808B609EF694070B76732D86FF", hash_generated_method = "4DDE5FBCA81499FF9DE24BF3895A50A4")
            public void onStartRestore() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onStartRestore, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Notification: the system has begun restore of the given package.
     *
     * @param name The name of the application being saved.  This will typically be a
     *     user-meaningful name such as "Browser" rather than a package name such as
     *     "com.android.browser", though this is not guaranteed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.457 -0500", hash_original_method = "BF9A8828D2C16C90EB4711EFB913DD94", hash_generated_method = "168EDBCE5F55CA8B63A1A27301E7CE20")
            public void onRestorePackage(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_onRestorePackage, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Notification: the restore-from-full-backup operation has ended.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.458 -0500", hash_original_method = "0D3193A2F89082FCD8029B6F27577E68", hash_generated_method = "AA18270CE5AE41ADD2B571066635E1DA")
            public void onEndRestore() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onEndRestore, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * The user's window of opportunity for confirming the operation has timed out.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.459 -0500", hash_original_method = "898DD290104790DEAB9DAE32E00C8AF0", hash_generated_method = "EFFB29D2B3C32B7B15B4D6CB03A763BA")
            public void onTimeout() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onTimeout, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.464 -0500", hash_original_field = "E579567140962152800F4F2F0E8E5C79", hash_generated_field = "41D979329973C4EFE7F90FB2EDC8E82E")

static final int TRANSACTION_onStartRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.464 -0500", hash_original_field = "FE95AA6A2E930A47A968F5853BCA3AAC", hash_generated_field = "C99768732F90B6F0888178A07C9DEC8D")

static final int TRANSACTION_onRestorePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.465 -0500", hash_original_field = "985A61F8889C1DD93D6F188377FD5F0C", hash_generated_field = "90C1842172C5F9AAFFA2DF4A131A36D5")

static final int TRANSACTION_onEndRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.466 -0500", hash_original_field = "7634D6D19D7F3E6FD6C31EBE332D05FF", hash_generated_field = "8E548DD646E57B10DF456C7797D18D0E")

static final int TRANSACTION_onTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.445 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.447 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.448 -0500", hash_original_method = "A0C4610EDE8D30B7777B3EB0F89E0F20", hash_generated_method = "CACDEE081C2B5989E86F4FADF9F08E48")
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
case TRANSACTION_onStartBackup:
{
data.enforceInterface(DESCRIPTOR);
this.onStartBackup();
return true;
}
case TRANSACTION_onBackupPackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onBackupPackage(_arg0);
return true;
}
case TRANSACTION_onEndBackup:
{
data.enforceInterface(DESCRIPTOR);
this.onEndBackup();
return true;
}
case TRANSACTION_onStartRestore:
{
data.enforceInterface(DESCRIPTOR);
this.onStartRestore();
return true;
}
case TRANSACTION_onRestorePackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onRestorePackage(_arg0);
return true;
}
case TRANSACTION_onEndRestore:
{
data.enforceInterface(DESCRIPTOR);
this.onEndRestore();
return true;
}
case TRANSACTION_onTimeout:
{
data.enforceInterface(DESCRIPTOR);
this.onTimeout();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void onStartBackup() throws android.os.RemoteException;

public void onBackupPackage(java.lang.String name) throws android.os.RemoteException;

public void onEndBackup() throws android.os.RemoteException;

public void onStartRestore() throws android.os.RemoteException;

public void onRestorePackage(java.lang.String name) throws android.os.RemoteException;

public void onEndRestore() throws android.os.RemoteException;

public void onTimeout() throws android.os.RemoteException;
}
