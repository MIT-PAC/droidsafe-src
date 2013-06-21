package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface IBackupAgent extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IBackupAgent
{
private static final java.lang.String DESCRIPTOR = "android.app.IBackupAgent";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

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
private static class Proxy implements android.app.IBackupAgent
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
static final int TRANSACTION_doBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_doRestore = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_doFullBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_doRestoreFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}

public void doBackup(android.os.ParcelFileDescriptor oldState, android.os.ParcelFileDescriptor data, android.os.ParcelFileDescriptor newState, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException;

public void doRestore(android.os.ParcelFileDescriptor data, int appVersionCode, android.os.ParcelFileDescriptor newState, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException;

public void doFullBackup(android.os.ParcelFileDescriptor data, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException;

public void doRestoreFile(android.os.ParcelFileDescriptor data, long size, int type, java.lang.String domain, java.lang.String path, long mode, long mtime, int token, android.app.backup.IBackupManager callbackBinder) throws android.os.RemoteException;
}
