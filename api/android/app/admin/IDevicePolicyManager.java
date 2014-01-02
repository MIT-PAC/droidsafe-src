package android.app.admin;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IDevicePolicyManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.admin.IDevicePolicyManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.454 -0500", hash_original_field = "911F2FBEE21FFB8F039DCA9ED15C22A3", hash_generated_field = "973EC24C3A7DA83FB67BF8E49171CA0C")

private static final java.lang.String DESCRIPTOR = "android.app.admin.IDevicePolicyManager";
/**
 * Cast an IBinder object into an android.app.admin.IDevicePolicyManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.459 -0500", hash_original_method = "091756F459F9C8CFC4E7AA4A93F862FD", hash_generated_method = "A1C4950E9F49D5A966F1B4B84E160B4E")
        
public static android.app.admin.IDevicePolicyManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.admin.IDevicePolicyManager))) {
return ((android.app.admin.IDevicePolicyManager)iin);
}
return new android.app.admin.IDevicePolicyManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.629 -0500", hash_original_field = "E341A3F7C3EEC363F5CC8D277691B74B", hash_generated_field = "44E39C5F16BE5B3CD8EC308F1874C593")

static final int TRANSACTION_setPasswordQuality = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.632 -0500", hash_original_field = "60D3DED3F6D379E91B54EEC0E10FCB16", hash_generated_field = "D5831FA8CBB0A6EEC366BD4BB973E2F7")

static final int TRANSACTION_getPasswordQuality = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.634 -0500", hash_original_field = "985B3BDB0DAAFC1E88BED0ECF5B4A1CB", hash_generated_field = "AC68B9E49847D848523F05EFF97BE27C")

static final int TRANSACTION_setPasswordMinimumLength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.admin.IDevicePolicyManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.477 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.480 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.482 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.484 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.488 -0500", hash_original_method = "2C64D4237BC8ACCA687853CFE6E4A61A", hash_generated_method = "BE79B9E74F726F75DD08C8222935A6D3")
            
public void setPasswordQuality(android.content.ComponentName who, int quality) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(quality);
mRemote.transact(Stub.TRANSACTION_setPasswordQuality, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.490 -0500", hash_original_method = "5920A8F8DEAFCB4C488BAA94577B9C1B", hash_generated_method = "09EAE70E8B502147605210065F491CBD")
            
public int getPasswordQuality(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordQuality, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.493 -0500", hash_original_method = "65566C4A016CD33943DE3DD5425946B0", hash_generated_method = "45A6661486E6FC986BF4F2DD3786FF64")
            
public void setPasswordMinimumLength(android.content.ComponentName who, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_setPasswordMinimumLength, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.496 -0500", hash_original_method = "5E5518836D9411A539AA994A95A0B922", hash_generated_method = "4704B3E4EC4BD6B46E58D6AA8EA69798")
            
public int getPasswordMinimumLength(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordMinimumLength, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.498 -0500", hash_original_method = "89CC6F579FC8B49D4364DCDCFA019ECD", hash_generated_method = "7914DFF02368002D7647BB57F2633A2E")
            
public void setPasswordMinimumUpperCase(android.content.ComponentName who, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_setPasswordMinimumUpperCase, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.501 -0500", hash_original_method = "8F08F58FA9858B85261A58669C608E6D", hash_generated_method = "42773F363080EB07925E1076A3A45C36")
            
public int getPasswordMinimumUpperCase(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordMinimumUpperCase, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.504 -0500", hash_original_method = "BA88B93C9C9744D2E13C0F7E2FA98737", hash_generated_method = "0E23ECE5683F224A65E37B78C5932336")
            
public void setPasswordMinimumLowerCase(android.content.ComponentName who, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_setPasswordMinimumLowerCase, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.507 -0500", hash_original_method = "B8741DD1617420C8BE73D690F78F98C0", hash_generated_method = "9F58923A2066E046A16DCAEE3E0CDE69")
            
public int getPasswordMinimumLowerCase(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordMinimumLowerCase, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.510 -0500", hash_original_method = "706B43FA70012B93E6F03D802C8E0A8E", hash_generated_method = "24872BCB9B6AC0ED0045921D0DA0E489")
            
public void setPasswordMinimumLetters(android.content.ComponentName who, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_setPasswordMinimumLetters, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.512 -0500", hash_original_method = "B35EEA01FC67C8AD90E90DBB69039B56", hash_generated_method = "29A82805016A81124432646ECFFE5701")
            
public int getPasswordMinimumLetters(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordMinimumLetters, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.515 -0500", hash_original_method = "7B023FA76C282221FC27F506C1C599ED", hash_generated_method = "77F631A3F657A7D5A0835A260CF99DF5")
            
public void setPasswordMinimumNumeric(android.content.ComponentName who, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_setPasswordMinimumNumeric, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.518 -0500", hash_original_method = "646EC32125A5F036F1554418A1D2C9B4", hash_generated_method = "4CCEDE6B2061EFC9F1AEA880ECFA3DC3")
            
public int getPasswordMinimumNumeric(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordMinimumNumeric, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.520 -0500", hash_original_method = "EB5C4DE90FD105658EF0378CAE88A985", hash_generated_method = "3343794E065CE65F1F5FB7F03F479D98")
            
public void setPasswordMinimumSymbols(android.content.ComponentName who, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_setPasswordMinimumSymbols, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.524 -0500", hash_original_method = "BD19C5F47950727B000B1CECBEB7D217", hash_generated_method = "D50A70A4718E355EBE16E878255E774F")
            
public int getPasswordMinimumSymbols(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordMinimumSymbols, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.526 -0500", hash_original_method = "29360DC1080A6B0854540D87731749A4", hash_generated_method = "1E2A0B9B8B91044D6C362F8DD48C69DD")
            
public void setPasswordMinimumNonLetter(android.content.ComponentName who, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_setPasswordMinimumNonLetter, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.529 -0500", hash_original_method = "751F7EEEBB1379CED9CB4AED5AFF5BE3", hash_generated_method = "02B4C0C36C573D4E450D271C86CE2A2A")
            
public int getPasswordMinimumNonLetter(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordMinimumNonLetter, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.532 -0500", hash_original_method = "659E61B1BEA960FC71571C049D51CDB6", hash_generated_method = "7B775FBA347F6AFE2970C45768645AE1")
            
public void setPasswordHistoryLength(android.content.ComponentName who, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_setPasswordHistoryLength, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.535 -0500", hash_original_method = "261CBB62869448B2D0A8BC56653F1C9A", hash_generated_method = "546D44B6FEB45891EBE07169C4DF85BF")
            
public int getPasswordHistoryLength(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordHistoryLength, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.537 -0500", hash_original_method = "EC4CACC537D6CDF150DF46698B86E35F", hash_generated_method = "8257B3999BAE7FF5A77B51F79AB68F96")
            
public void setPasswordExpirationTimeout(android.content.ComponentName who, long expiration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(expiration);
mRemote.transact(Stub.TRANSACTION_setPasswordExpirationTimeout, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.540 -0500", hash_original_method = "FE81D1B6FA4EFC24A6C12894C304C6FD", hash_generated_method = "E5A41014336A0904FCA37712D906F508")
            
public long getPasswordExpirationTimeout(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordExpirationTimeout, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.544 -0500", hash_original_method = "F355292664FEDA5AA53BA02D483B6ACD", hash_generated_method = "B73DA664A45AA3B0CC9F5D71B76615ED")
            
public long getPasswordExpiration(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPasswordExpiration, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.546 -0500", hash_original_method = "265598231FE3160F3B2339A44A3CFEDE", hash_generated_method = "3CE86A9ADFA6A7A96A1905F11DEB396C")
            
public boolean isActivePasswordSufficient() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isActivePasswordSufficient, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.549 -0500", hash_original_method = "D650CDCC62F1D61CCBDF6EF3387EBCAB", hash_generated_method = "179DEA38689F87B2B5DAA3782DE19C01")
            
public int getCurrentFailedPasswordAttempts() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentFailedPasswordAttempts, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.552 -0500", hash_original_method = "6D2D5C94EA271F0E711F59AF27D3B546", hash_generated_method = "40DF01395768E324E3938985A5260072")
            
public void setMaximumFailedPasswordsForWipe(android.content.ComponentName admin, int num) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((admin!=null)) {
_data.writeInt(1);
admin.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(num);
mRemote.transact(Stub.TRANSACTION_setMaximumFailedPasswordsForWipe, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.554 -0500", hash_original_method = "42009F61CA476348D19A467A7261F2DC", hash_generated_method = "8C5B3C3FCBF195A19BBC1924895F6993")
            
public int getMaximumFailedPasswordsForWipe(android.content.ComponentName admin) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((admin!=null)) {
_data.writeInt(1);
admin.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getMaximumFailedPasswordsForWipe, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.557 -0500", hash_original_method = "A6083AFCEEDE182BF3E72BC741B58018", hash_generated_method = "E3F2F62F96E07E149D05500D117488B2")
            
public boolean resetPassword(java.lang.String password, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(password);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_resetPassword, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.560 -0500", hash_original_method = "316EFF0397F63780AD3590BB1081BC3C", hash_generated_method = "F898BE7A4AE4DB8ABDDCDE1C6121EB72")
            
public void setMaximumTimeToLock(android.content.ComponentName who, long timeMs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(timeMs);
mRemote.transact(Stub.TRANSACTION_setMaximumTimeToLock, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.562 -0500", hash_original_method = "DA0EF76887961B4896A8663127065A2C", hash_generated_method = "5FB42B0FA5EABB94881FF22732860058")
            
public long getMaximumTimeToLock(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getMaximumTimeToLock, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.565 -0500", hash_original_method = "8F7092B778E38169BA98DB7247A6BC49", hash_generated_method = "215A9965357BB3A7A0139CC248974F80")
            
public void lockNow() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_lockNow, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.567 -0500", hash_original_method = "A49D80FA65FE2FDAE5D55FEC8C1D74B9", hash_generated_method = "C3310B054D9285AF03A31CBBC6F27212")
            
public void wipeData(int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_wipeData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.570 -0500", hash_original_method = "87502811873D13225C45C63756CECF72", hash_generated_method = "88F127086AD926B563867470BF38DCBF")
            
public android.content.ComponentName setGlobalProxy(android.content.ComponentName admin, java.lang.String proxySpec, java.lang.String exclusionList) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ComponentName _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((admin!=null)) {
_data.writeInt(1);
admin.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(proxySpec);
_data.writeString(exclusionList);
mRemote.transact(Stub.TRANSACTION_setGlobalProxy, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.572 -0500", hash_original_method = "924678378B4AC5F680C8BD38ABA93F50", hash_generated_method = "88EF9E39C6011F2F805676BC9438202F")
            
public android.content.ComponentName getGlobalProxyAdmin() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ComponentName _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getGlobalProxyAdmin, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.576 -0500", hash_original_method = "501ABD506791B25CE0B03F580762B802", hash_generated_method = "F4595093986A261603B9837DF3CC6CA5")
            
public int setStorageEncryption(android.content.ComponentName who, boolean encrypt) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((encrypt)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setStorageEncryption, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.579 -0500", hash_original_method = "EA1824B5873A764C06EC8B2BBA600E46", hash_generated_method = "4237FD09BF1883CA995093380EFD008B")
            
public boolean getStorageEncryption(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getStorageEncryption, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.581 -0500", hash_original_method = "5336B8C43D9D92973BC4ADB3B1036CBE", hash_generated_method = "26A6BDF847A595F833464E60DE901976")
            
public int getStorageEncryptionStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getStorageEncryptionStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.585 -0500", hash_original_method = "8AAE2768292AF7E71D83E0D095FA70A0", hash_generated_method = "A9C81ACD48FE62B754C92820147FBC29")
            
public void setCameraDisabled(android.content.ComponentName who, boolean disabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((disabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setCameraDisabled, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.588 -0500", hash_original_method = "70C5ACAA6364AC7FAE3A62DAEBD16EBA", hash_generated_method = "58FE50B62D51BFB9F155EE28465856D8")
            
public boolean getCameraDisabled(android.content.ComponentName who) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((who!=null)) {
_data.writeInt(1);
who.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getCameraDisabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.590 -0500", hash_original_method = "CC9F00BA773DD605497146CF269E5134", hash_generated_method = "9DB8B120F958161A0C98E84775A51EAE")
            
public void setActiveAdmin(android.content.ComponentName policyReceiver, boolean refreshing) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((policyReceiver!=null)) {
_data.writeInt(1);
policyReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((refreshing)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setActiveAdmin, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.593 -0500", hash_original_method = "39D0DB024E9AA90AD07854B4260063DB", hash_generated_method = "47C420BC0CE92257C7B6FB83983F4C3A")
            
public boolean isAdminActive(android.content.ComponentName policyReceiver) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((policyReceiver!=null)) {
_data.writeInt(1);
policyReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_isAdminActive, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.596 -0500", hash_original_method = "5847560DDB20B5C5CE338875A128A5FD", hash_generated_method = "B8AD447A450780428DCE48A99226C653")
            
public java.util.List<android.content.ComponentName> getActiveAdmins() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.content.ComponentName> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getActiveAdmins, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.content.ComponentName.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.598 -0500", hash_original_method = "853F1CDC687853994D13E2DF8BB51632", hash_generated_method = "247B4378DB4C423C21CADC2A5C3E326D")
            
public boolean packageHasActiveAdmins(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_packageHasActiveAdmins, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.601 -0500", hash_original_method = "974A4ECA53AED55ED9EF644446588E39", hash_generated_method = "C433852D5873F011561CF31725D24918")
            
public void getRemoveWarning(android.content.ComponentName policyReceiver, android.os.RemoteCallback result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((policyReceiver!=null)) {
_data.writeInt(1);
policyReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((result!=null)) {
_data.writeInt(1);
result.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getRemoveWarning, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.604 -0500", hash_original_method = "B90C34ED67B660F435423D12EEE074F7", hash_generated_method = "E67F896FB0E636C899AB89BCE34EE3F9")
            
public void removeActiveAdmin(android.content.ComponentName policyReceiver) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((policyReceiver!=null)) {
_data.writeInt(1);
policyReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removeActiveAdmin, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.607 -0500", hash_original_method = "D4105A5FB94ECF4385E6F0605FE3E66C", hash_generated_method = "BCE55A438CDE2B42917AE6464F88C72F")
            
public boolean hasGrantedPolicy(android.content.ComponentName policyReceiver, int usesPolicy) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((policyReceiver!=null)) {
_data.writeInt(1);
policyReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(usesPolicy);
mRemote.transact(Stub.TRANSACTION_hasGrantedPolicy, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.609 -0500", hash_original_method = "37228362780BC1F4382C0AA25D41729D", hash_generated_method = "7263918C949D93A04EDB174B6340032E")
            
public void setActivePasswordState(int quality, int length, int letters, int uppercase, int lowercase, int numbers, int symbols, int nonletter) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(quality);
_data.writeInt(length);
_data.writeInt(letters);
_data.writeInt(uppercase);
_data.writeInt(lowercase);
_data.writeInt(numbers);
_data.writeInt(symbols);
_data.writeInt(nonletter);
mRemote.transact(Stub.TRANSACTION_setActivePasswordState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.612 -0500", hash_original_method = "2768E6B4943D2BF636EC84462B17B8BA", hash_generated_method = "953A95D978FA03D015205B1F63384A8B")
            
public void reportFailedPasswordAttempt() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reportFailedPasswordAttempt, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.615 -0500", hash_original_method = "70CEE64AA71F6F2994DCD09D4E67A0AD", hash_generated_method = "5E48CBB8F6D70C44FC2A30871B6C0B0C")
            
public void reportSuccessfulPasswordAttempt() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reportSuccessfulPasswordAttempt, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.636 -0500", hash_original_field = "2DE905898977A107DD34E6E242CB887D", hash_generated_field = "5F8D4E03A190614E10D2A0D0B2C3A5E2")

static final int TRANSACTION_getPasswordMinimumLength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.639 -0500", hash_original_field = "6AD5559BD46AF4F63D95621CD745E907", hash_generated_field = "9009E8127412674D0790050C73F5B8EF")

static final int TRANSACTION_setPasswordMinimumUpperCase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.641 -0500", hash_original_field = "EA823249CC69D43A756BCC2340C8EFA5", hash_generated_field = "6BDA3B88F6EEF30AB604AB7DA297F887")

static final int TRANSACTION_getPasswordMinimumUpperCase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.643 -0500", hash_original_field = "CEE45101B1F1CFB32D8EF2B6F6B672BD", hash_generated_field = "D5558595E1652FE2CE504929AF4940D6")

static final int TRANSACTION_setPasswordMinimumLowerCase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.646 -0500", hash_original_field = "0205FAF8EDD157F32548ACF51CC982FE", hash_generated_field = "7BD02ACF4175895EEA424548D03D40FA")

static final int TRANSACTION_getPasswordMinimumLowerCase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.648 -0500", hash_original_field = "9AC9DB393A75D9B17CC06FF87AFF8BF3", hash_generated_field = "68BB59E17D4817B6831880085B4E21BB")

static final int TRANSACTION_setPasswordMinimumLetters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.651 -0500", hash_original_field = "EB9891EA296BBBB32596F8CA8D816195", hash_generated_field = "419D82E3F4DB796EE1782027096F2E27")

static final int TRANSACTION_getPasswordMinimumLetters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.654 -0500", hash_original_field = "1E6C9DA8C6B3D587BA49B661CA88221C", hash_generated_field = "61A8E5DF700498E0BA8879BEA495847E")

static final int TRANSACTION_setPasswordMinimumNumeric = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.656 -0500", hash_original_field = "32E914F316AC5075AD40386CA67F1949", hash_generated_field = "74FB1B041333B52F5B35292F5CCDCD4F")

static final int TRANSACTION_getPasswordMinimumNumeric = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.658 -0500", hash_original_field = "457DFD8D5AFA43C3F6E41223C5389A25", hash_generated_field = "DA8E96C9C91B61B9AA8CC985E306113A")

static final int TRANSACTION_setPasswordMinimumSymbols = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.660 -0500", hash_original_field = "8048C46D803335D5DD7710DB87A820D1", hash_generated_field = "6E1BB10668AEC8C5515E960962C6430D")

static final int TRANSACTION_getPasswordMinimumSymbols = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.662 -0500", hash_original_field = "BB7C60E558F325EE8CCA4B3295A3E37C", hash_generated_field = "557D751C8E93A07493426E54C4C09085")

static final int TRANSACTION_setPasswordMinimumNonLetter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.665 -0500", hash_original_field = "DF7C1479FC018DBAEA9734B0BE7FCF07", hash_generated_field = "DA56CDCB1BF32FD613B96ABAE97F0444")

static final int TRANSACTION_getPasswordMinimumNonLetter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.668 -0500", hash_original_field = "95B111B490ABB7BCF20CBE6F2A38AD54", hash_generated_field = "C3AE4FF94ACCF70DA166780FCCCB007A")

static final int TRANSACTION_setPasswordHistoryLength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.670 -0500", hash_original_field = "DCD20DF247F9E813224FB7570C435010", hash_generated_field = "0F1B645E0CEAF8F4A32A305E38553773")

static final int TRANSACTION_getPasswordHistoryLength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.672 -0500", hash_original_field = "18F6783E3F51B82AAEECD7EF70161BC1", hash_generated_field = "7E06CA3C729A0CDF22AE94C0925EC696")

static final int TRANSACTION_setPasswordExpirationTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.675 -0500", hash_original_field = "FAD9F6DDCEC2B7352E5EAA7A8716440A", hash_generated_field = "317DC081D4820EB624B1C63C6E1EF4C5")

static final int TRANSACTION_getPasswordExpirationTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.677 -0500", hash_original_field = "7DC15E2BA8F677C67251175312F4FED6", hash_generated_field = "B7A789AC16D1251FA3AC7884BD1B404F")

static final int TRANSACTION_getPasswordExpiration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.679 -0500", hash_original_field = "9DF143F7F3A7003DFF239F3B2B3EA13A", hash_generated_field = "2F41F2DE92A31147F1745C42866980D7")

static final int TRANSACTION_isActivePasswordSufficient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.682 -0500", hash_original_field = "ED7F97799BBA369EDAF15D4AA956482F", hash_generated_field = "6FF37AE33DB7A821F21E6F1E03D9FBC9")

static final int TRANSACTION_getCurrentFailedPasswordAttempts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.684 -0500", hash_original_field = "33B1958B659AF911806C466BD08D9B76", hash_generated_field = "B370DEED6355E24C2FAA8529022B17B2")

static final int TRANSACTION_setMaximumFailedPasswordsForWipe = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.686 -0500", hash_original_field = "C25A4B93165F88ACB28200F44D6EABF4", hash_generated_field = "FE7DD0CD44E5B8190ACAA8A753AC7BD4")

static final int TRANSACTION_getMaximumFailedPasswordsForWipe = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.689 -0500", hash_original_field = "A6E9CDED0C475ACBE72FCE84FBE7A7D6", hash_generated_field = "6C4ED3919293CF8AB50D9E6F5DFDBD4E")

static final int TRANSACTION_resetPassword = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.692 -0500", hash_original_field = "D5CDF952FB5B8C690AE55995B79CDFB5", hash_generated_field = "863411D35FB36FA0BB3FD944EC0128F3")

static final int TRANSACTION_setMaximumTimeToLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.694 -0500", hash_original_field = "CFB4B369A0CFC521EAB379F8EC4D6C52", hash_generated_field = "065FA7E832DBE6F06555FFBF0E21F644")

static final int TRANSACTION_getMaximumTimeToLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.697 -0500", hash_original_field = "823701BC183884CB999DCB533CE03564", hash_generated_field = "61652F4F8D420DA5BE71B29C09E5202B")

static final int TRANSACTION_lockNow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.699 -0500", hash_original_field = "488C2341E610D359E539D29F85C4E555", hash_generated_field = "6AB73159456394BE3723953B57B86B51")

static final int TRANSACTION_wipeData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.701 -0500", hash_original_field = "10119756B5631A4FB57CBAD7A74D93D1", hash_generated_field = "FD48D9035C30077A5EC6508C18C64053")

static final int TRANSACTION_setGlobalProxy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.703 -0500", hash_original_field = "41AF59EE54053A85027B28C96C256521", hash_generated_field = "026938F5082A735BE513E57C8E09407E")

static final int TRANSACTION_getGlobalProxyAdmin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.705 -0500", hash_original_field = "F0ACEE1FA1A24482EE26E6984F2AC9E3", hash_generated_field = "184B34E2DD952A29E306AD3A2F44FA0D")

static final int TRANSACTION_setStorageEncryption = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.708 -0500", hash_original_field = "BC60D36BFDE1E2B8656D5E272C77FB20", hash_generated_field = "AACA1ECAF4EB20B8927A46BCF41366BD")

static final int TRANSACTION_getStorageEncryption = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.711 -0500", hash_original_field = "5D667C4B633EB71E463E4F67EB2D7072", hash_generated_field = "714DE4BCE796BF7C01360AEBC828AE75")

static final int TRANSACTION_getStorageEncryptionStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.713 -0500", hash_original_field = "5288DE141C39907D9FB58E9375E57C9D", hash_generated_field = "E4FA73CD46E0FCA5B8437814577856FE")

static final int TRANSACTION_setCameraDisabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.715 -0500", hash_original_field = "78F2807A844C02A0769F160CC45746D0", hash_generated_field = "DE6AF980ED04EA276376E4BA83A00323")

static final int TRANSACTION_getCameraDisabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.718 -0500", hash_original_field = "17A9570F20BC10851F634965995A669A", hash_generated_field = "978E696F13B22BD8218A7F2C2C7E6987")

static final int TRANSACTION_setActiveAdmin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.720 -0500", hash_original_field = "587D504732B297F7A9E37C3535D6EB1B", hash_generated_field = "FAF4D5D65870AA0CC9B0BA2EC4E07EB0")

static final int TRANSACTION_isAdminActive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.722 -0500", hash_original_field = "5783353832E71D61EC16F0ECB987DAD3", hash_generated_field = "9277817A423A579D5C79D78FE165E1B1")

static final int TRANSACTION_getActiveAdmins = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.725 -0500", hash_original_field = "CF71A3AFB32D62A8D5F6E26A4451BFF2", hash_generated_field = "A44B68FA0499575F6EEC1E52EB9AE376")

static final int TRANSACTION_packageHasActiveAdmins = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.728 -0500", hash_original_field = "F77CFB46628169722859E7EC0F33B79C", hash_generated_field = "FB9CD86CA46009CE0B56F41EDFAA6B3C")

static final int TRANSACTION_getRemoveWarning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.730 -0500", hash_original_field = "0A56440280EEC57DB162D07008B769A5", hash_generated_field = "087D60465E31E65D703F620DF80B94DD")

static final int TRANSACTION_removeActiveAdmin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.732 -0500", hash_original_field = "50C4405272B0F56A7B5F8BD2B1AE1AA3", hash_generated_field = "BA1D67754F333C10DF3B5752EE693727")

static final int TRANSACTION_hasGrantedPolicy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.734 -0500", hash_original_field = "5837BD314945C597887763BC004E2E23", hash_generated_field = "737BCB31BC303BED8213029B2287C976")

static final int TRANSACTION_setActivePasswordState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.737 -0500", hash_original_field = "6CE855F0C73E22430B1D68346FAA1BB1", hash_generated_field = "66CBEA181449322BA8E192C9675118D4")

static final int TRANSACTION_reportFailedPasswordAttempt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.740 -0500", hash_original_field = "464E813BEB3A3638A1B46726691A90EA", hash_generated_field = "3E6BE047E1757AFB66B9D83C0050030D")

static final int TRANSACTION_reportSuccessfulPasswordAttempt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.457 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.461 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:51.474 -0500", hash_original_method = "F2036F4D4914ABB6D76F8BBED523539D", hash_generated_method = "137FB0B8CAE2F2CE870ED5AC1F9A36A2")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setPasswordQuality:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordQuality(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordQuality:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordQuality(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordMinimumLength:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordMinimumLength(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordMinimumLength:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordMinimumLength(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordMinimumUpperCase:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordMinimumUpperCase(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordMinimumUpperCase:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordMinimumUpperCase(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordMinimumLowerCase:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordMinimumLowerCase(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordMinimumLowerCase:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordMinimumLowerCase(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordMinimumLetters:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordMinimumLetters(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordMinimumLetters:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordMinimumLetters(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordMinimumNumeric:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordMinimumNumeric(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordMinimumNumeric:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordMinimumNumeric(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordMinimumSymbols:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordMinimumSymbols(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordMinimumSymbols:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordMinimumSymbols(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordMinimumNonLetter:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordMinimumNonLetter(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordMinimumNonLetter:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordMinimumNonLetter(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordHistoryLength:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setPasswordHistoryLength(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordHistoryLength:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getPasswordHistoryLength(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPasswordExpirationTimeout:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _arg1;
_arg1 = data.readLong();
this.setPasswordExpirationTimeout(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPasswordExpirationTimeout:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _result = this.getPasswordExpirationTimeout(_arg0);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_getPasswordExpiration:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _result = this.getPasswordExpiration(_arg0);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_isActivePasswordSufficient:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isActivePasswordSufficient();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getCurrentFailedPasswordAttempts:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCurrentFailedPasswordAttempts();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setMaximumFailedPasswordsForWipe:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setMaximumFailedPasswordsForWipe(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getMaximumFailedPasswordsForWipe:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.getMaximumFailedPasswordsForWipe(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_resetPassword:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.resetPassword(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setMaximumTimeToLock:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _arg1;
_arg1 = data.readLong();
this.setMaximumTimeToLock(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getMaximumTimeToLock:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _result = this.getMaximumTimeToLock(_arg0);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_lockNow:
{
data.enforceInterface(DESCRIPTOR);
this.lockNow();
reply.writeNoException();
return true;
}
case TRANSACTION_wipeData:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.wipeData(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setGlobalProxy:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
android.content.ComponentName _result = this.setGlobalProxy(_arg0, _arg1, _arg2);
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
case TRANSACTION_getGlobalProxyAdmin:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _result = this.getGlobalProxyAdmin();
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
case TRANSACTION_setStorageEncryption:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
int _result = this.setStorageEncryption(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getStorageEncryption:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.getStorageEncryption(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getStorageEncryptionStatus:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getStorageEncryptionStatus();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setCameraDisabled:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setCameraDisabled(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getCameraDisabled:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.getCameraDisabled(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setActiveAdmin:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setActiveAdmin(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_isAdminActive:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.isAdminActive(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getActiveAdmins:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.content.ComponentName> _result = this.getActiveAdmins();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_packageHasActiveAdmins:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.packageHasActiveAdmins(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getRemoveWarning:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.RemoteCallback _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.RemoteCallback.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.getRemoveWarning(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeActiveAdmin:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.removeActiveAdmin(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_hasGrantedPolicy:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
boolean _result = this.hasGrantedPolicy(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setActivePasswordState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
int _arg5;
_arg5 = data.readInt();
int _arg6;
_arg6 = data.readInt();
int _arg7;
_arg7 = data.readInt();
this.setActivePasswordState(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
reply.writeNoException();
return true;
}
case TRANSACTION_reportFailedPasswordAttempt:
{
data.enforceInterface(DESCRIPTOR);
this.reportFailedPasswordAttempt();
reply.writeNoException();
return true;
}
case TRANSACTION_reportSuccessfulPasswordAttempt:
{
data.enforceInterface(DESCRIPTOR);
this.reportSuccessfulPasswordAttempt();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void setPasswordQuality(android.content.ComponentName who, int quality) throws android.os.RemoteException;
public int getPasswordQuality(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordMinimumLength(android.content.ComponentName who, int length) throws android.os.RemoteException;
public int getPasswordMinimumLength(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordMinimumUpperCase(android.content.ComponentName who, int length) throws android.os.RemoteException;
public int getPasswordMinimumUpperCase(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordMinimumLowerCase(android.content.ComponentName who, int length) throws android.os.RemoteException;
public int getPasswordMinimumLowerCase(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordMinimumLetters(android.content.ComponentName who, int length) throws android.os.RemoteException;
public int getPasswordMinimumLetters(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordMinimumNumeric(android.content.ComponentName who, int length) throws android.os.RemoteException;
public int getPasswordMinimumNumeric(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordMinimumSymbols(android.content.ComponentName who, int length) throws android.os.RemoteException;
public int getPasswordMinimumSymbols(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordMinimumNonLetter(android.content.ComponentName who, int length) throws android.os.RemoteException;
public int getPasswordMinimumNonLetter(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordHistoryLength(android.content.ComponentName who, int length) throws android.os.RemoteException;
public int getPasswordHistoryLength(android.content.ComponentName who) throws android.os.RemoteException;
public void setPasswordExpirationTimeout(android.content.ComponentName who, long expiration) throws android.os.RemoteException;
public long getPasswordExpirationTimeout(android.content.ComponentName who) throws android.os.RemoteException;
public long getPasswordExpiration(android.content.ComponentName who) throws android.os.RemoteException;
public boolean isActivePasswordSufficient() throws android.os.RemoteException;
public int getCurrentFailedPasswordAttempts() throws android.os.RemoteException;
public void setMaximumFailedPasswordsForWipe(android.content.ComponentName admin, int num) throws android.os.RemoteException;
public int getMaximumFailedPasswordsForWipe(android.content.ComponentName admin) throws android.os.RemoteException;
public boolean resetPassword(java.lang.String password, int flags) throws android.os.RemoteException;
public void setMaximumTimeToLock(android.content.ComponentName who, long timeMs) throws android.os.RemoteException;
public long getMaximumTimeToLock(android.content.ComponentName who) throws android.os.RemoteException;
public void lockNow() throws android.os.RemoteException;
public void wipeData(int flags) throws android.os.RemoteException;
public android.content.ComponentName setGlobalProxy(android.content.ComponentName admin, java.lang.String proxySpec, java.lang.String exclusionList) throws android.os.RemoteException;
public android.content.ComponentName getGlobalProxyAdmin() throws android.os.RemoteException;
public int setStorageEncryption(android.content.ComponentName who, boolean encrypt) throws android.os.RemoteException;
public boolean getStorageEncryption(android.content.ComponentName who) throws android.os.RemoteException;
public int getStorageEncryptionStatus() throws android.os.RemoteException;
public void setCameraDisabled(android.content.ComponentName who, boolean disabled) throws android.os.RemoteException;
public boolean getCameraDisabled(android.content.ComponentName who) throws android.os.RemoteException;
public void setActiveAdmin(android.content.ComponentName policyReceiver, boolean refreshing) throws android.os.RemoteException;
public boolean isAdminActive(android.content.ComponentName policyReceiver) throws android.os.RemoteException;
public java.util.List<android.content.ComponentName> getActiveAdmins() throws android.os.RemoteException;
public boolean packageHasActiveAdmins(java.lang.String packageName) throws android.os.RemoteException;
public void getRemoveWarning(android.content.ComponentName policyReceiver, android.os.RemoteCallback result) throws android.os.RemoteException;
public void removeActiveAdmin(android.content.ComponentName policyReceiver) throws android.os.RemoteException;
public boolean hasGrantedPolicy(android.content.ComponentName policyReceiver, int usesPolicy) throws android.os.RemoteException;
public void setActivePasswordState(int quality, int length, int letters, int uppercase, int lowercase, int numbers, int symbols, int nonletter) throws android.os.RemoteException;
public void reportFailedPasswordAttempt() throws android.os.RemoteException;
public void reportSuccessfulPasswordAttempt() throws android.os.RemoteException;
}
