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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.669 -0400", hash_original_field = "E2307FD862BA74C9C9C26ACA0B7E5364", hash_generated_field = "AE959CCFA06A07F93FA2A8BEED883021")

    private ParcelFileDescriptor mFd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.670 -0400", hash_original_field = "3DABB18D4F451E36446933F4C828ACE8", hash_generated_field = "286E6AACFD37B23A56DE152AEA0EBEB7")

    private long mStartOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.670 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "56354C84F68C232CB4A6660E662F1AD3")

    private long mLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.686 -0400", hash_original_method = "DC4E6AC867A43EED90FFB40A290359DB", hash_generated_method = "03F69AB4E844C108912653C18239F0DF")
    public  AssetFileDescriptor(ParcelFileDescriptor fd, long startOffset,
            long length) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "startOffset must be 0 when using UNKNOWN_LENGTH");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.688 -0400", hash_original_method = "1F42E1B919C11896F377AE3DA953160B", hash_generated_method = "3C7A316DB7AFE16926A7B8C36ED59BCC")
      AssetFileDescriptor(Parcel src) {
        mFd = ParcelFileDescriptor.CREATOR.createFromParcel(src);
        mStartOffset = src.readLong();
        mLength = src.readLong();
        // ---------- Original Method ----------
        //mFd = ParcelFileDescriptor.CREATOR.createFromParcel(src);
        //mStartOffset = src.readLong();
        //mLength = src.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.704 -0400", hash_original_method = "9E61752120AEDC1582A5E495568F317A", hash_generated_method = "2E72203E7FE557DCC69A4DEABEA13795")
    public ParcelFileDescriptor getParcelFileDescriptor() {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1166461541 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1166461541 = mFd;
        varB4EAC82CA7396A68D541C85D26508E83_1166461541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1166461541;
        // ---------- Original Method ----------
        //return mFd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.705 -0400", hash_original_method = "44C1CE26DE6098783D46BD5B3EB1BDD6", hash_generated_method = "F91375D686F59C630018A29FBF6C01D3")
    public FileDescriptor getFileDescriptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1473488201 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1473488201 = mFd.getFileDescriptor();
        varB4EAC82CA7396A68D541C85D26508E83_1473488201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1473488201;
        // ---------- Original Method ----------
        //return mFd.getFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.706 -0400", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "17AB8E1EB38D9CA2CCD34EA28FC04043")
    public long getStartOffset() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_910547844 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_910547844;
        // ---------- Original Method ----------
        //return mStartOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.721 -0400", hash_original_method = "CF0C8205090CB57B9B1EACE80CFEFFE6", hash_generated_method = "C7FC9030066D9EAC9B126C8CD1B46EB8")
    public long getLength() {
        long len;
        len = mFd.getStatSize();
        long var0F5264038205EDFB1AC05FBB0E8C5E94_703916585 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_703916585;
        // ---------- Original Method ----------
        //if (mLength >= 0) {
            //return mLength;
        //}
        //long len = mFd.getStatSize();
        //return len >= 0 ? len : UNKNOWN_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.722 -0400", hash_original_method = "017FD707368B4170A32A7494D8D576FE", hash_generated_method = "AA37A8784BB647C697D6B0C8E233A8D5")
    public long getDeclaredLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1549692875 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1549692875;
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.722 -0400", hash_original_method = "491F69AA4FD12992599C16C8B0915773", hash_generated_method = "7B9DF8EE0EA99115EB3CD369EE1E6439")
    public void close() throws IOException {
        mFd.close();
        // ---------- Original Method ----------
        //mFd.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.732 -0400", hash_original_method = "6638264422E2A7F83EB5780796593D58", hash_generated_method = "9F98E50900BA3190DE3F27F62FF706FD")
    public FileInputStream createInputStream() throws IOException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_2131511424 = null; //Variable for return #1
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_1299813361 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2131511424 = new ParcelFileDescriptor.AutoCloseInputStream(mFd);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1299813361 = new AutoCloseInputStream(this);
        FileInputStream varA7E53CE21691AB073D9660D615818899_131002983; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_131002983 = varB4EAC82CA7396A68D541C85D26508E83_2131511424;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_131002983 = varB4EAC82CA7396A68D541C85D26508E83_1299813361;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_131002983.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_131002983;
        // ---------- Original Method ----------
        //if (mLength < 0) {
            //return new ParcelFileDescriptor.AutoCloseInputStream(mFd);
        //}
        //return new AutoCloseInputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.741 -0400", hash_original_method = "221DC8DE3671455AA557297DC19DE0C7", hash_generated_method = "C780DE3458EF7F163B906534575B0AF6")
    public FileOutputStream createOutputStream() throws IOException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_1572753469 = null; //Variable for return #1
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_2054452503 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1572753469 = new ParcelFileDescriptor.AutoCloseOutputStream(mFd);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2054452503 = new AutoCloseOutputStream(this);
        FileOutputStream varA7E53CE21691AB073D9660D615818899_1553649558; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1553649558 = varB4EAC82CA7396A68D541C85D26508E83_1572753469;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1553649558 = varB4EAC82CA7396A68D541C85D26508E83_2054452503;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1553649558.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1553649558;
        // ---------- Original Method ----------
        //if (mLength < 0) {
            //return new ParcelFileDescriptor.AutoCloseOutputStream(mFd);
        //}
        //return new AutoCloseOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.765 -0400", hash_original_method = "7D4F991E1E50267AE78D06F4481657CB", hash_generated_method = "D4B204F027F991157E85BF98A3617423")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1591128814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1591128814 = "{AssetFileDescriptor: " + mFd
                + " start=" + mStartOffset + " len=" + mLength + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1591128814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1591128814;
        // ---------- Original Method ----------
        //return "{AssetFileDescriptor: " + mFd
                //+ " start=" + mStartOffset + " len=" + mLength + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.766 -0400", hash_original_method = "0879BA3E6020CB54A0A428F518BD5C8A", hash_generated_method = "6AEC19AEE6F274C1E21CF748C284A7B1")
    public int describeContents() {
        int var6E89DB6436784982CFB76FA78673DA45_543121397 = (mFd.describeContents());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001908684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001908684;
        // ---------- Original Method ----------
        //return mFd.describeContents();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.769 -0400", hash_original_method = "FCAECA18F17390C63AF97C29D61A7F69", hash_generated_method = "A6A568DC5A09BD6E0812CB32B2AA2393")
    public void writeToParcel(Parcel out, int flags) {
        mFd.writeToParcel(out, flags);
        out.writeLong(mStartOffset);
        out.writeLong(mLength);
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //mFd.writeToParcel(out, flags);
        //out.writeLong(mStartOffset);
        //out.writeLong(mLength);
    }

    
    public static class AutoCloseInputStream extends ParcelFileDescriptor.AutoCloseInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.769 -0400", hash_original_field = "07D38A3C377769B1B7C135193212D00C", hash_generated_field = "6A4F127DC4966865D6C91B71BF7CBFD7")

        private long mRemaining;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.774 -0400", hash_original_method = "7289ECB48E55CD5885F0914EF0F43EDF", hash_generated_method = "F1017B8EC8BDBBF3B62D546CB970A24A")
        public  AutoCloseInputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            super.skip(fd.getStartOffset());
            mRemaining = (int)fd.getLength();
            // ---------- Original Method ----------
            //super.skip(fd.getStartOffset());
            //mRemaining = (int)fd.getLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.784 -0400", hash_original_method = "7717D4D64B71963D2E03703366A3F767", hash_generated_method = "0AABF6A93148ECFBD1CB5A2AB72E9E19")
        @Override
        public int available() throws IOException {
            {
                Object var6698ECBC27A3D6C11D735685C1254F7A_1391767185 = (super.available());
            } //End flattened ternary
            //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493641801 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493641801;
            // ---------- Original Method ----------
            //return mRemaining >= 0
                    //? (mRemaining < 0x7fffffff ? (int)mRemaining : 0x7fffffff)
                    //: super.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.785 -0400", hash_original_method = "CAA8FF401C122C408179370071B2636B", hash_generated_method = "328A3C81235134F6238411E6594D53FF")
        @Override
        public int read() throws IOException {
            byte[] buffer;
            buffer = new byte[1];
            int result;
            result = read(buffer, 0, 1);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816107977 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816107977;
            // ---------- Original Method ----------
            //byte[] buffer = new byte[1];
            //int result = read(buffer, 0, 1);
            //return result == -1 ? -1 : buffer[0] & 0xff;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.810 -0400", hash_original_method = "9675FBC56EDFB22EFDB5A62982BF1091", hash_generated_method = "23BAC5871FAFF32A34161CFE85E6D0BA")
        @Override
        public int read(byte[] buffer, int offset, int count) throws IOException {
            {
                count = (int)mRemaining;
                int res;
                res = super.read(buffer, offset, count);
                mRemaining -= res;
            } //End block
            int var38013EA3FB183FB46AAC4E06CE6EB79F_1805779764 = (super.read(buffer, offset, count));
            addTaint(buffer[0]);
            addTaint(offset);
            addTaint(count);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671633364 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671633364;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.816 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "F67D2A6FDE2727075DF27EA41A78FB5D")
        @Override
        public int read(byte[] buffer) throws IOException {
            int var6345393F45692C8B243D9AAC70C2EFB3_1867891770 = (read(buffer, 0, buffer.length));
            addTaint(buffer[0]);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669264713 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669264713;
            // ---------- Original Method ----------
            //return read(buffer, 0, buffer.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.830 -0400", hash_original_method = "A933078BF27D250D6509D415A1A48695", hash_generated_method = "1922555C54F344753C9DE00DC4C92297")
        @Override
        public long skip(long count) throws IOException {
            {
                count = mRemaining;
                long res;
                res = super.skip(count);
                mRemaining -= res;
            } //End block
            long var5AED96CD04AD869E0322F3DF1B163422_784734611 = (super.skip(count));
            addTaint(count);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_2105324211 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2105324211;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.831 -0400", hash_original_method = "002645BE6DC8A0ABDC3AC933CA6AFCE2", hash_generated_method = "9E0C6E270C00B3E46289737DECB38CFB")
        @Override
        public void mark(int readlimit) {
            super.mark(readlimit);
            addTaint(readlimit);
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return;
            //}
            //super.mark(readlimit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.835 -0400", hash_original_method = "2AE31565D7E15B3ED03E3797DC0147F2", hash_generated_method = "92B88D14124B2243346B6CB938C42400")
        @Override
        public boolean markSupported() {
            boolean varAE14FF4A7F97D4826F48B41B2489304A_773351869 = (super.markSupported());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100336212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100336212;
            // ---------- Original Method ----------
            //if (mRemaining >= 0) {
                //return false;
            //}
            //return super.markSupported();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.836 -0400", hash_original_method = "579C70BE1F6B8B8FD4382F7193B33D00", hash_generated_method = "A325832584FC9FDD8D0403EA9D063875")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.836 -0400", hash_original_field = "07D38A3C377769B1B7C135193212D00C", hash_generated_field = "6A4F127DC4966865D6C91B71BF7CBFD7")

        private long mRemaining;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.853 -0400", hash_original_method = "079EE52ECDC98DA80188ACB762BDECCE", hash_generated_method = "12C14759A4E69E578BC4E7B75373B784")
        public  AutoCloseOutputStream(AssetFileDescriptor fd) throws IOException {
            super(fd.getParcelFileDescriptor());
            {
                boolean varFC3E12886C3AF3F36795BDDCB288EB5D_204393535 = (fd.getParcelFileDescriptor().seekTo(fd.getStartOffset()) < 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.855 -0400", hash_original_method = "35A99E3D460555EE5E79B5F1CF4B3E8C", hash_generated_method = "4CF522EAF331459CD5D6B7B880F8A45E")
        @Override
        public void write(byte[] buffer, int offset, int count) throws IOException {
            {
                count = (int)mRemaining;
                super.write(buffer, offset, count);
                mRemaining -= count;
            } //End block
            super.write(buffer, offset, count);
            addTaint(buffer[0]);
            addTaint(offset);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.888 -0400", hash_original_method = "4A27A012BA515BCAA339C3F9D7D659AA", hash_generated_method = "7986953D7C9221B0E5C2CAD84E5BBDE4")
        @Override
        public void write(byte[] buffer) throws IOException {
            {
                int count;
                count = buffer.length;
                count = (int)mRemaining;
                super.write(buffer);
                mRemaining -= count;
            } //End block
            super.write(buffer);
            addTaint(buffer[0]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.892 -0400", hash_original_method = "1210B34247DB6E03D45CB2428D3624D7", hash_generated_method = "BF6AB31DFF093DC33538EB2A269C2316")
        @Override
        public void write(int oneByte) throws IOException {
            {
                super.write(oneByte);
            } //End block
            super.write(oneByte);
            addTaint(oneByte);
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.892 -0400", hash_original_field = "CB0B57BF70999A7621B00BD40DFABFF8", hash_generated_field = "4FE9A1DE5214CFC95E635BC2E3ADC963")

    public static final long UNKNOWN_LENGTH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.893 -0400", hash_original_field = "55F81C540A0F490F18AFC67EA63DC2AC", hash_generated_field = "C848EEBB0F7783D5E330997BE762ED30")

    public static final Parcelable.Creator<AssetFileDescriptor> CREATOR
            = new Parcelable.Creator<AssetFileDescriptor>() {
        public AssetFileDescriptor createFromParcel(Parcel in) {
            return new AssetFileDescriptor(in);
        }
        public AssetFileDescriptor[] newArray(int size) {
            return new AssetFileDescriptor[size];
        }
    };
}

