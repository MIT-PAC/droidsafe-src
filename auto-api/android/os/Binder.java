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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.441 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.441 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "61E718D71E9BC4B7ED6B8BF7906FFCC9")

    private IInterface mOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.441 -0400", hash_original_field = "2C0F6C41CF17FD0929F458D2915A7B5A", hash_generated_field = "3A50F29FF34D11373125B8D4147870BB")

    private String mDescriptor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.449 -0400", hash_original_method = "E9C0CAF28240B0B259339EF455808C3F", hash_generated_method = "A992C43716BC814BBDBB7286B55F5C67")
    public  Binder() {
        init();
        {
            Class<? extends Binder> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_998354753 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.468 -0400", hash_original_method = "FF7CD905415FB665DAB37EF33B177901", hash_generated_method = "5BF695834ED1F4897E138948DA6E35F1")
    public void attachInterface(IInterface owner, String descriptor) {
        mOwner = owner;
        mDescriptor = descriptor;
        // ---------- Original Method ----------
        //mOwner = owner;
        //mDescriptor = descriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.479 -0400", hash_original_method = "D3E904DAC6E3F35A0A15305E093649D7", hash_generated_method = "3ABE1DE4B3A77285C3DAED1FC5AA380F")
    public String getInterfaceDescriptor() {
        String varB4EAC82CA7396A68D541C85D26508E83_1406467679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1406467679 = mDescriptor;
        varB4EAC82CA7396A68D541C85D26508E83_1406467679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1406467679;
        // ---------- Original Method ----------
        //return mDescriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.479 -0400", hash_original_method = "A88E99F5157D576DA956A58D2E3E5765", hash_generated_method = "2D2D8A0A9C6228C00543C179294EB0CB")
    public boolean pingBinder() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766943545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766943545;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.480 -0400", hash_original_method = "7D2EC13EC2CD5238366DCA3903BB993E", hash_generated_method = "48F6B4D95DBD10EFF170AFB8D56CBC47")
    public boolean isBinderAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789045866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789045866;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.493 -0400", hash_original_method = "5F53634C89FC8CF0041CE9B2B1E024B8", hash_generated_method = "778D505F8630F993CCE0C33286E00FD9")
    public IInterface queryLocalInterface(String descriptor) {
        IInterface varB4EAC82CA7396A68D541C85D26508E83_258855935 = null; //Variable for return #1
        IInterface varB4EAC82CA7396A68D541C85D26508E83_720924182 = null; //Variable for return #2
        {
            boolean varAC889952CAA6B5EA32D96EF8D1FD3668_2128550624 = (mDescriptor.equals(descriptor));
            {
                varB4EAC82CA7396A68D541C85D26508E83_258855935 = mOwner;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_720924182 = null;
        addTaint(descriptor.getTaint());
        IInterface varA7E53CE21691AB073D9660D615818899_327996159; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_327996159 = varB4EAC82CA7396A68D541C85D26508E83_258855935;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_327996159 = varB4EAC82CA7396A68D541C85D26508E83_720924182;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_327996159.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_327996159;
        // ---------- Original Method ----------
        //if (mDescriptor.equals(descriptor)) {
            //return mOwner;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.495 -0400", hash_original_method = "0CF6D9F1E08225F80F6CBB6DE559E3A9", hash_generated_method = "AB5580400EC0D5004BF3B664369BE8AD")
    protected boolean onTransact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691357368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691357368;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.524 -0400", hash_original_method = "062423BD3F619586ADD6FBBF398B1A78", hash_generated_method = "BD1235BEC05EDBA950233232C8B35098")
    public void dump(FileDescriptor fd, String[] args) {
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
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        //FileOutputStream fout = new FileOutputStream(fd);
        //PrintWriter pw = new PrintWriter(fout);
        //try {
            //dump(fd, pw, args);
        //} finally {
            //pw.flush();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.525 -0400", hash_original_method = "43E702619EA899B9933A99C2C1DACCB9", hash_generated_method = "CCB7B6CC872244CD9D7B1DA05713A39B")
    public void dumpAsync(final FileDescriptor fd, final String[] args) {
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
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.531 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "7073B447CA06FAFA3E27794A988AC9A2")
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(fd.getTaint());
        addTaint(fout.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.555 -0400", hash_original_method = "45A6F1E38538846BA699CFB220CE3AE3", hash_generated_method = "E36093CE6CB6830AA6653A5DD9781DE9")
    public final boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        {
            data.setDataPosition(0);
        } //End block
        boolean r;
        r = onTransact(code, data, reply, flags);
        {
            reply.setDataPosition(0);
        } //End block
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221209793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221209793;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.555 -0400", hash_original_method = "5287A3990077935C24A2BD79FED1C6A1", hash_generated_method = "CC167B5BFB7B85B7310E9B2758108566")
    public void linkToDeath(DeathRecipient recipient, int flags) {
        addTaint(recipient.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.556 -0400", hash_original_method = "1A3BA6E0CCE3FB8650C7F390300799F7", hash_generated_method = "A797813705492F47B509EAE7162059D4")
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        addTaint(recipient.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1543335704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1543335704;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.556 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "76851C627F983C777A1DF401ACFAAC11")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.556 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.557 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.564 -0400", hash_original_method = "F07199776E11DA2675C840AC9A2F2A30", hash_generated_method = "0FCE2A1C62D6735F27EE01448EE6839A")
    private boolean execTransact(int code, int dataObj, int replyObj,
            int flags) {
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
        addTaint(code);
        addTaint(dataObj);
        addTaint(replyObj);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572896183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572896183;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.565 -0400", hash_original_field = "E98C260B28FA80AA89F6D5E5597392E0", hash_generated_field = "85F8EDE7194C9C1A1A22315BDC750456")

    private static boolean FIND_POTENTIAL_LEAKS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.565 -0400", hash_original_field = "3147923060A83925CA1E6CB29A0BFBA4", hash_generated_field = "64408B3CF5BD255BB0AAB899FDEE9605")

    private static String TAG = "Binder";
}

final class BinderProxy implements IBinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.565 -0400", hash_original_field = "9257B96EA3E776729E1D45E7076891EA", hash_generated_field = "4EB287DD111C153F1E6F56591B54BB33")

    private WeakReference mSelf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.565 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.565 -0400", hash_original_field = "7A99240C71EF7B6EAC5C9E1F77C8025D", hash_generated_field = "CAF41DA934E5052A723BB6FD5B0433F4")

    private int mOrgue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.596 -0400", hash_original_method = "6F2DE2B0944C9F00778B80C418D11418", hash_generated_method = "25943465C34F7314EF91831B1A064961")
      BinderProxy() {
        mSelf = new WeakReference(this);
        // ---------- Original Method ----------
        //mSelf = new WeakReference(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.597 -0400", hash_original_method = "3AAC7144F281FBB542DFC7EF6106B5C9", hash_generated_method = "08F8575012014FA7EB3FC995538CFAA9")
    public boolean pingBinder() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_14723798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_14723798;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.598 -0400", hash_original_method = "ACDA4E684B1D0EE78316DF741FE72AF5", hash_generated_method = "EF78D3D5F339D3A3A395D31D3AD4DA49")
    public boolean isBinderAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981309322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981309322;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.598 -0400", hash_original_method = "B707B72714522D5F23CBE8D4C77B554B", hash_generated_method = "4498982A468ED7CE4A097594F25548C1")
    public IInterface queryLocalInterface(String descriptor) {
        IInterface varB4EAC82CA7396A68D541C85D26508E83_827772963 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_827772963 = null;
        addTaint(descriptor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_827772963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_827772963;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.599 -0400", hash_original_method = "6A74CDB8273CEC1C9569965EF003EFCB", hash_generated_method = "EA4B3F54BFD9578B1A4BA99DF2C0FDB9")
    public String getInterfaceDescriptor() throws RemoteException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.600 -0400", hash_original_method = "2DB55944420A41A5CEDC8BE2777F8B50", hash_generated_method = "C08F6445CCCD1EF31928A7967A621DEC")
    public boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801909024 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801909024;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.623 -0400", hash_original_method = "9A12D44BC0A4F3509826AD7E16FA0EA1", hash_generated_method = "DD1A10A47FDF07625AD61BD782250D7D")
    public void linkToDeath(DeathRecipient recipient, int flags) throws RemoteException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.625 -0400", hash_original_method = "C682342F842ADE74AC6BCB96B6CECF17", hash_generated_method = "F442EBDB60074A772CB9D8AE3032C3B6")
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156954537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156954537;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.626 -0400", hash_original_method = "C4F8E51C715A0CBA59E063E00B1AFC6F", hash_generated_method = "E2AE7297509437A7BFBD7637F4443D39")
    public void dump(FileDescriptor fd, String[] args) throws RemoteException {
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
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.646 -0400", hash_original_method = "07563DCFF6B89513E8E1D1CEF9639FFA", hash_generated_method = "F98490350066FDC422F0CC22A9719963")
    public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException {
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
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.647 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "633A9FB0E3D5B8AFD29FD7AA36FE9AB1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.647 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
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

