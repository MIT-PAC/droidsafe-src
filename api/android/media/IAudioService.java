package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAudioService extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.media.IAudioService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.561 -0500", hash_original_field = "A9C15E76C6F073729E8B6921D4442047", hash_generated_field = "74ECB6FC910B3757DB5CD218ED6F0838")

private static final java.lang.String DESCRIPTOR = "android.media.IAudioService";
/**
 * Cast an IBinder object into an android.media.IAudioService interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.567 -0500", hash_original_method = "069C7F8452E3E5E45C380349964E0738", hash_generated_method = "78F157BC6D58604D1CB04F83FF51540E")
        
public static android.media.IAudioService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.media.IAudioService))) {
return ((android.media.IAudioService)iin);
}
return new android.media.IAudioService.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.714 -0500", hash_original_field = "75E4E5FE08445C32225ED1FCCFD83AB2", hash_generated_field = "9515F84D5142130A181D35F470CDC112")

static final int TRANSACTION_adjustVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.716 -0500", hash_original_field = "EBC36C0CA1726B3DF78EDAA9489CC2D1", hash_generated_field = "A13E133380C470C6874A0A0D335C476A")

static final int TRANSACTION_adjustSuggestedStreamVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.718 -0500", hash_original_field = "0BB20CDD22124231B9E01E096EEF5A92", hash_generated_field = "88847AEA25B238C5E177B6E6C6C290A2")

static final int TRANSACTION_adjustStreamVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.media.IAudioService
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.582 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.585 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.588 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.590 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.593 -0500", hash_original_method = "B4A97B34F22886A91E041DE8226CDFDB", hash_generated_method = "77B917380B127135631B3660775D4EE5")
            
public void adjustVolume(int direction, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(direction);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_adjustVolume, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.596 -0500", hash_original_method = "2D2FE96359A5F1F75C48121AF2D3E7F6", hash_generated_method = "A6750C3BB5357100CE9CCF75841AFEB1")
            
public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(direction);
_data.writeInt(suggestedStreamType);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_adjustSuggestedStreamVolume, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.599 -0500", hash_original_method = "5E995304036EF8A64515CDAB68425B0F", hash_generated_method = "4983BC5710A9F83AD50B2A2F44BDE407")
            
public void adjustStreamVolume(int streamType, int direction, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(streamType);
_data.writeInt(direction);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_adjustStreamVolume, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.602 -0500", hash_original_method = "587A021F3AF81E3A12C2D89B61D03C5A", hash_generated_method = "D78E253CB1DBE3280DBA4184BCFDD304")
            
public void setStreamVolume(int streamType, int index, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(streamType);
_data.writeInt(index);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_setStreamVolume, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.605 -0500", hash_original_method = "290108D8C1876A7B9C6C78B079509855", hash_generated_method = "6CEF831F96F038973B82C5B5D8C58C8F")
            
public void setStreamSolo(int streamType, boolean state, android.os.IBinder cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(streamType);
_data.writeInt(((state)?(1):(0)));
_data.writeStrongBinder(cb);
mRemote.transact(Stub.TRANSACTION_setStreamSolo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.609 -0500", hash_original_method = "077C79D5D47585C4480D5E98759DE89C", hash_generated_method = "555AE6EE2FD02FE74D2224D3E56976D2")
            
public void setStreamMute(int streamType, boolean state, android.os.IBinder cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(streamType);
_data.writeInt(((state)?(1):(0)));
_data.writeStrongBinder(cb);
mRemote.transact(Stub.TRANSACTION_setStreamMute, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.611 -0500", hash_original_method = "8A12BA5F2259F93C000C4D33EB560515", hash_generated_method = "8D8D313C0A25D16E755C9C4720CA1541")
            
public boolean isStreamMute(int streamType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(streamType);
mRemote.transact(Stub.TRANSACTION_isStreamMute, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.614 -0500", hash_original_method = "6BB666BAA5D514514F70E581C53584FE", hash_generated_method = "D1746A8B73142426BEF168AB885265C2")
            
public int getStreamVolume(int streamType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(streamType);
mRemote.transact(Stub.TRANSACTION_getStreamVolume, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.617 -0500", hash_original_method = "1DFA7811C0DF1CF337C4215AEFA7EE4C", hash_generated_method = "42C1207451A6EB576E728D0CC491A54B")
            
public int getStreamMaxVolume(int streamType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(streamType);
mRemote.transact(Stub.TRANSACTION_getStreamMaxVolume, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.620 -0500", hash_original_method = "F0FEA90A0B4938F9831E8655A28BBCF9", hash_generated_method = "7B70202D1E02B872335B6A29C3C88A40")
            
public int getLastAudibleStreamVolume(int streamType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(streamType);
mRemote.transact(Stub.TRANSACTION_getLastAudibleStreamVolume, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.623 -0500", hash_original_method = "68FDEDC432DD249975FFC4F46E8845AF", hash_generated_method = "FB1791CEBE5FDE5ED903E27C0EEE24D9")
            
public void setRingerMode(int ringerMode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(ringerMode);
mRemote.transact(Stub.TRANSACTION_setRingerMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.626 -0500", hash_original_method = "D4918ADEC983C541F86F45757BFE2A14", hash_generated_method = "AB793618AF7293AE5A6F3C6872ADB567")
            
public int getRingerMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRingerMode, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.628 -0500", hash_original_method = "30EFBD567D60D449E9C1C81B462B54EA", hash_generated_method = "755DFBA6E26D0826CA738334E8C98D40")
            
public void setVibrateSetting(int vibrateType, int vibrateSetting) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(vibrateType);
_data.writeInt(vibrateSetting);
mRemote.transact(Stub.TRANSACTION_setVibrateSetting, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.631 -0500", hash_original_method = "9CBD4F0CDD9454D11A5849FE9C8ABB28", hash_generated_method = "CEB74E831530278406277CE8B75DCA64")
            
public int getVibrateSetting(int vibrateType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(vibrateType);
mRemote.transact(Stub.TRANSACTION_getVibrateSetting, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.634 -0500", hash_original_method = "F4EE01C80ABFBE53F921776D5787901C", hash_generated_method = "E5E50970EFBE1E46206887A37106ACB0")
            
public boolean shouldVibrate(int vibrateType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(vibrateType);
mRemote.transact(Stub.TRANSACTION_shouldVibrate, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.638 -0500", hash_original_method = "72F52556B3AC2C64AA87715606938E25", hash_generated_method = "7CD0F40438118E0D2AD68DFCDBAEC1C0")
            
public void setMode(int mode, android.os.IBinder cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mode);
_data.writeStrongBinder(cb);
mRemote.transact(Stub.TRANSACTION_setMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.640 -0500", hash_original_method = "D205ADA44388A46C6268935B51398C4C", hash_generated_method = "E740D159FC1A0D2A9C119FB49A76C30F")
            
public int getMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMode, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.643 -0500", hash_original_method = "50BB8F887964D6DAD5413EB917802F85", hash_generated_method = "6F05FA082084930AA1AD5F812A9053AB")
            
public void playSoundEffect(int effectType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(effectType);
mRemote.transact(Stub.TRANSACTION_playSoundEffect, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.646 -0500", hash_original_method = "3EB2DC2ACA77C572ECE0CBBB83CFF29F", hash_generated_method = "E06E7B2DE9F0FF2EC62B154A51568F0C")
            
public void playSoundEffectVolume(int effectType, float volume) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(effectType);
_data.writeFloat(volume);
mRemote.transact(Stub.TRANSACTION_playSoundEffectVolume, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.649 -0500", hash_original_method = "EFE52BD95C0CBBD287895B31AFEFE006", hash_generated_method = "AE3E266F89DCD207534D3F5C61457F74")
            
public boolean loadSoundEffects() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_loadSoundEffects, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.652 -0500", hash_original_method = "9734C5A4F859EA9E48198B765D415A14", hash_generated_method = "35D57EFBD72F2E8B8790F37D4B40C085")
            
public void unloadSoundEffects() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_unloadSoundEffects, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.655 -0500", hash_original_method = "944E02C5BF68C4BF98B5DB81562486E3", hash_generated_method = "C78DA688637225C3393F8D598BAC8C31")
            
public void reloadAudioSettings() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reloadAudioSettings, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.657 -0500", hash_original_method = "DDDCC0C769D69822909B650528A46EEB", hash_generated_method = "7210620ED5C8CC40076703C4CCEAB693")
            
public void setSpeakerphoneOn(boolean on) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((on)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setSpeakerphoneOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.660 -0500", hash_original_method = "8B39CA0AA87A775F1D4A4D5255FCBAFD", hash_generated_method = "E22C23ED843CE4560BF9C9450C3D5101")
            
public boolean isSpeakerphoneOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isSpeakerphoneOn, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.663 -0500", hash_original_method = "E930E753F2EEA06CFCD8CC07DD97E1AE", hash_generated_method = "31A96B0A35F4BC8C24A18510A5DE2328")
            
public void setBluetoothScoOn(boolean on) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((on)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setBluetoothScoOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.666 -0500", hash_original_method = "D999F3F3399376E2F1381A697071F47D", hash_generated_method = "05A4F211E8F22AD90C3A65073D4E634D")
            
public boolean isBluetoothScoOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isBluetoothScoOn, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.669 -0500", hash_original_method = "4199A73C4BC96D7404D9999CA4BDCF8D", hash_generated_method = "E47FDA70D9643D3A0B76AB0C2E579E5A")
            
public int requestAudioFocus(int mainStreamType, int durationHint, android.os.IBinder cb, android.media.IAudioFocusDispatcher l, java.lang.String clientId, java.lang.String callingPackageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mainStreamType);
_data.writeInt(durationHint);
_data.writeStrongBinder(cb);
_data.writeStrongBinder((((l!=null))?(l.asBinder()):(null)));
_data.writeString(clientId);
_data.writeString(callingPackageName);
mRemote.transact(Stub.TRANSACTION_requestAudioFocus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.673 -0500", hash_original_method = "F68D9308C1EF51BB6120D3EE288DB020", hash_generated_method = "F478ED13E60E41EACF7DEF052C2DD048")
            
public int abandonAudioFocus(android.media.IAudioFocusDispatcher l, java.lang.String clientId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((l!=null))?(l.asBinder()):(null)));
_data.writeString(clientId);
mRemote.transact(Stub.TRANSACTION_abandonAudioFocus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.676 -0500", hash_original_method = "C4136D35B945E17AFCD72B074D8A8EC6", hash_generated_method = "8F47AFFC6E24FA04B49C5CF0EDD32A5A")
            
public void unregisterAudioFocusClient(java.lang.String clientId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(clientId);
mRemote.transact(Stub.TRANSACTION_unregisterAudioFocusClient, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.678 -0500", hash_original_method = "CDE1399FAC7F2B98B54F0076200E083D", hash_generated_method = "D723A82A5617DFAE3F48E8135D04FC7B")
            
public void registerMediaButtonIntent(android.app.PendingIntent pi, android.content.ComponentName c) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((pi!=null)) {
_data.writeInt(1);
pi.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((c!=null)) {
_data.writeInt(1);
c.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_registerMediaButtonIntent, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.682 -0500", hash_original_method = "DF6A31FAF3D3FDFF2683A372BBC7AFF3", hash_generated_method = "1E810B73900C920FB7645E4A5FFA7F98")
            
public void unregisterMediaButtonIntent(android.app.PendingIntent pi, android.content.ComponentName c) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((pi!=null)) {
_data.writeInt(1);
pi.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((c!=null)) {
_data.writeInt(1);
c.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_unregisterMediaButtonIntent, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.685 -0500", hash_original_method = "2D203E33B7D4F6E9BC94C21583E34EF8", hash_generated_method = "5A6B5FBDB14CAF1F979E37D2998A13BA")
            
public void registerRemoteControlClient(android.app.PendingIntent mediaIntent, android.media.IRemoteControlClient rcClient, java.lang.String callingPackageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((mediaIntent!=null)) {
_data.writeInt(1);
mediaIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((rcClient!=null))?(rcClient.asBinder()):(null)));
_data.writeString(callingPackageName);
mRemote.transact(Stub.TRANSACTION_registerRemoteControlClient, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.688 -0500", hash_original_method = "EC24E43439BF3A7F2E6DD49372E289A6", hash_generated_method = "F3C077BC968D6571972385728259F57F")
            
public void unregisterRemoteControlClient(android.app.PendingIntent mediaIntent, android.media.IRemoteControlClient rcClient) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((mediaIntent!=null)) {
_data.writeInt(1);
mediaIntent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((rcClient!=null))?(rcClient.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterRemoteControlClient, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.691 -0500", hash_original_method = "302A268CE505E870B3F304B80CD71087", hash_generated_method = "75E636FFCB657AE82F0E3B069E12A5C0")
            
public void registerRemoteControlDisplay(android.media.IRemoteControlDisplay rcd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((rcd!=null))?(rcd.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerRemoteControlDisplay, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.694 -0500", hash_original_method = "7CADD2E5CEEA1409AE0A4DD91FD45907", hash_generated_method = "370166F2CAD9E9FB598944E29E6C1D91")
            
public void unregisterRemoteControlDisplay(android.media.IRemoteControlDisplay rcd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((rcd!=null))?(rcd.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterRemoteControlDisplay, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.696 -0500", hash_original_method = "A20DFE16316D6CEAD6D9A7CF3BF8D1F7", hash_generated_method = "8D1C7E05AC605FC81186F8016D424E11")
            
public void remoteControlDisplayUsesBitmapSize(android.media.IRemoteControlDisplay rcd, int w, int h) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((rcd!=null))?(rcd.asBinder()):(null)));
_data.writeInt(w);
_data.writeInt(h);
mRemote.transact(Stub.TRANSACTION_remoteControlDisplayUsesBitmapSize, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.699 -0500", hash_original_method = "0CD6BDA6A57E3AE0FFA97D6C1AC67E45", hash_generated_method = "6F6907631BA22EB20FEF63DC98AA56CD")
            
public void startBluetoothSco(android.os.IBinder cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(cb);
mRemote.transact(Stub.TRANSACTION_startBluetoothSco, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.AUDIO})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.702 -0500", hash_original_method = "1FB851C4FCAEFE9CCA462F2EE2B38ACA", hash_generated_method = "AF572CCB04FF2139297C786AF598C939")
            
public void stopBluetoothSco(android.os.IBinder cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder(cb);
mRemote.transact(Stub.TRANSACTION_stopBluetoothSco, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.721 -0500", hash_original_field = "B08BF3A8820BA67B94FCB44783D462B3", hash_generated_field = "A7BF6D7CCE3CBC480B25EF8CFA588E6A")

static final int TRANSACTION_setStreamVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.724 -0500", hash_original_field = "94AD30AE1C90DBC61AFA23BE0EACFF8D", hash_generated_field = "316198CDFEEF708347DB4C6D692230F8")

static final int TRANSACTION_setStreamSolo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.727 -0500", hash_original_field = "52DFB717A0D8CE705583CA6988D0AFBD", hash_generated_field = "C32CE0E966AD1A630BC92D99458B5402")

static final int TRANSACTION_setStreamMute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.729 -0500", hash_original_field = "B8C40C3CBBECB44FCBB1140CFBC2B64E", hash_generated_field = "2B6806939D01B8AB225AB99CD847B9FE")

static final int TRANSACTION_isStreamMute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.732 -0500", hash_original_field = "19DCEEB7A46B6CA3D6C72AF71A27003C", hash_generated_field = "D633E4DCCE71176D462B700B544C732B")

static final int TRANSACTION_getStreamVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.735 -0500", hash_original_field = "34775263EBCD1FDFF8C45CC8EAF8FF28", hash_generated_field = "040407FC50F1F2C8D14E3BCAEE1FC7EA")

static final int TRANSACTION_getStreamMaxVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.738 -0500", hash_original_field = "63338DA0752453762DAE46F1F1F9646C", hash_generated_field = "4AAF91143C360258F0CE3867FE7D720F")

static final int TRANSACTION_getLastAudibleStreamVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.740 -0500", hash_original_field = "2CC3EC4D07EE52364A253AD3730FD722", hash_generated_field = "C2B1AEECAA4705AD918A92A989A882FA")

static final int TRANSACTION_setRingerMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.743 -0500", hash_original_field = "A3903A5F770FEEAFA087881D3809C281", hash_generated_field = "C8ABB3EB3353B88117B7810DDEC72654")

static final int TRANSACTION_getRingerMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.745 -0500", hash_original_field = "DDA9DD05E7496ADE158FB1D782AD81A8", hash_generated_field = "41736CB8B2F069F96D9C313CEC4FEE7A")

static final int TRANSACTION_setVibrateSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.748 -0500", hash_original_field = "33166556A7AE51A50C08356FE6410699", hash_generated_field = "971E71CC3E6B72A5F9D13486D37C5AC7")

static final int TRANSACTION_getVibrateSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.751 -0500", hash_original_field = "44B46032D864FBCC4B0864A8E288AFEE", hash_generated_field = "989BD51F0A8A384A7CCB2D582BE5E15A")

static final int TRANSACTION_shouldVibrate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.755 -0500", hash_original_field = "86F8C6A992737B6C1280142F063205E1", hash_generated_field = "48BE9F333058E8208C44E104F6D2BFF8")

static final int TRANSACTION_setMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.758 -0500", hash_original_field = "8170B18F8D4882B153F4F040531CCFC0", hash_generated_field = "82A1AB4E3255D1DB78B0156292317203")

static final int TRANSACTION_getMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.760 -0500", hash_original_field = "51447C6FE9D46AC60F60B2BB97D78143", hash_generated_field = "8B2A9113B49AF7E5B865ECE710EDCDB1")

static final int TRANSACTION_playSoundEffect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.763 -0500", hash_original_field = "A2189814C20B145E107068B255B52DB7", hash_generated_field = "72290985F655C7CC775EE4789AFA0F2D")

static final int TRANSACTION_playSoundEffectVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.765 -0500", hash_original_field = "C866241DC999302DCA0544C3F92FDCB6", hash_generated_field = "C59C74BD7591853630630CDE3042EA33")

static final int TRANSACTION_loadSoundEffects = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.768 -0500", hash_original_field = "9503996BEC9803748345BE67EA841CA5", hash_generated_field = "6A2161858DA2FEBDA41C0AC91F6D1B7A")

static final int TRANSACTION_unloadSoundEffects = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.771 -0500", hash_original_field = "B747FCEF3E1D53EE014AE7F36B8C1DCD", hash_generated_field = "4A0376C32428E217752863A3F8C5FC5C")

static final int TRANSACTION_reloadAudioSettings = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.774 -0500", hash_original_field = "F36BFBB87E37CDACC38966141A2087FA", hash_generated_field = "B7D02572CB3204A8923F4028289A8E7F")

static final int TRANSACTION_setSpeakerphoneOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.777 -0500", hash_original_field = "7416BBF1192A015B17CDEDCE8108DF97", hash_generated_field = "75537BE9FB2F2F77529CBF46731D327B")

static final int TRANSACTION_isSpeakerphoneOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.779 -0500", hash_original_field = "4C846BDC59B49E196C5A5ABFAD2F6F36", hash_generated_field = "9173FDA8B5B18C027EC2D32C8CAE198B")

static final int TRANSACTION_setBluetoothScoOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.782 -0500", hash_original_field = "4DE3DD05604B369F50E2A9B3516DA3D0", hash_generated_field = "F3927CE4C6D34BE2F5385D89D658BA7F")

static final int TRANSACTION_isBluetoothScoOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.785 -0500", hash_original_field = "92EA1EFD786DFCEFC5A038102D75F28B", hash_generated_field = "9DA1A55A8E84B5051A32C93A7EA88796")

static final int TRANSACTION_requestAudioFocus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.788 -0500", hash_original_field = "194AD3650401056E7D8E72101CAA34F5", hash_generated_field = "6C84C4D5C8A827D5E639E1ECE813B91A")

static final int TRANSACTION_abandonAudioFocus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.791 -0500", hash_original_field = "A4CA5D0D9BB21524AB54100D169168B0", hash_generated_field = "087B575A5BDC21F8F20CF1AB245AD904")

static final int TRANSACTION_unregisterAudioFocusClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.793 -0500", hash_original_field = "9F284136953932FDA13FC79463F2F97F", hash_generated_field = "7A903B2F2A78B7DF7BEAFC253A92A5F6")

static final int TRANSACTION_registerMediaButtonIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.797 -0500", hash_original_field = "423352781A073DDB8289D5B8B68E7973", hash_generated_field = "4DA510CD9A1F7CB52C0F2EED1E1BF373")

static final int TRANSACTION_unregisterMediaButtonIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.799 -0500", hash_original_field = "FD865217958DFDE0D5B261FDE6529645", hash_generated_field = "7865B5788FC47A0D50EBB442CA453E3F")

static final int TRANSACTION_registerRemoteControlClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.804 -0500", hash_original_field = "BBA48453ACF31FAE01B485730095BECD", hash_generated_field = "5AEE036834EBFA27B2715D49C11F6617")

static final int TRANSACTION_unregisterRemoteControlClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.807 -0500", hash_original_field = "CABBF9658791187D2C9255A39FC84E28", hash_generated_field = "F6BC99E56D093D472EA6FD88539EA857")

static final int TRANSACTION_registerRemoteControlDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.811 -0500", hash_original_field = "94628CA918201A7EDEF19189C0B5615A", hash_generated_field = "A59DB546EA7F4C3614575B6BD737D013")

static final int TRANSACTION_unregisterRemoteControlDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.814 -0500", hash_original_field = "5B7233FEAAA6C9AF732C9AA8B792FA8F", hash_generated_field = "891BAA70B9278CA81201AF2A6B7FED52")

static final int TRANSACTION_remoteControlDisplayUsesBitmapSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.816 -0500", hash_original_field = "0835DABB84B32CB0F79F2D3425D3B06D", hash_generated_field = "1EBAA418E1B32A4CC64E1CC775FCE982")

static final int TRANSACTION_startBluetoothSco = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.819 -0500", hash_original_field = "E9355183214F0A43B3BD7DBD77EF518C", hash_generated_field = "BDEC98BA5B68F08B4035A0784E32F1A9")

static final int TRANSACTION_stopBluetoothSco = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.564 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.570 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.AUDIO})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:24.578 -0500", hash_original_method = "3318C9C193BF9E3BDBFD446631A96457", hash_generated_method = "07E4F8B6DB06AB462AE98FE0C005B9A7")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_adjustVolume:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.adjustVolume(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_adjustSuggestedStreamVolume:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.adjustSuggestedStreamVolume(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_adjustStreamVolume:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.adjustStreamVolume(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setStreamVolume:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.setStreamVolume(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setStreamSolo:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
android.os.IBinder _arg2;
_arg2 = data.readStrongBinder();
this.setStreamSolo(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setStreamMute:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
android.os.IBinder _arg2;
_arg2 = data.readStrongBinder();
this.setStreamMute(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_isStreamMute:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.isStreamMute(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getStreamVolume:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getStreamVolume(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getStreamMaxVolume:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getStreamMaxVolume(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getLastAudibleStreamVolume:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getLastAudibleStreamVolume(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setRingerMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setRingerMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getRingerMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getRingerMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setVibrateSetting:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.setVibrateSetting(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getVibrateSetting:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getVibrateSetting(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_shouldVibrate:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.shouldVibrate(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.IBinder _arg1;
_arg1 = data.readStrongBinder();
this.setMode(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_playSoundEffect:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.playSoundEffect(_arg0);
return true;
}
case TRANSACTION_playSoundEffectVolume:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
float _arg1;
_arg1 = data.readFloat();
this.playSoundEffectVolume(_arg0, _arg1);
return true;
}
case TRANSACTION_loadSoundEffects:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.loadSoundEffects();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unloadSoundEffects:
{
data.enforceInterface(DESCRIPTOR);
this.unloadSoundEffects();
return true;
}
case TRANSACTION_reloadAudioSettings:
{
data.enforceInterface(DESCRIPTOR);
this.reloadAudioSettings();
return true;
}
case TRANSACTION_setSpeakerphoneOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setSpeakerphoneOn(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isSpeakerphoneOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isSpeakerphoneOn();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setBluetoothScoOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setBluetoothScoOn(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isBluetoothScoOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isBluetoothScoOn();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_requestAudioFocus:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.os.IBinder _arg2;
_arg2 = data.readStrongBinder();
android.media.IAudioFocusDispatcher _arg3;
_arg3 = android.media.IAudioFocusDispatcher.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg4;
_arg4 = data.readString();
java.lang.String _arg5;
_arg5 = data.readString();
int _result = this.requestAudioFocus(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_abandonAudioFocus:
{
data.enforceInterface(DESCRIPTOR);
android.media.IAudioFocusDispatcher _arg0;
_arg0 = android.media.IAudioFocusDispatcher.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.abandonAudioFocus(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_unregisterAudioFocusClient:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.unregisterAudioFocusClient(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerMediaButtonIntent:
{
data.enforceInterface(DESCRIPTOR);
android.app.PendingIntent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.ComponentName _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.registerMediaButtonIntent(_arg0, _arg1);
return true;
}
case TRANSACTION_unregisterMediaButtonIntent:
{
data.enforceInterface(DESCRIPTOR);
android.app.PendingIntent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.ComponentName _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.unregisterMediaButtonIntent(_arg0, _arg1);
return true;
}
case TRANSACTION_registerRemoteControlClient:
{
data.enforceInterface(DESCRIPTOR);
android.app.PendingIntent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.media.IRemoteControlClient _arg1;
_arg1 = android.media.IRemoteControlClient.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg2;
_arg2 = data.readString();
this.registerRemoteControlClient(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_unregisterRemoteControlClient:
{
data.enforceInterface(DESCRIPTOR);
android.app.PendingIntent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.app.PendingIntent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.media.IRemoteControlClient _arg1;
_arg1 = android.media.IRemoteControlClient.Stub.asInterface(data.readStrongBinder());
this.unregisterRemoteControlClient(_arg0, _arg1);
return true;
}
case TRANSACTION_registerRemoteControlDisplay:
{
data.enforceInterface(DESCRIPTOR);
android.media.IRemoteControlDisplay _arg0;
_arg0 = android.media.IRemoteControlDisplay.Stub.asInterface(data.readStrongBinder());
this.registerRemoteControlDisplay(_arg0);
return true;
}
case TRANSACTION_unregisterRemoteControlDisplay:
{
data.enforceInterface(DESCRIPTOR);
android.media.IRemoteControlDisplay _arg0;
_arg0 = android.media.IRemoteControlDisplay.Stub.asInterface(data.readStrongBinder());
this.unregisterRemoteControlDisplay(_arg0);
return true;
}
case TRANSACTION_remoteControlDisplayUsesBitmapSize:
{
data.enforceInterface(DESCRIPTOR);
android.media.IRemoteControlDisplay _arg0;
_arg0 = android.media.IRemoteControlDisplay.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.remoteControlDisplayUsesBitmapSize(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_startBluetoothSco:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.startBluetoothSco(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_stopBluetoothSco:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _arg0;
_arg0 = data.readStrongBinder();
this.stopBluetoothSco(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public void adjustVolume(int direction, int flags) throws android.os.RemoteException;
public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) throws android.os.RemoteException;
public void adjustStreamVolume(int streamType, int direction, int flags) throws android.os.RemoteException;
public void setStreamVolume(int streamType, int index, int flags) throws android.os.RemoteException;
public void setStreamSolo(int streamType, boolean state, android.os.IBinder cb) throws android.os.RemoteException;
public void setStreamMute(int streamType, boolean state, android.os.IBinder cb) throws android.os.RemoteException;
public boolean isStreamMute(int streamType) throws android.os.RemoteException;
public int getStreamVolume(int streamType) throws android.os.RemoteException;
public int getStreamMaxVolume(int streamType) throws android.os.RemoteException;
public int getLastAudibleStreamVolume(int streamType) throws android.os.RemoteException;
public void setRingerMode(int ringerMode) throws android.os.RemoteException;
public int getRingerMode() throws android.os.RemoteException;
public void setVibrateSetting(int vibrateType, int vibrateSetting) throws android.os.RemoteException;
public int getVibrateSetting(int vibrateType) throws android.os.RemoteException;
public boolean shouldVibrate(int vibrateType) throws android.os.RemoteException;
public void setMode(int mode, android.os.IBinder cb) throws android.os.RemoteException;
public int getMode() throws android.os.RemoteException;
public void playSoundEffect(int effectType) throws android.os.RemoteException;
public void playSoundEffectVolume(int effectType, float volume) throws android.os.RemoteException;
public boolean loadSoundEffects() throws android.os.RemoteException;
public void unloadSoundEffects() throws android.os.RemoteException;
public void reloadAudioSettings() throws android.os.RemoteException;
public void setSpeakerphoneOn(boolean on) throws android.os.RemoteException;
public boolean isSpeakerphoneOn() throws android.os.RemoteException;
public void setBluetoothScoOn(boolean on) throws android.os.RemoteException;
public boolean isBluetoothScoOn() throws android.os.RemoteException;
public int requestAudioFocus(int mainStreamType, int durationHint, android.os.IBinder cb, android.media.IAudioFocusDispatcher l, java.lang.String clientId, java.lang.String callingPackageName) throws android.os.RemoteException;
public int abandonAudioFocus(android.media.IAudioFocusDispatcher l, java.lang.String clientId) throws android.os.RemoteException;
public void unregisterAudioFocusClient(java.lang.String clientId) throws android.os.RemoteException;
public void registerMediaButtonIntent(android.app.PendingIntent pi, android.content.ComponentName c) throws android.os.RemoteException;
public void unregisterMediaButtonIntent(android.app.PendingIntent pi, android.content.ComponentName c) throws android.os.RemoteException;
public void registerRemoteControlClient(android.app.PendingIntent mediaIntent, android.media.IRemoteControlClient rcClient, java.lang.String callingPackageName) throws android.os.RemoteException;
public void unregisterRemoteControlClient(android.app.PendingIntent mediaIntent, android.media.IRemoteControlClient rcClient) throws android.os.RemoteException;
public void registerRemoteControlDisplay(android.media.IRemoteControlDisplay rcd) throws android.os.RemoteException;
public void unregisterRemoteControlDisplay(android.media.IRemoteControlDisplay rcd) throws android.os.RemoteException;
public void remoteControlDisplayUsesBitmapSize(android.media.IRemoteControlDisplay rcd, int w, int h) throws android.os.RemoteException;
public void startBluetoothSco(android.os.IBinder cb) throws android.os.RemoteException;
public void stopBluetoothSco(android.os.IBinder cb) throws android.os.RemoteException;
}
