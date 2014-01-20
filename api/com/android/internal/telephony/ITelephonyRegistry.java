package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ITelephonyRegistry extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.ITelephonyRegistry
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.662 -0500", hash_original_field = "2896C9B69F1B56C5513DF86BAE858FAD", hash_generated_field = "1CED6E19DC6AF8FE6836E7E60A489694")

private static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.ITelephonyRegistry";
/**
 * Cast an IBinder object into an com.android.internal.telephony.ITelephonyRegistry interface,
 * generating a proxy if needed.
 */
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.668 -0500", hash_original_method = "D46F75458154A9A00ACDE68DFB7D73CA", hash_generated_method = "68B947F06570FC092F513BE4C8093123")
        
public static com.android.internal.telephony.ITelephonyRegistry asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.telephony.ITelephonyRegistry))) {
return ((com.android.internal.telephony.ITelephonyRegistry)iin);
}
return new com.android.internal.telephony.ITelephonyRegistry.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.727 -0500", hash_original_field = "AC7CF00952E0A127E5DB498137B5F1C0", hash_generated_field = "1F73E6BB0B09D3DD139C56AA8166F73A")

static final int TRANSACTION_listen = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.729 -0500", hash_original_field = "703E65EEB9C2CC15A5E9764C6C928852", hash_generated_field = "2980FF19EE97B87AAB1A331E8D28E462")

static final int TRANSACTION_notifyCallState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.732 -0500", hash_original_field = "A902BB48C4769A59B3C5E665F386B1A4", hash_generated_field = "DA9A1084D997129F937CA598448EFA4C")

static final int TRANSACTION_notifyServiceState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.telephony.ITelephonyRegistry
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.679 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.682 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.685 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.687 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.691 -0500", hash_original_method = "CB42527524D57638A7575C6E2EB9011E", hash_generated_method = "446C3474D561A39F11525BCD70A2B4A2")
            
