package com.android.internal.textservice;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ISpellCheckerSession extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.textservice.ISpellCheckerSession
{
private static final java.lang.String DESCRIPTOR = "com.android.internal.textservice.ISpellCheckerSession";

@DSModeled(DSC.BAN)
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static com.android.internal.textservice.ISpellCheckerSession asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.textservice.ISpellCheckerSession))) {
return ((com.android.internal.textservice.ISpellCheckerSession)iin);
}
return new com.android.internal.textservice.ISpellCheckerSession.Stub.Proxy(obj);
}
@DSModeled(DSC.BAN)
        public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onGetSuggestionsMultiple:
{
data.enforceInterface(DESCRIPTOR);
android.view.textservice.TextInfo[] _arg0;
_arg0 = data.createTypedArray(android.view.textservice.TextInfo.CREATOR);
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.onGetSuggestionsMultiple(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onCancel:
{
data.enforceInterface(DESCRIPTOR);
this.onCancel();
reply.writeNoException();
return true;
}
case TRANSACTION_onClose:
{
data.enforceInterface(DESCRIPTOR);
this.onClose();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.android.internal.textservice.ISpellCheckerSession
{
private android.os.IBinder mRemote;
@DSModeled(DSC.SAFE)
            Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSModeled(DSC.BAN)
            public android.os.IBinder asBinder()
{
return mRemote;
}
@DSModeled(DSC.BAN)
            public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSModeled(DSC.SAFE)
            public void onGetSuggestionsMultiple(android.view.textservice.TextInfo[] textInfos, int suggestionsLimit, boolean multipleWords) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(textInfos, 0);
_data.writeInt(suggestionsLimit);
_data.writeInt(((multipleWords)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onGetSuggestionsMultiple, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSModeled(DSC.BAN)
            public void onCancel() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onCancel, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSModeled(DSC.BAN)
            public void onClose() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onClose, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onGetSuggestionsMultiple = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onCancel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onClose = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void onGetSuggestionsMultiple(android.view.textservice.TextInfo[] textInfos, int suggestionsLimit, boolean multipleWords) throws android.os.RemoteException;
public void onCancel() throws android.os.RemoteException;
public void onClose() throws android.os.RemoteException;
}
