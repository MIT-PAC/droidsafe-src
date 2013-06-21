package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface IPackageDataObserver extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.pm.IPackageDataObserver
{
private static final java.lang.String DESCRIPTOR = "android.content.pm.IPackageDataObserver";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.content.pm.IPackageDataObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.pm.IPackageDataObserver))) {
return ((android.content.pm.IPackageDataObserver)iin);
}
return new android.content.pm.IPackageDataObserver.Stub.Proxy(obj);
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
case TRANSACTION_onRemoveCompleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.onRemoveCompleted(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.content.pm.IPackageDataObserver
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
public void onRemoveCompleted(java.lang.String packageName, boolean succeeded) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(((succeeded)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onRemoveCompleted, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onRemoveCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onRemoveCompleted(java.lang.String packageName, boolean succeeded) throws android.os.RemoteException;
}
