package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.regex.Pattern;
import libcore.net.MimeUtils;

public class MimeTypeMap {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.770 -0400", hash_original_method = "D2809047C19DC484190C3B6A1503A531", hash_generated_method = "3813AC6B5CB9CE0F32CF63BF21EAB5DA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.771 -0400", hash_original_method = "D279ABCEA3115671095B1C76CF272D07", hash_generated_method = "7573F07C8B5FB296641AA603A27CB5FD")
    public boolean hasMimeType(String mimeType) {
        addTaint(mimeType.getTaint());
        boolean var1882FF8BA738477F3D843ED303B8BB1D_777049440 = (MimeUtils.hasMimeType(mimeType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647406589 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647406589;
        // ---------- Original Method ----------
        //return MimeUtils.hasMimeType(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.771 -0400", hash_original_method = "9405A52065BBD485ABF37D1CA921E56B", hash_generated_method = "CDFACE2870E07578B8048A3D44C3FACE")
    public String getMimeTypeFromExtension(String extension) {
        addTaint(extension.getTaint());
String var4DAE02CC55ADD03932C065B04B888027_1374297065 =         MimeUtils.guessMimeTypeFromExtension(extension);
        var4DAE02CC55ADD03932C065B04B888027_1374297065.addTaint(taint);
        return var4DAE02CC55ADD03932C065B04B888027_1374297065;
        // ---------- Original Method ----------
        //return MimeUtils.guessMimeTypeFromExtension(extension);
    }

    
        private static String mimeTypeFromExtension(String extension) {
        return MimeUtils.guessMimeTypeFromExtension(extension);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.771 -0400", hash_original_method = "0FDF6D870E8A1081CB846B08F1E5769A", hash_generated_method = "54AA5A5C3D716533B7965E5B726B1BD7")
    public boolean hasExtension(String extension) {
        addTaint(extension.getTaint());
        boolean var3EDB18A82F44C3851921E4DF87DD5C3E_1225408912 = (MimeUtils.hasExtension(extension));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52066905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_52066905;
        // ---------- Original Method ----------
        //return MimeUtils.hasExtension(extension);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.771 -0400", hash_original_method = "CB74F3FB06BF8C09198BE8DA9DF60967", hash_generated_method = "77BCD29136DB6F4F30CAC19787085685")
    public String getExtensionFromMimeType(String mimeType) {
        addTaint(mimeType.getTaint());
String varB4A30242D1D4E5BAA090B65DC871EF20_1451489457 =         MimeUtils.guessExtensionFromMimeType(mimeType);
        varB4A30242D1D4E5BAA090B65DC871EF20_1451489457.addTaint(taint);
        return varB4A30242D1D4E5BAA090B65DC871EF20_1451489457;
        // ---------- Original Method ----------
        //return MimeUtils.guessExtensionFromMimeType(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.772 -0400", hash_original_method = "8195A5AC7EDE6C7AAA15CD33C312F38D", hash_generated_method = "C54CC446FEE269B46BE767B06CC07E96")
     String remapGenericMimeType(String mimeType, String url,
            String contentDisposition) {
        addTaint(contentDisposition.getTaint());
        addTaint(url.getTaint());
        addTaint(mimeType.getTaint());
    if("text/plain".equals(mimeType) ||
                "application/octet-stream".equals(mimeType))        
        {
            String filename = null;
    if(contentDisposition != null)            
            {
                filename = URLUtil.parseContentDisposition(contentDisposition);
            } //End block
    if(filename != null)            
            {
                url = filename;
            } //End block
            String extension = getFileExtensionFromUrl(url);
            String newMimeType = getMimeTypeFromExtension(extension);
    if(newMimeType != null)            
            {
                mimeType = newMimeType;
            } //End block
        } //End block
        else
    if("text/vnd.wap.wml".equals(mimeType))        
        {
            mimeType = "text/plain";
        } //End block
        else
        {
    if("application/vnd.wap.xhtml+xml".equals(mimeType))            
            {
                mimeType = "application/xhtml+xml";
            } //End block
        } //End block
String var31E26FAFE73C53DECDB0A7F1CF57D932_1530623850 =         mimeType;
        var31E26FAFE73C53DECDB0A7F1CF57D932_1530623850.addTaint(taint);
        return var31E26FAFE73C53DECDB0A7F1CF57D932_1530623850;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static MimeTypeMap getSingleton() {
        return sMimeTypeMap;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.772 -0400", hash_original_field = "16E55BAE015A69FFABBB45A7410C4B7E", hash_generated_field = "3D500F8A607DFB7B10663A6EAAD8C4BD")

    private static final MimeTypeMap sMimeTypeMap = new MimeTypeMap();
}

