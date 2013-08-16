package android.speech;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface IRecognitionService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.speech.IRecognitionService
{
private static final java.lang.String DESCRIPTOR = "android.speech.IRecognitionService";

@DSModeled(DSC.BAN)
        public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.speech.IRecognitionService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.speech.IRecognitionService))) {
return ((android.speech.IRecognitionService)iin);
}
return new android.speech.IRecognitionService.Stub.Proxy(obj);
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
case TRANSACTION_startListening:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.speech.IRecognitionListener _arg1;
_arg1 = android.speech.IRecognitionListener.Stub.asInterface(data.readStrongBinder());
this.startListening(_arg0, _arg1);
return true;
}
case TRANSACTION_stopListening:
{
data.enforceInterface(DESCRIPTOR);
android.speech.IRecognitionListener _arg0;
_arg0 = android.speech.IRecognitionListener.Stub.asInterface(data.readStrongBinder());
this.stopListening(_arg0);
return true;
}
case TRANSACTION_cancel:
{
data.enforceInterface(DESCRIPTOR);
android.speech.IRecognitionListener _arg0;
_arg0 = android.speech.IRecognitionListener.Stub.asInterface(data.readStrongBinder());
this.cancel(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.speech.IRecognitionService
{
private android.os.IBinder mRemote;
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

@DSModeled(DSC.SPEC)
            public void startListening(android.content.Intent recognizerIntent, android.speech.IRecognitionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((recognizerIntent!=null)) {
_data.writeInt(1);
recognizerIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_startListening, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}

public void stopListening(android.speech.IRecognitionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_stopListening, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}

public void cancel(android.speech.IRecognitionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_cancel, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_startListening = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_stopListening = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_cancel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}

public void startListening(android.content.Intent recognizerIntent, android.speech.IRecognitionListener listener) throws android.os.RemoteException;

public void stopListening(android.speech.IRecognitionListener listener) throws android.os.RemoteException;

public void cancel(android.speech.IRecognitionListener listener) throws android.os.RemoteException;
}
