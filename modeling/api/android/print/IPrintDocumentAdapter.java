/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/IPrintDocumentAdapter.aidl
 */
package android.print;
/**
 * Interface for communication with the print adapter object.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintDocumentAdapter extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IPrintDocumentAdapter
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.473 -0400", hash_original_field = "45DA216B29F622323D30A682C07EF2CA", hash_generated_field = "09F8542FB508C76AEC930474BB04C3C6")

private static final java.lang.String DESCRIPTOR = "android.print.IPrintDocumentAdapter";
/**
 * Cast an IBinder object into an android.print.IPrintDocumentAdapter interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.475 -0400", hash_original_method = "F2DFD25C4EF59BB6D8D37638AFB6C33F", hash_generated_method = "88005DDE79B08937870B3967A804CA62")
        
public static android.print.IPrintDocumentAdapter asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IPrintDocumentAdapter))) {
return ((android.print.IPrintDocumentAdapter)iin);
}
return new android.print.IPrintDocumentAdapter.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.492 -0400", hash_original_field = "A34794EBA8FE0C031202A7AD31F24A19", hash_generated_field = "A7623C5A9EA1F1A56739B65674C732FA")

static final int TRANSACTION_setObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.493 -0400", hash_original_field = "28F2414AF3D2A098583596FCB03E1D66", hash_generated_field = "37895B015E2C7912E2BB1B60C34509A1")

static final int TRANSACTION_start = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.494 -0400", hash_original_field = "E21469E6AB0AB1E6EF90349A57F1E330", hash_generated_field = "CBCDDF154156D35A25DE59595DB252BF")

static final int TRANSACTION_layout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.print.IPrintDocumentAdapter
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.480 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.481 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.482 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.483 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.484 -0400", hash_original_method = "BABA3B209755BDE6D2E4D8424C5D3200", hash_generated_method = "74C2ACFC10DB1CCEB9404CE486F078DF")
            
@Override public void setObserver(android.print.IPrintDocumentAdapterObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setObserver, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.485 -0400", hash_original_method = "20DE489883E8BE26749E094FFA3AA1EC", hash_generated_method = "12EB309C494E8219979947395F74059B")
            
@Override public void start() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_start, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.487 -0400", hash_original_method = "473E632778330790276791DFF3A41AF3", hash_generated_method = "BB91478324CF9E5E5F1A4C788BFFB365")
            
@Override public void layout(android.print.PrintAttributes oldAttributes, android.print.PrintAttributes newAttributes, android.print.ILayoutResultCallback callback, android.os.Bundle metadata, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((oldAttributes!=null)) {
_data.writeInt(1);
oldAttributes.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((newAttributes!=null)) {
_data.writeInt(1);
newAttributes.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
if ((metadata!=null)) {
_data.writeInt(1);
metadata.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_layout, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.488 -0400", hash_original_method = "87851E1F47F2579159E747872CC187B9", hash_generated_method = "03CF423639C8E0DEEEEF5C4139A73D28")
            
@Override public void write(android.print.PageRange[] pages, android.os.ParcelFileDescriptor fd, android.print.IWriteResultCallback callback, int sequence) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(pages, 0);
if ((fd!=null)) {
_data.writeInt(1);
fd.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(sequence);
mRemote.transact(Stub.TRANSACTION_write, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.489 -0400", hash_original_method = "1CCE90C574304B2F982ADF3335137F81", hash_generated_method = "AA530434134D43BB54680CE4D31FED24")
            
@Override public void finish() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_finish, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.490 -0400", hash_original_method = "0B631A39219F90FCEC00C4B766EE123E", hash_generated_method = "DCCDB1E15686C59E8523E113A6D71491")
            
@Override public void cancel() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_cancel, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.495 -0400", hash_original_field = "E7F237FD022E028556CA1A3C4E9868AA", hash_generated_field = "62A4363BB012E158A5B74C97CE86C87D")

static final int TRANSACTION_write = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.496 -0400", hash_original_field = "602622C342844399ACE8E087D1893DB6", hash_generated_field = "3DF2EF306CBF70DAE3C30859F78B7FAD")

static final int TRANSACTION_finish = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.497 -0400", hash_original_field = "E3A51E8919C04822EC472C9A08BF95BD", hash_generated_field = "DCE0869DD50CFB268C2A8704015F67D3")

static final int TRANSACTION_cancel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.474 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.477 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.479 -0400", hash_original_method = "2185D361221CE07605C031270B89457F", hash_generated_method = "97A9AE6C05598E696E7D253864219435")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setObserver:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrintDocumentAdapterObserver _arg0;
_arg0 = android.print.IPrintDocumentAdapterObserver.Stub.asInterface(data.readStrongBinder());
this.setObserver(_arg0);
return true;
}
case TRANSACTION_start:
{
data.enforceInterface(DESCRIPTOR);
this.start();
return true;
}
case TRANSACTION_layout:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintAttributes _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintAttributes.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.print.PrintAttributes _arg1;
if ((0!=data.readInt())) {
_arg1 = android.print.PrintAttributes.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.print.ILayoutResultCallback _arg2;
_arg2 = android.print.ILayoutResultCallback.Stub.asInterface(data.readStrongBinder());
android.os.Bundle _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _arg4;
_arg4 = data.readInt();
this.layout(_arg0, _arg1, _arg2, _arg3, _arg4);
return true;
}
case TRANSACTION_write:
{
data.enforceInterface(DESCRIPTOR);
android.print.PageRange[] _arg0;
_arg0 = data.createTypedArray(android.print.PageRange.CREATOR);
android.os.ParcelFileDescriptor _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.print.IWriteResultCallback _arg2;
_arg2 = android.print.IWriteResultCallback.Stub.asInterface(data.readStrongBinder());
int _arg3;
_arg3 = data.readInt();
this.write(_arg0, _arg1, _arg2, _arg3);
return true;
}
case TRANSACTION_finish:
{
data.enforceInterface(DESCRIPTOR);
this.finish();
return true;
}
case TRANSACTION_cancel:
{
data.enforceInterface(DESCRIPTOR);
this.cancel();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void setObserver(android.print.IPrintDocumentAdapterObserver observer) throws android.os.RemoteException;
public void start() throws android.os.RemoteException;
public void layout(android.print.PrintAttributes oldAttributes, android.print.PrintAttributes newAttributes, android.print.ILayoutResultCallback callback, android.os.Bundle metadata, int sequence) throws android.os.RemoteException;
public void write(android.print.PageRange[] pages, android.os.ParcelFileDescriptor fd, android.print.IWriteResultCallback callback, int sequence) throws android.os.RemoteException;
public void finish() throws android.os.RemoteException;
public void cancel() throws android.os.RemoteException;
}
