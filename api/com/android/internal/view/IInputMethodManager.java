package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IInputMethodManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.view.IInputMethodManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.547 -0500", hash_original_field = "E59C0E443F97E04D4FF8F0144D4F32CB", hash_generated_field = "A0799F3938A68B5ADDDCC64E25DB6035")

private static final java.lang.String DESCRIPTOR = "com.android.internal.view.IInputMethodManager";
/**
 * Cast an IBinder object into an com.android.internal.view.IInputMethodManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.553 -0500", hash_original_method = "90229D034E3090C6BC808BF3AE449367", hash_generated_method = "6D7A23844EC2606EFA8388D8A2F648B5")
        
public static com.android.internal.view.IInputMethodManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.view.IInputMethodManager))) {
return ((com.android.internal.view.IInputMethodManager)iin);
}
return new com.android.internal.view.IInputMethodManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.669 -0500", hash_original_field = "E70891DD3D6DFC89E549EB87889599E6", hash_generated_field = "41F8D8EBDECCF69135D0A67D115A5290")

static final int TRANSACTION_getInputMethodList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.672 -0500", hash_original_field = "0C3F58B3D7C38F0FE4FCCC54E2355747", hash_generated_field = "C8A7BD934B18CC1FD8AA1D0DA5B6B90E")

static final int TRANSACTION_getEnabledInputMethodList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.675 -0500", hash_original_field = "EB27589652952852CF93F3E73910B9D2", hash_generated_field = "B3A607D527C823D22A8367E848E34B07")

static final int TRANSACTION_getEnabledInputMethodSubtypeList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.view.IInputMethodManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.568 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.572 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.574 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.577 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.580 -0500", hash_original_method = "F3AE5752FAF4A71DE004B73E192D08FE", hash_generated_method = "4D6B1AC4594D0C13D4F705A68FD0B05B")
            
public java.util.List<android.view.inputmethod.InputMethodInfo> getInputMethodList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.view.inputmethod.InputMethodInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInputMethodList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.view.inputmethod.InputMethodInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.583 -0500", hash_original_method = "AD935C11980ABEA0B45C271C21218E1E", hash_generated_method = "262376AD39AD94E7D2521B4DEDDA096B")
            
public java.util.List<android.view.inputmethod.InputMethodInfo> getEnabledInputMethodList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.view.inputmethod.InputMethodInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getEnabledInputMethodList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.view.inputmethod.InputMethodInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.586 -0500", hash_original_method = "DACB82370C847806E1A7215B96C3C28C", hash_generated_method = "9097DF70DB42103053E5B91DC5DF6F90")
            
public java.util.List<android.view.inputmethod.InputMethodSubtype> getEnabledInputMethodSubtypeList(android.view.inputmethod.InputMethodInfo imi, boolean allowsImplicitlySelectedSubtypes) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.view.inputmethod.InputMethodSubtype> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((imi!=null)) {
_data.writeInt(1);
imi.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((allowsImplicitlySelectedSubtypes)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_getEnabledInputMethodSubtypeList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.view.inputmethod.InputMethodSubtype.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.589 -0500", hash_original_method = "82803D957B57359918301E917587D379", hash_generated_method = "21C5D2CA5FD597C09260E4F8C9AC2D1F")
            
public android.view.inputmethod.InputMethodSubtype getLastInputMethodSubtype() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.view.inputmethod.InputMethodSubtype _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLastInputMethodSubtype, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.view.inputmethod.InputMethodSubtype.CREATOR.createFromParcel(_reply);
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
// TODO: We should change the return type from List to List<Parcelable>
// Currently there is a bug that aidl doesn't accept List<Parcelable>

@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.592 -0500", hash_original_method = "2A966E0CD5BB2DD412B462C3DAA0105D", hash_generated_method = "C08050653CAE9F53F844811DF7E33485")
            
public java.util.List getShortcutInputMethodsAndSubtypes() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getShortcutInputMethodsAndSubtypes, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readArrayList(cl);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.595 -0500", hash_original_method = "D92B58BED5D95FA17B4B081F3A3603A9", hash_generated_method = "4F289AC7F41A5265C3D2EDFCA702A6C7")
            
public void addClient(com.android.internal.view.IInputMethodClient client, com.android.internal.view.IInputContext inputContext, int uid, int pid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
_data.writeStrongBinder((((inputContext!=null))?(inputContext.asBinder()):(null)));
_data.writeInt(uid);
_data.writeInt(pid);
mRemote.transact(Stub.TRANSACTION_addClient, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.598 -0500", hash_original_method = "B1A8202751D6C4AD1B18B1BAA65C2415", hash_generated_method = "4495FEB6004F194793FCEEE0198CABFD")
            
public void removeClient(com.android.internal.view.IInputMethodClient client) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeClient, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.602 -0500", hash_original_method = "624D13D597936BE095F1A98C93BF8969", hash_generated_method = "EE00317FBBE865C83D5CA307FA3712BE")
            
public com.android.internal.view.InputBindResult startInput(com.android.internal.view.IInputMethodClient client, com.android.internal.view.IInputContext inputContext, android.view.inputmethod.EditorInfo attribute, boolean initial, boolean needResult) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.android.internal.view.InputBindResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
_data.writeStrongBinder((((inputContext!=null))?(inputContext.asBinder()):(null)));
if ((attribute!=null)) {
_data.writeInt(1);
attribute.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((initial)?(1):(0)));
_data.writeInt(((needResult)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_startInput, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.android.internal.view.InputBindResult.CREATOR.createFromParcel(_reply);
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
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.604 -0500", hash_original_method = "E0EA6116FE4DE2A06A26292AA5E32FB5", hash_generated_method = "5F09657293036879DB37477E6C4C9485")
            
public void finishInput(com.android.internal.view.IInputMethodClient client) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_finishInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.607 -0500", hash_original_method = "E2E70ACFC8EBA048DCEC0FECC0612F42", hash_generated_method = "9205FB3BA2EB4F5E0A21258D7155E3CF")
            
public boolean showSoftInput(com.android.internal.view.IInputMethodClient client, int flags, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
_data.writeInt(flags);
if ((resultReceiver!=null)) {
_data.writeInt(1);
resultReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_showSoftInput, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.610 -0500", hash_original_method = "828F66604584E434D125297A0A837B26", hash_generated_method = "0043501DC97DCCA47092D1B9131AF17B")
            
public boolean hideSoftInput(com.android.internal.view.IInputMethodClient client, int flags, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
_data.writeInt(flags);
if ((resultReceiver!=null)) {
_data.writeInt(1);
resultReceiver.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_hideSoftInput, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.613 -0500", hash_original_method = "341698B439C9C766EBA9FB80C272A32D", hash_generated_method = "0CD33D11187DAAD437293F80135FF280")
            
public void windowGainedFocus(com.android.internal.view.IInputMethodClient client, android.os.IBinder windowToken, boolean viewHasFocus, boolean isTextEditor, int softInputMode, boolean first, int windowFlags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
_data.writeStrongBinder(windowToken);
_data.writeInt(((viewHasFocus)?(1):(0)));
_data.writeInt(((isTextEditor)?(1):(0)));
_data.writeInt(softInputMode);
_data.writeInt(((first)?(1):(0)));
_data.writeInt(windowFlags);
mRemote.transact(Stub.TRANSACTION_windowGainedFocus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.617 -0500", hash_original_method = "337168A246B481D0DA1BA402698660C8", hash_generated_method = "FCF34A74BE0FFBFCA2EA6D21CB59AFB0")
            
public void showInputMethodPickerFromClient(com.android.internal.view.IInputMethodClient client) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_showInputMethodPickerFromClient, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.620 -0500", hash_original_method = "3744B1D04E2E31EFA6DA30B540E83612", hash_generated_method = "BAB7BBA11407ACBC048764FE1820AC07")
            
public void showInputMethodAndSubtypeEnablerFromClient(com.android.internal.view.IInputMethodClient client, java.lang.String topId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
_data.writeString(topId);
mRemote.transact(Stub.TRANSACTION_showInputMethodAndSubtypeEnablerFromClient, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.623 -0500", hash_original_method = "D136E8E3BD0B64784540DD3A7475EB61", hash_generated_method = "7833A9B50B3DADBB4D8A9B6A7B2F743B")
            
public void setInputMethod(android.os.IBinder token, java.lang.String id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_setInputMethod, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.625 -0500", hash_original_method = "D37A150B198A530B01488EDDB6DDFE2D", hash_generated_method = "9CA38628F5A4459840A52F5900A19881")
            
public void setInputMethodAndSubtype(android.os.IBinder token, java.lang.String id, android.view.inputmethod.InputMethodSubtype subtype) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeString(id);
if ((subtype!=null)) {
_data.writeInt(1);
subtype.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setInputMethodAndSubtype, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.629 -0500", hash_original_method = "55D5130E25342A8A552B312F546888B7", hash_generated_method = "E25E63983DBA97CAB898E47256433645")
            
public void hideMySoftInput(android.os.IBinder token, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_hideMySoftInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.632 -0500", hash_original_method = "AF628C5710EFDFE7777D975CEE8C12BE", hash_generated_method = "E11F82040ACC55C89DBF9FFADD72A64B")
            
public void showMySoftInput(android.os.IBinder token, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_showMySoftInput, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.635 -0500", hash_original_method = "DA2B90F981351078DDCB31803E8771B3", hash_generated_method = "4B7B10C0EA408C9DE967EC3E15291895")
            
public void updateStatusIcon(android.os.IBinder token, java.lang.String packageName, int iconId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeString(packageName);
_data.writeInt(iconId);
mRemote.transact(Stub.TRANSACTION_updateStatusIcon, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.638 -0500", hash_original_method = "C12A3C0E7EFDBE88F4327FF2D54C08E5", hash_generated_method = "9D339B167A36F4F9FCE460E4AF01D7A4")
            
public void setImeWindowStatus(android.os.IBinder token, int vis, int backDisposition) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
_data.writeInt(vis);
_data.writeInt(backDisposition);
mRemote.transact(Stub.TRANSACTION_setImeWindowStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.640 -0500", hash_original_method = "C989760EAA77D6C3777A3098D05791DE", hash_generated_method = "8E1CF410BAA138A416506608C22384CB")
            
public void registerSuggestionSpansForNotification(android.text.style.SuggestionSpan[] spans) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(spans, 0);
mRemote.transact(Stub.TRANSACTION_registerSuggestionSpansForNotification, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.643 -0500", hash_original_method = "3429E83A83DC7385B6A9F86913305FE9", hash_generated_method = "CEB1AEA6887B8F7BEDDBAC5F13D8AF74")
            
public boolean notifySuggestionPicked(android.text.style.SuggestionSpan span, java.lang.String originalString, int index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((span!=null)) {
_data.writeInt(1);
span.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(originalString);
_data.writeInt(index);
mRemote.transact(Stub.TRANSACTION_notifySuggestionPicked, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.647 -0500", hash_original_method = "9952C81C0616FBBA2F50A6A3E52F7B68", hash_generated_method = "9E8C7AE6730E5685BD2393C6DD2D9C41")
            
public android.view.inputmethod.InputMethodSubtype getCurrentInputMethodSubtype() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.view.inputmethod.InputMethodSubtype _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentInputMethodSubtype, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.view.inputmethod.InputMethodSubtype.CREATOR.createFromParcel(_reply);
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
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.649 -0500", hash_original_method = "2D5E076B13867BF666C2D7214EB19A01", hash_generated_method = "5F2119090148CEAC2B685FBEFECAEBBD")
            
public boolean setCurrentInputMethodSubtype(android.view.inputmethod.InputMethodSubtype subtype) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((subtype!=null)) {
_data.writeInt(1);
subtype.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setCurrentInputMethodSubtype, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.652 -0500", hash_original_method = "7E17F8314CEB109A5D606DE93CD34720", hash_generated_method = "CA4CF42E54AB30E66AC59A17C1F8921F")
            
public boolean switchToLastInputMethod(android.os.IBinder token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(token);
mRemote.transact(Stub.TRANSACTION_switchToLastInputMethod, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.655 -0500", hash_original_method = "F96C31C8BC10F36717E865E21F00130C", hash_generated_method = "42D98DB6EA02D938A460B4C061A21993")
            
public boolean setInputMethodEnabled(java.lang.String id, boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setInputMethodEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.658 -0500", hash_original_method = "AC2D00161BF982437B13E7481A6534E5", hash_generated_method = "6389276BF0E13D8DAA3AC7DAEC1295E9")
            
public void setAdditionalInputMethodSubtypes(java.lang.String id, android.view.inputmethod.InputMethodSubtype[] subtypes) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
_data.writeTypedArray(subtypes, 0);
mRemote.transact(Stub.TRANSACTION_setAdditionalInputMethodSubtypes, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.677 -0500", hash_original_field = "230117315117D02530F634B70A909545", hash_generated_field = "3C78CB6C3E292D79616F341109C7F604")

static final int TRANSACTION_getLastInputMethodSubtype = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.680 -0500", hash_original_field = "F7D24C2F9A46E5E27916BCDBEFD9294A", hash_generated_field = "913C497ACFAB3E75ECCF8F54BE6D247B")

static final int TRANSACTION_getShortcutInputMethodsAndSubtypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.683 -0500", hash_original_field = "2CEDC84CA877C4230C60431C7EC328AD", hash_generated_field = "EE49FFE4D1D508B4390E41A320D9EE6E")

static final int TRANSACTION_addClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.686 -0500", hash_original_field = "5E79B735E915867678F1E3CE140C80F2", hash_generated_field = "A379F6C2160AD0AF23ADE7A8238A591E")

static final int TRANSACTION_removeClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.689 -0500", hash_original_field = "A107CD89B94E109B17EA9DC82166822A", hash_generated_field = "3AF113C9F2103D16D0960DF0F547A348")

static final int TRANSACTION_startInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.692 -0500", hash_original_field = "EA7537BCB24796408BF078DC89C7C016", hash_generated_field = "E5FF31230666B2C86D2F49994C8FD31D")

static final int TRANSACTION_finishInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.694 -0500", hash_original_field = "AC24BE1C6D18A7822531D8990888BB55", hash_generated_field = "2E743E6BD669DEF334694655E65EFECB")

static final int TRANSACTION_showSoftInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.696 -0500", hash_original_field = "34918F0BA3569013673C31886982FD06", hash_generated_field = "2584C665D5FAE7BD1BA6B0123F654614")

static final int TRANSACTION_hideSoftInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.699 -0500", hash_original_field = "ED81AAEB1B7846355A865DF135FC457E", hash_generated_field = "AD4C42A73824F1824912BB2243B33AF5")

static final int TRANSACTION_windowGainedFocus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.701 -0500", hash_original_field = "2C3222462C120FBB71C3FC8A0496BC7F", hash_generated_field = "1F8686F8090582E23D397F9D00701076")

static final int TRANSACTION_showInputMethodPickerFromClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.704 -0500", hash_original_field = "D1FAA97588110D5FE392D86683DCB484", hash_generated_field = "E4A5B191D10801DD12E8C8C1AE7A2FD0")

static final int TRANSACTION_showInputMethodAndSubtypeEnablerFromClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.707 -0500", hash_original_field = "B799824F651605E2DAA8DC70F21CEB4C", hash_generated_field = "DBE20A345F1D10C0E8D3F8E9FDE6E075")

static final int TRANSACTION_setInputMethod = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.709 -0500", hash_original_field = "A9595FD0B2310894527B38D7AFD0F1D4", hash_generated_field = "4F1086F892E27402B19CA1916828E3FD")

static final int TRANSACTION_setInputMethodAndSubtype = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.712 -0500", hash_original_field = "F0F33F0724B0E7863ABD5F12A4A0BD87", hash_generated_field = "41FF9F20AABF512AD581A92216A55CA8")

static final int TRANSACTION_hideMySoftInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.715 -0500", hash_original_field = "DAEB6E9127AA4D7E50217FF27258FA98", hash_generated_field = "BAC94F71009940AEAE2094CB3BB5CD95")

static final int TRANSACTION_showMySoftInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.717 -0500", hash_original_field = "BC75ADE393AA01EE5E3E3BCF71512CAF", hash_generated_field = "73F0A5395650053022EDD6277CFB0619")

static final int TRANSACTION_updateStatusIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.720 -0500", hash_original_field = "52C0D39CC0D4901D48147354B79537BE", hash_generated_field = "39EA51DAAEEC60EC632E2D45628C2AEC")

static final int TRANSACTION_setImeWindowStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.723 -0500", hash_original_field = "EDC0E0B858E6F7A0F6A85560E69B2CAF", hash_generated_field = "5AFF3E1E4D0C92B615E5710CB21CDCD3")

static final int TRANSACTION_registerSuggestionSpansForNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.726 -0500", hash_original_field = "70074BEEB674E4666FF445D2A82D15FD", hash_generated_field = "EE539C74F0CF1C20ADC9F8CC9E96AD71")

static final int TRANSACTION_notifySuggestionPicked = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.728 -0500", hash_original_field = "4E10C1A6731E99BCAD643127967F2143", hash_generated_field = "D46BDF005B127214F8798F6911E92990")

static final int TRANSACTION_getCurrentInputMethodSubtype = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.731 -0500", hash_original_field = "D2036049EDBCB313B18745F3E4C56F49", hash_generated_field = "30717294EE25DCF35A385A7408358B87")

static final int TRANSACTION_setCurrentInputMethodSubtype = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.734 -0500", hash_original_field = "604C8E74FD1FB053EDF7CA9657347459", hash_generated_field = "818F20C0316DCF125E033E22769ECB65")

static final int TRANSACTION_switchToLastInputMethod = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.736 -0500", hash_original_field = "5E22617B985F9E8B5DD7A737131FEE02", hash_generated_field = "837744D6987E18793D81FE0B21BFCD93")

static final int TRANSACTION_setInputMethodEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.739 -0500", hash_original_field = "7142F06DBE237BDFB5E38BCBBD9678AF", hash_generated_field = "FF7C335E2BBD72F4C3FD75A9640EEEAD")

static final int TRANSACTION_setAdditionalInputMethodSubtypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.550 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.556 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:29.565 -0500", hash_original_method = "31343B52EC2F425C40EA14A78D809088", hash_generated_method = "CDC837B65A51558FE31E55C83ECDDED9")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getInputMethodList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.view.inputmethod.InputMethodInfo> _result = this.getInputMethodList();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getEnabledInputMethodList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.view.inputmethod.InputMethodInfo> _result = this.getEnabledInputMethodList();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getEnabledInputMethodSubtypeList:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.InputMethodInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.inputmethod.InputMethodInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
java.util.List<android.view.inputmethod.InputMethodSubtype> _result = this.getEnabledInputMethodSubtypeList(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getLastInputMethodSubtype:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.InputMethodSubtype _result = this.getLastInputMethodSubtype();
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
case TRANSACTION_getShortcutInputMethodsAndSubtypes:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _result = this.getShortcutInputMethodsAndSubtypes();
reply.writeNoException();
reply.writeList(_result);
return true;
}
case TRANSACTION_addClient:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
com.android.internal.view.IInputContext _arg1;
_arg1 = com.android.internal.view.IInputContext.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.addClient(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_removeClient:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
this.removeClient(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_startInput:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
com.android.internal.view.IInputContext _arg1;
_arg1 = com.android.internal.view.IInputContext.Stub.asInterface(data.readStrongBinder());
android.view.inputmethod.EditorInfo _arg2;
if ((0!=data.readInt())) {
_arg2 = android.view.inputmethod.EditorInfo.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _arg4;
_arg4 = (0!=data.readInt());
com.android.internal.view.InputBindResult _result = this.startInput(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_finishInput:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
this.finishInput(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_showSoftInput:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
android.os.ResultReceiver _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.ResultReceiver.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
boolean _result = this.showSoftInput(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_hideSoftInput:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
android.os.ResultReceiver _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.ResultReceiver.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
boolean _result = this.hideSoftInput(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_windowGainedFocus:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
int _arg4;
_arg4 = data.readInt();
boolean _arg5;
_arg5 = (0!=data.readInt());
int _arg6;
_arg6 = data.readInt();
this.windowGainedFocus(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
reply.writeNoException();
return true;
}
case TRANSACTION_showInputMethodPickerFromClient:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
this.showInputMethodPickerFromClient(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_showInputMethodAndSubtypeEnablerFromClient:
{
data.enforceInterface(DESCRIPTOR);
com.android.internal.view.IInputMethodClient _arg0;
_arg0 = com.android.internal.view.IInputMethodClient.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
this.showInputMethodAndSubtypeEnablerFromClient(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setInputMethod:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
java.lang.String _arg1;
_arg1 = data.readString();
this.setInputMethod(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setInputMethodAndSubtype:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
java.lang.String _arg1;
_arg1 = data.readString();
android.view.inputmethod.InputMethodSubtype _arg2;
if ((0!=data.readInt())) {
_arg2 = android.view.inputmethod.InputMethodSubtype.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.setInputMethodAndSubtype(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_hideMySoftInput:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
this.hideMySoftInput(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_showMySoftInput:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
this.showMySoftInput(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_updateStatusIcon:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.updateStatusIcon(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setImeWindowStatus:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.setImeWindowStatus(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_registerSuggestionSpansForNotification:
{
data.enforceInterface(DESCRIPTOR);
android.text.style.SuggestionSpan[] _arg0;
_arg0 = data.createTypedArray(android.text.style.SuggestionSpan.CREATOR);
this.registerSuggestionSpansForNotification(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifySuggestionPicked:
{
data.enforceInterface(DESCRIPTOR);
android.text.style.SuggestionSpan _arg0;
if ((0!=data.readInt())) {
_arg0 = android.text.style.SuggestionSpan.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.notifySuggestionPicked(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getCurrentInputMethodSubtype:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.InputMethodSubtype _result = this.getCurrentInputMethodSubtype();
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
case TRANSACTION_setCurrentInputMethodSubtype:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.InputMethodSubtype _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.inputmethod.InputMethodSubtype.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.setCurrentInputMethodSubtype(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_switchToLastInputMethod:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
boolean _result = this.switchToLastInputMethod(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setInputMethodEnabled:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.setInputMethodEnabled(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setAdditionalInputMethodSubtypes:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.view.inputmethod.InputMethodSubtype[] _arg1;
_arg1 = data.createTypedArray(android.view.inputmethod.InputMethodSubtype.CREATOR);
this.setAdditionalInputMethodSubtypes(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public java.util.List<android.view.inputmethod.InputMethodInfo> getInputMethodList() throws android.os.RemoteException;
public java.util.List<android.view.inputmethod.InputMethodInfo> getEnabledInputMethodList() throws android.os.RemoteException;
public java.util.List<android.view.inputmethod.InputMethodSubtype> getEnabledInputMethodSubtypeList(android.view.inputmethod.InputMethodInfo imi, boolean allowsImplicitlySelectedSubtypes) throws android.os.RemoteException;
public android.view.inputmethod.InputMethodSubtype getLastInputMethodSubtype() throws android.os.RemoteException;

public java.util.List getShortcutInputMethodsAndSubtypes() throws android.os.RemoteException;
public void addClient(com.android.internal.view.IInputMethodClient client, com.android.internal.view.IInputContext inputContext, int uid, int pid) throws android.os.RemoteException;
public void removeClient(com.android.internal.view.IInputMethodClient client) throws android.os.RemoteException;
public com.android.internal.view.InputBindResult startInput(com.android.internal.view.IInputMethodClient client, com.android.internal.view.IInputContext inputContext, android.view.inputmethod.EditorInfo attribute, boolean initial, boolean needResult) throws android.os.RemoteException;
public void finishInput(com.android.internal.view.IInputMethodClient client) throws android.os.RemoteException;
public boolean showSoftInput(com.android.internal.view.IInputMethodClient client, int flags, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException;
public boolean hideSoftInput(com.android.internal.view.IInputMethodClient client, int flags, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException;
public void windowGainedFocus(com.android.internal.view.IInputMethodClient client, android.os.IBinder windowToken, boolean viewHasFocus, boolean isTextEditor, int softInputMode, boolean first, int windowFlags) throws android.os.RemoteException;
public void showInputMethodPickerFromClient(com.android.internal.view.IInputMethodClient client) throws android.os.RemoteException;
public void showInputMethodAndSubtypeEnablerFromClient(com.android.internal.view.IInputMethodClient client, java.lang.String topId) throws android.os.RemoteException;
public void setInputMethod(android.os.IBinder token, java.lang.String id) throws android.os.RemoteException;
public void setInputMethodAndSubtype(android.os.IBinder token, java.lang.String id, android.view.inputmethod.InputMethodSubtype subtype) throws android.os.RemoteException;
public void hideMySoftInput(android.os.IBinder token, int flags) throws android.os.RemoteException;
public void showMySoftInput(android.os.IBinder token, int flags) throws android.os.RemoteException;
public void updateStatusIcon(android.os.IBinder token, java.lang.String packageName, int iconId) throws android.os.RemoteException;
public void setImeWindowStatus(android.os.IBinder token, int vis, int backDisposition) throws android.os.RemoteException;
public void registerSuggestionSpansForNotification(android.text.style.SuggestionSpan[] spans) throws android.os.RemoteException;
public boolean notifySuggestionPicked(android.text.style.SuggestionSpan span, java.lang.String originalString, int index) throws android.os.RemoteException;
public android.view.inputmethod.InputMethodSubtype getCurrentInputMethodSubtype() throws android.os.RemoteException;
public boolean setCurrentInputMethodSubtype(android.view.inputmethod.InputMethodSubtype subtype) throws android.os.RemoteException;
public boolean switchToLastInputMethod(android.os.IBinder token) throws android.os.RemoteException;
public boolean setInputMethodEnabled(java.lang.String id, boolean enabled) throws android.os.RemoteException;
public void setAdditionalInputMethodSubtypes(java.lang.String id, android.view.inputmethod.InputMethodSubtype[] subtypes) throws android.os.RemoteException;
}
