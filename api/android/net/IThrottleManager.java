package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IThrottleManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.net.IThrottleManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.327 -0500", hash_original_field = "7BBFCD09685A5823258EA57E25E3D3B8", hash_generated_field = "FD20CFC3C73D43929D0083D084FD29D6")

private static final java.lang.String DESCRIPTOR = "android.net.IThrottleManager";
/**
 * Cast an IBinder object into an android.net.IThrottleManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.332 -0500", hash_original_method = "308D2CE6FF4A36EF2DA3892A3D3F8A53", hash_generated_method = "6AC142673E0268E1109BAA7BC7CC2A7C")
        
public static android.net.IThrottleManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.IThrottleManager))) {
return ((android.net.IThrottleManager)iin);
}
return new android.net.IThrottleManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.373 -0500", hash_original_field = "A2F201535400563420672B01E58E6111", hash_generated_field = "907C50D67214EF5BF79FC9FDB1779CF1")

static final int TRANSACTION_getByteCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.376 -0500", hash_original_field = "F26329E1B3CAAAFC858236AF062AF963", hash_generated_field = "B1EEF2611159B75622B72B1EE16CAA93")

static final int TRANSACTION_getThrottle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.378 -0500", hash_original_field = "E123CCB9D65F6D0107EC70A9CAA750B2", hash_generated_field = "B07F7FDD6BA3175B0B7272D397D035CD")

static final int TRANSACTION_getResetTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.IThrottleManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.342 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.344 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.346 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.348 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.351 -0500", hash_original_method = "804E853879EFABE0A7C407EC049A43E7", hash_generated_method = "90CD4E8C64EEB9256229D636C26131D2")
            
public long getByteCount(java.lang.String iface, int dir, int period, int ago) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeInt(dir);
_data.writeInt(period);
_data.writeInt(ago);
mRemote.transact(Stub.TRANSACTION_getByteCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.354 -0500", hash_original_method = "A9031479038C5BE28A6701DA9457DFDB", hash_generated_method = "3E9FDDC01418042D3A227C59740ED3DA")
            
public int getThrottle(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_getThrottle, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.357 -0500", hash_original_method = "BB1A9DF2DDB395B06766B25DB9582C7F", hash_generated_method = "CAF26651A5B6742C496922DC4C560D8D")
            
public long getResetTime(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_getResetTime, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.360 -0500", hash_original_method = "8E8AD20019B90B3D381955B1F5354C46", hash_generated_method = "8A1D64E9FD33D643216C5EAE7A3C40EA")
            
public long getPeriodStartTime(java.lang.String iface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
mRemote.transact(Stub.TRANSACTION_getPeriodStartTime, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.363 -0500", hash_original_method = "C259525A9F951ADF839FDAF50A848A59", hash_generated_method = "923A8941C8B71405E5188888500355CA")
            
public long getCliffThreshold(java.lang.String iface, int cliff) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeInt(cliff);
mRemote.transact(Stub.TRANSACTION_getCliffThreshold, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.366 -0500", hash_original_method = "80B868E0463A5D70002BACD497CA9428", hash_generated_method = "CA70E541773E77296AF3B8F5FE75670E")
            
public int getCliffLevel(java.lang.String iface, int cliff) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(iface);
_data.writeInt(cliff);
mRemote.transact(Stub.TRANSACTION_getCliffLevel, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.368 -0500", hash_original_method = "793E01F31A31BA6AFEDB271E98A5093F", hash_generated_method = "01B07904C73BF14ED283FDF0F9F0BC0F")
            
public java.lang.String getHelpUri() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHelpUri, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.381 -0500", hash_original_field = "90660BE4775086AFF057017F33080EE8", hash_generated_field = "F089CEDC080D615E5C68E15F618C786D")

static final int TRANSACTION_getPeriodStartTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.383 -0500", hash_original_field = "6DAD7EA7A6ACF89F3E95B1A5200BCA3E", hash_generated_field = "F036A8A031C18AD716BB72402498D2D2")

static final int TRANSACTION_getCliffThreshold = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.385 -0500", hash_original_field = "C7055F3E4EB3112514E7068D7076A5E9", hash_generated_field = "A245304B3A91A52806A04E6FFA052701")

static final int TRANSACTION_getCliffLevel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.388 -0500", hash_original_field = "8C8AC2D3D1E4C4256B0FC78877CF7585", hash_generated_field = "4D125C7677ED618CE700A90BA94A39A2")

static final int TRANSACTION_getHelpUri = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.330 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.334 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.339 -0500", hash_original_method = "C5435AF725E7FBCC736FD6AC8778C37B", hash_generated_method = "B1E700EC6B75E09737E29A892D7B9A1B")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getByteCount:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
long _result = this.getByteCount(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_getThrottle:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getThrottle(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getResetTime:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _result = this.getResetTime(_arg0);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_getPeriodStartTime:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _result = this.getPeriodStartTime(_arg0);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_getCliffThreshold:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
long _result = this.getCliffThreshold(_arg0, _arg1);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_getCliffLevel:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _result = this.getCliffLevel(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getHelpUri:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getHelpUri();
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public long getByteCount(java.lang.String iface, int dir, int period, int ago) throws android.os.RemoteException;
public int getThrottle(java.lang.String iface) throws android.os.RemoteException;
public long getResetTime(java.lang.String iface) throws android.os.RemoteException;
public long getPeriodStartTime(java.lang.String iface) throws android.os.RemoteException;
public long getCliffThreshold(java.lang.String iface, int cliff) throws android.os.RemoteException;
public int getCliffLevel(java.lang.String iface, int cliff) throws android.os.RemoteException;
public java.lang.String getHelpUri() throws android.os.RemoteException;
}
