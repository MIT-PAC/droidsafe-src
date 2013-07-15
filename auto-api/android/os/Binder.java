package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;

public class Binder implements IBinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.881 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.881 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "61E718D71E9BC4B7ED6B8BF7906FFCC9")

    private IInterface mOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.881 -0400", hash_original_field = "2C0F6C41CF17FD0929F458D2915A7B5A", hash_generated_field = "3A50F29FF34D11373125B8D4147870BB")

    private String mDescriptor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.881 -0400", hash_original_method = "E9C0CAF28240B0B259339EF455808C3F", hash_generated_method = "DE7EBD09F2355E157FC00BD015B83C72")
    public  Binder() {
        init();
        {
            final Class<? extends Binder> klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_32510344 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } 
        } 
        
        
        
            
            
                    
                
                    
            
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.884 -0400", hash_original_method = "FF7CD905415FB665DAB37EF33B177901", hash_generated_method = "5BF695834ED1F4897E138948DA6E35F1")
    public void attachInterface(IInterface owner, String descriptor) {
        mOwner = owner;
        mDescriptor = descriptor;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.885 -0400", hash_original_method = "D3E904DAC6E3F35A0A15305E093649D7", hash_generated_method = "DAB8A0A5500D2396D10A4A8BD3067425")
    public String getInterfaceDescriptor() {
        String varB4EAC82CA7396A68D541C85D26508E83_721499694 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_721499694 = mDescriptor;
        varB4EAC82CA7396A68D541C85D26508E83_721499694.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_721499694;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.885 -0400", hash_original_method = "A88E99F5157D576DA956A58D2E3E5765", hash_generated_method = "089FF23EE3C2D7E7C3E78B9A062BD3E6")
    public boolean pingBinder() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443702916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_443702916;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.885 -0400", hash_original_method = "7D2EC13EC2CD5238366DCA3903BB993E", hash_generated_method = "7B8286C4C454E3B80695A5FE4F635D2D")
    public boolean isBinderAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300462126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300462126;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.886 -0400", hash_original_method = "5F53634C89FC8CF0041CE9B2B1E024B8", hash_generated_method = "CD4F2DCC77C780D6077483F692BF7349")
    public IInterface queryLocalInterface(String descriptor) {
        IInterface varB4EAC82CA7396A68D541C85D26508E83_684386959 = null; 
        IInterface varB4EAC82CA7396A68D541C85D26508E83_1262591166 = null; 
        {
            boolean varAC889952CAA6B5EA32D96EF8D1FD3668_1254902277 = (mDescriptor.equals(descriptor));
            {
                varB4EAC82CA7396A68D541C85D26508E83_684386959 = mOwner;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1262591166 = null;
        addTaint(descriptor.getTaint());
        IInterface varA7E53CE21691AB073D9660D615818899_1875617689; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1875617689 = varB4EAC82CA7396A68D541C85D26508E83_684386959;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1875617689 = varB4EAC82CA7396A68D541C85D26508E83_1262591166;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1875617689.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1875617689;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.886 -0400", hash_original_method = "0CF6D9F1E08225F80F6CBB6DE559E3A9", hash_generated_method = "8DEAFDC794B1C527E938DC9B5D00531E")
    protected boolean onTransact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        
        {
            reply.writeString(getInterfaceDescriptor());
        } 
        {
            ParcelFileDescriptor fd = data.readFileDescriptor();
            String[] args = data.readStringArray();
            {
                try 
                {
                    dump(fd.getFileDescriptor(), args);
                } 
                finally 
                {
                    try 
                    {
                        fd.close();
                    } 
                    catch (IOException e)
                    { }
                } 
            } 
            {
                reply.writeNoException();
            } 
            {
                StrictMode.clearGatheredViolations();
            } 
        } 
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894355740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894355740;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.887 -0400", hash_original_method = "062423BD3F619586ADD6FBBF398B1A78", hash_generated_method = "90C8107F3475545FAC381153D04B857F")
    public void dump(FileDescriptor fd, String[] args) {
        FileOutputStream fout = new FileOutputStream(fd);
        PrintWriter pw = new PrintWriter(fout);
        try 
        {
            dump(fd, pw, args);
        } 
        finally 
        {
            pw.flush();
        } 
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.887 -0400", hash_original_method = "43E702619EA899B9933A99C2C1DACCB9", hash_generated_method = "A75E5F1F2EA9B1135A15B86656C3FDD2")
    public void dumpAsync(final FileDescriptor fd, final String[] args) {
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
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
        
        
        
        
            
                
                    
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.888 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "7073B447CA06FAFA3E27794A988AC9A2")
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(fd.getTaint());
        addTaint(fout.getTaint());
        addTaint(args[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.888 -0400", hash_original_method = "45A6F1E38538846BA699CFB220CE3AE3", hash_generated_method = "4C9A68BBBEB47B5A6FA5A70E357D0473")
    public final boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        {
            data.setDataPosition(0);
        } 
        boolean r = onTransact(code, data, reply, flags);
        {
            reply.setDataPosition(0);
        } 
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174354369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174354369;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.888 -0400", hash_original_method = "5287A3990077935C24A2BD79FED1C6A1", hash_generated_method = "CC167B5BFB7B85B7310E9B2758108566")
    public void linkToDeath(DeathRecipient recipient, int flags) {
        addTaint(recipient.getTaint());
        addTaint(flags);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.889 -0400", hash_original_method = "1A3BA6E0CCE3FB8650C7F390300799F7", hash_generated_method = "82E2D3CE0FBFA95164C72DA48BED8390")
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        addTaint(recipient.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1137864336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1137864336;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.889 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "76851C627F983C777A1DF401ACFAAC11")
    protected void finalize() throws Throwable {
        try 
        {
            destroy();
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.889 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.890 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    private final void destroy() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.890 -0400", hash_original_method = "F07199776E11DA2675C840AC9A2F2A30", hash_generated_method = "90CDA9DE61641FB2AA1DE126B60EB81B")
    private boolean execTransact(int code, int dataObj, int replyObj,
            int flags) {
        Parcel data = Parcel.obtain(dataObj);
        Parcel reply = Parcel.obtain(replyObj);
        boolean res;
        try 
        {
            res = onTransact(code, data, reply, flags);
        } 
        catch (RemoteException e)
        {
            reply.writeException(e);
            res = true;
        } 
        catch (RuntimeException e)
        {
            reply.writeException(e);
            res = true;
        } 
        catch (OutOfMemoryError e)
        {
            RuntimeException re = new RuntimeException("Out of memory", e);
            reply.writeException(re);
            res = true;
        } 
        reply.recycle();
        data.recycle();
        addTaint(code);
        addTaint(dataObj);
        addTaint(replyObj);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270966486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270966486;
        
        
        
        
        
            
        
            
            
        
            
            
        
            
            
            
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.890 -0400", hash_original_field = "E98C260B28FA80AA89F6D5E5597392E0", hash_generated_field = "0511AC5400F6AB0B4374BEAACA5C07BE")

    private static final boolean FIND_POTENTIAL_LEAKS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.890 -0400", hash_original_field = "3147923060A83925CA1E6CB29A0BFBA4", hash_generated_field = "CF05878F048D3E24EFB57B124A2E1127")

    private static final String TAG = "Binder";

    
}

final class BinderProxy implements IBinder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.890 -0400", hash_original_field = "9257B96EA3E776729E1D45E7076891EA", hash_generated_field = "4EB287DD111C153F1E6F56591B54BB33")

    private WeakReference mSelf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.890 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.890 -0400", hash_original_field = "7A99240C71EF7B6EAC5C9E1F77C8025D", hash_generated_field = "CAF41DA934E5052A723BB6FD5B0433F4")

    private int mOrgue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.891 -0400", hash_original_method = "6F2DE2B0944C9F00778B80C418D11418", hash_generated_method = "25943465C34F7314EF91831B1A064961")
      BinderProxy() {
        mSelf = new WeakReference(this);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.891 -0400", hash_original_method = "3AAC7144F281FBB542DFC7EF6106B5C9", hash_generated_method = "53C41F6175ECAFB4E32532524F4C27C6")
    public boolean pingBinder() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847222688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847222688;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.891 -0400", hash_original_method = "ACDA4E684B1D0EE78316DF741FE72AF5", hash_generated_method = "2BE357C5049267C370620D25CED8E7E3")
    public boolean isBinderAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058012275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058012275;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.892 -0400", hash_original_method = "B707B72714522D5F23CBE8D4C77B554B", hash_generated_method = "F2297C22615DBC70547AD1480FF3CB52")
    public IInterface queryLocalInterface(String descriptor) {
        IInterface varB4EAC82CA7396A68D541C85D26508E83_900193361 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_900193361 = null;
        addTaint(descriptor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_900193361.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_900193361;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.892 -0400", hash_original_method = "6A74CDB8273CEC1C9569965EF003EFCB", hash_generated_method = "EA4B3F54BFD9578B1A4BA99DF2C0FDB9")
    public String getInterfaceDescriptor() throws RemoteException {
        String s = new String();
        s.addTaint(this.taint);
        return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.892 -0400", hash_original_method = "2DB55944420A41A5CEDC8BE2777F8B50", hash_generated_method = "2B3465173A61C82029167190CABE60E3")
    public boolean transact(int code, Parcel data, Parcel reply,
            int flags) throws RemoteException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1175268954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1175268954;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.892 -0400", hash_original_method = "9A12D44BC0A4F3509826AD7E16FA0EA1", hash_generated_method = "DD1A10A47FDF07625AD61BD782250D7D")
    public void linkToDeath(DeathRecipient recipient, int flags) throws RemoteException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.893 -0400", hash_original_method = "C682342F842ADE74AC6BCB96B6CECF17", hash_generated_method = "CBE1217C5334D90E5C1642B4A36A9EA4")
    public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370646914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370646914;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.893 -0400", hash_original_method = "C4F8E51C715A0CBA59E063E00B1AFC6F", hash_generated_method = "509BC3612AC68EC129B2CB3AC4F586C6")
    public void dump(FileDescriptor fd, String[] args) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        try 
        {
            transact(DUMP_TRANSACTION, data, reply, 0);
            reply.readException();
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
        
        
        
        
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.894 -0400", hash_original_method = "07563DCFF6B89513E8E1D1CEF9639FFA", hash_generated_method = "660996FBC68CD94F6BE3B54BCBDCB2EA")
    public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        try 
        {
            transact(DUMP_TRANSACTION, data, reply, FLAG_ONEWAY);
            reply.readException();
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
        
        
        
        
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.894 -0400", hash_original_method = "E45E17FA4DD489F5F777D118010D5B05", hash_generated_method = "633A9FB0E3D5B8AFD29FD7AA36FE9AB1")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            destroy();
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.895 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
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

