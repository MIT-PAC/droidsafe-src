package com.android.internal.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ISpellCheckerSession extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.textservice.ISpellCheckerSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.818 -0500", hash_original_field = "70F78FC06F45D585E6B3C6723B3A054A", hash_generated_field = "1B64A74BEB018F46669377EE35B8F256")

private static final java.lang.String DESCRIPTOR = "com.android.internal.textservice.ISpellCheckerSession";
/**
 * Cast an IBinder object into an com.android.internal.textservice.ISpellCheckerSession interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.824 -0500", hash_original_method = "5E28CBCDC6A4F282082B7B59258D0B5B", hash_generated_method = "521AAE0E74A285A4A015553A530D8576")
        
public static com.android.internal.textservice.ISpellCheckerSession asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.textservice.ISpellCheckerSession))) {
return ((com.android.internal.textservice.ISpellCheckerSession)iin);
}
return new com.android.internal.textservice.ISpellCheckerSession.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.852 -0500", hash_original_field = "CB9A81D9C96172419E475C27AA5688B8", hash_generated_field = "CC25A9B597B6BF9C9680D0282F74E75D")

static final int TRANSACTION_onGetSuggestionsMultiple = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.855 -0500", hash_original_field = "4DDBB159DBAA139F81F583D977E94CB3", hash_generated_field = "995711587B80BC03FFE1C9A15C584507")

static final int TRANSACTION_onCancel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.857 -0500", hash_original_field = "56E7F1E3DB71ECB6C9B654DACCE70FB2", hash_generated_field = "CD0256F0B978E02109FE2820F602CABF")

static final int TRANSACTION_onClose = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.textservice.ISpellCheckerSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.832 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.834 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.837 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.840 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.842 -0500", hash_original_method = "0DEAA8F0104B54F28EEE0BE6EDAE936B", hash_generated_method = "3BF8FA2C5D3C94476C421F6FAAE6751D")
            
public void onGetSuggestionsMultiple(android.view.textservice.TextInfo[] textInfos, int suggestionsLimit, boolean multipleWords) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(textInfos, 0);
_data.writeInt(suggestionsLimit);
_data.writeInt(((multipleWords)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onGetSuggestionsMultiple, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.845 -0500", hash_original_method = "A66DD0987C5985B4ED266D1CCEACBCD3", hash_generated_method = "DD222C2E73C657008C91220F638D73F3")
            
public void onCancel() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onCancel, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.848 -0500", hash_original_method = "6E811FF00B1435915D296E6A54197D60", hash_generated_method = "073AD840BF45AE22F91A230262DCE4AF")
            
public void onClose() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onClose, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.821 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.826 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.829 -0500", hash_original_method = "81786125E6EAC160A741FA3AA13B3F32", hash_generated_method = "62D9EA8D65E49375299D7CC663613303")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onGetSuggestionsMultiple:
{
data.enforceInterface(DESCRIPTOR);
android.view.textservice.TextInfo[] _arg0;
_arg0 = data.createTypedArray(android.view.textservice.TextInfo.CREATOR);
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.onGetSuggestionsMultiple(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onCancel:
{
data.enforceInterface(DESCRIPTOR);
this.onCancel();
reply.writeNoException();
return true;
}
case TRANSACTION_onClose:
{
data.enforceInterface(DESCRIPTOR);
this.onClose();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onGetSuggestionsMultiple(android.view.textservice.TextInfo[] textInfos, int suggestionsLimit, boolean multipleWords) throws android.os.RemoteException;
public void onCancel() throws android.os.RemoteException;
public void onClose() throws android.os.RemoteException;
}
