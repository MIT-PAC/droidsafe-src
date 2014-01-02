package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IInputContext extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.view.IInputContext
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.039 -0500", hash_original_field = "E4BB484B9C5B97C0369D0FB7851F6884", hash_generated_field = "5DAC44CCD804744B8856D84A989ACC8F")

private static final java.lang.String DESCRIPTOR = "com.android.internal.view.IInputContext";
/**
 * Cast an IBinder object into an com.android.internal.view.IInputContext interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.044 -0500", hash_original_method = "CAA28C19F8D7172B84D07F5F1A074FCB", hash_generated_method = "144567B377B89D38C9587739EF0E97E0")
        
public static com.android.internal.view.IInputContext asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.view.IInputContext))) {
return ((com.android.internal.view.IInputContext)iin);
}
return new com.android.internal.view.IInputContext.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.136 -0500", hash_original_field = "52AD0C5E35F0170FF5AF3FEA917B0A2E", hash_generated_field = "A2820457623FDC0E7C02226FA1E6F21C")

static final int TRANSACTION_getTextBeforeCursor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.140 -0500", hash_original_field = "EBBE52520903CD61CF221B1DE6FC902F", hash_generated_field = "842B43DC4AC86B9669153AF52EE1D555")

static final int TRANSACTION_getTextAfterCursor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.143 -0500", hash_original_field = "D03B065F169875F006909719D880164B", hash_generated_field = "4510BBCABAD03F9D4C12461FFF700DFA")

static final int TRANSACTION_getCursorCapsMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements com.android.internal.view.IInputContext
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.057 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.059 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.062 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.064 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.068 -0500", hash_original_method = "AF684EDFD06C4BCFDA9346AC82A30F2D", hash_generated_method = "7C2283C1509608936069534BEDB78DA6")
            
public void getTextBeforeCursor(int length, int flags, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(length);
_data.writeInt(flags);
_data.writeInt(seq);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getTextBeforeCursor, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.071 -0500", hash_original_method = "8D95AD0B900E0357AF83C755508D78FA", hash_generated_method = "D78575C894400362A2A7B52AB99D8CE1")
            
public void getTextAfterCursor(int length, int flags, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(length);
_data.writeInt(flags);
_data.writeInt(seq);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getTextAfterCursor, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.074 -0500", hash_original_method = "1A1F6333FE3205E9ADD31CEE4EF9BC3F", hash_generated_method = "F26AC404B3BED781026BEB0E11BD0D48")
            
public void getCursorCapsMode(int reqModes, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(reqModes);
_data.writeInt(seq);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getCursorCapsMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.077 -0500", hash_original_method = "C728B95BFE5A600594C80A529AC9124F", hash_generated_method = "EAAA856ACF53E633EC1171923D7B3E0D")
            
public void getExtractedText(android.view.inputmethod.ExtractedTextRequest request, int flags, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((request!=null)) {
_data.writeInt(1);
request.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
_data.writeInt(seq);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getExtractedText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.080 -0500", hash_original_method = "F3C1513D470BD64AF3E95316FA560025", hash_generated_method = "DBEFB52F353B71B699513D9060A1C03F")
            
public void deleteSurroundingText(int leftLength, int rightLength) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(leftLength);
_data.writeInt(rightLength);
mRemote.transact(Stub.TRANSACTION_deleteSurroundingText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.083 -0500", hash_original_method = "C71FE921F8475DBF02753A492BAAF531", hash_generated_method = "C7F79E86A283FDA4258CBA61692E4819")
            
public void setComposingText(java.lang.CharSequence text, int newCursorPosition) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((text!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(text, _data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(newCursorPosition);
mRemote.transact(Stub.TRANSACTION_setComposingText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.086 -0500", hash_original_method = "2D69D523D33BF2485834517AADAF1F20", hash_generated_method = "3AA616AFBC1F7F5BDD0A16BA5A399209")
            
public void finishComposingText() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_finishComposingText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.089 -0500", hash_original_method = "492ED62D74543F4BD3E67AFFA182C0EB", hash_generated_method = "1566B07B7AFF466FDF0B337F0736866E")
            
public void commitText(java.lang.CharSequence text, int newCursorPosition) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((text!=null)) {
_data.writeInt(1);
android.text.TextUtils.writeToParcel(text, _data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(newCursorPosition);
mRemote.transact(Stub.TRANSACTION_commitText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.092 -0500", hash_original_method = "8765EE4879212F44C31CB7EBF6821309", hash_generated_method = "B1632865262060A05D7D13865A5DBE1B")
            
public void commitCompletion(android.view.inputmethod.CompletionInfo completion) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((completion!=null)) {
_data.writeInt(1);
completion.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_commitCompletion, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.095 -0500", hash_original_method = "247CB20075D5F4EA5FF6D55AF5D2EDB0", hash_generated_method = "9FA80DAE93E0CD1F89AADA9CF483BBC7")
            
public void commitCorrection(android.view.inputmethod.CorrectionInfo correction) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((correction!=null)) {
_data.writeInt(1);
correction.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_commitCorrection, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.098 -0500", hash_original_method = "F4D1ABBCCE46566FA56481F8126AD311", hash_generated_method = "5D2A41B535A6916DBF650F653D6B9548")
            
public void setSelection(int start, int end) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(start);
_data.writeInt(end);
mRemote.transact(Stub.TRANSACTION_setSelection, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.101 -0500", hash_original_method = "CC9BEAB39220E7B0D8E45222A75AF2D9", hash_generated_method = "C53A9CFDBCA4231D8E65FFCA9CC0DAC2")
            
public void performEditorAction(int actionCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(actionCode);
mRemote.transact(Stub.TRANSACTION_performEditorAction, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.104 -0500", hash_original_method = "32C88ACA42231B0C8F844443E2BCF208", hash_generated_method = "766CEF005EC5C93B7507664D53EE1DEA")
            
public void performContextMenuAction(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_performContextMenuAction, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.106 -0500", hash_original_method = "6E12DC533A308084463126DB657D1670", hash_generated_method = "78BA50B355CFC31BC58C2592A462A2F7")
            
public void beginBatchEdit() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_beginBatchEdit, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.109 -0500", hash_original_method = "26FE1CE66B2752A463E8E2B8415220FC", hash_generated_method = "0BD9FD28C2FE06CE6E4B2633774BF526")
            
public void endBatchEdit() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_endBatchEdit, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.112 -0500", hash_original_method = "D46524CE476D49775C3EC438FB8DEF36", hash_generated_method = "26CC91BC6C2AD2FFED440CB7D78AB524")
            
public void reportFullscreenMode(boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reportFullscreenMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.115 -0500", hash_original_method = "DB519959B45EE07A5C49AD6EEB65C0F7", hash_generated_method = "DBECB7C2455A27BBB6F578C878C3AA04")
            
public void sendKeyEvent(android.view.KeyEvent event) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((event!=null)) {
_data.writeInt(1);
event.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendKeyEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.118 -0500", hash_original_method = "04B9460889BC0F2737310C16A3C6FAD0", hash_generated_method = "CFE58B813668576E08E963E7C373AD98")
            
public void clearMetaKeyStates(int states) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(states);
mRemote.transact(Stub.TRANSACTION_clearMetaKeyStates, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.122 -0500", hash_original_method = "F8970BB10AC019036014399FEC850F77", hash_generated_method = "F5F8B934540961680F2073165B84B8B6")
            
public void performPrivateCommand(java.lang.String action, android.os.Bundle data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(action);
if ((data!=null)) {
_data.writeInt(1);
data.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_performPrivateCommand, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.125 -0500", hash_original_method = "7B1A53FAA0081B22D755F678C94C4421", hash_generated_method = "1984B18F5C7C49537EE1FC155B552396")
            
public void setComposingRegion(int start, int end) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(start);
_data.writeInt(end);
mRemote.transact(Stub.TRANSACTION_setComposingRegion, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.127 -0500", hash_original_method = "3E0D688C91EA86113862FE26F5B1B9E7", hash_generated_method = "7E1F3B9993BEF14325B7E2693978D3DA")
            
public void getSelectedText(int flags, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
_data.writeInt(seq);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getSelectedText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.146 -0500", hash_original_field = "A5680338C753D776490A7C904A52CDB7", hash_generated_field = "7974920FBF21DE6C4606E01B8B3B3DE5")

static final int TRANSACTION_getExtractedText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.149 -0500", hash_original_field = "C50659E9213BC84D8D60368CEC7029C0", hash_generated_field = "2E431C02376DC9A67303D85A1BE5699A")

static final int TRANSACTION_deleteSurroundingText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.151 -0500", hash_original_field = "43DAE64191D7BDDACDCC7A791AD07A91", hash_generated_field = "6B0D602FAFA6CDE07093AB5CE0DAAA6B")

static final int TRANSACTION_setComposingText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.154 -0500", hash_original_field = "095269C4E9418A37D442F868A2E8615C", hash_generated_field = "D0E8DB503C9800E3BFE09A47076E2C13")

static final int TRANSACTION_finishComposingText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.157 -0500", hash_original_field = "C702D535357C276D9A584FA970C3AA4F", hash_generated_field = "0BF840187FD304EAC6AA00B273E41BE4")

static final int TRANSACTION_commitText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.160 -0500", hash_original_field = "66DE6837BC7DDCF6AA7B4E2F24F98280", hash_generated_field = "754132DCEDE3AD69231B057A43354141")

static final int TRANSACTION_commitCompletion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.162 -0500", hash_original_field = "E73FCBE586D20BAD9971079DCF523D0F", hash_generated_field = "AB8DC29C0151D7695F52B1465AC1130D")

static final int TRANSACTION_commitCorrection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.165 -0500", hash_original_field = "80391EBFD1982EAF144BB414ECF7AFD2", hash_generated_field = "CF2AED8650EB7144A45EF901341AD9E8")

static final int TRANSACTION_setSelection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.168 -0500", hash_original_field = "A59C1E3FA76BD57D80058F88A6956A89", hash_generated_field = "6AD6DE1D338ED75D550D2714B7F8DB35")

static final int TRANSACTION_performEditorAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.171 -0500", hash_original_field = "913D0302291234682D9DD5582B1776BB", hash_generated_field = "7685CF157D93698C72A410090B159780")

static final int TRANSACTION_performContextMenuAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.174 -0500", hash_original_field = "589AA26D02011DC3AB9B231A7E243F2F", hash_generated_field = "0F64D6C8AD39254E46702E940CF732D8")

static final int TRANSACTION_beginBatchEdit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.177 -0500", hash_original_field = "F094EE22998E5D365AA1B9144793B8DC", hash_generated_field = "0BC78FB8B7C18A3B12ED8D79C00102A6")

static final int TRANSACTION_endBatchEdit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.179 -0500", hash_original_field = "2DEF35DD2A10DB4FDA197F47035BF64A", hash_generated_field = "A5FF581A9DFC261B413DE3B8922980FE")

static final int TRANSACTION_reportFullscreenMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.182 -0500", hash_original_field = "B044BA9159D39A796BE0A4DA978221E7", hash_generated_field = "92D92F5A287FDC202976661E54BB1AC5")

static final int TRANSACTION_sendKeyEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.185 -0500", hash_original_field = "6486D2CDECDCC091BE0630673D80CB6A", hash_generated_field = "1AD06C176998295D83FC3CB0B028B34C")

static final int TRANSACTION_clearMetaKeyStates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.188 -0500", hash_original_field = "BE15155C5883F3F80CD401D06C75ACFC", hash_generated_field = "773E792C07A7B589813CE65796225BFC")

static final int TRANSACTION_performPrivateCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.190 -0500", hash_original_field = "32C7D0F4AD0ABCA764B9F5F74B46ADC5", hash_generated_field = "6D7B33A2F303326A0A599948368ADF86")

static final int TRANSACTION_setComposingRegion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.193 -0500", hash_original_field = "2C615EA649065FA43ECBDC0C1D6DC336", hash_generated_field = "4A1303F7B40E2DD6F0EE0E5AFB5AD80D")

static final int TRANSACTION_getSelectedText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.041 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.047 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.053 -0500", hash_original_method = "C94E4D0630FA1684165185E7DC25BEA0", hash_generated_method = "C052F51DA111D64645457CD013095DEE")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getTextBeforeCursor:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
com.android.internal.view.IInputContextCallback _arg3;
_arg3 = com.android.internal.view.IInputContextCallback.Stub.asInterface(data.readStrongBinder());
this.getTextBeforeCursor(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_getTextAfterCursor:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
com.android.internal.view.IInputContextCallback _arg3;
_arg3 = com.android.internal.view.IInputContextCallback.Stub.asInterface(data.readStrongBinder());
this.getTextAfterCursor(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_getCursorCapsMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
com.android.internal.view.IInputContextCallback _arg2;
_arg2 = com.android.internal.view.IInputContextCallback.Stub.asInterface(data.readStrongBinder());
this.getCursorCapsMode(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getExtractedText:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.ExtractedTextRequest _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.inputmethod.ExtractedTextRequest.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
com.android.internal.view.IInputContextCallback _arg3;
_arg3 = com.android.internal.view.IInputContextCallback.Stub.asInterface(data.readStrongBinder());
this.getExtractedText(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_deleteSurroundingText:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.deleteSurroundingText(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setComposingText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.CharSequence _arg0;
if ((0!=data.readInt())) {
_arg0 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setComposingText(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_finishComposingText:
{
data.enforceInterface(DESCRIPTOR);
this.finishComposingText();
reply.writeNoException();
return true;
}
case TRANSACTION_commitText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.CharSequence _arg0;
if ((0!=data.readInt())) {
_arg0 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.commitText(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_commitCompletion:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.CompletionInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.inputmethod.CompletionInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.commitCompletion(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_commitCorrection:
{
data.enforceInterface(DESCRIPTOR);
android.view.inputmethod.CorrectionInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.inputmethod.CorrectionInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.commitCorrection(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setSelection:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.setSelection(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_performEditorAction:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.performEditorAction(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_performContextMenuAction:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.performContextMenuAction(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_beginBatchEdit:
{
data.enforceInterface(DESCRIPTOR);
this.beginBatchEdit();
reply.writeNoException();
return true;
}
case TRANSACTION_endBatchEdit:
{
data.enforceInterface(DESCRIPTOR);
this.endBatchEdit();
reply.writeNoException();
return true;
}
case TRANSACTION_reportFullscreenMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.reportFullscreenMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendKeyEvent:
{
data.enforceInterface(DESCRIPTOR);
android.view.KeyEvent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.view.KeyEvent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.sendKeyEvent(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_clearMetaKeyStates:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.clearMetaKeyStates(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_performPrivateCommand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.Bundle _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.performPrivateCommand(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setComposingRegion:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.setComposingRegion(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getSelectedText:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
com.android.internal.view.IInputContextCallback _arg2;
_arg2 = com.android.internal.view.IInputContextCallback.Stub.asInterface(data.readStrongBinder());
this.getSelectedText(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void getTextBeforeCursor(int length, int flags, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException;
public void getTextAfterCursor(int length, int flags, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException;
public void getCursorCapsMode(int reqModes, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException;
public void getExtractedText(android.view.inputmethod.ExtractedTextRequest request, int flags, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException;
public void deleteSurroundingText(int leftLength, int rightLength) throws android.os.RemoteException;
public void setComposingText(java.lang.CharSequence text, int newCursorPosition) throws android.os.RemoteException;
public void finishComposingText() throws android.os.RemoteException;
public void commitText(java.lang.CharSequence text, int newCursorPosition) throws android.os.RemoteException;
public void commitCompletion(android.view.inputmethod.CompletionInfo completion) throws android.os.RemoteException;
public void commitCorrection(android.view.inputmethod.CorrectionInfo correction) throws android.os.RemoteException;
public void setSelection(int start, int end) throws android.os.RemoteException;
public void performEditorAction(int actionCode) throws android.os.RemoteException;
public void performContextMenuAction(int id) throws android.os.RemoteException;
public void beginBatchEdit() throws android.os.RemoteException;
public void endBatchEdit() throws android.os.RemoteException;
public void reportFullscreenMode(boolean enabled) throws android.os.RemoteException;
public void sendKeyEvent(android.view.KeyEvent event) throws android.os.RemoteException;
public void clearMetaKeyStates(int states) throws android.os.RemoteException;
public void performPrivateCommand(java.lang.String action, android.os.Bundle data) throws android.os.RemoteException;
public void setComposingRegion(int start, int end) throws android.os.RemoteException;
public void getSelectedText(int flags, int seq, com.android.internal.view.IInputContextCallback callback) throws android.os.RemoteException;
}
