package android.accessibilityservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IEventListener extends android.os.IInterface
{

	public static abstract class Stub extends android.os.Binder implements android.accessibilityservice.IEventListener
	{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.612 -0500", hash_original_field = "0C5B62B11E5116460C9E7CD87075AB28", hash_generated_field = "0C4E6D753AA6B465D6BD2E95E27F96C2")

private static final java.lang.String DESCRIPTOR = "android.accessibilityservice.IEventListener";
/**
 * Cast an IBinder object into an android.accessibilityservice.IEventListener interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.618 -0500", hash_original_method = "D9607A9849E6D058728C3D98993F055B", hash_generated_method = "B46DCA2E60A7983A44F0EB460F659798")
        
public static android.accessibilityservice.IEventListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.accessibilityservice.IEventListener))) {
return ((android.accessibilityservice.IEventListener)iin);
}
return new android.accessibilityservice.IEventListener.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.648 -0500", hash_original_field = "0CC2E0DDD5804A618D95A3F18FD1EAF5", hash_generated_field = "8BF142A959644365404F36C5FF76837D")

static final int TRANSACTION_setConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.651 -0500", hash_original_field = "6374901A609B914C10E484335FD281A5", hash_generated_field = "A5CD3879025CD1131D2A51625AC48D27")

static final int TRANSACTION_onAccessibilityEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.653 -0500", hash_original_field = "5BD7FF775FF1CFE3CFD07C6902CBF578", hash_generated_field = "F75E2F41A4065BBF1131B0853660A8EA")

static final int TRANSACTION_onInterrupt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
		private static class Proxy implements android.accessibilityservice.IEventListener
		{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.628 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.631 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.633 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.636 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.639 -0500", hash_original_method = "B4EE9482B1F2E0F93B1E977C86B67FEE", hash_generated_method = "DE0E78CD0FA85CD31674E906CA417FC7")
            
public void setConnection(android.accessibilityservice.IAccessibilityServiceConnection connection, int connectionId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((connection!=null))?(connection.asBinder()):(null)));
_data.writeInt(connectionId);
mRemote.transact(Stub.TRANSACTION_setConnection, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.641 -0500", hash_original_method = "A3CF71C02AC191F17C05071DB7900041", hash_generated_method = "FEC1863C14D013F884CEBA64EF668E7C")
            
public void onAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_onAccessibilityEvent, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.644 -0500", hash_original_method = "044923AA01D185256E92B7033EDBB4EF", hash_generated_method = "C73E3919DEE3496DB2C6E8EBDAFE1F0D")
            
public void onInterrupt() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onInterrupt, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
		}
/** Construct the stub at attach it to the interface. */
@DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.615 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.621 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
		@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
		{
			switch (code)
			{
			case TRANSACTION_setConnection:
			{
				data.enforceInterface(DESCRIPTOR);
				android.accessibilityservice.IAccessibilityServiceConnection _arg0;
				_arg0 = android.accessibilityservice.IAccessibilityServiceConnection.Stub.asInterface(data.readStrongBinder());
				int _arg1;
				_arg1 = data.readInt();
				this.setConnection(_arg0, _arg1);
				return true;
			}
			case TRANSACTION_onAccessibilityEvent:
			{
				data.enforceInterface(DESCRIPTOR);
				android.view.accessibility.AccessibilityEvent _arg0;
				if ((0!=data.readInt())) {
					_arg0 = android.view.accessibility.AccessibilityEvent.CREATOR.createFromParcel(data);
				}
				else {
					_arg0 = null;
				}
				this.onAccessibilityEvent(_arg0);
				return true;
			}
			case TRANSACTION_onInterrupt:
			{
				data.enforceInterface(DESCRIPTOR);
				this.onInterrupt();
				return true;
			}
			}
			return super.onTransact(code, data, reply, flags);
		}
	}
	public void setConnection(android.accessibilityservice.IAccessibilityServiceConnection connection, int connectionId) throws android.os.RemoteException;
	public void onAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) throws android.os.RemoteException;
	public void onInterrupt() throws android.os.RemoteException;
}
