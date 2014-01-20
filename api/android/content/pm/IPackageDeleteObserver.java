package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IPackageDeleteObserver extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.pm.IPackageDeleteObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.123 -0500", hash_original_field = "8A7B6CF7DF5A4E3B2D5523B7F50E535D", hash_generated_field = "3A1B2E3095293FD505D2B381F9491FF0")

private static final java.lang.String DESCRIPTOR = "android.content.pm.IPackageDeleteObserver";
/**
 * Cast an IBinder object into an android.content.pm.IPackageDeleteObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.128 -0500", hash_original_method = "19347BBC53D1ADACD180E0B5FC4EA88E", hash_generated_method = "447C39370E1B86169DC9F13306FA2654")
        
public static android.content.pm.IPackageDeleteObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.pm.IPackageDeleteObserver))) {
return ((android.content.pm.IPackageDeleteObserver)iin);
}
return new android.content.pm.IPackageDeleteObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.150 -0500", hash_original_field = "D3631E5464DD5552BD689C3EF2B49B9C", hash_generated_field = "73810A91B317002F86CF624EB6BCBCA4")

static final int TRANSACTION_packageDeleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.125 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.131 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.content.pm.IPackageDeleteObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.137 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.139 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.141 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.143 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.146 -0500", hash_original_method = "260B72B6D621A100C68FB8E3E52C9CFF", hash_generated_method = "7278421E11F76F16A2C1C7C511792B5C")
            
public void packageDeleted(java.lang.String packageName, int returnCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(returnCode);
mRemote.transact(Stub.TRANSACTION_packageDeleted, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.133 -0500", hash_original_method = "E4E632877234A82BAEBC5A078A3C1F70", hash_generated_method = "C85B16125E94DB204DA470F8F00CE4A6")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_packageDeleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.packageDeleted(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void packageDeleted(java.lang.String packageName, int returnCode) throws android.os.RemoteException;
}
