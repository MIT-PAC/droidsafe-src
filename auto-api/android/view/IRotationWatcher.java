package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface IRotationWatcher extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.IRotationWatcher
{
private static final java.lang.String DESCRIPTOR = "android.view.IRotationWatcher";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.view.IRotationWatcher asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.IRotationWatcher))) {
return ((android.view.IRotationWatcher)iin);
}
return new android.view.IRotationWatcher.Stub.Proxy(obj);
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
case TRANSACTION_onRotationChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onRotationChanged(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.view.IRotationWatcher
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
public void onRotationChanged(int rotation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(rotation);
mRemote.transact(Stub.TRANSACTION_onRotationChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onRotationChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onRotationChanged(int rotation) throws android.os.RemoteException;
}

