package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IWindowManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.IWindowManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.391 -0500", hash_original_field = "94749AA71816ED18E065F6974D59C040", hash_generated_field = "EC0D635B0F89804A40F13F133D8544AA")

private static final java.lang.String DESCRIPTOR = "android.view.IWindowManager";

        public static android.view.IWindowManager asInterface(android.os.IBinder obj)
{
	android.view.IWindowManager retVal;
	if ((obj==null)) {
		retVal = null;
	} else {
		android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
		if (((iin!=null)&&(iin instanceof android.view.IWindowManager))) {
			retVal = ((android.view.IWindowManager)iin);
		} else {
			retVal = new android.view.IWindowManager.Stub.Proxy(obj);
		}
	}
	retVal.addTaint(obj.getTaint());
	return retVal;
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.697 -0500", hash_original_field = "1566ED9332287BBD97B501E5FEE6274F", hash_generated_field = "95BD1C33B9C523EE57833DC0568C7F6E")

static final int TRANSACTION_startViewServer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.700 -0500", hash_original_field = "E353CD7C8066ED0BF400B92915D823F4", hash_generated_field = "6474E417A1BDC6E5AAC7CF0E6FEC5999")

static final int TRANSACTION_stopViewServer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.702 -0500", hash_original_field = "2387E7E7FDC1C36E584013472E262121", hash_generated_field = "51A6600713DE4A7336ADE7E75CCC635C")

static final int TRANSACTION_isViewServerRunning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);

private static class Proxy implements android.view.IWindowManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.422 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.425 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.428 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.430 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * ===== NOTICE =====
     * The first three methods must remain the first three methods. Scripts
     * and tools rely on their transaction number to work properly.
     */// This is used for debugging

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.433 -0500", hash_original_method = "2D9879CEE40E2BA0156C27B646F50C3D", hash_generated_method = "655796A4C4A6B3FBD15AA675A9BA343F")
            
