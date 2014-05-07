package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;

public class ParcelFileDescriptor implements Parcelable {

    /**
     * Create a new ParcelFileDescriptor accessing a given file.
     *
     * @param file The file to be opened.
     * @param mode The desired access mode, must be one of
     * {@link #MODE_READ_ONLY}, {@link #MODE_WRITE_ONLY}, or
     * {@link #MODE_READ_WRITE}; may also be any combination of
     * {@link #MODE_CREATE}, {@link #MODE_TRUNCATE},
     * {@link #MODE_WORLD_READABLE}, and {@link #MODE_WORLD_WRITEABLE}.
     *
     * @return Returns a new ParcelFileDescriptor pointing to the given
     * file.
     *
     * @throws FileNotFoundException Throws FileNotFoundException if the given
     * file does not exist or can not be opened with the requested mode.
     */
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSSource({DSSourceKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.028 -0500", hash_original_method = "6C139DF2C99367764164B889BB05F5C6", hash_generated_method = "A4FC67A1E0EC81E84D832D0DE58F7F12")
    
public static ParcelFileDescriptor open(File file, int mode)
            throws FileNotFoundException {
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

    /**
     * Create a new ParcelFileDescriptor that is a dup of an existing
     * FileDescriptor.  This obeys standard POSIX semantics, where the
     * new file descriptor shared state such as file position with the
     * original file descriptor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.031 -0500", hash_original_method = "A50DDCD7940C2F2074ECB54366A87953", hash_generated_method = "63D089F27944FA9FD551BD7360B3A742")
    
public static ParcelFileDescriptor dup(FileDescriptor orig) throws IOException {
        FileDescriptor fd = Parcel.dupFileDescriptor(orig);
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    /**
     * Create a new ParcelFileDescriptor from a raw native fd.  The new
     * ParcelFileDescriptor holds a dup of the original fd passed in here,
     * so you must still close that fd as well as the new ParcelFileDescriptor.
     *
     * @param fd The native fd that the ParcelFileDescriptor should dup.
     *
     * @return Returns a new ParcelFileDescriptor holding a FileDescriptor
     * for a dup of the given fd.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.036 -0500", hash_original_method = "03604E5C7E0679D6E6C597691E5A0530", hash_generated_method = "A1FF5C516EC9893E9DA2898A20F9B104")
    
public static ParcelFileDescriptor fromFd(int fd) throws IOException {
        FileDescriptor fdesc = getFileDescriptorFromFd(fd);
        return new ParcelFileDescriptor(fdesc);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static FileDescriptor getFileDescriptorFromFd(int fd) throws IOException {
    	return new FileDescriptor();
    }

    /**
     * Take ownership of a raw native fd in to a new ParcelFileDescriptor.
     * The returned ParcelFileDescriptor now owns the given fd, and will be
     * responsible for closing it.  You must not close the fd yourself.
     *
     * @param fd The native fd that the ParcelFileDescriptor should adopt.
     *
     * @return Returns a new ParcelFileDescriptor holding a FileDescriptor
     * for the given fd.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.042 -0500", hash_original_method = "530A807B767E238C12421F2C9825F074", hash_generated_method = "2D148663D575EEEC25EAF181DB7563AA")
    
public static ParcelFileDescriptor adoptFd(int fd) {
        FileDescriptor fdesc = getFileDescriptorFromFdNoDup(fd);
        return new ParcelFileDescriptor(fdesc);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static FileDescriptor getFileDescriptorFromFdNoDup(int fd) {
    	return new FileDescriptor();
    }

    /**
     * Create a new ParcelFileDescriptor from the specified Socket.  The new
     * ParcelFileDescriptor holds a dup of the original FileDescriptor in
     * the Socket, so you must still close the Socket as well as the new
     * ParcelFileDescriptor.
     *
     * @param socket The Socket whose FileDescriptor is used to create
     *               a new ParcelFileDescriptor.
     *
     * @return A new ParcelFileDescriptor with the FileDescriptor of the
     *         specified Socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.048 -0500", hash_original_method = "85D7F2A5B84662980034D44564A77465", hash_generated_method = "D9D70BB94976666FC63AFBAD98143A15")
    
public static ParcelFileDescriptor fromSocket(Socket socket) {
        FileDescriptor fd = socket.getFileDescriptor$();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    /**
     * Create a new ParcelFileDescriptor from the specified DatagramSocket.
     *
     * @param datagramSocket The DatagramSocket whose FileDescriptor is used
     *               to create a new ParcelFileDescriptor.
     *
     * @return A new ParcelFileDescriptor with the FileDescriptor of the
     *         specified DatagramSocket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.050 -0500", hash_original_method = "7C266202E2C105591C60939D1875F8A0", hash_generated_method = "8B3F48C6D2897370E1340E49CE28A798")
    
public static ParcelFileDescriptor fromDatagramSocket(DatagramSocket datagramSocket) {
        FileDescriptor fd = datagramSocket.getFileDescriptor$();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    /**
     * Create two ParcelFileDescriptors structured as a data pipe.  The first
     * ParcelFileDescriptor in the returned array is the read side; the second
     * is the write side.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.052 -0500", hash_original_method = "C65286C81FD9123E310F422158F574EC", hash_generated_method = "E1EA0E6D54BAF1B13A10C5BA854D1303")
    
public static ParcelFileDescriptor[] createPipe() throws IOException {
        FileDescriptor[] fds = new FileDescriptor[2];
        createPipeNative(fds);
        ParcelFileDescriptor[] pfds = new ParcelFileDescriptor[2];
        pfds[0] = new ParcelFileDescriptor(fds[0]);
        pfds[1] = new ParcelFileDescriptor(fds[1]);
        return pfds;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void createPipeNative(FileDescriptor[] outFds) throws IOException {
    }

    /**
     * @hide Please use createPipe() or ContentProvider.openPipeHelper().
     * Gets a file descriptor for a read-only copy of the given data.
     *
     * @param data Data to copy.
     * @param name Name for the shared memory area that may back the file descriptor.
     *        This is purely informative and may be {@code null}.
     * @return A ParcelFileDescriptor.
     * @throws IOException if there is an error while creating the shared memory area.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.059 -0500", hash_original_method = "5DAB2FA0A665F799CCD0D6860DBF4933", hash_generated_method = "502151D93914B556FDAA4F01C688FADC")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.009 -0500", hash_original_field = "9B3ACF68654E0ED61E80CBA7B17F4EF4", hash_generated_field = "3A425E25D2158592F4B71395B73ABA48")

    public static final int MODE_WORLD_READABLE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.012 -0500", hash_original_field = "ED6D80294770989C0B7FC7B33AA0477E", hash_generated_field = "F70FF863E9B85A3B3C75BCAF712387C6")

    public static final int MODE_WORLD_WRITEABLE = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.014 -0500", hash_original_field = "0D952D49489DE4C5D5E9C25A60B1855F", hash_generated_field = "6B866752AF78022533961EAFEC48BF90")

    public static final int MODE_READ_ONLY = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.017 -0500", hash_original_field = "0D7B28B08ED2FC5AF624BE425256456B", hash_generated_field = "EE8DCC6B27D46EC2ED14ABA75E7783AA")

    public static final int MODE_WRITE_ONLY = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.019 -0500", hash_original_field = "BE74864E401030DE85C46F8CFDF76F02", hash_generated_field = "6494B31AC04BF207173A1DA805A4DC2B")

    public static final int MODE_READ_WRITE = 0x30000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.021 -0500", hash_original_field = "9AD7BDC159696C190C2AF0E1601D7486", hash_generated_field = "C6F7880235FE436C915681552C8587CE")

    public static final int MODE_CREATE = 0x08000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.023 -0500", hash_original_field = "928362FA979C9E19D69BA8F4F2C63DE9", hash_generated_field = "2EC651F48C0C7F452AF49E37006FEB27")

    public static final int MODE_TRUNCATE = 0x04000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.025 -0500", hash_original_field = "AC87D1273E90D122FF3E4986BCA77843", hash_generated_field = "299AF71922C12BCCD82076F57034ABBF")

    public static final int MODE_APPEND = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.098 -0400", hash_original_field = "195ED69EAF088F7FA956DC093526DC53", hash_generated_field = "DA358939EDE4BFAAAF0FF49DA63A85F3")

    public static final Parcelable.Creator<ParcelFileDescriptor> CREATOR
            = new Parcelable.Creator<ParcelFileDescriptor>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.114 -0500", hash_original_method = "621772CCC7C69481AB7D1DD9C7D31515", hash_generated_method = "C75A0CCB573FDF26B2F51326F4C00124")
        
public ParcelFileDescriptor createFromParcel(Parcel in) {
            return in.readFileDescriptor();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.116 -0500", hash_original_method = "0E118C44FAE1C288D206B8A2736A6FCD", hash_generated_method = "67876C2DB00FDBF39E82338196259CAC")
        
public ParcelFileDescriptor[] newArray(int size) {
            return new ParcelFileDescriptor[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.003 -0500", hash_original_field = "3DDF6F67F19B0814E8DAB7B3CFFED3B7", hash_generated_field = "58A1B3A123725E48931BD35C0EB2D4CB")

    private  FileDescriptor mFileDescriptor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.005 -0500", hash_original_field = "56ECBEBCC8BAA6BB3E13A5DE04356F54", hash_generated_field = "BD690B26D5468868AFAF08CAFB003D2A")

    private boolean mClosed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.007 -0500", hash_original_field = "07EABE4D020D51423AF65EE5F7010923", hash_generated_field = "BEBD775A200542FF483601B2C5DD74A0")

    //PartialFileDescriptor but avoid invoking close twice
    //consider ParcelFileDescriptor A(fileDescriptor fd),  ParcelFileDescriptor B(A)
    //in this particular case fd.close might be invoked twice.
    private  ParcelFileDescriptor mParcelDescriptor;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.104 -0500", hash_original_method = "DB42A2A8BBE574C2950DCEEDDCE79B62", hash_generated_method = "24D321CC68D854EFB2D3295E12498F0B")
    
public ParcelFileDescriptor(ParcelFileDescriptor descriptor) {
        super();
        mParcelDescriptor = descriptor;
        mFileDescriptor = mParcelDescriptor.mFileDescriptor;
    }

    /*package */@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.107 -0500", hash_original_method = "5987A31E1ECCB1911B1BA6CC4EEF72A2", hash_generated_method = "5987A31E1ECCB1911B1BA6CC4EEF72A2")
    
ParcelFileDescriptor(FileDescriptor descriptor) {
        super();
        if (descriptor == null) {
            throw new NullPointerException("descriptor must not be null");
        }
        mFileDescriptor = descriptor;
        mParcelDescriptor = null;
    }
    // orphaned legacy method
    @DSSafe(DSCat.SAFE_OTHERS)
    public ParcelFileDescriptor() {
    	
    }

    /**
     * Create a new ParcelFileDescriptor that is a dup of the existing
     * FileDescriptor.  This obeys standard POSIX semantics, where the
     * new file descriptor shared state such as file position with the
     * original file descriptor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.033 -0500", hash_original_method = "474327607EE56B056BCE4043FE865D8B", hash_generated_method = "A8CB8980488C2FCB5B884E352F4D3527")
    
public ParcelFileDescriptor dup() throws IOException {
        return dup(getFileDescriptor());
    }

    /**
     * Retrieve the actual FileDescriptor associated with this object.
     *
     * @return Returns the FileDescriptor associated with this object.
     */
    @DSSource({DSSourceKind.FILE})
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.061 -0500", hash_original_method = "949276D2764A2C9DACACDE44898698C8", hash_generated_method = "E5BF1F22A9EE48D78F7BADE5BB998512")
    
public FileDescriptor getFileDescriptor() {
        return mFileDescriptor;
    }
    
    public static class AutoCloseInputStream extends FileInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.082 -0500", hash_original_field = "F15BA4F12003086454C67D56791594A9", hash_generated_field = "AE959CCFA06A07F93FA2A8BEED883021")

        private  ParcelFileDescriptor mFd;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.084 -0500", hash_original_method = "E3D4E7E6DEAE42263A4A251652766597", hash_generated_method = "AA444B5ECC1A44970F5E326C27AA5E61")
        
public AutoCloseInputStream(ParcelFileDescriptor fd) {
            super(fd.getFileDescriptor());
            mFd = fd;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.087 -0500", hash_original_method = "3297019645A62F287411C53B25C33F9A", hash_generated_method = "189EF830A5C06698C8437B918CEB6E4B")
        
@Override
        public void close() throws IOException {
            try {
                mFd.close();
            } finally {
                super.close();
            }
        }
        
    }
    
    public static class AutoCloseOutputStream extends FileOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.091 -0500", hash_original_field = "F15BA4F12003086454C67D56791594A9", hash_generated_field = "AE959CCFA06A07F93FA2A8BEED883021")

        private  ParcelFileDescriptor mFd;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.094 -0500", hash_original_method = "AC6B0F3765CD3D3DD6495992ADDCA299", hash_generated_method = "D01C63A2064C1AEE0379D171ACBCE7FD")
        
public AutoCloseOutputStream(ParcelFileDescriptor fd) {
            super(fd.getFileDescriptor());
            mFd = fd;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.096 -0500", hash_original_method = "3297019645A62F287411C53B25C33F9A", hash_generated_method = "189EF830A5C06698C8437B918CEB6E4B")
        
@Override
        public void close() throws IOException {
            try {
                mFd.close();
            } finally {
                super.close();
            }
        }
        
    }

    /**
     * Return the total size of the file representing this fd, as determined
     * by stat().  Returns -1 if the fd is not a file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.064 -0500", hash_original_method = "77F816B0B1C349FF3A8882E701737452", hash_generated_method = "28E082901685F2C14DA35BBCF66DB001")
    
    public long getStatSize(){
    	//Formerly a native method
    	return getTaintLong();
    }

    /**
     * This is needed for implementing AssetFileDescriptor.AutoCloseOutputStream,
     * and I really don't think we want it to be public.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.068 -0500", hash_original_method = "0F9A3950A7A9E5BB31D919F8BB19673E", hash_generated_method = "2066042C4E4301B8E406A51F0CB2700B")
    
    public long seekTo(long pos){
    	//Formerly a native method
    	addTaint(pos);
    	return getTaintLong();
    }

    /**
     * Return the native fd int for this ParcelFileDescriptor.  The
     * ParcelFileDescriptor still owns the fd, and it still must be closed
     * through this API.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.070 -0500", hash_original_method = "C747587E89EFBC650597F209F149B598", hash_generated_method = "9486D8D458C93EF74D0AA526839B0ABE")
    
public int getFd() {
        if (mClosed) {
            throw new IllegalStateException("Already closed");
        }
        return getFdNative();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.073 -0500", hash_original_method = "48F8D374A617845984C88F484B28408C", hash_generated_method = "768CDDF19E2CFAF4C00BC3EFCDC28732")
    
    private int getFdNative(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Return the native fd int for this ParcelFileDescriptor and detach it
     * from the object here.  You are now responsible for closing the fd in
     * native code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.076 -0500", hash_original_method = "AECA8304F263BE3AD120D5996456D31E", hash_generated_method = "78E10B26650351F29984E50CD30A5C8A")
    
public int detachFd() {
        if (mClosed) {
            throw new IllegalStateException("Already closed");
        }
        if (mParcelDescriptor != null) {
            int fd = mParcelDescriptor.detachFd();
            mClosed = true;
            return fd;
        }
        int fd = getFd();
        mClosed = true;
        Parcel.clearFileDescriptor(mFileDescriptor);
        return fd;
    }

    /**
     * Close the ParcelFileDescriptor. This implementation closes the underlying
     * OS resources allocated to represent this stream.
     *
     * @throws IOException
     *             If an error occurs attempting to close this ParcelFileDescriptor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.078 -0500", hash_original_method = "39939000D7522F3E727F0E3243089AE5", hash_generated_method = "ED2F276848683C97A8A50C78CD7E7CD6")
    
public void close() throws IOException {
        synchronized (this) {
            if (mClosed) return;
            mClosed = true;
        }
        if (mParcelDescriptor != null) {
            // If this is a proxy to another file descriptor, just call through to its
            // close method.
            mParcelDescriptor.close();
        } else {
            Parcel.closeFileDescriptor(mFileDescriptor);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.100 -0500", hash_original_method = "BA9513A0FEF5B159A730B41F75EA216A", hash_generated_method = "6492143EEC626BDBFC9ECDAA366E42D9")
    
@Override
    public String toString() {
        return "{ParcelFileDescriptor: " + mFileDescriptor + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.102 -0500", hash_original_method = "47AC631E45892E7E44A62B81BC7ACB91", hash_generated_method = "82C8FC9A3F9B6E06400389058559C479")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (!mClosed) {
                close();
            }
        } finally {
            super.finalize();
        }
    }

    /* Parcelable interface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.109 -0500", hash_original_method = "5C5A30224996A2D414D9176559E683A9", hash_generated_method = "21B90FA3BEA6E09C036B9A91E6B4B68C")
    
public int describeContents() {
        return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    /**
     * {@inheritDoc}
     * If {@link Parcelable#PARCELABLE_WRITE_RETURN_VALUE} is set in flags,
     * the file descriptor will be closed after a copy is written to the Parcel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.111 -0500", hash_original_method = "D9382402A3E15CFE2B7948813716CC7C", hash_generated_method = "B7D638B39FA5EA0B27FB8B921502638E")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeFileDescriptor(mFileDescriptor);
        if ((flags&PARCELABLE_WRITE_RETURN_VALUE) != 0 && !mClosed) {
            try {
                close();
            } catch (IOException e) {
                // Empty
            }
        }
    }
    
    // orphaned legacy method
    public ParcelFileDescriptor[] newArray(int size) {
            return new ParcelFileDescriptor[size];
        }
    
    // orphaned legacy method
    public ParcelFileDescriptor createFromParcel(Parcel in) {
            return in.readFileDescriptor();
        }
    
}

