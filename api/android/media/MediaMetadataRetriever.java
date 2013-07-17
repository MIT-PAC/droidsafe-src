package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class MediaMetadataRetriever {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.535 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "4FF8A42CAE4591AC91206314B4192EA4")

    @SuppressWarnings("unused") private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.536 -0400", hash_original_method = "38580FA1CFCA0A8BC70F7859DD8ED432", hash_generated_method = "2AB8306B5DA12B671F5FB6B56B3C1E94")
    public  MediaMetadataRetriever() {
        native_setup();
        // ---------- Original Method ----------
        //native_setup();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.536 -0400", hash_original_method = "D47DF3C9D755BEB92AD11CA5A5487AA8", hash_generated_method = "4AD2FDC9F80F0B04601FEE229A9BF7B6")
    public void setDataSource(String path) throws IllegalArgumentException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.537 -0400", hash_original_method = "75031631EDBDF61877DE8EFD8981A88D", hash_generated_method = "2C378F077695C90042BC34F17CD52E9D")
    public void setDataSource(String uri,  Map<String, String> headers) throws IllegalArgumentException {
        addTaint(headers.getTaint());
        addTaint(uri.getTaint());
        int i = 0;
        String[] keys = new String[headers.size()];
        String[] values = new String[headers.size()];
for(Map.Entry<String, String> entry : headers.entrySet())
        {
            keys[i] = entry.getKey();
            values[i] = entry.getValue();
            ++i;
        } //End block
        _setDataSource(uri, keys, values);
        // ---------- Original Method ----------
        //int i = 0;
        //String[] keys = new String[headers.size()];
        //String[] values = new String[headers.size()];
        //for (Map.Entry<String, String> entry: headers.entrySet()) {
            //keys[i] = entry.getKey();
            //values[i] = entry.getValue();
            //++i;
        //}
        //_setDataSource(uri, keys, values);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.538 -0400", hash_original_method = "1285CC494A70498EAD553FCD7C19AE34", hash_generated_method = "CC3B57E8B0C4743A2F6D81D0F777FEA9")
    private void _setDataSource(
        String uri, String[] keys, String[] values) throws IllegalArgumentException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.538 -0400", hash_original_method = "BC4C0D4D9E4315B0C10CA47469C111B0", hash_generated_method = "E7A6E29F361A076E33A7A9D7B091463E")
    public void setDataSource(FileDescriptor fd, long offset, long length) throws IllegalArgumentException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.539 -0400", hash_original_method = "EF1A32438BC38F472DA718584B5867D9", hash_generated_method = "972A467EEAD7365C4E499427C0C7F931")
    public void setDataSource(FileDescriptor fd) throws IllegalArgumentException {
        addTaint(fd.getTaint());
        setDataSource(fd, 0, 0x7ffffffffffffffL);
        // ---------- Original Method ----------
        //setDataSource(fd, 0, 0x7ffffffffffffffL);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.540 -0400", hash_original_method = "701A3FA8EE72D63C1258CD78285617D5", hash_generated_method = "08A08977545EC338EDDC9F8D83CE1CA7")
    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException {
        addTaint(uri.getTaint());
        addTaint(context.getTaint());
        if(uri == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1320478204 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1320478204.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1320478204;
        } //End block
        String scheme = uri.getScheme();
        if(scheme == null || scheme.equals("file"))        
        {
            setDataSource(uri.getPath());
            return;
        } //End block
        AssetFileDescriptor fd = null;
        try 
        {
            ContentResolver resolver = context.getContentResolver();
            try 
            {
                fd = resolver.openAssetFileDescriptor(uri, "r");
            } //End block
            catch (FileNotFoundException e)
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_566441268 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_566441268.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_566441268;
            } //End block
            if(fd == null)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_738334555 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_738334555.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_738334555;
            } //End block
            FileDescriptor descriptor = fd.getFileDescriptor();
            if(!descriptor.valid())            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_674611669 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_674611669.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_674611669;
            } //End block
            if(fd.getDeclaredLength() < 0)            
            {
                setDataSource(descriptor);
            } //End block
            else
            {
                setDataSource(descriptor, fd.getStartOffset(), fd.getDeclaredLength());
            } //End block
            return;
        } //End block
        catch (SecurityException ex)
        {
        } //End block
        finally 
        {
            try 
            {
                if(fd != null)                
                {
                    fd.close();
                } //End block
            } //End block
            catch (IOException ioEx)
            {
            } //End block
        } //End block
        setDataSource(uri.toString());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.169 -0400", hash_original_method = "8FC26B688DF40812E766667E74AA42B9", hash_generated_method = "FE2CB58CC88315CB1A432EFEAAD82A77")
    public String extractMetadata(int keyCode) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.541 -0400", hash_original_method = "D44D6BE7DFFCAE11832F13741FBDA1F8", hash_generated_method = "94A88F64CC2F168A4D38BC354E7B0386")
    public Bitmap getFrameAtTime(long timeUs, int option) {
        addTaint(option);
        addTaint(timeUs);
        if(option < OPTION_PREVIOUS_SYNC ||
            option > OPTION_CLOSEST)        
        {
            IllegalArgumentException var69FA22AAC4421AB12EC13C7D968494DA_1655836955 = new IllegalArgumentException("Unsupported option: " + option);
            var69FA22AAC4421AB12EC13C7D968494DA_1655836955.addTaint(taint);
            throw var69FA22AAC4421AB12EC13C7D968494DA_1655836955;
        } //End block
Bitmap varAB1C2407842D2F107CAF6F34F7AFC9D8_1078527858 =         _getFrameAtTime(timeUs, option);
        varAB1C2407842D2F107CAF6F34F7AFC9D8_1078527858.addTaint(taint);
        return varAB1C2407842D2F107CAF6F34F7AFC9D8_1078527858;
        // ---------- Original Method ----------
        //if (option < OPTION_PREVIOUS_SYNC ||
            //option > OPTION_CLOSEST) {
            //throw new IllegalArgumentException("Unsupported option: " + option);
        //}
        //return _getFrameAtTime(timeUs, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.542 -0400", hash_original_method = "F77381ED452E3EC1B4D9E71ECA218C76", hash_generated_method = "8348EC56FBEA42EEC17FC881EDB044E3")
    public Bitmap getFrameAtTime(long timeUs) {
        addTaint(timeUs);
Bitmap var4259E13E89B1A6DF5254A409FDE05C54_1729789189 =         getFrameAtTime(timeUs, OPTION_CLOSEST_SYNC);
        var4259E13E89B1A6DF5254A409FDE05C54_1729789189.addTaint(taint);
        return var4259E13E89B1A6DF5254A409FDE05C54_1729789189;
        // ---------- Original Method ----------
        //return getFrameAtTime(timeUs, OPTION_CLOSEST_SYNC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.542 -0400", hash_original_method = "B076FDF9A15CA7321A3CFAECED9F7582", hash_generated_method = "D3349594504A66B66D8F346788B3921D")
    public Bitmap getFrameAtTime() {
Bitmap var09EE212372AEDF5BF1A18C39AF757758_995130384 =         getFrameAtTime(-1, OPTION_CLOSEST_SYNC);
        var09EE212372AEDF5BF1A18C39AF757758_995130384.addTaint(taint);
        return var09EE212372AEDF5BF1A18C39AF757758_995130384;
        // ---------- Original Method ----------
        //return getFrameAtTime(-1, OPTION_CLOSEST_SYNC);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.171 -0400", hash_original_method = "0267DF76D9FDF0A85486B93D0A2D882E", hash_generated_method = "EAEEF9DF0C3B11B82EFDFB7406623787")
    private Bitmap _getFrameAtTime(long timeUs, int option) {
    	Bitmap bmp = BitmapFactory.decodeByteArray(new byte[] {1}, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT);
    	bmp.addTaint(timeUs);
    	bmp.addTaint(option);
    	return bmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.543 -0400", hash_original_method = "BD3973B389FE81CEA52266D9B68AE29D", hash_generated_method = "0203D6B2D848B8C4F76EAC569DC9AA58")
    public byte[] getEmbeddedPicture() {
        byte[] varBA8CC16872951490579C3C533928EA6B_717306299 = (getEmbeddedPicture(EMBEDDED_PICTURE_TYPE_ANY));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1275733089 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1275733089;
        // ---------- Original Method ----------
        //return getEmbeddedPicture(EMBEDDED_PICTURE_TYPE_ANY);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.544 -0400", hash_original_method = "B906FFDB309D75A064AF9D81EE962B1C", hash_generated_method = "268DB065567DCB0383BBA368F41F5961")
    private byte[] getEmbeddedPicture(int pictureType) {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_54223325 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_54223325;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.544 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "41B8B73906B263B02861ABB4EEE712F2")
    public void release() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.544 -0400", hash_original_method = "B91E9A85D17B4C3984DC1E936380BF22", hash_generated_method = "F98B222B7869F5CF2D166DFFD6958B3E")
    private void native_setup() {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_init() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.545 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "BE94CB6DE9EDBEEF7D151AA52A7096EC")
    private final void native_finalize() {
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.545 -0400", hash_original_method = "24D5F4C50C2ABC5729410C2F2E889F36", hash_generated_method = "734DC2542CF2E5732EF16DF74CC2E89A")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            native_finalize();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //native_finalize();
        //} finally {
            //super.finalize();
        //}
    }

    
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "FFA5B1FAA7D1DA0CE2FE3A5B9BE7C499", hash_generated_field = "587845B93BAC11B9CC8CAD446009C60D")

    private static final int EMBEDDED_PICTURE_TYPE_ANY = 0xFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "186CF82134B5E5A198BDD6F7CBD8AFE9", hash_generated_field = "5309B7EC3A5813F72B40602F9ABECC48")

    public static final int OPTION_PREVIOUS_SYNC    = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "E9EF2E1E47EA22AA544EA7126246F582", hash_generated_field = "73816478ACDBC2EE31D950CB223C7F74")

    public static final int OPTION_NEXT_SYNC        = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "3D7BCAC77ADAD9914F6E0D88420DA9F7", hash_generated_field = "8810F7CBBC1EB231C1123CE10FC3556E")

    public static final int OPTION_CLOSEST_SYNC     = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "372963B11B5E82B72E315DEC470E581A", hash_generated_field = "1097E8796D5E40384ACF5CB8D615B8DE")

    public static final int OPTION_CLOSEST          = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "118F841C349356FAD1211037EE6426A5", hash_generated_field = "679D9EB252D22EEE8FB7D3FE6AC0FB8D")

    public static final int METADATA_KEY_CD_TRACK_NUMBER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "1B1F7D97EBD9B10D0ED9C931865260B3", hash_generated_field = "A332A8FAC3899D64A59B1BA4BE38256C")

    public static final int METADATA_KEY_ALBUM           = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "037BC4656707AEF90D2ABD8031E3609B", hash_generated_field = "B260EE8DF7D0A3AAC77DCD6397635365")

    public static final int METADATA_KEY_ARTIST          = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "2010C2018630D06BB7CD44CAB4208CF1", hash_generated_field = "94364E7F7221CCEAB7B004990A1161EF")

    public static final int METADATA_KEY_AUTHOR          = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "7E9DBDEDB60B73DFDD1EB055B20CF97A", hash_generated_field = "FD081427E601CC4ED3C33F130BE9A05C")

    public static final int METADATA_KEY_COMPOSER        = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.546 -0400", hash_original_field = "AE0C16C3B0A4596F3AEA19E4C06EEA81", hash_generated_field = "56BCDC6DA8A24C2BA5009697B974F032")

    public static final int METADATA_KEY_DATE            = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.547 -0400", hash_original_field = "1F3BFD8CB1915E2DA04BEFBFFE8A4BF9", hash_generated_field = "A0A841A75C91A084EFF03D27761CDFF2")

    public static final int METADATA_KEY_GENRE           = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.547 -0400", hash_original_field = "18F938567559B88C7DB257F288A337F8", hash_generated_field = "5E07A16E006ABD61DACDCB45AC45FD72")

    public static final int METADATA_KEY_TITLE           = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.547 -0400", hash_original_field = "53793043BA458565D5C6A1A08FFAFF41", hash_generated_field = "B627BD155150B228CAAD2E6F03893E96")

    public static final int METADATA_KEY_YEAR            = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.547 -0400", hash_original_field = "CF7C139494966DAA31521C3212F7AA3C", hash_generated_field = "B5CC8C2547709272FC0513E4C573BBD5")

    public static final int METADATA_KEY_DURATION        = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.547 -0400", hash_original_field = "5032EE4D0D98EA54EF096A5EDDFD8933", hash_generated_field = "1DDB4F0BAA52B11A6D7F602182654983")

    public static final int METADATA_KEY_NUM_TRACKS      = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.547 -0400", hash_original_field = "04AEA1FA0A17A75ED3C5C4BCC70D37CE", hash_generated_field = "BDBAB7BE53E33C51C917CDC9C9B0840E")

    public static final int METADATA_KEY_WRITER          = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.548 -0400", hash_original_field = "6D379963BCC6C28A7149012302134906", hash_generated_field = "0CD0514792BFA3307A8EF729B3B8076B")

    public static final int METADATA_KEY_MIMETYPE        = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.548 -0400", hash_original_field = "85995DD7CB431B371619B5FE95AB60C6", hash_generated_field = "3B38229DC5B7493B54B38AF9BC5B1D9A")

    public static final int METADATA_KEY_ALBUMARTIST     = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "2464F8DBFDCED782D3A74B9F7BF4DE56", hash_generated_field = "87195DDCA157DB9809F223D846F15942")

    public static final int METADATA_KEY_DISC_NUMBER     = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "04BC4DC442A2BF7D944439E9A8E271A3", hash_generated_field = "E5EBE677BEA5F8D03685372EBB030DD1")

    public static final int METADATA_KEY_COMPILATION     = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "3FB558F2C5C119B5A125599005FE1424", hash_generated_field = "60E5F5393E929633191E9F2C6A4056F2")

    public static final int METADATA_KEY_HAS_AUDIO       = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "C60E8642118E0932F7541FA895003811", hash_generated_field = "3F6339F99F930AEFB305E711EDBAE1FC")

    public static final int METADATA_KEY_HAS_VIDEO       = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "9AC575DFF9D601C00B08EFDAC44C8F20", hash_generated_field = "A3FA464A523964FB0786985DBB14FC6C")

    public static final int METADATA_KEY_VIDEO_WIDTH     = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "D23DE769B61FA75D840EF74AB4D6033F", hash_generated_field = "BCD3E497187EFE972C617A0602FE9F6D")

    public static final int METADATA_KEY_VIDEO_HEIGHT    = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "E6199FF2D9E80F6B5DB511AD4C002B10", hash_generated_field = "4BEC3C343EDCF094F63DFF20774CC474")

    public static final int METADATA_KEY_BITRATE         = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "7A73A76195DAE632FE0B8350F45E511D", hash_generated_field = "E893039E72C831B2BE3858E7E9B9042E")

    public static final int METADATA_KEY_TIMED_TEXT_LANGUAGES      = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "60D475B618BFFB8F7C3712FC83ACE737", hash_generated_field = "67D02F67AADF4D87B920C6E6B875577B")

    public static final int METADATA_KEY_IS_DRM          = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.581 -0400", hash_original_field = "78A5DBEF563B24261ACF9D3CA53411B0", hash_generated_field = "F80437010E69FE60188044161F9CFC13")

    public static final int METADATA_KEY_LOCATION        = 23;
}

