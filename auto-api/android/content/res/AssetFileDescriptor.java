package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AssetFileDescriptor implements Parcelable {
    private ParcelFileDescriptor mFd;
    private long mStartOffset;
    private long mLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.025 -0400", hash_original_method = "DC4E6AC867A43EED90FFB40A290359DB", hash_generated_method = "562F30445053366EC631F223B6E09FAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssetFileDescriptor(ParcelFileDescriptor fd, long startOffset,
            long length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(startOffset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.026 -0400", hash_original_method = "1F42E1B919C11896F377AE3DA953160B", hash_generated_method = "1D20F64EAB1E506E9178DD57CB6BAE03")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.027 -0400", hash_original_method = "9E61752120AEDC1582A5E495568F317A", hash_generated_method = "99525A1748DEAA82CB06201D3774910F")
    @DSModeled(DSC.SAFE)
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.027 -0400", hash_original_method = "44C1CE26DE6098783D46BD5B3EB1BDD6", hash_generated_method = "B63EBED3F4001AC61E3511956F3D1EE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor getFileDescriptor() {
        FileDescriptor var81FCA9E565538FFEE5656A282219DBC5_736294315 = (mFd.getFileDescriptor());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFd.getFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.027 -0400", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "13A033B78E54C5CAB0085FCECCF3964F")
    @DSModeled(DSC.SAFE)
    public long getStartOffset() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.028 -0400", hash_original_method = "CF0C8205090CB57B9B1EACE80CFEFFE6", hash_generated_method = "57BA8740F0D86F90EF7B3513396D52AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.028 -0400", hash_original_method = "017FD707368B4170A32A7494D8D576FE", hash_generated_method = "14DD25158FDD35EDC3CBE35E5EE439FC")
    @DSModeled(DSC.SAFE)
    public long getDeclaredLength() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.028 -0400", hash_original_method = "491F69AA4FD12992599C16C8B0915773", hash_generated_method = "7B9DF8EE0EA99115EB3CD369EE1E6439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        mFd.close();
        // ---------- Original Method ----------
        //mFd.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.029 -0400", hash_original_method = "6638264422E2A7F83EB5780796593D58", hash_generated_method = "CBB6F526534B4D06A2135CEDCE8E4B40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileInputStream createInputStream() throws IOException {
        {
            FileInputStream var34AB4F1394612BD91E1B18D0AE985962_1059328022 = (new ParcelFileDescriptor.AutoCloseInputStream(mFd));
        } //End block
        FileInputStream varD1C47E258C2000D8D27B3289EFA808F6_212184335 = (new AutoCloseInputStream(this));
        return (FileInputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mLength < 0) {
            //return new ParcelFileDescriptor.AutoCloseInputStream(mFd);
        //}
        //return new AutoCloseInputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.029 -0400", hash_original_method = "221DC8DE3671455AA557297DC19DE0C7", hash_generated_method = "EC82E558FABB732BF2D34A36D1BCB469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileOutputStream createOutputStream() throws IOException {
        {
            FileOutputStream var7AB6D40904D04891D858F629F715B922_403032313 = (new ParcelFileDescriptor.AutoCloseOutputStream(mFd));
        } //End block
        FileOutputStream var7822FF0A4780761BA1EA7B5B3FD6CD0D_226333548 = (new AutoCloseOutputStream(this));
        return (FileOutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mLength < 0) {
            //return new ParcelFileDescriptor.AutoCloseOutputStream(mFd);
        //}
        //return new AutoCloseOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.029 -0400", hash_original_method = "7D4F991E1E50267AE78D06F4481657CB", hash_generated_method = "B403AE61CD82EF6B6900648E31BCEE92")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "{AssetFileDescriptor: " + mFd
                //+ " start=" + mStartOffset + " len=" + mLength + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.030 -0400", hash_original_method = "0879BA3E6020CB54A0A428F518BD5C8A", hash_generated_method = "1D9DEF31792FD93AE12B5ECF174A7046")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int describeContents() {
        int var6E89DB6436784982CFB76FA78673DA45_275289254 = (mFd.describeContents());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFd.describeContents();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.030 -0400", hash_original_method = "FCAECA18F17390C63AF97C29D61A7F69", hash_generated_method = "DA08F1C26E4E82225EB64439CC725244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.030 -0400", hash_original_method = "7289ECB48E55CD5885F0914EF0F43EDF", hash_generated_method = "31F0C47BFF6840D8692136D39E005CD8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.031 -0400", hash_original_method = "7717D4D64B71963D2E03703366A3F767", hash_generated_method = "A62CE6F2C64190BE0C8E97AC1F66663A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int available() throws IOException {
            {
                Object var6698ECBC27A3D6C11D735685C1254F7A_1151742922 = (super.available());
            } //End flattened ternary
            //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mRemaining >= 0
                    //? (mRemaining < 0x7fffffff ? (int)mRemaining : 0x7fffffff)
                    //: super.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.032 -0400", hash_original_method = "CAA8FF401C122C408179370071B2636B", hash_generated_method = "699D22FDBD5C6422AA47EEFB8A990F6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.034 -0400", hash_original_method = "9675FBC56EDFB22EFDB5A62982BF1091", hash_generated_method = "03CF175E7A416E470B0B4B080C1656BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buffer, int offset, int count) throws IOException {
            dsTaint.addTaint(buffer[0]);
            dsTaint.addTaint(count);
            dsTaint.addTaint(offset);
            {
                count = (int)mRemaining;
                int res;
                res = super.read(buffer, offset, count);
                mRemaining -= res;
            } //End block
            int var38013EA3FB183FB46AAC4E06CE6EB79F_1190600046 = (super.read(buffer, offset, count));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.035 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "CB232DF291B2132B6391C128C771C8FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buffer) throws IOException {
            dsTaint.addTaint(buffer[0]);
            int var6345393F45692C8B243D9AAC70C2EFB3_478486091 = (read(buffer, 0, buffer.length));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return read(buffer, 0, buffer.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.035 -0400", hash_original_method = "A933078BF27D250D6509D415A1A48695", hash_generated_method = "FB4D50856AA2DADDCEB8A855376CF6BE")
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
            long var5AED96CD04AD869E0322F3DF1B163422_1031527022 = (super.skip(count));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.035 -0400", hash_original_method = "002645BE6DC8A0ABDC3AC933CA6AFCE2", hash_generated_method = "70C60DA5C41D15C5A6AB3E9B4898FC31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.036 -0400", hash_original_method = "2AE31565D7E15B3ED03E3797DC0147F2", hash_generated_method = "7029B7CC0F992AA20288AEF20A6A3446")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean markSupported() {
            boolean varAE14FF4A7F97D4826F48B41B2489304A_1584052524 = (super.markSupported());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return false;
            //}
            //return super.markSupported();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.036 -0400", hash_original_method = "579C70BE1F6B8B8FD4382F7193B33D00", hash_generated_method = "A325832584FC9FDD8D0403EA9D063875")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.036 -0400", hash_original_method = "079EE52ECDC98DA80188ACB762BDECCE", hash_generated_method = "A201D027A69B12A5F89F9675E55E02D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AutoCloseOutputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            dsTaint.addTaint(fd.dsTaint);
            {
                boolean varFC3E12886C3AF3F36795BDDCB288EB5D_76659019 = (fd.getParcelFileDescriptor().seekTo(fd.getStartOffset()) < 0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to seek");
                } //End block
            } //End collapsed parenthetic
            mRemaining = (int)fd.getLength();
            // ---------- Original Method ----------
            //if (fd.getParcelFileDescriptor().seekTo(fd.getStartOffset()) < 0) {
                //throw new IOException("Unable to seek");
            //}
            //mRemaining = (int)fd.getLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.037 -0400", hash_original_method = "35A99E3D460555EE5E79B5F1CF4B3E8C", hash_generated_method = "FAF35B76773DBBA9EEDB848BD3D90F4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(byte[] buffer, int offset, int count) throws IOException {
            dsTaint.addTaint(buffer[0]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.037 -0400", hash_original_method = "4A27A012BA515BCAA339C3F9D7D659AA", hash_generated_method = "575FFBE583A839A4D9E56F0F81E92F8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(byte[] buffer) throws IOException {
            dsTaint.addTaint(buffer[0]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.038 -0400", hash_original_method = "1210B34247DB6E03D45CB2428D3624D7", hash_generated_method = "B32651C83B148A2BD7B62AAE50C25654")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(int oneByte) throws IOException {
            dsTaint.addTaint(oneByte);
            {
                super.write(oneByte);
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


    
    public static final long UNKNOWN_LENGTH = -1;
    public static final Parcelable.Creator<AssetFileDescriptor> CREATOR = new Parcelable.Creator<AssetFileDescriptor>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.038 -0400", hash_original_method = "1A4F03E8300F0259C61020522681AA45", hash_generated_method = "300C489617CB8F16BC5ABB9CA6F4F779")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AssetFileDescriptor createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            AssetFileDescriptor varD4A9798B7479DFF067D2488B1107DF07_732821641 = (new AssetFileDescriptor(in));
            return (AssetFileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AssetFileDescriptor(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.038 -0400", hash_original_method = "CAD0361A5B33BFD049C2AE43787539DA", hash_generated_method = "179B3DDE37F00AA7685E413E6BCE2C28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AssetFileDescriptor[] newArray(int size) {
            dsTaint.addTaint(size);
            AssetFileDescriptor[] var03CA0BDF66F692DD57EA62A009B5244F_1425480402 = (new AssetFileDescriptor[size]);
            return (AssetFileDescriptor[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AssetFileDescriptor[size];
        }

        
}; //Transformed anonymous class
}

