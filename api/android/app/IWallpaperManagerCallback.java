package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IWallpaperManagerCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IWallpaperManagerCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.213 -0500", hash_original_field = "7E2B42BA55103072F4F0AE5C1DF6A61B", hash_generated_field = "DFC7C94928C123F63BAD3A2C5337D6BC")

private static final java.lang.String DESCRIPTOR = "android.app.IWallpaperManagerCallback";
/**
 * Cast an IBinder object into an android.app.IWallpaperManagerCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.218 -0500", hash_original_method = "8BC35B9AEE429005480536B7ACB71154", hash_generated_method = "BE38D7F994854550F530CBB1C5C5EC86")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.241 -0500", hash_original_field = "DFADCAE5FDB59B5D2BAAB0A80912CEE6", hash_generated_field = "65CD46BEAD223454ABB56B8624A68372")

static final int TRANSACTION_onWallpaperChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.216 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.221 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.app.IWallpaperManagerCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.227 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.230 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.232 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.234 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Called when the wallpaper has changed
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.237 -0500", hash_original_method = "C03EFFC7CC8DC9E181DE79E54337A743", hash_generated_method = "E884DC840834B444AAE63B5FAA42BAB3")
            
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.223 -0500", hash_original_method = "17004EC550C91F0E569BB89FB3D364BF", hash_generated_method = "C3745D7EEFEA1EBC020916CBDA9D1C2E")
        
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
}

public void onWallpaperChanged() throws android.os.RemoteException;
}
