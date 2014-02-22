package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.regex.Pattern;

import libcore.net.MimeUtils;
import android.text.TextUtils;

public class MimeTypeMap {

    /**
     * Returns the file extension or an empty string iff there is no
     * extension. This method is a convenience method for obtaining the
     * extension of a url and has undefined results for other Strings.
     * @param url
     * @return The file extension of the given url.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.152 -0500", hash_original_method = "5C8472A4BF23E5ABD60543D4D726ECB1", hash_generated_method = "53F198E505517BB1B332F50D0B132F1F")
    
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

            // if the filename contains special characters, we don't
            // consider it valid for our matching purposes:
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

    // Static method called by jni.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.158 -0500", hash_original_method = "A042DF11FC396083771CF7C6C82EEB8E", hash_generated_method = "54652D16722A89B788B9DC2B62E986B5")
    
private static String mimeTypeFromExtension(String extension) {
        return MimeUtils.guessMimeTypeFromExtension(extension);
    }

    /**
     * Get the singleton instance of MimeTypeMap.
     * @return The singleton instance of the MIME-type map.
     */
    @DSComment("Data structure factory")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.167 -0500", hash_original_method = "73A67A406B5A25034635E2FEA1819640", hash_generated_method = "169C199BAED4B582FF1B5FA6B4FA7742")
    
public static MimeTypeMap getSingleton() {
        return sMimeTypeMap;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.147 -0500", hash_original_field = "FF1D1DDAF6AD6B57B8EF654C6DB448E5", hash_generated_field = "3D500F8A607DFB7B10663A6EAAD8C4BD")

    private static final MimeTypeMap sMimeTypeMap = new MimeTypeMap();

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.149 -0500", hash_original_method = "D2809047C19DC484190C3B6A1503A531", hash_generated_method = "6C67DEF4D1B8466A735788048BB3AF9F")
    
private MimeTypeMap() {
    }

    /**
     * Return true if the given MIME type has an entry in the map.
     * @param mimeType A MIME type (i.e. text/plain)
     * @return True iff there is a mimeType entry in the map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.154 -0500", hash_original_method = "D279ABCEA3115671095B1C76CF272D07", hash_generated_method = "E3C18E6A880457434E2503225DBCC1E0")
    
public boolean hasMimeType(String mimeType) {
        return MimeUtils.hasMimeType(mimeType);
    }

    /**
     * Return the MIME type for the given extension.
     * @param extension A file extension without the leading '.'
     * @return The MIME type for the given extension or null iff there is none.
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.156 -0500", hash_original_method = "9405A52065BBD485ABF37D1CA921E56B", hash_generated_method = "EDD49E0F199A255FBC119868328FE566")
    
public String getMimeTypeFromExtension(String extension) {
        return MimeUtils.guessMimeTypeFromExtension(extension);
    }

    /**
     * Return true if the given extension has a registered MIME type.
     * @param extension A file extension without the leading '.'
     * @return True iff there is an extension entry in the map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.160 -0500", hash_original_method = "0FDF6D870E8A1081CB846B08F1E5769A", hash_generated_method = "02AD04A7CAB9640454FD6A3E63A18689")
    
public boolean hasExtension(String extension) {
        return MimeUtils.hasExtension(extension);
    }

    /**
     * Return the registered extension for the given MIME type. Note that some
     * MIME types map to multiple extensions. This call will return the most
     * common extension for the given MIME type.
     * @param mimeType A MIME type (i.e. text/plain)
     * @return The extension for the given MIME type or null iff there is none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.162 -0500", hash_original_method = "CB74F3FB06BF8C09198BE8DA9DF60967", hash_generated_method = "BEF4A01833E02F78B113AF11C6F31C57")
    
public String getExtensionFromMimeType(String mimeType) {
        return MimeUtils.guessExtensionFromMimeType(mimeType);
    }

    /**
     * If the given MIME type is null, or one of the "generic" types (text/plain
     * or application/octet-stream) map it to a type that Android can deal with.
     * If the given type is not generic, return it unchanged.
     *
     * @param mimeType MIME type provided by the server.
     * @param url URL of the data being loaded.
     * @param contentDisposition Content-disposition header given by the server.
     * @return The MIME type that should be used for this data.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.164 -0500", hash_original_method = "8195A5AC7EDE6C7AAA15CD33C312F38D", hash_generated_method = "AD9F182D1FD77219DDE792983B414E62")
    
String remapGenericMimeType(String mimeType, String url,
            String contentDisposition) {
        // If we have one of "generic" MIME types, try to deduce
        // the right MIME type from the file extension (if any):
        if ("text/plain".equals(mimeType) ||
                "application/octet-stream".equals(mimeType)) {

            // for attachment, use the filename in the Content-Disposition
            // to guess the mimetype
            String filename = null;
            if (contentDisposition != null) {
                filename = URLUtil.parseContentDisposition(contentDisposition);
            }
            if (filename != null) {
                url = filename;
            }
            String extension = getFileExtensionFromUrl(url);
            String newMimeType = getMimeTypeFromExtension(extension);
            if (newMimeType != null) {
                mimeType = newMimeType;
            }
        } else if ("text/vnd.wap.wml".equals(mimeType)) {
            // As we don't support wml, render it as plain text
            mimeType = "text/plain";
        } else {
            // It seems that xhtml+xml and vnd.wap.xhtml+xml mime
            // subtypes are used interchangeably. So treat them the same.
            if ("application/vnd.wap.xhtml+xml".equals(mimeType)) {
                mimeType = "application/xhtml+xml";
            }
        }
        return mimeType;
    }
}

