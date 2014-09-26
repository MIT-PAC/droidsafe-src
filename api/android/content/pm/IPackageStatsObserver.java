package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IPackageStatsObserver extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.content.pm.IPackageStatsObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.547 -0500", hash_original_field = "3AA1F27A139FBF49B14DB02DBFA64274", hash_generated_field = "06A5AEF3F5B219945C31517DDC028064")

private static final java.lang.String DESCRIPTOR = "android.content.pm.IPackageStatsObserver";
/**
 * Cast an IBinder object into an android.content.pm.IPackageStatsObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.553 -0500", hash_original_method = "46B971EEAAC75EBCBFA2C4F4903E7DCD", hash_generated_method = "3CE97845BA9ECFD2F4F60197C8D18D9C")
        
public static android.content.pm.IPackageStatsObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.pm.IPackageStatsObserver))) {
return ((android.content.pm.IPackageStatsObserver)iin);
}
return new android.content.pm.IPackageStatsObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.575 -0500", hash_original_field = "2FC3E7996E1E5A86830CCEF1679C1603", hash_generated_field = "136C4C55370189D282D1C3AA4E6D1314")

static final int TRANSACTION_onGetStatsCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.550 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.555 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.content.pm.IPackageStatsObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.561 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.563 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.565 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.568 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.571 -0500", hash_original_method = "CDF8C19B89C524D0D45428222EFBB11C", hash_generated_method = "9EE8FA87119C7AEE59747D9E5AF1E655")
            
public void onGetStatsCompleted(android.content.pm.PackageStats pStats, boolean succeeded) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((pStats!=null)) {
_data.writeInt(1);
pStats.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((succeeded)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onGetStatsCompleted, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.558 -0500", hash_original_method = "03FFFB90F726ED87025E182AD0956A35", hash_generated_method = "CAC703235F3649C1EB519EAC55D010FA")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onGetStatsCompleted:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.PackageStats _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.PackageStats.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
this.onGetStatsCompleted(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onGetStatsCompleted(android.content.pm.PackageStats pStats, boolean succeeded) throws android.os.RemoteException;
}
