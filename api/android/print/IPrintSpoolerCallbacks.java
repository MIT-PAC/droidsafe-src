/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/IPrintSpoolerCallbacks.aidl
 */
package android.print;
/**
 * Callbacks for communication with the print spooler service.
 *
 * @see android.print.IPrintSpoolerService
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintSpoolerCallbacks extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IPrintSpoolerCallbacks
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.339 -0400", hash_original_field = "B884B8B9927D33DEBC484E3290B3F404", hash_generated_field = "F5A0BA71BBCD995C0ADB0028CEBCF6F3")

private static final java.lang.String DESCRIPTOR = "android.print.IPrintSpoolerCallbacks";
/**
 * Cast an IBinder object into an android.print.IPrintSpoolerCallbacks interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.341 -0400", hash_original_method = "87D18F19478A0AA36C699D7D57678A0C", hash_generated_method = "5B6AF7BC85B2D84E7D029E5BF62A3E1E")
        
public static android.print.IPrintSpoolerCallbacks asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IPrintSpoolerCallbacks))) {
return ((android.print.IPrintSpoolerCallbacks)iin);
}
return new android.print.IPrintSpoolerCallbacks.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.356 -0400", hash_original_field = "1630835A17C57F020742083DD69315FE", hash_generated_field = "F10299987238C4697CBB4A94255D2D55")

static final int TRANSACTION_onGetPrintJobInfosResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.357 -0400", hash_original_field = "EFCB7F5EBE81C9F644BF418FCE70A95A", hash_generated_field = "0440BB659DFB8774A5A16248B139DD89")

static final int TRANSACTION_onCancelPrintJobResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.358 -0400", hash_original_field = "281DD1F6F317D2F64F0103F9F60AE2F6", hash_generated_field = "55AB38A225C3FC569C50B7EAB6E18942")

static final int TRANSACTION_onSetPrintJobStateResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.print.IPrintSpoolerCallbacks
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.345 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.346 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.347 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.348 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.349 -0400", hash_original_method = "7F0A8FDA16DE74C1243329279B2DAF8E", hash_generated_method = "5BD258DE7B359321EE37761EFB6396FC")
            
@Override public void onGetPrintJobInfosResult(java.util.List<android.print.PrintJobInfo> printJob, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(printJob);
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onGetPrintJobInfosResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.350 -0400", hash_original_method = "FAAB16B8752666AEF5F8A2EA872284D6", hash_generated_method = "ECF417383E7F82D90390E4D93F685093")
            
@Override public void onCancelPrintJobResult(boolean canceled, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((canceled)?(1):(0)));
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onCancelPrintJobResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.352 -0400", hash_original_method = "BCFC9DCC2D6A9C2E9C6C986D8ACFD59F", hash_generated_method = "6469B017DB2BAF9FB858D6CE0ADC80CE")
            
@Override public void onSetPrintJobStateResult(boolean success, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((success)?(1):(0)));
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onSetPrintJobStateResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.353 -0400", hash_original_method = "27CFB9E4367850F8F65565861C4FF398", hash_generated_method = "BCA6F20C5895CCF661A61D799BB25C10")
            
@Override public void onSetPrintJobTagResult(boolean success, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((success)?(1):(0)));
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onSetPrintJobTagResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.354 -0400", hash_original_method = "523DD5BD8E39398728CF5769A99BE5CD", hash_generated_method = "75DF7D4F6087B193D3A5A95B8276583D")
            
@Override public void onGetPrintJobInfoResult(android.print.PrintJobInfo printJob, int sequence) throws android.os.RemoteException
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
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_onGetPrintJobInfoResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.359 -0400", hash_original_field = "374F3DEFBBD676EB1FE90F545D06E9A9", hash_generated_field = "8BCD40CCECA852DF62D7628933912EE9")

static final int TRANSACTION_onSetPrintJobTagResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.360 -0400", hash_original_field = "826E329CFA86A1E4BCB886F9601A5450", hash_generated_field = "3938B6E8CE3FEEEFEDD16E181BA0E06A")

static final int TRANSACTION_onGetPrintJobInfoResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.340 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.342 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:58.344 -0400", hash_original_method = "B1D380A21914AF1EFB2B582DB6D9231E", hash_generated_method = "C0791DBB13662F0997605EA0AA696332")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onGetPrintJobInfosResult:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.print.PrintJobInfo> _arg0;
_arg0 = data.createTypedArrayList(android.print.PrintJobInfo.CREATOR);
int _arg1;
_arg1 = data.readInt();
this.onGetPrintJobInfosResult(_arg0, _arg1);
return true;
}
case TRANSACTION_onCancelPrintJobResult:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
int _arg1;
_arg1 = data.readInt();
this.onCancelPrintJobResult(_arg0, _arg1);
return true;
}
case TRANSACTION_onSetPrintJobStateResult:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
int _arg1;
_arg1 = data.readInt();
this.onSetPrintJobStateResult(_arg0, _arg1);
return true;
}
case TRANSACTION_onSetPrintJobTagResult:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
int _arg1;
_arg1 = data.readInt();
this.onSetPrintJobTagResult(_arg0, _arg1);
return true;
}
case TRANSACTION_onGetPrintJobInfoResult:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.onGetPrintJobInfoResult(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onGetPrintJobInfosResult(java.util.List<android.print.PrintJobInfo> printJob, int sequence) throws android.os.RemoteException;
public void onCancelPrintJobResult(boolean canceled, int sequence) throws android.os.RemoteException;
public void onSetPrintJobStateResult(boolean success, int sequence) throws android.os.RemoteException;
public void onSetPrintJobTagResult(boolean success, int sequence) throws android.os.RemoteException;
public void onGetPrintJobInfoResult(android.print.PrintJobInfo printJob, int sequence) throws android.os.RemoteException;
}
