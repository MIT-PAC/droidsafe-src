/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/IPrintSpoolerClient.aidl
 */
package android.print;
/**
 * Interface for receiving interesting state updates from the print spooler.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintSpoolerClient extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IPrintSpoolerClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.557 -0400", hash_original_field = "2CBF10112FBFA249119B523C5E671C59", hash_generated_field = "4ACC37C70572CECC46A635CEC12CC919")

private static final java.lang.String DESCRIPTOR = "android.print.IPrintSpoolerClient";
/**
 * Cast an IBinder object into an android.print.IPrintSpoolerClient interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.559 -0400", hash_original_method = "A833AF178DDC3A8F2D11EA8588F8FC6A", hash_generated_method = "E6D8B6A766A9B58FBA6C51BD3A683904")
        
public static android.print.IPrintSpoolerClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IPrintSpoolerClient))) {
return ((android.print.IPrintSpoolerClient)iin);
}
return new android.print.IPrintSpoolerClient.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.571 -0400", hash_original_field = "8E9D6B979F07C7D0ADC30AEFA14EC2D2", hash_generated_field = "ACC10FFB9EB90C14A313CA4A003FB3CC")

static final int TRANSACTION_onPrintJobQueued = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.572 -0400", hash_original_field = "FCEE1457858704560F27B8C6B4BC3C56", hash_generated_field = "28EB865E57D77C07728EC945951A51B6")

static final int TRANSACTION_onAllPrintJobsForServiceHandled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.573 -0400", hash_original_field = "47D31E8D1724EA8CD3EA856A7E5DF3AF", hash_generated_field = "887367952541DF0723DFDAE1A14D7EE9")

static final int TRANSACTION_onAllPrintJobsHandled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.print.IPrintSpoolerClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.562 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.563 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.564 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.565 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.566 -0400", hash_original_method = "9E0C24F0AB1CC7375F3F3A9086DC9678", hash_generated_method = "D6297F0CF7F3001F0274D10268ADF19E")
            
@Override public void onPrintJobQueued(android.print.PrintJobInfo printJob) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_onPrintJobQueued, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.567 -0400", hash_original_method = "833F3E61C483F5FD6229A0E192947845", hash_generated_method = "31864822C51A62BEECE1F9DD4F8F7357")
            
@Override public void onAllPrintJobsForServiceHandled(android.content.ComponentName printService) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printService!=null)) {
_data.writeInt(1);
printService.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onAllPrintJobsForServiceHandled, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.568 -0400", hash_original_method = "8E8B94E8E7CEF1F228E3C6F15B885274", hash_generated_method = "6BD95F451B987647B8351BC8006EE56E")
            
@Override public void onAllPrintJobsHandled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onAllPrintJobsHandled, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.569 -0400", hash_original_method = "BC634587D333184912FD032ADCD2FAC1", hash_generated_method = "CA2E0ADCD9C76230224BA91A5F72AED0")
            
@Override public void onPrintJobStateChanged(android.print.PrintJobInfo printJob) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_onPrintJobStateChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.574 -0400", hash_original_field = "EE718D4EBC663B90CA8270A3BC804181", hash_generated_field = "44779B616D998FA84C0AE33F27241FB1")

static final int TRANSACTION_onPrintJobStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.558 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.560 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.561 -0400", hash_original_method = "02A2BF94D3BD67C4299D7D5C1C61C2E9", hash_generated_method = "0144F4EF03931F1BCF5FC424C9D45950")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
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
case TRANSACTION_onAllPrintJobsForServiceHandled:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onAllPrintJobsForServiceHandled(_arg0);
return true;
}
case TRANSACTION_onAllPrintJobsHandled:
{
data.enforceInterface(DESCRIPTOR);
this.onAllPrintJobsHandled();
return true;
}
case TRANSACTION_onPrintJobStateChanged:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onPrintJobStateChanged(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onPrintJobQueued(android.print.PrintJobInfo printJob) throws android.os.RemoteException;
public void onAllPrintJobsForServiceHandled(android.content.ComponentName printService) throws android.os.RemoteException;
public void onAllPrintJobsHandled() throws android.os.RemoteException;
public void onPrintJobStateChanged(android.print.PrintJobInfo printJob) throws android.os.RemoteException;
}
