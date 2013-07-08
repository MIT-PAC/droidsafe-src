package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

public class Uri implements Parcelable, Comparable<Uri> {
    
	private String uriString;
	
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.279 -0400", hash_original_method = "81E08B95735493D923725112C83DA27A", hash_generated_method = "AE17603DE8C4908F75692349E5C02303")
    private  Uri() {
        
    	uriString = DSUtils.UNKNOWN_STRING;
    }

    
    @DSModeled(DSC.SAFE)
    public boolean isHierarchical() {
    	return getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.279 -0400", hash_original_method = "A0C9F8427F648091A08345C72525BACA", hash_generated_method = "32F4E428D9C8AF2E528A0D82AB210F03")
    public boolean isOpaque() {
        boolean var64B4064469A97508D22605F14516AC44_1239320677 = (!isHierarchical());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544808943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544808943;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public boolean isRelative() {
    	return getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.280 -0400", hash_original_method = "E92F08B9247EAC707F6805C228339DFA", hash_generated_method = "6B3BAB470AC346129824A4C6C9A43260")
    public boolean isAbsolute() {
        boolean varFAE8C8CB7DF16B40F7BD3C8C56459E57_1587092732 = (!isRelative());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333498309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333498309;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public String getScheme() {
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
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public String getUserInfo() {
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public String getEncodedUserInfo() {
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public String getHost() {
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public int getPort(){
    	return getTaintInt();
    }

    
    @DSModeled(DSC.SAFE)
    public String getPath(){
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public String getEncodedPath(){
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public String getQuery(){
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public String getEncodedQuery(){
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public String getFragment(){
    	return uriString;
    }

    
    @DSModeled(DSC.SAFE)
    public String getEncodedFragment(){
    	return uriString;
    }

    
    public List<String> getPathSegments(){
    	LinkedList<String> list = new LinkedList<String>();
		list.add(uriString);
		return list;
    }

    
    @DSModeled(DSC.SAFE)
    public String getLastPathSegment(){
    	return uriString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.283 -0400", hash_original_method = "FA9A408EEB8F8DAB44A912D276C5C2CC", hash_generated_method = "6E200725A51B600161718A7E967D3EA0")
    public boolean equals(Object o) {
        Uri other = (Uri) o;
        boolean varA0CF98E3EDF30C400FE114E3C4614876_2120173210 = (toString().equals(other.toString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971381048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_971381048;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.283 -0400", hash_original_method = "5AAF793CD4316640D385D37282629FDE", hash_generated_method = "6A81F3885FAE5EF6B61A99172D7C4D5D")
    public int hashCode() {
        int varFE9735C4A625FF797CCF16B0C7E4889C_1492519584 = (toString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990644944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990644944;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.284 -0400", hash_original_method = "45EC734684FFFB3EE70A4C12F2A2F839", hash_generated_method = "A80ADE847A43B13D80CD58A9CB186FE2")
    public int compareTo(Uri other) {
        int var9FDCE1533C4137A95AA1B9336AC2C904_597655754 = (toString().compareTo(other.toString()));
        addTaint(other.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021752188 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021752188;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public String toString() {
    	return uriString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.285 -0400", hash_original_method = "C2346F0C89241A0BA21735401E86BD49", hash_generated_method = "CCF8253640D2CB0496C48A954DCCF96A")
    public String toSafeString() {
        String varB4EAC82CA7396A68D541C85D26508E83_310674761 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_613539285 = null; 
        String scheme = getScheme();
        String ssp = getSchemeSpecificPart();
        {
            {
                boolean varECEC7553D0A8A9AA1C3551F50990F265_1234060321 = (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip")
                    || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto")
                    || scheme.equalsIgnoreCase("mailto"));
                {
                    StringBuilder builder = new StringBuilder(64);
                    builder.append(scheme);
                    builder.append(':');
                    {
                        {
                            int i = 0;
                            boolean var3701C9303431F43DBFBC3723803F56F1_431862942 = (i<ssp.length());
                            {
                                char c = ssp.charAt(i);
                                {
                                    builder.append(c);
                                } 
                                {
                                    builder.append('x');
                                } 
                            } 
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_310674761 = builder.toString();
                } 
            } 
        } 
        StringBuilder builder = new StringBuilder(64);
        {
            builder.append(scheme);
            builder.append(':');
        } 
        {
            builder.append(ssp);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_613539285 = builder.toString();
        String varA7E53CE21691AB073D9660D615818899_677974568; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_677974568 = varB4EAC82CA7396A68D541C85D26508E83_310674761;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_677974568 = varB4EAC82CA7396A68D541C85D26508E83_613539285;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_677974568.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_677974568;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public Builder buildUpon() {
    	return new Builder();
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.287 -0400", hash_original_method = "966FC11B97976C170B352F408FA2783F", hash_generated_method = "CD33BCC3E489E4881A565D7929F8DD9B")
    public Set<String> getQueryParameterNames() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_2022883362 = null; 
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1094297263 = null; 
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_1225888490 = (isOpaque());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } 
        } 
        String query = getEncodedQuery();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2022883362 = Collections.emptySet();
        } 
        Set<String> names = new LinkedHashSet<String>();
        int start = 0;
        {
            int next = query.indexOf('&', start);
            int end;
            end = query.length();
            end = next;
            int separator = query.indexOf('=', start);
            {
                separator = end;
            } 
            String name = query.substring(start, separator);
            names.add(decode(name));
            start = end + 1;
        } 
        {
            boolean var9694734975A6FBE04042BED474B6D869_396126404 = (start < query.length());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1094297263 = Collections.unmodifiableSet(names);
        Set<String> varA7E53CE21691AB073D9660D615818899_2112445807; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2112445807 = varB4EAC82CA7396A68D541C85D26508E83_2022883362;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2112445807 = varB4EAC82CA7396A68D541C85D26508E83_1094297263;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2112445807.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2112445807;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.288 -0400", hash_original_method = "9E05603A6F44EBCC73536B2584976016", hash_generated_method = "5DA715B28D93503A1888E151C531BE35")
    public List<String> getQueryParameters(String key) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1237228121 = null; 
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1243424920 = null; 
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_858948581 = (isOpaque());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key");
        } 
        String query = getEncodedQuery();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1237228121 = Collections.emptyList();
        } 
        String encodedKey;
        try 
        {
            encodedKey = URLEncoder.encode(key, DEFAULT_ENCODING);
        } 
        catch (UnsupportedEncodingException e)
        {
            throw new AssertionError(e);
        } 
        ArrayList<String> values = new ArrayList<String>();
        int start = 0;
        {
            int nextAmpersand = query.indexOf('&', start);
            int end;
            end = nextAmpersand;
            end = query.length();
            int separator = query.indexOf('=', start);
            {
                separator = end;
            } 
            {
                boolean var178076B3E468B8639CBF96A33155F9A9_1353219464 = (separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length()));
                {
                    {
                        values.add("");
                    } 
                    {
                        values.add(decode(query.substring(separator + 1, end)));
                    } 
                } 
            } 
            {
                start = nextAmpersand + 1;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1243424920 = Collections.unmodifiableList(values);
        addTaint(key.getTaint());
        List<String> varA7E53CE21691AB073D9660D615818899_1964458905; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1964458905 = varB4EAC82CA7396A68D541C85D26508E83_1237228121;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1964458905 = varB4EAC82CA7396A68D541C85D26508E83_1243424920;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1964458905.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1964458905;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.289 -0400", hash_original_method = "72F6B0777F298E12957F6498D8B3E8F1", hash_generated_method = "BC314E38598DFB15C9FCAE43E27ED486")
    public String getQueryParameter(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_95783203 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_657289670 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1211072075 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1530705704 = null; 
        {
            boolean var6FB98654367C4545BFB1C7222C5CD904_1093590865 = (isOpaque());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(NOT_HIERARCHICAL);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key");
        } 
        final String query = getEncodedQuery();
        {
            varB4EAC82CA7396A68D541C85D26508E83_95783203 = null;
        } 
        final String encodedKey = encode(key, null);
        final int length = query.length();
        int start = 0;
        {
            int nextAmpersand = query.indexOf('&', start);
            int end;
            end = nextAmpersand;
            end = length;
            int separator = query.indexOf('=', start);
            {
                separator = end;
            } 
            {
                boolean var178076B3E468B8639CBF96A33155F9A9_220355528 = (separator - start == encodedKey.length()
                    && query.regionMatches(start, encodedKey, 0, encodedKey.length()));
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_657289670 = "";
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1211072075 = decode(query.substring(separator + 1, end));
                    } 
                } 
            } 
            {
                start = nextAmpersand + 1;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1530705704 = null;
        addTaint(key.getTaint());
        String varA7E53CE21691AB073D9660D615818899_784994650; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_784994650 = varB4EAC82CA7396A68D541C85D26508E83_95783203;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_784994650 = varB4EAC82CA7396A68D541C85D26508E83_657289670;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_784994650 = varB4EAC82CA7396A68D541C85D26508E83_1211072075;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_784994650 = varB4EAC82CA7396A68D541C85D26508E83_1530705704;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_784994650.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_784994650;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.290 -0400", hash_original_method = "67BE774C17CDAC836698DE4D6D994F1B", hash_generated_method = "EFB5E05CC3279F71EAC5D88010189CA7")
    public boolean getBooleanQueryParameter(String key, boolean defaultValue) {
        String flag = getQueryParameter(key);
        flag = flag.toLowerCase();
        boolean var1524D06912FA9A8910A3FA6431D6523F_501198593 = ((!"false".equals(flag) && !"0".equals(flag)));
        addTaint(key.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979153930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979153930;
        
        
        
            
        
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.292 -0400", hash_original_field = "ACD4CFB867E9014EB5553B665A7654E7", hash_generated_field = "E4175460B78B44891D601990509D1265")

        private String uriString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.292 -0400", hash_original_field = "CAB1D5F863DB3FE1F854F1737D3BF567", hash_generated_field = "6ECAEC93E2396D17CA9FF61298DA11AE")

        private volatile int cachedSsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.292 -0400", hash_original_field = "0D27A2D8516BF4DCE688D48A00F04BF9", hash_generated_field = "6673040FAE4D4C35641720F36B224DA4")

        private volatile int cachedFsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.293 -0400", hash_original_field = "8FE13FA728B09DACBFC57E5751B51F48", hash_generated_field = "0E9D0B05543D9BBCEB78240FF4AE88F4")

        private volatile String scheme = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.293 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.293 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.293 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.293 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.293 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.294 -0400", hash_original_method = "6762E8F4F232397EC67D86B91A630B95", hash_generated_method = "A6C1825457AE7AF13DBEF010EABC8877")
        private  StringUri(String uriString) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uriString");
            } 
            this.uriString = uriString;
            
            
                
            
            
        }

        
        static Uri readFrom(Parcel parcel) {
            return new StringUri(parcel.readString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.294 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1FCE50BABC9FE5860849D82AF0A15FDC")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103994475 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103994475;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.295 -0400", hash_original_method = "C73A8428F9DA44091DF96EEDC1E3D3EF", hash_generated_method = "E60C4D7AA36A8DF226DE2DDB0065BC6D")
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(uriString);
            addTaint(parcel.getTaint());
            addTaint(flags);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.296 -0400", hash_original_method = "F197955D6E3BAB1920F769AA2F97BBD7", hash_generated_method = "7D23746246EBEC07100CD33E3FFA241A")
        private int findSchemeSeparator() {
            {
                Object varE78ED6E23D41D918630374A89968E910_610699255 = (cachedSsi = uriString.indexOf(':'));
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922501892 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922501892;
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.296 -0400", hash_original_method = "B0E1A879F11D02C30EC9FBB06F8801FE", hash_generated_method = "AE9B0DDC489BE44A79112A8F107E36B8")
        private int findFragmentSeparator() {
            {
                Object var084C492FFBD239136C6656DB9FC43D6A_1356373369 = (cachedFsi = uriString.indexOf('#', findSchemeSeparator()));
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304069012 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304069012;
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.297 -0400", hash_original_method = "11C2E375F5E033161AB2E06056D673CF", hash_generated_method = "F1659CC7050C5EE841BEE8DEC97C175F")
        public boolean isHierarchical() {
            int ssi = findSchemeSeparator();
            {
                boolean var57F8854C12EA0628EE85E2310495F80A_1311801486 = (uriString.length() == ssi + 1);
            } 
            boolean var27890038C7ED583D3363BEF736C880EE_368902862 = (uriString.charAt(ssi + 1) == '/');
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105955808 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_105955808;
            
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.297 -0400", hash_original_method = "DC1D040929AB7A4CF9A0DFBB95EA4283", hash_generated_method = "3CAFF20F01054850E076637D9AF527B5")
        public boolean isRelative() {
            boolean var3202A358296F4617942997BACCC7AFC0_1533390874 = (findSchemeSeparator() == NOT_FOUND);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770150308 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770150308;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.298 -0400", hash_original_method = "96667B7E38635C26F17AC80DC91F9ADB", hash_generated_method = "6919C4CAF4F8BD31FA11F422439E63BD")
        public String getScheme() {
            String varB4EAC82CA7396A68D541C85D26508E83_1697896107 = null; 
            @SuppressWarnings("StringEquality") boolean cached = (scheme != NOT_CACHED);
            varB4EAC82CA7396A68D541C85D26508E83_1697896107 = cached ? scheme : (scheme = parseScheme());
            varB4EAC82CA7396A68D541C85D26508E83_1697896107.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1697896107;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.298 -0400", hash_original_method = "B03A2C85823E1DE38C77FC40695B0CC7", hash_generated_method = "AD12F9C475415797CEC716CB88CF7988")
        private String parseScheme() {
            String varB4EAC82CA7396A68D541C85D26508E83_357291620 = null; 
            int ssi = findSchemeSeparator();
            varB4EAC82CA7396A68D541C85D26508E83_357291620 = ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
            varB4EAC82CA7396A68D541C85D26508E83_357291620.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_357291620;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.299 -0400", hash_original_method = "DE43C7F499D5F1739936552A95AA2492", hash_generated_method = "5DABA095A5E114E6363784538A472518")
        private Part getSsp() {
            Part varB4EAC82CA7396A68D541C85D26508E83_367620358 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_367620358 = ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
            varB4EAC82CA7396A68D541C85D26508E83_367620358.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_367620358;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.299 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "0B0813ABF23175B81F0589767B3B1918")
        public String getEncodedSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_160496749 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_160496749 = getSsp().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_160496749.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_160496749;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.300 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "FAD0881850D840150B7E4A6A6EFA5159")
        public String getSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_1143939560 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1143939560 = getSsp().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1143939560.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1143939560;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.300 -0400", hash_original_method = "6082AC88F53E9B67D59D9A72041A5D6F", hash_generated_method = "FA52A361B75B9249ED1C0EAC006CE9D1")
        private String parseSsp() {
            String varB4EAC82CA7396A68D541C85D26508E83_296947200 = null; 
            int ssi = findSchemeSeparator();
            int fsi = findFragmentSeparator();
            varB4EAC82CA7396A68D541C85D26508E83_296947200 = fsi == NOT_FOUND
                    ? uriString.substring(ssi + 1)
                    : uriString.substring(ssi + 1, fsi);
            varB4EAC82CA7396A68D541C85D26508E83_296947200.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_296947200;
            
            
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.301 -0400", hash_original_method = "C2AABBF6273BD8549508A0ABF072F220", hash_generated_method = "04D47CC04518F0B8B608A892B00E9D98")
        private Part getAuthorityPart() {
            Part varB4EAC82CA7396A68D541C85D26508E83_375746644 = null; 
            Part varB4EAC82CA7396A68D541C85D26508E83_1609715198 = null; 
            {
                String encodedAuthority = parseAuthority(this.uriString, findSchemeSeparator());
                varB4EAC82CA7396A68D541C85D26508E83_375746644 = authority = Part.fromEncoded(encodedAuthority);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1609715198 = authority;
            Part varA7E53CE21691AB073D9660D615818899_973160035; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_973160035 = varB4EAC82CA7396A68D541C85D26508E83_375746644;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_973160035 = varB4EAC82CA7396A68D541C85D26508E83_1609715198;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_973160035.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_973160035;
            
            
                
                        
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.302 -0400", hash_original_method = "B783FB869F9CE6B897E37C2A9B9B4259", hash_generated_method = "9A579AAA8D265A958B87FA98170D1BF2")
        public String getEncodedAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_275130903 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_275130903 = getAuthorityPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_275130903.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_275130903;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.303 -0400", hash_original_method = "F4404025FB90C68980598D2895AF9578", hash_generated_method = "31FB6D2525D86D3C686EE68090AABDF4")
        public String getAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_325299962 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_325299962 = getAuthorityPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_325299962.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_325299962;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.304 -0400", hash_original_method = "483C19AAE407B7D6148F370745A1893E", hash_generated_method = "49E1972328D10569291044F5E76EB996")
        private PathPart getPathPart() {
            PathPart varB4EAC82CA7396A68D541C85D26508E83_1705879846 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1705879846 = path == null
                    ? path = PathPart.fromEncoded(parsePath())
                    : path;
            varB4EAC82CA7396A68D541C85D26508E83_1705879846.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1705879846;
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.305 -0400", hash_original_method = "E8759FDECF433DBBFF0BA03CF3576CC0", hash_generated_method = "063C9A046F290D3B65B20CD357050357")
        public String getPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_940324512 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_940324512 = getPathPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_940324512.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_940324512;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.305 -0400", hash_original_method = "D26AFC1B9D9DFA82513D9A4C50DD2F0F", hash_generated_method = "F64416D08D5E3CCBEB8A43C983F741A2")
        public String getEncodedPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1222244893 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1222244893 = getPathPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1222244893.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1222244893;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.306 -0400", hash_original_method = "A1BA2B8DCFFB301EABC725C63F487DC2", hash_generated_method = "8ED4AEE33D8B34F278D24CB5FA4C89B7")
        public List<String> getPathSegments() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_2052374508 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2052374508 = getPathPart().getPathSegments();
            varB4EAC82CA7396A68D541C85D26508E83_2052374508.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2052374508;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.307 -0400", hash_original_method = "EF0989C68625FC2F46DE0EA4CB35660B", hash_generated_method = "4833A593CB28351879BACF0154B511EE")
        private String parsePath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1161813316 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_862404909 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1582434272 = null; 
            String uriString = this.uriString;
            int ssi = findSchemeSeparator();
            {
                boolean schemeOnly = ssi + 1 == uriString.length();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1161813316 = null;
                } 
                {
                    boolean varD917EE6A3AF74F85327A628F817BD281_1187752991 = (uriString.charAt(ssi + 1) != '/');
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_862404909 = null;
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1582434272 = parsePath(uriString, ssi);
            String varA7E53CE21691AB073D9660D615818899_257292606; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_257292606 = varB4EAC82CA7396A68D541C85D26508E83_1161813316;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_257292606 = varB4EAC82CA7396A68D541C85D26508E83_862404909;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_257292606 = varB4EAC82CA7396A68D541C85D26508E83_1582434272;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_257292606.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_257292606;
            
            
            
            
                
                
                    
                
                
                    
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.308 -0400", hash_original_method = "5338F6D0AC99191764C2394A710C873F", hash_generated_method = "742D42EEB00EE97C1FB02D6E2BAB9BE1")
        private Part getQueryPart() {
            Part varB4EAC82CA7396A68D541C85D26508E83_1964866753 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1964866753 = query == null
                    ? query = Part.fromEncoded(parseQuery()) : query;
            varB4EAC82CA7396A68D541C85D26508E83_1964866753.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1964866753;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.308 -0400", hash_original_method = "61892B739321CB796D242E9E13C1F033", hash_generated_method = "DBC30E06BFD36C746E7549BAE5EA54FA")
        public String getEncodedQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_2002288356 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2002288356 = getQueryPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_2002288356.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2002288356;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.309 -0400", hash_original_method = "93492ABD4F9B88C963E84B9F545E5D11", hash_generated_method = "102410C8CAE19D8D93697F67C4F35F56")
        private String parseQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_184797020 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_898561016 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_962262041 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_838109433 = null; 
            int qsi = uriString.indexOf('?', findSchemeSeparator());
            {
                varB4EAC82CA7396A68D541C85D26508E83_184797020 = null;
            } 
            int fsi = findFragmentSeparator();
            {
                varB4EAC82CA7396A68D541C85D26508E83_898561016 = uriString.substring(qsi + 1);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_962262041 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_838109433 = uriString.substring(qsi + 1, fsi);
            String varA7E53CE21691AB073D9660D615818899_1148001927; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1148001927 = varB4EAC82CA7396A68D541C85D26508E83_184797020;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1148001927 = varB4EAC82CA7396A68D541C85D26508E83_898561016;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_1148001927 = varB4EAC82CA7396A68D541C85D26508E83_962262041;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1148001927 = varB4EAC82CA7396A68D541C85D26508E83_838109433;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1148001927.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1148001927;
            
            
            
                
            
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.310 -0400", hash_original_method = "31EC40ABD8B86D0064329950E060BFBD", hash_generated_method = "1E6C8A22B5707C3191DFCD922F3F92F3")
        public String getQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_247278567 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_247278567 = getQueryPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_247278567.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_247278567;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.310 -0400", hash_original_method = "EAD370CB1FE781DF1864471D9F5F3E36", hash_generated_method = "3D811039BB228FA1252F386BA1949EBD")
        private Part getFragmentPart() {
            Part varB4EAC82CA7396A68D541C85D26508E83_1255329411 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1255329411 = fragment == null
                    ? fragment = Part.fromEncoded(parseFragment()) : fragment;
            varB4EAC82CA7396A68D541C85D26508E83_1255329411.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1255329411;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.311 -0400", hash_original_method = "C2884F3C25114B1CD652E8CCEF7D7F10", hash_generated_method = "14DE21F96D95FE459EB3F385D0630AEC")
        public String getEncodedFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_61590939 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_61590939 = getFragmentPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_61590939.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_61590939;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.312 -0400", hash_original_method = "13965C7143AC0E622773DBA6AE062E67", hash_generated_method = "A4029C9DA9A8F212CB03BB3EF5FB40DE")
        private String parseFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_1273690333 = null; 
            int fsi = findFragmentSeparator();
            varB4EAC82CA7396A68D541C85D26508E83_1273690333 = fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
            varB4EAC82CA7396A68D541C85D26508E83_1273690333.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1273690333;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.312 -0400", hash_original_method = "4E8163B4F7FDF9829581A99F6274656D", hash_generated_method = "E08B91708D282A03FFDBD7E882B52383")
        public String getFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_173606951 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_173606951 = getFragmentPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_173606951.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_173606951;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.313 -0400", hash_original_method = "ECB4588CBE3D957B88D2558A4C044374", hash_generated_method = "9C73B395D4C52C8188758939C40A8EEA")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_999075722 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_999075722 = uriString;
            varB4EAC82CA7396A68D541C85D26508E83_999075722.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_999075722;
            
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.315 -0400", hash_original_method = "54B78C0DD1C850213ABB66143A4F5DE7", hash_generated_method = "BC69BBF6C939431A93732912E174066E")
        public Builder buildUpon() {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2091705923 = null; 
            Builder varB4EAC82CA7396A68D541C85D26508E83_594102495 = null; 
            {
                boolean varDDDEF883E55C0067D538DC62E8B8900F_898332319 = (isHierarchical());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2091705923 = new Builder()
                        .scheme(getScheme())
                        .authority(getAuthorityPart())
                        .path(getPathPart())
                        .query(getQueryPart())
                        .fragment(getFragmentPart());
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_594102495 = new Builder()
                        .scheme(getScheme())
                        .opaquePart(getSsp())
                        .fragment(getFragmentPart());
                } 
            } 
            Builder varA7E53CE21691AB073D9660D615818899_2044133861; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_2044133861 = varB4EAC82CA7396A68D541C85D26508E83_2091705923;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2044133861 = varB4EAC82CA7396A68D541C85D26508E83_594102495;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2044133861.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_2044133861;
            
            
                
                        
                        
                        
                        
                        
            
                
                        
                        
                        
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.315 -0400", hash_original_field = "B0493B2AFC6F39450B0E6998DDC76696", hash_generated_field = "1525B2F69D3B82BDEA81D83890B48CEC")

        static final int TYPE_ID = 1;
    }


    
    private static class OpaqueUri extends Uri {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.315 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.315 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.315 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.315 -0400", hash_original_field = "E4D7B1085B3F20D4D3076206156621A1", hash_generated_field = "FCCD4A0FFBA55911A49FB2AEB7548D00")

        private volatile String cachedString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.316 -0400", hash_original_method = "A3EB90F61BB5DAD9A21709AA9F976DF8", hash_generated_method = "06AECF8220C181EEDE6CDB73AC6F3E82")
        private  OpaqueUri(String scheme, Part ssp, Part fragment) {
            this.scheme = scheme;
            this.ssp = ssp;
            this.fragment = fragment == null ? Part.NULL : fragment;
            
            
            
            
        }

        
        static Uri readFrom(Parcel parcel) {
            return new OpaqueUri(
                parcel.readString(),
                Part.readFrom(parcel),
                Part.readFrom(parcel)
            );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.316 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2F6DEF69100E13EFB55E7BB0614BB5D8")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672010388 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672010388;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.317 -0400", hash_original_method = "8F996E53ADCFC30BFF794C5CEED4DA61", hash_generated_method = "5EFDF35B09A0841810BA9C760D12E8B5")
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(scheme);
            ssp.writeTo(parcel);
            fragment.writeTo(parcel);
            addTaint(parcel.getTaint());
            addTaint(flags);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.317 -0400", hash_original_method = "414EEC63B62C24CE4C288B4F88575946", hash_generated_method = "9531957FFEA5B64B04C3C48DCD72C874")
        public boolean isHierarchical() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481303270 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481303270;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.318 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "77FA5E3B0037733FC83BFCCC2E2FB546")
        public boolean isRelative() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685933567 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685933567;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.318 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "FE2C50740BA665E9F1AF8673FB2D962F")
        public String getScheme() {
            String varB4EAC82CA7396A68D541C85D26508E83_1093379338 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1093379338 = this.scheme;
            varB4EAC82CA7396A68D541C85D26508E83_1093379338.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1093379338;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.319 -0400", hash_original_method = "3C55B6D4F736410AF7A2ACAB5CCC51ED", hash_generated_method = "14E3487361F4CC325C037BB189B5ADDE")
        public String getEncodedSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_1546302297 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1546302297 = ssp.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1546302297.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1546302297;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.319 -0400", hash_original_method = "ED3540C8D06E41CD645C58A620F36381", hash_generated_method = "86F3CD9401DF4614F8F7BB0577C05540")
        public String getSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_1162534018 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1162534018 = ssp.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1162534018.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1162534018;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.320 -0400", hash_original_method = "31E41E1CB0338F9BAA50A0AC05D7D02D", hash_generated_method = "91FB12C1B6C6EA872936371ED1DDB20E")
        public String getAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_511016190 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_511016190 = null;
            varB4EAC82CA7396A68D541C85D26508E83_511016190.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_511016190;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.320 -0400", hash_original_method = "C6F3CA63C6BE518EBD2AA32E2786DD3A", hash_generated_method = "B3DF0706EA4D95D20106C37151C2EFB2")
        public String getEncodedAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_507347244 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_507347244 = null;
            varB4EAC82CA7396A68D541C85D26508E83_507347244.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_507347244;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.321 -0400", hash_original_method = "F489014FCD27D67260CBEC8AC84559A2", hash_generated_method = "0D781E29CDE7804FF14851B2FE46A6FF")
        public String getPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1182018615 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1182018615 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1182018615.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1182018615;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.321 -0400", hash_original_method = "F167E35F53D1A5A8B17A8A72FE8359AE", hash_generated_method = "9771466666FEF4F1014A40F47120D700")
        public String getEncodedPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_901580678 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_901580678 = null;
            varB4EAC82CA7396A68D541C85D26508E83_901580678.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_901580678;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.322 -0400", hash_original_method = "2E34959E1DD3631C67E93F1AE6B31056", hash_generated_method = "1A9BFDEE8134B79D91293F947A49327F")
        public String getQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_400889605 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_400889605 = null;
            varB4EAC82CA7396A68D541C85D26508E83_400889605.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_400889605;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.323 -0400", hash_original_method = "53661DD2D38C9C2E00E8B8D2FF316BB7", hash_generated_method = "CD912AC08C1302613697423BAFF49B02")
        public String getEncodedQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_2123473973 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2123473973 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2123473973.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2123473973;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.324 -0400", hash_original_method = "9F53DDCB73E71AFF4CF207B49D0689B3", hash_generated_method = "C57A2590976FF88E213148988D16366E")
        public String getFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_2044733548 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2044733548 = fragment.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_2044733548.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2044733548;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.325 -0400", hash_original_method = "2FF982E252638134744EE32C0D7F6950", hash_generated_method = "28BDAF9D759EC0B3E34E10D5FE60D91F")
        public String getEncodedFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_1355616340 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1355616340 = fragment.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1355616340.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1355616340;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.325 -0400", hash_original_method = "08B329AF4FAA2768183F76EC45288C10", hash_generated_method = "560ECEF48F60D23D2D23C609CA3A1ACD")
        public List<String> getPathSegments() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_819858081 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_819858081 = Collections.emptyList();
            varB4EAC82CA7396A68D541C85D26508E83_819858081.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_819858081;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.326 -0400", hash_original_method = "AE7FF2A9DFCB643CF70873B2C08CD5A8", hash_generated_method = "DD3A377C6FB2C4805861913DFB869DAB")
        public String getLastPathSegment() {
            String varB4EAC82CA7396A68D541C85D26508E83_601257265 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_601257265 = null;
            varB4EAC82CA7396A68D541C85D26508E83_601257265.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_601257265;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.326 -0400", hash_original_method = "520FB960E4127ABC7143DD06EFB52356", hash_generated_method = "570AB5464EBFAC228EA9067AC2259780")
        public String getUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_1981555392 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1981555392 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1981555392.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1981555392;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.327 -0400", hash_original_method = "88ECB0B5D6F4AA907FC3666F8C1418EB", hash_generated_method = "C6EB846DE1E3DC9E784AC6411CDD2586")
        public String getEncodedUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_1329444801 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1329444801 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1329444801.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1329444801;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.327 -0400", hash_original_method = "00C71B0865F91AE7EF71B7BE21B14B9F", hash_generated_method = "60C397CEB4C5B053FD4B6FC4E9ED6147")
        public String getHost() {
            String varB4EAC82CA7396A68D541C85D26508E83_1758992384 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1758992384 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1758992384.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1758992384;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.327 -0400", hash_original_method = "B159430668427C6760C3FB4B772D9F59", hash_generated_method = "3AFA98A3CACC8B738EDF73EC51070497")
        public int getPort() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756468683 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756468683;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.328 -0400", hash_original_method = "ACF28BE5516AF44175C2E6962FB03404", hash_generated_method = "CE9F6FF6BE6D8384DEE016BB3F121120")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1023816883 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_737047222 = null; 
            @SuppressWarnings("StringEquality") boolean cached = cachedString != NOT_CACHED;
            {
                varB4EAC82CA7396A68D541C85D26508E83_1023816883 = cachedString;
            } 
            StringBuilder sb = new StringBuilder();
            sb.append(scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());
            {
                boolean varC8C86438344E58844BC399B4194DB415_663565099 = (!fragment.isEmpty());
                {
                    sb.append('#').append(fragment.getEncoded());
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_737047222 = cachedString = sb.toString();
            String varA7E53CE21691AB073D9660D615818899_14163088; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_14163088 = varB4EAC82CA7396A68D541C85D26508E83_1023816883;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_14163088 = varB4EAC82CA7396A68D541C85D26508E83_737047222;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_14163088.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_14163088;
            
            
            
            
                
            
            
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.329 -0400", hash_original_method = "9B1777E9DAB1C1ED3319A4EEC33BCB54", hash_generated_method = "69C78D46F3ECAE09E4111BD08DDF046D")
        public Builder buildUpon() {
            Builder varB4EAC82CA7396A68D541C85D26508E83_521294438 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_521294438 = new Builder()
                    .scheme(this.scheme)
                    .opaquePart(this.ssp)
                    .fragment(this.fragment);
            varB4EAC82CA7396A68D541C85D26508E83_521294438.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_521294438;
            
            
                    
                    
                    
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.329 -0400", hash_original_field = "404FF43CFEE8747368BFDA1DC5DB3B28", hash_generated_field = "81BC425463DB04A2D338A2C363556710")

        static final int TYPE_ID = 2;
    }


    
    static class PathSegments extends AbstractList<String> implements RandomAccess {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.329 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.329 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

        int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.330 -0400", hash_original_method = "816AFE27D6484B7E80593A248F7DEC12", hash_generated_method = "F2AFBC317E49E2BF0F98B0C5AE8378FC")
          PathSegments(String[] segments, int size) {
            this.segments = segments;
            this.size = size;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.331 -0400", hash_original_method = "043CF25E38E9D3A71BE4CC7B6371568E", hash_generated_method = "5B18FF03498004289169424CAFDD11CD")
        public String get(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_937839801 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_937839801 = segments[index];
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_937839801.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_937839801;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.332 -0400", hash_original_method = "BAF1AF8B1284BE94C387C840AF9FA265", hash_generated_method = "E85C76C8DC6C2F93FBC94E52B4A5D290")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570746876 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570746876;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.332 -0400", hash_original_field = "F2217D1D8C4EF2C438C5D90B83E3AD42", hash_generated_field = "E6083199966205833D7B5012129D384D")

        static final PathSegments EMPTY = new PathSegments(null, 0);
    }


    
    static class PathSegmentsBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.332 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.332 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

        int size = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.332 -0400", hash_original_method = "CD5B4727D6775EBFE00461F5F237812D", hash_generated_method = "CD5B4727D6775EBFE00461F5F237812D")
        public PathSegmentsBuilder ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.333 -0400", hash_original_method = "F05B9B5ECB44DE7CFF27782486F28CF3", hash_generated_method = "7B2AD76BACD90E19EA0D077B20E4D609")
         void add(String segment) {
            {
                segments = new String[4];
            } 
            {
                String[] expanded = new String[segments.length * 2];
                System.arraycopy(segments, 0, expanded, 0, segments.length);
                segments = expanded;
            } 
            segments[size++] = segment;
            
            
                
            
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.335 -0400", hash_original_method = "497F2229989230601A3120EEAF21B251", hash_generated_method = "F2296529FC7B9877E7598FDD3767FD6A")
         PathSegments build() {
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_1013656403 = null; 
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_1154939641 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1013656403 = PathSegments.EMPTY;
            } 
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1154939641 = new PathSegments(segments, size);
            } 
            finally 
            {
                segments = null;
            } 
            PathSegments varA7E53CE21691AB073D9660D615818899_970315574; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_970315574 = varB4EAC82CA7396A68D541C85D26508E83_1013656403;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_970315574 = varB4EAC82CA7396A68D541C85D26508E83_1154939641;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_970315574.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_970315574;
            
            
                
            
            
                
            
                
            
        }

        
    }


    
    private abstract static class AbstractHierarchicalUri extends Uri {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.335 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "87B54E118334D4593A462325E6A65F84")

        private Part userInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.335 -0400", hash_original_field = "38B3753700D5B450CB30995B4DB5AF95", hash_generated_field = "539F6E6D25356608852D958A8481FDA5")

        private volatile String host = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.335 -0400", hash_original_field = "38113C68733F87156C438BEBC2FCB827", hash_generated_field = "3DEE2B327E62FC31F0BA9783EFE62CA9")

        private volatile int port = NOT_CALCULATED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.335 -0400", hash_original_method = "469DE423ED30903E9EDD58224AA80D56", hash_generated_method = "469DE423ED30903E9EDD58224AA80D56")
        public AbstractHierarchicalUri ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.336 -0400", hash_original_method = "D5E71CFA6EED35AEB9B5F4AEC5287C3B", hash_generated_method = "42567A4C53A1487CCFFF5DE6A598C360")
        public String getLastPathSegment() {
            String varB4EAC82CA7396A68D541C85D26508E83_1737144833 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1899880689 = null; 
            List<String> segments = getPathSegments();
            int size = segments.size();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1737144833 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1899880689 = segments.get(size - 1);
            String varA7E53CE21691AB073D9660D615818899_447156902; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_447156902 = varB4EAC82CA7396A68D541C85D26508E83_1737144833;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_447156902 = varB4EAC82CA7396A68D541C85D26508E83_1899880689;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_447156902.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_447156902;
            
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.337 -0400", hash_original_method = "739BBE935CAE826F3703E2BBB77B819C", hash_generated_method = "8DE695D253CC53DD7E590BA4C7363717")
        private Part getUserInfoPart() {
            Part varB4EAC82CA7396A68D541C85D26508E83_948585616 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_948585616 = userInfo == null
                    ? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
            varB4EAC82CA7396A68D541C85D26508E83_948585616.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_948585616;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.338 -0400", hash_original_method = "EADAAD26DC8689BCA10DCA33883B9323", hash_generated_method = "82C220215F6DF56124D6F9A5F7DEF661")
        public final String getEncodedUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_237997664 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_237997664 = getUserInfoPart().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_237997664.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_237997664;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.338 -0400", hash_original_method = "10E379B7D06266EDAAC672E10EB0F58B", hash_generated_method = "23698D8E8158A5011A9A906B697264F6")
        private String parseUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_1217729417 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_243909274 = null; 
            String authority = getEncodedAuthority();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1217729417 = null;
            } 
            int end = authority.indexOf('@');
            varB4EAC82CA7396A68D541C85D26508E83_243909274 = end == NOT_FOUND ? null : authority.substring(0, end);
            String varA7E53CE21691AB073D9660D615818899_230789646; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_230789646 = varB4EAC82CA7396A68D541C85D26508E83_1217729417;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_230789646 = varB4EAC82CA7396A68D541C85D26508E83_243909274;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_230789646.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_230789646;
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.339 -0400", hash_original_method = "575ECF6860F7EEFE5055BF56F2601A0E", hash_generated_method = "86D54BD28091E097BB7CBE4AEE13CFCE")
        public String getUserInfo() {
            String varB4EAC82CA7396A68D541C85D26508E83_79689288 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_79689288 = getUserInfoPart().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_79689288.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_79689288;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.339 -0400", hash_original_method = "2FC22A6CCA0A3F4C0B9E4C09F79A556D", hash_generated_method = "1FF695445D0C93D9D5E4677349F95C88")
        public String getHost() {
            String varB4EAC82CA7396A68D541C85D26508E83_784455141 = null; 
            @SuppressWarnings("StringEquality") boolean cached = (host != NOT_CACHED);
            varB4EAC82CA7396A68D541C85D26508E83_784455141 = cached ? host
                    : (host = parseHost());
            varB4EAC82CA7396A68D541C85D26508E83_784455141.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_784455141;
            
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.340 -0400", hash_original_method = "F3410DE0DFF96D0677FF54552E852FC4", hash_generated_method = "CE9A59BEF2373CAEC30F5F87F4D5FF78")
        private String parseHost() {
            String varB4EAC82CA7396A68D541C85D26508E83_409797993 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_749618310 = null; 
            String authority = getEncodedAuthority();
            {
                varB4EAC82CA7396A68D541C85D26508E83_409797993 = null;
            } 
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);
            String encodedHost;
            encodedHost = authority.substring(userInfoSeparator + 1);
            encodedHost = authority.substring(userInfoSeparator + 1, portSeparator);
            varB4EAC82CA7396A68D541C85D26508E83_749618310 = decode(encodedHost);
            String varA7E53CE21691AB073D9660D615818899_113677729; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_113677729 = varB4EAC82CA7396A68D541C85D26508E83_409797993;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_113677729 = varB4EAC82CA7396A68D541C85D26508E83_749618310;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_113677729.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_113677729;
            
            
            
                
            
            
            
            
                    
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.341 -0400", hash_original_method = "A497EF38F72042FD9397DCB617BC4BBC", hash_generated_method = "9DE4D5138FADF4137313A8A52504DEEB")
        public int getPort() {
            {
                Object varD4A5E1084DDC786A109466698FB6E902_295037594 = (port = parsePort());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900526154 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900526154;
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.342 -0400", hash_original_method = "5469820A1C15A09B87242C85BC223022", hash_generated_method = "14BEAD066E4B70521AA3ED96D72D7C5F")
        private int parsePort() {
            String authority = getEncodedAuthority();
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);
            String portString = decode(authority.substring(portSeparator + 1));
            try 
            {
                int var9090A94059B9013CFD764DB303CCFFD1_391256625 = (Integer.parseInt(portString));
            } 
            catch (NumberFormatException e)
            { }
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391978416 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391978416;
            
            
            
                
            
            
            
            
                
            
            
            
                
            
                
                
            
        }

        
    }


    
    private static class HierarchicalUri extends AbstractHierarchicalUri {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.342 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.342 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.342 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.342 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.342 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.342 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.342 -0400", hash_original_field = "2BBB7D14660BA196C018E7EF1E07014A", hash_generated_field = "9968E15A97464199002C3D2A70E60BF1")

        private volatile String uriString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.343 -0400", hash_original_method = "4B8A4922E90F4F5C5F11CB942A244C7D", hash_generated_method = "68A9127EDB06137E28202F2E575DFD47")
        private  HierarchicalUri(String scheme, Part authority, PathPart path,
                Part query, Part fragment) {
            this.scheme = scheme;
            this.authority = Part.nonNull(authority);
            this.path = path == null ? PathPart.NULL : path;
            this.query = Part.nonNull(query);
            this.fragment = Part.nonNull(fragment);
            
            
            
            
            
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.345 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4EA67F1702E7F9B4B60B9B57E86CDBDA")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52479829 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52479829;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.346 -0400", hash_original_method = "601AB6BE7C1B16F2DB83E078DF9B61DC", hash_generated_method = "416E2535268A9AE550DD9A5E30CAFE39")
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(TYPE_ID);
            parcel.writeString(scheme);
            authority.writeTo(parcel);
            path.writeTo(parcel);
            query.writeTo(parcel);
            fragment.writeTo(parcel);
            addTaint(parcel.getTaint());
            addTaint(flags);
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.346 -0400", hash_original_method = "3471DB7575AAB7FBFD2140BF4AB89F77", hash_generated_method = "A846500F4D38B86297306319820F40E9")
        public boolean isHierarchical() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739031149 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_739031149;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.346 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "E73423EF37D0C11D63903B184F6477FA")
        public boolean isRelative() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120415870 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120415870;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.347 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FA11CF3CDAEF773BD975B552937E31D4")
        public String getScheme() {
            String varB4EAC82CA7396A68D541C85D26508E83_724913593 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_724913593 = scheme;
            varB4EAC82CA7396A68D541C85D26508E83_724913593.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_724913593;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.347 -0400", hash_original_method = "6F57A7CA1E43F50667C0921A8F0F4C1E", hash_generated_method = "88CA92286085109FD46ECD21C38833EF")
        private Part getSsp() {
            Part varB4EAC82CA7396A68D541C85D26508E83_950286359 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_950286359 = ssp == null
                    ? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
            varB4EAC82CA7396A68D541C85D26508E83_950286359.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_950286359;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.348 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "C8C1B0D15466A358B07C8A5F709904EB")
        public String getEncodedSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_1131293284 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1131293284 = getSsp().getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1131293284.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1131293284;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.349 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "80E839A3F64FA2C32A897A2D337E5B50")
        public String getSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_944495027 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_944495027 = getSsp().getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_944495027.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_944495027;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.349 -0400", hash_original_method = "EA75444742B675900BB1383BC22E224C", hash_generated_method = "E2D925DC798385E4BED6A418432EEFCF")
        private String makeSchemeSpecificPart() {
            String varB4EAC82CA7396A68D541C85D26508E83_396687493 = null; 
            StringBuilder builder = new StringBuilder();
            appendSspTo(builder);
            varB4EAC82CA7396A68D541C85D26508E83_396687493 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_396687493.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_396687493;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.350 -0400", hash_original_method = "55EA79AD41E607B8DD0B042A78040234", hash_generated_method = "11298ECA9461F31B3851D9BA7BF94FF4")
        private void appendSspTo(StringBuilder builder) {
            String encodedAuthority = authority.getEncoded();
            {
                builder.append("//").append(encodedAuthority);
            } 
            String encodedPath = path.getEncoded();
            {
                builder.append(encodedPath);
            } 
            {
                boolean var2C0BEF9EBF85F28B1D174D326A545DCD_643144094 = (!query.isEmpty());
                {
                    builder.append('?').append(query.getEncoded());
                } 
            } 
            addTaint(builder.getTaint());
            
            
            
                
            
            
            
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.350 -0400", hash_original_method = "4FC7F3346B5C0FC1519928E52B2843FB", hash_generated_method = "C385ACA66E7BA312DCCF66319EC86D83")
        public String getAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_1326294792 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1326294792 = this.authority.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1326294792.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1326294792;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.351 -0400", hash_original_method = "02F0907154122B499105718EFAFFB12D", hash_generated_method = "945C85CC3CED6C81E5FB6B7906C72F91")
        public String getEncodedAuthority() {
            String varB4EAC82CA7396A68D541C85D26508E83_1483137477 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1483137477 = this.authority.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1483137477.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1483137477;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.352 -0400", hash_original_method = "C2F72FED192DF0C1254C49B5EAFF6B37", hash_generated_method = "81A7B8365F56C8F7648E77D787E3F65D")
        public String getEncodedPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_1953781413 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1953781413 = this.path.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_1953781413.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1953781413;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.353 -0400", hash_original_method = "6081DF09BF7A0319CE8B8794EF03DD3D", hash_generated_method = "9FBF875F186D08D080AA60A7420E091F")
        public String getPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_670467363 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_670467363 = this.path.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_670467363.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_670467363;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.353 -0400", hash_original_method = "BB14E9B85B4B70FE8537ADEAEA0F30F8", hash_generated_method = "9A8A830BBC7C145FD895E0E8827DA47A")
        public String getQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_711790466 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_711790466 = this.query.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_711790466.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_711790466;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.355 -0400", hash_original_method = "4E4841C1D3AAC7E9E3EC5666E1D3BDC7", hash_generated_method = "2290037FDFC7741008770EA13D3A5F48")
        public String getEncodedQuery() {
            String varB4EAC82CA7396A68D541C85D26508E83_2137364528 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2137364528 = this.query.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_2137364528.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2137364528;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.356 -0400", hash_original_method = "BC71EA5136922A2C431D19FA4D7E797E", hash_generated_method = "7167673B1821FFED338D3EAC40A17DC9")
        public String getFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_1713789547 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1713789547 = this.fragment.getDecoded();
            varB4EAC82CA7396A68D541C85D26508E83_1713789547.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1713789547;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.356 -0400", hash_original_method = "D0BDA4E24821D7C40932E823B160DCAD", hash_generated_method = "AF777B38062C502C693C2ABFA8A8DF3E")
        public String getEncodedFragment() {
            String varB4EAC82CA7396A68D541C85D26508E83_743466001 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_743466001 = this.fragment.getEncoded();
            varB4EAC82CA7396A68D541C85D26508E83_743466001.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_743466001;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.357 -0400", hash_original_method = "6A1F2A59685BCA2552F3B76D88CB5845", hash_generated_method = "F52720D7D13D568364E7E1C7C518450D")
        public List<String> getPathSegments() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_990117668 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_990117668 = this.path.getPathSegments();
            varB4EAC82CA7396A68D541C85D26508E83_990117668.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_990117668;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.358 -0400", hash_original_method = "2FFEEC7D33EBEEF04178DF9D921CBC02", hash_generated_method = "BE43AFC2FB78085118B05759FE306A57")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_724695403 = null; 
            @SuppressWarnings("StringEquality") boolean cached = (uriString != NOT_CACHED);
            varB4EAC82CA7396A68D541C85D26508E83_724695403 = cached ? uriString
                    : (uriString = makeUriString());
            varB4EAC82CA7396A68D541C85D26508E83_724695403.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_724695403;
            
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.358 -0400", hash_original_method = "5AECD242275C33F74DCA414A6C8DF5D7", hash_generated_method = "89F4FE339DFEA0752D1940BF8BBE1336")
        private String makeUriString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1134287131 = null; 
            StringBuilder builder = new StringBuilder();
            {
                builder.append(scheme).append(':');
            } 
            appendSspTo(builder);
            {
                boolean varC8C86438344E58844BC399B4194DB415_70579268 = (!fragment.isEmpty());
                {
                    builder.append('#').append(fragment.getEncoded());
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1134287131 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1134287131.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1134287131;
            
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.359 -0400", hash_original_method = "6635CD2DD122D7EE5F14A5F21B272B08", hash_generated_method = "CEDFDB018EB57DA618121368BED3AEDD")
        public Builder buildUpon() {
            Builder varB4EAC82CA7396A68D541C85D26508E83_605199033 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_605199033 = new Builder()
                    .scheme(scheme)
                    .authority(authority)
                    .path(path)
                    .query(query)
                    .fragment(fragment);
            varB4EAC82CA7396A68D541C85D26508E83_605199033.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_605199033;
            
            
                    
                    
                    
                    
                    
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.359 -0400", hash_original_field = "1A6BAB54CA68848B2D28EFB422CF1725", hash_generated_field = "F1F90627D661D3D25ABE19AF04422DA0")

        static final int TYPE_ID = 3;
    }


    
    public static final class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.359 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.359 -0400", hash_original_field = "E17823015F179701BCEC9CD4356C4A38", hash_generated_field = "F30F644E178A706F0279AC78D6913562")

        private Part opaquePart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.359 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.359 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.359 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.359 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.360 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "7F0D829FE2A4B9F217489244A9FD2E61")
        public  Builder() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.360 -0400", hash_original_method = "1FAF048543AEDF54BF8218C15362FDC3", hash_generated_method = "5EDE3C29A61F6C289E293FEAE83DC69D")
        public Builder scheme(String scheme) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1709897966 = null; 
            this.scheme = scheme;
            varB4EAC82CA7396A68D541C85D26508E83_1709897966 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1709897966.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1709897966;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.361 -0400", hash_original_method = "8D4C2B402A916DF01BF39AF004B22B4B", hash_generated_method = "0D0AD7DF32DDEA04E0DEDC0DDD9F4E35")
         Builder opaquePart(Part opaquePart) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1147574028 = null; 
            this.opaquePart = opaquePart;
            varB4EAC82CA7396A68D541C85D26508E83_1147574028 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1147574028.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1147574028;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.362 -0400", hash_original_method = "B04C2A20C29308DA58A03AAA34E4602D", hash_generated_method = "D8F902E7FB497584D9D2D77F7C025F35")
        public Builder opaquePart(String opaquePart) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1215931534 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1215931534 = opaquePart(Part.fromDecoded(opaquePart));
            addTaint(opaquePart.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1215931534.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1215931534;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.363 -0400", hash_original_method = "E3AC90668DB82124786DAC21400DF68F", hash_generated_method = "4FC72168B41BC5C206B58E2BB6C2B30C")
        public Builder encodedOpaquePart(String opaquePart) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_149818233 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_149818233 = opaquePart(Part.fromEncoded(opaquePart));
            addTaint(opaquePart.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_149818233.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_149818233;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.364 -0400", hash_original_method = "CE12FA6D2315F74B1A3B79C027FFFA6D", hash_generated_method = "351AA0D67A2F67A04CBBE5188AB470D3")
         Builder authority(Part authority) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_925943511 = null; 
            this.opaquePart = null;
            this.authority = authority;
            varB4EAC82CA7396A68D541C85D26508E83_925943511 = this;
            varB4EAC82CA7396A68D541C85D26508E83_925943511.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_925943511;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.365 -0400", hash_original_method = "8B987B114EF487282F33A481DCB273CB", hash_generated_method = "83FCC4035E15288CD6EA5808DA9A74C3")
        public Builder authority(String authority) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_703080450 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_703080450 = authority(Part.fromDecoded(authority));
            addTaint(authority.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_703080450.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_703080450;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.366 -0400", hash_original_method = "2AF9D1463857894BBB2A3B7E377A77BB", hash_generated_method = "5D502F7295DB07209CC99E061FB9F370")
        public Builder encodedAuthority(String authority) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1843953129 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1843953129 = authority(Part.fromEncoded(authority));
            addTaint(authority.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1843953129.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1843953129;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.366 -0400", hash_original_method = "0552AFD7FA04CD9C4E588C7FB644B387", hash_generated_method = "A9882FADB74F316CCEC77F96C98D6D9B")
         Builder path(PathPart path) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_701507955 = null; 
            this.opaquePart = null;
            this.path = path;
            varB4EAC82CA7396A68D541C85D26508E83_701507955 = this;
            varB4EAC82CA7396A68D541C85D26508E83_701507955.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_701507955;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.367 -0400", hash_original_method = "311D5047B3596F1C34DEC3DA1D1264C5", hash_generated_method = "EE6EEFE22057E815BF1A8D0C537BBACB")
        public Builder path(String path) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1405592071 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1405592071 = path(PathPart.fromDecoded(path));
            addTaint(path.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1405592071.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1405592071;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.368 -0400", hash_original_method = "B2733F0C4852B782EB87F01613E6C574", hash_generated_method = "0A88A20EF9C7680F81B734ADA696DE62")
        public Builder encodedPath(String path) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1013111641 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1013111641 = path(PathPart.fromEncoded(path));
            addTaint(path.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1013111641.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1013111641;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.368 -0400", hash_original_method = "818DCEC2192004BCFE40E4E49FDA7A4C", hash_generated_method = "2658D05468FE9BCB40C0FACF733A7630")
        public Builder appendPath(String newSegment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1151634554 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1151634554 = path(PathPart.appendDecodedSegment(path, newSegment));
            addTaint(newSegment.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1151634554.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1151634554;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.369 -0400", hash_original_method = "04B6E07373B5BCB6E5F5541B11BC55A7", hash_generated_method = "23F2E0989EBBBDA1F2147868E091CA21")
        public Builder appendEncodedPath(String newSegment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1767853157 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1767853157 = path(PathPart.appendEncodedSegment(path, newSegment));
            addTaint(newSegment.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1767853157.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1767853157;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.369 -0400", hash_original_method = "526B00AFFC674BC410AFF0DB5058AD68", hash_generated_method = "B45D610A06E4DBE5358A5C0FC4EFF230")
         Builder query(Part query) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_87781242 = null; 
            this.opaquePart = null;
            this.query = query;
            varB4EAC82CA7396A68D541C85D26508E83_87781242 = this;
            varB4EAC82CA7396A68D541C85D26508E83_87781242.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_87781242;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.370 -0400", hash_original_method = "915051404F16544BAB27A534573CC34D", hash_generated_method = "604160CE92E664783982F8D114C74B6C")
        public Builder query(String query) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_855442171 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_855442171 = query(Part.fromDecoded(query));
            addTaint(query.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_855442171.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_855442171;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.370 -0400", hash_original_method = "2B1CFFF6E8520529FC529F01B5DBCD04", hash_generated_method = "5642CBD15B11C55244E021DB3723E599")
        public Builder encodedQuery(String query) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_966591051 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_966591051 = query(Part.fromEncoded(query));
            addTaint(query.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_966591051.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_966591051;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.371 -0400", hash_original_method = "AAD8E80453C4B46D11B41869FDCBA00D", hash_generated_method = "B6171A4A9C2E467462A2E0BDC4565CE0")
         Builder fragment(Part fragment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1257340078 = null; 
            this.fragment = fragment;
            varB4EAC82CA7396A68D541C85D26508E83_1257340078 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1257340078.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1257340078;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.371 -0400", hash_original_method = "016C309F39EF5D90CF32B95F6FDB27F8", hash_generated_method = "587BD5324EECE25C1C45CFB521F885DD")
        public Builder fragment(String fragment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2005725992 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2005725992 = fragment(Part.fromDecoded(fragment));
            addTaint(fragment.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2005725992.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2005725992;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.372 -0400", hash_original_method = "C5F51A11F0BEF63CCF4FD5F6AF742648", hash_generated_method = "D8E7B749054B153347887F2D48FF8A94")
        public Builder encodedFragment(String fragment) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1001982271 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1001982271 = fragment(Part.fromEncoded(fragment));
            addTaint(fragment.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1001982271.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1001982271;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.373 -0400", hash_original_method = "F83D70A0FC90543F01AB6385367098CC", hash_generated_method = "1D7E5AB3EE1F07443D8DFF780E0ED2B7")
        public Builder appendQueryParameter(String key, String value) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_487627179 = null; 
            Builder varB4EAC82CA7396A68D541C85D26508E83_1741485622 = null; 
            this.opaquePart = null;
            String encodedParameter = encode(key, null) + "="
                    + encode(value, null);
            {
                query = Part.fromEncoded(encodedParameter);
                varB4EAC82CA7396A68D541C85D26508E83_487627179 = this;
            } 
            String oldQuery = query.getEncoded();
            {
                boolean varD871C9980587FFA401304C0008BE3177_539933486 = (oldQuery == null || oldQuery.length() == 0);
                {
                    query = Part.fromEncoded(encodedParameter);
                } 
                {
                    query = Part.fromEncoded(oldQuery + "&" + encodedParameter);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1741485622 = this;
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            Builder varA7E53CE21691AB073D9660D615818899_1299361000; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1299361000 = varB4EAC82CA7396A68D541C85D26508E83_487627179;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1299361000 = varB4EAC82CA7396A68D541C85D26508E83_1741485622;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1299361000.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1299361000;
            
            
            
                    
            
                
                
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.374 -0400", hash_original_method = "581A1CF068B5634C1F252DE7C2737E06", hash_generated_method = "8BE1D86CB011A7A83A51EE40B0B06928")
        public Builder clearQuery() {
            Builder varB4EAC82CA7396A68D541C85D26508E83_813491454 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_813491454 = query((Part) null);
            varB4EAC82CA7396A68D541C85D26508E83_813491454.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_813491454;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.376 -0400", hash_original_method = "C36CE5067F02DA1F1C7276BF67665A1B", hash_generated_method = "896B95F0D68B69BD2493D7972412C2C8")
        public Uri build() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_2132869431 = null; 
            Uri varB4EAC82CA7396A68D541C85D26508E83_1458893432 = null; 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                            "An opaque URI must have a scheme.");
                } 
                varB4EAC82CA7396A68D541C85D26508E83_2132869431 = new OpaqueUri(scheme, opaquePart, fragment);
            } 
            {
                PathPart path = this.path;
                {
                    path = PathPart.EMPTY;
                } 
                {
                    {
                        boolean var2CA83CB1D078EAA23C6D98CE29904B75_1961666405 = (hasSchemeOrAuthority());
                        {
                            path = PathPart.makeAbsolute(path);
                        } 
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1458893432 = new HierarchicalUri(
                        scheme, authority, path, query, fragment);
            } 
            Uri varA7E53CE21691AB073D9660D615818899_736553691; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_736553691 = varB4EAC82CA7396A68D541C85D26508E83_2132869431;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_736553691 = varB4EAC82CA7396A68D541C85D26508E83_1458893432;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_736553691.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_736553691;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.376 -0400", hash_original_method = "7917AD3B49169A1AC8EEA7DD014B7E45", hash_generated_method = "C3D927ACB0A3C2AF8E4AC19D4CF8EE5C")
        private boolean hasSchemeOrAuthority() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_397446047 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_397446047;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.377 -0400", hash_original_method = "50FC77E3DFFDDD2DB7D0B749912434F7", hash_generated_method = "AC6883BCC7C7558A54B446C707964E3E")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_200844913 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_200844913 = build().toString();
            varB4EAC82CA7396A68D541C85D26508E83_200844913.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_200844913;
            
            
        }

        
    }


    
    static abstract class AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.377 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "08274B7EEBA921030ECC3D76D1E6ECCB")

        volatile String encoded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.377 -0400", hash_original_field = "AD05458423E19C1FF1F3C0237F8CFBED", hash_generated_field = "B682B941676F7CF6A565D2078C9BC0A9")

        volatile String decoded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.378 -0400", hash_original_method = "21E01F693530948BFE81E2C9AE8C6D31", hash_generated_method = "00DF56A1D35C3F914A2155477BDE237F")
          AbstractPart(String encoded, String decoded) {
            this.encoded = encoded;
            this.decoded = decoded;
            
            
            
        }

        
        abstract String getEncoded();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.378 -0400", hash_original_method = "06323BBC323E7F59CEDDE1FAA04ED1F6", hash_generated_method = "1BEA5DE69D2AAB3F0C03FD4C31AB5882")
        final String getDecoded() {
            String varB4EAC82CA7396A68D541C85D26508E83_777960618 = null; 
            @SuppressWarnings("StringEquality") boolean hasDecoded = decoded != NOT_CACHED;
            varB4EAC82CA7396A68D541C85D26508E83_777960618 = hasDecoded ? decoded : (decoded = decode(encoded));
            varB4EAC82CA7396A68D541C85D26508E83_777960618.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_777960618;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.379 -0400", hash_original_method = "BB7E54AFB81798C035BF3B3717F470E7", hash_generated_method = "5F81D851E5AC802886082DF2F3F99F2A")
        final void writeTo(Parcel parcel) {
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
            @SuppressWarnings("StringEquality") boolean hasDecoded = decoded != NOT_CACHED;
            {
                parcel.writeInt(Representation.BOTH);
                parcel.writeString(encoded);
                parcel.writeString(decoded);
            } 
            {
                parcel.writeInt(Representation.ENCODED);
                parcel.writeString(encoded);
            } 
            {
                parcel.writeInt(Representation.DECODED);
                parcel.writeString(decoded);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Neither encoded nor decoded");
            } 
            addTaint(parcel.getTaint());
            
            
            
            
            
            
                
                
                
            
                
                
            
                
                
            
                
            
        }

        
        static class Representation {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.379 -0400", hash_original_method = "49186660D0AEF0721F749C758CF0FE34", hash_generated_method = "49186660D0AEF0721F749C758CF0FE34")
            public Representation ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.379 -0400", hash_original_field = "659BA2B3286FF6C4923CFE851F3CD42E", hash_generated_field = "FF4F4E4C6DA0CB1E3DB9C13C6C3A4A5B")

            static final int BOTH = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.379 -0400", hash_original_field = "D22FD9F8AEEC62F2AEF921B20283C7C9", hash_generated_field = "A15D22B3282778C07B2BEC94A0EE0FD2")

            static final int ENCODED = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.379 -0400", hash_original_field = "7CA715B76440B29FFB05D39B0C592B7F", hash_generated_field = "8C3D0A85A317D2355A45465A71C73F69")

            static final int DECODED = 2;
        }


        
    }


    
    static class Part extends AbstractPart {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.379 -0400", hash_original_method = "68B275EBA6010E5404727E121615E229", hash_generated_method = "A2A4141E5360E67DD2B728987EC31D1B")
        private  Part(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(encoded.getTaint());
            addTaint(decoded.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.380 -0400", hash_original_method = "BD94DCCF5B44419F4498543CA74892E2", hash_generated_method = "699AD448A963503DA10F419A9E5CAD02")
         boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949568178 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_949568178;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.380 -0400", hash_original_method = "74B8C999E422A266FD890BA259F6B43C", hash_generated_method = "FCE8E984DA394661D14B97317EF4599B")
         String getEncoded() {
            String varB4EAC82CA7396A68D541C85D26508E83_2043679740 = null; 
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
            varB4EAC82CA7396A68D541C85D26508E83_2043679740 = hasEncoded ? encoded : (encoded = encode(decoded));
            varB4EAC82CA7396A68D541C85D26508E83_2043679740.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2043679740;
            
            
            
            
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.382 -0400", hash_original_method = "D79C0256E86C850253FAE782AD9920ED", hash_generated_method = "D6E891CD56E98A9A6565F34666DC1B4A")
            public  EmptyPart(String value) {
                super(value, value);
                addTaint(value.getTaint());
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.382 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "3CEE4ED3EC3712934801972F062DE9A1")
            @Override
             boolean isEmpty() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813818611 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_813818611;
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.382 -0400", hash_original_field = "22902092D13F95EF047EC38F67C7A689", hash_generated_field = "B57558D017E2A8337F27C36F5D930EAB")

        static final Part NULL = new EmptyPart(null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.382 -0400", hash_original_field = "7F2DFD92B4F00B07EC2711F9AFB4D4CD", hash_generated_field = "D56E54A9BB15BF578A32B43A761A7D58")

        static final Part EMPTY = new EmptyPart("");
    }


    
    static class PathPart extends AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.382 -0400", hash_original_field = "5C8A59F77C438336819DD4F6B0C372B5", hash_generated_field = "BB8884736C4C2C995D440C597E10BBE6")

        private PathSegments pathSegments;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.383 -0400", hash_original_method = "E8CA21F7072E8C7642F3BFF9454329AE", hash_generated_method = "425902F356A88F24F0B82B0C0A427610")
        private  PathPart(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(encoded.getTaint());
            addTaint(decoded.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.384 -0400", hash_original_method = "EEE1C5D1C73794B2424FF9B6A794D8BE", hash_generated_method = "ABE8CD03B54774414E17C8C6708A26EB")
         String getEncoded() {
            String varB4EAC82CA7396A68D541C85D26508E83_36132687 = null; 
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
            varB4EAC82CA7396A68D541C85D26508E83_36132687 = hasEncoded ? encoded : (encoded = encode(decoded, "/"));
            varB4EAC82CA7396A68D541C85D26508E83_36132687.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_36132687;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.386 -0400", hash_original_method = "BB12DAE5001652F9E9419E41FB496BCF", hash_generated_method = "669CF7506047BA32186AEA967067E9A9")
         PathSegments getPathSegments() {
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_577196931 = null; 
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_1743230296 = null; 
            PathSegments varB4EAC82CA7396A68D541C85D26508E83_989407366 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_577196931 = pathSegments;
            } 
            String path = getEncoded();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1743230296 = pathSegments = PathSegments.EMPTY;
            } 
            PathSegmentsBuilder segmentBuilder = new PathSegmentsBuilder();
            int previous = 0;
            int current;
            {
                boolean varF3473A5176F979210C8BDFC961564284_94742747 = ((current = path.indexOf('/', previous)) > -1);
                {
                    {
                        String decodedSegment = decode(path.substring(previous, current));
                        segmentBuilder.add(decodedSegment);
                    } 
                    previous = current + 1;
                } 
            } 
            {
                boolean var80E2BDF18328ED6FA29B39AB13CE0D97_741898982 = (previous < path.length());
                {
                    segmentBuilder.add(decode(path.substring(previous)));
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_989407366 = pathSegments = segmentBuilder.build();
            PathSegments varA7E53CE21691AB073D9660D615818899_2136606242; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_2136606242 = varB4EAC82CA7396A68D541C85D26508E83_577196931;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_2136606242 = varB4EAC82CA7396A68D541C85D26508E83_1743230296;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2136606242 = varB4EAC82CA7396A68D541C85D26508E83_989407366;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2136606242.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_2136606242;
            
            
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "12FCD4CDDE0159C0A83B0F6923FAC7D8", hash_generated_field = "CE631D3EC26A75E141BE1EBBE7AA5D88")

        static final PathPart NULL = new PathPart(null, null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "2511CF6735334EEEFE4C66E3501EA765", hash_generated_field = "092DD7A22CF30B1C24AB41550FA2A397")

        static final PathPart EMPTY = new PathPart("", "");
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "15E64A01463468950481CAE21CF06FCB", hash_generated_field = "0451CD7498AE36BDD61110634E7FCA90")

    private static final String LOG = Uri.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "A90280C308D46EDE51003B54A6774638", hash_generated_field = "B954F9C12AC0662BCBDFC1BE53358724")

    @SuppressWarnings("RedundantStringConstructorCall") private static final String NOT_CACHED = new String("NOT CACHED");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "A81A920AEF8690239BB9D44F7E78D4F4", hash_generated_field = "5038C252470848AFDD24667CC5D97705")

    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL,
            PathPart.EMPTY, Part.NULL, Part.NULL);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "096628D07602808452D76140024603D6", hash_generated_field = "70D3B26ADAF374FF9FC1A886C7965F17")

    private final static int NOT_FOUND = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "4FDDDF7A3C684DEFD4771F4F71A53864", hash_generated_field = "309A8D293FB70CF3C8B75760A49AAA8A")

    private final static int NOT_CALCULATED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "6DE16BB1834113B41F3DB9E09DDB15A3", hash_generated_field = "D90B08A155B6660D5725B7F9B3B765E3")

    private static final String NOT_HIERARCHICAL = "This isn't a hierarchical URI.";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "2D7FBEFE0E1B69A4322A3C2F72D1B945", hash_generated_field = "801ABCF993C84AFFC2A4DEC33E3ED2DF")

    private static final String DEFAULT_ENCODING = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "FEE7EF6013925E53DB51A6700DEA6FED", hash_generated_field = "013D84CBB14787012A1B410C2CED92EA")

    private static final int NULL_TYPE_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "FA031E527800FCED59C59BB3277BEE96", hash_generated_field = "A8963E713BB231EFDC73C3C4317D711B")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "7590EBC339FE731817F9724DB1BDFD6C", hash_generated_field = "C46B2CD1575F3EFF815653AFF0EA6C73")

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.388 -0400", hash_original_field = "B895F573C0891DA82989F42094373576", hash_generated_field = "EA76FA4E6E39D084A2B31303C1E9D60D")

    private static final byte[] REPLACEMENT = { (byte) 0xFF, (byte) 0xFD };
    
    public Uri[] newArray(int size) {
            return new Uri[size];
        }
    
    
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


	@Override
	public int describeContents() {
		
		return 0;
	}


	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		
	}
    
}

