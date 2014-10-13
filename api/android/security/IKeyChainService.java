package android.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IKeyChainService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.security.IKeyChainService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.026 -0500", hash_original_field = "8F41D6158234114136221888DCF9D28E", hash_generated_field = "605E9006DEF2D8FCC87DF364946A4370")

private static final java.lang.String DESCRIPTOR = "android.security.IKeyChainService";
/**
 * Cast an IBinder object into an android.security.IKeyChainService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.033 -0500", hash_original_method = "AFA5DA603FFEA53F86D54A9C044CC989", hash_generated_method = "DFF12E106AB7B45313CC23B1D5F8C35C")
        
public static android.security.IKeyChainService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.security.IKeyChainService))) {
return ((android.security.IKeyChainService)iin);
}
return new android.security.IKeyChainService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.084 -0500", hash_original_field = "AC413EC72F4E49B84B93FF1CF9FE7463", hash_generated_field = "72569D27AB41D87AB662177934EF82A9")

static final int TRANSACTION_getPrivateKey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.087 -0500", hash_original_field = "D0CFD5A6FDA31DFD2D11BA477858895B", hash_generated_field = "D3ECEE7EEFEE069ACD65B322626AC6BF")

static final int TRANSACTION_getCertificate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.090 -0500", hash_original_field = "261E90AC920646BF665F53ED9BA9D5B6", hash_generated_field = "17284911EEB286FE1578460214444CEE")

static final int TRANSACTION_installCaCertificate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.security.IKeyChainService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.044 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.047 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.050 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.053 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
// APIs used by KeyChain

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.057 -0500", hash_original_method = "E1E7376FCFFA703FA6DE594390338A17", hash_generated_method = "26E8233BF3D0A53BA89F08BE21A6AB16")
            
public byte[] getPrivateKey(java.lang.String alias) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(alias);
mRemote.transact(Stub.TRANSACTION_getPrivateKey, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.060 -0500", hash_original_method = "85837FBC16C4ABC19A4F56F7E6AD5AB4", hash_generated_method = "FA3C2E57C7CC5996B38ED109F545A44B")
            
public byte[] getCertificate(java.lang.String alias) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(alias);
mRemote.transact(Stub.TRANSACTION_getCertificate, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// APIs used by CertInstaller

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.064 -0500", hash_original_method = "245FC35906A30F772EEEE02A5918A89C", hash_generated_method = "3F850A42C42581408269FE34F76B9E32")
            
public void installCaCertificate(byte[] caCertificate) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(caCertificate);
mRemote.transact(Stub.TRANSACTION_installCaCertificate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// APIs used by Settings

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.067 -0500", hash_original_method = "3AA415B0B68B0DB492154E015C895C01", hash_generated_method = "FB9BEAE583E3C3E70B3F90BE7FCB6F8E")
            
public boolean deleteCaCertificate(java.lang.String alias) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(alias);
mRemote.transact(Stub.TRANSACTION_deleteCaCertificate, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.071 -0500", hash_original_method = "69204C301BFA18E2C1554535A64AF029", hash_generated_method = "52CCBBB8CA1154496D9A8E4F97570A1E")
            
public boolean reset() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reset, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// APIs used by KeyChainActivity

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.074 -0500", hash_original_method = "2CBE6F23E8E693A240B8880FFEADF816", hash_generated_method = "00E637FE91D0D339CF04F7CBF26683CE")
            
public void setGrant(int uid, java.lang.String alias, boolean value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeString(alias);
_data.writeInt(((value)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setGrant, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.077 -0500", hash_original_method = "37A67393E120257362C1B9EDA8C5BD70", hash_generated_method = "6FC632203D6C0AB4123CF8CD7DE616A6")
            
public boolean hasGrant(int uid, java.lang.String alias) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeString(alias);
mRemote.transact(Stub.TRANSACTION_hasGrant, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.093 -0500", hash_original_field = "362DE6EB2D7464DA005EB282429CBD01", hash_generated_field = "869E161EEA8512F3059A2C1AB2A1EA86")

static final int TRANSACTION_deleteCaCertificate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.096 -0500", hash_original_field = "9A3B56754F15EA5AA975A77041C9C1AB", hash_generated_field = "185F72C6BB94E1ADF1D83C1CBF7E5E69")

static final int TRANSACTION_reset = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.099 -0500", hash_original_field = "BBDA9162DAA56FB1603B0003B98E8796", hash_generated_field = "E3F3F619B0F807B4D2858FC489D27925")

static final int TRANSACTION_setGrant = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.102 -0500", hash_original_field = "77AD2F1F0372FD4959842F25731FAF2E", hash_generated_field = "1F3C92585FE776E324F06E875E6EB731")

static final int TRANSACTION_hasGrant = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.029 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.036 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.040 -0500", hash_original_method = "50E2FDA90F3F1EB3C94ED2D3835D9945", hash_generated_method = "E735C803376D7363339FC06F4092E6DF")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getPrivateKey:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _result = this.getPrivateKey(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_getCertificate:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _result = this.getCertificate(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_installCaCertificate:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
this.installCaCertificate(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_deleteCaCertificate:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.deleteCaCertificate(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reset:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reset();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setGrant:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.setGrant(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_hasGrant:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.hasGrant(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public byte[] getPrivateKey(java.lang.String alias) throws android.os.RemoteException;
public byte[] getCertificate(java.lang.String alias) throws android.os.RemoteException;

public void installCaCertificate(byte[] caCertificate) throws android.os.RemoteException;

public boolean deleteCaCertificate(java.lang.String alias) throws android.os.RemoteException;
public boolean reset() throws android.os.RemoteException;

public void setGrant(int uid, java.lang.String alias, boolean value) throws android.os.RemoteException;
public boolean hasGrant(int uid, java.lang.String alias) throws android.os.RemoteException;
}
