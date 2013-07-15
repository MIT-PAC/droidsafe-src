package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;

public class Binder implements IBinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.872 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.872 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "61E718D71E9BC4B7ED6B8BF7906FFCC9")

    private IInterface mOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.872 -0400", hash_original_field = "2C0F6C41CF17FD0929F458D2915A7B5A", hash_generated_field = "3A50F29FF34D11373125B8D4147870BB")

    private String mDescriptor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.872 -0400", hash_original_method = "E9C0CAF28240B0B259339EF455808C3F", hash_generated_method = "07296B8B833E8B9FAEFB65A7E920A6A3")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.874 -0400", hash_original_method = "FF7CD905415FB665DAB37EF33B177901", hash_generated_method = "5BF695834ED1F4897E138948DA6E35F1")
    public void attachInterface(IInterface owner, String descriptor) {
        mOwner = owner;
        mDescriptor = descriptor;
        // ---------- Original Method ----------
        //mOwner = owner;
        //mDescriptor = descriptor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.875 -0400", hash_original_method = "D3E904DAC6E3F35A0A15305E093649D7", hash_generated_method = "C653E9A874508059DAD8B890DB6201D7")
    public String getInterfaceDescriptor() {
String var180132377E6787EAA700529A4FAEA05D_897792298 =         mDescriptor;
        var180132377E6787EAA700529A4FAEA05D_897792298.addTaint(taint);
        return var180132377E6787EAA700529A4FAEA05D_897792298;
        // ---------- Original Method ----------
        //return mDescriptor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.875 -0400", hash_original_method = "A88E99F5157D576DA956A58D2E3E5765", hash_generated_method = "2FA1162E4538FFE65CDC25465B8A8D76")
    public boolean pingBinder() {
        boolean varB326B5062B2F0E69046810717534CB09_439025694 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156007838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156007838;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.875 -0400", hash_original_method = "7D2EC13EC2CD5238366DCA3903BB993E", hash_generated_method = "1F5D8F7814A9F0618C13CDF0A1F0EC7E")
    public boolean isBinderAlive() {
        boolean varB326B5062B2F0E69046810717534CB09_611878087 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669142714 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669142714;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.875 -0400", hash_original_method = "5F53634C89FC8CF0041CE9B2B1E024B8", hash_generated_method = "9411E8D49E6918144F71B023046DC653")
    public IInterface queryLocalInterface(String descriptor) {
        addTaint(descriptor.getTaint());
    if(mDescriptor.equals(descriptor))        
        {
IInterface var5F2C684ADE383867ABA7E337213B9967_2051689246 =             mOwner;
            var5F2C684ADE383867ABA7E337213B9967_2051689246.addTaint(taint);
            return var5F2C684ADE383867ABA7E337213B9967_2051689246;
        } //End block
IInterface var540C13E9E156B687226421B24F2DF178_1245817612 =         null;
        var540C13E9E156B687226421B24F2DF178_1245817612.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1245817612;
        // ---------- Original Method ----------
        //if (mDescriptor.equals(descriptor)) {
            //return mOwner;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.876 -0400", hash_original_method = "0CF6D9F1E08225F80F6CBB6DE559E3A9", hash_generated_method = "03B050CEBF78DD84B28D8D9ECD8822E5")
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
            boolean varB326B5062B2F0E69046810717534CB09_822056056 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98983528 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_98983528;
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
            boolean varB326B5062B2F0E69046810717534CB09_455445751 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1726138530 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1726138530;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1549715337 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837521687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837521687;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.877 -0400", hash_original_method = "062423BD3F619586ADD6FBBF398B1A78", hash_generated_method = "3B899D1EA7118170BAC1FB60B2973AB7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.878 -0400", hash_original_method = "43E702619EA899B9933A99C2C1DACCB9", hash_generated_method = "302C6D0A05023EC2F6B1751DD6724B87")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.878 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "9AFAE328FE6D74207D92B4DA0CDEEBF6")
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fout.getTaint());
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.878 -0400", hash_original_method = "45A6F1E38538846BA699CFB220CE3AE3", hash_generated_method = "9A56F266D7528F749417D06C60F9287D")
    public final boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
    if(false){ }    if(data != null)        
        {
            data.setDataPosition(0);
        } //End block
        boolean r = onTransact(code, data, reply, flags);
    if(reply != null)        
        {
            reply.setDataPosition(0);
        } //End block
        boolean var4B43B0AEE35624CD95B910189B3DC231_1632033604 = (r);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121608522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121608522;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.879 -0400", hash_original_method = "5287A3990077935C24A2BD79FED1C6A1", hash_generated_method = "9BCAA9AAAC7F98FB3E9A06E4226FA444")
    public void linkToDeath(DeathRecipient recipient, int flags) {
        addTaint(flags);
        addTaint(recipient.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.879 -0400", hash_original_method = "1A3BA6E0CCE3FB8650C7F390300799F7", hash_generated_method = "7D1E0A7FAB4C10F5F6CA2C5BDB3C01D2")
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        addTaint(flags);
        addTaint(recipient.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_321983130 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656459514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656459514;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.880 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "76851C627F983C777A1DF401ACFAAC11")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.880 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.880 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.881 -0400", hash_original_method = "F07199776E11DA2675C840AC9A2F2A30", hash_generated_method = "AA88AD93EA11C62E2C69153DD5E4AC38")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1580408626 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803925435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803925435;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.881 -0400", hash_original_field = "E98C260B28FA80AA89F6D5E5597392E0", hash_generated_field = "0511AC5400F6AB0B4374BEAACA5C07BE")

    private static final boolean FIND_POTENTIAL_LEAKS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.881 -0400", hash_original_field = "3147923060A83925CA1E6CB29A0BFBA4", hash_generated_field = "CF05878F048D3E24EFB57B124A2E1127")

    private static final String TAG = "Binder";
}

final class BinderProxy implements IBinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.881 -0400", hash_original_field = "9257B96EA3E776729E1D45E7076891EA", hash_generated_field = "4EB287DD111C153F1E6F56591B54BB33")

    private WeakReference mSelf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.881 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.881 -0400", hash_original_field = "7A99240C71EF7B6EAC5C9E1F77C8025D", hash_generated_field = "CAF41DA934E5052A723BB6FD5B0433F4")

    private int mOrgue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.881 -0400", hash_original_method = "6F2DE2B0944C9F00778B80C418D11418", hash_generated_method = "25943465C34F7314EF91831B1A064961")
      BinderProxy() {
        mSelf = new WeakReference(this);
        // ---------- Original Method ----------
        //mSelf = new WeakReference(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.882 -0400", hash_original_method = "3AAC7144F281FBB542DFC7EF6106B5C9", hash_generated_method = "64E89F74F458EAF26E79EFE1B97C57EA")
    public boolean pingBinder() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526295717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526295717;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.882 -0400", hash_original_method = "ACDA4E684B1D0EE78316DF741FE72AF5", hash_generated_method = "01B8FCD45C6D5DDE1B9E9DEAA6ECD400")
    public boolean isBinderAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598157614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_598157614;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.882 -0400", hash_original_method = "B707B72714522D5F23CBE8D4C77B554B", hash_generated_method = "26EA4ADB9A6E032F6416BD12B2A3C152")
    public IInterface queryLocalInterface(String descriptor) {
        addTaint(descriptor.getTaint());
IInterface var540C13E9E156B687226421B24F2DF178_596551353 =         null;
        var540C13E9E156B687226421B24F2DF178_596551353.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_596551353;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.883 -0400", hash_original_method = "2DB55944420A41A5CEDC8BE2777F8B50", hash_generated_method = "8CA42B3B4C541C236AF8DA37B5CD71CE")
    public boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844890067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844890067;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.883 -0400", hash_original_method = "9A12D44BC0A4F3509826AD7E16FA0EA1", hash_generated_method = "DD1A10A47FDF07625AD61BD782250D7D")
    public void linkToDeath(DeathRecipient recipient, int flags) throws RemoteException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.883 -0400", hash_original_method = "C682342F842ADE74AC6BCB96B6CECF17", hash_generated_method = "09B11EFC2A7F3842EFF72DEAAC1F65BA")
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1157736577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1157736577;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.883 -0400", hash_original_method = "C4F8E51C715A0CBA59E063E00B1AFC6F", hash_generated_method = "DD29D45FC0FE4908A7A5C6CC6E587981")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.884 -0400", hash_original_method = "07563DCFF6B89513E8E1D1CEF9639FFA", hash_generated_method = "2870CB085FDBF3EAA142B36322543782")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.884 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "633A9FB0E3D5B8AFD29FD7AA36FE9AB1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.884 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
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

