package android.app.backup;

// Droidsafe Imports

public interface IBackupManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.backup.IBackupManager
{
private static final java.lang.String DESCRIPTOR = "android.app.backup.IBackupManager";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

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
public android.os.IBinder asBinder()
{
return this;
}
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
private static class Proxy implements android.app.backup.IBackupManager
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}

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
static final int TRANSACTION_dataChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_clearBackupData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_agentConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_agentDisconnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_restoreAtInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setBackupEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_setAutoRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_setBackupProvisioned = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_isBackupEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_setBackupPassword = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_hasBackupPassword = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_backupNow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_fullBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_fullRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_acknowledgeFullBackupOrRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getCurrentTransport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_listAllTransports = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_selectBackupTransport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_getConfigurationIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_getDestinationString = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_beginRestoreSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_opComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
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
