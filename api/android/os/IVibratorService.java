package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IVibratorService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.os.IVibratorService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.387 -0500", hash_original_field = "517BFE6B3B68E26A40D0303571E062CE", hash_generated_field = "D599B982B6DFABA3A65BA8800FCB6DF9")

private static final java.lang.String DESCRIPTOR = "android.os.IVibratorService";
/**
 * Cast an IBinder object into an android.os.IVibratorService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.392 -0500", hash_original_method = "BB7C7C0491D79FA1DA363469B2BF9F14", hash_generated_method = "EEBF792954FB3B26605252DDD1C06A75")
        
public static android.os.IVibratorService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.os.IVibratorService))) {
return ((android.os.IVibratorService)iin);
}
return new android.os.IVibratorService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.423 -0500", hash_original_field = "F085B426ADA2055EBFA45958D8E40B81", hash_generated_field = "C411785D2FBD77236D5AADFE1E9B8B3C")

static final int TRANSACTION_hasVibrator = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.426 -0500", hash_original_field = "6A43C956B96ADC0CBD831211512D18BC", hash_generated_field = "971992D3D088401C4501F47B0EF7BFC9")

static final int TRANSACTION_vibrate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.428 -0500", hash_original_field = "A240D30B3BBA6A24E6B8602EA3EBC92E", hash_generated_field = "16FBD939770064FFD254E09990B0EDFA")

static final int TRANSACTION_vibratePattern = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.os.IVibratorService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.401 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.403 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.405 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.407 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.410 -0500", hash_original_method = "F6F11590FE2298EB3A400215986B778D", hash_generated_method = "D12D38334943393C91B4165BC5EFBE38")
            
public boolean hasVibrator() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hasVibrator, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.412 -0500", hash_original_method = "3BDFE0807A260B84C8BCA6F9D598D370", hash_generated_method = "F129396452ECE74614A537CABA1B4230")
            
public void vibrate(long milliseconds, android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(milliseconds);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_vibrate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.416 -0500", hash_original_method = "48821EA601DFEA5AA5ADCC2215010C21", hash_generated_method = "D7DB64C46CE09B5F722B4F552E2C2A80")
            
public void vibratePattern(long[] pattern, int repeat, android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLongArray(pattern);
_data.writeInt(repeat);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_vibratePattern, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.419 -0500", hash_original_method = "7EF87F6423F3624FB2AA95060E91AA15", hash_generated_method = "00D80B114D452F3ADF048A9D0D7F1203")
            
public void cancelVibrate(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_cancelVibrate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.430 -0500", hash_original_field = "5615FD07A278F39CB355FBCA0B90DE81", hash_generated_field = "6677B1015038720143EE76D221DEACA4")

static final int TRANSACTION_cancelVibrate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.389 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.394 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.397 -0500", hash_original_method = "3BA45031E80328C7F2338242CA245C39", hash_generated_method = "3B21D679035ADC4613D9C077BB1201BA")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_hasVibrator:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasVibrator();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_vibrate:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
this.vibrate(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_vibratePattern:
{
data.enforceInterface(DESCRIPTOR);
long[] _arg0;
_arg0 = data.createLongArray();
int _arg1;
_arg1 = data.readInt();
android.os.IBinder _arg2;
_arg2 = data.readStrongBinder();
this.vibratePattern(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_cancelVibrate:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.cancelVibrate(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public boolean hasVibrator() throws android.os.RemoteException;
public void vibrate(long milliseconds, android.os.IBinder token) throws android.os.RemoteException;
public void vibratePattern(long[] pattern, int repeat, android.os.IBinder token) throws android.os.RemoteException;
public void cancelVibrate(android.os.IBinder token) throws android.os.RemoteException;
}
