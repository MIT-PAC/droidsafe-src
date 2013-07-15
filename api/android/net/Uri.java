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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.736 -0400", hash_original_method = "81E08B95735493D923725112C83DA27A", hash_generated_method = "AE17603DE8C4908F75692349E5C02303")
    private  Uri() {
        // ---------- Original Method ----------
    }

    
    public abstract boolean isHierarchical();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.737 -0400", hash_original_method = "A0C9F8427F648091A08345C72525BACA", hash_generated_method = "19048114946DB16A1471436F5ACE092D")
    public boolean isOpaque() {
        boolean varB0499C09D88ADA4B175FB58912D54137_1772191663 = (!isHierarchical());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187757106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_187757106;
        // ---------- Original Method ----------
        //return !isHierarchical();
    }

    
    public abstract boolean isRelative();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.737 -0400", hash_original_method = "E92F08B9247EAC707F6805C228339DFA", hash_generated_method = "B9BFFE5B1E8F4D7BA4EE06AD6EF84A10")
    public boolean isAbsolute() {
        boolean varA7DC41148D608495EEE12AD396A7094A_1551995100 = (!isRelative());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1744372995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1744372995;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.738 -0400", hash_original_method = "FA9A408EEB8F8DAB44A912D276C5C2CC", hash_generated_method = "B445FE634A6082477B2777A2725A5CD0")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof Uri))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1495084640 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796504318 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796504318;
        } //End block
        Uri other = (Uri) o;
        boolean var375391202D42F422F32D588DF637C48C_1964378765 = (toString().equals(other.toString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1521316959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1521316959;
        // ---------- Original Method ----------
        //if (!(o instanceof Uri)) {
            //return false;
        //}
        //Uri other = (Uri) o;
        //return toString().equals(other.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.738 -0400", hash_original_method = "5AAF793CD4316640D385D37282629FDE", hash_generated_method = "471564C6ABFE1F94E515AF20CD337579")
    public int hashCode() {
        int var3A322A74445239A748BA39CEE0B79D31_589027483 = (toString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057136274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057136274;
        // ---------- Original Method ----------
        //return toString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.738 -0400", hash_original_method = "45EC734684FFFB3EE70A4C12F2A2F839", hash_generated_method = "B1C31B7A3C36B71F84CB66402CA54DA6")
    public int compareTo(Uri other) {
        addTaint(other.getTaint());
        int varB42A77B0F940EC261622D54B298EB83F_286574705 = (toString().compareTo(other.toString()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909904493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909904493;
        // ---------- Original Method ----------
        //return toString().compareTo(other.toString());
    }

    
    public abstract String toString();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.739 -0400", hash_original_method = "C2346F0C89241A0BA21735401E86BD49", hash_generated_method = "85BFBAC0DE6BDA2C4292BD96F59B691F")
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
String varF4CF030572656354ACFDF83FEE21D7A6_2127649281 =                 builder.toString();
                varF4CF030572656354ACFDF83FEE21D7A6_2127649281.addTaint(taint);
                return varF4CF030572656354ACFDF83FEE21D7A6_2127649281;
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
String varF4CF030572656354ACFDF83FEE21D7A6_1286293928 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1286293928.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1286293928;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.740 -0400", hash_original_method = "966FC11B97976C170B352F408FA2783F", hash_generated_method = "DADD76A0AC091846B8A4895B9A1D7892")
    public Set<String> getQueryParameterNames() {
    if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_643016007 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_643016007.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_643016007;
        } //End block
        String query = getEncodedQuery();
    if(query == null)        
        {
Set<String> var5CEAC4B7DE047656E0B916F1F83FCC49_1882485786 =             Collections.emptySet();
            var5CEAC4B7DE047656E0B916F1F83FCC49_1882485786.addTaint(taint);
            return var5CEAC4B7DE047656E0B916F1F83FCC49_1882485786;
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
Set<String> varDD12C3B8A2F9B14F672A88549FBB956F_1993196988 =         Collections.unmodifiableSet(names);
        varDD12C3B8A2F9B14F672A88549FBB956F_1993196988.addTaint(taint);
        return varDD12C3B8A2F9B14F672A88549FBB956F_1993196988;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.740 -0400", hash_original_method = "9E05603A6F44EBCC73536B2584976016", hash_generated_method = "0CDA7C3ACEBF51EDD3881A872B1189E9")
    public List<String> getQueryParameters(String key) {
        addTaint(key.getTaint());
    if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_587919453 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_587919453.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_587919453;
        } //End block
    if(key == null)        
        {
            NullPointerException var6D18FBA697BA09A47EF653F0DB540AE6_689063635 = new NullPointerException("key");
            var6D18FBA697BA09A47EF653F0DB540AE6_689063635.addTaint(taint);
            throw var6D18FBA697BA09A47EF653F0DB540AE6_689063635;
        } //End block
        String query = getEncodedQuery();
    if(query == null)        
        {
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_524435357 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_524435357.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_524435357;
        } //End block
        String encodedKey;
        try 
        {
            encodedKey = URLEncoder.encode(key, DEFAULT_ENCODING);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_733868015 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_733868015.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_733868015;
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
List<String> var00BA81E9B2AB879A295DB9B86426A421_1188090738 =         Collections.unmodifiableList(values);
        var00BA81E9B2AB879A295DB9B86426A421_1188090738.addTaint(taint);
        return var00BA81E9B2AB879A295DB9B86426A421_1188090738;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.741 -0400", hash_original_method = "72F6B0777F298E12957F6498D8B3E8F1", hash_generated_method = "64D0E273490F321074638467A8D0EB34")
    public String getQueryParameter(String key) {
        addTaint(key.getTaint());
    if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_358550057 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_358550057.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_358550057;
        } //End block
    if(key == null)        
        {
            NullPointerException var6D18FBA697BA09A47EF653F0DB540AE6_743732589 = new NullPointerException("key");
            var6D18FBA697BA09A47EF653F0DB540AE6_743732589.addTaint(taint);
            throw var6D18FBA697BA09A47EF653F0DB540AE6_743732589;
        } //End block
        final String query = getEncodedQuery();
    if(query == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1622852579 =             null;
            var540C13E9E156B687226421B24F2DF178_1622852579.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1622852579;
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
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_729440607 =                         "";
                        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_729440607.addTaint(taint);
                        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_729440607;
                    } //End block
                    else
                    {
String varEB3B385708156ABD4F6A26F7ED4FD51E_2018334684 =                         decode(query.substring(separator + 1, end));
                        varEB3B385708156ABD4F6A26F7ED4FD51E_2018334684.addTaint(taint);
                        return varEB3B385708156ABD4F6A26F7ED4FD51E_2018334684;
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
String var540C13E9E156B687226421B24F2DF178_442394430 =         null;
        var540C13E9E156B687226421B24F2DF178_442394430.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_442394430;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.741 -0400", hash_original_method = "67BE774C17CDAC836698DE4D6D994F1B", hash_generated_method = "CB925B8C6919AA60BF0AF173F2F1C200")
    public boolean getBooleanQueryParameter(String key, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        String flag = getQueryParameter(key);
    if(flag == null)        
        {
            boolean var16830A58E1E33A4163524366BA7B701B_1064843020 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732363211 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_732363211;
        } //End block
        flag = flag.toLowerCase();
        boolean varEA95ECFC8D5C8F8BB96D459961F0F8E2_1762205217 = ((!"false".equals(flag) && !"0".equals(flag)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489123998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489123998;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "ACD4CFB867E9014EB5553B665A7654E7", hash_generated_field = "E4175460B78B44891D601990509D1265")

        private String uriString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "CAB1D5F863DB3FE1F854F1737D3BF567", hash_generated_field = "6ECAEC93E2396D17CA9FF61298DA11AE")

        private volatile int cachedSsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "0D27A2D8516BF4DCE688D48A00F04BF9", hash_generated_field = "6673040FAE4D4C35641720F36B224DA4")

        private volatile int cachedFsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "8FE13FA728B09DACBFC57E5751B51F48", hash_generated_field = "0E9D0B05543D9BBCEB78240FF4AE88F4")

        private volatile String scheme = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.742 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.743 -0400", hash_original_method = "6762E8F4F232397EC67D86B91A630B95", hash_generated_method = "7DC174B750324255E7BEEA3BAE609DF3")
        private  StringUri(String uriString) {
    if(uriString == null)            
            {
                NullPointerException var68D2986827E7776409B7C54E12824C66_1135541121 = new NullPointerException("uriString");
                var68D2986827E7776409B7C54E12824C66_1135541121.addTaint(taint);
                throw var68D2986827E7776409B7C54E12824C66_1135541121;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.743 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D66B10463D2B5DE3A20D0A3756A6A264")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1093510345 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283950918 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283950918;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.744 -0400", hash_original_method = "C73A8428F9DA44091DF96EEDC1E3D3EF", hash_generated_method = "324EBC5AEA4A8D0023485D42B57F178D")
        public void writeToParcel(Parcel parcel, int flags) {
            addTaint(flags);
            addTaint(parcel.getTaint());
            parcel.writeInt(TYPE_ID);
            parcel.writeString(uriString);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.744 -0400", hash_original_method = "F197955D6E3BAB1920F769AA2F97BBD7", hash_generated_method = "8AA8AB4ABC8204954B6C8209CA8330DA")
        private int findSchemeSeparator() {
            int varF628705FEC99553366B579C402EB9B06_1327503763 = (cachedSsi == NOT_CALCULATED
                    ? cachedSsi = uriString.indexOf(':')
                    : cachedSsi);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500686941 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500686941;
            // ---------- Original Method ----------
            //return cachedSsi == NOT_CALCULATED
                    //? cachedSsi = uriString.indexOf(':')
                    //: cachedSsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.744 -0400", hash_original_method = "B0E1A879F11D02C30EC9FBB06F8801FE", hash_generated_method = "295B9078A42E8695AF6B1CE504F0B99F")
        private int findFragmentSeparator() {
            int varB610A4875B79C5B29765DB968E0E51FE_218866552 = (cachedFsi == NOT_CALCULATED
                    ? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    : cachedFsi);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73424151 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73424151;
            // ---------- Original Method ----------
            //return cachedFsi == NOT_CALCULATED
                    //? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    //: cachedFsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.744 -0400", hash_original_method = "11C2E375F5E033161AB2E06056D673CF", hash_generated_method = "2A4F40D78453164E9EC22787E18EC77C")
        public boolean isHierarchical() {
            int ssi = findSchemeSeparator();
    if(ssi == NOT_FOUND)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1421681234 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387834328 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_387834328;
            } //End block
    if(uriString.length() == ssi + 1)            
            {
                boolean var68934A3E9455FA72420237EB05902327_342811868 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_690665709 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_690665709;
            } //End block
            boolean varC62061A402117AB0C4CED01069D594B5_1366606386 = (uriString.charAt(ssi + 1) == '/');
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672924472 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672924472;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.744 -0400", hash_original_method = "DC1D040929AB7A4CF9A0DFBB95EA4283", hash_generated_method = "B17FBA92F60B4D02AA579D1BD89780A8")
        public boolean isRelative() {
            boolean var348FB469184CEBD475FA89D15A3871A3_1269290523 = (findSchemeSeparator() == NOT_FOUND);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322776603 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322776603;
            // ---------- Original Method ----------
            //return findSchemeSeparator() == NOT_FOUND;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.744 -0400", hash_original_method = "96667B7E38635C26F17AC80DC91F9ADB", hash_generated_method = "9E34D8B162B4CEEC336C56F25541FBAF")
        public String getScheme() {
            @SuppressWarnings("StringEquality") boolean cached = (scheme != NOT_CACHED);
String var5EC068FC8BAF19C405B863C227DA0116_1713594487 =             cached ? scheme : (scheme = parseScheme());
            var5EC068FC8BAF19C405B863C227DA0116_1713594487.addTaint(taint);
            return var5EC068FC8BAF19C405B863C227DA0116_1713594487;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (scheme != NOT_CACHED);
            //return cached ? scheme : (scheme = parseScheme());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.744 -0400", hash_original_method = "B03A2C85823E1DE38C77FC40695B0CC7", hash_generated_method = "2A769E2767A252962C59CFA95F8A106C")
        private String parseScheme() {
            int ssi = findSchemeSeparator();
String var9A67634AC4372CD6514004924726C40E_1810523629 =             ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
            var9A67634AC4372CD6514004924726C40E_1810523629.addTaint(taint);
            return var9A67634AC4372CD6514004924726C40E_1810523629;
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //return ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.745 -0400", hash_original_method = "DE43C7F499D5F1739936552A95AA2492", hash_generated_method = "760D6B42FF3319F16756254E883AF542")
        private Part getSsp() {
Part var09914C8DC28309112B8F11C48A2310A0_635942481 =             ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
            var09914C8DC28309112B8F11C48A2310A0_635942481.addTaint(taint);
            return var09914C8DC28309112B8F11C48A2310A0_635942481;
            // ---------- Original Method ----------
            //return ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.745 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "6696FFA666543EFF44CDD4E3E3F6A152")
        public String getEncodedSchemeSpecificPart() {
String var393D011CD485FB233FC4BE4326461491_972660729 =             getSsp().getEncoded();
            var393D011CD485FB233FC4BE4326461491_972660729.addTaint(taint);
            return var393D011CD485FB233FC4BE4326461491_972660729;
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.745 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "100EBAF56C351A75CE04AD07C46E16E7")
        public String getSchemeSpecificPart() {
String varDEA78A046E5755E6A172773CC85259A6_357018450 =             getSsp().getDecoded();
            varDEA78A046E5755E6A172773CC85259A6_357018450.addTaint(taint);
            return varDEA78A046E5755E6A172773CC85259A6_357018450;
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.745 -0400", hash_original_method = "6082AC88F53E9B67D59D9A72041A5D6F", hash_generated_method = "915AA1BD19514F8236AD4D355C1F201A")
        private String parseSsp() {
            int ssi = findSchemeSeparator();
            int fsi = findFragmentSeparator();
String varBF4B489B1C1A01395A08B9487579BBF1_562107650 =             fsi == NOT_FOUND
                    ? uriString.substring(ssi + 1)
                    : uriString.substring(ssi + 1, fsi);
            varBF4B489B1C1A01395A08B9487579BBF1_562107650.addTaint(taint);
            return varBF4B489B1C1A01395A08B9487579BBF1_562107650;
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND
                    //? uriString.substring(ssi + 1)
                    //: uriString.substring(ssi + 1, fsi);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.745 -0400", hash_original_method = "C2AABBF6273BD8549508A0ABF072F220", hash_generated_method = "29829BC19E7E954294BEEA2E1F2FDE0C")
        private Part getAuthorityPart() {
    if(authority == null)            
            {
                String encodedAuthority = parseAuthority(this.uriString, findSchemeSeparator());
Part var381FCECE440D5D319C351EE6F1BBEAAB_1303759437 =                 authority = Part.fromEncoded(encodedAuthority);
                var381FCECE440D5D319C351EE6F1BBEAAB_1303759437.addTaint(taint);
                return var381FCECE440D5D319C351EE6F1BBEAAB_1303759437;
            } //End block
Part var9A4A00E403B4898E9807F68E9EBE5A8B_654084325 =             authority;
            var9A4A00E403B4898E9807F68E9EBE5A8B_654084325.addTaint(taint);
            return var9A4A00E403B4898E9807F68E9EBE5A8B_654084325;
            // ---------- Original Method ----------
            //if (authority == null) {
                //String encodedAuthority
                        //= parseAuthority(this.uriString, findSchemeSeparator());
                //return authority = Part.fromEncoded(encodedAuthority);
            //}
            //return authority;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.745 -0400", hash_original_method = "B783FB869F9CE6B897E37C2A9B9B4259", hash_generated_method = "B6AF48BC0C6F22A3F1E0F6B3C13897EA")
        public String getEncodedAuthority() {
String var4F2DF47BEB24727A66BE79DC91AEECC0_431782812 =             getAuthorityPart().getEncoded();
            var4F2DF47BEB24727A66BE79DC91AEECC0_431782812.addTaint(taint);
            return var4F2DF47BEB24727A66BE79DC91AEECC0_431782812;
            // ---------- Original Method ----------
            //return getAuthorityPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.745 -0400", hash_original_method = "F4404025FB90C68980598D2895AF9578", hash_generated_method = "54893BD41FD139962351D6B387542292")
        public String getAuthority() {
String var039061F12DF25903DB753BE4C77CEE48_713635380 =             getAuthorityPart().getDecoded();
            var039061F12DF25903DB753BE4C77CEE48_713635380.addTaint(taint);
            return var039061F12DF25903DB753BE4C77CEE48_713635380;
            // ---------- Original Method ----------
            //return getAuthorityPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.746 -0400", hash_original_method = "483C19AAE407B7D6148F370745A1893E", hash_generated_method = "8592C21C8F1E0F712ABCF4305443CEFC")
        private PathPart getPathPart() {
PathPart varD78256BB83A04B0BB00412684FCFB6CE_376958901 =             path == null
                    ? path = PathPart.fromEncoded(parsePath())
                    : path;
            varD78256BB83A04B0BB00412684FCFB6CE_376958901.addTaint(taint);
            return varD78256BB83A04B0BB00412684FCFB6CE_376958901;
            // ---------- Original Method ----------
            //return path == null
                    //? path = PathPart.fromEncoded(parsePath())
                    //: path;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.746 -0400", hash_original_method = "E8759FDECF433DBBFF0BA03CF3576CC0", hash_generated_method = "CE3251EB3B4FBEA358BA9BB4F5470B20")
        public String getPath() {
String varEADC8740E16239A469558240BCE0C192_2119209351 =             getPathPart().getDecoded();
            varEADC8740E16239A469558240BCE0C192_2119209351.addTaint(taint);
            return varEADC8740E16239A469558240BCE0C192_2119209351;
            // ---------- Original Method ----------
            //return getPathPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.746 -0400", hash_original_method = "D26AFC1B9D9DFA82513D9A4C50DD2F0F", hash_generated_method = "DD189EEEC24EFA37522DDF63B40C03E2")
        public String getEncodedPath() {
String var5763B1F1953626A1B4119C83521EC238_1721249771 =             getPathPart().getEncoded();
            var5763B1F1953626A1B4119C83521EC238_1721249771.addTaint(taint);
            return var5763B1F1953626A1B4119C83521EC238_1721249771;
            // ---------- Original Method ----------
            //return getPathPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.746 -0400", hash_original_method = "A1BA2B8DCFFB301EABC725C63F487DC2", hash_generated_method = "675FB367E9782A8CEF514823BE40B790")
        public List<String> getPathSegments() {
List<String> var9D1E6922DB3B6A33267FC8778B1D1882_1959755670 =             getPathPart().getPathSegments();
            var9D1E6922DB3B6A33267FC8778B1D1882_1959755670.addTaint(taint);
            return var9D1E6922DB3B6A33267FC8778B1D1882_1959755670;
            // ---------- Original Method ----------
            //return getPathPart().getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.746 -0400", hash_original_method = "EF0989C68625FC2F46DE0EA4CB35660B", hash_generated_method = "6D435D82DF943B68937D32C25A747AB4")
        private String parsePath() {
            String uriString = this.uriString;
            int ssi = findSchemeSeparator();
    if(ssi > -1)            
            {
                boolean schemeOnly = ssi + 1 == uriString.length();
    if(schemeOnly)                
                {
String var540C13E9E156B687226421B24F2DF178_524416024 =                     null;
                    var540C13E9E156B687226421B24F2DF178_524416024.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_524416024;
                } //End block
    if(uriString.charAt(ssi + 1) != '/')                
                {
String var540C13E9E156B687226421B24F2DF178_2038061337 =                     null;
                    var540C13E9E156B687226421B24F2DF178_2038061337.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_2038061337;
                } //End block
            } //End block
            else
            {
            } //End block
String var735954F5F0815F8E40E83E176F832A69_273669062 =             parsePath(uriString, ssi);
            var735954F5F0815F8E40E83E176F832A69_273669062.addTaint(taint);
            return var735954F5F0815F8E40E83E176F832A69_273669062;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.747 -0400", hash_original_method = "5338F6D0AC99191764C2394A710C873F", hash_generated_method = "9C96C4BA1130F7C0762C78030DBD03B1")
        private Part getQueryPart() {
Part varF5F740948841E62E50DE94DCB962384D_2005173445 =             query == null
                    ? query = Part.fromEncoded(parseQuery()) : query;
            varF5F740948841E62E50DE94DCB962384D_2005173445.addTaint(taint);
            return varF5F740948841E62E50DE94DCB962384D_2005173445;
            // ---------- Original Method ----------
            //return query == null
                    //? query = Part.fromEncoded(parseQuery()) : query;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.747 -0400", hash_original_method = "61892B739321CB796D242E9E13C1F033", hash_generated_method = "386293B7677E1A990DCD12CD7C2DBE0D")
        public String getEncodedQuery() {
String var592BAA78F9680D5D07BEE2DE945A79E3_708390229 =             getQueryPart().getEncoded();
            var592BAA78F9680D5D07BEE2DE945A79E3_708390229.addTaint(taint);
            return var592BAA78F9680D5D07BEE2DE945A79E3_708390229;
            // ---------- Original Method ----------
            //return getQueryPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.747 -0400", hash_original_method = "93492ABD4F9B88C963E84B9F545E5D11", hash_generated_method = "9F9D5868FB8369C6686DF1F2CC8FE39C")
        private String parseQuery() {
            int qsi = uriString.indexOf('?', findSchemeSeparator());
    if(qsi == NOT_FOUND)            
            {
String var540C13E9E156B687226421B24F2DF178_1514768809 =                 null;
                var540C13E9E156B687226421B24F2DF178_1514768809.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1514768809;
            } //End block
            int fsi = findFragmentSeparator();
    if(fsi == NOT_FOUND)            
            {
String var36038C78F7FD108CFC3CF4002250C153_1750119027 =                 uriString.substring(qsi + 1);
                var36038C78F7FD108CFC3CF4002250C153_1750119027.addTaint(taint);
                return var36038C78F7FD108CFC3CF4002250C153_1750119027;
            } //End block
    if(fsi < qsi)            
            {
String var540C13E9E156B687226421B24F2DF178_1740775312 =                 null;
                var540C13E9E156B687226421B24F2DF178_1740775312.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1740775312;
            } //End block
String varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_245878655 =             uriString.substring(qsi + 1, fsi);
            varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_245878655.addTaint(taint);
            return varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_245878655;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.747 -0400", hash_original_method = "31EC40ABD8B86D0064329950E060BFBD", hash_generated_method = "8239FFC9D17A110C86296338322EAE86")
        public String getQuery() {
String varF32257C5D28B6286E14CC639F868B333_1808225868 =             getQueryPart().getDecoded();
            varF32257C5D28B6286E14CC639F868B333_1808225868.addTaint(taint);
            return varF32257C5D28B6286E14CC639F868B333_1808225868;
            // ---------- Original Method ----------
            //return getQueryPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.747 -0400", hash_original_method = "EAD370CB1FE781DF1864471D9F5F3E36", hash_generated_method = "C5F03E19C824760D9B78C4BF81E19964")
        private Part getFragmentPart() {
Part var8550B3AFC925290D75F2A324FFCC8703_963133996 =             fragment == null
                    ? fragment = Part.fromEncoded(parseFragment()) : fragment;
            var8550B3AFC925290D75F2A324FFCC8703_963133996.addTaint(taint);
            return var8550B3AFC925290D75F2A324FFCC8703_963133996;
            // ---------- Original Method ----------
            //return fragment == null
                    //? fragment = Part.fromEncoded(parseFragment()) : fragment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.748 -0400", hash_original_method = "C2884F3C25114B1CD652E8CCEF7D7F10", hash_generated_method = "F64E204D3E8575A99AD29DEEA5499E02")
        public String getEncodedFragment() {
String var15356DF640E39A7E16838423CF95944B_2040174174 =             getFragmentPart().getEncoded();
            var15356DF640E39A7E16838423CF95944B_2040174174.addTaint(taint);
            return var15356DF640E39A7E16838423CF95944B_2040174174;
            // ---------- Original Method ----------
            //return getFragmentPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.748 -0400", hash_original_method = "13965C7143AC0E622773DBA6AE062E67", hash_generated_method = "235EE9B8E9E083713D607080CF2E503A")
        private String parseFragment() {
            int fsi = findFragmentSeparator();
String varDFC5047C05E36D10FFCD890F81F09AE9_520712669 =             fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
            varDFC5047C05E36D10FFCD890F81F09AE9_520712669.addTaint(taint);
            return varDFC5047C05E36D10FFCD890F81F09AE9_520712669;
            // ---------- Original Method ----------
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.748 -0400", hash_original_method = "4E8163B4F7FDF9829581A99F6274656D", hash_generated_method = "AF6529BDEC5CB45DE11859BAA13A1DAE")
        public String getFragment() {
String var93BCD471CAA5DE221487CFBAAF871060_225691213 =             getFragmentPart().getDecoded();
            var93BCD471CAA5DE221487CFBAAF871060_225691213.addTaint(taint);
            return var93BCD471CAA5DE221487CFBAAF871060_225691213;
            // ---------- Original Method ----------
            //return getFragmentPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.748 -0400", hash_original_method = "ECB4588CBE3D957B88D2558A4C044374", hash_generated_method = "BA1567F0944298C267466DD40840B385")
        public String toString() {
String varA4F4B44693A1936015581C1F7D6F4DAF_1441487951 =             uriString;
            varA4F4B44693A1936015581C1F7D6F4DAF_1441487951.addTaint(taint);
            return varA4F4B44693A1936015581C1F7D6F4DAF_1441487951;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.749 -0400", hash_original_method = "54B78C0DD1C850213ABB66143A4F5DE7", hash_generated_method = "541FDBD68EF598C062E614B4C72A60CC")
        public Builder buildUpon() {
    if(isHierarchical())            
            {
Builder varF2D941D0CA5C6E55CED50CE66323299C_458937402 =                 new Builder()
                        .scheme(getScheme())
                        .authority(getAuthorityPart())
                        .path(getPathPart())
                        .query(getQueryPart())
                        .fragment(getFragmentPart());
                varF2D941D0CA5C6E55CED50CE66323299C_458937402.addTaint(taint);
                return varF2D941D0CA5C6E55CED50CE66323299C_458937402;
            } //End block
            else
            {
Builder varC65AC201593175003FC279C7FC3D63BE_1137035008 =                 new Builder()
                        .scheme(getScheme())
                        .opaquePart(getSsp())
                        .fragment(getFragmentPart());
                varC65AC201593175003FC279C7FC3D63BE_1137035008.addTaint(taint);
                return varC65AC201593175003FC279C7FC3D63BE_1137035008;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.749 -0400", hash_original_field = "B0493B2AFC6F39450B0E6998DDC76696", hash_generated_field = "1525B2F69D3B82BDEA81D83890B48CEC")

        static final int TYPE_ID = 1;
    }


    
    private static class OpaqueUri extends Uri {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.749 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.749 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.749 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.749 -0400", hash_original_field = "E4D7B1085B3F20D4D3076206156621A1", hash_generated_field = "FCCD4A0FFBA55911A49FB2AEB7548D00")

        private volatile String cachedString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.749 -0400", hash_original_method = "A3EB90F61BB5DAD9A21709AA9F976DF8", hash_generated_method = "06AECF8220C181EEDE6CDB73AC6F3E82")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.750 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "81082252D0B3FA1C811906D3319D6F03")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_455098991 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912851333 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912851333;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.750 -0400", hash_original_method = "8F996E53ADCFC30BFF794C5CEED4DA61", hash_generated_method = "9E225E24A0B19EF01FE9969CB078EF74")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.750 -0400", hash_original_method = "414EEC63B62C24CE4C288B4F88575946", hash_generated_method = "BF447BFCE93F4F7A23810FE729B90803")
        public boolean isHierarchical() {
            boolean var68934A3E9455FA72420237EB05902327_1014009054 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246035451 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246035451;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.750 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "6090EDA3E36AA0CD9DCBEB29E95A6124")
        public boolean isRelative() {
            boolean var4518A3BFE1F17529286D9D4EFE362EA9_2097494444 = (scheme == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1404148692 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1404148692;
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.750 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "1954CD3CC0F9C55E957AC05061D3E1DB")
        public String getScheme() {
String varBF26C0D1E8CB9E7F67A307E664136E8F_1944356334 =             this.scheme;
            varBF26C0D1E8CB9E7F67A307E664136E8F_1944356334.addTaint(taint);
            return varBF26C0D1E8CB9E7F67A307E664136E8F_1944356334;
            // ---------- Original Method ----------
            //return this.scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.750 -0400", hash_original_method = "3C55B6D4F736410AF7A2ACAB5CCC51ED", hash_generated_method = "AA0F042CCAFFB801172C2342878D31AE")
        public String getEncodedSchemeSpecificPart() {
String varD902B0CDE27092B0A8D653D3A1CAB3D2_767324158 =             ssp.getEncoded();
            varD902B0CDE27092B0A8D653D3A1CAB3D2_767324158.addTaint(taint);
            return varD902B0CDE27092B0A8D653D3A1CAB3D2_767324158;
            // ---------- Original Method ----------
            //return ssp.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.751 -0400", hash_original_method = "ED3540C8D06E41CD645C58A620F36381", hash_generated_method = "04C0E4AD9FDB2C68ADDA4D07FC4AB568")
        public String getSchemeSpecificPart() {
String var754BC27394ACBF326C1E9A754D8A46C9_1725893960 =             ssp.getDecoded();
            var754BC27394ACBF326C1E9A754D8A46C9_1725893960.addTaint(taint);
            return var754BC27394ACBF326C1E9A754D8A46C9_1725893960;
            // ---------- Original Method ----------
            //return ssp.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.751 -0400", hash_original_method = "31E41E1CB0338F9BAA50A0AC05D7D02D", hash_generated_method = "90166ED8B4B7815534BA78EA10799B5E")
        public String getAuthority() {
String var540C13E9E156B687226421B24F2DF178_997969942 =             null;
            var540C13E9E156B687226421B24F2DF178_997969942.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_997969942;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.751 -0400", hash_original_method = "C6F3CA63C6BE518EBD2AA32E2786DD3A", hash_generated_method = "F8C04D189E1157AA8E37FFC60DE9155A")
        public String getEncodedAuthority() {
String var540C13E9E156B687226421B24F2DF178_661848128 =             null;
            var540C13E9E156B687226421B24F2DF178_661848128.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_661848128;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.751 -0400", hash_original_method = "F489014FCD27D67260CBEC8AC84559A2", hash_generated_method = "7669C47318E6934478E064F4DE0165E6")
        public String getPath() {
String var540C13E9E156B687226421B24F2DF178_1236128700 =             null;
            var540C13E9E156B687226421B24F2DF178_1236128700.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1236128700;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.751 -0400", hash_original_method = "F167E35F53D1A5A8B17A8A72FE8359AE", hash_generated_method = "6A117E8E99A82F6ED069B2AF7FB09FEE")
        public String getEncodedPath() {
String var540C13E9E156B687226421B24F2DF178_47732062 =             null;
            var540C13E9E156B687226421B24F2DF178_47732062.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_47732062;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.751 -0400", hash_original_method = "2E34959E1DD3631C67E93F1AE6B31056", hash_generated_method = "151D4A5B1658E9F9E7A99E3B008D735D")
        public String getQuery() {
String var540C13E9E156B687226421B24F2DF178_166255111 =             null;
            var540C13E9E156B687226421B24F2DF178_166255111.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_166255111;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.751 -0400", hash_original_method = "53661DD2D38C9C2E00E8B8D2FF316BB7", hash_generated_method = "324203FB9F1DF9937555F0C3E8AECD55")
        public String getEncodedQuery() {
String var540C13E9E156B687226421B24F2DF178_79315536 =             null;
            var540C13E9E156B687226421B24F2DF178_79315536.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_79315536;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.751 -0400", hash_original_method = "9F53DDCB73E71AFF4CF207B49D0689B3", hash_generated_method = "67F42316C07F7F0511769AE54F7CB80D")
        public String getFragment() {
String varAF7E6EDA3A17E940567231584A0703A7_605229009 =             fragment.getDecoded();
            varAF7E6EDA3A17E940567231584A0703A7_605229009.addTaint(taint);
            return varAF7E6EDA3A17E940567231584A0703A7_605229009;
            // ---------- Original Method ----------
            //return fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.752 -0400", hash_original_method = "2FF982E252638134744EE32C0D7F6950", hash_generated_method = "416A121E5E0F0BD79DD8DB6F0895CA03")
        public String getEncodedFragment() {
String varC670092882988D295A0AFA2F86B4E2AC_1995015202 =             fragment.getEncoded();
            varC670092882988D295A0AFA2F86B4E2AC_1995015202.addTaint(taint);
            return varC670092882988D295A0AFA2F86B4E2AC_1995015202;
            // ---------- Original Method ----------
            //return fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.752 -0400", hash_original_method = "08B329AF4FAA2768183F76EC45288C10", hash_generated_method = "3F7EE38880C3A8B92741001216E32631")
        public List<String> getPathSegments() {
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_739144941 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_739144941.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_739144941;
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.752 -0400", hash_original_method = "AE7FF2A9DFCB643CF70873B2C08CD5A8", hash_generated_method = "25D5F6F512AAB4A9F4951696CE45F19D")
        public String getLastPathSegment() {
String var540C13E9E156B687226421B24F2DF178_623056244 =             null;
            var540C13E9E156B687226421B24F2DF178_623056244.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_623056244;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.752 -0400", hash_original_method = "520FB960E4127ABC7143DD06EFB52356", hash_generated_method = "D115B4196DF6AF54C43CB06051D0A6BE")
        public String getUserInfo() {
String var540C13E9E156B687226421B24F2DF178_1676495280 =             null;
            var540C13E9E156B687226421B24F2DF178_1676495280.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1676495280;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.752 -0400", hash_original_method = "88ECB0B5D6F4AA907FC3666F8C1418EB", hash_generated_method = "C15556D58F323FF5949495E9108B34C0")
        public String getEncodedUserInfo() {
String var540C13E9E156B687226421B24F2DF178_1342826186 =             null;
            var540C13E9E156B687226421B24F2DF178_1342826186.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1342826186;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.752 -0400", hash_original_method = "00C71B0865F91AE7EF71B7BE21B14B9F", hash_generated_method = "FF9C472D52675E7B6AC549DA09855AFD")
        public String getHost() {
String var540C13E9E156B687226421B24F2DF178_1928428253 =             null;
            var540C13E9E156B687226421B24F2DF178_1928428253.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1928428253;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.752 -0400", hash_original_method = "B159430668427C6760C3FB4B772D9F59", hash_generated_method = "BEA588E3F1120476D5168DB6CE97CEBE")
        public int getPort() {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_327522958 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520277012 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520277012;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.752 -0400", hash_original_method = "ACF28BE5516AF44175C2E6962FB03404", hash_generated_method = "B5203448CA34A2D2AE466E9F1FECF0A8")
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached = cachedString != NOT_CACHED;
    if(cached)            
            {
String var3B17D0B227025B279C654EE822543E6B_827378147 =                 cachedString;
                var3B17D0B227025B279C654EE822543E6B_827378147.addTaint(taint);
                return var3B17D0B227025B279C654EE822543E6B_827378147;
            } //End block
            StringBuilder sb = new StringBuilder();
            sb.append(scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());
    if(!fragment.isEmpty())            
            {
                sb.append('#').append(fragment.getEncoded());
            } //End block
String varC27FFD0D6D1EF6B53917B2D053C6E05C_1799495727 =             cachedString = sb.toString();
            varC27FFD0D6D1EF6B53917B2D053C6E05C_1799495727.addTaint(taint);
            return varC27FFD0D6D1EF6B53917B2D053C6E05C_1799495727;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_method = "9B1777E9DAB1C1ED3319A4EEC33BCB54", hash_generated_method = "7ABF346EB4403B2DFFC15CE9FB4E6C58")
        public Builder buildUpon() {
Builder varB0D57715B2E1FC2447B5F7A2D1E9683B_1880440187 =             new Builder()
                    .scheme(this.scheme)
                    .opaquePart(this.ssp)
                    .fragment(this.fragment);
            varB0D57715B2E1FC2447B5F7A2D1E9683B_1880440187.addTaint(taint);
            return varB0D57715B2E1FC2447B5F7A2D1E9683B_1880440187;
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(this.scheme)
                    //.opaquePart(this.ssp)
                    //.fragment(this.fragment);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_field = "404FF43CFEE8747368BFDA1DC5DB3B28", hash_generated_field = "81BC425463DB04A2D338A2C363556710")

        static final int TYPE_ID = 2;
    }


    
    static class PathSegments extends AbstractList<String> implements RandomAccess {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

        int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_method = "816AFE27D6484B7E80593A248F7DEC12", hash_generated_method = "F2AFBC317E49E2BF0F98B0C5AE8378FC")
          PathSegments(String[] segments, int size) {
            this.segments = segments;
            this.size = size;
            // ---------- Original Method ----------
            //this.segments = segments;
            //this.size = size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_method = "043CF25E38E9D3A71BE4CC7B6371568E", hash_generated_method = "F22D6719D99CB774637EDA535178448A")
        public String get(int index) {
            addTaint(index);
    if(index >= size)            
            {
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1696137700 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_1696137700.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_1696137700;
            } //End block
String var0670CDC624AB38F74C6CE6D645099017_676802730 =             segments[index];
            var0670CDC624AB38F74C6CE6D645099017_676802730.addTaint(taint);
            return var0670CDC624AB38F74C6CE6D645099017_676802730;
            // ---------- Original Method ----------
            //if (index >= size) {
                //throw new IndexOutOfBoundsException();
            //}
            //return segments[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_method = "BAF1AF8B1284BE94C387C840AF9FA265", hash_generated_method = "D0F47CB201E203BD21DE9CF684E95304")
        public int size() {
            int varFE91D8EC738CF7D8BE7D802E3604E3B0_1824992220 = (this.size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847560143 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847560143;
            // ---------- Original Method ----------
            //return this.size;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_field = "F2217D1D8C4EF2C438C5D90B83E3AD42", hash_generated_field = "E6083199966205833D7B5012129D384D")

        static final PathSegments EMPTY = new PathSegments(null, 0);
    }


    
    static class PathSegmentsBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

        int size = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.753 -0400", hash_original_method = "CD5B4727D6775EBFE00461F5F237812D", hash_generated_method = "CD5B4727D6775EBFE00461F5F237812D")
        public PathSegmentsBuilder ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.755 -0400", hash_original_method = "F05B9B5ECB44DE7CFF27782486F28CF3", hash_generated_method = "57396C99D23B797B3C467EFAA3744A8B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.755 -0400", hash_original_method = "497F2229989230601A3120EEAF21B251", hash_generated_method = "5B22F349002C54D78FE82467D7FAFC37")
         PathSegments build() {
    if(segments == null)            
            {
PathSegments var61ED7A3446E992CC1D6CE996343F0BB7_1241002676 =                 PathSegments.EMPTY;
                var61ED7A3446E992CC1D6CE996343F0BB7_1241002676.addTaint(taint);
                return var61ED7A3446E992CC1D6CE996343F0BB7_1241002676;
            } //End block
            try 
            {
PathSegments varF93FC2B9FE269AF50DE5689CD2FB3B65_43492692 =                 new PathSegments(segments, size);
                varF93FC2B9FE269AF50DE5689CD2FB3B65_43492692.addTaint(taint);
                return varF93FC2B9FE269AF50DE5689CD2FB3B65_43492692;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.755 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "87B54E118334D4593A462325E6A65F84")

        private Part userInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.755 -0400", hash_original_field = "38B3753700D5B450CB30995B4DB5AF95", hash_generated_field = "539F6E6D25356608852D958A8481FDA5")

        private volatile String host = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.755 -0400", hash_original_field = "38113C68733F87156C438BEBC2FCB827", hash_generated_field = "3DEE2B327E62FC31F0BA9783EFE62CA9")

        private volatile int port = NOT_CALCULATED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.755 -0400", hash_original_method = "469DE423ED30903E9EDD58224AA80D56", hash_generated_method = "469DE423ED30903E9EDD58224AA80D56")
        public AbstractHierarchicalUri ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.756 -0400", hash_original_method = "D5E71CFA6EED35AEB9B5F4AEC5287C3B", hash_generated_method = "B3F69FACC1AB49C9103F53388D855B2F")
        public String getLastPathSegment() {
            List<String> segments = getPathSegments();
            int size = segments.size();
    if(size == 0)            
            {
String var540C13E9E156B687226421B24F2DF178_1970344649 =                 null;
                var540C13E9E156B687226421B24F2DF178_1970344649.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1970344649;
            } //End block
String varEFCF283257D160202712C81EC6306DA0_1605682375 =             segments.get(size - 1);
            varEFCF283257D160202712C81EC6306DA0_1605682375.addTaint(taint);
            return varEFCF283257D160202712C81EC6306DA0_1605682375;
            // ---------- Original Method ----------
            //List<String> segments = getPathSegments();
            //int size = segments.size();
            //if (size == 0) {
                //return null;
            //}
            //return segments.get(size - 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.756 -0400", hash_original_method = "739BBE935CAE826F3703E2BBB77B819C", hash_generated_method = "27EDD0182AFBE793D453437A8F426294")
        private Part getUserInfoPart() {
Part varF7E738A42E6D63EB0326855BC730BADF_806831303 =             userInfo == null
                    ? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
            varF7E738A42E6D63EB0326855BC730BADF_806831303.addTaint(taint);
            return varF7E738A42E6D63EB0326855BC730BADF_806831303;
            // ---------- Original Method ----------
            //return userInfo == null
                    //? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.756 -0400", hash_original_method = "EADAAD26DC8689BCA10DCA33883B9323", hash_generated_method = "E58C25D3EE8254D821E854A50ED4A728")
        public final String getEncodedUserInfo() {
String var09E3B0803DBA809E674A74FBBA3FD409_8359628 =             getUserInfoPart().getEncoded();
            var09E3B0803DBA809E674A74FBBA3FD409_8359628.addTaint(taint);
            return var09E3B0803DBA809E674A74FBBA3FD409_8359628;
            // ---------- Original Method ----------
            //return getUserInfoPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.756 -0400", hash_original_method = "10E379B7D06266EDAAC672E10EB0F58B", hash_generated_method = "BE0CB4624F6BC33FFD6615565E1BA912")
        private String parseUserInfo() {
            String authority = getEncodedAuthority();
    if(authority == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1607227214 =                 null;
                var540C13E9E156B687226421B24F2DF178_1607227214.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1607227214;
            } //End block
            int end = authority.indexOf('@');
String var9D68F14379A550242867922C161646A9_205947465 =             end == NOT_FOUND ? null : authority.substring(0, end);
            var9D68F14379A550242867922C161646A9_205947465.addTaint(taint);
            return var9D68F14379A550242867922C161646A9_205947465;
            // ---------- Original Method ----------
            //String authority = getEncodedAuthority();
            //if (authority == null) {
                //return null;
            //}
            //int end = authority.indexOf('@');
            //return end == NOT_FOUND ? null : authority.substring(0, end);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.756 -0400", hash_original_method = "575ECF6860F7EEFE5055BF56F2601A0E", hash_generated_method = "25EA65AC84B9AE2B9CE6305BFD4A2417")
        public String getUserInfo() {
String varB4A42524A46C4FAD7FBAC514070D2A61_1881687465 =             getUserInfoPart().getDecoded();
            varB4A42524A46C4FAD7FBAC514070D2A61_1881687465.addTaint(taint);
            return varB4A42524A46C4FAD7FBAC514070D2A61_1881687465;
            // ---------- Original Method ----------
            //return getUserInfoPart().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.756 -0400", hash_original_method = "2FC22A6CCA0A3F4C0B9E4C09F79A556D", hash_generated_method = "610657B41B3A84D2F8B0E2A8488B55A5")
        public String getHost() {
            @SuppressWarnings("StringEquality") boolean cached = (host != NOT_CACHED);
String var8FB9745AFEFD90E610A95B02DD737746_937101336 =             cached ? host
                    : (host = parseHost());
            var8FB9745AFEFD90E610A95B02DD737746_937101336.addTaint(taint);
            return var8FB9745AFEFD90E610A95B02DD737746_937101336;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (host != NOT_CACHED);
            //return cached ? host
                    //: (host = parseHost());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.756 -0400", hash_original_method = "F3410DE0DFF96D0677FF54552E852FC4", hash_generated_method = "DAF771A2C1F70DBC11050D7688912B94")
        private String parseHost() {
            String authority = getEncodedAuthority();
    if(authority == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1761298539 =                 null;
                var540C13E9E156B687226421B24F2DF178_1761298539.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1761298539;
            } //End block
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);
            String encodedHost = portSeparator == NOT_FOUND
                    ? authority.substring(userInfoSeparator + 1)
                    : authority.substring(userInfoSeparator + 1, portSeparator);
String var608417B3BC2F90A7AFAAFAF8F1F376E0_2064067737 =             decode(encodedHost);
            var608417B3BC2F90A7AFAAFAF8F1F376E0_2064067737.addTaint(taint);
            return var608417B3BC2F90A7AFAAFAF8F1F376E0_2064067737;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_method = "A497EF38F72042FD9397DCB617BC4BBC", hash_generated_method = "3DC3E7919B028D0D4A6A36D5E32AD8A3")
        public int getPort() {
            int var7D5469D2554BBE8BEA01480744CB64B8_595135275 = (port == NOT_CALCULATED
                    ? port = parsePort()
                    : port);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764798650 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764798650;
            // ---------- Original Method ----------
            //return port == NOT_CALCULATED
                    //? port = parsePort()
                    //: port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_method = "5469820A1C15A09B87242C85BC223022", hash_generated_method = "05DD4918B8C4F0773748D3E6ACD1D274")
        private int parsePort() {
            String authority = getEncodedAuthority();
    if(authority == null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2020057780 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728344313 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728344313;
            } //End block
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);
    if(portSeparator == NOT_FOUND)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_831204335 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_136362490 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_136362490;
            } //End block
            String portString = decode(authority.substring(portSeparator + 1));
            try 
            {
                int varFBDD8FEF87E1A48D29F5CB7C1376F258_1062853425 = (Integer.parseInt(portString));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008953574 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008953574;
            } //End block
            catch (NumberFormatException e)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2146313777 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973112020 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973112020;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.757 -0400", hash_original_field = "2BBB7D14660BA196C018E7EF1E07014A", hash_generated_field = "9968E15A97464199002C3D2A70E60BF1")

        private volatile String uriString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.758 -0400", hash_original_method = "4B8A4922E90F4F5C5F11CB942A244C7D", hash_generated_method = "68A9127EDB06137E28202F2E575DFD47")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.758 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AAFF96A22F03A5D660B4B2B45477967D")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1711859193 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359337415 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359337415;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.758 -0400", hash_original_method = "601AB6BE7C1B16F2DB83E078DF9B61DC", hash_generated_method = "6A38504F7EF3B41458C9CFB61B747E71")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.758 -0400", hash_original_method = "3471DB7575AAB7FBFD2140BF4AB89F77", hash_generated_method = "5C9DD9452A4C04D8FA693366C47FAE91")
        public boolean isHierarchical() {
            boolean varB326B5062B2F0E69046810717534CB09_1967351254 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792661563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792661563;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.760 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "ECA3D6EA5E3BBE66E7594C8ECCE1EAE3")
        public boolean isRelative() {
            boolean var4518A3BFE1F17529286D9D4EFE362EA9_657496407 = (scheme == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_650363226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_650363226;
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.760 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FEFCEF6CCE9F6829902E084D07E2C500")
        public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_1879268385 =             scheme;
            varFD3305CF8340E40F0AC0AB554909AEBC_1879268385.addTaint(taint);
            return varFD3305CF8340E40F0AC0AB554909AEBC_1879268385;
            // ---------- Original Method ----------
            //return scheme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.761 -0400", hash_original_method = "6F57A7CA1E43F50667C0921A8F0F4C1E", hash_generated_method = "DEEAB001B62B7F6443A0EF0190443B69")
        private Part getSsp() {
Part var612ADADF05B7551B37A539180151D856_1863722011 =             ssp == null
                    ? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
            var612ADADF05B7551B37A539180151D856_1863722011.addTaint(taint);
            return var612ADADF05B7551B37A539180151D856_1863722011;
            // ---------- Original Method ----------
            //return ssp == null
                    //? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.761 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "CDB93836FD0C9989E23970CAFB336BA9")
        public String getEncodedSchemeSpecificPart() {
String var393D011CD485FB233FC4BE4326461491_2044362727 =             getSsp().getEncoded();
            var393D011CD485FB233FC4BE4326461491_2044362727.addTaint(taint);
            return var393D011CD485FB233FC4BE4326461491_2044362727;
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.761 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "3A3AA09A1829F7B0EAA424AFFBC4C5BD")
        public String getSchemeSpecificPart() {
String varDEA78A046E5755E6A172773CC85259A6_1941035900 =             getSsp().getDecoded();
            varDEA78A046E5755E6A172773CC85259A6_1941035900.addTaint(taint);
            return varDEA78A046E5755E6A172773CC85259A6_1941035900;
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.761 -0400", hash_original_method = "EA75444742B675900BB1383BC22E224C", hash_generated_method = "C27CCC8E075A35026B7581C6633A6C94")
        private String makeSchemeSpecificPart() {
            StringBuilder builder = new StringBuilder();
            appendSspTo(builder);
String varF4CF030572656354ACFDF83FEE21D7A6_1614050809 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_1614050809.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_1614050809;
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //appendSspTo(builder);
            //return builder.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.762 -0400", hash_original_method = "55EA79AD41E607B8DD0B042A78040234", hash_generated_method = "6482B19B506A7357F59DD4CC14EB48C5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.762 -0400", hash_original_method = "4FC7F3346B5C0FC1519928E52B2843FB", hash_generated_method = "14ABE121D222A3E942FB1203912FB59A")
        public String getAuthority() {
String varDD511262F0E7679CA44A2E8218470028_1059099846 =             this.authority.getDecoded();
            varDD511262F0E7679CA44A2E8218470028_1059099846.addTaint(taint);
            return varDD511262F0E7679CA44A2E8218470028_1059099846;
            // ---------- Original Method ----------
            //return this.authority.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.762 -0400", hash_original_method = "02F0907154122B499105718EFAFFB12D", hash_generated_method = "CAE1C4B4A5EB0DE81E6FF34CA84D9256")
        public String getEncodedAuthority() {
String var19AE63614558C7149808DBD062B65B6B_1163704315 =             this.authority.getEncoded();
            var19AE63614558C7149808DBD062B65B6B_1163704315.addTaint(taint);
            return var19AE63614558C7149808DBD062B65B6B_1163704315;
            // ---------- Original Method ----------
            //return this.authority.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.762 -0400", hash_original_method = "C2F72FED192DF0C1254C49B5EAFF6B37", hash_generated_method = "4BA30D5F09F937CD0AA0ED4A728867A8")
        public String getEncodedPath() {
String varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_864361052 =             this.path.getEncoded();
            varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_864361052.addTaint(taint);
            return varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_864361052;
            // ---------- Original Method ----------
            //return this.path.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.762 -0400", hash_original_method = "6081DF09BF7A0319CE8B8794EF03DD3D", hash_generated_method = "62F74DFA1F2F65E7C03C27D8F6AEB137")
        public String getPath() {
String var83F9CE5C9BAF5C5C429C86F8D8178641_1066419813 =             this.path.getDecoded();
            var83F9CE5C9BAF5C5C429C86F8D8178641_1066419813.addTaint(taint);
            return var83F9CE5C9BAF5C5C429C86F8D8178641_1066419813;
            // ---------- Original Method ----------
            //return this.path.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.762 -0400", hash_original_method = "BB14E9B85B4B70FE8537ADEAEA0F30F8", hash_generated_method = "4C6458F9CCF2525B13B6FEC663E50431")
        public String getQuery() {
String var0FC25D767B999B6312889F23BA6B3E21_1397121610 =             this.query.getDecoded();
            var0FC25D767B999B6312889F23BA6B3E21_1397121610.addTaint(taint);
            return var0FC25D767B999B6312889F23BA6B3E21_1397121610;
            // ---------- Original Method ----------
            //return this.query.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.762 -0400", hash_original_method = "4E4841C1D3AAC7E9E3EC5666E1D3BDC7", hash_generated_method = "2C36AFBB3DC34785ABE5A90793304C34")
        public String getEncodedQuery() {
String varD80217C924F7F40BAC074946FDBADEEC_1677782194 =             this.query.getEncoded();
            varD80217C924F7F40BAC074946FDBADEEC_1677782194.addTaint(taint);
            return varD80217C924F7F40BAC074946FDBADEEC_1677782194;
            // ---------- Original Method ----------
            //return this.query.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.763 -0400", hash_original_method = "BC71EA5136922A2C431D19FA4D7E797E", hash_generated_method = "1E96DE90FE5EE361993E22C99C88959B")
        public String getFragment() {
String varD91F6287F55E70D82879F259060BB4F7_1999914189 =             this.fragment.getDecoded();
            varD91F6287F55E70D82879F259060BB4F7_1999914189.addTaint(taint);
            return varD91F6287F55E70D82879F259060BB4F7_1999914189;
            // ---------- Original Method ----------
            //return this.fragment.getDecoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.763 -0400", hash_original_method = "D0BDA4E24821D7C40932E823B160DCAD", hash_generated_method = "D52D328DC04BC77F72EEB99B6F4826F9")
        public String getEncodedFragment() {
String var9BE81904ABD2B0EBFE2214CE0EE4BBFD_453306539 =             this.fragment.getEncoded();
            var9BE81904ABD2B0EBFE2214CE0EE4BBFD_453306539.addTaint(taint);
            return var9BE81904ABD2B0EBFE2214CE0EE4BBFD_453306539;
            // ---------- Original Method ----------
            //return this.fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.763 -0400", hash_original_method = "6A1F2A59685BCA2552F3B76D88CB5845", hash_generated_method = "ABCDB102DB94AD206BE00FC80E04286F")
        public List<String> getPathSegments() {
List<String> varA8049C752B325D0BCB78F1A90EC0D736_2123729167 =             this.path.getPathSegments();
            varA8049C752B325D0BCB78F1A90EC0D736_2123729167.addTaint(taint);
            return varA8049C752B325D0BCB78F1A90EC0D736_2123729167;
            // ---------- Original Method ----------
            //return this.path.getPathSegments();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.763 -0400", hash_original_method = "2FFEEC7D33EBEEF04178DF9D921CBC02", hash_generated_method = "8684D18ED13DC8A1D273110F4360BAA1")
        @Override
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached = (uriString != NOT_CACHED);
String var9B86F3459D079E341060C628CFD4EC8E_1499319601 =             cached ? uriString
                    : (uriString = makeUriString());
            var9B86F3459D079E341060C628CFD4EC8E_1499319601.addTaint(taint);
            return var9B86F3459D079E341060C628CFD4EC8E_1499319601;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (uriString != NOT_CACHED);
            //return cached ? uriString
                    //: (uriString = makeUriString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.763 -0400", hash_original_method = "5AECD242275C33F74DCA414A6C8DF5D7", hash_generated_method = "46521C71ACF38B0D485BCA44CBEE58AE")
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
String varF4CF030572656354ACFDF83FEE21D7A6_746956393 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_746956393.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_746956393;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_method = "6635CD2DD122D7EE5F14A5F21B272B08", hash_generated_method = "B32C666BE8AAB70A6E93199552EB376F")
        public Builder buildUpon() {
Builder varED3F8822050435D1DCF8FEEC1E3625B3_850670095 =             new Builder()
                    .scheme(scheme)
                    .authority(authority)
                    .path(path)
                    .query(query)
                    .fragment(fragment);
            varED3F8822050435D1DCF8FEEC1E3625B3_850670095.addTaint(taint);
            return varED3F8822050435D1DCF8FEEC1E3625B3_850670095;
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(scheme)
                    //.authority(authority)
                    //.path(path)
                    //.query(query)
                    //.fragment(fragment);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_field = "1A6BAB54CA68848B2D28EFB422CF1725", hash_generated_field = "F1F90627D661D3D25ABE19AF04422DA0")

        static final int TYPE_ID = 3;
    }


    
    public static final class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_field = "E17823015F179701BCEC9CD4356C4A38", hash_generated_field = "F30F644E178A706F0279AC78D6913562")

        private Part opaquePart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.765 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "7F0D829FE2A4B9F217489244A9FD2E61")
        public  Builder() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.766 -0400", hash_original_method = "1FAF048543AEDF54BF8218C15362FDC3", hash_generated_method = "5E4A473D63B3B0ABE52BA8194FA10F35")
        public Builder scheme(String scheme) {
            this.scheme = scheme;
Builder var72A74007B2BE62B849F475C7BDA4658B_1059307637 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1059307637.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1059307637;
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.766 -0400", hash_original_method = "8D4C2B402A916DF01BF39AF004B22B4B", hash_generated_method = "17BEFD60AADA7D771F221DBF9FE43C76")
         Builder opaquePart(Part opaquePart) {
            this.opaquePart = opaquePart;
Builder var72A74007B2BE62B849F475C7BDA4658B_1370116580 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1370116580.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1370116580;
            // ---------- Original Method ----------
            //this.opaquePart = opaquePart;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.766 -0400", hash_original_method = "B04C2A20C29308DA58A03AAA34E4602D", hash_generated_method = "2BDF9FB7D4092DBEEDFE13A6851EFB23")
        public Builder opaquePart(String opaquePart) {
            addTaint(opaquePart.getTaint());
Builder var447EF4E65B1A86D27C660BD3406092A1_753977493 =             opaquePart(Part.fromDecoded(opaquePart));
            var447EF4E65B1A86D27C660BD3406092A1_753977493.addTaint(taint);
            return var447EF4E65B1A86D27C660BD3406092A1_753977493;
            // ---------- Original Method ----------
            //return opaquePart(Part.fromDecoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.766 -0400", hash_original_method = "E3AC90668DB82124786DAC21400DF68F", hash_generated_method = "AF911592B07500E68926456185FF0FC7")
        public Builder encodedOpaquePart(String opaquePart) {
            addTaint(opaquePart.getTaint());
Builder var34CFA2F802F04C1F00EC4E996B5D7270_460455063 =             opaquePart(Part.fromEncoded(opaquePart));
            var34CFA2F802F04C1F00EC4E996B5D7270_460455063.addTaint(taint);
            return var34CFA2F802F04C1F00EC4E996B5D7270_460455063;
            // ---------- Original Method ----------
            //return opaquePart(Part.fromEncoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.768 -0400", hash_original_method = "CE12FA6D2315F74B1A3B79C027FFFA6D", hash_generated_method = "2ED2FC35E3C2633326DEAAB6A95439A7")
         Builder authority(Part authority) {
            this.opaquePart = null;
            this.authority = authority;
Builder var72A74007B2BE62B849F475C7BDA4658B_1721359575 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1721359575.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1721359575;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.authority = authority;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.768 -0400", hash_original_method = "8B987B114EF487282F33A481DCB273CB", hash_generated_method = "CFE47024B2F745ED04A41BDB732479D4")
        public Builder authority(String authority) {
            addTaint(authority.getTaint());
Builder var2EDA88150582111521EDC9CAB7001682_448284993 =             authority(Part.fromDecoded(authority));
            var2EDA88150582111521EDC9CAB7001682_448284993.addTaint(taint);
            return var2EDA88150582111521EDC9CAB7001682_448284993;
            // ---------- Original Method ----------
            //return authority(Part.fromDecoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.768 -0400", hash_original_method = "2AF9D1463857894BBB2A3B7E377A77BB", hash_generated_method = "F62F7002B69F8952C37B276C9DF5A63B")
        public Builder encodedAuthority(String authority) {
            addTaint(authority.getTaint());
Builder var426370EFE7B4302B3E1C247DE7CA1F10_489614963 =             authority(Part.fromEncoded(authority));
            var426370EFE7B4302B3E1C247DE7CA1F10_489614963.addTaint(taint);
            return var426370EFE7B4302B3E1C247DE7CA1F10_489614963;
            // ---------- Original Method ----------
            //return authority(Part.fromEncoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.769 -0400", hash_original_method = "0552AFD7FA04CD9C4E588C7FB644B387", hash_generated_method = "C52BDA38F6E80C345C9780376570DBFF")
         Builder path(PathPart path) {
            this.opaquePart = null;
            this.path = path;
Builder var72A74007B2BE62B849F475C7BDA4658B_646277947 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_646277947.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_646277947;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.path = path;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.769 -0400", hash_original_method = "311D5047B3596F1C34DEC3DA1D1264C5", hash_generated_method = "4B63F32434AE6BA2FF85172E1964288A")
        public Builder path(String path) {
            addTaint(path.getTaint());
Builder varE93D7008AE3144DB58924E5F7D03413A_2122082453 =             path(PathPart.fromDecoded(path));
            varE93D7008AE3144DB58924E5F7D03413A_2122082453.addTaint(taint);
            return varE93D7008AE3144DB58924E5F7D03413A_2122082453;
            // ---------- Original Method ----------
            //return path(PathPart.fromDecoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.769 -0400", hash_original_method = "B2733F0C4852B782EB87F01613E6C574", hash_generated_method = "EFBE8B74CD1C2D4E57BDD15AB92902BB")
        public Builder encodedPath(String path) {
            addTaint(path.getTaint());
Builder var2C099BD4CBAC004E7DBA3E062586EF05_1634585813 =             path(PathPart.fromEncoded(path));
            var2C099BD4CBAC004E7DBA3E062586EF05_1634585813.addTaint(taint);
            return var2C099BD4CBAC004E7DBA3E062586EF05_1634585813;
            // ---------- Original Method ----------
            //return path(PathPart.fromEncoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.769 -0400", hash_original_method = "818DCEC2192004BCFE40E4E49FDA7A4C", hash_generated_method = "545381BF0175BE394F7902E0D9511FD4")
        public Builder appendPath(String newSegment) {
            addTaint(newSegment.getTaint());
Builder var8D3C52E329AACC9BA26FC60EDBDA633E_1903733345 =             path(PathPart.appendDecodedSegment(path, newSegment));
            var8D3C52E329AACC9BA26FC60EDBDA633E_1903733345.addTaint(taint);
            return var8D3C52E329AACC9BA26FC60EDBDA633E_1903733345;
            // ---------- Original Method ----------
            //return path(PathPart.appendDecodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.771 -0400", hash_original_method = "04B6E07373B5BCB6E5F5541B11BC55A7", hash_generated_method = "BE1C3319E5238AEA95078E8B5A344E78")
        public Builder appendEncodedPath(String newSegment) {
            addTaint(newSegment.getTaint());
Builder var15BBA848D385BBCE5F9325C9F07D3D5A_973627066 =             path(PathPart.appendEncodedSegment(path, newSegment));
            var15BBA848D385BBCE5F9325C9F07D3D5A_973627066.addTaint(taint);
            return var15BBA848D385BBCE5F9325C9F07D3D5A_973627066;
            // ---------- Original Method ----------
            //return path(PathPart.appendEncodedSegment(path, newSegment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.771 -0400", hash_original_method = "526B00AFFC674BC410AFF0DB5058AD68", hash_generated_method = "2BE2E9F2EE9F94C4210F88F2065BC9D7")
         Builder query(Part query) {
            this.opaquePart = null;
            this.query = query;
Builder var72A74007B2BE62B849F475C7BDA4658B_849470634 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_849470634.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_849470634;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.query = query;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.771 -0400", hash_original_method = "915051404F16544BAB27A534573CC34D", hash_generated_method = "BAED94C303ECC741F79FD79847242AB8")
        public Builder query(String query) {
            addTaint(query.getTaint());
Builder var66923BEC3D8C1278767576BF4D394152_416477836 =             query(Part.fromDecoded(query));
            var66923BEC3D8C1278767576BF4D394152_416477836.addTaint(taint);
            return var66923BEC3D8C1278767576BF4D394152_416477836;
            // ---------- Original Method ----------
            //return query(Part.fromDecoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.771 -0400", hash_original_method = "2B1CFFF6E8520529FC529F01B5DBCD04", hash_generated_method = "E6697D4B1AF98A6B9EF0FAF2E0794538")
        public Builder encodedQuery(String query) {
            addTaint(query.getTaint());
Builder var05319EFE71D4D5FABCEFB5394AF0F3A4_1173885160 =             query(Part.fromEncoded(query));
            var05319EFE71D4D5FABCEFB5394AF0F3A4_1173885160.addTaint(taint);
            return var05319EFE71D4D5FABCEFB5394AF0F3A4_1173885160;
            // ---------- Original Method ----------
            //return query(Part.fromEncoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.771 -0400", hash_original_method = "AAD8E80453C4B46D11B41869FDCBA00D", hash_generated_method = "28711AA3DF2509F2DAB5D626B2CB5827")
         Builder fragment(Part fragment) {
            this.fragment = fragment;
Builder var72A74007B2BE62B849F475C7BDA4658B_1755202165 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1755202165.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1755202165;
            // ---------- Original Method ----------
            //this.fragment = fragment;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.772 -0400", hash_original_method = "016C309F39EF5D90CF32B95F6FDB27F8", hash_generated_method = "04BE290D28714FBE9813FE1D4D6369B1")
        public Builder fragment(String fragment) {
            addTaint(fragment.getTaint());
Builder var8A0E66BF4149A1703B51D880CE7BD3FB_1362213049 =             fragment(Part.fromDecoded(fragment));
            var8A0E66BF4149A1703B51D880CE7BD3FB_1362213049.addTaint(taint);
            return var8A0E66BF4149A1703B51D880CE7BD3FB_1362213049;
            // ---------- Original Method ----------
            //return fragment(Part.fromDecoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.772 -0400", hash_original_method = "C5F51A11F0BEF63CCF4FD5F6AF742648", hash_generated_method = "11403A7D7B1742473CDFB7AEE59BF76E")
        public Builder encodedFragment(String fragment) {
            addTaint(fragment.getTaint());
Builder varF653F4C1C1E12E452895547E2A8D497C_2054344239 =             fragment(Part.fromEncoded(fragment));
            varF653F4C1C1E12E452895547E2A8D497C_2054344239.addTaint(taint);
            return varF653F4C1C1E12E452895547E2A8D497C_2054344239;
            // ---------- Original Method ----------
            //return fragment(Part.fromEncoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.774 -0400", hash_original_method = "F83D70A0FC90543F01AB6385367098CC", hash_generated_method = "38D8B2E8087817545F346203EBE6BD39")
        public Builder appendQueryParameter(String key, String value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            this.opaquePart = null;
            String encodedParameter = encode(key, null) + "="
                    + encode(value, null);
    if(query == null)            
            {
                query = Part.fromEncoded(encodedParameter);
Builder var72A74007B2BE62B849F475C7BDA4658B_1165513973 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1165513973.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1165513973;
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
Builder var72A74007B2BE62B849F475C7BDA4658B_1745606145 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1745606145.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1745606145;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.774 -0400", hash_original_method = "581A1CF068B5634C1F252DE7C2737E06", hash_generated_method = "994CFABC198B286013C2F204AD451358")
        public Builder clearQuery() {
Builder var53FE33D9FA667E351CE36A4E53159F37_907939201 =             query((Part) null);
            var53FE33D9FA667E351CE36A4E53159F37_907939201.addTaint(taint);
            return var53FE33D9FA667E351CE36A4E53159F37_907939201;
            // ---------- Original Method ----------
            //return query((Part) null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.774 -0400", hash_original_method = "C36CE5067F02DA1F1C7276BF67665A1B", hash_generated_method = "29B398FF9ADDA5029764FFBFF91D4F7A")
        public Uri build() {
    if(opaquePart != null)            
            {
    if(this.scheme == null)                
                {
                    UnsupportedOperationException varBBE90DF2A7DE2FEB6E102C54C2A10961_1425242323 = new UnsupportedOperationException(
                            "An opaque URI must have a scheme.");
                    varBBE90DF2A7DE2FEB6E102C54C2A10961_1425242323.addTaint(taint);
                    throw varBBE90DF2A7DE2FEB6E102C54C2A10961_1425242323;
                } //End block
Uri varBD7EC89A1E53A9CF305CC36AF2561E02_249525448 =                 new OpaqueUri(scheme, opaquePart, fragment);
                varBD7EC89A1E53A9CF305CC36AF2561E02_249525448.addTaint(taint);
                return varBD7EC89A1E53A9CF305CC36AF2561E02_249525448;
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
Uri var1A5C773E6B2C9527C52233E0D175F391_2039176192 =                 new HierarchicalUri(
                        scheme, authority, path, query, fragment);
                var1A5C773E6B2C9527C52233E0D175F391_2039176192.addTaint(taint);
                return var1A5C773E6B2C9527C52233E0D175F391_2039176192;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.774 -0400", hash_original_method = "7917AD3B49169A1AC8EEA7DD014B7E45", hash_generated_method = "2B8E10446CD295DA89FF1688B63463F3")
        private boolean hasSchemeOrAuthority() {
            boolean var66F0DE1EAD0A64E28D3A3FCCC8CAE0D4_1975763531 = (scheme != null
                    || (authority != null && authority != Part.NULL));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991528605 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_991528605;
            // ---------- Original Method ----------
            //return scheme != null
                    //|| (authority != null && authority != Part.NULL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.774 -0400", hash_original_method = "50FC77E3DFFDDD2DB7D0B749912434F7", hash_generated_method = "59DBA8C44D706FE63AFFAFD33A89DD42")
        @Override
        public String toString() {
String var83CCC8E6DBC69F3499A1E5AC609A34CF_620334279 =             build().toString();
            var83CCC8E6DBC69F3499A1E5AC609A34CF_620334279.addTaint(taint);
            return var83CCC8E6DBC69F3499A1E5AC609A34CF_620334279;
            // ---------- Original Method ----------
            //return build().toString();
        }

        
    }


    
    static abstract class AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.775 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "08274B7EEBA921030ECC3D76D1E6ECCB")

        volatile String encoded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.775 -0400", hash_original_field = "AD05458423E19C1FF1F3C0237F8CFBED", hash_generated_field = "B682B941676F7CF6A565D2078C9BC0A9")

        volatile String decoded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.775 -0400", hash_original_method = "21E01F693530948BFE81E2C9AE8C6D31", hash_generated_method = "00DF56A1D35C3F914A2155477BDE237F")
          AbstractPart(String encoded, String decoded) {
            this.encoded = encoded;
            this.decoded = decoded;
            // ---------- Original Method ----------
            //this.encoded = encoded;
            //this.decoded = decoded;
        }

        
        abstract String getEncoded();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.776 -0400", hash_original_method = "06323BBC323E7F59CEDDE1FAA04ED1F6", hash_generated_method = "AD11D19FD24FB8C711AFDE73EFBDF9A8")
        final String getDecoded() {
            @SuppressWarnings("StringEquality") boolean hasDecoded = decoded != NOT_CACHED;
String varF9DE9787DBBABACF674820C53FE77B7A_1267378933 =             hasDecoded ? decoded : (decoded = decode(encoded));
            varF9DE9787DBBABACF674820C53FE77B7A_1267378933.addTaint(taint);
            return varF9DE9787DBBABACF674820C53FE77B7A_1267378933;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasDecoded = decoded != NOT_CACHED;
            //return hasDecoded ? decoded : (decoded = decode(encoded));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.776 -0400", hash_original_method = "BB7E54AFB81798C035BF3B3717F470E7", hash_generated_method = "2EDEF720196EBAC623B3F0512E2041D7")
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
                IllegalArgumentException var25F0B2A44934D2D997027BC02866E4A5_2096874179 = new IllegalArgumentException("Neither encoded nor decoded");
                var25F0B2A44934D2D997027BC02866E4A5_2096874179.addTaint(taint);
                throw var25F0B2A44934D2D997027BC02866E4A5_2096874179;
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.776 -0400", hash_original_method = "49186660D0AEF0721F749C758CF0FE34", hash_generated_method = "49186660D0AEF0721F749C758CF0FE34")
            public Representation ()
            {
                //Synthesized constructor
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.776 -0400", hash_original_field = "659BA2B3286FF6C4923CFE851F3CD42E", hash_generated_field = "FF4F4E4C6DA0CB1E3DB9C13C6C3A4A5B")

            static final int BOTH = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.776 -0400", hash_original_field = "D22FD9F8AEEC62F2AEF921B20283C7C9", hash_generated_field = "A15D22B3282778C07B2BEC94A0EE0FD2")

            static final int ENCODED = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.776 -0400", hash_original_field = "7CA715B76440B29FFB05D39B0C592B7F", hash_generated_field = "8C3D0A85A317D2355A45465A71C73F69")

            static final int DECODED = 2;
        }


        
    }


    
    static class Part extends AbstractPart {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.776 -0400", hash_original_method = "68B275EBA6010E5404727E121615E229", hash_generated_method = "CE292AEA2FF3777030E1EB75C7BF77AA")
        private  Part(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(decoded.getTaint());
            addTaint(encoded.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.778 -0400", hash_original_method = "BD94DCCF5B44419F4498543CA74892E2", hash_generated_method = "3938D66DE6C4FFC0DD40BDE259ED0050")
         boolean isEmpty() {
            boolean var68934A3E9455FA72420237EB05902327_1064960387 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_489107858 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_489107858;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.778 -0400", hash_original_method = "74B8C999E422A266FD890BA259F6B43C", hash_generated_method = "D8F8970313E2CB10F70A80D1BBA11FAC")
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
String varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_400236575 =             hasEncoded ? encoded : (encoded = encode(decoded));
            varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_400236575.addTaint(taint);
            return varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_400236575;
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.779 -0400", hash_original_method = "D79C0256E86C850253FAE782AD9920ED", hash_generated_method = "D6E891CD56E98A9A6565F34666DC1B4A")
            public  EmptyPart(String value) {
                super(value, value);
                addTaint(value.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.780 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "923B6A5E84B6D19BB1F586C74C322B15")
            @Override
             boolean isEmpty() {
                boolean varB326B5062B2F0E69046810717534CB09_89484169 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1542021969 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1542021969;
                // ---------- Original Method ----------
                //return true;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.780 -0400", hash_original_field = "22902092D13F95EF047EC38F67C7A689", hash_generated_field = "B57558D017E2A8337F27C36F5D930EAB")

        static final Part NULL = new EmptyPart(null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.780 -0400", hash_original_field = "7F2DFD92B4F00B07EC2711F9AFB4D4CD", hash_generated_field = "D56E54A9BB15BF578A32B43A761A7D58")

        static final Part EMPTY = new EmptyPart("");
    }


    
    static class PathPart extends AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.780 -0400", hash_original_field = "5C8A59F77C438336819DD4F6B0C372B5", hash_generated_field = "BB8884736C4C2C995D440C597E10BBE6")

        private PathSegments pathSegments;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.780 -0400", hash_original_method = "E8CA21F7072E8C7642F3BFF9454329AE", hash_generated_method = "BCE7A6DB1134431144E50BD91D1A7695")
        private  PathPart(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(decoded.getTaint());
            addTaint(encoded.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.780 -0400", hash_original_method = "EEE1C5D1C73794B2424FF9B6A794D8BE", hash_generated_method = "843EDEB5FB6713C7C08390D3E757E0B3")
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
String varEFDAC2AC5D53E9CE24C648C5C33F0808_818508418 =             hasEncoded ? encoded : (encoded = encode(decoded, "/"));
            varEFDAC2AC5D53E9CE24C648C5C33F0808_818508418.addTaint(taint);
            return varEFDAC2AC5D53E9CE24C648C5C33F0808_818508418;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded, "/"));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.781 -0400", hash_original_method = "BB12DAE5001652F9E9419E41FB496BCF", hash_generated_method = "956E066C7A113A0D8772C59FD3289204")
         PathSegments getPathSegments() {
    if(pathSegments != null)            
            {
PathSegments var5204DC86E95830EB05C770BC38BED307_569365192 =                 pathSegments;
                var5204DC86E95830EB05C770BC38BED307_569365192.addTaint(taint);
                return var5204DC86E95830EB05C770BC38BED307_569365192;
            } //End block
            String path = getEncoded();
    if(path == null)            
            {
PathSegments var73DD0AB3EF50886F4E8427C8CCBD1FAF_233690400 =                 pathSegments = PathSegments.EMPTY;
                var73DD0AB3EF50886F4E8427C8CCBD1FAF_233690400.addTaint(taint);
                return var73DD0AB3EF50886F4E8427C8CCBD1FAF_233690400;
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
PathSegments var58DFB823F4B6E95DFEC9F8BC0A1DF96E_1391484081 =             pathSegments = segmentBuilder.build();
            var58DFB823F4B6E95DFEC9F8BC0A1DF96E_1391484081.addTaint(taint);
            return var58DFB823F4B6E95DFEC9F8BC0A1DF96E_1391484081;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "12FCD4CDDE0159C0A83B0F6923FAC7D8", hash_generated_field = "CE631D3EC26A75E141BE1EBBE7AA5D88")

        static final PathPart NULL = new PathPart(null, null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "2511CF6735334EEEFE4C66E3501EA765", hash_generated_field = "092DD7A22CF30B1C24AB41550FA2A397")

        static final PathPart EMPTY = new PathPart("", "");
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "15E64A01463468950481CAE21CF06FCB", hash_generated_field = "0451CD7498AE36BDD61110634E7FCA90")

    private static final String LOG = Uri.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "A90280C308D46EDE51003B54A6774638", hash_generated_field = "B954F9C12AC0662BCBDFC1BE53358724")

    @SuppressWarnings("RedundantStringConstructorCall") private static final String NOT_CACHED = new String("NOT CACHED");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "A81A920AEF8690239BB9D44F7E78D4F4", hash_generated_field = "5038C252470848AFDD24667CC5D97705")

    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL,
            PathPart.EMPTY, Part.NULL, Part.NULL);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "096628D07602808452D76140024603D6", hash_generated_field = "70D3B26ADAF374FF9FC1A886C7965F17")

    private final static int NOT_FOUND = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "4FDDDF7A3C684DEFD4771F4F71A53864", hash_generated_field = "309A8D293FB70CF3C8B75760A49AAA8A")

    private final static int NOT_CALCULATED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "6DE16BB1834113B41F3DB9E09DDB15A3", hash_generated_field = "D90B08A155B6660D5725B7F9B3B765E3")

    private static final String NOT_HIERARCHICAL = "This isn't a hierarchical URI.";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.783 -0400", hash_original_field = "2D7FBEFE0E1B69A4322A3C2F72D1B945", hash_generated_field = "801ABCF993C84AFFC2A4DEC33E3ED2DF")

    private static final String DEFAULT_ENCODING = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.784 -0400", hash_original_field = "FEE7EF6013925E53DB51A6700DEA6FED", hash_generated_field = "013D84CBB14787012A1B410C2CED92EA")

    private static final int NULL_TYPE_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.784 -0400", hash_original_field = "FA031E527800FCED59C59BB3277BEE96", hash_generated_field = "A8963E713BB231EFDC73C3C4317D711B")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.784 -0400", hash_original_field = "7590EBC339FE731817F9724DB1BDFD6C", hash_generated_field = "C46B2CD1575F3EFF815653AFF0EA6C73")

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.784 -0400", hash_original_field = "B895F573C0891DA82989F42094373576", hash_generated_field = "EA76FA4E6E39D084A2B31303C1E9D60D")

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
    @Override
	public int describeContents() {
		
		return 0;
	}
    
    // orphaned legacy method
    @Override
	public void writeToParcel(Parcel dest, int flags) {
		
		
	}
    
    // orphaned legacy field
    private String uriString;
    
}

