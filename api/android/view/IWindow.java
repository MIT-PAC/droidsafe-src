package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IWindow extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.IWindow
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.952 -0500", hash_original_field = "0AAA31184C36BC4966CE6DC82AF3658B", hash_generated_field = "755650C6C99F1AB4D14B9EAAEFDE9BB2")

private static final java.lang.String DESCRIPTOR = "android.view.IWindow";
/**
 * Cast an IBinder object into an android.view.IWindow interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.957 -0500", hash_original_method = "C27E0EBC0F8FE11BF725DD4DF2EED1AD", hash_generated_method = "736F011477D210BD4724B5D9849FA203")
        
public static android.view.IWindow asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.IWindow))) {
return ((android.view.IWindow)iin);
}
return new android.view.IWindow.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.010 -0500", hash_original_field = "1A3E79F8E7FC0364FEC342A348C9742A", hash_generated_field = "26072D2C8004426DF2AC02EE50EA8322")

static final int TRANSACTION_executeCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.012 -0500", hash_original_field = "DACE981EF92AA5CC6C19E839962AD519", hash_generated_field = "36B5F05C8761D3E2491FCD4538F302A4")

static final int TRANSACTION_resized = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.015 -0500", hash_original_field = "2F91A90F3EB12177F1122D564B773DF1", hash_generated_field = "ED97BA86451AEC6505A6A1E4410FD2E3")

static final int TRANSACTION_dispatchAppVisibility = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.view.IWindow
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.968 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.971 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.973 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.975 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * ===== NOTICE =====
     * The first method must remain the first method. Scripts
     * and tools rely on their transaction number to work properly.
     *//**
     * Invoked by the view server to tell a window to execute the specified
     * command. Any response from the receiver must be sent through the
     * specified file descriptor.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.978 -0500", hash_original_method = "E57BFF56F043C94276BA34FADEBFD994", hash_generated_method = "996D6C3A80AF2A68707D3F0E18073DCB")
            
public void executeCommand(java.lang.String command, java.lang.String parameters, android.os.ParcelFileDescriptor descriptor) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(command);
_data.writeString(parameters);
if ((descriptor!=null)) {
_data.writeInt(1);
descriptor.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_executeCommand, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.981 -0500", hash_original_method = "792F80B3795471B1BF10AB5C364E398B", hash_generated_method = "7BE4A27942140F65DEC254AC265189A4")
            
public void resized(int w, int h, android.graphics.Rect coveredInsets, android.graphics.Rect visibleInsets, boolean reportDraw, android.content.res.Configuration newConfig) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(w);
_data.writeInt(h);
if ((coveredInsets!=null)) {
_data.writeInt(1);
coveredInsets.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((visibleInsets!=null)) {
_data.writeInt(1);
visibleInsets.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((reportDraw)?(1):(0)));
if ((newConfig!=null)) {
_data.writeInt(1);
newConfig.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_resized, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.984 -0500", hash_original_method = "B82B388CF88B088EAE11646FD909B807", hash_generated_method = "CC5D89C51ABC5DF6D43525290D01E0BA")
            
public void dispatchAppVisibility(boolean visible) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((visible)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_dispatchAppVisibility, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.986 -0500", hash_original_method = "7E4F13F12CF006B04E347834299E8AEE", hash_generated_method = "430FC274AE5B37DC94056AC5F3D2CC89")
            
public void dispatchGetNewSurface() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_dispatchGetNewSurface, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Tell the window that it is either gaining or losing focus.  Keep it up
     * to date on the current state showing navigational focus (touch mode) too.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.989 -0500", hash_original_method = "0939BB3456A9AA0DF90F1E7AD4E73FA8", hash_generated_method = "34A6BAF43A160C22EC035523CFD247F0")
            
public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((hasFocus)?(1):(0)));
_data.writeInt(((inTouchMode)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_windowFocusChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.991 -0500", hash_original_method = "9A4A81A1599BFA8CB3FEFA1825B0BE90", hash_generated_method = "0E8C9F942AD6DA472ACCA6779E0F22A1")
            
public void closeSystemDialogs(java.lang.String reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(reason);
mRemote.transact(Stub.TRANSACTION_closeSystemDialogs, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Called for wallpaper windows when their offsets change.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.994 -0500", hash_original_method = "430A5D0BAD2A6B0195ACDFD5A84BD8D5", hash_generated_method = "0E42ADD02C32455D8CB456CA337B1B1B")
            
public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep, boolean sync) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeFloat(x);
_data.writeFloat(y);
_data.writeFloat(xStep);
_data.writeFloat(yStep);
_data.writeInt(((sync)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_dispatchWallpaperOffsets, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.998 -0500", hash_original_method = "97B5FF9971C1886E6FA32012B72AA491", hash_generated_method = "93F02765844CA4773F9254720CC2D84A")
            
public void dispatchWallpaperCommand(java.lang.String action, int x, int y, int z, android.os.Bundle extras, boolean sync) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(action);
_data.writeInt(x);
_data.writeInt(y);
_data.writeInt(z);
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((sync)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_dispatchWallpaperCommand, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Drag/drop events
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.001 -0500", hash_original_method = "CD74DD3D29B56C7A54D09014AF06B3B9", hash_generated_method = "23F5F42116FB8242A9477F5C9593A757")
            
public void dispatchDragEvent(android.view.DragEvent event) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((event!=null)) {
_data.writeInt(1);
event.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_dispatchDragEvent, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * System chrome visibility changes
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.004 -0500", hash_original_method = "DBF8D361CA4F63AA616D4F1E15B51426", hash_generated_method = "4B67386B05ADFA23F653F23655712DD8")
            
public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility, int localValue, int localChanges) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(seq);
_data.writeInt(globalVisibility);
_data.writeInt(localValue);
_data.writeInt(localChanges);
mRemote.transact(Stub.TRANSACTION_dispatchSystemUiVisibilityChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.017 -0500", hash_original_field = "C2280D5A1A2B9F8ADF4CEFA3AC38D864", hash_generated_field = "982D0307BDF400DF6798F51685666B51")

static final int TRANSACTION_dispatchGetNewSurface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.020 -0500", hash_original_field = "656326322A28B747A82D19C019C1CC6C", hash_generated_field = "B6E46E378E848A703C23D2C407F96731")

static final int TRANSACTION_windowFocusChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.022 -0500", hash_original_field = "4CDA49739345018EBBEABCF334E93EC1", hash_generated_field = "71A946625455229CF822F423CB1E1A9F")

static final int TRANSACTION_closeSystemDialogs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.025 -0500", hash_original_field = "3E4CBEBEF39BB71800C0C469A0E2774D", hash_generated_field = "5553B8E37BE85B7624C5A4F0E14FC398")

static final int TRANSACTION_dispatchWallpaperOffsets = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.028 -0500", hash_original_field = "6B8398CBBC5FD60557EBBA7EAD2975C9", hash_generated_field = "4970A8C610E1AFCA9FA85FB505E4AEA7")

static final int TRANSACTION_dispatchWallpaperCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.031 -0500", hash_original_field = "FEE050168BC23F33C9E3D6AE76AA0E56", hash_generated_field = "509073A96430452066EF2C446438AA14")

static final int TRANSACTION_dispatchDragEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.033 -0500", hash_original_field = "A3D59FAB0A4D244A3DC8CE1349E7C2C2", hash_generated_field = "70DA3520080F2B2536B4A6920F98AF20")

static final int TRANSACTION_dispatchSystemUiVisibilityChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.954 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.960 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.964 -0500", hash_original_method = "3FEF827E49E6C9E563A6F0CC853C3078", hash_generated_method = "48CC69DBF57B277160B28CC1F82BCC8A")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_executeCommand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
android.os.ParcelFileDescriptor _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.executeCommand(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_resized:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.graphics.Rect _arg2;
if ((0!=data.readInt())) {
_arg2 = android.graphics.Rect.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
android.graphics.Rect _arg3;
if ((0!=data.readInt())) {
_arg3 = android.graphics.Rect.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
boolean _arg4;
_arg4 = (0!=data.readInt());
android.content.res.Configuration _arg5;
if ((0!=data.readInt())) {
_arg5 = android.content.res.Configuration.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
this.resized(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
return true;
}
case TRANSACTION_dispatchAppVisibility:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.dispatchAppVisibility(_arg0);
return true;
}
case TRANSACTION_dispatchGetNewSurface:
{
data.enforceInterface(DESCRIPTOR);
this.dispatchGetNewSurface();
return true;
}
case TRANSACTION_windowFocusChanged:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _arg1;
_arg1 = (0!=data.readInt());
this.windowFocusChanged(_arg0, _arg1);
return true;
}
case TRANSACTION_closeSystemDialogs:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.closeSystemDialogs(_arg0);
return true;
}
case TRANSACTION_dispatchWallpaperOffsets:
{
data.enforceInterface(DESCRIPTOR);
float _arg0;
_arg0 = data.readFloat();
float _arg1;
_arg1 = data.readFloat();
float _arg2;
_arg2 = data.readFloat();
float _arg3;
_arg3 = data.readFloat();
boolean _arg4;
_arg4 = (0!=data.readInt());
this.dispatchWallpaperOffsets(_arg0, _arg1, _arg2, _arg3, _arg4);
return true;
}
case TRANSACTION_dispatchWallpaperCommand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.os.Bundle _arg4;
if ((0!=data.readInt())) {
_arg4 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
boolean _arg5;
_arg5 = (0!=data.readInt());
this.dispatchWallpaperCommand(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
return true;
}
case TRANSACTION_dispatchDragEvent:
{
data.enforceInterface(DESCRIPTOR);
android.view.DragEvent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.DragEvent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.dispatchDragEvent(_arg0);
return true;
}
case TRANSACTION_dispatchSystemUiVisibilityChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.dispatchSystemUiVisibilityChanged(_arg0, _arg1, _arg2, _arg3);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void executeCommand(java.lang.String command, java.lang.String parameters, android.os.ParcelFileDescriptor descriptor) throws android.os.RemoteException;
public void resized(int w, int h, android.graphics.Rect coveredInsets, android.graphics.Rect visibleInsets, boolean reportDraw, android.content.res.Configuration newConfig) throws android.os.RemoteException;
public void dispatchAppVisibility(boolean visible) throws android.os.RemoteException;
public void dispatchGetNewSurface() throws android.os.RemoteException;

public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) throws android.os.RemoteException;
public void closeSystemDialogs(java.lang.String reason) throws android.os.RemoteException;

public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep, boolean sync) throws android.os.RemoteException;
public void dispatchWallpaperCommand(java.lang.String action, int x, int y, int z, android.os.Bundle extras, boolean sync) throws android.os.RemoteException;

public void dispatchDragEvent(android.view.DragEvent event) throws android.os.RemoteException;

public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility, int localValue, int localChanges) throws android.os.RemoteException;
}
