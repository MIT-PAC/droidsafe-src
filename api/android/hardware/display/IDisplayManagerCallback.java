/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: frameworks/base/core/java/android/hardware/display/IDisplayManagerCallback.aidl
 */
package android.hardware.display;
/** @hide */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IDisplayManagerCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.hardware.display.IDisplayManagerCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.297 -0500", hash_original_field = "4D2DAA3A9ACC455B92AF627F5111CAED", hash_generated_field = "21BC97E25054444398DB3FBBC71D04D6")

private static final java.lang.String DESCRIPTOR = "android.hardware.display.IDisplayManagerCallback";
/**
 * Cast an IBinder object into an android.hardware.display.IDisplayManagerCallback interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.301 -0500", hash_original_method = "C2BAAE7FF3816FC90E857B804CABF314", hash_generated_method = "5C2EE83A14FB63E8FD33247C2EF08988")
        
public static android.hardware.display.IDisplayManagerCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.hardware.display.IDisplayManagerCallback))) {
return ((android.hardware.display.IDisplayManagerCallback)iin);
}
return new android.hardware.display.IDisplayManagerCallback.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.322 -0500", hash_original_field = "32FFB5B2AE82A1C376BF9F372204016C", hash_generated_field = "3133299C56526394F85009D936400587")

static final int TRANSACTION_onDisplayEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.299 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.303 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.hardware.display.IDisplayManagerCallback
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.309 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.311 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.313 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.315 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.317 -0500", hash_original_method = "6503B8C12D044C6BC60EAF3FD412AB0B", hash_generated_method = "0A9B26F5B7B4A5668696FA71BF825C12")
            
@Override public void onDisplayEvent(int displayId, int event) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(displayId);
_data.writeInt(event);
mRemote.transact(Stub.TRANSACTION_onDisplayEvent, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.306 -0500", hash_original_method = "D3573989C3FF8A334D90FE45EFA931C7", hash_generated_method = "97DB3ED53519E6C9DDD5B3D30D608393")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onDisplayEvent:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.onDisplayEvent(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onDisplayEvent(int displayId, int event) throws android.os.RemoteException;
}
