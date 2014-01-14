package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IContentObserver extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.database.IContentObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.059 -0500", hash_original_field = "50D51A73298236A25CAE441984EF5072", hash_generated_field = "21748C4CA4DE69F25F2C30404793F0E1")

private static final java.lang.String DESCRIPTOR = "android.database.IContentObserver";
/**
 * Cast an IBinder object into an android.database.IContentObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.065 -0500", hash_original_method = "4C2F2D01DF1099AD0CB08160A4BD4959", hash_generated_method = "67BCC41949F1713C8E0E2A705F2B12DB")
        
public static android.database.IContentObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.database.IContentObserver))) {
return ((android.database.IContentObserver)iin);
}
return new android.database.IContentObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.088 -0500", hash_original_field = "72AD8F434DCB7BE003DF2747E1F0364C", hash_generated_field = "54DAD02F7CE03E0A6CC8B24C4BB4EE06")

static final int TRANSACTION_onChange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.061 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.DATABASE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.067 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.database.IContentObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.074 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.076 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.079 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.DATABASE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.082 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * This method is called when an update occurs to the cursor that is being
     * observed. selfUpdate is true if the update was caused by a call to
     * commit on the cursor that is being observed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.084 -0500", hash_original_method = "544FF93E8D8DD03ECB4250D6B9167F89", hash_generated_method = "21863C369BF308DACDE366A1CCA8C819")
            
public void onChange(boolean selfUpdate) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((selfUpdate)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onChange, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.070 -0500", hash_original_method = "1A4C47A926431C38E737F6655B5CABBE", hash_generated_method = "E451589183F7E911B7E171D615F18D3D")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onChange:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.onChange(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void onChange(boolean selfUpdate) throws android.os.RemoteException;
}
