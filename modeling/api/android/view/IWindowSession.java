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
 * Original file: android/view/IWindowSession.aidl
 */
package android.view;
/**
 * System private per-application interface to the window manager.
 *
 * {@hide}
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IWindowSession extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.view.IWindowSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.567 -0500", hash_original_field = "52831E9B3D8B3CF1147314882F401455", hash_generated_field = "12F3BAF3DA5CF1A3DF9155BE3D7F863D")

private static final java.lang.String DESCRIPTOR = "android.view.IWindowSession";
/**
 * Cast an IBinder object into an android.view.IWindowSession interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.573 -0500", hash_original_method = "361F168ACD6748436B8271771C7D66C9", hash_generated_method = "17C7F0C8B259FA1A897A58EFF4563A27")
        public static android.view.IWindowSession asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.IWindowSession))) {
return ((android.view.IWindowSession)iin);
}
return new android.view.IWindowSession.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.663 -0500", hash_original_field = "3294D678F63ECE7CB024FDA46450F47D", hash_generated_field = "B526FEEF1E7774FD85C365D7C392D7D2")

static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.665 -0500", hash_original_field = "9F2EEB00D07E54EEF1433954CFE33F9F", hash_generated_field = "94C926EB4C79AC9D1404A5DDB7097A41")

static final int TRANSACTION_addWithoutInputChannel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.667 -0500", hash_original_field = "DF6876EAD2769F5C3AF5B174E94862B3", hash_generated_field = "068F7E34BA09F8AA75F0107F1A029B78")

static final int TRANSACTION_remove = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.view.IWindowSession
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.592 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.594 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.596 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.598 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.601 -0500", hash_original_method = "048EA2E7EBC287CD87122A8F7DAE5650", hash_generated_method = "53E247BF94687866C2A3FC0C7ACCB53C")
            public int add(android.view.IWindow window, int seq, android.view.WindowManager.LayoutParams attrs, int viewVisibility, android.graphics.Rect outContentInsets, android.view.InputChannel outInputChannel) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
_data.writeInt(seq);
if ((attrs!=null)) {
_data.writeInt(1);
attrs.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(viewVisibility);
mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
if ((0!=_reply.readInt())) {
outContentInsets.readFromParcel(_reply);
}
if ((0!=_reply.readInt())) {
outInputChannel.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.604 -0500", hash_original_method = "DAF10E69747E740D18C9D27564D0AFEA", hash_generated_method = "197465C4C6FAA390D240569FD0D11127")
            public int addWithoutInputChannel(android.view.IWindow window, int seq, android.view.WindowManager.LayoutParams attrs, int viewVisibility, android.graphics.Rect outContentInsets) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
_data.writeInt(seq);
if ((attrs!=null)) {
_data.writeInt(1);
attrs.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(viewVisibility);
mRemote.transact(Stub.TRANSACTION_addWithoutInputChannel, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
if ((0!=_reply.readInt())) {
outContentInsets.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.606 -0500", hash_original_method = "DF4334FB0805E17173B9E97DD333571F", hash_generated_method = "62B2EC19D89A22ED07D78380D48B2DA5")
            public void remove(android.view.IWindow window) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_remove, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Change the parameters of a window.  You supply the
     * new parameters, it returns the new frame of the window on screen (the
     * position should be ignored) and surface of the window.  The surface
     * will be invalid if the window is currently hidden, else you can use it
     * to draw the window's contents.
     * 
     * @param window The window being modified.
     * @param seq Ordering sequence number.
     * @param attrs If non-null, new attributes to apply to the window.
     * @param requestedWidth The width the window wants to be.
     * @param requestedHeight The height the window wants to be.
     * @param viewVisibility Window root view's visibility.
     * @param flags Request flags: {@link WindowManagerImpl#RELAYOUT_INSETS_PENDING},
     * {@link WindowManagerImpl#RELAYOUT_DEFER_SURFACE_DESTROY}.
     * @param outFrame Rect in which is placed the new position/size on
     * screen.
     * @param outContentInsets Rect in which is placed the offsets from
     * <var>outFrame</var> in which the content of the window should be
     * placed.  This can be used to modify the window layout to ensure its
     * contents are visible to the user, taking into account system windows
     * like the status bar or a soft keyboard.
     * @param outVisibleInsets Rect in which is placed the offsets from
     * <var>outFrame</var> in which the window is actually completely visible
     * to the user.  This can be used to temporarily scroll the window's
     * contents to make sure the user can see it.  This is different than
     * <var>outContentInsets</var> in that these insets change transiently,
     * so complex relayout of the window should not happen based on them.
     * @param outConfiguration New configuration of window, if it is now
     * becoming visible and the global configuration has changed since it
     * was last displayed.
     * @param outSurface Object in which is placed the new display surface.
     * 
     * @return int Result flags: {@link WindowManagerImpl#RELAYOUT_SHOW_FOCUS},
     * {@link WindowManagerImpl#RELAYOUT_FIRST_TIME}.
     */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.609 -0500", hash_original_method = "1F5C5EF6E04EBFBE4D08889314ECF6C1", hash_generated_method = "AFAB77AA17DE20F3C20D2002F7C5EC55")
            public int relayout(android.view.IWindow window, int seq, android.view.WindowManager.LayoutParams attrs, int requestedWidth, int requestedHeight, int viewVisibility, int flags, android.graphics.Rect outFrame, android.graphics.Rect outContentInsets, android.graphics.Rect outVisibleInsets, android.content.res.Configuration outConfig, android.view.Surface outSurface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
_data.writeInt(seq);
if ((attrs!=null)) {
_data.writeInt(1);
attrs.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(requestedWidth);
_data.writeInt(requestedHeight);
_data.writeInt(viewVisibility);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_relayout, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
if ((0!=_reply.readInt())) {
outFrame.readFromParcel(_reply);
}
if ((0!=_reply.readInt())) {
outContentInsets.readFromParcel(_reply);
}
if ((0!=_reply.readInt())) {
outVisibleInsets.readFromParcel(_reply);
}
if ((0!=_reply.readInt())) {
outConfig.readFromParcel(_reply);
}
if ((0!=_reply.readInt())) {
outSurface.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * If a call to relayout() asked to have the surface destroy deferred,
     * it must call this once it is okay to destroy that surface.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.611 -0500", hash_original_method = "2E2192E62BD89B767FF76151126F1C38", hash_generated_method = "93CF0BB419DBC874421CDD6DE15C893D")
            public void performDeferredDestroy(android.view.IWindow window) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_performDeferredDestroy, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Called by a client to report that it ran out of graphics memory.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.614 -0500", hash_original_method = "82D3E99FEA809A8D91EBEBE8D330C89D", hash_generated_method = "632C97448FE84075AA65D4176EB3DEEA")
            public boolean outOfMemory(android.view.IWindow window) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_outOfMemory, _data, _reply, 0);
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
     * Give the window manager a hint of the part of the window that is
     * completely transparent, allowing it to work with the surface flinger
     * to optimize compositing of this part of the window.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.616 -0500", hash_original_method = "086349C1BEEF67C084C59FDFBE541A03", hash_generated_method = "42E320218CAB8BCFD5AB95C65A82C10E")
            public void setTransparentRegion(android.view.IWindow window, android.graphics.Region region) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
if ((region!=null)) {
_data.writeInt(1);
region.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setTransparentRegion, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Tell the window manager about the content and visible insets of the
     * given window, which can be used to adjust the <var>outContentInsets</var>
     * and <var>outVisibleInsets</var> values returned by
     * {@link #relayout relayout()} for windows behind this one.
     *
     * @param touchableInsets Controls which part of the window inside of its
     * frame can receive pointer events, as defined by
     * {@link android.view.ViewTreeObserver.InternalInsetsInfo}.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.618 -0500", hash_original_method = "9511390C4578990DF5C0BF49E8BF4D83", hash_generated_method = "1D705CF205F702D21E3BCA213A371C06")
            public void setInsets(android.view.IWindow window, int touchableInsets, android.graphics.Rect contentInsets, android.graphics.Rect visibleInsets, android.graphics.Region touchableRegion) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
_data.writeInt(touchableInsets);
if ((contentInsets!=null)) {
_data.writeInt(1);
contentInsets.writeToParcel(_data, 0);
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
if ((touchableRegion!=null)) {
_data.writeInt(1);
touchableRegion.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setInsets, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Return the current display size in which the window is being laid out,
     * accounting for screen decorations around it.
     */
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.621 -0500", hash_original_method = "A2BEDA751B80597BCBB55F1AAFFB8E4C", hash_generated_method = "87F510CE290B1A135B94E527FFAA2D10")
            public void getDisplayFrame(android.view.IWindow window, android.graphics.Rect outDisplayFrame) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getDisplayFrame, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
outDisplayFrame.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.623 -0500", hash_original_method = "B8345596A58C4AE6F67F30F8C81D5B24", hash_generated_method = "5D22AAE47C4A639D260888D226567C1C")
            public void finishDrawing(android.view.IWindow window) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_finishDrawing, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.625 -0500", hash_original_method = "52A17965AC134C7133CBA6BF88A9F477", hash_generated_method = "A90EBF07F4876B71E12EBCF80F18605D")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.627 -0500", hash_original_method = "34B9BBCCC420FCCD67BBEB20192AB0A7", hash_generated_method = "B37C175A21F4AF30814768AE083D2DDB")
            public boolean getInTouchMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInTouchMode, _data, _reply, 0);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.629 -0500", hash_original_method = "A1688EC279A07AD329B471CA7E5A932D", hash_generated_method = "C4A8E1E99F0136C63FA66C1C6CE8A665")
            public boolean performHapticFeedback(android.view.IWindow window, int effectId, boolean always) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
_data.writeInt(effectId);
_data.writeInt(((always)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_performHapticFeedback, _data, _reply, 0);
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
     * Allocate the drag's thumbnail surface.  Also assigns a token that identifies
     * the drag to the OS and passes that as the return value.  A return value of
     * null indicates failure.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.631 -0500", hash_original_method = "D13D04567E8F33D6E8A803ED334A2209", hash_generated_method = "94E4E8BE16E96B70C6F9FC510A43256B")
            public android.os.IBinder prepareDrag(android.view.IWindow window, int flags, int thumbnailWidth, int thumbnailHeight, android.view.Surface outSurface) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.IBinder _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
_data.writeInt(flags);
_data.writeInt(thumbnailWidth);
_data.writeInt(thumbnailHeight);
mRemote.transact(Stub.TRANSACTION_prepareDrag, _data, _reply, 0);
_reply.readException();
_result = _reply.readStrongBinder();
if ((0!=_reply.readInt())) {
outSurface.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Initiate the drag operation itself
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.634 -0500", hash_original_method = "5C097B9CDC8C89C4BCF116E6AE33E39C", hash_generated_method = "CCCFD0CA480B020A6C6C65AD815C8175")
            public boolean performDrag(android.view.IWindow window, android.os.IBinder dragToken, float touchX, float touchY, float thumbCenterX, float thumbCenterY, android.content.ClipData data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
_data.writeStrongBinder(dragToken);
_data.writeFloat(touchX);
_data.writeFloat(touchY);
_data.writeFloat(thumbCenterX);
_data.writeFloat(thumbCenterY);
if ((data!=null)) {
_data.writeInt(1);
data.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_performDrag, _data, _reply, 0);
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
	 * Report the result of a drop action targeted to the given window.
	 * consumed is 'true' when the drop was accepted by a valid recipient,
	 * 'false' otherwise.
	 */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.637 -0500", hash_original_method = "E6CE8BBF56B97C3D449855CB1C2F0D71", hash_generated_method = "3C1000DE151B4CE374D4D5D6A13C2CA4")
            public void reportDropResult(android.view.IWindow window, boolean consumed) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
_data.writeInt(((consumed)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reportDropResult, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Tell the OS that we've just dragged into a View that is willing to accept the drop
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.639 -0500", hash_original_method = "67E82A5784DC1080FC96A50BB0E88663", hash_generated_method = "A72C6936100A00A20CE53425534E11B9")
            public void dragRecipientEntered(android.view.IWindow window) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_dragRecipientEntered, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Tell the OS that we've just dragged *off* of a View that was willing to accept the drop
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.641 -0500", hash_original_method = "20AF00D0EB22173D8988EF26A58EB6B0", hash_generated_method = "D8C5596F6172C06E09A3A04C6AA8B435")
            public void dragRecipientExited(android.view.IWindow window) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((window!=null))?(window.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_dragRecipientExited, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * For windows with the wallpaper behind them, and the wallpaper is
     * larger than the screen, set the offset within the screen.
     * For multi screen launcher type applications, xstep and ystep indicate
     * how big the increment is from one screen to another.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.643 -0500", hash_original_method = "AEDF4FCB92D53CD0A798923656FB395C", hash_generated_method = "EE1627C44DDF2792469F816EFEE93ACE")
            public void setWallpaperPosition(android.os.IBinder windowToken, float x, float y, float xstep, float ystep) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(windowToken);
_data.writeFloat(x);
_data.writeFloat(y);
_data.writeFloat(xstep);
_data.writeFloat(ystep);
mRemote.transact(Stub.TRANSACTION_setWallpaperPosition, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.646 -0500", hash_original_method = "A19F3E21705365B40D0FC4C0A96DAC7D", hash_generated_method = "8B5C89A9144DCA498937669556B1638F")
            public void wallpaperOffsetsComplete(android.os.IBinder window) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(window);
mRemote.transact(Stub.TRANSACTION_wallpaperOffsetsComplete, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.648 -0500", hash_original_method = "8B2A391D1048095F59862B51BC968268", hash_generated_method = "627E1B6D21E3D00341D97E31FE0789D7")
            public android.os.Bundle sendWallpaperCommand(android.os.IBinder window, java.lang.String action, int x, int y, int z, android.os.Bundle extras, boolean sync) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Bundle _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(window);
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
mRemote.transact(Stub.TRANSACTION_sendWallpaperCommand, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.Bundle.CREATOR.createFromParcel(_reply);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.650 -0500", hash_original_method = "1E23A6972F9E1DD7B57A8E498769412A", hash_generated_method = "76E0704D2B6BC4B110A9084C23F21D89")
            public void wallpaperCommandComplete(android.os.IBinder window, android.os.Bundle result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(window);
if ((result!=null)) {
_data.writeInt(1);
result.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_wallpaperCommandComplete, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.669 -0500", hash_original_field = "B00795AAF9C8A9DB8C2ED8ABE598C96C", hash_generated_field = "140BED292FCA89AAC1C82EC6F971040D")

static final int TRANSACTION_relayout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.671 -0500", hash_original_field = "4272815A4298B7851B6869A9EF668210", hash_generated_field = "4C676086E2E2CA9C151356E95BAB802B")

static final int TRANSACTION_performDeferredDestroy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.674 -0500", hash_original_field = "81AFC7C0BF8145A7AC8D504522D17460", hash_generated_field = "6835FE70F2025D107A42C228347F8F34")

static final int TRANSACTION_outOfMemory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.676 -0500", hash_original_field = "75EFFB77BF560A46DF73F3F7BE149240", hash_generated_field = "B5802BC2DED29788CE253676CC425A01")

static final int TRANSACTION_setTransparentRegion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.678 -0500", hash_original_field = "358FB26CF563975CF5A1FB8CE98D8F65", hash_generated_field = "2FC387F66ED5F7071D3E379662E144B0")

static final int TRANSACTION_setInsets = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.680 -0500", hash_original_field = "7CC8067C89EBD58B627D230C65B0B6FD", hash_generated_field = "ED32F06F7BDE56B7759C50EFCCAF3BC4")

static final int TRANSACTION_getDisplayFrame = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.683 -0500", hash_original_field = "A7D9085C5F46D89AFAE7B4AE28BBE4DD", hash_generated_field = "DB9E78335C1821362298F14ADA5D4D86")

static final int TRANSACTION_finishDrawing = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.685 -0500", hash_original_field = "24931B0BE0AF5CC2BD2055FBBC8A1ABB", hash_generated_field = "165A444A11A10965B1E48379FB01DAEC")

static final int TRANSACTION_setInTouchMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.687 -0500", hash_original_field = "2B99B4192B98146106EF9777DCD25A75", hash_generated_field = "B6903290191A9E1E8EA5A7AF32ADE0D3")

static final int TRANSACTION_getInTouchMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.689 -0500", hash_original_field = "2144E6789DA302F878B7A7B16D6C7B06", hash_generated_field = "60DA33929D50231DCE02EC585A00C44D")

static final int TRANSACTION_performHapticFeedback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.691 -0500", hash_original_field = "EE7DF859246F4B6ED95C01FD083ED687", hash_generated_field = "54AD215C1127F7D97B185F5A6BBEC3A1")

static final int TRANSACTION_prepareDrag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.693 -0500", hash_original_field = "0C8B87AF981B124689F4119B5C6B9BCD", hash_generated_field = "B1EDEFB181DA97A09A228D8C42D2EF5C")

static final int TRANSACTION_performDrag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.696 -0500", hash_original_field = "9526BEC9062A0D7B11EDF9D476086DB3", hash_generated_field = "D63C40E0F20EB12E190D7600344AFD0E")

static final int TRANSACTION_reportDropResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.698 -0500", hash_original_field = "0E8DA0DBAD31C2F3F3F8AF179B872794", hash_generated_field = "AD403F37EF22AF70058634D537426F1F")

static final int TRANSACTION_dragRecipientEntered = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.700 -0500", hash_original_field = "6006C63736A3FE78775C9F5BFB2928A0", hash_generated_field = "857993EEFDD250158A825200016B71AB")

static final int TRANSACTION_dragRecipientExited = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.702 -0500", hash_original_field = "5F4669E330A8C6A5725536D6F7832098", hash_generated_field = "77838B55928C1C90261C0C775530BEEF")

static final int TRANSACTION_setWallpaperPosition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.704 -0500", hash_original_field = "9E3239F65B1B9A5AD33794E70B27739F", hash_generated_field = "F3E12066B95C27A1FC8AB980AEA76CCB")

static final int TRANSACTION_wallpaperOffsetsComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.706 -0500", hash_original_field = "C2D8865031FC4F980122E83C2BB13F6D", hash_generated_field = "9F62CD890EB4BAC29AE06137227B5870")

static final int TRANSACTION_sendWallpaperCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.708 -0500", hash_original_field = "3493CD099449F1EAC6BCF34F8D7A1C50", hash_generated_field = "1B94D0433D4871E7E9C11C8B20429BF2")

static final int TRANSACTION_wallpaperCommandComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.570 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.575 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.588 -0500", hash_original_method = "6B5BD5C5810D2EC9F260ABCD1C16141C", hash_generated_method = "333EA55466C4ABB2F8307B9C62E9BC6A")
        @Override
public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_add:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
android.view.WindowManager.LayoutParams _arg2;
if ((0!=data.readInt())) {
_arg2 = android.view.WindowManager.LayoutParams.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
android.graphics.Rect _arg4;
_arg4 = new android.graphics.Rect();
android.view.InputChannel _arg5;
_arg5 = new android.view.InputChannel();
int _result = this.add(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(_result);
if ((_arg4!=null)) {
reply.writeInt(1);
_arg4.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addWithoutInputChannel:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
android.view.WindowManager.LayoutParams _arg2;
if ((0!=data.readInt())) {
_arg2 = android.view.WindowManager.LayoutParams.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
android.graphics.Rect _arg4;
_arg4 = new android.graphics.Rect();
int _result = this.addWithoutInputChannel(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(_result);
if ((_arg4!=null)) {
reply.writeInt(1);
_arg4.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_remove:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
this.remove(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_relayout:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
android.view.WindowManager.LayoutParams _arg2;
if ((0!=data.readInt())) {
_arg2 = android.view.WindowManager.LayoutParams.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
int _arg5;
_arg5 = data.readInt();
int _arg6;
_arg6 = data.readInt();
android.graphics.Rect _arg7;
_arg7 = new android.graphics.Rect();
android.graphics.Rect _arg8;
_arg8 = new android.graphics.Rect();
android.graphics.Rect _arg9;
_arg9 = new android.graphics.Rect();
android.content.res.Configuration _arg10;
_arg10 = new android.content.res.Configuration();
android.view.Surface _arg11;
_arg11 = new android.view.Surface();
int _result = this.relayout(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10, _arg11);
reply.writeNoException();
reply.writeInt(_result);
if ((_arg7!=null)) {
reply.writeInt(1);
_arg7.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg8!=null)) {
reply.writeInt(1);
_arg8.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg9!=null)) {
reply.writeInt(1);
_arg9.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg10!=null)) {
reply.writeInt(1);
_arg10.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg11!=null)) {
reply.writeInt(1);
_arg11.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_performDeferredDestroy:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
this.performDeferredDestroy(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_outOfMemory:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
boolean _result = this.outOfMemory(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setTransparentRegion:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
android.graphics.Region _arg1;
if ((0!=data.readInt())) {
_arg1 = android.graphics.Region.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.setTransparentRegion(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setInsets:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
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
android.graphics.Region _arg4;
if ((0!=data.readInt())) {
_arg4 = android.graphics.Region.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
this.setInsets(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_getDisplayFrame:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
android.graphics.Rect _arg1;
_arg1 = new android.graphics.Rect();
this.getDisplayFrame(_arg0, _arg1);
reply.writeNoException();
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_finishDrawing:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
this.finishDrawing(_arg0);
reply.writeNoException();
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
case TRANSACTION_getInTouchMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getInTouchMode();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_performHapticFeedback:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _result = this.performHapticFeedback(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_prepareDrag:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.view.Surface _arg4;
_arg4 = new android.view.Surface();
android.os.IBinder _result = this.prepareDrag(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeStrongBinder(_result);
if ((_arg4!=null)) {
reply.writeInt(1);
_arg4.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_performDrag:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
float _arg2;
_arg2 = data.readFloat();
float _arg3;
_arg3 = data.readFloat();
float _arg4;
_arg4 = data.readFloat();
float _arg5;
_arg5 = data.readFloat();
android.content.ClipData _arg6;
if ((0!=data.readInt())) {
_arg6 = android.content.ClipData.CREATOR.createFromParcel(data);
}
else {
_arg6 = null;
}
boolean _result = this.performDrag(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reportDropResult:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
boolean _arg1;
_arg1 = (0!=data.readInt());
this.reportDropResult(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_dragRecipientEntered:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
this.dragRecipientEntered(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_dragRecipientExited:
{
data.enforceInterface(DESCRIPTOR);
android.view.IWindow _arg0;
_arg0 = android.view.IWindow.Stub.asInterface(data.readStrongBinder());
this.dragRecipientExited(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setWallpaperPosition:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
float _arg1;
_arg1 = data.readFloat();
float _arg2;
_arg2 = data.readFloat();
float _arg3;
_arg3 = data.readFloat();
float _arg4;
_arg4 = data.readFloat();
this.setWallpaperPosition(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_wallpaperOffsetsComplete:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.wallpaperOffsetsComplete(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendWallpaperCommand:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
android.os.Bundle _arg5;
if ((0!=data.readInt())) {
_arg5 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
boolean _arg6;
_arg6 = (0!=data.readInt());
android.os.Bundle _result = this.sendWallpaperCommand(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
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
case TRANSACTION_wallpaperCommandComplete:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
android.os.Bundle _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.wallpaperCommandComplete(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public int add(android.view.IWindow window, int seq, android.view.WindowManager.LayoutParams attrs, int viewVisibility, android.graphics.Rect outContentInsets, android.view.InputChannel outInputChannel) throws android.os.RemoteException;
public int addWithoutInputChannel(android.view.IWindow window, int seq, android.view.WindowManager.LayoutParams attrs, int viewVisibility, android.graphics.Rect outContentInsets) throws android.os.RemoteException;
public void remove(android.view.IWindow window) throws android.os.RemoteException;
/**
     * Change the parameters of a window.  You supply the
     * new parameters, it returns the new frame of the window on screen (the
     * position should be ignored) and surface of the window.  The surface
     * will be invalid if the window is currently hidden, else you can use it
     * to draw the window's contents.
     * 
     * @param window The window being modified.
     * @param seq Ordering sequence number.
     * @param attrs If non-null, new attributes to apply to the window.
     * @param requestedWidth The width the window wants to be.
     * @param requestedHeight The height the window wants to be.
     * @param viewVisibility Window root view's visibility.
     * @param flags Request flags: {@link WindowManagerImpl#RELAYOUT_INSETS_PENDING},
     * {@link WindowManagerImpl#RELAYOUT_DEFER_SURFACE_DESTROY}.
     * @param outFrame Rect in which is placed the new position/size on
     * screen.
     * @param outContentInsets Rect in which is placed the offsets from
     * <var>outFrame</var> in which the content of the window should be
     * placed.  This can be used to modify the window layout to ensure its
     * contents are visible to the user, taking into account system windows
     * like the status bar or a soft keyboard.
     * @param outVisibleInsets Rect in which is placed the offsets from
     * <var>outFrame</var> in which the window is actually completely visible
     * to the user.  This can be used to temporarily scroll the window's
     * contents to make sure the user can see it.  This is different than
     * <var>outContentInsets</var> in that these insets change transiently,
     * so complex relayout of the window should not happen based on them.
     * @param outConfiguration New configuration of window, if it is now
     * becoming visible and the global configuration has changed since it
     * was last displayed.
     * @param outSurface Object in which is placed the new display surface.
     * 
     * @return int Result flags: {@link WindowManagerImpl#RELAYOUT_SHOW_FOCUS},
     * {@link WindowManagerImpl#RELAYOUT_FIRST_TIME}.
     */
public int relayout(android.view.IWindow window, int seq, android.view.WindowManager.LayoutParams attrs, int requestedWidth, int requestedHeight, int viewVisibility, int flags, android.graphics.Rect outFrame, android.graphics.Rect outContentInsets, android.graphics.Rect outVisibleInsets, android.content.res.Configuration outConfig, android.view.Surface outSurface) throws android.os.RemoteException;
/**
     * If a call to relayout() asked to have the surface destroy deferred,
     * it must call this once it is okay to destroy that surface.
     */
public void performDeferredDestroy(android.view.IWindow window) throws android.os.RemoteException;
/**
     * Called by a client to report that it ran out of graphics memory.
     */
public boolean outOfMemory(android.view.IWindow window) throws android.os.RemoteException;
/**
     * Give the window manager a hint of the part of the window that is
     * completely transparent, allowing it to work with the surface flinger
     * to optimize compositing of this part of the window.
     */
public void setTransparentRegion(android.view.IWindow window, android.graphics.Region region) throws android.os.RemoteException;
/**
     * Tell the window manager about the content and visible insets of the
     * given window, which can be used to adjust the <var>outContentInsets</var>
     * and <var>outVisibleInsets</var> values returned by
     * {@link #relayout relayout()} for windows behind this one.
     *
     * @param touchableInsets Controls which part of the window inside of its
     * frame can receive pointer events, as defined by
     * {@link android.view.ViewTreeObserver.InternalInsetsInfo}.
     */
public void setInsets(android.view.IWindow window, int touchableInsets, android.graphics.Rect contentInsets, android.graphics.Rect visibleInsets, android.graphics.Region touchableRegion) throws android.os.RemoteException;
/**
     * Return the current display size in which the window is being laid out,
     * accounting for screen decorations around it.
     */
public void getDisplayFrame(android.view.IWindow window, android.graphics.Rect outDisplayFrame) throws android.os.RemoteException;
public void finishDrawing(android.view.IWindow window) throws android.os.RemoteException;
public void setInTouchMode(boolean showFocus) throws android.os.RemoteException;
public boolean getInTouchMode() throws android.os.RemoteException;
public boolean performHapticFeedback(android.view.IWindow window, int effectId, boolean always) throws android.os.RemoteException;
/**
     * Allocate the drag's thumbnail surface.  Also assigns a token that identifies
     * the drag to the OS and passes that as the return value.  A return value of
     * null indicates failure.
     */
public android.os.IBinder prepareDrag(android.view.IWindow window, int flags, int thumbnailWidth, int thumbnailHeight, android.view.Surface outSurface) throws android.os.RemoteException;
/**
     * Initiate the drag operation itself
     */
public boolean performDrag(android.view.IWindow window, android.os.IBinder dragToken, float touchX, float touchY, float thumbCenterX, float thumbCenterY, android.content.ClipData data) throws android.os.RemoteException;
/**
	 * Report the result of a drop action targeted to the given window.
	 * consumed is 'true' when the drop was accepted by a valid recipient,
	 * 'false' otherwise.
	 */
public void reportDropResult(android.view.IWindow window, boolean consumed) throws android.os.RemoteException;
/**
     * Tell the OS that we've just dragged into a View that is willing to accept the drop
     */
public void dragRecipientEntered(android.view.IWindow window) throws android.os.RemoteException;
/**
     * Tell the OS that we've just dragged *off* of a View that was willing to accept the drop
     */
public void dragRecipientExited(android.view.IWindow window) throws android.os.RemoteException;
/**
     * For windows with the wallpaper behind them, and the wallpaper is
     * larger than the screen, set the offset within the screen.
     * For multi screen launcher type applications, xstep and ystep indicate
     * how big the increment is from one screen to another.
     */
public void setWallpaperPosition(android.os.IBinder windowToken, float x, float y, float xstep, float ystep) throws android.os.RemoteException;
public void wallpaperOffsetsComplete(android.os.IBinder window) throws android.os.RemoteException;
public android.os.Bundle sendWallpaperCommand(android.os.IBinder window, java.lang.String action, int x, int y, int z, android.os.Bundle extras, boolean sync) throws android.os.RemoteException;
public void wallpaperCommandComplete(android.os.IBinder window, android.os.Bundle result) throws android.os.RemoteException;
}
