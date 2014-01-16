package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ISms extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.ISms
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.101 -0500", hash_original_field = "38281336B9AED41F6E32AE7FD32685BF", hash_generated_field = "E684FF3D1E95F12DE3893CA95D9C8A76")

private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.ISms";
/**
 * Cast an IBinder object into an com.android.internal.telephony.ISms interface,
 * generating a proxy if needed.
 */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.106 -0500", hash_original_method = "BF398C098787FFE2BA3E7FE22D3B8121", hash_generated_method = "C2ECE4B7C2DCB02552440642AAD9EA8B")
        
public static com.android.internal.telephony.ISms asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.ISms))) {
return ((com.android.internal.telephony.ISms)iin);
}
return new com.android.internal.telephony.ISms.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.162 -0500", hash_original_field = "5BF9AC00954A8619588465E8A720A8BB", hash_generated_field = "16DAAE061E3D7828DFF32AA69E6744BE")

static final int TRANSACTION_getAllMessagesFromIccEf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.164 -0500", hash_original_field = "4A1EC53721D934EFE44F8B4C6E6F71EC", hash_generated_field = "F4E4764E977F365EEC6E771FBB3F33C4")

static final int TRANSACTION_updateMessageOnIccEf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.167 -0500", hash_original_field = "BCE8B2F8F29BDD766A3C2727B977360D", hash_generated_field = "5E9DB0EABC305D448E6E2C8802B14A6C")

static final int TRANSACTION_copyMessageToIccEf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.telephony.ISms
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.117 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.120 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.123 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.125 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Retrieves all messages currently stored on ICC.
     *
     * @return list of SmsRawData of all sms on ICC
     */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.128 -0500", hash_original_method = "6A1170C1A1E461159C242116F02E5FBC", hash_generated_method = "5EE2A4367D213EAA6951402FE8102D25")
            
public java.util.List<com.android.internal.telephony.SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.android.internal.telephony.SmsRawData> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllMessagesFromIccEf, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.android.internal.telephony.SmsRawData.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Update the specified message on the ICC.
     *
     * @param messageIndex record index of message to update
     * @param newStatus new message status (STATUS_ON_ICC_READ,
     *                  STATUS_ON_ICC_UNREAD, STATUS_ON_ICC_SENT,
     *                  STATUS_ON_ICC_UNSENT, STATUS_ON_ICC_FREE)
     * @param pdu the raw PDU to store
     * @return success or not
     *
     */
