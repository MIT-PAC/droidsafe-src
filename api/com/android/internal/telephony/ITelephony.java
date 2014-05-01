package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ITelephony extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.ITelephony
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.323 -0500", hash_original_field = "C37B5523F42A4847EEA79BEFAF203E7C", hash_generated_field = "0B9B656BEF8AA34A30400C51580EE76E")

private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.ITelephony";
/**
 * Cast an IBinder object into an com.android.internal.telephony.ITelephony interface,
 * generating a proxy if needed.
 */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.329 -0500", hash_original_method = "38D7450F09BFFEDD74D63D4EDA496DF5", hash_generated_method = "E55A4A190D898818E1EB3AB99495F477")
        
public static com.android.internal.telephony.ITelephony asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.ITelephony))) {
return ((com.android.internal.telephony.ITelephony)iin);
}
return new com.android.internal.telephony.ITelephony.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.477 -0500", hash_original_field = "E6D3999D79F449506FC94E3934FC85EB", hash_generated_field = "431EE237DDC5EB6ADF0064B09F3A3968")

static final int TRANSACTION_dial = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.480 -0500", hash_original_field = "ED6DF249BB0622DD24E7645C2F9CFA6C", hash_generated_field = "73B95D8F0FCD7BD0C0408BAB86CC7C11")

static final int TRANSACTION_call = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.483 -0500", hash_original_field = "3D9CCA35DFACD52295F312D7933C435C", hash_generated_field = "1ADECAD901E1F84231209485415BFB51")

static final int TRANSACTION_showCallScreen = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.telephony.ITelephony
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.342 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.345 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.348 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.351 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Dial a number. This doesn't place the call. It displays
     * the Dialer screen.
     * @param number the number to be dialed. If null, this
     * would display the Dialer screen with no number pre-filled.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.354 -0500", hash_original_method = "003FA1A16EAD2D2EE413F77BE362604D", hash_generated_method = "8F2D50EA0BEED8C3395B1AFA6004A124")
            
public void dial(java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_dial, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Place a call to the specified number.
     * @param number the number to be called.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.357 -0500", hash_original_method = "D6E5363A73046E1F382B3ECD81084431", hash_generated_method = "44E98AAD429DF5DC66489E766205E961")
            
public void call(java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_call, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * If there is currently a call in progress, show the call screen.
     * The DTMF dialpad may or may not be visible initially, depending on
     * whether it was up when the user last exited the InCallScreen.
     *
     * @return true if the call screen was shown.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.360 -0500", hash_original_method = "72196DFCBD47FCD5CA243C168133D1AB", hash_generated_method = "7523B2B429301BC9CCDC3328A5845402")
            
public boolean showCallScreen() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_showCallScreen, _data, _reply, 0);
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
     * Variation of showCallScreen() that also specifies whether the
     * DTMF dialpad should be initially visible when the InCallScreen
     * comes up.
     *
     * @param showDialpad if true, make the dialpad visible initially,
     *                    otherwise hide the dialpad initially.
     * @return true if the call screen was shown.
     *
     * @see showCallScreen
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.362 -0500", hash_original_method = "4A189D6540C9917BDE8E9A28A89A401A", hash_generated_method = "6D1EA7058F7A7E77302E560C17304E02")
            
public boolean showCallScreenWithDialpad(boolean showDialpad) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((showDialpad)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_showCallScreenWithDialpad, _data, _reply, 0);
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
     * End call if there is a call in progress, otherwise does nothing.
     *
     * @return whether it hung up
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.365 -0500", hash_original_method = "7370292ACBE719AEB4DF3409032E7F5A", hash_generated_method = "ECEEAC3588DF32FC1A67DCDDE4830D08")
            
public boolean endCall() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_endCall, _data, _reply, 0);
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
     * Answer the currently-ringing call.
     *
     * If there's already a current active call, that call will be
     * automatically put on hold.  If both lines are currently in use, the
     * current active call will be ended.
     *
     * TODO: provide a flag to let the caller specify what policy to use
     * if both lines are in use.  (The current behavior is hardwired to
     * "answer incoming, end ongoing", which is how the CALL button
     * is specced to behave.)
     *
     * TODO: this should be a oneway call (especially since it's called
     * directly from the key queue thread).
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.367 -0500", hash_original_method = "1D29003944C551581D208D11C95AD7B1", hash_generated_method = "6A74FE3AF0407DEAFA7D20D9C934A814")
            
