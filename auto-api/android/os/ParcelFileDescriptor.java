package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private FileDescriptor mFileDescriptor;
    private boolean mClosed;
    private ParcelFileDescriptor mParcelDescriptor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.025 -0400", hash_original_method = "DB42A2A8BBE574C2950DCEEDDCE79B62", hash_generated_method = "2A8FF1AC42EA7613EEF655971F1D8146")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParcelFileDescriptor(ParcelFileDescriptor descriptor) {
        super();
        dsTaint.addTaint(descriptor.dsTaint);
        mFileDescriptor = mParcelDescriptor.mFileDescriptor;
        // ---------- Original Method ----------
        //mParcelDescriptor = descriptor;
        //mFileDescriptor = mParcelDescriptor.mFileDescriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.025 -0400", hash_original_method = "5987A31E1ECCB1911B1BA6CC4EEF72A2", hash_generated_method = "D2CB826C27CC233552B05C79902DF5CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ParcelFileDescriptor(FileDescriptor descriptor) {
        super();
        dsTaint.addTaint(descriptor.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("descriptor must not be null");
        } //End block
        mParcelDescriptor = null;
        // ---------- Original Method ----------
        //if (descriptor == null) {
            //throw new NullPointerException("descriptor must not be null");
        //}
        //mFileDescriptor = descriptor;
        //mParcelDescriptor = null;
    }

    
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

    
        public static ParcelFileDescriptor dup(FileDescriptor orig) throws IOException {
        FileDescriptor fd = Parcel.dupFileDescriptor(orig);
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.026 -0400", hash_original_method = "474327607EE56B056BCE4043FE865D8B", hash_generated_method = "169C1AA05998D24A643BB84D725DD9EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParcelFileDescriptor dup() throws IOException {
        ParcelFileDescriptor var9FA6A09B8472BACDF2AE552CC4D7ECC7_1595350159 = (dup(getFileDescriptor()));
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dup(getFileDescriptor());
    }

    
        public static ParcelFileDescriptor fromFd(int fd) throws IOException {
        FileDescriptor fdesc = getFileDescriptorFromFd(fd);
        return new ParcelFileDescriptor(fdesc);
    }

    
        private static FileDescriptor getFileDescriptorFromFd(int fd) throws IOException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static ParcelFileDescriptor adoptFd(int fd) {
        FileDescriptor fdesc = getFileDescriptorFromFdNoDup(fd);
        return new ParcelFileDescriptor(fdesc);
    }

    
        private static FileDescriptor getFileDescriptorFromFdNoDup(int fd) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static ParcelFileDescriptor fromSocket(Socket socket) {
        FileDescriptor fd = socket.getFileDescriptor$();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
        public static ParcelFileDescriptor fromDatagramSocket(DatagramSocket datagramSocket) {
        FileDescriptor fd = datagramSocket.getFileDescriptor$();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
        public static ParcelFileDescriptor[] createPipe() throws IOException {
        FileDescriptor[] fds = new FileDescriptor[2];
        createPipeNative(fds);
        ParcelFileDescriptor[] pfds = new ParcelFileDescriptor[2];
        pfds[0] = new ParcelFileDescriptor(fds[0]);
        pfds[1] = new ParcelFileDescriptor(fds[1]);
        return pfds;
    }

    
        private static void createPipeNative(FileDescriptor[] outFds) throws IOException {
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.027 -0400", hash_original_method = "949276D2764A2C9DACACDE44898698C8", hash_generated_method = "AE06AE99F38E123E80429212D733352D")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFileDescriptor() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFileDescriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.027 -0400", hash_original_method = "77F816B0B1C349FF3A8882E701737452", hash_generated_method = "D035A8883253BF6BA19C6B8A3F1C2D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getStatSize() {
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.028 -0400", hash_original_method = "0F9A3950A7A9E5BB31D919F8BB19673E", hash_generated_method = "4E8CC30A4452959B16AF4FF4CB4A07E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long seekTo(long pos) {
        dsTaint.addTaint(pos);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.028 -0400", hash_original_method = "C747587E89EFBC650597F209F149B598", hash_generated_method = "44C243C1ADE8287BFC4DF7DD6E4B0817")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFd() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already closed");
        } //End block
        int var751A6E18182434738AFEB29212FB434D_609830905 = (getFdNative());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mClosed) {
            //throw new IllegalStateException("Already closed");
        //}
        //return getFdNative();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.028 -0400", hash_original_method = "48F8D374A617845984C88F484B28408C", hash_generated_method = "A38C53FD02F026A61AFEF34DB7667B95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getFdNative() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.028 -0400", hash_original_method = "AECA8304F263BE3AD120D5996456D31E", hash_generated_method = "767DB377561FC22E36CECF388E0B9237")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int detachFd() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already closed");
        } //End block
        {
            int fd;
            fd = mParcelDescriptor.detachFd();
            mClosed = true;
        } //End block
        int fd;
        fd = getFd();
        mClosed = true;
        Parcel.clearFileDescriptor(mFileDescriptor);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mClosed) {
            //throw new IllegalStateException("Already closed");
        //}
        //if (mParcelDescriptor != null) {
            //int fd = mParcelDescriptor.detachFd();
            //mClosed = true;
            //return fd;
        //}
        //int fd = getFd();
        //mClosed = true;
        //Parcel.clearFileDescriptor(mFileDescriptor);
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.029 -0400", hash_original_method = "39939000D7522F3E727F0E3243089AE5", hash_generated_method = "C93AE2836E4766793DDE4FD6C28D9C61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        {
            mClosed = true;
        } //End block
        {
            mParcelDescriptor.close();
        } //End block
        {
            Parcel.closeFileDescriptor(mFileDescriptor);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mClosed) return;
            //mClosed = true;
        //}
        //if (mParcelDescriptor != null) {
            //mParcelDescriptor.close();
        //} else {
            //Parcel.closeFileDescriptor(mFileDescriptor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.029 -0400", hash_original_method = "BA9513A0FEF5B159A730B41F75EA216A", hash_generated_method = "B3E23BB433BCE47F39BABA7398832984")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "{ParcelFileDescriptor: " + mFileDescriptor + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.029 -0400", hash_original_method = "47AC631E45892E7E44A62B81BC7ACB91", hash_generated_method = "5BFFCB83F2EFF1414AF3C5F71AB87D6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                close();
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (!mClosed) {
                //close();
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.029 -0400", hash_original_method = "5C5A30224996A2D414D9176559E683A9", hash_generated_method = "FC3B912957A2E65031C97112DB7F5A46")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.029 -0400", hash_original_method = "D9382402A3E15CFE2B7948813716CC7C", hash_generated_method = "C8D99264AF7EB76D55F22C4649ECAC88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeFileDescriptor(mFileDescriptor);
        {
            try 
            {
                close();
            } //End block
            catch (IOException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //out.writeFileDescriptor(mFileDescriptor);
        //if ((flags&PARCELABLE_WRITE_RETURN_VALUE) != 0 && !mClosed) {
            //try {
                //close();
            //} catch (IOException e) {
            //}
        //}
    }

    
    public static class AutoCloseInputStream extends FileInputStream {
        private ParcelFileDescriptor mFd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.030 -0400", hash_original_method = "E3D4E7E6DEAE42263A4A251652766597", hash_generated_method = "A2172A42790C66F9BDD2C86D9F354E4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AutoCloseInputStream(ParcelFileDescriptor fd) {
            super(fd.getFileDescriptor());
            dsTaint.addTaint(fd.dsTaint);
            // ---------- Original Method ----------
            //mFd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.030 -0400", hash_original_method = "3297019645A62F287411C53B25C33F9A", hash_generated_method = "64EED0A8F37058D0517D6328F7FEB62F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            try 
            {
                mFd.close();
            } //End block
            finally 
            {
                super.close();
            } //End block
            // ---------- Original Method ----------
            //try {
                //mFd.close();
            //} finally {
                //super.close();
            //}
        }

        
    }


    
    public static class AutoCloseOutputStream extends FileOutputStream {
        private ParcelFileDescriptor mFd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.030 -0400", hash_original_method = "AC6B0F3765CD3D3DD6495992ADDCA299", hash_generated_method = "925715F188DBD09F2FAC94622B66D588")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AutoCloseOutputStream(ParcelFileDescriptor fd) {
            super(fd.getFileDescriptor());
            dsTaint.addTaint(fd.dsTaint);
            // ---------- Original Method ----------
            //mFd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.030 -0400", hash_original_method = "3297019645A62F287411C53B25C33F9A", hash_generated_method = "64EED0A8F37058D0517D6328F7FEB62F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            try 
            {
                mFd.close();
            } //End block
            finally 
            {
                super.close();
            } //End block
            // ---------- Original Method ----------
            //try {
                //mFd.close();
            //} finally {
                //super.close();
            //}
        }

        
    }


    
    public static final int MODE_WORLD_READABLE = 0x00000001;
    public static final int MODE_WORLD_WRITEABLE = 0x00000002;
    public static final int MODE_READ_ONLY = 0x10000000;
    public static final int MODE_WRITE_ONLY = 0x20000000;
    public static final int MODE_READ_WRITE = 0x30000000;
    public static final int MODE_CREATE = 0x08000000;
    public static final int MODE_TRUNCATE = 0x04000000;
    public static final int MODE_APPEND = 0x02000000;
    public static final Parcelable.Creator<ParcelFileDescriptor> CREATOR = new Parcelable.Creator<ParcelFileDescriptor>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.031 -0400", hash_original_method = "621772CCC7C69481AB7D1DD9C7D31515", hash_generated_method = "A8D2395C1BC1CA0F3641410FD785A10A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ParcelFileDescriptor createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ParcelFileDescriptor var48FE8C6DCF0D96FABA91CE4B6AA12D43_692207594 = (in.readFileDescriptor());
            return (ParcelFileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return in.readFileDescriptor();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.031 -0400", hash_original_method = "0E118C44FAE1C288D206B8A2736A6FCD", hash_generated_method = "F9A4C1774311B681B0326FF07A133974")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ParcelFileDescriptor[] newArray(int size) {
            dsTaint.addTaint(size);
            ParcelFileDescriptor[] varA0F689DD1D61C586B36169819E73014D_195262329 = (new ParcelFileDescriptor[size]);
            return (ParcelFileDescriptor[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ParcelFileDescriptor[size];
        }

        
}; //Transformed anonymous class
}