@DSSink({DSSinkKind.SMS_MMS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.131 -0500", hash_original_method = "9607C1486E70D6EE8AFE18BCBCE13E3A", hash_generated_method = "EE144715505B5CCD74D579DD24F8EA7F")
            
public boolean updateMessageOnIccEf(int messageIndex, int newStatus, byte[] pdu) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(messageIndex);
_data.writeInt(newStatus);
_data.writeByteArray(pdu);
mRemote.transact(Stub.TRANSACTION_updateMessageOnIccEf, _data, _reply, 0);
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
     * Copy a raw SMS PDU to the ICC.
     *
     * @param pdu the raw PDU to store
     * @param status message status (STATUS_ON_ICC_READ, STATUS_ON_ICC_UNREAD,
     *               STATUS_ON_ICC_SENT, STATUS_ON_ICC_UNSENT)
     * @return success or not
     *
     */
@DSSink({DSSinkKind.SMS_MMS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.134 -0500", hash_original_method = "2D37596EC8B046E600C89AAC3A2B4312", hash_generated_method = "BC5C467C951DE778B92AB78AE0B43EE8")
            
public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
_data.writeByteArray(pdu);
_data.writeByteArray(smsc);
mRemote.transact(Stub.TRANSACTION_copyMessageToIccEf, _data, _reply, 0);
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
     * Send a data SMS.
     *
     * @param smsc the SMSC to send the message through, or NULL for the
     *  default SMSC
     * @param data the body of the message to send
     * @param sentIntent if not NULL this <code>PendingIntent</code> is
     *  broadcast when the message is sucessfully sent, or failed.
     *  The result code will be <code>Activity.RESULT_OK<code> for success,
     *  or one of these errors:<br>
     *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
     *  <code>RESULT_ERROR_RADIO_OFF</code><br>
     *  <code>RESULT_ERROR_NULL_PDU</code><br>
     *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> the sentIntent may include
     *  the extra "errorCode" containing a radio technology specific value,
     *  generally only useful for troubleshooting.<br>
     *  The per-application based SMS control checks sentIntent. If sentIntent
     *  is NULL the caller will be checked against all unknown applicaitons,
     *  which cause smaller number of SMS to be sent in checking period.
     * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
     *  broadcast when the message is delivered to the recipient.  The
     *  raw pdu of the status report is in the extended data ("pdu").
     */
@DSSink({DSSinkKind.SMS_MMS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.137 -0500", hash_original_method = "15D626DBBF907F47EB9A900B95604DC3", hash_generated_method = "D7AA83970941B0E4958CC6A57442E62A")
            
public void sendData(java.lang.String destAddr, java.lang.String scAddr, int destPort, byte[] data, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(destAddr);
_data.writeString(scAddr);
_data.writeInt(destPort);
_data.writeByteArray(data);
if ((sentIntent!=null)) {
_data.writeInt(1);
sentIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((deliveryIntent!=null)) {
_data.writeInt(1);
deliveryIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Send an SMS.
     *
     * @param smsc the SMSC to send the message through, or NULL for the
     *  default SMSC
     * @param text the body of the message to send
     * @param sentIntent if not NULL this <code>PendingIntent</code> is
     *  broadcast when the message is sucessfully sent, or failed.
     *  The result code will be <code>Activity.RESULT_OK<code> for success,
     *  or one of these errors:<br>
     *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
     *  <code>RESULT_ERROR_RADIO_OFF</code><br>
     *  <code>RESULT_ERROR_NULL_PDU</code><br>
     *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> the sentIntent may include
     *  the extra "errorCode" containing a radio technology specific value,
     *  generally only useful for troubleshooting.<br>
     *  The per-application based SMS control checks sentIntent. If sentIntent
     *  is NULL the caller will be checked against all unknown applications,
     *  which cause smaller number of SMS to be sent in checking period.
     * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
     *  broadcast when the message is delivered to the recipient.  The
     *  raw pdu of the status report is in the extended data ("pdu").
     */
@DSSink({DSSinkKind.SMS_MMS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.140 -0500", hash_original_method = "C7F1653F2148AC49E040842DC2276758", hash_generated_method = "40F1C4AEC3B498EB96E93F473CBC2554")
            
public void sendText(java.lang.String destAddr, java.lang.String scAddr, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(destAddr);
_data.writeString(scAddr);
_data.writeString(text);
if ((sentIntent!=null)) {
_data.writeInt(1);
sentIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((deliveryIntent!=null)) {
_data.writeInt(1);
deliveryIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Send a multi-part text based SMS.
     *
     * @param destinationAddress the address to send the message to
     * @param scAddress is the service center address or null to use
     *   the current default SMSC
     * @param parts an <code>ArrayList</code> of strings that, in order,
     *   comprise the original message
     * @param sentIntents if not null, an <code>ArrayList</code> of
     *   <code>PendingIntent</code>s (one for each message part) that is
     *   broadcast when the corresponding message part has been sent.
     *   The result code will be <code>Activity.RESULT_OK<code> for success,
     *   or one of these errors:
     *   <code>RESULT_ERROR_GENERIC_FAILURE</code>
     *   <code>RESULT_ERROR_RADIO_OFF</code>
     *   <code>RESULT_ERROR_NULL_PDU</code>.
     * @param deliveryIntents if not null, an <code>ArrayList</code> of
     *   <code>PendingIntent</code>s (one for each message part) that is
     *   broadcast when the corresponding message part has been delivered
     *   to the recipient.  The raw pdu of the status report is in the
     *   extended data ("pdu").
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.143 -0500", hash_original_method = "E29A12CE48B0E542EE40223AB5CDB364", hash_generated_method = "8B8CAFFAB4C9D843102DE29CE07F530E")
            
public void sendMultipartText(java.lang.String destinationAddress, java.lang.String scAddress, java.util.List<java.lang.String> parts, java.util.List<android.app.PendingIntent> sentIntents, java.util.List<android.app.PendingIntent> deliveryIntents) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(destinationAddress);
_data.writeString(scAddress);
_data.writeStringList(parts);
_data.writeTypedList(sentIntents);
_data.writeTypedList(deliveryIntents);
mRemote.transact(Stub.TRANSACTION_sendMultipartText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Enable reception of cell broadcast (SMS-CB) messages with the given
     * message identifier. Note that if two different clients enable the same
     * message identifier, they must both disable it for the device to stop
     * receiving those messages.
     *
     * @param messageIdentifier Message identifier as specified in TS 23.041
     * @return true if successful, false otherwise
     *
     * @see #disableCellBroadcast(int)
     */
@DSSink({DSSinkKind.SMS_MMS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.146 -0500", hash_original_method = "2979FDDD6D9AD2D58A8B226CB8D78F5A", hash_generated_method = "0332F3D02FF39B24CADDB8F5D2988FE7")
            
public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(messageIdentifier);
mRemote.transact(Stub.TRANSACTION_enableCellBroadcast, _data, _reply, 0);
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
     * Disable reception of cell broadcast (SMS-CB) messages with the given
     * message identifier. Note that if two different clients enable the same
     * message identifier, they must both disable it for the device to stop
     * receiving those messages.
     *
     * @param messageIdentifier Message identifier as specified in TS 23.041
     * @return true if successful, false otherwise
     *
     * @see #enableCellBroadcast(int)
     */
@DSSink({DSSinkKind.SMS_MMS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.148 -0500", hash_original_method = "5100083DC5C537DAE194E8B6F221D974", hash_generated_method = "FED4108FA3557FF78DF3BB7E76628A71")
            
public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(messageIdentifier);
mRemote.transact(Stub.TRANSACTION_disableCellBroadcast, _data, _reply, 0);
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
     * Enable reception of cell broadcast (SMS-CB) messages with the given
     * message identifier range. Note that if two different clients enable
     * a message identifier range, they must both disable it for the device
     * to stop receiving those messages.
     *
     * @param startMessageId first message identifier as specified in TS 23.041
     * @param endMessageId last message identifier as specified in TS 23.041
     * @return true if successful, false otherwise
     *
     * @see #disableCellBroadcastRange(int, int)
     */
@DSSink({DSSinkKind.SMS_MMS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.151 -0500", hash_original_method = "62C8A386C19BB5493BE042F8A9D60702", hash_generated_method = "2BD7969F295D3D2EFCE1942266AA06DC")
            
public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(startMessageId);
_data.writeInt(endMessageId);
mRemote.transact(Stub.TRANSACTION_enableCellBroadcastRange, _data, _reply, 0);
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
     * Disable reception of cell broadcast (SMS-CB) messages with the given
     * message identifier range. Note that if two different clients enable
     * a message identifier range, they must both disable it for the device
     * to stop receiving those messages.
     *
     * @param startMessageId first message identifier as specified in TS 23.041
     * @param endMessageId last message identifier as specified in TS 23.041
     * @return true if successful, false otherwise
     *
     * @see #enableCellBroadcastRange(int, int)
     */
@DSSink({DSSinkKind.SMS_MMS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.153 -0500", hash_original_method = "F53BE916C4234C2EC54BE7CD135C70CD", hash_generated_method = "747E964953C620DBDDD0B730775D6317")
            
public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(startMessageId);
_data.writeInt(endMessageId);
mRemote.transact(Stub.TRANSACTION_disableCellBroadcastRange, _data, _reply, 0);
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.169 -0500", hash_original_field = "4182B1BF531FE79F1D2E4ADE0675CEE0", hash_generated_field = "DB8CF6F0952314A68A76B041E58B1E6E")

static final int TRANSACTION_sendData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.172 -0500", hash_original_field = "F125F51E6879F3F0D6AA17FFE1AF825A", hash_generated_field = "3B146D338E5DC737F661E3C444D8FE28")

static final int TRANSACTION_sendText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.174 -0500", hash_original_field = "A211485AF43E6C0F94654EF75A68B81B", hash_generated_field = "AEE81C328A4CC8F00A30A6F8FBA56FA6")

static final int TRANSACTION_sendMultipartText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.177 -0500", hash_original_field = "701B3EC057969497C03B5FBE83814359", hash_generated_field = "86B2780FE18841105AC9376B5EEE287C")

static final int TRANSACTION_enableCellBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.179 -0500", hash_original_field = "D98C0EF27FF15341D6089B1B1C1C2178", hash_generated_field = "2161B150D1AC9C00E18CEA4EB108AB6B")

static final int TRANSACTION_disableCellBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.182 -0500", hash_original_field = "EE18ABD8BF5A3EABED33055AD4CC8643", hash_generated_field = "E212790C45B56D307355BA31B5B5CC54")

static final int TRANSACTION_enableCellBroadcastRange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.184 -0500", hash_original_field = "FA9202A60CF7866A83925D920B687FF5", hash_generated_field = "374ADC564635AA6F6017CB498DA6F070")

static final int TRANSACTION_disableCellBroadcastRange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.104 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.108 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SMS_MMS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.114 -0500", hash_original_method = "55AAE5B4A4662F93314476244DB6682B", hash_generated_method = "33A5B08014F6891C62CF3CE7ABF472E0")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getAllMessagesFromIccEf:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.android.internal.telephony.SmsRawData> _result = this.getAllMessagesFromIccEf();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_updateMessageOnIccEf:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
byte[] _arg2;
_arg2 = data.createByteArray();
boolean _result = this.updateMessageOnIccEf(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_copyMessageToIccEf:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _arg1;
_arg1 = data.createByteArray();
byte[] _arg2;
_arg2 = data.createByteArray();
boolean _result = this.copyMessageToIccEf(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_sendData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
byte[] _arg3;
_arg3 = data.createByteArray();
android.app.PendingIntent _arg4;
if ((0!=data.readInt())) {
_arg4 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
android.app.PendingIntent _arg5;
if ((0!=data.readInt())) {
_arg5 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
this.sendData(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_sendText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
android.app.PendingIntent _arg3;
if ((0!=data.readInt())) {
_arg3 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
android.app.PendingIntent _arg4;
if ((0!=data.readInt())) {
_arg4 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
this.sendText(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_sendMultipartText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
java.util.List<android.app.PendingIntent> _arg3;
_arg3 = data.createTypedArrayList(android.app.PendingIntent.CREATOR);
java.util.List<android.app.PendingIntent> _arg4;
_arg4 = data.createTypedArrayList(android.app.PendingIntent.CREATOR);
this.sendMultipartText(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_enableCellBroadcast:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.enableCellBroadcast(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disableCellBroadcast:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.disableCellBroadcast(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enableCellBroadcastRange:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.enableCellBroadcastRange(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disableCellBroadcastRange:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.disableCellBroadcastRange(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public java.util.List<com.android.internal.telephony.SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException;

public boolean updateMessageOnIccEf(int messageIndex, int newStatus, byte[] pdu) throws android.os.RemoteException;

public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) throws android.os.RemoteException;

public void sendData(java.lang.String destAddr, java.lang.String scAddr, int destPort, byte[] data, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) throws android.os.RemoteException;

public void sendText(java.lang.String destAddr, java.lang.String scAddr, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) throws android.os.RemoteException;

public void sendMultipartText(java.lang.String destinationAddress, java.lang.String scAddress, java.util.List<java.lang.String> parts, java.util.List<android.app.PendingIntent> sentIntents, java.util.List<android.app.PendingIntent> deliveryIntents) throws android.os.RemoteException;

public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException;

public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException;

public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException;

public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException;
}