public void answerRingingCall() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_answerRingingCall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Silence the ringer if an incoming call is currently ringing.
     * (If vibrating, stop the vibrator also.)
     *
     * It's safe to call this if the ringer has already been silenced, or
     * even if there's no incoming call.  (If so, this method will do nothing.)
     *
     * TODO: this should be a oneway call too (see above).
     *       (Actually *all* the methods here that return void can
     *       probably be oneway.)
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.370 -0500", hash_original_method = "2E0BF4ADAFF862D8682875B71842F214", hash_generated_method = "BDA1B50F8758EBA58B5F9D6D657EF5D2")
            
public void silenceRinger() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_silenceRinger, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Check if we are in either an active or holding call
     * @return true if the phone state is OFFHOOK.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.373 -0500", hash_original_method = "DD17206BCFD526853F70E9A4A82E0E98", hash_generated_method = "DFB0B96F8BAD30BAFDC7583784139F71")
            
public boolean isOffhook() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isOffhook, _data, _reply, 0);
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
     * Check if an incoming phone call is ringing or call waiting.
     * @return true if the phone state is RINGING.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.377 -0500", hash_original_method = "DAE22FA7C7CA3360A5EBF2DE7EF5233B", hash_generated_method = "E1337C6F424E639056294BD02F9DF138")
            
public boolean isRinging() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isRinging, _data, _reply, 0);
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
     * Check if the phone is idle.
     * @return true if the phone state is IDLE.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.379 -0500", hash_original_method = "DBC5D9EEE1A20C2B0EDF19A089418008", hash_generated_method = "FC1B5C2E744FB07D224957905A2BE48B")
            
public boolean isIdle() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isIdle, _data, _reply, 0);
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
     * Check to see if the radio is on or not.
     * @return returns true if the radio is on.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.382 -0500", hash_original_method = "F302F257E5F5527059424D43E6340045", hash_generated_method = "0D69625C5398C6947B91AE212DF1800D")
            
public boolean isRadioOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isRadioOn, _data, _reply, 0);
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
     * Check if the SIM pin lock is enabled.
     * @return true if the SIM pin lock is enabled.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.385 -0500", hash_original_method = "30E7DCB127AABE21603BFCBBBF57CBD6", hash_generated_method = "55E44EAB57D376B1594F4DCA25560F59")
            
public boolean isSimPinEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isSimPinEnabled, _data, _reply, 0);
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
     * Cancels the missed calls notification.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.388 -0500", hash_original_method = "A084FC4E1FBDA2E8658C9C081D2EE0EC", hash_generated_method = "151F1BB1314BD09AFC3369141B04607C")
            
public void cancelMissedCallsNotification() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_cancelMissedCallsNotification, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Supply a pin to unlock the SIM.  Blocks until a result is determined.
     * @param pin The pin to check.
     * @return whether the operation was a success.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.390 -0500", hash_original_method = "ED84B459A179E193688C0E44C9D68E21", hash_generated_method = "2925A190FD6A3654AB26163935D0B226")
            
public boolean supplyPin(java.lang.String pin) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pin);
mRemote.transact(Stub.TRANSACTION_supplyPin, _data, _reply, 0);
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
     * Supply puk to unlock the SIM and set SIM pin to new pin.
     *  Blocks until a result is determined.
     * @param puk The puk to check.
     *        pin The new pin to be set in SIM
     * @return whether the operation was a success.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.393 -0500", hash_original_method = "8D56D5A5FEC6AF92C6D4D5AE842C4BC7", hash_generated_method = "2D06224763C07EE638A3402C474DA63B")
            
