/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/IPrintSpooler.aidl
 */
package android.print;
/**
 * Interface for communication with the print spooler service.
 *
 * @see android.print.IPrintSpoolerCallbacks
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintSpooler extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IPrintSpooler
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.065 -0400", hash_original_field = "A276AD475CECE0DDB8919A48964A20CE", hash_generated_field = "D4DA79D796D7380A45243E612ABCD9C8")

private static final java.lang.String DESCRIPTOR = "android.print.IPrintSpooler";
/**
 * Cast an IBinder object into an android.print.IPrintSpooler interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.067 -0400", hash_original_method = "6149979B1023CA92B78F29DFBF0E47F4", hash_generated_method = "40C75337C8B53AB6B897C988740E4A83")
        
public static android.print.IPrintSpooler asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IPrintSpooler))) {
return ((android.print.IPrintSpooler)iin);
}
return new android.print.IPrintSpooler.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.088 -0400", hash_original_field = "CE32953C3A82576544C8789A8C0E8DA3", hash_generated_field = "31B1D2A7D8E237D7FB540AF27D09AAB6")

static final int TRANSACTION_removeObsoletePrintJobs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.089 -0400", hash_original_field = "4DCB8EF39236230FE61DDD0D268F1B97", hash_generated_field = "9CFF840C386DB5D3CC15A6BF63555FAD")

static final int TRANSACTION_getPrintJobInfos = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.090 -0400", hash_original_field = "6DF75756641C7A8856225374AB4F3485", hash_generated_field = "FB292DD63DB7EF2CD1E210391B5D2D11")

static final int TRANSACTION_getPrintJobInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.print.IPrintSpooler
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.072 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.073 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.074 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.075 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.076 -0400", hash_original_method = "BD1B0711A6BC5B27468FB49642BE6456", hash_generated_method = "5350B652C3D748473158EF4A743A64F0")
            
@Override public void removeObsoletePrintJobs() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_removeObsoletePrintJobs, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.077 -0400", hash_original_method = "8B219C5FDAE550389207AD9D092BB19C", hash_generated_method = "A0316EC5B66A986466F4976D7D7B9B2D")
            
@Override public void getPrintJobInfos(android.print.IPrintSpoolerCallbacks callback, android.content.ComponentName componentName, int state, int appId, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(state);
_data.writeInt(appId);
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_getPrintJobInfos, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.078 -0400", hash_original_method = "574C5BCC2730A3829BCDE60278D4092E", hash_generated_method = "7EE054A2923E61160BDE6B6B0863583A")
            
@Override public void getPrintJobInfo(android.print.PrintJobId printJobId, android.print.IPrintSpoolerCallbacks callback, int appId, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(appId);
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_getPrintJobInfo, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.080 -0400", hash_original_method = "9908FDEFBEBE7896A387AF7B396A5BD3", hash_generated_method = "B92D0B1ADD0E935A6A2FB3056B9BA0D5")
            
@Override public void createPrintJob(android.print.PrintJobInfo printJob) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJob!=null)) {
_data.writeInt(1);
printJob.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createPrintJob, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.081 -0400", hash_original_method = "31059AC7491140E777A65C053E5C9DDC", hash_generated_method = "D303127C2DD1DDCE24804FD6F9B65017")
            
@Override public void setPrintJobState(android.print.PrintJobId printJobId, int status, java.lang.String stateReason, android.print.IPrintSpoolerCallbacks callback, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(status);
_data.writeString(stateReason);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_setPrintJobState, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.082 -0400", hash_original_method = "DFCB29EB05F27926322B3806224C82FC", hash_generated_method = "26BDA2ED666D5F0CD2BC5E0E6E3C9B67")
            
@Override public void setPrintJobTag(android.print.PrintJobId printJobId, java.lang.String tag, android.print.IPrintSpoolerCallbacks callback, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
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
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_setPrintJobTag, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.083 -0400", hash_original_method = "CCCA5F0D25786D33D43ED1B4CA092A58", hash_generated_method = "13012ADEF43C620672A62BA75DC4CD71")
            
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.085 -0400", hash_original_method = "007A08C6AFEBC1CF4DA29FEE910E63D2", hash_generated_method = "ABBFB96DE1EB872978BFE7335BC67127")
            
@Override public void setClient(android.print.IPrintSpoolerClient client) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setClient, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.086 -0400", hash_original_method = "A8C81081E888F57641A337C365C3C605", hash_generated_method = "D3551B2191A588C7325CFCE895DEC25E")
            
@Override public void setPrintJobCancelling(android.print.PrintJobId printJobId, boolean cancelling) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((cancelling)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setPrintJobCancelling, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.091 -0400", hash_original_field = "D25E9C8DC82AB472D895C570073BE38C", hash_generated_field = "C2B42418864BB9E8173E580DB9C38825")

static final int TRANSACTION_createPrintJob = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.092 -0400", hash_original_field = "E5DFA44B09B28C08CAB43BB8BD70898E", hash_generated_field = "5D7DC878F48C5D08395E89B5BB70354B")

static final int TRANSACTION_setPrintJobState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.092 -0400", hash_original_field = "2D3D0D053096EBB16C76D8B5F6D11D70", hash_generated_field = "6FA47932A5E6F58630F0B61212FB0264")

static final int TRANSACTION_setPrintJobTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.093 -0400", hash_original_field = "83C851B35245490E88124271C64A154B", hash_generated_field = "8788BC597F2FE872681ED670BDED3D1C")

static final int TRANSACTION_writePrintJobData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.094 -0400", hash_original_field = "A5DCD8359C15CE0DE21B2BC3328DED7E", hash_generated_field = "E95C0F06D2A6224302676BC44845749C")

static final int TRANSACTION_setClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.095 -0400", hash_original_field = "6BD5AB41964549408EC15A30E21F8AEC", hash_generated_field = "02E0BF10238A192608BF278C8BD7A4A5")

static final int TRANSACTION_setPrintJobCancelling = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.066 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.068 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.070 -0400", hash_original_method = "0FB6D2F2E106E08A0519CE502B01F99E", hash_generated_method = "09FCBBCED033D3102AB742326454A24E")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_removeObsoletePrintJobs:
{
data.enforceInterface(DESCRIPTOR);
this.removeObsoletePrintJobs();
return true;
}
case TRANSACTION_getPrintJobInfos:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrintSpoolerCallbacks _arg0;
_arg0 = android.print.IPrintSpoolerCallbacks.Stub.asInterface(data.readStrongBinder());
android.content.ComponentName _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
this.getPrintJobInfos(_arg0, _arg1, _arg2, _arg3, _arg4);
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
android.print.IPrintSpoolerCallbacks _arg1;
_arg1 = android.print.IPrintSpoolerCallbacks.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.getPrintJobInfo(_arg0, _arg1, _arg2, _arg3);
return true;
}
case TRANSACTION_createPrintJob:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.createPrintJob(_arg0);
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
android.print.IPrintSpoolerCallbacks _arg3;
_arg3 = android.print.IPrintSpoolerCallbacks.Stub.asInterface(data.readStrongBinder());
int _arg4;
_arg4 = data.readInt();
this.setPrintJobState(_arg0, _arg1, _arg2, _arg3, _arg4);
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
android.print.IPrintSpoolerCallbacks _arg2;
_arg2 = android.print.IPrintSpoolerCallbacks.Stub.asInterface(data.readStrongBinder());
int _arg3;
_arg3 = data.readInt();
this.setPrintJobTag(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_setClient:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrintSpoolerClient _arg0;
_arg0 = android.print.IPrintSpoolerClient.Stub.asInterface(data.readStrongBinder());
this.setClient(_arg0);
return true;
}
case TRANSACTION_setPrintJobCancelling:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setPrintJobCancelling(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void removeObsoletePrintJobs() throws android.os.RemoteException;
public void getPrintJobInfos(android.print.IPrintSpoolerCallbacks callback, android.content.ComponentName componentName, int state, int appId, int sequence) throws android.os.RemoteException;
public void getPrintJobInfo(android.print.PrintJobId printJobId, android.print.IPrintSpoolerCallbacks callback, int appId, int sequence) throws android.os.RemoteException;
public void createPrintJob(android.print.PrintJobInfo printJob) throws android.os.RemoteException;
public void setPrintJobState(android.print.PrintJobId printJobId, int status, java.lang.String stateReason, android.print.IPrintSpoolerCallbacks callback, int sequence) throws android.os.RemoteException;
public void setPrintJobTag(android.print.PrintJobId printJobId, java.lang.String tag, android.print.IPrintSpoolerCallbacks callback, int sequence) throws android.os.RemoteException;
public void writePrintJobData(android.os.ParcelFileDescriptor fd, android.print.PrintJobId printJobId) throws android.os.RemoteException;
public void setClient(android.print.IPrintSpoolerClient client) throws android.os.RemoteException;
public void setPrintJobCancelling(android.print.PrintJobId printJobId, boolean cancelling) throws android.os.RemoteException;
}
