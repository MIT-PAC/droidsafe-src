package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

import android.os.Parcel;
import android.os.Parcelable;

import droidsafe.helpers.DSUtils;

public class Uri implements Parcelable, Comparable<Uri> {
    
        public static Uri parse(String uriString) {
            return new Uri(uriString);
        }

    /**
     * Creates a Uri from a file. The URI has the form
     * "file://<absolute path>". Encodes path characters with the exception of
     * '/'.
     *
     * <p>Example: "file:///tmp/android.txt"
     *
     * @throws NullPointerException if file is null
     * @return a Uri for the given file
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.971 -0500", hash_original_method = "C8E1BC520600654AF7D7DBB518285820", hash_generated_method = "06EDC206A38F612490541C35EAB729B0")
    
public static Uri fromFile(File file) {
        if (file == null) {
            throw new NullPointerException("file");
        }

        PathPart path = PathPart.fromDecoded(file.getAbsolutePath());
        return new HierarchicalUri(
                "file", Part.EMPTY, path, Part.NULL, Part.NULL);
    }

    /**
     * Creates an opaque Uri from the given components. Encodes the ssp
     * which means this method cannot be used to create hierarchical URIs.
     *
     * @param scheme of the URI
     * @param ssp scheme-specific-part, everything between the
     *  scheme separator (':') and the fragment separator ('#'), which will
     *  get encoded
     * @param fragment fragment, everything after the '#', null if undefined,
     *  will get encoded
     *
     * @throws NullPointerException if scheme or ssp is null
     * @return Uri composed of the given scheme, ssp, and fragment
     *
     * @see Builder if you don't want the ssp and fragment to be encoded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.083 -0500", hash_original_method = "0AD237FFD29D45E9689601598F4FC92E", hash_generated_method = "9D21685D66E36BC775C6163A2712CC60")
    
public static Uri fromParts(String scheme, String ssp,
            String fragment) {
        if (scheme == null) {
            throw new NullPointerException("scheme");
        }
        if (ssp == null) {
            throw new NullPointerException("ssp");
        }

        return new OpaqueUri(scheme, Part.fromDecoded(ssp),
                Part.fromDecoded(fragment));
    }

    /**
     * Writes a Uri to a Parcel.
     *
     * @param out parcel to write to
     * @param uri to write, can be null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.392 -0500", hash_original_method = "4AD2B9D8D63865C3ECF569D0E6B1A555", hash_generated_method = "9A87E198A1AE69D2D29504ABFA3E441B")
    
public static void writeToParcel(Parcel out, Uri uri) {
        if (uri == null) {
            out.writeInt(NULL_TYPE_ID);
        } else {
            uri.writeToParcel(out, 0);
        }
    }

    /**
     * Encodes characters in the given string as '%'-escaped octets
     * using the UTF-8 scheme. Leaves letters ("A-Z", "a-z"), numbers
     * ("0-9"), and unreserved characters ("_-!.~'()*") intact. Encodes
     * all other characters.
     *
     * @param s string to encode
     * @return an encoded version of s suitable for use as a URI component,
     *  or null if s is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.396 -0500", hash_original_method = "49BB482E96A859715BC5C61306FD74C0", hash_generated_method = "C724103AB538903E19E5DE37C9B2FBE9")
    
public static String encode(String s) {
        return encode(s, null);
    }

    /**
     * Encodes characters in the given string as '%'-escaped octets
     * using the UTF-8 scheme. Leaves letters ("A-Z", "a-z"), numbers
     * ("0-9"), and unreserved characters ("_-!.~'()*") intact. Encodes
     * all other characters with the exception of those specified in the
     * allow argument.
     *
     * @param s string to encode
     * @param allow set of additional characters to allow in the encoded form,
     *  null if no characters should be skipped
     * @return an encoded version of s suitable for use as a URI component,
     *  or null if s is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.399 -0500", hash_original_method = "1C5D49909CC2D6B9385B7495620A5621", hash_generated_method = "835A012B817E2AE6DD44309433E28C9D")
    
public static String encode(String s, String allow) {
        if (s == null) {
            return null;
        }

        // Lazily-initialized buffers.
        StringBuilder encoded = null;

        int oldLength = s.length();

        // This loop alternates between copying over allowed characters and
        // encoding in chunks. This results in fewer method calls and
        // allocations than encoding one character at a time.
        int current = 0;
        while (current < oldLength) {
            // Start in "copying" mode where we copy over allowed chars.

            // Find the next character which needs to be encoded.
            int nextToEncode = current;
            while (nextToEncode < oldLength
                    && isAllowed(s.charAt(nextToEncode), allow)) {
                nextToEncode++;
            }

            // If there's nothing more to encode...
            if (nextToEncode == oldLength) {
                if (current == 0) {
                    // We didn't need to encode anything!
                    return s;
                } else {
                    // Presumably, we've already done some encoding.
                    encoded.append(s, current, oldLength);
                    return encoded.toString();
                }
            }

            if (encoded == null) {
                encoded = new StringBuilder();
            }

            if (nextToEncode > current) {
                // Append allowed characters leading up to this point.
                encoded.append(s, current, nextToEncode);
            } else {
                // assert nextToEncode == current
            }

            // Switch to "encoding" mode.

            // Find the next allowed character.
            current = nextToEncode;
            int nextAllowed = current + 1;
            while (nextAllowed < oldLength
                    && !isAllowed(s.charAt(nextAllowed), allow)) {
                nextAllowed++;
            }

            // Convert the substring to bytes and encode the bytes as
            // '%'-escaped octets.
            String toEncode = s.substring(current, nextAllowed);
            try {
                byte[] bytes = toEncode.getBytes(DEFAULT_ENCODING);
                int bytesLength = bytes.length;
                for (int i = 0; i < bytesLength; i++) {
                    encoded.append('%');
                    encoded.append(HEX_DIGITS[(bytes[i] & 0xf0) >> 4]);
                    encoded.append(HEX_DIGITS[bytes[i] & 0xf]);
                }
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }

            current = nextAllowed;
        }

        // Encoded could still be null at this point if s is empty.
        return encoded == null ? s : encoded.toString();
    }

    /**
     * Returns true if the given character is allowed.
     *
     * @param c character to check
     * @param allow characters to allow
     * @return true if the character is allowed or false if it should be
     *  encoded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.402 -0500", hash_original_method = "EC34BDFAF87F6FC405563F3C5834D87D", hash_generated_method = "B64F6845D1765CBAC05659D97CB25992")
    
private static boolean isAllowed(char c, String allow) {
        return (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z')
                || (c >= '0' && c <= '9')
                || "_-!.~'()*".indexOf(c) != NOT_FOUND
                || (allow != null && allow.indexOf(c) != NOT_FOUND);
    }

    /**
     * Decodes '%'-escaped octets in the given string using the UTF-8 scheme.
     * Replaces invalid octets with the unicode replacement character
     * ("\\uFFFD").
     *
     * @param s encoded string to decode
     * @return the given string with escaped octets decoded, or null if
     *  s is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.408 -0500", hash_original_method = "8CA7F37205DBA3826558AF549D47A0C3", hash_generated_method = "CC309B2D382E2C1002242B4B0583B5AD")
    
public static String decode(String s) {
        /*
        Compared to java.net.URLEncoderDecoder.decode(), this method decodes a
        chunk at a time instead of one character at a time, and it doesn't
        throw exceptions. It also only allocates memory when necessary--if
        there's nothing to decode, this method won't do much.
        */

        if (s == null) {
            return null;
        }

        // Lazily-initialized buffers.
        StringBuilder decoded = null;
        ByteArrayOutputStream out = null;

        int oldLength = s.length();

        // This loop alternates between copying over normal characters and
        // escaping in chunks. This results in fewer method calls and
        // allocations than decoding one character at a time.
        int current = 0;
        while (current < oldLength) {
            // Start in "copying" mode where we copy over normal characters.

            // Find the next escape sequence.
            int nextEscape = s.indexOf('%', current);

            if (nextEscape == NOT_FOUND) {
                if (decoded == null) {
                    // We didn't actually decode anything.
                    return s;
                } else {
                    // Append the remainder and return the decoded string.
                    decoded.append(s, current, oldLength);
                    return decoded.toString();
                }
            }

            // Prepare buffers.
            if (decoded == null) {
                // Looks like we're going to need the buffers...
                // We know the new string will be shorter. Using the old length
                // may overshoot a bit, but it will save us from resizing the
                // buffer.
                decoded = new StringBuilder(oldLength);
                out = new ByteArrayOutputStream(4);
            } else {
                // Clear decoding buffer.
                out.reset();
            }

            // Append characters leading up to the escape.
            if (nextEscape > current) {
                decoded.append(s, current, nextEscape);

                current = nextEscape;
            } else {
                // assert current == nextEscape
            }

            // Switch to "decoding" mode where we decode a string of escape
            // sequences.

            // Decode and append escape sequences. Escape sequences look like
            // "%ab" where % is literal and a and b are hex digits.
            try {
                do {
                    if (current + 2 >= oldLength) {
                        // Truncated escape sequence.
                        out.write(REPLACEMENT);
                    } else {
                        int a = Character.digit(s.charAt(current + 1), 16);
                        int b = Character.digit(s.charAt(current + 2), 16);

                        if (a == -1 || b == -1) {
                            // Non hex digits.
                            out.write(REPLACEMENT);
                        } else {
                            // Combine the hex digits into one byte and write.
                            out.write((a << 4) + b);
                        }
                    }

                    // Move passed the escape sequence.
                    current += 3;
                } while (current < oldLength && s.charAt(current) == '%');

                // Decode UTF-8 bytes into a string and append it.
                decoded.append(out.toString(DEFAULT_ENCODING));
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        // If we don't have a buffer, we didn't have to decode anything.
        return decoded == null ? s : decoded.toString();
    }

    /**
     * Creates a new Uri by appending an already-encoded path segment to a
     * base Uri.
     *
     * @param baseUri Uri to append path segment to
     * @param pathSegment encoded path segment to append
     * @return a new Uri based on baseUri with the given segment appended to 
     *  the path
     * @throws NullPointerException if baseUri is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.507 -0500", hash_original_method = "39777FDE2593A579E76592A008126365", hash_generated_method = "F04C9A83020F5098114C752E2F7E0883")
    
public static Uri withAppendedPath(Uri baseUri, String pathSegment) {
        Builder builder = baseUri.buildUpon();
        builder = builder.appendEncodedPath(pathSegment);
        return builder.build();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.888 -0500", hash_original_field = "3844FFA99A999BB4EDDD7DE578438A79", hash_generated_field = "CFC1AACEA60AD0E5F3AD35D47126879D")

    /** Log tag. */
    private static final String LOG = Uri.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.891 -0500", hash_original_field = "9170C7A7E0C34F20BDE926A4BDB090D3", hash_generated_field = "B954F9C12AC0662BCBDFC1BE53358724")

    @SuppressWarnings("RedundantStringConstructorCall")
    private static final String NOT_CACHED = new String("NOT CACHED");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.893 -0500", hash_original_field = "A2A991E114DB1FA39218BF826FE91450", hash_generated_field = "5038C252470848AFDD24667CC5D97705")

    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL,
            PathPart.EMPTY, Part.NULL, Part.NULL);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.959 -0500", hash_original_field = "B29A94A1DBE0E3A2B4A52177D3D1B1F9", hash_generated_field = "70D3B26ADAF374FF9FC1A886C7965F17")