public boolean supplyPuk(java.lang.String puk, java.lang.String pin) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(puk);
_data.writeString(pin);
mRemote.transact(Stub.TRANSACTION_supplyPuk, _data, _reply, 0);
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
     * Handles PIN MMI commands (PIN/PIN2/PUK/PUK2), which are initiated
     * without SEND (so <code>dial</code> is not appropriate).
     *
     * @param dialString the MMI command to be executed.
     * @return true if MMI command is executed.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.396 -0500", hash_original_method = "1DB9D81C4A3FD70E32BC316E3DCA2E51", hash_generated_method = "9282EDDB6E7B5622AC951A2B3067A87C")
            
public boolean handlePinMmi(java.lang.String dialString) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(dialString);
mRemote.transact(Stub.TRANSACTION_handlePinMmi, _data, _reply, 0);
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
     * Toggles the radio on or off.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.400 -0500", hash_original_method = "519C6B2E48540A7C3726C97800EC28CB", hash_generated_method = "F223825EECA3B649EF8E80B095B7F2EC")
            
public void toggleRadioOnOff() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_toggleRadioOnOff, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set the radio to on or off
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.402 -0500", hash_original_method = "C9B04F361F6C128B0681AD7ACF4CFE5F", hash_generated_method = "0097B3D7BE79C6467934C6F1A06927B0")
            
public boolean setRadio(boolean turnOn) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((turnOn)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setRadio, _data, _reply, 0);
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
     * Request to update location information in service state
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.405 -0500", hash_original_method = "DB06353AD188F9009F2B07EB89B54E9C", hash_generated_method = "C66569EB04CAFF360C7CF05C7989BC10")
            
public void updateServiceLocation() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_updateServiceLocation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Enable location update notifications.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.408 -0500", hash_original_method = "BC0D48A14C443F5E25EFBFD70F6890A3", hash_generated_method = "6104F979EC3CFC49A7F1D61DEA075688")
            
public void enableLocationUpdates() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_enableLocationUpdates, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Disable location update notifications.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.410 -0500", hash_original_method = "692B3A5691EC1F36A357DEA6A9054300", hash_generated_method = "400863E39F6BA1871A3CA0F9C2289B8E")
            
public void disableLocationUpdates() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disableLocationUpdates, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Enable a specific APN type.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.413 -0500", hash_original_method = "EBA53F7D8FD8AF8B980927A391845603", hash_generated_method = "FDFE2D65256BE842DE71F8AF87D79589")
            
public int enableApnType(java.lang.String type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(type);
mRemote.transact(Stub.TRANSACTION_enableApnType, _data, _reply, 0);
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
     * Disable a specific APN type.
     */
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.416 -0500", hash_original_method = "6650FC503684630F8C89748FCDA74E93", hash_generated_method = "1A8D2C405C3E7F59CD935AF852819334")
            
public int disableApnType(java.lang.String type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(type);
mRemote.transact(Stub.TRANSACTION_disableApnType, _data, _reply, 0);
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
     * Allow mobile data connections.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.419 -0500", hash_original_method = "ABEA709E942CB2A81DA5488AC8345B02", hash_generated_method = "AFCDD4743A548B1E082CB30AF1803F26")
            
public boolean enableDataConnectivity() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_enableDataConnectivity, _data, _reply, 0);
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
     * Disallow mobile data connections.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.422 -0500", hash_original_method = "CB5C50AF7773DE1EE0723C4117359DB8", hash_generated_method = "B2F18A5E9665874564182FA79CB86593")
            
public boolean disableDataConnectivity() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disableDataConnectivity, _data, _reply, 0);
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
     * Report whether data connectivity is possible.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.425 -0500", hash_original_method = "7E711D58755671583EDDED0FFCC4D115", hash_generated_method = "CF24EF722E14803A6E6918E541279E61")
            
