package android.os;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;

import android.util.Log;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class Binder implements IBinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.674 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.674 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "61E718D71E9BC4B7ED6B8BF7906FFCC9")

    private IInterface mOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.674 -0400", hash_original_field = "2C0F6C41CF17FD0929F458D2915A7B5A", hash_generated_field = "3A50F29FF34D11373125B8D4147870BB")

    private String mDescriptor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.675 -0400", hash_original_method = "E9C0CAF28240B0B259339EF455808C3F", hash_generated_method = "07296B8B833E8B9FAEFB65A7E920A6A3")
    public  Binder() {
        init();
        if(FIND_POTENTIAL_LEAKS)        
        {
            final Class<? extends Binder> klass = getClass();
            if((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0)            
            {
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    public static final int getCallingPid() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213128804 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213128804;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getCallingUid() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889067269 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889067269;
    }

    
    @DSModeled(DSC.SAFE)
    public static final long clearCallingIdentity() {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1969549158 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1969549158;
    }

    
    @DSModeled(DSC.SAFE)
    public static final void restoreCallingIdentity(long token) {
    }

    
    @DSModeled(DSC.SAFE)
    public static final void setThreadStrictModePolicy(int policyMask) {
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getThreadStrictModePolicy() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372633461 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372633461;
    }

    
    @DSModeled(DSC.SAFE)
    public static final void flushPendingCommands() {
    }

    
    @DSModeled(DSC.SAFE)
    public static final void joinThreadPool() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.678 -0400", hash_original_method = "FF7CD905415FB665DAB37EF33B177901", hash_generated_method = "5BF695834ED1F4897E138948DA6E35F1")
    public void attachInterface(IInterface owner, String descriptor) {
        mOwner = owner;
        mDescriptor = descriptor;
        // ---------- Original Method ----------
        //mOwner = owner;
        //mDescriptor = descriptor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.678 -0400", hash_original_method = "D3E904DAC6E3F35A0A15305E093649D7", hash_generated_method = "6CD8172D958C875FF4FBA59690B7F00E")
    public String getInterfaceDescriptor() {
String var180132377E6787EAA700529A4FAEA05D_1592533828 =         mDescriptor;
        var180132377E6787EAA700529A4FAEA05D_1592533828.addTaint(taint);
        return var180132377E6787EAA700529A4FAEA05D_1592533828;
        // ---------- Original Method ----------
        //return mDescriptor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.679 -0400", hash_original_method = "A88E99F5157D576DA956A58D2E3E5765", hash_generated_method = "40A050172645707C43543DB18DAB0996")
    public boolean pingBinder() {
        boolean varB326B5062B2F0E69046810717534CB09_1157041457 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281918952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281918952;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.679 -0400", hash_original_method = "7D2EC13EC2CD5238366DCA3903BB993E", hash_generated_method = "0A4D764FBCBAE4289D977512D676CE05")
    public boolean isBinderAlive() {
        boolean varB326B5062B2F0E69046810717534CB09_210788378 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752238043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752238043;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.679 -0400", hash_original_method = "5F53634C89FC8CF0041CE9B2B1E024B8", hash_generated_method = "284303DCC240B49B6CFEC7D736B67898")
    public IInterface queryLocalInterface(String descriptor) {
        addTaint(descriptor.getTaint());
        if(mDescriptor.equals(descriptor))        
        {
IInterface var5F2C684ADE383867ABA7E337213B9967_2058262874 =             mOwner;
            var5F2C684ADE383867ABA7E337213B9967_2058262874.addTaint(taint);
            return var5F2C684ADE383867ABA7E337213B9967_2058262874;
        } //End block
IInterface var540C13E9E156B687226421B24F2DF178_1703837821 =         null;
        var540C13E9E156B687226421B24F2DF178_1703837821.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1703837821;
        // ---------- Original Method ----------
        //if (mDescriptor.equals(descriptor)) {
            //return mOwner;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.680 -0400", hash_original_method = "0CF6D9F1E08225F80F6CBB6DE559E3A9", hash_generated_method = "DE0928A7DC2600F181BE28A66E84C301")
    protected boolean onTransact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
        if(code == INTERFACE_TRANSACTION)        
        {
            reply.writeString(getInterfaceDescriptor());
            boolean varB326B5062B2F0E69046810717534CB09_1998913075 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827992625 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_827992625;
        } //End block
        else
        if(code == DUMP_TRANSACTION)        
        {
            ParcelFileDescriptor fd = data.readFileDescriptor();
            String[] args = data.readStringArray();
            if(fd != null)            
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
                    {
                    } //End block
                } //End block
            } //End block
            if(reply != null)            
            {
                reply.writeNoException();
            } //End block
            else
            {
                StrictMode.clearGatheredViolations();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1363818083 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799183057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799183057;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_982782441 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205288554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_205288554;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.681 -0400", hash_original_method = "062423BD3F619586ADD6FBBF398B1A78", hash_generated_method = "3B899D1EA7118170BAC1FB60B2973AB7")
    public void dump(FileDescriptor fd, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fd.getTaint());
        FileOutputStream fout = new FileOutputStream(fd);
        PrintWriter pw = new PrintWriter(fout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.682 -0400", hash_original_method = "43E702619EA899B9933A99C2C1DACCB9", hash_generated_method = "302C6D0A05023EC2F6B1751DD6724B87")
    public void dumpAsync(final FileDescriptor fd, final String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fd.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.682 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "9AFAE328FE6D74207D92B4DA0CDEEBF6")
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fout.getTaint());
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.682 -0400", hash_original_method = "45A6F1E38538846BA699CFB220CE3AE3", hash_generated_method = "F1195C8E53319897CBB2331A495EF341")
    public final boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
        if(false){ }        if(data != null)        
        {
            data.setDataPosition(0);
        } //End block
        boolean r = onTransact(code, data, reply, flags);
        if(reply != null)        
        {
            reply.setDataPosition(0);
        } //End block
        boolean var4B43B0AEE35624CD95B910189B3DC231_1121882728 = (r);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104225288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_104225288;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.683 -0400", hash_original_method = "5287A3990077935C24A2BD79FED1C6A1", hash_generated_method = "9BCAA9AAAC7F98FB3E9A06E4226FA444")
    public void linkToDeath(DeathRecipient recipient, int flags) {
        addTaint(flags);
        addTaint(recipient.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.683 -0400", hash_original_method = "1A3BA6E0CCE3FB8650C7F390300799F7", hash_generated_method = "9664A897B4A6F7ADA4C2AF42C95F66D1")
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        addTaint(flags);
        addTaint(recipient.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1098680142 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351447570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_351447570;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.683 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "76851C627F983C777A1DF401ACFAAC11")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.683 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    private final void init() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.683 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.684 -0400", hash_original_method = "F07199776E11DA2675C840AC9A2F2A30", hash_generated_method = "9C5249DB831DD1E1E766BB85A1D08A51")
    private boolean execTransact(int code, int dataObj, int replyObj,
            int flags) {
        addTaint(flags);
        addTaint(replyObj);
        addTaint(dataObj);
        addTaint(code);
        Parcel data = Parcel.obtain(dataObj);
        Parcel reply = Parcel.obtain(replyObj);
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
            RuntimeException re = new RuntimeException("Out of memory", e);
            reply.writeException(re);
            res = true;
        } //End block
        reply.recycle();
        data.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_205768937 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1929339897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1929339897;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.685 -0400", hash_original_field = "E98C260B28FA80AA89F6D5E5597392E0", hash_generated_field = "0511AC5400F6AB0B4374BEAACA5C07BE")

    private static final boolean FIND_POTENTIAL_LEAKS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.685 -0400", hash_original_field = "3147923060A83925CA1E6CB29A0BFBA4", hash_generated_field = "CF05878F048D3E24EFB57B124A2E1127")

    private static final String TAG = "Binder";
}

final class BinderProxy implements IBinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.685 -0400", hash_original_field = "9257B96EA3E776729E1D45E7076891EA", hash_generated_field = "4EB287DD111C153F1E6F56591B54BB33")

    private WeakReference mSelf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.685 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.685 -0400", hash_original_field = "7A99240C71EF7B6EAC5C9E1F77C8025D", hash_generated_field = "CAF41DA934E5052A723BB6FD5B0433F4")

    private int mOrgue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.685 -0400", hash_original_method = "6F2DE2B0944C9F00778B80C418D11418", hash_generated_method = "25943465C34F7314EF91831B1A064961")
      BinderProxy() {
        mSelf = new WeakReference(this);
        // ---------- Original Method ----------
        //mSelf = new WeakReference(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.691 -0400", hash_original_method = "3AAC7144F281FBB542DFC7EF6106B5C9", hash_generated_method = "E22BBFEFF865843227B68C1B5CD393C1")
    public boolean pingBinder() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421038235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421038235;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.691 -0400", hash_original_method = "ACDA4E684B1D0EE78316DF741FE72AF5", hash_generated_method = "094E2C127F9AA154CB60C1D4116A68C0")
    public boolean isBinderAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715816387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715816387;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.692 -0400", hash_original_method = "B707B72714522D5F23CBE8D4C77B554B", hash_generated_method = "B3CA86098D1540903997732BE7339F33")
    public IInterface queryLocalInterface(String descriptor) {
        addTaint(descriptor.getTaint());
IInterface var540C13E9E156B687226421B24F2DF178_610493722 =         null;
        var540C13E9E156B687226421B24F2DF178_610493722.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_610493722;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.892 -0400", hash_original_method = "6A74CDB8273CEC1C9569965EF003EFCB", hash_generated_method = "EA4B3F54BFD9578B1A4BA99DF2C0FDB9")
    public String getInterfaceDescriptor() throws RemoteException {
        String s = new String();
        s.addTaint(this.taint);
        return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.693 -0400", hash_original_method = "2DB55944420A41A5CEDC8BE2777F8B50", hash_generated_method = "6D92FAB3373EDF8501939908D5643F55")
    public boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_220250176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_220250176;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.693 -0400", hash_original_method = "9A12D44BC0A4F3509826AD7E16FA0EA1", hash_generated_method = "DD1A10A47FDF07625AD61BD782250D7D")
    public void linkToDeath(DeathRecipient recipient, int flags) throws RemoteException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.694 -0400", hash_original_method = "C682342F842ADE74AC6BCB96B6CECF17", hash_generated_method = "EC3690BD0055C9D256F7AAF7EBAA237B")
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1492403580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1492403580;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.694 -0400", hash_original_method = "C4F8E51C715A0CBA59E063E00B1AFC6F", hash_generated_method = "DD29D45FC0FE4908A7A5C6CC6E587981")
    public void dump(FileDescriptor fd, String[] args) throws RemoteException {
        addTaint(args[0].getTaint());
        addTaint(fd.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.695 -0400", hash_original_method = "07563DCFF6B89513E8E1D1CEF9639FFA", hash_generated_method = "2870CB085FDBF3EAA142B36322543782")
    public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException {
        addTaint(args[0].getTaint());
        addTaint(fd.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.695 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "633A9FB0E3D5B8AFD29FD7AA36FE9AB1")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.695 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
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

