package android.accounts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IAccountManager extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.accounts.IAccountManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.753 -0500", hash_original_field = "2269A578ABE57C48236BB016A3CB653B", hash_generated_field = "14340894C158F6ED527C75036E7A37D0")

private static final java.lang.String DESCRIPTOR = "android.accounts.IAccountManager";
/**
 * Cast an IBinder object into an android.accounts.IAccountManager interface,
 * generating a proxy if needed.
 */
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.758 -0500", hash_original_method = "070C6DDC88ED014883E5B71B36D3A9EE", hash_generated_method = "AF427E403C371A5E56F3973FB6E3AF25")
        
public static android.accounts.IAccountManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.accounts.IAccountManager))) {
return ((android.accounts.IAccountManager)iin);
}
return new android.accounts.IAccountManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.851 -0500", hash_original_field = "46C289219EA5E6B338213ABA1867E9EA", hash_generated_field = "3CB9DC7B3F2227EB18712063083BB3CA")

static final int TRANSACTION_getPassword = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.853 -0500", hash_original_field = "49B78E5416EC96A01E178D0766D3FB37", hash_generated_field = "DE29C91DD4D10DC385B2BECC306E738B")

static final int TRANSACTION_getUserData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.856 -0500", hash_original_field = "BBE15DA069B70C6C75F961DB3796CB49", hash_generated_field = "3927FCE607A151B65BDBB4908C01422B")

static final int TRANSACTION_getAuthenticatorTypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.accounts.IAccountManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.773 -0500", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.776 -0500", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.779 -0500", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "759C8A668582B1083BBB5B7173EDF02D")
            
