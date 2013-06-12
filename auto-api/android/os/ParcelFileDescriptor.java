package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private /* final */ FileDescriptor mFileDescriptor;
    private boolean mClosed;
    private /* final */ ParcelFileDescriptor mParcelDescriptor;
    public static final int MODE_WORLD_READABLE = 0x00000001;
    public static final int MODE_WORLD_WRITEABLE = 0x00000002;
    public static final int MODE_READ_ONLY = 0x10000000;
    public static final int MODE_WRITE_ONLY = 0x20000000;
    public static final int MODE_READ_WRITE = 0x30000000;
    public static final int MODE_CREATE = 0x08000000;
    public static final int MODE_TRUNCATE = 0x04000000;
    public static final int MODE_APPEND = 0x02000000;
    
    @DSModeled(DSC.BAN) // created to accomodate return from native calls
    public ParcelFileDescriptor() {
		// TODO Auto-generated constructor stub
	}
    
    public static final Parcelable.Creator<ParcelFileDescriptor> CREATOR = new Parcelable.Creator<ParcelFileDescriptor>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.812 -0400", hash_original_method = "621772CCC7C69481AB7D1DD9C7D31515", hash_generated_method = "F1BC810BF9B6B3F6A4E419C20FA1028B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ParcelFileDescriptor createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ParcelFileDescriptor var48FE8C6DCF0D96FABA91CE4B6AA12D43_1763824307 = (in.readFileDescriptor());
            return (ParcelFileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return in.readFileDescriptor();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.812 -0400", hash_original_method = "0E118C44FAE1C288D206B8A2736A6FCD", hash_generated_method = "F2B5B322CCCF174A48715CE5BA6FE449")
        @DSModeled(DSC.SAFE)
        public ParcelFileDescriptor[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ParcelFileDescriptor[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ParcelFileDescriptor[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.812 -0400", hash_original_method = "DB42A2A8BBE574C2950DCEEDDCE79B62", hash_generated_method = "F585B50C81C9B2DA0EA85E757FF9B651")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParcelFileDescriptor(ParcelFileDescriptor descriptor) {
        super();
        dsTaint.addTaint(descriptor.dsTaint);
        mFileDescriptor = mParcelDescriptor.mFileDescriptor;
        // ---------- Original Method ----------
        //mParcelDescriptor = descriptor;
        //mFileDescriptor = mParcelDescriptor.mFileDescriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.812 -0400", hash_original_method = "5987A31E1ECCB1911B1BA6CC4EEF72A2", hash_generated_method = "7F0F371D77E5FA895A409C21B01111BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ParcelFileDescriptor(FileDescriptor descriptor) {
        super();
        dsTaint.addTaint(descriptor.dsTaint);
        {
            throw new NullPointerException("descriptor must not be null");
        } //End block
        mParcelDescriptor = null;
        // ---------- Original Method ----------
        //if (descriptor == null) {
            //throw new NullPointerException("descriptor must not be null");
        //}
        //mFileDescriptor = descriptor;
        //mParcelDescriptor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.812 -0400", hash_original_method = "6C139DF2C99367764164B889BB05F5C6", hash_generated_method = "A4FC67A1E0EC81E84D832D0DE58F7F12")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.812 -0400", hash_original_method = "A50DDCD7940C2F2074ECB54366A87953", hash_generated_method = "63D089F27944FA9FD551BD7360B3A742")
    public static ParcelFileDescriptor dup(FileDescriptor orig) throws IOException {
        FileDescriptor fd = Parcel.dupFileDescriptor(orig);
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.812 -0400", hash_original_method = "474327607EE56B056BCE4043FE865D8B", hash_generated_method = "EF51DA006F307A3547827B8881207B5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParcelFileDescriptor dup() throws IOException {
        ParcelFileDescriptor var9FA6A09B8472BACDF2AE552CC4D7ECC7_1036411501 = (dup(getFileDescriptor()));
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dup(getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.812 -0400", hash_original_method = "03604E5C7E0679D6E6C597691E5A0530", hash_generated_method = "A1FF5C516EC9893E9DA2898A20F9B104")
    public static ParcelFileDescriptor fromFd(int fd) throws IOException {
        FileDescriptor fdesc = getFileDescriptorFromFd(fd);
        return new ParcelFileDescriptor(fdesc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "5B9BEBD53DA88F119BA69D9BCF36F79E", hash_generated_method = "020F81E31D834959583B4373751BB8EA")
    private static FileDescriptor getFileDescriptorFromFd(int fd) throws IOException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "530A807B767E238C12421F2C9825F074", hash_generated_method = "2D148663D575EEEC25EAF181DB7563AA")
    public static ParcelFileDescriptor adoptFd(int fd) {
        FileDescriptor fdesc = getFileDescriptorFromFdNoDup(fd);
        return new ParcelFileDescriptor(fdesc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "ECC2BD071DF2F5E1C33B5CE43A549DDA", hash_generated_method = "8DE208DB4E7C2C787550B8C34CC70791")
    private static FileDescriptor getFileDescriptorFromFdNoDup(int fd) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "85D7F2A5B84662980034D44564A77465", hash_generated_method = "D9D70BB94976666FC63AFBAD98143A15")
    public static ParcelFileDescriptor fromSocket(Socket socket) {
        FileDescriptor fd = socket.getFileDescriptor$();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "7C266202E2C105591C60939D1875F8A0", hash_generated_method = "8B3F48C6D2897370E1340E49CE28A798")
    public static ParcelFileDescriptor fromDatagramSocket(DatagramSocket datagramSocket) {
        FileDescriptor fd = datagramSocket.getFileDescriptor$();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "C65286C81FD9123E310F422158F574EC", hash_generated_method = "E1EA0E6D54BAF1B13A10C5BA854D1303")
    public static ParcelFileDescriptor[] createPipe() throws IOException {
        FileDescriptor[] fds = new FileDescriptor[2];
        createPipeNative(fds);
        ParcelFileDescriptor[] pfds = new ParcelFileDescriptor[2];
        pfds[0] = new ParcelFileDescriptor(fds[0]);
        pfds[1] = new ParcelFileDescriptor(fds[1]);
        return pfds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "406FA2C737CEB883C193D53164181615", hash_generated_method = "08410D5508E261402A9911E99013868B")
    private static void createPipeNative(FileDescriptor[] outFds) throws IOException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "5DAB2FA0A665F799CCD0D6860DBF4933", hash_generated_method = "502151D93914B556FDAA4F01C688FADC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "949276D2764A2C9DACACDE44898698C8", hash_generated_method = "8DDFC9DCBF069CEE4083FD896563D635")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFileDescriptor() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFileDescriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "77F816B0B1C349FF3A8882E701737452", hash_generated_method = "92125EDBFD89735D2FFA1487312B7A7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getStatSize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.813 -0400", hash_original_method = "0F9A3950A7A9E5BB31D919F8BB19673E", hash_generated_method = "AE4BCDD91F4DD9F4C30D79AC22656B2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long seekTo(long pos) {
        dsTaint.addTaint(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.814 -0400", hash_original_method = "C747587E89EFBC650597F209F149B598", hash_generated_method = "05492709264BE98CE1F457C3A51F0E08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFd() {
        {
            throw new IllegalStateException("Already closed");
        } //End block
        int var751A6E18182434738AFEB29212FB434D_822736193 = (getFdNative());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mClosed) {
            //throw new IllegalStateException("Already closed");
        //}
        //return getFdNative();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.814 -0400", hash_original_method = "48F8D374A617845984C88F484B28408C", hash_generated_method = "62FDE9B85DAF0517DB3D8A2DAF117F1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getFdNative() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.814 -0400", hash_original_method = "AECA8304F263BE3AD120D5996456D31E", hash_generated_method = "F1F0D898FA1B556403717829A280B428")
    @DSModeled(DSC.SAFE)
    public int detachFd() {
        {
            throw new IllegalStateException("Already closed");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.814 -0400", hash_original_method = "39939000D7522F3E727F0E3243089AE5", hash_generated_method = "B58EB1BB59F36AF5C95A450AE63CDB58")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.814 -0400", hash_original_method = "BA9513A0FEF5B159A730B41F75EA216A", hash_generated_method = "F13CE7458F4C2B0DFAC60AC4C4A21506")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "{ParcelFileDescriptor: " + mFileDescriptor + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.814 -0400", hash_original_method = "47AC631E45892E7E44A62B81BC7ACB91", hash_generated_method = "A5D583A19F2D66DF086EBDA88B95AD1B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.814 -0400", hash_original_method = "5C5A30224996A2D414D9176559E683A9", hash_generated_method = "8653937E3206ED8F83C03F2D9FF207EE")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.814 -0400", hash_original_method = "D9382402A3E15CFE2B7948813716CC7C", hash_generated_method = "CB25678A0D494A96C524B98F4DFC8BC1")
    @DSModeled(DSC.SAFE)
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
        private final ParcelFileDescriptor mFd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.815 -0400", hash_original_method = "E3D4E7E6DEAE42263A4A251652766597", hash_generated_method = "F4B590FF704C02C86B288DEDCE894306")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AutoCloseInputStream(ParcelFileDescriptor fd) {
            super(fd.getFileDescriptor());
            dsTaint.addTaint(fd.dsTaint);
            // ---------- Original Method ----------
            //mFd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.815 -0400", hash_original_method = "3297019645A62F287411C53B25C33F9A", hash_generated_method = "4F8A7EDAF449F5BAA840A0FF66D7B078")
        @DSModeled(DSC.SAFE)
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
        private final ParcelFileDescriptor mFd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.815 -0400", hash_original_method = "AC6B0F3765CD3D3DD6495992ADDCA299", hash_generated_method = "939BF92B6CCAFB247BDFFE1064D756F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AutoCloseOutputStream(ParcelFileDescriptor fd) {
            super(fd.getFileDescriptor());
            dsTaint.addTaint(fd.dsTaint);
            // ---------- Original Method ----------
            //mFd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.815 -0400", hash_original_method = "3297019645A62F287411C53B25C33F9A", hash_generated_method = "4F8A7EDAF449F5BAA840A0FF66D7B078")
        @DSModeled(DSC.SAFE)
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


    
}


