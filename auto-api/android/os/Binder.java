package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;

public class Binder implements IBinder {
    private static final boolean FIND_POTENTIAL_LEAKS = false;
    private static final String TAG = "Binder";
    private int mObject;
    private IInterface mOwner;
    private String mDescriptor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "E9C0CAF28240B0B259339EF455808C3F", hash_generated_method = "8AE550F267F8367378D7C17269C2C29A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Binder() {
        init();
        {
            final Class<? extends Binder> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_1558882852 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "71A0E2F872338404194717981CE64A2B", hash_generated_method = "9F4DAFB6A3D04CA2B877B511EE92E489")
    public static final int getCallingPid() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "7614E6A02CF93B5C0C58345F6C636207", hash_generated_method = "F3251076ECF4E4F9E909EE7A3F8D8A72")
    public static final int getCallingUid() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "510ADEDD6430B9BE0A41F7F7C7CF9194", hash_generated_method = "74FC09E72CCF057B7881813A90D3EF40")
    public static final long clearCallingIdentity() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "5BD87FC104F6ED551725ABFA0C2ABECF", hash_generated_method = "ADA9B763ABB4B40401D0C8BFE75E72F5")
    public static final void restoreCallingIdentity(long token) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "673031E01009A648DBA64FAD555384A1", hash_generated_method = "FEA953A765F4CA72287FAB36728BA8CF")
    public static final void setThreadStrictModePolicy(int policyMask) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "0627301764F03D9B90C1A0B10D5AEC3C", hash_generated_method = "21B0079FB70499EF9AC84AE2904219EC")
    public static final int getThreadStrictModePolicy() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "E934A6F85889769D1A0D3661C32D4F39", hash_generated_method = "985797BC9ADD31EF3993642FF1BE13B5")
    public static final void flushPendingCommands() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "EFAEF866E392CFE9D06D530B612DCBC0", hash_generated_method = "00D2F864834569F64735BEABC1AFC69A")
    public static final void joinThreadPool() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.530 -0400", hash_original_method = "FF7CD905415FB665DAB37EF33B177901", hash_generated_method = "93EFAA29AA2B3CA5D806FE08D513346C")
    @DSModeled(DSC.SAFE)
    public void attachInterface(IInterface owner, String descriptor) {
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(owner.dsTaint);
        // ---------- Original Method ----------
        //mOwner = owner;
        //mDescriptor = descriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.531 -0400", hash_original_method = "D3E904DAC6E3F35A0A15305E093649D7", hash_generated_method = "7C30F799E866F3F8FF91A71C2F89E6CF")
    @DSModeled(DSC.SAFE)
    public String getInterfaceDescriptor() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDescriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.531 -0400", hash_original_method = "A88E99F5157D576DA956A58D2E3E5765", hash_generated_method = "C76EEBA91717B4DB05F6EFD83A359B76")
    @DSModeled(DSC.SAFE)
    public boolean pingBinder() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.531 -0400", hash_original_method = "7D2EC13EC2CD5238366DCA3903BB993E", hash_generated_method = "B34431E306F991DAEBD658826C3B583C")
    @DSModeled(DSC.SAFE)
    public boolean isBinderAlive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.531 -0400", hash_original_method = "5F53634C89FC8CF0041CE9B2B1E024B8", hash_generated_method = "7DDA25CD9A089FF8400D8C1CA587E63C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IInterface queryLocalInterface(String descriptor) {
        dsTaint.addTaint(descriptor);
        {
            boolean varAC889952CAA6B5EA32D96EF8D1FD3668_15430630 = (mDescriptor.equals(descriptor));
        } //End collapsed parenthetic
        return (IInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mDescriptor.equals(descriptor)) {
            //return mOwner;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.531 -0400", hash_original_method = "0CF6D9F1E08225F80F6CBB6DE559E3A9", hash_generated_method = "E6729CDFFEB8454968AE57FBE54170FB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.531 -0400", hash_original_method = "062423BD3F619586ADD6FBBF398B1A78", hash_generated_method = "127FF807E318840AFAE972A6C5E8C284")
    @DSModeled(DSC.SAFE)
    public void dump(FileDescriptor fd, String[] args) {
        dsTaint.addTaint(args);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.532 -0400", hash_original_method = "43E702619EA899B9933A99C2C1DACCB9", hash_generated_method = "CA03DFD46ED72E1DD3663C3AE144C009")
    @DSModeled(DSC.SAFE)
    public void dumpAsync(final FileDescriptor fd, final String[] args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(fd.dsTaint);
        final FileOutputStream fout;
        fout = new FileOutputStream(fd);
        final PrintWriter pw;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.532 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "A9C201DE0F3FDDCBBE6BCD1CD980D7B6")
    @DSModeled(DSC.SAFE)
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args);
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.532 -0400", hash_original_method = "45A6F1E38538846BA699CFB220CE3AE3", hash_generated_method = "ACD5489546427BDC0876A9FBF1B0DB91")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.532 -0400", hash_original_method = "5287A3990077935C24A2BD79FED1C6A1", hash_generated_method = "7FE04B3D335415E34029EBC7AFC0B9D4")
    @DSModeled(DSC.SAFE)
    public void linkToDeath(DeathRecipient recipient, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(recipient.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.532 -0400", hash_original_method = "1A3BA6E0CCE3FB8650C7F390300799F7", hash_generated_method = "F954FE028805C9D91669DD21AAE6027F")
    @DSModeled(DSC.SAFE)
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(recipient.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.532 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "345DF44A6204CC8424F6BC56F3883604")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.532 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "4B1E98977D3F64984DAB4C3850F81BB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.532 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "69B84BC3B1EA0628B8FAFB6B271248C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.533 -0400", hash_original_method = "F07199776E11DA2675C840AC9A2F2A30", hash_generated_method = "B89597E50F43CCB26FF3D8B8E0413B2D")
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

    
}

final class BinderProxy implements IBinder {
    final private WeakReference mSelf;
    private int mObject;
    private int mOrgue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.533 -0400", hash_original_method = "6F2DE2B0944C9F00778B80C418D11418", hash_generated_method = "D5E8BE923EC4EC4CFDE548BF90C009E0")
    @DSModeled(DSC.SAFE)
     BinderProxy() {
        mSelf = new WeakReference(this);
        // ---------- Original Method ----------
        //mSelf = new WeakReference(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.533 -0400", hash_original_method = "3AAC7144F281FBB542DFC7EF6106B5C9", hash_generated_method = "0A0AE5B14A516A45AF7E3DCC3F3F5283")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pingBinder() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.533 -0400", hash_original_method = "ACDA4E684B1D0EE78316DF741FE72AF5", hash_generated_method = "1C825D36B5D0828924966D04B97F355B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBinderAlive() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.534 -0400", hash_original_method = "B707B72714522D5F23CBE8D4C77B554B", hash_generated_method = "2E363393258D6DA276B70A60436511C9")
    @DSModeled(DSC.SAFE)
    public IInterface queryLocalInterface(String descriptor) {
        dsTaint.addTaint(descriptor);
        return (IInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.534 -0400", hash_original_method = "6A74CDB8273CEC1C9569965EF003EFCB", hash_generated_method = "B8F5FB4C2693DB98FE19BAB0C788D4E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getInterfaceDescriptor() throws RemoteException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.534 -0400", hash_original_method = "2DB55944420A41A5CEDC8BE2777F8B50", hash_generated_method = "A2098743E14E096CFF165CF523511255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.534 -0400", hash_original_method = "9A12D44BC0A4F3509826AD7E16FA0EA1", hash_generated_method = "90B2DCB9585141BF3B68914DD9837DE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void linkToDeath(DeathRecipient recipient, int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(recipient.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.534 -0400", hash_original_method = "C682342F842ADE74AC6BCB96B6CECF17", hash_generated_method = "ED0DC86797B8E07A5A3FFF570DE17CD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(recipient.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.535 -0400", hash_original_method = "C4F8E51C715A0CBA59E063E00B1AFC6F", hash_generated_method = "092CCD873131ADE0B86A37C2A5742D14")
    @DSModeled(DSC.SAFE)
    public void dump(FileDescriptor fd, String[] args) throws RemoteException {
        dsTaint.addTaint(args);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.535 -0400", hash_original_method = "07563DCFF6B89513E8E1D1CEF9639FFA", hash_generated_method = "A2ED3117D510B5C600118A113115EB28")
    @DSModeled(DSC.SAFE)
    public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException {
        dsTaint.addTaint(args);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.535 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "ED012FF96D8C5CAEB4ECE50C9AE22182")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.535 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "69B84BC3B1EA0628B8FAFB6B271248C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.536 -0400", hash_original_method = "ED38B913C167A37A15CA15D403C1E80F", hash_generated_method = "986878FE3AE8FB0C51B7FDEE5BB0C195")
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


