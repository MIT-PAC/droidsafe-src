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
 * Original file: ./android/print/IPrintDocumentAdapterObserver.aidl
 */
package android.print;
/**
 * Interface for observing the state of a print document adapter.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintDocumentAdapterObserver extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IPrintDocumentAdapterObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.758 -0400", hash_original_field = "A2C84211CB3D9E88617D515A4E689F7D", hash_generated_field = "10CA33088CC3F0404A0B1785664EEEB5")

private static final java.lang.String DESCRIPTOR = "android.print.IPrintDocumentAdapterObserver";
/**
 * Cast an IBinder object into an android.print.IPrintDocumentAdapterObserver interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.761 -0400", hash_original_method = "82FA6BEDDF3538F6B70081065403E66B", hash_generated_method = "31329AA191A75141283F33B0F746103B")
        
public static android.print.IPrintDocumentAdapterObserver asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IPrintDocumentAdapterObserver))) {
return ((android.print.IPrintDocumentAdapterObserver)iin);
}
return new android.print.IPrintDocumentAdapterObserver.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.775 -0400", hash_original_field = "74EBE39808F51F6B39CA31EEFCFBF26B", hash_generated_field = "F4E68238F0D535954CF6A0ACA2890393")

static final int TRANSACTION_onDestroy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.759 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.763 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
private static class Proxy implements android.print.IPrintDocumentAdapterObserver
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.766 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.768 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.770 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.771 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.773 -0400", hash_original_method = "9FD23340D10B6798813E89567F4DF641", hash_generated_method = "CD322C523793734B3BA6676A0CF22F90")
            
@Override public void onDestroy() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onDestroy, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:57.764 -0400", hash_original_method = "9A503E051A700921393D9A6B4648C577", hash_generated_method = "525C54B780C20ADBD129594A5FDA75AD")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onDestroy:
{
data.enforceInterface(DESCRIPTOR);
this.onDestroy();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void onDestroy() throws android.os.RemoteException;
}
