/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/printservice/IPrintService.aidl
 */
package android.printservice;
/**
 * Top-level interface to a print service component.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.printservice.IPrintService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.630 -0400", hash_original_field = "FBD1472B75074EB7069E1679DFE6ECCA", hash_generated_field = "208DFCDCB00B1A6046D9E99A354D1217")

private static final java.lang.String DESCRIPTOR = "android.printservice.IPrintService";
/**
 * Cast an IBinder object into an android.printservice.IPrintService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.632 -0400", hash_original_method = "F7E4F3440C8BC19FFCB7DD837A285496", hash_generated_method = "C5DF9BB87D51AD2D27924E2E91CFCD02")
        
public static android.printservice.IPrintService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.printservice.IPrintService))) {
return ((android.printservice.IPrintService)iin);
}
return new android.printservice.IPrintService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.653 -0400", hash_original_field = "4489C990E6AD8E2F89614D00B4A44EF3", hash_generated_field = "068C2CA10F22029AF0C9A458C7AC7270")

static final int TRANSACTION_setClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.654 -0400", hash_original_field = "14149BF3B633DF3EC12AFCF4F0ADD45B", hash_generated_field = "605CB441CAE9FB7EBDDD75DF3AD5CEFB")

static final int TRANSACTION_requestCancelPrintJob = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.655 -0400", hash_original_field = "09B5EB71E3E03F1535AFA0690C03B1A3", hash_generated_field = "251890004BD5053F802F28DFE53C3535")

static final int TRANSACTION_onPrintJobQueued = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.printservice.IPrintService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.636 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.637 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.638 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.639 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.640 -0400", hash_original_method = "D80397273C9CC88CF20B24D26BEBC9FF", hash_generated_method = "37812BC6C42E60D4ADED5D5315038FA5")
            
@Override public void setClient(android.printservice.IPrintServiceClient client) throws android.os.RemoteException
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.641 -0400", hash_original_method = "FE542EFF4CB5823DDB139D779894DA87", hash_generated_method = "898B53764F66470DA1DA8639EB73B167")
            
@Override public void requestCancelPrintJob(android.print.PrintJobInfo printJobInfo) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobInfo!=null)) {
_data.writeInt(1);
printJobInfo.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_requestCancelPrintJob, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.643 -0400", hash_original_method = "38AE2A938D35F2A936836B43D7075CFE", hash_generated_method = "EEA832343C07536FF9B6BB6FC31FFD81")
            
@Override public void onPrintJobQueued(android.print.PrintJobInfo printJobInfo) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobInfo!=null)) {
_data.writeInt(1);
printJobInfo.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onPrintJobQueued, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.644 -0400", hash_original_method = "732F56001F1A3F69A11212FC0618A1A2", hash_generated_method = "A71DE16104F2A7C7723567FCA929844A")
            
@Override public void createPrinterDiscoverySession() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_createPrinterDiscoverySession, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.645 -0400", hash_original_method = "A723751F00362CB5377F0C39BFF798F4", hash_generated_method = "03C887EB3757CE1036659FB02BE6A24D")
            
@Override public void startPrinterDiscovery(java.util.List<android.print.PrinterId> priorityList) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(priorityList);
mRemote.transact(Stub.TRANSACTION_startPrinterDiscovery, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.646 -0400", hash_original_method = "85704318F8784F72386831A8319B0A3C", hash_generated_method = "AD4D0D8146DC8670922F9C5C11401C7D")
            
@Override public void stopPrinterDiscovery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopPrinterDiscovery, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.647 -0400", hash_original_method = "8ACC446292AA8650C960C0EA159D7687", hash_generated_method = "67C70D81A33231C470540F59A9DB21E7")
            
@Override public void validatePrinters(java.util.List<android.print.PrinterId> printerIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(printerIds);
mRemote.transact(Stub.TRANSACTION_validatePrinters, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.649 -0400", hash_original_method = "EB2F7A16CB1C58E5446B4A8C46A4A920", hash_generated_method = "A5891E7486B350E3C406A0E9319D0A4B")
            
@Override public void startPrinterStateTracking(android.print.PrinterId printerId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printerId!=null)) {
_data.writeInt(1);
printerId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_startPrinterStateTracking, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.650 -0400", hash_original_method = "A2017A7C2ED7163CAB453153F9D380ED", hash_generated_method = "52CA1F75EA88D63D494E24F7271289C0")
            
@Override public void stopPrinterStateTracking(android.print.PrinterId printerId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printerId!=null)) {
_data.writeInt(1);
printerId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_stopPrinterStateTracking, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.651 -0400", hash_original_method = "0D22E992583D345C3CF871F215784413", hash_generated_method = "26D3071500D7066F643A9A8A57474DB2")
            
@Override public void destroyPrinterDiscoverySession() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_destroyPrinterDiscoverySession, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.656 -0400", hash_original_field = "071C42FB77AB9C3C9D49FDBD93937085", hash_generated_field = "6D69B39F09098934E28F501A631A5BF6")

static final int TRANSACTION_createPrinterDiscoverySession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.657 -0400", hash_original_field = "5D5FA6A8F832E0824A1E45C5B58D77E1", hash_generated_field = "009235D13EDE4843401A6631866371DD")

static final int TRANSACTION_startPrinterDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.658 -0400", hash_original_field = "831B09D82F496E57D52B81C6C1F9DC8C", hash_generated_field = "A6EBB7C69211DF4996B83CD910C87589")

static final int TRANSACTION_stopPrinterDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.659 -0400", hash_original_field = "854B2CA22B03947F882FDFC899745156", hash_generated_field = "FD227B4BAA5F8ECB7832D882449C485D")

static final int TRANSACTION_validatePrinters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.660 -0400", hash_original_field = "BF3E34F4CE010D8498F381CBB3CA972D", hash_generated_field = "59F0074058BB074BB0B116A29AF14F36")

static final int TRANSACTION_startPrinterStateTracking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.661 -0400", hash_original_field = "90975B4C7F8E1D3206DF5811A03809CC", hash_generated_field = "969C06017E30E84513A180DE0DECB25C")

static final int TRANSACTION_stopPrinterStateTracking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.662 -0400", hash_original_field = "F80F7FA404816E3AEF56D3410F4E02F7", hash_generated_field = "83FF6D1418AE77B131C5DF899992736F")

static final int TRANSACTION_destroyPrinterDiscoverySession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.631 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.633 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.635 -0400", hash_original_method = "D5D83266D5B4D9BF4CC18EDC8702B7FB", hash_generated_method = "328E6758434025F5E4983A4237C807D6")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setClient:
{
data.enforceInterface(DESCRIPTOR);
android.printservice.IPrintServiceClient _arg0;
_arg0 = android.printservice.IPrintServiceClient.Stub.asInterface(data.readStrongBinder());
this.setClient(_arg0);
return true;
}
case TRANSACTION_requestCancelPrintJob:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.requestCancelPrintJob(_arg0);
return true;
}
case TRANSACTION_onPrintJobQueued:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onPrintJobQueued(_arg0);
return true;
}
case TRANSACTION_createPrinterDiscoverySession:
{
data.enforceInterface(DESCRIPTOR);
this.createPrinterDiscoverySession();
return true;
}
case TRANSACTION_startPrinterDiscovery:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.print.PrinterId> _arg0;
_arg0 = data.createTypedArrayList(android.print.PrinterId.CREATOR);
this.startPrinterDiscovery(_arg0);
return true;
}
case TRANSACTION_stopPrinterDiscovery:
{
data.enforceInterface(DESCRIPTOR);
this.stopPrinterDiscovery();
return true;
}
case TRANSACTION_validatePrinters:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.print.PrinterId> _arg0;
_arg0 = data.createTypedArrayList(android.print.PrinterId.CREATOR);
this.validatePrinters(_arg0);
return true;
}
case TRANSACTION_startPrinterStateTracking:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrinterId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrinterId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.startPrinterStateTracking(_arg0);
return true;
}
case TRANSACTION_stopPrinterStateTracking:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrinterId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrinterId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.stopPrinterStateTracking(_arg0);
return true;
}
case TRANSACTION_destroyPrinterDiscoverySession:
{
data.enforceInterface(DESCRIPTOR);
this.destroyPrinterDiscoverySession();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void setClient(android.printservice.IPrintServiceClient client) throws android.os.RemoteException;
public void requestCancelPrintJob(android.print.PrintJobInfo printJobInfo) throws android.os.RemoteException;
public void onPrintJobQueued(android.print.PrintJobInfo printJobInfo) throws android.os.RemoteException;
public void createPrinterDiscoverySession() throws android.os.RemoteException;
public void startPrinterDiscovery(java.util.List<android.print.PrinterId> priorityList) throws android.os.RemoteException;
public void stopPrinterDiscovery() throws android.os.RemoteException;
public void validatePrinters(java.util.List<android.print.PrinterId> printerIds) throws android.os.RemoteException;
public void startPrinterStateTracking(android.print.PrinterId printerId) throws android.os.RemoteException;
public void stopPrinterStateTracking(android.print.PrinterId printerId) throws android.os.RemoteException;
public void destroyPrinterDiscoverySession() throws android.os.RemoteException;
}
