package com.android.internal.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface ISpellCheckerSessionListener extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements com.android.internal.textservice.ISpellCheckerSessionListener
{
private static final java.lang.String DESCRIPTOR = "com.android.internal.textservice.ISpellCheckerSessionListener";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static com.android.internal.textservice.ISpellCheckerSessionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.android.internal.textservice.ISpellCheckerSessionListener))) {
return ((com.android.internal.textservice.ISpellCheckerSessionListener)iin);
}
return new com.android.internal.textservice.ISpellCheckerSessionListener.Stub.Proxy(obj);
}
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
case TRANSACTION_onGetSuggestions:
{
data.enforceInterface(DESCRIPTOR);
android.view.textservice.SuggestionsInfo[] _arg0;
_arg0 = data.createTypedArray(android.view.textservice.SuggestionsInfo.CREATOR);
this.onGetSuggestions(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.android.internal.textservice.ISpellCheckerSessionListener
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public void onGetSuggestions(android.view.textservice.SuggestionsInfo[] results) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(results, 0);
mRemote.transact(Stub.TRANSACTION_onGetSuggestions, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onGetSuggestions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onGetSuggestions(android.view.textservice.SuggestionsInfo[] results) throws android.os.RemoteException;
}