public android.os.IBinder asBinder()
{
return mRemote;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.782 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSSource({DSSourceKind.ACCOUNT_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.785 -0500", hash_original_method = "613F5AA8B2BF31EC9130873BA11619C0", hash_generated_method = "5385C0A2CC4FEA5417E82C2F32B2A9A3")
            
public java.lang.String getPassword(android.accounts.Account account) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPassword, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.ACCOUNT_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.788 -0500", hash_original_method = "1369827228C2F9DDBAA4B6ECA2E8F6A7", hash_generated_method = "85BC745FE5C53AE9EF039EBE94EA18E3")
            
public java.lang.String getUserData(android.accounts.Account account, java.lang.String key) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(key);
mRemote.transact(Stub.TRANSACTION_getUserData, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.790 -0500", hash_original_method = "455B780F5DB92F774B23366EC2E886B7", hash_generated_method = "BC34F2933FF17CE05D1948FA94463C8E")
            
public android.accounts.AuthenticatorDescription[] getAuthenticatorTypes() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.accounts.AuthenticatorDescription[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAuthenticatorTypes, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.accounts.AuthenticatorDescription.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSource({DSSourceKind.ACCOUNT_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.793 -0500", hash_original_method = "AA0D02F193C8C1E99102BFE98B5DD2D8", hash_generated_method = "BE210932322F2C92E4D6DD575675852F")
            
public android.accounts.Account[] getAccounts(java.lang.String accountType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.accounts.Account[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(accountType);
mRemote.transact(Stub.TRANSACTION_getAccounts, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArray(android.accounts.Account.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.797 -0500", hash_original_method = "A9E821901FB4179F1E8E39F793D99A69", hash_generated_method = "49C46A958AEFD343FB063421A871761B")
            
public void hasFeatures(android.accounts.IAccountManagerResponse response, android.accounts.Account account, java.lang.String[] features) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStringArray(features);
mRemote.transact(Stub.TRANSACTION_hasFeatures, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.800 -0500", hash_original_method = "2B24D9044E5459ED3A8D3B367A9BD3A5", hash_generated_method = "51FAD87001A03414159DEFC7C1CF2733")
            
public void getAccountsByFeatures(android.accounts.IAccountManagerResponse response, java.lang.String accountType, java.lang.String[] features) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
_data.writeString(accountType);
_data.writeStringArray(features);
mRemote.transact(Stub.TRANSACTION_getAccountsByFeatures, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.803 -0500", hash_original_method = "3447C83D5FF9E2A34BDC066D70D40F18", hash_generated_method = "1A90A24AE1EC465A81D643C151E9B66B")
            
public boolean addAccount(android.accounts.Account account, java.lang.String password, android.os.Bundle extras) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(password);
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addAccount, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.806 -0500", hash_original_method = "87D03907FE58C4A795A58E4764F89BCF", hash_generated_method = "CE32848C866C07387B6D1F02F695B344")
            
public void removeAccount(android.accounts.IAccountManagerResponse response, android.accounts.Account account) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removeAccount, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.809 -0500", hash_original_method = "25B3D598F21607F54B9DB93F25E141D7", hash_generated_method = "E93F74B2EF08E3C88241D0F70A6431F7")
            
public void invalidateAuthToken(java.lang.String accountType, java.lang.String authToken) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(accountType);
_data.writeString(authToken);
mRemote.transact(Stub.TRANSACTION_invalidateAuthToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.812 -0500", hash_original_method = "0A43DB28AA286DFBE326B78C77E32713", hash_generated_method = "D807BFD87488A7BDD51EAB1D2744ED36")
            
public java.lang.String peekAuthToken(android.accounts.Account account, java.lang.String authTokenType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authTokenType);
mRemote.transact(Stub.TRANSACTION_peekAuthToken, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.815 -0500", hash_original_method = "27041E59A46441704B9D4A554720EC3C", hash_generated_method = "B3CCB3BFE353BA9CD13018154D18AFA1")
            
public void setAuthToken(android.accounts.Account account, java.lang.String authTokenType, java.lang.String authToken) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authTokenType);
_data.writeString(authToken);
mRemote.transact(Stub.TRANSACTION_setAuthToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.819 -0500", hash_original_method = "92BB79506A20C63BB46CDF586DE01885", hash_generated_method = "1EE4F9E1ABC05750B703966504F185BE")
            
public void setPassword(android.accounts.Account account, java.lang.String password) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(password);
mRemote.transact(Stub.TRANSACTION_setPassword, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.822 -0500", hash_original_method = "8CC2FD8724B90BDC2DA5E0DEC8D321E2", hash_generated_method = "70F62E10E5797953B71833D2E40DAA78")
            
public void clearPassword(android.accounts.Account account) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_clearPassword, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.825 -0500", hash_original_method = "04059C959DA954E966F758AEC50BF3D6", hash_generated_method = "0F9C7743AE7194EED09EC9DD2894D010")
            
public void setUserData(android.accounts.Account account, java.lang.String key, java.lang.String value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(key);
_data.writeString(value);
mRemote.transact(Stub.TRANSACTION_setUserData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.828 -0500", hash_original_method = "B9A2318B03DF05E45E47C824A09686C8", hash_generated_method = "A36B512D08F94486FB6C0142ED87B8E4")
            
public void getAuthToken(android.accounts.IAccountManagerResponse response, android.accounts.Account account, java.lang.String authTokenType, boolean notifyOnAuthFailure, boolean expectActivityLaunch, android.os.Bundle options) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authTokenType);
_data.writeInt(((notifyOnAuthFailure)?(1):(0)));
_data.writeInt(((expectActivityLaunch)?(1):(0)));
if ((options!=null)) {
_data.writeInt(1);
options.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getAuthToken, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.831 -0500", hash_original_method = "1B37A3F0E37B46B007FC3287EB1CE330", hash_generated_method = "3AEEDC481306286B303A4705EA6C2B9C")
            
public void addAcount(android.accounts.IAccountManagerResponse response, java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] requiredFeatures, boolean expectActivityLaunch, android.os.Bundle options) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
_data.writeString(accountType);
_data.writeString(authTokenType);
_data.writeStringArray(requiredFeatures);
_data.writeInt(((expectActivityLaunch)?(1):(0)));
if ((options!=null)) {
_data.writeInt(1);
options.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addAcount, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.834 -0500", hash_original_method = "AF8787AF92F55CE5961C029851B37584", hash_generated_method = "F08613930EB91BB8950E30D49F2989A7")
            
public void updateCredentials(android.accounts.IAccountManagerResponse response, android.accounts.Account account, java.lang.String authTokenType, boolean expectActivityLaunch, android.os.Bundle options) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(authTokenType);
_data.writeInt(((expectActivityLaunch)?(1):(0)));
if ((options!=null)) {
_data.writeInt(1);
options.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateCredentials, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.837 -0500", hash_original_method = "80777DBA5B20CC21D3AB40B19DCCB919", hash_generated_method = "A00C4390D4B55CD35C42FE9D38DE79FE")
            
public void editProperties(android.accounts.IAccountManagerResponse response, java.lang.String accountType, boolean expectActivityLaunch) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
_data.writeString(accountType);
_data.writeInt(((expectActivityLaunch)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_editProperties, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.841 -0500", hash_original_method = "3F6D5297BBFECDF4BE38E20EEB490973", hash_generated_method = "2F1C7BDFEB0890AC2BE9B973AE7B6883")
            
public void confirmCredentials(android.accounts.IAccountManagerResponse response, android.accounts.Account account, android.os.Bundle options, boolean expectActivityLaunch) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
if ((account!=null)) {
_data.writeInt(1);
account.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((options!=null)) {
_data.writeInt(1);
options.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((expectActivityLaunch)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_confirmCredentials, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.859 -0500", hash_original_field = "CA6E2A39FF4728A2DE4CCDE84CB37C39", hash_generated_field = "FAF37ABB98E315CD09173C67570D05DB")

static final int TRANSACTION_getAccounts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.861 -0500", hash_original_field = "13A072B4B9B80E725AAB20B957708416", hash_generated_field = "8D4A8327951900896073EF3A3D390112")

static final int TRANSACTION_hasFeatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.864 -0500", hash_original_field = "D54B7EAA77517DAB34D326C20E7301FA", hash_generated_field = "D69A9441D02B54FB8DCC8234BCE17458")

static final int TRANSACTION_getAccountsByFeatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.867 -0500", hash_original_field = "436C6CF64E1C0077089BEC0688C82D37", hash_generated_field = "B70186FFB05D68C19A9EBF9F9E2EFCA3")

static final int TRANSACTION_addAccount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.870 -0500", hash_original_field = "D3A6FA1DB8B768431EC7AFAA647FEC31", hash_generated_field = "7CBAC61870683B86576283B6613EAE20")

static final int TRANSACTION_removeAccount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.872 -0500", hash_original_field = "ECFB5A7E91352E7DF378DECF413655C3", hash_generated_field = "006363D02CB4CF0973C955D7990A8F29")

static final int TRANSACTION_invalidateAuthToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.875 -0500", hash_original_field = "964BE04587243E892782E9C38E10FE4B", hash_generated_field = "9C692DBD3725F794F75C721ACBB6F62A")

static final int TRANSACTION_peekAuthToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.878 -0500", hash_original_field = "AC2C6DA98EF9125C5608B7B22463EE88", hash_generated_field = "108275C05EC523E6BB3E8391AE249B2D")

static final int TRANSACTION_setAuthToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.881 -0500", hash_original_field = "793ABE5039DB3C44912EC60183B8479C", hash_generated_field = "F87E20AAEE01A45743A47D883CABC66B")

static final int TRANSACTION_setPassword = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.884 -0500", hash_original_field = "00E3418426B644D1C287D0D29A9D516F", hash_generated_field = "AB45277E3E0E027FD29C6E16EC484785")

static final int TRANSACTION_clearPassword = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.887 -0500", hash_original_field = "2040954FFCE990E9C4651552CC72B0BA", hash_generated_field = "EDFC21093DCF977EDBFB252656E38E15")

static final int TRANSACTION_setUserData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.889 -0500", hash_original_field = "69669E1D675038C86CA52D9C971AAC79", hash_generated_field = "03CC2F42058499CC52ECD82A9E8B1280")

static final int TRANSACTION_getAuthToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.892 -0500", hash_original_field = "4C814240DDD3C15338BC1779675699FC", hash_generated_field = "D99CA656AD780DC53D26CE853EAC4554")

static final int TRANSACTION_addAcount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.895 -0500", hash_original_field = "1EC5708F3E52A8EBE5C95D75F111A926", hash_generated_field = "B969E213661F0A20CF6EF9CE038DD919")

static final int TRANSACTION_updateCredentials = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.897 -0500", hash_original_field = "F38A1C8D085A6307F230DA68A8A3ACAF", hash_generated_field = "CDE8B3C866FFD4B90BAA25A8D5E52D8E")

static final int TRANSACTION_editProperties = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.900 -0500", hash_original_field = "BA65ED182B37CCC8CD1D23AC94ABA0E8", hash_generated_field = "C81DFCC315F3D03AAD148C6FC3821892")

static final int TRANSACTION_confirmCredentials = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.756 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.761 -0500", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "A79E347C5D485D9B79CCCDADB15E402D")
        
public android.os.IBinder asBinder()
{
return this;
}
@DSSink({DSSinkKind.ACCOUNT_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.769 -0500", hash_original_method = "256E9B458D549132DE7A1253180A65FA", hash_generated_method = "79EF2D7BC2A5C7161352E9AE426E3272")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getPassword:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _result = this.getPassword(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getUserData:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _result = this.getUserData(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getAuthenticatorTypes:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.AuthenticatorDescription[] _result = this.getAuthenticatorTypes();
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_getAccounts:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.accounts.Account[] _result = this.getAccounts(_arg0);
reply.writeNoException();
reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
return true;
}
case TRANSACTION_hasFeatures:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountManagerResponse _arg0;
_arg0 = android.accounts.IAccountManagerResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
this.hasFeatures(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getAccountsByFeatures:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountManagerResponse _arg0;
_arg0 = android.accounts.IAccountManagerResponse.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
this.getAccountsByFeatures(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_addAccount:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
boolean _result = this.addAccount(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_removeAccount:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountManagerResponse _arg0;
_arg0 = android.accounts.IAccountManagerResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.removeAccount(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_invalidateAuthToken:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.invalidateAuthToken(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_peekAuthToken:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _result = this.peekAuthToken(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setAuthToken:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.setAuthToken(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setPassword:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
this.setPassword(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_clearPassword:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.clearPassword(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setUserData:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.Account _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.setUserData(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getAuthToken:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountManagerResponse _arg0;
_arg0 = android.accounts.IAccountManagerResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String _arg2;
_arg2 = data.readString();
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _arg4;
_arg4 = (0!=data.readInt());
android.os.Bundle _arg5;
if ((0!=data.readInt())) {
_arg5 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
this.getAuthToken(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_addAcount:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountManagerResponse _arg0;
_arg0 = android.accounts.IAccountManagerResponse.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String[] _arg3;
_arg3 = data.createStringArray();
boolean _arg4;
_arg4 = (0!=data.readInt());
android.os.Bundle _arg5;
if ((0!=data.readInt())) {
_arg5 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
this.addAcount(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_updateCredentials:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountManagerResponse _arg0;
_arg0 = android.accounts.IAccountManagerResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String _arg2;
_arg2 = data.readString();
boolean _arg3;
_arg3 = (0!=data.readInt());
android.os.Bundle _arg4;
if ((0!=data.readInt())) {
_arg4 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
this.updateCredentials(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_editProperties:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountManagerResponse _arg0;
_arg0 = android.accounts.IAccountManagerResponse.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.editProperties(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_confirmCredentials:
{
data.enforceInterface(DESCRIPTOR);
android.accounts.IAccountManagerResponse _arg0;
_arg0 = android.accounts.IAccountManagerResponse.Stub.asInterface(data.readStrongBinder());
android.accounts.Account _arg1;
if ((0!=data.readInt())) {
_arg1 = android.accounts.Account.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
boolean _arg3;
_arg3 = (0!=data.readInt());
this.confirmCredentials(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public java.lang.String getPassword(android.accounts.Account account) throws android.os.RemoteException;
public java.lang.String getUserData(android.accounts.Account account, java.lang.String key) throws android.os.RemoteException;
public android.accounts.AuthenticatorDescription[] getAuthenticatorTypes() throws android.os.RemoteException;
public android.accounts.Account[] getAccounts(java.lang.String accountType) throws android.os.RemoteException;
public void hasFeatures(android.accounts.IAccountManagerResponse response, android.accounts.Account account, java.lang.String[] features) throws android.os.RemoteException;
public void getAccountsByFeatures(android.accounts.IAccountManagerResponse response, java.lang.String accountType, java.lang.String[] features) throws android.os.RemoteException;
public boolean addAccount(android.accounts.Account account, java.lang.String password, android.os.Bundle extras) throws android.os.RemoteException;
public void removeAccount(android.accounts.IAccountManagerResponse response, android.accounts.Account account) throws android.os.RemoteException;
public void invalidateAuthToken(java.lang.String accountType, java.lang.String authToken) throws android.os.RemoteException;
public java.lang.String peekAuthToken(android.accounts.Account account, java.lang.String authTokenType) throws android.os.RemoteException;
public void setAuthToken(android.accounts.Account account, java.lang.String authTokenType, java.lang.String authToken) throws android.os.RemoteException;
public void setPassword(android.accounts.Account account, java.lang.String password) throws android.os.RemoteException;
public void clearPassword(android.accounts.Account account) throws android.os.RemoteException;
public void setUserData(android.accounts.Account account, java.lang.String key, java.lang.String value) throws android.os.RemoteException;
public void getAuthToken(android.accounts.IAccountManagerResponse response, android.accounts.Account account, java.lang.String authTokenType, boolean notifyOnAuthFailure, boolean expectActivityLaunch, android.os.Bundle options) throws android.os.RemoteException;
public void addAcount(android.accounts.IAccountManagerResponse response, java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] requiredFeatures, boolean expectActivityLaunch, android.os.Bundle options) throws android.os.RemoteException;
public void updateCredentials(android.accounts.IAccountManagerResponse response, android.accounts.Account account, java.lang.String authTokenType, boolean expectActivityLaunch, android.os.Bundle options) throws android.os.RemoteException;
public void editProperties(android.accounts.IAccountManagerResponse response, java.lang.String accountType, boolean expectActivityLaunch) throws android.os.RemoteException;
public void confirmCredentials(android.accounts.IAccountManagerResponse response, android.accounts.Account account, android.os.Bundle options, boolean expectActivityLaunch) throws android.os.RemoteException;
}
