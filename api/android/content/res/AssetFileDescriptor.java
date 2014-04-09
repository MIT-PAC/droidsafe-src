package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

public class AssetFileDescriptor implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.727 -0500", hash_original_field = "D383DF2E70CDAE2ECE477107467659F5", hash_generated_field = "4FE9A1DE5214CFC95E635BC2E3ADC963")

    public static final long UNKNOWN_LENGTH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.928 -0400", hash_original_field = "55F81C540A0F490F18AFC67EA63DC2AC", hash_generated_field = "C848EEBB0F7783D5E330997BE762ED30")

    public static final Parcelable.Creator<AssetFileDescriptor> CREATOR
            = new Parcelable.Creator<AssetFileDescriptor>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.812 -0500", hash_original_method = "1A4F03E8300F0259C61020522681AA45", hash_generated_method = "1A68C4DFC8269B9003C31D1062EC747A")
        
public AssetFileDescriptor createFromParcel(Parcel in) {
            return new AssetFileDescriptor(in);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.814 -0500", hash_original_method = "CAD0361A5B33BFD049C2AE43787539DA", hash_generated_method = "5326B01EDE809B32F05318641AA31379")
        
public AssetFileDescriptor[] newArray(int size) {
            return new AssetFileDescriptor[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.730 -0500", hash_original_field = "F15BA4F12003086454C67D56791594A9", hash_generated_field = "AE959CCFA06A07F93FA2A8BEED883021")
    
    private  ParcelFileDescriptor mFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.732 -0500", hash_original_field = "EA2AC6F7F17E9F5AC720129EC7B5A165", hash_generated_field = "286E6AACFD37B23A56DE152AEA0EBEB7")

    private  long mStartOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.734 -0500", hash_original_field = "CAB3DDEC49B3F58AA21EC9312CA21C26", hash_generated_field = "56354C84F68C232CB4A6660E662F1AD3")

    private  long mLength;
    
    /**
     * Create a new AssetFileDescriptor from the given values.
     * @param fd The underlying file descriptor.
     * @param startOffset The location within the file that the asset starts.
     * This must be 0 if length is UNKNOWN_LENGTH.
     * @param length The number of bytes of the asset, or
     * {@link #UNKNOWN_LENGTH} if it extends to the end of the file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.737 -0500", hash_original_method = "DC4E6AC867A43EED90FFB40A290359DB", hash_generated_method = "88543127A25C62BC2023719A31B46817")
    
public AssetFileDescriptor(ParcelFileDescriptor fd, long startOffset,
            long length) {
        if (length < 0 && startOffset != 0) {
            throw new IllegalArgumentException(
                    "startOffset must be 0 when using UNKNOWN_LENGTH");
        }
        mFd = fd;
        mStartOffset = startOffset;
        mLength = length;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.808 -0500", hash_original_method = "1F42E1B919C11896F377AE3DA953160B", hash_generated_method = "1F42E1B919C11896F377AE3DA953160B")
    
AssetFileDescriptor(Parcel src) {
        mFd = ParcelFileDescriptor.CREATOR.createFromParcel(src);
        mStartOffset = src.readLong();
        mLength = src.readLong();
    }
    
    /**
     * The AssetFileDescriptor contains its own ParcelFileDescriptor, which
     * in addition to the normal FileDescriptor object also allows you to close
     * the descriptor when you are done with it.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.739 -0500", hash_original_method = "9E61752120AEDC1582A5E495568F317A", hash_generated_method = "4296F37385ABE7D8D01D65FDFB3669B1")
    
public ParcelFileDescriptor getParcelFileDescriptor() {
        return mFd;
    }
    
    /**
     * Returns the FileDescriptor that can be used to read the data in the
     * file.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.741 -0500", hash_original_method = "44C1CE26DE6098783D46BD5B3EB1BDD6", hash_generated_method = "AAD5723250B4FD2A2C783AFDFFD1F5F0")
    
public FileDescriptor getFileDescriptor() {
        return mFd.getFileDescriptor();
    }
    
    /**
     * Returns the byte offset where this asset entry's data starts.
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.743 -0500", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "8D97620EF9AD25B7CC0B648BD738E0E0")
    
public long getStartOffset() {
        return mStartOffset;
    }
    
    /**
     * Returns the total number of bytes of this asset entry's data.  May be
     * {@link #UNKNOWN_LENGTH} if the asset extends to the end of the file.
     * If the AssetFileDescriptor was constructed with {@link #UNKNOWN_LENGTH},
     * this will use {@link ParcelFileDescriptor#getStatSize()
     * ParcelFileDescriptor.getStatSize()} to find the total size of the file,
     * returning that number if found or {@link #UNKNOWN_LENGTH} if it could
     * not be determined.
     * 
     * @see #getDeclaredLength()
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.745 -0500", hash_original_method = "CF0C8205090CB57B9B1EACE80CFEFFE6", hash_generated_method = "F1D872A0D86B7EF8F27AE8B5C27ED7A5")
    
public long getLength() {
        if (mLength >= 0) {
            return mLength;
        }
        long len = mFd.getStatSize();
        return len >= 0 ? len : UNKNOWN_LENGTH;
    }
    
    /**
     * Return the actual number of bytes that were declared when the
     * AssetFileDescriptor was constructed.  Will be
     * {@link #UNKNOWN_LENGTH} if the length was not declared, meaning data
     * should be read to the end of the file.
     * 
     * @see #getDeclaredLength()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.748 -0500", hash_original_method = "017FD707368B4170A32A7494D8D576FE", hash_generated_method = "F6014B19B06A61282754490289EFC536")
    
public long getDeclaredLength() {
        return mLength;
    }
    
    /**
     * Convenience for calling <code>getParcelFileDescriptor().close()</code>.
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.750 -0500", hash_original_method = "491F69AA4FD12992599C16C8B0915773", hash_generated_method = "96F1DAB79A4CAC2E01C61FFEE8C1D882")
    
public void close() throws IOException {
        mFd.close();
    }

    /**
     * Create and return a new auto-close input stream for this asset.  This
     * will either return a full asset {@link AutoCloseInputStream}, or
     * an underlying {@link ParcelFileDescriptor.AutoCloseInputStream
     * ParcelFileDescriptor.AutoCloseInputStream} depending on whether the
     * the object represents a complete file or sub-section of a file.  You
     * should only call this once for a particular asset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.752 -0500", hash_original_method = "6638264422E2A7F83EB5780796593D58", hash_generated_method = "A1CC958F99EFE0E294750B1589E93093")
    
public FileInputStream createInputStream() throws IOException {
        if (mLength < 0) {
            return new ParcelFileDescriptor.AutoCloseInputStream(mFd);
        }
        return new AutoCloseInputStream(this);
    }
    
    /**
     * Create and return a new auto-close output stream for this asset.  This
     * will either return a full asset {@link AutoCloseOutputStream}, or
     * an underlying {@link ParcelFileDescriptor.AutoCloseOutputStream
     * ParcelFileDescriptor.AutoCloseOutputStream} depending on whether the
     * the object represents a complete file or sub-section of a file.  You
     * should only call this once for a particular asset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.754 -0500", hash_original_method = "221DC8DE3671455AA557297DC19DE0C7", hash_generated_method = "7B6C3E658EDE2D227355D9F3663D4FFC")
    
public FileOutputStream createOutputStream() throws IOException {
        if (mLength < 0) {
            return new ParcelFileDescriptor.AutoCloseOutputStream(mFd);
        }
        return new AutoCloseOutputStream(this);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.757 -0500", hash_original_method = "7D4F991E1E50267AE78D06F4481657CB", hash_generated_method = "A927486723CF9B2F42D6177F7933917A")
    
@Override
    public String toString() {
        return "{AssetFileDescriptor: " + mFd
                + " start=" + mStartOffset + " len=" + mLength + "}";
    }
    
    public static class AutoCloseInputStream extends ParcelFileDescriptor.AutoCloseInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.760 -0500", hash_original_field = "9B1849AEC403CCCD9B11224F99438BE6", hash_generated_field = "6A4F127DC4966865D6C91B71BF7CBFD7")

        private long mRemaining;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.763 -0500", hash_original_method = "7289ECB48E55CD5885F0914EF0F43EDF", hash_generated_method = "C79C714C04F028E13A8F428C987B2823")
        
public AutoCloseInputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            super.skip(fd.getStartOffset());
            mRemaining = (int)fd.getLength();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.765 -0500", hash_original_method = "7717D4D64B71963D2E03703366A3F767", hash_generated_method = "2FDA3991AC089B6C65564942F9217BA8")
        
@Override
        public int available() throws IOException {
            /*
            return mRemaining >= 0
                    ? (mRemaining < 0x7fffffff ? (int)mRemaining : 0x7fffffff)
                    : super.available();
            */
            return (int)(mRemaining + super.available());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.768 -0500", hash_original_method = "CAA8FF401C122C408179370071B2636B", hash_generated_method = "133480537539C593AACA5B34163DC7D7")
        
@Override
        public int read() throws IOException {
            byte[] buffer = new byte[1];
            int result = read(buffer, 0, 1);
            //return result == -1 ? -1 : buffer[0] & 0xff;
            return (result + buffer[0]);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.771 -0500", hash_original_method = "9675FBC56EDFB22EFDB5A62982BF1091", hash_generated_method = "367348FC8B4441B579089B440A81D12C")
        
@Override
        public int read(byte[] buffer, int offset, int count) throws IOException {
            if (mRemaining >= 0) {
                if (mRemaining == 0) return -1;
                if (count > mRemaining) count = (int)mRemaining;
                int res = super.read(buffer, offset, count);
                if (res >= 0) mRemaining -= res;
                return res;
            }
            
            return super.read(buffer, offset, count);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.773 -0500", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "719B70FE11F60F1AC9724DB275BA1BD6")
        
@Override
        public int read(byte[] buffer) throws IOException {
            return read(buffer, 0, buffer.length);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.776 -0500", hash_original_method = "A933078BF27D250D6509D415A1A48695", hash_generated_method = "232DE9A9D08AD1450071EA1B00669074")
        
@Override
        public long skip(long count) throws IOException {
            if (mRemaining >= 0) {
                if (mRemaining == 0) return -1;
                if (count > mRemaining) count = mRemaining;
                long res = super.skip(count);
                if (res >= 0) mRemaining -= res;
                return res;
            }
            
            return super.skip(count);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.779 -0500", hash_original_method = "002645BE6DC8A0ABDC3AC933CA6AFCE2", hash_generated_method = "8DF92F7793A770886964C55CA059E5B1")
        
@Override
        public void mark(int readlimit) {
            if (mRemaining >= 0) {
                // Not supported.
                return;
            }
            super.mark(readlimit);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.781 -0500", hash_original_method = "2AE31565D7E15B3ED03E3797DC0147F2", hash_generated_method = "5402FA5AEB79545236C776B57B1DA108")
        
@Override
        public boolean markSupported() {
            if (mRemaining >= 0) {
                return false;
            }
            return super.markSupported();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.784 -0500", hash_original_method = "579C70BE1F6B8B8FD4382F7193B33D00", hash_generated_method = "7DC303A7EF18C20A3EDEE1150CD0ED69")
        
@Override
        public synchronized void reset() throws IOException {
            if (mRemaining >= 0) {
                // Not supported.
                return;
            }
            super.reset();
        }
        
    }
    
    public static class AutoCloseOutputStream extends ParcelFileDescriptor.AutoCloseOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.789 -0500", hash_original_field = "9B1849AEC403CCCD9B11224F99438BE6", hash_generated_field = "6A4F127DC4966865D6C91B71BF7CBFD7")

        private long mRemaining;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.791 -0500", hash_original_method = "079EE52ECDC98DA80188ACB762BDECCE", hash_generated_method = "76167BDED690D299F2FBBA6D6A4C205D")
        
public AutoCloseOutputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            if (fd.getParcelFileDescriptor().seekTo(fd.getStartOffset()) < 0) {
                throw new IOException("Unable to seek");
            }
            mRemaining = (int)fd.getLength();
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.794 -0500", hash_original_method = "35A99E3D460555EE5E79B5F1CF4B3E8C", hash_generated_method = "99396FCB85956551DAF75A652F058F75")
        
@Override
        public void write(byte[] buffer, int offset, int count) throws IOException {
            if (mRemaining >= 0) {
                if (mRemaining == 0) return;
                if (count > mRemaining) count = (int)mRemaining;
                super.write(buffer, offset, count);
                mRemaining -= count;
                return;
            }
            
            super.write(buffer, offset, count);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.796 -0500", hash_original_method = "4A27A012BA515BCAA339C3F9D7D659AA", hash_generated_method = "C9BADE41350B88B7A7E61999E744FB74")
        
@Override
        public void write(byte[] buffer) throws IOException {
            if (mRemaining >= 0) {
                if (mRemaining == 0) return;
                int count = buffer.length;
                if (count > mRemaining) count = (int)mRemaining;
                super.write(buffer);
                mRemaining -= count;
                return;
            }
            
            super.write(buffer);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.799 -0500", hash_original_method = "1210B34247DB6E03D45CB2428D3624D7", hash_generated_method = "332339B8451EA97A43A552B9C585D46F")
        
@Override
        public void write(int oneByte) throws IOException {
            if (mRemaining >= 0) {
                if (mRemaining == 0) return;
                super.write(oneByte);
                mRemaining--;
                return;
            }
            
            super.write(oneByte);
        }
        
    }
    
    /* Parcelable interface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.803 -0500", hash_original_method = "0879BA3E6020CB54A0A428F518BD5C8A", hash_generated_method = "EFFB3C4548C45015B0D9B8D762F1DDE8")
    
public int describeContents() {
        return mFd.describeContents();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.805 -0500", hash_original_method = "FCAECA18F17390C63AF97C29D61A7F69", hash_generated_method = "04F78D42D902BAA983304466CC17FBBC")
    
public void writeToParcel(Parcel out, int flags) {
        mFd.writeToParcel(out, flags);
        out.writeLong(mStartOffset);
        out.writeLong(mLength);
    }
    // orphaned legacy method
    public AssetFileDescriptor createFromParcel(Parcel in) {
            return new AssetFileDescriptor(in);
        }
    
    // orphaned legacy method
    public AssetFileDescriptor[] newArray(int size) {
            return new AssetFileDescriptor[size];
        }
    
}

