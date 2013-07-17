package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.557 -0400", hash_original_method = "81E08B95735493D923725112C83DA27A", hash_generated_method = "AE17603DE8C4908F75692349E5C02303")
    private  Uri() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isHierarchical();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.558 -0400", hash_original_method = "A0C9F8427F648091A08345C72525BACA", hash_generated_method = "A31AADEA40ACF801DA8E588B41859BCF")
    public boolean isOpaque() {
        boolean varB0499C09D88ADA4B175FB58912D54137_2109316948 = (!isHierarchical());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24839511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24839511;
        // ---------- Original Method ----------
        //return !isHierarchical();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isRelative();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.558 -0400", hash_original_method = "E92F08B9247EAC707F6805C228339DFA", hash_generated_method = "90B19047FB92B2AAE3D36FEC41F95CE9")
    public boolean isAbsolute() {
        boolean varA7DC41148D608495EEE12AD396A7094A_982983477 = (!isRelative());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535463145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535463145;
        // ---------- Original Method ----------
        //return !isRelative();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String getScheme();

    
    @DSModeled(DSC.SAFE)
    public abstract String getSchemeSpecificPart();

    
    @DSModeled(DSC.SAFE)
    public abstract String getEncodedSchemeSpecificPart();

    
    @DSModeled(DSC.SAFE)
    public abstract String getAuthority();

    
    @DSModeled(DSC.SAFE)
    public abstract String getEncodedAuthority();

    
    @DSModeled(DSC.SAFE)
    public abstract String getUserInfo();

    
    @DSModeled(DSC.SAFE)
    public abstract String getEncodedUserInfo();

    
    @DSModeled(DSC.SAFE)
    public abstract String getHost();

    
    @DSModeled(DSC.SAFE)
    public abstract int getPort();

    
    @DSModeled(DSC.SAFE)
    public abstract String getPath();

    
    @DSModeled(DSC.SAFE)
    public abstract String getEncodedPath();

    
    @DSModeled(DSC.SAFE)
    public abstract String getQuery();

    
    @DSModeled(DSC.SAFE)
    public abstract String getEncodedQuery();

    
    @DSModeled(DSC.SAFE)
    public abstract String getFragment();

    
    @DSModeled(DSC.SAFE)
    public abstract String getEncodedFragment();

    
    @DSModeled(DSC.SAFE)
    public abstract List<String> getPathSegments();

    
    @DSModeled(DSC.SAFE)
    public abstract String getLastPathSegment();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.560 -0400", hash_original_method = "FA9A408EEB8F8DAB44A912D276C5C2CC", hash_generated_method = "675F52B25BE95BC9B60E349FF2B6433A")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof Uri))        
        {
            boolean var68934A3E9455FA72420237EB05902327_650334079 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748750507 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748750507;
        } //End block
        Uri other = (Uri) o;
        boolean var375391202D42F422F32D588DF637C48C_1668111561 = (toString().equals(other.toString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632213281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_632213281;
        // ---------- Original Method ----------
        //if (!(o instanceof Uri)) {
            //return false;
        //}
        //Uri other = (Uri) o;
        //return toString().equals(other.toString());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.560 -0400", hash_original_method = "5AAF793CD4316640D385D37282629FDE", hash_generated_method = "10BD6E4763DAEB33F336269050638B5F")
    public int hashCode() {
        int var3A322A74445239A748BA39CEE0B79D31_1282162070 = (toString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593219428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593219428;
        // ---------- Original Method ----------
        //return toString().hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.560 -0400", hash_original_method = "45EC734684FFFB3EE70A4C12F2A2F839", hash_generated_method = "CA4D99013B6590DF43E46B045D177776")
    public int compareTo(Uri other) {
        addTaint(other.getTaint());
        int varB42A77B0F940EC261622D54B298EB83F_562246200 = (toString().compareTo(other.toString()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497305294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497305294;
        // ---------- Original Method ----------
        //return toString().compareTo(other.toString());
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String toString();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.561 -0400", hash_original_method = "C2346F0C89241A0BA21735401E86BD49", hash_generated_method = "2A28DF4C1EBCE1DF228903458C16B73C")
    public String toSafeString() {
        String scheme = getScheme();
        String ssp = getSchemeSpecificPart();
        if(scheme != null)        
        {
            if(scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip")
                    || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto")
                    || scheme.equalsIgnoreCase("mailto"))            
            {
                StringBuilder builder = new StringBuilder(64);
                builder.append(scheme);
                builder.append(':');
                if(ssp != null)                
                {
for(int i=0;i<ssp.length();i++)
                    {
                        char c = ssp.charAt(i);
                        if(c == '-' || c == '@' || c == '.')                        
                        {
                            builder.append(c);
                        } //End block
                        else
                        {
                            builder.append('x');
                        } //End block
                    } //End block
                } //End block
String varF4CF030572656354ACFDF83FEE21D7A6_1663035368 =                 builder.toString();
                varF4CF030572656354ACFDF83FEE21D7A6_1663035368.addTaint(taint);
                return varF4CF030572656354ACFDF83FEE21D7A6_1663035368;
            } //End block
        } //End block
        StringBuilder builder = new StringBuilder(64);
        if(scheme != null)        
        {
            builder.append(scheme);
            builder.append(':');
        } //End block
        if(ssp != null)        
        {
            builder.append(ssp);
        } //End block
String varF4CF030572656354ACFDF83FEE21D7A6_1137535438 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1137535438.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1137535438;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    public abstract Builder buildUpon();

    
    @DSModeled(DSC.SAFE)
    public static Uri parse(String uriString) {
        return new StringUri(uriString);
    }

    
    @DSModeled(DSC.SPEC)
    public static Uri fromFile(File file) {
        if (file == null) {
            throw new NullPointerException("file");
        }
        PathPart path = PathPart.fromDecoded(file.getAbsolutePath());
        return new HierarchicalUri(
                "file", Part.EMPTY, path, Part.NULL, Part.NULL);
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.561 -0400", hash_original_method = "966FC11B97976C170B352F408FA2783F", hash_generated_method = "3207D25E990B98F93714CA0AC81FE9A8")
    public Set<String> getQueryParameterNames() {
        if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_956920246 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_956920246.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_956920246;
        } //End block
        String query = getEncodedQuery();
        if(query == null)        
        {
Set<String> var5CEAC4B7DE047656E0B916F1F83FCC49_2050861202 =             Collections.emptySet();
            var5CEAC4B7DE047656E0B916F1F83FCC49_2050861202.addTaint(taint);
            return var5CEAC4B7DE047656E0B916F1F83FCC49_2050861202;
        } //End block
        Set<String> names = new LinkedHashSet<String>();
        int start = 0;
        do {
            {
                int next = query.indexOf('&', start);
                int end = (next == -1) ? query.length() : next;
                int separator = query.indexOf('=', start);
                if(separator > end || separator == -1)                
                {
                    separator = end;
                } //End block
                String name = query.substring(start, separator);
                names.add(decode(name));
                start = end + 1;
            } //End block
} while (start < query.length());
Set<String> varDD12C3B8A2F9B14F672A88549FBB956F_821819607 =         Collections.unmodifiableSet(names);
        varDD12C3B8A2F9B14F672A88549FBB956F_821819607.addTaint(taint);
        return varDD12C3B8A2F9B14F672A88549FBB956F_821819607;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.562 -0400", hash_original_method = "9E05603A6F44EBCC73536B2584976016", hash_generated_method = "975E9C2D6EF5A70698781F1A0D1C200A")
    public List<String> getQueryParameters(String key) {
        addTaint(key.getTaint());
        if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_26531210 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_26531210.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_26531210;
        } //End block
        if(key == null)        
        {
            NullPointerException var6D18FBA697BA09A47EF653F0DB540AE6_1962062880 = new NullPointerException("key");
            var6D18FBA697BA09A47EF653F0DB540AE6_1962062880.addTaint(taint);
            throw var6D18FBA697BA09A47EF653F0DB540AE6_1962062880;
        } //End block
        String query = getEncodedQuery();
        if(query == null)        
        {
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_575639787 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_575639787.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_575639787;
        } //End block
        String encodedKey;
        try 
        {
            encodedKey = URLEncoder.encode(key, DEFAULT_ENCODING);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_378962596 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_378962596.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_378962596;
        } //End block
        ArrayList<String> values = new ArrayList<String>();
        int start = 0;
        do {
            {
                int nextAmpersand = query.indexOf('&', start);
                int end = nextAmpersand != -1 ? nextAmpersand : query.length();
                int separator = query.indexOf('=', start);
                if(separator > end || separator == -1)                
                {
                    separator = end;
                } //End block
                if(separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length()))                
                {
                    if(separator == end)                    
                    {
                        values.add("");
                    } //End block
                    else
                    {
                        values.add(decode(query.substring(separator + 1, end)));
                    } //End block
                } //End block
                if(nextAmpersand != -1)                
                {
                    start = nextAmpersand + 1;
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
} while (true);
List<String> var00BA81E9B2AB879A295DB9B86426A421_494928898 =         Collections.unmodifiableList(values);
        var00BA81E9B2AB879A295DB9B86426A421_494928898.addTaint(taint);
        return var00BA81E9B2AB879A295DB9B86426A421_494928898;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.562 -0400", hash_original_method = "72F6B0777F298E12957F6498D8B3E8F1", hash_generated_method = "77DD98E72F4BAB45BAFF7F134A67308B")
    public String getQueryParameter(String key) {
        addTaint(key.getTaint());
        if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_595114965 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_595114965.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_595114965;
        } //End block
        if(key == null)        
        {
            NullPointerException var6D18FBA697BA09A47EF653F0DB540AE6_27035486 = new NullPointerException("key");
            var6D18FBA697BA09A47EF653F0DB540AE6_27035486.addTaint(taint);
            throw var6D18FBA697BA09A47EF653F0DB540AE6_27035486;
        } //End block
        final String query = getEncodedQuery();
        if(query == null)        
        {
String var540C13E9E156B687226421B24F2DF178_155166281 =             null;
            var540C13E9E156B687226421B24F2DF178_155166281.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_155166281;
        } //End block
        final String encodedKey = encode(key, null);
        final int length = query.length();
        int start = 0;
        do {
            {
                int nextAmpersand = query.indexOf('&', start);
                int end = nextAmpersand != -1 ? nextAmpersand : length;
                int separator = query.indexOf('=', start);
                if(separator > end || separator == -1)                
                {
                    separator = end;
                } //End block
                if(separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length()))                
                {
                    if(separator == end)                    
                    {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1351623255 =                         "";
                        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1351623255.addTaint(taint);
                        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1351623255;
                    } //End block
                    else
                    {
String varEB3B385708156ABD4F6A26F7ED4FD51E_2043379468 =                         decode(query.substring(separator + 1, end));
                        varEB3B385708156ABD4F6A26F7ED4FD51E_2043379468.addTaint(taint);
                        return varEB3B385708156ABD4F6A26F7ED4FD51E_2043379468;
                    } //End block
                } //End block
                if(nextAmpersand != -1)                
                {
                    start = nextAmpersand + 1;
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
} while (true);
String var540C13E9E156B687226421B24F2DF178_1084278097 =         null;
        var540C13E9E156B687226421B24F2DF178_1084278097.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1084278097;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.563 -0400", hash_original_method = "67BE774C17CDAC836698DE4D6D994F1B", hash_generated_method = "6208FBE48A0E870E5B19F0A6574B2E00")
    public boolean getBooleanQueryParameter(String key, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        String flag = getQueryParameter(key);
        if(flag == null)        
        {
            boolean var16830A58E1E33A4163524366BA7B701B_654525115 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1522328201 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1522328201;
        } //End block
        flag = flag.toLowerCase();
        boolean varEA95ECFC8D5C8F8BB96D459961F0F8E2_701724460 = ((!"false".equals(flag) && !"0".equals(flag)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_619192796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_619192796;
        // ---------- Original Method ----------
        //String flag = getQueryParameter(key);
        //if (flag == null) {
            //return defaultValue;
        //}
        //flag = flag.toLowerCase();
        //return (!"false".equals(flag) && !"0".equals(flag));
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    public static Uri withAppendedPath(Uri baseUri, String pathSegment) {
        Builder builder = baseUri.buildUpon();
        builder = builder.appendEncodedPath(pathSegment);
        return builder.build();
    }

    
    private static class StringUri extends AbstractHierarchicalUri {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "ACD4CFB867E9014EB5553B665A7654E7", hash_generated_field = "E4175460B78B44891D601990509D1265")

        private String uriString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "CAB1D5F863DB3FE1F854F1737D3BF567", hash_generated_field = "6ECAEC93E2396D17CA9FF61298DA11AE")

        private volatile int cachedSsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "0D27A2D8516BF4DCE688D48A00F04BF9", hash_generated_field = "6673040FAE4D4C35641720F36B224DA4")

        private volatile int cachedFsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "8FE13FA728B09DACBFC57E5751B51F48", hash_generated_field = "0E9D0B05543D9BBCEB78240FF4AE88F4")

        private volatile String scheme = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_method = "6762E8F4F232397EC67D86B91A630B95", hash_generated_method = "80AC3C0EF60D46145B1AD3896064E960")
        private  StringUri(String uriString) {
            if(uriString == null)            
            {
                NullPointerException var68D2986827E7776409B7C54E12824C66_541518704 = new NullPointerException("uriString");
                var68D2986827E7776409B7C54E12824C66_541518704.addTaint(taint);
                throw var68D2986827E7776409B7C54E12824C66_541518704;
            } //End block
            this.uriString = uriString;
            // ---------- Original Method ----------
            //if (uriString == null) {
                //throw new NullPointerException("uriString");
            //}
            //this.uriString = uriString;
        }

        
        @DSModeled(DSC.SPEC)
        static Uri readFrom(Parcel parcel) {
            return new StringUri(parcel.readString());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.564 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "09A94825B5D91D67D51EDE934C52B5AC")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1797434895 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299906247 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299906247;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.565 -0400", hash_original_method = "C73A8428F9DA44091DF96EEDC1E3D3EF", hash_generated_method = "324EBC5AEA4A8D0023485D42B57F178D")
        public void writeToParcel(Parcel parcel, int flags) {
            addTaint(flags);
            addTaint(parcel.getTaint());
            parcel.writeInt(TYPE_ID);
            parcel.writeString(uriString);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.565 -0400", hash_original_method = "F197955D6E3BAB1920F769AA2F97BBD7", hash_generated_method = "89C59A043FDE7833AAEE4D8874F2ABC6")
        private int findSchemeSeparator() {
            int varF628705FEC99553366B579C402EB9B06_450672413 = (cachedSsi == NOT_CALCULATED
                    ? cachedSsi = uriString.indexOf(':')
                    : cachedSsi);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759532882 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759532882;
            // ---------- Original Method ----------
            //return cachedSsi == NOT_CALCULATED
                    //? cachedSsi = uriString.indexOf(':')
                    //: cachedSsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.565 -0400", hash_original_method = "B0E1A879F11D02C30EC9FBB06F8801FE", hash_generated_method = "2B94A035C8B66978EF715EEB9947C28C")
        private int findFragmentSeparator() {
            int varB610A4875B79C5B29765DB968E0E51FE_485664101 = (cachedFsi == NOT_CALCULATED
                    ? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    : cachedFsi);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218821582 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218821582;
            // ---------- Original Method ----------
            //return cachedFsi == NOT_CALCULATED
                    //? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    //: cachedFsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.565 -0400", hash_original_method = "11C2E375F5E033161AB2E06056D673CF", hash_generated_method = "C82EB92B59790FAF8BD9A52390C6D3FB")
        public boolean isHierarchical() {
            int ssi = findSchemeSeparator();
            if(ssi == NOT_FOUND)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_961483567 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_878229948 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_878229948;
            } //End block
            if(uriString.length() == ssi + 1)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1826597278 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1487721353 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1487721353;
            } //End block
            boolean varC62061A402117AB0C4CED01069D594B5_2055795701 = (uriString.charAt(ssi + 1) == '/');
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1733491714 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1733491714;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.565 -0400", hash_original_method = "DC1D040929AB7A4CF9A0DFBB95EA4283", hash_generated_method = "78803BD20BAC9BF6FB8747ACE8383BEF")
        public boolean isRelative() {
            boolean var348FB469184CEBD475FA89D15A3871A3_1180377750 = (findSchemeSeparator() == NOT_FOUND);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519120662 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_519120662;
            // ---------- Original Method ----------
            //return findSchemeSeparator() == NOT_FOUND;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.565 -0400", hash_original_method = "96667B7E38635C26F17AC80DC91F9ADB", hash_generated_method = "4C1B28A0CFD4FBC1E1C08867A87C6E30")
        public String getScheme() {
            @SuppressWarnings("StringEquality") boolean cached = (scheme != NOT_CACHED);
String var5EC068FC8BAF19C405B863C227DA0116_758083170 =             cached ? scheme : (scheme = parseScheme());
            var5EC068FC8BAF19C405B863C227DA0116_758083170.addTaint(taint);
            return var5EC068FC8BAF19C405B863C227DA0116_758083170;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (scheme != NOT_CACHED);
            //return cached ? scheme : (scheme = parseScheme());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.565 -0400", hash_original_method = "B03A2C85823E1DE38C77FC40695B0CC7", hash_generated_method = "74E6EDCABB38E1CAB122652EADF1F9E9")
        private String parseScheme() {
            int ssi = findSchemeSeparator();
String var9A67634AC4372CD6514004924726C40E_439712884 =             ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
            var9A67634AC4372CD6514004924726C40E_439712884.addTaint(taint);
            return var9A67634AC4372CD6514004924726C40E_439712884;
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //return ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.566 -0400", hash_original_method = "DE43C7F499D5F1739936552A95AA2492", hash_generated_method = "6463AB6A8FE14802A7A2D2C6B58E6334")
        private Part getSsp() {
Part var09914C8DC28309112B8F11C48A2310A0_374841147 =             ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
            var09914C8DC28309112B8F11C48A2310A0_374841147.addTaint(taint);
            return var09914C8DC28309112B8F11C48A2310A0_374841147;
            // ---------- Original Method ----------
            //return ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.566 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "2DB37ED90F33D63638A17B5EB9999652")
        public String getEncodedSchemeSpecificPart() {
String var393D011CD485FB233FC4BE4326461491_355476562 =             getSsp().getEncoded();
            var393D011CD485FB233FC4BE4326461491_355476562.addTaint(taint);
            return var393D011CD485FB233FC4BE4326461491_355476562;
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.566 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "A16C4665E747B722CDD4EE52C5A84316")
        public String getSchemeSpecificPart() {
String varDEA78A046E5755E6A172773CC85259A6_1415776458 =             getSsp().getDecoded();
            varDEA78A046E5755E6A172773CC85259A6_1415776458.addTaint(taint);
            return varDEA78A046E5755E6A172773CC85259A6_1415776458;
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.566 -0400", hash_original_method = "6082AC88F53E9B67D59D9A72041A5D6F", hash_generated_method = "3316CAAF57D3680703933288384BF5F6")
        private String parseSsp() {
            int ssi = findSchemeSeparator();
            int fsi = findFragmentSeparator();
String varBF4B489B1C1A01395A08B9487579BBF1_1161418210 =             fsi == NOT_FOUND
                    ? uriString.substring(ssi + 1)
                    : uriString.substring(ssi + 1, fsi);
            varBF4B489B1C1A01395A08B9487579BBF1_1161418210.addTaint(taint);
            return varBF4B489B1C1A01395A08B9487579BBF1_1161418210;
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND
                    //? uriString.substring(ssi + 1)
                    //: uriString.substring(ssi + 1, fsi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.566 -0400", hash_original_method = "C2AABBF6273BD8549508A0ABF072F220", hash_generated_method = "2F69F8D402795DDE4DBC8154683942C8")
        private Part getAuthorityPart() {
            if(authority == null)            
            {
                String encodedAuthority = parseAuthority(this.uriString, findSchemeSeparator());
Part var381FCECE440D5D319C351EE6F1BBEAAB_193319550 =                 authority = Part.fromEncoded(encodedAuthority);
                var381FCECE440D5D319C351EE6F1BBEAAB_193319550.addTaint(taint);
                return var381FCECE440D5D319C351EE6F1BBEAAB_193319550;
            } //End block
Part var9A4A00E403B4898E9807F68E9EBE5A8B_160671446 =             authority;
            var9A4A00E403B4898E9807F68E9EBE5A8B_160671446.addTaint(taint);
            return var9A4A00E403B4898E9807F68E9EBE5A8B_160671446;
            // ---------- Original Method ----------
            //if (authority == null) {
                //String encodedAuthority
                        //= parseAuthority(this.uriString, findSchemeSeparator());
                //return authority = Part.fromEncoded(encodedAuthority);
            //}
            //return authority;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.566 -0400", hash_original_method = "B783FB869F9CE6B897E37C2A9B9B4259", hash_generated_method = "0F4D990A6C3803780B6824DF7E412523")
        public String getEncodedAuthority() {
String var4F2DF47BEB24727A66BE79DC91AEECC0_881706896 =             getAuthorityPart().getEncoded();
            var4F2DF47BEB24727A66BE79DC91AEECC0_881706896.addTaint(taint);
            return var4F2DF47BEB24727A66BE79DC91AEECC0_881706896;
            // ---------- Original Method ----------
            //return getAuthorityPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.566 -0400", hash_original_method = "F4404025FB90C68980598D2895AF9578", hash_generated_method = "FBD56D24AB3DEF7AE98161096558FBA6")
        public String getAuthority() {
String var039061F12DF25903DB753BE4C77CEE48_644804322 =             getAuthorityPart().getDecoded();
            var039061F12DF25903DB753BE4C77CEE48_644804322.addTaint(taint);
            return var039061F12DF25903DB753BE4C77CEE48_644804322;
            // ---------- Original Method ----------
            //return getAuthorityPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.567 -0400", hash_original_method = "483C19AAE407B7D6148F370745A1893E", hash_generated_method = "D380775AF0C043B7D98435930F5EFE0C")
        private PathPart getPathPart() {
PathPart varD78256BB83A04B0BB00412684FCFB6CE_633721031 =             path == null
                    ? path = PathPart.fromEncoded(parsePath())
                    : path;
            varD78256BB83A04B0BB00412684FCFB6CE_633721031.addTaint(taint);
            return varD78256BB83A04B0BB00412684FCFB6CE_633721031;
            // ---------- Original Method ----------
            //return path == null
                    //? path = PathPart.fromEncoded(parsePath())
                    //: path;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.567 -0400", hash_original_method = "E8759FDECF433DBBFF0BA03CF3576CC0", hash_generated_method = "140D0702114868B1D347DCEB8EC98862")
        public String getPath() {
String varEADC8740E16239A469558240BCE0C192_1360468971 =             getPathPart().getDecoded();
            varEADC8740E16239A469558240BCE0C192_1360468971.addTaint(taint);
            return varEADC8740E16239A469558240BCE0C192_1360468971;
            // ---------- Original Method ----------
            //return getPathPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.567 -0400", hash_original_method = "D26AFC1B9D9DFA82513D9A4C50DD2F0F", hash_generated_method = "8D9C1B6934AB78E96D385B76E04BB7D9")
        public String getEncodedPath() {
String var5763B1F1953626A1B4119C83521EC238_280258390 =             getPathPart().getEncoded();
            var5763B1F1953626A1B4119C83521EC238_280258390.addTaint(taint);
            return var5763B1F1953626A1B4119C83521EC238_280258390;
            // ---------- Original Method ----------
            //return getPathPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.567 -0400", hash_original_method = "A1BA2B8DCFFB301EABC725C63F487DC2", hash_generated_method = "C11AE3481E850B0A07ACF89D6EE56B76")
        public List<String> getPathSegments() {
List<String> var9D1E6922DB3B6A33267FC8778B1D1882_78304198 =             getPathPart().getPathSegments();
            var9D1E6922DB3B6A33267FC8778B1D1882_78304198.addTaint(taint);
            return var9D1E6922DB3B6A33267FC8778B1D1882_78304198;
            // ---------- Original Method ----------
            //return getPathPart().getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.567 -0400", hash_original_method = "EF0989C68625FC2F46DE0EA4CB35660B", hash_generated_method = "2A8072453064333CB9EB05A2D59CDCC1")
        private String parsePath() {
            String uriString = this.uriString;
            int ssi = findSchemeSeparator();
            if(ssi > -1)            
            {
                boolean schemeOnly = ssi + 1 == uriString.length();
                if(schemeOnly)                
                {
String var540C13E9E156B687226421B24F2DF178_1091046280 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1091046280.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1091046280;
                } //End block
                if(uriString.charAt(ssi + 1) != '/')                
                {
String var540C13E9E156B687226421B24F2DF178_903058584 =                     null;
                    var540C13E9E156B687226421B24F2DF178_903058584.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_903058584;
                } //End block
            } //End block
            else
            {
            } //End block
String var735954F5F0815F8E40E83E176F832A69_1133847576 =             parsePath(uriString, ssi);
            var735954F5F0815F8E40E83E176F832A69_1133847576.addTaint(taint);
            return var735954F5F0815F8E40E83E176F832A69_1133847576;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.567 -0400", hash_original_method = "5338F6D0AC99191764C2394A710C873F", hash_generated_method = "E1EA6E8BDA35D6BDDC56C7DEBC4EE6AD")
        private Part getQueryPart() {
Part varF5F740948841E62E50DE94DCB962384D_1844453816 =             query == null
                    ? query = Part.fromEncoded(parseQuery()) : query;
            varF5F740948841E62E50DE94DCB962384D_1844453816.addTaint(taint);
            return varF5F740948841E62E50DE94DCB962384D_1844453816;
            // ---------- Original Method ----------
            //return query == null
                    //? query = Part.fromEncoded(parseQuery()) : query;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.567 -0400", hash_original_method = "61892B739321CB796D242E9E13C1F033", hash_generated_method = "516E2E2B03FB52C82533DC41B924FEAD")
        public String getEncodedQuery() {
String var592BAA78F9680D5D07BEE2DE945A79E3_412783657 =             getQueryPart().getEncoded();
            var592BAA78F9680D5D07BEE2DE945A79E3_412783657.addTaint(taint);
            return var592BAA78F9680D5D07BEE2DE945A79E3_412783657;
            // ---------- Original Method ----------
            //return getQueryPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.568 -0400", hash_original_method = "93492ABD4F9B88C963E84B9F545E5D11", hash_generated_method = "8B410598BD2FA76D90EB509BCC62EC18")
        private String parseQuery() {
            int qsi = uriString.indexOf('?', findSchemeSeparator());
            if(qsi == NOT_FOUND)            
            {
String var540C13E9E156B687226421B24F2DF178_1768666600 =                 null;
                var540C13E9E156B687226421B24F2DF178_1768666600.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1768666600;
            } //End block
            int fsi = findFragmentSeparator();
            if(fsi == NOT_FOUND)            
            {
String var36038C78F7FD108CFC3CF4002250C153_1044101727 =                 uriString.substring(qsi + 1);
                var36038C78F7FD108CFC3CF4002250C153_1044101727.addTaint(taint);
                return var36038C78F7FD108CFC3CF4002250C153_1044101727;
            } //End block
            if(fsi < qsi)            
            {
String var540C13E9E156B687226421B24F2DF178_1175340601 =                 null;
                var540C13E9E156B687226421B24F2DF178_1175340601.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1175340601;
            } //End block
String varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_1268622670 =             uriString.substring(qsi + 1, fsi);
            varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_1268622670.addTaint(taint);
            return varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_1268622670;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.568 -0400", hash_original_method = "31EC40ABD8B86D0064329950E060BFBD", hash_generated_method = "D9DBD52DF085B6C06DCEA47A0A7EBA13")
        public String getQuery() {
String varF32257C5D28B6286E14CC639F868B333_883734688 =             getQueryPart().getDecoded();
            varF32257C5D28B6286E14CC639F868B333_883734688.addTaint(taint);
            return varF32257C5D28B6286E14CC639F868B333_883734688;
            // ---------- Original Method ----------
            //return getQueryPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.568 -0400", hash_original_method = "EAD370CB1FE781DF1864471D9F5F3E36", hash_generated_method = "5B3F22E30D1FBDB513F1FA0EFE9AAF47")
        private Part getFragmentPart() {
Part var8550B3AFC925290D75F2A324FFCC8703_391413042 =             fragment == null
                    ? fragment = Part.fromEncoded(parseFragment()) : fragment;
            var8550B3AFC925290D75F2A324FFCC8703_391413042.addTaint(taint);
            return var8550B3AFC925290D75F2A324FFCC8703_391413042;
            // ---------- Original Method ----------
            //return fragment == null
                    //? fragment = Part.fromEncoded(parseFragment()) : fragment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.568 -0400", hash_original_method = "C2884F3C25114B1CD652E8CCEF7D7F10", hash_generated_method = "8D5B00C85B1946637EE5650A5FAC227E")
        public String getEncodedFragment() {
String var15356DF640E39A7E16838423CF95944B_265488810 =             getFragmentPart().getEncoded();
            var15356DF640E39A7E16838423CF95944B_265488810.addTaint(taint);
            return var15356DF640E39A7E16838423CF95944B_265488810;
            // ---------- Original Method ----------
            //return getFragmentPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.568 -0400", hash_original_method = "13965C7143AC0E622773DBA6AE062E67", hash_generated_method = "C7F1E646EEC3E6EB490F9B41D999036C")
        private String parseFragment() {
            int fsi = findFragmentSeparator();
String varDFC5047C05E36D10FFCD890F81F09AE9_616823519 =             fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
            varDFC5047C05E36D10FFCD890F81F09AE9_616823519.addTaint(taint);
            return varDFC5047C05E36D10FFCD890F81F09AE9_616823519;
            // ---------- Original Method ----------
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.568 -0400", hash_original_method = "4E8163B4F7FDF9829581A99F6274656D", hash_generated_method = "90286C43AE27D87FDB959295130747F1")
        public String getFragment() {
String var93BCD471CAA5DE221487CFBAAF871060_1286352373 =             getFragmentPart().getDecoded();
            var93BCD471CAA5DE221487CFBAAF871060_1286352373.addTaint(taint);
            return var93BCD471CAA5DE221487CFBAAF871060_1286352373;
            // ---------- Original Method ----------
            //return getFragmentPart().getDecoded();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.569 -0400", hash_original_method = "ECB4588CBE3D957B88D2558A4C044374", hash_generated_method = "7D69DE22EED90F732C3E076E632191FB")
        public String toString() {
String varA4F4B44693A1936015581C1F7D6F4DAF_1025895370 =             uriString;
            varA4F4B44693A1936015581C1F7D6F4DAF_1025895370.addTaint(taint);
            return varA4F4B44693A1936015581C1F7D6F4DAF_1025895370;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.569 -0400", hash_original_method = "54B78C0DD1C850213ABB66143A4F5DE7", hash_generated_method = "CFA89F40379C209241ABA8A2CD75CE45")
        public Builder buildUpon() {
            if(isHierarchical())            
            {
Builder varF2D941D0CA5C6E55CED50CE66323299C_2364105 =                 new Builder()
                        .scheme(getScheme())
                        .authority(getAuthorityPart())
                        .path(getPathPart())
                        .query(getQueryPart())
                        .fragment(getFragmentPart());
                varF2D941D0CA5C6E55CED50CE66323299C_2364105.addTaint(taint);
                return varF2D941D0CA5C6E55CED50CE66323299C_2364105;
            } //End block
            else
            {
Builder varC65AC201593175003FC279C7FC3D63BE_1390331118 =                 new Builder()
                        .scheme(getScheme())
                        .opaquePart(getSsp())
                        .fragment(getFragmentPart());
                varC65AC201593175003FC279C7FC3D63BE_1390331118.addTaint(taint);
                return varC65AC201593175003FC279C7FC3D63BE_1390331118;
            } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.569 -0400", hash_original_field = "B0493B2AFC6F39450B0E6998DDC76696", hash_generated_field = "1525B2F69D3B82BDEA81D83890B48CEC")

        static final int TYPE_ID = 1;
    }


    
    private static class OpaqueUri extends Uri {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.569 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.569 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.569 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.569 -0400", hash_original_field = "E4D7B1085B3F20D4D3076206156621A1", hash_generated_field = "FCCD4A0FFBA55911A49FB2AEB7548D00")

        private volatile String cachedString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.570 -0400", hash_original_method = "A3EB90F61BB5DAD9A21709AA9F976DF8", hash_generated_method = "06AECF8220C181EEDE6CDB73AC6F3E82")
        private  OpaqueUri(String scheme, Part ssp, Part fragment) {
            this.scheme = scheme;
            this.ssp = ssp;
            this.fragment = fragment == null ? Part.NULL : fragment;
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //this.ssp = ssp;
            //this.fragment = fragment == null ? Part.NULL : fragment;
        }

        
        @DSModeled(DSC.SPEC)
        static Uri readFrom(Parcel parcel) {
            return new OpaqueUri(
                parcel.readString(),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.570 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D71D305F7E87C31BD9B76C7FD8318192")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_778237449 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668669996 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668669996;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.570 -0400", hash_original_method = "8F996E53ADCFC30BFF794C5CEED4DA61", hash_generated_method = "9E225E24A0B19EF01FE9969CB078EF74")
        public void writeToParcel(Parcel parcel, int flags) {
            addTaint(flags);
            addTaint(parcel.getTaint());
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.570 -0400", hash_original_method = "414EEC63B62C24CE4C288B4F88575946", hash_generated_method = "F6627A2AF480C1A15C245A323B117B90")
        public boolean isHierarchical() {
            boolean var68934A3E9455FA72420237EB05902327_234181423 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796712948 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_796712948;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.570 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "26AD937D52DCF5B184FAC9FEC7259F97")
        public boolean isRelative() {
            boolean var4518A3BFE1F17529286D9D4EFE362EA9_327524359 = (scheme == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302904556 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302904556;
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.570 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "EBD37FCDD8E5DF10CEE859A857C36314")
        public String getScheme() {
String varBF26C0D1E8CB9E7F67A307E664136E8F_1394798367 =             this.scheme;
            varBF26C0D1E8CB9E7F67A307E664136E8F_1394798367.addTaint(taint);
            return varBF26C0D1E8CB9E7F67A307E664136E8F_1394798367;
            // ---------- Original Method ----------
            //return this.scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "3C55B6D4F736410AF7A2ACAB5CCC51ED", hash_generated_method = "B9E0DFE473CE0C86E76CB66FE4DB4F91")
        public String getEncodedSchemeSpecificPart() {
String varD902B0CDE27092B0A8D653D3A1CAB3D2_1786689259 =             ssp.getEncoded();
            varD902B0CDE27092B0A8D653D3A1CAB3D2_1786689259.addTaint(taint);
            return varD902B0CDE27092B0A8D653D3A1CAB3D2_1786689259;
            // ---------- Original Method ----------
            //return ssp.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "ED3540C8D06E41CD645C58A620F36381", hash_generated_method = "A5BE0BA872FDFE261AFEB5AB07E38916")
        public String getSchemeSpecificPart() {
String var754BC27394ACBF326C1E9A754D8A46C9_320441699 =             ssp.getDecoded();
            var754BC27394ACBF326C1E9A754D8A46C9_320441699.addTaint(taint);
            return var754BC27394ACBF326C1E9A754D8A46C9_320441699;
            // ---------- Original Method ----------
            //return ssp.getDecoded();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "31E41E1CB0338F9BAA50A0AC05D7D02D", hash_generated_method = "3CA1CFD64335C94358AF98ABCE3BEFBC")
        public String getAuthority() {
String var540C13E9E156B687226421B24F2DF178_1360889393 =             null;
            var540C13E9E156B687226421B24F2DF178_1360889393.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1360889393;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "C6F3CA63C6BE518EBD2AA32E2786DD3A", hash_generated_method = "9D78F110D25179F7269FA5DC1CB3F682")
        public String getEncodedAuthority() {
String var540C13E9E156B687226421B24F2DF178_1431147006 =             null;
            var540C13E9E156B687226421B24F2DF178_1431147006.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1431147006;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "F489014FCD27D67260CBEC8AC84559A2", hash_generated_method = "7582894F9E6E9CA84431CEA845F5042B")
        public String getPath() {
String var540C13E9E156B687226421B24F2DF178_104703420 =             null;
            var540C13E9E156B687226421B24F2DF178_104703420.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_104703420;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "F167E35F53D1A5A8B17A8A72FE8359AE", hash_generated_method = "00626BABA394BB27EC693829F1A8DE2C")
        public String getEncodedPath() {
String var540C13E9E156B687226421B24F2DF178_867417542 =             null;
            var540C13E9E156B687226421B24F2DF178_867417542.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_867417542;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "2E34959E1DD3631C67E93F1AE6B31056", hash_generated_method = "B6064C5C444680820C27B6B7F906CBF6")
        public String getQuery() {
String var540C13E9E156B687226421B24F2DF178_1750795840 =             null;
            var540C13E9E156B687226421B24F2DF178_1750795840.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1750795840;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "53661DD2D38C9C2E00E8B8D2FF316BB7", hash_generated_method = "5E22C01751FA5F257E563818516D6427")
        public String getEncodedQuery() {
String var540C13E9E156B687226421B24F2DF178_1037525320 =             null;
            var540C13E9E156B687226421B24F2DF178_1037525320.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1037525320;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.571 -0400", hash_original_method = "9F53DDCB73E71AFF4CF207B49D0689B3", hash_generated_method = "AC1537AF22716F1E21BB225C4943F4C4")
        public String getFragment() {
String varAF7E6EDA3A17E940567231584A0703A7_1636020986 =             fragment.getDecoded();
            varAF7E6EDA3A17E940567231584A0703A7_1636020986.addTaint(taint);
            return varAF7E6EDA3A17E940567231584A0703A7_1636020986;
            // ---------- Original Method ----------
            //return fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.572 -0400", hash_original_method = "2FF982E252638134744EE32C0D7F6950", hash_generated_method = "45D0BE57B32413EAD93979846D2163C0")
        public String getEncodedFragment() {
String varC670092882988D295A0AFA2F86B4E2AC_1602544592 =             fragment.getEncoded();
            varC670092882988D295A0AFA2F86B4E2AC_1602544592.addTaint(taint);
            return varC670092882988D295A0AFA2F86B4E2AC_1602544592;
            // ---------- Original Method ----------
            //return fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.572 -0400", hash_original_method = "08B329AF4FAA2768183F76EC45288C10", hash_generated_method = "BD4F003824F943542EEFD74FFD6C5B46")
        public List<String> getPathSegments() {
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_869767726 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_869767726.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_869767726;
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.572 -0400", hash_original_method = "AE7FF2A9DFCB643CF70873B2C08CD5A8", hash_generated_method = "5DCE164093E4522BA3221E67883D0A32")
        public String getLastPathSegment() {
String var540C13E9E156B687226421B24F2DF178_26882699 =             null;
            var540C13E9E156B687226421B24F2DF178_26882699.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_26882699;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.572 -0400", hash_original_method = "520FB960E4127ABC7143DD06EFB52356", hash_generated_method = "7E5FD2A8C6D985EBA34CB13CDC9C5067")
        public String getUserInfo() {
String var540C13E9E156B687226421B24F2DF178_1254453887 =             null;
            var540C13E9E156B687226421B24F2DF178_1254453887.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1254453887;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.572 -0400", hash_original_method = "88ECB0B5D6F4AA907FC3666F8C1418EB", hash_generated_method = "074C1896445817C70871EA1566B9C424")
        public String getEncodedUserInfo() {
String var540C13E9E156B687226421B24F2DF178_1740552767 =             null;
            var540C13E9E156B687226421B24F2DF178_1740552767.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1740552767;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.572 -0400", hash_original_method = "00C71B0865F91AE7EF71B7BE21B14B9F", hash_generated_method = "F3ED3E5C93772A4EA42656B9B60D33C0")
        public String getHost() {
String var540C13E9E156B687226421B24F2DF178_1369154991 =             null;
            var540C13E9E156B687226421B24F2DF178_1369154991.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1369154991;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.572 -0400", hash_original_method = "B159430668427C6760C3FB4B772D9F59", hash_generated_method = "E82D8E608A4A49510C4DA4EE6279988C")
        public int getPort() {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1643557903 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276322953 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276322953;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.572 -0400", hash_original_method = "ACF28BE5516AF44175C2E6962FB03404", hash_generated_method = "EBD192089EF8AE0445192694DA6F5362")
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached = cachedString != NOT_CACHED;
            if(cached)            
            {
String var3B17D0B227025B279C654EE822543E6B_1686515330 =                 cachedString;
                var3B17D0B227025B279C654EE822543E6B_1686515330.addTaint(taint);
                return var3B17D0B227025B279C654EE822543E6B_1686515330;
            } //End block
            StringBuilder sb = new StringBuilder();
            sb.append(scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());
            if(!fragment.isEmpty())            
            {
                sb.append('#').append(fragment.getEncoded());
            } //End block
String varC27FFD0D6D1EF6B53917B2D053C6E05C_641726276 =             cachedString = sb.toString();
            varC27FFD0D6D1EF6B53917B2D053C6E05C_641726276.addTaint(taint);
            return varC27FFD0D6D1EF6B53917B2D053C6E05C_641726276;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_method = "9B1777E9DAB1C1ED3319A4EEC33BCB54", hash_generated_method = "01879C480D7722AB222B4CCF9C33A663")
        public Builder buildUpon() {
Builder varB0D57715B2E1FC2447B5F7A2D1E9683B_1531034479 =             new Builder()
                    .scheme(this.scheme)
                    .opaquePart(this.ssp)
                    .fragment(this.fragment);
            varB0D57715B2E1FC2447B5F7A2D1E9683B_1531034479.addTaint(taint);
            return varB0D57715B2E1FC2447B5F7A2D1E9683B_1531034479;
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(this.scheme)
                    //.opaquePart(this.ssp)
                    //.fragment(this.fragment);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_field = "404FF43CFEE8747368BFDA1DC5DB3B28", hash_generated_field = "81BC425463DB04A2D338A2C363556710")

        static final int TYPE_ID = 2;
    }


    
    static class PathSegments extends AbstractList<String> implements RandomAccess {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

        int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_method = "816AFE27D6484B7E80593A248F7DEC12", hash_generated_method = "F2AFBC317E49E2BF0F98B0C5AE8378FC")
          PathSegments(String[] segments, int size) {
            this.segments = segments;
            this.size = size;
            // ---------- Original Method ----------
            //this.segments = segments;
            //this.size = size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_method = "043CF25E38E9D3A71BE4CC7B6371568E", hash_generated_method = "793ACAB1F161A2EC2C8ACDD2B4EA900C")
        public String get(int index) {
            addTaint(index);
            if(index >= size)            
            {
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_136835942 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_136835942.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_136835942;
            } //End block
String var0670CDC624AB38F74C6CE6D645099017_432209564 =             segments[index];
            var0670CDC624AB38F74C6CE6D645099017_432209564.addTaint(taint);
            return var0670CDC624AB38F74C6CE6D645099017_432209564;
            // ---------- Original Method ----------
            //if (index >= size) {
                //throw new IndexOutOfBoundsException();
            //}
            //return segments[index];
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_method = "BAF1AF8B1284BE94C387C840AF9FA265", hash_generated_method = "F0DF0BDF6473C2D459D38A7DB4A2684C")
        public int size() {
            int varFE91D8EC738CF7D8BE7D802E3604E3B0_619449297 = (this.size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276274195 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276274195;
            // ---------- Original Method ----------
            //return this.size;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_field = "F2217D1D8C4EF2C438C5D90B83E3AD42", hash_generated_field = "E6083199966205833D7B5012129D384D")

        static final PathSegments EMPTY = new PathSegments(null, 0);
    }


    
    static class PathSegmentsBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.573 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

        int size = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_method = "CD5B4727D6775EBFE00461F5F237812D", hash_generated_method = "CD5B4727D6775EBFE00461F5F237812D")
        public PathSegmentsBuilder ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_method = "F05B9B5ECB44DE7CFF27782486F28CF3", hash_generated_method = "57396C99D23B797B3C467EFAA3744A8B")
         void add(String segment) {
            if(segments == null)            
            {
                segments = new String[4];
            } //End block
            else
            if(size + 1 == segments.length)            
            {
                String[] expanded = new String[segments.length * 2];
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_method = "497F2229989230601A3120EEAF21B251", hash_generated_method = "BE1FB8928B4CADA9775AF2D439C579B3")
         PathSegments build() {
            if(segments == null)            
            {
PathSegments var61ED7A3446E992CC1D6CE996343F0BB7_2081726430 =                 PathSegments.EMPTY;
                var61ED7A3446E992CC1D6CE996343F0BB7_2081726430.addTaint(taint);
                return var61ED7A3446E992CC1D6CE996343F0BB7_2081726430;
            } //End block
            try 
            {
PathSegments varF93FC2B9FE269AF50DE5689CD2FB3B65_1167847616 =                 new PathSegments(segments, size);
                varF93FC2B9FE269AF50DE5689CD2FB3B65_1167847616.addTaint(taint);
                return varF93FC2B9FE269AF50DE5689CD2FB3B65_1167847616;
            } //End block
            finally 
            {
                segments = null;
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "87B54E118334D4593A462325E6A65F84")

        private Part userInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_field = "38B3753700D5B450CB30995B4DB5AF95", hash_generated_field = "539F6E6D25356608852D958A8481FDA5")

        private volatile String host = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_field = "38113C68733F87156C438BEBC2FCB827", hash_generated_field = "3DEE2B327E62FC31F0BA9783EFE62CA9")

        private volatile int port = NOT_CALCULATED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_method = "469DE423ED30903E9EDD58224AA80D56", hash_generated_method = "469DE423ED30903E9EDD58224AA80D56")
        public AbstractHierarchicalUri ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_method = "D5E71CFA6EED35AEB9B5F4AEC5287C3B", hash_generated_method = "EA087EFBB35991B0403EA905A8FA516C")
        public String getLastPathSegment() {
            List<String> segments = getPathSegments();
            int size = segments.size();
            if(size == 0)            
            {
String var540C13E9E156B687226421B24F2DF178_2038453379 =                 null;
                var540C13E9E156B687226421B24F2DF178_2038453379.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2038453379;
            } //End block
String varEFCF283257D160202712C81EC6306DA0_577866392 =             segments.get(size - 1);
            varEFCF283257D160202712C81EC6306DA0_577866392.addTaint(taint);
            return varEFCF283257D160202712C81EC6306DA0_577866392;
            // ---------- Original Method ----------
            //List<String> segments = getPathSegments();
            //int size = segments.size();
            //if (size == 0) {
                //return null;
            //}
            //return segments.get(size - 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.574 -0400", hash_original_method = "739BBE935CAE826F3703E2BBB77B819C", hash_generated_method = "B6B5CBBFB2941951E9CFA70395D0666A")
        private Part getUserInfoPart() {
Part varF7E738A42E6D63EB0326855BC730BADF_540057556 =             userInfo == null
                    ? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
            varF7E738A42E6D63EB0326855BC730BADF_540057556.addTaint(taint);
            return varF7E738A42E6D63EB0326855BC730BADF_540057556;
            // ---------- Original Method ----------
            //return userInfo == null
                    //? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.575 -0400", hash_original_method = "EADAAD26DC8689BCA10DCA33883B9323", hash_generated_method = "A235F23D4789F69706E251C6D9E520B1")
        public final String getEncodedUserInfo() {
String var09E3B0803DBA809E674A74FBBA3FD409_2116496451 =             getUserInfoPart().getEncoded();
            var09E3B0803DBA809E674A74FBBA3FD409_2116496451.addTaint(taint);
            return var09E3B0803DBA809E674A74FBBA3FD409_2116496451;
            // ---------- Original Method ----------
            //return getUserInfoPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.575 -0400", hash_original_method = "10E379B7D06266EDAAC672E10EB0F58B", hash_generated_method = "B8DB776BC4872FFD1B916610F298AE91")
        private String parseUserInfo() {
            String authority = getEncodedAuthority();
            if(authority == null)            
            {
String var540C13E9E156B687226421B24F2DF178_2005039794 =                 null;
                var540C13E9E156B687226421B24F2DF178_2005039794.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2005039794;
            } //End block
            int end = authority.indexOf('@');
String var9D68F14379A550242867922C161646A9_926535294 =             end == NOT_FOUND ? null : authority.substring(0, end);
            var9D68F14379A550242867922C161646A9_926535294.addTaint(taint);
            return var9D68F14379A550242867922C161646A9_926535294;
            // ---------- Original Method ----------
            //String authority = getEncodedAuthority();
            //if (authority == null) {
                //return null;
            //}
            //int end = authority.indexOf('@');
            //return end == NOT_FOUND ? null : authority.substring(0, end);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.575 -0400", hash_original_method = "575ECF6860F7EEFE5055BF56F2601A0E", hash_generated_method = "F2AC848BF056546FCFADE2776868F344")
        public String getUserInfo() {
String varB4A42524A46C4FAD7FBAC514070D2A61_34678447 =             getUserInfoPart().getDecoded();
            varB4A42524A46C4FAD7FBAC514070D2A61_34678447.addTaint(taint);
            return varB4A42524A46C4FAD7FBAC514070D2A61_34678447;
            // ---------- Original Method ----------
            //return getUserInfoPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.576 -0400", hash_original_method = "2FC22A6CCA0A3F4C0B9E4C09F79A556D", hash_generated_method = "D534E69D11B2DAC2F4121F2AAE799563")
        public String getHost() {
            @SuppressWarnings("StringEquality") boolean cached = (host != NOT_CACHED);
String var8FB9745AFEFD90E610A95B02DD737746_86711358 =             cached ? host
                    : (host = parseHost());
            var8FB9745AFEFD90E610A95B02DD737746_86711358.addTaint(taint);
            return var8FB9745AFEFD90E610A95B02DD737746_86711358;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (host != NOT_CACHED);
            //return cached ? host
                    //: (host = parseHost());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.576 -0400", hash_original_method = "F3410DE0DFF96D0677FF54552E852FC4", hash_generated_method = "0FE72B4DB819FF6DDAD061284385303E")
        private String parseHost() {
            String authority = getEncodedAuthority();
            if(authority == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1373073359 =                 null;
                var540C13E9E156B687226421B24F2DF178_1373073359.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1373073359;
            } //End block
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);
            String encodedHost = portSeparator == NOT_FOUND
                    ? authority.substring(userInfoSeparator + 1)
                    : authority.substring(userInfoSeparator + 1, portSeparator);
String var608417B3BC2F90A7AFAAFAF8F1F376E0_1608226449 =             decode(encodedHost);
            var608417B3BC2F90A7AFAAFAF8F1F376E0_1608226449.addTaint(taint);
            return var608417B3BC2F90A7AFAAFAF8F1F376E0_1608226449;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.576 -0400", hash_original_method = "A497EF38F72042FD9397DCB617BC4BBC", hash_generated_method = "1A769FE7B7AF1B76BC5CC9F004CAD36B")
        public int getPort() {
            int var7D5469D2554BBE8BEA01480744CB64B8_1375076527 = (port == NOT_CALCULATED
                    ? port = parsePort()
                    : port);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730111507 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730111507;
            // ---------- Original Method ----------
            //return port == NOT_CALCULATED
                    //? port = parsePort()
                    //: port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.576 -0400", hash_original_method = "5469820A1C15A09B87242C85BC223022", hash_generated_method = "FA16E48F01FC24247CAA8DBB624BF0C0")
        private int parsePort() {
            String authority = getEncodedAuthority();
            if(authority == null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_880490025 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826309050 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826309050;
            } //End block
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);
            if(portSeparator == NOT_FOUND)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1282293529 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238770796 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238770796;
            } //End block
            String portString = decode(authority.substring(portSeparator + 1));
            try 
            {
                int varFBDD8FEF87E1A48D29F5CB7C1376F258_1167697878 = (Integer.parseInt(portString));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330539921 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330539921;
            } //End block
            catch (NumberFormatException e)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1345680027 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039241131 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039241131;
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.577 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.577 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.577 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.577 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.577 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.577 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.577 -0400", hash_original_field = "2BBB7D14660BA196C018E7EF1E07014A", hash_generated_field = "9968E15A97464199002C3D2A70E60BF1")

        private volatile String uriString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.578 -0400", hash_original_method = "4B8A4922E90F4F5C5F11CB942A244C7D", hash_generated_method = "68A9127EDB06137E28202F2E575DFD47")
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

        
        @DSModeled(DSC.SPEC)
        static Uri readFrom(Parcel parcel) {
            return new HierarchicalUri(
                parcel.readString(),
                Part.readFrom(parcel),
                PathPart.readFrom(parcel),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.579 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4F832AD7F6CEED74DEFD919EAC078D41")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1479508355 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076241323 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076241323;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.579 -0400", hash_original_method = "601AB6BE7C1B16F2DB83E078DF9B61DC", hash_generated_method = "6A38504F7EF3B41458C9CFB61B747E71")
        public void writeToParcel(Parcel parcel, int flags) {
            addTaint(flags);
            addTaint(parcel.getTaint());
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.579 -0400", hash_original_method = "3471DB7575AAB7FBFD2140BF4AB89F77", hash_generated_method = "6D6A0D8783E48C273E07EF71B134ECB9")
        public boolean isHierarchical() {
            boolean varB326B5062B2F0E69046810717534CB09_1622567651 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996262863 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996262863;
            // ---------- Original Method ----------
            //return true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.579 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "C71BC3EB3160C2E743A88A6B730576ED")
        public boolean isRelative() {
            boolean var4518A3BFE1F17529286D9D4EFE362EA9_954823205 = (scheme == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403668166 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_403668166;
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.580 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "6995BFF68FFBDD93B49FE6CEF0CEEE6E")
        public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_1839685147 =             scheme;
            varFD3305CF8340E40F0AC0AB554909AEBC_1839685147.addTaint(taint);
            return varFD3305CF8340E40F0AC0AB554909AEBC_1839685147;
            // ---------- Original Method ----------
            //return scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.581 -0400", hash_original_method = "6F57A7CA1E43F50667C0921A8F0F4C1E", hash_generated_method = "DB2AC856D9F674ADAB2DED039660161D")
        private Part getSsp() {
Part var612ADADF05B7551B37A539180151D856_792649281 =             ssp == null
                    ? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
            var612ADADF05B7551B37A539180151D856_792649281.addTaint(taint);
            return var612ADADF05B7551B37A539180151D856_792649281;
            // ---------- Original Method ----------
            //return ssp == null
                    //? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.581 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "C5D93D7C700738FCCDA7C43A307A63B9")
        public String getEncodedSchemeSpecificPart() {
String var393D011CD485FB233FC4BE4326461491_1548544534 =             getSsp().getEncoded();
            var393D011CD485FB233FC4BE4326461491_1548544534.addTaint(taint);
            return var393D011CD485FB233FC4BE4326461491_1548544534;
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.581 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "9EE7400DE02A4D5DAB09220830052529")
        public String getSchemeSpecificPart() {
String varDEA78A046E5755E6A172773CC85259A6_1766392902 =             getSsp().getDecoded();
            varDEA78A046E5755E6A172773CC85259A6_1766392902.addTaint(taint);
            return varDEA78A046E5755E6A172773CC85259A6_1766392902;
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.581 -0400", hash_original_method = "EA75444742B675900BB1383BC22E224C", hash_generated_method = "1E27DF33412D3DD6A3D20BC3ECD6EC90")
        private String makeSchemeSpecificPart() {
            StringBuilder builder = new StringBuilder();
            appendSspTo(builder);
String varF4CF030572656354ACFDF83FEE21D7A6_1668621932 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_1668621932.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_1668621932;
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //appendSspTo(builder);
            //return builder.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.581 -0400", hash_original_method = "55EA79AD41E607B8DD0B042A78040234", hash_generated_method = "6482B19B506A7357F59DD4CC14EB48C5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.582 -0400", hash_original_method = "4FC7F3346B5C0FC1519928E52B2843FB", hash_generated_method = "52AAEAC70D3D3CFBDF7BCE1272471E47")
        public String getAuthority() {
String varDD511262F0E7679CA44A2E8218470028_1844446681 =             this.authority.getDecoded();
            varDD511262F0E7679CA44A2E8218470028_1844446681.addTaint(taint);
            return varDD511262F0E7679CA44A2E8218470028_1844446681;
            // ---------- Original Method ----------
            //return this.authority.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.582 -0400", hash_original_method = "02F0907154122B499105718EFAFFB12D", hash_generated_method = "9C4646CA98BC8A984F3D3A61568EE60C")
        public String getEncodedAuthority() {
String var19AE63614558C7149808DBD062B65B6B_959093011 =             this.authority.getEncoded();
            var19AE63614558C7149808DBD062B65B6B_959093011.addTaint(taint);
            return var19AE63614558C7149808DBD062B65B6B_959093011;
            // ---------- Original Method ----------
            //return this.authority.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.582 -0400", hash_original_method = "C2F72FED192DF0C1254C49B5EAFF6B37", hash_generated_method = "32CB156686CA8D5CC9CE853720650394")
        public String getEncodedPath() {
String varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_1945471599 =             this.path.getEncoded();
            varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_1945471599.addTaint(taint);
            return varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_1945471599;
            // ---------- Original Method ----------
            //return this.path.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.582 -0400", hash_original_method = "6081DF09BF7A0319CE8B8794EF03DD3D", hash_generated_method = "521CED1310FE658E645AF630CCF0A0DC")
        public String getPath() {
String var83F9CE5C9BAF5C5C429C86F8D8178641_1044350044 =             this.path.getDecoded();
            var83F9CE5C9BAF5C5C429C86F8D8178641_1044350044.addTaint(taint);
            return var83F9CE5C9BAF5C5C429C86F8D8178641_1044350044;
            // ---------- Original Method ----------
            //return this.path.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.585 -0400", hash_original_method = "BB14E9B85B4B70FE8537ADEAEA0F30F8", hash_generated_method = "BBF34C9E04617B60B78D61B2916D9A30")
        public String getQuery() {
String var0FC25D767B999B6312889F23BA6B3E21_1745676423 =             this.query.getDecoded();
            var0FC25D767B999B6312889F23BA6B3E21_1745676423.addTaint(taint);
            return var0FC25D767B999B6312889F23BA6B3E21_1745676423;
            // ---------- Original Method ----------
            //return this.query.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.585 -0400", hash_original_method = "4E4841C1D3AAC7E9E3EC5666E1D3BDC7", hash_generated_method = "033670BC2A2283988C02BE14338673FF")
        public String getEncodedQuery() {
String varD80217C924F7F40BAC074946FDBADEEC_1418321578 =             this.query.getEncoded();
            varD80217C924F7F40BAC074946FDBADEEC_1418321578.addTaint(taint);
            return varD80217C924F7F40BAC074946FDBADEEC_1418321578;
            // ---------- Original Method ----------
            //return this.query.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.585 -0400", hash_original_method = "BC71EA5136922A2C431D19FA4D7E797E", hash_generated_method = "41372F5FFA26EB9EAF0836E4DAB82201")
        public String getFragment() {
String varD91F6287F55E70D82879F259060BB4F7_594496462 =             this.fragment.getDecoded();
            varD91F6287F55E70D82879F259060BB4F7_594496462.addTaint(taint);
            return varD91F6287F55E70D82879F259060BB4F7_594496462;
            // ---------- Original Method ----------
            //return this.fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.585 -0400", hash_original_method = "D0BDA4E24821D7C40932E823B160DCAD", hash_generated_method = "FBD10D794EC68AF9B890D0B8CE2C51E6")
        public String getEncodedFragment() {
String var9BE81904ABD2B0EBFE2214CE0EE4BBFD_34142790 =             this.fragment.getEncoded();
            var9BE81904ABD2B0EBFE2214CE0EE4BBFD_34142790.addTaint(taint);
            return var9BE81904ABD2B0EBFE2214CE0EE4BBFD_34142790;
            // ---------- Original Method ----------
            //return this.fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.585 -0400", hash_original_method = "6A1F2A59685BCA2552F3B76D88CB5845", hash_generated_method = "3E9CB02A953481C7E6963B224060FE82")
        public List<String> getPathSegments() {
List<String> varA8049C752B325D0BCB78F1A90EC0D736_826742052 =             this.path.getPathSegments();
            varA8049C752B325D0BCB78F1A90EC0D736_826742052.addTaint(taint);
            return varA8049C752B325D0BCB78F1A90EC0D736_826742052;
            // ---------- Original Method ----------
            //return this.path.getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.585 -0400", hash_original_method = "2FFEEC7D33EBEEF04178DF9D921CBC02", hash_generated_method = "F19AA148C0B171478C3A59069B5C2062")
        @Override
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached = (uriString != NOT_CACHED);
String var9B86F3459D079E341060C628CFD4EC8E_1490582607 =             cached ? uriString
                    : (uriString = makeUriString());
            var9B86F3459D079E341060C628CFD4EC8E_1490582607.addTaint(taint);
            return var9B86F3459D079E341060C628CFD4EC8E_1490582607;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (uriString != NOT_CACHED);
            //return cached ? uriString
                    //: (uriString = makeUriString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.585 -0400", hash_original_method = "5AECD242275C33F74DCA414A6C8DF5D7", hash_generated_method = "5A3C8AD7B7EB3853BEDD741B3A79B739")
        private String makeUriString() {
            StringBuilder builder = new StringBuilder();
            if(scheme != null)            
            {
                builder.append(scheme).append(':');
            } //End block
            appendSspTo(builder);
            if(!fragment.isEmpty())            
            {
                builder.append('#').append(fragment.getEncoded());
            } //End block
String varF4CF030572656354ACFDF83FEE21D7A6_1527676801 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_1527676801.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_1527676801;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.586 -0400", hash_original_method = "6635CD2DD122D7EE5F14A5F21B272B08", hash_generated_method = "9D7A06606E4D80468986C2C2E34B67C5")
        public Builder buildUpon() {
Builder varED3F8822050435D1DCF8FEEC1E3625B3_1504337175 =             new Builder()
                    .scheme(scheme)
                    .authority(authority)
                    .path(path)
                    .query(query)
                    .fragment(fragment);
            varED3F8822050435D1DCF8FEEC1E3625B3_1504337175.addTaint(taint);
            return varED3F8822050435D1DCF8FEEC1E3625B3_1504337175;
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(scheme)
                    //.authority(authority)
                    //.path(path)
                    //.query(query)
                    //.fragment(fragment);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.586 -0400", hash_original_field = "1A6BAB54CA68848B2D28EFB422CF1725", hash_generated_field = "F1F90627D661D3D25ABE19AF04422DA0")

        static final int TYPE_ID = 3;
    }


    
    public static final class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.586 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.586 -0400", hash_original_field = "E17823015F179701BCEC9CD4356C4A38", hash_generated_field = "F30F644E178A706F0279AC78D6913562")

        private Part opaquePart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.586 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.586 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.586 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.593 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.594 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "7F0D829FE2A4B9F217489244A9FD2E61")
        public  Builder() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.594 -0400", hash_original_method = "1FAF048543AEDF54BF8218C15362FDC3", hash_generated_method = "402B22F32E551A44FDAAF8C0B47EAB6E")
        public Builder scheme(String scheme) {
            this.scheme = scheme;
Builder var72A74007B2BE62B849F475C7BDA4658B_722342005 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_722342005.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_722342005;
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.594 -0400", hash_original_method = "8D4C2B402A916DF01BF39AF004B22B4B", hash_generated_method = "B0F5C6E88BA782CF2C95A93109C85BB1")
         Builder opaquePart(Part opaquePart) {
            this.opaquePart = opaquePart;
Builder var72A74007B2BE62B849F475C7BDA4658B_494493155 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_494493155.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_494493155;
            // ---------- Original Method ----------
            //this.opaquePart = opaquePart;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.594 -0400", hash_original_method = "B04C2A20C29308DA58A03AAA34E4602D", hash_generated_method = "DD3B1521C12B16D9277BDA39AC1F6013")
        public Builder opaquePart(String opaquePart) {
            addTaint(opaquePart.getTaint());
Builder var447EF4E65B1A86D27C660BD3406092A1_84109580 =             opaquePart(Part.fromDecoded(opaquePart));
            var447EF4E65B1A86D27C660BD3406092A1_84109580.addTaint(taint);
            return var447EF4E65B1A86D27C660BD3406092A1_84109580;
            // ---------- Original Method ----------
            //return opaquePart(Part.fromDecoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.594 -0400", hash_original_method = "E3AC90668DB82124786DAC21400DF68F", hash_generated_method = "E768F3717DB1CE7AE18865D2385201A0")
        public Builder encodedOpaquePart(String opaquePart) {
            addTaint(opaquePart.getTaint());
Builder var34CFA2F802F04C1F00EC4E996B5D7270_1882006054 =             opaquePart(Part.fromEncoded(opaquePart));
            var34CFA2F802F04C1F00EC4E996B5D7270_1882006054.addTaint(taint);
            return var34CFA2F802F04C1F00EC4E996B5D7270_1882006054;
            // ---------- Original Method ----------
            //return opaquePart(Part.fromEncoded(opaquePart));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.595 -0400", hash_original_method = "CE12FA6D2315F74B1A3B79C027FFFA6D", hash_generated_method = "B78B9C4418BFCAB498199097CAE1B101")
         Builder authority(Part authority) {
            this.opaquePart = null;
            this.authority = authority;
Builder var72A74007B2BE62B849F475C7BDA4658B_96846340 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_96846340.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_96846340;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.authority = authority;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.595 -0400", hash_original_method = "8B987B114EF487282F33A481DCB273CB", hash_generated_method = "AF91ECF257D9FE86332B9D941466260F")
        public Builder authority(String authority) {
            addTaint(authority.getTaint());
Builder var2EDA88150582111521EDC9CAB7001682_1241099465 =             authority(Part.fromDecoded(authority));
            var2EDA88150582111521EDC9CAB7001682_1241099465.addTaint(taint);
            return var2EDA88150582111521EDC9CAB7001682_1241099465;
            // ---------- Original Method ----------
            //return authority(Part.fromDecoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.595 -0400", hash_original_method = "2AF9D1463857894BBB2A3B7E377A77BB", hash_generated_method = "D60ABBF18309439F38B322632B74E9BD")
        public Builder encodedAuthority(String authority) {
            addTaint(authority.getTaint());
Builder var426370EFE7B4302B3E1C247DE7CA1F10_1665490766 =             authority(Part.fromEncoded(authority));
            var426370EFE7B4302B3E1C247DE7CA1F10_1665490766.addTaint(taint);
            return var426370EFE7B4302B3E1C247DE7CA1F10_1665490766;
            // ---------- Original Method ----------
            //return authority(Part.fromEncoded(authority));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.595 -0400", hash_original_method = "0552AFD7FA04CD9C4E588C7FB644B387", hash_generated_method = "14D50D1D9D855F3AB2AF0ADB6C3CA073")
         Builder path(PathPart path) {
            this.opaquePart = null;
            this.path = path;
Builder var72A74007B2BE62B849F475C7BDA4658B_289922558 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_289922558.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_289922558;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.path = path;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.595 -0400", hash_original_method = "311D5047B3596F1C34DEC3DA1D1264C5", hash_generated_method = "EE78580C89F5DEDDA155BB4C78474741")
        public Builder path(String path) {
            addTaint(path.getTaint());
Builder varE93D7008AE3144DB58924E5F7D03413A_1450572146 =             path(PathPart.fromDecoded(path));
            varE93D7008AE3144DB58924E5F7D03413A_1450572146.addTaint(taint);
            return varE93D7008AE3144DB58924E5F7D03413A_1450572146;
            // ---------- Original Method ----------
            //return path(PathPart.fromDecoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.595 -0400", hash_original_method = "B2733F0C4852B782EB87F01613E6C574", hash_generated_method = "95562AB67A3AA1260A521F056699D39F")
        public Builder encodedPath(String path) {
            addTaint(path.getTaint());
Builder var2C099BD4CBAC004E7DBA3E062586EF05_393448635 =             path(PathPart.fromEncoded(path));
            var2C099BD4CBAC004E7DBA3E062586EF05_393448635.addTaint(taint);
            return var2C099BD4CBAC004E7DBA3E062586EF05_393448635;
            // ---------- Original Method ----------
            //return path(PathPart.fromEncoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.595 -0400", hash_original_method = "818DCEC2192004BCFE40E4E49FDA7A4C", hash_generated_method = "DEAF6462A7C89C2A6141D470DBBCA296")
        public Builder appendPath(String newSegment) {
            addTaint(newSegment.getTaint());
Builder var8D3C52E329AACC9BA26FC60EDBDA633E_1231330332 =             path(PathPart.appendDecodedSegment(path, newSegment));
            var8D3C52E329AACC9BA26FC60EDBDA633E_1231330332.addTaint(taint);
            return var8D3C52E329AACC9BA26FC60EDBDA633E_1231330332;
            // ---------- Original Method ----------
            //return path(PathPart.appendDecodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.596 -0400", hash_original_method = "04B6E07373B5BCB6E5F5541B11BC55A7", hash_generated_method = "8954EF8E27E96CB9B4ABA726E1D7B0DB")
        public Builder appendEncodedPath(String newSegment) {
            addTaint(newSegment.getTaint());
Builder var15BBA848D385BBCE5F9325C9F07D3D5A_1349472841 =             path(PathPart.appendEncodedSegment(path, newSegment));
            var15BBA848D385BBCE5F9325C9F07D3D5A_1349472841.addTaint(taint);
            return var15BBA848D385BBCE5F9325C9F07D3D5A_1349472841;
            // ---------- Original Method ----------
            //return path(PathPart.appendEncodedSegment(path, newSegment));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.597 -0400", hash_original_method = "526B00AFFC674BC410AFF0DB5058AD68", hash_generated_method = "CB07D75382C585A19AF8BCDDD00E523D")
         Builder query(Part query) {
            this.opaquePart = null;
            this.query = query;
Builder var72A74007B2BE62B849F475C7BDA4658B_760064989 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_760064989.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_760064989;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.query = query;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.597 -0400", hash_original_method = "915051404F16544BAB27A534573CC34D", hash_generated_method = "A62E46F9AECE60C73B39DBEAB36444B1")
        public Builder query(String query) {
            addTaint(query.getTaint());
Builder var66923BEC3D8C1278767576BF4D394152_616978471 =             query(Part.fromDecoded(query));
            var66923BEC3D8C1278767576BF4D394152_616978471.addTaint(taint);
            return var66923BEC3D8C1278767576BF4D394152_616978471;
            // ---------- Original Method ----------
            //return query(Part.fromDecoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.597 -0400", hash_original_method = "2B1CFFF6E8520529FC529F01B5DBCD04", hash_generated_method = "9E0288B5BCC64F0F39F51F6F214BE944")
        public Builder encodedQuery(String query) {
            addTaint(query.getTaint());
Builder var05319EFE71D4D5FABCEFB5394AF0F3A4_65962828 =             query(Part.fromEncoded(query));
            var05319EFE71D4D5FABCEFB5394AF0F3A4_65962828.addTaint(taint);
            return var05319EFE71D4D5FABCEFB5394AF0F3A4_65962828;
            // ---------- Original Method ----------
            //return query(Part.fromEncoded(query));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.597 -0400", hash_original_method = "AAD8E80453C4B46D11B41869FDCBA00D", hash_generated_method = "94D3F7937EDD2A5EA3D6B41458FDA7D6")
         Builder fragment(Part fragment) {
            this.fragment = fragment;
Builder var72A74007B2BE62B849F475C7BDA4658B_1656707604 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1656707604.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1656707604;
            // ---------- Original Method ----------
            //this.fragment = fragment;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.597 -0400", hash_original_method = "016C309F39EF5D90CF32B95F6FDB27F8", hash_generated_method = "513822E1AFB69F702F5ECF9BF1CEEEC9")
        public Builder fragment(String fragment) {
            addTaint(fragment.getTaint());
Builder var8A0E66BF4149A1703B51D880CE7BD3FB_1255831276 =             fragment(Part.fromDecoded(fragment));
            var8A0E66BF4149A1703B51D880CE7BD3FB_1255831276.addTaint(taint);
            return var8A0E66BF4149A1703B51D880CE7BD3FB_1255831276;
            // ---------- Original Method ----------
            //return fragment(Part.fromDecoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.597 -0400", hash_original_method = "C5F51A11F0BEF63CCF4FD5F6AF742648", hash_generated_method = "4951CE4F38B86378FBB6A406A930F1C6")
        public Builder encodedFragment(String fragment) {
            addTaint(fragment.getTaint());
Builder varF653F4C1C1E12E452895547E2A8D497C_727369764 =             fragment(Part.fromEncoded(fragment));
            varF653F4C1C1E12E452895547E2A8D497C_727369764.addTaint(taint);
            return varF653F4C1C1E12E452895547E2A8D497C_727369764;
            // ---------- Original Method ----------
            //return fragment(Part.fromEncoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.601 -0400", hash_original_method = "F83D70A0FC90543F01AB6385367098CC", hash_generated_method = "C33BEE1EC03CA65D04AF67CE59E3339E")
        public Builder appendQueryParameter(String key, String value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            this.opaquePart = null;
            String encodedParameter = encode(key, null) + "="
                    + encode(value, null);
            if(query == null)            
            {
                query = Part.fromEncoded(encodedParameter);
Builder var72A74007B2BE62B849F475C7BDA4658B_979720811 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_979720811.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_979720811;
            } //End block
            String oldQuery = query.getEncoded();
            if(oldQuery == null || oldQuery.length() == 0)            
            {
                query = Part.fromEncoded(encodedParameter);
            } //End block
            else
            {
                query = Part.fromEncoded(oldQuery + "&" + encodedParameter);
            } //End block
Builder var72A74007B2BE62B849F475C7BDA4658B_1642664029 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1642664029.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1642664029;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.601 -0400", hash_original_method = "581A1CF068B5634C1F252DE7C2737E06", hash_generated_method = "286DD42F90579E73B00C950F476B07FF")
        public Builder clearQuery() {
Builder var53FE33D9FA667E351CE36A4E53159F37_1011402667 =             query((Part) null);
            var53FE33D9FA667E351CE36A4E53159F37_1011402667.addTaint(taint);
            return var53FE33D9FA667E351CE36A4E53159F37_1011402667;
            // ---------- Original Method ----------
            //return query((Part) null);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.601 -0400", hash_original_method = "C36CE5067F02DA1F1C7276BF67665A1B", hash_generated_method = "6D3155A9E94E4CCE71A96A3DC3B20A30")
        public Uri build() {
            if(opaquePart != null)            
            {
                if(this.scheme == null)                
                {
                    UnsupportedOperationException varBBE90DF2A7DE2FEB6E102C54C2A10961_1767941199 = new UnsupportedOperationException(
                            "An opaque URI must have a scheme.");
                    varBBE90DF2A7DE2FEB6E102C54C2A10961_1767941199.addTaint(taint);
                    throw varBBE90DF2A7DE2FEB6E102C54C2A10961_1767941199;
                } //End block
Uri varBD7EC89A1E53A9CF305CC36AF2561E02_1770099967 =                 new OpaqueUri(scheme, opaquePart, fragment);
                varBD7EC89A1E53A9CF305CC36AF2561E02_1770099967.addTaint(taint);
                return varBD7EC89A1E53A9CF305CC36AF2561E02_1770099967;
            } //End block
            else
            {
                PathPart path = this.path;
                if(path == null || path == PathPart.NULL)                
                {
                    path = PathPart.EMPTY;
                } //End block
                else
                {
                    if(hasSchemeOrAuthority())                    
                    {
                        path = PathPart.makeAbsolute(path);
                    } //End block
                } //End block
Uri var1A5C773E6B2C9527C52233E0D175F391_1424051451 =                 new HierarchicalUri(
                        scheme, authority, path, query, fragment);
                var1A5C773E6B2C9527C52233E0D175F391_1424051451.addTaint(taint);
                return var1A5C773E6B2C9527C52233E0D175F391_1424051451;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.602 -0400", hash_original_method = "7917AD3B49169A1AC8EEA7DD014B7E45", hash_generated_method = "FF2D3536CBA1599058C695E7CF027B7B")
        private boolean hasSchemeOrAuthority() {
            boolean var66F0DE1EAD0A64E28D3A3FCCC8CAE0D4_578380994 = (scheme != null
                    || (authority != null && authority != Part.NULL));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622971407 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622971407;
            // ---------- Original Method ----------
            //return scheme != null
                    //|| (authority != null && authority != Part.NULL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.602 -0400", hash_original_method = "50FC77E3DFFDDD2DB7D0B749912434F7", hash_generated_method = "7C6A55311883C1ED8B46AA70A217BC7B")
        @Override
        public String toString() {
String var83CCC8E6DBC69F3499A1E5AC609A34CF_2125315496 =             build().toString();
            var83CCC8E6DBC69F3499A1E5AC609A34CF_2125315496.addTaint(taint);
            return var83CCC8E6DBC69F3499A1E5AC609A34CF_2125315496;
            // ---------- Original Method ----------
            //return build().toString();
        }

        
    }


    
    static abstract class AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.602 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "08274B7EEBA921030ECC3D76D1E6ECCB")

        volatile String encoded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.602 -0400", hash_original_field = "AD05458423E19C1FF1F3C0237F8CFBED", hash_generated_field = "B682B941676F7CF6A565D2078C9BC0A9")

        volatile String decoded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.603 -0400", hash_original_method = "21E01F693530948BFE81E2C9AE8C6D31", hash_generated_method = "00DF56A1D35C3F914A2155477BDE237F")
          AbstractPart(String encoded, String decoded) {
            this.encoded = encoded;
            this.decoded = decoded;
            // ---------- Original Method ----------
            //this.encoded = encoded;
            //this.decoded = decoded;
        }

        
        @DSModeled(DSC.SAFE)
        abstract String getEncoded();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.603 -0400", hash_original_method = "06323BBC323E7F59CEDDE1FAA04ED1F6", hash_generated_method = "ECB35ECFDCBD99C27C190F645832DBC1")
        final String getDecoded() {
            @SuppressWarnings("StringEquality") boolean hasDecoded = decoded != NOT_CACHED;
String varF9DE9787DBBABACF674820C53FE77B7A_1987488811 =             hasDecoded ? decoded : (decoded = decode(encoded));
            varF9DE9787DBBABACF674820C53FE77B7A_1987488811.addTaint(taint);
            return varF9DE9787DBBABACF674820C53FE77B7A_1987488811;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasDecoded = decoded != NOT_CACHED;
            //return hasDecoded ? decoded : (decoded = decode(encoded));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.604 -0400", hash_original_method = "BB7E54AFB81798C035BF3B3717F470E7", hash_generated_method = "65F494771ED40569A915752704BA6CB8")
        final void writeTo(Parcel parcel) {
            addTaint(parcel.getTaint());
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
            @SuppressWarnings("StringEquality") boolean hasDecoded = decoded != NOT_CACHED;
            if(hasEncoded && hasDecoded)            
            {
                parcel.writeInt(Representation.BOTH);
                parcel.writeString(encoded);
                parcel.writeString(decoded);
            } //End block
            else
            if(hasEncoded)            
            {
                parcel.writeInt(Representation.ENCODED);
                parcel.writeString(encoded);
            } //End block
            else
            if(hasDecoded)            
            {
                parcel.writeInt(Representation.DECODED);
                parcel.writeString(decoded);
            } //End block
            else
            {
                IllegalArgumentException var25F0B2A44934D2D997027BC02866E4A5_1684579461 = new IllegalArgumentException("Neither encoded nor decoded");
                var25F0B2A44934D2D997027BC02866E4A5_1684579461.addTaint(taint);
                throw var25F0B2A44934D2D997027BC02866E4A5_1684579461;
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.604 -0400", hash_original_method = "49186660D0AEF0721F749C758CF0FE34", hash_generated_method = "49186660D0AEF0721F749C758CF0FE34")
            public Representation ()
            {
                //Synthesized constructor
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.604 -0400", hash_original_field = "659BA2B3286FF6C4923CFE851F3CD42E", hash_generated_field = "FF4F4E4C6DA0CB1E3DB9C13C6C3A4A5B")

            static final int BOTH = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.604 -0400", hash_original_field = "D22FD9F8AEEC62F2AEF921B20283C7C9", hash_generated_field = "A15D22B3282778C07B2BEC94A0EE0FD2")

            static final int ENCODED = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.604 -0400", hash_original_field = "7CA715B76440B29FFB05D39B0C592B7F", hash_generated_field = "8C3D0A85A317D2355A45465A71C73F69")

            static final int DECODED = 2;
        }


        
    }


    
    static class Part extends AbstractPart {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.604 -0400", hash_original_method = "68B275EBA6010E5404727E121615E229", hash_generated_method = "CE292AEA2FF3777030E1EB75C7BF77AA")
        private  Part(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(decoded.getTaint());
            addTaint(encoded.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.604 -0400", hash_original_method = "BD94DCCF5B44419F4498543CA74892E2", hash_generated_method = "21C70E4D3A247DBB99B7D4E45D3153C9")
         boolean isEmpty() {
            boolean var68934A3E9455FA72420237EB05902327_1928133346 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476076688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_476076688;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.609 -0400", hash_original_method = "74B8C999E422A266FD890BA259F6B43C", hash_generated_method = "2D43F1EE418D042ACF094A2F33A46B4A")
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
String varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_1871794796 =             hasEncoded ? encoded : (encoded = encode(decoded));
            varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_1871794796.addTaint(taint);
            return varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_1871794796;
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

        
        @DSModeled(DSC.SAFE)
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.619 -0400", hash_original_method = "D79C0256E86C850253FAE782AD9920ED", hash_generated_method = "D6E891CD56E98A9A6565F34666DC1B4A")
            public  EmptyPart(String value) {
                super(value, value);
                addTaint(value.getTaint());
                // ---------- Original Method ----------
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.619 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "DF6E9319501E70ACA24D94C3605E1F23")
            @Override
             boolean isEmpty() {
                boolean varB326B5062B2F0E69046810717534CB09_709351747 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1458172460 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1458172460;
                // ---------- Original Method ----------
                //return true;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.620 -0400", hash_original_field = "22902092D13F95EF047EC38F67C7A689", hash_generated_field = "B57558D017E2A8337F27C36F5D930EAB")

        static final Part NULL = new EmptyPart(null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.620 -0400", hash_original_field = "7F2DFD92B4F00B07EC2711F9AFB4D4CD", hash_generated_field = "D56E54A9BB15BF578A32B43A761A7D58")

        static final Part EMPTY = new EmptyPart("");
    }


    
    static class PathPart extends AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.620 -0400", hash_original_field = "5C8A59F77C438336819DD4F6B0C372B5", hash_generated_field = "BB8884736C4C2C995D440C597E10BBE6")

        private PathSegments pathSegments;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.620 -0400", hash_original_method = "E8CA21F7072E8C7642F3BFF9454329AE", hash_generated_method = "BCE7A6DB1134431144E50BD91D1A7695")
        private  PathPart(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(decoded.getTaint());
            addTaint(encoded.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.620 -0400", hash_original_method = "EEE1C5D1C73794B2424FF9B6A794D8BE", hash_generated_method = "B277AC279D1CD34E4955722A4A2B89C4")
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
String varEFDAC2AC5D53E9CE24C648C5C33F0808_45375346 =             hasEncoded ? encoded : (encoded = encode(decoded, "/"));
            varEFDAC2AC5D53E9CE24C648C5C33F0808_45375346.addTaint(taint);
            return varEFDAC2AC5D53E9CE24C648C5C33F0808_45375346;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded, "/"));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.620 -0400", hash_original_method = "BB12DAE5001652F9E9419E41FB496BCF", hash_generated_method = "98426F72709FA97C3E13EB8D09027C5F")
         PathSegments getPathSegments() {
            if(pathSegments != null)            
            {
PathSegments var5204DC86E95830EB05C770BC38BED307_1556350904 =                 pathSegments;
                var5204DC86E95830EB05C770BC38BED307_1556350904.addTaint(taint);
                return var5204DC86E95830EB05C770BC38BED307_1556350904;
            } //End block
            String path = getEncoded();
            if(path == null)            
            {
PathSegments var73DD0AB3EF50886F4E8427C8CCBD1FAF_1884826577 =                 pathSegments = PathSegments.EMPTY;
                var73DD0AB3EF50886F4E8427C8CCBD1FAF_1884826577.addTaint(taint);
                return var73DD0AB3EF50886F4E8427C8CCBD1FAF_1884826577;
            } //End block
            PathSegmentsBuilder segmentBuilder = new PathSegmentsBuilder();
            int previous = 0;
            int current;
            while
((current = path.indexOf('/', previous)) > -1)            
            {
                if(previous < current)                
                {
                    String decodedSegment = decode(path.substring(previous, current));
                    segmentBuilder.add(decodedSegment);
                } //End block
                previous = current + 1;
            } //End block
            if(previous < path.length())            
            {
                segmentBuilder.add(decode(path.substring(previous)));
            } //End block
PathSegments var58DFB823F4B6E95DFEC9F8BC0A1DF96E_837270339 =             pathSegments = segmentBuilder.build();
            var58DFB823F4B6E95DFEC9F8BC0A1DF96E_837270339.addTaint(taint);
            return var58DFB823F4B6E95DFEC9F8BC0A1DF96E_837270339;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.621 -0400", hash_original_field = "12FCD4CDDE0159C0A83B0F6923FAC7D8", hash_generated_field = "CE631D3EC26A75E141BE1EBBE7AA5D88")

        static final PathPart NULL = new PathPart(null, null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.621 -0400", hash_original_field = "2511CF6735334EEEFE4C66E3501EA765", hash_generated_field = "092DD7A22CF30B1C24AB41550FA2A397")

        static final PathPart EMPTY = new PathPart("", "");
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.621 -0400", hash_original_field = "15E64A01463468950481CAE21CF06FCB", hash_generated_field = "0451CD7498AE36BDD61110634E7FCA90")

    private static final String LOG = Uri.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.621 -0400", hash_original_field = "A90280C308D46EDE51003B54A6774638", hash_generated_field = "B954F9C12AC0662BCBDFC1BE53358724")

    @SuppressWarnings("RedundantStringConstructorCall") private static final String NOT_CACHED = new String("NOT CACHED");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "A81A920AEF8690239BB9D44F7E78D4F4", hash_generated_field = "5038C252470848AFDD24667CC5D97705")

    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL,
            PathPart.EMPTY, Part.NULL, Part.NULL);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "096628D07602808452D76140024603D6", hash_generated_field = "70D3B26ADAF374FF9FC1A886C7965F17")

    private final static int NOT_FOUND = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "4FDDDF7A3C684DEFD4771F4F71A53864", hash_generated_field = "309A8D293FB70CF3C8B75760A49AAA8A")

    private final static int NOT_CALCULATED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "6DE16BB1834113B41F3DB9E09DDB15A3", hash_generated_field = "D90B08A155B6660D5725B7F9B3B765E3")

    private static final String NOT_HIERARCHICAL = "This isn't a hierarchical URI.";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "2D7FBEFE0E1B69A4322A3C2F72D1B945", hash_generated_field = "801ABCF993C84AFFC2A4DEC33E3ED2DF")

    private static final String DEFAULT_ENCODING = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "FEE7EF6013925E53DB51A6700DEA6FED", hash_generated_field = "013D84CBB14787012A1B410C2CED92EA")

    private static final int NULL_TYPE_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "FA031E527800FCED59C59BB3277BEE96", hash_generated_field = "A8963E713BB231EFDC73C3C4317D711B")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "7590EBC339FE731817F9724DB1BDFD6C", hash_generated_field = "C46B2CD1575F3EFF815653AFF0EA6C73")

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.622 -0400", hash_original_field = "B895F573C0891DA82989F42094373576", hash_generated_field = "EA76FA4E6E39D084A2B31303C1E9D60D")

    private static final byte[] REPLACEMENT = { (byte) 0xFF, (byte) 0xFD };
    // orphaned legacy method
    public Uri[] newArray(int size) {
            return new Uri[size];
        }
    
    // orphaned legacy method
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
    
    // orphaned legacy method
    @DSModeled(DSC.SPEC)
    @Override
	public int describeContents() {
		
		return 0;
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SPEC)
    @Override
	public void writeToParcel(Parcel dest, int flags) {
		
		
	}
    
    // orphaned legacy field
    private String uriString;
    
}

