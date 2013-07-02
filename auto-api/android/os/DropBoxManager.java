package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Log;
import com.android.internal.os.IDropBoxManagerService;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class DropBoxManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.160 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "FF673E933014905FBCDFD4D8541297A4")

    private IDropBoxManagerService mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.161 -0400", hash_original_method = "04B0A4DBB2EAE135AA112A8CAA9647B1", hash_generated_method = "56807A840D421C3846696C198899DDB8")
    public  DropBoxManager(IDropBoxManagerService service) {
        mService = service;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.161 -0400", hash_original_method = "E688A3A6CCC118BEDB51FAABD6872F4D", hash_generated_method = "1D2825C63C164429C45D67692FE8B561")
    protected  DropBoxManager() {
        mService = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.161 -0400", hash_original_method = "B6329499D071F8AC982F0B19B7FB97DF", hash_generated_method = "782CDBD3C41808A2B4A52AD4975D1EB7")
    public void addText(String tag, String data) {
        try 
        {
            mService.add(new Entry(tag, 0, data));
        } 
        catch (RemoteException e)
        { }
        addTaint(tag.getTaint());
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.162 -0400", hash_original_method = "7BD48A32860AA6BD88FDC639FDB6D7D8", hash_generated_method = "6E2821E95A42E6BD91F574136C7E0224")
    public void addData(String tag, byte[] data, int flags) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("data == null");
        try 
        {
            mService.add(new Entry(tag, 0, data, flags));
        } 
        catch (RemoteException e)
        { }
        addTaint(tag.getTaint());
        addTaint(data[0]);
        addTaint(flags);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.162 -0400", hash_original_method = "BF97B72EB64F4DB129C9C48237659777", hash_generated_method = "D9E7E7F8CD8E93FD369BB5EA9C94AA19")
    public void addFile(String tag, File file, int flags) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("file == null");
        Entry entry = new Entry(tag, 0, file, flags);
        try 
        {
            mService.add(entry);
        } 
        catch (RemoteException e)
        { }
        finally 
        {
            entry.close();
        } 
        addTaint(tag.getTaint());
        addTaint(file.getTaint());
        addTaint(flags);
        
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.162 -0400", hash_original_method = "0FE06F2CE6966672337D3755F0FF0CD0", hash_generated_method = "282827FE93B3C22EBB634679A9C5A268")
    public boolean isTagEnabled(String tag) {
        try 
        {
            boolean var175D0364BFB4A88762C5ABCE62C258F0_1694311151 = (mService.isTagEnabled(tag));
        } 
        catch (RemoteException e)
        { }
        addTaint(tag.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_228955727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_228955727;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.163 -0400", hash_original_method = "A691D94F864449A091C30E093C0F46CD", hash_generated_method = "844A233CE3AE98E74BCFF0D84C38BD95")
    public Entry getNextEntry(String tag, long msec) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_1240694501 = null; 
        Entry varB4EAC82CA7396A68D541C85D26508E83_204730454 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1240694501 = mService.getNextEntry(tag, msec);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_204730454 = null;
        } 
        addTaint(tag.getTaint());
        addTaint(msec);
        Entry varA7E53CE21691AB073D9660D615818899_1824303457; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1824303457 = varB4EAC82CA7396A68D541C85D26508E83_1240694501;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1824303457 = varB4EAC82CA7396A68D541C85D26508E83_204730454;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1824303457.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1824303457;
        
        
    }

    
    public static class Entry implements Parcelable, Closeable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.163 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.163 -0400", hash_original_field = "6F3BEB4D53F7C410F1DAD4C6334EE882", hash_generated_field = "753DEC84E9370E35F2BD26C6679E5DA4")

        private long mTimeMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.163 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

        private byte[] mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.164 -0400", hash_original_field = "D118306A98C1E7C12AA828417A60A6F6", hash_generated_field = "2EB80060CD9954C0E91A29E7A228F077")

        private ParcelFileDescriptor mFileDescriptor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.164 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.164 -0400", hash_original_method = "59D4C7A828654550E9A00289F418A41B", hash_generated_method = "A00DA6A97368562A5FD88FE000D85CB8")
        public  Entry(String tag, long millis) {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = null;
            mFlags = IS_EMPTY;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.165 -0400", hash_original_method = "3040DA05407F13E8561F02C468A7DEB4", hash_generated_method = "CA17E820E1E887B7683B5BD142EEDF69")
        public  Entry(String tag, long millis, String text) {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("text == null");
            mTag = tag;
            mTimeMillis = millis;
            mData = text.getBytes();
            mFileDescriptor = null;
            mFlags = IS_TEXT;
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.165 -0400", hash_original_method = "182B4976A5D069A0C2E90B74F50A592D", hash_generated_method = "4F450E1434193E0CF483D45EBFA6BF10")
        public  Entry(String tag, long millis, byte[] data, int flags) {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad flags: " + flags);
            } 
            mTag = tag;
            mTimeMillis = millis;
            mData = data;
            mFileDescriptor = null;
            mFlags = flags;
            
            
            
                
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.166 -0400", hash_original_method = "98F6B6C49553AC4D3032798198FC694A", hash_generated_method = "A2547DD161A6AF0EECBAF6CE4E8996E1")
        public  Entry(String tag, long millis, ParcelFileDescriptor data, int flags) {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad flags: " + flags);
            } 
            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = data;
            mFlags = flags;
            
            
            
                
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.166 -0400", hash_original_method = "102E401D4541F654441520BE506818C4", hash_generated_method = "68E8A1ACA5477CAA9C34B72B9E33A3F1")
        public  Entry(String tag, long millis, File data, int flags) throws IOException {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad flags: " + flags);
            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = ParcelFileDescriptor.open(data, ParcelFileDescriptor.MODE_READ_ONLY);
            mFlags = flags;
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.167 -0400", hash_original_method = "377836285D1E96A0220618E9638425CD", hash_generated_method = "FE9BF441F4F88D70E70789299360E1CB")
        public void close() {
            try 
            {
                mFileDescriptor.close();
            } 
            catch (IOException e)
            { }
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.167 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "9CEEFE2FA4A4ACEB5A737783377192D2")
        public String getTag() {
            String varB4EAC82CA7396A68D541C85D26508E83_2097104175 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2097104175 = mTag;
            varB4EAC82CA7396A68D541C85D26508E83_2097104175.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2097104175;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.167 -0400", hash_original_method = "6C399926D10F83AEDA9A5ADCC6A5D3A1", hash_generated_method = "6C5981961B8A62639FDAED235EAF707D")
        public long getTimeMillis() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1786575087 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1786575087;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.168 -0400", hash_original_method = "DEBA147F1626153ABBF4AEA4FEEBC80F", hash_generated_method = "88D3A2E80D82CEFF7EBB3552AF3DFA84")
        public int getFlags() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750414391 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750414391;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.169 -0400", hash_original_method = "5115D4296A1E9A49B9B7627B57AD3F2E", hash_generated_method = "C65C4F709977953EB1599FBFEFB94AAB")
        public String getText(int maxBytes) {
            String varB4EAC82CA7396A68D541C85D26508E83_2100074328 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1714232405 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_2056910921 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_609108068 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_325772333 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2100074328 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1714232405 = new String(mData, 0, Math.min(maxBytes, mData.length));
            InputStream is = null;
            try 
            {
                is = getInputStream();
                varB4EAC82CA7396A68D541C85D26508E83_2056910921 = null;
                byte[] buf = new byte[maxBytes];
                int readBytes = 0;
                int n = 0;
                {
                    boolean varF9720F5057F50303867139DD98C6B9EC_806209604 = (n >= 0 && (readBytes += n) < maxBytes);
                    {
                        n = is.read(buf, readBytes, maxBytes - readBytes);
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_609108068 = new String(buf, 0, readBytes);
            } 
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_325772333 = null;
            } 
            finally 
            {
                try 
                {
                    is.close();
                } 
                catch (IOException e)
                { }
            } 
            addTaint(maxBytes);
            String varA7E53CE21691AB073D9660D615818899_305764308; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_305764308 = varB4EAC82CA7396A68D541C85D26508E83_2100074328;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_305764308 = varB4EAC82CA7396A68D541C85D26508E83_1714232405;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_305764308 = varB4EAC82CA7396A68D541C85D26508E83_2056910921;
                    break;
                case 4: 
                    varA7E53CE21691AB073D9660D615818899_305764308 = varB4EAC82CA7396A68D541C85D26508E83_609108068;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_305764308 = varB4EAC82CA7396A68D541C85D26508E83_325772333;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_305764308.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_305764308;
            
            
            
            
            
                
                
                
                
                
                
                    
                
                
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.170 -0400", hash_original_method = "1138A2AC2CDA63F5FD2C1DAD635BB1B0", hash_generated_method = "A4B676BEDD96F929E22E6BCC15216096")
        public InputStream getInputStream() throws IOException {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_476842329 = null; 
            InputStream varB4EAC82CA7396A68D541C85D26508E83_698808722 = null; 
            InputStream is;
            {
                is = new ByteArrayInputStream(mData);
            } 
            {
                is = new ParcelFileDescriptor.AutoCloseInputStream(mFileDescriptor);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_476842329 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_698808722 = (mFlags & IS_GZIPPED) != 0 ? new GZIPInputStream(is) : is;
            InputStream varA7E53CE21691AB073D9660D615818899_859443915; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_859443915 = varB4EAC82CA7396A68D541C85D26508E83_476842329;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_859443915 = varB4EAC82CA7396A68D541C85D26508E83_698808722;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_859443915.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_859443915;
            
            
            
                
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.170 -0400", hash_original_method = "CE12D992AD97C7CB4D92B660FD5831CC", hash_generated_method = "36225685C32C8DBB96AFF748A6D443EE")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359436360 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359436360;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.170 -0400", hash_original_method = "651672D7808B55AEFC112D3455309C97", hash_generated_method = "42CF11E6888B9991F726200DEBE6EDBF")
        public void writeToParcel(Parcel out, int flags) {
            out.writeString(mTag);
            out.writeLong(mTimeMillis);
            {
                out.writeInt(mFlags & ~HAS_BYTE_ARRAY);
                mFileDescriptor.writeToParcel(out, flags);
            } 
            {
                out.writeInt(mFlags | HAS_BYTE_ARRAY);
                out.writeByteArray(mData);
            } 
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
            
                
                
            
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "A8DC184895BB5B5BEE6BB5E9D72AA17F", hash_generated_field = "329A53A95C2F0B54BB6DBA5A539F5907")

        public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator() {
            public Entry[] newArray(int size) { return new Entry[size]; }
            public Entry createFromParcel(Parcel in) {
                String tag = in.readString();
                long millis = in.readLong();
                int flags = in.readInt();
                if ((flags & HAS_BYTE_ARRAY) != 0) {
                    return new Entry(tag, millis, in.createByteArray(), flags & ~HAS_BYTE_ARRAY);
                } else {
                    return new Entry(tag, millis, in.readFileDescriptor(), flags);
                }
            }
        };
        
        public Entry createFromParcel(Parcel in) {
                String tag = in.readString();
                long millis = in.readLong();
                int flags = in.readInt();
                if ((flags & HAS_BYTE_ARRAY) != 0) {
                    return new Entry(tag, millis, in.createByteArray(), flags & ~HAS_BYTE_ARRAY);
                } else {
                    return new Entry(tag, millis, in.readFileDescriptor(), flags);
                }
            }
        
        
        public Entry[] newArray(int size) { return new Entry[size]; }
        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "DF2FD460CAAAEBB1A10FC77F067462EB", hash_generated_field = "7F88B1F6C3AA23682B73D2063D96AD46")

    private static final String TAG = "DropBoxManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "79A4E1188426E01C21F71399E062B2DB", hash_generated_field = "4342C6618E9F33B619CAED2246633D02")

    public static final int IS_EMPTY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "58E57C056E79049DC8AFF3FE98FDEE08", hash_generated_field = "26AE776D9F0D1E8967689D8BDE25B1E4")

    public static final int IS_TEXT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "F03BF7F70E23C4614DE3AF15DEE42B19", hash_generated_field = "0467C01D2B434424775E1AEC77EA10FE")

    public static final int IS_GZIPPED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "3CC289AFB2A4BFCE9CF3B0CE20E7FE9C", hash_generated_field = "48D79452E0CE2C4C0A373F8DD88D3A93")

    private static final int HAS_BYTE_ARRAY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "1C1542243F83EC851C9D74881C834C3E", hash_generated_field = "C96D94412FCD56314FB7038C746F0C74")

    public static final String ACTION_DROPBOX_ENTRY_ADDED =
        "android.intent.action.DROPBOX_ENTRY_ADDED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "56A4A212BD6F81ED70338F2E0CD1786C", hash_generated_field = "DA52E65CF9683E9971D90CD0BBF2BACB")

    public static final String EXTRA_TAG = "tag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.171 -0400", hash_original_field = "F2F651B0DF45A4AA735D59F9077C5568", hash_generated_field = "BF72FAE2E20FCDE1DA6F95CAA1981EAC")

    public static final String EXTRA_TIME = "time";
}

