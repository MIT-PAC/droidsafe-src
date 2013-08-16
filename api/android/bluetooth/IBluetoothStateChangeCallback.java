package android.bluetooth;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface IBluetoothStateChangeCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.bluetooth.IBluetoothStateChangeCallback
{
private static final java.lang.String DESCRIPTOR = "android.bluetooth.IBluetoothStateChangeCallback";

@DSModeled(DSC.BAN)
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.bluetooth.IBluetoothStateChangeCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.bluetooth.IBluetoothStateChangeCallback))) {
return ((android.bluetooth.IBluetoothStateChangeCallback)iin);
}
return new android.bluetooth.IBluetoothStateChangeCallback.Stub.Proxy(obj);
}
@DSModeled(DSC.BAN)
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
case TRANSACTION_onBluetoothStateChange:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.onBluetoothStateChange(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.bluetooth.IBluetoothStateChangeCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSModeled(DSC.BAN)
            public android.os.IBinder asBinder()
{
return mRemote;
}
@DSModeled(DSC.BAN)
            public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSModeled(DSC.BAN)
            public void onBluetoothStateChange(boolean on) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((on)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onBluetoothStateChange, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onBluetoothStateChange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onBluetoothStateChange(boolean on) throws android.os.RemoteException;
}
