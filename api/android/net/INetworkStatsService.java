package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface INetworkStatsService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.net.INetworkStatsService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.811 -0500", hash_original_field = "6EC80ADF98B9C7BE09D3604E98257C1B", hash_generated_field = "7ADA7DBD1271DCD0F1724A4DA19EFC64")

private static final java.lang.String DESCRIPTOR = "android.net.INetworkStatsService";
/**
 * Cast an IBinder object into an android.net.INetworkStatsService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.816 -0500", hash_original_method = "B359032830A4B19E951D07BB2CAC68DD", hash_generated_method = "93F65E7B87ABD138A49669D30E79845A")
        
public static android.net.INetworkStatsService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.net.INetworkStatsService))) {
return ((android.net.INetworkStatsService)iin);
}
return new android.net.INetworkStatsService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.863 -0500", hash_original_field = "F713BCC315798981400D1815E78953EB", hash_generated_field = "F71B1DFB6776187F93A12C934616B7EC")

static final int TRANSACTION_getHistoryForNetwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.865 -0500", hash_original_field = "3EC8F73BAF8F03AA2540F8BCED8A65F1", hash_generated_field = "F84B75DFDC6CF4BA520FA2C5F8D58AAD")

static final int TRANSACTION_getHistoryForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.868 -0500", hash_original_field = "328A252915DA453F278D2B23A051AA90", hash_generated_field = "9D88CF49009FAF34C8F19E07E0D89D88")

static final int TRANSACTION_getSummaryForNetwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.net.INetworkStatsService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.826 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.829 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.832 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.834 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/** Return historical network layer stats for traffic that matches template. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.837 -0500", hash_original_method = "3C8C225036810D88401546DD851711AD", hash_generated_method = "34CF81588C6EC634BEF999DC3CD83224")
            
public android.net.NetworkStatsHistory getHistoryForNetwork(android.net.NetworkTemplate template, int fields) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStatsHistory _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((template!=null)) {
_data.writeInt(1);
template.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(fields);
mRemote.transact(Stub.TRANSACTION_getHistoryForNetwork, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStatsHistory.CREATOR.createFromParcel(_reply);
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
/** Return historical network layer stats for specific UID traffic that matches template. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.840 -0500", hash_original_method = "CACBAA77FE21BDA06F3C3069CD4CCD0F", hash_generated_method = "99F1BEDBE1965153DB1BE4BDA3F92C41")
            
public android.net.NetworkStatsHistory getHistoryForUid(android.net.NetworkTemplate template, int uid, int set, int tag, int fields) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStatsHistory _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((template!=null)) {
_data.writeInt(1);
template.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(uid);
_data.writeInt(set);
_data.writeInt(tag);
_data.writeInt(fields);
mRemote.transact(Stub.TRANSACTION_getHistoryForUid, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStatsHistory.CREATOR.createFromParcel(_reply);
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
/** Return network layer usage summary for traffic that matches template. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.843 -0500", hash_original_method = "A54908EF16362E2A1B808C8168074CD3", hash_generated_method = "60CBE550D1B3B36937E4A47F14105E8B")
            
public android.net.NetworkStats getSummaryForNetwork(android.net.NetworkTemplate template, long start, long end) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStats _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((template!=null)) {
_data.writeInt(1);
template.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(start);
_data.writeLong(end);
mRemote.transact(Stub.TRANSACTION_getSummaryForNetwork, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStats.CREATOR.createFromParcel(_reply);
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
/** Return network layer usage summary per UID for traffic that matches template. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.846 -0500", hash_original_method = "5AD3CBDE9BCAFD3CFE1991C5550A5D13", hash_generated_method = "8A40D821F90530FB7B83F724FB3B3066")
            
public android.net.NetworkStats getSummaryForAllUid(android.net.NetworkTemplate template, long start, long end, boolean includeTags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStats _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((template!=null)) {
_data.writeInt(1);
template.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(start);
_data.writeLong(end);
_data.writeInt(((includeTags)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_getSummaryForAllUid, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStats.CREATOR.createFromParcel(_reply);
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
/** Return data layer snapshot of UID network usage. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.848 -0500", hash_original_method = "1A88557C5D7AA6EBD3EBA7EA53E25EB1", hash_generated_method = "7BC8A10B856FF89D545A3E70287C94B6")
            
public android.net.NetworkStats getDataLayerSnapshotForUid(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.net.NetworkStats _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getDataLayerSnapshotForUid, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.net.NetworkStats.CREATOR.createFromParcel(_reply);
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
/** Increment data layer count of operations performed for UID and tag. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.851 -0500", hash_original_method = "10F51767D64FBEF18A57CD067D4BD79F", hash_generated_method = "BF673F700460A4279A8063C5978DBC4D")
            
public void incrementOperationCount(int uid, int tag, int operationCount) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(tag);
_data.writeInt(operationCount);
mRemote.transact(Stub.TRANSACTION_incrementOperationCount, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** Mark given UID as being in foreground for stats purposes. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.853 -0500", hash_original_method = "9FADAF129FD0E33999456235B63EEC10", hash_generated_method = "7A51092A770C5EEFA3CA3A8B6B70A08C")
            
public void setUidForeground(int uid, boolean uidForeground) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(((uidForeground)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setUidForeground, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** Force update of statistics. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.856 -0500", hash_original_method = "3BE8F4059C5C32BADA605B7E0626D95F", hash_generated_method = "89AA00157EB7F2C4EEC19A1CACA4EF69")
            
public void forceUpdate() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_forceUpdate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.870 -0500", hash_original_field = "1B97EED7F1F771D5DF8E3B709C63E512", hash_generated_field = "150B496EC4EDC8B48753142D6DF50F75")

static final int TRANSACTION_getSummaryForAllUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.872 -0500", hash_original_field = "4441855FA24D7ABE9F453D4CC11A3EC8", hash_generated_field = "52E0328F9B3E86967A1B427F0823E373")

static final int TRANSACTION_getDataLayerSnapshotForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.875 -0500", hash_original_field = "28BEE93730F1E15806874E252A929EDE", hash_generated_field = "420E49C8381858315C6671B1C044BD5D")

static final int TRANSACTION_incrementOperationCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.877 -0500", hash_original_field = "38E9828AB261A576499986AA024AB42B", hash_generated_field = "E3E9C62079D1B303259669973D2244A4")

static final int TRANSACTION_setUidForeground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.879 -0500", hash_original_field = "9CA0F40378F0FF64835E6733B25974B5", hash_generated_field = "ACBD76002A6ACD438B35D36314E9EC2E")

static final int TRANSACTION_forceUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.814 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.819 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.823 -0500", hash_original_method = "69F5C3AACC34E0F6C900FDF4C47AD86C", hash_generated_method = "4E64855B9281885D2FFE9E89612DF5ED")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getHistoryForNetwork:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkTemplate _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.NetworkTemplate.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.net.NetworkStatsHistory _result = this.getHistoryForNetwork(_arg0, _arg1);
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
case TRANSACTION_getHistoryForUid:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkTemplate _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.NetworkTemplate.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
android.net.NetworkStatsHistory _result = this.getHistoryForUid(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_getSummaryForNetwork:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkTemplate _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.NetworkTemplate.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _arg1;
_arg1 = data.readLong();
long _arg2;
_arg2 = data.readLong();
android.net.NetworkStats _result = this.getSummaryForNetwork(_arg0, _arg1, _arg2);
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
case TRANSACTION_getSummaryForAllUid:
{
data.enforceInterface(DESCRIPTOR);
android.net.NetworkTemplate _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.NetworkTemplate.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _arg1;
_arg1 = data.readLong();
long _arg2;
_arg2 = data.readLong();
boolean _arg3;
_arg3 = (0!=data.readInt());
android.net.NetworkStats _result = this.getSummaryForAllUid(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_getDataLayerSnapshotForUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.net.NetworkStats _result = this.getDataLayerSnapshotForUid(_arg0);
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
case TRANSACTION_incrementOperationCount:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.incrementOperationCount(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setUidForeground:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setUidForeground(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_forceUpdate:
{
data.enforceInterface(DESCRIPTOR);
this.forceUpdate();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public android.net.NetworkStatsHistory getHistoryForNetwork(android.net.NetworkTemplate template, int fields) throws android.os.RemoteException;

public android.net.NetworkStatsHistory getHistoryForUid(android.net.NetworkTemplate template, int uid, int set, int tag, int fields) throws android.os.RemoteException;

public android.net.NetworkStats getSummaryForNetwork(android.net.NetworkTemplate template, long start, long end) throws android.os.RemoteException;

public android.net.NetworkStats getSummaryForAllUid(android.net.NetworkTemplate template, long start, long end, boolean includeTags) throws android.os.RemoteException;

public android.net.NetworkStats getDataLayerSnapshotForUid(int uid) throws android.os.RemoteException;

public void incrementOperationCount(int uid, int tag, int operationCount) throws android.os.RemoteException;

public void setUidForeground(int uid, boolean uidForeground) throws android.os.RemoteException;

public void forceUpdate() throws android.os.RemoteException;
}
