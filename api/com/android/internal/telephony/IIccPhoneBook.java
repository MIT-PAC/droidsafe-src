package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IIccPhoneBook extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.IIccPhoneBook
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.629 -0500", hash_original_field = "5ECF00DF2CDC07A1AABF48F9C2486099", hash_generated_field = "824C8546F77C00364ED332A03D06E21E")

private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.IIccPhoneBook";
/**
 * Cast an IBinder object into an com.android.internal.telephony.IIccPhoneBook interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.634 -0500", hash_original_method = "051A91FF6481BF92BDBCA66144A6F50C", hash_generated_method = "FFA663671B84543DC9462829AA857A04")
        
public static com.android.internal.telephony.IIccPhoneBook asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.IIccPhoneBook))) {
return ((com.android.internal.telephony.IIccPhoneBook)iin);
}
return new com.android.internal.telephony.IIccPhoneBook.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.671 -0500", hash_original_field = "F5DF0F004AC1A35A8091C8BC3EC97AFB", hash_generated_field = "76157148EDF96AB7929F60C21E8BDB24")

static final int TRANSACTION_getAdnRecordsInEf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.674 -0500", hash_original_field = "C5DAD85EE4584B13DDD915C24E3F7988", hash_generated_field = "78B1728B159224785255BF1B369591FB")

static final int TRANSACTION_updateAdnRecordsInEfBySearch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.677 -0500", hash_original_field = "64D879133FEA80C1CD3A880F4339F71B", hash_generated_field = "CC82C0E0A56A407893257F6AA3576CB0")

static final int TRANSACTION_updateAdnRecordsInEfByIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.telephony.IIccPhoneBook
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.644 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.647 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.650 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.653 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Loads the AdnRecords in efid and returns them as a
     * List of AdnRecords
     *
     * @param efid the EF id of a ADN-like SIM
     * @return List of AdnRecord
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.656 -0500", hash_original_method = "1087187EA88A0FA0C7119DE2C3CAD628", hash_generated_method = "AF0D072B8934CCA37A67CE52B07EFB81")
            
public java.util.List<com.android.internal.telephony.AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.android.internal.telephony.AdnRecord> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(efid);
mRemote.transact(Stub.TRANSACTION_getAdnRecordsInEf, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.android.internal.telephony.AdnRecord.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Replace oldAdn with newAdn in ADN-like record in EF
     *
     * getAdnRecordsInEf must be called at least once before this function,
     * otherwise an error will be returned
     *
     * @param efid must be one among EF_ADN, EF_FDN, and EF_SDN
     * @param oldTag adn tag to be replaced
     * @param oldPhoneNumber adn number to be replaced
     *        Set both oldTag and oldPhoneNubmer to "" means to replace an
     *        empty record, aka, insert new record
     * @param newTag adn tag to be stored
     * @param newPhoneNumber adn number ot be stored
     *        Set both newTag and newPhoneNubmer to "" means to replace the old
     *        record with empty one, aka, delete old record
     * @param pin2 required to update EF_FDN, otherwise must be null
     * @return true for success
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.660 -0500", hash_original_method = "57C77BA299B396EE0E106B99D9516114", hash_generated_method = "9E50DC52BDEAA2B0B9C46A46D9320CB8")
            
public boolean updateAdnRecordsInEfBySearch(int efid, java.lang.String oldTag, java.lang.String oldPhoneNumber, java.lang.String newTag, java.lang.String newPhoneNumber, java.lang.String pin2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(efid);
_data.writeString(oldTag);
_data.writeString(oldPhoneNumber);
_data.writeString(newTag);
_data.writeString(newPhoneNumber);
_data.writeString(pin2);
mRemote.transact(Stub.TRANSACTION_updateAdnRecordsInEfBySearch, _data, _reply, 0);
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
     * Update an ADN-like EF record by record index
     *
     * This is useful for iteration the whole ADN file, such as write the whole
     * phone book or erase/format the whole phonebook
     *
     * @param efid must be one among EF_ADN, EF_FDN, and EF_SDN
     * @param newTag adn tag to be stored
     * @param newPhoneNumber adn number to be stored
     *        Set both newTag and newPhoneNubmer to "" means to replace the old
     *        record with empty one, aka, delete old record
     * @param index is 1-based adn record index to be updated
     * @param pin2 required to update EF_FDN, otherwise must be null
     * @return true for success
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.663 -0500", hash_original_method = "91281558576364C85BE46F0079CA820C", hash_generated_method = "BCDF32329AFCC1C932F143E93CF11FA9")
            
public boolean updateAdnRecordsInEfByIndex(int efid, java.lang.String newTag, java.lang.String newPhoneNumber, int index, java.lang.String pin2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(efid);
_data.writeString(newTag);
_data.writeString(newPhoneNumber);
_data.writeInt(index);
_data.writeString(pin2);
mRemote.transact(Stub.TRANSACTION_updateAdnRecordsInEfByIndex, _data, _reply, 0);
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
     * Get the max munber of records in efid
     *
     * @param efid the EF id of a ADN-like SIM
     * @return  int[3] array
     *            recordSizes[0]  is the single record length
     *            recordSizes[1]  is the total length of the EF file
     *            recordSizes[2]  is the number of records in the EF file
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.666 -0500", hash_original_method = "BF5F15589ED225EF4BE651856D8EC959", hash_generated_method = "D611BB6BB4B7286B89E52C3136EB3CF8")
            
public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(efid);
mRemote.transact(Stub.TRANSACTION_getAdnRecordsSize, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.679 -0500", hash_original_field = "5B11D49B1644D320A69D1356B52D808B", hash_generated_field = "54D9CE133688DD42C8D8EF3BE54678CB")

static final int TRANSACTION_getAdnRecordsSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.632 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.637 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.641 -0500", hash_original_method = "11BCFDA3CD5B05CDBD41BE36B711C193", hash_generated_method = "40A9B7703A04A44038037C58907FE8E2")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getAdnRecordsInEf:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<com.android.internal.telephony.AdnRecord> _result = this.getAdnRecordsInEf(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_updateAdnRecordsInEfBySearch:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
java.lang.String _arg5;
_arg5 = data.readString();
boolean _result = this.updateAdnRecordsInEfBySearch(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_updateAdnRecordsInEfByIndex:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
int _arg3;
_arg3 = data.readInt();
java.lang.String _arg4;
_arg4 = data.readString();
boolean _result = this.updateAdnRecordsInEfByIndex(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAdnRecordsSize:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int[] _result = this.getAdnRecordsSize(_arg0);
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public java.util.List<com.android.internal.telephony.AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException;

public boolean updateAdnRecordsInEfBySearch(int efid, java.lang.String oldTag, java.lang.String oldPhoneNumber, java.lang.String newTag, java.lang.String newPhoneNumber, java.lang.String pin2) throws android.os.RemoteException;

public boolean updateAdnRecordsInEfByIndex(int efid, java.lang.String newTag, java.lang.String newPhoneNumber, int index, java.lang.String pin2) throws android.os.RemoteException;

public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException;
}
