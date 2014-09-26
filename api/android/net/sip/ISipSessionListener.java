package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ISipSessionListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.net.sip.ISipSessionListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.673 -0500", hash_original_field = "91387B0464ABCF09C35F539DE3EF9711", hash_generated_field = "0516AD24C1D9437E17BE3F039BDECD6D")

private static final java.lang.String DESCRIPTOR = "android.net.sip.ISipSessionListener";
/**
 * Cast an IBinder object into an android.net.sip.ISipSessionListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.679 -0500", hash_original_method = "DC2E27B3FEFEAC3046A8C25DDC04A10D", hash_generated_method = "8377079CCBC876A9D0CD24DC71A0FB40")
        
public static android.net.sip.ISipSessionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.sip.ISipSessionListener))) {
return ((android.net.sip.ISipSessionListener)iin);
}
return new android.net.sip.ISipSessionListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.739 -0500", hash_original_field = "19069CBD67953420FE039B64F538965B", hash_generated_field = "1A6E26CF84B565BCE1CC6C4EDA59A717")

static final int TRANSACTION_onCalling = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.741 -0500", hash_original_field = "1E52FBE6396FF925C3F6933E5A4EE4AF", hash_generated_field = "B407074E16B74E5C049394D643FABF4A")

static final int TRANSACTION_onRinging = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.743 -0500", hash_original_field = "BCE41F84073A0451030934F8E13E808F", hash_generated_field = "17808699D188220CC4EB8D3A8DF2487B")

static final int TRANSACTION_onRingingBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.sip.ISipSessionListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.689 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.692 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.695 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.697 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Called when an INVITE request is sent to initiate a new call.
     *
     * @param session the session object that carries out the transaction
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.699 -0500", hash_original_method = "761DEFE470D7375487A75E55E83030C8", hash_generated_method = "42A9F11D99CEC8C686C671FCB1F4DE3B")
            
public void onCalling(android.net.sip.ISipSession session) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onCalling, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when an INVITE request is received.
     *
     * @param session the session object that carries out the transaction
     * @param caller the SIP profile of the caller
     * @param sessionDescription the caller's session description
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.702 -0500", hash_original_method = "1963D7EC46FAC9D90263CC0D16B8E993", hash_generated_method = "BD729882A357C81845EF52A677ABE0C1")
            
public void onRinging(android.net.sip.ISipSession session, android.net.sip.SipProfile caller, java.lang.String sessionDescription) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
if ((caller!=null)) {
_data.writeInt(1);
caller.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(sessionDescription);
mRemote.transact(Stub.TRANSACTION_onRinging, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when a RINGING response is received for the INVITE request sent
     *
     * @param session the session object that carries out the transaction
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.705 -0500", hash_original_method = "2713D0E35A1935D3F41D48C1C7F579A6", hash_generated_method = "B2A138693FE9FD208354C56638C0B303")
            
public void onRingingBack(android.net.sip.ISipSession session) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onRingingBack, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when the session is established.
     *
     * @param session the session object that is associated with the dialog
     * @param sessionDescription the peer's session description
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.708 -0500", hash_original_method = "A21D32F3C1CF12195E2EA3E294F5CB1B", hash_generated_method = "0D7B1B3ACB3E8AE61B4D95927E66EEB3")
            
public void onCallEstablished(android.net.sip.ISipSession session, java.lang.String sessionDescription) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
_data.writeString(sessionDescription);
mRemote.transact(Stub.TRANSACTION_onCallEstablished, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when the session is terminated.
     *
     * @param session the session object that is associated with the dialog
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.710 -0500", hash_original_method = "40799F3ADCC57A31E383131D63C8778F", hash_generated_method = "D455971F7B4BA0BBCA7C32A34E720B5D")
            
public void onCallEnded(android.net.sip.ISipSession session) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onCallEnded, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when the peer is busy during session initialization.
     *
     * @param session the session object that carries out the transaction
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.713 -0500", hash_original_method = "44D790E3A18B638D3871F5A2EEC09488", hash_generated_method = "182F1C8338C8AA9F97302D6D796A31C8")
            
public void onCallBusy(android.net.sip.ISipSession session) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onCallBusy, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when the call is being transferred to a new one.
     *
     * @param newSession the new session that the call will be transferred to
     * @param sessionDescription the new peer's session description
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.715 -0500", hash_original_method = "04421EA7FEBB2163D9E64796D081E257", hash_generated_method = "452513E3305A3E8F7576EE0814002BF0")
            
public void onCallTransferring(android.net.sip.ISipSession newSession, java.lang.String sessionDescription) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((newSession!=null))?(newSession.asBinder()):(null)));
_data.writeString(sessionDescription);
mRemote.transact(Stub.TRANSACTION_onCallTransferring, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when an error occurs during session initialization and
     * termination.
     *
     * @param session the session object that carries out the transaction
     * @param errorCode error code defined in {@link SipErrorCode}
     * @param errorMessage error message
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.718 -0500", hash_original_method = "0BD912CCA877C51B95421544F3142456", hash_generated_method = "A6E1A5F3FDACAC4219EF1CF014B6CB57")
            
public void onError(android.net.sip.ISipSession session, int errorCode, java.lang.String errorMessage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
_data.writeInt(errorCode);
_data.writeString(errorMessage);
mRemote.transact(Stub.TRANSACTION_onError, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when an error occurs during session modification negotiation.
     *
     * @param session the session object that carries out the transaction
     * @param errorCode error code defined in {@link SipErrorCode}
     * @param errorMessage error message
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.721 -0500", hash_original_method = "25E7D2AD65D6CA798C113C35EF60E3D3", hash_generated_method = "5520FFEEF20790C49626AB50E8745167")
            
public void onCallChangeFailed(android.net.sip.ISipSession session, int errorCode, java.lang.String errorMessage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
_data.writeInt(errorCode);
_data.writeString(errorMessage);
mRemote.transact(Stub.TRANSACTION_onCallChangeFailed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when a registration request is sent.
     *
     * @param session the session object that carries out the transaction
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.724 -0500", hash_original_method = "EE227007666629D18CC82F10AB08ECB2", hash_generated_method = "B9BB83F8BC489287718E9D232398AF6F")
            
public void onRegistering(android.net.sip.ISipSession session) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onRegistering, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when registration is successfully done.
     *
     * @param session the session object that carries out the transaction
     * @param duration duration in second before the registration expires
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.727 -0500", hash_original_method = "0DF66C8678F5E7B56AD6324DBDE7829C", hash_generated_method = "B56281405C21412CD6F869C8F1A1D882")
            
public void onRegistrationDone(android.net.sip.ISipSession session, int duration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
_data.writeInt(duration);
mRemote.transact(Stub.TRANSACTION_onRegistrationDone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when the registration fails.
     *
     * @param session the session object that carries out the transaction
     * @param errorCode error code defined in {@link SipErrorCode}
     * @param errorMessage error message
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.730 -0500", hash_original_method = "35EF36F5DA39F334174D31E2A9CBCE4A", hash_generated_method = "B342D094C750DB9610C8D0840E7E235E")
            
public void onRegistrationFailed(android.net.sip.ISipSession session, int errorCode, java.lang.String errorMessage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
_data.writeInt(errorCode);
_data.writeString(errorMessage);
mRemote.transact(Stub.TRANSACTION_onRegistrationFailed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called when the registration gets timed out.
     *
     * @param session the session object that carries out the transaction
     */
