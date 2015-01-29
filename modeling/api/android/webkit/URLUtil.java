package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import android.util.Log;

public final class URLUtil {

    /**
     * Cleans up (if possible) user-entered web addresses
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.673 -0500", hash_original_method = "9D80C9082F91CAFA08705A591CB3B142", hash_generated_method = "848B59499902E7D28738BE65161277AE")
    
public static String guessUrl(String inUrl) {

        String retVal = inUrl;
        WebAddress webAddress;

        if (DebugFlags.URL_UTIL) Log.v(LOGTAG, "guessURL before queueRequest: " + inUrl);

        if (inUrl.length() == 0) return inUrl;
        if (inUrl.startsWith("about:")) return inUrl;
        // Do not try to interpret data scheme URLs
        if (inUrl.startsWith("data:")) return inUrl;
        // Do not try to interpret file scheme URLs
        if (inUrl.startsWith("file:")) return inUrl;
        // Do not try to interpret javascript scheme URLs
        if (inUrl.startsWith("javascript:")) return inUrl;

        // bug 762454: strip period off end of url
        if (inUrl.endsWith(".") == true) {
            inUrl = inUrl.substring(0, inUrl.length() - 1);
        }

        try {
            webAddress = new WebAddress(inUrl);
        } catch (ParseException ex) {

            if (DebugFlags.URL_UTIL) {
                Log.v(LOGTAG, "smartUrlFilter: failed to parse url = " + inUrl);
            }
            return retVal;
        }

        // Check host
        if (webAddress.getHost().indexOf('.') == -1) {
            // no dot: user probably entered a bare domain.  try .com
            webAddress.setHost("www." + webAddress.getHost() + ".com");
        }
        return webAddress.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.675 -0500", hash_original_method = "17EE920C64F6DE13B4EC63DEAA50E3EA", hash_generated_method = "4A67D5D07C858DE34DB430D7F6BC9D32")
    
public static String composeSearchUrl(String inQuery, String template,
                                          String queryPlaceHolder) {
        int placeHolderIndex = template.indexOf(queryPlaceHolder);
        if (placeHolderIndex < 0) {
            return null;
        }

        String query;
        StringBuilder buffer = new StringBuilder();
        buffer.append(template.substring(0, placeHolderIndex));

        try {
            query = java.net.URLEncoder.encode(inQuery, "utf-8");
            buffer.append(query);
        } catch (UnsupportedEncodingException ex) {
            return null;
        }

        buffer.append(template.substring(
                placeHolderIndex + queryPlaceHolder.length()));

        return buffer.toString();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.678 -0500", hash_original_method = "8240A7F17F78A2DDA242E2A49435C8A8", hash_generated_method = "98776632F03E8705A784C45EDDAD7964")
    
public static byte[] decode(byte[] url) throws IllegalArgumentException {
        if (url.length == 0) {
            return new byte[0];
        }

        // Create a new byte array with the same length to ensure capacity
        byte[] tempData = new byte[url.length];

        int tempCount = 0;
        for (int i = 0; i < url.length; i++) {
            byte b = url[i];
            if (b == '%') {
                if (url.length - i > 2) {
                    b = (byte) (parseHex(url[i + 1]) * 16
                            + parseHex(url[i + 2]));
                    i += 2;
                } else {
                    throw new IllegalArgumentException("Invalid format");
                }
            }
            tempData[tempCount++] = b;
        }
        byte[] retData = new byte[tempCount];
        System.arraycopy(tempData, 0, retData, 0, tempCount);
        return retData;
    }

    /**
     * @return True iff the url is correctly URL encoded
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.680 -0500", hash_original_method = "B86DCEF63D924FEFE4DB4449754985A4", hash_generated_method = "300E97105D23E6FB87A40176CA6B3A1A")
    
static boolean verifyURLEncoding(String url) {
        int count = url.length();
        if (count == 0) {
            return false;
        }

        int index = url.indexOf('%');
        while (index >= 0 && index < count) {
            if (index < count - 2) {
                try {
                    parseHex((byte) url.charAt(++index));
                    parseHex((byte) url.charAt(++index));
                } catch (IllegalArgumentException e) {
                    return false;
                }
            } else {
                return false;
            }
            index = url.indexOf('%', index + 1);
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.683 -0500", hash_original_method = "2342490C34D4378E5670B7E8B53592CC", hash_generated_method = "8ECF9A9494461412CCE65D52513E6D5A")
    
private static int parseHex(byte b) {
        if (b >= '0' && b <= '9') return (b - '0');
        if (b >= 'A' && b <= 'F') return (b - 'A' + 10);
        if (b >= 'a' && b <= 'f') return (b - 'a' + 10);

        throw new IllegalArgumentException("Invalid hex char '" + b + "'");
    }

    /**
     * @return True iff the url is an asset file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.685 -0500", hash_original_method = "9FBCF1E8843FC5E3EE07E5669AE7FD35", hash_generated_method = "986BD8A60194208CDC08A9548B6E56B7")
    
public static boolean isAssetUrl(String url) {
        return (null != url) && url.startsWith(ASSET_BASE);
    }

    /**
     * @return True iff the url is a resource file.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.688 -0500", hash_original_method = "21D10448C54FA1D3CCEAAD83257A1843", hash_generated_method = "48E572B3FCE43FCD1B97409AFEA96578")
    
public static boolean isResourceUrl(String url) {
        return (null != url) && url.startsWith(RESOURCE_BASE);
    }

    /**
     * @return True iff the url is an proxy url to allow cookieless network 
     * requests from a file url.
     * @deprecated Cookieless proxy is no longer supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.691 -0500", hash_original_method = "81003AB01D40BC758E5136B251404F92", hash_generated_method = "2E3A34C09B0DECC7A8FA6ACE7B84D925")
    
@Deprecated
    public static boolean isCookielessProxyUrl(String url) {
        return (null != url) && url.startsWith(PROXY_BASE);
    }

    /**
     * @return True iff the url is a local file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.693 -0500", hash_original_method = "6770067995A38A9D5405CA956A65E4E8", hash_generated_method = "582D829EDE9B170C77B8922F131370AE")
    
public static boolean isFileUrl(String url) {
        return (null != url) && (url.startsWith(FILE_BASE) &&
                                 !url.startsWith(ASSET_BASE) &&
                                 !url.startsWith(PROXY_BASE));
    }

    /**
     * @return True iff the url is an about: url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.696 -0500", hash_original_method = "E0B35B68469CC1EA0A41559227E21B77", hash_generated_method = "B261C5499B8CB10103F306FB03248F45")
    
public static boolean isAboutUrl(String url) {
        return (null != url) && url.startsWith("about:");
    }

    /**
     * @return True iff the url is a data: url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.698 -0500", hash_original_method = "A7292CD1508DC8A2948CEAFB40E5B67C", hash_generated_method = "5552F0223DCBC495B2A1ECE71D881151")
    
public static boolean isDataUrl(String url) {
        return (null != url) && url.startsWith("data:");
    }

    /**
     * @return True iff the url is a javascript: url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.700 -0500", hash_original_method = "ABECE3B46850D153133B255BB085C421", hash_generated_method = "A0C1BE877362FC5D56FB2CD22DC4EB39")
    
public static boolean isJavaScriptUrl(String url) {
        return (null != url) && url.startsWith("javascript:");
    }

    /**
     * @return True iff the url is an http: url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.702 -0500", hash_original_method = "0577DBF0BAEEFF8711E91E8D88220A50", hash_generated_method = "1F7D6051AEB999AACBE6EBC908CFBB79")
    
public static boolean isHttpUrl(String url) {
        return (null != url) &&
               (url.length() > 6) &&
               url.substring(0, 7).equalsIgnoreCase("http://");
    }

    /**
     * @return True iff the url is an https: url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.705 -0500", hash_original_method = "5A6246C609B220E0DEFAB0D97751B7DA", hash_generated_method = "B1454B3F4F75439267F4126E66F366CF")
    
public static boolean isHttpsUrl(String url) {
        return (null != url) &&
               (url.length() > 7) &&
               url.substring(0, 8).equalsIgnoreCase("https://");
    }

    /**
     * @return True iff the url is a network url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.707 -0500", hash_original_method = "9AD0BE9C8CD23EFD3B89246A82C1A504", hash_generated_method = "2388AD5AD8360C7B69E0370FB8D48427")
    
public static boolean isNetworkUrl(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }
        return isHttpUrl(url) || isHttpsUrl(url);
    }

    /**
     * @return True iff the url is a content: url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.709 -0500", hash_original_method = "FE2F4BAC8672AD6CD9CB7475EEFC530C", hash_generated_method = "0DF114E7F9221C7996C6CFAC43C483B1")
    
public static boolean isContentUrl(String url) {
        return (null != url) && url.startsWith("content:");
    }

    /**
     * @return True iff the url is valid.
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.712 -0500", hash_original_method = "2527411CED96FFEC1D8C9EE305F559EE", hash_generated_method = "E404149FB48C572109BCE8D35AB2AA48")
    
public static boolean isValidUrl(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }

        return (isAssetUrl(url) ||
                isResourceUrl(url) ||
                isFileUrl(url) ||
                isAboutUrl(url) ||
                isHttpUrl(url) ||
                isHttpsUrl(url) ||
                isJavaScriptUrl(url) ||
                isContentUrl(url));
    }

    /**
     * Strips the url of the anchor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.714 -0500", hash_original_method = "82D8655C49413B091F33E67A02E6B20F", hash_generated_method = "F42AA45B9945F1794A34A616DE3A9D73")
    
public static String stripAnchor(String url) {
        int anchorIndex = url.indexOf('#');
        if (anchorIndex != -1) {
            return url.substring(0, anchorIndex);
        }
        return url;
    }
    
    /**
     * Guesses canonical filename that a download would have, using
     * the URL and contentDisposition. File extension, if not defined,
     * is added based on the mimetype
     * @param url Url to the content
     * @param contentDisposition Content-Disposition HTTP header or null
     * @param mimeType Mime-type of the content or null
     * 
     * @return suggested filename
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.718 -0500", hash_original_method = "8CDFE7B5CE94DD276F31B39577FD5966", hash_generated_method = "3DC47773A05DF5A1FCD734C0E40FC588")
    
public static final String guessFileName(
            String url,
            String contentDisposition,
            String mimeType) {
        String filename = null;
        String extension = null;

        // If we couldn't do anything with the hint, move toward the content disposition
        if (filename == null && contentDisposition != null) {
            filename = parseContentDisposition(contentDisposition);
            if (filename != null) {
                int index = filename.lastIndexOf('/') + 1;
                if (index > 0) {
                    filename = filename.substring(index);
                }
            }
        }

        // If all the other http-related approaches failed, use the plain uri
        if (filename == null) {
            String decodedUrl = Uri.decode(url);
            if (decodedUrl != null) {
                int queryIndex = decodedUrl.indexOf('?');
                // If there is a query string strip it, same as desktop browsers
                if (queryIndex > 0) {
                    decodedUrl = decodedUrl.substring(0, queryIndex);
                }
                if (!decodedUrl.endsWith("/")) {
                    int index = decodedUrl.lastIndexOf('/') + 1;
                    if (index > 0) {
                        filename = decodedUrl.substring(index);
                    }
                }
            }
        }

        // Finally, if couldn't get filename from URI, get a generic filename
        if (filename == null) {
            filename = "downloadfile";
        }

        // Split filename between base and extension
        // Add an extension if filename does not have one
        int dotIndex = filename.indexOf('.');
        if (dotIndex < 0) {
            if (mimeType != null) {
                extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType);
                if (extension != null) {
                    extension = "." + extension;
                }
            }
            if (extension == null) {
                if (mimeType != null && mimeType.toLowerCase().startsWith("text/")) {
                    if (mimeType.equalsIgnoreCase("text/html")) {
                        extension = ".html";
                    } else {
                        extension = ".txt";
                    }
                } else {
                    extension = ".bin";
                }
            }
        } else {
            if (mimeType != null) {
                // Compare the last segment of the extension against the mime type.
                // If there's a mismatch, discard the entire extension.
                int lastDotIndex = filename.lastIndexOf('.');
                String typeFromExt = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                        filename.substring(lastDotIndex + 1));
                if (typeFromExt != null && !typeFromExt.equalsIgnoreCase(mimeType)) {
                    extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType);
                    if (extension != null) {
                        extension = "." + extension;
                    }
                }
            }
            if (extension == null) {
                extension = filename.substring(dotIndex);
            }
            filename = filename.substring(0, dotIndex);
        }

        return filename + extension;
    }

    /*
     * Parse the Content-Disposition HTTP Header. The format of the header
     * is defined here: http://www.w3.org/Protocols/rfc2616/rfc2616-sec19.html
     * This header provides a filename for content that is going to be
     * downloaded to the file system. We only support the attachment type.
     * Note that RFC 2616 specifies the filename value must be double-quoted.
     * Unfortunately some servers do not quote the value so to maintain
     * consistent behaviour with other browsers, we allow unquoted values too.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.722 -0500", hash_original_method = "AA01DDAC57CD33C8744947339D947DA2", hash_generated_method = "637A39E6F89446E95646E0DFD9E68E60")
    
static String parseContentDisposition(String contentDisposition) {
        try {
            Matcher m = CONTENT_DISPOSITION_PATTERN.matcher(contentDisposition);
            if (m.find()) {
                return m.group(2);
            }
        } catch (IllegalStateException ex) {
             // This function is defined as returning null when it can't parse the header
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.661 -0500", hash_original_field = "CF5103981B618784F76950E4558FDBCC", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.663 -0500", hash_original_field = "8FEE478141829863F395EE3520B21B0F", hash_generated_field = "E575175BEB352DC9B9221FF58DCC2B7E")

    // "file:///android_asset/foo/bar.png".
    static final String ASSET_BASE = "file:///android_asset/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.665 -0500", hash_original_field = "D04DFEA6110A8C35850D0A9C99F010CD", hash_generated_field = "B18A86632B387489BE88AA5471087F05")

    // "file:///android_res/drawable/bar.png". Use "drawable" to refer to
    // "drawable-hdpi" directory as well.
    static final String RESOURCE_BASE = "file:///android_res/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.667 -0500", hash_original_field = "32A164AADC4C610E4EC37D2AED0674FA", hash_generated_field = "4C4EBAD751642DB37C255157F2A97244")

    static final String FILE_BASE = "file://";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.670 -0500", hash_original_field = "5B0D60920F408916AB7DA0CF43360B90", hash_generated_field = "104E441706A1DF8685818DA8868D49C9")

    static final String PROXY_BASE = "file:///cookieless_proxy/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.720 -0500", hash_original_field = "043043FBC18153C0406F14AE6C7045F9", hash_generated_field = "54A966242246C6999ED8F8A4812598B6")

    private static final Pattern CONTENT_DISPOSITION_PATTERN =
            Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$",
            Pattern.CASE_INSENSITIVE);
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.216 -0400", hash_original_method = "581EF9FF4A1E1085E3970232802A3705", hash_generated_method = "581EF9FF4A1E1085E3970232802A3705")
    public URLUtil ()
    {
        //Synthesized constructor
    }
}

