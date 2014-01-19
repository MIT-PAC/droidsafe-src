package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IBackupManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.backup.IBackupManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.375 -0500", hash_original_field = "820ED0B5DCE864C905A185D16BA0B405", hash_generated_field = "C1E024CEBFEDF6C7260BB71084863D3C")

private static final java.lang.String DESCRIPTOR = "android.app.backup.IBackupManager";
/**
 * Cast an IBinder object into an android.app.backup.IBackupManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.380 -0500", hash_original_method = "727593CA0692F85427A1C15BA56C2B4B", hash_generated_method = "0C8C03E88D4B95D98295B631D4BE54C5")
        
public static android.app.backup.IBackupManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.backup.IBackupManager))) {
return ((android.app.backup.IBackupManager)iin);
}
return new android.app.backup.IBackupManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.469 -0500", hash_original_field = "079037341F6A0A3146DAB5315F3AB698", hash_generated_field = "FD1964580AC94236ACC93699D7FB1A8E")

static final int TRANSACTION_dataChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.472 -0500", hash_original_field = "462433525F8EAEE39D4BC94613972A4D", hash_generated_field = "B7CD715B6F4CD5C19AC1AF78C1BF5257")

static final int TRANSACTION_clearBackupData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.474 -0500", hash_original_field = "943E565A796792D075B1F11A421CC57D", hash_generated_field = "434CB3667BDA7034573F0C289453974B")

static final int TRANSACTION_agentConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.backup.IBackupManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.393 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.396 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.398 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.400 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Tell the system service that the caller has made changes to its
     * data, and therefore needs to undergo an incremental backup pass.
     *
     * Any application can invoke this method for its own package, but
     * only callers who hold the android.permission.BACKUP permission
     * may invoke it for arbitrary packages.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.402 -0500", hash_original_method = "18BE60F292FCF675BADDD27D49A225A7", hash_generated_method = "9A9A1EFF4CFCBA85172CBAA885FC50FC")
            
public void dataChanged(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_dataChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Erase all backed-up data for the given package from the storage
     * destination.
     *
     * Any application can invoke this method for its own package, but
     * only callers who hold the android.permission.BACKUP permission
     * may invoke it for arbitrary packages.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.405 -0500", hash_original_method = "BFE969117C6C9413340434F6942C991A", hash_generated_method = "69831E4420E6F023FE5F77A4F1EAD212")
            
public void clearBackupData(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_clearBackupData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Notifies the Backup Manager Service that an agent has become available.  This
     * method is only invoked by the Activity Manager.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.407 -0500", hash_original_method = "EF46CF74562230DAF571268DE698C169", hash_generated_method = "0D415A9D85E8A5AEA79C64383C3FE050")
            
public void agentConnected(java.lang.String packageName, android.os.IBinder agent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder(agent);
mRemote.transact(Stub.TRANSACTION_agentConnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Notify the Backup Manager Service that an agent has unexpectedly gone away.
     * This method is only invoked by the Activity Manager.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.410 -0500", hash_original_method = "79DD87326CB0F083542B55A92241E0EE", hash_generated_method = "4E18127C5E492029832F0636F75D60F6")
            
public void agentDisconnected(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_agentDisconnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Notify the Backup Manager Service that an application being installed will
     * need a data-restore pass.  This method is only invoked by the Package Manager.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.413 -0500", hash_original_method = "4363D4D6F1C5E17E83A281115201A491", hash_generated_method = "65966835C9899AC34AA7F677FDCB051C")
            
public void restoreAtInstall(java.lang.String packageName, int token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(token);
mRemote.transact(Stub.TRANSACTION_restoreAtInstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Enable/disable the backup service entirely.  When disabled, no backup
     * or restore operations will take place.  Data-changed notifications will
     * still be observed and collected, however, so that changes made while the
     * mechanism was disabled will still be backed up properly if it is enabled
     * at some point in the future.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.416 -0500", hash_original_method = "0AEDE126CAFEBAF41FE8F99E5E992A0A", hash_generated_method = "A0A4745C52F3706F1CFBB71A340208A9")
            
public void setBackupEnabled(boolean isEnabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isEnabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setBackupEnabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Enable/disable automatic restore of application data at install time.  When
     * enabled, installation of any package will involve the Backup Manager.  If data
     * exists for the newly-installed package, either from the device's current [enabled]
     * backup dataset or from the restore set used in the last wholesale restore operation,
     * that data will be supplied to the new package's restore agent before the package
     * is made generally available for launch.
     *
     * <p>Callers must hold  the android.permission.BACKUP permission to use this method.
     *
     * @param doAutoRestore When true, enables the automatic app-data restore facility.  When
     *   false, this facility will be disabled.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.418 -0500", hash_original_method = "B245B0B2519FD27C96527833CDEDD540", hash_generated_method = "C410B96C01EA99C6B554A4B78651380A")
            
public void setAutoRestore(boolean doAutoRestore) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((doAutoRestore)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setAutoRestore, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Indicate that any necessary one-time provisioning has occurred.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.421 -0500", hash_original_method = "171D395EB68162B6953EA057D5E4B3B4", hash_generated_method = "D35BCFBC33B7CA7F7EC0EB1974315563")
            
public void setBackupProvisioned(boolean isProvisioned) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isProvisioned)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setBackupProvisioned, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Report whether the backup mechanism is currently enabled.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.424 -0500", hash_original_method = "784F0C015576D693E65219DB30EACC8C", hash_generated_method = "FCB13AD4493279B9E7D55FD5EC1C3A2C")
            
public boolean isBackupEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isBackupEnabled, _data, _reply, 0);
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
     * Set the device's backup password.  Returns {@code true} if the password was set
     * successfully, {@code false} otherwise.  Typically a failure means that an incorrect
     * current password was supplied.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.426 -0500", hash_original_method = "298C32D82EC8238149BA9E41FBCF1BEB", hash_generated_method = "3F6A457AFD669779C206E93E39BD37DC")
            
public boolean setBackupPassword(java.lang.String currentPw, java.lang.String newPw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(currentPw);
_data.writeString(newPw);
mRemote.transact(Stub.TRANSACTION_setBackupPassword, _data, _reply, 0);
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
     * Reports whether a backup password is currently set.  If not, then a null or empty
     * "current password" argument should be passed to setBackupPassword().
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.429 -0500", hash_original_method = "BD553320542568A7CB679FEDE4E6BD52", hash_generated_method = "DBA0751A7AB76600213A386CF5D2E933")
            
public boolean hasBackupPassword() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hasBackupPassword, _data, _reply, 0);
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
     * Schedule an immediate backup attempt for all pending updates.  This is
     * primarily intended for transports to use when they detect a suitable
     * opportunity for doing a backup pass.  If there are no pending updates to
     * be sent, no action will be taken.  Even if some updates are pending, the
     * transport will still be asked to confirm via the usual requestBackupTime()
     * method.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.432 -0500", hash_original_method = "EFEF4282071706B836A68E273E5076A5", hash_generated_method = "D06A3D0A8B9BB3C84AD33859944EC3F0")
            
public void backupNow() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_backupNow, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Write a full backup of the given package to the supplied file descriptor.
     * The fd may be a socket or other non-seekable destination.  If no package names
     * are supplied, then every application on the device will be backed up to the output.
     *
     * <p>This method is <i>synchronous</i> -- it does not return until the backup has
     * completed.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     *
     * @param fd The file descriptor to which a 'tar' file stream is to be written
     * @param includeApks If <code>true</code>, the resulting tar stream will include the
     *     application .apk files themselves as well as their data.
     * @param includeShared If <code>true</code>, the resulting tar stream will include
     *     the contents of the device's shared storage (SD card or equivalent).
     * @param allApps If <code>true</code>, the resulting tar stream will include all
     *     installed applications' data, not just those named in the <code>packageNames</code>
     *     parameter.
     * @param allIncludesSystem If {@code true}, then {@code allApps} will be interpreted
     *     as including packages pre-installed as part of the system. If {@code false},
     *     then setting {@code allApps} to {@code true} will mean only that all 3rd-party
     *     applications will be included in the dataset.
     * @param packageNames The package names of the apps whose data (and optionally .apk files)
     *     are to be backed up.  The <code>allApps</code> parameter supersedes this.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.435 -0500", hash_original_method = "B085B15808BB89C263DEC4695E36D6FF", hash_generated_method = "B0D4305787E551C697B0B0ABED1D7514")
            
public void fullBackup(android.os.ParcelFileDescriptor fd, boolean includeApks, boolean includeShared, boolean allApps, boolean allIncludesSystem, java.lang.String[] packageNames) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((fd!=null)) {
_data.writeInt(1);
fd.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((includeApks)?(1):(0)));
_data.writeInt(((includeShared)?(1):(0)));
_data.writeInt(((allApps)?(1):(0)));
_data.writeInt(((allIncludesSystem)?(1):(0)));
_data.writeStringArray(packageNames);
mRemote.transact(Stub.TRANSACTION_fullBackup, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Restore device content from the data stream passed through the given socket.  The
     * data stream must be in the format emitted by fullBackup().
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.438 -0500", hash_original_method = "96EAE0305BBB23CF5E02A5267DB44A64", hash_generated_method = "3B9B1843FFBFB3F3AFA6D24D1569D3DE")
            
public void fullRestore(android.os.ParcelFileDescriptor fd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((fd!=null)) {
_data.writeInt(1);
fd.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_fullRestore, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Confirm that the requested full backup/restore operation can proceed.  The system will
     * not actually perform the operation described to fullBackup() / fullRestore() unless the
     * UI calls back into the Backup Manager to confirm, passing the correct token.  At
     * the same time, the UI supplies a callback Binder for progress notifications during
     * the operation.
     *
     * <p>The password passed by the confirming entity must match the saved backup or
     * full-device encryption password in order to perform a backup.  If a password is
     * supplied for restore, it must match the password used when creating the full
     * backup dataset being used for restore.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.441 -0500", hash_original_method = "D22D08573CE9B47E8ABB517223739945", hash_generated_method = "E8D7D426F8FEF735709DBD471B4B888F")
            
public void acknowledgeFullBackupOrRestore(int token, boolean allow, java.lang.String curPassword, java.lang.String encryptionPassword, android.app.backup.IFullBackupRestoreObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(token);
_data.writeInt(((allow)?(1):(0)));
_data.writeString(curPassword);
_data.writeString(encryptionPassword);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_acknowledgeFullBackupOrRestore, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Identify the currently selected transport.  Callers must hold the
     * android.permission.BACKUP permission to use this method.
     */
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.443 -0500", hash_original_method = "E6BEF60268F9B787EF84D6AA81C4800E", hash_generated_method = "989A63C854AF4A9BBB7DB6176ABAE99F")
            
