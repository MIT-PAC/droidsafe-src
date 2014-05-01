package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IActivityWatcher extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IActivityWatcher
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.309 -0500", hash_original_field = "FA5DDEBE27603CDD346D65B5ED1FAA96", hash_generated_field = "1F1A7E5CD7BF27195D6259B021B56288")

private static final java.lang.String DESCRIPTOR = "android.app.IActivityWatcher";
/**
 * Cast an IBinder object into an android.app.IActivityWatcher interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.314 -0500", hash_original_method = "6B6FF2DAF628A0C82471B7F2B6F5C12D", hash_generated_method = "6D537EA28D13BFA7B5A58FEF769C2A38")
        
public static android.app.IActivityWatcher asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IActivityWatcher))) {
return ((android.app.IActivityWatcher)iin);
}
return new android.app.IActivityWatcher.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.339 -0500", hash_original_field = "5AC97C6A01C882CEE7721268B8162704", hash_generated_field = "4FCC895C4D9E1E953B66EBD67BFBDD6F")

static final int TRANSACTION_activityResuming = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.341 -0500", hash_original_field = "B1DBCA003539B74FF0153DBB433D198D", hash_generated_field = "98329233715AA4025AE2CEA22C7B9B6C")

static final int TRANSACTION_closingSystemDialogs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.311 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.app.IActivityWatcher
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.322 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.325 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.328 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.330 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.333 -0500", hash_original_method = "79A1D2769741B8D1C0225906D028648F", hash_generated_method = "12AF53BED744F0673E8EE81F7D567543")
            
public void activityResuming(int activityId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(activityId);
mRemote.transact(Stub.TRANSACTION_activityResuming, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.335 -0500", hash_original_method = "ABAFC85670B5116606E5E41B1BADC1A2", hash_generated_method = "01934B7E5A5DF723C0E050FB47475542")
            
public void closingSystemDialogs(java.lang.String reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(reason);
mRemote.transact(Stub.TRANSACTION_closingSystemDialogs, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.316 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.319 -0500", hash_original_method = "E83CC7759BFBBBF17C4C153047041D64", hash_generated_method = "2869C911149FD385C8254628092F501F")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_activityResuming:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.activityResuming(_arg0);
return true;
}
case TRANSACTION_closingSystemDialogs:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.closingSystemDialogs(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void activityResuming(int activityId) throws android.os.RemoteException;
public void closingSystemDialogs(java.lang.String reason) throws android.os.RemoteException;
}
