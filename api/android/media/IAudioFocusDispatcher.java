package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAudioFocusDispatcher extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.media.IAudioFocusDispatcher
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.806 -0500", hash_original_field = "CE8D7F69DE64EB0ADB2BC2778B1BA3A0", hash_generated_field = "C80709A2400BD285739E35A0E192B867")

private static final java.lang.String DESCRIPTOR = "android.media.IAudioFocusDispatcher";
/**
 * Cast an IBinder object into an android.media.IAudioFocusDispatcher interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.812 -0500", hash_original_method = "33F9C29BC60A2AB4F160386992F7118A", hash_generated_method = "6296801B18A104FDDCBA5F5CD10D0F74")
        
public static android.media.IAudioFocusDispatcher asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.media.IAudioFocusDispatcher))) {
return ((android.media.IAudioFocusDispatcher)iin);
}
return new android.media.IAudioFocusDispatcher.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.835 -0500", hash_original_field = "CE02DBCC3344A7EB40109D679B536728", hash_generated_field = "5F0BAF567A70FDAC02DCE1BAB2E73E8D")

static final int TRANSACTION_dispatchAudioFocusChange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.809 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.814 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.media.IAudioFocusDispatcher
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.820 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.823 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.826 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.828 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.831 -0500", hash_original_method = "D18FFBC450DD782FECA6EB6C971924B7", hash_generated_method = "AC557D126E669BC7021148A289488B51")
            
public void dispatchAudioFocusChange(int focusChange, java.lang.String clientId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(focusChange);
_data.writeString(clientId);
mRemote.transact(Stub.TRANSACTION_dispatchAudioFocusChange, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.817 -0500", hash_original_method = "D2822B3FCA0CC1A563D4DEDEE6646DED", hash_generated_method = "C894B60D8A9C978361C9346E6B82CB3E")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_dispatchAudioFocusChange:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.dispatchAudioFocusChange(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void dispatchAudioFocusChange(int focusChange, java.lang.String clientId) throws android.os.RemoteException;
}