public void listen(java.lang.String pkg, com.android.internal.telephony.IPhoneStateListener callback, int events, boolean notifyNow) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeInt(events);
_data.writeInt(((notifyNow)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_listen, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.694 -0500", hash_original_method = "35CB5747D5BA6980C0EF266373043129", hash_generated_method = "9112C58D21C041FE18647FB0349D9954")
            
public void notifyCallState(int state, java.lang.String incomingNumber) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(state);
_data.writeString(incomingNumber);
mRemote.transact(Stub.TRANSACTION_notifyCallState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.697 -0500", hash_original_method = "D8C767D34D20211D217609AFA3CE6AC9", hash_generated_method = "7B1FEBDF9478F32F0BBBD65F1E201643")
            
public void notifyServiceState(android.telephony.ServiceState state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((state!=null)) {
_data.writeInt(1);
state.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_notifyServiceState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.700 -0500", hash_original_method = "B0C0B6A06DEFD4397E6A5F5781AECC3C", hash_generated_method = "0474748EE4EAB0E17C0A15A70680CCF2")
            
public void notifySignalStrength(android.telephony.SignalStrength signalStrength) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((signalStrength!=null)) {
_data.writeInt(1);
signalStrength.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_notifySignalStrength, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.702 -0500", hash_original_method = "20754C544EE5635E5689D06DBA2642A7", hash_generated_method = "15734DC91938E0FD4BCF526EB6A5327C")
            
public void notifyMessageWaitingChanged(boolean mwi) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((mwi)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_notifyMessageWaitingChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.706 -0500", hash_original_method = "CF98D6625B6BD52ED6D603B308890939", hash_generated_method = "7E16748FF9F2EC08D6966BC838EE48E0")
            
public void notifyCallForwardingChanged(boolean cfi) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((cfi)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_notifyCallForwardingChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.708 -0500", hash_original_method = "F39D4F665CA868DE1FA03947F1216D8B", hash_generated_method = "3421F709B680ECCBF5E6A623596AC54F")
            
public void notifyDataActivity(int state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(state);
mRemote.transact(Stub.TRANSACTION_notifyDataActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.PHONE_STATE})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.711 -0500", hash_original_method = "55A9CCD0AAC626E26768DEE46A3751F2", hash_generated_method = "A87A9F4F525FF449FA17E90FC61EE77E")
            
public void notifyDataConnection(int state, boolean isDataConnectivityPossible, java.lang.String reason, java.lang.String apn, java.lang.String apnType, android.net.LinkProperties linkProperties, android.net.LinkCapabilities linkCapabilities, int networkType, boolean roaming) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(state);
_data.writeInt(((isDataConnectivityPossible)?(1):(0)));
_data.writeString(reason);
_data.writeString(apn);
_data.writeString(apnType);
if ((linkProperties!=null)) {
_data.writeInt(1);
linkProperties.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((linkCapabilities!=null)) {
_data.writeInt(1);
linkCapabilities.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(networkType);
_data.writeInt(((roaming)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_notifyDataConnection, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.PHONE_STATE})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.714 -0500", hash_original_method = "5BFB3DB9002BBCAB41A2AB8C517A4D24", hash_generated_method = "623532AA36A7DF95C67DB360AB19ABAB")
            
public void notifyDataConnectionFailed(java.lang.String reason, java.lang.String apnType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(reason);
_data.writeString(apnType);
mRemote.transact(Stub.TRANSACTION_notifyDataConnectionFailed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.717 -0500", hash_original_method = "4FD9173A19128AADB5D4D2B306027FB0", hash_generated_method = "CB34F7933D240426421D859A503BB6AE")
            
public void notifyCellLocation(android.os.Bundle cellLocation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((cellLocation!=null)) {
_data.writeInt(1);
cellLocation.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_notifyCellLocation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.720 -0500", hash_original_method = "A4A83CE89E465C1521B2B11208F4F43D", hash_generated_method = "1817BDD58AEAF1B5C5A9B8A6DA1CEE06")
            
public void notifyOtaspChanged(int otaspMode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(otaspMode);
mRemote.transact(Stub.TRANSACTION_notifyOtaspChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.735 -0500", hash_original_field = "49F5A60931834EB0D25FA98253C59068", hash_generated_field = "9B91359237079430A7A79E44FCC7F3AF")

static final int TRANSACTION_notifySignalStrength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.737 -0500", hash_original_field = "A533430C8F291C1C1D86098CF4847EFB", hash_generated_field = "1734A50B0F020CFA18ADFF8C2D66587B")

static final int TRANSACTION_notifyMessageWaitingChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.740 -0500", hash_original_field = "610C1424575B134971E0AF9DC0362769", hash_generated_field = "F29639E2387A258ED0617290FDF25AAD")

static final int TRANSACTION_notifyCallForwardingChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.743 -0500", hash_original_field = "2562BE3A98E21398D65BFDF735BE7060", hash_generated_field = "AB945E8B5AC65510089FC300F7B7C5D9")

static final int TRANSACTION_notifyDataActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.745 -0500", hash_original_field = "C11C6B72EA5D928A7931DCB3555AA0B7", hash_generated_field = "BE62FC11DDEE0B44442A7A22C6FA37D2")

static final int TRANSACTION_notifyDataConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.749 -0500", hash_original_field = "F2D702D08EB069AA043BFEE06B51DCD8", hash_generated_field = "11CBEEB4C2675EF16556F0561C65E9AC")

static final int TRANSACTION_notifyDataConnectionFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.751 -0500", hash_original_field = "C3790A53C45315DFC199C53C03B2D3E7", hash_generated_field = "83A4E6A7ED4F1EAF5181195F4C7C002B")

static final int TRANSACTION_notifyCellLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.754 -0500", hash_original_field = "AE3B613D9F3C1B9AB9FF3CB191C13AB1", hash_generated_field = "35F5046BF829F09C94BC49D6129EA775")

static final int TRANSACTION_notifyOtaspChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.665 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.670 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.676 -0500", hash_original_method = "46C8B47770D502C554977C67222EC884", hash_generated_method = "327BA7ECEE0684191AF337A18C3E867A")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_listen:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.android.internal.telephony.IPhoneStateListener _arg1;
_arg1 = com.android.internal.telephony.IPhoneStateListener.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
boolean _arg3;
_arg3 = (0!=data.readInt());
this.listen(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyCallState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.notifyCallState(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyServiceState:
{
data.enforceInterface(DESCRIPTOR);
android.telephony.ServiceState _arg0;
if ((0!=data.readInt())) {
_arg0 = android.telephony.ServiceState.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.notifyServiceState(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifySignalStrength:
{
data.enforceInterface(DESCRIPTOR);
android.telephony.SignalStrength _arg0;
if ((0!=data.readInt())) {
_arg0 = android.telephony.SignalStrength.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.notifySignalStrength(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyMessageWaitingChanged:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.notifyMessageWaitingChanged(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyCallForwardingChanged:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.notifyCallForwardingChanged(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyDataActivity:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.notifyDataActivity(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyDataConnection:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
android.net.LinkProperties _arg5;
if ((0!=data.readInt())) {
_arg5 = android.net.LinkProperties.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
android.net.LinkCapabilities _arg6;
if ((0!=data.readInt())) {
_arg6 = android.net.LinkCapabilities.CREATOR.createFromParcel(data);
}
else {
_arg6 = null;
}
int _arg7;
_arg7 = data.readInt();
boolean _arg8;
_arg8 = (0!=data.readInt());
this.notifyDataConnection(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyDataConnectionFailed:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.notifyDataConnectionFailed(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyCellLocation:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.notifyCellLocation(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyOtaspChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.notifyOtaspChanged(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void listen(java.lang.String pkg, com.android.internal.telephony.IPhoneStateListener callback, int events, boolean notifyNow) throws android.os.RemoteException;
public void notifyCallState(int state, java.lang.String incomingNumber) throws android.os.RemoteException;
public void notifyServiceState(android.telephony.ServiceState state) throws android.os.RemoteException;
public void notifySignalStrength(android.telephony.SignalStrength signalStrength) throws android.os.RemoteException;
public void notifyMessageWaitingChanged(boolean mwi) throws android.os.RemoteException;
public void notifyCallForwardingChanged(boolean cfi) throws android.os.RemoteException;
public void notifyDataActivity(int state) throws android.os.RemoteException;
public void notifyDataConnection(int state, boolean isDataConnectivityPossible, java.lang.String reason, java.lang.String apn, java.lang.String apnType, android.net.LinkProperties linkProperties, android.net.LinkCapabilities linkCapabilities, int networkType, boolean roaming) throws android.os.RemoteException;
public void notifyDataConnectionFailed(java.lang.String reason, java.lang.String apnType) throws android.os.RemoteException;
public void notifyCellLocation(android.os.Bundle cellLocation) throws android.os.RemoteException;
public void notifyOtaspChanged(int otaspMode) throws android.os.RemoteException;
}
