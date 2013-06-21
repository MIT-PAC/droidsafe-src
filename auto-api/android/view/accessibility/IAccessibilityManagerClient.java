package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface IAccessibilityManagerClient extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.accessibility.IAccessibilityManagerClient
{
private static final java.lang.String DESCRIPTOR = "android.view.accessibility.IAccessibilityManagerClient";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.view.accessibility.IAccessibilityManagerClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.accessibility.IAccessibilityManagerClient))) {
return ((android.view.accessibility.IAccessibilityManagerClient)iin);
}
return new android.view.accessibility.IAccessibilityManagerClient.Stub.Proxy(obj);
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
case TRANSACTION_setState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setState(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.view.accessibility.IAccessibilityManagerClient
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
public void setState(int stateFlags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(stateFlags);
mRemote.transact(Stub.TRANSACTION_setState, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_setState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void setState(int stateFlags) throws android.os.RemoteException;
}
