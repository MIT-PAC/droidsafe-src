/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ./android/print/IPrintManager.aidl
 */
package android.print;
/**
 * Interface for communication with the core print manager service.
 *
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface IPrintManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.print.IPrintManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.720 -0400", hash_original_field = "811FE8F02B8B02C2205C196051EAF8A9", hash_generated_field = "3509AF68F3429A53253FE05409086DD9")

private static final java.lang.String DESCRIPTOR = "android.print.IPrintManager";
/**
 * Cast an IBinder object into an android.print.IPrintManager interface,
 * generating a proxy if needed.
 */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.722 -0400", hash_original_method = "710736E06DDC1C2FC78C7ECC90CDB266", hash_generated_method = "3AA8D5D5802EDDD60E203EA732078727")
        
public static android.print.IPrintManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.print.IPrintManager))) {
return ((android.print.IPrintManager)iin);
}
return new android.print.IPrintManager.Stub.Proxy(obj);
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.755 -0400", hash_original_field = "9BFD868DE6314DEE2B4AA9C7FA5BDD53", hash_generated_field = "4CDE6D460AE8F6F2B62C4897D4E55AAB")

static final int TRANSACTION_getPrintJobInfos = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.756 -0400", hash_original_field = "FB215D2375F674CC15E67ED28E3557C6", hash_generated_field = "302CB1836000FB392C4DF0FB8EA68972")

static final int TRANSACTION_getPrintJobInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.757 -0400", hash_original_field = "EE5B1B99A69D00D3E03F1B3C0F3EE144", hash_generated_field = "DF20AC15C2456FCAB085D2BB7B784461")

static final int TRANSACTION_print = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
private static class Proxy implements android.print.IPrintManager
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.727 -0400", hash_original_field = "5DDD4F5248ED0D91FD55F73F7CBF8A12", hash_generated_field = "9ADA791533F2FB6F0AFD94406D571674")

private android.os.IBinder mRemote;
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.728 -0400", hash_original_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D", hash_generated_method = "EE9C5A5BCE6D08AEA2E7E52F04E87C0D")
            
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.729 -0400", hash_original_method = "417FB855FBDF4B61E12822ECB3981D2C", hash_generated_method = "FC1E3AB600CA6EE021DD2A28A63E0FA2")
            
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.730 -0400", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.731 -0400", hash_original_method = "2B334127BF9A6DFD6A8E1F2F754CBB37", hash_generated_method = "56FE7B8BF5A6E9422304003446AD2ED1")
            
