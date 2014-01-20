package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import droidsafe.helpers.DSUtils;

public class MediaMetadataRetriever {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_init() {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.073 -0500", hash_original_field = "9EC9B27412543E88C0704005395F4E28", hash_generated_field = "587845B93BAC11B9CC8CAD446009C60D")
 
    private static final int EMBEDDED_PICTURE_TYPE_ANY = 0xFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.139 -0500", hash_original_field = "ADF4AC4FAAFB3BDC8E7DD061F865C60E", hash_generated_field = "ED9343FD844D40BF245CA3FD3775CD51")

    /* Do not change these option values without updating their counterparts
     * in include/media/stagefright/MediaSource.h!
     */
    /**
     * This option is used with {@link #getFrameAtTime(long, int)} to retrieve
     * a sync (or key) frame associated with a data source that is located
     * right before or at the given time.
     *
     * @see #getFrameAtTime(long, int)
     */
    public static final int OPTION_PREVIOUS_SYNC    = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.142 -0500", hash_original_field = "B110D25BF4EC3E9E4F2BF4F52EA139C7", hash_generated_field = "73816478ACDBC2EE31D950CB223C7F74")

    public static final int OPTION_NEXT_SYNC        = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.145 -0500", hash_original_field = "2036B80D7133F81D26C446E3A71AF591", hash_generated_field = "8810F7CBBC1EB231C1123CE10FC3556E")

    public static final int OPTION_CLOSEST_SYNC     = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.147 -0500", hash_original_field = "7144C0E57AB94DD2D789265C1C2E19A6", hash_generated_field = "1097E8796D5E40384ACF5CB8D615B8DE")

    public static final int OPTION_CLOSEST          = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.150 -0500", hash_original_field = "A0877CDA930100DC1F17A661E8519D20", hash_generated_field = "09A356A258DD810F10B1BC93E348E23E")

    /**
     * The metadata key to retrieve the numberic string describing the
     * order of the audio data source on its original recording.
     */
    public static final int METADATA_KEY_CD_TRACK_NUMBER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.153 -0500", hash_original_field = "F729FFED96774F5295D58A715F9257C8", hash_generated_field = "A332A8FAC3899D64A59B1BA4BE38256C")

    public static final int METADATA_KEY_ALBUM           = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.156 -0500", hash_original_field = "0E8A0D4F8FDB3B56B5F1B3ED9C8B4B65", hash_generated_field = "B260EE8DF7D0A3AAC77DCD6397635365")

    public static final int METADATA_KEY_ARTIST          = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.158 -0500", hash_original_field = "92D1A6925D82F4472B086171B20F63C7", hash_generated_field = "94364E7F7221CCEAB7B004990A1161EF")

    public static final int METADATA_KEY_AUTHOR          = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.161 -0500", hash_original_field = "F45C1B9A94A2ECB20B127CCB4B48D900", hash_generated_field = "FD081427E601CC4ED3C33F130BE9A05C")

    public static final int METADATA_KEY_COMPOSER        = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.163 -0500", hash_original_field = "614D2B574BA20EC5BE2D70EFD85B69EE", hash_generated_field = "56BCDC6DA8A24C2BA5009697B974F032")

    public static final int METADATA_KEY_DATE            = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.166 -0500", hash_original_field = "A521C443C959AEF58201FE8D84CB4C32", hash_generated_field = "A0A841A75C91A084EFF03D27761CDFF2")

    public static final int METADATA_KEY_GENRE           = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.168 -0500", hash_original_field = "85B3A554160CC5D3203AB00C2A72C213", hash_generated_field = "5E07A16E006ABD61DACDCB45AC45FD72")

    public static final int METADATA_KEY_TITLE           = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.171 -0500", hash_original_field = "3A03D05A5A0398635ED2B0CD5BD56D4F", hash_generated_field = "B627BD155150B228CAAD2E6F03893E96")