@DSSink({DSSinkKind.VOIP})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.732 -0500", hash_original_method = "C9BAB9B532E37BF39F5CA1664FA819D1", hash_generated_method = "EBC31CD02A03573E4F7DA40434BF3AED")
            
public void onRegistrationTimeout(android.net.sip.ISipSession session) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onRegistrationTimeout, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.746 -0500", hash_original_field = "CFA5EE9E53DFD6EC762E8D4DF3ECF914", hash_generated_field = "E8FA9106975FE61B6C74C6E68B98286B")

static final int TRANSACTION_onCallEstablished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.748 -0500", hash_original_field = "AE557E391C4ECC1F972331D0A36413F3", hash_generated_field = "220F474DC2A5BC17ED3B27F8F319E9F4")

static final int TRANSACTION_onCallEnded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.751 -0500", hash_original_field = "1D4EFF490A2EEEEB3145D31C3EBB0172", hash_generated_field = "5F5D737AC017D0D02C866A8F672C36D6")

static final int TRANSACTION_onCallBusy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.754 -0500", hash_original_field = "FA1D1FA15C80B6FE578EDA7AA7D97953", hash_generated_field = "7D4C8166587F1CE3C95686380AF854D6")

static final int TRANSACTION_onCallTransferring = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.756 -0500", hash_original_field = "329B5CEC0C1989D76E3CC70F284D3C31", hash_generated_field = "062F9E97EC56A3145716BA68D00B54A7")

