package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;

public class ParcelFileDescriptor implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.864 -0400", hash_original_field = "D118306A98C1E7C12AA828417A60A6F6", hash_generated_field = "58A1B3A123725E48931BD35C0EB2D4CB")

    private FileDescriptor mFileDescriptor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.864 -0400", hash_original_field = "C15A1B081B66F38188E926501ED5F8A7", hash_generated_field = "BD690B26D5468868AFAF08CAFB003D2A")

    private boolean mClosed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.864 -0400", hash_original_field = "7CE9BC3451B021C57B703C29E2527A74", hash_generated_field = "9AA0DA752DD4578B6A205C30B394DEF2")

    private ParcelFileDescriptor mParcelDescriptor;
    
    public ParcelFileDescriptor() {
    	
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.865 -0400", hash_original_method = "DB42A2A8BBE574C2950DCEEDDCE79B62", hash_generated_method = "0D84580F8C4180A00E40F7A16F093250")
    public  ParcelFileDescriptor(ParcelFileDescriptor descriptor) {
        super();
        mParcelDescriptor = descriptor;
        mFileDescriptor = mParcelDescriptor.mFileDescriptor;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.865 -0400", hash_original_method = "5987A31E1ECCB1911B1BA6CC4EEF72A2", hash_generated_method = "BCE3644BB6151AF5EE3D1F08790C958A")
      ParcelFileDescriptor(FileDescriptor descriptor) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("descriptor must not be null");
        } 
        mFileDescriptor = descriptor;
        mParcelDescriptor = null;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ParcelFileDescriptor open(File file, int mode) throws FileNotFoundException {
        String path = file.getPath();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(path);
            if ((mode&MODE_WRITE_ONLY) != 0) {
                security.checkWrite(path);
            }
        }
        if ((mode&MODE_READ_WRITE) == 0) {
            throw new IllegalArgumentException(
                    "Must specify MODE_READ_ONLY, MODE_WRITE_ONLY, or MODE_READ_WRITE");
        }
        FileDescriptor fd = Parcel.openFileDescriptor(path, mode);
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSModeled(DSC.SAFE)
    public static ParcelFileDescriptor dup(FileDescriptor orig) throws IOException {
        FileDescriptor fd = Parcel.dupFileDescriptor(orig);
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.866 -0400", hash_original_method = "474327607EE56B056BCE4043FE865D8B", hash_generated_method = "B58C9C3760BDF94893BEA57F32C2EDF0")
    public ParcelFileDescriptor dup() throws IOException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1249206110 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1249206110 = dup(getFileDescriptor());
        varB4EAC82CA7396A68D541C85D26508E83_1249206110.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1249206110;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ParcelFileDescriptor fromFd(int fd) throws IOException {
        FileDescriptor fdesc = getFileDescriptorFromFd(fd);
        return new ParcelFileDescriptor(fdesc);
    }

    
    @DSModeled(DSC.SAFE)
    private static FileDescriptor getFileDescriptorFromFd(int fd) throws IOException {
    	return new FileDescriptor();
    }

    
    @DSModeled(DSC.SAFE)
    public static ParcelFileDescriptor adoptFd(int fd) {
        FileDescriptor fdesc = getFileDescriptorFromFdNoDup(fd);
        return new ParcelFileDescriptor(fdesc);
    }

    
    @DSModeled(DSC.SAFE)
    private static FileDescriptor getFileDescriptorFromFdNoDup(int fd) {
    	return new FileDescriptor();
    }

    
    @DSModeled(DSC.SPEC)
    public static ParcelFileDescriptor fromSocket(Socket socket) {
        FileDescriptor fd = socket.getFileDescriptor$();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSModeled(DSC.SAFE)
    public static ParcelFileDescriptor fromDatagramSocket(DatagramSocket datagramSocket) {
        FileDescriptor fd = datagramSocket.getFileDescriptor$();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSModeled(DSC.SAFE)
    public static ParcelFileDescriptor[] createPipe() throws IOException {
        FileDescriptor[] fds = new FileDescriptor[2];
        createPipeNative(fds);
        ParcelFileDescriptor[] pfds = new ParcelFileDescriptor[2];
        pfds[0] = new ParcelFileDescriptor(fds[0]);
        pfds[1] = new ParcelFileDescriptor(fds[1]);
        return pfds;
    }

    
    @DSModeled(DSC.SAFE)
    private static void createPipeNative(FileDescriptor[] outFds) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static ParcelFileDescriptor fromData(byte[] data, String name) throws IOException {
        if (data == null) return null;
        MemoryFile file = new MemoryFile(name, data.length);
        if (data.length > 0) {
            file.writeBytes(data, 0, 0, data.length);
        }
        file.deactivate();
        FileDescriptor fd = file.getFileDescriptor();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.869 -0400", hash_original_method = "949276D2764A2C9DACACDE44898698C8", hash_generated_method = "81B2C01F95111840AFF626401A6B9D61")
    public FileDescriptor getFileDescriptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_735870705 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_735870705 = mFileDescriptor;
        varB4EAC82CA7396A68D541C85D26508E83_735870705.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_735870705;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.869 -0400", hash_original_method = "77F816B0B1C349FF3A8882E701737452", hash_generated_method = "C981594F427539FFDDED8184BFA5429B")
    public long getStatSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1921677362 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1921677362;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.869 -0400", hash_original_method = "0F9A3950A7A9E5BB31D919F8BB19673E", hash_generated_method = "306FF4C037CFBB17D9AF117D8E0F5FAA")
    public long seekTo(long pos) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2092852791 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2092852791;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.870 -0400", hash_original_method = "C747587E89EFBC650597F209F149B598", hash_generated_method = "8C2AC9AD04B8AD7CDA6E8DAAC23C212E")
    public int getFd() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already closed");
        } 
        int var751A6E18182434738AFEB29212FB434D_222888602 = (getFdNative());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1251663227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1251663227;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.870 -0400", hash_original_method = "48F8D374A617845984C88F484B28408C", hash_generated_method = "799DFD1DC96C2E8E03BB949B49D98303")
    private int getFdNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836281088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836281088;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.870 -0400", hash_original_method = "AECA8304F263BE3AD120D5996456D31E", hash_generated_method = "362763032FDCC525606D1DB6933FFD23")
    public int detachFd() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already closed");
        } 
        {
            int fd = mParcelDescriptor.detachFd();
            mClosed = true;
        } 
        int fd = getFd();
        mClosed = true;
        Parcel.clearFileDescriptor(mFileDescriptor);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126011799 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126011799;
        
        
            
        
        
            
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.871 -0400", hash_original_method = "39939000D7522F3E727F0E3243089AE5", hash_generated_method = "C93AE2836E4766793DDE4FD6C28D9C61")
    public void close() throws IOException {
        {
            mClosed = true;
        } 
        {
            mParcelDescriptor.close();
        } 
        {
            Parcel.closeFileDescriptor(mFileDescriptor);
        } 
        
        
            
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.871 -0400", hash_original_method = "BA9513A0FEF5B159A730B41F75EA216A", hash_generated_method = "BEBCFFBD3AF3CB61522B65F6D6BFB224")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_582510642 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_582510642 = "{ParcelFileDescriptor: " + mFileDescriptor + "}";
        varB4EAC82CA7396A68D541C85D26508E83_582510642.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_582510642;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.871 -0400", hash_original_method = "47AC631E45892E7E44A62B81BC7ACB91", hash_generated_method = "5BFFCB83F2EFF1414AF3C5F71AB87D6E")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                close();
            } 
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.872 -0400", hash_original_method = "5C5A30224996A2D414D9176559E683A9", hash_generated_method = "94F36844B5C38BB4D5F2304749BD2B8F")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117493792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117493792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.872 -0400", hash_original_method = "D9382402A3E15CFE2B7948813716CC7C", hash_generated_method = "A4060D8882E09B4E89CBADE79B077B5E")
    public void writeToParcel(Parcel out, int flags) {
        out.writeFileDescriptor(mFileDescriptor);
        {
            try 
            {
                close();
            } 
            catch (IOException e)
            { }
        } 
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
            
                
            
            
        
    }

    
    public static class AutoCloseInputStream extends FileInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.872 -0400", hash_original_field = "E2307FD862BA74C9C9C26ACA0B7E5364", hash_generated_field = "AE959CCFA06A07F93FA2A8BEED883021")

        private ParcelFileDescriptor mFd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.872 -0400", hash_original_method = "E3D4E7E6DEAE42263A4A251652766597", hash_generated_method = "4971668D7654AFFF55B2DDD509DBD7E3")
        public  AutoCloseInputStream(ParcelFileDescriptor fd) {
            super(fd.getFileDescriptor());
            mFd = fd;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_method = "3297019645A62F287411C53B25C33F9A", hash_generated_method = "64EED0A8F37058D0517D6328F7FEB62F")
        @Override
        public void close() throws IOException {
            try 
            {
                mFd.close();
            } 
            finally 
            {
                super.close();
            } 
            
            
                
            
                
            
        }

        
    }


    
    public static class AutoCloseOutputStream extends FileOutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_field = "E2307FD862BA74C9C9C26ACA0B7E5364", hash_generated_field = "AE959CCFA06A07F93FA2A8BEED883021")

        private ParcelFileDescriptor mFd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_method = "AC6B0F3765CD3D3DD6495992ADDCA299", hash_generated_method = "3519A8D63370D6208317BADE5496D9F6")
        public  AutoCloseOutputStream(ParcelFileDescriptor fd) {
            super(fd.getFileDescriptor());
            mFd = fd;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_method = "3297019645A62F287411C53B25C33F9A", hash_generated_method = "64EED0A8F37058D0517D6328F7FEB62F")
        @Override
        public void close() throws IOException {
            try 
            {
                mFd.close();
            } 
            finally 
            {
                super.close();
            } 
            
            
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_field = "BA2BAC1F18752DA00A4F6572A504B359", hash_generated_field = "3A425E25D2158592F4B71395B73ABA48")

    public static final int MODE_WORLD_READABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_field = "17D2B2ED3DC4B3B97CA172345DAD8657", hash_generated_field = "F70FF863E9B85A3B3C75BCAF712387C6")

    public static final int MODE_WORLD_WRITEABLE = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_field = "315D150280C704F0621DA42B7EABEA77", hash_generated_field = "6B866752AF78022533961EAFEC48BF90")

    public static final int MODE_READ_ONLY = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_field = "264C60EDCCFAB2B0358041AC33FEEE6B", hash_generated_field = "EE8DCC6B27D46EC2ED14ABA75E7783AA")

    public static final int MODE_WRITE_ONLY = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.873 -0400", hash_original_field = "48FA6B9BAC27C5E37C2AC15B73BEB0F5", hash_generated_field = "6494B31AC04BF207173A1DA805A4DC2B")

    public static final int MODE_READ_WRITE = 0x30000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.874 -0400", hash_original_field = "64F9E90F65FFACE62B2054906BA03800", hash_generated_field = "C6F7880235FE436C915681552C8587CE")

    public static final int MODE_CREATE = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.874 -0400", hash_original_field = "7507DA721AE1A637B2BABAD93D9F8266", hash_generated_field = "2EC651F48C0C7F452AF49E37006FEB27")

    public static final int MODE_TRUNCATE = 0x04000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.874 -0400", hash_original_field = "8E4ACDF6D243F49EEB6EAAF3B5A6BCCA", hash_generated_field = "299AF71922C12BCCD82076F57034ABBF")

    public static final int MODE_APPEND = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.874 -0400", hash_original_field = "195ED69EAF088F7FA956DC093526DC53", hash_generated_field = "DA358939EDE4BFAAAF0FF49DA63A85F3")

    public static final Parcelable.Creator<ParcelFileDescriptor> CREATOR
            = new Parcelable.Creator<ParcelFileDescriptor>() {
        public ParcelFileDescriptor createFromParcel(Parcel in) {
            return in.readFileDescriptor();
        }
        public ParcelFileDescriptor[] newArray(int size) {
            return new ParcelFileDescriptor[size];
        }
    };
    
    public ParcelFileDescriptor[] newArray(int size) {
            return new ParcelFileDescriptor[size];
        }
    
    
    public ParcelFileDescriptor createFromParcel(Parcel in) {
            return in.readFileDescriptor();
        }
    
}

