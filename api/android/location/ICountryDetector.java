package android.location;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ICountryDetector extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.location.ICountryDetector
{
private static final java.lang.String DESCRIPTOR = "android.location.ICountryDetector";

@DSModeled(DSC.BAN)
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.location.ICountryDetector asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.location.ICountryDetector))) {
return ((android.location.ICountryDetector)iin);
}
return new android.location.ICountryDetector.Stub.Proxy(obj);
}
@DSModeled(DSC.BAN)
        public android.os.IBinder asBinder()
{
return this;
}
@DSModeled(DSC.SAFE)
        @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_detectCountry:
{
data.enforceInterface(DESCRIPTOR);
android.location.Country _result = this.detectCountry();
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
case TRANSACTION_addCountryListener:
{
data.enforceInterface(DESCRIPTOR);
android.location.ICountryListener _arg0;
_arg0 = android.location.ICountryListener.Stub.asInterface(data.readStrongBinder());
this.addCountryListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeCountryListener:
{
data.enforceInterface(DESCRIPTOR);
android.location.ICountryListener _arg0;
_arg0 = android.location.ICountryListener.Stub.asInterface(data.readStrongBinder());
this.removeCountryListener(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.location.ICountryDetector
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
            public android.location.Country detectCountry() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.location.Country _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_detectCountry, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.location.Country.CREATOR.createFromParcel(_reply);
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

public void addCountryListener(android.location.ICountryListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addCountryListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}

@DSModeled(DSC.SAFE)
            public void removeCountryListener(android.location.ICountryListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeCountryListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_detectCountry = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_addCountryListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_removeCountryListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}

public android.location.Country detectCountry() throws android.os.RemoteException;

public void addCountryListener(android.location.ICountryListener listener) throws android.os.RemoteException;

public void removeCountryListener(android.location.ICountryListener listener) throws android.os.RemoteException;
}
