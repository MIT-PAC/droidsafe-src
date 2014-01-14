package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAlarmManager extends android.os.IInterface
{

	public static abstract class Stub extends android.os.Binder implements android.app.IAlarmManager
	{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.759 -0500", hash_original_field = "13A5B65295BA8071E30F3DBB26419F56", hash_generated_field = "B848C5D782742CE031286D376D8D5931")

private static final java.lang.String DESCRIPTOR = "android.app.IAlarmManager";
/**
 * Cast an IBinder object into an android.app.IAlarmManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.764 -0500", hash_original_method = "0971AB021AE0A2A378B50A14E634F809", hash_generated_method = "3A588C914C6F7C273B745D1ABD13162B")
        
public static android.app.IAlarmManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.app.IAlarmManager))) {
return ((android.app.IAlarmManager)iin);
}
return new android.app.IAlarmManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.802 -0500", hash_original_field = "B68C0E318E0679047C036D38E67C45B7", hash_generated_field = "FA3FF09450992587AD1070C5C0E8264A")

static final int TRANSACTION_set = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.805 -0500", hash_original_field = "19791C385D5FFB0431A9F42B59C5EC7A", hash_generated_field = "1E10D19E0EC3BA9CBD9415D9F9902C87")

static final int TRANSACTION_setRepeating = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.808 -0500", hash_original_field = "97D0EAFDC15FB423EBD79E6452A846D9", hash_generated_field = "61C527CA7B5CEED5A9B2E79F7EBCED1F")

static final int TRANSACTION_setInexactRepeating = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
		private static class Proxy implements android.app.IAlarmManager
		{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.773 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.777 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.779 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.781 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.784 -0500", hash_original_method = "1DC05C107F015B862168D7045BFA60F3", hash_generated_method = "7999ACB5C5684B53D68BB5FA99473DBB")
            
public void set(int type, long triggerAtTime, android.app.PendingIntent operation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
_data.writeLong(triggerAtTime);
if ((operation!=null)) {
_data.writeInt(1);
operation.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_set, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.786 -0500", hash_original_method = "7E92E548EB73359F421E8CBA533E7E15", hash_generated_method = "9A72531E1C935502AD127344FD2F6996")
            
public void setRepeating(int type, long triggerAtTime, long interval, android.app.PendingIntent operation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
_data.writeLong(triggerAtTime);
_data.writeLong(interval);
if ((operation!=null)) {
_data.writeInt(1);
operation.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setRepeating, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.789 -0500", hash_original_method = "7E9F1B843C5588AA72BBC55E16EB2500", hash_generated_method = "8942C52394E96D5C212203517E9DCE78")
            
public void setInexactRepeating(int type, long triggerAtTime, long interval, android.app.PendingIntent operation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
_data.writeLong(triggerAtTime);
_data.writeLong(interval);
if ((operation!=null)) {
_data.writeInt(1);
operation.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setInexactRepeating, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.791 -0500", hash_original_method = "B36AF32B24065383BC1E25527AF82158", hash_generated_method = "9D3A4EAA599A67862021C8B90AE0651B")
            
public void setTime(long millis) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(millis);
mRemote.transact(Stub.TRANSACTION_setTime, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.794 -0500", hash_original_method = "6EC57E73D108B2E02F320191BAC177C9", hash_generated_method = "DCD936525768544BB862312EC1E911C3")
            
public void setTimeZone(java.lang.String zone) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(zone);
mRemote.transact(Stub.TRANSACTION_setTimeZone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.797 -0500", hash_original_method = "AD218CFB0644E8AB5F1FA76E19AE7AEA", hash_generated_method = "25976E990BCD2DFF76C2098475F93433")
            
public void remove(android.app.PendingIntent operation) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((operation!=null)) {
_data.writeInt(1);
operation.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_remove, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
		}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.810 -0500", hash_original_field = "A9EB55189E21DCB9AAD9D63A414926A8", hash_generated_field = "3751A32A8ADDC3655181F7B0BC3919EB")

static final int TRANSACTION_setTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.812 -0500", hash_original_field = "EA3AC225CA517A31517FAF4E6A6BB37D", hash_generated_field = "97B4ADE89501BCA0E7ADFBA6EAE5C9EE")

static final int TRANSACTION_setTimeZone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.815 -0500", hash_original_field = "526D91FBC7F6DC7198A4FBFB72BAE028", hash_generated_field = "65EAFFF0F5E8D1AAE3C7124B29CE2CD8")

static final int TRANSACTION_remove = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.761 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.766 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:11.770 -0500", hash_original_method = "A5278518EB89DAE18C8DD05C09A25BD0", hash_generated_method = "F7B4C0F3F302F83612C82D5B276F6FDC")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_set:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
long _arg1;
_arg1 = data.readLong();
android.app.PendingIntent _arg2;
if ((0!=data.readInt())) {
_arg2 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.set(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setRepeating:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
long _arg1;
_arg1 = data.readLong();
long _arg2;
_arg2 = data.readLong();
android.app.PendingIntent _arg3;
if ((0!=data.readInt())) {
_arg3 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.setRepeating(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_setInexactRepeating:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
long _arg1;
_arg1 = data.readLong();
long _arg2;
_arg2 = data.readLong();
android.app.PendingIntent _arg3;
if ((0!=data.readInt())) {
_arg3 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.setInexactRepeating(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_setTime:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
this.setTime(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setTimeZone:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setTimeZone(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_remove:
{
data.enforceInterface(DESCRIPTOR);
android.app.PendingIntent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.remove(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
	}
	public void set(int type, long triggerAtTime, android.app.PendingIntent operation) throws android.os.RemoteException;
	public void setRepeating(int type, long triggerAtTime, long interval, android.app.PendingIntent operation) throws android.os.RemoteException;
	public void setInexactRepeating(int type, long triggerAtTime, long interval, android.app.PendingIntent operation) throws android.os.RemoteException;
	public void setTime(long millis) throws android.os.RemoteException;
	public void setTimeZone(java.lang.String zone) throws android.os.RemoteException;
	public void remove(android.app.PendingIntent operation) throws android.os.RemoteException;
}