    public static final int METADATA_KEY_YEAR            = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.174 -0500", hash_original_field = "7927AEA208681547630EB25228CC0685", hash_generated_field = "B5CC8C2547709272FC0513E4C573BBD5")

    public static final int METADATA_KEY_DURATION        = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.176 -0500", hash_original_field = "DB08EBE123BB2380A7B628FB5B34E56D", hash_generated_field = "1DDB4F0BAA52B11A6D7F602182654983")

    public static final int METADATA_KEY_NUM_TRACKS      = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.180 -0500", hash_original_field = "BC9314C8F307A7D060272CFD0CF592E5", hash_generated_field = "BDBAB7BE53E33C51C917CDC9C9B0840E")

    public static final int METADATA_KEY_WRITER          = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.182 -0500", hash_original_field = "41772431CAB9ACC4E588CF2B417DCF0D", hash_generated_field = "0CD0514792BFA3307A8EF729B3B8076B")

    public static final int METADATA_KEY_MIMETYPE        = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.185 -0500", hash_original_field = "B3C58DD95BC581ED71D50EFA7CDE4D4A", hash_generated_field = "3B38229DC5B7493B54B38AF9BC5B1D9A")

    public static final int METADATA_KEY_ALBUMARTIST     = 13;
    
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.188 -0500", hash_original_field = "E78633DB13115443B41FE63E1BACF674", hash_generated_field = "87195DDCA157DB9809F223D846F15942")

    public static final int METADATA_KEY_DISC_NUMBER     = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.190 -0500", hash_original_field = "0535D1FCAC13ED087EA3FA8A35195FB2", hash_generated_field = "E5EBE677BEA5F8D03685372EBB030DD1")

    public static final int METADATA_KEY_COMPILATION     = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.193 -0500", hash_original_field = "343525343DEAD8FCDFADC0FE5F0DC04E", hash_generated_field = "60E5F5393E929633191E9F2C6A4056F2")

    public static final int METADATA_KEY_HAS_AUDIO       = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.195 -0500", hash_original_field = "EA58D5C38BE4D73EC2412220877829AE", hash_generated_field = "3F6339F99F930AEFB305E711EDBAE1FC")

    public static final int METADATA_KEY_HAS_VIDEO       = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.198 -0500", hash_original_field = "460CC05FC661EDD5C162E39A5B2BF655", hash_generated_field = "A3FA464A523964FB0786985DBB14FC6C")

    public static final int METADATA_KEY_VIDEO_WIDTH     = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.201 -0500", hash_original_field = "D08C3B863263B378AF75E392F9B04CF6", hash_generated_field = "BCD3E497187EFE972C617A0602FE9F6D")

    public static final int METADATA_KEY_VIDEO_HEIGHT    = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.203 -0500", hash_original_field = "B4D3457C5DAC019F7E855F9F33F1649E", hash_generated_field = "4BEC3C343EDCF094F63DFF20774CC474")

    public static final int METADATA_KEY_BITRATE         = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.205 -0500", hash_original_field = "77A63F06F0EE76050C7EEAEF69EF8E38", hash_generated_field = "E893039E72C831B2BE3858E7E9B9042E")

    public static final int METADATA_KEY_TIMED_TEXT_LANGUAGES      = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.208 -0500", hash_original_field = "F7115BA577D63B570FA4057F209BA019", hash_generated_field = "67D02F67AADF4D87B920C6E6B875577B")

    public static final int METADATA_KEY_IS_DRM          = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.211 -0500", hash_original_field = "DF76C124736200F509AF70E1679A98EB", hash_generated_field = "F80437010E69FE60188044161F9CFC13")

    public static final int METADATA_KEY_LOCATION        = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.070 -0500", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "4FF8A42CAE4591AC91206314B4192EA4")

    @SuppressWarnings("unused")
    private int mNativeContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.075 -0500", hash_original_method = "38580FA1CFCA0A8BC70F7859DD8ED432", hash_generated_method = "E8A79BC0816761C8EA9D84D271D3ABA4")
    
public MediaMetadataRetriever() {
        native_setup();
    }

