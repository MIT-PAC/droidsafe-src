package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IOnPrimaryClipChangedListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.IOnPrimaryClipChangedListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.531 -0500", hash_original_field = "9185E0AC62820D192E7A0F75D4F9F5B0", hash_generated_field = "3DEAF503EBAB8899B6C445224F332689")

private static final java.lang.String DESCRIPTOR = "android.content.IOnPrimaryClipChangedListener";
/**
 * Cast an IBinder object into an android.content.IOnPrimaryClipChangedListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.533 -0500", hash_original_method = "BA2C941DDA351E36E57B8646C42712D2", hash_generated_method = "6FC68AF8500324B18E1BF5BBD7DDE9D6")
        public static android.content.IOnPrimaryClipChangedListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.IOnPrimaryClipChangedListener))) {
return ((android.content.IOnPrimaryClipChangedListener)iin);
}
return new android.content.IOnPrimaryClipChangedListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.542 -0500", hash_original_field = "879FEE9C07A2966FD4DBD7E7CC9E307D", hash_generated_field = "33D72A84D6773A1AC8D91566847C8434")

static final int TRANSACTION_dispatchPrimaryClipChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.532 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.534 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.content.IOnPrimaryClipChangedListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.536 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.537 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.538 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.539 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.540 -0500", hash_original_method = "2C63A3FA04A3293817DE8E7ABFAC211A", hash_generated_method = "70F4E7AAACB2CF2379195AD90AA4201D")
            public void dispatchPrimaryClipChanged() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_dispatchPrimaryClipChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.535 -0500", hash_original_method = "4C9ABE1543E975EEC340F6E48D375817", hash_generated_method = "85F12260F406732F7E347D644BCAF539")
        @Override
public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_dispatchPrimaryClipChanged:
{
data.enforceInterface(DESCRIPTOR);
this.dispatchPrimaryClipChanged();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void dispatchPrimaryClipChanged() throws android.os.RemoteException;
}
