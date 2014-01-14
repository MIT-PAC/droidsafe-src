package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ISipSession extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.net.sip.ISipSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.171 -0500", hash_original_field = "2E1C48F44A237CB291DAEB9219A8262C", hash_generated_field = "17CCA768F87BBFCA0A03AEDAF0117B40")

private static final java.lang.String DESCRIPTOR = "android.net.sip.ISipSession";
/**
 * Cast an IBinder object into an android.net.sip.ISipSession interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.176 -0500", hash_original_method = "0536BF331CF39F60907DFDBA8591E14F", hash_generated_method = "2F39D36301360D126776F07362400E97")
        
public static android.net.sip.ISipSession asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.sip.ISipSession))) {
return ((android.net.sip.ISipSession)iin);
}
return new android.net.sip.ISipSession.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.235 -0500", hash_original_field = "1C230B2596C4A5054F048BE367A6E4F1", hash_generated_field = "7C3981D47584354B86097622F33A9F0C")

static final int TRANSACTION_getLocalIp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.237 -0500", hash_original_field = "44FD7ABFAE8EA70CB2CA458A9EF1F3CA", hash_generated_field = "67E1A803842A1168CCA4F9938FDCB0D4")

static final int TRANSACTION_getLocalProfile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.239 -0500", hash_original_field = "C1C43D2AC9AB2224BEBD04F3751CE167", hash_generated_field = "C9F85BE6B0E2C12F7B1FCE56E0E28A92")

static final int TRANSACTION_getPeerProfile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.sip.ISipSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.186 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.189 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.191 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.193 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Gets the IP address of the local host on which this SIP session runs.
     *
     * @return the IP address of the local host
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.195 -0500", hash_original_method = "119AA0417FC14367E8644BD854E0663E", hash_generated_method = "DAD36025ED61F0EF17141DA6F3FD353E")
            
public java.lang.String getLocalIp() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLocalIp, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Gets the SIP profile that this session is associated with.
     *
     * @return the SIP profile that this session is associated with
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.198 -0500", hash_original_method = "CC2C3FF2B88274524049F3DA6FA6ABD7", hash_generated_method = "0F81B2F785EE524E3F881060C96E1B64")
            
public android.net.sip.SipProfile getLocalProfile() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.sip.SipProfile _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLocalProfile, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.sip.SipProfile.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Gets the SIP profile that this session is connected to. Only available
     * when the session is associated with a SIP dialog.
     *
     * @return the SIP profile that this session is connected to
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.201 -0500", hash_original_method = "7C1A0C491046BEBAC3253D510228C498", hash_generated_method = "C9C72E79EC74D027FE87B2ACEFE06CF3")
            
public android.net.sip.SipProfile getPeerProfile() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.sip.SipProfile _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPeerProfile, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.sip.SipProfile.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Gets the session state. The value returned must be one of the states in
     * {@link SipSessionState}.
     *
     * @return the session state
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.204 -0500", hash_original_method = "34C8BE8866555A4E37FB3BE07D3804F6", hash_generated_method = "52D8D043CF1FF87ECD04698A0AB87331")
            
public int getState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getState, _data, _reply, 0);
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
     * Checks if the session is in a call.
     *
     * @return true if the session is in a call
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.207 -0500", hash_original_method = "88EE0D280934DE1933C7FDD7A01F60F9", hash_generated_method = "D0386D31FDDB3811FC7AB3DC8790C9D6")
            
public boolean isInCall() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isInCall, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Gets the call ID of the session.
     *
     * @return the call ID
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.209 -0500", hash_original_method = "6A3B61D31FB5345A87B021271D682AE5", hash_generated_method = "25AAE56B4BD6FA75D674C873F311292F")
            
public java.lang.String getCallId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCallId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Sets the listener to listen to the session events. A {@link ISipSession}
     * can only hold one listener at a time. Subsequent calls to this method
     * override the previous listener.
     *
     * @param listener to listen to the session events of this object
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.212 -0500", hash_original_method = "CAC49524625F4FDECB475043789F4BED", hash_generated_method = "06B254359AD8CA0CDAF8B36D2F0A2343")
            
public void setListener(android.net.sip.ISipSessionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Performs registration to the server specified by the associated local
     * profile. The session listener is called back upon success or failure of
     * registration. The method is only valid to call when the session state is
     * in {@link SipSessionState#READY_TO_CALL}.
     *
     * @param duration duration in second before the registration expires
     * @see ISipSessionListener
     */
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.215 -0500", hash_original_method = "A811318D1751CC81FC786BFC7E548294", hash_generated_method = "1351984165F7E631428C88A3C60F36B3")
            
