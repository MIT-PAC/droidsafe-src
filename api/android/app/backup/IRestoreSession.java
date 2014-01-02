package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IRestoreSession extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.backup.IRestoreSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.099 -0500", hash_original_field = "D62214A6BB796EEAF57F1B6F4F7D87C0", hash_generated_field = "A6EEEC64C4D3C9DC9E2726FFF06BEDDD")

private static final java.lang.String DESCRIPTOR = "android.app.backup.IRestoreSession";
/**
 * Cast an IBinder object into an android.app.backup.IRestoreSession interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.104 -0500", hash_original_method = "5178700368B834C23AD8ED25EB131849", hash_generated_method = "017AFFB83FA42B9A7CCB6289F0413C88")
        
public static android.app.backup.IRestoreSession asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.backup.IRestoreSession))) {
return ((android.app.backup.IRestoreSession)iin);
}
return new android.app.backup.IRestoreSession.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.145 -0500", hash_original_field = "0B5EF00255EC3F6330F2550180C379BB", hash_generated_field = "0569B9093DD5F762C1B60F8B4185B971")

static final int TRANSACTION_getAvailableRestoreSets = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.147 -0500", hash_original_field = "00719AA75E55E363F00C0E4983E2A345", hash_generated_field = "B9C216F3920F3215ED1A53E9EEA8D91B")

static final int TRANSACTION_restoreAll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.150 -0500", hash_original_field = "218721511ACCF9DAC2F3AD91942113AD", hash_generated_field = "1B70CA149FB2B0C77980A3371D32A5BB")

static final int TRANSACTION_restoreSome = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.backup.IRestoreSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.113 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.116 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.118 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.121 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Ask the current transport what the available restore sets are.
     *
     * @param observer This binder points to an object whose onRestoreSetsAvailable()
     *   method will be called to supply the results of the transport's lookup.
     * @return Zero on success; nonzero on error.  The observer will only receive a
     *   result callback if this method returned zero.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.123 -0500", hash_original_method = "F6DD32B5279B742297057D8965D2E0AB", hash_generated_method = "84C0E8AFA2EAD088C040836763350254")
            
public int getAvailableRestoreSets(android.app.backup.IRestoreObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getAvailableRestoreSets, _data, _reply, 0);
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
     * Restore the given set onto the device, replacing the current data of any app
     * contained in the restore set with the data previously backed up.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     *
     * @return Zero on success; nonzero on error.  The observer will only receive
     *   progress callbacks if this method returned zero.
     * @param token The token from {@link getAvailableRestoreSets()} corresponding to
     *   the restore set that should be used.
     * @param observer If non-null, this binder points to an object that will receive
     *   progress callbacks during the restore operation.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.126 -0500", hash_original_method = "EBEAD6A2F5AC5E0806619F0CA3E2BC96", hash_generated_method = "30455DB1341A1E00B4FF52B8BF56A726")
            
public int restoreAll(long token, android.app.backup.IRestoreObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(token);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_restoreAll, _data, _reply, 0);
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
     * Restore select packages from the given set onto the device, replacing the
     * current data of any app contained in the set with the data previously
     * backed up.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     *
     * @return Zero on success, nonzero on error. The observer will only receive
     *   progress callbacks if this method returned zero.
     * @param token The token from {@link getAvailableRestoreSets()} corresponding to
     *   the restore set that should be used.
     * @param observer If non-null, this binder points to an object that will receive
     *   progress callbacks during the restore operation.
     * @param packages The set of packages for which to attempt a restore.  Regardless of
     *   the contents of the actual back-end dataset named by {@code token}, only
     *   applications mentioned in this list will have their data restored.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.129 -0500", hash_original_method = "4C7B634D0B09C866EA862065BD3859A6", hash_generated_method = "A27588910B113F7F96A3BCFE48836FF2")
            
public int restoreSome(long token, android.app.backup.IRestoreObserver observer, java.lang.String[] packages) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(token);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeStringArray(packages);
mRemote.transact(Stub.TRANSACTION_restoreSome, _data, _reply, 0);
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
     * Restore a single application from backup.  The data will be restored from the
     * current backup dataset if the given package has stored data there, or from
     * the dataset used during the last full device setup operation if the current
     * backup dataset has no matching data.  If no backup data exists for this package
     * in either source, a nonzero value will be returned.
     *
     * @return Zero on success; nonzero on error.  The observer will only receive
     *   progress callbacks if this method returned zero.
     * @param packageName The name of the package whose data to restore.  If this is
     *   not the name of the caller's own package, then the android.permission.BACKUP
     *   permission must be held.
     * @param observer If non-null, this binder points to an object that will receive
     *   progress callbacks during the restore operation.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.133 -0500", hash_original_method = "763A71E341385A63AF9B7B27DB41DD5C", hash_generated_method = "CB7ED56C27388CC9DB042613444B4189")
            
public int restorePackage(java.lang.String packageName, android.app.backup.IRestoreObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_restorePackage, _data, _reply, 0);
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
     * End this restore session.  After this method is called, the IRestoreSession binder
     * is no longer valid.
     *
     * <p><b>Note:</b> The caller <i>must</i> invoke this method to end the restore session,
     *   even if {@link getAvailableRestoreSets} or {@link performRestore} failed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.135 -0500", hash_original_method = "0BB049E56D34C4D8680A1178ED7D4995", hash_generated_method = "FDADE12C834BD9500B6E1E60F6904C4C")
            
public void endRestoreSession() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_endRestoreSession, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.152 -0500", hash_original_field = "E9068A2E6786ED0312688E1E3918EEA9", hash_generated_field = "D95E12A15D61799BA291471F84D108C5")

static final int TRANSACTION_restorePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.155 -0500", hash_original_field = "55BDA9F06E4AC25F2D198E6D95575709", hash_generated_field = "27E9D317434E50861E4A6EF5ACF9E62C")

static final int TRANSACTION_endRestoreSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.101 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.107 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.110 -0500", hash_original_method = "423E84187EDABE1190F1418C2BAF5B86", hash_generated_method = "2E215F2E1E1E5694C2AB343B0C1F78D2")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getAvailableRestoreSets:
{
data.enforceInterface(DESCRIPTOR);
android.app.backup.IRestoreObserver _arg0;
_arg0 = android.app.backup.IRestoreObserver.Stub.asInterface(data.readStrongBinder());
int _result = this.getAvailableRestoreSets(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_restoreAll:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
android.app.backup.IRestoreObserver _arg1;
_arg1 = android.app.backup.IRestoreObserver.Stub.asInterface(data.readStrongBinder());
int _result = this.restoreAll(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_restoreSome:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
android.app.backup.IRestoreObserver _arg1;
_arg1 = android.app.backup.IRestoreObserver.Stub.asInterface(data.readStrongBinder());
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
int _result = this.restoreSome(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_restorePackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.app.backup.IRestoreObserver _arg1;
_arg1 = android.app.backup.IRestoreObserver.Stub.asInterface(data.readStrongBinder());
int _result = this.restorePackage(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_endRestoreSession:
{
data.enforceInterface(DESCRIPTOR);
this.endRestoreSession();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public int getAvailableRestoreSets(android.app.backup.IRestoreObserver observer) throws android.os.RemoteException;

public int restoreAll(long token, android.app.backup.IRestoreObserver observer) throws android.os.RemoteException;

public int restoreSome(long token, android.app.backup.IRestoreObserver observer, java.lang.String[] packages) throws android.os.RemoteException;

public int restorePackage(java.lang.String packageName, android.app.backup.IRestoreObserver observer) throws android.os.RemoteException;

public void endRestoreSession() throws android.os.RemoteException;
}
