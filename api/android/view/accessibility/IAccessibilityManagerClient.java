package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAccessibilityManagerClient extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.view.accessibility.IAccessibilityManagerClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.517 -0500", hash_original_field = "5DAF4A91D6E05937711FDDA71FF259CC", hash_generated_field = "77748A8B450B1770BC8F83231298BD80")

private static final java.lang.String DESCRIPTOR = "android.view.accessibility.IAccessibilityManagerClient";
/**
 * Cast an IBinder object into an android.view.accessibility.IAccessibilityManagerClient interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.522 -0500", hash_original_method = "E2B8CA158A8F4FC97600AF94F3CAA9A0", hash_generated_method = "BCF6B38590D8CD1C34A531F45C353EF5")
        
public static android.view.accessibility.IAccessibilityManagerClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.view.accessibility.IAccessibilityManagerClient))) {
return ((android.view.accessibility.IAccessibilityManagerClient)iin);
}
return new android.view.accessibility.IAccessibilityManagerClient.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.545 -0500", hash_original_field = "881258B107FF1320AD7FF1698320C217", hash_generated_field = "95F26D9E960FBB8C3673E644DB5C8D45")

static final int TRANSACTION_setState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.519 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.524 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.view.accessibility.IAccessibilityManagerClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.530 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.533 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.536 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.539 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:52.541 -0500", hash_original_method = "31CE0D9883649DEE04D8497F05CB3AAD", hash_generated_method = "C04EEA780D02D6F6B91EBC7CB363AC9C")
            
public void setState(int stateFlags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(stateFlags);
mRemote.transact(Stub.TRANSACTION_setState, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}

        @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
	addTaint(code);
	addTaint(data.getTaint());
	addTaint(reply.getTaint());
	addTaint(flags);
	reply.addTaint(getTaint());
	switch (code)
	{
		case INTERFACE_TRANSACTION:
		{
			reply.writeString(DESCRIPTOR);
		}
		case TRANSACTION_setState:
		{
			data.enforceInterface(DESCRIPTOR);
			int _arg0;
			_arg0 = data.readInt();
			this.setState(_arg0);
		}
		default:
		{
			super.onTransact(code, data, reply, flags);
		}
	}
	return getTaintBoolean();
}
}
public void setState(int stateFlags) throws android.os.RemoteException;
}
