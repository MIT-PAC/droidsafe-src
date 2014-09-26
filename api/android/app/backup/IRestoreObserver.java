package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IRestoreObserver extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.backup.IRestoreObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.343 -0500", hash_original_field = "3928635500F4A1CD022C3ABC45BD724F", hash_generated_field = "1A91A3E45B7AE784F83E2F2F957B5881")

private static final java.lang.String DESCRIPTOR = "android.app.backup.IRestoreObserver";
/**
 * Cast an IBinder object into an android.app.backup.IRestoreObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.348 -0500", hash_original_method = "4641B47FE459B90EA9FF5565CD5B007E", hash_generated_method = "5DC20A379C2826FDC6CA076FCFAEDC2E")
        
public static android.app.backup.IRestoreObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.backup.IRestoreObserver))) {
return ((android.app.backup.IRestoreObserver)iin);
}
return new android.app.backup.IRestoreObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.380 -0500", hash_original_field = "77838774F29970F8DBAAE92E826BB060", hash_generated_field = "94CEC8E9286B77C9DF6669187DE86B55")

static final int TRANSACTION_restoreSetsAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.383 -0500", hash_original_field = "B7134D5FB0D58B82E5410BBCDF0FA487", hash_generated_field = "DA484044BB0070950643BCDFC6600C89")

static final int TRANSACTION_restoreStarting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.385 -0500", hash_original_field = "164098B5E12D2036023C9C220DD89911", hash_generated_field = "1416BFCF3C4F90BD8175339475E603E8")

static final int TRANSACTION_onUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.backup.IRestoreObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.357 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.359 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.361 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.364 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Supply a list of the restore datasets available from the current transport.  This
     * method is invoked as a callback following the application's use of the
     * {@link android.app.backup.IRestoreSession.getAvailableRestoreSets} method.
     *
     * @param result An array of {@link android.app.backup.RestoreSet RestoreSet} objects
     *   describing all of the available datasets that are candidates for restoring to
     *   the current device.  If no applicable datasets exist, {@code result} will be
     *   {@code null}.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.367 -0500", hash_original_method = "0622CA1E51B91425EAF6FF59B15C1C1B", hash_generated_method = "07E5DCC78C98B9C86A9FCA5DB5242C8E")
            
public void restoreSetsAvailable(android.app.backup.RestoreSet[] result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(result, 0);
mRemote.transact(Stub.TRANSACTION_restoreSetsAvailable, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * The restore operation has begun.
     *
     * @param numPackages The total number of packages being processed in
     *   this restore operation.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.370 -0500", hash_original_method = "AD83777E217714B6FF6910D47F9B7839", hash_generated_method = "35BB13DBA26B90C1B9843687CBABAD97")
            
public void restoreStarting(int numPackages) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(numPackages);
mRemote.transact(Stub.TRANSACTION_restoreStarting, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * An indication of which package is being restored currently, out of the
     * total number provided in the {@link #restoreStarting(int numPackages)} callback.
     * This method is not guaranteed to be called.
     *
     * @param nowBeingRestored The index, between 1 and the numPackages parameter
     *   to the restoreStarting() callback, of the package now being restored.
     * @param currentPackage The name of the package now being restored.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.372 -0500", hash_original_method = "4D1B698F9DDC9B92F2E46B95B365AB82", hash_generated_method = "CF8F7B25257DBCCF95FC810D1DC76B89")
            
public void onUpdate(int nowBeingRestored, java.lang.String curentPackage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nowBeingRestored);
_data.writeString(curentPackage);
mRemote.transact(Stub.TRANSACTION_onUpdate, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * The restore operation has completed.
     *
     * @param error Zero on success; a nonzero error code if the restore operation
     *   as a whole failed.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.376 -0500", hash_original_method = "9BC1D282CC171018446D034E9A1E58BA", hash_generated_method = "724391F076095EA8FCE8A0D23943356A")
            
public void restoreFinished(int error) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(error);
mRemote.transact(Stub.TRANSACTION_restoreFinished, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.387 -0500", hash_original_field = "A471EA3CFBB790BB0A19A55F22753B83", hash_generated_field = "FFF2792B70BF8E213E2451FB13A6EC8B")

static final int TRANSACTION_restoreFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.345 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.351 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.354 -0500", hash_original_method = "BD05F25EAE2EF1ED9BB0F2504403FE37", hash_generated_method = "610DA5A0B6F6A42E30978CD0FCC5F047")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_restoreSetsAvailable:
{
data.enforceInterface(DESCRIPTOR);
android.app.backup.RestoreSet[] _arg0;
_arg0 = data.createTypedArray(android.app.backup.RestoreSet.CREATOR);
this.restoreSetsAvailable(_arg0);
return true;
}
case TRANSACTION_restoreStarting:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.restoreStarting(_arg0);
return true;
}
case TRANSACTION_onUpdate:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.onUpdate(_arg0, _arg1);
return true;
}
case TRANSACTION_restoreFinished:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.restoreFinished(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void restoreSetsAvailable(android.app.backup.RestoreSet[] result) throws android.os.RemoteException;

public void restoreStarting(int numPackages) throws android.os.RemoteException;

public void onUpdate(int nowBeingRestored, java.lang.String curentPackage) throws android.os.RemoteException;

public void restoreFinished(int error) throws android.os.RemoteException;
}