    private final static int NOT_FOUND = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.961 -0500", hash_original_field = "28FC6CE832F2A38A66D7B8904D94951D", hash_generated_field = "309A8D293FB70CF3C8B75760A49AAA8A")

    private final static int NOT_CALCULATED = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.964 -0500", hash_original_field = "B29DB14A98402BDB8D9208BF40749EE4", hash_generated_field = "D90B08A155B6660D5725B7F9B3B765E3")

    private static final String NOT_HIERARCHICAL
            = "This isn't a hierarchical URI.";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.966 -0500", hash_original_field = "5660948E44B63FC73A55AD401702B233", hash_generated_field = "801ABCF993C84AFFC2A4DEC33E3ED2DF")

    private static final String DEFAULT_ENCODING = "UTF-8";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.381 -0500", hash_original_field = "813F46B60784C54718B55D8E71BB57D8", hash_generated_field = "013D84CBB14787012A1B410C2CED92EA")

    private static final int NULL_TYPE_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.190 -0400", hash_original_field = "FA031E527800FCED59C59BB3277BEE96", hash_generated_field = "A8963E713BB231EFDC73C3C4317D711B")

    public static final Parcelable.Creator<Uri> CREATOR
            = new Parcelable.Creator<Uri>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.385 -0500", hash_original_method = "1CCA462AB4D0EF409DF9173916BA5FD8", hash_generated_method = "E7D8D1AE887DF3EC27BA286F1F6632FA")
        
public Uri createFromParcel(Parcel in) {
            int type = in.readInt();
            switch (type) {
                case NULL_TYPE_ID: return null;
                case StringUri.TYPE_ID: return StringUri.readFrom(in);
                case OpaqueUri.TYPE_ID: return OpaqueUri.readFrom(in);
                case HierarchicalUri.TYPE_ID:
                    return HierarchicalUri.readFrom(in);
            }

            throw new IllegalArgumentException("Unknown URI type: " + type);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.387 -0500", hash_original_method = "F0F0985DDECE05E12B4F154480B8ACF8", hash_generated_method = "94289B15B827C73E361AA24EF37F3646")
        
public Uri[] newArray(int size) {
            return new Uri[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.394 -0500", hash_original_field = "4F2326E262E6A6BF466951D799AF1031", hash_generated_field = "C46B2CD1575F3EFF815653AFF0EA6C73")

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.404 -0500", hash_original_field = "6E3065D20156420EF488BFA36FB1FCC6", hash_generated_field = "EA76FA4E6E39D084A2B31303C1E9D60D")

    private static final byte[] REPLACEMENT = { (byte) 0xFF, (byte) 0xFD };
    
    // orphaned legacy field
    @DSVAModeled
    private String uriString;

    /**
     * Prevents external subclassing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.896 -0500", hash_original_method = "81E08B95735493D923725112C83DA27A", hash_generated_method = "0ABE2EDBA81B324492C4B22D918117A5")
    
private Uri() {}
    // orphaned legacy method
    
	public Uri(String uri) {
		this();
		uriString = uri;
	}
    
	public boolean isHierarchical() {
		return getTaintBoolean();
	}
    
	public boolean isOpaque() {
        return getTaintBoolean();
    }
    
	public boolean isRelative() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}
    
	public boolean isAbsolute() {
        return getTaintBoolean();
    }
    
	public String getScheme() {
		// TODO Auto-generated method stub
		return uriString;
	}
    
	public String getSchemeSpecificPart() {
		return uriString;
	}
    
	public String getEncodedSchemeSpecificPart() {
		return uriString;
	}
    
	public String getAuthority() {
		return uriString;
	}
    
	public String getEncodedAuthority() {
		// TODO Auto-generated method stub
		return uriString;
	}
    
	public String getUserInfo() {
		// TODO Auto-generated method stub
		return DSUtils.UNKNOWN_STRING;
	}
    
	public String getEncodedUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}
    
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}
    
	public int getPort() {
		return getTaintInt();
	}
    
	public String getPath() {
		return uriString;
	}
    
	public String getEncodedPath() {
		return uriString;
	}
    
	public String getQuery() {
		// TODO Auto-generated method stub
		return uriString;
	}
    
	public String getEncodedQuery() {
		// TODO Auto-generated method stub
		return uriString;
	}
    
    private static class StringUri extends AbstractHierarchicalUri {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.981 -0500", hash_original_method = "B9752410D58B51B65C9ADC7D117FE072", hash_generated_method = "22442DA2F8749F2BB2B04094E92CF446")
        
static Uri readFrom(Parcel parcel) {
            return new StringUri(parcel.readString());
        }

        /**
         * Parses an authority out of the given URI string.
         *
         * @param uriString URI string
         * @param ssi scheme separator index, -1 for a relative URI
         *
         * @return the authority or null if none is found
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.070 -0500", hash_original_method = "646016FCFDD19CBEFB230A993DB05800", hash_generated_method = "CC94B2B4059F922578309270CCC16EE6")
        
static String parseAuthority(String uriString, int ssi) {
            int length = uriString.length();

            // If "//" follows the scheme separator, we have an authority.
            if (length > ssi + 2
                    && uriString.charAt(ssi + 1) == '/'
                    && uriString.charAt(ssi + 2) == '/') {
                // We have an authority.

                // Look for the start of the path, query, or fragment, or the
                // end of the string.
                int end = ssi + 3;
                LOOP: while (end < length) {
                    switch (uriString.charAt(end)) {
                        case '/': // Start of path
                        case '?': // Start of query
                        case '#': // Start of fragment
                            break LOOP;
                    }
                    end++;
                }

                return uriString.substring(ssi + 3, end);
            } else {
                return null;
            }

        }

        /**
         * Parses a path out of this given URI string.
         *
         * @param uriString URI string
         * @param ssi scheme separator index, -1 for a relative URI
         *
         * @return the path
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.073 -0500", hash_original_method = "1E19AC1A8E05179CA2F3BA2BE9214917", hash_generated_method = "CF2D20DE501C346989772C1673EA962E")
        
static String parsePath(String uriString, int ssi) {
            int length = uriString.length();

            // Find start of path.
            int pathStart;
            if (length > ssi + 2
                    && uriString.charAt(ssi + 1) == '/'
                    && uriString.charAt(ssi + 2) == '/') {
                // Skip over authority to path.
                pathStart = ssi + 3;
                LOOP: while (pathStart < length) {
                    switch (uriString.charAt(pathStart)) {
                        case '?': // Start of query
                        case '#': // Start of fragment
                            return ""; // Empty path.
                        case '/': // Start of path!
                            break LOOP;
                    }
                    pathStart++;
                }
            } else {
                // Path starts immediately after scheme separator.
                pathStart = ssi + 1;
            }

            // Find end of path.
            int pathEnd = pathStart;
            LOOP: while (pathEnd < length) {
                switch (uriString.charAt(pathEnd)) {
                    case '?': // Start of query
                    case '#': // Start of fragment
                        break LOOP;
                }
                pathEnd++;
            }

            return uriString.substring(pathStart, pathEnd);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.974 -0500", hash_original_field = "863F9F50E8A0641979DA2B8756C46C2A", hash_generated_field = "1525B2F69D3B82BDEA81D83890B48CEC")

        static final int TYPE_ID = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.976 -0500", hash_original_field = "EC8F33E45FD6053217E2485C59DC6361", hash_generated_field = "E4175460B78B44891D601990509D1265")

        private  String uriString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.989 -0500", hash_original_field = "888EA2E79830C189E1BC860C0800AB2F", hash_generated_field = "6ECAEC93E2396D17CA9FF61298DA11AE")

        private volatile int cachedSsi = NOT_CALCULATED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.993 -0500", hash_original_field = "3E527EAAFA69413ACB9F50FFCE35801A", hash_generated_field = "6673040FAE4D4C35641720F36B224DA4")

        private volatile int cachedFsi = NOT_CALCULATED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.003 -0500", hash_original_field = "030FC5261A8EB10381C37C096712C0E9", hash_generated_field = "0E9D0B05543D9BBCEB78240FF4AE88F4")

        private volatile String scheme = NOT_CACHED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.010 -0500", hash_original_field = "BBAE3713DECE7C8525260DE5E70C46A6", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.021 -0500", hash_original_field = "9E21E7090446CDE5086844B195D6CB36", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.030 -0500", hash_original_field = "AD52E446D12B30C7A18B4724BD0AE7E6", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.045 -0500", hash_original_field = "3E1F2A3AC6880420E2E1AD742E2B9ADF", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.056 -0500", hash_original_field = "02C0AB2936C6D04A6600CAEE292968AD", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.979 -0500", hash_original_method = "6762E8F4F232397EC67D86B91A630B95", hash_generated_method = "50DD23618C06AA5993422C596D95A15D")
        
private StringUri(String uriString) {
            if (uriString == null) {
                throw new NullPointerException("uriString");
            }

            this.uriString = uriString;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.983 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.986 -0500", hash_original_method = "C73A8428F9DA44091DF96EEDC1E3D3EF", hash_generated_method = "5103B31771CBF6E066AB4C9C31E90AB2")
        
public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(uriString);
        }

        /** Finds the first ':'. Returns -1 if none found. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.991 -0500", hash_original_method = "F197955D6E3BAB1920F769AA2F97BBD7", hash_generated_method = "CB28982BF84320CC265CCD0217E2270B")
        
private int findSchemeSeparator() {
            return cachedSsi == NOT_CALCULATED
                    ? cachedSsi = uriString.indexOf(':')
                    : cachedSsi;
        }

        /** Finds the first '#'. Returns -1 if none found. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.996 -0500", hash_original_method = "B0E1A879F11D02C30EC9FBB06F8801FE", hash_generated_method = "3A287F7E062B40A217480E3CD179D64C")
        
private int findFragmentSeparator() {
            return cachedFsi == NOT_CALCULATED
                    ? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    : cachedFsi;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.998 -0500", hash_original_method = "11C2E375F5E033161AB2E06056D673CF", hash_generated_method = "C254253F66C2CCFF25DDD6F44E5B7B52")
        
public boolean isHierarchical() {
            int ssi = findSchemeSeparator();

            if (ssi == NOT_FOUND) {
                // All relative URIs are hierarchical.
                return true;
            }

            if (uriString.length() == ssi + 1) {
                // No ssp.
                return false;
            }

            // If the ssp starts with a '/', this is hierarchical.
            return uriString.charAt(ssi + 1) == '/';
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.001 -0500", hash_original_method = "DC1D040929AB7A4CF9A0DFBB95EA4283", hash_generated_method = "5DBD26208324B5EC7290009F9FA676F9")
        
public boolean isRelative() {
            // Note: We return true if the index is 0
            return findSchemeSeparator() == NOT_FOUND;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.005 -0500", hash_original_method = "96667B7E38635C26F17AC80DC91F9ADB", hash_generated_method = "ABEBD18496B29AF5F92CABFFDDA0861E")
        
public String getScheme() {
            @SuppressWarnings("StringEquality")
            boolean cached = (scheme != NOT_CACHED);
            return cached ? scheme : (scheme = parseScheme());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.008 -0500", hash_original_method = "B03A2C85823E1DE38C77FC40695B0CC7", hash_generated_method = "8202C68A06A4C9D7E52938E46EA609CA")
        
private String parseScheme() {
            int ssi = findSchemeSeparator();
            return ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.012 -0500", hash_original_method = "DE43C7F499D5F1739936552A95AA2492", hash_generated_method = "FC1D015FDAC2686ED4C1E29ACD784356")
        
private Part getSsp() {
            return ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.014 -0500", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "6C573169C6465A1D34E7B9EFB56733C9")
        
public String getEncodedSchemeSpecificPart() {
            return getSsp().getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.017 -0500", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "37BB1A681E484F8C8E4B8C8EBCB6B0EB")
        
public String getSchemeSpecificPart() {
            return getSsp().getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.019 -0500", hash_original_method = "6082AC88F53E9B67D59D9A72041A5D6F", hash_generated_method = "F5214BF1CAC55E6C4840E5FCA8BB9EC5")
        
private String parseSsp() {
            int ssi = findSchemeSeparator();
            int fsi = findFragmentSeparator();

            // Return everything between ssi and fsi.
            return fsi == NOT_FOUND
                    ? uriString.substring(ssi + 1)
                    : uriString.substring(ssi + 1, fsi);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.024 -0500", hash_original_method = "C2AABBF6273BD8549508A0ABF072F220", hash_generated_method = "34233D8C266ED8E16932066F92E29576")
        
private Part getAuthorityPart() {
            if (authority == null) {
                String encodedAuthority
                        = parseAuthority(this.uriString, findSchemeSeparator());
                return authority = Part.fromEncoded(encodedAuthority);
            }

            return authority;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.026 -0500", hash_original_method = "B783FB869F9CE6B897E37C2A9B9B4259", hash_generated_method = "996349E684006CBE9E2F442569BE8BEB")
        
public String getEncodedAuthority() {
            return getAuthorityPart().getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.028 -0500", hash_original_method = "F4404025FB90C68980598D2895AF9578", hash_generated_method = "B8ED49E3BBA5B95DA1FECE1AB8908166")
        
public String getAuthority() {
            return getAuthorityPart().getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.033 -0500", hash_original_method = "483C19AAE407B7D6148F370745A1893E", hash_generated_method = "6256B62FD67F9E0C6891B0494243BF01")
        
private PathPart getPathPart() {
            return path == null
                    ? path = PathPart.fromEncoded(parsePath())
                    : path;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.035 -0500", hash_original_method = "E8759FDECF433DBBFF0BA03CF3576CC0", hash_generated_method = "2D7DF043E810551E77B13D1BF994FB35")
        
public String getPath() {
            return getPathPart().getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.037 -0500", hash_original_method = "D26AFC1B9D9DFA82513D9A4C50DD2F0F", hash_generated_method = "D76DEE69566845892394F838DEF42423")
        
public String getEncodedPath() {
            return getPathPart().getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.039 -0500", hash_original_method = "A1BA2B8DCFFB301EABC725C63F487DC2", hash_generated_method = "6360CFBA859A8146986F6908DA370ACD")
        
public List<String> getPathSegments() {
            return getPathPart().getPathSegments();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.042 -0500", hash_original_method = "EF0989C68625FC2F46DE0EA4CB35660B", hash_generated_method = "EF83B4A0704C57A9ADFBBDE00B07B249")
        
private String parsePath() {
            String uriString = this.uriString;
            int ssi = findSchemeSeparator();

            // If the URI is absolute.
            if (ssi > -1) {
                // Is there anything after the ':'?
                boolean schemeOnly = ssi + 1 == uriString.length();
                if (schemeOnly) {
                    // Opaque URI.
                    return null;
                }

                // A '/' after the ':' means this is hierarchical.
                if (uriString.charAt(ssi + 1) != '/') {
                    // Opaque URI.
                    return null;
                }
            } else {
                // All relative URIs are hierarchical.
            }

            return parsePath(uriString, ssi);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.047 -0500", hash_original_method = "5338F6D0AC99191764C2394A710C873F", hash_generated_method = "3F8F6AF74D9BF1C34143002341BFAE51")
        
private Part getQueryPart() {
            return query == null
                    ? query = Part.fromEncoded(parseQuery()) : query;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.049 -0500", hash_original_method = "61892B739321CB796D242E9E13C1F033", hash_generated_method = "5E2027BD2C07E5B1E83E0C04CAC1C035")
        
public String getEncodedQuery() {
            return getQueryPart().getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.052 -0500", hash_original_method = "93492ABD4F9B88C963E84B9F545E5D11", hash_generated_method = "C332A30D6008CD1647D1905962137694")
        
private String parseQuery() {
            // It doesn't make sense to cache this index. We only ever
            // calculate it once.
            int qsi = uriString.indexOf('?', findSchemeSeparator());
            if (qsi == NOT_FOUND) {
                return null;
            }

            int fsi = findFragmentSeparator();

            if (fsi == NOT_FOUND) {
                return uriString.substring(qsi + 1);
            }

            if (fsi < qsi) {
                // Invalid.
                return null;
            }

            return uriString.substring(qsi + 1, fsi);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.054 -0500", hash_original_method = "31EC40ABD8B86D0064329950E060BFBD", hash_generated_method = "413F82C57A2A806E7BB30B2EB4A63439")
        
public String getQuery() {
            return getQueryPart().getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.058 -0500", hash_original_method = "EAD370CB1FE781DF1864471D9F5F3E36", hash_generated_method = "6A3C6A895406655EED02C3ABE901619D")
        
private Part getFragmentPart() {
            return fragment == null
                    ? fragment = Part.fromEncoded(parseFragment()) : fragment;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.061 -0500", hash_original_method = "C2884F3C25114B1CD652E8CCEF7D7F10", hash_generated_method = "AA2431BFE82B59690CB6FDD7D4C291B6")
        
public String getEncodedFragment() {
            return getFragmentPart().getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.063 -0500", hash_original_method = "13965C7143AC0E622773DBA6AE062E67", hash_generated_method = "406E2636FE1327D3BED674ABB0488121")
        
private String parseFragment() {
            int fsi = findFragmentSeparator();
            return fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.065 -0500", hash_original_method = "4E8163B4F7FDF9829581A99F6274656D", hash_generated_method = "F1715D18395FB9C9CACA110D8EEF2A68")
        
public String getFragment() {
            return getFragmentPart().getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.067 -0500", hash_original_method = "ECB4588CBE3D957B88D2558A4C044374", hash_generated_method = "19CFFF886D28C68E94CFDF2A58D847A8")
        
public String toString() {
            return uriString;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.075 -0500", hash_original_method = "54B78C0DD1C850213ABB66143A4F5DE7", hash_generated_method = "8FF248167E67BE39247FEB2C6867262F")
        
public Builder buildUpon() {
            if (isHierarchical()) {
                return new Builder()
                        .scheme(getScheme())
                        .authority(getAuthorityPart())
                        .path(getPathPart())
                        .query(getQueryPart())
                        .fragment(getFragmentPart());
            } else {
                return new Builder()
                        .scheme(getScheme())
                        .opaquePart(getSsp())
                        .fragment(getFragmentPart());
            }
        }
    }
    
    private static class OpaqueUri extends Uri {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.097 -0500", hash_original_method = "3DE9F905D00C8A1D201EDE3F979AEDDF", hash_generated_method = "89D685E248F63B9588817D427ED3DFC2")
        
static Uri readFrom(Parcel parcel) {
            return new OpaqueUri(
                parcel.readString(),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.086 -0500", hash_original_field = "4E602521BBF893FF227C9F335380FA4E", hash_generated_field = "81BC425463DB04A2D338A2C363556710")

        static final int TYPE_ID = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.088 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private  String scheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.091 -0500", hash_original_field = "BBAE3713DECE7C8525260DE5E70C46A6", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private  Part ssp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.093 -0500", hash_original_field = "02C0AB2936C6D04A6600CAEE292968AD", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private  Part fragment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.146 -0500", hash_original_field = "F33F15A6FD47288E315F6C17BEBC95C3", hash_generated_field = "FCCD4A0FFBA55911A49FB2AEB7548D00")

        private volatile String cachedString = NOT_CACHED;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.095 -0500", hash_original_method = "A3EB90F61BB5DAD9A21709AA9F976DF8", hash_generated_method = "39188B62C75D2D2708B249374908B250")
        
private OpaqueUri(String scheme, Part ssp, Part fragment) {
            this.scheme = scheme;
            this.ssp = ssp;
            this.fragment = fragment == null ? Part.NULL : fragment;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.100 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.102 -0500", hash_original_method = "8F996E53ADCFC30BFF794C5CEED4DA61", hash_generated_method = "AD03F242E88A5E578C66EA90BAA91E0A")
        
public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(scheme);
            ssp.writeTo(parcel);
            fragment.writeTo(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.104 -0500", hash_original_method = "414EEC63B62C24CE4C288B4F88575946", hash_generated_method = "6C10894394774586A5BD88CBBAA51733")
        
public boolean isHierarchical() {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.107 -0500", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "FB9692414BA5D99084CFA1D888A33E7E")
        
public boolean isRelative() {
            return scheme == null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.109 -0500", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "8C187E31064D5FC7E4CBD4735C1E35F0")
        
public String getScheme() {
            return this.scheme;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.111 -0500", hash_original_method = "3C55B6D4F736410AF7A2ACAB5CCC51ED", hash_generated_method = "D9699FBBF6C96E786BA500FDEE919373")
        
public String getEncodedSchemeSpecificPart() {
            return ssp.getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.113 -0500", hash_original_method = "ED3540C8D06E41CD645C58A620F36381", hash_generated_method = "14D5CE5B8CB9F1199BD9A9D6654520F4")
        
public String getSchemeSpecificPart() {
            return ssp.getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.115 -0500", hash_original_method = "31E41E1CB0338F9BAA50A0AC05D7D02D", hash_generated_method = "9A0C58B5BBE1FCEC366B081238823F0A")
        
public String getAuthority() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.118 -0500", hash_original_method = "C6F3CA63C6BE518EBD2AA32E2786DD3A", hash_generated_method = "A15C1BE630C4FDCBD71DE4D5DDE0D088")
        
public String getEncodedAuthority() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.120 -0500", hash_original_method = "F489014FCD27D67260CBEC8AC84559A2", hash_generated_method = "EE57F7E9DBD1DFFCFE37F1B53C90B593")
        
public String getPath() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.122 -0500", hash_original_method = "F167E35F53D1A5A8B17A8A72FE8359AE", hash_generated_method = "9A03D197F6F1FF001396774924A4EA10")
        
public String getEncodedPath() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.124 -0500", hash_original_method = "2E34959E1DD3631C67E93F1AE6B31056", hash_generated_method = "58C6480CA69FCA257D3E6360B960D9FA")
        
public String getQuery() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.126 -0500", hash_original_method = "53661DD2D38C9C2E00E8B8D2FF316BB7", hash_generated_method = "BE25EB7B18FD2ADE6051EDD77F799F57")
        
public String getEncodedQuery() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.128 -0500", hash_original_method = "9F53DDCB73E71AFF4CF207B49D0689B3", hash_generated_method = "2532A8DADB3FD31CDC6F4B459CA993BE")
        
public String getFragment() {
            return fragment.getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.131 -0500", hash_original_method = "2FF982E252638134744EE32C0D7F6950", hash_generated_method = "22F080C9855388C8843984CE7CECF20E")
        
public String getEncodedFragment() {
            return fragment.getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.134 -0500", hash_original_method = "08B329AF4FAA2768183F76EC45288C10", hash_generated_method = "C308D1FFE23155846734C76076DE029B")
        
public List<String> getPathSegments() {
            return Collections.emptyList();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.136 -0500", hash_original_method = "AE7FF2A9DFCB643CF70873B2C08CD5A8", hash_generated_method = "19B1F7448E2299233816958124B540A5")
        
public String getLastPathSegment() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.138 -0500", hash_original_method = "520FB960E4127ABC7143DD06EFB52356", hash_generated_method = "8DE0BBA69F7A404BBEC99FE1E99B06C9")
        
public String getUserInfo() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.140 -0500", hash_original_method = "88ECB0B5D6F4AA907FC3666F8C1418EB", hash_generated_method = "A95C49D5677FFFDB10F2DA55FC2AF01B")
        
public String getEncodedUserInfo() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.142 -0500", hash_original_method = "00C71B0865F91AE7EF71B7BE21B14B9F", hash_generated_method = "22F262111A38CABA0104217396F895C0")
        
public String getHost() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.144 -0500", hash_original_method = "B159430668427C6760C3FB4B772D9F59", hash_generated_method = "044A39B9EF3590AFFFFA54A57D715C0B")
        
public int getPort() {
            return -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.149 -0500", hash_original_method = "ACF28BE5516AF44175C2E6962FB03404", hash_generated_method = "291234E5DAE31DCB3BDD08EEC1479DC0")
        
public String toString() {
            @SuppressWarnings("StringEquality")
            boolean cached = cachedString != NOT_CACHED;
            if (cached) {
                return cachedString;
            }

            StringBuilder sb = new StringBuilder();

            sb.append(scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());

            if (!fragment.isEmpty()) {
                sb.append('#').append(fragment.getEncoded());
            }

            return cachedString = sb.toString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.152 -0500", hash_original_method = "9B1777E9DAB1C1ED3319A4EEC33BCB54", hash_generated_method = "5C4462209FE1A43E0C9AE726C6C002B4")
        
public Builder buildUpon() {
            return new Builder()
                    .scheme(this.scheme)
                    .opaquePart(this.ssp)
                    .fragment(this.fragment);
        }
    }
    
    static class PathSegments extends AbstractList<String> implements RandomAccess {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.157 -0500", hash_original_field = "59330FF4187274F876811687E6879EEE", hash_generated_field = "E6083199966205833D7B5012129D384D")

        static final PathSegments EMPTY = new PathSegments(null, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.159 -0500", hash_original_field = "D8C8A9DBE80A96D9E735DAA1D195D137", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

         String[] segments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.162 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

         int size;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.164 -0500", hash_original_method = "816AFE27D6484B7E80593A248F7DEC12", hash_generated_method = "816AFE27D6484B7E80593A248F7DEC12")
        
PathSegments(String[] segments, int size) {
            this.segments = segments;
            this.size = size;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.166 -0500", hash_original_method = "043CF25E38E9D3A71BE4CC7B6371568E", hash_generated_method = "5BCFD94D9679CD4A7A9B991B3AFB878D")
        
public String get(int index) {
            if (index >= size) {
                throw new IndexOutOfBoundsException();
            }

            return segments[index];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.168 -0500", hash_original_method = "BAF1AF8B1284BE94C387C840AF9FA265", hash_generated_method = "60E9F6BB3D1DD5277C70AB9E8521925E")
        
public int size() {
            return this.size;
        }
    }
    
    static class PathSegmentsBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.172 -0500", hash_original_field = "D8C8A9DBE80A96D9E735DAA1D195D137", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.175 -0500", hash_original_field = "689FC3CB9A887B5817C15E9CFDD066DB", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

        int size = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.068 -0400", hash_original_method = "CD5B4727D6775EBFE00461F5F237812D", hash_generated_method = "CD5B4727D6775EBFE00461F5F237812D")
        
        public PathSegmentsBuilder ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.177 -0500", hash_original_method = "F05B9B5ECB44DE7CFF27782486F28CF3", hash_generated_method = "F05B9B5ECB44DE7CFF27782486F28CF3")
        
void add(String segment) {
            if (segments == null) {
                segments = new String[4];
            } else if (size + 1 == segments.length) {
                String[] expanded = new String[segments.length * 2];
                System.arraycopy(segments, 0, expanded, 0, segments.length);
                segments = expanded;
            }

            segments[size++] = segment;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.179 -0500", hash_original_method = "497F2229989230601A3120EEAF21B251", hash_generated_method = "F717289A5AEF0381E70DEC0AC7EEA7C5")
        
PathSegments build() {
            if (segments == null) {
                return PathSegments.EMPTY;
            }

            try {
                return new PathSegments(segments, size);
            } finally {
                // Makes sure this doesn't get reused.
                segments = null;
            }
        }
        
    }
    
    private abstract static class AbstractHierarchicalUri extends Uri {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.186 -0500", hash_original_field = "E7ECD9A0FC9E62BEC865842D9572366E", hash_generated_field = "87B54E118334D4593A462325E6A65F84")

        private Part userInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.198 -0500", hash_original_field = "19AC129A72D528D26CDAD281A292D279", hash_generated_field = "539F6E6D25356608852D958A8481FDA5")

        private volatile String host = NOT_CACHED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.206 -0500", hash_original_field = "8CE6EA1656D08DDFBE4E07A115079F77", hash_generated_field = "3DEE2B327E62FC31F0BA9783EFE62CA9")

        private volatile int port = NOT_CALCULATED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.071 -0400", hash_original_method = "469DE423ED30903E9EDD58224AA80D56", hash_generated_method = "469DE423ED30903E9EDD58224AA80D56")
        
        public AbstractHierarchicalUri ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.184 -0500", hash_original_method = "D5E71CFA6EED35AEB9B5F4AEC5287C3B", hash_generated_method = "1F2BC9F5EC821DBA8B733164E9A9E9B7")
        
public String getLastPathSegment() {
            // TODO: If we haven't parsed all of the segments already, just
            // grab the last one directly so we only allocate one string.

            List<String> segments = getPathSegments();
            int size = segments.size();
            if (size == 0) {
                return null;
            }
            return segments.get(size - 1);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.189 -0500", hash_original_method = "739BBE935CAE826F3703E2BBB77B819C", hash_generated_method = "61D00D760E71067A79B0A8C73A16A024")
        
private Part getUserInfoPart() {
            return userInfo == null
                    ? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.191 -0500", hash_original_method = "EADAAD26DC8689BCA10DCA33883B9323", hash_generated_method = "B65DC03815AB8E7C61C492B99EC4A3CC")
        
public final String getEncodedUserInfo() {
            return getUserInfoPart().getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.193 -0500", hash_original_method = "10E379B7D06266EDAAC672E10EB0F58B", hash_generated_method = "C3678EFB1F1D6AB018259E35AC5664E4")
        
private String parseUserInfo() {
            String authority = getEncodedAuthority();
            if (authority == null) {
                return null;
            }

            int end = authority.indexOf('@');
            return end == NOT_FOUND ? null : authority.substring(0, end);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.196 -0500", hash_original_method = "575ECF6860F7EEFE5055BF56F2601A0E", hash_generated_method = "67B026BDA8B421E52FB1B44B539023AC")
        
public String getUserInfo() {
            return getUserInfoPart().getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.201 -0500", hash_original_method = "2FC22A6CCA0A3F4C0B9E4C09F79A556D", hash_generated_method = "77597C8C7E77DE3FB0EC4F344AD34D95")
        
public String getHost() {
            @SuppressWarnings("StringEquality")
            boolean cached = (host != NOT_CACHED);
            return cached ? host
                    : (host = parseHost());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.203 -0500", hash_original_method = "F3410DE0DFF96D0677FF54552E852FC4", hash_generated_method = "6FE439461BEF73ECED59AC74EF908941")
        
private String parseHost() {
            String authority = getEncodedAuthority();
            if (authority == null) {
                return null;
            }

            // Parse out user info and then port.
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);

            String encodedHost = portSeparator == NOT_FOUND
                    ? authority.substring(userInfoSeparator + 1)
                    : authority.substring(userInfoSeparator + 1, portSeparator);

            return decode(encodedHost);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.208 -0500", hash_original_method = "A497EF38F72042FD9397DCB617BC4BBC", hash_generated_method = "FDB52F3958882AD594D47F375808E87F")
        
public int getPort() {
            return port == NOT_CALCULATED
                    ? port = parsePort()
                    : port;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.210 -0500", hash_original_method = "5469820A1C15A09B87242C85BC223022", hash_generated_method = "F5E0DDA9804C0317A68B5EF25357F043")
        
private int parsePort() {
            String authority = getEncodedAuthority();
            if (authority == null) {
                return -1;
            }

            // Make sure we look for the port separtor *after* the user info
            // separator. We have URLs with a ':' in the user info.
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);

            if (portSeparator == NOT_FOUND) {
                return -1;
            }

            String portString = decode(authority.substring(portSeparator + 1));
            try {
                return Integer.parseInt(portString);
            } catch (NumberFormatException e) {
                Log.w(LOG, "Error parsing port string.", e);
                return -1;
            }
        }
        
    }
    
    private static class HierarchicalUri extends AbstractHierarchicalUri {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.232 -0500", hash_original_method = "DC5791E697BE9BB4980E8FB1C7E142D4", hash_generated_method = "A47CF22DA42BCF6708CFEE192B64BF1D")
        
static Uri readFrom(Parcel parcel) {
            return new HierarchicalUri(
                parcel.readString(),
                Part.readFrom(parcel),
                PathPart.readFrom(parcel),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.216 -0500", hash_original_field = "8247145A6A9BF20190BDCAE12512B6AE", hash_generated_field = "F1F90627D661D3D25ABE19AF04422DA0")

        static final int TYPE_ID = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.218 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private  String scheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.220 -0500", hash_original_field = "9E21E7090446CDE5086844B195D6CB36", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private  Part authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.222 -0500", hash_original_field = "AD52E446D12B30C7A18B4724BD0AE7E6", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private  PathPart path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.224 -0500", hash_original_field = "3E1F2A3AC6880420E2E1AD742E2B9ADF", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private  Part query;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.227 -0500", hash_original_field = "02C0AB2936C6D04A6600CAEE292968AD", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private  Part fragment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.246 -0500", hash_original_field = "BBAE3713DECE7C8525260DE5E70C46A6", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.285 -0500", hash_original_field = "F774E53212EDF2C0CFC94017CE1A4E2A", hash_generated_field = "9968E15A97464199002C3D2A70E60BF1")

        private volatile String uriString = NOT_CACHED;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.230 -0500", hash_original_method = "4B8A4922E90F4F5C5F11CB942A244C7D", hash_generated_method = "EC65AD6F8429D72A9CE3D0B1BB58FF1A")
        
private HierarchicalUri(String scheme, Part authority, PathPart path,
                Part query, Part fragment) {
            this.scheme = scheme;
            this.authority = Part.nonNull(authority);
            this.path = path == null ? PathPart.NULL : path;
            this.query = Part.nonNull(query);
            this.fragment = Part.nonNull(fragment);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.234 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.237 -0500", hash_original_method = "601AB6BE7C1B16F2DB83E078DF9B61DC", hash_generated_method = "C4975111E918C24052F4398AF779DB0F")
        
public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(scheme);
            authority.writeTo(parcel);
            path.writeTo(parcel);
            query.writeTo(parcel);
            fragment.writeTo(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.240 -0500", hash_original_method = "3471DB7575AAB7FBFD2140BF4AB89F77", hash_generated_method = "FE9496BFF17DAE3F49884B3628405047")
        
public boolean isHierarchical() {
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.242 -0500", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "FB9692414BA5D99084CFA1D888A33E7E")
        
public boolean isRelative() {
            return scheme == null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.244 -0500", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "9D11AD0B611F352DC84C8E1A6B825617")
        
public String getScheme() {
            return scheme;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.248 -0500", hash_original_method = "6F57A7CA1E43F50667C0921A8F0F4C1E", hash_generated_method = "E98FEC6CF7437DF6F46762E2B45036F7")
        
private Part getSsp() {
            return ssp == null
                    ? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.251 -0500", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "6C573169C6465A1D34E7B9EFB56733C9")
        
public String getEncodedSchemeSpecificPart() {
            return getSsp().getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.253 -0500", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "37BB1A681E484F8C8E4B8C8EBCB6B0EB")
        
public String getSchemeSpecificPart() {
            return getSsp().getDecoded();
        }

        /**
         * Creates the encoded scheme-specific part from its sub parts.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.255 -0500", hash_original_method = "EA75444742B675900BB1383BC22E224C", hash_generated_method = "979E10CFE3C0857FC52F9F856BE08E20")
        
private String makeSchemeSpecificPart() {
            StringBuilder builder = new StringBuilder();
            appendSspTo(builder);
            return builder.toString();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.093 -0400", hash_original_method = "55EA79AD41E607B8DD0B042A78040234", hash_generated_method = "6482B19B506A7357F59DD4CC14EB48C5")
        private void appendSspTo(StringBuilder builder) {
            addTaint(builder.getTaint());
            String encodedAuthority = authority.getEncoded();
            if(encodedAuthority != null)            
            {
                builder.append("//").append(encodedAuthority);
            } //End block
            String encodedPath = path.getEncoded();
            if(encodedPath != null)            
            {
                builder.append(encodedPath);
            } //End block
            if(!query.isEmpty())            
            {
                builder.append('?').append(query.getEncoded());
            } //End block
            // ---------- Original Method ----------
            //String encodedAuthority = authority.getEncoded();
            //if (encodedAuthority != null) {
                //builder.append("//").append(encodedAuthority);
            //}
            //String encodedPath = path.getEncoded();
            //if (encodedPath != null) {
                //builder.append(encodedPath);
            //}
            //if (!query.isEmpty()) {
                //builder.append('?').append(query.getEncoded());
            //}
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.264 -0500", hash_original_method = "4FC7F3346B5C0FC1519928E52B2843FB", hash_generated_method = "6DAFF03A5E15B07027CC73E6C6D6AD17")
        
public String getAuthority() {
            return this.authority.getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.267 -0500", hash_original_method = "02F0907154122B499105718EFAFFB12D", hash_generated_method = "32A82B6575A426C3A9E8F67E9E1373E8")
        
public String getEncodedAuthority() {
            return this.authority.getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.269 -0500", hash_original_method = "C2F72FED192DF0C1254C49B5EAFF6B37", hash_generated_method = "B5E9BADA276CBA0DAA9FC1B55A587E66")
        
public String getEncodedPath() {
            return this.path.getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.271 -0500", hash_original_method = "6081DF09BF7A0319CE8B8794EF03DD3D", hash_generated_method = "09DC704FF3D2BD0779FFD97841A9109F")
        
public String getPath() {
            return this.path.getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.273 -0500", hash_original_method = "BB14E9B85B4B70FE8537ADEAEA0F30F8", hash_generated_method = "8601242321E93A0871DB465B77BE5081")
        
public String getQuery() {
            return this.query.getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.275 -0500", hash_original_method = "4E4841C1D3AAC7E9E3EC5666E1D3BDC7", hash_generated_method = "D563C34DF22A3AADAC2136BC2E298569")
        
public String getEncodedQuery() {
            return this.query.getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.278 -0500", hash_original_method = "BC71EA5136922A2C431D19FA4D7E797E", hash_generated_method = "DCAB9AA3C442CF69C72366A8441484EB")
        
public String getFragment() {
            return this.fragment.getDecoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.280 -0500", hash_original_method = "D0BDA4E24821D7C40932E823B160DCAD", hash_generated_method = "2379CD52C8BD57FF5E451B5C74D2F1E9")
        
public String getEncodedFragment() {
            return this.fragment.getEncoded();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.283 -0500", hash_original_method = "6A1F2A59685BCA2552F3B76D88CB5845", hash_generated_method = "216A1EB87BA78F1931DF87DD6F07CD8B")
        
public List<String> getPathSegments() {
            return this.path.getPathSegments();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.287 -0500", hash_original_method = "2FFEEC7D33EBEEF04178DF9D921CBC02", hash_generated_method = "6819D86B216326E77E51A7C94FB01B30")
        
@Override
        public String toString() {
            @SuppressWarnings("StringEquality")
            boolean cached = (uriString != NOT_CACHED);
            return cached ? uriString
                    : (uriString = makeUriString());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.290 -0500", hash_original_method = "5AECD242275C33F74DCA414A6C8DF5D7", hash_generated_method = "AE0B3FAE7964F8BC076EB03B46820B5C")
        
private String makeUriString() {
            StringBuilder builder = new StringBuilder();

            if (scheme != null) {
                builder.append(scheme).append(':');
            }

            appendSspTo(builder);

            if (!fragment.isEmpty()) {
                builder.append('#').append(fragment.getEncoded());
            }

            return builder.toString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.292 -0500", hash_original_method = "6635CD2DD122D7EE5F14A5F21B272B08", hash_generated_method = "6F54BA35F35A446CC22D46803754C9E1")
        
public Builder buildUpon() {
            return new Builder()
                    .scheme(scheme)
                    .authority(authority)
                    .path(path)
                    .query(query)
                    .fragment(fragment);
        }
    }
    
    public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.298 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.300 -0500", hash_original_field = "B38EBC2627A503BF98004E270055A1D9", hash_generated_field = "F30F644E178A706F0279AC78D6913562")

        private Part opaquePart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.302 -0500", hash_original_field = "9E21E7090446CDE5086844B195D6CB36", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.305 -0500", hash_original_field = "AD52E446D12B30C7A18B4724BD0AE7E6", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.307 -0500", hash_original_field = "3E1F2A3AC6880420E2E1AD742E2B9ADF", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.309 -0500", hash_original_field = "02C0AB2936C6D04A6600CAEE292968AD", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;

        /**
         * Constructs a new Builder.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.311 -0500", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "E3E7F27996F0F2E94367F4C927CC51AE")
        
public Builder() {}

        /**
         * Sets the scheme.
         *
         * @param scheme name or {@code null} if this is a relative Uri
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.313 -0500", hash_original_method = "1FAF048543AEDF54BF8218C15362FDC3", hash_generated_method = "96BDFF6D7293B0C9E7E466CD527BE2B3")
        
public Builder scheme(String scheme) {
            this.scheme = scheme;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.316 -0500", hash_original_method = "8D4C2B402A916DF01BF39AF004B22B4B", hash_generated_method = "8D4C2B402A916DF01BF39AF004B22B4B")
        
Builder opaquePart(Part opaquePart) {
            this.opaquePart = opaquePart;
            return this;
        }

        /**
         * Encodes and sets the given opaque scheme-specific-part.
         *
         * @param opaquePart decoded opaque part
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.318 -0500", hash_original_method = "B04C2A20C29308DA58A03AAA34E4602D", hash_generated_method = "8BFAED0288E76E83F943044F7AE7CC60")
        
public Builder opaquePart(String opaquePart) {
            return opaquePart(Part.fromDecoded(opaquePart));
        }

        /**
         * Sets the previously encoded opaque scheme-specific-part.
         *
         * @param opaquePart encoded opaque part
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.321 -0500", hash_original_method = "E3AC90668DB82124786DAC21400DF68F", hash_generated_method = "11537B98350027FDE12D8E917BA91C05")
        
public Builder encodedOpaquePart(String opaquePart) {
            return opaquePart(Part.fromEncoded(opaquePart));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.323 -0500", hash_original_method = "CE12FA6D2315F74B1A3B79C027FFFA6D", hash_generated_method = "98DCEE1FFE85A89C0BEF38663C36C6FC")
        
Builder authority(Part authority) {
            // This URI will be hierarchical.
            this.opaquePart = null;

            this.authority = authority;
            return this;
        }

        /**
         * Encodes and sets the authority.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.325 -0500", hash_original_method = "8B987B114EF487282F33A481DCB273CB", hash_generated_method = "3F1CD1513DF2B9AA237EA1AEB4374316")
        
public Builder authority(String authority) {
            return authority(Part.fromDecoded(authority));
        }

        /**
         * Sets the previously encoded authority.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.327 -0500", hash_original_method = "2AF9D1463857894BBB2A3B7E377A77BB", hash_generated_method = "FF5E086FF567F3975804752188384374")
        
public Builder encodedAuthority(String authority) {
            return authority(Part.fromEncoded(authority));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.329 -0500", hash_original_method = "0552AFD7FA04CD9C4E588C7FB644B387", hash_generated_method = "5C383CF2B075A11E48E6AB1D3ED8D942")
        
Builder path(PathPart path) {
            // This URI will be hierarchical.
            this.opaquePart = null;

            this.path = path;
            return this;
        }

        /**
         * Sets the path. Leaves '/' characters intact but encodes others as
         * necessary.
         *
         * <p>If the path is not null and doesn't start with a '/', and if
         * you specify a scheme and/or authority, the builder will prepend the
         * given path with a '/'.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.332 -0500", hash_original_method = "311D5047B3596F1C34DEC3DA1D1264C5", hash_generated_method = "92D9024264FD1F75982EB1750CE7841A")
        
public Builder path(String path) {
            return path(PathPart.fromDecoded(path));
        }

        /**
         * Sets the previously encoded path.
         *
         * <p>If the path is not null and doesn't start with a '/', and if
         * you specify a scheme and/or authority, the builder will prepend the
         * given path with a '/'.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.334 -0500", hash_original_method = "B2733F0C4852B782EB87F01613E6C574", hash_generated_method = "A058284D73BCE21547C46FC15EAF01A1")
        
public Builder encodedPath(String path) {
            return path(PathPart.fromEncoded(path));
        }

        /**
         * Encodes the given segment and appends it to the path.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.337 -0500", hash_original_method = "818DCEC2192004BCFE40E4E49FDA7A4C", hash_generated_method = "B34AC168D54B8003CF0F37D3B13C2499")
        
public Builder appendPath(String newSegment) {
            return path(PathPart.appendDecodedSegment(path, newSegment));
        }

        /**
         * Appends the given segment to the path.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.339 -0500", hash_original_method = "04B6E07373B5BCB6E5F5541B11BC55A7", hash_generated_method = "155909857C199EE42D2F0076DA9C9BAD")
        
public Builder appendEncodedPath(String newSegment) {
            return path(PathPart.appendEncodedSegment(path, newSegment));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.341 -0500", hash_original_method = "526B00AFFC674BC410AFF0DB5058AD68", hash_generated_method = "3188366FD00FB87C5285CCF82A6B56B8")
        
Builder query(Part query) {
            // This URI will be hierarchical.
            this.opaquePart = null;

            this.query = query;
            return this;
        }

        /**
         * Encodes and sets the query.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.343 -0500", hash_original_method = "915051404F16544BAB27A534573CC34D", hash_generated_method = "D61CA135A10609047E44413EF6F2655C")
        
public Builder query(String query) {
            return query(Part.fromDecoded(query));
        }

        /**
         * Sets the previously encoded query.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.345 -0500", hash_original_method = "2B1CFFF6E8520529FC529F01B5DBCD04", hash_generated_method = "CC52CDC7E989A90EBE4E0F2FB0BE3497")
        
public Builder encodedQuery(String query) {
            return query(Part.fromEncoded(query));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.347 -0500", hash_original_method = "AAD8E80453C4B46D11B41869FDCBA00D", hash_generated_method = "AAD8E80453C4B46D11B41869FDCBA00D")
        
Builder fragment(Part fragment) {
            this.fragment = fragment;
            return this;
        }

        /**
         * Encodes and sets the fragment.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.350 -0500", hash_original_method = "016C309F39EF5D90CF32B95F6FDB27F8", hash_generated_method = "44CE4AECBBD06EEDB74A930FDEAA0DD6")
        
public Builder fragment(String fragment) {
            return fragment(Part.fromDecoded(fragment));
        }

        /**
         * Sets the previously encoded fragment.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.352 -0500", hash_original_method = "C5F51A11F0BEF63CCF4FD5F6AF742648", hash_generated_method = "006961D3D9D2747525D6B2CF5C8749FE")
        
public Builder encodedFragment(String fragment) {
            return fragment(Part.fromEncoded(fragment));
        }

        /**
         * Encodes the key and value and then appends the parameter to the
         * query string.
         *
         * @param key which will be encoded
         * @param value which will be encoded
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.354 -0500", hash_original_method = "F83D70A0FC90543F01AB6385367098CC", hash_generated_method = "A4980B53E56EA71AABF495818D735160")
        
public Builder appendQueryParameter(String key, String value) {
            // This URI will be hierarchical.
            this.opaquePart = null;

            String encodedParameter = encode(key, null) + "="
                    + encode(value, null);

            if (query == null) {
                query = Part.fromEncoded(encodedParameter);
                return this;
            }

            String oldQuery = query.getEncoded();
            if (oldQuery == null || oldQuery.length() == 0) {
                query = Part.fromEncoded(encodedParameter);
            } else {
                query = Part.fromEncoded(oldQuery + "&" + encodedParameter);
            }

            return this;
        }

        /**
         * Clears the the previously set query.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.356 -0500", hash_original_method = "581A1CF068B5634C1F252DE7C2737E06", hash_generated_method = "F7612AA45FF623D4138D5C87140B2C58")
        
public Builder clearQuery() {
          return query((Part) null);
        }

        /**
         * Constructs a Uri with the current attributes.
         *
         * @throws UnsupportedOperationException if the URI is opaque and the
         *  scheme is null
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.359 -0500", hash_original_method = "C36CE5067F02DA1F1C7276BF67665A1B", hash_generated_method = "49E0BB8D44C8E87C84F7CDE7E9DE5DF1")
        
public Uri build() {
            if (opaquePart != null) {
                if (this.scheme == null) {
                    throw new UnsupportedOperationException(
                            "An opaque URI must have a scheme.");
                }

                return new OpaqueUri(scheme, opaquePart, fragment);
            } else {
                // Hierarchical URIs should not return null for getPath().
                PathPart path = this.path;
                if (path == null || path == PathPart.NULL) {
                    path = PathPart.EMPTY;
                } else {
                    // If we have a scheme and/or authority, the path must
                    // be absolute. Prepend it with a '/' if necessary.
                    if (hasSchemeOrAuthority()) {
                        path = PathPart.makeAbsolute(path);
                    }
                }

                return new HierarchicalUri(
                        scheme, authority, path, query, fragment);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.362 -0500", hash_original_method = "7917AD3B49169A1AC8EEA7DD014B7E45", hash_generated_method = "8FB1F5046A7F2AE85274DDFF94E1698C")
        
private boolean hasSchemeOrAuthority() {
            return scheme != null
                    || (authority != null && authority != Part.NULL);

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.365 -0500", hash_original_method = "50FC77E3DFFDDD2DB7D0B749912434F7", hash_generated_method = "0BB595C7C262392EA7FCAD5D5C7168D3")
        
@Override
        public String toString() {
            return build().toString();
        }
        
    }
    
    static abstract class AbstractPart {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.421 -0500", hash_original_field = "4F672F59E73887C4AB6D2CB85FA87583", hash_generated_field = "08274B7EEBA921030ECC3D76D1E6ECCB")

        volatile String encoded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.423 -0500", hash_original_field = "6D4540C10A5D9188A1CCDEA2E902B48E", hash_generated_field = "B682B941676F7CF6A565D2078C9BC0A9")

        volatile String decoded;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.425 -0500", hash_original_method = "21E01F693530948BFE81E2C9AE8C6D31", hash_generated_method = "21E01F693530948BFE81E2C9AE8C6D31")
        
AbstractPart(String encoded, String decoded) {
            this.encoded = encoded;
            this.decoded = decoded;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.427 -0500", hash_original_method = "91FC101CC1B0ACCF71C15B71127FF8D2", hash_generated_method = "C0D3A0FB73870ED76549BD4C608443AC")
        
abstract String getEncoded();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.430 -0500", hash_original_method = "06323BBC323E7F59CEDDE1FAA04ED1F6", hash_generated_method = "03DCF9641223B8656F16E1E81D8C0759")
        
final String getDecoded() {
            @SuppressWarnings("StringEquality")
            boolean hasDecoded = decoded != NOT_CACHED;
            return hasDecoded ? decoded : (decoded = decode(encoded));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.433 -0500", hash_original_method = "BB7E54AFB81798C035BF3B3717F470E7", hash_generated_method = "9E6CCE194A734C36504361B0E7203AB8")
        
final void writeTo(Parcel parcel) {
            @SuppressWarnings("StringEquality")
            boolean hasEncoded = encoded != NOT_CACHED;

            @SuppressWarnings("StringEquality")
            boolean hasDecoded = decoded != NOT_CACHED;

            if (hasEncoded && hasDecoded) {
                parcel.writeInt(Representation.BOTH);
                parcel.writeString(encoded);
                parcel.writeString(decoded);
            } else if (hasEncoded) {
                parcel.writeInt(Representation.ENCODED);
                parcel.writeString(encoded);
            } else if (hasDecoded) {
                parcel.writeInt(Representation.DECODED);
                parcel.writeString(decoded);
            } else {
                throw new IllegalArgumentException("Neither encoded nor decoded");
            }
        }
        
        static class Representation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.412 -0500", hash_original_field = "D91CFF54E7669AFC23076F5A26D733F3", hash_generated_field = "FF4F4E4C6DA0CB1E3DB9C13C6C3A4A5B")

            static final int BOTH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.414 -0500", hash_original_field = "96C6A880F3C7E020EA910384DDCCA813", hash_generated_field = "A15D22B3282778C07B2BEC94A0EE0FD2")

            static final int ENCODED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.417 -0500", hash_original_field = "C3D57F46A18829E47E9564BC7710B852", hash_generated_field = "8C3D0A85A317D2355A45465A71C73F69")

            static final int DECODED = 2;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.161 -0400", hash_original_method = "49186660D0AEF0721F749C758CF0FE34", hash_generated_method = "49186660D0AEF0721F749C758CF0FE34")
            public Representation ()
            {
                //Synthesized constructor
            }
        }
        
    }
    
    static class Part extends AbstractPart {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.448 -0500", hash_original_method = "0A7C24B10C6F335EA8E9C233B8EAC1DF", hash_generated_method = "DF63C4D93FBCBE444881D3B902C102E3")
        
static Part readFrom(Parcel parcel) {
            int representation = parcel.readInt();
            switch (representation) {
                case Representation.BOTH:
                    return from(parcel.readString(), parcel.readString());
                case Representation.ENCODED:
                    return fromEncoded(parcel.readString());
                case Representation.DECODED:
                    return fromDecoded(parcel.readString());
                default:
                    throw new IllegalArgumentException("Unknown representation: "
                            + representation);
            }
        }

        /**
         * Returns given part or {@link #NULL} if the given part is null.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.451 -0500", hash_original_method = "7E582160561011C399B089EEEB2ACE48", hash_generated_method = "37B846E096993F34E5C408E5154E02FF")
        
static Part nonNull(Part part) {
            return part == null ? NULL : part;
        }

        /**
         * Creates a part from the encoded string.
         *
         * @param encoded part string
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.453 -0500", hash_original_method = "E9523DE9E1BA3B83E89657DB7636CA0B", hash_generated_method = "FBC19D5A6490A7AB4B200F79382F810E")
        
static Part fromEncoded(String encoded) {
            return from(encoded, NOT_CACHED);
        }

        /**
         * Creates a part from the decoded string.
         *
         * @param decoded part string
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.456 -0500", hash_original_method = "7EDC6E3E03A5038D4D1890F7EC9BBFB5", hash_generated_method = "8553348EE8801BE84BFA1119703A925E")
        
static Part fromDecoded(String decoded) {
            return from(NOT_CACHED, decoded);
        }

        /**
         * Creates a part from the encoded and decoded strings.
         *
         * @param encoded part string
         * @param decoded part string
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.458 -0500", hash_original_method = "2939154DCAF0A4BC8BC678B8D40526D2", hash_generated_method = "D4BCB01FB5B112FA7A2B32AEC3D3830A")
        
static Part from(String encoded, String decoded) {
            // We have to check both encoded and decoded in case one is
            // NOT_CACHED.

            if (encoded == null) {
                return NULL;
            }
            if (encoded.length() == 0) {
                return EMPTY;
            }

            if (decoded == null) {
                return NULL;
            }
            if (decoded .length() == 0) {
                return EMPTY;
            }

            return new Part(encoded, decoded);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.438 -0500", hash_original_field = "6D922A5F7BB5B2FD3E443B809DD981F6", hash_generated_field = "B57558D017E2A8337F27C36F5D930EAB")

        static final Part NULL = new EmptyPart(null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.440 -0500", hash_original_field = "D12985FD432A12F921FEC62CA6BA2AFB", hash_generated_field = "D56E54A9BB15BF578A32B43A761A7D58")

        static final Part EMPTY = new EmptyPart("");

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.442 -0500", hash_original_method = "68B275EBA6010E5404727E121615E229", hash_generated_method = "0F50A72C8C7037EC2CBE092C0C937235")
        
private Part(String encoded, String decoded) {
            super(encoded, decoded);
        }
        
        private static class EmptyPart extends Part {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.461 -0500", hash_original_method = "D79C0256E86C850253FAE782AD9920ED", hash_generated_method = "FDFA040038EB5D1B5BB965FE7838E7F1")
            
public EmptyPart(String value) {
                super(value, value);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.465 -0500", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "562A29446A4C3261B9B7CE657D34B7A2")
            
@Override
            boolean isEmpty() {
                return true;
            }
            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.444 -0500", hash_original_method = "BD94DCCF5B44419F4498543CA74892E2", hash_generated_method = "BD94DCCF5B44419F4498543CA74892E2")
        
boolean isEmpty() {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.446 -0500", hash_original_method = "74B8C999E422A266FD890BA259F6B43C", hash_generated_method = "74B8C999E422A266FD890BA259F6B43C")
        
String getEncoded() {
            @SuppressWarnings("StringEquality")
            boolean hasEncoded = encoded != NOT_CACHED;
            return hasEncoded ? encoded : (encoded = encode(decoded));
        }
    }
    
    static class PathPart extends AbstractPart {
        
        static PathPart appendEncodedSegment(PathPart oldPart,
                String newSegment) {
            if (oldPart == null) {
                return fromEncoded("/" + newSegment);
            }
            String oldPath = oldPart.getEncoded();
            if (oldPath == null) {
                oldPath = "";
            }
            int oldPathLength = oldPath.length();
            String newPath;
            if (oldPathLength == 0) {
                newPath = "/" + newSegment;
            } else if (oldPath.charAt(oldPathLength - 1) == '/') {
                newPath = oldPath + newSegment;
            } else {
                newPath = oldPath + "/" + newSegment;
            }
            PathPart retVal = fromEncoded(newPath);
            retVal.addTaint(oldPart.getTaint());
            retVal.addTaint(newSegment.getTaint());
            return retVal;
        }
        
        static PathPart appendDecodedSegment(PathPart oldPart, String decoded) {
            String encoded = encode(decoded);
            PathPart retVal = appendEncodedSegment(oldPart, encoded);
            retVal.addTaint(oldPart.getTaint());
            retVal.addTaint(decoded.getTaint());
            return retVal;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.491 -0500", hash_original_method = "9EE848C90BFEA86776EFC70469F7458B", hash_generated_method = "0ED8123F34795B87A9CEBD39BF7EAF76")
        
static PathPart readFrom(Parcel parcel) {
            int representation = parcel.readInt();
            switch (representation) {
                case Representation.BOTH:
                    return from(parcel.readString(), parcel.readString());
                case Representation.ENCODED:
                    return fromEncoded(parcel.readString());
                case Representation.DECODED:
                    return fromDecoded(parcel.readString());
                default:
                    throw new IllegalArgumentException("Bad representation: " + representation);
            }
        }
        
        static PathPart fromEncoded(String encoded) {
        	PathPart retVal = from(encoded, NOT_CACHED);
        	retVal.addTaint(encoded.getTaint());
            return retVal;
        }

        /**
         * Creates a path from the decoded string.
         *
         * @param decoded part string
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.496 -0500", hash_original_method = "0BBE694B2E74FFFDB557998D4D35D258", hash_generated_method = "FE9735AD27E54DCDFC518070C7168A59")
        
static PathPart fromDecoded(String decoded) {
            return from(NOT_CACHED, decoded);
        }

        /**
         * Creates a path from the encoded and decoded strings.
         *
         * @param encoded part string
         * @param decoded part string
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.498 -0500", hash_original_method = "886122DB8DE034540F8087F0A2C37A21", hash_generated_method = "635B93CF110A8EA0D226F0DB513A4696")
        
static PathPart from(String encoded, String decoded) {
            if (encoded == null) {
                return NULL;
            }

            if (encoded.length() == 0) {
                return EMPTY;
            }

            return new PathPart(encoded, decoded);
        }
        
        static PathPart makeAbsolute(PathPart oldPart) {
            @SuppressWarnings("StringEquality")
            boolean encodedCached = oldPart.encoded != NOT_CACHED;
            String oldPath = encodedCached ? oldPart.encoded : oldPart.decoded;
            if (oldPath == null || oldPath.length() == 0
                    || oldPath.startsWith("/")) {
                return oldPart;
            }
            String newEncoded = encodedCached
                    ? "/" + oldPart.encoded : NOT_CACHED;
            @SuppressWarnings("StringEquality")
            boolean decodedCached = oldPart.decoded != NOT_CACHED;
            String newDecoded = decodedCached
                    ? "/" + oldPart.decoded
                    : NOT_CACHED;
            PathPart retVal = new PathPart(newEncoded, newDecoded);
            retVal.addTaint(oldPart.getTaint());
            return retVal;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.471 -0500", hash_original_field = "4369DE13433D4C2DF3C24BF6FA597090", hash_generated_field = "CE631D3EC26A75E141BE1EBBE7AA5D88")

        static final PathPart NULL = new PathPart(null, null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.473 -0500", hash_original_field = "8A726054110FD123BC2978AA883E1F60", hash_generated_field = "092DD7A22CF30B1C24AB41550FA2A397")

        static final PathPart EMPTY = new PathPart("", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.482 -0500", hash_original_field = "B28E23F558FD6201658428D5968B9F71", hash_generated_field = "BB8884736C4C2C995D440C597E10BBE6")

        private PathSegments pathSegments;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.477 -0500", hash_original_method = "E8CA21F7072E8C7642F3BFF9454329AE", hash_generated_method = "0D9AADBA85FF804C2B025C3087B31625")
        
private PathPart(String encoded, String decoded) {
            super(encoded, decoded);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.479 -0500", hash_original_method = "EEE1C5D1C73794B2424FF9B6A794D8BE", hash_generated_method = "78801BE81952A415B8F898DB77CC0059")
        
String getEncoded() {
            @SuppressWarnings("StringEquality")
            boolean hasEncoded = encoded != NOT_CACHED;

            // Don't encode '/'.
            return hasEncoded ? encoded : (encoded = encode(decoded, "/"));
        }

        /**
         * Gets the individual path segments. Parses them if necessary.
         *
         * @return parsed path segments or null if this isn't a hierarchical
         *  URI
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.484 -0500", hash_original_method = "BB12DAE5001652F9E9419E41FB496BCF", hash_generated_method = "D4ECE24F38C3065DD12BD0422137E29C")
        
PathSegments getPathSegments() {
            if (pathSegments != null) {
                return pathSegments;
            }

            String path = getEncoded();
            if (path == null) {
                return pathSegments = PathSegments.EMPTY;
            }

            PathSegmentsBuilder segmentBuilder = new PathSegmentsBuilder();

            int previous = 0;
            int current;
            while ((current = path.indexOf('/', previous)) > -1) {
                // This check keeps us from adding a segment if the path starts
                // '/' and an empty segment for "//".
                if (previous < current) {
                    String decodedSegment
                            = decode(path.substring(previous, current));
                    segmentBuilder.add(decodedSegment);
                }
                previous = current + 1;
            }

            // Add in the final path segment.
            if (previous < path.length()) {
                segmentBuilder.add(decode(path.substring(previous)));
            }

            return pathSegments = segmentBuilder.build();
        }
    }
    
	public String getFragment() {
		return uriString;
	}
    
	public String getEncodedFragment() {
		return uriString;
	}
    
	public List<String> getPathSegments() {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		list.add(uriString);
		return list;
	}
    
	public String getLastPathSegment() {
		return uriString;
	}
    
	public boolean equals(Object o) {
		return true;
	}

    /**
     * Hashes the encoded string represention of this Uri consistently with
     * {@link #equals(Object)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.947 -0500", hash_original_method = "5AAF793CD4316640D385D37282629FDE", hash_generated_method = "57152E3FA0403B67671D902594F3B622")
    
public int hashCode() {
        return toString().hashCode();
    }
    
	public String toString() {
                String str = new String();
                str.addTaint(this.getTaint());
		return str;
	}

    /**
     * Return a string representation of the URI that is safe to print
     * to logs and other places where PII should be avoided.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.955 -0500", hash_original_method = "C2346F0C89241A0BA21735401E86BD49", hash_generated_method = "9D8BBEDD22B431DE0493EAE5382CDD79")
    
public String toSafeString() {
        String scheme = getScheme();
        String ssp = getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip")
                    || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto")
                    || scheme.equalsIgnoreCase("mailto")) {
                StringBuilder builder = new StringBuilder(64);
                builder.append(scheme);
                builder.append(':');
                if (ssp != null) {
                    for (int i=0; i<ssp.length(); i++) {
                        char c = ssp.charAt(i);
                        if (c == '-' || c == '@' || c == '.') {
                            builder.append(c);
                        } else {
                            builder.append('x');
                        }
                    }
                }
                return builder.toString();
            }
        }
        // Not a sensitive scheme, but let's still be conservative about
        // the data we include -- only the ssp, not the query params or
        // fragment, because those can often have sensitive info.
        StringBuilder builder = new StringBuilder(64);
        if (scheme != null) {
            builder.append(scheme);
            builder.append(':');
        }
        if (ssp != null) {
            builder.append(ssp);
        }
        return builder.toString();
    }
    
	public Builder buildUpon() {
		return new Builder();
	}

    /**
     * Returns a set of the unique names of all query parameters. Iterating
     * over the set will return the names in order of their first occurrence.
     *
     * @throws UnsupportedOperationException if this isn't a hierarchical URI
     *
     * @return a set of decoded names
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.370 -0500", hash_original_method = "966FC11B97976C170B352F408FA2783F", hash_generated_method = "2EB34DCB1EFDE22317CBB5E752A66BEE")
    
public Set<String> getQueryParameterNames() {
        if (isOpaque()) {
            throw new UnsupportedOperationException(NOT_HIERARCHICAL);
        }

        String query = getEncodedQuery();
        if (query == null) {
            return Collections.emptySet();
        }

        Set<String> names = new LinkedHashSet<String>();
        int start = 0;
        do {
            int next = query.indexOf('&', start);
            int end = (next == -1) ? query.length() : next;

            int separator = query.indexOf('=', start);
            if (separator > end || separator == -1) {
                separator = end;
            }

            String name = query.substring(start, separator);
            names.add(decode(name));

            // Move start to end of name.
            start = end + 1;
        } while (start < query.length());

        return Collections.unmodifiableSet(names);
    }

    /**
     * Searches the query string for parameter values with the given key.
     *
     * @param key which will be encoded
     *
     * @throws UnsupportedOperationException if this isn't a hierarchical URI
     * @throws NullPointerException if key is null
     * @return a list of decoded values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.373 -0500", hash_original_method = "9E05603A6F44EBCC73536B2584976016", hash_generated_method = "3145FC174D8CD639CAD7A13104A0C7E4")
    
public List<String> getQueryParameters(String key) {
        if (isOpaque()) {
            throw new UnsupportedOperationException(NOT_HIERARCHICAL);
        }
        if (key == null) {
          throw new NullPointerException("key");
        }

        String query = getEncodedQuery();
        if (query == null) {
            return Collections.emptyList();
        }

        String encodedKey;
        try {
            encodedKey = URLEncoder.encode(key, DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }

        ArrayList<String> values = new ArrayList<String>();

        int start = 0;
        do {
            int nextAmpersand = query.indexOf('&', start);
            int end = nextAmpersand != -1 ? nextAmpersand : query.length();

            int separator = query.indexOf('=', start);
            if (separator > end || separator == -1) {
                separator = end;
            }

            if (separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length())) {
                if (separator == end) {
                  values.add("");
                } else {
                  values.add(decode(query.substring(separator + 1, end)));
                }
            }

            // Move start to end of name.
            if (nextAmpersand != -1) {
                start = nextAmpersand + 1;
            } else {
                break;
            }
        } while (true);

        return Collections.unmodifiableList(values);
    }

    /**
     * Searches the query string for the first value with the given key.
     *
     * @param key which will be encoded
     * @throws UnsupportedOperationException if this isn't a hierarchical URI
     * @throws NullPointerException if key is null
     * @return the decoded value or null if no parameter is found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.377 -0500", hash_original_method = "72F6B0777F298E12957F6498D8B3E8F1", hash_generated_method = "DE3A435133C1A354744AD6E94234BDA2")
    
public String getQueryParameter(String key) {
        if (isOpaque()) {
            throw new UnsupportedOperationException(NOT_HIERARCHICAL);
        }
        if (key == null) {
            throw new NullPointerException("key");
        }

        final String query = getEncodedQuery();
        if (query == null) {
            return null;
        }

        final String encodedKey = encode(key, null);
        final int length = query.length();
        int start = 0;
        do {
            int nextAmpersand = query.indexOf('&', start);
            int end = nextAmpersand != -1 ? nextAmpersand : length;

            int separator = query.indexOf('=', start);
            if (separator > end || separator == -1) {
                separator = end;
            }

            if (separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length())) {
                if (separator == end) {
                  return "";
                } else {
                  return decode(query.substring(separator + 1, end));
                }
            }

            // Move start to end of name.
            if (nextAmpersand != -1) {
                start = nextAmpersand + 1;
            } else {
                break;
            }
        } while (true);
        return null;
    }

    /**
     * Searches the query string for the first value with the given key and interprets it
     * as a boolean value. "false" and "0" are interpreted as <code>false</code>, everything
     * else is interpreted as <code>true</code>.
     *
     * @param key which will be decoded
     * @param defaultValue the default value to return if there is no query parameter for key
     * @return the boolean interpretation of the query parameter key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:08.379 -0500", hash_original_method = "67BE774C17CDAC836698DE4D6D994F1B", hash_generated_method = "6115CE9F0AD02D5FFC89B91CC7DC7087")
    
public boolean getBooleanQueryParameter(String key, boolean defaultValue) {
        String flag = getQueryParameter(key);
        if (flag == null) {
            return defaultValue;
        }
        flag = flag.toLowerCase();
        return (!"false".equals(flag) && !"0".equals(flag));
    }
    
    // orphaned legacy method
    
	public int describeContents() {
		return getTaintInt();
	}
    
    // orphaned legacy method
    
	public void writeToParcel(Parcel dest, int flags) {
		dest.addTaint(getTaint());
	}
    
    // orphaned legacy method
    
	public int compareTo(Uri arg0) {
		// TODO Auto-generated method stub
		return getTaintInt();
	}
    
}