@Override public java.util.List<android.print.PrintJobInfo> getPrintJobInfos(int appId, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.print.PrintJobInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(appId);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPrintJobInfos, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.print.PrintJobInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.733 -0400", hash_original_method = "59A8762EA8B5410BDF80B60BAA597966", hash_generated_method = "504DD4EE7DD0E7DA11607C28F25F8765")
            
@Override public android.print.PrintJobInfo getPrintJobInfo(android.print.PrintJobId printJobId, int appId, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.print.PrintJobInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(appId);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPrintJobInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.print.PrintJobInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.734 -0400", hash_original_method = "3FB5FCED4B4935233CD69DE177135919", hash_generated_method = "7365AB7402A914593FE4978427BCFA4E")
            
@Override public android.os.Bundle print(java.lang.String printJobName, android.print.IPrintDocumentAdapter printAdapter, android.print.PrintAttributes attributes, java.lang.String packageName, int appId, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Bundle _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(printJobName);
_data.writeStrongBinder((((printAdapter!=null))?(printAdapter.asBinder()):(null)));
if ((attributes!=null)) {
_data.writeInt(1);
attributes.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(packageName);
_data.writeInt(appId);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_print, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.Bundle.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.736 -0400", hash_original_method = "FE501532C4820F1BDF661E989A5A42A1", hash_generated_method = "B9A4D5F3F69BDD536953104A839BDFB4")
            
@Override public void cancelPrintJob(android.print.PrintJobId printJobId, int appId, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(appId);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_cancelPrintJob, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.737 -0400", hash_original_method = "174C09E5F7769191CC838137BD025298", hash_generated_method = "040DE412C030C2C4A304991E2C1E0107")
            
@Override public void restartPrintJob(android.print.PrintJobId printJobId, int appId, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printJobId!=null)) {
_data.writeInt(1);
printJobId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(appId);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_restartPrintJob, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.739 -0400", hash_original_method = "5502FFFCD387BC72D7B5425602DA0EE1", hash_generated_method = "E0C350F676C97A8D77039E74819DDED3")
            
@Override public void addPrintJobStateChangeListener(android.print.IPrintJobStateChangeListener listener, int appId, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
_data.writeInt(appId);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_addPrintJobStateChangeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.740 -0400", hash_original_method = "DFD1639E6534AB121D792EFBAD8670C3", hash_generated_method = "DFB3A48ADDF4A51E02B3EE9B6C71E72F")
            
@Override public void removePrintJobStateChangeListener(android.print.IPrintJobStateChangeListener listener, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_removePrintJobStateChangeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.741 -0400", hash_original_method = "79BF4D1A51680FD427F7A0F3EFCEDA1E", hash_generated_method = "3B29B5E9C11E1600FA853B08B50E5F49")
            
@Override public java.util.List<android.printservice.PrintServiceInfo> getInstalledPrintServices(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.printservice.PrintServiceInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getInstalledPrintServices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.printservice.PrintServiceInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.742 -0400", hash_original_method = "0D98601BE6941CA5F330972788847828", hash_generated_method = "AD5C038574EF7BEFD8BC687468BB9700")
            
@Override public java.util.List<android.printservice.PrintServiceInfo> getEnabledPrintServices(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.printservice.PrintServiceInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getEnabledPrintServices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.printservice.PrintServiceInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.743 -0400", hash_original_method = "85BA4F4067DD5AF179C000FA76FF1BD2", hash_generated_method = "374D3C695927B9114E9B551FB29C4E00")
            
@Override public void createPrinterDiscoverySession(android.print.IPrinterDiscoveryObserver observer, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_createPrinterDiscoverySession, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.745 -0400", hash_original_method = "5CEF2D02B6BD5438C3BABB12471F8A7C", hash_generated_method = "602D8544AEA812FC7FFA9B879CC04AD9")
            
@Override public void startPrinterDiscovery(android.print.IPrinterDiscoveryObserver observer, java.util.List<android.print.PrinterId> priorityList, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeTypedList(priorityList);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_startPrinterDiscovery, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.746 -0400", hash_original_method = "BF580457FAD21AD4E6D88ADDA6D18DFA", hash_generated_method = "583B625A115355CBC6426A522F27256D")
            
@Override public void stopPrinterDiscovery(android.print.IPrinterDiscoveryObserver observer, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_stopPrinterDiscovery, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.747 -0400", hash_original_method = "90C3A4C12E1EB5B100DBA65796DB527C", hash_generated_method = "211526FF2348744D112CC34597AA7B1B")
            
@Override public void validatePrinters(java.util.List<android.print.PrinterId> printerIds, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(printerIds);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_validatePrinters, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.749 -0400", hash_original_method = "8BAA9C8B07F3CCAEC3DF95E768571E6D", hash_generated_method = "6857DD8A286E455A6FC8EB969024CD31")
            
@Override public void startPrinterStateTracking(android.print.PrinterId printerId, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printerId!=null)) {
_data.writeInt(1);
printerId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_startPrinterStateTracking, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.750 -0400", hash_original_method = "FE957F6E376617613F96A4806450A947", hash_generated_method = "B34868EFABE86A3ABCA0DEEF6108FE1A")
            
@Override public void stopPrinterStateTracking(android.print.PrinterId printerId, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((printerId!=null)) {
_data.writeInt(1);
printerId.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_stopPrinterStateTracking, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.752 -0400", hash_original_method = "51E88DD9BB7C63010EF9D8F69421EB87", hash_generated_method = "F465C6D9C18DCBD292A5022AA09544E7")
            
@Override public void destroyPrinterDiscoverySession(android.print.IPrinterDiscoveryObserver observer, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_destroyPrinterDiscoverySession, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.758 -0400", hash_original_field = "B2A7E8DA4737B377CA15B15AEFCDE445", hash_generated_field = "73A2A7B365621D14C4C159F924D35C26")

static final int TRANSACTION_cancelPrintJob = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.759 -0400", hash_original_field = "046DE9C0367B24B22A4B64B0F3D36FC8", hash_generated_field = "8C80071807289D04902B0EC697A6F918")

static final int TRANSACTION_restartPrintJob = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.760 -0400", hash_original_field = "FB5D2ABA24DFC7C4A6488914EE6DC70D", hash_generated_field = "E8193AE461AC49E96B457CC7F7E7C08F")

static final int TRANSACTION_addPrintJobStateChangeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.760 -0400", hash_original_field = "812E414177F4B243C202D75C3AA988FA", hash_generated_field = "3434C14C21B9FB66874A2EDCD36924DC")

static final int TRANSACTION_removePrintJobStateChangeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.761 -0400", hash_original_field = "E5B0B330BF730BFD93389FA48E6AB2EC", hash_generated_field = "AD7CA758C7741B772D2B12E18F1E89D1")

static final int TRANSACTION_getInstalledPrintServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.762 -0400", hash_original_field = "90A541A7B822363DD64D160119FE948A", hash_generated_field = "A3F71E0EEC3E290F2D2175995CE70AEA")

static final int TRANSACTION_getEnabledPrintServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.763 -0400", hash_original_field = "6B19E3822E7AFC4D3283B0B2F1A7AE40", hash_generated_field = "1ADD409B8AFAAD60465188322F1AA0FD")

static final int TRANSACTION_createPrinterDiscoverySession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.764 -0400", hash_original_field = "9E4770422F7B9E85950F6333C22E8107", hash_generated_field = "77C8067B712B1CE3A995F2C74EAA77D5")

static final int TRANSACTION_startPrinterDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.765 -0400", hash_original_field = "EFFD3C120D00950356862D8C74F8A3C6", hash_generated_field = "ED5B5BE7F052A8C6A7517FBD19F30C52")

static final int TRANSACTION_stopPrinterDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.766 -0400", hash_original_field = "AB46E293C8ED6C4F2DE8B180CF83231F", hash_generated_field = "9320EAB3B686CCE8934DC5B75F3705FA")

static final int TRANSACTION_validatePrinters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.767 -0400", hash_original_field = "707FCBAC4F15279B90411E6F57EA268B", hash_generated_field = "95925CD7A893B2E17F1ADB04F931A919")

static final int TRANSACTION_startPrinterStateTracking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.768 -0400", hash_original_field = "F904BEE2A9F971CFAEDFB013879826DC", hash_generated_field = "28822D3692D575A88246C60ADA2E3976")

static final int TRANSACTION_stopPrinterStateTracking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.769 -0400", hash_original_field = "DD20464CFDF273BADAAFD3B3D99F0B58", hash_generated_field = "38CDB3D9DBAB9E204CC50B4F9FB5B11D")

static final int TRANSACTION_destroyPrinterDiscoverySession = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
/** Construct the stub at attach it to the interface. */
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.721 -0400", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.723 -0400", hash_original_method = "7D02DBE97AD2CBB8160830C3A5F89A61", hash_generated_method = "EB6F575215AD7615FF883B6856E9FBCC")
        
@Override public android.os.IBinder asBinder()
{
return this;
}
@DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.726 -0400", hash_original_method = "9CE64A2E25B37D2959F75F2013A9934D", hash_generated_method = "981529A495F997A2C82A53D0FFF4AFEC")
        
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getPrintJobInfos:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
java.util.List<android.print.PrintJobInfo> _result = this.getPrintJobInfos(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getPrintJobInfo:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.print.PrintJobInfo _result = this.getPrintJobInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_print:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.print.IPrintDocumentAdapter _arg1;
_arg1 = android.print.IPrintDocumentAdapter.Stub.asInterface(data.readStrongBinder());
android.print.PrintAttributes _arg2;
if ((0!=data.readInt())) {
_arg2 = android.print.PrintAttributes.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
java.lang.String _arg3;
_arg3 = data.readString();
int _arg4;
_arg4 = data.readInt();
int _arg5;
_arg5 = data.readInt();
android.os.Bundle _result = this.print(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_cancelPrintJob:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.cancelPrintJob(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_restartPrintJob:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrintJobId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrintJobId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.restartPrintJob(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_addPrintJobStateChangeListener:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrintJobStateChangeListener _arg0;
_arg0 = android.print.IPrintJobStateChangeListener.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.addPrintJobStateChangeListener(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_removePrintJobStateChangeListener:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrintJobStateChangeListener _arg0;
_arg0 = android.print.IPrintJobStateChangeListener.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
this.removePrintJobStateChangeListener(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getInstalledPrintServices:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<android.printservice.PrintServiceInfo> _result = this.getInstalledPrintServices(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getEnabledPrintServices:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<android.printservice.PrintServiceInfo> _result = this.getEnabledPrintServices(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_createPrinterDiscoverySession:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrinterDiscoveryObserver _arg0;
_arg0 = android.print.IPrinterDiscoveryObserver.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
this.createPrinterDiscoverySession(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_startPrinterDiscovery:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrinterDiscoveryObserver _arg0;
_arg0 = android.print.IPrinterDiscoveryObserver.Stub.asInterface(data.readStrongBinder());
java.util.List<android.print.PrinterId> _arg1;
_arg1 = data.createTypedArrayList(android.print.PrinterId.CREATOR);
int _arg2;
_arg2 = data.readInt();
this.startPrinterDiscovery(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_stopPrinterDiscovery:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrinterDiscoveryObserver _arg0;
_arg0 = android.print.IPrinterDiscoveryObserver.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
this.stopPrinterDiscovery(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_validatePrinters:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.print.PrinterId> _arg0;
_arg0 = data.createTypedArrayList(android.print.PrinterId.CREATOR);
int _arg1;
_arg1 = data.readInt();
this.validatePrinters(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_startPrinterStateTracking:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrinterId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrinterId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.startPrinterStateTracking(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_stopPrinterStateTracking:
{
data.enforceInterface(DESCRIPTOR);
android.print.PrinterId _arg0;
if ((0!=data.readInt())) {
_arg0 = android.print.PrinterId.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.stopPrinterStateTracking(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_destroyPrinterDiscoverySession:
{
data.enforceInterface(DESCRIPTOR);
android.print.IPrinterDiscoveryObserver _arg0;
_arg0 = android.print.IPrinterDiscoveryObserver.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
this.destroyPrinterDiscoverySession(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
}
public java.util.List<android.print.PrintJobInfo> getPrintJobInfos(int appId, int userId) throws android.os.RemoteException;
public android.print.PrintJobInfo getPrintJobInfo(android.print.PrintJobId printJobId, int appId, int userId) throws android.os.RemoteException;
public android.os.Bundle print(java.lang.String printJobName, android.print.IPrintDocumentAdapter printAdapter, android.print.PrintAttributes attributes, java.lang.String packageName, int appId, int userId) throws android.os.RemoteException;
public void cancelPrintJob(android.print.PrintJobId printJobId, int appId, int userId) throws android.os.RemoteException;
public void restartPrintJob(android.print.PrintJobId printJobId, int appId, int userId) throws android.os.RemoteException;
public void addPrintJobStateChangeListener(android.print.IPrintJobStateChangeListener listener, int appId, int userId) throws android.os.RemoteException;
public void removePrintJobStateChangeListener(android.print.IPrintJobStateChangeListener listener, int userId) throws android.os.RemoteException;
public java.util.List<android.printservice.PrintServiceInfo> getInstalledPrintServices(int userId) throws android.os.RemoteException;
public java.util.List<android.printservice.PrintServiceInfo> getEnabledPrintServices(int userId) throws android.os.RemoteException;
public void createPrinterDiscoverySession(android.print.IPrinterDiscoveryObserver observer, int userId) throws android.os.RemoteException;
public void startPrinterDiscovery(android.print.IPrinterDiscoveryObserver observer, java.util.List<android.print.PrinterId> priorityList, int userId) throws android.os.RemoteException;
public void stopPrinterDiscovery(android.print.IPrinterDiscoveryObserver observer, int userId) throws android.os.RemoteException;
public void validatePrinters(java.util.List<android.print.PrinterId> printerIds, int userId) throws android.os.RemoteException;
public void startPrinterStateTracking(android.print.PrinterId printerId, int userId) throws android.os.RemoteException;
public void stopPrinterStateTracking(android.print.PrinterId printerId, int userId) throws android.os.RemoteException;
public void destroyPrinterDiscoverySession(android.print.IPrinterDiscoveryObserver observer, int userId) throws android.os.RemoteException;
}
