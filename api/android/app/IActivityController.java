package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IActivityController extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.app.IActivityController
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.135 -0500", hash_original_field = "90DC61D876541DE853A7DC47E8FB512B", hash_generated_field = "6C26687E8308E4FD2B45EA5B977B1A31")

private static final java.lang.String DESCRIPTOR = "android.app.IActivityController";
/**
 * Cast an IBinder object into an android.app.IActivityController interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.140 -0500", hash_original_method = "711A9844EB9BDCDAA6BC114C9CEAC04D", hash_generated_method = "DBD26D52DD31C1D275DB2A38CE075133")
        
public static android.app.IActivityController asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IActivityController))) {
return ((android.app.IActivityController)iin);
}
return new android.app.IActivityController.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.177 -0500", hash_original_field = "5D922647431EBF19633BA7810273FED8", hash_generated_field = "D27A93C819DCB4D5E041DC2F8A0714EE")

static final int TRANSACTION_activityStarting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.179 -0500", hash_original_field = "3C53FC279F59776329C60DDB0BC34D27", hash_generated_field = "EB5A330A8B39BF19A2FB08FD252CC9C5")

static final int TRANSACTION_activityResuming = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.182 -0500", hash_original_field = "ED953ADBD2FB59C7695BFCC96A51848F", hash_generated_field = "31CF2484349670242B5D2FC396210F91")

static final int TRANSACTION_appCrashed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.app.IActivityController
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.150 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.153 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.155 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.157 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * The system is trying to start an activity.  Return true to allow
     * it to be started as normal, or false to cancel/reject this activity.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.160 -0500", hash_original_method = "F5F84FFEB114317F4A83F0AE47F3889E", hash_generated_method = "CDAF40B06E7FE0242180007D2ADC909F")
            
public boolean activityStarting(android.content.Intent intent, java.lang.String pkg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(pkg);
mRemote.transact(Stub.TRANSACTION_activityStarting, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * The system is trying to return to an activity.  Return true to allow
     * it to be resumed as normal, or false to cancel/reject this activity.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.163 -0500", hash_original_method = "412D6D0CAE338ACFBAD174118AB01D1C", hash_generated_method = "81564434BFFFD31A12F26CA78ECE8153")
            
public boolean activityResuming(java.lang.String pkg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg);
mRemote.transact(Stub.TRANSACTION_activityResuming, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * An application process has crashed (in Java).  Return true for the
     * normal error recovery (app crash dialog) to occur, false to kill
     * it immediately.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.166 -0500", hash_original_method = "14F34B4CD5B4E7E7712020CF919206D1", hash_generated_method = "6A26445AECDAFC2350C69DE1E02DC4E9")
            
public boolean appCrashed(java.lang.String processName, int pid, java.lang.String shortMsg, java.lang.String longMsg, long timeMillis, java.lang.String stackTrace) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(processName);
_data.writeInt(pid);
_data.writeString(shortMsg);
_data.writeString(longMsg);
_data.writeLong(timeMillis);
_data.writeString(stackTrace);
mRemote.transact(Stub.TRANSACTION_appCrashed, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Early call as soon as an ANR is detected.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.169 -0500", hash_original_method = "BE2AC70FA2718E540DBE8AB2D9B0D845", hash_generated_method = "69BF69F2A9987B2BB41554FE650D9818")
            
public int appEarlyNotResponding(java.lang.String processName, int pid, java.lang.String annotation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(processName);
_data.writeInt(pid);
_data.writeString(annotation);
mRemote.transact(Stub.TRANSACTION_appEarlyNotResponding, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * An application process is not responding.  Return 0 to show the "app
     * not responding" dialog, 1 to continue waiting, or -1 to kill it
     * immediately.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.172 -0500", hash_original_method = "633CD0A854B114BE3FF5BDCA46B67598", hash_generated_method = "A392E3482164CB683CC473A826BA8290")
            
public int appNotResponding(java.lang.String processName, int pid, java.lang.String processStats) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(processName);
_data.writeInt(pid);
_data.writeString(processStats);
mRemote.transact(Stub.TRANSACTION_appNotResponding, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.184 -0500", hash_original_field = "FC367022A8E92F33FF7E9DA9C45995FB", hash_generated_field = "F5138538D6E1D578B51EE65F5F3A84D1")

static final int TRANSACTION_appEarlyNotResponding = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.187 -0500", hash_original_field = "B4484E1CD5848C2085754DB477A208CE", hash_generated_field = "589EBD49457DB162A7305231AC84FD41")

static final int TRANSACTION_appNotResponding = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.137 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.142 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.147 -0500", hash_original_method = "E80FEF71984C4212D08F4597653B1AED", hash_generated_method = "1658D43418D2995A67E90F80F7C68BC7")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_activityStarting:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.activityStarting(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_activityResuming:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.activityResuming(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_appCrashed:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
long _arg4;
_arg4 = data.readLong();
java.lang.String _arg5;
_arg5 = data.readString();
boolean _result = this.appCrashed(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_appEarlyNotResponding:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
int _result = this.appEarlyNotResponding(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_appNotResponding:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
int _result = this.appNotResponding(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public boolean activityStarting(android.content.Intent intent, java.lang.String pkg) throws android.os.RemoteException;

public boolean activityResuming(java.lang.String pkg) throws android.os.RemoteException;

public boolean appCrashed(java.lang.String processName, int pid, java.lang.String shortMsg, java.lang.String longMsg, long timeMillis, java.lang.String stackTrace) throws android.os.RemoteException;

public int appEarlyNotResponding(java.lang.String processName, int pid, java.lang.String annotation) throws android.os.RemoteException;

public int appNotResponding(java.lang.String processName, int pid, java.lang.String processStats) throws android.os.RemoteException;
}