static final int TRANSACTION_onError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.758 -0500", hash_original_field = "E8C9A5EE6D5BECF3FF2648AA7879AFF9", hash_generated_field = "84AAB03FA83F15C1A3AF70D26CAF9985")

static final int TRANSACTION_onCallChangeFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.760 -0500", hash_original_field = "FC2BDF0EDFCC99D3B94F7608634F6FDC", hash_generated_field = "4B254C714CCAFA6796CAAAA792B21839")

static final int TRANSACTION_onRegistering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.762 -0500", hash_original_field = "14C1AE0A80280CA29BE677C0B5DC4C04", hash_generated_field = "3255B1F93C32ED827F87F12D9190C645")

static final int TRANSACTION_onRegistrationDone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.765 -0500", hash_original_field = "BAA4C4B5FA1FD21AA0D12A9F910C1D96", hash_generated_field = "4016B1B67707B2EB37345645180052B4")

static final int TRANSACTION_onRegistrationFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.768 -0500", hash_original_field = "A5C225E14820B70B81579B022E27F759", hash_generated_field = "1DBFCDB0839C5D4F3F351449EFC63207")

static final int TRANSACTION_onRegistrationTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.677 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.681 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.686 -0500", hash_original_method = "48B8D117326ED6B3786792D210EB20DF", hash_generated_method = "D32948E06A4E83AEB91B691B376B5D15")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onCalling:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
this.onCalling(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onRinging:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
android.net.sip.SipProfile _arg1;
if ((0!=data.readInt())) {
_arg1 = android.net.sip.SipProfile.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String _arg2;
_arg2 = data.readString();
this.onRinging(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onRingingBack:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
this.onRingingBack(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onCallEstablished:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
this.onCallEstablished(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onCallEnded:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
this.onCallEnded(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onCallBusy:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
this.onCallBusy(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onCallTransferring:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
this.onCallTransferring(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onError:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
this.onError(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onCallChangeFailed:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
this.onCallChangeFailed(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onRegistering:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
this.onRegistering(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onRegistrationDone:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
this.onRegistrationDone(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onRegistrationFailed:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
this.onRegistrationFailed(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onRegistrationTimeout:
{
data.enforceInterface(DESCRIPTOR);
android.net.sip.ISipSession _arg0;
_arg0 = android.net.sip.ISipSession.Stub.asInterface(data.readStrongBinder());
this.onRegistrationTimeout(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void onCalling(android.net.sip.ISipSession session) throws android.os.RemoteException;

public void onRinging(android.net.sip.ISipSession session, android.net.sip.SipProfile caller, java.lang.String sessionDescription) throws android.os.RemoteException;

public void onRingingBack(android.net.sip.ISipSession session) throws android.os.RemoteException;

public void onCallEstablished(android.net.sip.ISipSession session, java.lang.String sessionDescription) throws android.os.RemoteException;

public void onCallEnded(android.net.sip.ISipSession session) throws android.os.RemoteException;

public void onCallBusy(android.net.sip.ISipSession session) throws android.os.RemoteException;

public void onCallTransferring(android.net.sip.ISipSession newSession, java.lang.String sessionDescription) throws android.os.RemoteException;

public void onError(android.net.sip.ISipSession session, int errorCode, java.lang.String errorMessage) throws android.os.RemoteException;

public void onCallChangeFailed(android.net.sip.ISipSession session, int errorCode, java.lang.String errorMessage) throws android.os.RemoteException;

public void onRegistering(android.net.sip.ISipSession session) throws android.os.RemoteException;

public void onRegistrationDone(android.net.sip.ISipSession session, int duration) throws android.os.RemoteException;

public void onRegistrationFailed(android.net.sip.ISipSession session, int errorCode, java.lang.String errorMessage) throws android.os.RemoteException;

public void onRegistrationTimeout(android.net.sip.ISipSession session) throws android.os.RemoteException;
}