public boolean isDataConnectivityPossible() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isDataConnectivityPossible, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.428 -0500", hash_original_method = "F6CDD54A3D12E036556BAD54534A1F15", hash_generated_method = "2EB675D02DADC17090B5A90EEAA263BC")
            
public android.os.Bundle getCellLocation() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Bundle _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCellLocation, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.Bundle.CREATOR.createFromParcel(_reply);
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
     * Returns the neighboring cell information of the device.
     */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.431 -0500", hash_original_method = "C32B1995B5C81B26073E92199ECBCB4B", hash_generated_method = "5C590D7A105EF2F9FA394159754259A4")
            
public java.util.List<android.telephony.NeighboringCellInfo> getNeighboringCellInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.telephony.NeighboringCellInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNeighboringCellInfo, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.telephony.NeighboringCellInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.433 -0500", hash_original_method = "752F861CFB7348040E9FB0CC8D4AE73A", hash_generated_method = "1D4DFCC3212F4A63E9BF49F4CB2CC861")
            
public int getCallState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCallState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.436 -0500", hash_original_method = "7553F156EA84D297DA3054255E129DB7", hash_generated_method = "A5534AFBED4F5494F3230B1DF5A32B18")
            
public int getDataActivity() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDataActivity, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.440 -0500", hash_original_method = "136EEAD0F130E8DFF495C2DEDE865981", hash_generated_method = "23441F62D71419C3B543FC993750E7A3")
            
public int getDataState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDataState, _data, _reply, 0);
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
     * Returns the current active phone type as integer.
     * Returns TelephonyManager.PHONE_TYPE_CDMA if RILConstants.CDMA_PHONE
     * and TelephonyManager.PHONE_TYPE_GSM if RILConstants.GSM_PHONE
     */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.442 -0500", hash_original_method = "AC08CF0CB27049DF114E2E45FCFE0F96", hash_generated_method = "910AFA78441B4125672FED33D804868B")
            
public int getActivePhoneType() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getActivePhoneType, _data, _reply, 0);
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
     * Returns the CDMA ERI icon index to display
     */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.445 -0500", hash_original_method = "ADB903AC959BF98960741DB738A46562", hash_generated_method = "D72918F4B775F2901A824DE5A3352CD6")
            
public int getCdmaEriIconIndex() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCdmaEriIconIndex, _data, _reply, 0);
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
     * Returns the CDMA ERI icon mode,
     * 0 - ON
     * 1 - FLASHING
     */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.448 -0500", hash_original_method = "8F6E280C03D616940524BFDEEE02BB6A", hash_generated_method = "6D625809C75648240B363C001980678C")
            
public int getCdmaEriIconMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCdmaEriIconMode, _data, _reply, 0);
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
     * Returns the CDMA ERI text,
     */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.451 -0500", hash_original_method = "2EE419FA3D39B7F1F24E120048C7B42C", hash_generated_method = "2476AFA1B0F86576F0E5FAC7AA9C4352")
            
public java.lang.String getCdmaEriText() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCdmaEriText, _data, _reply, 0);
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
     * Returns true if OTA service provisioning needs to run.
     * Only relevant on some technologies, others will always
     * return false.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.453 -0500", hash_original_method = "944077F3E7A6D1C68F1A13AEEF635E18", hash_generated_method = "2CF5D7F702F9B8A8AEFED0CA38ED09EF")
            
public boolean needsOtaServiceProvisioning() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_needsOtaServiceProvisioning, _data, _reply, 0);
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
      * Returns the unread count of voicemails
      */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.456 -0500", hash_original_method = "8C37C2DFEA07A2F8DD58EE7C707B85C7", hash_generated_method = "1C2931D3B98E1AD65AC68B467805163F")
            
