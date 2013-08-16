package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface IWallpaperManagerCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IWallpaperManagerCallback
{
private static final java.lang.String DESCRIPTOR = "android.app.IWallpaperManagerCallback";

@DSModeled(DSC.BAN)
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.app.IWallpaperManagerCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IWallpaperManagerCallback))) {
return ((android.app.IWallpaperManagerCallback)iin);
}
return new android.app.IWallpaperManagerCallback.Stub.Proxy(obj);
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
case TRANSACTION_onWallpaperChanged:
{
data.enforceInterface(DESCRIPTOR);
this.onWallpaperChanged();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.app.IWallpaperManagerCallback
{
private android.os.IBinder mRemote;
@DSModeled(DSC.SAFE)
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
            public void onWallpaperChanged() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onWallpaperChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onWallpaperChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}

public void onWallpaperChanged() throws android.os.RemoteException;
}
