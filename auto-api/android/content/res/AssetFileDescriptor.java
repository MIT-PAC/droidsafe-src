package android.content.res;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class AssetFileDescriptor implements Parcelable {
    public static final long UNKNOWN_LENGTH = -1;
    private final ParcelFileDescriptor mFd;
    private final long mStartOffset;
    private final long mLength;
    public static final Parcelable.Creator<AssetFileDescriptor> CREATOR = new Parcelable.Creator<AssetFileDescriptor>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.184 -0400", hash_original_method = "1A4F03E8300F0259C61020522681AA45", hash_generated_method = "3ED5D9E7D4FC7FFB643C23D4F9B1695C")
        @DSModeled(DSC.SAFE)
        public AssetFileDescriptor createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (AssetFileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AssetFileDescriptor(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.185 -0400", hash_original_method = "CAD0361A5B33BFD049C2AE43787539DA", hash_generated_method = "BE2B2137AA8112DF920AE676066E683C")
        @DSModeled(DSC.SAFE)
        public AssetFileDescriptor[] newArray(int size) {
            dsTaint.addTaint(size);
            return (AssetFileDescriptor[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AssetFileDescriptor[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.187 -0400", hash_original_method = "DC4E6AC867A43EED90FFB40A290359DB", hash_generated_method = "552DFE4FE7E98B1C842718A53FAE48D8")
    @DSModeled(DSC.SAFE)
    public AssetFileDescriptor(ParcelFileDescriptor fd, long startOffset,
            long length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(startOffset);
        {
            throw new IllegalArgumentException(
                    "startOffset must be 0 when using UNKNOWN_LENGTH");
        } //End block
        // ---------- Original Method ----------
        //if (length < 0 && startOffset != 0) {
            //throw new IllegalArgumentException(
                    //"startOffset must be 0 when using UNKNOWN_LENGTH");
        //}
        //mFd = fd;
        //mStartOffset = startOffset;
        //mLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.188 -0400", hash_original_method = "1F42E1B919C11896F377AE3DA953160B", hash_generated_method = "81F94AFEB69FEE27179C8CCA8544D0A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AssetFileDescriptor(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mFd = ParcelFileDescriptor.CREATOR.createFromParcel(src);
        mStartOffset = src.readLong();
        mLength = src.readLong();
        // ---------- Original Method ----------
        //mFd = ParcelFileDescriptor.CREATOR.createFromParcel(src);
        //mStartOffset = src.readLong();
        //mLength = src.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.189 -0400", hash_original_method = "9E61752120AEDC1582A5E495568F317A", hash_generated_method = "7F3132FA9ECFA2BD8964CDB00C9721DD")
    @DSModeled(DSC.SAFE)
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.189 -0400", hash_original_method = "44C1CE26DE6098783D46BD5B3EB1BDD6", hash_generated_method = "A477CF5120C365E9AAA8A12D7E5B4792")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor getFileDescriptor() {
        FileDescriptor var81FCA9E565538FFEE5656A282219DBC5_1076926286 = (mFd.getFileDescriptor());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFd.getFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.189 -0400", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "B610A8246E363942F17024A5CCC3A716")
    @DSModeled(DSC.SAFE)
    public long getStartOffset() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.190 -0400", hash_original_method = "CF0C8205090CB57B9B1EACE80CFEFFE6", hash_generated_method = "1D8FB6E066BC7B1612E5C426C9FC9AF2")
    @DSModeled(DSC.SAFE)
    public long getLength() {
        long len;
        len = mFd.getStatSize();
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (mLength >= 0) {
            //return mLength;
        //}
        //long len = mFd.getStatSize();
        //return len >= 0 ? len : UNKNOWN_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.190 -0400", hash_original_method = "017FD707368B4170A32A7494D8D576FE", hash_generated_method = "25B365C6F532DF1EABEBBEE9B627AC3B")
    @DSModeled(DSC.SAFE)
    public long getDeclaredLength() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.190 -0400", hash_original_method = "491F69AA4FD12992599C16C8B0915773", hash_generated_method = "5D5179C7F6FAF34BDEE3EE09E8606786")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        mFd.close();
        // ---------- Original Method ----------
        //mFd.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.190 -0400", hash_original_method = "6638264422E2A7F83EB5780796593D58", hash_generated_method = "E5694F45DC2BEF7807E4895173F2A11B")
    @DSModeled(DSC.SAFE)
    public FileInputStream createInputStream() throws IOException {
        return (FileInputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mLength < 0) {
            //return new ParcelFileDescriptor.AutoCloseInputStream(mFd);
        //}
        //return new AutoCloseInputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.190 -0400", hash_original_method = "221DC8DE3671455AA557297DC19DE0C7", hash_generated_method = "144A079820E41BB75CC21046B72076DF")
    @DSModeled(DSC.SAFE)
    public FileOutputStream createOutputStream() throws IOException {
        return (FileOutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mLength < 0) {
            //return new ParcelFileDescriptor.AutoCloseOutputStream(mFd);
        //}
        //return new AutoCloseOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.191 -0400", hash_original_method = "7D4F991E1E50267AE78D06F4481657CB", hash_generated_method = "0BA44CC2905370CDCBD298C8F6923772")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "{AssetFileDescriptor: " + mFd
                //+ " start=" + mStartOffset + " len=" + mLength + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.191 -0400", hash_original_method = "0879BA3E6020CB54A0A428F518BD5C8A", hash_generated_method = "68C2629BFE5BB00A0C268CB5C3D76410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int describeContents() {
        int var6E89DB6436784982CFB76FA78673DA45_470406473 = (mFd.describeContents());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFd.describeContents();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.191 -0400", hash_original_method = "FCAECA18F17390C63AF97C29D61A7F69", hash_generated_method = "A0CD1DA2DF077807ABC5263C03B613A7")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        mFd.writeToParcel(out, flags);
        out.writeLong(mStartOffset);
        out.writeLong(mLength);
        // ---------- Original Method ----------
        //mFd.writeToParcel(out, flags);
        //out.writeLong(mStartOffset);
        //out.writeLong(mLength);
    }

    
    public static class AutoCloseInputStream extends ParcelFileDescriptor.AutoCloseInputStream {
        private long mRemaining;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.191 -0400", hash_original_method = "7289ECB48E55CD5885F0914EF0F43EDF", hash_generated_method = "67F2692CC4C0C62F7A2A4A69AC8DE2B5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AutoCloseInputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            dsTaint.addTaint(fd.dsTaint);
            super.skip(fd.getStartOffset());
            mRemaining = (int)fd.getLength();
            // ---------- Original Method ----------
            //super.skip(fd.getStartOffset());
            //mRemaining = (int)fd.getLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.192 -0400", hash_original_method = "7717D4D64B71963D2E03703366A3F767", hash_generated_method = "BF29B0673587AC651D944BE6F4F7A104")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int available() throws IOException {
            {
                Object var6698ECBC27A3D6C11D735685C1254F7A_1447488949 = (super.available());
            } //End flattened ternary
            //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mRemaining >= 0
                    //? (mRemaining < 0x7fffffff ? (int)mRemaining : 0x7fffffff)
                    //: super.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.192 -0400", hash_original_method = "CAA8FF401C122C408179370071B2636B", hash_generated_method = "91988E230931336B2B26B885C2C2C736")
        @DSModeled(DSC.SAFE)
        @Override
        public int read() throws IOException {
            byte[] buffer;
            buffer = new byte[1];
            int result;
            result = read(buffer, 0, 1);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //byte[] buffer = new byte[1];
            //int result = read(buffer, 0, 1);
            //return result == -1 ? -1 : buffer[0] & 0xff;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.192 -0400", hash_original_method = "9675FBC56EDFB22EFDB5A62982BF1091", hash_generated_method = "A44A2A81855DB68D6A884AEFBFE4CF06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buffer, int offset, int count) throws IOException {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(count);
            dsTaint.addTaint(offset);
            {
                count = (int)mRemaining;
                int res;
                res = super.read(buffer, offset, count);
                mRemaining -= res;
            } //End block
            int var38013EA3FB183FB46AAC4E06CE6EB79F_842822443 = (super.read(buffer, offset, count));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //if (mRemaining == 0) return -1;
                //if (count > mRemaining) count = (int)mRemaining;
                //int res = super.read(buffer, offset, count);
                //if (res >= 0) mRemaining -= res;
                //return res;
            //}
            //return super.read(buffer, offset, count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.192 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "684D1A604F06137F2B9DEEF5495F9772")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buffer) throws IOException {
            dsTaint.addTaint(buffer);
            int var6345393F45692C8B243D9AAC70C2EFB3_672901756 = (read(buffer, 0, buffer.length));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return read(buffer, 0, buffer.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.193 -0400", hash_original_method = "A933078BF27D250D6509D415A1A48695", hash_generated_method = "199876BDBD992D9BC232A6BEA4BE601E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public long skip(long count) throws IOException {
            dsTaint.addTaint(count);
            {
                count = mRemaining;
                long res;
                res = super.skip(count);
                mRemaining -= res;
            } //End block
            long var5AED96CD04AD869E0322F3DF1B163422_716416540 = (super.skip(count));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //if (mRemaining == 0) return -1;
                //if (count > mRemaining) count = mRemaining;
                //long res = super.skip(count);
                //if (res >= 0) mRemaining -= res;
                //return res;
            //}
            //return super.skip(count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.193 -0400", hash_original_method = "002645BE6DC8A0ABDC3AC933CA6AFCE2", hash_generated_method = "DF6A8B0F93BD1B0D76F5A5BD4AA319A7")
        @DSModeled(DSC.SAFE)
        @Override
        public void mark(int readlimit) {
            dsTaint.addTaint(readlimit);
            super.mark(readlimit);
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return;
            //}
            //super.mark(readlimit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.193 -0400", hash_original_method = "2AE31565D7E15B3ED03E3797DC0147F2", hash_generated_method = "556FA625269EAAD8767903BEEE5B6104")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean markSupported() {
            boolean varAE14FF4A7F97D4826F48B41B2489304A_712666475 = (super.markSupported());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return false;
            //}
            //return super.markSupported();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.193 -0400", hash_original_method = "579C70BE1F6B8B8FD4382F7193B33D00", hash_generated_method = "723F670BEDDAFFEF03988097A7CEEA7B")
        @DSModeled(DSC.SAFE)
        @Override
        public synchronized void reset() throws IOException {
            super.reset();
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return;
            //}
            //super.reset();
        }

        
    }


    
    public static class AutoCloseOutputStream extends ParcelFileDescriptor.AutoCloseOutputStream {
        private long mRemaining;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.193 -0400", hash_original_method = "079EE52ECDC98DA80188ACB762BDECCE", hash_generated_method = "960EBC9C2118697E4650A95C9FA932CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AutoCloseOutputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            dsTaint.addTaint(fd.dsTaint);
            {
                boolean varFC3E12886C3AF3F36795BDDCB288EB5D_519738423 = (fd.getParcelFileDescriptor().seekTo(fd.getStartOffset()) < 0);
                {
                	if (DroidSafeAndroidRuntime.control)throw new IOException("Unable to seek");
                } //End block
            } //End collapsed parenthetic
            mRemaining = (int)fd.getLength();
            // ---------- Original Method ----------
            //if (fd.getParcelFileDescriptor().seekTo(fd.getStartOffset()) < 0) {
                //throw new IOException("Unable to seek");
            //}
            //mRemaining = (int)fd.getLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.194 -0400", hash_original_method = "35A99E3D460555EE5E79B5F1CF4B3E8C", hash_generated_method = "ECF946A379987BF92C4BEF3A383B53DF")
        @DSModeled(DSC.SAFE)
        @Override
        public void write(byte[] buffer, int offset, int count) throws IOException {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(count);
            dsTaint.addTaint(offset);
            {
                count = (int)mRemaining;
                super.write(buffer, offset, count);
            } //End block
            super.write(buffer, offset, count);
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //if (mRemaining == 0) return;
                //if (count > mRemaining) count = (int)mRemaining;
                //super.write(buffer, offset, count);
                //mRemaining -= count;
                //return;
            //}
            //super.write(buffer, offset, count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.194 -0400", hash_original_method = "4A27A012BA515BCAA339C3F9D7D659AA", hash_generated_method = "CC44684ECDAE0A88E50302CE795E14E3")
        @DSModeled(DSC.SAFE)
        @Override
        public void write(byte[] buffer) throws IOException {
            dsTaint.addTaint(buffer);
            {
                int count;
                count = buffer.length;
                count = (int)mRemaining;
                super.write(buffer);
                mRemaining -= count;
            } //End block
            super.write(buffer);
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //if (mRemaining == 0) return;
                //int count = buffer.length;
                //if (count > mRemaining) count = (int)mRemaining;
                //super.write(buffer);
                //mRemaining -= count;
                //return;
            //}
            //super.write(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.194 -0400", hash_original_method = "1210B34247DB6E03D45CB2428D3624D7", hash_generated_method = "3120EA1307FBA2D7C3A9C3886EF1E5E9")
        @DSModeled(DSC.SAFE)
        @Override
        public void write(int oneByte) throws IOException {
            dsTaint.addTaint(oneByte);
            {
                super.write(oneByte);
                mRemaining--;
            } //End block
            super.write(oneByte);
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //if (mRemaining == 0) return;
                //super.write(oneByte);
                //mRemaining--;
                //return;
            //}
            //super.write(oneByte);
        }

        
    }


    
}


