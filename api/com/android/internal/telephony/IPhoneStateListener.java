package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IPhoneStateListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.IPhoneStateListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.684 -0500", hash_original_field = "4E43226AD10944B25B6668798C38655F", hash_generated_field = "DC7E1DC102CC2959D0333A6146FA5840")

private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.IPhoneStateListener";
/**
 * Cast an IBinder object into an com.android.internal.telephony.IPhoneStateListener interface,
 * generating a proxy if needed.
 */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.689 -0500", hash_original_method = "90137F0421DF68B35D06DE0465F29377", hash_generated_method = "A88E6A9EE99087B6B4EBBE0926C0C860")
        
public static com.android.internal.telephony.IPhoneStateListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.IPhoneStateListener))) {
return ((com.android.internal.telephony.IPhoneStateListener)iin);
}
return new com.android.internal.telephony.IPhoneStateListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.740 -0500", hash_original_field = "77FBA770C44B4910C6BB66AA7B159925", hash_generated_field = "07864C8B4209EA6F844E54A64178D9FE")

static final int TRANSACTION_onServiceStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.743 -0500", hash_original_field = "70D50E93407927C3F629724E1D9C9562", hash_generated_field = "F4B124BA367803EAF9B1628250EBBE77")

static final int TRANSACTION_onSignalStrengthChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.746 -0500", hash_original_field = "3FB883CA3FB68F541ED003C3CAABAC61", hash_generated_field = "BD691115334B00109E5EE60C45FA1279")

static final int TRANSACTION_onMessageWaitingIndicatorChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.telephony.IPhoneStateListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.699 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.702 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.704 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.706 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.709 -0500", hash_original_method = "C9A33A10B40259A72F5FBA0E7E382D51", hash_generated_method = "5E806E3F1FE326448656417F6236C0FE")
            
