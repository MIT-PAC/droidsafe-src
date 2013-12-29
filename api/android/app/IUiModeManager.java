package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IUiModeManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IUiModeManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.853 -0500", hash_original_field = "FD3ACC8D85E31E2E909861AD759B9CB1", hash_generated_field = "C3D44F7D18F73E3881EEEA31EAD48290")

private static final java.lang.String DESCRIPTOR = "android.app.IUiModeManager";
/**
 * Cast an IBinder object into an android.app.IUiModeManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.855 -0500", hash_original_method = "DD0AFDD78BF38DC8157359A8F34EBBDC", hash_generated_method = "A5B240179D1A6488227DF1C13820A7CE")
        public static android.app.IUiModeManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IUiModeManager))) {
return ((android.app.IUiModeManager)iin);
}
return new android.app.IUiModeManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.867 -0500", hash_original_field = "C6397067BED62C6C5341E218A57CFDE4", hash_generated_field = "E2D3135D2ECFA66A4726FFE55319BE2F")

static final int TRANSACTION_enableCarMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.868 -0500", hash_original_field = "7EEC90C756E217A3DE930D82EE2FC875", hash_generated_field = "A6DF670045DF8B10CB4B7F74C3DC53E6")

static final int TRANSACTION_disableCarMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.869 -0500", hash_original_field = "F2B119807EB110407588D4DF3F399AAA", hash_generated_field = "8F3FBB9BF4EF6D754E38A2A14A025484")

static final int TRANSACTION_getCurrentModeType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.IUiModeManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.858 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.859 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.860 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.861 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Enables the car mode. Only the system can do this.
     * @hide
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.862 -0500", hash_original_method = "C5F323F16AD98C6B60C43FBA98426CE6", hash_generated_method = "FBC5AD9B5D38FB6CD90C2D245EB01064")
            public void enableCarMode(int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_enableCarMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Disables the car mode.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.863 -0500", hash_original_method = "8E48413C20FA7567364234C5AD4D4EE1", hash_generated_method = "67FE653ACA3EECD472CA32D33626C58B")
            public void disableCarMode(int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_disableCarMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Return the current running mode.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.864 -0500", hash_original_method = "6CB427398EC24BA8943FAF32B2C558EE", hash_generated_method = "FAEBB14967F9AA8C25730570EA84BF88")
            public int getCurrentModeType() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentModeType, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Sets the night mode.
     * The mode can be one of:
     *   1 - notnight mode
     *   2 - night mode
     *   3 - automatic mode switching
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.865 -0500", hash_original_method = "71E3D78902EFCE6D5A4990D7C4EC6D3B", hash_generated_method = "EB3E2DD796B54ED74912A343EC8C9258")
            public void setNightMode(int mode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mode);
mRemote.transact(Stub.TRANSACTION_setNightMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Gets the currently configured night mode.  Return 1 for notnight,
     * 2 for night, and 3 for automatic mode switching.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.866 -0500", hash_original_method = "45038D1123405D8086E583C427BCDE5E", hash_generated_method = "D333D579A4B5B126CDFEB1204176352E")
            public int getNightMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNightMode, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.870 -0500", hash_original_field = "0EB688BD639ED5EE4DBE3800E4F38B7C", hash_generated_field = "44FD9A23A519221216A6E37301CA28E1")

static final int TRANSACTION_setNightMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.871 -0500", hash_original_field = "2CEA14FB514C8BC1DDB5CDC97B578282", hash_generated_field = "82BDD58B425A25ADC0F152C4E5D499EE")

static final int TRANSACTION_getNightMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.854 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.856 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:14.857 -0500", hash_original_method = "878788D6966E17A37BB51D4EDC515904", hash_generated_method = "B70CE9B195CF2D7909F9EB0226C9E693")
        @Override
public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_enableCarMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.enableCarMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_disableCarMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.disableCarMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getCurrentModeType:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCurrentModeType();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setNightMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setNightMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getNightMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getNightMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void enableCarMode(int flags) throws android.os.RemoteException;

public void disableCarMode(int flags) throws android.os.RemoteException;

public int getCurrentModeType() throws android.os.RemoteException;

public void setNightMode(int mode) throws android.os.RemoteException;

public int getNightMode() throws android.os.RemoteException;
}
