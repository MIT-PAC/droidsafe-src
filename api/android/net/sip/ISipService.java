package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ISipService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.net.sip.ISipService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.652 -0500", hash_original_field = "95AA22A1F9965BC2FF76F74696BB7B70", hash_generated_field = "762F9A5A3FDB9BA8BB6A831BDC5661F1")

private static final java.lang.String DESCRIPTOR = "android.net.sip.ISipService";
/**
 * Cast an IBinder object into an android.net.sip.ISipService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.657 -0500", hash_original_method = "E867344AC76D57AE7BED12513799AFF6", hash_generated_method = "FEF3BFD5535256768A480E014D668D2D")
        
public static android.net.sip.ISipService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.sip.ISipService))) {
return ((android.net.sip.ISipService)iin);
}
return new android.net.sip.ISipService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.706 -0500", hash_original_field = "5759229C592FC14E357D14B4C89AC9A0", hash_generated_field = "09EA03F0C4FDF727C5BCAF1BAB89D4AA")

static final int TRANSACTION_open = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.709 -0500", hash_original_field = "DB25B843C7A410CAB028E51C575F4C12", hash_generated_field = "DB98447D6B95B89CDCB7CAE27AB17ECF")

static final int TRANSACTION_open3 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.711 -0500", hash_original_field = "A6BA89E55661BEA5613C6ABB523224F4", hash_generated_field = "7A485F6F1F89F5B9DD655033A0888CFB")

static final int TRANSACTION_close = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.sip.ISipService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.667 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.670 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.672 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.674 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.676 -0500", hash_original_method = "E0EAB5C31A33C2003073FFF937C61ACC", hash_generated_method = "40CD503E714111F3F404233A36C78804")
            
public void open(android.net.sip.SipProfile localProfile) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((localProfile!=null)) {
_data.writeInt(1);
localProfile.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_open, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.680 -0500", hash_original_method = "E7C4C8F314E8672679C568D0825D3254", hash_generated_method = "3215EAB8093D18A7D87E0CE62AEF0813")
            
public void open3(android.net.sip.SipProfile localProfile, android.app.PendingIntent incomingCallPendingIntent, android.net.sip.ISipSessionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((localProfile!=null)) {
_data.writeInt(1);
localProfile.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((incomingCallPendingIntent!=null)) {
_data.writeInt(1);
incomingCallPendingIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_open3, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.683 -0500", hash_original_method = "11C5121FEB655A47409EC646A890496A", hash_generated_method = "54C8CF10E838E936E0CED90F0AED4598")
            
public void close(java.lang.String localProfileUri) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(localProfileUri);
mRemote.transact(Stub.TRANSACTION_close, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.686 -0500", hash_original_method = "FBC917ADE8CAE7F46978ACA628A96132", hash_generated_method = "013959FAB3C71C100DE71A8E2F2EC91A")
            
public boolean isOpened(java.lang.String localProfileUri) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(localProfileUri);
mRemote.transact(Stub.TRANSACTION_isOpened, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.688 -0500", hash_original_method = "67FB649000A8E3225399989B6971A7C3", hash_generated_method = "66823868976E6F47A2048F65FC2AB494")
            
public boolean isRegistered(java.lang.String localProfileUri) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(localProfileUri);
mRemote.transact(Stub.TRANSACTION_isRegistered, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.692 -0500", hash_original_method = "753EF647FA2D09B8B52F7AF7FBE7B28C", hash_generated_method = "5AF6FCB7F7918D854A4B2167A1D43E50")
            
public void setRegistrationListener(java.lang.String localProfileUri, android.net.sip.ISipSessionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(localProfileUri);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setRegistrationListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.694 -0500", hash_original_method = "884EF6AD3F58ECAE9E178A4637675F76", hash_generated_method = "63CB4D273D5C406415DF5BEE7D5FA202")
            
public android.net.sip.ISipSession createSession(android.net.sip.SipProfile localProfile, android.net.sip.ISipSessionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.sip.ISipSession _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((localProfile!=null)) {
_data.writeInt(1);
localProfile.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_createSession, _data, _reply, 0);
_reply.readException();
_result = android.net.sip.ISipSession.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.697 -0500", hash_original_method = "AF15C2C60DDB595D159C99B3CDBCD04B", hash_generated_method = "5EB7F08A050BA4192EC51B45DFCF949E")
            
public android.net.sip.ISipSession getPendingSession(java.lang.String callId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.sip.ISipSession _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(callId);
mRemote.transact(Stub.TRANSACTION_getPendingSession, _data, _reply, 0);
_reply.readException();
_result = android.net.sip.ISipSession.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.700 -0500", hash_original_method = "F0BB67BE44FDDFE34D566FC500430FC5", hash_generated_method = "B89315912ABF913C6B140EFC729B5ABC")
            
public android.net.sip.SipProfile[] getListOfProfiles() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.sip.SipProfile[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getListOfProfiles, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.net.sip.SipProfile.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.713 -0500", hash_original_field = "A798EC5AC551A6B5FAF18BE8EEF19456", hash_generated_field = "57CD4F63E1CD6CA68773E494EF0C0779")

static final int TRANSACTION_isOpened = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.715 -0500", hash_original_field = "4927B00A49B9946CFA62094E921FE045", hash_generated_field = "2413B0F9AA6FB2E3006C4E3B5D229390")

static final int TRANSACTION_isRegistered = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.718 -0500", hash_original_field = "06ED25EA7D4B97F756670840753FFDA1", hash_generated_field = "E2188B258212C0CB0AD055F81D51C640")

static final int TRANSACTION_setRegistrationListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.720 -0500", hash_original_field = "713D0AA026DFF565359A790A070C2AC1", hash_generated_field = "5E01739429D58A62AF8F45FC5369DA4E")

static final int TRANSACTION_createSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.722 -0500", hash_original_field = "12D5E31F29E8BD87B79B7A763D707EFC", hash_generated_field = "434E81776E6D3C2EBC7119563FBCD896")

static final int TRANSACTION_getPendingSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.724 -0500", hash_original_field = "32C2CEC1D14395CAB609D2C78BD50304", hash_generated_field = "F2C6826A08BADB53430D3A9D7B7A832D")

static final int TRANSACTION_getListOfProfiles = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.655 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.659 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.664 -0500", hash_original_method = "FE937C92C259E3DD0303DBBADBB61C50", hash_generated_method = "C91F1075D4F0B43E02FD8966AEA2199E")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_open:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.SipProfile _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.sip.SipProfile.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.open(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_open3:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.SipProfile _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.sip.SipProfile.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.app.PendingIntent _arg1;
if ((0!=data.readInt())) {
_arg1 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.net.sip.ISipSessionListener _arg2;
_arg2 = android.net.sip.ISipSessionListener.Stub.asInterface(data.readStrongBinder());
this.open3(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_close:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.close(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isOpened:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isOpened(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isRegistered:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isRegistered(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setRegistrationListener:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.sip.ISipSessionListener _arg1;
_arg1 = android.net.sip.ISipSessionListener.Stub.asInterface(data.readStrongBinder());
this.setRegistrationListener(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_createSession:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.SipProfile _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.sip.SipProfile.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.net.sip.ISipSessionListener _arg1;
_arg1 = android.net.sip.ISipSessionListener.Stub.asInterface(data.readStrongBinder());
android.net.sip.ISipSession _result = this.createSession(_arg0, _arg1);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getPendingSession:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.net.sip.ISipSession _result = this.getPendingSession(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getListOfProfiles:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.SipProfile[] _result = this.getListOfProfiles();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void open(android.net.sip.SipProfile localProfile) throws android.os.RemoteException;
public void open3(android.net.sip.SipProfile localProfile, android.app.PendingIntent incomingCallPendingIntent, android.net.sip.ISipSessionListener listener) throws android.os.RemoteException;
public void close(java.lang.String localProfileUri) throws android.os.RemoteException;
public boolean isOpened(java.lang.String localProfileUri) throws android.os.RemoteException;
public boolean isRegistered(java.lang.String localProfileUri) throws android.os.RemoteException;
public void setRegistrationListener(java.lang.String localProfileUri, android.net.sip.ISipSessionListener listener) throws android.os.RemoteException;
public android.net.sip.ISipSession createSession(android.net.sip.SipProfile localProfile, android.net.sip.ISipSessionListener listener) throws android.os.RemoteException;
public android.net.sip.ISipSession getPendingSession(java.lang.String callId) throws android.os.RemoteException;
public android.net.sip.SipProfile[] getListOfProfiles() throws android.os.RemoteException;
}
