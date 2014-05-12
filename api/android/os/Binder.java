package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;

import android.util.Log;

import droidsafe.helpers.DSUtils;

public class Binder implements IBinder {
    
    public static final int getCallingPid() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213128804 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213128804;
    }
    
    public static final int getCallingUid() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889067269 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889067269;
    }
    
    public static final long clearCallingIdentity() {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1969549158 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1969549158;
    }
    
    public static final void restoreCallingIdentity(long token) {
    }
    
    public static final void setThreadStrictModePolicy(int policyMask) {
    }
    
    public static final int getThreadStrictModePolicy() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372633461 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372633461;
    }
    
    public static final void flushPendingCommands() {
    }
    
    public static final void joinThreadPool() {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.106 -0500", hash_original_field = "EF077B080E17BA8045DEC02712518733", hash_generated_field = "0511AC5400F6AB0B4374BEAACA5C07BE")

    private static final boolean FIND_POTENTIAL_LEAKS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.108 -0500", hash_original_field = "F78480768CA69FB7BD7DFE07AD3BF12B", hash_generated_field = "CF05878F048D3E24EFB57B124A2E1127")

    private static final String TAG = "Binder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.110 -0500", hash_original_field = "099BEA65529558F891E66B800CD4AD52", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.112 -0500", hash_original_field = "A7CA8FFEE56AE2617FD1EF74724DB612", hash_generated_field = "61E718D71E9BC4B7ED6B8BF7906FFCC9")

    private IInterface mOwner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.114 -0500", hash_original_field = "686FFA57469A563639011BAA8528B9E2", hash_generated_field = "3A50F29FF34D11373125B8D4147870BB")

    private String mDescriptor;
    
    /**
     * Default constructor initializes the object.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.148 -0500", hash_original_method = "E9C0CAF28240B0B259339EF455808C3F", hash_generated_method = "3D5C65FE180F867DB2040729AD77C600")
    
public Binder() {
        init();

        if (FIND_POTENTIAL_LEAKS) {
            final Class<? extends Binder> klass = getClass();
            if ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0) {
                Log.w(TAG, "The following Binder class should be static or leaks might occur: " +
                    klass.getCanonicalName());
            }
        }
    }
    
    /**
     * Convenience method for associating a specific interface with the Binder.
     * After calling, queryLocalInterface() will be implemented for you
     * to return the given owner IInterface when the corresponding
     * descriptor is requested.
     */
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.150 -0500", hash_original_method = "FF7CD905415FB665DAB37EF33B177901", hash_generated_method = "EA06BD2476989BF4DB475E54AC02F660")
    
public void attachInterface(IInterface owner, String descriptor) {
        mOwner = owner;
        mDescriptor = descriptor;
    }
    
    /**
     * Default implementation returns an empty interface name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.153 -0500", hash_original_method = "D3E904DAC6E3F35A0A15305E093649D7", hash_generated_method = "851E22E704239ADEFBCD1E61F06C7294")
    
public String getInterfaceDescriptor() {
        return mDescriptor;
    }

    /**
     * Default implementation always returns true -- if you got here,
     * the object is alive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.155 -0500", hash_original_method = "A88E99F5157D576DA956A58D2E3E5765", hash_generated_method = "9A600698D550F34B474DF10EC9B87548")
    
public boolean pingBinder() {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * Note that if you're calling on a local binder, this always returns true
     * because your process is alive if you're calling it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.157 -0500", hash_original_method = "7D2EC13EC2CD5238366DCA3903BB993E", hash_generated_method = "9C1F0417389951E88DFA30E9CC948A3F")
    
public boolean isBinderAlive() {
        return true;
    }
    
    /**
     * Use information supplied to attachInterface() to return the
     * associated IInterface if it matches the requested
     * descriptor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.159 -0500", hash_original_method = "5F53634C89FC8CF0041CE9B2B1E024B8", hash_generated_method = "C636C74DCE4A34923431FE496CBD3E65")
    
public IInterface queryLocalInterface(String descriptor) {
        if (mDescriptor.equals(descriptor)) {
            return mOwner;
        }
        return null;
    }
    
    /**
     * Default implementation is a stub that returns false.  You will want
     * to override this to do the appropriate unmarshalling of transactions.
     *
     * <p>If you want to call this, call transact().
     */
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.161 -0500", hash_original_method = "0CF6D9F1E08225F80F6CBB6DE559E3A9", hash_generated_method = "1C003B722C02AF5B148F4AC3DEDD3455")
    @DSVerified("called from transact")
protected boolean onTransact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        if (code == INTERFACE_TRANSACTION) {
            reply.writeString(getInterfaceDescriptor());
            return true;
        } else if (code == DUMP_TRANSACTION) {
            ParcelFileDescriptor fd = data.readFileDescriptor();
            String[] args = data.readStringArray();
            if (fd != null) {
                try {
                    dump(fd.getFileDescriptor(), args);
                } finally {
                    try {
                        fd.close();
                    } catch (IOException e) {
                        // swallowed, not propagated back to the caller
                    }
                }
            }
            // Write the StrictMode header.
            if (reply != null) {
                reply.writeNoException();
            } else {
                StrictMode.clearGatheredViolations();
            }
            return true;
        }
        return false;
    }

    /**
     * Implemented to call the more convenient version
     * {@link #dump(FileDescriptor, PrintWriter, String[])}.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.164 -0500", hash_original_method = "062423BD3F619586ADD6FBBF398B1A78", hash_generated_method = "A93C1D716934E3F725A1746D785E8C4E")
    
public void dump(FileDescriptor fd, String[] args) {
        fd.addTaint(getTaint());
        if (args != null)
            fd.addTaint(args[0].getTaint());
        /*
        FileOutputStream fout = new FileOutputStream(fd);
        PrintWriter pw = new PrintWriter(fout);
        try {
            dump(fd, pw, args);
        } finally {
            pw.flush();
        }
        */
    }
    
    /**
     * Like {@link #dump(FileDescriptor, String[])}, but ensures the target
     * executes asynchronously.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.169 -0500", hash_original_method = "43E702619EA899B9933A99C2C1DACCB9", hash_generated_method = "972C8DC111E0C75BBB8941828C7F350F")
    
public void dumpAsync(final FileDescriptor fd, final String[] args) {
        fd.addTaint(getTaint());
        if (args != null)
            fd.addTaint(args[0].getTaint());

        /*
        final FileOutputStream fout = new FileOutputStream(fd);
        final PrintWriter pw = new PrintWriter(fout);
        Thread thr = new Thread("Binder.dumpAsync") {
            public void run() {
                try {
                    dump(fd, pw, args);
                } finally {
                    pw.flush();
                }
            }
        };
        thr.start();
        */
    }

    /**
     * Print the object's state into the given stream.
     * 
     * @param fd The raw file descriptor that the dump is being sent to.
     * @param fout The file to which you should dump your state.  This will be
     * closed for you after you return.
     * @param args additional arguments to the dump request.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.172 -0500", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "F6D7C174AEA7671EB5A5529CC69A276B")
    
protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        fout.addTaint(fd.getTaintInt() + args[0].getTaintInt());
    }

    /**
     * Default implementation rewinds the parcels and calls onTransact.  On
     * the remote side, transact calls into the binder to do the IPC.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.175 -0500", hash_original_method = "45A6F1E38538846BA699CFB220CE3AE3", hash_generated_method = "DFD2A6D833E8FF563A6C31E0748E4021")
    @DSSpec(DSCat.SERIALIZATION)
    @DSVerified
public final boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        if (false) Log.v("Binder", "Transact: " + code + " to " + this);
        if (data != null) {
            data.setDataPosition(0);
        }
        boolean r = onTransact(code, data, reply, flags);
        if (reply != null) {
            reply.setDataPosition(0);
        }
        return r;
    }
    
    /**
     * Local implementation is a no-op.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.177 -0500", hash_original_method = "5287A3990077935C24A2BD79FED1C6A1", hash_generated_method = "24331F1DD3A548F079B4D04E636A5F9F")
    
public void linkToDeath(DeathRecipient recipient, int flags) {
    }

    /**
     * Local implementation is a no-op.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.179 -0500", hash_original_method = "1A3BA6E0CCE3FB8650C7F390300799F7", hash_generated_method = "5BBDF0A418ACAA1B6908C68F12A43E36")
    
public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        return true;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.182 -0500", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "D713F164488311AD375EE936C161E639")
    
protected void finalize() throws Throwable {
        /*
        try {
            destroy();
        } finally {
            super.finalize();
        }
        */
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.185 -0500", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "63B40292B395EEA932919999AB750BE0")
    
    private final void init(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.188 -0500", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "3A9765D4DB060B4FEE0666AA04B388EF")
    
    private final void destroy(){
    	//Formerly a native method
    }

    // Entry point from android_util_Binder.cpp's onTransact
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.191 -0500", hash_original_method = "F07199776E11DA2675C840AC9A2F2A30", hash_generated_method = "0587CA39AE5CA44638259C157AE9E508")
    
private boolean execTransact(int code, int dataObj, int replyObj,
            int flags) {
        Parcel data = Parcel.obtain(dataObj);
        Parcel reply = Parcel.obtain(replyObj);
        // theoretically, we should call transact, which will call onTransact,
        // but all that does is rewind it, and we just got these from an IPC,
        // so we'll just call it directly.
        boolean res;
        try {
            res = onTransact(code, data, reply, flags);
        } catch (RemoteException e) {
            reply.writeException(e);
            res = true;
        } catch (RuntimeException e) {
            reply.writeException(e);
            res = true;
        } catch (OutOfMemoryError e) {
            RuntimeException re = new RuntimeException("Out of memory", e);
            reply.writeException(re);
            res = true;
        }
        reply.recycle();
        data.recycle();
        return res;
    }
}

