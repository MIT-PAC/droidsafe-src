package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IGpsStatusListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.location.IGpsStatusListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.861 -0500", hash_original_field = "404FF1E008AE55D122E3A2CC66A551FC", hash_generated_field = "7B145091C3BB08C7CE5F7242DA3E66CF")

private static final java.lang.String DESCRIPTOR = "android.location.IGpsStatusListener";
/**
 * Cast an IBinder object into an android.location.IGpsStatusListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.867 -0500", hash_original_method = "971DB3CD6285873D8ED3A08E88D6744B", hash_generated_method = "1282579C2AF22A72E0A3CCD454A852FE")
        
public static android.location.IGpsStatusListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.location.IGpsStatusListener))) {
return ((android.location.IGpsStatusListener)iin);
}
return new android.location.IGpsStatusListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.902 -0500", hash_original_field = "FB308EB75413C30715E40C5DB9E759FF", hash_generated_field = "C98AFD69C2A77A440B469E29F2C44749")

static final int TRANSACTION_onGpsStarted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.904 -0500", hash_original_field = "6B3BA0ECC9D09807CB4CC94CB6B84DCF", hash_generated_field = "F0FFD2250CF78A166A14D9A19F1B7F73")

static final int TRANSACTION_onGpsStopped = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.907 -0500", hash_original_field = "901D89912D95A5157C46BF884E92BF1D", hash_generated_field = "A39FAFD7951A5CAF4E9BD5C8846B8E8C")

static final int TRANSACTION_onFirstFix = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.location.IGpsStatusListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.876 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.879 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.881 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.883 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.887 -0500", hash_original_method = "470B268B2EC076559A3CE61183923585", hash_generated_method = "E0C75204584BBCDFDDF3D37FADB18D4D")
            
public void onGpsStarted() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onGpsStarted, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.889 -0500", hash_original_method = "8AF600D27F76E4677633A404F08FBF9D", hash_generated_method = "7648C6ED55D7DE634DFD5483496B2E62")
            
public void onGpsStopped() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onGpsStopped, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.892 -0500", hash_original_method = "CEBB8088DAB7501A5B474AD26F003D57", hash_generated_method = "CE764FB7FA8084D700FA02E0B411DA4E")
            
public void onFirstFix(int ttff) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(ttff);
mRemote.transact(Stub.TRANSACTION_onFirstFix, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.895 -0500", hash_original_method = "7FD0669BA825FA9EC2CDF88A49E195BF", hash_generated_method = "8463877D6F9CFCEBE59FE420ECF35B66")
            
public void onSvStatusChanged(int svCount, int[] prns, float[] snrs, float[] elevations, float[] azimuths, int ephemerisMask, int almanacMask, int usedInFixMask) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(svCount);
_data.writeIntArray(prns);
_data.writeFloatArray(snrs);
_data.writeFloatArray(elevations);
_data.writeFloatArray(azimuths);
_data.writeInt(ephemerisMask);
_data.writeInt(almanacMask);
_data.writeInt(usedInFixMask);
mRemote.transact(Stub.TRANSACTION_onSvStatusChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.897 -0500", hash_original_method = "462FCFFEE61C7A5D7214F5AF7E23DD70", hash_generated_method = "022B53A98D673E0422DAB219FAD27730")
            
public void onNmeaReceived(long timestamp, java.lang.String nmea) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(timestamp);
_data.writeString(nmea);
mRemote.transact(Stub.TRANSACTION_onNmeaReceived, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.909 -0500", hash_original_field = "572E65264A0BA035128ECC23D06CE528", hash_generated_field = "0B69B38F3D308CE353C68C464FCAC8E1")

static final int TRANSACTION_onSvStatusChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.912 -0500", hash_original_field = "10A588EAC7ED92EC0A04DEC5B3A2BEBB", hash_generated_field = "319C101AF77107AA371577F165DF9033")

static final int TRANSACTION_onNmeaReceived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.864 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.869 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:58.873 -0500", hash_original_method = "06721DCDB08962C3850E14424C96ED0D", hash_generated_method = "E1DE0332B33D8DBB5197B4FE45B2C216")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onGpsStarted:
{
data.enforceInterface(DESCRIPTOR);
this.onGpsStarted();
return true;
}
case TRANSACTION_onGpsStopped:
{
data.enforceInterface(DESCRIPTOR);
this.onGpsStopped();
return true;
}
case TRANSACTION_onFirstFix:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onFirstFix(_arg0);
return true;
}
case TRANSACTION_onSvStatusChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int[] _arg1;
_arg1 = data.createIntArray();
float[] _arg2;
_arg2 = data.createFloatArray();
float[] _arg3;
_arg3 = data.createFloatArray();
float[] _arg4;
_arg4 = data.createFloatArray();
int _arg5;
_arg5 = data.readInt();
int _arg6;
_arg6 = data.readInt();
int _arg7;
_arg7 = data.readInt();
this.onSvStatusChanged(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
return true;
}
case TRANSACTION_onNmeaReceived:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
this.onNmeaReceived(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onGpsStarted() throws android.os.RemoteException;
public void onGpsStopped() throws android.os.RemoteException;
public void onFirstFix(int ttff) throws android.os.RemoteException;
public void onSvStatusChanged(int svCount, int[] prns, float[] snrs, float[] elevations, float[] azimuths, int ephemerisMask, int almanacMask, int usedInFixMask) throws android.os.RemoteException;
public void onNmeaReceived(long timestamp, java.lang.String nmea) throws android.os.RemoteException;
}