public java.lang.String getCurrentTransport() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentTransport, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Request a list of all available backup transports' names.  Callers must
     * hold the android.permission.BACKUP permission to use this method.
     */
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.446 -0500", hash_original_method = "7381354AF1E93FF8E17E3709ED2490B1", hash_generated_method = "63031197FBB2D5B0E2ACEDB2225C8A4A")
            
public java.lang.String[] listAllTransports() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_listAllTransports, _data, _reply, 0);
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
     * Specify the current backup transport.  Callers must hold the
     * android.permission.BACKUP permission to use this method.
     *
     * @param transport The name of the transport to select.  This should be one
     * of {@link BackupManager.TRANSPORT_GOOGLE} or {@link BackupManager.TRANSPORT_ADB}.
     * @return The name of the previously selected transport.  If the given transport
     *   name is not one of the currently available transports, no change is made to
     *   the current transport setting and the method returns null.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.448 -0500", hash_original_method = "E51351C2829E900ED71C1941D72EB81E", hash_generated_method = "784FA7290B29488CF9A3889C87F8EBF7")
            
public java.lang.String selectBackupTransport(java.lang.String transport) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(transport);
mRemote.transact(Stub.TRANSACTION_selectBackupTransport, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Get the configuration Intent, if any, from the given transport.  Callers must
     * hold the android.permission.BACKUP permission in order to use this method.
     *
     * @param transport The name of the transport to query.
     * @return An Intent to use with Activity#startActivity() to bring up the configuration
     *   UI supplied by the transport.  If the transport has no configuration UI, it should
     *   return {@code null} here.
     */
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.451 -0500", hash_original_method = "BA19851F6D06D18DC0B278533C6E94E2", hash_generated_method = "F79C558F140F5688F1EB644F2734766B")
            
public android.content.Intent getConfigurationIntent(java.lang.String transport) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.Intent _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(transport);
mRemote.transact(Stub.TRANSACTION_getConfigurationIntent, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.Intent.CREATOR.createFromParcel(_reply);
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
     * Get the destination string supplied by the given transport.  Callers must
     * hold the android.permission.BACKUP permission in order to use this method.
     *
     * @param transport The name of the transport to query.
     * @return A string describing the current backup destination.  This string is used
     *   verbatim by the Settings UI as the summary text of the "configure..." item.
     */
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.454 -0500", hash_original_method = "17F9B82413A8349C579407FE79FB69FF", hash_generated_method = "72B8AE52626B17CA690E220F1DE49543")
            
public java.lang.String getDestinationString(java.lang.String transport) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(transport);
mRemote.transact(Stub.TRANSACTION_getDestinationString, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Begin a restore session.  Either or both of packageName and transportID
     * may be null.  If packageName is non-null, then only the given package will be
     * considered for restore.  If transportID is null, then the restore will use
     * the current active transport.
     * <p>
     * This method requires the android.permission.BACKUP permission <i>except</i>
     * when transportID is null and packageName is the name of the caller's own
     * package.  In that case, the restore session returned is suitable for supporting
     * the BackupManager.requestRestore() functionality via RestoreSession.restorePackage()
     * without requiring the app to hold any special permission.
     *
     * @param packageName The name of the single package for which a restore will
     *        be requested.  May be null, in which case all packages in the restore
     *        set can be restored.
     * @param transportID The name of the transport to use for the restore operation.
     *        May be null, in which case the current active transport is used.
     * @return An interface to the restore session, or null on error.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.457 -0500", hash_original_method = "259FC444CDACE3FDF209755A3B095F42", hash_generated_method = "40A34159BBC266A24A4F6909B3F70D64")
            
public android.app.backup.IRestoreSession beginRestoreSession(java.lang.String packageName, java.lang.String transportID) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.app.backup.IRestoreSession _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeString(transportID);
mRemote.transact(Stub.TRANSACTION_beginRestoreSession, _data, _reply, 0);
_reply.readException();
_result = android.app.backup.IRestoreSession.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Notify the backup manager that a BackupAgent has completed the operation
     * corresponding to the given token.
     *
     * @param token The transaction token passed to a BackupAgent's doBackup() or
     *        doRestore() method.
     * {@hide}
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.460 -0500", hash_original_method = "22E957B296D0F1EA85120A706CE841EA", hash_generated_method = "B2993E67E0688FBE9E4BA03617041409")
            
public void opComplete(int token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(token);
mRemote.transact(Stub.TRANSACTION_opComplete, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.477 -0500", hash_original_field = "FD0EAFA70A5C1DC303B10C353B120F93", hash_generated_field = "9D257289E407D44B2D1C1F82ECEB9F5B")

static final int TRANSACTION_agentDisconnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.479 -0500", hash_original_field = "2B0A822FCA825C65B6B936D7DB3045AF", hash_generated_field = "B83303279995D4C1705CAC11903D5FE1")

static final int TRANSACTION_restoreAtInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.482 -0500", hash_original_field = "51E7B4B617C292199C8E75C02851BB4C", hash_generated_field = "2B46BC67A302EB236B7160559791648D")

static final int TRANSACTION_setBackupEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.485 -0500", hash_original_field = "3FC52062537F7ABF867F0E0BF0B7F7BE", hash_generated_field = "F3A17111A4F81C59E0E8BDF2C5726A05")

static final int TRANSACTION_setAutoRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.487 -0500", hash_original_field = "A891C496868EC27D7EE436E652AEBC7E", hash_generated_field = "8E9D9BB226B2676248C705C0B332C2F3")

static final int TRANSACTION_setBackupProvisioned = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.490 -0500", hash_original_field = "F88EB7067ED787C1450CFC33F92A5F0E", hash_generated_field = "C0265E632EC7F6C478CFACC395F379B3")

static final int TRANSACTION_isBackupEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.492 -0500", hash_original_field = "3017DBA4A18C85CE0594A36AED2BC51D", hash_generated_field = "B2463A550520658025EEDC61AE6345D1")

static final int TRANSACTION_setBackupPassword = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.494 -0500", hash_original_field = "4EF8DEDC2B51BB6E754ED399E0F639BB", hash_generated_field = "B3646974DE5520D0FC689884123DEBF2")

static final int TRANSACTION_hasBackupPassword = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.497 -0500", hash_original_field = "F8A06386DDEE11AEEAB1F5D32687B016", hash_generated_field = "660DC1AF242A67E27FE51791ED90DF8A")

static final int TRANSACTION_backupNow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.499 -0500", hash_original_field = "750E0CB4FFB53B85A8D07177C32DC9E7", hash_generated_field = "E29500FBEC5231925540EF78B792A404")

static final int TRANSACTION_fullBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.502 -0500", hash_original_field = "A2681E14B886285423EFB43D27809665", hash_generated_field = "1C0E0C55BE16111337FEE05071487DB9")

static final int TRANSACTION_fullRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.504 -0500", hash_original_field = "97EA6C5E1109B6F2B50F53C5653F0E99", hash_generated_field = "73599BDF3A3F3640B82904A583FC6EE3")

static final int TRANSACTION_acknowledgeFullBackupOrRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.507 -0500", hash_original_field = "5DA6BFD2A2B011094E427CA725362A31", hash_generated_field = "B4F211501E6ACBEE1BB3D5583A22C7FB")

static final int TRANSACTION_getCurrentTransport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.509 -0500", hash_original_field = "4137B42BD2E9987C6E9980E32BAABC6F", hash_generated_field = "9400291F61F1B3115A5AD9B485A0F6EF")

static final int TRANSACTION_listAllTransports = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.512 -0500", hash_original_field = "B859EE0FA9CAD2FA9894B94659400431", hash_generated_field = "5AF903514F0C80DF3D861A8A19552FDE")

static final int TRANSACTION_selectBackupTransport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.515 -0500", hash_original_field = "59C1A7D7AD99DEF37A4B3F709DB2CA00", hash_generated_field = "67882C9C4F7E0894CA3B144A9972BEA9")

static final int TRANSACTION_getConfigurationIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.517 -0500", hash_original_field = "437304125B67A4F6DE79E2E2E385659B", hash_generated_field = "718D3F52655FF4E8BEF835479145D4B2")

static final int TRANSACTION_getDestinationString = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.519 -0500", hash_original_field = "19ECAFD61E11E8528FF37920F708FBCD", hash_generated_field = "50843FFED1DD040511AA55A8CA36F78D")

static final int TRANSACTION_beginRestoreSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.522 -0500", hash_original_field = "050A47CA15C49D44197399366E294035", hash_generated_field = "CB465D23306D35592A0171819978417A")

static final int TRANSACTION_opComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.378 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.383 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.390 -0500", hash_original_method = "18AFB37077DC14752C6C154F188A82B6", hash_generated_method = "E9EC155D58D8BC0956C2121D4CD6626A")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_dataChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.dataChanged(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_clearBackupData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearBackupData(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_agentConnected:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
this.agentConnected(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_agentDisconnected:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.agentDisconnected(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_restoreAtInstall:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.restoreAtInstall(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setBackupEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setBackupEnabled(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setAutoRestore:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setAutoRestore(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setBackupProvisioned:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setBackupProvisioned(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isBackupEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isBackupEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setBackupPassword:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.setBackupPassword(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_hasBackupPassword:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasBackupPassword();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_backupNow:
{
data.enforceInterface(DESCRIPTOR);
this.backupNow();
reply.writeNoException();
return true;
}
case TRANSACTION_fullBackup:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _arg4;
_arg4 = (0!=data.readInt());
java.lang.String[] _arg5;
_arg5 = data.createStringArray();
this.fullBackup(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_fullRestore:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.fullRestore(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_acknowledgeFullBackupOrRestore:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
android.app.backup.IFullBackupRestoreObserver _arg4;
_arg4 = android.app.backup.IFullBackupRestoreObserver.Stub.asInterface(data.readStrongBinder());
this.acknowledgeFullBackupOrRestore(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_getCurrentTransport:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCurrentTransport();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_listAllTransports:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.listAllTransports();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_selectBackupTransport:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.selectBackupTransport(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getConfigurationIntent:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.Intent _result = this.getConfigurationIntent(_arg0);
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
case TRANSACTION_getDestinationString:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.getDestinationString(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_beginRestoreSession:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
android.app.backup.IRestoreSession _result = this.beginRestoreSession(_arg0, _arg1);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_opComplete:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.opComplete(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void dataChanged(java.lang.String packageName) throws android.os.RemoteException;

public void clearBackupData(java.lang.String packageName) throws android.os.RemoteException;

public void agentConnected(java.lang.String packageName, android.os.IBinder agent) throws android.os.RemoteException;

public void agentDisconnected(java.lang.String packageName) throws android.os.RemoteException;

public void restoreAtInstall(java.lang.String packageName, int token) throws android.os.RemoteException;

public void setBackupEnabled(boolean isEnabled) throws android.os.RemoteException;

public void setAutoRestore(boolean doAutoRestore) throws android.os.RemoteException;

public void setBackupProvisioned(boolean isProvisioned) throws android.os.RemoteException;

public boolean isBackupEnabled() throws android.os.RemoteException;

public boolean setBackupPassword(java.lang.String currentPw, java.lang.String newPw) throws android.os.RemoteException;

public boolean hasBackupPassword() throws android.os.RemoteException;

public void backupNow() throws android.os.RemoteException;

public void fullBackup(android.os.ParcelFileDescriptor fd, boolean includeApks, boolean includeShared, boolean allApps, boolean allIncludesSystem, java.lang.String[] packageNames) throws android.os.RemoteException;

public void fullRestore(android.os.ParcelFileDescriptor fd) throws android.os.RemoteException;

public void acknowledgeFullBackupOrRestore(int token, boolean allow, java.lang.String curPassword, java.lang.String encryptionPassword, android.app.backup.IFullBackupRestoreObserver observer) throws android.os.RemoteException;

public java.lang.String getCurrentTransport() throws android.os.RemoteException;

public java.lang.String[] listAllTransports() throws android.os.RemoteException;

public java.lang.String selectBackupTransport(java.lang.String transport) throws android.os.RemoteException;

public android.content.Intent getConfigurationIntent(java.lang.String transport) throws android.os.RemoteException;

public java.lang.String getDestinationString(java.lang.String transport) throws android.os.RemoteException;

public android.app.backup.IRestoreSession beginRestoreSession(java.lang.String packageName, java.lang.String transportID) throws android.os.RemoteException;

public void opComplete(int token) throws android.os.RemoteException;
}
