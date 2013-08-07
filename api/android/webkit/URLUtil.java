package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import android.util.Log;





public final class URLUtil {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.216 -0400", hash_original_method = "581EF9FF4A1E1085E3970232802A3705", hash_generated_method = "581EF9FF4A1E1085E3970232802A3705")
    public URLUtil ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static String guessUrl(String inUrl) {
        String retVal = inUrl;
        WebAddress webAddress;
        if (DebugFlags.URL_UTIL) Log.v(LOGTAG, "guessURL before queueRequest: " + inUrl);
        if (inUrl.length() == 0) return inUrl;
        if (inUrl.startsWith("about:")) return inUrl;
        if (inUrl.startsWith("data:")) return inUrl;
        if (inUrl.startsWith("file:")) return inUrl;
        if (inUrl.startsWith("javascript:")) return inUrl;
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
        if (webAddress.getHost().indexOf('.') == -1) {
            webAddress.setHost("www." + webAddress.getHost() + ".com");
        }
        return webAddress.toString();
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    public static byte[] decode(byte[] url) throws IllegalArgumentException {
        if (url.length == 0) {
            return new byte[0];
        }
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.BAN)
    private static int parseHex(byte b) {
        if (b >= '0' && b <= '9') return (b - '0');
        if (b >= 'A' && b <= 'F') return (b - 'A' + 10);
        if (b >= 'a' && b <= 'f') return (b - 'a' + 10);
        throw new IllegalArgumentException("Invalid hex char '" + b + "'");
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isAssetUrl(String url) {
        return (null != url) && url.startsWith(ASSET_BASE);
    }

    
    @DSModeled(DSC.BAN)
    public static boolean isResourceUrl(String url) {
        return (null != url) && url.startsWith(RESOURCE_BASE);
    }

    
    @DSModeled(DSC.SPEC)
    @Deprecated
    public static boolean isCookielessProxyUrl(String url) {
        return (null != url) && url.startsWith(PROXY_BASE);
    }

    
    public static boolean isFileUrl(String url) {
        return (null != url) && (url.startsWith(FILE_BASE) &&
                                 !url.startsWith(ASSET_BASE) &&
                                 !url.startsWith(PROXY_BASE));
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isAboutUrl(String url) {
        return (null != url) && url.startsWith("about:");
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isDataUrl(String url) {
        return (null != url) && url.startsWith("data:");
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isJavaScriptUrl(String url) {
        return (null != url) && url.startsWith("javascript:");
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isHttpUrl(String url) {
        return (null != url) &&
               (url.length() > 6) &&
               url.substring(0, 7).equalsIgnoreCase("http://");
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isHttpsUrl(String url) {
        return (null != url) &&
               (url.length() > 7) &&
               url.substring(0, 8).equalsIgnoreCase("https://");
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isNetworkUrl(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }
        return isHttpUrl(url) || isHttpsUrl(url);
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isContentUrl(String url) {
        return (null != url) && url.startsWith("content:");
    }

    
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

    
    @DSModeled(DSC.SPEC)
    public static String stripAnchor(String url) {
        int anchorIndex = url.indexOf('#');
        if (anchorIndex != -1) {
            return url.substring(0, anchorIndex);
        }
        return url;
    }

    
    public static final String guessFileName(
            String url,
            String contentDisposition,
            String mimeType) {
        String filename = null;
        String extension = null;
        if (filename == null && contentDisposition != null) {
            filename = parseContentDisposition(contentDisposition);
            if (filename != null) {
                int index = filename.lastIndexOf('/') + 1;
                if (index > 0) {
                    filename = filename.substring(index);
                }
            }
        }
        if (filename == null) {
            String decodedUrl = Uri.decode(url);
            if (decodedUrl != null) {
                int queryIndex = decodedUrl.indexOf('?');
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
        if (filename == null) {
            filename = "downloadfile";
        }
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

    
    @DSModeled(DSC.SPEC)
    static String parseContentDisposition(String contentDisposition) {
        try {
            Matcher m = CONTENT_DISPOSITION_PATTERN.matcher(contentDisposition);
            if (m.find()) {
                return m.group(2);
            }
        } catch (IllegalStateException ex) {
        }
        return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.219 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.219 -0400", hash_original_field = "BACD749C65C027DBF29226FBBB30A932", hash_generated_field = "2E352A21C2E8AA2180D7AADA5AD3F445")

    static final String ASSET_BASE = "file:///android_asset/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.219 -0400", hash_original_field = "9376DDBC43C10F9E023EFBC3708B397C", hash_generated_field = "94490EFDDE96CFA02BB10BB275BC4D3E")

    static final String RESOURCE_BASE = "file:///android_res/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.219 -0400", hash_original_field = "B7A11B6B0F190799195F07BEE76A8891", hash_generated_field = "4C4EBAD751642DB37C255157F2A97244")

    static final String FILE_BASE = "file://";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.219 -0400", hash_original_field = "04B24A8C89E94214A450F2E3B193AF72", hash_generated_field = "104E441706A1DF8685818DA8868D49C9")

    static final String PROXY_BASE = "file:///cookieless_proxy/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.219 -0400", hash_original_field = "91C530073C1D8723C9CBBE1EE5BB80A9", hash_generated_field = "54A966242246C6999ED8F8A4812598B6")

    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$",
            Pattern.CASE_INSENSITIVE);
}

