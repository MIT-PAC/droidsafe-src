package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;

public class Binder implements IBinder {
    private int mObject;
    private IInterface mOwner;
    private String mDescriptor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.341 -0400", hash_original_method = "E9C0CAF28240B0B259339EF455808C3F", hash_generated_method = "76D7824D2E352E82B8ED03E3217606E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Binder() {
        init();
        {
            Class<? extends Binder> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_319825139 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //init();
        //if (FIND_POTENTIAL_LEAKS) {
            //final Class<? extends Binder> klass = getClass();
            //if ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    //(klass.getModifiers() & Modifier.STATIC) == 0) {
                //Log.w(TAG, "The following Binder class should be static or leaks might occur: " +
                    //klass.getCanonicalName());
            //}
        //}
    }

    
        public static final int getCallingPid() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int getCallingUid() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final long clearCallingIdentity() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static final void restoreCallingIdentity(long token) {
    }

    
        public static final void setThreadStrictModePolicy(int policyMask) {
    }

    
        public static final int getThreadStrictModePolicy() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final void flushPendingCommands() {
    }

    
        public static final void joinThreadPool() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.342 -0400", hash_original_method = "FF7CD905415FB665DAB37EF33B177901", hash_generated_method = "2183E5A27F14009EBE6F7E52068C038D")
    @DSModeled(DSC.SAFE)
    public void attachInterface(IInterface owner, String descriptor) {
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(owner.dsTaint);
        // ---------- Original Method ----------
        //mOwner = owner;
        //mDescriptor = descriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.343 -0400", hash_original_method = "D3E904DAC6E3F35A0A15305E093649D7", hash_generated_method = "83183C380EF0E1DD60C7124FC417EDAD")
    @DSModeled(DSC.SAFE)
    public String getInterfaceDescriptor() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDescriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.343 -0400", hash_original_method = "A88E99F5157D576DA956A58D2E3E5765", hash_generated_method = "1FD167A5035771C88F0EB43961230542")
    @DSModeled(DSC.SAFE)
    public boolean pingBinder() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.343 -0400", hash_original_method = "7D2EC13EC2CD5238366DCA3903BB993E", hash_generated_method = "00CB2710171EE1936578E14080DB72E9")
    @DSModeled(DSC.SAFE)
    public boolean isBinderAlive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.343 -0400", hash_original_method = "5F53634C89FC8CF0041CE9B2B1E024B8", hash_generated_method = "984E82073EE8A06BF08DCB7585776FB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IInterface queryLocalInterface(String descriptor) {
        dsTaint.addTaint(descriptor);
        {
            boolean varAC889952CAA6B5EA32D96EF8D1FD3668_703202855 = (mDescriptor.equals(descriptor));
        } //End collapsed parenthetic
        return (IInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mDescriptor.equals(descriptor)) {
            //return mOwner;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.344 -0400", hash_original_method = "0CF6D9F1E08225F80F6CBB6DE559E3A9", hash_generated_method = "374EB9FA39ECB9DCCCA4D27CF572060C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean onTransact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
        {
            reply.writeString(getInterfaceDescriptor());
        } //End block
        {
            ParcelFileDescriptor fd;
            fd = data.readFileDescriptor();
            String[] args;
            args = data.readStringArray();
            {
                try 
                {
                    dump(fd.getFileDescriptor(), args);
                } //End block
                finally 
                {
                    try 
                    {
                        fd.close();
                    } //End block
                    catch (IOException e)
                    { }
                } //End block
            } //End block
            {
                reply.writeNoException();
            } //End block
            {
                StrictMode.clearGatheredViolations();
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.344 -0400", hash_original_method = "062423BD3F619586ADD6FBBF398B1A78", hash_generated_method = "554BD91D6D505FC48223636D9783E656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(FileDescriptor fd, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        FileOutputStream fout;
        fout = new FileOutputStream(fd);
        PrintWriter pw;
        pw = new PrintWriter(fout);
        try 
        {
            dump(fd, pw, args);
        } //End block
        finally 
        {
            pw.flush();
        } //End block
        // ---------- Original Method ----------
        //FileOutputStream fout = new FileOutputStream(fd);
        //PrintWriter pw = new PrintWriter(fout);
        //try {
            //dump(fd, pw, args);
        //} finally {
            //pw.flush();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.344 -0400", hash_original_method = "43E702619EA899B9933A99C2C1DACCB9", hash_generated_method = "8BD7B2458CB1823582BFF1505F67ED50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpAsync(final FileDescriptor fd, final String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        FileOutputStream fout;
        fout = new FileOutputStream(fd);
        PrintWriter pw;
        pw = new PrintWriter(fout);
        Thread thr;
        thr = new Thread("Binder.dumpAsync") {
            public void run() {
                try {
                    dump(fd, pw, args);
                } finally {
                    pw.flush();
                }
            }
        };
        thr.start();
        // ---------- Original Method ----------
        //final FileOutputStream fout = new FileOutputStream(fd);
        //final PrintWriter pw = new PrintWriter(fout);
        //Thread thr = new Thread("Binder.dumpAsync") {
            //public void run() {
                //try {
                    //dump(fd, pw, args);
                //} finally {
                    //pw.flush();
                //}
            //}
        //};
        //thr.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.344 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "5DCAAF4A6D4E4FDA6A2EF6B8DA4BD614")
    @DSModeled(DSC.SAFE)
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.345 -0400", hash_original_method = "45A6F1E38538846BA699CFB220CE3AE3", hash_generated_method = "4B4AE489838315269C4C6D911A7B3A05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
        {
            data.setDataPosition(0);
        } //End block
        boolean r;
        r = onTransact(code, data, reply, flags);
        {
            reply.setDataPosition(0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (false) Log.v("Binder", "Transact: " + code + " to " + this);
        //if (data != null) {
            //data.setDataPosition(0);
        //}
        //boolean r = onTransact(code, data, reply, flags);
        //if (reply != null) {
            //reply.setDataPosition(0);
        //}
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.345 -0400", hash_original_method = "5287A3990077935C24A2BD79FED1C6A1", hash_generated_method = "4B612537749EA12B5FEB760633A59509")
    @DSModeled(DSC.SAFE)
    public void linkToDeath(DeathRecipient recipient, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(recipient.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.346 -0400", hash_original_method = "1A3BA6E0CCE3FB8650C7F390300799F7", hash_generated_method = "3E3F3C29EC1C3E85F33D2DF0ECEB3EF1")
    @DSModeled(DSC.SAFE)
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(recipient.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.346 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "76851C627F983C777A1DF401ACFAAC11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        try 
        {
            destroy();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //destroy();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.346 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.347 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.347 -0400", hash_original_method = "F07199776E11DA2675C840AC9A2F2A30", hash_generated_method = "9B53DC938B45A2010217175198FB5E33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean execTransact(int code, int dataObj, int replyObj,
            int flags) {
        dsTaint.addTaint(dataObj);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(replyObj);
        dsTaint.addTaint(code);
        Parcel data;
        data = Parcel.obtain(dataObj);
        Parcel reply;
        reply = Parcel.obtain(replyObj);
        boolean res;
        try 
        {
            res = onTransact(code, data, reply, flags);
        } //End block
        catch (RemoteException e)
        {
            reply.writeException(e);
            res = true;
        } //End block
        catch (RuntimeException e)
        {
            reply.writeException(e);
            res = true;
        } //End block
        catch (OutOfMemoryError e)
        {
            RuntimeException re;
            re = new RuntimeException("Out of memory", e);
            reply.writeException(re);
            res = true;
        } //End block
        reply.recycle();
        data.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain(dataObj);
        //Parcel reply = Parcel.obtain(replyObj);
        //boolean res;
        //try {
            //res = onTransact(code, data, reply, flags);
        //} catch (RemoteException e) {
            //reply.writeException(e);
            //res = true;
        //} catch (RuntimeException e) {
            //reply.writeException(e);
            //res = true;
        //} catch (OutOfMemoryError e) {
            //RuntimeException re = new RuntimeException("Out of memory", e);
            //reply.writeException(re);
            //res = true;
        //}
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    private static final boolean FIND_POTENTIAL_LEAKS = false;
    private static final String TAG = "Binder";
}

final class BinderProxy implements IBinder {
    private WeakReference mSelf;
    private int mObject;
    private int mOrgue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.348 -0400", hash_original_method = "6F2DE2B0944C9F00778B80C418D11418", hash_generated_method = "25943465C34F7314EF91831B1A064961")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BinderProxy() {
        mSelf = new WeakReference(this);
        // ---------- Original Method ----------
        //mSelf = new WeakReference(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.348 -0400", hash_original_method = "3AAC7144F281FBB542DFC7EF6106B5C9", hash_generated_method = "A290152F8883DDE9D02DA17F5F7990F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pingBinder() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.348 -0400", hash_original_method = "ACDA4E684B1D0EE78316DF741FE72AF5", hash_generated_method = "AAF9AA784C3770142A8ABC6E78253B8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBinderAlive() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.348 -0400", hash_original_method = "B707B72714522D5F23CBE8D4C77B554B", hash_generated_method = "9DED9584973EABF55ADE7B3D1FFB854F")
    @DSModeled(DSC.SAFE)
    public IInterface queryLocalInterface(String descriptor) {
        dsTaint.addTaint(descriptor);
        return (IInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.349 -0400", hash_original_method = "6A74CDB8273CEC1C9569965EF003EFCB", hash_generated_method = "979AEEA00D7ECAD1BA6C466AEF6C59B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getInterfaceDescriptor() throws RemoteException {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.349 -0400", hash_original_method = "2DB55944420A41A5CEDC8BE2777F8B50", hash_generated_method = "747339485B43CBE23BC824786FE14D82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.349 -0400", hash_original_method = "9A12D44BC0A4F3509826AD7E16FA0EA1", hash_generated_method = "AE87C3A559F2C3E76C48E55BD53477D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void linkToDeath(DeathRecipient recipient, int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(recipient.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.349 -0400", hash_original_method = "C682342F842ADE74AC6BCB96B6CECF17", hash_generated_method = "DECBF461D5D1CB5A790FEB23F4135DB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(recipient.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.350 -0400", hash_original_method = "C4F8E51C715A0CBA59E063E00B1AFC6F", hash_generated_method = "B8A3DCE6D2737458A4303F7AB6BBAE47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(FileDescriptor fd, String[] args) throws RemoteException {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        try 
        {
            transact(DUMP_TRANSACTION, data, reply, 0);
            reply.readException();
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeFileDescriptor(fd);
        //data.writeStringArray(args);
        //try {
            //transact(DUMP_TRANSACTION, data, reply, 0);
            //reply.readException();
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.350 -0400", hash_original_method = "07563DCFF6B89513E8E1D1CEF9639FFA", hash_generated_method = "96EF02E8015DFE081512CF1DE7623482")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        try 
        {
            transact(DUMP_TRANSACTION, data, reply, FLAG_ONEWAY);
            reply.readException();
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeFileDescriptor(fd);
        //data.writeStringArray(args);
        //try {
            //transact(DUMP_TRANSACTION, data, reply, FLAG_ONEWAY);
            //reply.readException();
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.350 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "633A9FB0E3D5B8AFD29FD7AA36FE9AB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            destroy();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //destroy();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.350 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void destroy() {
    }

    
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

    
}

