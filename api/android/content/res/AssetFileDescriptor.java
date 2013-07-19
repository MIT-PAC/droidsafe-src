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
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AssetFileDescriptor implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.909 -0400", hash_original_field = "E2307FD862BA74C9C9C26ACA0B7E5364", hash_generated_field = "AE959CCFA06A07F93FA2A8BEED883021")

    private ParcelFileDescriptor mFd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.909 -0400", hash_original_field = "3DABB18D4F451E36446933F4C828ACE8", hash_generated_field = "286E6AACFD37B23A56DE152AEA0EBEB7")

    private long mStartOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.909 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "56354C84F68C232CB4A6660E662F1AD3")

    private long mLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.910 -0400", hash_original_method = "DC4E6AC867A43EED90FFB40A290359DB", hash_generated_method = "ACCDC49C8FAB0D56D701C5EDB1B9EB19")
    public  AssetFileDescriptor(ParcelFileDescriptor fd, long startOffset,
            long length) {
        if(length < 0 && startOffset != 0)        
        {
            IllegalArgumentException varB3512AB4186134165A44A70721E982E7_478269615 = new IllegalArgumentException(
                    "startOffset must be 0 when using UNKNOWN_LENGTH");
            varB3512AB4186134165A44A70721E982E7_478269615.addTaint(taint);
            throw varB3512AB4186134165A44A70721E982E7_478269615;
        } //End block
        mFd = fd;
        mStartOffset = startOffset;
        mLength = length;
        // ---------- Original Method ----------
        //if (length < 0 && startOffset != 0) {
            //throw new IllegalArgumentException(
                    //"startOffset must be 0 when using UNKNOWN_LENGTH");
        //}
        //mFd = fd;
        //mStartOffset = startOffset;
        //mLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.911 -0400", hash_original_method = "1F42E1B919C11896F377AE3DA953160B", hash_generated_method = "3C7A316DB7AFE16926A7B8C36ED59BCC")
      AssetFileDescriptor(Parcel src) {
        mFd = ParcelFileDescriptor.CREATOR.createFromParcel(src);
        mStartOffset = src.readLong();
        mLength = src.readLong();
        // ---------- Original Method ----------
        //mFd = ParcelFileDescriptor.CREATOR.createFromParcel(src);
        //mStartOffset = src.readLong();
        //mLength = src.readLong();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.912 -0400", hash_original_method = "9E61752120AEDC1582A5E495568F317A", hash_generated_method = "F5EA1E44DCDB0436756E6AD6635CC293")
    public ParcelFileDescriptor getParcelFileDescriptor() {
ParcelFileDescriptor varA2020F057EE0C4681E5D494D56A7C135_90232845 =         mFd;
        varA2020F057EE0C4681E5D494D56A7C135_90232845.addTaint(taint);
        return varA2020F057EE0C4681E5D494D56A7C135_90232845;
        // ---------- Original Method ----------
        //return mFd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.912 -0400", hash_original_method = "44C1CE26DE6098783D46BD5B3EB1BDD6", hash_generated_method = "9432DAE106B27E908272052B4C3E4859")
    public FileDescriptor getFileDescriptor() {
FileDescriptor varE1F1962AEBAD268B7AA58A52652DD259_432765167 =         mFd.getFileDescriptor();
        varE1F1962AEBAD268B7AA58A52652DD259_432765167.addTaint(taint);
        return varE1F1962AEBAD268B7AA58A52652DD259_432765167;
        // ---------- Original Method ----------
        //return mFd.getFileDescriptor();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.912 -0400", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "CFAE672C1D442BC5E2CD3F37356A910D")
    public long getStartOffset() {
        long var3DABB18D4F451E36446933F4C828ACE8_475681867 = (mStartOffset);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_250627388 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_250627388;
        // ---------- Original Method ----------
        //return mStartOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.913 -0400", hash_original_method = "CF0C8205090CB57B9B1EACE80CFEFFE6", hash_generated_method = "CA1312525AF931F4966345EA1EC15CCD")
    public long getLength() {
        if(mLength >= 0)        
        {
            long var429F431E8CD8AC287AA27460675EAEFE_1321034166 = (mLength);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_50167638 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_50167638;
        } //End block
        long len = mFd.getStatSize();
        long var0B719F927E8F117BDAFF56591042D6FB_844977156 = (len >= 0 ? len : UNKNOWN_LENGTH);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1824016047 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1824016047;
        // ---------- Original Method ----------
        //if (mLength >= 0) {
            //return mLength;
        //}
        //long len = mFd.getStatSize();
        //return len >= 0 ? len : UNKNOWN_LENGTH;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.914 -0400", hash_original_method = "017FD707368B4170A32A7494D8D576FE", hash_generated_method = "6A2ED2FC881F174540D9CCEE2C2368E4")
    public long getDeclaredLength() {
        long var429F431E8CD8AC287AA27460675EAEFE_1056988965 = (mLength);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_895908576 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_895908576;
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.914 -0400", hash_original_method = "491F69AA4FD12992599C16C8B0915773", hash_generated_method = "7B9DF8EE0EA99115EB3CD369EE1E6439")
    public void close() throws IOException {
        mFd.close();
        // ---------- Original Method ----------
        //mFd.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.914 -0400", hash_original_method = "6638264422E2A7F83EB5780796593D58", hash_generated_method = "F95C6810F4762ADE963992FCEF403C93")
    public FileInputStream createInputStream() throws IOException {
        if(mLength < 0)        
        {
FileInputStream varEF24DBCBCD4752A1C1B3ADD9F7C73988_113589766 =             new ParcelFileDescriptor.AutoCloseInputStream(mFd);
            varEF24DBCBCD4752A1C1B3ADD9F7C73988_113589766.addTaint(taint);
            return varEF24DBCBCD4752A1C1B3ADD9F7C73988_113589766;
        } //End block
FileInputStream varB7E13BA4CA2B8A7FC10C543D77BE2739_1591861297 =         new AutoCloseInputStream(this);
        varB7E13BA4CA2B8A7FC10C543D77BE2739_1591861297.addTaint(taint);
        return varB7E13BA4CA2B8A7FC10C543D77BE2739_1591861297;
        // ---------- Original Method ----------
        //if (mLength < 0) {
            //return new ParcelFileDescriptor.AutoCloseInputStream(mFd);
        //}
        //return new AutoCloseInputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.915 -0400", hash_original_method = "221DC8DE3671455AA557297DC19DE0C7", hash_generated_method = "8CEB31CAE2B75BC280828B7509651A19")
    public FileOutputStream createOutputStream() throws IOException {
        if(mLength < 0)        
        {
FileOutputStream varC8528CBB18F21826401B122D7340E8D9_486312202 =             new ParcelFileDescriptor.AutoCloseOutputStream(mFd);
            varC8528CBB18F21826401B122D7340E8D9_486312202.addTaint(taint);
            return varC8528CBB18F21826401B122D7340E8D9_486312202;
        } //End block
FileOutputStream varA761DD43DBE68E9165A4D1238397668F_614338894 =         new AutoCloseOutputStream(this);
        varA761DD43DBE68E9165A4D1238397668F_614338894.addTaint(taint);
        return varA761DD43DBE68E9165A4D1238397668F_614338894;
        // ---------- Original Method ----------
        //if (mLength < 0) {
            //return new ParcelFileDescriptor.AutoCloseOutputStream(mFd);
        //}
        //return new AutoCloseOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.916 -0400", hash_original_method = "7D4F991E1E50267AE78D06F4481657CB", hash_generated_method = "B28A462F6B9A2E643BD62BA0D1DE4522")
    @Override
    public String toString() {
String varBCC72A648A1B956D0D083D4BD8697C29_719345300 =         "{AssetFileDescriptor: " + mFd
                + " start=" + mStartOffset + " len=" + mLength + "}";
        varBCC72A648A1B956D0D083D4BD8697C29_719345300.addTaint(taint);
        return varBCC72A648A1B956D0D083D4BD8697C29_719345300;
        // ---------- Original Method ----------
        //return "{AssetFileDescriptor: " + mFd
                //+ " start=" + mStartOffset + " len=" + mLength + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.917 -0400", hash_original_method = "0879BA3E6020CB54A0A428F518BD5C8A", hash_generated_method = "01530F11585FC3A7914C48700B673FAA")
    public int describeContents() {
        int varDB5AF88C7B512B080FACBB611680962E_1701269159 = (mFd.describeContents());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1084538730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1084538730;
        // ---------- Original Method ----------
        //return mFd.describeContents();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.917 -0400", hash_original_method = "FCAECA18F17390C63AF97C29D61A7F69", hash_generated_method = "010805410BE1497A683F140F20FCF855")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        mFd.writeToParcel(out, flags);
        out.writeLong(mStartOffset);
        out.writeLong(mLength);
        // ---------- Original Method ----------
        //mFd.writeToParcel(out, flags);
        //out.writeLong(mStartOffset);
        //out.writeLong(mLength);
    }

    
    public static class AutoCloseInputStream extends ParcelFileDescriptor.AutoCloseInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.918 -0400", hash_original_field = "07D38A3C377769B1B7C135193212D00C", hash_generated_field = "6A4F127DC4966865D6C91B71BF7CBFD7")

        private long mRemaining;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.918 -0400", hash_original_method = "7289ECB48E55CD5885F0914EF0F43EDF", hash_generated_method = "F1017B8EC8BDBBF3B62D546CB970A24A")
        public  AutoCloseInputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            super.skip(fd.getStartOffset());
            mRemaining = (int)fd.getLength();
            // ---------- Original Method ----------
            //super.skip(fd.getStartOffset());
            //mRemaining = (int)fd.getLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.919 -0400", hash_original_method = "7717D4D64B71963D2E03703366A3F767", hash_generated_method = "B54D4282B9418BFB40A2B9C905C89714")
        @Override
        public int available() throws IOException {
            int var66F4FC13D94481FC8E1ADDCD0009BEDC_556001223 = (mRemaining >= 0
                    ? (mRemaining < 0x7fffffff ? (int)mRemaining : 0x7fffffff)
                    : super.available());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121718768 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121718768;
            // ---------- Original Method ----------
            //return mRemaining >= 0
                    //? (mRemaining < 0x7fffffff ? (int)mRemaining : 0x7fffffff)
                    //: super.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.919 -0400", hash_original_method = "CAA8FF401C122C408179370071B2636B", hash_generated_method = "B49827104F99977051E1791AF2EC090D")
        @Override
        public int read() throws IOException {
            byte[] buffer = new byte[1];
            int result = read(buffer, 0, 1);
            int var0011BFF4A37BCDDA2923E4D4D30EF25A_513208134 = (result == -1 ? -1 : buffer[0] & 0xff);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992917078 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992917078;
            // ---------- Original Method ----------
            //byte[] buffer = new byte[1];
            //int result = read(buffer, 0, 1);
            //return result == -1 ? -1 : buffer[0] & 0xff;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.920 -0400", hash_original_method = "9675FBC56EDFB22EFDB5A62982BF1091", hash_generated_method = "F8A53CF1CC944E5C5F806579D5D4DC41")
        @Override
        public int read(byte[] buffer, int offset, int count) throws IOException {
            addTaint(count);
            addTaint(offset);
            addTaint(buffer[0]);
            if(mRemaining >= 0)            
            {
                if(mRemaining == 0)                
                {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_609098469 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014444791 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014444791;
                }
                if(count > mRemaining)                
                count = (int)mRemaining;
                int res = super.read(buffer, offset, count);
                if(res >= 0)                
                mRemaining -= res;
                int var9B207167E5381C47682C6B4F58A623FB_1317414018 = (res);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661893984 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661893984;
            } //End block
            int varEDC3BC489A6EB1408A7492189745293E_1058688048 = (super.read(buffer, offset, count));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102139794 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102139794;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.920 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "03293EE1BEFA411D2363D0AB478B166D")
        @Override
        public int read(byte[] buffer) throws IOException {
            addTaint(buffer[0]);
            int varB17F7FC0C34BA0A2828AFE480EE84868_1330203785 = (read(buffer, 0, buffer.length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386094701 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386094701;
            // ---------- Original Method ----------
            //return read(buffer, 0, buffer.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.921 -0400", hash_original_method = "A933078BF27D250D6509D415A1A48695", hash_generated_method = "C3B4875D16F9B6A1F49DCC5738AF64E9")
        @Override
        public long skip(long count) throws IOException {
            addTaint(count);
            if(mRemaining >= 0)            
            {
                if(mRemaining == 0)                
                {
                long var6BB61E3B7BCE0931DA574D19D1D82C88_1362776910 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_21484658 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_21484658;
                }
                if(count > mRemaining)                
                count = mRemaining;
                long res = super.skip(count);
                if(res >= 0)                
                mRemaining -= res;
                long var9B207167E5381C47682C6B4F58A623FB_1174821811 = (res);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1538455758 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1538455758;
            } //End block
            long varA99A9A5A725C4A6383AB8F4E5E4E7520_2119196106 = (super.skip(count));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1989956091 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1989956091;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.923 -0400", hash_original_method = "002645BE6DC8A0ABDC3AC933CA6AFCE2", hash_generated_method = "7C7D84C794B25C7AF689DB0A731204DF")
        @Override
        public void mark(int readlimit) {
            addTaint(readlimit);
            if(mRemaining >= 0)            
            {
                return;
            } //End block
            super.mark(readlimit);
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return;
            //}
            //super.mark(readlimit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.924 -0400", hash_original_method = "2AE31565D7E15B3ED03E3797DC0147F2", hash_generated_method = "87AD8E27B69E4E5B8959983A1EB2AD7B")
        @Override
        public boolean markSupported() {
            if(mRemaining >= 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1749635112 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959817001 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959817001;
            } //End block
            boolean var1D49FEDA454BE1353A4F8C089DF4F30E_1050761355 = (super.markSupported());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007973248 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007973248;
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return false;
            //}
            //return super.markSupported();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.925 -0400", hash_original_method = "579C70BE1F6B8B8FD4382F7193B33D00", hash_generated_method = "D965CDC6349115A765A5282AD141C8DD")
        @Override
        public synchronized void reset() throws IOException {
            if(mRemaining >= 0)            
            {
                return;
            } //End block
            super.reset();
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return;
            //}
            //super.reset();
        }

        
    }


    
    public static class AutoCloseOutputStream extends ParcelFileDescriptor.AutoCloseOutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.925 -0400", hash_original_field = "07D38A3C377769B1B7C135193212D00C", hash_generated_field = "6A4F127DC4966865D6C91B71BF7CBFD7")

        private long mRemaining;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.926 -0400", hash_original_method = "079EE52ECDC98DA80188ACB762BDECCE", hash_generated_method = "18B8D94CE1C3C70AFD9F9A9952CE4448")
        public  AutoCloseOutputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            if(fd.getParcelFileDescriptor().seekTo(fd.getStartOffset()) < 0)            
            {
                IOException var682A00F07B0E09BF37F8CA047EFF5F34_1647268145 = new IOException("Unable to seek");
                var682A00F07B0E09BF37F8CA047EFF5F34_1647268145.addTaint(taint);
                throw var682A00F07B0E09BF37F8CA047EFF5F34_1647268145;
            } //End block
            mRemaining = (int)fd.getLength();
            // ---------- Original Method ----------
            //if (fd.getParcelFileDescriptor().seekTo(fd.getStartOffset()) < 0) {
                //throw new IOException("Unable to seek");
            //}
            //mRemaining = (int)fd.getLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.927 -0400", hash_original_method = "35A99E3D460555EE5E79B5F1CF4B3E8C", hash_generated_method = "8E8DBE6E924603FA7B5E0BA2AE98207A")
        @Override
        public void write(byte[] buffer, int offset, int count) throws IOException {
            addTaint(offset);
            addTaint(buffer[0]);
            if(mRemaining >= 0)            
            {
                if(mRemaining == 0)                
                return;
                if(count > mRemaining)                
                count = (int)mRemaining;
                super.write(buffer, offset, count);
                mRemaining -= count;
                return;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.927 -0400", hash_original_method = "4A27A012BA515BCAA339C3F9D7D659AA", hash_generated_method = "F660BA9C99EC52176F5473D60678FD2F")
        @Override
        public void write(byte[] buffer) throws IOException {
            addTaint(buffer[0]);
            if(mRemaining >= 0)            
            {
                if(mRemaining == 0)                
                return;
                int count = buffer.length;
                if(count > mRemaining)                
                count = (int)mRemaining;
                super.write(buffer);
                mRemaining -= count;
                return;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.928 -0400", hash_original_method = "1210B34247DB6E03D45CB2428D3624D7", hash_generated_method = "CDBE5921F67C227C0ED312194A4DF374")
        @Override
        public void write(int oneByte) throws IOException {
            addTaint(oneByte);
            if(mRemaining >= 0)            
            {
                if(mRemaining == 0)                
                return;
                super.write(oneByte);
                mRemaining--;
                return;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.928 -0400", hash_original_field = "CB0B57BF70999A7621B00BD40DFABFF8", hash_generated_field = "4FE9A1DE5214CFC95E635BC2E3ADC963")

    public static final long UNKNOWN_LENGTH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.928 -0400", hash_original_field = "55F81C540A0F490F18AFC67EA63DC2AC", hash_generated_field = "C848EEBB0F7783D5E330997BE762ED30")

    public static final Parcelable.Creator<AssetFileDescriptor> CREATOR
            = new Parcelable.Creator<AssetFileDescriptor>() {
        public AssetFileDescriptor createFromParcel(Parcel in) {
            return new AssetFileDescriptor(in);
        }
        public AssetFileDescriptor[] newArray(int size) {
            return new AssetFileDescriptor[size];
        }
    };
    // orphaned legacy method
    public AssetFileDescriptor createFromParcel(Parcel in) {
            return new AssetFileDescriptor(in);
        }
    
    // orphaned legacy method
    public AssetFileDescriptor[] newArray(int size) {
            return new AssetFileDescriptor[size];
        }
    
}

