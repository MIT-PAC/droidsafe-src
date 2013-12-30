package com.android.internal.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ISpellCheckerSessionListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.textservice.ISpellCheckerSessionListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.963 -0500", hash_original_field = "F984C4D07C54AE3B25E6C1199667E695", hash_generated_field = "BED61AAACE53F48DC903ABB5746AE7D5")

private static final java.lang.String DESCRIPTOR = "com.android.internal.textservice.ISpellCheckerSessionListener";
/**
 * Cast an IBinder object into an com.android.internal.textservice.ISpellCheckerSessionListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.968 -0500", hash_original_method = "F9BDB81A798DAC236F5F5D099F728D74", hash_generated_method = "27488A48B963B7AF5A16DDD902A6AFD2")
        
public static com.android.internal.textservice.ISpellCheckerSessionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.textservice.ISpellCheckerSessionListener))) {
return ((com.android.internal.textservice.ISpellCheckerSessionListener)iin);
}
return new com.android.internal.textservice.ISpellCheckerSessionListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.992 -0500", hash_original_field = "9CCDBBEFE1FE27271BE80D257DF97E7F", hash_generated_field = "A315FE4CC0B53B0BA15F168655552E40")

static final int TRANSACTION_onGetSuggestions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.966 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.971 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements com.android.internal.textservice.ISpellCheckerSessionListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.978 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.981 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.983 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.985 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.988 -0500", hash_original_method = "29625C6C228CA1C9F1FDF7B4B794D6DF", hash_generated_method = "DD0B28646FD523716239F4DBD9BB7314")
            
public void onGetSuggestions(android.view.textservice.SuggestionsInfo[] results) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(results, 0);
mRemote.transact(Stub.TRANSACTION_onGetSuggestions, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.975 -0500", hash_original_method = "C41B98B4DABFF44083389A92B337BF9E", hash_generated_method = "F0079F59160C1F40D77212BC82BBD761")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onGetSuggestions:
{
data.enforceInterface(DESCRIPTOR);
android.view.textservice.SuggestionsInfo[] _arg0;
_arg0 = data.createTypedArray(android.view.textservice.SuggestionsInfo.CREATOR);
this.onGetSuggestions(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onGetSuggestions(android.view.textservice.SuggestionsInfo[] results) throws android.os.RemoteException;
}