public int getVoiceMessageCount() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVoiceMessageCount, _data, _reply, 0);
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
      * Returns the network type
      */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.459 -0500", hash_original_method = "ABA87574838366AB68E4FD524D3C6179", hash_generated_method = "21A79A110AC3A324830A0AF9634E5CB2")
            
public int getNetworkType() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNetworkType, _data, _reply, 0);
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
     * Return true if an ICC card is present
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.463 -0500", hash_original_method = "985ED6A631D613CE11D0362B80CE0895", hash_generated_method = "1D6B226855C121A120C7AB4CA6B491ED")
            
public boolean hasIccCard() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hasIccCard, _data, _reply, 0);
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
     * Return if the current radio is LTE on CDMA. This
     * is a tri-state return value as for a period of time
     * the mode may be unknown.
     *
     * @return {@link Phone#LTE_ON_CDMA_UNKNOWN}, {@link Phone#LTE_ON_CDMA_FALSE}
     * or {@link PHone#LTE_ON_CDMA_TRUE}
     */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.466 -0500", hash_original_method = "0BA6F7CD63E97EA2676933CA677C1AF5", hash_generated_method = "D209F2088C4D2D0314CE7AE97315D1B9")
            
public int getLteOnCdmaMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLteOnCdmaMode, _data, _reply, 0);
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.486 -0500", hash_original_field = "6FFA2DE555351209A2C3B255018B8ACD", hash_generated_field = "FD655080FEBD90DE6C7E00E782B146DA")

static final int TRANSACTION_showCallScreenWithDialpad = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.488 -0500", hash_original_field = "4DD9B1D552F45F2102038225EAC03FB1", hash_generated_field = "59336C0AFD9D8553C69702C9032FD618")

static final int TRANSACTION_endCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.491 -0500", hash_original_field = "9FE50383124C4F3E4C58D7DD8269DEFF", hash_generated_field = "6338F9D38E46F239181FF8F914B350D1")

static final int TRANSACTION_answerRingingCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.494 -0500", hash_original_field = "8083F15AC3808DFA5E16300FC3C949F4", hash_generated_field = "1CE386F8D3DF0FA527545000D8C11FEA")

static final int TRANSACTION_silenceRinger = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.496 -0500", hash_original_field = "E798CD234EED842DC76E5D79C207370A", hash_generated_field = "4AF5380DBDCD131F79A46F91ECBB48F0")

static final int TRANSACTION_isOffhook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.498 -0500", hash_original_field = "2CCE73EC60C7ED751F9244703F06D03C", hash_generated_field = "1B5B83EFB24C2634724239FDD85F86BB")

static final int TRANSACTION_isRinging = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.501 -0500", hash_original_field = "61FF952AD8D519E99F7634A01046C955", hash_generated_field = "32A61E535F5B2DAB963ECD0D895C7901")

static final int TRANSACTION_isIdle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.503 -0500", hash_original_field = "24B0A2D473A7BE815E6A2A55086D6CC1", hash_generated_field = "01DE08DCEB756922AB4A2ACAA5E86BA0")

static final int TRANSACTION_isRadioOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.507 -0500", hash_original_field = "FBDEA89E216640B27424CFA72656A69D", hash_generated_field = "043EC6649D8BA92D10D7D08A863C3D5B")

static final int TRANSACTION_isSimPinEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.509 -0500", hash_original_field = "0308724618393A53DA51F8E4FE1B31BC", hash_generated_field = "781882E64715815C3752F53C38EFCBD6")

static final int TRANSACTION_cancelMissedCallsNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.512 -0500", hash_original_field = "698988F3CB658808C13EF1ACE65F8EE4", hash_generated_field = "47C3F50CAFFA0725F3FDF8A616D3C118")

static final int TRANSACTION_supplyPin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.515 -0500", hash_original_field = "A91ABDD50DCB063E0804BFCDF63CF1CE", hash_generated_field = "717C83F52B3690C5BF9A96F7CC81B7EE")

static final int TRANSACTION_supplyPuk = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.517 -0500", hash_original_field = "7AE9A21A06D4DD2024584A9E5ED07A0E", hash_generated_field = "1697E60F4D9FADE337D418A0642DADBC")

static final int TRANSACTION_handlePinMmi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.520 -0500", hash_original_field = "2A23821DBE04C073B898BF3BBE5EC449", hash_generated_field = "DC9C16EF592B3A54150537AAC43E16AE")

static final int TRANSACTION_toggleRadioOnOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.523 -0500", hash_original_field = "E34FC0C2F30EE5FE4637722A6936D7E5", hash_generated_field = "362CDA9F8DC12F5ABF01E8BEE3878B7F")

static final int TRANSACTION_setRadio = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.525 -0500", hash_original_field = "F483DAEA87509051923189994B8DD4C7", hash_generated_field = "B96AEB1CB1E8F8BFE9B4D1F6F1ADA0DA")

static final int TRANSACTION_updateServiceLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.528 -0500", hash_original_field = "5C1D463C20ACC7A2574C8707E7710B94", hash_generated_field = "45905DCA7DA3D51C6B7CF8056C6D5347")

static final int TRANSACTION_enableLocationUpdates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.530 -0500", hash_original_field = "885579FA0E24828828BE3210B8AFB96A", hash_generated_field = "EB39B0300D03D94A5CC3A4FDC61D1389")

static final int TRANSACTION_disableLocationUpdates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.533 -0500", hash_original_field = "817F6EA397293A10FB29C6305A5A7CAE", hash_generated_field = "F97C1A1EF735CABC71F79C0A4C94DE53")

static final int TRANSACTION_enableApnType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.536 -0500", hash_original_field = "39F29311F1C928C104BD819F1CA20723", hash_generated_field = "00BC1DA76854E313D59C06176A3872B9")

static final int TRANSACTION_disableApnType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.538 -0500", hash_original_field = "BEBC22DD983AC795CE3F21F73359E73D", hash_generated_field = "0815FCFD6661ECEBF005EA8FDBB4B4B6")

static final int TRANSACTION_enableDataConnectivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.541 -0500", hash_original_field = "A67C8143B7B66EFB696C31C3DD29BAC8", hash_generated_field = "69B8C5B6FDD31E63A2624EB1C4E7CA1B")

static final int TRANSACTION_disableDataConnectivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.544 -0500", hash_original_field = "B1D0A924DFBA91FB60870A49C5F9357F", hash_generated_field = "84B91CF7DB5359B71111393990A560A2")

static final int TRANSACTION_isDataConnectivityPossible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.546 -0500", hash_original_field = "14775EAAA3EF101DA3F6650B25164437", hash_generated_field = "79137B73BF14593102D21F06C7CD4E67")

static final int TRANSACTION_getCellLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.549 -0500", hash_original_field = "148BB5C2DFFA8FF947A192E5E0A61EE8", hash_generated_field = "747E76EC0ED6F10F60AB00F5FAE16ECD")

static final int TRANSACTION_getNeighboringCellInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.552 -0500", hash_original_field = "FCECDBA3F1A1C8CC265901DEA9FDAAF6", hash_generated_field = "141DE1172BF1C8EC86F6E68ED006CEE6")

static final int TRANSACTION_getCallState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.554 -0500", hash_original_field = "6FD23CEF7C9BA24A269D0551E0FF2D84", hash_generated_field = "5812EFCAA543D5A3BDAD8E4AAC435C8A")

static final int TRANSACTION_getDataActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.557 -0500", hash_original_field = "D5F9E8F1866FC26610DEDC6C13FF34DA", hash_generated_field = "A502ABB41705959B8C3E6D856BECB616")

static final int TRANSACTION_getDataState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.560 -0500", hash_original_field = "D3C3DA7C9822A70BE3D87D74EF10E0E7", hash_generated_field = "CD0C3223AEBE7D7AEC9B36A1916825AC")

static final int TRANSACTION_getActivePhoneType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.563 -0500", hash_original_field = "75D57F26E4547F5D435E0AF299C4FF40", hash_generated_field = "9A017DA154257435C23214385D5F3C4A")

static final int TRANSACTION_getCdmaEriIconIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.565 -0500", hash_original_field = "2CBCE093F368650AEA88FFF731CF5680", hash_generated_field = "9478B6FC75B54A211088F13309069C3D")

static final int TRANSACTION_getCdmaEriIconMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.568 -0500", hash_original_field = "4900C00CC4EBD2BA7BDFBBF8760D6D83", hash_generated_field = "3FC62A52149AC509E38706E6DA38EC49")

static final int TRANSACTION_getCdmaEriText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.570 -0500", hash_original_field = "E2A9304908DBF57962FDA6C03F71243B", hash_generated_field = "5F1FF378E96EF3AA30153C3FD569BE20")

static final int TRANSACTION_needsOtaServiceProvisioning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.573 -0500", hash_original_field = "C12BD2BAEFBFDC3761942B594E8D7449", hash_generated_field = "37BF3BE46D3DFA9494E3B8DD7E315EE8")

static final int TRANSACTION_getVoiceMessageCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.576 -0500", hash_original_field = "9AADAADC2B36A210D1A2BD265A44D075", hash_generated_field = "0ABEA56C1FEA9C159B6A19682B4A2B9D")

static final int TRANSACTION_getNetworkType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.578 -0500", hash_original_field = "3BEC2D989FA84AA7ACCFA64D8ECBFD54", hash_generated_field = "31B976937185FB5DCFEEF4738983E39F")

static final int TRANSACTION_hasIccCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.581 -0500", hash_original_field = "EA44B0280A9520362E7438DC56D866CF", hash_generated_field = "FEEFD3E0A486387712D46B422A78E1FE")

static final int TRANSACTION_getLteOnCdmaMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.326 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.331 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:22.338 -0500", hash_original_method = "D9C108DFFD61AEC3A3ACB70B26457A93", hash_generated_method = "DF74E77E4A8C3622DC40D9126ABC3E03")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_dial:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.dial(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_call:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.call(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_showCallScreen:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.showCallScreen();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_showCallScreenWithDialpad:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.showCallScreenWithDialpad(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_endCall:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.endCall();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_answerRingingCall:
{
data.enforceInterface(DESCRIPTOR);
this.answerRingingCall();
reply.writeNoException();
return true;
}
case TRANSACTION_silenceRinger:
{
data.enforceInterface(DESCRIPTOR);
this.silenceRinger();
reply.writeNoException();
return true;
}
case TRANSACTION_isOffhook:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isOffhook();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isRinging:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isRinging();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isIdle:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isIdle();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isRadioOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isRadioOn();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isSimPinEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isSimPinEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_cancelMissedCallsNotification:
{
data.enforceInterface(DESCRIPTOR);
this.cancelMissedCallsNotification();
reply.writeNoException();
return true;
}
case TRANSACTION_supplyPin:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.supplyPin(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_supplyPuk:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.supplyPuk(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_handlePinMmi:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.handlePinMmi(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_toggleRadioOnOff:
{
data.enforceInterface(DESCRIPTOR);
this.toggleRadioOnOff();
reply.writeNoException();
return true;
}
case TRANSACTION_setRadio:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.setRadio(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_updateServiceLocation:
{
data.enforceInterface(DESCRIPTOR);
this.updateServiceLocation();
reply.writeNoException();
return true;
}
case TRANSACTION_enableLocationUpdates:
{
data.enforceInterface(DESCRIPTOR);
this.enableLocationUpdates();
reply.writeNoException();
return true;
}
case TRANSACTION_disableLocationUpdates:
{
data.enforceInterface(DESCRIPTOR);
this.disableLocationUpdates();
reply.writeNoException();
return true;
}
case TRANSACTION_enableApnType:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.enableApnType(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_disableApnType:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.disableApnType(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_enableDataConnectivity:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.enableDataConnectivity();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disableDataConnectivity:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.disableDataConnectivity();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isDataConnectivityPossible:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isDataConnectivityPossible();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getCellLocation:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _result = this.getCellLocation();
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
case TRANSACTION_getNeighboringCellInfo:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.telephony.NeighboringCellInfo> _result = this.getNeighboringCellInfo();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getCallState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCallState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getDataActivity:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getDataActivity();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getDataState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getDataState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getActivePhoneType:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getActivePhoneType();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getCdmaEriIconIndex:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCdmaEriIconIndex();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getCdmaEriIconMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCdmaEriIconMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getCdmaEriText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCdmaEriText();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_needsOtaServiceProvisioning:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.needsOtaServiceProvisioning();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getVoiceMessageCount:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getVoiceMessageCount();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getNetworkType:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getNetworkType();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_hasIccCard:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasIccCard();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getLteOnCdmaMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getLteOnCdmaMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void dial(java.lang.String number) throws android.os.RemoteException;

public void call(java.lang.String number) throws android.os.RemoteException;

public boolean showCallScreen() throws android.os.RemoteException;

public boolean showCallScreenWithDialpad(boolean showDialpad) throws android.os.RemoteException;

public boolean endCall() throws android.os.RemoteException;

public void answerRingingCall() throws android.os.RemoteException;

public void silenceRinger() throws android.os.RemoteException;

public boolean isOffhook() throws android.os.RemoteException;

public boolean isRinging() throws android.os.RemoteException;

public boolean isIdle() throws android.os.RemoteException;

public boolean isRadioOn() throws android.os.RemoteException;

public boolean isSimPinEnabled() throws android.os.RemoteException;

public void cancelMissedCallsNotification() throws android.os.RemoteException;

public boolean supplyPin(java.lang.String pin) throws android.os.RemoteException;

public boolean supplyPuk(java.lang.String puk, java.lang.String pin) throws android.os.RemoteException;

public boolean handlePinMmi(java.lang.String dialString) throws android.os.RemoteException;

public void toggleRadioOnOff() throws android.os.RemoteException;

public boolean setRadio(boolean turnOn) throws android.os.RemoteException;

public void updateServiceLocation() throws android.os.RemoteException;

public void enableLocationUpdates() throws android.os.RemoteException;

public void disableLocationUpdates() throws android.os.RemoteException;

public int enableApnType(java.lang.String type) throws android.os.RemoteException;

public int disableApnType(java.lang.String type) throws android.os.RemoteException;

public boolean enableDataConnectivity() throws android.os.RemoteException;

public boolean disableDataConnectivity() throws android.os.RemoteException;

public boolean isDataConnectivityPossible() throws android.os.RemoteException;
public android.os.Bundle getCellLocation() throws android.os.RemoteException;

public java.util.List<android.telephony.NeighboringCellInfo> getNeighboringCellInfo() throws android.os.RemoteException;
public int getCallState() throws android.os.RemoteException;
public int getDataActivity() throws android.os.RemoteException;
public int getDataState() throws android.os.RemoteException;

public int getActivePhoneType() throws android.os.RemoteException;

public int getCdmaEriIconIndex() throws android.os.RemoteException;

public int getCdmaEriIconMode() throws android.os.RemoteException;

public java.lang.String getCdmaEriText() throws android.os.RemoteException;

public boolean needsOtaServiceProvisioning() throws android.os.RemoteException;

public int getVoiceMessageCount() throws android.os.RemoteException;

public int getNetworkType() throws android.os.RemoteException;

public boolean hasIccCard() throws android.os.RemoteException;

public int getLteOnCdmaMode() throws android.os.RemoteException;
}
