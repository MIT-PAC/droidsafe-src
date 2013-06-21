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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.561 -0400", hash_original_method = "D2809047C19DC484190C3B6A1503A531", hash_generated_method = "3813AC6B5CB9CE0F32CF63BF21EAB5DA")
    @DSModeled(DSC.SAFE)
    private MimeTypeMap() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.562 -0400", hash_original_method = "D279ABCEA3115671095B1C76CF272D07", hash_generated_method = "08317D799E1354A164A92904D54CF716")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMimeType(String mimeType) {
        dsTaint.addTaint(mimeType);
        boolean var4B1BAFD38DD6F2F154669CF3E55C5C1F_1265522502 = (MimeUtils.hasMimeType(mimeType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return MimeUtils.hasMimeType(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.562 -0400", hash_original_method = "9405A52065BBD485ABF37D1CA921E56B", hash_generated_method = "DE13874E6A8B380939BE6D85C448C790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMimeTypeFromExtension(String extension) {
        dsTaint.addTaint(extension);
        String var33583EF8048969DD704660B7E15ECC5B_565963031 = (MimeUtils.guessMimeTypeFromExtension(extension));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return MimeUtils.guessMimeTypeFromExtension(extension);
    }

    
        private static String mimeTypeFromExtension(String extension) {
        return MimeUtils.guessMimeTypeFromExtension(extension);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.563 -0400", hash_original_method = "0FDF6D870E8A1081CB846B08F1E5769A", hash_generated_method = "5FFA9EB66059244FE8A973A77EE03A8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasExtension(String extension) {
        dsTaint.addTaint(extension);
        boolean varD8871BD6B8337A54A3C048C36CA3F7A7_1025427171 = (MimeUtils.hasExtension(extension));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return MimeUtils.hasExtension(extension);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.563 -0400", hash_original_method = "CB74F3FB06BF8C09198BE8DA9DF60967", hash_generated_method = "477ED5ABFB22667D1587293D6F9AAF52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getExtensionFromMimeType(String mimeType) {
        dsTaint.addTaint(mimeType);
        String var09D0525CBA98ADB3258E9962BEBFE7AF_376296712 = (MimeUtils.guessExtensionFromMimeType(mimeType));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return MimeUtils.guessExtensionFromMimeType(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.563 -0400", hash_original_method = "8195A5AC7EDE6C7AAA15CD33C312F38D", hash_generated_method = "4382BCD3670223D181D53527AB6C6A62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String remapGenericMimeType(String mimeType, String url,
            String contentDisposition) {
        dsTaint.addTaint(contentDisposition);
        dsTaint.addTaint(url);
        dsTaint.addTaint(mimeType);
        {
            boolean varD017DA53BFA52B744B6E737D7E89CE66_752765589 = ("text/plain".equals(mimeType) ||
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
                boolean var68AC8C414A3D42236AE1AB319DBB151F_257678680 = ("text/vnd.wap.wml".equals(mimeType));
                {
                    mimeType = "text/plain";
                } //End block
                {
                    {
                        boolean var61557B498F43C779DEB2860D41B1C26C_1173234313 = ("application/vnd.wap.xhtml+xml".equals(mimeType));
                        {
                            mimeType = "application/xhtml+xml";
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static MimeTypeMap getSingleton() {
        return sMimeTypeMap;
    }

    
    private static final MimeTypeMap sMimeTypeMap = new MimeTypeMap();
}

