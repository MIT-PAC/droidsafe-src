/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/IPrinterDiscoveryObserver.aidl
 */
package android.print;
/**
 * Interface for observing discovered printers by a discovery session.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrinterDiscoveryObserver extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IPrinterDiscoveryObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.179 -0400", hash_original_field = "784A458748BABB58063D9AF981A1CDB9", hash_generated_field = "E4A2622861D89F8D78F463FC77671443")

private static final java.lang.String DESCRIPTOR = "android.print.IPrinterDiscoveryObserver";
/**
 * Cast an IBinder object into an android.print.IPrinterDiscoveryObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.182 -0400", hash_original_method = "B259F4690CBD05EC0258663EB7D617D3", hash_generated_method = "DFFE938585DED925BB49AC194129E5BE")
        
public static android.print.IPrinterDiscoveryObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IPrinterDiscoveryObserver))) {
return ((android.print.IPrinterDiscoveryObserver)iin);
}
return new android.print.IPrinterDiscoveryObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.192 -0400", hash_original_field = "6169E46BFE70629749C2F555851ECAE8", hash_generated_field = "DF02DD23CAC6E3EFDDDF5CFF51DFD9F0")

static final int TRANSACTION_onPrintersAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.193 -0400", hash_original_field = "927DCDBBA5ACF18675064AFD95DAE97D", hash_generated_field = "DE4969D91E5F13C9461E2DE28430E3D7")

static final int TRANSACTION_onPrintersRemoved = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.180 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
private static class Proxy implements android.print.IPrinterDiscoveryObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.185 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.186 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.187 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.188 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.189 -0400", hash_original_method = "5DEE636E93CEEF9C455768C6BB919E08", hash_generated_method = "9B7C21568142E2F196506898309B49FD")
            
@Override public void onPrintersAdded(android.content.pm.ParceledListSlice printers) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printers!=null)) {
_data.writeInt(1);
printers.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onPrintersAdded, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.190 -0400", hash_original_method = "4F3B6CE96B5F3391C25CA74BD9CED8B7", hash_generated_method = "0EA95FEFEB64FBA4D1817550D7D2E8A9")
            
@Override public void onPrintersRemoved(android.content.pm.ParceledListSlice printerIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printerIds!=null)) {
_data.writeInt(1);
printerIds.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onPrintersRemoved, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.183 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.184 -0400", hash_original_method = "E219D90BC8B7083226BC18808072A481", hash_generated_method = "1BA7A204DC84C6C8F27DDD959ABBD499")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onPrintersAdded:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.ParceledListSlice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onPrintersAdded(_arg0);
return true;
}
case TRANSACTION_onPrintersRemoved:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.ParceledListSlice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onPrintersRemoved(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onPrintersAdded(android.content.pm.ParceledListSlice printers) throws android.os.RemoteException;
public void onPrintersRemoved(android.content.pm.ParceledListSlice printerIds) throws android.os.RemoteException;
}
