package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IRemoteControlDisplay extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.media.IRemoteControlDisplay
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.898 -0500", hash_original_field = "21B7BC5E0BB98CFFB21417E2B1C4BE11", hash_generated_field = "AF032BCCC9618DED16C0D4C9D7537D51")

private static final java.lang.String DESCRIPTOR = "android.media.IRemoteControlDisplay";
/**
 * Cast an IBinder object into an android.media.IRemoteControlDisplay interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.904 -0500", hash_original_method = "8008047DBB2F705097A87793CD730B9B", hash_generated_method = "C1C12ADBC0292BA619AC84776DFFDE15")
        
public static android.media.IRemoteControlDisplay asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.media.IRemoteControlDisplay))) {
return ((android.media.IRemoteControlDisplay)iin);
}
return new android.media.IRemoteControlDisplay.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.945 -0500", hash_original_field = "F1A3A5A7916348B2B19421D0CD9226F8", hash_generated_field = "D7EDEC97A236D10A6143CA7C67425985")

static final int TRANSACTION_setCurrentClientId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.948 -0500", hash_original_field = "D4FD7E34017D6BD3AC73E7B82E9733CF", hash_generated_field = "5FD0414115B7786ABBFC3A4D0432AE7F")

static final int TRANSACTION_setPlaybackState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.951 -0500", hash_original_field = "6B463EF816AE11D6849A0B7633777B22", hash_generated_field = "43A3C88D2838D3A63E39B3FB789AAC37")

static final int TRANSACTION_setTransportControlFlags = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.media.IRemoteControlDisplay
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.914 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.917 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.919 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.922 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Sets the generation counter of the current client that is displayed on the remote control.
     * @param clientGeneration the new RemoteControlClient generation
     * @param clientMediaIntent the PendingIntent associated with the client.
     *    May be null, which implies there is no registered media button event receiver.
     * @param clearing true if the new client generation value maps to a remote control update
     *    where the display should be cleared.
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.924 -0500", hash_original_method = "D748A395306EDA787D8CFBEA7A65878A", hash_generated_method = "1E002A8E54B11539DBB47BCA79F445F4")
            
public void setCurrentClientId(int clientGeneration, android.app.PendingIntent clientMediaIntent, boolean clearing) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(clientGeneration);
if ((clientMediaIntent!=null)) {
_data.writeInt(1);
clientMediaIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((clearing)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setCurrentClientId, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.927 -0500", hash_original_method = "B2343D81DE3F84DFDBF7C3EE8D5C97C8", hash_generated_method = "40B9B107838E5291FB7971EE1523DC80")
            
public void setPlaybackState(int generationId, int state, long stateChangeTimeMs) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(generationId);
_data.writeInt(state);
_data.writeLong(stateChangeTimeMs);
mRemote.transact(Stub.TRANSACTION_setPlaybackState, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.930 -0500", hash_original_method = "F4E545D951F63D0A4BB84D710BEDBA3D", hash_generated_method = "63DE600A7FE6899FD88051AAF6F7968B")
            
public void setTransportControlFlags(int generationId, int transportControlFlags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(generationId);
_data.writeInt(transportControlFlags);
mRemote.transact(Stub.TRANSACTION_setTransportControlFlags, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.933 -0500", hash_original_method = "2FD40E63CB8438DE978D5D89915F32F4", hash_generated_method = "2C1C3478BB615C29D66A0B85E7BEEA03")
            
public void setMetadata(int generationId, android.os.Bundle metadata) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(generationId);
if ((metadata!=null)) {
_data.writeInt(1);
metadata.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setMetadata, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.936 -0500", hash_original_method = "AA353CAE3E50F0ADC304C8670AAA81D7", hash_generated_method = "66DB5EABF86C09CC4F659A87F96DDEA2")
            
public void setArtwork(int generationId, android.graphics.Bitmap artwork) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(generationId);
if ((artwork!=null)) {
_data.writeInt(1);
artwork.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setArtwork, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * To combine metadata text and artwork in one binder call
     */
@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.939 -0500", hash_original_method = "C52E2A19ECD47492786433623CDFC6D5", hash_generated_method = "CEF4377301462C72D3CC3CDA1D15917C")
            
public void setAllMetadata(int generationId, android.os.Bundle metadata, android.graphics.Bitmap artwork) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(generationId);
if ((metadata!=null)) {
_data.writeInt(1);
metadata.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((artwork!=null)) {
_data.writeInt(1);
artwork.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setAllMetadata, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.953 -0500", hash_original_field = "BA3F44286FBBA9DBE32F63A915E27E30", hash_generated_field = "3CB23549B904B2706DBF89E6AF100CE2")

static final int TRANSACTION_setMetadata = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.956 -0500", hash_original_field = "D194F7247120B4EDDFC9B4E050D27024", hash_generated_field = "FAEAF8236482653C1495BE6B05B93C7B")

static final int TRANSACTION_setArtwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.959 -0500", hash_original_field = "E63D46BC979E5EFFF9673A6A98D03B30", hash_generated_field = "E9B3A3E03BC6527820926554C9D4EC89")

static final int TRANSACTION_setAllMetadata = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.900 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.907 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.911 -0500", hash_original_method = "BED3FF1ABCC84211203D8AB6588BC5A6", hash_generated_method = "166D6737BBB577E7AF07C685D00A7D23")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setCurrentClientId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.app.PendingIntent _arg1;
if ((0!=data.readInt())) {
_arg1 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _arg2;
_arg2 = (0!=data.readInt());
this.setCurrentClientId(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_setPlaybackState:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
long _arg2;
_arg2 = data.readLong();
this.setPlaybackState(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_setTransportControlFlags:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.setTransportControlFlags(_arg0, _arg1);
return true;
}
case TRANSACTION_setMetadata:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.Bundle _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.setMetadata(_arg0, _arg1);
return true;
}
case TRANSACTION_setArtwork:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.graphics.Bitmap _arg1;
if ((0!=data.readInt())) {
_arg1 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.setArtwork(_arg0, _arg1);
return true;
}
case TRANSACTION_setAllMetadata:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.Bundle _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.graphics.Bitmap _arg2;
if ((0!=data.readInt())) {
_arg2 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.setAllMetadata(_arg0, _arg1, _arg2);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}

public void setCurrentClientId(int clientGeneration, android.app.PendingIntent clientMediaIntent, boolean clearing) throws android.os.RemoteException;
public void setPlaybackState(int generationId, int state, long stateChangeTimeMs) throws android.os.RemoteException;
public void setTransportControlFlags(int generationId, int transportControlFlags) throws android.os.RemoteException;
public void setMetadata(int generationId, android.os.Bundle metadata) throws android.os.RemoteException;
public void setArtwork(int generationId, android.graphics.Bitmap artwork) throws android.os.RemoteException;

public void setAllMetadata(int generationId, android.os.Bundle metadata, android.graphics.Bitmap artwork) throws android.os.RemoteException;
}
