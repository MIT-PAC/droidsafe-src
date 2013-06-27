package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.regex.Pattern;
import libcore.net.MimeUtils;

public class MimeTypeMap {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.937 -0400", hash_original_method = "D2809047C19DC484190C3B6A1503A531", hash_generated_method = "3813AC6B5CB9CE0F32CF63BF21EAB5DA")
    private  MimeTypeMap() {
        // ---------- Original Method ----------
    }

    
        public static String getFileExtensionFromUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            int fragment = url.lastIndexOf('#');
            if (fragment > 0) {
                url = url.substring(0, fragment);
            }
            int query = url.lastIndexOf('?');
            if (query > 0) {
                url = url.substring(0, query);
            }
            int filenamePos = url.lastIndexOf('/');
            String filename =
                0 <= filenamePos ? url.substring(filenamePos + 1) : url;
            if (!filename.isEmpty() &&
                Pattern.matches("[a-zA-Z_0-9\\.\\-\\(\\)\\%]+", filename)) {
                int dotPos = filename.lastIndexOf('.');
                if (0 <= dotPos) {
                    return filename.substring(dotPos + 1);
                }
            }
        }
        return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.938 -0400", hash_original_method = "D279ABCEA3115671095B1C76CF272D07", hash_generated_method = "7B66CF8BB776F0F4AFF8BDA741BA715C")
    public boolean hasMimeType(String mimeType) {
        boolean var4B1BAFD38DD6F2F154669CF3E55C5C1F_614526440 = (MimeUtils.hasMimeType(mimeType));
        addTaint(mimeType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395593390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395593390;
        // ---------- Original Method ----------
        //return MimeUtils.hasMimeType(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.953 -0400", hash_original_method = "9405A52065BBD485ABF37D1CA921E56B", hash_generated_method = "93E278EB8E6F7E21BBAD4701EFEBF494")
    public String getMimeTypeFromExtension(String extension) {
        String varB4EAC82CA7396A68D541C85D26508E83_307443145 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_307443145 = MimeUtils.guessMimeTypeFromExtension(extension);
        addTaint(extension.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_307443145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_307443145;
        // ---------- Original Method ----------
        //return MimeUtils.guessMimeTypeFromExtension(extension);
    }

    
        private static String mimeTypeFromExtension(String extension) {
        return MimeUtils.guessMimeTypeFromExtension(extension);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.958 -0400", hash_original_method = "0FDF6D870E8A1081CB846B08F1E5769A", hash_generated_method = "C1DFF17661E3E0223CEB3E6F9E667E9D")
    public boolean hasExtension(String extension) {
        boolean varD8871BD6B8337A54A3C048C36CA3F7A7_2036065410 = (MimeUtils.hasExtension(extension));
        addTaint(extension.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_454473943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_454473943;
        // ---------- Original Method ----------
        //return MimeUtils.hasExtension(extension);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.959 -0400", hash_original_method = "CB74F3FB06BF8C09198BE8DA9DF60967", hash_generated_method = "C11B3A7649549B36EAFA029BC09ADA95")
    public String getExtensionFromMimeType(String mimeType) {
        String varB4EAC82CA7396A68D541C85D26508E83_44394718 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_44394718 = MimeUtils.guessExtensionFromMimeType(mimeType);
        addTaint(mimeType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_44394718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_44394718;
        // ---------- Original Method ----------
        //return MimeUtils.guessExtensionFromMimeType(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.039 -0400", hash_original_method = "8195A5AC7EDE6C7AAA15CD33C312F38D", hash_generated_method = "EB42336BC11CF749829ED95A556493CD")
     String remapGenericMimeType(String mimeType, String url,
            String contentDisposition) {
        String varB4EAC82CA7396A68D541C85D26508E83_982889751 = null; //Variable for return #1
        {
            boolean varD017DA53BFA52B744B6E737D7E89CE66_792330501 = ("text/plain".equals(mimeType) ||
                "application/octet-stream".equals(mimeType));
            {
                String filename;
                filename = null;
                {
                    filename = URLUtil.parseContentDisposition(contentDisposition);
                } //End block
                {
                    url = filename;
                } //End block
                String extension;
                extension = getFileExtensionFromUrl(url);
                String newMimeType;
                newMimeType = getMimeTypeFromExtension(extension);
                {
                    mimeType = newMimeType;
                } //End block
            } //End block
            {
                boolean var68AC8C414A3D42236AE1AB319DBB151F_1140169374 = ("text/vnd.wap.wml".equals(mimeType));
                {
                    mimeType = "text/plain";
                } //End block
                {
                    {
                        boolean var61557B498F43C779DEB2860D41B1C26C_1370013873 = ("application/vnd.wap.xhtml+xml".equals(mimeType));
                        {
                            mimeType = "application/xhtml+xml";
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_982889751 = mimeType;
        addTaint(mimeType.getTaint());
        addTaint(url.getTaint());
        addTaint(contentDisposition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_982889751.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_982889751;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static MimeTypeMap getSingleton() {
        return sMimeTypeMap;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.039 -0400", hash_original_field = "16E55BAE015A69FFABBB45A7410C4B7E", hash_generated_field = "1C1FA4DEE284B2DD06AF1473F0C1F4B5")

    private static MimeTypeMap sMimeTypeMap = new MimeTypeMap();
}