public boolean startViewServer(int port) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(port);
mRemote.transact(Stub.TRANSACTION_startViewServer, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Transaction #1

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.436 -0500", hash_original_method = "5D891C9305427C783143F7563E2B168F", hash_generated_method = "4C11C63687F896BCA7317DE641DDB1FF")
            
public boolean stopViewServer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopViewServer, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Transaction #2

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.439 -0500", hash_original_method = "05AF4E54CB50187CC10C750CE0300675", hash_generated_method = "B519606CE0F2232F0BC25D1523465A21")
            
public boolean isViewServerRunning() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isViewServerRunning, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Transaction #3

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.442 -0500", hash_original_method = "26B43F52765B90ACC60482449CA98F7E", hash_generated_method = "76555BF82423560ACCEC9AF96C545D03")
            
public android.view.IWindowSession openSession(com.android.internal.view.IInputMethodClient client, com.android.internal.view.IInputContext inputContext) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.view.IWindowSession _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
_data.writeStrongBinder((((inputContext!=null))?(inputContext.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_openSession, _data, _reply, 0);
_reply.readException();
_result = android.view.IWindowSession.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.444 -0500", hash_original_method = "5FA117A2D00FC21DCE8BAEB1DB5E6E58", hash_generated_method = "8710F70ABBB283D3B9DE69DA6612701B")
            
public boolean inputMethodClientHasFocus(com.android.internal.view.IInputMethodClient client) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_inputMethodClientHasFocus, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.447 -0500", hash_original_method = "1DA3165411FF66342E9A1F7F2575E828", hash_generated_method = "B69406432CE1F583C7CF2A15E142570A")
            
public void getDisplaySize(android.graphics.Point size) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDisplaySize, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
size.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.451 -0500", hash_original_method = "EB81BEB8566A5350FDF5D9F1772FCD2E", hash_generated_method = "211943D658F9810A314FA3DF90B869C2")
            
public void getRealDisplaySize(android.graphics.Point size) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRealDisplaySize, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
size.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.454 -0500", hash_original_method = "157E7B2826AD667A480B6615D684C664", hash_generated_method = "801183D21F2F660F99D5AA70DE801896")
            
public int getMaximumSizeDimension() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMaximumSizeDimension, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.457 -0500", hash_original_method = "A8AD914061D3B10D0DF0C045A4BB2407", hash_generated_method = "3A10E28CFC1D2AB65DFC8B76000F6E9C")
            
public void setForcedDisplaySize(int longDimen, int shortDimen) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(longDimen);
_data.writeInt(shortDimen);
mRemote.transact(Stub.TRANSACTION_setForcedDisplaySize, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.460 -0500", hash_original_method = "D12E6C98FF7CE454748705E50ADAA532", hash_generated_method = "55682C43706928D564DD76AF00287603")
            
public void clearForcedDisplaySize() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_clearForcedDisplaySize, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}

            public boolean canStatusBarHide() throws android.os.RemoteException
{
	android.os.Parcel _data = android.os.Parcel.obtain();
	android.os.Parcel _reply = android.os.Parcel.obtain();
	boolean _result;
	try {
		_data.writeInterfaceToken(DESCRIPTOR);
		mRemote.transact(Stub.TRANSACTION_canStatusBarHide, _data, _reply, 0);
		_reply.readException();
		_result = (0!=_reply.readInt());
	}
	finally {
		_reply.recycle();
		_data.recycle();
	}
	return getTaintBoolean();
}
// These can only be called when injecting events to your own window,
// or by holding the INJECT_EVENTS permission.  These methods may block
// until pending input events are finished being dispatched even when 'sync' is false.
// Avoid calling these methods on your UI thread or use the 'NoWait' version instead.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.465 -0500", hash_original_method = "04CAC982945F800036F52E5EB1E4D4C6", hash_generated_method = "B88B2B5D3E3CD183FEC469E529E54F67")
            
public boolean injectKeyEvent(android.view.KeyEvent ev, boolean sync) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ev!=null)) {
_data.writeInt(1);
ev.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((sync)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_injectKeyEvent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.468 -0500", hash_original_method = "5CC85B5664C5246E80410808722C2BED", hash_generated_method = "CF91D5021EFC30D8515985BE70287FCE")
            
public boolean injectPointerEvent(android.view.MotionEvent ev, boolean sync) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ev!=null)) {
_data.writeInt(1);
ev.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((sync)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_injectPointerEvent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.471 -0500", hash_original_method = "D1352126CCE2AC7F9D0E396DC8730508", hash_generated_method = "8A106839A1B0178B31C5B2F25E81CEE6")
            
public boolean injectTrackballEvent(android.view.MotionEvent ev, boolean sync) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ev!=null)) {
_data.writeInt(1);
ev.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((sync)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_injectTrackballEvent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.474 -0500", hash_original_method = "9FC2E944D8A22C4EF42856F8F53CB954", hash_generated_method = "3316909B8827CBC00DE06F60E1B3A8B7")
            
public boolean injectInputEventNoWait(android.view.InputEvent ev) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ev!=null)) {
_data.writeInt(1);
ev.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_injectInputEventNoWait, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// These can only be called when holding the MANAGE_APP_TOKENS permission.

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.477 -0500", hash_original_method = "45603D89407C59DED4A5DC1004A25367", hash_generated_method = "1D1323E9A189617154668B690F6E246F")
            
public void pauseKeyDispatching(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_pauseKeyDispatching, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.479 -0500", hash_original_method = "AE30EF489A89A2DBB35D9DD915795253", hash_generated_method = "9628BCAA56B23180928AD5651F0ACBEC")
            
public void resumeKeyDispatching(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_resumeKeyDispatching, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.482 -0500", hash_original_method = "E4DF3890926568FFBC713321ADBD59B0", hash_generated_method = "2FB8AEE9C0E830C05954C286C984DECF")
            
public void setEventDispatching(boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setEventDispatching, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.485 -0500", hash_original_method = "68C9AC258EA1CA4D68FA35CD605A5E0D", hash_generated_method = "9A80D461231B53026B63355161DBDE45")
            
public void addWindowToken(android.os.IBinder token, int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_addWindowToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.487 -0500", hash_original_method = "434B117AA95D41A5C6FCC1C15DC17B79", hash_generated_method = "B57E56F998504E60FA68E661D9A931C5")
            
public void removeWindowToken(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_removeWindowToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.491 -0500", hash_original_method = "C9F91A0CB31C3DF088CB7202840BE465", hash_generated_method = "798A09269DA23E82DBA4600FCF8988C1")
            
public void addAppToken(int addPos, android.view.IApplicationToken token, int groupId, int requestedOrientation, boolean fullscreen) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(addPos);
_data.writeStrongBinder((((token!=null))?(token.asBinder()):(null)));
_data.writeInt(groupId);
_data.writeInt(requestedOrientation);
_data.writeInt(((fullscreen)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_addAppToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.494 -0500", hash_original_method = "E203D6940D8A2FB1C80929CD40ED2CB2", hash_generated_method = "2B8C7BAE82D2E4264EAB1D101AB7B606")
            
public void setAppGroupId(android.os.IBinder token, int groupId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(groupId);
mRemote.transact(Stub.TRANSACTION_setAppGroupId, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.497 -0500", hash_original_method = "2610537932CD56B8E20F6B11C9AE5D35", hash_generated_method = "250F2B15EC0983F40302C323BE432E09")
            
public void setAppOrientation(android.view.IApplicationToken token, int requestedOrientation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((token!=null))?(token.asBinder()):(null)));
_data.writeInt(requestedOrientation);
mRemote.transact(Stub.TRANSACTION_setAppOrientation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.500 -0500", hash_original_method = "A11FFC266EE072C5C7AD92E69CF04007", hash_generated_method = "A1D45582FD81D69581CF39014CFC433E")
            
public int getAppOrientation(android.view.IApplicationToken token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((token!=null))?(token.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getAppOrientation, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.502 -0500", hash_original_method = "1D319BF31253DCF21B7B4315C4BC0E71", hash_generated_method = "B35B5B1BA0117847A9925436F91E9F82")
            
public void setFocusedApp(android.os.IBinder token, boolean moveFocusNow) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(((moveFocusNow)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setFocusedApp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.505 -0500", hash_original_method = "07499EF0C6EC345D39E2283B7E91A57C", hash_generated_method = "E3EC2D061668B72AFEB9A31DA974CC3E")
            
public void prepareAppTransition(int transit, boolean alwaysKeepCurrent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(transit);
_data.writeInt(((alwaysKeepCurrent)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_prepareAppTransition, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.508 -0500", hash_original_method = "827F78035E4BB828CF8DB31EF60CDD69", hash_generated_method = "54B1AD297D7867D6A57EE56A1B54FB12")
            
public int getPendingAppTransition() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPendingAppTransition, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.521 -0500", hash_original_method = "81461174334D379253C781E877388F91", hash_generated_method = "1CB97DB68280AA3CC5531C7B1A3512F7")
            
public void overridePendingAppTransition(java.lang.String packageName, int enterAnim, int exitAnim) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(enterAnim);
_data.writeInt(exitAnim);
mRemote.transact(Stub.TRANSACTION_overridePendingAppTransition, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.524 -0500", hash_original_method = "7365D88628C8822F0F20E076419C508A", hash_generated_method = "83D2DFF5E9456EF5C60AE6AB4191136A")
            
public void executeAppTransition() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_executeAppTransition, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.528 -0500", hash_original_method = "08DDF512B10FE6B21E6527A36CB4DEC2", hash_generated_method = "01BF9478DEA58552EF30674B01BB5F86")
            
public void setAppStartingWindow(android.os.IBinder token, java.lang.String pkg, int theme, android.content.res.CompatibilityInfo compatInfo, java.lang.CharSequence nonLocalizedLabel, int labelRes, int icon, int windowFlags, android.os.IBinder transferFrom, boolean createIfNeeded) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeString(pkg);
_data.writeInt(theme);
if ((compatInfo!=null)) {
_data.writeInt(1);
compatInfo.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((nonLocalizedLabel!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(nonLocalizedLabel, _data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(labelRes);
_data.writeInt(icon);
_data.writeInt(windowFlags);
_data.writeStrongBinder(transferFrom);
_data.writeInt(((createIfNeeded)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setAppStartingWindow, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.531 -0500", hash_original_method = "8D91354CA4AB6D6A932A41A4A6A2C6E0", hash_generated_method = "A08030565559D55C95A790E6B9B2D105")
            
public void setAppWillBeHidden(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_setAppWillBeHidden, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.534 -0500", hash_original_method = "C667E73D24100FDAE0302AF01B1721FD", hash_generated_method = "AFAEA6E56D940F9B2A780A6967B643A5")
            
public void setAppVisibility(android.os.IBinder token, boolean visible) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(((visible)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setAppVisibility, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.537 -0500", hash_original_method = "0AF8C5E49871C39A5EF676B904083728", hash_generated_method = "1405F7586270E1ABB64FBC180B39D4BF")
            
public void startAppFreezingScreen(android.os.IBinder token, int configChanges) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(configChanges);
mRemote.transact(Stub.TRANSACTION_startAppFreezingScreen, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.541 -0500", hash_original_method = "E8A45AF928C91B51A86CF1C773407B97", hash_generated_method = "0C52B7DF4D6B2621FC65E91DC1DEF5C3")
            
public void stopAppFreezingScreen(android.os.IBinder token, boolean force) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(((force)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_stopAppFreezingScreen, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.544 -0500", hash_original_method = "20306967C984BCCBCBA965C8DF76E23A", hash_generated_method = "767BFA400388851749A985AA98A225DA")
            
public void removeAppToken(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_removeAppToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.547 -0500", hash_original_method = "FC5B8D2D610E190996E73CF54E717F20", hash_generated_method = "B50A1DF1BA868DD549616B10230911DE")
            
public void moveAppToken(int index, android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_moveAppToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.549 -0500", hash_original_method = "426F2E2CD7A8C097F94B59B34D8F5B30", hash_generated_method = "E6AEC150009E29729000FFE8787FCC2C")
            
public void moveAppTokensToTop(java.util.List<android.os.IBinder> tokens) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeBinderList(tokens);
mRemote.transact(Stub.TRANSACTION_moveAppTokensToTop, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.553 -0500", hash_original_method = "E8650E42AD6F9F24EA3C5D033EF99ED4", hash_generated_method = "2AE6BBF7F7E4F4B5178943EA6E08418F")
            
public void moveAppTokensToBottom(java.util.List<android.os.IBinder> tokens) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeBinderList(tokens);
mRemote.transact(Stub.TRANSACTION_moveAppTokensToBottom, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Re-evaluate the current orientation from the caller's state.
// If there is a change, the new Configuration is returned and the
// caller must call setNewConfiguration() sometime later.

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.556 -0500", hash_original_method = "400BA41181E53EC3508DE55AC5CF30F4", hash_generated_method = "41DB0D7AB79899C581E75585A55292CC")
            
public android.content.res.Configuration updateOrientationFromAppTokens(android.content.res.Configuration currentConfig, android.os.IBinder freezeThisOneIfNeeded) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.res.Configuration _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((currentConfig!=null)) {
_data.writeInt(1);
currentConfig.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder(freezeThisOneIfNeeded);
mRemote.transact(Stub.TRANSACTION_updateOrientationFromAppTokens, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.res.Configuration.CREATOR.createFromParcel(_reply);
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
@DSSink({DSSinkKind.SYSTEM_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.559 -0500", hash_original_method = "0BDEB4B6740FC69209C1D9404E6CDFD6", hash_generated_method = "1DAE6949DD6AE0EF212A26E527029C80")
            
public void setNewConfiguration(android.content.res.Configuration config) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((config!=null)) {
_data.writeInt(1);
config.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setNewConfiguration, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// these require DISABLE_KEYGUARD permission

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.562 -0500", hash_original_method = "8A64EAC6B9BF7013C96B2C098290A07B", hash_generated_method = "B633205C266249A0D49EA8B2CE8302A8")
            
public void disableKeyguard(android.os.IBinder token, java.lang.String tag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeString(tag);
mRemote.transact(Stub.TRANSACTION_disableKeyguard, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.565 -0500", hash_original_method = "275AEED14E700914AE2FCB23A612E4FC", hash_generated_method = "DE2B95D4998D3B1A8B9628443B8376A5")
            
public void reenableKeyguard(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_reenableKeyguard, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.568 -0500", hash_original_method = "B9866789E2435FD0EAF34E79861901BB", hash_generated_method = "BFE03E7C578252EA4AB22ADDF0670676")
            
public void exitKeyguardSecurely(android.view.IOnKeyguardExitResult callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_exitKeyguardSecurely, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.571 -0500", hash_original_method = "41AEA8A19FA08199572767C23E5F366B", hash_generated_method = "1034A532EF3FEF9D79571091CCA2D84A")
            
public boolean isKeyguardLocked() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isKeyguardLocked, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.574 -0500", hash_original_method = "4A29DC411BCBDF56827A255915BF6C27", hash_generated_method = "FB7904A1BF715CE13E672231DF6F5AF6")
            
public boolean isKeyguardSecure() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isKeyguardSecure, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.576 -0500", hash_original_method = "518ECACD2FF98D909C0AB150C7A87A72", hash_generated_method = "0C2DDE98797583734B0EDE677A6071C5")
            
public boolean inKeyguardRestrictedInputMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_inKeyguardRestrictedInputMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.579 -0500", hash_original_method = "3550F31825B6FD67AA3D60DBA7C2172E", hash_generated_method = "1C35C01A19E50AE888AB88CD3CB2C85E")
            
public void dismissKeyguard() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_dismissKeyguard, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.582 -0500", hash_original_method = "F34FD9E6A31D07F7E3039F17FCB187FF", hash_generated_method = "B852579D88451B6EF79E3C8FCAC0517F")
            
public void closeSystemDialogs(java.lang.String reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(reason);
mRemote.transact(Stub.TRANSACTION_closeSystemDialogs, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// These can only be called with the SET_ANIMATON_SCALE permission.

@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.585 -0500", hash_original_method = "306ABE9311EAC00183520FD5E1774028", hash_generated_method = "24174B4B3416F2B43785EFE67532C1CC")
            
public float getAnimationScale(int which) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(which);
mRemote.transact(Stub.TRANSACTION_getAnimationScale, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.589 -0500", hash_original_method = "F3EFC97EB84AF55A83797873A51A87DA", hash_generated_method = "98980DC4E25570EBEFD8DCC47FCDF6B7")
            
public float[] getAnimationScales() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAnimationScales, _data, _reply, 0);
_reply.readException();
_result = _reply.createFloatArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.592 -0500", hash_original_method = "0CBEDE37DA1D98AAA9EEF325CCB986F5", hash_generated_method = "8DBCB65BCF88F5B9A23C5C1321699079")
            
public void setAnimationScale(int which, float scale) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(which);
_data.writeFloat(scale);
mRemote.transact(Stub.TRANSACTION_setAnimationScale, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.594 -0500", hash_original_method = "31C7337A9C0DFDE3826C59B330B3434A", hash_generated_method = "68887281641FD58E871AF793AC50F028")
            
public void setAnimationScales(float[] scales) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeFloatArray(scales);
mRemote.transact(Stub.TRANSACTION_setAnimationScales, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// These require the READ_INPUT_STATE permission.

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.597 -0500", hash_original_method = "E976FC2EA4C512A5021717FD70CA0D73", hash_generated_method = "FB1D4B76363CE6CDDB45E81D557CF656")
            
public int getSwitchState(int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getSwitchState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.600 -0500", hash_original_method = "C4B59194F41CA13AE9B6E7B92005B950", hash_generated_method = "9F27A451BE63D77BF746EF56EDF7DBF5")
            
public int getSwitchStateForDevice(int devid, int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(devid);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getSwitchStateForDevice, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.603 -0500", hash_original_method = "6EB9A2E170F7A94A071C12DDBE7CA564", hash_generated_method = "B238DF7207F285C93836BB9B1AB9096B")
            
public int getScancodeState(int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getScancodeState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.606 -0500", hash_original_method = "8F17FC5292CCF4DC82F71E8A88CA2733", hash_generated_method = "866BBF6BC98434647A9317BE562CFC70")
            
public int getScancodeStateForDevice(int devid, int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(devid);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getScancodeStateForDevice, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.609 -0500", hash_original_method = "ED0C049DCF4AC3C72D1645C296A1FE38", hash_generated_method = "B703DDB022A085A054CA833198691F20")
            
public int getTrackballScancodeState(int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getTrackballScancodeState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.612 -0500", hash_original_method = "AA730B1F8EAA7A601E3BF2A1D438B25F", hash_generated_method = "25661F9E7FD6B5ED41D1B92900805DB4")
            
public int getDPadScancodeState(int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getDPadScancodeState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.616 -0500", hash_original_method = "9799A2AF9A82FF556D052D806077A82C", hash_generated_method = "781CAB0DCC815BB38A52E2DEF0708FAF")
            
public int getKeycodeState(int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getKeycodeState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.618 -0500", hash_original_method = "AA507E59D494FE01700EAA6787124F0F", hash_generated_method = "DFB1A3B059D53598821855DFE957CFEE")
            
public int getKeycodeStateForDevice(int devid, int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(devid);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getKeycodeStateForDevice, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.621 -0500", hash_original_method = "265BEA4C0018D37B6225AEBF56A6C37F", hash_generated_method = "4B35579FB7C84737DCEE15FCCDD33B65")
            
public int getTrackballKeycodeState(int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getTrackballKeycodeState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.624 -0500", hash_original_method = "BF48CA29C8582DF48E82DD8E80C062ED", hash_generated_method = "9FA74D1CA5F55F74935274BFC891D8A5")
            
public int getDPadKeycodeState(int sw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sw);
mRemote.transact(Stub.TRANSACTION_getDPadKeycodeState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.627 -0500", hash_original_method = "DD667025688D3F959E3FFF7E78B4F9C0", hash_generated_method = "5D9ABB91388FCF446C1B17B88863CE37")
            
public android.view.InputChannel monitorInput(java.lang.String inputChannelName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.view.InputChannel _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(inputChannelName);
mRemote.transact(Stub.TRANSACTION_monitorInput, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.view.InputChannel.CREATOR.createFromParcel(_reply);
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
// Report whether the hardware supports the given keys; returns true if successful

@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.629 -0500", hash_original_method = "366FE96078ECD5D614ACA00DC9420EB7", hash_generated_method = "6F1BBD37319242A0B4517BFEF34E4456")
            
public boolean hasKeys(int[] keycodes, boolean[] keyExists) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(keycodes);
_data.writeBooleanArray(keyExists);
mRemote.transact(Stub.TRANSACTION_hasKeys, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
_reply.readBooleanArray(keyExists);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

            public android.view.InputDevice getInputDevice(int deviceId) throws android.os.RemoteException
{
	addTaint(deviceId);
	android.os.Parcel _data = android.os.Parcel.obtain();
	android.os.Parcel _reply = android.os.Parcel.obtain();
	android.view.InputDevice _result;
	try {
		_data.writeInterfaceToken(DESCRIPTOR);
		_data.writeInt(deviceId);
		mRemote.transact(Stub.TRANSACTION_getInputDevice, _data, _reply, 0);
		_reply.readException();
		if ((0!=_reply.readInt())) {
			_result = android.view.InputDevice.CREATOR.createFromParcel(_reply);
		}
		else {
			_result = null;
		}
	}
	finally {
		_reply.recycle();
		_data.recycle();
	}
	_result.addTaint(getTaint());
	return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.635 -0500", hash_original_method = "3D76221EEE129FA0ECE3D53CFBE745D6", hash_generated_method = "9A4EF4BF180AABD3096EE0ABADEC19F6")
            
public int[] getInputDeviceIds() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInputDeviceIds, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// For testing

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.638 -0500", hash_original_method = "52A17965AC134C7133CBA6BF88A9F477", hash_generated_method = "A90EBF07F4876B71E12EBCF80F18605D")
            
public void setInTouchMode(boolean showFocus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((showFocus)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setInTouchMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}

            public void showStrictModeViolation(boolean on) throws android.os.RemoteException
{
	addTaint(on);
	android.os.Parcel _data = android.os.Parcel.obtain();
	android.os.Parcel _reply = android.os.Parcel.obtain();
	try {
		_data.writeInterfaceToken(DESCRIPTOR);
		_data.writeInt(((on)?(1):(0)));
		mRemote.transact(Stub.TRANSACTION_showStrictModeViolation, _data, _reply, 0);
		_reply.readException();
	}
	finally {
		_reply.recycle();
		_data.recycle();
	}
}
// Proxy to set the system property for whether the flashing
// should be enabled.  The 'enabled' value is null or blank for
// the system default (differs per build variant) or any valid
// boolean string as parsed by SystemProperties.getBoolean().

@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.645 -0500", hash_original_method = "7B55B749407372647BD05C6F10B051A2", hash_generated_method = "8C4BE03E80366B3D7AC6CA6A6C99425C")
            
public void setStrictModeVisualIndicatorPreference(java.lang.String enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(enabled);
mRemote.transact(Stub.TRANSACTION_setStrictModeVisualIndicatorPreference, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// These can only be called with the SET_ORIENTATION permission.
/**
     * Update the current screen rotation based on the current state of
     * the world.
     * @param alwaysSendConfiguration Flag to force a new configuration to
     * be evaluated.  This can be used when there are other parameters in
     * configuration that are changing.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.648 -0500", hash_original_method = "85C9F34931A44A165EAEA0FAE508E194", hash_generated_method = "207E8218535204E0F52D36589A50BBBD")
            
public void updateRotation(boolean alwaysSendConfiguration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((alwaysSendConfiguration)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_updateRotation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Retrieve the current screen orientation, constants as per
     * {@link android.view.Surface}.
     */
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.650 -0500", hash_original_method = "398A53213006E05BB71DCA5D7BCD23A7", hash_generated_method = "083DB7210165873C863A46409AF9534B")
            
public int getRotation() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRotation, _data, _reply, 0);
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
     * Watch the rotation of the screen.  Returns the current rotation,
     * calls back when it changes.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.653 -0500", hash_original_method = "805704D2D7AD9F981124E9C1981CCFE3", hash_generated_method = "53F11EA6BB485B47524DDE50DB213D0B")
            
public int watchRotation(android.view.IRotationWatcher watcher) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((watcher!=null))?(watcher.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_watchRotation, _data, _reply, 0);
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
     * Determine the preferred edge of the screen to pin the compact options menu against.
     * @return a Gravity value for the options menu panel
     * @hide
     */
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.656 -0500", hash_original_method = "AAC8116C8A90DF67AF7EDCE07F828F65", hash_generated_method = "2ECCCF000CC425CFE1DBF8B3AE61DB07")
            
public int getPreferredOptionsPanelGravity() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPreferredOptionsPanelGravity, _data, _reply, 0);
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
	 * Lock the device orientation to the specified rotation, or to the
	 * current rotation if -1.  Sensor input will be ignored until
	 * thawRotation() is called.
	 * @hide
	 */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.659 -0500", hash_original_method = "D482DA73C3957D19059CA60559535D3B", hash_generated_method = "C94735AF4B879244FEE8F096216042BC")
            
public void freezeRotation(int rotation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(rotation);
mRemote.transact(Stub.TRANSACTION_freezeRotation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Release the orientation lock imposed by freezeRotation().
	 * @hide
	 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.662 -0500", hash_original_method = "257DC60089B3788A8CA15F209EB5088F", hash_generated_method = "4DFF09C7B0E9CC48FBF976DFB0EE8764")
            
public void thawRotation() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_thawRotation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Create a screenshot of the applications currently displayed.
	 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.665 -0500", hash_original_method = "4658FEEAFD4F5548D13221286354A723", hash_generated_method = "F5834261610AB9CD7BE34147FBF63256")
            
public android.graphics.Bitmap screenshotApplications(android.os.IBinder appToken, int maxWidth, int maxHeight) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.graphics.Bitmap _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(appToken);
_data.writeInt(maxWidth);
_data.writeInt(maxHeight);
mRemote.transact(Stub.TRANSACTION_screenshotApplications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.graphics.Bitmap.CREATOR.createFromParcel(_reply);
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
/**
     * Called by the status bar to notify Views of changes to System UI visiblity.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.668 -0500", hash_original_method = "DB95160710490488D54FFE03BDFBD86E", hash_generated_method = "2E1AA464F4CE25C5ADC3EADE8183CECC")
            
public void statusBarVisibilityChanged(int visibility) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(visibility);
mRemote.transact(Stub.TRANSACTION_statusBarVisibilityChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called by the settings application to temporarily set the pointer speed.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.671 -0500", hash_original_method = "B5E043558F7928EE2F6B5F1CFD58F96F", hash_generated_method = "0D7CC72E5C631ED3CEB93461755B36BC")
            
public void setPointerSpeed(int speed) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(speed);
mRemote.transact(Stub.TRANSACTION_setPointerSpeed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Block until the given window has been drawn to the screen.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.673 -0500", hash_original_method = "E0CB7BEA470C3E6F5EC9C5CEF6FB0DFF", hash_generated_method = "213E9B049FB198E2C1D91BEE64BEB1C3")
            
public void waitForWindowDrawn(android.os.IBinder token, android.os.IRemoteCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_waitForWindowDrawn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}

            public boolean hasNavigationBar() throws android.os.RemoteException
{
	android.os.Parcel _data = android.os.Parcel.obtain();
	android.os.Parcel _reply = android.os.Parcel.obtain();
	boolean _result;
	try {
		_data.writeInterfaceToken(DESCRIPTOR);
		mRemote.transact(Stub.TRANSACTION_hasNavigationBar, _data, _reply, 0);
		_reply.readException();
		_result = (0!=_reply.readInt());
	}
	finally {
		_reply.recycle();
		_data.recycle();
	}
	return getTaintBoolean();
}

}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.705 -0500", hash_original_field = "94A9CBB24369BF9BCE81A9AC9AB0F752", hash_generated_field = "07A3DFCFF22DA2A514B2FF7ED226B9D2")

static final int TRANSACTION_openSession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.708 -0500", hash_original_field = "41394AD1072A23A74E03AAF606F25B15", hash_generated_field = "BB77E91AFFE5DD805A423FD5C82EF9E9")

static final int TRANSACTION_inputMethodClientHasFocus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.710 -0500", hash_original_field = "73BA7202D7BF06AE4F2CEC9291249591", hash_generated_field = "17A49717FD306B5C1C2CB22D51D728C5")

static final int TRANSACTION_getDisplaySize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.713 -0500", hash_original_field = "4DC08090F223B5AD0F846EB2F64275E4", hash_generated_field = "0B6FDCA74ED5E41710DAA1971A12F57D")

static final int TRANSACTION_getRealDisplaySize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.715 -0500", hash_original_field = "088DA095E7953D8DE889A383F6716BFE", hash_generated_field = "2D2D97F6574D89B1479046C3D9E9AA37")

static final int TRANSACTION_getMaximumSizeDimension = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.718 -0500", hash_original_field = "A84CE37B97A8BF908573539E8B4F33B9", hash_generated_field = "B2F8D2F7122C994592B29C9A380ECECC")

static final int TRANSACTION_setForcedDisplaySize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.721 -0500", hash_original_field = "E5F17D9BD0C08951D8F5BF443342119A", hash_generated_field = "1F52FBC8B80AEE54006476E3EE9F6CFA")

static final int TRANSACTION_clearForcedDisplaySize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.723 -0500", hash_original_field = "3817B00DF033EFC0D99940028D01E3CE", hash_generated_field = "878EB9FEA795100ED45D2F8158AAD436")

static final int TRANSACTION_canStatusBarHide = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.726 -0500", hash_original_field = "FE2960BB62EC67B828783A0397ECD0F2", hash_generated_field = "B465298010A6F8FEA0029D00EF373F65")

static final int TRANSACTION_injectKeyEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.728 -0500", hash_original_field = "7E65871ED0BE2FDC6594756BD04D53B1", hash_generated_field = "7E4156FF76710E6386BB5665E1459EE8")

static final int TRANSACTION_injectPointerEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.731 -0500", hash_original_field = "0E716962AED38E6C06A5CC57FFDA3025", hash_generated_field = "B4CCBF6CC0530E65815AA51F292A3CDB")

static final int TRANSACTION_injectTrackballEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.734 -0500", hash_original_field = "BBCFB884DBE4391EDA51459DDD13AA9E", hash_generated_field = "8BEF4A358ACDB557853D60D3BEDDE13D")

static final int TRANSACTION_injectInputEventNoWait = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.737 -0500", hash_original_field = "C6CB607292E9A5E408FB8F24D8181C46", hash_generated_field = "ABFD6968B142F68C693DF7C1A9153F2E")

static final int TRANSACTION_pauseKeyDispatching = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.740 -0500", hash_original_field = "18007C5A4C620D809EC0FDE2416D6311", hash_generated_field = "93AB34E3AD976BB02A64A3372ACB5375")

static final int TRANSACTION_resumeKeyDispatching = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.742 -0500", hash_original_field = "A3EF22ACC8B0CB7B5C3476E973D89E99", hash_generated_field = "267C26DA1B63B3B222E1BB95A43D9D1C")

static final int TRANSACTION_setEventDispatching = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.745 -0500", hash_original_field = "D7063057DB5A95FF5521C1544E56BA6A", hash_generated_field = "45539B95E08C28AFFBD440BCFB9F36BF")

static final int TRANSACTION_addWindowToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.747 -0500", hash_original_field = "3DFF81E4969FCB845543AD442C635901", hash_generated_field = "D73161FFCA7A55C905DFE42C7E087A46")

static final int TRANSACTION_removeWindowToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.750 -0500", hash_original_field = "2EC4823E582E58F4E5B8BCB9986AEF7A", hash_generated_field = "688CB5C3A75098BD72175E2C4273CDC5")

static final int TRANSACTION_addAppToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.752 -0500", hash_original_field = "00D4314FD53F824E009CB2E5BE99F3BB", hash_generated_field = "28BED5ACDE26640A349E84147243E654")

static final int TRANSACTION_setAppGroupId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.756 -0500", hash_original_field = "B414C36F6BA14560377079AD7E95B0AD", hash_generated_field = "8A2A3E885BDF322F5CCDB8FA511F9FAC")

static final int TRANSACTION_setAppOrientation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.758 -0500", hash_original_field = "3F9EAF79744EF2E701BC72EEE19AD0C4", hash_generated_field = "14A146D9E5BFDE2D332A9375255F6052")

static final int TRANSACTION_getAppOrientation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.761 -0500", hash_original_field = "9D7AB606E947ED81DF3BD66E9C391DBD", hash_generated_field = "2B5A61F650157D65D72D894ADFECBBA5")

static final int TRANSACTION_setFocusedApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.764 -0500", hash_original_field = "A5939468B48BA649773847438E8588C6", hash_generated_field = "2ED182AEF997625AF719ECCAC642BA6B")

static final int TRANSACTION_prepareAppTransition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.766 -0500", hash_original_field = "9C1C2D79060FF500DD708C3A7DC22236", hash_generated_field = "C393654889701DC69DE93BC52852F572")

static final int TRANSACTION_getPendingAppTransition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.769 -0500", hash_original_field = "904E79C75E214FFC22BBD77CB31D1ABD", hash_generated_field = "43EF76AB14C4A65BD1F4F0E7E8657923")

static final int TRANSACTION_overridePendingAppTransition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.771 -0500", hash_original_field = "24D68F2385C10EC76F9603F09E8483CC", hash_generated_field = "1A4035AAF87AF471AC5147E42DDD68B7")

static final int TRANSACTION_executeAppTransition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.774 -0500", hash_original_field = "65188012C5EF6718AA4F275EE16FD322", hash_generated_field = "CB3511B3608D2E9DCB08087DF870FCD5")

static final int TRANSACTION_setAppStartingWindow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.777 -0500", hash_original_field = "BE0BBF88B0DCB3D11B598437A873E02B", hash_generated_field = "4F9C9064C3A3B6EE34469508EA222D66")

static final int TRANSACTION_setAppWillBeHidden = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.779 -0500", hash_original_field = "C98B3B05412B22C8DBA9B1EBFC743436", hash_generated_field = "B6F09119BDEBC3A59C4808120B0B2295")

static final int TRANSACTION_setAppVisibility = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.782 -0500", hash_original_field = "1A599B27B6C3AE1EFF0B7E4171CB5D5C", hash_generated_field = "54EDA94EA20FD26178AEA32682A6DD28")

static final int TRANSACTION_startAppFreezingScreen = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.784 -0500", hash_original_field = "440D3D431E3F8053A96855C290029580", hash_generated_field = "B80A85502BD006FB1484743F503337FA")

static final int TRANSACTION_stopAppFreezingScreen = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.787 -0500", hash_original_field = "2915B1FA83A35EE0999666D66C13FAA6", hash_generated_field = "0E292EE889333F6C76A615BD133037DC")

static final int TRANSACTION_removeAppToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.789 -0500", hash_original_field = "E01BF2B07FA9794E082CB133D80A7BFA", hash_generated_field = "8CA261074DD78887F190F13C4CEAD332")

static final int TRANSACTION_moveAppToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.792 -0500", hash_original_field = "9AE5281FD91DD30B2C1FFAE9DE81B350", hash_generated_field = "994BE54C9C6C2F5ADE05EA4509E8B0C1")

static final int TRANSACTION_moveAppTokensToTop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.795 -0500", hash_original_field = "2C4ECD64AA35AF5CDDC7AC2D11719CE4", hash_generated_field = "5D6C4216053A20B65E1A8FABC10A5509")

static final int TRANSACTION_moveAppTokensToBottom = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.797 -0500", hash_original_field = "FA5311AF5EE018573333046F0BD65492", hash_generated_field = "86BF7AAAE2244965194FAECC2B7C6587")

static final int TRANSACTION_updateOrientationFromAppTokens = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.800 -0500", hash_original_field = "CD616C5C4BBA13047011D87DE516E292", hash_generated_field = "13E483F0CF3C5BB1DDA47227C6F29920")

static final int TRANSACTION_setNewConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.803 -0500", hash_original_field = "4EEB8B3AE99685EC0C1CB78D4AD31CC6", hash_generated_field = "F3043ED6F6D77834539826C8E91468AC")

static final int TRANSACTION_disableKeyguard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.805 -0500", hash_original_field = "44927B3FB79458E3CCD7A74B54FB7108", hash_generated_field = "25ABC7C83BDB72045709A9B9D23B5358")

static final int TRANSACTION_reenableKeyguard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.809 -0500", hash_original_field = "73F548B153BF56528C58E74EC07485C5", hash_generated_field = "FEFDC2FFB157B5172F750702F53EBF29")

static final int TRANSACTION_exitKeyguardSecurely = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.811 -0500", hash_original_field = "8A86632154CE9E02FB92B84AC8035797", hash_generated_field = "4A277B6BEBB6492646427E946C03A670")

static final int TRANSACTION_isKeyguardLocked = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.814 -0500", hash_original_field = "7DCAE793B4E691190D2C12A961925A6B", hash_generated_field = "5DDDDEC78A555A0FBE6521C96546F967")

static final int TRANSACTION_isKeyguardSecure = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.817 -0500", hash_original_field = "C5468E8363647233419CF6F750E46484", hash_generated_field = "406DFE09C833FE272E1CF5875858DF40")

static final int TRANSACTION_inKeyguardRestrictedInputMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.819 -0500", hash_original_field = "D59B35463604C50545026D18A97F8F90", hash_generated_field = "2F0DDCBF9C2807A444715E8E90216022")

static final int TRANSACTION_dismissKeyguard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.822 -0500", hash_original_field = "7B2B07306DD686AB17EF6C2B64698CA1", hash_generated_field = "1430CBDB0B7703E96A0320C4FA6428F3")

static final int TRANSACTION_closeSystemDialogs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.825 -0500", hash_original_field = "A2F31D439942664A19185D3745A65F23", hash_generated_field = "0346A2A070CEBA27F218E50AE95E4FAA")

static final int TRANSACTION_getAnimationScale = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.827 -0500", hash_original_field = "5D0B5FA7121E698414BD8581007E625A", hash_generated_field = "EE64B35DA028E20119610859549AC03D")

static final int TRANSACTION_getAnimationScales = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.829 -0500", hash_original_field = "96275167A62C6AE3D38401B84F2F9214", hash_generated_field = "2E89C8048B2B0ECB51D28ECF8838D01A")

static final int TRANSACTION_setAnimationScale = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.832 -0500", hash_original_field = "7604ECD0DEE256CE61ED395741ED80DB", hash_generated_field = "BA9F99C01BAE7E17EFE5519C2A69016B")

static final int TRANSACTION_setAnimationScales = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.834 -0500", hash_original_field = "6D6740034977D1FD95091F74BD2B6EC0", hash_generated_field = "CE24776A0E88C2ECD31F4189D586CE45")

static final int TRANSACTION_getSwitchState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.837 -0500", hash_original_field = "61B6487FEAF366FA8F1AC07C4212DDC7", hash_generated_field = "26EA0524FAAC636F0DA1AD0B6DCCE8D0")

static final int TRANSACTION_getSwitchStateForDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.840 -0500", hash_original_field = "9BD61D6317C08DF133F0A621B81EFF67", hash_generated_field = "5073DDB6B541FFD7E7524AA9D61A54A7")

static final int TRANSACTION_getScancodeState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.843 -0500", hash_original_field = "1E25AB6AB4D37E8F341324F3C7B620EB", hash_generated_field = "2CC3711D5A0990289F50DB4C015F7BFA")

static final int TRANSACTION_getScancodeStateForDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.845 -0500", hash_original_field = "E95C90CE181C11258C17B5D24DB385FA", hash_generated_field = "44F29A24B3D14FC20EE9DCE4D451F353")

static final int TRANSACTION_getTrackballScancodeState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.848 -0500", hash_original_field = "9A0AF0429CC3489FE7B1121130C3C742", hash_generated_field = "FB171AD875FC878AB0F8F94BA61B7FBE")

static final int TRANSACTION_getDPadScancodeState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.850 -0500", hash_original_field = "DD1159BFB8F4465EE35AD59327BEA8D6", hash_generated_field = "0FEC809909D625EAF271D4DC33744ECC")

static final int TRANSACTION_getKeycodeState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.853 -0500", hash_original_field = "2E4DE72411641C8A2AB7DFC8B1E6A323", hash_generated_field = "294A6FEDFCFBFC2C461BC9E365F8FD57")

static final int TRANSACTION_getKeycodeStateForDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.857 -0500", hash_original_field = "6FF42B68F14B6091E1B34898B078B35D", hash_generated_field = "D1A48F7DBAA5D959F4D1AE60D10069F3")

static final int TRANSACTION_getTrackballKeycodeState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.859 -0500", hash_original_field = "FA314F75239F41E99FDFE240B7B66F55", hash_generated_field = "1627091E9DAB71F6EB7DF46B0A0794FE")

static final int TRANSACTION_getDPadKeycodeState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.862 -0500", hash_original_field = "BE0D052AA4FCFD904114CA7F5DD8D635", hash_generated_field = "6E8A311C5AC636BC85B4A5F2ACB0DC3D")

static final int TRANSACTION_monitorInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.864 -0500", hash_original_field = "B1F03A1AB1711497870BB37C04FDE202", hash_generated_field = "C07BA0E4ACF7FA87F6A830398B16ACE0")

static final int TRANSACTION_hasKeys = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.867 -0500", hash_original_field = "AE824D95E1BD72C101E78943003FCB6E", hash_generated_field = "41CC1F1657434EA1D6B9997399A01734")

static final int TRANSACTION_getInputDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.869 -0500", hash_original_field = "60E5BE4426A683F10599A17324D40FB4", hash_generated_field = "3E795D6CC2F44E1F577D1E21E11B5215")

static final int TRANSACTION_getInputDeviceIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.872 -0500", hash_original_field = "87C694A37AAF8919E12859866A2F6276", hash_generated_field = "30FA4D7FB40C1087960CD18D22194FFF")

static final int TRANSACTION_setInTouchMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.875 -0500", hash_original_field = "C5B8EC60AF9E36BA0E44EA2922DB11F9", hash_generated_field = "5CF9CA606C43D31A84351D35A4CEE485")

static final int TRANSACTION_showStrictModeViolation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.877 -0500", hash_original_field = "9BD290AEC442F8D96B033D1C15B88FB5", hash_generated_field = "667EE4DC3A9152192B315FF8E19718E0")

static final int TRANSACTION_setStrictModeVisualIndicatorPreference = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.879 -0500", hash_original_field = "93702EF1D291BD93228E2800FE85110A", hash_generated_field = "20D5418ABFA931308E91F9F591BF8B30")

static final int TRANSACTION_updateRotation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.882 -0500", hash_original_field = "738E3F0FF79F18F7C37217CD49563704", hash_generated_field = "DF4EDBC3A7A4F113E242AE11A0345081")

static final int TRANSACTION_getRotation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.885 -0500", hash_original_field = "2737ADA5EB144082B8A773A53255D2EF", hash_generated_field = "08728FCEB63AE88CE0AD7E6D780C97B7")

static final int TRANSACTION_watchRotation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.888 -0500", hash_original_field = "8512E7993186EA8D0CF87C2F4B2A84B9", hash_generated_field = "28353D833C39C9DF5C83BCF0B2FE070E")

static final int TRANSACTION_getPreferredOptionsPanelGravity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.891 -0500", hash_original_field = "4F7663297A56B05B408400E05E4CEFA6", hash_generated_field = "271226EAE77C561F6B38773BF5050F12")

static final int TRANSACTION_freezeRotation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.893 -0500", hash_original_field = "F0634A25BEF360672CA6E3723E5F098F", hash_generated_field = "F8ECEE2B96E504AB793AD02B554867F9")

static final int TRANSACTION_thawRotation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.896 -0500", hash_original_field = "D60FA7A64F1980BE9FAE53886101A916", hash_generated_field = "443763D2CA3CD3045AC2BE782CAC4C1E")

static final int TRANSACTION_screenshotApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 75);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.899 -0500", hash_original_field = "5D61483B1310958FD59E084E1A57B055", hash_generated_field = "A1CB18B952CEE9287FA1540251F0EEF4")

static final int TRANSACTION_statusBarVisibilityChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 76);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.901 -0500", hash_original_field = "F3F42EF1B92E1757C91ACBDCF0CE4E1E", hash_generated_field = "D6716EF34D8292351768309ABED8AFC5")

static final int TRANSACTION_setPointerSpeed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 77);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.904 -0500", hash_original_field = "E1DADB724C463C3B84007B33493DF92C", hash_generated_field = "1F9E589A0843C2FA4A5F453D9DC17C5F")

static final int TRANSACTION_waitForWindowDrawn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 78);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.906 -0500", hash_original_field = "245C798D4D748E5A2FC3829F49E15089", hash_generated_field = "840CAD475474616D4978B9ED3F695DE6")

static final int TRANSACTION_hasNavigationBar = (android.os.IBinder.FIRST_CALL_TRANSACTION + 79);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.393 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.400 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:05.417 -0500", hash_original_method = "FCFED59FDEFBD7637834E7329FC7F078", hash_generated_method = "C97BBC4209330A0E483E13562288A89F")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_startViewServer:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.startViewServer(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_stopViewServer:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.stopViewServer();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isViewServerRunning:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isViewServerRunning();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_openSession:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
com.android.internal.view.IInputContext _arg1;
_arg1 = com.android.internal.view.IInputContext.Stub.asInterface(data.readStrongBinder());
android.view.IWindowSession _result = this.openSession(_arg0, _arg1);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_inputMethodClientHasFocus:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
boolean _result = this.inputMethodClientHasFocus(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getDisplaySize:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Point _arg0;
_arg0 = new android.graphics.Point();
this.getDisplaySize(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getRealDisplaySize:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Point _arg0;
_arg0 = new android.graphics.Point();
this.getRealDisplaySize(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getMaximumSizeDimension:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getMaximumSizeDimension();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setForcedDisplaySize:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.setForcedDisplaySize(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_clearForcedDisplaySize:
{
data.enforceInterface(DESCRIPTOR);
this.clearForcedDisplaySize();
reply.writeNoException();
return true;
}
case TRANSACTION_canStatusBarHide:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.canStatusBarHide();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_injectKeyEvent:
{
data.enforceInterface(DESCRIPTOR);
android.view.KeyEvent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.KeyEvent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.injectKeyEvent(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_injectPointerEvent:
{
data.enforceInterface(DESCRIPTOR);
android.view.MotionEvent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.MotionEvent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.injectPointerEvent(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_injectTrackballEvent:
{
data.enforceInterface(DESCRIPTOR);
android.view.MotionEvent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.MotionEvent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.injectTrackballEvent(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_injectInputEventNoWait:
{
data.enforceInterface(DESCRIPTOR);
android.view.InputEvent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.InputEvent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.injectInputEventNoWait(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_pauseKeyDispatching:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.pauseKeyDispatching(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_resumeKeyDispatching:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.resumeKeyDispatching(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setEventDispatching:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setEventDispatching(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_addWindowToken:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
this.addWindowToken(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeWindowToken:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.removeWindowToken(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_addAppToken:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.view.IApplicationToken _arg1;
_arg1 = android.view.IApplicationToken.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
boolean _arg4;
_arg4 = (0!=data.readInt());
this.addAppToken(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_setAppGroupId:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
this.setAppGroupId(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setAppOrientation:
{
data.enforceInterface(DESCRIPTOR);
android.view.IApplicationToken _arg0;
_arg0 = android.view.IApplicationToken.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
this.setAppOrientation(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getAppOrientation:
{
data.enforceInterface(DESCRIPTOR);
android.view.IApplicationToken _arg0;
_arg0 = android.view.IApplicationToken.Stub.asInterface(data.readStrongBinder());
int _result = this.getAppOrientation(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setFocusedApp:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setFocusedApp(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_prepareAppTransition:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.prepareAppTransition(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPendingAppTransition:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPendingAppTransition();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_overridePendingAppTransition:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.overridePendingAppTransition(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_executeAppTransition:
{
data.enforceInterface(DESCRIPTOR);
this.executeAppTransition();
reply.writeNoException();
return true;
}
case TRANSACTION_setAppStartingWindow:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
android.content.res.CompatibilityInfo _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.res.CompatibilityInfo.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
java.lang.CharSequence _arg4;
if ((0!=data.readInt())) {
_arg4 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
int _arg5;
_arg5 = data.readInt();
int _arg6;
_arg6 = data.readInt();
int _arg7;
_arg7 = data.readInt();
android.os.IBinder _arg8;
_arg8 = data.readStrongBinder();
boolean _arg9;
_arg9 = (0!=data.readInt());
this.setAppStartingWindow(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9);
reply.writeNoException();
return true;
}
case TRANSACTION_setAppWillBeHidden:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.setAppWillBeHidden(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setAppVisibility:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setAppVisibility(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_startAppFreezingScreen:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
this.startAppFreezingScreen(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_stopAppFreezingScreen:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.stopAppFreezingScreen(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_removeAppToken:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.removeAppToken(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_moveAppToken:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
this.moveAppToken(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_moveAppTokensToTop:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.IBinder> _arg0;
_arg0 = data.createBinderArrayList();
this.moveAppTokensToTop(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_moveAppTokensToBottom:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.IBinder> _arg0;
_arg0 = data.createBinderArrayList();
this.moveAppTokensToBottom(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_updateOrientationFromAppTokens:
{
data.enforceInterface(DESCRIPTOR);
android.content.res.Configuration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.res.Configuration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
android.content.res.Configuration _result = this.updateOrientationFromAppTokens(_arg0, _arg1);
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
case TRANSACTION_setNewConfiguration:
{
data.enforceInterface(DESCRIPTOR);
android.content.res.Configuration _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.res.Configuration.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setNewConfiguration(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_disableKeyguard:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
java.lang.String _arg1;
_arg1 = data.readString();
this.disableKeyguard(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_reenableKeyguard:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.reenableKeyguard(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_exitKeyguardSecurely:
{
data.enforceInterface(DESCRIPTOR);
android.view.IOnKeyguardExitResult _arg0;
_arg0 = android.view.IOnKeyguardExitResult.Stub.asInterface(data.readStrongBinder());
this.exitKeyguardSecurely(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isKeyguardLocked:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isKeyguardLocked();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isKeyguardSecure:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isKeyguardSecure();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_inKeyguardRestrictedInputMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.inKeyguardRestrictedInputMode();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_dismissKeyguard:
{
data.enforceInterface(DESCRIPTOR);
this.dismissKeyguard();
reply.writeNoException();
return true;
}
case TRANSACTION_closeSystemDialogs:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.closeSystemDialogs(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getAnimationScale:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
float _result = this.getAnimationScale(_arg0);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_getAnimationScales:
{
data.enforceInterface(DESCRIPTOR);
float[] _result = this.getAnimationScales();
reply.writeNoException();
reply.writeFloatArray(_result);
return true;
}
case TRANSACTION_setAnimationScale:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
float _arg1;
_arg1 = data.readFloat();
this.setAnimationScale(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setAnimationScales:
{
data.enforceInterface(DESCRIPTOR);
float[] _arg0;
_arg0 = data.createFloatArray();
this.setAnimationScales(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getSwitchState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getSwitchState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getSwitchStateForDevice:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.getSwitchStateForDevice(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getScancodeState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getScancodeState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getScancodeStateForDevice:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.getScancodeStateForDevice(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getTrackballScancodeState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getTrackballScancodeState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getDPadScancodeState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getDPadScancodeState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getKeycodeState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getKeycodeState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getKeycodeStateForDevice:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.getKeycodeStateForDevice(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getTrackballKeycodeState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getTrackballKeycodeState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getDPadKeycodeState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getDPadKeycodeState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_monitorInput:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.view.InputChannel _result = this.monitorInput(_arg0);
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
case TRANSACTION_hasKeys:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
boolean[] _arg1;
_arg1 = data.createBooleanArray();
boolean _result = this.hasKeys(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
reply.writeBooleanArray(_arg1);
return true;
}
case TRANSACTION_getInputDevice:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.view.InputDevice _result = this.getInputDevice(_arg0);
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
case TRANSACTION_getInputDeviceIds:
{
data.enforceInterface(DESCRIPTOR);
int[] _result = this.getInputDeviceIds();
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
case TRANSACTION_setInTouchMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setInTouchMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_showStrictModeViolation:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.showStrictModeViolation(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setStrictModeVisualIndicatorPreference:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setStrictModeVisualIndicatorPreference(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_updateRotation:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.updateRotation(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getRotation:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getRotation();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_watchRotation:
{
data.enforceInterface(DESCRIPTOR);
android.view.IRotationWatcher _arg0;
_arg0 = android.view.IRotationWatcher.Stub.asInterface(data.readStrongBinder());
int _result = this.watchRotation(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getPreferredOptionsPanelGravity:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPreferredOptionsPanelGravity();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_freezeRotation:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.freezeRotation(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_thawRotation:
{
data.enforceInterface(DESCRIPTOR);
this.thawRotation();
reply.writeNoException();
return true;
}
case TRANSACTION_screenshotApplications:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.graphics.Bitmap _result = this.screenshotApplications(_arg0, _arg1, _arg2);
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
case TRANSACTION_statusBarVisibilityChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.statusBarVisibilityChanged(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setPointerSpeed:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setPointerSpeed(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_waitForWindowDrawn:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
android.os.IRemoteCallback _arg1;
_arg1 = android.os.IRemoteCallback.Stub.asInterface(data.readStrongBinder());
this.waitForWindowDrawn(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_hasNavigationBar:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasNavigationBar();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public boolean startViewServer(int port) throws android.os.RemoteException;

public boolean stopViewServer() throws android.os.RemoteException;

public boolean isViewServerRunning() throws android.os.RemoteException;

public android.view.IWindowSession openSession(com.android.internal.view.IInputMethodClient client, com.android.internal.view.IInputContext inputContext) throws android.os.RemoteException;
public boolean inputMethodClientHasFocus(com.android.internal.view.IInputMethodClient client) throws android.os.RemoteException;
public void getDisplaySize(android.graphics.Point size) throws android.os.RemoteException;
public void getRealDisplaySize(android.graphics.Point size) throws android.os.RemoteException;
public int getMaximumSizeDimension() throws android.os.RemoteException;
public void setForcedDisplaySize(int longDimen, int shortDimen) throws android.os.RemoteException;
public void clearForcedDisplaySize() throws android.os.RemoteException;

public boolean canStatusBarHide() throws android.os.RemoteException;

public boolean injectKeyEvent(android.view.KeyEvent ev, boolean sync) throws android.os.RemoteException;
public boolean injectPointerEvent(android.view.MotionEvent ev, boolean sync) throws android.os.RemoteException;
public boolean injectTrackballEvent(android.view.MotionEvent ev, boolean sync) throws android.os.RemoteException;
public boolean injectInputEventNoWait(android.view.InputEvent ev) throws android.os.RemoteException;

public void pauseKeyDispatching(android.os.IBinder token) throws android.os.RemoteException;
public void resumeKeyDispatching(android.os.IBinder token) throws android.os.RemoteException;
public void setEventDispatching(boolean enabled) throws android.os.RemoteException;
public void addWindowToken(android.os.IBinder token, int type) throws android.os.RemoteException;
public void removeWindowToken(android.os.IBinder token) throws android.os.RemoteException;
public void addAppToken(int addPos, android.view.IApplicationToken token, int groupId, int requestedOrientation, boolean fullscreen) throws android.os.RemoteException;
public void setAppGroupId(android.os.IBinder token, int groupId) throws android.os.RemoteException;
public void setAppOrientation(android.view.IApplicationToken token, int requestedOrientation) throws android.os.RemoteException;
public int getAppOrientation(android.view.IApplicationToken token) throws android.os.RemoteException;
public void setFocusedApp(android.os.IBinder token, boolean moveFocusNow) throws android.os.RemoteException;
public void prepareAppTransition(int transit, boolean alwaysKeepCurrent) throws android.os.RemoteException;
public int getPendingAppTransition() throws android.os.RemoteException;
public void overridePendingAppTransition(java.lang.String packageName, int enterAnim, int exitAnim) throws android.os.RemoteException;
public void executeAppTransition() throws android.os.RemoteException;
public void setAppStartingWindow(android.os.IBinder token, java.lang.String pkg, int theme, android.content.res.CompatibilityInfo compatInfo, java.lang.CharSequence nonLocalizedLabel, int labelRes, int icon, int windowFlags, android.os.IBinder transferFrom, boolean createIfNeeded) throws android.os.RemoteException;
public void setAppWillBeHidden(android.os.IBinder token) throws android.os.RemoteException;
public void setAppVisibility(android.os.IBinder token, boolean visible) throws android.os.RemoteException;
public void startAppFreezingScreen(android.os.IBinder token, int configChanges) throws android.os.RemoteException;
public void stopAppFreezingScreen(android.os.IBinder token, boolean force) throws android.os.RemoteException;
public void removeAppToken(android.os.IBinder token) throws android.os.RemoteException;
public void moveAppToken(int index, android.os.IBinder token) throws android.os.RemoteException;
public void moveAppTokensToTop(java.util.List<android.os.IBinder> tokens) throws android.os.RemoteException;
public void moveAppTokensToBottom(java.util.List<android.os.IBinder> tokens) throws android.os.RemoteException;

public android.content.res.Configuration updateOrientationFromAppTokens(android.content.res.Configuration currentConfig, android.os.IBinder freezeThisOneIfNeeded) throws android.os.RemoteException;
public void setNewConfiguration(android.content.res.Configuration config) throws android.os.RemoteException;

public void disableKeyguard(android.os.IBinder token, java.lang.String tag) throws android.os.RemoteException;
public void reenableKeyguard(android.os.IBinder token) throws android.os.RemoteException;
public void exitKeyguardSecurely(android.view.IOnKeyguardExitResult callback) throws android.os.RemoteException;
public boolean isKeyguardLocked() throws android.os.RemoteException;
public boolean isKeyguardSecure() throws android.os.RemoteException;
public boolean inKeyguardRestrictedInputMode() throws android.os.RemoteException;
public void dismissKeyguard() throws android.os.RemoteException;
public void closeSystemDialogs(java.lang.String reason) throws android.os.RemoteException;

public float getAnimationScale(int which) throws android.os.RemoteException;
public float[] getAnimationScales() throws android.os.RemoteException;
public void setAnimationScale(int which, float scale) throws android.os.RemoteException;
public void setAnimationScales(float[] scales) throws android.os.RemoteException;

public int getSwitchState(int sw) throws android.os.RemoteException;
public int getSwitchStateForDevice(int devid, int sw) throws android.os.RemoteException;
public int getScancodeState(int sw) throws android.os.RemoteException;
public int getScancodeStateForDevice(int devid, int sw) throws android.os.RemoteException;
public int getTrackballScancodeState(int sw) throws android.os.RemoteException;
public int getDPadScancodeState(int sw) throws android.os.RemoteException;
public int getKeycodeState(int sw) throws android.os.RemoteException;
public int getKeycodeStateForDevice(int devid, int sw) throws android.os.RemoteException;
public int getTrackballKeycodeState(int sw) throws android.os.RemoteException;
public int getDPadKeycodeState(int sw) throws android.os.RemoteException;
public android.view.InputChannel monitorInput(java.lang.String inputChannelName) throws android.os.RemoteException;

public boolean hasKeys(int[] keycodes, boolean[] keyExists) throws android.os.RemoteException;

public android.view.InputDevice getInputDevice(int deviceId) throws android.os.RemoteException;
public int[] getInputDeviceIds() throws android.os.RemoteException;

public void setInTouchMode(boolean showFocus) throws android.os.RemoteException;

public void showStrictModeViolation(boolean on) throws android.os.RemoteException;

public void setStrictModeVisualIndicatorPreference(java.lang.String enabled) throws android.os.RemoteException;

public void updateRotation(boolean alwaysSendConfiguration) throws android.os.RemoteException;

public int getRotation() throws android.os.RemoteException;

public int watchRotation(android.view.IRotationWatcher watcher) throws android.os.RemoteException;

public int getPreferredOptionsPanelGravity() throws android.os.RemoteException;

public void freezeRotation(int rotation) throws android.os.RemoteException;

public void thawRotation() throws android.os.RemoteException;

public android.graphics.Bitmap screenshotApplications(android.os.IBinder appToken, int maxWidth, int maxHeight) throws android.os.RemoteException;

public void statusBarVisibilityChanged(int visibility) throws android.os.RemoteException;

public void setPointerSpeed(int speed) throws android.os.RemoteException;

public void waitForWindowDrawn(android.os.IBinder token, android.os.IRemoteCallback callback) throws android.os.RemoteException;

public boolean hasNavigationBar() throws android.os.RemoteException;
}
