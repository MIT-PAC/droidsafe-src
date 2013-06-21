package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

public abstract class Uri implements Parcelable, Comparable<Uri> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.565 -0400", hash_original_method = "81E08B95735493D923725112C83DA27A", hash_generated_method = "AE17603DE8C4908F75692349E5C02303")
    @DSModeled(DSC.SAFE)
    private Uri() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
	public boolean isHierarchical() {
		return dsTaint.getTaintBoolean();
	}

    
    @DSModeled(DSC.SAFE)
	public boolean isOpaque() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSModeled(DSC.SAFE)
	public boolean isRelative() {
		// TODO Auto-generated method stub
		return dsTaint.getTaintBoolean();
	}

    
    @DSModeled(DSC.SAFE)
	public boolean isAbsolute() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSModeled(DSC.SAFE)
	public String getScheme() {
		// TODO Auto-generated method stub
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getSchemeSpecificPart() {
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getEncodedSchemeSpecificPart() {
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getAuthority() {
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getEncodedAuthority() {
		// TODO Auto-generated method stub
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getUserInfo() {
		// TODO Auto-generated method stub
		return DSUtils.UNKNOWN_STRING;
	}

    
    @DSModeled(DSC.SAFE)
	public String getEncodedUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
	public int getPort() {
		return dsTaint.getTaintInt();
	}

    
    @DSModeled(DSC.SAFE)
	public String getPath() {
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getEncodedPath() {
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getQuery() {
		// TODO Auto-generated method stub
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getEncodedQuery() {
		// TODO Auto-generated method stub
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getFragment() {
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public String getEncodedFragment() {
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public List<String> getPathSegments() {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		list.add(uriString);
		return list;
	}

    
    @DSModeled(DSC.SAFE)
	public String getLastPathSegment() {
		return uriString;
	}

    
    @DSModeled(DSC.SAFE)
	public boolean equals(Object o) {
		return true;
	}

    
    @DSModeled(DSC.SAFE)
	public int hashCode() {
        return toString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.571 -0400", hash_original_method = "45EC734684FFFB3EE70A4C12F2A2F839", hash_generated_method = "B674AC0DBC187FEF1E5CBE92623714A3")
    @DSModeled(DSC.SPEC)
    public int compareTo(Uri other) {
        dsTaint.addTaint(other.dsTaint);
        int var9FDCE1533C4137A95AA1B9336AC2C904_2051748237 = (toString().compareTo(other.toString()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return toString().compareTo(other.toString());
    }

    
    @DSModeled(DSC.SAFE)
	public String toString() {
		return dsTaint.getTaintString() + this.uriString;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.574 -0400", hash_original_method = "C2346F0C89241A0BA21735401E86BD49", hash_generated_method = "E09897DD6191876E475F46BD827F15D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toSafeString() {
        String scheme;
        scheme = getScheme();
        String ssp;
        ssp = getSchemeSpecificPart();
        {
            {
                boolean varECEC7553D0A8A9AA1C3551F50990F265_1624166876 = (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip")
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
                            boolean var3701C9303431F43DBFBC3723803F56F1_453336826 = (i<ssp.length());
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
                    String var1F59284C411F9419B065CDD234D02411_953723098 = (builder.toString());
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
        String var687AAF24B90629C9BFCFE9608FDCE6E7_998610495 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled()
	public Builder buildUpon() {
		return new Builder();
	}

    
    @DSModeled(DSC.SAFE)
    public static Uri parse(String uriString) {
        return new Uri(uriString);
    }

    
    public static Uri fromFile(File file) {
        if (file == null) {
            throw new NullPointerException("file");
        }
        PathPart path = PathPart.fromDecoded(file.getAbsolutePath());
        return new HierarchicalUri(
                "file", Part.EMPTY, path, Part.NULL, Part.NULL);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.581 -0400", hash_original_method = "966FC11B97976C170B352F408FA2783F", hash_generated_method = "3A1CAD1B682E1575C801B93BE4BC9AF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> getQueryParameterNames() {
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_538360717 = (isOpaque());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } //End block
        } //End collapsed parenthetic
        String query;
        query = getEncodedQuery();
        {
            Set<String> varAC8545868B29B0426131270094E9B735_742248576 = (Collections.emptySet());
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
            boolean var9694734975A6FBE04042BED474B6D869_2101427135 = (start < query.length());
        } //End collapsed parenthetic
        Set<String> varF0B7DA9F1BDCEA664A0164B39E9458D6_78525272 = (Collections.unmodifiableSet(names));
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.586 -0400", hash_original_method = "9E05603A6F44EBCC73536B2584976016", hash_generated_method = "792FF0C8F7BCD530D5B7533009FA5A5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getQueryParameters(String key) {
        dsTaint.addTaint(key);
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_1076572860 = (isOpaque());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key");
        } //End block
        String query;
        query = getEncodedQuery();
        {
            List<String> var1F7E6404BCDE565051377D8968B6B9AF_1089891613 = (Collections.emptyList());
        } //End block
        String encodedKey;
        try 
        {
            encodedKey = URLEncoder.encode(key, DEFAULT_ENCODING);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
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
                boolean var178076B3E468B8639CBF96A33155F9A9_2014234035 = (separator - start == encodedKey.length()
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
        List<String> varBB580AD4751E078150A200F823153F7A_2038069874 = (Collections.unmodifiableList(values));
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.588 -0400", hash_original_method = "72F6B0777F298E12957F6498D8B3E8F1", hash_generated_method = "D1CC342CBB73FF0CD2A0CD3D99C39864")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQueryParameter(String key) {
        dsTaint.addTaint(key);
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_1492688437 = (isOpaque());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key");
        } //End block
        String query;
        query = getEncodedQuery();
        String encodedKey;
        encodedKey = encode(key, null);
        int length;
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
                boolean var178076B3E468B8639CBF96A33155F9A9_559464198 = (separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length()));
                {
                    {
                        String var7E3DEF0FFA94D3A50F682B9FA129A299_336507576 = (decode(query.substring(separator + 1, end)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.589 -0400", hash_original_method = "67BE774C17CDAC836698DE4D6D994F1B", hash_generated_method = "F8547230B8CFBB6DD8CA392697CF1350")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBooleanQueryParameter(String key, boolean defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        String flag;
        flag = getQueryParameter(key);
        flag = flag.toLowerCase();
        boolean var1524D06912FA9A8910A3FA6431D6523F_964684015 = ((!"false".equals(flag) && !"0".equals(flag)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String flag = getQueryParameter(key);
        //if (flag == null) {
            //return defaultValue;
        //}
        //flag = flag.toLowerCase();
        //return (!"false".equals(flag) && !"0".equals(flag));
    }

    
    public static void writeToParcel(Parcel out, Uri uri) {
        if (uri == null) {
            out.writeInt(NULL_TYPE_ID);
        } else {
            uri.writeToParcel(out, 0);
        }
    }

    
    public static String encode(String s) {
        return encode(s, null);
    }

    
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

    
    private static boolean isAllowed(char c, String allow) {
        return (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z')
                || (c >= '0' && c <= '9')
                || "_-!.~'()*".indexOf(c) != NOT_FOUND
                || (allow != null && allow.indexOf(c) != NOT_FOUND);
    }

    
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

    
    public static Uri withAppendedPath(Uri baseUri, String pathSegment) {
        Builder builder = baseUri.buildUpon();
        builder = builder.appendEncodedPath(pathSegment);
        return builder.build();
    }

    
    private static class StringUri extends AbstractHierarchicalUri {
        private String uriString;
        private volatile int cachedSsi = NOT_CALCULATED;
        private volatile int cachedFsi = NOT_CALCULATED;
        private volatile String scheme = NOT_CACHED;
        private Part ssp;
        private Part authority;
        private PathPart path;
        private Part query;
        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.594 -0400", hash_original_method = "6762E8F4F232397EC67D86B91A630B95", hash_generated_method = "9A68C1FF974A1D5652B711AB47900F40")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private StringUri(String uriString) {
            dsTaint.addTaint(uriString);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uriString");
            } //End block
            // ---------- Original Method ----------
            //if (uriString == null) {
                //throw new NullPointerException("uriString");
            //}
            //this.uriString = uriString;
        }

        
        static Uri readFrom(Parcel parcel) {
            return new StringUri(parcel.readString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.595 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.596 -0400", hash_original_method = "C73A8428F9DA44091DF96EEDC1E3D3EF", hash_generated_method = "733C6392FC1D8C934125D39799D3081D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel parcel, int flags) {
            dsTaint.addTaint(parcel.dsTaint);
            dsTaint.addTaint(flags);
            parcel.writeInt(TYPE_ID);
            parcel.writeString(uriString);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.599 -0400", hash_original_method = "F197955D6E3BAB1920F769AA2F97BBD7", hash_generated_method = "CEA321A92EC4A258E716980A3E810251")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int findSchemeSeparator() {
            {
                Object varE78ED6E23D41D918630374A89968E910_1812570388 = (cachedSsi = uriString.indexOf(':'));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return cachedSsi == NOT_CALCULATED
                    //? cachedSsi = uriString.indexOf(':')
                    //: cachedSsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.601 -0400", hash_original_method = "B0E1A879F11D02C30EC9FBB06F8801FE", hash_generated_method = "F878702B570B1E42B523D2A4682F323F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int findFragmentSeparator() {
            {
                Object var084C492FFBD239136C6656DB9FC43D6A_826713665 = (cachedFsi = uriString.indexOf('#', findSchemeSeparator()));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return cachedFsi == NOT_CALCULATED
                    //? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    //: cachedFsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.602 -0400", hash_original_method = "11C2E375F5E033161AB2E06056D673CF", hash_generated_method = "B257D6A242556898D59E21BF80A19863")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isHierarchical() {
            int ssi;
            ssi = findSchemeSeparator();
            {
                boolean var57F8854C12EA0628EE85E2310495F80A_1574601198 = (uriString.length() == ssi + 1);
            } //End collapsed parenthetic
            boolean var27890038C7ED583D3363BEF736C880EE_265888084 = (uriString.charAt(ssi + 1) == '/');
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.603 -0400", hash_original_method = "DC1D040929AB7A4CF9A0DFBB95EA4283", hash_generated_method = "3F7E1D06F3EED240E59D68DA224BEF92")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isRelative() {
            boolean var3202A358296F4617942997BACCC7AFC0_1965538356 = (findSchemeSeparator() == NOT_FOUND);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return findSchemeSeparator() == NOT_FOUND;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.604 -0400", hash_original_method = "96667B7E38635C26F17AC80DC91F9ADB", hash_generated_method = "8F5925EA81DBBE6548C66FDB6BDB296B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getScheme() {
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (scheme != NOT_CACHED);
            {
                Object var7D216945360A9EB9106C3C6C10DBEE9A_712479318 = ((scheme = parseScheme()));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (scheme != NOT_CACHED);
            //return cached ? scheme : (scheme = parseScheme());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.605 -0400", hash_original_method = "B03A2C85823E1DE38C77FC40695B0CC7", hash_generated_method = "270C2AD61E63D26F72236E15D338DDDF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseScheme() {
            int ssi;
            ssi = findSchemeSeparator();
            {
                Object varCA104DA348F215F5529B91729A84824D_1749807901 = (uriString.substring(0, ssi));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //return ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.605 -0400", hash_original_method = "DE43C7F499D5F1739936552A95AA2492", hash_generated_method = "13BC1DA5271539626D99E4285147FB15")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getSsp() {
            {
                Object var78B9EFF0635EFBC686B09B483006DE78_1179928298 = (ssp = Part.fromEncoded(parseSsp()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.606 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "ED24246A78973D941D230BCB035E766B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedSchemeSpecificPart() {
            String var7D7FAEEE599108648A5A2C7256B47284_518165590 = (getSsp().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.617 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "22AD333430184927B6F3EB1389F10DD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getSchemeSpecificPart() {
            String var6DA99212315C50EDEEA13CBB45FC742F_1338650571 = (getSsp().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.618 -0400", hash_original_method = "6082AC88F53E9B67D59D9A72041A5D6F", hash_generated_method = "90404AB80D942C71C50890F49D2168EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseSsp() {
            int ssi;
            ssi = findSchemeSeparator();
            int fsi;
            fsi = findFragmentSeparator();
            {
                Object var1D900DBA169E529915BAABE0CE7F691B_965873224 = (uriString.substring(ssi + 1));
                Object var686C19CE234EEB8202829754EBB3A81D_1767379737 = (uriString.substring(ssi + 1, fsi));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND
                    //? uriString.substring(ssi + 1)
                    //: uriString.substring(ssi + 1, fsi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.628 -0400", hash_original_method = "C2AABBF6273BD8549508A0ABF072F220", hash_generated_method = "64C81B3D6248E6D28B917507F7129D0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getAuthorityPart() {
            {
                String encodedAuthority;
                encodedAuthority = parseAuthority(this.uriString, findSchemeSeparator());
                Part var87395B0C31486C92603EF5CFE566FC66_2136104177 = (authority = Part.fromEncoded(encodedAuthority));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.629 -0400", hash_original_method = "B783FB869F9CE6B897E37C2A9B9B4259", hash_generated_method = "7A3B961E30BF03D9AAFA783FA75A4A82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedAuthority() {
            String varAE5D04574D52DB652DEEBC8EA0235C9F_1106750890 = (getAuthorityPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getAuthorityPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.629 -0400", hash_original_method = "F4404025FB90C68980598D2895AF9578", hash_generated_method = "D5453374A155D2D254C33C8517A970C3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAuthority() {
            String var26C54218C3529D041B1823F65DF9B723_846827393 = (getAuthorityPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getAuthorityPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.630 -0400", hash_original_method = "483C19AAE407B7D6148F370745A1893E", hash_generated_method = "07C7ADE0B47026F3E8F616A1E2BAE4E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private PathPart getPathPart() {
            {
                Object var6C16C9C45A30E2131CDB00C08C229CEA_695066226 = (path = PathPart.fromEncoded(parsePath()));
            } //End flattened ternary
            return (PathPart)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path == null
                    //? path = PathPart.fromEncoded(parsePath())
                    //: path;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.631 -0400", hash_original_method = "E8759FDECF433DBBFF0BA03CF3576CC0", hash_generated_method = "D518EDAD2E5C7D466B4835EF0E57BCE7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getPath() {
            String var349F3F47631A3E1A940835C3C72CB3FB_114601277 = (getPathPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getPathPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.637 -0400", hash_original_method = "D26AFC1B9D9DFA82513D9A4C50DD2F0F", hash_generated_method = "0570099E0C021CDBDDD282780087D7B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedPath() {
            String varDFA6C8D800AD9633D6136C1A17BF6588_611211042 = (getPathPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getPathPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.637 -0400", hash_original_method = "A1BA2B8DCFFB301EABC725C63F487DC2", hash_generated_method = "5835F236B173C3510FB14721E118BE70")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getPathSegments() {
            List<String> var24A8571EC31E4D340BB96C28284006F7_381407468 = (getPathPart().getPathSegments());
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getPathPart().getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.639 -0400", hash_original_method = "EF0989C68625FC2F46DE0EA4CB35660B", hash_generated_method = "DF7A68B7ED0CBDB5EF5C2C3F4E08239B")
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
                    boolean varD917EE6A3AF74F85327A628F817BD281_262356340 = (uriString.charAt(ssi + 1) != '/');
                } //End collapsed parenthetic
            } //End block
            String var9B8AAACD164711163A6613636FE9739A_1341803294 = (parsePath(uriString, ssi));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.640 -0400", hash_original_method = "5338F6D0AC99191764C2394A710C873F", hash_generated_method = "236611FDE6671E20BDD3C0A575E93D9D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getQueryPart() {
            {
                Object var801FBFC2970160220E521316DD1EB050_1991994991 = (query = Part.fromEncoded(parseQuery()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return query == null
                    //? query = Part.fromEncoded(parseQuery()) : query;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.645 -0400", hash_original_method = "61892B739321CB796D242E9E13C1F033", hash_generated_method = "9D375CAF52910809C6EEBD093ADA8A71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedQuery() {
            String varD0A6156362E4ACEED3829124CC8D36D4_1345922277 = (getQueryPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getQueryPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.646 -0400", hash_original_method = "93492ABD4F9B88C963E84B9F545E5D11", hash_generated_method = "B37D0BB36E5EE4E3ACDB85FCB47DE73E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseQuery() {
            int qsi;
            qsi = uriString.indexOf('?', findSchemeSeparator());
            int fsi;
            fsi = findFragmentSeparator();
            {
                String varD5188933CF729337DEAF15D26C06DC9F_412559126 = (uriString.substring(qsi + 1));
            } //End block
            String var531346F1553737677BB25172E787CD90_1691060210 = (uriString.substring(qsi + 1, fsi));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.647 -0400", hash_original_method = "31EC40ABD8B86D0064329950E060BFBD", hash_generated_method = "6A6ECAA745E3B817995169EEBF8FBCDC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getQuery() {
            String var65FE725AD9C28CA5FADDACECC82F6AFC_818001939 = (getQueryPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getQueryPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.659 -0400", hash_original_method = "EAD370CB1FE781DF1864471D9F5F3E36", hash_generated_method = "6ED876D54DBF49086EA8AFF44C22DE18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getFragmentPart() {
            {
                Object varBC1183FC5A49D55E17559946F28DE142_14624496 = (fragment = Part.fromEncoded(parseFragment()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fragment == null
                    //? fragment = Part.fromEncoded(parseFragment()) : fragment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.660 -0400", hash_original_method = "C2884F3C25114B1CD652E8CCEF7D7F10", hash_generated_method = "BC993F60B2B511AA069CF5F5CE5A06E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedFragment() {
            String var9F52E53C1164E929343C99056BB74BF5_1687511968 = (getFragmentPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getFragmentPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.662 -0400", hash_original_method = "13965C7143AC0E622773DBA6AE062E67", hash_generated_method = "F3EF3B9D5AB2BE4C8958E97687AB48B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseFragment() {
            int fsi;
            fsi = findFragmentSeparator();
            {
                Object var04EF01075150630161DFDC67991EA889_1597355545 = (uriString.substring(fsi + 1));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.662 -0400", hash_original_method = "4E8163B4F7FDF9829581A99F6274656D", hash_generated_method = "0F2978E5F9CEEE996232F24BD25DA056")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getFragment() {
            String var70D235A5DEE0D344761C7126F2616A72_1703764556 = (getFragmentPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getFragmentPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.663 -0400", hash_original_method = "ECB4588CBE3D957B88D2558A4C044374", hash_generated_method = "331361155F0E804D66A0D94DC4130ABC")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return uriString;
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.665 -0400", hash_original_method = "54B78C0DD1C850213ABB66143A4F5DE7", hash_generated_method = "E5F2AC6C43333270AD4D0D016EFB4C38")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder buildUpon() {
            {
                boolean varDDDEF883E55C0067D538DC62E8B8900F_1200336741 = (isHierarchical());
                {
                    Builder varA9FA48921BCD4E83C921A5BF971A2D2F_491213352 = (new Builder()
                        .scheme(getScheme())
                        .authority(getAuthorityPart())
                        .path(getPathPart())
                        .query(getQueryPart())
                        .fragment(getFragmentPart()));
                } //End block
                {
                    Builder varAD173BB872313D8C15A6FD748C8D6532_1167941357 = (new Builder()
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

        
        static final int TYPE_ID = 1;
    }


    
    private static class OpaqueUri extends Uri {
        private String scheme;
        private Part ssp;
        private Part fragment;
        private volatile String cachedString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.671 -0400", hash_original_method = "A3EB90F61BB5DAD9A21709AA9F976DF8", hash_generated_method = "26E6348747649C5517EF3759BA23E02C")
        @DSModeled(DSC.SAFE)
        private OpaqueUri(String scheme, Part ssp, Part fragment) {
            dsTaint.addTaint(scheme);
            dsTaint.addTaint(ssp.dsTaint);
            dsTaint.addTaint(fragment.dsTaint);
            this.fragment = fragment == null ? Part.NULL : fragment;
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //this.ssp = ssp;
            //this.fragment = fragment == null ? Part.NULL : fragment;
        }

        
        static Uri readFrom(Parcel parcel) {
            return new OpaqueUri(
                parcel.readString(),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.673 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.674 -0400", hash_original_method = "8F996E53ADCFC30BFF794C5CEED4DA61", hash_generated_method = "1967BE5D4DABE108641C2B515BDBF83E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.675 -0400", hash_original_method = "414EEC63B62C24CE4C288B4F88575946", hash_generated_method = "2EC67B5866E9D0BA5A62D453ADE12008")
        @DSModeled(DSC.SAFE)
        public boolean isHierarchical() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.676 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "ADD19B0342CA45869A0290C0CF0AB3A8")
        @DSModeled(DSC.SAFE)
        public boolean isRelative() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.677 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "BC31174F828F19811FA9B66B1F89A31F")
        @DSModeled(DSC.SAFE)
        public String getScheme() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.677 -0400", hash_original_method = "3C55B6D4F736410AF7A2ACAB5CCC51ED", hash_generated_method = "55C4AE933ACC0C4B8BC011EB7556C8B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedSchemeSpecificPart() {
            String var3B6DB3B18730A649E01AB6CC8288DC37_1988347526 = (ssp.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return ssp.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.678 -0400", hash_original_method = "ED3540C8D06E41CD645C58A620F36381", hash_generated_method = "46317DEE10630416A9CBF2B7FA4B2464")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getSchemeSpecificPart() {
            String varB2851401428327DC587D0E57AFC8B6D2_518269480 = (ssp.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return ssp.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.679 -0400", hash_original_method = "31E41E1CB0338F9BAA50A0AC05D7D02D", hash_generated_method = "4F7269241A52E55F9BEF1057A841586C")
        @DSModeled(DSC.SAFE)
        public String getAuthority() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.679 -0400", hash_original_method = "C6F3CA63C6BE518EBD2AA32E2786DD3A", hash_generated_method = "2CE96AF1610EA1610847A4150FCA2215")
        @DSModeled(DSC.SAFE)
        public String getEncodedAuthority() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.680 -0400", hash_original_method = "F489014FCD27D67260CBEC8AC84559A2", hash_generated_method = "5DC91256D20EE1A5604C580B32C468C5")
        @DSModeled(DSC.SAFE)
        public String getPath() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.681 -0400", hash_original_method = "F167E35F53D1A5A8B17A8A72FE8359AE", hash_generated_method = "75A2A4176113F9C1D22902C7C5686B43")
        @DSModeled(DSC.SAFE)
        public String getEncodedPath() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.694 -0400", hash_original_method = "2E34959E1DD3631C67E93F1AE6B31056", hash_generated_method = "80D8E25C4FAD30B4BAD94F55D2F6D2C0")
        @DSModeled(DSC.SAFE)
        public String getQuery() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.695 -0400", hash_original_method = "53661DD2D38C9C2E00E8B8D2FF316BB7", hash_generated_method = "C9816019EDEB8B454674C8E3707666DE")
        @DSModeled(DSC.SAFE)
        public String getEncodedQuery() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.696 -0400", hash_original_method = "9F53DDCB73E71AFF4CF207B49D0689B3", hash_generated_method = "59645235B6EA464D267CD1E653940B90")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getFragment() {
            String varE18A7E61FDA99F5B7F21777A6737F482_1765553446 = (fragment.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.697 -0400", hash_original_method = "2FF982E252638134744EE32C0D7F6950", hash_generated_method = "09E3B5678F14538C208EA34A6050501A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedFragment() {
            String var0C1C71A0BDCB9223CF4E2E5E5D4E780B_188791203 = (fragment.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.698 -0400", hash_original_method = "08B329AF4FAA2768183F76EC45288C10", hash_generated_method = "6F48C103091AAC851EC134BB29A439E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getPathSegments() {
            List<String> var1F7E6404BCDE565051377D8968B6B9AF_756269039 = (Collections.emptyList());
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.698 -0400", hash_original_method = "AE7FF2A9DFCB643CF70873B2C08CD5A8", hash_generated_method = "9604D1506D9D73093982FD4E6DCD0AC3")
        @DSModeled(DSC.SAFE)
        public String getLastPathSegment() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.699 -0400", hash_original_method = "520FB960E4127ABC7143DD06EFB52356", hash_generated_method = "44E53B33C59DBE9BE65EF125EF93D04E")
        @DSModeled(DSC.SAFE)
        public String getUserInfo() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.700 -0400", hash_original_method = "88ECB0B5D6F4AA907FC3666F8C1418EB", hash_generated_method = "2F47AC89CA4505643CF9256685EB07CA")
        @DSModeled(DSC.SAFE)
        public String getEncodedUserInfo() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.701 -0400", hash_original_method = "00C71B0865F91AE7EF71B7BE21B14B9F", hash_generated_method = "DFB6D14D9FC486FFA060B9239D8804D8")
        @DSModeled(DSC.SAFE)
        public String getHost() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.702 -0400", hash_original_method = "B159430668427C6760C3FB4B772D9F59", hash_generated_method = "451D70C8290DD0636FC94AF62E78B273")
        @DSModeled(DSC.SAFE)
        public int getPort() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.703 -0400", hash_original_method = "ACF28BE5516AF44175C2E6962FB03404", hash_generated_method = "C70C5F18736F3F982BF9A24CECCB6BA9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached;
            cached = cachedString != NOT_CACHED;
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append(scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());
            {
                boolean varC8C86438344E58844BC399B4194DB415_182529609 = (!fragment.isEmpty());
                {
                    sb.append('#').append(fragment.getEncoded());
                } //End block
            } //End collapsed parenthetic
            String var4647C862C9388EEC83BA6D6ED75C87D6_133819876 = (cachedString = sb.toString());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.705 -0400", hash_original_method = "9B1777E9DAB1C1ED3319A4EEC33BCB54", hash_generated_method = "6EDA206820BE0BD096D34CCF33A96922")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder buildUpon() {
            Builder var3790BFD7AAE4E78997336FD736448E7A_1727172561 = (new Builder()
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

        
        static final int TYPE_ID = 2;
    }


    
    static class PathSegments extends AbstractList<String> implements RandomAccess {
        String[] segments;
        int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.706 -0400", hash_original_method = "816AFE27D6484B7E80593A248F7DEC12", hash_generated_method = "53B2744B73CC278B9BC4BDB41B00ACC6")
        @DSModeled(DSC.SAFE)
         PathSegments(String[] segments, int size) {
            dsTaint.addTaint(segments[0]);
            dsTaint.addTaint(size);
            // ---------- Original Method ----------
            //this.segments = segments;
            //this.size = size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.707 -0400", hash_original_method = "043CF25E38E9D3A71BE4CC7B6371568E", hash_generated_method = "0CBDB32EDAF18E72B6B80341B2ECC7EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String get(int index) {
            dsTaint.addTaint(index);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (index >= size) {
                //throw new IndexOutOfBoundsException();
            //}
            //return segments[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.708 -0400", hash_original_method = "BAF1AF8B1284BE94C387C840AF9FA265", hash_generated_method = "8E7325EEBAE9B23535EEE04475E654C3")
        @DSModeled(DSC.SAFE)
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return this.size;
        }

        
        static final PathSegments EMPTY = new PathSegments(null, 0);
    }


    
    static class PathSegmentsBuilder {
        String[] segments;
        int size = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.708 -0400", hash_original_method = "85B31AF41D66F37A55703EAB0B1E6F6A", hash_generated_method = "85B31AF41D66F37A55703EAB0B1E6F6A")
                public PathSegmentsBuilder ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.709 -0400", hash_original_method = "F05B9B5ECB44DE7CFF27782486F28CF3", hash_generated_method = "71C48582D740682F41004C2FFEFF760F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.719 -0400", hash_original_method = "497F2229989230601A3120EEAF21B251", hash_generated_method = "F1E56782F552926FA46748D861725484")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PathSegments build() {
            try 
            {
                PathSegments varC7FB489348CA13E7ADFF5FB28AB184A9_1639500887 = (new PathSegments(segments, size));
            } //End block
            finally 
            {
                segments = null;
            } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.719 -0400", hash_original_method = "5C567CCCE588FE0FC87F1C1B34C74562", hash_generated_method = "5C567CCCE588FE0FC87F1C1B34C74562")
                public AbstractHierarchicalUri ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.720 -0400", hash_original_method = "D5E71CFA6EED35AEB9B5F4AEC5287C3B", hash_generated_method = "F62C56C141C48FA66116AA4A3AF0832C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getLastPathSegment() {
            List<String> segments;
            segments = getPathSegments();
            int size;
            size = segments.size();
            String varDA71D27E66201AF49E74FE99F5D415E8_95300880 = (segments.get(size - 1));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //List<String> segments = getPathSegments();
            //int size = segments.size();
            //if (size == 0) {
                //return null;
            //}
            //return segments.get(size - 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.721 -0400", hash_original_method = "739BBE935CAE826F3703E2BBB77B819C", hash_generated_method = "E22E9F1AD16D7B84333F5F3E7BBA7E6E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getUserInfoPart() {
            {
                Object var83325DD41FA59C607668F0253D190775_1445132002 = (userInfo = Part.fromEncoded(parseUserInfo()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return userInfo == null
                    //? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.730 -0400", hash_original_method = "EADAAD26DC8689BCA10DCA33883B9323", hash_generated_method = "FC8780F68F09BB9E269F4EE57679068F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final String getEncodedUserInfo() {
            String var867DF3A9180C7B738F645E8AD44C399A_1712881240 = (getUserInfoPart().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getUserInfoPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.731 -0400", hash_original_method = "10E379B7D06266EDAAC672E10EB0F58B", hash_generated_method = "B8AB7DEA92759F7AF61660F3D04E4BCB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String parseUserInfo() {
            String authority;
            authority = getEncodedAuthority();
            int end;
            end = authority.indexOf('@');
            {
                Object var5DA044768034BD1010C9FEFE00110404_504172063 = (authority.substring(0, end));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.731 -0400", hash_original_method = "575ECF6860F7EEFE5055BF56F2601A0E", hash_generated_method = "EE914A622B743CD9CCF9C01ABED8092B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getUserInfo() {
            String varB8BF2F2F92AD83DFABA92B26BFD460B0_1129143687 = (getUserInfoPart().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getUserInfoPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.732 -0400", hash_original_method = "2FC22A6CCA0A3F4C0B9E4C09F79A556D", hash_generated_method = "F539D76BD61A79D56195D64288203F23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getHost() {
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (host != NOT_CACHED);
            {
                Object varDDAA9BFD1D32781B47E24284D76327A2_1361575048 = ((host = parseHost()));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (host != NOT_CACHED);
            //return cached ? host
                    //: (host = parseHost());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.734 -0400", hash_original_method = "F3410DE0DFF96D0677FF54552E852FC4", hash_generated_method = "F31D8BD4F8EE98B29D0518F0E3E1BBD8")
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
            String varAB580F79A3C7C01033A72FFB758929E1_1825025461 = (decode(encodedHost));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.735 -0400", hash_original_method = "A497EF38F72042FD9397DCB617BC4BBC", hash_generated_method = "D94CF088B38AF5AE9E32E3AD91EAF3EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getPort() {
            {
                Object varD4A5E1084DDC786A109466698FB6E902_98298202 = (port = parsePort());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return port == NOT_CALCULATED
                    //? port = parsePort()
                    //: port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.737 -0400", hash_original_method = "5469820A1C15A09B87242C85BC223022", hash_generated_method = "642849CE23B49FB3D637C0DCD519AA7C")
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
                int var9090A94059B9013CFD764DB303CCFFD1_38131572 = (Integer.parseInt(portString));
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
        private String scheme;
        private Part authority;
        private PathPart path;
        private Part query;
        private Part fragment;
        private Part ssp;
        private volatile String uriString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.738 -0400", hash_original_method = "4B8A4922E90F4F5C5F11CB942A244C7D", hash_generated_method = "549BA8A36DA5CD2438C7A76AAE9C80E6")
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
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //this.authority = Part.nonNull(authority);
            //this.path = path == null ? PathPart.NULL : path;
            //this.query = Part.nonNull(query);
            //this.fragment = Part.nonNull(fragment);
        }

        
        static Uri readFrom(Parcel parcel) {
            return new HierarchicalUri(
                parcel.readString(),
                Part.readFrom(parcel),
                PathPart.readFrom(parcel),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.739 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.740 -0400", hash_original_method = "601AB6BE7C1B16F2DB83E078DF9B61DC", hash_generated_method = "83270F72731FAF74B03214958DBA3F16")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.741 -0400", hash_original_method = "3471DB7575AAB7FBFD2140BF4AB89F77", hash_generated_method = "E965FDFDEBAD77DD219E6B899E584635")
        @DSModeled(DSC.SAFE)
        public boolean isHierarchical() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.758 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "ADD19B0342CA45869A0290C0CF0AB3A8")
        @DSModeled(DSC.SAFE)
        public boolean isRelative() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.759 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FA0BB2BEE07FE20A886DD0258ABDE91D")
        @DSModeled(DSC.SAFE)
        public String getScheme() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.759 -0400", hash_original_method = "6F57A7CA1E43F50667C0921A8F0F4C1E", hash_generated_method = "3E1FCC58BE5E183183AA50495A5CF102")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part getSsp() {
            {
                Object var39F76A5B79F95BA39BB83A418D2236C8_752252543 = (ssp = Part.fromEncoded(makeSchemeSpecificPart()));
            } //End flattened ternary
            return (Part)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ssp == null
                    //? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.760 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "B8F684C9AA8F5D72E900E590FB5E58CE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedSchemeSpecificPart() {
            String var7D7FAEEE599108648A5A2C7256B47284_1100008617 = (getSsp().getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.761 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "FBA9B0C0F5B4304D8AE695F43AA55AEF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getSchemeSpecificPart() {
            String var6DA99212315C50EDEEA13CBB45FC742F_1402320393 = (getSsp().getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.762 -0400", hash_original_method = "EA75444742B675900BB1383BC22E224C", hash_generated_method = "313BA4D849EC1CC62A3889C2CC165CCC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String makeSchemeSpecificPart() {
            StringBuilder builder;
            builder = new StringBuilder();
            appendSspTo(builder);
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_267772099 = (builder.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //appendSspTo(builder);
            //return builder.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.763 -0400", hash_original_method = "55EA79AD41E607B8DD0B042A78040234", hash_generated_method = "F4E7E70368DC613A81CBE96A55DD6829")
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
                boolean var2C0BEF9EBF85F28B1D174D326A545DCD_735463476 = (!query.isEmpty());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.764 -0400", hash_original_method = "4FC7F3346B5C0FC1519928E52B2843FB", hash_generated_method = "6A950CEB08AB853EAC93BFADF9174E95")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAuthority() {
            String varB91FC8B23E1047CF018D2B37565FE340_665601120 = (this.authority.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.authority.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.765 -0400", hash_original_method = "02F0907154122B499105718EFAFFB12D", hash_generated_method = "A34208ABC7C7D7C20BF1C1D17EB745FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedAuthority() {
            String var5F6FBB91CD789576B10D23A293F63029_1057550376 = (this.authority.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.authority.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.765 -0400", hash_original_method = "C2F72FED192DF0C1254C49B5EAFF6B37", hash_generated_method = "C1AFC4D9E25A3857FA335FF19A034C63")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedPath() {
            String var47FED85FF7E0E428EA402E5A789DA8BD_1322605770 = (this.path.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.path.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.766 -0400", hash_original_method = "6081DF09BF7A0319CE8B8794EF03DD3D", hash_generated_method = "8362D2EF5E4FF61BF3CC9CB7723BFF1B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getPath() {
            String var132B060647AD30D8B7E93CD172EE5447_276676600 = (this.path.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.path.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.767 -0400", hash_original_method = "BB14E9B85B4B70FE8537ADEAEA0F30F8", hash_generated_method = "8D2EF7BEEC485E1F579AFA3AF17EC7DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getQuery() {
            String var9CEC3AB415F24DB14727C661906E2F5C_636504253 = (this.query.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.query.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.768 -0400", hash_original_method = "4E4841C1D3AAC7E9E3EC5666E1D3BDC7", hash_generated_method = "E814BE28691684E19CDB26773D78E2F0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedQuery() {
            String varD3BD189CE28C860EBDB783946C9CCDDA_1022776025 = (this.query.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.query.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.768 -0400", hash_original_method = "BC71EA5136922A2C431D19FA4D7E797E", hash_generated_method = "981F4EF079EFB04F2389EE2288A6E468")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getFragment() {
            String varB86D3547FC80A1CB8084D3FD71166066_1253206727 = (this.fragment.getDecoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.769 -0400", hash_original_method = "D0BDA4E24821D7C40932E823B160DCAD", hash_generated_method = "28939E894A28F86B4161CBDC04E8C543")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncodedFragment() {
            String varC7E1537659F8272C880F473FD1F35D0E_1645322741 = (this.fragment.getEncoded());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return this.fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.771 -0400", hash_original_method = "6A1F2A59685BCA2552F3B76D88CB5845", hash_generated_method = "532EDE0D4C1146D512F33C08FFA93294")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getPathSegments() {
            List<String> var6EE7B0C0F0A37515379382C9ADBD120B_2126474714 = (this.path.getPathSegments());
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return this.path.getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.780 -0400", hash_original_method = "2FFEEC7D33EBEEF04178DF9D921CBC02", hash_generated_method = "E598A9F9882E34E9C16FE75A7F65E6B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (uriString != NOT_CACHED);
            {
                Object varE7AC0064225DACB1A436B0919FEFA6ED_1999886060 = ((uriString = makeUriString()));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (uriString != NOT_CACHED);
            //return cached ? uriString
                    //: (uriString = makeUriString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.781 -0400", hash_original_method = "5AECD242275C33F74DCA414A6C8DF5D7", hash_generated_method = "D7932F087474C353CA4BFFAFD0A7BBA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String makeUriString() {
            StringBuilder builder;
            builder = new StringBuilder();
            {
                builder.append(scheme).append(':');
            } //End block
            appendSspTo(builder);
            {
                boolean varC8C86438344E58844BC399B4194DB415_650095803 = (!fragment.isEmpty());
                {
                    builder.append('#').append(fragment.getEncoded());
                } //End block
            } //End collapsed parenthetic
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_948968859 = (builder.toString());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.782 -0400", hash_original_method = "6635CD2DD122D7EE5F14A5F21B272B08", hash_generated_method = "09F73F4457C512EC02969D3C16756036")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder buildUpon() {
            Builder varA7F76453C8BA3B997659EDA9BEC16AB9_784969484 = (new Builder()
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

        
        static final int TYPE_ID = 3;
    }


    
    public static final class Builder {
        private String scheme;
        private Part opaquePart;
        private Part authority;
        private PathPart path;
        private Part query;
        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.783 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "7F0D829FE2A4B9F217489244A9FD2E61")
        @DSModeled(DSC.SAFE)
        public Builder() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.784 -0400", hash_original_method = "1FAF048543AEDF54BF8218C15362FDC3", hash_generated_method = "D78FF1230E75DFF99B156C6478C7C029")
        @DSModeled(DSC.SAFE)
        public Builder scheme(String scheme) {
            dsTaint.addTaint(scheme);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.784 -0400", hash_original_method = "8D4C2B402A916DF01BF39AF004B22B4B", hash_generated_method = "FE845AE45A7E460D7C6CE5C2912E5B33")
        @DSModeled(DSC.SAFE)
         Builder opaquePart(Part opaquePart) {
            dsTaint.addTaint(opaquePart.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.opaquePart = opaquePart;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.785 -0400", hash_original_method = "B04C2A20C29308DA58A03AAA34E4602D", hash_generated_method = "1FEC1B7AADDD03383D6413C46BE02F04")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder opaquePart(String opaquePart) {
            dsTaint.addTaint(opaquePart);
            Builder var6C3A4A3671646F60B2AF9B53E066F6BC_1341236645 = (opaquePart(Part.fromDecoded(opaquePart)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return opaquePart(Part.fromDecoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.786 -0400", hash_original_method = "E3AC90668DB82124786DAC21400DF68F", hash_generated_method = "E2235B06162403F6F14461657CB36394")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedOpaquePart(String opaquePart) {
            dsTaint.addTaint(opaquePart);
            Builder var8A7656A3673A9500D87AF5DEA9CEF1BF_792324723 = (opaquePart(Part.fromEncoded(opaquePart)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return opaquePart(Part.fromEncoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.787 -0400", hash_original_method = "CE12FA6D2315F74B1A3B79C027FFFA6D", hash_generated_method = "7CCBB13AE4503A8C924EFC2530ECC7E0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.787 -0400", hash_original_method = "8B987B114EF487282F33A481DCB273CB", hash_generated_method = "9E0AB862710524B1E55F78FBA4FEA332")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder authority(String authority) {
            dsTaint.addTaint(authority);
            Builder varDD6B29B220B5C92FB846A00E677B7F82_138390787 = (authority(Part.fromDecoded(authority)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return authority(Part.fromDecoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.788 -0400", hash_original_method = "2AF9D1463857894BBB2A3B7E377A77BB", hash_generated_method = "9C1DB04B03655DC32AFBB776F02548C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedAuthority(String authority) {
            dsTaint.addTaint(authority);
            Builder var8B538EB5FC2B179B3080ECB7C6F21F0F_2015132442 = (authority(Part.fromEncoded(authority)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return authority(Part.fromEncoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.789 -0400", hash_original_method = "0552AFD7FA04CD9C4E588C7FB644B387", hash_generated_method = "338B97A9A246A7D99D1367485D0B677A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.789 -0400", hash_original_method = "311D5047B3596F1C34DEC3DA1D1264C5", hash_generated_method = "103EBFEE8205C6E7F0D803706D508471")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder path(String path) {
            dsTaint.addTaint(path);
            Builder varA5F05625DDAD196CC170EB6DA5B4DFDA_1233340672 = (path(PathPart.fromDecoded(path)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path(PathPart.fromDecoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.790 -0400", hash_original_method = "B2733F0C4852B782EB87F01613E6C574", hash_generated_method = "402AD3EBF972D631C718B78201792ED5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedPath(String path) {
            dsTaint.addTaint(path);
            Builder varD0BA09633109B9478118F9AE2074776C_1525792510 = (path(PathPart.fromEncoded(path)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path(PathPart.fromEncoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.792 -0400", hash_original_method = "818DCEC2192004BCFE40E4E49FDA7A4C", hash_generated_method = "5C8197BE98C28B0C03B30CBE4FB5EC0B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder appendPath(String newSegment) {
            dsTaint.addTaint(newSegment);
            Builder var263ED00DA704240B552F9A81223F16F4_2036749767 = (path(PathPart.appendDecodedSegment(path, newSegment)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path(PathPart.appendDecodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.793 -0400", hash_original_method = "04B6E07373B5BCB6E5F5541B11BC55A7", hash_generated_method = "8F19416318A41DC2EA2D74D2550C7447")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder appendEncodedPath(String newSegment) {
            dsTaint.addTaint(newSegment);
            Builder var281F32762F95F37C34A0CC29AE97CD9C_620265009 = (path(PathPart.appendEncodedSegment(path, newSegment)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return path(PathPart.appendEncodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.797 -0400", hash_original_method = "526B00AFFC674BC410AFF0DB5058AD68", hash_generated_method = "6BE1549C602978FFA1FC66818EE36449")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.798 -0400", hash_original_method = "915051404F16544BAB27A534573CC34D", hash_generated_method = "1EEABA2700DDBC571B83158F237C60AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder query(String query) {
            dsTaint.addTaint(query);
            Builder var4AF05161165E0ABC57C395852DCB6F65_104108701 = (query(Part.fromDecoded(query)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return query(Part.fromDecoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.800 -0400", hash_original_method = "2B1CFFF6E8520529FC529F01B5DBCD04", hash_generated_method = "275918A3E2765E639C732AFA3401976E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedQuery(String query) {
            dsTaint.addTaint(query);
            Builder var1CA62C78AE2CCF83DCEFD70594AC982D_812436624 = (query(Part.fromEncoded(query)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return query(Part.fromEncoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.801 -0400", hash_original_method = "AAD8E80453C4B46D11B41869FDCBA00D", hash_generated_method = "C15C23D064B9EC713A649918258B25FB")
        @DSModeled(DSC.SAFE)
         Builder fragment(Part fragment) {
            dsTaint.addTaint(fragment.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.fragment = fragment;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.802 -0400", hash_original_method = "016C309F39EF5D90CF32B95F6FDB27F8", hash_generated_method = "045802BF122AC16A39891AD933E8D53E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder fragment(String fragment) {
            dsTaint.addTaint(fragment);
            Builder var94241188A52CAF7F79ADDEFBBA9A2461_1667172812 = (fragment(Part.fromDecoded(fragment)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fragment(Part.fromDecoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.803 -0400", hash_original_method = "C5F51A11F0BEF63CCF4FD5F6AF742648", hash_generated_method = "2D23A199A7016D8A56EBF6CFC55CD2F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder encodedFragment(String fragment) {
            dsTaint.addTaint(fragment);
            Builder var74930B6AD7A89E8CA47E48EAC7892FD5_685062155 = (fragment(Part.fromEncoded(fragment)));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fragment(Part.fromEncoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.805 -0400", hash_original_method = "F83D70A0FC90543F01AB6385367098CC", hash_generated_method = "9DCEF7935D7BB82E05615A1D00A052A4")
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
                boolean varD871C9980587FFA401304C0008BE3177_1149963977 = (oldQuery == null || oldQuery.length() == 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.806 -0400", hash_original_method = "581A1CF068B5634C1F252DE7C2737E06", hash_generated_method = "09296D939643A02423BE58839FED59B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder clearQuery() {
            Builder var172750AB115CE806BDA046477A26E7D1_1828180596 = (query((Part) null));
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return query((Part) null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.829 -0400", hash_original_method = "C36CE5067F02DA1F1C7276BF67665A1B", hash_generated_method = "134E4449FA6E66073EBCF9AA4272C80E")
        @DSModeled(DSC.SPEC)
        public Uri build() {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                            "An opaque URI must have a scheme.");
                } //End block
                Uri varDDC564E4635F713C8E0A3548BDA67713_714383960 = (new OpaqueUri(scheme, opaquePart, fragment));
            } //End block
            {
                PathPart path;
                path = this.path;
                {
                    path = PathPart.EMPTY;
                } //End block
                {
                    {
                        boolean var2CA83CB1D078EAA23C6D98CE29904B75_1297764341 = (hasSchemeOrAuthority());
                        {
                            path = PathPart.makeAbsolute(path);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                Uri var6DB2CA31D38A9D45C84DAE40628015CE_296508485 = (new HierarchicalUri(
                        scheme, authority, path, query, fragment));
            } //End block
            return (Uri)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.831 -0400", hash_original_method = "7917AD3B49169A1AC8EEA7DD014B7E45", hash_generated_method = "EFD6B7E0939BB8A51AD1C203B08F5860")
        @DSModeled(DSC.SAFE)
        private boolean hasSchemeOrAuthority() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return scheme != null
                    //|| (authority != null && authority != Part.NULL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.835 -0400", hash_original_method = "50FC77E3DFFDDD2DB7D0B749912434F7", hash_generated_method = "52F5D2AA3FF75BA9671F0F77D6F88071")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var8C18A8F60159DED136B70CAF5F2BA8BA_25914017 = (build().toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return build().toString();
        }

        
    }


    
    static abstract class AbstractPart {
        volatile String encoded;
        volatile String decoded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.838 -0400", hash_original_method = "21E01F693530948BFE81E2C9AE8C6D31", hash_generated_method = "588F3B124544199FF8FA676E08E2D82F")
        @DSModeled(DSC.SAFE)
         AbstractPart(String encoded, String decoded) {
            dsTaint.addTaint(decoded);
            dsTaint.addTaint(encoded);
            // ---------- Original Method ----------
            //this.encoded = encoded;
            //this.decoded = decoded;
        }

        
        abstract String getEncoded();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.855 -0400", hash_original_method = "06323BBC323E7F59CEDDE1FAA04ED1F6", hash_generated_method = "1746AC8F96ABF27008788D19FA15365B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final String getDecoded() {
            @SuppressWarnings("StringEquality") boolean hasDecoded;
            hasDecoded = decoded != NOT_CACHED;
            {
                Object var52343EF1A0AE03CEC529642E146C7164_14381441 = ((decoded = decode(encoded)));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasDecoded = decoded != NOT_CACHED;
            //return hasDecoded ? decoded : (decoded = decode(encoded));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.859 -0400", hash_original_method = "BB7E54AFB81798C035BF3B3717F470E7", hash_generated_method = "5731B50AC66E71826FFF347FD5C6A03D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Neither encoded nor decoded");
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.860 -0400", hash_original_method = "0825D57E53D4DF2C8703C1BCAA3C7B3B", hash_generated_method = "0825D57E53D4DF2C8703C1BCAA3C7B3B")
                        public Representation ()
            {
            }


            static final int BOTH = 0;
            static final int ENCODED = 1;
            static final int DECODED = 2;
        }


        
    }


    
    static class Part extends AbstractPart {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.862 -0400", hash_original_method = "68B275EBA6010E5404727E121615E229", hash_generated_method = "DAE41E45C743F19C55F804F85A03498F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Part(String encoded, String decoded) {
            super(encoded, decoded);
            dsTaint.addTaint(decoded);
            dsTaint.addTaint(encoded);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.863 -0400", hash_original_method = "BD94DCCF5B44419F4498543CA74892E2", hash_generated_method = "6FCA15C54C341E8C053EEB6DD69ECA30")
        @DSModeled(DSC.SAFE)
         boolean isEmpty() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.865 -0400", hash_original_method = "74B8C999E422A266FD890BA259F6B43C", hash_generated_method = "EB4D0E32269E9EECDE44C7AE4F91A89E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded;
            hasEncoded = encoded != NOT_CACHED;
            {
                Object var65A0EA33726E1CAA970142E3851564A4_1398889012 = ((encoded = encode(decoded)));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded));
        }

        
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

        
        static Part nonNull(Part part) {
            return part == null ? NULL : part;
        }

        
        static Part fromEncoded(String encoded) {
            return from(encoded, NOT_CACHED);
        }

        
        static Part fromDecoded(String decoded) {
            return from(NOT_CACHED, decoded);
        }

        
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.866 -0400", hash_original_method = "D79C0256E86C850253FAE782AD9920ED", hash_generated_method = "B4841FB0D77E558BFF5A3946A15B0003")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public EmptyPart(String value) {
                super(value, value);
                dsTaint.addTaint(value);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.866 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "9A59452060804C67E6B80C8B599D6F31")
            @DSModeled(DSC.SAFE)
            @Override
             boolean isEmpty() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return true;
            }

            
        }


        
        static final Part NULL = new EmptyPart(null);
        static final Part EMPTY = new EmptyPart("");
    }


    
    static class PathPart extends AbstractPart {
        private PathSegments pathSegments;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.867 -0400", hash_original_method = "E8CA21F7072E8C7642F3BFF9454329AE", hash_generated_method = "C865675921FE820C5541843A0CCD01B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private PathPart(String encoded, String decoded) {
            super(encoded, decoded);
            dsTaint.addTaint(decoded);
            dsTaint.addTaint(encoded);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.868 -0400", hash_original_method = "EEE1C5D1C73794B2424FF9B6A794D8BE", hash_generated_method = "73B7B2B2F50EF644E236B17F0DDA8A96")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded;
            hasEncoded = encoded != NOT_CACHED;
            {
                Object varAEC42D21560FD4DA78EF91AA3282921F_1530157027 = ((encoded = encode(decoded, "/")));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded, "/"));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.884 -0400", hash_original_method = "BB12DAE5001652F9E9419E41FB496BCF", hash_generated_method = "C5FA7C59B4F7808F13C453F7F12303AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PathSegments getPathSegments() {
            String path;
            path = getEncoded();
            {
                PathSegments var9CB68C940CA264E9584BBC014A11EED3_2123963559 = (pathSegments = PathSegments.EMPTY);
            } //End block
            PathSegmentsBuilder segmentBuilder;
            segmentBuilder = new PathSegmentsBuilder();
            int previous;
            previous = 0;
            int current;
            {
                boolean varF3473A5176F979210C8BDFC961564284_1418733888 = ((current = path.indexOf('/', previous)) > -1);
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
                boolean var80E2BDF18328ED6FA29B39AB13CE0D97_814518129 = (previous < path.length());
                {
                    segmentBuilder.add(decode(path.substring(previous)));
                } //End block
            } //End collapsed parenthetic
            PathSegments varD19D4B91636879DCBCCCBA50FF177F1B_1189134717 = (pathSegments = segmentBuilder.build());
            return (PathSegments)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
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

        
        static PathPart appendDecodedSegment(PathPart oldPart, String decoded) {
            String encoded = encode(decoded);
            return appendEncodedSegment(oldPart, encoded);
        }

        
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
            return from(encoded, NOT_CACHED);
        }

        
        static PathPart fromDecoded(String decoded) {
            return from(NOT_CACHED, decoded);
        }

        
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
            return new PathPart(newEncoded, newDecoded);
        }

        
        static final PathPart NULL = new PathPart(null, null);
        static final PathPart EMPTY = new PathPart("", "");
    }


    
    // orphaned legacy method
    @DSModeled()
	public void writeToParcel(Parcel dest, int flags) {
		dest.dsTaint.addTaint(dsTaint);
	}
    
    // orphaned legacy method
    @DSModeled()
	public int describeContents() {
		return dsTaint.getTaintInt();
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
	public int compareTo(Uri arg0) {
		// TODO Auto-generated method stub
		return dsTaint.getTaintInt();
	}
    
    private static final String LOG = Uri.class.getSimpleName();
    @SuppressWarnings("RedundantStringConstructorCall") private static final String NOT_CACHED = new String("NOT CACHED");
    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL,
            PathPart.EMPTY, Part.NULL, Part.NULL);
    private final static int NOT_FOUND = -1;
    private final static int NOT_CALCULATED = -2;
    private static final String NOT_HIERARCHICAL
            = "This isn't a hierarchical URI.";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final int NULL_TYPE_ID = 0;
    public static final Parcelable.Creator<Uri> CREATOR = new Parcelable.Creator<Uri>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.893 -0400", hash_original_method = "1CCA462AB4D0EF409DF9173916BA5FD8", hash_generated_method = "FA0DC6B75E69BDA3809526FF12F91B80")
        @DSModeled(DSC.SPEC)
        public Uri createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int type;
            type = in.readInt();
            //Begin case StringUri.TYPE_ID 
            Uri var44595097F10EFD8AA530382151DF381B_1630610525 = (StringUri.readFrom(in));
            //End case StringUri.TYPE_ID 
            //Begin case OpaqueUri.TYPE_ID 
            Uri var622E4C21BF455B57E3B2C67BA2F80941_871597343 = (OpaqueUri.readFrom(in));
            //End case OpaqueUri.TYPE_ID 
            //Begin case HierarchicalUri.TYPE_ID 
            Uri varD89508D27841F514DC289F56EB993C58_250696686 = (HierarchicalUri.readFrom(in));
            //End case HierarchicalUri.TYPE_ID 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URI type: " + type);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.894 -0400", hash_original_method = "F0F0985DDECE05E12B4F154480B8ACF8", hash_generated_method = "604B3E037A2686467F70E3800B0BC2D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Uri[] newArray(int size) {
            dsTaint.addTaint(size);
            Uri[] var0A19078302170FA06C0F8C9826C72AA6_492732266 = (new Uri[size]);
            return (Uri[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Uri[size];
        }

        
        // orphaned legacy method
        @DSModeled()
	public void writeToParcel(Parcel dest, int flags) {
		dest.dsTaint.addTaint(dsTaint);
	}
        
        // orphaned legacy method
        @DSModeled()
	public int describeContents() {
		return dsTaint.getTaintInt();
	}
        
        // orphaned legacy method
        @DSModeled(DSC.SAFE)
	public int compareTo(Uri arg0) {
		// TODO Auto-generated method stub
		return dsTaint.getTaintInt();
	}
        
}; //Transformed anonymous class
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final byte[] REPLACEMENT = { (byte) 0xFF, (byte) 0xFD };
}

