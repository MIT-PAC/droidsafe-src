/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/printservice/IPrintServiceClient.aidl
 */
package android.printservice;
/**
 * The top-level interface from a print service to the system.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintServiceClient extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.printservice.IPrintServiceClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.993 -0400", hash_original_field = "E6CAD8532E0FD85DD0CDC40C10EF2E8E", hash_generated_field = "FAEB5651477D534DA07897E9E1F91A8D")

private static final java.lang.String DESCRIPTOR = "android.printservice.IPrintServiceClient";
/**
 * Cast an IBinder object into an android.printservice.IPrintServiceClient interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.995 -0400", hash_original_method = "38FDB2E9EBB2F74083BA85EA10327441", hash_generated_method = "7892BA0EB25C0B7B1FD93511BEC3C6D1")
        
public static android.printservice.IPrintServiceClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.printservice.IPrintServiceClient))) {
return ((android.printservice.IPrintServiceClient)iin);
}
return new android.printservice.IPrintServiceClient.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.013 -0400", hash_original_field = "9BFD868DE6314DEE2B4AA9C7FA5BDD53", hash_generated_field = "4CDE6D460AE8F6F2B62C4897D4E55AAB")

static final int TRANSACTION_getPrintJobInfos = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.014 -0400", hash_original_field = "FB215D2375F674CC15E67ED28E3557C6", hash_generated_field = "302CB1836000FB392C4DF0FB8EA68972")

static final int TRANSACTION_getPrintJobInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.016 -0400", hash_original_field = "9254BF8547EAD78E668431968019AC4E", hash_generated_field = "6C43EC55D7913552D3E0DF061BF95C19")

static final int TRANSACTION_setPrintJobState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.printservice.IPrintServiceClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.000 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.001 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.002 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.003 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.004 -0400", hash_original_method = "C1530252ADC43E030DAD6FEC7DF27B78", hash_generated_method = "FDDD6233D72D3D94ECF5C8D056B7004B")
            
@Override public java.util.List<android.print.PrintJobInfo> getPrintJobInfos() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.print.PrintJobInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrintJobInfos, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.print.PrintJobInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.005 -0400", hash_original_method = "A5BAA08340FF74B4BE3181E0A0FAAFFD", hash_generated_method = "47B3FA70DEA3AD0D4A03275E08B5AAA1")
            
@Override public android.print.PrintJobInfo getPrintJobInfo(android.print.PrintJobId printJobId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.print.PrintJobInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPrintJobInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.print.PrintJobInfo.CREATOR.createFromParcel(_reply);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.007 -0400", hash_original_method = "D86F5D94082A40FD795A9FB61DF1D0E3", hash_generated_method = "E80159881FAA46E1721C06D0E434434E")
            
@Override public boolean setPrintJobState(android.print.PrintJobId printJobId, int state, java.lang.String error) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(state);
_data.writeString(error);
mRemote.transact(Stub.TRANSACTION_setPrintJobState, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.008 -0400", hash_original_method = "B745C82B48B98DB8C32A05E38B91B61D", hash_generated_method = "E8277621C28E5ECE8E2FE939CE6B43CB")
            
@Override public boolean setPrintJobTag(android.print.PrintJobId printJobId, java.lang.String tag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(tag);
mRemote.transact(Stub.TRANSACTION_setPrintJobTag, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.009 -0400", hash_original_method = "CCCA5F0D25786D33D43ED1B4CA092A58", hash_generated_method = "13012ADEF43C620672A62BA75DC4CD71")
            
@Override public void writePrintJobData(android.os.ParcelFileDescriptor fd, android.print.PrintJobId printJobId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((fd!=null)) {
_data.writeInt(1);
fd.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_writePrintJobData, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.010 -0400", hash_original_method = "1E7D4EB452F2421F425A0667BF09CB7F", hash_generated_method = "619A3A3CD0E3043B415506F83C9A1405")
            
@Override public void onPrintersAdded(android.content.pm.ParceledListSlice printers) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printers!=null)) {
_data.writeInt(1);
printers.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onPrintersAdded, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.011 -0400", hash_original_method = "7A94E70250A6FE9C247EEC8A3DD6937E", hash_generated_method = "02E5F83F7F81F1741EBD84B5205D8057")
            
@Override public void onPrintersRemoved(android.content.pm.ParceledListSlice printerIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printerIds!=null)) {
_data.writeInt(1);
printerIds.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onPrintersRemoved, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.017 -0400", hash_original_field = "993E16FF6CA834D1EE3F1CFC158E5EDD", hash_generated_field = "0E75BD4DA1F06315F8795B14B6B9550F")

static final int TRANSACTION_setPrintJobTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.018 -0400", hash_original_field = "7F40EFD493BE7D28521CE07C8AE374D8", hash_generated_field = "741E242FD4CBE0FD886615EA55052772")

static final int TRANSACTION_writePrintJobData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.019 -0400", hash_original_field = "921E9F22ECF6656A5597207E75238460", hash_generated_field = "255D4649AC07BD02A955364733D7E9A4")

static final int TRANSACTION_onPrintersAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:11.020 -0400", hash_original_field = "13CD3175A3EAF526BED43AE34299995E", hash_generated_field = "B4221D191CAA412830C1F1960CC34397")

static final int TRANSACTION_onPrintersRemoved = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.994 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.996 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.998 -0400", hash_original_method = "E31E495B1448BF82CD2F19B0A84078DA", hash_generated_method = "BD0F187A21D14D97B7EE9AF022D3E041")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getPrintJobInfos:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.print.PrintJobInfo> _result = this.getPrintJobInfos();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getPrintJobInfo:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.print.PrintJobInfo _result = this.getPrintJobInfo(_arg0);
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
case TRANSACTION_setPrintJobState:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.setPrintJobState(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setPrintJobTag:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.setPrintJobTag(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_writePrintJobData:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.print.PrintJobId _arg1;
if ((0!=data.readInt())) {
_arg1 = android.print.PrintJobId.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.writePrintJobData(_arg0, _arg1);
return true;
}
case TRANSACTION_onPrintersAdded:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.ParceledListSlice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onPrintersAdded(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onPrintersRemoved:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.ParceledListSlice _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onPrintersRemoved(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public java.util.List<android.print.PrintJobInfo> getPrintJobInfos() throws android.os.RemoteException;
public android.print.PrintJobInfo getPrintJobInfo(android.print.PrintJobId printJobId) throws android.os.RemoteException;
public boolean setPrintJobState(android.print.PrintJobId printJobId, int state, java.lang.String error) throws android.os.RemoteException;
public boolean setPrintJobTag(android.print.PrintJobId printJobId, java.lang.String tag) throws android.os.RemoteException;
public void writePrintJobData(android.os.ParcelFileDescriptor fd, android.print.PrintJobId printJobId) throws android.os.RemoteException;
public void onPrintersAdded(android.content.pm.ParceledListSlice printers) throws android.os.RemoteException;
public void onPrintersRemoved(android.content.pm.ParceledListSlice printerIds) throws android.os.RemoteException;
}
