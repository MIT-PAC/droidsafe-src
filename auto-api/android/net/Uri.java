package android.net;

// Droidsafe Imports
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public abstract class Uri implements Parcelable, Comparable<Uri> {
    private static final String LOG = Uri.class.getSimpleName();
    @SuppressWarnings("RedundantStringConstructorCall")
    private static final String NOT_CACHED = new String("NOT CACHED");
    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL,
            PathPart.EMPTY, Part.NULL, Part.NULL);
    private final static int NOT_FOUND = -1;
    private final static int NOT_CALCULATED = -2;
    private static final String NOT_HIERARCHICAL
            = "This isn't a hierarchical URI.";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final int NULL_TYPE_ID = 0;
    public static final Parcelable.Creator<Uri> CREATOR = new Parcelable.Creator<Uri>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.446 -0400", hash_original_method = "1CCA462AB4D0EF409DF9173916BA5FD8", hash_generated_method = "6738DB567CF358A9E37FC2DD7A77C3EC")
        @DSModeled(DSC.SPEC)
        public Uri createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int type;
            type = in.readInt();
            //Begin case StringUri.TYPE_ID 
            Uri var44595097F10EFD8AA530382151DF381B_1252186912 = (StringUri.readFrom(in));
            //End case StringUri.TYPE_ID 
            //Begin case OpaqueUri.TYPE_ID 
            Uri var622E4C21BF455B57E3B2C67BA2F80941_1707735020 = (OpaqueUri.readFrom(in));
            //End case OpaqueUri.TYPE_ID 
            //Begin case HierarchicalUri.TYPE_ID 
            Uri varD89508D27841F514DC289F56EB993C58_851300036 = (HierarchicalUri.readFrom(in));
            //End case HierarchicalUri.TYPE_ID 
            if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException("Unknown URI type: " + type);
            return (Uri)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int type = in.readInt();
            //switch (type) {
                //case NULL_TYPE_ID: return null;
                //case StringUri.TYPE_ID: return StringUri.readFrom(in);
                //case OpaqueUri.TYPE_ID: return OpaqueUri.readFrom(in);
                //case HierarchicalUri.TYPE_ID:
                    //return HierarchicalUri.readFrom(in);
            //}
            //throw new IllegalArgumentException("Unknown URI type: " + type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.446 -0400", hash_original_method = "F0F0985DDECE05E12B4F154480B8ACF8", hash_generated_method = "8CBCD6C1CC1D536608C9FFD8E14F29C4")
        @DSModeled(DSC.SAFE)
        public Uri[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Uri[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Uri[size];
        }

        
}; //Transformed anonymous class
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final byte[] REPLACEMENT = { (byte) 0xFF, (byte) 0xFD };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.446 -0400", hash_original_method = "81E08B95735493D923725112C83DA27A", hash_generated_method = "C47C377CF96FB563C1C530E0C9451BA0")
    @DSModeled(DSC.SAFE)
    private Uri() {
        // ---------- Original Method ----------
    }

    
    public abstract boolean isHierarchical();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.446 -0400", hash_original_method = "A0C9F8427F648091A08345C72525BACA", hash_generated_method = "7EE20001AFD61CD01C6642C70D778507")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOpaque() {
        boolean var64B4064469A97508D22605F14516AC44_1322183863 = (!isHierarchical());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !isHierarchical();
    }

    
    public abstract boolean isRelative();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.446 -0400", hash_original_method = "E92F08B9247EAC707F6805C228339DFA", hash_generated_method = "7A47E751E92975D0CCB2831E4AC90A35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAbsolute() {
        boolean varFAE8C8CB7DF16B40F7BD3C8C56459E57_1712367978 = (!isRelative());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !isRelative();
    }

    
    public abstract String getScheme();

    
    public abstract String getSchemeSpecificPart();

    
    public abstract String getEncodedSchemeSpecificPart();

    
    public abstract String getAuthority();

    
    public abstract String getEncodedAuthority();

    
    public abstract String getUserInfo();

    
    public abstract String getEncodedUserInfo();

    
    public abstract String getHost();

    
    public abstract int getPort();

    
    public abstract String getPath();

    
    public abstract String getEncodedPath();

    
    public abstract String getQuery();

    
    public abstract String getEncodedQuery();

    
    public abstract String getFragment();

    
    public abstract String getEncodedFragment();

    
    public abstract List<String> getPathSegments();

    
    public abstract String getLastPathSegment();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.447 -0400", hash_original_method = "FA9A408EEB8F8DAB44A912D276C5C2CC", hash_generated_method = "087E07D4487B17B79B2E3B6104E8DAC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        Uri other;
        other = (Uri) o;
        boolean varA0CF98E3EDF30C400FE114E3C4614876_1809302518 = (toString().equals(other.toString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(o instanceof Uri)) {
            //return false;
        //}
        //Uri other = (Uri) o;
        //return toString().equals(other.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.447 -0400", hash_original_method = "5AAF793CD4316640D385D37282629FDE", hash_generated_method = "84BB9F8DAEED1D4F99978B2D1F0E5AFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int varFE9735C4A625FF797CCF16B0C7E4889C_1034073143 = (toString().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return toString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.447 -0400", hash_original_method = "45EC734684FFFB3EE70A4C12F2A2F839", hash_generated_method = "77D79D9DFB674DC970AAA1334C27DEA4")
    @DSModeled(DSC.SPEC)
    public int compareTo(Uri other) {
        dsTaint.addTaint(other.dsTaint);
        int var9FDCE1533C4137A95AA1B9336AC2C904_537394410 = (toString().compareTo(other.toString()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return toString().compareTo(other.toString());
    }

    
    public abstract String toString();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.448 -0400", hash_original_method = "C2346F0C89241A0BA21735401E86BD49", hash_generated_method = "E5BDE9CFD47712AC13D95E153EBA50C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toSafeString() {
        String scheme;
        scheme = getScheme();
        String ssp;
        ssp = getSchemeSpecificPart();
        {
            {
                boolean varECEC7553D0A8A9AA1C3551F50990F265_130533142 = (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip")
                    || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto")
                    || scheme.equalsIgnoreCase("mailto"));
                {
                    StringBuilder builder;
                    builder = new StringBuilder(64);
                    builder.append(scheme);
                    builder.append(':');
                    {
                        {
                            int i;
                            i = 0;
                            boolean var3701C9303431F43DBFBC3723803F56F1_1797966944 = (i<ssp.length());
                            {
                                char c;
                                c = ssp.charAt(i);
                                {
                                    builder.append(c);
                                } //End block
                                {
                                    builder.append('x');
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    String var1F59284C411F9419B065CDD234D02411_1457847806 = (builder.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        StringBuilder builder;
        builder = new StringBuilder(64);
        {
            builder.append(scheme);
            builder.append(':');
        } //End block
        {
            builder.append(ssp);
        } //End block
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1270271771 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract Builder buildUpon();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.448 -0400", hash_original_method = "603F6878CB913DDE5D6C58DE8ECA5D98", hash_generated_method = "1FC9BBEF0AAC4F16527FA3217B13A5E9")
    public static Uri parse(String uriString) {
        return new StringUri(uriString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.448 -0400", hash_original_method = "C8E1BC520600654AF7D7DBB518285820", hash_generated_method = "06EDC206A38F612490541C35EAB729B0")
    public static Uri fromFile(File file) {
        if (file == null) {
            throw new NullPointerException("file");
        }
        PathPart path = PathPart.fromDecoded(file.getAbsolutePath());
        return new HierarchicalUri(
                "file", Part.EMPTY, path, Part.NULL, Part.NULL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.448 -0400", hash_original_method = "0AD237FFD29D45E9689601598F4FC92E", hash_generated_method = "9D21685D66E36BC775C6163A2712CC60")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.448 -0400", hash_original_method = "966FC11B97976C170B352F408FA2783F", hash_generated_method = "12C6E7BCC02E8A9A253D48FB125B880E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> getQueryParameterNames() {
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_207441060 = (isOpaque());
            {
            	if (DroidSafeAndroidRuntime.control)throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } //End block
        } //End collapsed parenthetic
        String query;
        query = getEncodedQuery();
        {
            Set<String> varAC8545868B29B0426131270094E9B735_1271344666 = (Collections.emptySet());
        } //End block
        Set<String> names;
        names = new LinkedHashSet<String>();
        int start;
        start = 0;
        {
            int next;
            next = query.indexOf('&', start);
            int end;
            end = query.length();
            end = next;
            int separator;
            separator = query.indexOf('=', start);
            {
                separator = end;
            } //End block
            String name;
            name = query.substring(start, separator);
            names.add(decode(name));
            start = end + 1;
        } //End block
        {
            boolean var9694734975A6FBE04042BED474B6D869_1820181153 = (start < query.length());
        } //End collapsed parenthetic
        Set<String> varF0B7DA9F1BDCEA664A0164B39E9458D6_434779495 = (Collections.unmodifiableSet(names));
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.449 -0400", hash_original_method = "9E05603A6F44EBCC73536B2584976016", hash_generated_method = "D0D05CA284EE4FD50DAC1172E49D5782")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getQueryParameters(String key) {
        dsTaint.addTaint(key);
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_674457525 = (isOpaque());
            {
            	if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } //End block
        } //End collapsed parenthetic
        {
        	if (DroidSafeAndroidRuntime.control)throw new NullPointerException("key");
        } //End block
        String query;
        query = getEncodedQuery();
        {
            List<String> var1F7E6404BCDE565051377D8968B6B9AF_871149426 = (Collections.emptyList());
        } //End block
        String encodedKey;
        try 
        {
            encodedKey = URLEncoder.encode(key, DEFAULT_ENCODING);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            throw new AssertionError(e);
        } //End block
        ArrayList<String> values;
        values = new ArrayList<String>();
        int start;
        start = 0;
        {
            int nextAmpersand;
            nextAmpersand = query.indexOf('&', start);
            int end;
            end = nextAmpersand;
            end = query.length();
            int separator;
            separator = query.indexOf('=', start);
            {
                separator = end;
            } //End block
            {
                boolean var178076B3E468B8639CBF96A33155F9A9_87830148 = (separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length()));
                {
                    {
                        values.add("");
                    } //End block
                    {
                        values.add(decode(query.substring(separator + 1, end)));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                start = nextAmpersand + 1;
            } //End block
        } //End block
        List<String> varBB580AD4751E078150A200F823153F7A_1596334860 = (Collections.unmodifiableList(values));
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.449 -0400", hash_original_method = "72F6B0777F298E12957F6498D8B3E8F1", hash_generated_method = "BB8E172FC272E60E18FFBDBEE2342550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQueryParameter(String key) {
        dsTaint.addTaint(key);
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_595306297 = (isOpaque());
            {
            	if (DroidSafeAndroidRuntime.control)throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } //End block
        } //End collapsed parenthetic
        {
        	if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key");
        } //End block
        final String query;
        query = getEncodedQuery();
        final String encodedKey;
        encodedKey = encode(key, null);
        final int length;
        length = query.length();
        int start;
        start = 0;
        {
            int nextAmpersand;
            nextAmpersand = query.indexOf('&', start);
            int end;
            end = nextAmpersand;
            end = length;
            int separator;
            separator = query.indexOf('=', start);
            {
                separator = end;
            } //End block
            {
                boolean var178076B3E468B8639CBF96A33155F9A9_1817387295 = (separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length()));
                {
                    {
                        String var7E3DEF0FFA94D3A50F682B9FA129A299_1910983867 = (decode(query.substring(separator + 1, end)));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                start = nextAmpersand + 1;
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.450 -0400", hash_original_method = "67BE774C17CDAC836698DE4D6D994F1B", hash_generated_method = "AA9B74A601FBC7E0964D264C0FC3538E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBooleanQueryParameter(String key, boolean defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        String flag;
        flag = getQueryParameter(key);
        flag = flag.toLowerCase();
        boolean var1524D06912FA9A8910A3FA6431D6523F_1286205362 = ((!"false".equals(flag) && !"0".equals(flag)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String flag = getQueryParameter(key);
        //if (flag == null) {
            //return defaultValue;
        //}
        //flag = flag.toLowerCase();
        //return (!"false".equals(flag) && !"0".equals(flag));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.450 -0400", hash_original_method = "4AD2B9D8D63865C3ECF569D0E6B1A555", hash_generated_method = "9A87E198A1AE69D2D29504ABFA3E441B")
    public static void writeToParcel(Parcel out, Uri uri) {
        if (uri == null) {
            out.writeInt(NULL_TYPE_ID);
        } else {
            uri.writeToParcel(out, 0);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.450 -0400", hash_original_method = "49BB482E96A859715BC5C61306FD74C0", hash_generated_method = "C724103AB538903E19E5DE37C9B2FBE9")
    public static String encode(String s) {
        return encode(s, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.450 -0400", hash_original_method = "1C5D49909CC2D6B9385B7495620A5621", hash_generated_method = "C5D4863E8392BC23BD3CC0E33B80030C")
    public static String encode(String s, String allow) {
        if (s == null) {
            return null;
        }
        StringBuilder encoded = null;
        int oldLength = s.length();
        int current = 0;
        while (current < oldLength) {
            int nextToEncode = current;
            while (nextToEncode < oldLength
                    && isAllowed(s.charAt(nextToEncode), allow)) {
                nextToEncode++;
            }
            if (nextToEncode == oldLength) {
                if (current == 0) {
                    return s;
                } else {
                    encoded.append(s, current, oldLength);
                    return encoded.toString();
                }
            }
            if (encoded == null) {
                encoded = new StringBuilder();
            }
            if (nextToEncode > current) {
                encoded.append(s, current, nextToEncode);
            } else {
            }
            current = nextToEncode;
            int nextAllowed = current + 1;
            while (nextAllowed < oldLength
                    && !isAllowed(s.charAt(nextAllowed), allow)) {
                nextAllowed++;
            }
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
        return encoded == null ? s : encoded.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.450 -0400", hash_original_method = "EC34BDFAF87F6FC405563F3C5834D87D", hash_generated_method = "B64F6845D1765CBAC05659D97CB25992")
    private static boolean isAllowed(char c, String allow) {
        return (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z')
                || (c >= '0' && c <= '9')
                || "_-!.~'()*".indexOf(c) != NOT_FOUND
                || (allow != null && allow.indexOf(c) != NOT_FOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.450 -0400", hash_original_method = "8CA7F37205DBA3826558AF549D47A0C3", hash_generated_method = "C5BA415E60B71C57F57CAD34B2EECD43")
    public static String decode(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder decoded = null;
        ByteArrayOutputStream out = null;
        int oldLength = s.length();
        int current = 0;
        while (current < oldLength) {
            int nextEscape = s.indexOf('%', current);
            if (nextEscape == NOT_FOUND) {
                if (decoded == null) {
                    return s;
                } else {
                    decoded.append(s, current, oldLength);
                    return decoded.toString();
                }
            }
            if (decoded == null) {
                decoded = new StringBuilder(oldLength);
                out = new ByteArrayOutputStream(4);
            } else {
                out.reset();
            }
            if (nextEscape > current) {
                decoded.append(s, current, nextEscape);
                current = nextEscape;
            } else {
            }
            try {
                do {
                    if (current + 2 >= oldLength) {
                        out.write(REPLACEMENT);
                    } else {
                        int a = Character.digit(s.charAt(current + 1), 16);
                        int b = Character.digit(s.charAt(current + 2), 16);
                        if (a == -1 || b == -1) {
                            out.write(REPLACEMENT);
                        } else {
                            out.write((a << 4) + b);
                        }
                    }
                    current += 3;
                } while (current < oldLength && s.charAt(current) == '%');
                decoded.append(out.toString(DEFAULT_ENCODING));
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        return decoded == null ? s : decoded.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.451 -0400", hash_original_method = "39777FDE2593A579E76592A008126365", hash_generated_method = "F04C9A83020F5098114C752E2F7E0883")
    public static Uri withAppendedPath(Uri baseUri, String pathSegment) {
        Builder builder = baseUri.buildUpon();
        builder = builder.appendEncodedPath(pathSegment);
        return builder.build();
    }

    
    private static class StringUri extends AbstractHierarchicalUri {
        static final int TYPE_ID = 1;
        private final String uriString;
        private volatile int cachedSsi = NOT_CALCULATED;
        private volatile int cachedFsi = NOT_CALCULATED;
        private volatile String scheme = NOT_CACHED;
        private Part ssp;
        private Part authority;
        private PathPart path;
        private Part query;
        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.451 -0400", hash_original_method = "6762E8F4F232397EC67D86B91A630B95", hash_generated_method = "0A2B1C916F696BB8074568633DFC7819")
        @DSModeled(DSC.SAFE)
        private StringUri(String uriString) {
            dsTaint.addTaint(uriString);
            {
                throw new NullPointerException("uriString");
            } //End block
            // ---------- Original Method ----------
            //if (uriString == null) {
                //throw new NullPointerException("uriString");
            //}
            //this.uriString = uriString;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.451 -0400", hash_original_method = "B9752410D58B51B65C9ADC7D117FE072", hash_generated_method = "22442DA2F8749F2BB2B04094E92CF446")
        static Uri readFrom(Parcel parcel) {
            return new StringUri(parcel.readString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.451 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.451 -0400", hash_original_method = "C73A8428F9DA44091DF96EEDC1E3D3EF", hash_generated_method = "514CC86FE4CCF8A696B45D10CFCA174B")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel parcel, int flags) {
            dsTaint.addTaint(parcel.dsTaint);
            dsTaint.addTaint(flags);
            parcel.writeInt(TYPE_ID);
            parcel.writeString(uriString);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.451 -0400", hash_original_method = "F197955D6E3BAB1920F769AA2F97BBD7", hash_generated_method = "CB59B3219A2BF3F42E4D26D09FCAF447")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int findSchemeSeparator() {
            {
                Object varE78ED6E23D41D918630374A89968E910_888294200 = (cachedSsi = uriString.indexOf(':'));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return cachedSsi == NOT_CALCULATED
                    //? cachedSsi = uriString.indexOf(':')
                    //: cachedSsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.451 -0400", hash_original_method = "B0E1A879F11D02C30EC9FBB06F8801FE", hash_generated_method = "3EC101AADB910F99036EF13A04E72171")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int findFragmentSeparator() {
            {
                Object var084C492FFBD239136C6656DB9FC43D6A_1634189869 = (cachedFsi = uriString.indexOf('#', findSchemeSeparator()));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return cachedFsi == NOT_CALCULATED
                    //? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    //: cachedFsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.452 -0400", hash_original_method = "11C2E375F5E033161AB2E06056D673CF", hash_generated_method = "D01EF38BE4FDB1219F858129EE84BA52")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isHierarchical() {
            int ssi;
            ssi = findSchemeSeparator();
            {
                boolean var57F8854C12EA0628EE85E2310495F80A_900971080 = (uriString.length() == ssi + 1);
            } //End collapsed parenthetic
            boolean var27890038C7ED583D3363BEF736C880EE_938594386 = (uriString.charAt(ssi + 1) == '/');
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //if (ssi == NOT_FOUND) {
                //return true;
            //}
            //if (uriString.length() == ssi + 1) {
                //return false;
            //}
            //return uriString.charAt(ssi + 1) == '/';
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.452 -0400", hash_original_method = "DC1D040929AB7A4CF9A0DFBB95EA4283", hash_generated_method = "7A28129ED8EC7F034BFE959F7029A0C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isRelative() {
            boolean var3202A358296F4617942997BACCC7AFC0_1793822777 = (findSchemeSeparator() == NOT_FOUND);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return findSchemeSeparator() == NOT_FOUND;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.452 -0400", hash_original_method = "96667B7E38635C26F17AC80DC91F9ADB", hash_generated_method = "AFEC7DDAA1E4F83403FC130B52C586C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getScheme() {
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (scheme != NOT_CACHED);
            {
                Object var7D216945360A9EB9106C3C6C10DBEE9A_1962188363 = ((scheme = parseScheme()));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (scheme != NOT_CACHED);
            //return cached ? scheme : (scheme = parseScheme());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.452 -0400", hash_original_method = "B03A2C85823E1DE38C77FC40695B0CC7", hash_generated_method = "E0AE5ED856D1117221C492C41FF51B18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseScheme() {
            int ssi;
            ssi = findSchemeSeparator();
            {
                Object varCA104DA348F215F5529B91729A84824D_1739514179 = (uriString.substring(0, ssi));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //return ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.452 -0400", hash_original_method = "DE43C7F499D5F1739936552A95AA2492", hash_generated_method = "E6C45F3DDB3C470FB1B2FFDFAB98E10C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getSsp() {
            {
                Object var78B9EFF0635EFBC686B09B483006DE78_128440672 = (ssp = Part.fromEncoded(parseSsp()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.452 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "4DD37E8D3CF9A689753DB5246A006550")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedSchemeSpecificPart() {
            String var7D7FAEEE599108648A5A2C7256B47284_1730740072 = (getSsp().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.452 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "C0781030A6592566EE8899C85D20EEF0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getSchemeSpecificPart() {
            String var6DA99212315C50EDEEA13CBB45FC742F_714366658 = (getSsp().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.453 -0400", hash_original_method = "6082AC88F53E9B67D59D9A72041A5D6F", hash_generated_method = "EACCCF1CDCB73787A9ED45804E06579F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseSsp() {
            int ssi;
            ssi = findSchemeSeparator();
            int fsi;
            fsi = findFragmentSeparator();
            {
                Object var1D900DBA169E529915BAABE0CE7F691B_935867536 = (uriString.substring(ssi + 1));
                Object var686C19CE234EEB8202829754EBB3A81D_622950807 = (uriString.substring(ssi + 1, fsi));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND
                    //? uriString.substring(ssi + 1)
                    //: uriString.substring(ssi + 1, fsi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.453 -0400", hash_original_method = "C2AABBF6273BD8549508A0ABF072F220", hash_generated_method = "DB40A045B4CD493A7372BC224E29A72C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getAuthorityPart() {
            {
                String encodedAuthority;
                encodedAuthority = parseAuthority(this.uriString, findSchemeSeparator());
                Part var87395B0C31486C92603EF5CFE566FC66_842444582 = (authority = Part.fromEncoded(encodedAuthority));
            } //End block
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (authority == null) {
                //String encodedAuthority
                        //= parseAuthority(this.uriString, findSchemeSeparator());
                //return authority = Part.fromEncoded(encodedAuthority);
            //}
            //return authority;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.453 -0400", hash_original_method = "B783FB869F9CE6B897E37C2A9B9B4259", hash_generated_method = "A5243D9B597D4DC1CE6079BA11FD166F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedAuthority() {
            String varAE5D04574D52DB652DEEBC8EA0235C9F_1637570939 = (getAuthorityPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getAuthorityPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.453 -0400", hash_original_method = "F4404025FB90C68980598D2895AF9578", hash_generated_method = "B86413B30D7D8599B38F2DF2552C951B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAuthority() {
            String var26C54218C3529D041B1823F65DF9B723_1905383031 = (getAuthorityPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getAuthorityPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.453 -0400", hash_original_method = "483C19AAE407B7D6148F370745A1893E", hash_generated_method = "39C38E73E2EC97E2CDAE3641813CFA72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private PathPart getPathPart() {
            {
                Object var6C16C9C45A30E2131CDB00C08C229CEA_1928838800 = (path = PathPart.fromEncoded(parsePath()));
            } //End flattened ternary
            return (PathPart)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path == null
                    //? path = PathPart.fromEncoded(parsePath())
                    //: path;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.453 -0400", hash_original_method = "E8759FDECF433DBBFF0BA03CF3576CC0", hash_generated_method = "C4F76C6C920FF9C92FEC44089EC571D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getPath() {
            String var349F3F47631A3E1A940835C3C72CB3FB_426620059 = (getPathPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getPathPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.453 -0400", hash_original_method = "D26AFC1B9D9DFA82513D9A4C50DD2F0F", hash_generated_method = "F86C9A92AD274CDDC7DC6BE1182F32BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedPath() {
            String varDFA6C8D800AD9633D6136C1A17BF6588_274857566 = (getPathPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getPathPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.454 -0400", hash_original_method = "A1BA2B8DCFFB301EABC725C63F487DC2", hash_generated_method = "0486D2CF07DDC4F2660DE2DE9E4F0456")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getPathSegments() {
            List<String> var24A8571EC31E4D340BB96C28284006F7_433092569 = (getPathPart().getPathSegments());
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getPathPart().getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.454 -0400", hash_original_method = "EF0989C68625FC2F46DE0EA4CB35660B", hash_generated_method = "92972DEE0D726C391029984CBE934817")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parsePath() {
            String uriString;
            uriString = this.uriString;
            int ssi;
            ssi = findSchemeSeparator();
            {
                boolean schemeOnly;
                schemeOnly = ssi + 1 == uriString.length();
                {
                    boolean varD917EE6A3AF74F85327A628F817BD281_1625704964 = (uriString.charAt(ssi + 1) != '/');
                } //End collapsed parenthetic
            } //End block
            String var9B8AAACD164711163A6613636FE9739A_1367646212 = (parsePath(uriString, ssi));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String uriString = this.uriString;
            //int ssi = findSchemeSeparator();
            //if (ssi > -1) {
                //boolean schemeOnly = ssi + 1 == uriString.length();
                //if (schemeOnly) {
                    //return null;
                //}
                //if (uriString.charAt(ssi + 1) != '/') {
                    //return null;
                //}
            //} else {
            //}
            //return parsePath(uriString, ssi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.454 -0400", hash_original_method = "5338F6D0AC99191764C2394A710C873F", hash_generated_method = "7606114F9DECD28546C629E471DB5C91")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getQueryPart() {
            {
                Object var801FBFC2970160220E521316DD1EB050_1361977823 = (query = Part.fromEncoded(parseQuery()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return query == null
                    //? query = Part.fromEncoded(parseQuery()) : query;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.454 -0400", hash_original_method = "61892B739321CB796D242E9E13C1F033", hash_generated_method = "F8E1B71C86A09DB9AA004D29D35B9DCE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedQuery() {
            String varD0A6156362E4ACEED3829124CC8D36D4_871511316 = (getQueryPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getQueryPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.454 -0400", hash_original_method = "93492ABD4F9B88C963E84B9F545E5D11", hash_generated_method = "4B914B18E310856599A40B65CFD9EF1D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseQuery() {
            int qsi;
            qsi = uriString.indexOf('?', findSchemeSeparator());
            int fsi;
            fsi = findFragmentSeparator();
            {
                String varD5188933CF729337DEAF15D26C06DC9F_510591757 = (uriString.substring(qsi + 1));
            } //End block
            String var531346F1553737677BB25172E787CD90_429295344 = (uriString.substring(qsi + 1, fsi));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int qsi = uriString.indexOf('?', findSchemeSeparator());
            //if (qsi == NOT_FOUND) {
                //return null;
            //}
            //int fsi = findFragmentSeparator();
            //if (fsi == NOT_FOUND) {
                //return uriString.substring(qsi + 1);
            //}
            //if (fsi < qsi) {
                //return null;
            //}
            //return uriString.substring(qsi + 1, fsi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.454 -0400", hash_original_method = "31EC40ABD8B86D0064329950E060BFBD", hash_generated_method = "C9632D287EDB660FDBCE281D9518CB18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getQuery() {
            String var65FE725AD9C28CA5FADDACECC82F6AFC_397919506 = (getQueryPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getQueryPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.455 -0400", hash_original_method = "EAD370CB1FE781DF1864471D9F5F3E36", hash_generated_method = "3022B9A5D6B03AD846B1563276A09791")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getFragmentPart() {
            {
                Object varBC1183FC5A49D55E17559946F28DE142_1840978178 = (fragment = Part.fromEncoded(parseFragment()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fragment == null
                    //? fragment = Part.fromEncoded(parseFragment()) : fragment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.455 -0400", hash_original_method = "C2884F3C25114B1CD652E8CCEF7D7F10", hash_generated_method = "73EB528BD8A959D2C70C73A2F54674BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedFragment() {
            String var9F52E53C1164E929343C99056BB74BF5_292992523 = (getFragmentPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getFragmentPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.455 -0400", hash_original_method = "13965C7143AC0E622773DBA6AE062E67", hash_generated_method = "1C5FF84601C7C61C833D2BBA70E57113")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseFragment() {
            int fsi;
            fsi = findFragmentSeparator();
            {
                Object var04EF01075150630161DFDC67991EA889_95469585 = (uriString.substring(fsi + 1));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.455 -0400", hash_original_method = "4E8163B4F7FDF9829581A99F6274656D", hash_generated_method = "548F6FF98B8FBAC24A824BF6303B0FF8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getFragment() {
            String var70D235A5DEE0D344761C7126F2616A72_723676638 = (getFragmentPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getFragmentPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.455 -0400", hash_original_method = "ECB4588CBE3D957B88D2558A4C044374", hash_generated_method = "9D3005F344814D84E01B3F2F8025DE66")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return uriString;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.455 -0400", hash_original_method = "646016FCFDD19CBEFB230A993DB05800", hash_generated_method = "6678B08A89BC38AA8B86FC6A6D0EC25E")
        static String parseAuthority(String uriString, int ssi) {
            int length = uriString.length();
            if (length > ssi + 2
                    && uriString.charAt(ssi + 1) == '/'
                    && uriString.charAt(ssi + 2) == '/') {
                int end = ssi + 3;
                LOOP: while (end < length) {
                    switch (uriString.charAt(end)) {
                        case '/': 
                        case '?': 
                        case '#': 
                            break LOOP;
                    }
                    end++;
                }
                return uriString.substring(ssi + 3, end);
            } else {
                return null;
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.455 -0400", hash_original_method = "1E19AC1A8E05179CA2F3BA2BE9214917", hash_generated_method = "5EB6F702951D4B56FF6A446A4C9FC885")
        static String parsePath(String uriString, int ssi) {
            int length = uriString.length();
            int pathStart;
            if (length > ssi + 2
                    && uriString.charAt(ssi + 1) == '/'
                    && uriString.charAt(ssi + 2) == '/') {
                pathStart = ssi + 3;
                LOOP: while (pathStart < length) {
                    switch (uriString.charAt(pathStart)) {
                        case '?': 
                        case '#': 
                            return ""; 
                        case '/': 
                            break LOOP;
                    }
                    pathStart++;
                }
            } else {
                pathStart = ssi + 1;
            }
            int pathEnd = pathStart;
            LOOP: while (pathEnd < length) {
                switch (uriString.charAt(pathEnd)) {
                    case '?': 
                    case '#': 
                        break LOOP;
                }
                pathEnd++;
            }
            return uriString.substring(pathStart, pathEnd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.456 -0400", hash_original_method = "54B78C0DD1C850213ABB66143A4F5DE7", hash_generated_method = "77EDEDF977D03029BC97185494744FE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder buildUpon() {
            {
                boolean varDDDEF883E55C0067D538DC62E8B8900F_977584476 = (isHierarchical());
                {
                    Builder varA9FA48921BCD4E83C921A5BF971A2D2F_1074042254 = (new Builder()
                        .scheme(getScheme())
                        .authority(getAuthorityPart())
                        .path(getPathPart())
                        .query(getQueryPart())
                        .fragment(getFragmentPart()));
                } //End block
                {
                    Builder varAD173BB872313D8C15A6FD748C8D6532_1074476557 = (new Builder()
                        .scheme(getScheme())
                        .opaquePart(getSsp())
                        .fragment(getFragmentPart()));
                } //End block
            } //End collapsed parenthetic
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (isHierarchical()) {
                //return new Builder()
                        //.scheme(getScheme())
                        //.authority(getAuthorityPart())
                        //.path(getPathPart())
                        //.query(getQueryPart())
                        //.fragment(getFragmentPart());
            //} else {
                //return new Builder()
                        //.scheme(getScheme())
                        //.opaquePart(getSsp())
                        //.fragment(getFragmentPart());
            //}
        }

        
    }


    
    private static class OpaqueUri extends Uri {
        static final int TYPE_ID = 2;
        private final String scheme;
        private final Part ssp;
        private final Part fragment;
        private volatile String cachedString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.456 -0400", hash_original_method = "A3EB90F61BB5DAD9A21709AA9F976DF8", hash_generated_method = "F7FCDA9070F6657B8E5F1E73C5A7E2BF")
        @DSModeled(DSC.SAFE)
        private OpaqueUri(String scheme, Part ssp, Part fragment) {
            dsTaint.addTaint(scheme);
            dsTaint.addTaint(ssp.dsTaint);
            dsTaint.addTaint(fragment.dsTaint);
            this.fragment = fragment == null ? Part.NULL : fragment;
            this.scheme = scheme;
            this.ssp = ssp;
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //this.ssp = ssp;
            //this.fragment = fragment == null ? Part.NULL : fragment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.456 -0400", hash_original_method = "3DE9F905D00C8A1D201EDE3F979AEDDF", hash_generated_method = "89D685E248F63B9588817D427ED3DFC2")
        static Uri readFrom(Parcel parcel) {
            return new OpaqueUri(
                parcel.readString(),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.456 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.456 -0400", hash_original_method = "8F996E53ADCFC30BFF794C5CEED4DA61", hash_generated_method = "8D289FB44156B461F62D437D1B5A7549")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel parcel, int flags) {
            dsTaint.addTaint(parcel.dsTaint);
            dsTaint.addTaint(flags);
            parcel.writeInt(TYPE_ID);
            parcel.writeString(scheme);
            ssp.writeTo(parcel);
            fragment.writeTo(parcel);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(scheme);
            //ssp.writeTo(parcel);
            //fragment.writeTo(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "414EEC63B62C24CE4C288B4F88575946", hash_generated_method = "02436DCA5A094362CD5374C723406F17")
        @DSModeled(DSC.SAFE)
        public boolean isHierarchical() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "E7A636053E5A6B033EE9C785BB682629")
        @DSModeled(DSC.SAFE)
        public boolean isRelative() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "720CF3191F6B563166AAA6DB4E356E75")
        @DSModeled(DSC.SAFE)
        public String getScheme() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "3C55B6D4F736410AF7A2ACAB5CCC51ED", hash_generated_method = "505B75BB8BE237B7385E18C74217FC56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedSchemeSpecificPart() {
            String var3B6DB3B18730A649E01AB6CC8288DC37_631638061 = (ssp.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return ssp.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "ED3540C8D06E41CD645C58A620F36381", hash_generated_method = "54C3DF7AF52BB04E82257381EAF504BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getSchemeSpecificPart() {
            String varB2851401428327DC587D0E57AFC8B6D2_219068483 = (ssp.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return ssp.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "31E41E1CB0338F9BAA50A0AC05D7D02D", hash_generated_method = "F6578B7D77C8AF1D2D808D954974E24E")
        @DSModeled(DSC.SAFE)
        public String getAuthority() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "C6F3CA63C6BE518EBD2AA32E2786DD3A", hash_generated_method = "149F1093BBA57B5C020898905D609CB7")
        @DSModeled(DSC.SAFE)
        public String getEncodedAuthority() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "F489014FCD27D67260CBEC8AC84559A2", hash_generated_method = "F1D00948EEDE01EF25B69378EECDB7F8")
        @DSModeled(DSC.SAFE)
        public String getPath() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "F167E35F53D1A5A8B17A8A72FE8359AE", hash_generated_method = "C6839AA9BCD1B530AFA522EC8E7BA522")
        @DSModeled(DSC.SAFE)
        public String getEncodedPath() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.457 -0400", hash_original_method = "2E34959E1DD3631C67E93F1AE6B31056", hash_generated_method = "DA7D178CA10D940AC898295E923BCBD5")
        @DSModeled(DSC.SAFE)
        public String getQuery() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "53661DD2D38C9C2E00E8B8D2FF316BB7", hash_generated_method = "0521D1E9B9DF4252344582F609EE4733")
        @DSModeled(DSC.SAFE)
        public String getEncodedQuery() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "9F53DDCB73E71AFF4CF207B49D0689B3", hash_generated_method = "D17D5294D48D3AA039F5F9DB32CE9B40")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getFragment() {
            String varE18A7E61FDA99F5B7F21777A6737F482_437228582 = (fragment.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "2FF982E252638134744EE32C0D7F6950", hash_generated_method = "AD36E9433D2B8A93629649C793B99179")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedFragment() {
            String var0C1C71A0BDCB9223CF4E2E5E5D4E780B_387845258 = (fragment.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "08B329AF4FAA2768183F76EC45288C10", hash_generated_method = "0278C28B1186BFEAF02AD686032C6A95")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getPathSegments() {
            List<String> var1F7E6404BCDE565051377D8968B6B9AF_1893668857 = (Collections.emptyList());
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "AE7FF2A9DFCB643CF70873B2C08CD5A8", hash_generated_method = "ADCA9BD82F726611017EA99A8B72C068")
        @DSModeled(DSC.SAFE)
        public String getLastPathSegment() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "520FB960E4127ABC7143DD06EFB52356", hash_generated_method = "C2CAFC37B17AE5508344047F21D2AA64")
        @DSModeled(DSC.SAFE)
        public String getUserInfo() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "88ECB0B5D6F4AA907FC3666F8C1418EB", hash_generated_method = "AFBBD745FA8C9E8301AAFBBE09306AC3")
        @DSModeled(DSC.SAFE)
        public String getEncodedUserInfo() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "00C71B0865F91AE7EF71B7BE21B14B9F", hash_generated_method = "377E0C3D5CFCFBA6B934B87B3333170C")
        @DSModeled(DSC.SAFE)
        public String getHost() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.458 -0400", hash_original_method = "B159430668427C6760C3FB4B772D9F59", hash_generated_method = "DD9B4302C2A9EE1D522995887611D43C")
        @DSModeled(DSC.SAFE)
        public int getPort() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.459 -0400", hash_original_method = "ACF28BE5516AF44175C2E6962FB03404", hash_generated_method = "3F59C2650F10BB3705EA1D9F4F0E948B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached;
            cached = cachedString != NOT_CACHED;
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append(scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());
            {
                boolean varC8C86438344E58844BC399B4194DB415_1704566990 = (!fragment.isEmpty());
                {
                    sb.append('#').append(fragment.getEncoded());
                } //End block
            } //End collapsed parenthetic
            String var4647C862C9388EEC83BA6D6ED75C87D6_767244293 = (cachedString = sb.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = cachedString != NOT_CACHED;
            //if (cached) {
                //return cachedString;
            //}
            //StringBuilder sb = new StringBuilder();
            //sb.append(scheme).append(':');
            //sb.append(getEncodedSchemeSpecificPart());
            //if (!fragment.isEmpty()) {
                //sb.append('#').append(fragment.getEncoded());
            //}
            //return cachedString = sb.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.459 -0400", hash_original_method = "9B1777E9DAB1C1ED3319A4EEC33BCB54", hash_generated_method = "538F85633CE5D06F2C22901859ECAED3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder buildUpon() {
            Builder var3790BFD7AAE4E78997336FD736448E7A_555840422 = (new Builder()
                    .scheme(this.scheme)
                    .opaquePart(this.ssp)
                    .fragment(this.fragment));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(this.scheme)
                    //.opaquePart(this.ssp)
                    //.fragment(this.fragment);
        }

        
    }


    
    static class PathSegments extends AbstractList<String> implements RandomAccess {
        static final PathSegments EMPTY = new PathSegments(null, 0);
        final String[] segments;
        final int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.459 -0400", hash_original_method = "816AFE27D6484B7E80593A248F7DEC12", hash_generated_method = "C3DA0D4BCD0EADBB03FF2DBDB6A9CCF6")
        @DSModeled(DSC.SAFE)
         PathSegments(String[] segments, int size) {
            dsTaint.addTaint(segments);
            dsTaint.addTaint(size);
            this.segments = segments;
            this.size = size;
            // ---------- Original Method ----------
            //this.segments = segments;
            //this.size = size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.459 -0400", hash_original_method = "043CF25E38E9D3A71BE4CC7B6371568E", hash_generated_method = "77DB9E3E65E97639DE505CE52EA47C2B")
        @DSModeled(DSC.SAFE)
        public String get(int index) {
            dsTaint.addTaint(index);
            {
            	if (DroidSafeAndroidRuntime.control)throw new IndexOutOfBoundsException();
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (index >= size) {
                //throw new IndexOutOfBoundsException();
            //}
            //return segments[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.459 -0400", hash_original_method = "BAF1AF8B1284BE94C387C840AF9FA265", hash_generated_method = "FF6D59041294C84A84B367DE3D22F537")
        @DSModeled(DSC.SAFE)
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return this.size;
        }

        
    }


    
    static class PathSegmentsBuilder {
        String[] segments;
        int size = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.459 -0400", hash_original_method = "F05B9B5ECB44DE7CFF27782486F28CF3", hash_generated_method = "0C41A0619F844C90D6F4FF8049497F73")
        @DSModeled(DSC.SAFE)
         void add(String segment) {
            dsTaint.addTaint(segment);
            {
                segments = new String[4];
            } //End block
            {
                String[] expanded;
                expanded = new String[segments.length * 2];
                System.arraycopy(segments, 0, expanded, 0, segments.length);
                segments = expanded;
            } //End block
            segments[size++] = segment;
            // ---------- Original Method ----------
            //if (segments == null) {
                //segments = new String[4];
            //} else if (size + 1 == segments.length) {
                //String[] expanded = new String[segments.length * 2];
                //System.arraycopy(segments, 0, expanded, 0, segments.length);
                //segments = expanded;
            //}
            //segments[size++] = segment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.460 -0400", hash_original_method = "497F2229989230601A3120EEAF21B251", hash_generated_method = "8DA1B11F2EA9E67918C1B9E5D1EEB3B6")
        @DSModeled(DSC.SAFE)
         PathSegments build() {
            return (PathSegments)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (segments == null) {
                //return PathSegments.EMPTY;
            //}
            //try {
                //return new PathSegments(segments, size);
            //} finally {
                //segments = null;
            //}
        }

        
    }


    
    private abstract static class AbstractHierarchicalUri extends Uri {
        private Part userInfo;
        private volatile String host = NOT_CACHED;
        private volatile int port = NOT_CALCULATED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.460 -0400", hash_original_method = "D5E71CFA6EED35AEB9B5F4AEC5287C3B", hash_generated_method = "AA7B9B3DC32E27E1DD8DAE5FAC495DB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getLastPathSegment() {
            List<String> segments;
            segments = getPathSegments();
            int size;
            size = segments.size();
            String varDA71D27E66201AF49E74FE99F5D415E8_249880757 = (segments.get(size - 1));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //List<String> segments = getPathSegments();
            //int size = segments.size();
            //if (size == 0) {
                //return null;
            //}
            //return segments.get(size - 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.460 -0400", hash_original_method = "739BBE935CAE826F3703E2BBB77B819C", hash_generated_method = "F9EE01B4E395C7CAD8F0E0C901BA0B98")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getUserInfoPart() {
            {
                Object var83325DD41FA59C607668F0253D190775_1363862036 = (userInfo = Part.fromEncoded(parseUserInfo()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return userInfo == null
                    //? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.460 -0400", hash_original_method = "EADAAD26DC8689BCA10DCA33883B9323", hash_generated_method = "9ED0BC0981FF6D83851326EB023AEE96")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final String getEncodedUserInfo() {
            String var867DF3A9180C7B738F645E8AD44C399A_550356225 = (getUserInfoPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getUserInfoPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.460 -0400", hash_original_method = "10E379B7D06266EDAAC672E10EB0F58B", hash_generated_method = "044DF3B360D58B83F8405D57D1C41669")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseUserInfo() {
            String authority;
            authority = getEncodedAuthority();
            int end;
            end = authority.indexOf('@');
            {
                Object var5DA044768034BD1010C9FEFE00110404_211110604 = (authority.substring(0, end));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String authority = getEncodedAuthority();
            //if (authority == null) {
                //return null;
            //}
            //int end = authority.indexOf('@');
            //return end == NOT_FOUND ? null : authority.substring(0, end);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.460 -0400", hash_original_method = "575ECF6860F7EEFE5055BF56F2601A0E", hash_generated_method = "A8F13917C5E26192CC2E64219C0B2A54")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getUserInfo() {
            String varB8BF2F2F92AD83DFABA92B26BFD460B0_861956125 = (getUserInfoPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getUserInfoPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.461 -0400", hash_original_method = "2FC22A6CCA0A3F4C0B9E4C09F79A556D", hash_generated_method = "FF0B4006E7D23F698AA39115CE8D9302")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getHost() {
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (host != NOT_CACHED);
            {
                Object varDDAA9BFD1D32781B47E24284D76327A2_815114473 = ((host = parseHost()));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (host != NOT_CACHED);
            //return cached ? host
                    //: (host = parseHost());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.461 -0400", hash_original_method = "F3410DE0DFF96D0677FF54552E852FC4", hash_generated_method = "261921356779F894816DDD29FA22F252")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseHost() {
            String authority;
            authority = getEncodedAuthority();
            int userInfoSeparator;
            userInfoSeparator = authority.indexOf('@');
            int portSeparator;
            portSeparator = authority.indexOf(':', userInfoSeparator);
            String encodedHost;
            encodedHost = authority.substring(userInfoSeparator + 1);
            encodedHost = authority.substring(userInfoSeparator + 1, portSeparator);
            String varAB580F79A3C7C01033A72FFB758929E1_1009364344 = (decode(encodedHost));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String authority = getEncodedAuthority();
            //if (authority == null) {
                //return null;
            //}
            //int userInfoSeparator = authority.indexOf('@');
            //int portSeparator = authority.indexOf(':', userInfoSeparator);
            //String encodedHost = portSeparator == NOT_FOUND
                    //? authority.substring(userInfoSeparator + 1)
                    //: authority.substring(userInfoSeparator + 1, portSeparator);
            //return decode(encodedHost);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.461 -0400", hash_original_method = "A497EF38F72042FD9397DCB617BC4BBC", hash_generated_method = "6C5941EEB9A3E9A6F13B76BB5218ABA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getPort() {
            {
                Object varD4A5E1084DDC786A109466698FB6E902_1840365766 = (port = parsePort());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return port == NOT_CALCULATED
                    //? port = parsePort()
                    //: port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.461 -0400", hash_original_method = "5469820A1C15A09B87242C85BC223022", hash_generated_method = "A83B28DF05798E2F3780530A9065DAE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int parsePort() {
            String authority;
            authority = getEncodedAuthority();
            int userInfoSeparator;
            userInfoSeparator = authority.indexOf('@');
            int portSeparator;
            portSeparator = authority.indexOf(':', userInfoSeparator);
            String portString;
            portString = decode(authority.substring(portSeparator + 1));
            try 
            {
                int var9090A94059B9013CFD764DB303CCFFD1_2140795990 = (Integer.parseInt(portString));
            } //End block
            catch (NumberFormatException e)
            { }
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //String authority = getEncodedAuthority();
            //if (authority == null) {
                //return -1;
            //}
            //int userInfoSeparator = authority.indexOf('@');
            //int portSeparator = authority.indexOf(':', userInfoSeparator);
            //if (portSeparator == NOT_FOUND) {
                //return -1;
            //}
            //String portString = decode(authority.substring(portSeparator + 1));
            //try {
                //return Integer.parseInt(portString);
            //} catch (NumberFormatException e) {
                //Log.w(LOG, "Error parsing port string.", e);
                //return -1;
            //}
        }

        
    }


    
    private static class HierarchicalUri extends AbstractHierarchicalUri {
        static final int TYPE_ID = 3;
        private final String scheme;
        private final Part authority;
        private final PathPart path;
        private final Part query;
        private final Part fragment;
        private Part ssp;
        private volatile String uriString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.461 -0400", hash_original_method = "4B8A4922E90F4F5C5F11CB942A244C7D", hash_generated_method = "CCB08099BA432FB6A84C49447C0DAC03")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private HierarchicalUri(String scheme, Part authority, PathPart path,
                Part query, Part fragment) {
            dsTaint.addTaint(authority.dsTaint);
            dsTaint.addTaint(scheme);
            dsTaint.addTaint(query.dsTaint);
            dsTaint.addTaint(path.dsTaint);
            dsTaint.addTaint(fragment.dsTaint);
            this.authority = Part.nonNull(authority);
            this.path = path == null ? PathPart.NULL : path;
            this.query = Part.nonNull(query);
            this.fragment = Part.nonNull(fragment);
            this.scheme = scheme;

            // ---------- Original Method ----------
            //this.scheme = scheme;
            //this.authority = Part.nonNull(authority);
            //this.path = path == null ? PathPart.NULL : path;
            //this.query = Part.nonNull(query);
            //this.fragment = Part.nonNull(fragment);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "DC5791E697BE9BB4980E8FB1C7E142D4", hash_generated_method = "A47CF22DA42BCF6708CFEE192B64BF1D")
        static Uri readFrom(Parcel parcel) {
            return new HierarchicalUri(
                parcel.readString(),
                Part.readFrom(parcel),
                PathPart.readFrom(parcel),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "601AB6BE7C1B16F2DB83E078DF9B61DC", hash_generated_method = "46A9E2CE459DD07606105A10AF4CF263")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel parcel, int flags) {
            dsTaint.addTaint(parcel.dsTaint);
            dsTaint.addTaint(flags);
            parcel.writeInt(TYPE_ID);
            parcel.writeString(scheme);
            authority.writeTo(parcel);
            path.writeTo(parcel);
            query.writeTo(parcel);
            fragment.writeTo(parcel);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(scheme);
            //authority.writeTo(parcel);
            //path.writeTo(parcel);
            //query.writeTo(parcel);
            //fragment.writeTo(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "3471DB7575AAB7FBFD2140BF4AB89F77", hash_generated_method = "4FF008D2D89DE043C3E29F89B51A6434")
        @DSModeled(DSC.SAFE)
        public boolean isHierarchical() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "E7A636053E5A6B033EE9C785BB682629")
        @DSModeled(DSC.SAFE)
        public boolean isRelative() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "6809119C812010AE912E08971A3DC4F5")
        @DSModeled(DSC.SAFE)
        public String getScheme() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "6F57A7CA1E43F50667C0921A8F0F4C1E", hash_generated_method = "74EEA2A58D5C6CD9D9E7490C7AA2AAD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getSsp() {
            {
                Object var39F76A5B79F95BA39BB83A418D2236C8_1384242326 = (ssp = Part.fromEncoded(makeSchemeSpecificPart()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ssp == null
                    //? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "4547C3CEA064AB7637D7C0208FA23CFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedSchemeSpecificPart() {
            String var7D7FAEEE599108648A5A2C7256B47284_839228446 = (getSsp().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.462 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "994A2AF03D5028F3AED16E49723740D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getSchemeSpecificPart() {
            String var6DA99212315C50EDEEA13CBB45FC742F_708479376 = (getSsp().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.463 -0400", hash_original_method = "EA75444742B675900BB1383BC22E224C", hash_generated_method = "288197A7092BF2E58C49765C019833E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String makeSchemeSpecificPart() {
            StringBuilder builder;
            builder = new StringBuilder();
            appendSspTo(builder);
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_1335182548 = (builder.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //appendSspTo(builder);
            //return builder.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.463 -0400", hash_original_method = "55EA79AD41E607B8DD0B042A78040234", hash_generated_method = "184B618878944BE5545342185474954D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void appendSspTo(StringBuilder builder) {
            dsTaint.addTaint(builder.dsTaint);
            String encodedAuthority;
            encodedAuthority = authority.getEncoded();
            {
                builder.append("//").append(encodedAuthority);
            } //End block
            String encodedPath;
            encodedPath = path.getEncoded();
            {
                builder.append(encodedPath);
            } //End block
            {
                boolean var2C0BEF9EBF85F28B1D174D326A545DCD_1754280537 = (!query.isEmpty());
                {
                    builder.append('?').append(query.getEncoded());
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.463 -0400", hash_original_method = "4FC7F3346B5C0FC1519928E52B2843FB", hash_generated_method = "506CE9A95C52A7D87EA5A82B9BDD53F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAuthority() {
            String varB91FC8B23E1047CF018D2B37565FE340_627043434 = (this.authority.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.authority.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.463 -0400", hash_original_method = "02F0907154122B499105718EFAFFB12D", hash_generated_method = "C9CF1BE0306BCABF3D3E417B5E4ECF29")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedAuthority() {
            String var5F6FBB91CD789576B10D23A293F63029_1717352609 = (this.authority.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.authority.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.463 -0400", hash_original_method = "C2F72FED192DF0C1254C49B5EAFF6B37", hash_generated_method = "FAA43BF245FA41E2FCBDC0FBD882A7FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedPath() {
            String var47FED85FF7E0E428EA402E5A789DA8BD_1750761213 = (this.path.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.path.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.463 -0400", hash_original_method = "6081DF09BF7A0319CE8B8794EF03DD3D", hash_generated_method = "3A922FC86752AFDAF4F5C676CEFA50B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getPath() {
            String var132B060647AD30D8B7E93CD172EE5447_2029602117 = (this.path.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.path.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.463 -0400", hash_original_method = "BB14E9B85B4B70FE8537ADEAEA0F30F8", hash_generated_method = "1919128F5047CEFD859EBC892B16D27E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getQuery() {
            String var9CEC3AB415F24DB14727C661906E2F5C_1569470047 = (this.query.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.query.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.464 -0400", hash_original_method = "4E4841C1D3AAC7E9E3EC5666E1D3BDC7", hash_generated_method = "0673CB364C12542CD42146406BE7BF9B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedQuery() {
            String varD3BD189CE28C860EBDB783946C9CCDDA_105690203 = (this.query.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.query.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.464 -0400", hash_original_method = "BC71EA5136922A2C431D19FA4D7E797E", hash_generated_method = "DCC2E71030C967F4169C43035C46932F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getFragment() {
            String varB86D3547FC80A1CB8084D3FD71166066_1009472135 = (this.fragment.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.464 -0400", hash_original_method = "D0BDA4E24821D7C40932E823B160DCAD", hash_generated_method = "62E1958163521C34A838A99FCD59DEEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedFragment() {
            String varC7E1537659F8272C880F473FD1F35D0E_421614824 = (this.fragment.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.464 -0400", hash_original_method = "6A1F2A59685BCA2552F3B76D88CB5845", hash_generated_method = "2CEE1881737AD2885B24CD4E40601632")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getPathSegments() {
            List<String> var6EE7B0C0F0A37515379382C9ADBD120B_1006667749 = (this.path.getPathSegments());
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return this.path.getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.464 -0400", hash_original_method = "2FFEEC7D33EBEEF04178DF9D921CBC02", hash_generated_method = "EBBCB40023DE739B04344DC9219DB85D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (uriString != NOT_CACHED);
            {
                Object varE7AC0064225DACB1A436B0919FEFA6ED_482018880 = ((uriString = makeUriString()));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (uriString != NOT_CACHED);
            //return cached ? uriString
                    //: (uriString = makeUriString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.464 -0400", hash_original_method = "5AECD242275C33F74DCA414A6C8DF5D7", hash_generated_method = "76B86E11DC539CCCFAE2C0E487A2D45A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String makeUriString() {
            StringBuilder builder;
            builder = new StringBuilder();
            {
                builder.append(scheme).append(':');
            } //End block
            appendSspTo(builder);
            {
                boolean varC8C86438344E58844BC399B4194DB415_418481069 = (!fragment.isEmpty());
                {
                    builder.append('#').append(fragment.getEncoded());
                } //End block
            } //End collapsed parenthetic
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_1726914511 = (builder.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //if (scheme != null) {
                //builder.append(scheme).append(':');
            //}
            //appendSspTo(builder);
            //if (!fragment.isEmpty()) {
                //builder.append('#').append(fragment.getEncoded());
            //}
            //return builder.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.464 -0400", hash_original_method = "6635CD2DD122D7EE5F14A5F21B272B08", hash_generated_method = "48B0E56576EC2423B44ECBD3DA4B95FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder buildUpon() {
            Builder varA7F76453C8BA3B997659EDA9BEC16AB9_1476455537 = (new Builder()
                    .scheme(scheme)
                    .authority(authority)
                    .path(path)
                    .query(query)
                    .fragment(fragment));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(scheme)
                    //.authority(authority)
                    //.path(path)
                    //.query(query)
                    //.fragment(fragment);
        }

        
    }


    
    public static final class Builder {
        private String scheme;
        private Part opaquePart;
        private Part authority;
        private PathPart path;
        private Part query;
        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.465 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "6A0D4580F0807EB37108C48DCE62D6D2")
        @DSModeled(DSC.SAFE)
        public Builder() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.465 -0400", hash_original_method = "1FAF048543AEDF54BF8218C15362FDC3", hash_generated_method = "BE5AC33731D4D422BD5872301A579F62")
        @DSModeled(DSC.SAFE)
        public Builder scheme(String scheme) {
            dsTaint.addTaint(scheme);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.465 -0400", hash_original_method = "8D4C2B402A916DF01BF39AF004B22B4B", hash_generated_method = "6D041F7DFD9EF479925A4C778C1AB1D8")
        @DSModeled(DSC.SAFE)
         Builder opaquePart(Part opaquePart) {
            dsTaint.addTaint(opaquePart.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.opaquePart = opaquePart;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.465 -0400", hash_original_method = "B04C2A20C29308DA58A03AAA34E4602D", hash_generated_method = "F906605D60DCD40D6AD2D3B58735F087")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder opaquePart(String opaquePart) {
            dsTaint.addTaint(opaquePart);
            Builder var6C3A4A3671646F60B2AF9B53E066F6BC_1648191245 = (opaquePart(Part.fromDecoded(opaquePart)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return opaquePart(Part.fromDecoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.465 -0400", hash_original_method = "E3AC90668DB82124786DAC21400DF68F", hash_generated_method = "90FC47265F3901D43DEBF351A766B93B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedOpaquePart(String opaquePart) {
            dsTaint.addTaint(opaquePart);
            Builder var8A7656A3673A9500D87AF5DEA9CEF1BF_922490189 = (opaquePart(Part.fromEncoded(opaquePart)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return opaquePart(Part.fromEncoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.465 -0400", hash_original_method = "CE12FA6D2315F74B1A3B79C027FFFA6D", hash_generated_method = "28FD80683DC981A22676A9B0DCBA15E4")
        @DSModeled(DSC.SAFE)
         Builder authority(Part authority) {
            dsTaint.addTaint(authority.dsTaint);
            this.opaquePart = null;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.authority = authority;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.465 -0400", hash_original_method = "8B987B114EF487282F33A481DCB273CB", hash_generated_method = "EE3E956E782595FC8300CF0130CEE7E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder authority(String authority) {
            dsTaint.addTaint(authority);
            Builder varDD6B29B220B5C92FB846A00E677B7F82_210367168 = (authority(Part.fromDecoded(authority)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return authority(Part.fromDecoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.466 -0400", hash_original_method = "2AF9D1463857894BBB2A3B7E377A77BB", hash_generated_method = "1272EF8390AF9EEC96B42CF6057E16FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedAuthority(String authority) {
            dsTaint.addTaint(authority);
            Builder var8B538EB5FC2B179B3080ECB7C6F21F0F_764164641 = (authority(Part.fromEncoded(authority)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return authority(Part.fromEncoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.466 -0400", hash_original_method = "0552AFD7FA04CD9C4E588C7FB644B387", hash_generated_method = "54A59E4D73F237BCE97595C75118AC11")
        @DSModeled(DSC.SAFE)
         Builder path(PathPart path) {
            dsTaint.addTaint(path.dsTaint);
            this.opaquePart = null;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.path = path;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.466 -0400", hash_original_method = "311D5047B3596F1C34DEC3DA1D1264C5", hash_generated_method = "1127921EBC87690CE52823C5E58E4767")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder path(String path) {
            dsTaint.addTaint(path);
            Builder varA5F05625DDAD196CC170EB6DA5B4DFDA_987036291 = (path(PathPart.fromDecoded(path)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path(PathPart.fromDecoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.466 -0400", hash_original_method = "B2733F0C4852B782EB87F01613E6C574", hash_generated_method = "F3A7AE8366D88356450E0369EA63BAAA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedPath(String path) {
            dsTaint.addTaint(path);
            Builder varD0BA09633109B9478118F9AE2074776C_986105835 = (path(PathPart.fromEncoded(path)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path(PathPart.fromEncoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.466 -0400", hash_original_method = "818DCEC2192004BCFE40E4E49FDA7A4C", hash_generated_method = "9613FE536D89F95AA0EE859D99F32CC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder appendPath(String newSegment) {
            dsTaint.addTaint(newSegment);
            Builder var263ED00DA704240B552F9A81223F16F4_1114351017 = (path(PathPart.appendDecodedSegment(path, newSegment)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path(PathPart.appendDecodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.466 -0400", hash_original_method = "04B6E07373B5BCB6E5F5541B11BC55A7", hash_generated_method = "ECC2031384BAD1C76F7EBEC635A21A15")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder appendEncodedPath(String newSegment) {
            dsTaint.addTaint(newSegment);
            Builder var281F32762F95F37C34A0CC29AE97CD9C_1233660760 = (path(PathPart.appendEncodedSegment(path, newSegment)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path(PathPart.appendEncodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.466 -0400", hash_original_method = "526B00AFFC674BC410AFF0DB5058AD68", hash_generated_method = "25E9B5E91149040E317351D0487691F5")
        @DSModeled(DSC.SAFE)
         Builder query(Part query) {
            dsTaint.addTaint(query.dsTaint);
            this.opaquePart = null;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.query = query;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.466 -0400", hash_original_method = "915051404F16544BAB27A534573CC34D", hash_generated_method = "FD8AF8557C1C5594AFBCBD1EF416E726")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder query(String query) {
            dsTaint.addTaint(query);
            Builder var4AF05161165E0ABC57C395852DCB6F65_1467910820 = (query(Part.fromDecoded(query)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return query(Part.fromDecoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.467 -0400", hash_original_method = "2B1CFFF6E8520529FC529F01B5DBCD04", hash_generated_method = "4E61D68D2DE94603A2BA4611583C3A7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedQuery(String query) {
            dsTaint.addTaint(query);
            Builder var1CA62C78AE2CCF83DCEFD70594AC982D_1525665126 = (query(Part.fromEncoded(query)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return query(Part.fromEncoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.467 -0400", hash_original_method = "AAD8E80453C4B46D11B41869FDCBA00D", hash_generated_method = "E2B85F202A80458F29650F164C326FA0")
        @DSModeled(DSC.SAFE)
         Builder fragment(Part fragment) {
            dsTaint.addTaint(fragment.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.fragment = fragment;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.467 -0400", hash_original_method = "016C309F39EF5D90CF32B95F6FDB27F8", hash_generated_method = "DC09D2EA3FDED6A45893D35D7352A67A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder fragment(String fragment) {
            dsTaint.addTaint(fragment);
            Builder var94241188A52CAF7F79ADDEFBBA9A2461_738882930 = (fragment(Part.fromDecoded(fragment)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fragment(Part.fromDecoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.467 -0400", hash_original_method = "C5F51A11F0BEF63CCF4FD5F6AF742648", hash_generated_method = "D292E7E08A925830F62886DD568BBC2D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedFragment(String fragment) {
            dsTaint.addTaint(fragment);
            Builder var74930B6AD7A89E8CA47E48EAC7892FD5_1843040444 = (fragment(Part.fromEncoded(fragment)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fragment(Part.fromEncoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.467 -0400", hash_original_method = "F83D70A0FC90543F01AB6385367098CC", hash_generated_method = "35B2D9A27237802508F48C58CFA7634F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder appendQueryParameter(String key, String value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            this.opaquePart = null;
            String encodedParameter;
            encodedParameter = encode(key, null) + "="
                    + encode(value, null);
            {
                query = Part.fromEncoded(encodedParameter);
            } //End block
            String oldQuery;
            oldQuery = query.getEncoded();
            {
                boolean varD871C9980587FFA401304C0008BE3177_601618379 = (oldQuery == null || oldQuery.length() == 0);
                {
                    query = Part.fromEncoded(encodedParameter);
                } //End block
                {
                    query = Part.fromEncoded(oldQuery + "&" + encodedParameter);
                } //End block
            } //End collapsed parenthetic
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //String encodedParameter = encode(key, null) + "="
                    //+ encode(value, null);
            //if (query == null) {
                //query = Part.fromEncoded(encodedParameter);
                //return this;
            //}
            //String oldQuery = query.getEncoded();
            //if (oldQuery == null || oldQuery.length() == 0) {
                //query = Part.fromEncoded(encodedParameter);
            //} else {
                //query = Part.fromEncoded(oldQuery + "&" + encodedParameter);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.468 -0400", hash_original_method = "581A1CF068B5634C1F252DE7C2737E06", hash_generated_method = "8FD00789ADB4AF9E614321385BB2D2D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder clearQuery() {
            Builder var172750AB115CE806BDA046477A26E7D1_640790112 = (query((Part) null));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return query((Part) null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.468 -0400", hash_original_method = "C36CE5067F02DA1F1C7276BF67665A1B", hash_generated_method = "B051BE13354FEE3FBD355C393A53851D")
        @DSModeled(DSC.SPEC)
        public Uri build() {
            {
                {
                    if (DroidSafeAndroidRuntime.control)  throw new UnsupportedOperationException(
                            "An opaque URI must have a scheme.");
                } //End block
            } //End block
            {
                PathPart path;
                path = this.path;
                {
                    path = PathPart.EMPTY;
                } //End block
                {
                    {
                        boolean var2CA83CB1D078EAA23C6D98CE29904B75_1618586574 = (hasSchemeOrAuthority());
                        {
                            path = PathPart.makeAbsolute(path);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            return (Uri)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.468 -0400", hash_original_method = "7917AD3B49169A1AC8EEA7DD014B7E45", hash_generated_method = "660FBED5C2C84E0CE7750C00DC7CD1E7")
        @DSModeled(DSC.SAFE)
        private boolean hasSchemeOrAuthority() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return scheme != null
                    //|| (authority != null && authority != Part.NULL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.468 -0400", hash_original_method = "50FC77E3DFFDDD2DB7D0B749912434F7", hash_generated_method = "45F885BE083DDAF8D0CCDF4E1FB36206")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var8C18A8F60159DED136B70CAF5F2BA8BA_7299307 = (build().toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return build().toString();
        }

        
    }


    
    static abstract class AbstractPart {
        volatile String encoded;
        volatile String decoded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.469 -0400", hash_original_method = "21E01F693530948BFE81E2C9AE8C6D31", hash_generated_method = "BA3F5A3D936B86EDFCC403264280AF0D")
        @DSModeled(DSC.SAFE)
         AbstractPart(String encoded, String decoded) {
            dsTaint.addTaint(decoded);
            dsTaint.addTaint(encoded);
            // ---------- Original Method ----------
            //this.encoded = encoded;
            //this.decoded = decoded;
        }

        
        abstract String getEncoded();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.469 -0400", hash_original_method = "06323BBC323E7F59CEDDE1FAA04ED1F6", hash_generated_method = "314B9F578C9ECCC023AD1B802F70F04F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final String getDecoded() {
            @SuppressWarnings("StringEquality") boolean hasDecoded;
            hasDecoded = decoded != NOT_CACHED;
            {
                Object var52343EF1A0AE03CEC529642E146C7164_300540088 = ((decoded = decode(encoded)));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasDecoded = decoded != NOT_CACHED;
            //return hasDecoded ? decoded : (decoded = decode(encoded));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.469 -0400", hash_original_method = "BB7E54AFB81798C035BF3B3717F470E7", hash_generated_method = "70E1D7471454F964170CE9B6CFEAD8FD")
        @DSModeled(DSC.SAFE)
        final void writeTo(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            @SuppressWarnings("StringEquality") boolean hasEncoded;
            hasEncoded = encoded != NOT_CACHED;
            @SuppressWarnings("StringEquality") boolean hasDecoded;
            hasDecoded = decoded != NOT_CACHED;
            {
                parcel.writeInt(Representation.BOTH);
                parcel.writeString(encoded);
                parcel.writeString(decoded);
            } //End block
            {
                parcel.writeInt(Representation.ENCODED);
                parcel.writeString(encoded);
            } //End block
            {
                parcel.writeInt(Representation.DECODED);
                parcel.writeString(decoded);
            } //End block
            {
                throw new IllegalArgumentException("Neither encoded nor decoded");
            } //End block
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //@SuppressWarnings("StringEquality")
            //boolean hasDecoded = decoded != NOT_CACHED;
            //if (hasEncoded && hasDecoded) {
                //parcel.writeInt(Representation.BOTH);
                //parcel.writeString(encoded);
                //parcel.writeString(decoded);
            //} else if (hasEncoded) {
                //parcel.writeInt(Representation.ENCODED);
                //parcel.writeString(encoded);
            //} else if (hasDecoded) {
                //parcel.writeInt(Representation.DECODED);
                //parcel.writeString(decoded);
            //} else {
                //throw new IllegalArgumentException("Neither encoded nor decoded");
            //}
        }

        
        static class Representation {
            static final int BOTH = 0;
            static final int ENCODED = 1;
            static final int DECODED = 2;
            
        }


        
    }


    
    static class Part extends AbstractPart {
        static final Part NULL = new EmptyPart(null);
        static final Part EMPTY = new EmptyPart("");
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.469 -0400", hash_original_method = "68B275EBA6010E5404727E121615E229", hash_generated_method = "0411680D74EE7AA05ADF17CFE6065D2B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part(String encoded, String decoded) {
            super(encoded, decoded);
            dsTaint.addTaint(decoded);
            dsTaint.addTaint(encoded);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.470 -0400", hash_original_method = "BD94DCCF5B44419F4498543CA74892E2", hash_generated_method = "0518BCC8C3209A12991D206F6576FE6F")
        @DSModeled(DSC.SAFE)
         boolean isEmpty() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.470 -0400", hash_original_method = "74B8C999E422A266FD890BA259F6B43C", hash_generated_method = "08D1D8C89637902650BB89AEC60CBCB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded;
            hasEncoded = encoded != NOT_CACHED;
            {
                Object var65A0EA33726E1CAA970142E3851564A4_1592242317 = ((encoded = encode(decoded)));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.470 -0400", hash_original_method = "0A7C24B10C6F335EA8E9C233B8EAC1DF", hash_generated_method = "DF63C4D93FBCBE444881D3B902C102E3")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.470 -0400", hash_original_method = "7E582160561011C399B089EEEB2ACE48", hash_generated_method = "22C0043159AF111E907FE2930BA4EC89")
        static Part nonNull(Part part) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            return part == null ? NULL : part;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.470 -0400", hash_original_method = "E9523DE9E1BA3B83E89657DB7636CA0B", hash_generated_method = "FBC19D5A6490A7AB4B200F79382F810E")
        static Part fromEncoded(String encoded) {
            return from(encoded, NOT_CACHED);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.471 -0400", hash_original_method = "7EDC6E3E03A5038D4D1890F7EC9BBFB5", hash_generated_method = "8553348EE8801BE84BFA1119703A925E")
        static Part fromDecoded(String decoded) {
            return from(NOT_CACHED, decoded);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.471 -0400", hash_original_method = "2939154DCAF0A4BC8BC678B8D40526D2", hash_generated_method = "2CB930B2EAF6635CF4E8F91FFA47F817")
        static Part from(String encoded, String decoded) {
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

        
        private static class EmptyPart extends Part {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.471 -0400", hash_original_method = "D79C0256E86C850253FAE782AD9920ED", hash_generated_method = "A6C0622F3ED6B4F5931D0B02D411C083")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public EmptyPart(String value) {
                super(value, value);
                dsTaint.addTaint(value);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.471 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "066CB0A153952AE3B9E422013CCB634D")
            @DSModeled(DSC.SAFE)
            @Override
             boolean isEmpty() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return true;
            }

            
        }


        
    }


    
    static class PathPart extends AbstractPart {
        static final PathPart NULL = new PathPart(null, null);
        static final PathPart EMPTY = new PathPart("", "");
        private PathSegments pathSegments;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.471 -0400", hash_original_method = "E8CA21F7072E8C7642F3BFF9454329AE", hash_generated_method = "4FA6563D66BE28BDF22E5AFC9E99D721")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private PathPart(String encoded, String decoded) {
            super(encoded, decoded);
            dsTaint.addTaint(decoded);
            dsTaint.addTaint(encoded);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.472 -0400", hash_original_method = "EEE1C5D1C73794B2424FF9B6A794D8BE", hash_generated_method = "879272BA597674355D8965B5A59C9C23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded;
            hasEncoded = encoded != NOT_CACHED;
            {
                Object varAEC42D21560FD4DA78EF91AA3282921F_1665305970 = ((encoded = encode(decoded, "/")));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded, "/"));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.472 -0400", hash_original_method = "BB12DAE5001652F9E9419E41FB496BCF", hash_generated_method = "2659C9045866308AA7033CB2C2C1F96C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PathSegments getPathSegments() {
            String path;
            path = getEncoded();
            {
                PathSegments var9CB68C940CA264E9584BBC014A11EED3_1562502968 = (pathSegments = PathSegments.EMPTY);
            } //End block
            PathSegmentsBuilder segmentBuilder;
            segmentBuilder = new PathSegmentsBuilder();
            int previous;
            previous = 0;
            int current;
            {
                boolean varF3473A5176F979210C8BDFC961564284_1263168824 = ((current = path.indexOf('/', previous)) > -1);
                {
                    {
                        String decodedSegment;
                        decodedSegment = decode(path.substring(previous, current));
                        segmentBuilder.add(decodedSegment);
                    } //End block
                    previous = current + 1;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var80E2BDF18328ED6FA29B39AB13CE0D97_668745956 = (previous < path.length());
                {
                    segmentBuilder.add(decode(path.substring(previous)));
                } //End block
            } //End collapsed parenthetic
            PathSegments varD19D4B91636879DCBCCCBA50FF177F1B_351032501 = (pathSegments = segmentBuilder.build());
            return (PathSegments)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.472 -0400", hash_original_method = "FC759233B18D19C130F9855408C22F1F", hash_generated_method = "09E241BD18EC63696698E29ACD690E67")
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
            return fromEncoded(newPath);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.473 -0400", hash_original_method = "693D7EB1AC9B5DA10C06940CE5547310", hash_generated_method = "7E71C8985829A4DD725FE8C91850458C")
        static PathPart appendDecodedSegment(PathPart oldPart, String decoded) {
            String encoded = encode(decoded);
            return appendEncodedSegment(oldPart, encoded);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.473 -0400", hash_original_method = "9EE848C90BFEA86776EFC70469F7458B", hash_generated_method = "0ED8123F34795B87A9CEBD39BF7EAF76")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.473 -0400", hash_original_method = "E9900F32313470FE434176EDB3F6782A", hash_generated_method = "F5CD9204EAA71E8BB3B8994EC35AAF66")
        static PathPart fromEncoded(String encoded) {
            return from(encoded, NOT_CACHED);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.473 -0400", hash_original_method = "0BBE694B2E74FFFDB557998D4D35D258", hash_generated_method = "FE9735AD27E54DCDFC518070C7168A59")
        static PathPart fromDecoded(String decoded) {
            return from(NOT_CACHED, decoded);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.473 -0400", hash_original_method = "886122DB8DE034540F8087F0A2C37A21", hash_generated_method = "635B93CF110A8EA0D226F0DB513A4696")
        static PathPart from(String encoded, String decoded) {
            if (encoded == null) {
                return NULL;
            }
            if (encoded.length() == 0) {
                return EMPTY;
            }
            return new PathPart(encoded, decoded);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.474 -0400", hash_original_method = "3BB1F912AAE8A681B953ED643F92E7C0", hash_generated_method = "C34F101BF03FCCEA606DB8DD322595CF")
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
            return new PathPart(newEncoded, newDecoded);
        }

        
    }


    
}


//DSFIXME:  CODE0011:  Unresolved legacy methods exist in original model
/*

*/
