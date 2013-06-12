package android.media;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;
import java.util.Map;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class MediaMetadataRetriever {
    @SuppressWarnings("unused")
    private int mNativeContext;
    private static final int EMBEDDED_PICTURE_TYPE_ANY = 0xFFFF;
    public static final int OPTION_PREVIOUS_SYNC    = 0x00;
    public static final int OPTION_NEXT_SYNC        = 0x01;
    public static final int OPTION_CLOSEST_SYNC     = 0x02;
    public static final int OPTION_CLOSEST          = 0x03;
    public static final int METADATA_KEY_CD_TRACK_NUMBER = 0;
    public static final int METADATA_KEY_ALBUM           = 1;
    public static final int METADATA_KEY_ARTIST          = 2;
    public static final int METADATA_KEY_AUTHOR          = 3;
    public static final int METADATA_KEY_COMPOSER        = 4;
    public static final int METADATA_KEY_DATE            = 5;
    public static final int METADATA_KEY_GENRE           = 6;
    public static final int METADATA_KEY_TITLE           = 7;
    public static final int METADATA_KEY_YEAR            = 8;
    public static final int METADATA_KEY_DURATION        = 9;
    public static final int METADATA_KEY_NUM_TRACKS      = 10;
    public static final int METADATA_KEY_WRITER          = 11;
    public static final int METADATA_KEY_MIMETYPE        = 12;
    public static final int METADATA_KEY_ALBUMARTIST     = 13;
    public static final int METADATA_KEY_DISC_NUMBER     = 14;
    public static final int METADATA_KEY_COMPILATION     = 15;
    public static final int METADATA_KEY_HAS_AUDIO       = 16;
    public static final int METADATA_KEY_HAS_VIDEO       = 17;
    public static final int METADATA_KEY_VIDEO_WIDTH     = 18;
    public static final int METADATA_KEY_VIDEO_HEIGHT    = 19;
    public static final int METADATA_KEY_BITRATE         = 20;
    public static final int METADATA_KEY_TIMED_TEXT_LANGUAGES      = 21;
    public static final int METADATA_KEY_IS_DRM          = 22;
    public static final int METADATA_KEY_LOCATION        = 23;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.930 -0400", hash_original_method = "38580FA1CFCA0A8BC70F7859DD8ED432", hash_generated_method = "9335DD515A4FC4150806083245C2DA99")
    @DSModeled(DSC.SAFE)
    public MediaMetadataRetriever() {
        native_setup();
        // ---------- Original Method ----------
        //native_setup();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.930 -0400", hash_original_method = "D47DF3C9D755BEB92AD11CA5A5487AA8", hash_generated_method = "E5263395D0E02F25EA78518701A11EC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataSource(String path) throws IllegalArgumentException {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.931 -0400", hash_original_method = "75031631EDBDF61877DE8EFD8981A88D", hash_generated_method = "AF0EAA87F17C2DF9A70DE4A94BE18A9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataSource(String uri,  Map<String, String> headers) throws IllegalArgumentException {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(uri);
        int i;
        i = 0;
        String[] keys;
        keys = new String[headers.size()];
        String[] values;
        values = new String[headers.size()];
        {
            Iterator<Map.Entry<String, String>> seatecAstronomy42 = headers.entrySet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<String, String> entry = seatecAstronomy42.next();
            {
                keys[i] = entry.getKey();
                values[i] = entry.getValue();
                ++i;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.931 -0400", hash_original_method = "1285CC494A70498EAD553FCD7C19AE34", hash_generated_method = "707C59FF27D8822291CB0EC1E5D4F6CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _setDataSource(
        String uri, String[] keys, String[] values) throws IllegalArgumentException {
        dsTaint.addTaint(values);
        dsTaint.addTaint(keys);
        dsTaint.addTaint(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.931 -0400", hash_original_method = "BC4C0D4D9E4315B0C10CA47469C111B0", hash_generated_method = "1B407B1B406D1E61C3BA13B7C6318A35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataSource(FileDescriptor fd, long offset, long length) throws IllegalArgumentException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.931 -0400", hash_original_method = "EF1A32438BC38F472DA718584B5867D9", hash_generated_method = "D1B69E663E8B6BFFBC3B9E3552BBAA6F")
    @DSModeled(DSC.SAFE)
    public void setDataSource(FileDescriptor fd) throws IllegalArgumentException {
        dsTaint.addTaint(fd.dsTaint);
        setDataSource(fd, 0, 0x7ffffffffffffffL);
        // ---------- Original Method ----------
        //setDataSource(fd, 0, 0x7ffffffffffffffL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.931 -0400", hash_original_method = "701A3FA8EE72D63C1258CD78285617D5", hash_generated_method = "CF137E330899FF142A80469565761282")
    @DSModeled(DSC.SPEC)
    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException();
        } //End block
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varB783BCB76216B10372231D3D68484DB8_1610918255 = (scheme == null || scheme.equals("file"));
            {
                setDataSource(uri.getPath());
            } //End block
        } //End collapsed parenthetic
        AssetFileDescriptor fd;
        fd = null;
        try 
        {
            ContentResolver resolver;
            resolver = context.getContentResolver();
            try 
            {
                fd = resolver.openAssetFileDescriptor(uri, "r");
            } //End block
            catch (FileNotFoundException e)
            {
                throw new IllegalArgumentException();
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException();
            } //End block
            FileDescriptor descriptor;
            descriptor = fd.getFileDescriptor();
            {
                boolean varD6D1E6889A2F65271896664E86493E08_358385156 = (!descriptor.valid());
                {
                	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var761F6419C241ADD42691E3D2E85CB236_10968861 = (fd.getDeclaredLength() < 0);
                {
                    setDataSource(descriptor);
                } //End block
                {
                    setDataSource(descriptor, fd.getStartOffset(), fd.getDeclaredLength());
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (SecurityException ex)
        { }
        finally 
        {
            try 
            {
                {
                    fd.close();
                } //End block
            } //End block
            catch (IOException ioEx)
            { }
        } //End block
        setDataSource(uri.toString());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.931 -0400", hash_original_method = "8FC26B688DF40812E766667E74AA42B9", hash_generated_method = "BBDDB9831AAD600039E4A4BFC40EDBB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String extractMetadata(int keyCode) {
        dsTaint.addTaint(keyCode);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "D44D6BE7DFFCAE11832F13741FBDA1F8", hash_generated_method = "45DFB7377064D8A7F79DE9794352C129")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getFrameAtTime(long timeUs, int option) {
        dsTaint.addTaint(timeUs);
        dsTaint.addTaint(option);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unsupported option: " + option);
        } //End block
        Bitmap var230D3FA8BC7C0BB4FFBCA21112BDCF8E_1166799729 = (_getFrameAtTime(timeUs, option));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (option < OPTION_PREVIOUS_SYNC ||
            //option > OPTION_CLOSEST) {
            //throw new IllegalArgumentException("Unsupported option: " + option);
        //}
        //return _getFrameAtTime(timeUs, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "F77381ED452E3EC1B4D9E71ECA218C76", hash_generated_method = "E5D8878910BC332AC70E68E6530A7D76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getFrameAtTime(long timeUs) {
        dsTaint.addTaint(timeUs);
        Bitmap var69D4BFBBE36454DA36449A715967D3BF_307495908 = (getFrameAtTime(timeUs, OPTION_CLOSEST_SYNC));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFrameAtTime(timeUs, OPTION_CLOSEST_SYNC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "B076FDF9A15CA7321A3CFAECED9F7582", hash_generated_method = "0CA65D2EA49860EBB1BE5DCEDA24F3CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getFrameAtTime() {
        Bitmap var906B553BE1ECA06AAD70CCA8115F869B_1305278877 = (getFrameAtTime(-1, OPTION_CLOSEST_SYNC));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFrameAtTime(-1, OPTION_CLOSEST_SYNC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "0267DF76D9FDF0A85486B93D0A2D882E", hash_generated_method = "B004261BA05FDD614A939B2CEB28960F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Bitmap _getFrameAtTime(long timeUs, int option) {
        dsTaint.addTaint(timeUs);
        dsTaint.addTaint(option);
        return (Bitmap)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "BD3973B389FE81CEA52266D9B68AE29D", hash_generated_method = "7EED7580EC46A1EBBFD82E0C295C6D8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEmbeddedPicture() {
        byte[] varE081D7682A2AC5CF620917DF793D9486_380452280 = (getEmbeddedPicture(EMBEDDED_PICTURE_TYPE_ANY));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getEmbeddedPicture(EMBEDDED_PICTURE_TYPE_ANY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "B906FFDB309D75A064AF9D81EE962B1C", hash_generated_method = "FB20DBEE988291EE0140DE5E31FFD7FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] getEmbeddedPicture(int pictureType) {
        dsTaint.addTaint(pictureType);
        return new byte[] {dsTaint.getTaintByte()};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "D2584A9F2F8C3801A0BB432618FEF48E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "B91E9A85D17B4C3984DC1E936380BF22", hash_generated_method = "C8A66CBBF88F597E424B809F93386C93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_setup() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "9DACEB091913AFFD29EB0CE9882462AB", hash_generated_method = "3D783755AB596340F98D250656AEA902")
    private static void native_init() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "07892C9045EEFAC960AD527F85526543")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_finalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.932 -0400", hash_original_method = "24D5F4C50C2ABC5729410C2F2E889F36", hash_generated_method = "0426F02DBA3F4ECE0151F2AD13AADF0C")
    @DSModeled(DSC.SAFE)
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
    
}


