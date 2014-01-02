package com.android.internal.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ITextServicesSessionListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.textservice.ITextServicesSessionListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.687 -0500", hash_original_field = "BCCAC356B091E9B7B6C44DF50EFF022A", hash_generated_field = "18EEF80BC0C837AF9BC0B4C7E9F8CDFC")

private static final java.lang.String DESCRIPTOR = "com.android.internal.textservice.ITextServicesSessionListener";
/**
 * Cast an IBinder object into an com.android.internal.textservice.ITextServicesSessionListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.692 -0500", hash_original_method = "E1AFDF5410E0609BE8DA66E26BD4ADBC", hash_generated_method = "186F2D3D159FCC73144F263DC1ED49FB")
        
public static com.android.internal.textservice.ITextServicesSessionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.textservice.ITextServicesSessionListener))) {
return ((com.android.internal.textservice.ITextServicesSessionListener)iin);
}
return new com.android.internal.textservice.ITextServicesSessionListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.715 -0500", hash_original_field = "75717EBA9827695882150C3144756037", hash_generated_field = "70F177E84AB0EB2D64F4E97C70CB56C4")

static final int TRANSACTION_onServiceConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.689 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.694 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements com.android.internal.textservice.ITextServicesSessionListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.701 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.704 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.706 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.709 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.711 -0500", hash_original_method = "08386E619B6DA8D14E59ED404C55C0FA", hash_generated_method = "637B272035CAFAAEA9EF5DC65B670CC9")
            
public void onServiceConnected(com.android.internal.textservice.ISpellCheckerSession spellCheckerSession) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((spellCheckerSession!=null))?(spellCheckerSession.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onServiceConnected, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.697 -0500", hash_original_method = "0916650B669626512A8776D85D4FE3E8", hash_generated_method = "54DC8035F81E9941FC73BCB8D2CE87B9")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onServiceConnected:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.textservice.ISpellCheckerSession _arg0;
_arg0 = com.android.internal.textservice.ISpellCheckerSession.Stub.asInterface(data.readStrongBinder());
this.onServiceConnected(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onServiceConnected(com.android.internal.textservice.ISpellCheckerSession spellCheckerSession) throws android.os.RemoteException;
}
