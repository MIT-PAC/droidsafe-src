package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface IApplicationToken extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.IApplicationToken
{
private static final java.lang.String DESCRIPTOR = "android.view.IApplicationToken";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.view.IApplicationToken asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.IApplicationToken))) {
return ((android.view.IApplicationToken)iin);
}
return new android.view.IApplicationToken.Stub.Proxy(obj);
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
case TRANSACTION_windowsDrawn:
{
data.enforceInterface(DESCRIPTOR);
this.windowsDrawn();
reply.writeNoException();
return true;
}
case TRANSACTION_windowsVisible:
{
data.enforceInterface(DESCRIPTOR);
this.windowsVisible();
reply.writeNoException();
return true;
}
case TRANSACTION_windowsGone:
{
data.enforceInterface(DESCRIPTOR);
this.windowsGone();
reply.writeNoException();
return true;
}
case TRANSACTION_keyDispatchingTimedOut:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.keyDispatchingTimedOut();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getKeyDispatchingTimeout:
{
data.enforceInterface(DESCRIPTOR);
long _result = this.getKeyDispatchingTimeout();
reply.writeNoException();
reply.writeLong(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.view.IApplicationToken
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
public void windowsDrawn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_windowsDrawn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void windowsVisible() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_windowsVisible, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void windowsGone() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_windowsGone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public boolean keyDispatchingTimedOut() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_keyDispatchingTimedOut, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public long getKeyDispatchingTimeout() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getKeyDispatchingTimeout, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_windowsDrawn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_windowsVisible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_windowsGone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_keyDispatchingTimedOut = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getKeyDispatchingTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
public void windowsDrawn() throws android.os.RemoteException;
public void windowsVisible() throws android.os.RemoteException;
public void windowsGone() throws android.os.RemoteException;
public boolean keyDispatchingTimedOut() throws android.os.RemoteException;
public long getKeyDispatchingTimeout() throws android.os.RemoteException;
}
