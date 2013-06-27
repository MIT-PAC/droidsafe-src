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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.267 -0400", hash_original_method = "81E08B95735493D923725112C83DA27A", hash_generated_method = "AE17603DE8C4908F75692349E5C02303")
    private  Uri() {
        // ---------- Original Method ----------
    }

    
    public abstract boolean isHierarchical();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.269 -0400", hash_original_method = "A0C9F8427F648091A08345C72525BACA", hash_generated_method = "35976118052E3DBACCEC00FEFC1D83AC")
    public boolean isOpaque() {
        boolean var64B4064469A97508D22605F14516AC44_482867608 = (!isHierarchical());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306746636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306746636;
        // ---------- Original Method ----------
        //return !isHierarchical();
    }

    
    public abstract boolean isRelative();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.270 -0400", hash_original_method = "E92F08B9247EAC707F6805C228339DFA", hash_generated_method = "13CB5038E918E02F81939CDC14829CB8")
    public boolean isAbsolute() {
        boolean varFAE8C8CB7DF16B40F7BD3C8C56459E57_1540296044 = (!isRelative());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813353568 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813353568;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.307 -0400", hash_original_method = "FA9A408EEB8F8DAB44A912D276C5C2CC", hash_generated_method = "346D48C163BB34182FA59F2C2AED54EA")
    public boolean equals(Object o) {
        Uri other;
        other = (Uri) o;
        boolean varA0CF98E3EDF30C400FE114E3C4614876_604052802 = (toString().equals(other.toString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964384534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_964384534;
        // ---------- Original Method ----------
        //if (!(o instanceof Uri)) {
            //return false;
        //}
        //Uri other = (Uri) o;
        //return toString().equals(other.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.307 -0400", hash_original_method = "5AAF793CD4316640D385D37282629FDE", hash_generated_method = "2135806DD6F3455B68121FB0E9475760")
    public int hashCode() {
        int varFE9735C4A625FF797CCF16B0C7E4889C_943485337 = (toString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521521770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521521770;
        // ---------- Original Method ----------
        //return toString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.323 -0400", hash_original_method = "45EC734684FFFB3EE70A4C12F2A2F839", hash_generated_method = "80D63483B816ED47B0D2EC7657C23DEA")
    public int compareTo(Uri other) {
        int var9FDCE1533C4137A95AA1B9336AC2C904_921373246 = (toString().compareTo(other.toString()));
        addTaint(other.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519953187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519953187;
        // ---------- Original Method ----------
        //return toString().compareTo(other.toString());
    }

    
    public abstract String toString();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.354 -0400", hash_original_method = "C2346F0C89241A0BA21735401E86BD49", hash_generated_method = "2B20461A45B788E5DF4E4A2F165184A4")
    public String toSafeString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1400539121 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2128309997 = null; //Variable for return #2
        String scheme;
        scheme = getScheme();
        String ssp;
        ssp = getSchemeSpecificPart();
        {
            {
                boolean varECEC7553D0A8A9AA1C3551F50990F265_658658165 = (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip")
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
                            boolean var3701C9303431F43DBFBC3723803F56F1_2012124752 = (i<ssp.length());
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
                    varB4EAC82CA7396A68D541C85D26508E83_1400539121 = builder.toString();
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
        varB4EAC82CA7396A68D541C85D26508E83_2128309997 = builder.toString();
        String varA7E53CE21691AB073D9660D615818899_514283826; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_514283826 = varB4EAC82CA7396A68D541C85D26508E83_1400539121;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_514283826 = varB4EAC82CA7396A68D541C85D26508E83_2128309997;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_514283826.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_514283826;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract Builder buildUpon();

    
        public static Uri parse(String uriString) {
        return new StringUri(uriString);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.360 -0400", hash_original_method = "966FC11B97976C170B352F408FA2783F", hash_generated_method = "E97A0E64A53D70A7530FB22A08D3E197")
    public Set<String> getQueryParameterNames() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1239157224 = null; //Variable for return #1
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1465420658 = null; //Variable for return #2
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_1208515032 = (isOpaque());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } //End block
        } //End collapsed parenthetic
        String query;
        query = getEncodedQuery();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1239157224 = Collections.emptySet();
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
            boolean var9694734975A6FBE04042BED474B6D869_51915728 = (start < query.length());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1465420658 = Collections.unmodifiableSet(names);
        Set<String> varA7E53CE21691AB073D9660D615818899_84128683; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_84128683 = varB4EAC82CA7396A68D541C85D26508E83_1239157224;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_84128683 = varB4EAC82CA7396A68D541C85D26508E83_1465420658;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_84128683.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_84128683;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.391 -0400", hash_original_method = "9E05603A6F44EBCC73536B2584976016", hash_generated_method = "B6DC9BBF2B8FEBEF3578278A5B575520")
    public List<String> getQueryParameters(String key) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_2057842025 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1279961245 = null; //Variable for return #2
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_1234113255 = (isOpaque());
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
            varB4EAC82CA7396A68D541C85D26508E83_2057842025 = Collections.emptyList();
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
                boolean var178076B3E468B8639CBF96A33155F9A9_622032102 = (separator - start == encodedKey.length()
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
        varB4EAC82CA7396A68D541C85D26508E83_1279961245 = Collections.unmodifiableList(values);
        addTaint(key.getTaint());
        List<String> varA7E53CE21691AB073D9660D615818899_1369043710; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1369043710 = varB4EAC82CA7396A68D541C85D26508E83_2057842025;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1369043710 = varB4EAC82CA7396A68D541C85D26508E83_1279961245;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1369043710.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1369043710;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.463 -0400", hash_original_method = "72F6B0777F298E12957F6498D8B3E8F1", hash_generated_method = "4A90BEC3526049D33A1F8E05DB98902C")
    public String getQueryParameter(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_515382015 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_157235478 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1489480495 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1824418344 = null; //Variable for return #4
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_1555422084 = (isOpaque());
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
            varB4EAC82CA7396A68D541C85D26508E83_515382015 = null;
        } //End block
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
                boolean var178076B3E468B8639CBF96A33155F9A9_1953412793 = (separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length()));
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_157235478 = "";
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1489480495 = decode(query.substring(separator + 1, end));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                start = nextAmpersand + 1;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1824418344 = null;
        addTaint(key.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1662780197; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1662780197 = varB4EAC82CA7396A68D541C85D26508E83_515382015;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1662780197 = varB4EAC82CA7396A68D541C85D26508E83_157235478;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1662780197 = varB4EAC82CA7396A68D541C85D26508E83_1489480495;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1662780197 = varB4EAC82CA7396A68D541C85D26508E83_1824418344;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1662780197.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1662780197;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.464 -0400", hash_original_method = "67BE774C17CDAC836698DE4D6D994F1B", hash_generated_method = "9475B7C7AEB071CFBC74B2AD03C9A1DE")
    public boolean getBooleanQueryParameter(String key, boolean defaultValue) {
        String flag;
        flag = getQueryParameter(key);
        flag = flag.toLowerCase();
        boolean var1524D06912FA9A8910A3FA6431D6523F_1103986012 = ((!"false".equals(flag) && !"0".equals(flag)));
        addTaint(key.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190315052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_190315052;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.499 -0400", hash_original_field = "ACD4CFB867E9014EB5553B665A7654E7", hash_generated_field = "E4175460B78B44891D601990509D1265")

        private String uriString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.499 -0400", hash_original_field = "CAB1D5F863DB3FE1F854F1737D3BF567", hash_generated_field = "6ECAEC93E2396D17CA9FF61298DA11AE")

        private volatile int cachedSsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.499 -0400", hash_original_field = "0D27A2D8516BF4DCE688D48A00F04BF9", hash_generated_field = "6673040FAE4D4C35641720F36B224DA4")

        private volatile int cachedFsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.499 -0400", hash_original_field = "8FE13FA728B09DACBFC57E5751B51F48", hash_generated_field = "0E9D0B05543D9BBCEB78240FF4AE88F4")

        private volatile String scheme = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.499 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.499 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.500 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.500 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.500 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.504 -0400", hash_original_method = "6762E8F4F232397EC67D86B91A630B95", hash_generated_method = "A6C1825457AE7AF13DBEF010EABC8877")
        private  StringUri(String uriString) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uriString");
            } //End block
            this.uriString = uriString;
            // ---------- Original Method ----------
            //if (uriString == null) {
                //throw new NullPointerException("uriString");
            //}
            //this.uriString = uriString;
        }

        
                static Uri readFrom(Parcel parcel) {
            return new StringUri(parcel.readString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.505 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "595DFF0CA1E0EF28B0C3F6733D0DE165")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796762035 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796762035;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.506 -0400", hash_original_method = "C73A8428F9DA44091DF96EEDC1E3D3EF", hash_generated_method = "E60C4D7AA36A8DF226DE2DDB0065BC6D")
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(uriString);
            addTaint(parcel.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.511 -0400", hash_original_method = "F197955D6E3BAB1920F769AA2F97BBD7", hash_generated_method = "42BE3A2855C09CA132D1D5DD61895341")
        private int findSchemeSeparator() {
            {
                Object varE78ED6E23D41D918630374A89968E910_1858373268 = (cachedSsi = uriString.indexOf(':'));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273350214 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273350214;
            // ---------- Original Method ----------
            //return cachedSsi == NOT_CALCULATED
                    //? cachedSsi = uriString.indexOf(':')
                    //: cachedSsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.523 -0400", hash_original_method = "B0E1A879F11D02C30EC9FBB06F8801FE", hash_generated_method = "E0BD21440E84315C8E75B2CACE5F2A3C")
        private int findFragmentSeparator() {
            {
                Object var084C492FFBD239136C6656DB9FC43D6A_2017331336 = (cachedFsi = uriString.indexOf('#', findSchemeSeparator()));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427787221 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427787221;
            // ---------- Original Method ----------
            //return cachedFsi == NOT_CALCULATED
                    //? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    //: cachedFsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.524 -0400", hash_original_method = "11C2E375F5E033161AB2E06056D673CF", hash_generated_method = "3C59F99935E8708522449FEF702F8CE9")
        public boolean isHierarchical() {
            int ssi;
            ssi = findSchemeSeparator();
            {
                boolean var57F8854C12EA0628EE85E2310495F80A_1613625271 = (uriString.length() == ssi + 1);
            } //End collapsed parenthetic
            boolean var27890038C7ED583D3363BEF736C880EE_398822657 = (uriString.charAt(ssi + 1) == '/');
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202026386 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_202026386;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.529 -0400", hash_original_method = "DC1D040929AB7A4CF9A0DFBB95EA4283", hash_generated_method = "7E7BE089C84BBE9C41D117713D2E9D38")
        public boolean isRelative() {
            boolean var3202A358296F4617942997BACCC7AFC0_1343573918 = (findSchemeSeparator() == NOT_FOUND);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_531712545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_531712545;
            // ---------- Original Method ----------
            //return findSchemeSeparator() == NOT_FOUND;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.540 -0400", hash_original_method = "96667B7E38635C26F17AC80DC91F9ADB", hash_generated_method = "C17AF68C320E405ED8D7C9515058580C")
        public String getScheme() {
            String varB4EAC82CA7396A68D541C85D26508E83_470027903 = null; //Variable for return #1
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (scheme != NOT_CACHED);
            varB4EAC82CA7396A68D541C85D26508E83_470027903 = cached ? scheme : (scheme = parseScheme());
            varB4EAC82CA7396A68D541C85D26508E83_470027903.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_470027903;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (scheme != NOT_CACHED);
            //return cached ? scheme : (scheme = parseScheme());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.541 -0400", hash_original_method = "B03A2C85823E1DE38C77FC40695B0CC7", hash_generated_method = "6EC42BE4F9F7E79B3D28141AAB199823")
        private String parseScheme() {
            String varB4EAC82CA7396A68D541C85D26508E83_523094076 = null; //Variable for return #1
            int ssi;
            ssi = findSchemeSeparator();
            varB4EAC82CA7396A68D541C85D26508E83_523094076 = ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
            varB4EAC82CA7396A68D541C85D26508E83_523094076.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_523094076;
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //return ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.543 -0400", hash_original_method = "DE43C7F499D5F1739936552A95AA2492", hash_generated_method = "808132BABC4EACAAA4FB7C3B4EBAEE59")
        private Part getSsp() {
            Part varB4EAC82CA7396A68D541C85D26508E83_1822973583 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1822973583 = ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
            varB4EAC82CA7396A68D541C85D26508E83_1822973583.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1822973583;
            // ---------- Original Method ----------
            //return ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.556 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "41DB6DE15D69302E49A5C81CCC66AD48")
        public String getEncodedSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_1708204106 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1708204106 = getSsp().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1708204106.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1708204106;
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.558 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "60C0D8E769218668D4740825B8F199F8")
        public String getSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_1439809291 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1439809291 = getSsp().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1439809291.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1439809291;
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.573 -0400", hash_original_method = "6082AC88F53E9B67D59D9A72041A5D6F", hash_generated_method = "4DECF03445CB8323C943701AF9EFCDF9")
        private String parseSsp() {
            String varB4EAC82CA7396A68D541C85D26508E83_1057023453 = null; //Variable for return #1
            int ssi;
            ssi = findSchemeSeparator();
            int fsi;
            fsi = findFragmentSeparator();
            varB4EAC82CA7396A68D541C85D26508E83_1057023453 = fsi == NOT_FOUND
                    ? uriString.substring(ssi + 1)
                    : uriString.substring(ssi + 1, fsi);
            varB4EAC82CA7396A68D541C85D26508E83_1057023453.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1057023453;
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND
                    //? uriString.substring(ssi + 1)
                    //: uriString.substring(ssi + 1, fsi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.574 -0400", hash_original_method = "C2AABBF6273BD8549508A0ABF072F220", hash_generated_method = "78A57D20AB62BFA4CE748F296AE97772")
        private Part getAuthorityPart() {
            Part varB4EAC82CA7396A68D541C85D26508E83_1313036251 = null; //Variable for return #1
            Part varB4EAC82CA7396A68D541C85D26508E83_1194771009 = null; //Variable for return #2
            {
                String encodedAuthority;
                encodedAuthority = parseAuthority(this.uriString, findSchemeSeparator());
                varB4EAC82CA7396A68D541C85D26508E83_1313036251 = authority = Part.fromEncoded(encodedAuthority);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1194771009 = authority;
            Part varA7E53CE21691AB073D9660D615818899_1608105529; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1608105529 = varB4EAC82CA7396A68D541C85D26508E83_1313036251;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1608105529 = varB4EAC82CA7396A68D541C85D26508E83_1194771009;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1608105529.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1608105529;
            // ---------- Original Method ----------
            //if (authority == null) {
                //String encodedAuthority
                        //= parseAuthority(this.uriString, findSchemeSeparator());
                //return authority = Part.fromEncoded(encodedAuthority);
            //}
            //return authority;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.575 -0400", hash_original_method = "B783FB869F9CE6B897E37C2A9B9B4259", hash_generated_method = "5142AB8BA0705859D568AAE8FF9E2857")
        public String getEncodedAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_271035908 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_271035908 = getAuthorityPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_271035908.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_271035908;
            // ---------- Original Method ----------
            //return getAuthorityPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.577 -0400", hash_original_method = "F4404025FB90C68980598D2895AF9578", hash_generated_method = "E16D5C68158B69BBC0B2B5778FEFB808")
        public String getAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_1286427897 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1286427897 = getAuthorityPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1286427897.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1286427897;
            // ---------- Original Method ----------
            //return getAuthorityPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.577 -0400", hash_original_method = "483C19AAE407B7D6148F370745A1893E", hash_generated_method = "7B87CC556FB0644E0A3CFE1995C3B8A7")
        private PathPart getPathPart() {
            PathPart varB4EAC82CA7396A68D541C85D26508E83_1303855291 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1303855291 = path == null
                    ? path = PathPart.fromEncoded(parsePath())
                    : path;
            varB4EAC82CA7396A68D541C85D26508E83_1303855291.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1303855291;
            // ---------- Original Method ----------
            //return path == null
                    //? path = PathPart.fromEncoded(parsePath())
                    //: path;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.578 -0400", hash_original_method = "E8759FDECF433DBBFF0BA03CF3576CC0", hash_generated_method = "1B876F2CEBD5BD3D2AA02E47E0D4F9BA")
        public String getPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1013482117 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1013482117 = getPathPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1013482117.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1013482117;
            // ---------- Original Method ----------
            //return getPathPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.592 -0400", hash_original_method = "D26AFC1B9D9DFA82513D9A4C50DD2F0F", hash_generated_method = "0E05D357376B1416EF0CCF2949F9B111")
        public String getEncodedPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1494944500 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1494944500 = getPathPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1494944500.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1494944500;
            // ---------- Original Method ----------
            //return getPathPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.593 -0400", hash_original_method = "A1BA2B8DCFFB301EABC725C63F487DC2", hash_generated_method = "D118F9BF044DEBBEBA10DDB103B32040")
        public List<String> getPathSegments() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_464102664 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_464102664 = getPathPart().getPathSegments();
            varB4EAC82CA7396A68D541C85D26508E83_464102664.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_464102664;
            // ---------- Original Method ----------
            //return getPathPart().getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.607 -0400", hash_original_method = "EF0989C68625FC2F46DE0EA4CB35660B", hash_generated_method = "60BC61F5462D1E4F3548EAEA1351392E")
        private String parsePath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1251363028 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_2132215264 = null; //Variable for return #2
            String varB4EAC82CA7396A68D541C85D26508E83_1630272913 = null; //Variable for return #3
            String uriString;
            uriString = this.uriString;
            int ssi;
            ssi = findSchemeSeparator();
            {
                boolean schemeOnly;
                schemeOnly = ssi + 1 == uriString.length();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1251363028 = null;
                } //End block
                {
                    boolean varD917EE6A3AF74F85327A628F817BD281_1809757323 = (uriString.charAt(ssi + 1) != '/');
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2132215264 = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1630272913 = parsePath(uriString, ssi);
            String varA7E53CE21691AB073D9660D615818899_1807289216; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1807289216 = varB4EAC82CA7396A68D541C85D26508E83_1251363028;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1807289216 = varB4EAC82CA7396A68D541C85D26508E83_2132215264;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1807289216 = varB4EAC82CA7396A68D541C85D26508E83_1630272913;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1807289216.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1807289216;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.607 -0400", hash_original_method = "5338F6D0AC99191764C2394A710C873F", hash_generated_method = "66EAD5ECBC1A0675C4F95200C4467FD3")
        private Part getQueryPart() {
            Part varB4EAC82CA7396A68D541C85D26508E83_1604842708 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1604842708 = query == null
                    ? query = Part.fromEncoded(parseQuery()) : query;
            varB4EAC82CA7396A68D541C85D26508E83_1604842708.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1604842708;
            // ---------- Original Method ----------
            //return query == null
                    //? query = Part.fromEncoded(parseQuery()) : query;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.626 -0400", hash_original_method = "61892B739321CB796D242E9E13C1F033", hash_generated_method = "6348542905875CCB2BEC8324D5C8604F")
        public String getEncodedQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_1105280309 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1105280309 = getQueryPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1105280309.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1105280309;
            // ---------- Original Method ----------
            //return getQueryPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.629 -0400", hash_original_method = "93492ABD4F9B88C963E84B9F545E5D11", hash_generated_method = "A345517A97B14C9B8584538EC03C846B")
        private String parseQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_1357073978 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_208140844 = null; //Variable for return #2
            String varB4EAC82CA7396A68D541C85D26508E83_764620132 = null; //Variable for return #3
            String varB4EAC82CA7396A68D541C85D26508E83_383323309 = null; //Variable for return #4
            int qsi;
            qsi = uriString.indexOf('?', findSchemeSeparator());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1357073978 = null;
            } //End block
            int fsi;
            fsi = findFragmentSeparator();
            {
                varB4EAC82CA7396A68D541C85D26508E83_208140844 = uriString.substring(qsi + 1);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_764620132 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_383323309 = uriString.substring(qsi + 1, fsi);
            String varA7E53CE21691AB073D9660D615818899_1190047827; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1190047827 = varB4EAC82CA7396A68D541C85D26508E83_1357073978;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1190047827 = varB4EAC82CA7396A68D541C85D26508E83_208140844;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1190047827 = varB4EAC82CA7396A68D541C85D26508E83_764620132;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1190047827 = varB4EAC82CA7396A68D541C85D26508E83_383323309;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1190047827.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1190047827;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.629 -0400", hash_original_method = "31EC40ABD8B86D0064329950E060BFBD", hash_generated_method = "2772091D3696F05929B1D459A6960BE0")
        public String getQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_1511368695 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1511368695 = getQueryPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1511368695.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1511368695;
            // ---------- Original Method ----------
            //return getQueryPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.641 -0400", hash_original_method = "EAD370CB1FE781DF1864471D9F5F3E36", hash_generated_method = "2A72A6C6590A6ED603CDD5B2E13914AF")
        private Part getFragmentPart() {
            Part varB4EAC82CA7396A68D541C85D26508E83_1208805570 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1208805570 = fragment == null
                    ? fragment = Part.fromEncoded(parseFragment()) : fragment;
            varB4EAC82CA7396A68D541C85D26508E83_1208805570.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1208805570;
            // ---------- Original Method ----------
            //return fragment == null
                    //? fragment = Part.fromEncoded(parseFragment()) : fragment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.642 -0400", hash_original_method = "C2884F3C25114B1CD652E8CCEF7D7F10", hash_generated_method = "FB4609C84414E5EE2E5BC61CD90E65B3")
        public String getEncodedFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_1187829311 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1187829311 = getFragmentPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1187829311.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1187829311;
            // ---------- Original Method ----------
            //return getFragmentPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.643 -0400", hash_original_method = "13965C7143AC0E622773DBA6AE062E67", hash_generated_method = "A6580CDF01F5268CE80EB53A5FC46FBA")
        private String parseFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_267380257 = null; //Variable for return #1
            int fsi;
            fsi = findFragmentSeparator();
            varB4EAC82CA7396A68D541C85D26508E83_267380257 = fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
            varB4EAC82CA7396A68D541C85D26508E83_267380257.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_267380257;
            // ---------- Original Method ----------
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.647 -0400", hash_original_method = "4E8163B4F7FDF9829581A99F6274656D", hash_generated_method = "642C4A030AA4891D3138C51530D9AE7C")
        public String getFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_771621027 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_771621027 = getFragmentPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_771621027.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_771621027;
            // ---------- Original Method ----------
            //return getFragmentPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.648 -0400", hash_original_method = "ECB4588CBE3D957B88D2558A4C044374", hash_generated_method = "B49DF6A2506FFC5A5904A41A9A05FA3F")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1661809876 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1661809876 = uriString;
            varB4EAC82CA7396A68D541C85D26508E83_1661809876.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1661809876;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.664 -0400", hash_original_method = "54B78C0DD1C850213ABB66143A4F5DE7", hash_generated_method = "DD63CE9C2C2BC264D05008E507E446B8")
        public Builder buildUpon() {
            Builder varB4EAC82CA7396A68D541C85D26508E83_662235842 = null; //Variable for return #1
            Builder varB4EAC82CA7396A68D541C85D26508E83_314594612 = null; //Variable for return #2
            {
                boolean varDDDEF883E55C0067D538DC62E8B8900F_767854981 = (isHierarchical());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_662235842 = new Builder()
                        .scheme(getScheme())
                        .authority(getAuthorityPart())
                        .path(getPathPart())
                        .query(getQueryPart())
                        .fragment(getFragmentPart());
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_314594612 = new Builder()
                        .scheme(getScheme())
                        .opaquePart(getSsp())
                        .fragment(getFragmentPart());
                } //End block
            } //End collapsed parenthetic
            Builder varA7E53CE21691AB073D9660D615818899_615693776; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_615693776 = varB4EAC82CA7396A68D541C85D26508E83_662235842;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_615693776 = varB4EAC82CA7396A68D541C85D26508E83_314594612;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_615693776.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_615693776;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.668 -0400", hash_original_field = "B0493B2AFC6F39450B0E6998DDC76696", hash_generated_field = "B20ED70ADEB548567D793C434972614A")

        static int TYPE_ID = 1;
    }


    
    private static class OpaqueUri extends Uri {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.669 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.669 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.669 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.669 -0400", hash_original_field = "E4D7B1085B3F20D4D3076206156621A1", hash_generated_field = "FCCD4A0FFBA55911A49FB2AEB7548D00")

        private volatile String cachedString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.674 -0400", hash_original_method = "A3EB90F61BB5DAD9A21709AA9F976DF8", hash_generated_method = "06AECF8220C181EEDE6CDB73AC6F3E82")
        private  OpaqueUri(String scheme, Part ssp, Part fragment) {
            this.scheme = scheme;
            this.ssp = ssp;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.675 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "51E2B64D743566A2A8BC94DAB8EE859C")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37798922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37798922;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.690 -0400", hash_original_method = "8F996E53ADCFC30BFF794C5CEED4DA61", hash_generated_method = "5EFDF35B09A0841810BA9C760D12E8B5")
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(scheme);
            ssp.writeTo(parcel);
            fragment.writeTo(parcel);
            addTaint(parcel.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(scheme);
            //ssp.writeTo(parcel);
            //fragment.writeTo(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.691 -0400", hash_original_method = "414EEC63B62C24CE4C288B4F88575946", hash_generated_method = "BE5EAD67F0FE9DA13D782931D64FD240")
        public boolean isHierarchical() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123131850 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123131850;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.696 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "E1E51B5882AE1538B1F64F92EB7CB49D")
        public boolean isRelative() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_410011331 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_410011331;
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.701 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "1029E945DA75232981287A14A76D29F7")
        public String getScheme() {
            String varB4EAC82CA7396A68D541C85D26508E83_1463754352 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1463754352 = this.scheme;
            varB4EAC82CA7396A68D541C85D26508E83_1463754352.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1463754352;
            // ---------- Original Method ----------
            //return this.scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.701 -0400", hash_original_method = "3C55B6D4F736410AF7A2ACAB5CCC51ED", hash_generated_method = "4A02433EE7CA2D32D9FF857CDD119515")
        public String getEncodedSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_273446994 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_273446994 = ssp.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_273446994.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_273446994;
            // ---------- Original Method ----------
            //return ssp.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.706 -0400", hash_original_method = "ED3540C8D06E41CD645C58A620F36381", hash_generated_method = "C1E9A708C0BE3D69B40B695E25E6D8E2")
        public String getSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_1292224677 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1292224677 = ssp.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1292224677.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1292224677;
            // ---------- Original Method ----------
            //return ssp.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.707 -0400", hash_original_method = "31E41E1CB0338F9BAA50A0AC05D7D02D", hash_generated_method = "620D92C4A312794B2DE99F3B071209C3")
        public String getAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_1484803101 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1484803101 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1484803101.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1484803101;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.729 -0400", hash_original_method = "C6F3CA63C6BE518EBD2AA32E2786DD3A", hash_generated_method = "6E2599B960519B838F8CFA18BEBBB44C")
        public String getEncodedAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_1234990030 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1234990030 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1234990030.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1234990030;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.730 -0400", hash_original_method = "F489014FCD27D67260CBEC8AC84559A2", hash_generated_method = "02364F029597FFB28535933DE269A4FB")
        public String getPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1949127243 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1949127243 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1949127243.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1949127243;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.731 -0400", hash_original_method = "F167E35F53D1A5A8B17A8A72FE8359AE", hash_generated_method = "071ECDFE45C51E4A19B74AA80B677477")
        public String getEncodedPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1399879122 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1399879122 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1399879122.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1399879122;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.731 -0400", hash_original_method = "2E34959E1DD3631C67E93F1AE6B31056", hash_generated_method = "FFE707E928AB30791A615214E2991F9F")
        public String getQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_1413095322 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1413095322 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1413095322.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1413095322;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.732 -0400", hash_original_method = "53661DD2D38C9C2E00E8B8D2FF316BB7", hash_generated_method = "C5504FF4D408C91277DBD62888FEFF3D")
        public String getEncodedQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_1452075356 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1452075356 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1452075356.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1452075356;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.737 -0400", hash_original_method = "9F53DDCB73E71AFF4CF207B49D0689B3", hash_generated_method = "ECA79887A94F9A100B695A0D4B018E75")
        public String getFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_1655574915 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1655574915 = fragment.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1655574915.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1655574915;
            // ---------- Original Method ----------
            //return fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.754 -0400", hash_original_method = "2FF982E252638134744EE32C0D7F6950", hash_generated_method = "ABC1259F562AE64650A29A85DF929D2E")
        public String getEncodedFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_2007905324 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2007905324 = fragment.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_2007905324.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2007905324;
            // ---------- Original Method ----------
            //return fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.755 -0400", hash_original_method = "08B329AF4FAA2768183F76EC45288C10", hash_generated_method = "772614407829B3A3ADC9CCB098DAD240")
        public List<String> getPathSegments() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_1222053122 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1222053122 = Collections.emptyList();
            varB4EAC82CA7396A68D541C85D26508E83_1222053122.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1222053122;
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.756 -0400", hash_original_method = "AE7FF2A9DFCB643CF70873B2C08CD5A8", hash_generated_method = "CEDEC85596EBE5E016670368D2C191C1")
        public String getLastPathSegment() {
            String varB4EAC82CA7396A68D541C85D26508E83_2070499793 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2070499793 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2070499793.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2070499793;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.756 -0400", hash_original_method = "520FB960E4127ABC7143DD06EFB52356", hash_generated_method = "F7D261682E35E5A9F7E4B89E3B4A0F8D")
        public String getUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_1110215679 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1110215679 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1110215679.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1110215679;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.761 -0400", hash_original_method = "88ECB0B5D6F4AA907FC3666F8C1418EB", hash_generated_method = "6FDE7ED6C833471BD71B5600220D545C")
        public String getEncodedUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_790256155 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_790256155 = null;
            varB4EAC82CA7396A68D541C85D26508E83_790256155.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_790256155;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.777 -0400", hash_original_method = "00C71B0865F91AE7EF71B7BE21B14B9F", hash_generated_method = "E6B64411753C344925F204C5FFFEDA7C")
        public String getHost() {
            String varB4EAC82CA7396A68D541C85D26508E83_1713096263 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1713096263 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1713096263.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1713096263;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.777 -0400", hash_original_method = "B159430668427C6760C3FB4B772D9F59", hash_generated_method = "AE2F00BD1BA214D09338F8BA961D99E8")
        public int getPort() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114273361 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114273361;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.779 -0400", hash_original_method = "ACF28BE5516AF44175C2E6962FB03404", hash_generated_method = "C0D48CE3400C579960C846326C524A05")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_226809472 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_186524148 = null; //Variable for return #2
            @SuppressWarnings("StringEquality") boolean cached;
            cached = cachedString != NOT_CACHED;
            {
                varB4EAC82CA7396A68D541C85D26508E83_226809472 = cachedString;
            } //End block
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append(scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());
            {
                boolean varC8C86438344E58844BC399B4194DB415_289594841 = (!fragment.isEmpty());
                {
                    sb.append('#').append(fragment.getEncoded());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_186524148 = cachedString = sb.toString();
            String varA7E53CE21691AB073D9660D615818899_671141404; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_671141404 = varB4EAC82CA7396A68D541C85D26508E83_226809472;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_671141404 = varB4EAC82CA7396A68D541C85D26508E83_186524148;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_671141404.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_671141404;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.781 -0400", hash_original_method = "9B1777E9DAB1C1ED3319A4EEC33BCB54", hash_generated_method = "B77510C77EF72702D7C71F6340B0CD70")
        public Builder buildUpon() {
            Builder varB4EAC82CA7396A68D541C85D26508E83_104284630 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_104284630 = new Builder()
                    .scheme(this.scheme)
                    .opaquePart(this.ssp)
                    .fragment(this.fragment);
            varB4EAC82CA7396A68D541C85D26508E83_104284630.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_104284630;
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(this.scheme)
                    //.opaquePart(this.ssp)
                    //.fragment(this.fragment);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.784 -0400", hash_original_field = "404FF43CFEE8747368BFDA1DC5DB3B28", hash_generated_field = "F3FBA7B249D24D5355C3AA38935068D2")

        static int TYPE_ID = 2;
    }


    
    static class PathSegments extends AbstractList<String> implements RandomAccess {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.785 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.785 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

        int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.794 -0400", hash_original_method = "816AFE27D6484B7E80593A248F7DEC12", hash_generated_method = "F2AFBC317E49E2BF0F98B0C5AE8378FC")
          PathSegments(String[] segments, int size) {
            this.segments = segments;
            this.size = size;
            // ---------- Original Method ----------
            //this.segments = segments;
            //this.size = size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.799 -0400", hash_original_method = "043CF25E38E9D3A71BE4CC7B6371568E", hash_generated_method = "71D4D434E42F294CE236BB8C18353C61")
        public String get(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_2636340 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2636340 = segments[index];
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2636340.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2636340;
            // ---------- Original Method ----------
            //if (index >= size) {
                //throw new IndexOutOfBoundsException();
            //}
            //return segments[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.800 -0400", hash_original_method = "BAF1AF8B1284BE94C387C840AF9FA265", hash_generated_method = "9C98C2E0FC2EC98C1593F70CE9C22936")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_965303000 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_965303000;
            // ---------- Original Method ----------
            //return this.size;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.803 -0400", hash_original_field = "F2217D1D8C4EF2C438C5D90B83E3AD42", hash_generated_field = "69F60209E828DA9026969A916E1F8FA0")

        static PathSegments EMPTY = new PathSegments(null, 0);
    }


    
    static class PathSegmentsBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.803 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.803 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

        int size = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.803 -0400", hash_original_method = "CD5B4727D6775EBFE00461F5F237812D", hash_generated_method = "CD5B4727D6775EBFE00461F5F237812D")
        public PathSegmentsBuilder ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.812 -0400", hash_original_method = "F05B9B5ECB44DE7CFF27782486F28CF3", hash_generated_method = "74F7C03E29417F2B866971828F2CC6A6")
         void add(String segment) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.831 -0400", hash_original_method = "497F2229989230601A3120EEAF21B251", hash_generated_method = "C60DD34CD4D4D49316E02AF2A8A0A9CF")
         PathSegments build() {
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_90116188 = null; //Variable for return #1
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_1084919501 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_90116188 = PathSegments.EMPTY;
            } //End block
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1084919501 = new PathSegments(segments, size);
            } //End block
            finally 
            {
                segments = null;
            } //End block
            PathSegments varA7E53CE21691AB073D9660D615818899_1498461977; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1498461977 = varB4EAC82CA7396A68D541C85D26508E83_90116188;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1498461977 = varB4EAC82CA7396A68D541C85D26508E83_1084919501;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1498461977.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1498461977;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.831 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "87B54E118334D4593A462325E6A65F84")

        private Part userInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.831 -0400", hash_original_field = "38B3753700D5B450CB30995B4DB5AF95", hash_generated_field = "539F6E6D25356608852D958A8481FDA5")

        private volatile String host = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.831 -0400", hash_original_field = "38113C68733F87156C438BEBC2FCB827", hash_generated_field = "3DEE2B327E62FC31F0BA9783EFE62CA9")

        private volatile int port = NOT_CALCULATED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.832 -0400", hash_original_method = "469DE423ED30903E9EDD58224AA80D56", hash_generated_method = "469DE423ED30903E9EDD58224AA80D56")
        public AbstractHierarchicalUri ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.836 -0400", hash_original_method = "D5E71CFA6EED35AEB9B5F4AEC5287C3B", hash_generated_method = "75AF49DFFCC454DF4040589C6F6B2F1B")
        public String getLastPathSegment() {
            String varB4EAC82CA7396A68D541C85D26508E83_768017764 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1811352715 = null; //Variable for return #2
            List<String> segments;
            segments = getPathSegments();
            int size;
            size = segments.size();
            {
                varB4EAC82CA7396A68D541C85D26508E83_768017764 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1811352715 = segments.get(size - 1);
            String varA7E53CE21691AB073D9660D615818899_1497312446; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1497312446 = varB4EAC82CA7396A68D541C85D26508E83_768017764;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1497312446 = varB4EAC82CA7396A68D541C85D26508E83_1811352715;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1497312446.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1497312446;
            // ---------- Original Method ----------
            //List<String> segments = getPathSegments();
            //int size = segments.size();
            //if (size == 0) {
                //return null;
            //}
            //return segments.get(size - 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.837 -0400", hash_original_method = "739BBE935CAE826F3703E2BBB77B819C", hash_generated_method = "3DA56DFCEE42448565333C26A7BCDF34")
        private Part getUserInfoPart() {
            Part varB4EAC82CA7396A68D541C85D26508E83_2117173898 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2117173898 = userInfo == null
                    ? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
            varB4EAC82CA7396A68D541C85D26508E83_2117173898.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2117173898;
            // ---------- Original Method ----------
            //return userInfo == null
                    //? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.856 -0400", hash_original_method = "EADAAD26DC8689BCA10DCA33883B9323", hash_generated_method = "C58B0EB0AC92BC132D37F5163A868FA5")
        public final String getEncodedUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_1988787882 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1988787882 = getUserInfoPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1988787882.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1988787882;
            // ---------- Original Method ----------
            //return getUserInfoPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.857 -0400", hash_original_method = "10E379B7D06266EDAAC672E10EB0F58B", hash_generated_method = "CEA37CA667C47FB882DCDCFE460DAC79")
        private String parseUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_1987580290 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_181767816 = null; //Variable for return #2
            String authority;
            authority = getEncodedAuthority();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1987580290 = null;
            } //End block
            int end;
            end = authority.indexOf('@');
            varB4EAC82CA7396A68D541C85D26508E83_181767816 = end == NOT_FOUND ? null : authority.substring(0, end);
            String varA7E53CE21691AB073D9660D615818899_1820485313; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1820485313 = varB4EAC82CA7396A68D541C85D26508E83_1987580290;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1820485313 = varB4EAC82CA7396A68D541C85D26508E83_181767816;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1820485313.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1820485313;
            // ---------- Original Method ----------
            //String authority = getEncodedAuthority();
            //if (authority == null) {
                //return null;
            //}
            //int end = authority.indexOf('@');
            //return end == NOT_FOUND ? null : authority.substring(0, end);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.858 -0400", hash_original_method = "575ECF6860F7EEFE5055BF56F2601A0E", hash_generated_method = "C54AFD0D770FAA590E580C270CFA0D72")
        public String getUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_967600170 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_967600170 = getUserInfoPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_967600170.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_967600170;
            // ---------- Original Method ----------
            //return getUserInfoPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.876 -0400", hash_original_method = "2FC22A6CCA0A3F4C0B9E4C09F79A556D", hash_generated_method = "AD97229BB51800A52AB4A794AA9CA197")
        public String getHost() {
            String varB4EAC82CA7396A68D541C85D26508E83_1258709173 = null; //Variable for return #1
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (host != NOT_CACHED);
            varB4EAC82CA7396A68D541C85D26508E83_1258709173 = cached ? host
                    : (host = parseHost());
            varB4EAC82CA7396A68D541C85D26508E83_1258709173.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1258709173;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (host != NOT_CACHED);
            //return cached ? host
                    //: (host = parseHost());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.879 -0400", hash_original_method = "F3410DE0DFF96D0677FF54552E852FC4", hash_generated_method = "C0A1003C481F87398D23D3BFBB3EE35B")
        private String parseHost() {
            String varB4EAC82CA7396A68D541C85D26508E83_2038012571 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_135539708 = null; //Variable for return #2
            String authority;
            authority = getEncodedAuthority();
            {
                varB4EAC82CA7396A68D541C85D26508E83_2038012571 = null;
            } //End block
            int userInfoSeparator;
            userInfoSeparator = authority.indexOf('@');
            int portSeparator;
            portSeparator = authority.indexOf(':', userInfoSeparator);
            String encodedHost;
            encodedHost = authority.substring(userInfoSeparator + 1);
            encodedHost = authority.substring(userInfoSeparator + 1, portSeparator);
            varB4EAC82CA7396A68D541C85D26508E83_135539708 = decode(encodedHost);
            String varA7E53CE21691AB073D9660D615818899_927033818; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_927033818 = varB4EAC82CA7396A68D541C85D26508E83_2038012571;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_927033818 = varB4EAC82CA7396A68D541C85D26508E83_135539708;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_927033818.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_927033818;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.880 -0400", hash_original_method = "A497EF38F72042FD9397DCB617BC4BBC", hash_generated_method = "A5871551F7D4067FB4A5759FC70A331E")
        public int getPort() {
            {
                Object varD4A5E1084DDC786A109466698FB6E902_1041193862 = (port = parsePort());
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522660591 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522660591;
            // ---------- Original Method ----------
            //return port == NOT_CALCULATED
                    //? port = parsePort()
                    //: port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.881 -0400", hash_original_method = "5469820A1C15A09B87242C85BC223022", hash_generated_method = "7700D188F0299DAC8C4C22E83A847A3D")
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
                int var9090A94059B9013CFD764DB303CCFFD1_1086510585 = (Integer.parseInt(portString));
            } //End block
            catch (NumberFormatException e)
            { }
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807642479 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807642479;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.881 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.881 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.881 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.881 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.881 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.881 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.882 -0400", hash_original_field = "2BBB7D14660BA196C018E7EF1E07014A", hash_generated_field = "9968E15A97464199002C3D2A70E60BF1")

        private volatile String uriString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.899 -0400", hash_original_method = "4B8A4922E90F4F5C5F11CB942A244C7D", hash_generated_method = "68A9127EDB06137E28202F2E575DFD47")
        private  HierarchicalUri(String scheme, Part authority, PathPart path,
                Part query, Part fragment) {
            this.scheme = scheme;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.917 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AC0EFFA932AAB953CD3CC5A81F2D5C61")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907012137 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907012137;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.918 -0400", hash_original_method = "601AB6BE7C1B16F2DB83E078DF9B61DC", hash_generated_method = "416E2535268A9AE550DD9A5E30CAFE39")
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(scheme);
            authority.writeTo(parcel);
            path.writeTo(parcel);
            query.writeTo(parcel);
            fragment.writeTo(parcel);
            addTaint(parcel.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(scheme);
            //authority.writeTo(parcel);
            //path.writeTo(parcel);
            //query.writeTo(parcel);
            //fragment.writeTo(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.918 -0400", hash_original_method = "3471DB7575AAB7FBFD2140BF4AB89F77", hash_generated_method = "8E9AC9488FE57F687668D9453F8199D3")
        public boolean isHierarchical() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805730681 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_805730681;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.919 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "14681FE74C9F9DF2A8A6A29A4A1088F6")
        public boolean isRelative() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880484646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880484646;
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.920 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "E0B9C5468AEF88D9B9EBA13C151B1DF7")
        public String getScheme() {
            String varB4EAC82CA7396A68D541C85D26508E83_1721752814 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1721752814 = scheme;
            varB4EAC82CA7396A68D541C85D26508E83_1721752814.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1721752814;
            // ---------- Original Method ----------
            //return scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.936 -0400", hash_original_method = "6F57A7CA1E43F50667C0921A8F0F4C1E", hash_generated_method = "C5F4CECC3DDC66A6AB91BF8B6FC9003F")
        private Part getSsp() {
            Part varB4EAC82CA7396A68D541C85D26508E83_1081406402 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1081406402 = ssp == null
                    ? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
            varB4EAC82CA7396A68D541C85D26508E83_1081406402.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1081406402;
            // ---------- Original Method ----------
            //return ssp == null
                    //? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.937 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "ED79DD1874FBCFC6428D1C92C44BA044")
        public String getEncodedSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_1920041480 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1920041480 = getSsp().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1920041480.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1920041480;
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.937 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "84A3AED50FECCE794A3382880F6E3F56")
        public String getSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_194664473 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_194664473 = getSsp().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_194664473.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_194664473;
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.938 -0400", hash_original_method = "EA75444742B675900BB1383BC22E224C", hash_generated_method = "813600C778B206667D4762C21C633761")
        private String makeSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_193815797 = null; //Variable for return #1
            StringBuilder builder;
            builder = new StringBuilder();
            appendSspTo(builder);
            varB4EAC82CA7396A68D541C85D26508E83_193815797 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_193815797.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_193815797;
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //appendSspTo(builder);
            //return builder.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.949 -0400", hash_original_method = "55EA79AD41E607B8DD0B042A78040234", hash_generated_method = "042A00B46BDAF14693CE00840D31EF61")
        private void appendSspTo(StringBuilder builder) {
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
                boolean var2C0BEF9EBF85F28B1D174D326A545DCD_651709627 = (!query.isEmpty());
                {
                    builder.append('?').append(query.getEncoded());
                } //End block
            } //End collapsed parenthetic
            addTaint(builder.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.950 -0400", hash_original_method = "4FC7F3346B5C0FC1519928E52B2843FB", hash_generated_method = "9C70D8E4F501F64AEA7645B5D8D694B4")
        public String getAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_1584957383 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1584957383 = this.authority.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1584957383.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1584957383;
            // ---------- Original Method ----------
            //return this.authority.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.982 -0400", hash_original_method = "02F0907154122B499105718EFAFFB12D", hash_generated_method = "E7914B9B83EE82D3CA0F7AC6373DDB11")
        public String getEncodedAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_360136340 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_360136340 = this.authority.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_360136340.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_360136340;
            // ---------- Original Method ----------
            //return this.authority.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.983 -0400", hash_original_method = "C2F72FED192DF0C1254C49B5EAFF6B37", hash_generated_method = "759D5984D8CFD7D4D591B56B1F24B201")
        public String getEncodedPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1347036431 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1347036431 = this.path.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1347036431.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1347036431;
            // ---------- Original Method ----------
            //return this.path.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.987 -0400", hash_original_method = "6081DF09BF7A0319CE8B8794EF03DD3D", hash_generated_method = "4016DD744917AC6C34B880BE0A62F0A9")
        public String getPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_625421584 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_625421584 = this.path.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_625421584.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_625421584;
            // ---------- Original Method ----------
            //return this.path.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.988 -0400", hash_original_method = "BB14E9B85B4B70FE8537ADEAEA0F30F8", hash_generated_method = "526F89B5E89475EC9926CAA40EB372BE")
        public String getQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_1313478744 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1313478744 = this.query.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1313478744.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1313478744;
            // ---------- Original Method ----------
            //return this.query.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.017 -0400", hash_original_method = "4E4841C1D3AAC7E9E3EC5666E1D3BDC7", hash_generated_method = "E8EF92660A70EAAD494EC5AF2812C3D7")
        public String getEncodedQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_2039795638 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2039795638 = this.query.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_2039795638.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2039795638;
            // ---------- Original Method ----------
            //return this.query.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.018 -0400", hash_original_method = "BC71EA5136922A2C431D19FA4D7E797E", hash_generated_method = "A5DFBFF8AB33318A8329B4CA5356146C")
        public String getFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_964774382 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_964774382 = this.fragment.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_964774382.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_964774382;
            // ---------- Original Method ----------
            //return this.fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.019 -0400", hash_original_method = "D0BDA4E24821D7C40932E823B160DCAD", hash_generated_method = "5B529D5C9D11B6A14CE0FF6EDCBC3048")
        public String getEncodedFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_1998274678 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1998274678 = this.fragment.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1998274678.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1998274678;
            // ---------- Original Method ----------
            //return this.fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.020 -0400", hash_original_method = "6A1F2A59685BCA2552F3B76D88CB5845", hash_generated_method = "528ACA90D0729A7E73C35C05CA90411A")
        public List<String> getPathSegments() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_1268590537 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1268590537 = this.path.getPathSegments();
            varB4EAC82CA7396A68D541C85D26508E83_1268590537.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1268590537;
            // ---------- Original Method ----------
            //return this.path.getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.020 -0400", hash_original_method = "2FFEEC7D33EBEEF04178DF9D921CBC02", hash_generated_method = "FD6E124F10AAFEF04CC37469ED387A3A")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_949059855 = null; //Variable for return #1
            @SuppressWarnings("StringEquality") boolean cached;
            cached = (uriString != NOT_CACHED);
            varB4EAC82CA7396A68D541C85D26508E83_949059855 = cached ? uriString
                    : (uriString = makeUriString());
            varB4EAC82CA7396A68D541C85D26508E83_949059855.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_949059855;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (uriString != NOT_CACHED);
            //return cached ? uriString
                    //: (uriString = makeUriString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.022 -0400", hash_original_method = "5AECD242275C33F74DCA414A6C8DF5D7", hash_generated_method = "BA10E84F7F326B46DDC1DF823B557D26")
        private String makeUriString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1627067278 = null; //Variable for return #1
            StringBuilder builder;
            builder = new StringBuilder();
            {
                builder.append(scheme).append(':');
            } //End block
            appendSspTo(builder);
            {
                boolean varC8C86438344E58844BC399B4194DB415_1632549558 = (!fragment.isEmpty());
                {
                    builder.append('#').append(fragment.getEncoded());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1627067278 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1627067278.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1627067278;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.040 -0400", hash_original_method = "6635CD2DD122D7EE5F14A5F21B272B08", hash_generated_method = "8A495C8AA43C475F293A53A673764B3A")
        public Builder buildUpon() {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1393339375 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1393339375 = new Builder()
                    .scheme(scheme)
                    .authority(authority)
                    .path(path)
                    .query(query)
                    .fragment(fragment);
            varB4EAC82CA7396A68D541C85D26508E83_1393339375.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1393339375;
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(scheme)
                    //.authority(authority)
                    //.path(path)
                    //.query(query)
                    //.fragment(fragment);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.040 -0400", hash_original_field = "1A6BAB54CA68848B2D28EFB422CF1725", hash_generated_field = "29A0B9A1B9D1EACFD9F76BE10E74F93C")

        static int TYPE_ID = 3;
    }


    
    public static final class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.041 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.041 -0400", hash_original_field = "E17823015F179701BCEC9CD4356C4A38", hash_generated_field = "F30F644E178A706F0279AC78D6913562")

        private Part opaquePart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.041 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.041 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.041 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.041 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.042 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "7F0D829FE2A4B9F217489244A9FD2E61")
        public  Builder() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.067 -0400", hash_original_method = "1FAF048543AEDF54BF8218C15362FDC3", hash_generated_method = "11CB26100701F1E78D1A318E085D2B14")
        public Builder scheme(String scheme) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1274150906 = null; //Variable for return #1
            this.scheme = scheme;
            varB4EAC82CA7396A68D541C85D26508E83_1274150906 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1274150906.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1274150906;
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.068 -0400", hash_original_method = "8D4C2B402A916DF01BF39AF004B22B4B", hash_generated_method = "CD0FB7797DB9966F931B4244F23C3D5C")
         Builder opaquePart(Part opaquePart) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1983172603 = null; //Variable for return #1
            this.opaquePart = opaquePart;
            varB4EAC82CA7396A68D541C85D26508E83_1983172603 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1983172603.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1983172603;
            // ---------- Original Method ----------
            //this.opaquePart = opaquePart;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.075 -0400", hash_original_method = "B04C2A20C29308DA58A03AAA34E4602D", hash_generated_method = "D237E1757D9E4DDFC173020A349D2628")
        public Builder opaquePart(String opaquePart) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1861646510 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1861646510 = opaquePart(Part.fromDecoded(opaquePart));
            addTaint(opaquePart.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1861646510.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1861646510;
            // ---------- Original Method ----------
            //return opaquePart(Part.fromDecoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.076 -0400", hash_original_method = "E3AC90668DB82124786DAC21400DF68F", hash_generated_method = "E9CB3C2FE6BB8AE16473301CBFD203A9")
        public Builder encodedOpaquePart(String opaquePart) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1521534110 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1521534110 = opaquePart(Part.fromEncoded(opaquePart));
            addTaint(opaquePart.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1521534110.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1521534110;
            // ---------- Original Method ----------
            //return opaquePart(Part.fromEncoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.101 -0400", hash_original_method = "CE12FA6D2315F74B1A3B79C027FFFA6D", hash_generated_method = "7C39E85072E4E73E8A39896F28F55D84")
         Builder authority(Part authority) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1751861409 = null; //Variable for return #1
            this.opaquePart = null;
            this.authority = authority;
            varB4EAC82CA7396A68D541C85D26508E83_1751861409 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1751861409.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1751861409;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.authority = authority;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.101 -0400", hash_original_method = "8B987B114EF487282F33A481DCB273CB", hash_generated_method = "F65E20553D074E9BBE165FCAE0FD5E1D")
        public Builder authority(String authority) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_718434777 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_718434777 = authority(Part.fromDecoded(authority));
            addTaint(authority.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_718434777.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_718434777;
            // ---------- Original Method ----------
            //return authority(Part.fromDecoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.102 -0400", hash_original_method = "2AF9D1463857894BBB2A3B7E377A77BB", hash_generated_method = "DBFFB5A6BC1A9339188ACFE10B2CD8A7")
        public Builder encodedAuthority(String authority) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_758690967 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_758690967 = authority(Part.fromEncoded(authority));
            addTaint(authority.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_758690967.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_758690967;
            // ---------- Original Method ----------
            //return authority(Part.fromEncoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.118 -0400", hash_original_method = "0552AFD7FA04CD9C4E588C7FB644B387", hash_generated_method = "C46A628BE704099D2EEFC63335C88A4B")
         Builder path(PathPart path) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_624122129 = null; //Variable for return #1
            this.opaquePart = null;
            this.path = path;
            varB4EAC82CA7396A68D541C85D26508E83_624122129 = this;
            varB4EAC82CA7396A68D541C85D26508E83_624122129.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_624122129;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.path = path;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.133 -0400", hash_original_method = "311D5047B3596F1C34DEC3DA1D1264C5", hash_generated_method = "1ACE80B3D2A09C944629FBC552A6A7E2")
        public Builder path(String path) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_630404028 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_630404028 = path(PathPart.fromDecoded(path));
            addTaint(path.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_630404028.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_630404028;
            // ---------- Original Method ----------
            //return path(PathPart.fromDecoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.134 -0400", hash_original_method = "B2733F0C4852B782EB87F01613E6C574", hash_generated_method = "57823EAF610A70FB7F05915726A08E09")
        public Builder encodedPath(String path) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1762703746 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1762703746 = path(PathPart.fromEncoded(path));
            addTaint(path.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1762703746.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1762703746;
            // ---------- Original Method ----------
            //return path(PathPart.fromEncoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.149 -0400", hash_original_method = "818DCEC2192004BCFE40E4E49FDA7A4C", hash_generated_method = "082679412DAA999302F69C565B919930")
        public Builder appendPath(String newSegment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_335181250 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_335181250 = path(PathPart.appendDecodedSegment(path, newSegment));
            addTaint(newSegment.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_335181250.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_335181250;
            // ---------- Original Method ----------
            //return path(PathPart.appendDecodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.150 -0400", hash_original_method = "04B6E07373B5BCB6E5F5541B11BC55A7", hash_generated_method = "084757F23B9AF972102C3672FC00E516")
        public Builder appendEncodedPath(String newSegment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_504272292 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_504272292 = path(PathPart.appendEncodedSegment(path, newSegment));
            addTaint(newSegment.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_504272292.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_504272292;
            // ---------- Original Method ----------
            //return path(PathPart.appendEncodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.151 -0400", hash_original_method = "526B00AFFC674BC410AFF0DB5058AD68", hash_generated_method = "AB8E810339A188E0AD518A62791C4DB6")
         Builder query(Part query) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_339699918 = null; //Variable for return #1
            this.opaquePart = null;
            this.query = query;
            varB4EAC82CA7396A68D541C85D26508E83_339699918 = this;
            varB4EAC82CA7396A68D541C85D26508E83_339699918.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_339699918;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.query = query;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.152 -0400", hash_original_method = "915051404F16544BAB27A534573CC34D", hash_generated_method = "45018FF035E1109A7FEBA62FBE005512")
        public Builder query(String query) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_58425691 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_58425691 = query(Part.fromDecoded(query));
            addTaint(query.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_58425691.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_58425691;
            // ---------- Original Method ----------
            //return query(Part.fromDecoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.152 -0400", hash_original_method = "2B1CFFF6E8520529FC529F01B5DBCD04", hash_generated_method = "78508DF2AEF7CF21FE8589EACE989326")
        public Builder encodedQuery(String query) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1756456842 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1756456842 = query(Part.fromEncoded(query));
            addTaint(query.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1756456842.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1756456842;
            // ---------- Original Method ----------
            //return query(Part.fromEncoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.174 -0400", hash_original_method = "AAD8E80453C4B46D11B41869FDCBA00D", hash_generated_method = "DB9AD73E4943396869800B8BCA6D6A42")
         Builder fragment(Part fragment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2031738910 = null; //Variable for return #1
            this.fragment = fragment;
            varB4EAC82CA7396A68D541C85D26508E83_2031738910 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2031738910.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2031738910;
            // ---------- Original Method ----------
            //this.fragment = fragment;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.174 -0400", hash_original_method = "016C309F39EF5D90CF32B95F6FDB27F8", hash_generated_method = "448EF96350A4A1D200B0B2F3EF3DF0E8")
        public Builder fragment(String fragment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_985218154 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_985218154 = fragment(Part.fromDecoded(fragment));
            addTaint(fragment.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_985218154.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_985218154;
            // ---------- Original Method ----------
            //return fragment(Part.fromDecoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.189 -0400", hash_original_method = "C5F51A11F0BEF63CCF4FD5F6AF742648", hash_generated_method = "A465654B9B366EED7671025CBC0D2325")
        public Builder encodedFragment(String fragment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1587850022 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1587850022 = fragment(Part.fromEncoded(fragment));
            addTaint(fragment.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1587850022.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1587850022;
            // ---------- Original Method ----------
            //return fragment(Part.fromEncoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.192 -0400", hash_original_method = "F83D70A0FC90543F01AB6385367098CC", hash_generated_method = "E149AFAD3F5AF4D00349E5892F3B525A")
        public Builder appendQueryParameter(String key, String value) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_648422810 = null; //Variable for return #1
            Builder varB4EAC82CA7396A68D541C85D26508E83_2091508189 = null; //Variable for return #2
            this.opaquePart = null;
            String encodedParameter;
            encodedParameter = encode(key, null) + "="
                    + encode(value, null);
            {
                query = Part.fromEncoded(encodedParameter);
                varB4EAC82CA7396A68D541C85D26508E83_648422810 = this;
            } //End block
            String oldQuery;
            oldQuery = query.getEncoded();
            {
                boolean varD871C9980587FFA401304C0008BE3177_1852873079 = (oldQuery == null || oldQuery.length() == 0);
                {
                    query = Part.fromEncoded(encodedParameter);
                } //End block
                {
                    query = Part.fromEncoded(oldQuery + "&" + encodedParameter);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2091508189 = this;
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            Builder varA7E53CE21691AB073D9660D615818899_2062076961; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2062076961 = varB4EAC82CA7396A68D541C85D26508E83_648422810;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2062076961 = varB4EAC82CA7396A68D541C85D26508E83_2091508189;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2062076961.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2062076961;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.207 -0400", hash_original_method = "581A1CF068B5634C1F252DE7C2737E06", hash_generated_method = "AF4F1BE44EA77D279D0E520073870264")
        public Builder clearQuery() {
            Builder varB4EAC82CA7396A68D541C85D26508E83_435328600 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_435328600 = query((Part) null);
            varB4EAC82CA7396A68D541C85D26508E83_435328600.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_435328600;
            // ---------- Original Method ----------
            //return query((Part) null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.209 -0400", hash_original_method = "C36CE5067F02DA1F1C7276BF67665A1B", hash_generated_method = "9402DFA1CA49191FC3D377C4908C64B9")
        public Uri build() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_168076833 = null; //Variable for return #1
            Uri varB4EAC82CA7396A68D541C85D26508E83_1120519599 = null; //Variable for return #2
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                            "An opaque URI must have a scheme.");
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_168076833 = new OpaqueUri(scheme, opaquePart, fragment);
            } //End block
            {
                PathPart path;
                path = this.path;
                {
                    path = PathPart.EMPTY;
                } //End block
                {
                    {
                        boolean var2CA83CB1D078EAA23C6D98CE29904B75_559777555 = (hasSchemeOrAuthority());
                        {
                            path = PathPart.makeAbsolute(path);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1120519599 = new HierarchicalUri(
                        scheme, authority, path, query, fragment);
            } //End block
            Uri varA7E53CE21691AB073D9660D615818899_479758950; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_479758950 = varB4EAC82CA7396A68D541C85D26508E83_168076833;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_479758950 = varB4EAC82CA7396A68D541C85D26508E83_1120519599;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_479758950.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_479758950;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.209 -0400", hash_original_method = "7917AD3B49169A1AC8EEA7DD014B7E45", hash_generated_method = "D021AD4CBACEDEF6C5DFE63910E793B9")
        private boolean hasSchemeOrAuthority() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_203316185 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_203316185;
            // ---------- Original Method ----------
            //return scheme != null
                    //|| (authority != null && authority != Part.NULL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.230 -0400", hash_original_method = "50FC77E3DFFDDD2DB7D0B749912434F7", hash_generated_method = "6107DA3307254BA1DAF54FD654290F31")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1555814961 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1555814961 = build().toString();
            varB4EAC82CA7396A68D541C85D26508E83_1555814961.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1555814961;
            // ---------- Original Method ----------
            //return build().toString();
        }

        
    }


    
    static abstract class AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.230 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "08274B7EEBA921030ECC3D76D1E6ECCB")

        volatile String encoded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.230 -0400", hash_original_field = "AD05458423E19C1FF1F3C0237F8CFBED", hash_generated_field = "B682B941676F7CF6A565D2078C9BC0A9")

        volatile String decoded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.231 -0400", hash_original_method = "21E01F693530948BFE81E2C9AE8C6D31", hash_generated_method = "00DF56A1D35C3F914A2155477BDE237F")
          AbstractPart(String encoded, String decoded) {
            this.encoded = encoded;
            this.decoded = decoded;
            // ---------- Original Method ----------
            //this.encoded = encoded;
            //this.decoded = decoded;
        }

        
        abstract String getEncoded();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.232 -0400", hash_original_method = "06323BBC323E7F59CEDDE1FAA04ED1F6", hash_generated_method = "A78909AB3526F0C58503FBA04569228A")
        final String getDecoded() {
            String varB4EAC82CA7396A68D541C85D26508E83_1484704116 = null; //Variable for return #1
            @SuppressWarnings("StringEquality") boolean hasDecoded;
            hasDecoded = decoded != NOT_CACHED;
            varB4EAC82CA7396A68D541C85D26508E83_1484704116 = hasDecoded ? decoded : (decoded = decode(encoded));
            varB4EAC82CA7396A68D541C85D26508E83_1484704116.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1484704116;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasDecoded = decoded != NOT_CACHED;
            //return hasDecoded ? decoded : (decoded = decode(encoded));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.254 -0400", hash_original_method = "BB7E54AFB81798C035BF3B3717F470E7", hash_generated_method = "A111340E1DA718CF57BDC6A3E00B43C1")
        final void writeTo(Parcel parcel) {
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
            addTaint(parcel.getTaint());
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.255 -0400", hash_original_method = "49186660D0AEF0721F749C758CF0FE34", hash_generated_method = "49186660D0AEF0721F749C758CF0FE34")
            public Representation ()
            {
                //Synthesized constructor
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.255 -0400", hash_original_field = "659BA2B3286FF6C4923CFE851F3CD42E", hash_generated_field = "0ECB613EF123E018235FE7E4B9D17C2E")

            static int BOTH = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.255 -0400", hash_original_field = "D22FD9F8AEEC62F2AEF921B20283C7C9", hash_generated_field = "8536DF05FD4192CE4BA43F650DAD013C")

            static int ENCODED = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.255 -0400", hash_original_field = "7CA715B76440B29FFB05D39B0C592B7F", hash_generated_field = "73C6F197EBE1645DC7DE0D3B20946FCF")

            static int DECODED = 2;
        }


        
    }


    
    static class Part extends AbstractPart {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.267 -0400", hash_original_method = "68B275EBA6010E5404727E121615E229", hash_generated_method = "A2A4141E5360E67DD2B728987EC31D1B")
        private  Part(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(encoded.getTaint());
            addTaint(decoded.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.268 -0400", hash_original_method = "BD94DCCF5B44419F4498543CA74892E2", hash_generated_method = "0BC0529117487F5388B1110E7EE8F43B")
         boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923053724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_923053724;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.270 -0400", hash_original_method = "74B8C999E422A266FD890BA259F6B43C", hash_generated_method = "7F3064793666D0F242A7F8DA010AF9F8")
         String getEncoded() {
            String varB4EAC82CA7396A68D541C85D26508E83_782590402 = null; //Variable for return #1
            @SuppressWarnings("StringEquality") boolean hasEncoded;
            hasEncoded = encoded != NOT_CACHED;
            varB4EAC82CA7396A68D541C85D26508E83_782590402 = hasEncoded ? encoded : (encoded = encode(decoded));
            varB4EAC82CA7396A68D541C85D26508E83_782590402.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_782590402;
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.320 -0400", hash_original_method = "D79C0256E86C850253FAE782AD9920ED", hash_generated_method = "D6E891CD56E98A9A6565F34666DC1B4A")
            public  EmptyPart(String value) {
                super(value, value);
                addTaint(value.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.321 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "CE90F7BE4B4EF3F3E4E03462C4B0B833")
            @Override
             boolean isEmpty() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404457469 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_404457469;
                // ---------- Original Method ----------
                //return true;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.322 -0400", hash_original_field = "22902092D13F95EF047EC38F67C7A689", hash_generated_field = "BFE6123A9E3D0EFE1A63D83B81B8255B")

        static Part NULL = new EmptyPart(null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.322 -0400", hash_original_field = "7F2DFD92B4F00B07EC2711F9AFB4D4CD", hash_generated_field = "B098B99E5AB556F47486DA9A903855D3")

        static Part EMPTY = new EmptyPart("");
    }


    
    static class PathPart extends AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.322 -0400", hash_original_field = "5C8A59F77C438336819DD4F6B0C372B5", hash_generated_field = "BB8884736C4C2C995D440C597E10BBE6")

        private PathSegments pathSegments;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.323 -0400", hash_original_method = "E8CA21F7072E8C7642F3BFF9454329AE", hash_generated_method = "425902F356A88F24F0B82B0C0A427610")
        private  PathPart(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(encoded.getTaint());
            addTaint(decoded.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.324 -0400", hash_original_method = "EEE1C5D1C73794B2424FF9B6A794D8BE", hash_generated_method = "6EA5AF39E3C552D45880106930100CB8")
         String getEncoded() {
            String varB4EAC82CA7396A68D541C85D26508E83_807527743 = null; //Variable for return #1
            @SuppressWarnings("StringEquality") boolean hasEncoded;
            hasEncoded = encoded != NOT_CACHED;
            varB4EAC82CA7396A68D541C85D26508E83_807527743 = hasEncoded ? encoded : (encoded = encode(decoded, "/"));
            varB4EAC82CA7396A68D541C85D26508E83_807527743.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_807527743;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded, "/"));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.343 -0400", hash_original_method = "BB12DAE5001652F9E9419E41FB496BCF", hash_generated_method = "3B02BEA324B5754BFD329013CED6DB2A")
         PathSegments getPathSegments() {
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_995386937 = null; //Variable for return #1
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_755607800 = null; //Variable for return #2
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_828606867 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_995386937 = pathSegments;
            } //End block
            String path;
            path = getEncoded();
            {
                varB4EAC82CA7396A68D541C85D26508E83_755607800 = pathSegments = PathSegments.EMPTY;
            } //End block
            PathSegmentsBuilder segmentBuilder;
            segmentBuilder = new PathSegmentsBuilder();
            int previous;
            previous = 0;
            int current;
            {
                boolean varF3473A5176F979210C8BDFC961564284_1250820675 = ((current = path.indexOf('/', previous)) > -1);
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
                boolean var80E2BDF18328ED6FA29B39AB13CE0D97_610372991 = (previous < path.length());
                {
                    segmentBuilder.add(decode(path.substring(previous)));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_828606867 = pathSegments = segmentBuilder.build();
            PathSegments varA7E53CE21691AB073D9660D615818899_1808224027; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1808224027 = varB4EAC82CA7396A68D541C85D26508E83_995386937;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1808224027 = varB4EAC82CA7396A68D541C85D26508E83_755607800;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1808224027 = varB4EAC82CA7396A68D541C85D26508E83_828606867;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1808224027.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1808224027;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "12FCD4CDDE0159C0A83B0F6923FAC7D8", hash_generated_field = "8ECB44FE06630CB5E3D8EF52BB3969F1")

        static PathPart NULL = new PathPart(null, null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "2511CF6735334EEEFE4C66E3501EA765", hash_generated_field = "B260C1DBE46C249545F47BF3BD4DE1AF")

        static PathPart EMPTY = new PathPart("", "");
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "15E64A01463468950481CAE21CF06FCB", hash_generated_field = "47C0CAE24718EC174B9B6B0B137E5E99")

    private static String LOG = Uri.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "A90280C308D46EDE51003B54A6774638", hash_generated_field = "6F222F6C47CA38C0A7F81959C13B5970")

    @SuppressWarnings("RedundantStringConstructorCall") private static String NOT_CACHED = new String("NOT CACHED");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "A81A920AEF8690239BB9D44F7E78D4F4", hash_generated_field = "5038C252470848AFDD24667CC5D97705")

    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL,
            PathPart.EMPTY, Part.NULL, Part.NULL);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "096628D07602808452D76140024603D6", hash_generated_field = "4E02F57571CF8579FA415EEF37F04E36")

    private static int NOT_FOUND = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "4FDDDF7A3C684DEFD4771F4F71A53864", hash_generated_field = "2076DA02B966BB00E944179668DF4482")

    private static int NOT_CALCULATED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "6DE16BB1834113B41F3DB9E09DDB15A3", hash_generated_field = "6791AB0FB70363D3232DCD776BD95EA7")

    private static String NOT_HIERARCHICAL = "This isn't a hierarchical URI.";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "2D7FBEFE0E1B69A4322A3C2F72D1B945", hash_generated_field = "E5701ADC5E89D5E641FA37F5A19EB33A")

    private static String DEFAULT_ENCODING = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "FEE7EF6013925E53DB51A6700DEA6FED", hash_generated_field = "2FA0E199B268A36317F4693FEDB86E9C")

    private static int NULL_TYPE_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.362 -0400", hash_original_field = "FA031E527800FCED59C59BB3277BEE96", hash_generated_field = "A8963E713BB231EFDC73C3C4317D711B")

    public static final Parcelable.Creator<Uri> CREATOR
            = new Parcelable.Creator<Uri>() {
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

        public Uri[] newArray(int size) {
            return new Uri[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.363 -0400", hash_original_field = "7590EBC339FE731817F9724DB1BDFD6C", hash_generated_field = "EFDBD6587C0091DE9CCAF154EBCFD8A1")

    private static char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.363 -0400", hash_original_field = "B895F573C0891DA82989F42094373576", hash_generated_field = "0AFDB67E39A1E6959A389C62AE853D85")

    private static byte[] REPLACEMENT = ;
}

