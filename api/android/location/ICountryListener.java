package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ICountryListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.location.ICountryListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.716 -0500", hash_original_field = "526D0F5D3FF51AA18CBE3AD80A986029", hash_generated_field = "0B3B795A7F4ADEA31FFC7FE6B628CBB4")

private static final java.lang.String DESCRIPTOR = "android.location.ICountryListener";
/**
 * Cast an IBinder object into an android.location.ICountryListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.721 -0500", hash_original_method = "21AA8D9590A8804489145B8D53CFD44D", hash_generated_method = "5268CECE0E62C0D414962C4021C25DAC")
        
public static android.location.ICountryListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.location.ICountryListener))) {
return ((android.location.ICountryListener)iin);
}
return new android.location.ICountryListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.743 -0500", hash_original_field = "92B200C859D37E39F088C19D75C455D2", hash_generated_field = "0E154BF7D70161D573758E460DFBB1E2")

static final int TRANSACTION_onCountryDetected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.719 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.723 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.location.ICountryListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.729 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.732 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.734 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.LOCATION_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.737 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.739 -0500", hash_original_method = "B585656C0289031287A8CC6BD1EEEC10", hash_generated_method = "0501A5C33A1B197C94341C654FB8802A")
            
public void onCountryDetected(android.location.Country country) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((country!=null)) {
_data.writeInt(1);
country.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onCountryDetected, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.726 -0500", hash_original_method = "D5746628C9C1F96F747ED2231AA81F0A", hash_generated_method = "75C05B34508DEC3B24441E47C59F8455")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onCountryDetected:
{
data.enforceInterface(DESCRIPTOR);
android.location.Country _arg0;
if ((0!=data.readInt())) {
_arg0 = android.location.Country.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onCountryDetected(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onCountryDetected(android.location.Country country) throws android.os.RemoteException;
}