    /**
     * Sets the data source (file pathname) to use. Call this
     * method before the rest of the methods in this class. This method may be
     * time-consuming.
     * 
     * @param path The path of the input media file.
     * @throws IllegalArgumentException If the path is invalid.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.079 -0500", hash_original_method = "D47DF3C9D755BEB92AD11CA5A5487AA8", hash_generated_method = "318ADC299ACB0CF5EA529B8905847333")
    
    public void setDataSource(String path) throws IllegalArgumentException{
    	//Formerly a native method
    	addTaint(path.getTaint());
    }

    /**
     * Sets the data source (URI) to use. Call this
     * method before the rest of the methods in this class. This method may be
     * time-consuming.
     *
     * @param uri The URI of the input media.
     * @param headers the headers to be sent together with the request for the data
     * @throws IllegalArgumentException If the URI is invalid.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.082 -0500", hash_original_method = "75031631EDBDF61877DE8EFD8981A88D", hash_generated_method = "A5C7CBE8EC0A57C100FDAE4D70C4CF29")
    
public void setDataSource(String uri,  Map<String, String> headers)
            throws IllegalArgumentException {
        int i = 0;
        String[] keys = new String[headers.size()];
        String[] values = new String[headers.size()];
        for (Map.Entry<String, String> entry: headers.entrySet()) {
            keys[i] = entry.getKey();
            values[i] = entry.getValue();
            ++i;
        }
        _setDataSource(uri, keys, values);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.086 -0500", hash_original_method = "1285CC494A70498EAD553FCD7C19AE34", hash_generated_method = "AEB7347C605AC8EE71AD309093B2B6E6")
    
    private void _setDataSource(
            String uri, String[] keys, String[] values)
            throws IllegalArgumentException{
    	//Formerly a native method
    	addTaint(uri.getTaint());
    	addTaint(keys[0].getTaint());
    	addTaint(values[0].getTaint());
    }

    /**
     * Sets the data source (FileDescriptor) to use.  It is the caller's
     * responsibility to close the file descriptor. It is safe to do so as soon
     * as this call returns. Call this method before the rest of the methods in
     * this class. This method may be time-consuming.
     * 
     * @param fd the FileDescriptor for the file you want to play
     * @param offset the offset into the file where the data to be played starts,
     * in bytes. It must be non-negative
     * @param length the length in bytes of the data to be played. It must be
     * non-negative.
     * @throws IllegalArgumentException if the arguments are invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.090 -0500", hash_original_method = "BC4C0D4D9E4315B0C10CA47469C111B0", hash_generated_method = "D85BA1CE07318F11395232A9DB385F44")
    
    public void setDataSource(FileDescriptor fd, long offset, long length)
                throws IllegalArgumentException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(offset);
    	addTaint(length);
    }
    
    /**
     * Sets the data source (FileDescriptor) to use. It is the caller's
     * responsibility to close the file descriptor. It is safe to do so as soon
     * as this call returns. Call this method before the rest of the methods in
     * this class. This method may be time-consuming.
     * 
     * @param fd the FileDescriptor for the file you want to play
     * @throws IllegalArgumentException if the FileDescriptor is invalid
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.093 -0500", hash_original_method = "EF1A32438BC38F472DA718584B5867D9", hash_generated_method = "4280F20F6A6FA29E01FA62C8646B8359")
    
public void setDataSource(FileDescriptor fd)
            throws IllegalArgumentException {
        // intentionally less than LONG_MAX
        setDataSource(fd, 0, 0x7ffffffffffffffL);
    }
    
    /**
     * Sets the data source as a content Uri. Call this method before 
     * the rest of the methods in this class. This method may be time-consuming.
     * 
     * @param context the Context to use when resolving the Uri
     * @param uri the Content URI of the data you want to play
     * @throws IllegalArgumentException if the Uri is invalid
     * @throws SecurityException if the Uri cannot be used due to lack of
     * permission.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.096 -0500", hash_original_method = "701A3FA8EE72D63C1258CD78285617D5", hash_generated_method = "F487EBE20D2B1CF2C1444779A0CD30AC")
    
public void setDataSource(Context context, Uri uri)
        throws IllegalArgumentException, SecurityException {
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        
        String scheme = uri.getScheme();
        if(scheme == null || scheme.equals("file")) {
            setDataSource(uri.getPath());
            return;
        }

        AssetFileDescriptor fd = null;
        try {
            ContentResolver resolver = context.getContentResolver();
            try {
                fd = resolver.openAssetFileDescriptor(uri, "r");
            } catch(FileNotFoundException e) {
                throw new IllegalArgumentException();
            }
            if (fd == null) {
                throw new IllegalArgumentException();
            }
            FileDescriptor descriptor = fd.getFileDescriptor();
            if (!descriptor.valid()) {
                throw new IllegalArgumentException();
            }
            // Note: using getDeclaredLength so that our behavior is the same
            // as previous versions when the content provider is returning
            // a full file.
            if (fd.getDeclaredLength() < 0) {
                setDataSource(descriptor);
            } else {
                setDataSource(descriptor, fd.getStartOffset(), fd.getDeclaredLength());
            }
            return;
        } catch (SecurityException ex) {
        } finally {
            try {
                if (fd != null) {
                    fd.close();
                }
            } catch(IOException ioEx) {
            }
        }
        setDataSource(uri.toString());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.169 -0400", hash_original_method = "8FC26B688DF40812E766667E74AA42B9", hash_generated_method = "FE2CB58CC88315CB1A432EFEAAD82A77")
    public String extractMetadata(int keyCode) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    /**
     * Call this method after setDataSource(). This method finds a
     * representative frame close to the given time position by considering
     * the given option if possible, and returns it as a bitmap. This is
     * useful for generating a thumbnail for an input data source or just
     * obtain and display a frame at the given time position.
     *
     * @param timeUs The time position where the frame will be retrieved.
     * When retrieving the frame at the given time position, there is no
     * guarantee that the data source has a frame located at the position.
     * When this happens, a frame nearby will be returned. If timeUs is
     * negative, time position and option will ignored, and any frame
     * that the implementation considers as representative may be returned.
     *
     * @param option a hint on how the frame is found. Use
     * {@link #OPTION_PREVIOUS_SYNC} if one wants to retrieve a sync frame
     * that has a timestamp earlier than or the same as timeUs. Use
     * {@link #OPTION_NEXT_SYNC} if one wants to retrieve a sync frame
     * that has a timestamp later than or the same as timeUs. Use
     * {@link #OPTION_CLOSEST_SYNC} if one wants to retrieve a sync frame
     * that has a timestamp closest to or the same as timeUs. Use
     * {@link #OPTION_CLOSEST} if one wants to retrieve a frame that may
     * or may not be a sync frame but is closest to or the same as timeUs.
     * {@link #OPTION_CLOSEST} often has larger performance overhead compared
     * to the other options if there is no sync frame located at timeUs.
     *
     * @return A Bitmap containing a representative video frame, which 
     *         can be null, if such a frame cannot be retrieved.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.103 -0500", hash_original_method = "D44D6BE7DFFCAE11832F13741FBDA1F8", hash_generated_method = "88A7311FAAC51426A11B97D0E886B5C4")
    
public Bitmap getFrameAtTime(long timeUs, int option) {
        if (option < OPTION_PREVIOUS_SYNC ||
            option > OPTION_CLOSEST) {
            throw new IllegalArgumentException("Unsupported option: " + option);
        }

        return _getFrameAtTime(timeUs, option);
    }

    /**
     * Call this method after setDataSource(). This method finds a
     * representative frame close to the given time position if possible,
     * and returns it as a bitmap. This is useful for generating a thumbnail
     * for an input data source. Call this method if one does not care
     * how the frame is found as long as it is close to the given time;
     * otherwise, please call {@link #getFrameAtTime(long, int)}.
     *
     * @param timeUs The time position where the frame will be retrieved.
     * When retrieving the frame at the given time position, there is no
     * guarentee that the data source has a frame located at the position.
     * When this happens, a frame nearby will be returned. If timeUs is
     * negative, time position and option will ignored, and any frame
     * that the implementation considers as representative may be returned.
     *
     * @return A Bitmap containing a representative video frame, which
     *         can be null, if such a frame cannot be retrieved.
     *
     * @see #getFrameAtTime(long, int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.106 -0500", hash_original_method = "F77381ED452E3EC1B4D9E71ECA218C76", hash_generated_method = "0D811B8BE139B55E6C5E1B7CBDDBB175")
    
public Bitmap getFrameAtTime(long timeUs) {
        return getFrameAtTime(timeUs, OPTION_CLOSEST_SYNC);
    }

    /**
     * Call this method after setDataSource(). This method finds a
     * representative frame at any time position if possible,
     * and returns it as a bitmap. This is useful for generating a thumbnail
     * for an input data source. Call this method if one does not
     * care about where the frame is located; otherwise, please call
     * {@link #getFrameAtTime(long)} or {@link #getFrameAtTime(long, int)}
     *
     * @return A Bitmap containing a representative video frame, which
     *         can be null, if such a frame cannot be retrieved.
     *
     * @see #getFrameAtTime(long)
     * @see #getFrameAtTime(long, int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.108 -0500", hash_original_method = "B076FDF9A15CA7321A3CFAECED9F7582", hash_generated_method = "D29ADFE2A05B3DF9B524058A151E3CB9")
    
public Bitmap getFrameAtTime() {
        return getFrameAtTime(-1, OPTION_CLOSEST_SYNC);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.171 -0400", hash_original_method = "0267DF76D9FDF0A85486B93D0A2D882E", hash_generated_method = "EAEEF9DF0C3B11B82EFDFB7406623787")
    private Bitmap _getFrameAtTime(long timeUs, int option) {
    	Bitmap bmp = BitmapFactory.decodeByteArray(new byte[] {1}, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT);
    	bmp.addTaint(timeUs);
    	bmp.addTaint(option);
    	return bmp;
    }
    
    /**
     * Call this method after setDataSource(). This method finds the optional
     * graphic or album/cover art associated associated with the data source. If
     * there are more than one pictures, (any) one of them is returned.
     * 
     * @return null if no such graphic is found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.115 -0500", hash_original_method = "BD3973B389FE81CEA52266D9B68AE29D", hash_generated_method = "EACED70D609CB8312649627A912859FB")
    
public byte[] getEmbeddedPicture() {
        return getEmbeddedPicture(EMBEDDED_PICTURE_TYPE_ANY);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.119 -0500", hash_original_method = "B906FFDB309D75A064AF9D81EE962B1C", hash_generated_method = "08ADEAFBA917F96D3A01A7090AD754F4")
    
    private byte[] getEmbeddedPicture(int pictureType){
    	//Formerly a native method
    	addTaint(pictureType);
    	return new byte[]{getTaintByte(),};
    }

    /**
     * Call it when one is done with the object. This method releases the memory
     * allocated internally.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.122 -0500", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "278A7E53643DE73F8A80E1A85A107DD5")
    
    public void release(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.126 -0500", hash_original_method = "B91E9A85D17B4C3984DC1E936380BF22", hash_generated_method = "3AA47E7546A03DC6BF1E9D10CCBDCA7D")
    
    private void native_setup(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.134 -0500", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void native_finalize(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.137 -0500", hash_original_method = "24D5F4C50C2ABC5729410C2F2E889F36", hash_generated_method = "932E17C175F633B7C6ED1D87A1181F69")
    
@Override
    protected void finalize() throws Throwable {
        try {
            native_finalize();
        } finally {
            super.finalize();
        }
    }
}