public void register(int duration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(duration);
mRemote.transact(Stub.TRANSACTION_register, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Performs unregistration to the server specified by the associated local
     * profile. Unregistration is technically the same as registration with zero
     * expiration duration. The session listener is called back upon success or
     * failure of unregistration. The method is only valid to call when the
     * session state is in {@link SipSessionState#READY_TO_CALL}.
     *
     * @see ISipSessionListener
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.218 -0500", hash_original_method = "22222755E6B235BB9C58DB113262BCBE", hash_generated_method = "387652987CEB28F3D77BB139FD4F65AF")
            
public void unregister() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_unregister, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Initiates a call to the specified profile. The session listener is called
     * back upon defined session events. The method is only valid to call when
     * the session state is in {@link SipSessionState#READY_TO_CALL}.
     *
     * @param callee the SIP profile to make the call to
     * @param sessionDescription the session description of this call
     * @param timeout the session will be timed out if the call is not
     *        established within {@code timeout} seconds
     * @see ISipSessionListener
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.220 -0500", hash_original_method = "E3C247DE01EC088A9EADA01D5EC0727D", hash_generated_method = "F4921C433BB35758318E30C50E362FEA")
            
public void makeCall(android.net.sip.SipProfile callee, java.lang.String sessionDescription, int timeout) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((callee!=null)) {
_data.writeInt(1);
callee.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(sessionDescription);
_data.writeInt(timeout);
mRemote.transact(Stub.TRANSACTION_makeCall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Answers an incoming call with the specified session description. The
     * method is only valid to call when the session state is in
     * {@link SipSessionState#INCOMING_CALL}.
     *
     * @param sessionDescription the session description to answer this call
     * @param timeout the session will be timed out if the call is not
     *        established within {@code timeout} seconds
     */
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.223 -0500", hash_original_method = "5F49DB427B632074EB62B1752EFF7457", hash_generated_method = "37692A33C7F32A440FCE534AF3E86D9B")
            
public void answerCall(java.lang.String sessionDescription, int timeout) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sessionDescription);
_data.writeInt(timeout);
mRemote.transact(Stub.TRANSACTION_answerCall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Ends an established call, terminates an outgoing call or rejects an
     * incoming call. The method is only valid to call when the session state is
     * in {@link SipSessionState#IN_CALL},
     * {@link SipSessionState#INCOMING_CALL},
     * {@link SipSessionState#OUTGOING_CALL} or
     * {@link SipSessionState#OUTGOING_CALL_RING_BACK}.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.226 -0500", hash_original_method = "027721633837D9093DBB0A84C5483B06", hash_generated_method = "478C38473A7663C8D44BAF3A8ABD24CA")
            
public void endCall() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_endCall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Changes the session description during a call. The method is only valid
     * to call when the session state is in {@link SipSessionState#IN_CALL}.
     *
     * @param sessionDescription the new session description
     * @param timeout the session will be timed out if the call is not
     *        established within {@code timeout} seconds
     */
@DSSink({DSSinkKind.NETWORK})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.228 -0500", hash_original_method = "5A1C81426FAE5FAF6600D0CBE3ED07E8", hash_generated_method = "21679CD7A422C1952E62708EB178E789")
            
public void changeCall(java.lang.String sessionDescription, int timeout) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sessionDescription);
_data.writeInt(timeout);
mRemote.transact(Stub.TRANSACTION_changeCall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.241 -0500", hash_original_field = "CFB982EA0CD2961A778DB6780D8BB48C", hash_generated_field = "0744F45CF96E823A16E65396EBE49CC2")

static final int TRANSACTION_getState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.243 -0500", hash_original_field = "F0CEAAD5F98F50F3E01534B3F1BB1577", hash_generated_field = "A0425432AEE56D60A0DBC448F54E49D2")

static final int TRANSACTION_isInCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.246 -0500", hash_original_field = "E7A391C7F03417666A6B194BF1A023E6", hash_generated_field = "3E58545CEAB54EBA78799A0E37ED4E9A")

static final int TRANSACTION_getCallId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.248 -0500", hash_original_field = "C810FDB016032AE39670EF427A1237F4", hash_generated_field = "BCA2839E089A16BA9C760D3E42BD5622")

static final int TRANSACTION_setListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.251 -0500", hash_original_field = "D84E7F8D44F4D45A927BB1D0C0073E1C", hash_generated_field = "5149C08B6E9B8C4437150EB4E915CF9D")

static final int TRANSACTION_register = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.253 -0500", hash_original_field = "65430FCDA2DDCD677FFD85B5F84F8BC8", hash_generated_field = "C9B1BC667EE7E332A6D3B5E79DE28BCE")

static final int TRANSACTION_unregister = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.255 -0500", hash_original_field = "6B7F15CB5B67361472D4E9BFFC8BACBC", hash_generated_field = "C6C3FD0C1B42AD147741F9CC1689ACB4")

static final int TRANSACTION_makeCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.258 -0500", hash_original_field = "B7A227F937528943065C11D117BAF28C", hash_generated_field = "4031E05BB889D40450E4608F73000652")

static final int TRANSACTION_answerCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.260 -0500", hash_original_field = "5340220F09F49A97D853953C83B47866", hash_generated_field = "26484D96250B8D48330F410A3961A1DA")

static final int TRANSACTION_endCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.263 -0500", hash_original_field = "2A44F9CFE3EFBEAC7174DDD0EB1303AA", hash_generated_field = "7F3795CEE915435C8F6B2747F20F6D68")

static final int TRANSACTION_changeCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.174 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.178 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:27.183 -0500", hash_original_method = "B1BB77ABF74A2B9698B38716C4A15335", hash_generated_method = "0CA791B213115D8A2FEC259D75D91F10")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getLocalIp:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getLocalIp();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getLocalProfile:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.SipProfile _result = this.getLocalProfile();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPeerProfile:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.SipProfile _result = this.getPeerProfile();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isInCall:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isInCall();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getCallId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCallId();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setListener:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSessionListener _arg0;
_arg0 = android.net.sip.ISipSessionListener.Stub.asInterface(data.readStrongBinder());
this.setListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_register:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.register(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregister:
{
data.enforceInterface(DESCRIPTOR);
this.unregister();
reply.writeNoException();
return true;
}
case TRANSACTION_makeCall:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.SipProfile _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.sip.SipProfile.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.makeCall(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_answerCall:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.answerCall(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_endCall:
{
data.enforceInterface(DESCRIPTOR);
this.endCall();
reply.writeNoException();
return true;
}
case TRANSACTION_changeCall:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.changeCall(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public java.lang.String getLocalIp() throws android.os.RemoteException;

public android.net.sip.SipProfile getLocalProfile() throws android.os.RemoteException;

public android.net.sip.SipProfile getPeerProfile() throws android.os.RemoteException;

public int getState() throws android.os.RemoteException;

public boolean isInCall() throws android.os.RemoteException;

public java.lang.String getCallId() throws android.os.RemoteException;

public void setListener(android.net.sip.ISipSessionListener listener) throws android.os.RemoteException;

public void register(int duration) throws android.os.RemoteException;

public void unregister() throws android.os.RemoteException;

public void makeCall(android.net.sip.SipProfile callee, java.lang.String sessionDescription, int timeout) throws android.os.RemoteException;

public void answerCall(java.lang.String sessionDescription, int timeout) throws android.os.RemoteException;

public void endCall() throws android.os.RemoteException;

public void changeCall(java.lang.String sessionDescription, int timeout) throws android.os.RemoteException;
}
