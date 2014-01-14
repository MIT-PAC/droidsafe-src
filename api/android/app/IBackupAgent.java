package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IBackupAgent extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IBackupAgent
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.808 -0500", hash_original_field = "C4EA7B0066D185653E8215E0774349EB", hash_generated_field = "94C90B7D985F988AD9D50D2773E63F04")

private static final java.lang.String DESCRIPTOR = "android.app.IBackupAgent";
/**
 * Cast an IBinder object into an android.app.IBackupAgent interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.813 -0500", hash_original_method = "B5107667657B788E6D47DDCB504EEBFC", hash_generated_method = "74C4B5908B4E3B416A2E02EABF3E8CB9")
        
public static android.app.IBackupAgent asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IBackupAgent))) {
return ((android.app.IBackupAgent)iin);
}
return new android.app.IBackupAgent.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.848 -0500", hash_original_field = "107EDED27A916576BCF971B396D16C7B", hash_generated_field = "4763C4D5F545C3BD04F98B9F8FE7B858")

static final int TRANSACTION_doBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.851 -0500", hash_original_field = "D8FFBC7C23BD5BC18F0AB77DE14DA638", hash_generated_field = "C80B7ABB6E607065769EB698B528AA04")

static final int TRANSACTION_doRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.853 -0500", hash_original_field = "20576963DC2FA02ED0176A9E16403DF3", hash_generated_field = "7A6BEF41047FE745702A2B6CF9BC612E")

static final int TRANSACTION_doFullBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.IBackupAgent
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.823 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.826 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.829 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.831 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Request that the app perform an incremental backup.
     *
     * @param oldState Read-only file containing the description blob of the
     *        app's data state as of the last backup operation's completion.
     *        This file is empty or invalid when a full backup is being
     *        requested.
     *
     * @param data Read-write file, empty when onBackup() is called, that
     *        is the data destination for this backup pass's incrementals.
     *
     * @param newState Read-write file, empty when onBackup() is called,
     *        where the new state blob is to be recorded.
     *
     * @param token Opaque token identifying this transaction.  This must
     *        be echoed back to the backup service binder once the new
     *        data has been written to the data and newState files.
     *
     * @param callbackBinder Binder on which to indicate operation completion,
     *        passed here as a convenience to the agent.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.834 -0500", hash_original_method = "38ABAE47777CD71C1332151525EBB98A", hash_generated_method = "8FF34B5C1D8AB6EE6FDF5F950A6AAC68")
            
public void doBackup(android.os.ParcelFileDescriptor oldState, android.os.ParcelFileDescriptor data, android.os.ParcelFileDescriptor newState, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((oldState!=null)) {
_data.writeInt(1);
oldState.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((data!=null)) {
_data.writeInt(1);
data.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((newState!=null)) {
_data.writeInt(1);
newState.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(token);
_data.writeStrongBinder((((callbackBinder!=null))?(callbackBinder.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_doBackup, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Restore an entire data snapshot to the application.
     *
     * @param data Read-only file containing the full data snapshot of the
     *        app's backup.  This is to be a <i>replacement</i> of the app's
     *        current data, not to be merged into it.
     *
     * @param appVersionCode The android:versionCode attribute of the application
     *        that created this data set.  This can help the agent distinguish among
     *        various historical backup content possibilities.
     *
     * @param newState Read-write file, empty when onRestore() is called,
     *        that is to be written with the state description that holds after
     *        the restore has been completed.
     *
     * @param token Opaque token identifying this transaction.  This must
     *        be echoed back to the backup service binder once the agent is
     *        finished restoring the application based on the restore data
     *        contents.
     *
     * @param callbackBinder Binder on which to indicate operation completion,
     *        passed here as a convenience to the agent.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.837 -0500", hash_original_method = "FFB5D5D99D1A7509F9DFEC38FD442FF1", hash_generated_method = "2436B2A4685505A8F1AA31E1666D2C10")
            
public void doRestore(android.os.ParcelFileDescriptor data, int appVersionCode, android.os.ParcelFileDescriptor newState, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((data!=null)) {
_data.writeInt(1);
data.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(appVersionCode);
if ((newState!=null)) {
_data.writeInt(1);
newState.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(token);
_data.writeStrongBinder((((callbackBinder!=null))?(callbackBinder.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_doRestore, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Perform a "full" backup to the given file descriptor.  The output file is presumed
     * to be a socket or other non-seekable, write-only data sink.  When this method is
     * called, the app should write all of its files to the output.
     *
     * @param data Write-only file to receive the backed-up file content stream.
     *        The data must be formatted correctly for the resulting archive to be
     *        legitimate, so that will be tightly controlled by the available API.
     *
     * @param token Opaque token identifying this transaction.  This must
     *        be echoed back to the backup service binder once the agent is
     *        finished restoring the application based on the restore data
     *        contents.
     *
     * @param callbackBinder Binder on which to indicate operation completion,
     *        passed here as a convenience to the agent.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.840 -0500", hash_original_method = "22EDF7CCC5F708029E8FA1B203B8B462", hash_generated_method = "142357608C81481A556CF9DEE820E75C")
            
public void doFullBackup(android.os.ParcelFileDescriptor data, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((data!=null)) {
_data.writeInt(1);
data.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(token);
_data.writeStrongBinder((((callbackBinder!=null))?(callbackBinder.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_doFullBackup, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Restore a single "file" to the application.  The file was typically obtained from
     * a full-backup dataset.  The agent reads 'size' bytes of file content
     * from the provided file descriptor.
     *
     * @param data Read-only pipe delivering the file content itself.
     *
     * @param size Size of the file being restored.
     * @param type Type of file system entity, e.g. FullBackup.TYPE_DIRECTORY.
     * @param domain Name of the file's semantic domain to which the 'path' argument is a
     *        relative path.  e.g. FullBackup.DATABASE_TREE_TOKEN.
     * @param path Relative path of the file within its semantic domain.
     * @param mode Access mode of the file system entity, e.g. 0660.
     * @param mtime Last modification time of the file system entity.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.843 -0500", hash_original_method = "36E0B830C44AC9BF09E9AAE2B1E38A29", hash_generated_method = "51B161BB5959FF57E7A78ED8D6AD828A")
            
public void doRestoreFile(android.os.ParcelFileDescriptor data, long size, int type, java.lang.String domain, java.lang.String path, long mode, long mtime, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((data!=null)) {
_data.writeInt(1);
data.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(size);
_data.writeInt(type);
_data.writeString(domain);
_data.writeString(path);
_data.writeLong(mode);
_data.writeLong(mtime);
_data.writeInt(token);
_data.writeStrongBinder((((callbackBinder!=null))?(callbackBinder.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_doRestoreFile, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.856 -0500", hash_original_field = "DB614B0ADA23E4F944329FAD860B8BBF", hash_generated_field = "43670B86D8AEA5BEEA2A16066B8D2CF1")

static final int TRANSACTION_doRestoreFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.811 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.815 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.820 -0500", hash_original_method = "0FBBB9C72847D8D32E64133847F60B84", hash_generated_method = "CEA2A0B706B6309DDB4A29837127E1E3")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_doBackup:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.ParcelFileDescriptor _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.os.ParcelFileDescriptor _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
android.app.backup.IBackupManager _arg4;
_arg4 = android.app.backup.IBackupManager.Stub.asInterface(data.readStrongBinder());
this.doBackup(_arg0, _arg1, _arg2, _arg3, _arg4);
return true;
}
case TRANSACTION_doRestore:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.os.ParcelFileDescriptor _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
android.app.backup.IBackupManager _arg4;
_arg4 = android.app.backup.IBackupManager.Stub.asInterface(data.readStrongBinder());
this.doRestore(_arg0, _arg1, _arg2, _arg3, _arg4);
return true;
}
case TRANSACTION_doFullBackup:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.app.backup.IBackupManager _arg2;
_arg2 = android.app.backup.IBackupManager.Stub.asInterface(data.readStrongBinder());
this.doFullBackup(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_doRestoreFile:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _arg1;
_arg1 = data.readLong();
int _arg2;
_arg2 = data.readInt();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
long _arg5;
_arg5 = data.readLong();
long _arg6;
_arg6 = data.readLong();
int _arg7;
_arg7 = data.readInt();
android.app.backup.IBackupManager _arg8;
_arg8 = android.app.backup.IBackupManager.Stub.asInterface(data.readStrongBinder());
this.doRestoreFile(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void doBackup(android.os.ParcelFileDescriptor oldState, android.os.ParcelFileDescriptor data, android.os.ParcelFileDescriptor newState, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException;

public void doRestore(android.os.ParcelFileDescriptor data, int appVersionCode, android.os.ParcelFileDescriptor newState, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException;

public void doFullBackup(android.os.ParcelFileDescriptor data, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException;

public void doRestoreFile(android.os.ParcelFileDescriptor data, long size, int type, java.lang.String domain, java.lang.String path, long mode, long mtime, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException;
}