public void onServiceStateChanged(android.telephony.ServiceState serviceState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((serviceState!=null)) {
_data.writeInt(1);
serviceState.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onServiceStateChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.712 -0500", hash_original_method = "DC0A9E9109A388139E403549608FC7E4", hash_generated_method = "3C2B305712709D6A51B49EB0F4044F6E")
            
public void onSignalStrengthChanged(int asu) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(asu);
mRemote.transact(Stub.TRANSACTION_onSignalStrengthChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.716 -0500", hash_original_method = "F517B5091B8665056BD57B4FCB3FBC99", hash_generated_method = "E7CEB915BE8EE3DFF214985443727721")
            
public void onMessageWaitingIndicatorChanged(boolean mwi) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((mwi)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onMessageWaitingIndicatorChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.718 -0500", hash_original_method = "345798C33F31E75F110AB020D0E567AD", hash_generated_method = "B75673078A53F36077190146EF4F656B")
            
public void onCallForwardingIndicatorChanged(boolean cfi) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((cfi)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onCallForwardingIndicatorChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
// we use bundle here instead of CellLocation so it can get the right subclass

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.721 -0500", hash_original_method = "C16E8763DB6D907DAC62DB16FE688759", hash_generated_method = "BD634BE98B9E92208F6501241B2C8052")
            
public void onCellLocationChanged(android.os.Bundle location) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((location!=null)) {
_data.writeInt(1);
location.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onCellLocationChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.724 -0500", hash_original_method = "1441A94C05CB723F89C8A58A6A1C5254", hash_generated_method = "D45295FC507A076E63DE3A2F3FDA783D")
            
public void onCallStateChanged(int state, java.lang.String incomingNumber) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(state);
_data.writeString(incomingNumber);
mRemote.transact(Stub.TRANSACTION_onCallStateChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.PHONE_STATE})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.727 -0500", hash_original_method = "23FB10E6CE8C84FF47A096923CDC3513", hash_generated_method = "F6C795097AD9EDA8D744E4DA2A882C2E")
            
public void onDataConnectionStateChanged(int state, int networkType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(state);
_data.writeInt(networkType);
mRemote.transact(Stub.TRANSACTION_onDataConnectionStateChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.729 -0500", hash_original_method = "503EE554549E0CC775F55C2500A53194", hash_generated_method = "18857B6CE283E1FFC2DE436901931D4E")
            
public void onDataActivity(int direction) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(direction);
mRemote.transact(Stub.TRANSACTION_onDataActivity, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.732 -0500", hash_original_method = "1BA113721BC76493E9E37740533BB7C3", hash_generated_method = "801EDE85FDF766DAE73B31FB76ACB375")
            
public void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((signalStrength!=null)) {
_data.writeInt(1);
signalStrength.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onSignalStrengthsChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.735 -0500", hash_original_method = "14921A04956D70BE26589046492AFC93", hash_generated_method = "A03B0CAF13CDBA8BF5E290DC915BA740")
            
public void onOtaspChanged(int otaspMode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(otaspMode);
mRemote.transact(Stub.TRANSACTION_onOtaspChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.748 -0500", hash_original_field = "61687C7538725E26A58B2949FF3EA8B5", hash_generated_field = "AACA2F25243CD725AE1089CD7A11A58B")

static final int TRANSACTION_onCallForwardingIndicatorChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.751 -0500", hash_original_field = "FF7705F85F4DE03D7E06BEE840BF6CEE", hash_generated_field = "93A4BC3A33B18D1EC3D1ACD402849F7C")

static final int TRANSACTION_onCellLocationChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.753 -0500", hash_original_field = "D915FF6C7A1308621F0CBC0F0E2B69CD", hash_generated_field = "DB2655FEBEA7FC0680942DF222409053")

static final int TRANSACTION_onCallStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.756 -0500", hash_original_field = "D36920DBA88B278B7BFBF059B4ACB86A", hash_generated_field = "87A8AC37F967BA62957D693CDC72F0C1")

static final int TRANSACTION_onDataConnectionStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.758 -0500", hash_original_field = "93AD0475B8547EFDE18DA7F552F17BC6", hash_generated_field = "A7CF03E53FBE72794E967A0FD3CA36E3")

static final int TRANSACTION_onDataActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.761 -0500", hash_original_field = "DC8ECD7832985441B873E0F417C1D3D0", hash_generated_field = "7FEA622F8187FF843F20994F002C41B8")

static final int TRANSACTION_onSignalStrengthsChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.764 -0500", hash_original_field = "9184B2CA15110251F716115A888FBF23", hash_generated_field = "709A43C1B5DFCCFD9D56680AF07C20B6")

static final int TRANSACTION_onOtaspChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.686 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.692 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.695 -0500", hash_original_method = "5E1C8CC4379FD4EFBCFC359119ABB3C4", hash_generated_method = "999C377E5CA8ECFE540B82C1DF99E271")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onServiceStateChanged:
{
data.enforceInterface(DESCRIPTOR);
android.telephony.ServiceState _arg0;
if ((0!=data.readInt())) {
_arg0 = android.telephony.ServiceState.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onServiceStateChanged(_arg0);
return true;
}
case TRANSACTION_onSignalStrengthChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onSignalStrengthChanged(_arg0);
return true;
}
case TRANSACTION_onMessageWaitingIndicatorChanged:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.onMessageWaitingIndicatorChanged(_arg0);
return true;
}
case TRANSACTION_onCallForwardingIndicatorChanged:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.onCallForwardingIndicatorChanged(_arg0);
return true;
}
case TRANSACTION_onCellLocationChanged:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onCellLocationChanged(_arg0);
return true;
}
case TRANSACTION_onCallStateChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.onCallStateChanged(_arg0, _arg1);
return true;
}
case TRANSACTION_onDataConnectionStateChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.onDataConnectionStateChanged(_arg0, _arg1);
return true;
}
case TRANSACTION_onDataActivity:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onDataActivity(_arg0);
return true;
}
case TRANSACTION_onSignalStrengthsChanged:
{
data.enforceInterface(DESCRIPTOR);
android.telephony.SignalStrength _arg0;
if ((0!=data.readInt())) {
_arg0 = android.telephony.SignalStrength.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onSignalStrengthsChanged(_arg0);
return true;
}
case TRANSACTION_onOtaspChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onOtaspChanged(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onServiceStateChanged(android.telephony.ServiceState serviceState) throws android.os.RemoteException;
public void onSignalStrengthChanged(int asu) throws android.os.RemoteException;
public void onMessageWaitingIndicatorChanged(boolean mwi) throws android.os.RemoteException;
public void onCallForwardingIndicatorChanged(boolean cfi) throws android.os.RemoteException;

public void onCellLocationChanged(android.os.Bundle location) throws android.os.RemoteException;
public void onCallStateChanged(int state, java.lang.String incomingNumber) throws android.os.RemoteException;
public void onDataConnectionStateChanged(int state, int networkType) throws android.os.RemoteException;
public void onDataActivity(int direction) throws android.os.RemoteException;
public void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) throws android.os.RemoteException;
public void onOtaspChanged(int otaspMode) throws android.os.RemoteException;
}