final class BinderProxy implements IBinder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.232 -0500", hash_original_method = "ED38B913C167A37A15CA15D403C1E80F", hash_generated_method = "986878FE3AE8FB0C51B7FDEE5BB0C195")
    
private static final void sendDeathNotice(DeathRecipient recipient) {
        if (false) Log.v("JavaBinder", "sendDeathNotice to " + recipient);
        try {
            recipient.binderDied();
        }
        catch (RuntimeException exc) {
            Log.w("BinderNative", "Uncaught exception from death notification",
                    exc);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.235 -0500", hash_original_field = "B6AD301DEBECEEA98E0E9725D5C64B16", hash_generated_field = "4EB287DD111C153F1E6F56591B54BB33")
    
     private WeakReference mSelf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.237 -0500", hash_original_field = "099BEA65529558F891E66B800CD4AD52", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.239 -0500", hash_original_field = "F3100D5FAEB265E763B5009309360DBB", hash_generated_field = "CAF41DA934E5052A723BB6FD5B0433F4")

    private int mOrgue;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.224 -0500", hash_original_method = "6F2DE2B0944C9F00778B80C418D11418", hash_generated_method = "6F2DE2B0944C9F00778B80C418D11418")
    
BinderProxy() {
        mSelf = new WeakReference(this);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.196 -0500", hash_original_method = "3AAC7144F281FBB542DFC7EF6106B5C9", hash_generated_method = "A497FD9FB9728B521D6700C152F64339")
    
    public boolean pingBinder(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.200 -0500", hash_original_method = "ACDA4E684B1D0EE78316DF741FE72AF5", hash_generated_method = "E4207F492E6DCF047D2677C31199E4F0")
    
    public boolean isBinderAlive(){
    	//Formerly a native method
    	return getTaintBoolean();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.202 -0500", hash_original_method = "B707B72714522D5F23CBE8D4C77B554B", hash_generated_method = "DB9A5309E19F1DA01E9E9CCD2E3F347D")
    
public IInterface queryLocalInterface(String descriptor) {
        return null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.892 -0400", hash_original_method = "6A74CDB8273CEC1C9569965EF003EFCB", hash_generated_method = "EA4B3F54BFD9578B1A4BA99DF2C0FDB9")
    public String getInterfaceDescriptor() throws RemoteException {
        String s = new String();
        s.addTaint(this.getTaint());
        return s;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.209 -0500", hash_original_method = "2DB55944420A41A5CEDC8BE2777F8B50", hash_generated_method = "D7176CFB390C114FB35EDCB077C2D1BA")
    
    public boolean transact(int code, Parcel data, Parcel reply,
                int flags) throws RemoteException{
    	//Formerly a native method
    	addTaint(code);
    	addTaint(data.getTaint());
    	addTaint(reply.getTaint());
    	addTaint(flags);
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.212 -0500", hash_original_method = "9A12D44BC0A4F3509826AD7E16FA0EA1", hash_generated_method = "2FD103B153D93F63BD283224EC0EA60C")
    
    public void linkToDeath(DeathRecipient recipient, int flags)
                throws RemoteException{
    	//Formerly a native method
    	addTaint(recipient.getTaint());
    	addTaint(flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.216 -0500", hash_original_method = "C682342F842ADE74AC6BCB96B6CECF17", hash_generated_method = "5DDA4B68258C92EEE11897BC5CBC0FCF")
    
    public boolean unlinkToDeath(DeathRecipient recipient, int flags){
    	//Formerly a native method
    	addTaint(recipient.getTaint());
    	addTaint(flags);
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.219 -0500", hash_original_method = "C4F8E51C715A0CBA59E063E00B1AFC6F", hash_generated_method = "D3572BDB8A72D93CE954CDFF82F510A1")
    
public void dump(FileDescriptor fd, String[] args) throws RemoteException {
        /*
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        try {
            transact(DUMP_TRANSACTION, data, reply, 0);
            reply.readException();
        } finally {
            data.recycle();
            reply.recycle();
        }
        */
        fd.addTaint(getTaint());
        if (args != null)
            fd.addTaint(args[0].getTaint());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.221 -0500", hash_original_method = "07563DCFF6B89513E8E1D1CEF9639FFA", hash_generated_method = "C791514F1AE69543F6D21AEC2A2A796F")
    
public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException {
        fd.addTaint(getTaint());
        if (args != null)
            fd.addTaint(args[0].getTaint());
       /* 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        try {
            transact(DUMP_TRANSACTION, data, reply, FLAG_ONEWAY);
            reply.readException();
        } finally {
            data.recycle();
            reply.recycle();
        }
        */
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.226 -0500", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "A5E9738289C22E874EDDA2DFBEABCF79")
    
@Override
    protected void finalize() throws Throwable {
        /*
        try {
            destroy();
        } finally {
            super.finalize();
        }
        */
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.230 -0500", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "3A9765D4DB060B4FEE0666AA04B388EF")
    
    private final void destroy(){
    	//Formerly a native method
    }
    
}

