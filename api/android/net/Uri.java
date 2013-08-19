package android.net;

// Droidsafe Imports
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
    
    @DSModeled(DSC.BAN)
	private Uri() {}

    @DSModeled(DSC.SAFE)
	public boolean isHierarchical() {
		return getTaintBoolean();
	}

    
    @DSModeled(DSC.SAFE)
	public boolean isOpaque() {
        return getTaintBoolean();
    }

    
    @DSModeled(DSC.SAFE)
	public boolean isRelative() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}

    
    @DSModeled(DSC.SAFE)
	public boolean isAbsolute() {
        return getTaintBoolean();
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
		return getTaintInt();
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

    
    @DSModeled(DSC.SAFE)
	public String toString() {
                String str = new String();
                str.addTaint(this.getTaint());
		return str;
	}

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:30.993 -0400", hash_original_method = "C2346F0C89241A0BA21735401E86BD49", hash_generated_method = "3054DE5413D86379582B8B2580C3ABEF")
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
String varF4CF030572656354ACFDF83FEE21D7A6_1422840219 =                 builder.toString();
                varF4CF030572656354ACFDF83FEE21D7A6_1422840219.addTaint(taint);
                return varF4CF030572656354ACFDF83FEE21D7A6_1422840219;
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
String varF4CF030572656354ACFDF83FEE21D7A6_1293281338 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1293281338.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1293281338;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
	public Builder buildUpon() {
		return new Builder();
	}

    
    @DSModeled(DSC.SPEC)
        public static Uri parse(String uriString) {
            return new Uri(uriString);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:30.995 -0400", hash_original_method = "966FC11B97976C170B352F408FA2783F", hash_generated_method = "7CC4BF4539F1E5CE9003E1D03B910129")
    public Set<String> getQueryParameterNames() {
        if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_1444814055 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_1444814055.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_1444814055;
        } //End block
        String query = getEncodedQuery();
        if(query == null)        
        {
Set<String> var5CEAC4B7DE047656E0B916F1F83FCC49_659659397 =             Collections.emptySet();
            var5CEAC4B7DE047656E0B916F1F83FCC49_659659397.addTaint(taint);
            return var5CEAC4B7DE047656E0B916F1F83FCC49_659659397;
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
Set<String> varDD12C3B8A2F9B14F672A88549FBB956F_1855633732 =         Collections.unmodifiableSet(names);
        varDD12C3B8A2F9B14F672A88549FBB956F_1855633732.addTaint(taint);
        return varDD12C3B8A2F9B14F672A88549FBB956F_1855633732;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:30.996 -0400", hash_original_method = "9E05603A6F44EBCC73536B2584976016", hash_generated_method = "6D87AD0C7DB56ECB6CB7F471F5142FDE")
    public List<String> getQueryParameters(String key) {
        addTaint(key.getTaint());
        if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_245284941 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_245284941.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_245284941;
        } //End block
        if(key == null)        
        {
            NullPointerException var6D18FBA697BA09A47EF653F0DB540AE6_874191306 = new NullPointerException("key");
            var6D18FBA697BA09A47EF653F0DB540AE6_874191306.addTaint(taint);
            throw var6D18FBA697BA09A47EF653F0DB540AE6_874191306;
        } //End block
        String query = getEncodedQuery();
        if(query == null)        
        {
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_1772282180 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_1772282180.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_1772282180;
        } //End block
        String encodedKey;
        try 
        {
            encodedKey = URLEncoder.encode(key, DEFAULT_ENCODING);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_78929714 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_78929714.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_78929714;
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
List<String> var00BA81E9B2AB879A295DB9B86426A421_2042182195 =         Collections.unmodifiableList(values);
        var00BA81E9B2AB879A295DB9B86426A421_2042182195.addTaint(taint);
        return var00BA81E9B2AB879A295DB9B86426A421_2042182195;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:30.997 -0400", hash_original_method = "72F6B0777F298E12957F6498D8B3E8F1", hash_generated_method = "095BD8B35EB9E7BB6B5006218FC112AB")
    public String getQueryParameter(String key) {
        addTaint(key.getTaint());
        if(isOpaque())        
        {
            UnsupportedOperationException var2E178A4FD4690D3AFDBE7B0221793B08_1302775818 = new UnsupportedOperationException(NOT_HIERARCHICAL);
            var2E178A4FD4690D3AFDBE7B0221793B08_1302775818.addTaint(taint);
            throw var2E178A4FD4690D3AFDBE7B0221793B08_1302775818;
        } //End block
        if(key == null)        
        {
            NullPointerException var6D18FBA697BA09A47EF653F0DB540AE6_1325857501 = new NullPointerException("key");
            var6D18FBA697BA09A47EF653F0DB540AE6_1325857501.addTaint(taint);
            throw var6D18FBA697BA09A47EF653F0DB540AE6_1325857501;
        } //End block
        final String query = getEncodedQuery();
        if(query == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1367773986 =             null;
            var540C13E9E156B687226421B24F2DF178_1367773986.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1367773986;
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
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1772177874 =                         "";
                        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1772177874.addTaint(taint);
                        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1772177874;
                    } //End block
                    else
                    {
String varEB3B385708156ABD4F6A26F7ED4FD51E_803879007 =                         decode(query.substring(separator + 1, end));
                        varEB3B385708156ABD4F6A26F7ED4FD51E_803879007.addTaint(taint);
                        return varEB3B385708156ABD4F6A26F7ED4FD51E_803879007;
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
String var540C13E9E156B687226421B24F2DF178_1669367434 =         null;
        var540C13E9E156B687226421B24F2DF178_1669367434.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1669367434;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:30.998 -0400", hash_original_method = "67BE774C17CDAC836698DE4D6D994F1B", hash_generated_method = "F7872A63696B4ADA497FE173FBB8C675")
    public boolean getBooleanQueryParameter(String key, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        String flag = getQueryParameter(key);
        if(flag == null)        
        {
            boolean var16830A58E1E33A4163524366BA7B701B_206093064 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873314536 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_873314536;
        } //End block
        flag = flag.toLowerCase();
        boolean varEA95ECFC8D5C8F8BB96D459961F0F8E2_1889079694 = ((!"false".equals(flag) && !"0".equals(flag)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896914119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_896914119;
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

    
    @DSModeled(DSC.SAFE)
    public static String encode(String s) {
        return encode(s, null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    private static boolean isAllowed(char c, String allow) {
        return (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z')
                || (c >= '0' && c <= '9')
                || "_-!.~'()*".indexOf(c) != NOT_FOUND
                || (allow != null && allow.indexOf(c) != NOT_FOUND);
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.000 -0400", hash_original_field = "ACD4CFB867E9014EB5553B665A7654E7", hash_generated_field = "E4175460B78B44891D601990509D1265")

        private String uriString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.000 -0400", hash_original_field = "CAB1D5F863DB3FE1F854F1737D3BF567", hash_generated_field = "6ECAEC93E2396D17CA9FF61298DA11AE")

        private volatile int cachedSsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.001 -0400", hash_original_field = "0D27A2D8516BF4DCE688D48A00F04BF9", hash_generated_field = "6673040FAE4D4C35641720F36B224DA4")

        private volatile int cachedFsi = NOT_CALCULATED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.001 -0400", hash_original_field = "8FE13FA728B09DACBFC57E5751B51F48", hash_generated_field = "0E9D0B05543D9BBCEB78240FF4AE88F4")

        private volatile String scheme = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.001 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.001 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.001 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.001 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.002 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.002 -0400", hash_original_method = "6762E8F4F232397EC67D86B91A630B95", hash_generated_method = "C1985004B088F6815759ADC2D2D4F5A7")
        @DSModeled(DSC.BAN)
        private  StringUri(String uriString) {
            if(uriString == null)            
            {
                NullPointerException var68D2986827E7776409B7C54E12824C66_2066909523 = new NullPointerException("uriString");
                var68D2986827E7776409B7C54E12824C66_2066909523.addTaint(taint);
                throw var68D2986827E7776409B7C54E12824C66_2066909523;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.003 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "05B3264A06238DA671190C01591EFB7D")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1204067575 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927694181 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927694181;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.004 -0400", hash_original_method = "C73A8428F9DA44091DF96EEDC1E3D3EF", hash_generated_method = "324EBC5AEA4A8D0023485D42B57F178D")
        public void writeToParcel(Parcel parcel, int flags) {
            addTaint(flags);
            addTaint(parcel.getTaint());
            parcel.writeInt(TYPE_ID);
            parcel.writeString(uriString);
            // ---------- Original Method ----------
            //parcel.writeInt(TYPE_ID);
            //parcel.writeString(uriString);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.004 -0400", hash_original_method = "F197955D6E3BAB1920F769AA2F97BBD7", hash_generated_method = "77AF8B9302806EEFC12C2558387D1368")
        private int findSchemeSeparator() {
            int varF628705FEC99553366B579C402EB9B06_1103763769 = (cachedSsi == NOT_CALCULATED
                    ? cachedSsi = uriString.indexOf(':')
                    : cachedSsi);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695050535 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695050535;
            // ---------- Original Method ----------
            //return cachedSsi == NOT_CALCULATED
                    //? cachedSsi = uriString.indexOf(':')
                    //: cachedSsi;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.005 -0400", hash_original_method = "B0E1A879F11D02C30EC9FBB06F8801FE", hash_generated_method = "4369BD0A5F15DE4D59C9AEA9BC25C1CB")
        private int findFragmentSeparator() {
            int varB610A4875B79C5B29765DB968E0E51FE_1681702907 = (cachedFsi == NOT_CALCULATED
                    ? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    : cachedFsi);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939513263 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939513263;
            // ---------- Original Method ----------
            //return cachedFsi == NOT_CALCULATED
                    //? cachedFsi = uriString.indexOf('#', findSchemeSeparator())
                    //: cachedFsi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.006 -0400", hash_original_method = "11C2E375F5E033161AB2E06056D673CF", hash_generated_method = "98142875C1ECBDFED15C3D99C01DFCE8")
        public boolean isHierarchical() {
            int ssi = findSchemeSeparator();
            if(ssi == NOT_FOUND)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_455568810 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1199016793 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1199016793;
            } //End block
            if(uriString.length() == ssi + 1)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1840552769 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1480729415 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1480729415;
            } //End block
            boolean varC62061A402117AB0C4CED01069D594B5_587360301 = (uriString.charAt(ssi + 1) == '/');
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239911428 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239911428;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.007 -0400", hash_original_method = "DC1D040929AB7A4CF9A0DFBB95EA4283", hash_generated_method = "236D5315169DC2B5C6D3C96B7CC9969F")
        public boolean isRelative() {
            boolean var348FB469184CEBD475FA89D15A3871A3_1855334818 = (findSchemeSeparator() == NOT_FOUND);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417124185 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_417124185;
            // ---------- Original Method ----------
            //return findSchemeSeparator() == NOT_FOUND;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.008 -0400", hash_original_method = "96667B7E38635C26F17AC80DC91F9ADB", hash_generated_method = "27ACBDD87F5D51143EC4B75757645650")
        public String getScheme() {
            @SuppressWarnings("StringEquality") boolean cached = (scheme != NOT_CACHED);
String var5EC068FC8BAF19C405B863C227DA0116_133692976 =             cached ? scheme : (scheme = parseScheme());
            var5EC068FC8BAF19C405B863C227DA0116_133692976.addTaint(taint);
            return var5EC068FC8BAF19C405B863C227DA0116_133692976;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (scheme != NOT_CACHED);
            //return cached ? scheme : (scheme = parseScheme());
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.009 -0400", hash_original_method = "B03A2C85823E1DE38C77FC40695B0CC7", hash_generated_method = "CBD71E7613BB6612E57160B1B63455C2")
        private String parseScheme() {
            int ssi = findSchemeSeparator();
String var9A67634AC4372CD6514004924726C40E_29303340 =             ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
            var9A67634AC4372CD6514004924726C40E_29303340.addTaint(taint);
            return var9A67634AC4372CD6514004924726C40E_29303340;
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //return ssi == NOT_FOUND ? null : uriString.substring(0, ssi);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.009 -0400", hash_original_method = "DE43C7F499D5F1739936552A95AA2492", hash_generated_method = "E65880A2018BB1E4BC4D17F05BD76C41")
        private Part getSsp() {
Part var09914C8DC28309112B8F11C48A2310A0_1339336635 =             ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
            var09914C8DC28309112B8F11C48A2310A0_1339336635.addTaint(taint);
            return var09914C8DC28309112B8F11C48A2310A0_1339336635;
            // ---------- Original Method ----------
            //return ssp == null ? ssp = Part.fromEncoded(parseSsp()) : ssp;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.010 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "19422696D4EE9F24202A4614A498DE70")
        public String getEncodedSchemeSpecificPart() {
String var393D011CD485FB233FC4BE4326461491_404763565 =             getSsp().getEncoded();
            var393D011CD485FB233FC4BE4326461491_404763565.addTaint(taint);
            return var393D011CD485FB233FC4BE4326461491_404763565;
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.010 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "9898CBA299C423413C7D776CBD8265BC")
        public String getSchemeSpecificPart() {
String varDEA78A046E5755E6A172773CC85259A6_551791302 =             getSsp().getDecoded();
            varDEA78A046E5755E6A172773CC85259A6_551791302.addTaint(taint);
            return varDEA78A046E5755E6A172773CC85259A6_551791302;
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.011 -0400", hash_original_method = "6082AC88F53E9B67D59D9A72041A5D6F", hash_generated_method = "3B385027A4546889A2FFC0047089BA46")
        private String parseSsp() {
            int ssi = findSchemeSeparator();
            int fsi = findFragmentSeparator();
String varBF4B489B1C1A01395A08B9487579BBF1_284449847 =             fsi == NOT_FOUND
                    ? uriString.substring(ssi + 1)
                    : uriString.substring(ssi + 1, fsi);
            varBF4B489B1C1A01395A08B9487579BBF1_284449847.addTaint(taint);
            return varBF4B489B1C1A01395A08B9487579BBF1_284449847;
            // ---------- Original Method ----------
            //int ssi = findSchemeSeparator();
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND
                    //? uriString.substring(ssi + 1)
                    //: uriString.substring(ssi + 1, fsi);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.012 -0400", hash_original_method = "C2AABBF6273BD8549508A0ABF072F220", hash_generated_method = "4D4766BF459E3C69C8A754A237CE96CD")
        private Part getAuthorityPart() {
            if(authority == null)            
            {
                String encodedAuthority = parseAuthority(this.uriString, findSchemeSeparator());
Part var381FCECE440D5D319C351EE6F1BBEAAB_1707532535 =                 authority = Part.fromEncoded(encodedAuthority);
                var381FCECE440D5D319C351EE6F1BBEAAB_1707532535.addTaint(taint);
                return var381FCECE440D5D319C351EE6F1BBEAAB_1707532535;
            } //End block
Part var9A4A00E403B4898E9807F68E9EBE5A8B_433007366 =             authority;
            var9A4A00E403B4898E9807F68E9EBE5A8B_433007366.addTaint(taint);
            return var9A4A00E403B4898E9807F68E9EBE5A8B_433007366;
            // ---------- Original Method ----------
            //if (authority == null) {
                //String encodedAuthority
                        //= parseAuthority(this.uriString, findSchemeSeparator());
                //return authority = Part.fromEncoded(encodedAuthority);
            //}
            //return authority;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.012 -0400", hash_original_method = "B783FB869F9CE6B897E37C2A9B9B4259", hash_generated_method = "9A89BA81684390B6AE303A0156713C55")
        public String getEncodedAuthority() {
String var4F2DF47BEB24727A66BE79DC91AEECC0_277821908 =             getAuthorityPart().getEncoded();
            var4F2DF47BEB24727A66BE79DC91AEECC0_277821908.addTaint(taint);
            return var4F2DF47BEB24727A66BE79DC91AEECC0_277821908;
            // ---------- Original Method ----------
            //return getAuthorityPart().getEncoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.013 -0400", hash_original_method = "F4404025FB90C68980598D2895AF9578", hash_generated_method = "9EE649F67445BC5EE518AE8BAD4A2C0A")
        public String getAuthority() {
String var039061F12DF25903DB753BE4C77CEE48_2111102001 =             getAuthorityPart().getDecoded();
            var039061F12DF25903DB753BE4C77CEE48_2111102001.addTaint(taint);
            return var039061F12DF25903DB753BE4C77CEE48_2111102001;
            // ---------- Original Method ----------
            //return getAuthorityPart().getDecoded();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.021 -0400", hash_original_method = "483C19AAE407B7D6148F370745A1893E", hash_generated_method = "D146411E7EA0A1B058DAB6588647EC09")
        private PathPart getPathPart() {
PathPart varD78256BB83A04B0BB00412684FCFB6CE_432328209 =             path == null
                    ? path = PathPart.fromEncoded(parsePath())
                    : path;
            varD78256BB83A04B0BB00412684FCFB6CE_432328209.addTaint(taint);
            return varD78256BB83A04B0BB00412684FCFB6CE_432328209;
            // ---------- Original Method ----------
            //return path == null
                    //? path = PathPart.fromEncoded(parsePath())
                    //: path;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.023 -0400", hash_original_method = "E8759FDECF433DBBFF0BA03CF3576CC0", hash_generated_method = "84940FDDB7645CEFB55D78E6CD16EFBF")
        public String getPath() {
String varEADC8740E16239A469558240BCE0C192_326774278 =             getPathPart().getDecoded();
            varEADC8740E16239A469558240BCE0C192_326774278.addTaint(taint);
            return varEADC8740E16239A469558240BCE0C192_326774278;
            // ---------- Original Method ----------
            //return getPathPart().getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.024 -0400", hash_original_method = "D26AFC1B9D9DFA82513D9A4C50DD2F0F", hash_generated_method = "471CA07C8B54471FE9ABE4E5888AB43D")
        public String getEncodedPath() {
String var5763B1F1953626A1B4119C83521EC238_125143572 =             getPathPart().getEncoded();
            var5763B1F1953626A1B4119C83521EC238_125143572.addTaint(taint);
            return var5763B1F1953626A1B4119C83521EC238_125143572;
            // ---------- Original Method ----------
            //return getPathPart().getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.025 -0400", hash_original_method = "A1BA2B8DCFFB301EABC725C63F487DC2", hash_generated_method = "37FB46F463080A91978D9CBDFDC5608D")
        public List<String> getPathSegments() {
List<String> var9D1E6922DB3B6A33267FC8778B1D1882_607478686 =             getPathPart().getPathSegments();
            var9D1E6922DB3B6A33267FC8778B1D1882_607478686.addTaint(taint);
            return var9D1E6922DB3B6A33267FC8778B1D1882_607478686;
            // ---------- Original Method ----------
            //return getPathPart().getPathSegments();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.025 -0400", hash_original_method = "EF0989C68625FC2F46DE0EA4CB35660B", hash_generated_method = "D70A646539D4ACC47CF10887E1026072")
        private String parsePath() {
            String uriString = this.uriString;
            int ssi = findSchemeSeparator();
            if(ssi > -1)            
            {
                boolean schemeOnly = ssi + 1 == uriString.length();
                if(schemeOnly)                
                {
String var540C13E9E156B687226421B24F2DF178_208772130 =                     null;
                    var540C13E9E156B687226421B24F2DF178_208772130.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_208772130;
                } //End block
                if(uriString.charAt(ssi + 1) != '/')                
                {
String var540C13E9E156B687226421B24F2DF178_2138110841 =                     null;
                    var540C13E9E156B687226421B24F2DF178_2138110841.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_2138110841;
                } //End block
            } //End block
            else
            {
            } //End block
String var735954F5F0815F8E40E83E176F832A69_1920584329 =             parsePath(uriString, ssi);
            var735954F5F0815F8E40E83E176F832A69_1920584329.addTaint(taint);
            return var735954F5F0815F8E40E83E176F832A69_1920584329;
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

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.026 -0400", hash_original_method = "5338F6D0AC99191764C2394A710C873F", hash_generated_method = "B70DBEF34A4823C2056C2D66C66C37A7")
        private Part getQueryPart() {
Part varF5F740948841E62E50DE94DCB962384D_1611442754 =             query == null
                    ? query = Part.fromEncoded(parseQuery()) : query;
            varF5F740948841E62E50DE94DCB962384D_1611442754.addTaint(taint);
            return varF5F740948841E62E50DE94DCB962384D_1611442754;
            // ---------- Original Method ----------
            //return query == null
                    //? query = Part.fromEncoded(parseQuery()) : query;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.026 -0400", hash_original_method = "61892B739321CB796D242E9E13C1F033", hash_generated_method = "D77062F2A289BA98D2A091742A7C3A51")
        public String getEncodedQuery() {
String var592BAA78F9680D5D07BEE2DE945A79E3_1217048749 =             getQueryPart().getEncoded();
            var592BAA78F9680D5D07BEE2DE945A79E3_1217048749.addTaint(taint);
            return var592BAA78F9680D5D07BEE2DE945A79E3_1217048749;
            // ---------- Original Method ----------
            //return getQueryPart().getEncoded();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.027 -0400", hash_original_method = "93492ABD4F9B88C963E84B9F545E5D11", hash_generated_method = "A45A43262A95F3994E73268A352DF6C5")
        private String parseQuery() {
            int qsi = uriString.indexOf('?', findSchemeSeparator());
            if(qsi == NOT_FOUND)            
            {
String var540C13E9E156B687226421B24F2DF178_419303363 =                 null;
                var540C13E9E156B687226421B24F2DF178_419303363.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_419303363;
            } //End block
            int fsi = findFragmentSeparator();
            if(fsi == NOT_FOUND)            
            {
String var36038C78F7FD108CFC3CF4002250C153_1228478988 =                 uriString.substring(qsi + 1);
                var36038C78F7FD108CFC3CF4002250C153_1228478988.addTaint(taint);
                return var36038C78F7FD108CFC3CF4002250C153_1228478988;
            } //End block
            if(fsi < qsi)            
            {
String var540C13E9E156B687226421B24F2DF178_1258281850 =                 null;
                var540C13E9E156B687226421B24F2DF178_1258281850.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1258281850;
            } //End block
String varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_482490620 =             uriString.substring(qsi + 1, fsi);
            varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_482490620.addTaint(taint);
            return varCEC45AD9CB71F2C97FE02CF3CA3FEDB4_482490620;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.028 -0400", hash_original_method = "31EC40ABD8B86D0064329950E060BFBD", hash_generated_method = "220035C8F0A535147BF0E0652AD05D7C")
        public String getQuery() {
String varF32257C5D28B6286E14CC639F868B333_832508055 =             getQueryPart().getDecoded();
            varF32257C5D28B6286E14CC639F868B333_832508055.addTaint(taint);
            return varF32257C5D28B6286E14CC639F868B333_832508055;
            // ---------- Original Method ----------
            //return getQueryPart().getDecoded();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.029 -0400", hash_original_method = "EAD370CB1FE781DF1864471D9F5F3E36", hash_generated_method = "E66769E318FEDAF44054F5E7004C9627")
        private Part getFragmentPart() {
Part var8550B3AFC925290D75F2A324FFCC8703_415127987 =             fragment == null
                    ? fragment = Part.fromEncoded(parseFragment()) : fragment;
            var8550B3AFC925290D75F2A324FFCC8703_415127987.addTaint(taint);
            return var8550B3AFC925290D75F2A324FFCC8703_415127987;
            // ---------- Original Method ----------
            //return fragment == null
                    //? fragment = Part.fromEncoded(parseFragment()) : fragment;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.030 -0400", hash_original_method = "C2884F3C25114B1CD652E8CCEF7D7F10", hash_generated_method = "F399F17B114CB3DF2F04969A855DEC13")
        public String getEncodedFragment() {
String var15356DF640E39A7E16838423CF95944B_1978300904 =             getFragmentPart().getEncoded();
            var15356DF640E39A7E16838423CF95944B_1978300904.addTaint(taint);
            return var15356DF640E39A7E16838423CF95944B_1978300904;
            // ---------- Original Method ----------
            //return getFragmentPart().getEncoded();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.030 -0400", hash_original_method = "13965C7143AC0E622773DBA6AE062E67", hash_generated_method = "D9A5483878A493798522D5357BFAEE28")
        private String parseFragment() {
            int fsi = findFragmentSeparator();
String varDFC5047C05E36D10FFCD890F81F09AE9_1010739627 =             fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
            varDFC5047C05E36D10FFCD890F81F09AE9_1010739627.addTaint(taint);
            return varDFC5047C05E36D10FFCD890F81F09AE9_1010739627;
            // ---------- Original Method ----------
            //int fsi = findFragmentSeparator();
            //return fsi == NOT_FOUND ? null : uriString.substring(fsi + 1);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.031 -0400", hash_original_method = "4E8163B4F7FDF9829581A99F6274656D", hash_generated_method = "D59959ACFAA950431A109E24319E5132")
        public String getFragment() {
String var93BCD471CAA5DE221487CFBAAF871060_581464693 =             getFragmentPart().getDecoded();
            var93BCD471CAA5DE221487CFBAAF871060_581464693.addTaint(taint);
            return var93BCD471CAA5DE221487CFBAAF871060_581464693;
            // ---------- Original Method ----------
            //return getFragmentPart().getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.031 -0400", hash_original_method = "ECB4588CBE3D957B88D2558A4C044374", hash_generated_method = "88D2C0EB57FFCA629C4CDEDC19A45165")
        public String toString() {
String varA4F4B44693A1936015581C1F7D6F4DAF_1061034407 =             uriString;
            varA4F4B44693A1936015581C1F7D6F4DAF_1061034407.addTaint(taint);
            return varA4F4B44693A1936015581C1F7D6F4DAF_1061034407;
            // ---------- Original Method ----------
            //return uriString;
        }

        
        @DSModeled(DSC.SAFE)
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

        
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.033 -0400", hash_original_method = "54B78C0DD1C850213ABB66143A4F5DE7", hash_generated_method = "3C2BE706E42892C4A1C17FD77B8D937D")
        public Builder buildUpon() {
            if(isHierarchical())            
            {
Builder varF2D941D0CA5C6E55CED50CE66323299C_34584296 =                 new Builder()
                        .scheme(getScheme())
                        .authority(getAuthorityPart())
                        .path(getPathPart())
                        .query(getQueryPart())
                        .fragment(getFragmentPart());
                varF2D941D0CA5C6E55CED50CE66323299C_34584296.addTaint(taint);
                return varF2D941D0CA5C6E55CED50CE66323299C_34584296;
            } //End block
            else
            {
Builder varC65AC201593175003FC279C7FC3D63BE_930556655 =                 new Builder()
                        .scheme(getScheme())
                        .opaquePart(getSsp())
                        .fragment(getFragmentPart());
                varC65AC201593175003FC279C7FC3D63BE_930556655.addTaint(taint);
                return varC65AC201593175003FC279C7FC3D63BE_930556655;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.033 -0400", hash_original_field = "B0493B2AFC6F39450B0E6998DDC76696", hash_generated_field = "1525B2F69D3B82BDEA81D83890B48CEC")

        static final int TYPE_ID = 1;
    }


    
    private static class OpaqueUri extends Uri {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.033 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.033 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.033 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.034 -0400", hash_original_field = "E4D7B1085B3F20D4D3076206156621A1", hash_generated_field = "FCCD4A0FFBA55911A49FB2AEB7548D00")

        private volatile String cachedString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.037 -0400", hash_original_method = "A3EB90F61BB5DAD9A21709AA9F976DF8", hash_generated_method = "06AECF8220C181EEDE6CDB73AC6F3E82")
        @DSModeled(DSC.BAN)
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.040 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DD2264613A885C4CDF337A900CEDB4F7")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_803693682 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612585053 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612585053;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.041 -0400", hash_original_method = "8F996E53ADCFC30BFF794C5CEED4DA61", hash_generated_method = "9E225E24A0B19EF01FE9969CB078EF74")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.043 -0400", hash_original_method = "414EEC63B62C24CE4C288B4F88575946", hash_generated_method = "9AD0F928BDCE1C836E9257BB70E3F7E0")
        public boolean isHierarchical() {
            boolean var68934A3E9455FA72420237EB05902327_20804672 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075248555 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075248555;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.044 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "1C7F38E130739F65D50BAB7CB57AF3BF")
        public boolean isRelative() {
            boolean var4518A3BFE1F17529286D9D4EFE362EA9_2139779207 = (scheme == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576272880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_576272880;
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.049 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "F9627346E6F2B1A1AD3B1B3F0FB8C360")
        public String getScheme() {
String varBF26C0D1E8CB9E7F67A307E664136E8F_721707593 =             this.scheme;
            varBF26C0D1E8CB9E7F67A307E664136E8F_721707593.addTaint(taint);
            return varBF26C0D1E8CB9E7F67A307E664136E8F_721707593;
            // ---------- Original Method ----------
            //return this.scheme;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.050 -0400", hash_original_method = "3C55B6D4F736410AF7A2ACAB5CCC51ED", hash_generated_method = "FE22B2652046FA02D2F381F4C6954EBE")
        public String getEncodedSchemeSpecificPart() {
String varD902B0CDE27092B0A8D653D3A1CAB3D2_2141627697 =             ssp.getEncoded();
            varD902B0CDE27092B0A8D653D3A1CAB3D2_2141627697.addTaint(taint);
            return varD902B0CDE27092B0A8D653D3A1CAB3D2_2141627697;
            // ---------- Original Method ----------
            //return ssp.getEncoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.051 -0400", hash_original_method = "ED3540C8D06E41CD645C58A620F36381", hash_generated_method = "BA921490D48924EC18FE3E45EE1FD05D")
        public String getSchemeSpecificPart() {
String var754BC27394ACBF326C1E9A754D8A46C9_1154205437 =             ssp.getDecoded();
            var754BC27394ACBF326C1E9A754D8A46C9_1154205437.addTaint(taint);
            return var754BC27394ACBF326C1E9A754D8A46C9_1154205437;
            // ---------- Original Method ----------
            //return ssp.getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.053 -0400", hash_original_method = "31E41E1CB0338F9BAA50A0AC05D7D02D", hash_generated_method = "91E3950F27DB114C6E1C5602E93D2EDC")
        public String getAuthority() {
String var540C13E9E156B687226421B24F2DF178_92506878 =             null;
            var540C13E9E156B687226421B24F2DF178_92506878.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_92506878;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.056 -0400", hash_original_method = "C6F3CA63C6BE518EBD2AA32E2786DD3A", hash_generated_method = "0B8DFE02BBC2E4D4953E4A13218CB5D3")
        public String getEncodedAuthority() {
String var540C13E9E156B687226421B24F2DF178_994570867 =             null;
            var540C13E9E156B687226421B24F2DF178_994570867.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_994570867;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.057 -0400", hash_original_method = "F489014FCD27D67260CBEC8AC84559A2", hash_generated_method = "7E2FB1BCA1BE51AC4E37E759F6A7979A")
        public String getPath() {
String var540C13E9E156B687226421B24F2DF178_1571135016 =             null;
            var540C13E9E156B687226421B24F2DF178_1571135016.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1571135016;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.058 -0400", hash_original_method = "F167E35F53D1A5A8B17A8A72FE8359AE", hash_generated_method = "D48A78FD7E075E92206F7A8A9D7EE3D5")
        public String getEncodedPath() {
String var540C13E9E156B687226421B24F2DF178_1584705862 =             null;
            var540C13E9E156B687226421B24F2DF178_1584705862.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1584705862;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.059 -0400", hash_original_method = "2E34959E1DD3631C67E93F1AE6B31056", hash_generated_method = "ABC9C97BD2CC1AC82BCFCACB76F0BD6F")
        public String getQuery() {
String var540C13E9E156B687226421B24F2DF178_1143532196 =             null;
            var540C13E9E156B687226421B24F2DF178_1143532196.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1143532196;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.060 -0400", hash_original_method = "53661DD2D38C9C2E00E8B8D2FF316BB7", hash_generated_method = "ADEDC6753E9B8A038FD418C56C694243")
        public String getEncodedQuery() {
String var540C13E9E156B687226421B24F2DF178_1039604194 =             null;
            var540C13E9E156B687226421B24F2DF178_1039604194.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1039604194;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.061 -0400", hash_original_method = "9F53DDCB73E71AFF4CF207B49D0689B3", hash_generated_method = "9D338AC47E3B94682F777FAB1A5AD7C5")
        public String getFragment() {
String varAF7E6EDA3A17E940567231584A0703A7_766359486 =             fragment.getDecoded();
            varAF7E6EDA3A17E940567231584A0703A7_766359486.addTaint(taint);
            return varAF7E6EDA3A17E940567231584A0703A7_766359486;
            // ---------- Original Method ----------
            //return fragment.getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.061 -0400", hash_original_method = "2FF982E252638134744EE32C0D7F6950", hash_generated_method = "58B9ED27851AAF27D4DCE21B2F727718")
        public String getEncodedFragment() {
String varC670092882988D295A0AFA2F86B4E2AC_1810866594 =             fragment.getEncoded();
            varC670092882988D295A0AFA2F86B4E2AC_1810866594.addTaint(taint);
            return varC670092882988D295A0AFA2F86B4E2AC_1810866594;
            // ---------- Original Method ----------
            //return fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.062 -0400", hash_original_method = "08B329AF4FAA2768183F76EC45288C10", hash_generated_method = "6D7859DF1D7DF783349429099D8FBCBC")
        public List<String> getPathSegments() {
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_664217235 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_664217235.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_664217235;
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.062 -0400", hash_original_method = "AE7FF2A9DFCB643CF70873B2C08CD5A8", hash_generated_method = "3E4753C0ABF875934F47E51EAB5B4B6A")
        public String getLastPathSegment() {
String var540C13E9E156B687226421B24F2DF178_2111026775 =             null;
            var540C13E9E156B687226421B24F2DF178_2111026775.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2111026775;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.062 -0400", hash_original_method = "520FB960E4127ABC7143DD06EFB52356", hash_generated_method = "DF90956C2B7F20446D82D448D77DC540")
        public String getUserInfo() {
String var540C13E9E156B687226421B24F2DF178_2070871702 =             null;
            var540C13E9E156B687226421B24F2DF178_2070871702.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2070871702;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.063 -0400", hash_original_method = "88ECB0B5D6F4AA907FC3666F8C1418EB", hash_generated_method = "13D1D0ECDABB9E140F3C93D7E5A08EC3")
        public String getEncodedUserInfo() {
String var540C13E9E156B687226421B24F2DF178_781215292 =             null;
            var540C13E9E156B687226421B24F2DF178_781215292.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_781215292;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.063 -0400", hash_original_method = "00C71B0865F91AE7EF71B7BE21B14B9F", hash_generated_method = "2309B9BA0737FC1CAD650E306FA8982C")
        public String getHost() {
String var540C13E9E156B687226421B24F2DF178_1006019564 =             null;
            var540C13E9E156B687226421B24F2DF178_1006019564.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1006019564;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.064 -0400", hash_original_method = "B159430668427C6760C3FB4B772D9F59", hash_generated_method = "9CA6012A025B89B72A1FB26D63467B1A")
        public int getPort() {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1369326531 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018363759 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018363759;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.064 -0400", hash_original_method = "ACF28BE5516AF44175C2E6962FB03404", hash_generated_method = "77D1888EADBAD504CC77895E0518AD7A")
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached = cachedString != NOT_CACHED;
            if(cached)            
            {
String var3B17D0B227025B279C654EE822543E6B_346959233 =                 cachedString;
                var3B17D0B227025B279C654EE822543E6B_346959233.addTaint(taint);
                return var3B17D0B227025B279C654EE822543E6B_346959233;
            } //End block
            StringBuilder sb = new StringBuilder();
            sb.append(scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());
            if(!fragment.isEmpty())            
            {
                sb.append('#').append(fragment.getEncoded());
            } //End block
String varC27FFD0D6D1EF6B53917B2D053C6E05C_1344946912 =             cachedString = sb.toString();
            varC27FFD0D6D1EF6B53917B2D053C6E05C_1344946912.addTaint(taint);
            return varC27FFD0D6D1EF6B53917B2D053C6E05C_1344946912;
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.065 -0400", hash_original_method = "9B1777E9DAB1C1ED3319A4EEC33BCB54", hash_generated_method = "CA211AB13478F815CB1155C5DB3D8A45")
        public Builder buildUpon() {
Builder varB0D57715B2E1FC2447B5F7A2D1E9683B_339072280 =             new Builder()
                    .scheme(this.scheme)
                    .opaquePart(this.ssp)
                    .fragment(this.fragment);
            varB0D57715B2E1FC2447B5F7A2D1E9683B_339072280.addTaint(taint);
            return varB0D57715B2E1FC2447B5F7A2D1E9683B_339072280;
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(this.scheme)
                    //.opaquePart(this.ssp)
                    //.fragment(this.fragment);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.065 -0400", hash_original_field = "404FF43CFEE8747368BFDA1DC5DB3B28", hash_generated_field = "81BC425463DB04A2D338A2C363556710")

        static final int TYPE_ID = 2;
    }


    
    static class PathSegments extends AbstractList<String> implements RandomAccess {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.066 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.066 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

        int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.066 -0400", hash_original_method = "816AFE27D6484B7E80593A248F7DEC12", hash_generated_method = "F2AFBC317E49E2BF0F98B0C5AE8378FC")
        @DSModeled(DSC.SAFE)
          PathSegments(String[] segments, int size) {
            this.segments = segments;
            this.size = size;
            // ---------- Original Method ----------
            //this.segments = segments;
            //this.size = size;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.067 -0400", hash_original_method = "043CF25E38E9D3A71BE4CC7B6371568E", hash_generated_method = "985004B1447161B4BA971EBE76EF7B28")
        public String get(int index) {
            addTaint(index);
            if(index >= size)            
            {
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1874899748 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_1874899748.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_1874899748;
            } //End block
String var0670CDC624AB38F74C6CE6D645099017_1187855771 =             segments[index];
            var0670CDC624AB38F74C6CE6D645099017_1187855771.addTaint(taint);
            return var0670CDC624AB38F74C6CE6D645099017_1187855771;
            // ---------- Original Method ----------
            //if (index >= size) {
                //throw new IndexOutOfBoundsException();
            //}
            //return segments[index];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.067 -0400", hash_original_method = "BAF1AF8B1284BE94C387C840AF9FA265", hash_generated_method = "19C5F0B5858827E7997E7665ADF84CD6")
        public int size() {
            int varFE91D8EC738CF7D8BE7D802E3604E3B0_1854093831 = (this.size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127291465 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127291465;
            // ---------- Original Method ----------
            //return this.size;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.068 -0400", hash_original_field = "F2217D1D8C4EF2C438C5D90B83E3AD42", hash_generated_field = "E6083199966205833D7B5012129D384D")

        static final PathSegments EMPTY = new PathSegments(null, 0);
    }


    
    static class PathSegmentsBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.068 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "D8C8A9DBE80A96D9E735DAA1D195D137")

        String[] segments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.068 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

        int size = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.068 -0400", hash_original_method = "CD5B4727D6775EBFE00461F5F237812D", hash_generated_method = "CD5B4727D6775EBFE00461F5F237812D")
        @DSModeled(DSC.SAFE)
        public PathSegmentsBuilder ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.069 -0400", hash_original_method = "F05B9B5ECB44DE7CFF27782486F28CF3", hash_generated_method = "57396C99D23B797B3C467EFAA3744A8B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.070 -0400", hash_original_method = "497F2229989230601A3120EEAF21B251", hash_generated_method = "26BC1976A2455F67CAD548F2CDE4CDFB")
         PathSegments build() {
            if(segments == null)            
            {
PathSegments var61ED7A3446E992CC1D6CE996343F0BB7_569176493 =                 PathSegments.EMPTY;
                var61ED7A3446E992CC1D6CE996343F0BB7_569176493.addTaint(taint);
                return var61ED7A3446E992CC1D6CE996343F0BB7_569176493;
            } //End block
            try 
            {
PathSegments varF93FC2B9FE269AF50DE5689CD2FB3B65_2002378793 =                 new PathSegments(segments, size);
                varF93FC2B9FE269AF50DE5689CD2FB3B65_2002378793.addTaint(taint);
                return varF93FC2B9FE269AF50DE5689CD2FB3B65_2002378793;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.070 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "87B54E118334D4593A462325E6A65F84")

        private Part userInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.070 -0400", hash_original_field = "38B3753700D5B450CB30995B4DB5AF95", hash_generated_field = "539F6E6D25356608852D958A8481FDA5")

        private volatile String host = NOT_CACHED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.071 -0400", hash_original_field = "38113C68733F87156C438BEBC2FCB827", hash_generated_field = "3DEE2B327E62FC31F0BA9783EFE62CA9")

        private volatile int port = NOT_CALCULATED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.071 -0400", hash_original_method = "469DE423ED30903E9EDD58224AA80D56", hash_generated_method = "469DE423ED30903E9EDD58224AA80D56")
        @DSModeled(DSC.BAN)
        public AbstractHierarchicalUri ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.072 -0400", hash_original_method = "D5E71CFA6EED35AEB9B5F4AEC5287C3B", hash_generated_method = "A004B3158E3193D5D8F4332CABCEE94B")
        public String getLastPathSegment() {
            List<String> segments = getPathSegments();
            int size = segments.size();
            if(size == 0)            
            {
String var540C13E9E156B687226421B24F2DF178_1817876364 =                 null;
                var540C13E9E156B687226421B24F2DF178_1817876364.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1817876364;
            } //End block
String varEFCF283257D160202712C81EC6306DA0_863662672 =             segments.get(size - 1);
            varEFCF283257D160202712C81EC6306DA0_863662672.addTaint(taint);
            return varEFCF283257D160202712C81EC6306DA0_863662672;
            // ---------- Original Method ----------
            //List<String> segments = getPathSegments();
            //int size = segments.size();
            //if (size == 0) {
                //return null;
            //}
            //return segments.get(size - 1);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.073 -0400", hash_original_method = "739BBE935CAE826F3703E2BBB77B819C", hash_generated_method = "804767A45B6BD4AF08FE6F054F6D69C5")
        private Part getUserInfoPart() {
Part varF7E738A42E6D63EB0326855BC730BADF_283795157 =             userInfo == null
                    ? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
            varF7E738A42E6D63EB0326855BC730BADF_283795157.addTaint(taint);
            return varF7E738A42E6D63EB0326855BC730BADF_283795157;
            // ---------- Original Method ----------
            //return userInfo == null
                    //? userInfo = Part.fromEncoded(parseUserInfo()) : userInfo;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.074 -0400", hash_original_method = "EADAAD26DC8689BCA10DCA33883B9323", hash_generated_method = "90D052C454337410BF4F159A425FE6B2")
        public final String getEncodedUserInfo() {
String var09E3B0803DBA809E674A74FBBA3FD409_137253196 =             getUserInfoPart().getEncoded();
            var09E3B0803DBA809E674A74FBBA3FD409_137253196.addTaint(taint);
            return var09E3B0803DBA809E674A74FBBA3FD409_137253196;
            // ---------- Original Method ----------
            //return getUserInfoPart().getEncoded();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.080 -0400", hash_original_method = "10E379B7D06266EDAAC672E10EB0F58B", hash_generated_method = "F80A187C623BD4248EAA595C1219DCB5")
        private String parseUserInfo() {
            String authority = getEncodedAuthority();
            if(authority == null)            
            {
String var540C13E9E156B687226421B24F2DF178_538804005 =                 null;
                var540C13E9E156B687226421B24F2DF178_538804005.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_538804005;
            } //End block
            int end = authority.indexOf('@');
String var9D68F14379A550242867922C161646A9_1957311184 =             end == NOT_FOUND ? null : authority.substring(0, end);
            var9D68F14379A550242867922C161646A9_1957311184.addTaint(taint);
            return var9D68F14379A550242867922C161646A9_1957311184;
            // ---------- Original Method ----------
            //String authority = getEncodedAuthority();
            //if (authority == null) {
                //return null;
            //}
            //int end = authority.indexOf('@');
            //return end == NOT_FOUND ? null : authority.substring(0, end);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.083 -0400", hash_original_method = "575ECF6860F7EEFE5055BF56F2601A0E", hash_generated_method = "521A80EE3A5F1B2A931821EB1F683FDF")
        public String getUserInfo() {
String varB4A42524A46C4FAD7FBAC514070D2A61_422818221 =             getUserInfoPart().getDecoded();
            varB4A42524A46C4FAD7FBAC514070D2A61_422818221.addTaint(taint);
            return varB4A42524A46C4FAD7FBAC514070D2A61_422818221;
            // ---------- Original Method ----------
            //return getUserInfoPart().getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.083 -0400", hash_original_method = "2FC22A6CCA0A3F4C0B9E4C09F79A556D", hash_generated_method = "2AB9F607AE11845C83D474DB63B07F9D")
        public String getHost() {
            @SuppressWarnings("StringEquality") boolean cached = (host != NOT_CACHED);
String var8FB9745AFEFD90E610A95B02DD737746_1840320759 =             cached ? host
                    : (host = parseHost());
            var8FB9745AFEFD90E610A95B02DD737746_1840320759.addTaint(taint);
            return var8FB9745AFEFD90E610A95B02DD737746_1840320759;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (host != NOT_CACHED);
            //return cached ? host
                    //: (host = parseHost());
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.084 -0400", hash_original_method = "F3410DE0DFF96D0677FF54552E852FC4", hash_generated_method = "170AB4FA92B6DACD8700328CD3000698")
        private String parseHost() {
            String authority = getEncodedAuthority();
            if(authority == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1593555732 =                 null;
                var540C13E9E156B687226421B24F2DF178_1593555732.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1593555732;
            } //End block
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);
            String encodedHost = portSeparator == NOT_FOUND
                    ? authority.substring(userInfoSeparator + 1)
                    : authority.substring(userInfoSeparator + 1, portSeparator);
String var608417B3BC2F90A7AFAAFAF8F1F376E0_85359202 =             decode(encodedHost);
            var608417B3BC2F90A7AFAAFAF8F1F376E0_85359202.addTaint(taint);
            return var608417B3BC2F90A7AFAAFAF8F1F376E0_85359202;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.084 -0400", hash_original_method = "A497EF38F72042FD9397DCB617BC4BBC", hash_generated_method = "1736AEE52C24AE0AE8EA70700C42B37E")
        public int getPort() {
            int var7D5469D2554BBE8BEA01480744CB64B8_1833004327 = (port == NOT_CALCULATED
                    ? port = parsePort()
                    : port);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1277455399 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1277455399;
            // ---------- Original Method ----------
            //return port == NOT_CALCULATED
                    //? port = parsePort()
                    //: port;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.085 -0400", hash_original_method = "5469820A1C15A09B87242C85BC223022", hash_generated_method = "F7744EF9230A9881A194AADF6DACCE86")
        private int parsePort() {
            String authority = getEncodedAuthority();
            if(authority == null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1191673357 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803711630 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803711630;
            } //End block
            int userInfoSeparator = authority.indexOf('@');
            int portSeparator = authority.indexOf(':', userInfoSeparator);
            if(portSeparator == NOT_FOUND)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1027564512 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013437157 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013437157;
            } //End block
            String portString = decode(authority.substring(portSeparator + 1));
            try 
            {
                int varFBDD8FEF87E1A48D29F5CB7C1376F258_2054012288 = (Integer.parseInt(portString));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708676043 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708676043;
            } //End block
            catch (NumberFormatException e)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1916750232 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1252880408 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1252880408;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.086 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.086 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.086 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.086 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.086 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.086 -0400", hash_original_field = "97C9C694D99F729E1A48940D0B386A9B", hash_generated_field = "7012AD665E5A3250E37E3BF51B044446")

        private Part ssp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.087 -0400", hash_original_field = "2BBB7D14660BA196C018E7EF1E07014A", hash_generated_field = "9968E15A97464199002C3D2A70E60BF1")

        private volatile String uriString = NOT_CACHED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.088 -0400", hash_original_method = "4B8A4922E90F4F5C5F11CB942A244C7D", hash_generated_method = "68A9127EDB06137E28202F2E575DFD47")
        @DSModeled(DSC.BAN)
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.089 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D7E5771C2DAC068663EE1F55DC801F26")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_211453800 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565387578 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565387578;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.089 -0400", hash_original_method = "601AB6BE7C1B16F2DB83E078DF9B61DC", hash_generated_method = "6A38504F7EF3B41458C9CFB61B747E71")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.090 -0400", hash_original_method = "3471DB7575AAB7FBFD2140BF4AB89F77", hash_generated_method = "0EFCF1F2759F10DA48BCC902676EAE0D")
        public boolean isHierarchical() {
            boolean varB326B5062B2F0E69046810717534CB09_1302170313 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_200744544 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_200744544;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.090 -0400", hash_original_method = "9639BAD4AF2BECE413ED6DDD1E0FB03A", hash_generated_method = "3B30E99C7EC49515CFEFD9929CFD9827")
        public boolean isRelative() {
            boolean var4518A3BFE1F17529286D9D4EFE362EA9_385310581 = (scheme == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122078883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122078883;
            // ---------- Original Method ----------
            //return scheme == null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.091 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "1877A3E9C51D087B3844A8DA08C93E95")
        public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_1824841476 =             scheme;
            varFD3305CF8340E40F0AC0AB554909AEBC_1824841476.addTaint(taint);
            return varFD3305CF8340E40F0AC0AB554909AEBC_1824841476;
            // ---------- Original Method ----------
            //return scheme;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.091 -0400", hash_original_method = "6F57A7CA1E43F50667C0921A8F0F4C1E", hash_generated_method = "F326F52DA47E853B9F90DCD86457D5DF")
        private Part getSsp() {
Part var612ADADF05B7551B37A539180151D856_1864340048 =             ssp == null
                    ? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
            var612ADADF05B7551B37A539180151D856_1864340048.addTaint(taint);
            return var612ADADF05B7551B37A539180151D856_1864340048;
            // ---------- Original Method ----------
            //return ssp == null
                    //? ssp = Part.fromEncoded(makeSchemeSpecificPart()) : ssp;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.092 -0400", hash_original_method = "55E7C64ABF6A3CC92844508D23C19AB9", hash_generated_method = "C137C2E39F63AA6A2A59EC22B74A82AC")
        public String getEncodedSchemeSpecificPart() {
String var393D011CD485FB233FC4BE4326461491_1839085107 =             getSsp().getEncoded();
            var393D011CD485FB233FC4BE4326461491_1839085107.addTaint(taint);
            return var393D011CD485FB233FC4BE4326461491_1839085107;
            // ---------- Original Method ----------
            //return getSsp().getEncoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.092 -0400", hash_original_method = "AC19873BD337CA7E5ADD95E4E1A5F455", hash_generated_method = "D9D09D9974A829F7D16E76951B106BD7")
        public String getSchemeSpecificPart() {
String varDEA78A046E5755E6A172773CC85259A6_492389728 =             getSsp().getDecoded();
            varDEA78A046E5755E6A172773CC85259A6_492389728.addTaint(taint);
            return varDEA78A046E5755E6A172773CC85259A6_492389728;
            // ---------- Original Method ----------
            //return getSsp().getDecoded();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.092 -0400", hash_original_method = "EA75444742B675900BB1383BC22E224C", hash_generated_method = "6E1C7CF20A71589AB189F53FC49F44D1")
        private String makeSchemeSpecificPart() {
            StringBuilder builder = new StringBuilder();
            appendSspTo(builder);
String varF4CF030572656354ACFDF83FEE21D7A6_572769634 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_572769634.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_572769634;
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //appendSspTo(builder);
            //return builder.toString();
        }

        
        @DSModeled(DSC.BAN)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.093 -0400", hash_original_method = "4FC7F3346B5C0FC1519928E52B2843FB", hash_generated_method = "807C71C4E0B862DD8CC88450D52A0815")
        public String getAuthority() {
String varDD511262F0E7679CA44A2E8218470028_1715053174 =             this.authority.getDecoded();
            varDD511262F0E7679CA44A2E8218470028_1715053174.addTaint(taint);
            return varDD511262F0E7679CA44A2E8218470028_1715053174;
            // ---------- Original Method ----------
            //return this.authority.getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.094 -0400", hash_original_method = "02F0907154122B499105718EFAFFB12D", hash_generated_method = "A30DA0D724887B21979820F2CEFABB81")
        public String getEncodedAuthority() {
String var19AE63614558C7149808DBD062B65B6B_1737801250 =             this.authority.getEncoded();
            var19AE63614558C7149808DBD062B65B6B_1737801250.addTaint(taint);
            return var19AE63614558C7149808DBD062B65B6B_1737801250;
            // ---------- Original Method ----------
            //return this.authority.getEncoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.094 -0400", hash_original_method = "C2F72FED192DF0C1254C49B5EAFF6B37", hash_generated_method = "F8E4214CD5A4FF81C0E6DA310D836CE9")
        public String getEncodedPath() {
String varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_947160269 =             this.path.getEncoded();
            varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_947160269.addTaint(taint);
            return varEEAD1A4B4F429D96FD5A6ADB3BF1FFE5_947160269;
            // ---------- Original Method ----------
            //return this.path.getEncoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.095 -0400", hash_original_method = "6081DF09BF7A0319CE8B8794EF03DD3D", hash_generated_method = "667D8E2B32336376946BC31CB8EF32D4")
        public String getPath() {
String var83F9CE5C9BAF5C5C429C86F8D8178641_1050424861 =             this.path.getDecoded();
            var83F9CE5C9BAF5C5C429C86F8D8178641_1050424861.addTaint(taint);
            return var83F9CE5C9BAF5C5C429C86F8D8178641_1050424861;
            // ---------- Original Method ----------
            //return this.path.getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.095 -0400", hash_original_method = "BB14E9B85B4B70FE8537ADEAEA0F30F8", hash_generated_method = "76C6628A29EE99E4A1B514CE59D97840")
        public String getQuery() {
String var0FC25D767B999B6312889F23BA6B3E21_91451011 =             this.query.getDecoded();
            var0FC25D767B999B6312889F23BA6B3E21_91451011.addTaint(taint);
            return var0FC25D767B999B6312889F23BA6B3E21_91451011;
            // ---------- Original Method ----------
            //return this.query.getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.096 -0400", hash_original_method = "4E4841C1D3AAC7E9E3EC5666E1D3BDC7", hash_generated_method = "EB4AB9176B0F29C8DA2021911A867D75")
        public String getEncodedQuery() {
String varD80217C924F7F40BAC074946FDBADEEC_905534879 =             this.query.getEncoded();
            varD80217C924F7F40BAC074946FDBADEEC_905534879.addTaint(taint);
            return varD80217C924F7F40BAC074946FDBADEEC_905534879;
            // ---------- Original Method ----------
            //return this.query.getEncoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.096 -0400", hash_original_method = "BC71EA5136922A2C431D19FA4D7E797E", hash_generated_method = "C9F3E4B5BEE195B431B60F211DD7F90C")
        public String getFragment() {
String varD91F6287F55E70D82879F259060BB4F7_1180400820 =             this.fragment.getDecoded();
            varD91F6287F55E70D82879F259060BB4F7_1180400820.addTaint(taint);
            return varD91F6287F55E70D82879F259060BB4F7_1180400820;
            // ---------- Original Method ----------
            //return this.fragment.getDecoded();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.096 -0400", hash_original_method = "D0BDA4E24821D7C40932E823B160DCAD", hash_generated_method = "B7110403967EF5A991C997DB917F1100")
        public String getEncodedFragment() {
String var9BE81904ABD2B0EBFE2214CE0EE4BBFD_186588106 =             this.fragment.getEncoded();
            var9BE81904ABD2B0EBFE2214CE0EE4BBFD_186588106.addTaint(taint);
            return var9BE81904ABD2B0EBFE2214CE0EE4BBFD_186588106;
            // ---------- Original Method ----------
            //return this.fragment.getEncoded();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.097 -0400", hash_original_method = "6A1F2A59685BCA2552F3B76D88CB5845", hash_generated_method = "EBFCE7ABB43102C4EDAD30102F8D5AD7")
        public List<String> getPathSegments() {
List<String> varA8049C752B325D0BCB78F1A90EC0D736_10837507 =             this.path.getPathSegments();
            varA8049C752B325D0BCB78F1A90EC0D736_10837507.addTaint(taint);
            return varA8049C752B325D0BCB78F1A90EC0D736_10837507;
            // ---------- Original Method ----------
            //return this.path.getPathSegments();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.099 -0400", hash_original_method = "2FFEEC7D33EBEEF04178DF9D921CBC02", hash_generated_method = "FC2C629EF938EA81F1B52290C3B3BB28")
        @Override
        public String toString() {
            @SuppressWarnings("StringEquality") boolean cached = (uriString != NOT_CACHED);
String var9B86F3459D079E341060C628CFD4EC8E_208299123 =             cached ? uriString
                    : (uriString = makeUriString());
            var9B86F3459D079E341060C628CFD4EC8E_208299123.addTaint(taint);
            return var9B86F3459D079E341060C628CFD4EC8E_208299123;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean cached = (uriString != NOT_CACHED);
            //return cached ? uriString
                    //: (uriString = makeUriString());
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.099 -0400", hash_original_method = "5AECD242275C33F74DCA414A6C8DF5D7", hash_generated_method = "629638C317F231973669D19B4C860396")
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
String varF4CF030572656354ACFDF83FEE21D7A6_1370325355 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_1370325355.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_1370325355;
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.100 -0400", hash_original_method = "6635CD2DD122D7EE5F14A5F21B272B08", hash_generated_method = "167C0A1C978BA2C420B66F39E14B1AF2")
        public Builder buildUpon() {
Builder varED3F8822050435D1DCF8FEEC1E3625B3_1513361006 =             new Builder()
                    .scheme(scheme)
                    .authority(authority)
                    .path(path)
                    .query(query)
                    .fragment(fragment);
            varED3F8822050435D1DCF8FEEC1E3625B3_1513361006.addTaint(taint);
            return varED3F8822050435D1DCF8FEEC1E3625B3_1513361006;
            // ---------- Original Method ----------
            //return new Builder()
                    //.scheme(scheme)
                    //.authority(authority)
                    //.path(path)
                    //.query(query)
                    //.fragment(fragment);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.100 -0400", hash_original_field = "1A6BAB54CA68848B2D28EFB422CF1725", hash_generated_field = "F1F90627D661D3D25ABE19AF04422DA0")

        static final int TYPE_ID = 3;
    }


    
    public static final class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.100 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

        private String scheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.100 -0400", hash_original_field = "E17823015F179701BCEC9CD4356C4A38", hash_generated_field = "F30F644E178A706F0279AC78D6913562")

        private Part opaquePart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.101 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "204632F970E6983D2007A7D2C7B93357")

        private Part authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.101 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "EEFCA663E12A09EA3C7131B68BE78289")

        private PathPart path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.101 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "D9C517AF157475966407B5CDC5940032")

        private Part query;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.101 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "8AF52B12247A3EBE638DDC3C88EEE123")

        private Part fragment;
        
        @DSModeled(DSC.SAFE)
        public Builder() {}

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.111 -0400", hash_original_method = "1FAF048543AEDF54BF8218C15362FDC3", hash_generated_method = "DA9B92F29C4F9F77E66D9D2F88B4F06F")
        public Builder scheme(String scheme) {
            this.scheme = scheme;
Builder var72A74007B2BE62B849F475C7BDA4658B_2012197944 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2012197944.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2012197944;
            // ---------- Original Method ----------
            //this.scheme = scheme;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.113 -0400", hash_original_method = "8D4C2B402A916DF01BF39AF004B22B4B", hash_generated_method = "6129C6ED1C029301B39FDEF6A0CD61D2")
         Builder opaquePart(Part opaquePart) {
            this.opaquePart = opaquePart;
Builder var72A74007B2BE62B849F475C7BDA4658B_235750601 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_235750601.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_235750601;
            // ---------- Original Method ----------
            //this.opaquePart = opaquePart;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.114 -0400", hash_original_method = "B04C2A20C29308DA58A03AAA34E4602D", hash_generated_method = "6E1DC25672C8A740CAA64D5F09CA0F5B")
        public Builder opaquePart(String opaquePart) {
            addTaint(opaquePart.getTaint());
Builder var447EF4E65B1A86D27C660BD3406092A1_948667496 =             opaquePart(Part.fromDecoded(opaquePart));
            var447EF4E65B1A86D27C660BD3406092A1_948667496.addTaint(taint);
            return var447EF4E65B1A86D27C660BD3406092A1_948667496;
            // ---------- Original Method ----------
            //return opaquePart(Part.fromDecoded(opaquePart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.115 -0400", hash_original_method = "E3AC90668DB82124786DAC21400DF68F", hash_generated_method = "EE45515611785797DB97E99194DE411F")
        public Builder encodedOpaquePart(String opaquePart) {
            addTaint(opaquePart.getTaint());
Builder var34CFA2F802F04C1F00EC4E996B5D7270_1298283884 =             opaquePart(Part.fromEncoded(opaquePart));
            var34CFA2F802F04C1F00EC4E996B5D7270_1298283884.addTaint(taint);
            return var34CFA2F802F04C1F00EC4E996B5D7270_1298283884;
            // ---------- Original Method ----------
            //return opaquePart(Part.fromEncoded(opaquePart));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.115 -0400", hash_original_method = "CE12FA6D2315F74B1A3B79C027FFFA6D", hash_generated_method = "6C94BFEB5F47CD803428D862254F76A5")
         Builder authority(Part authority) {
            this.opaquePart = null;
            this.authority = authority;
Builder var72A74007B2BE62B849F475C7BDA4658B_1336484549 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1336484549.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1336484549;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.authority = authority;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.118 -0400", hash_original_method = "8B987B114EF487282F33A481DCB273CB", hash_generated_method = "FA6038C78F68E95DFC95BC69C223363E")
        public Builder authority(String authority) {
            addTaint(authority.getTaint());
Builder var2EDA88150582111521EDC9CAB7001682_2013565414 =             authority(Part.fromDecoded(authority));
            var2EDA88150582111521EDC9CAB7001682_2013565414.addTaint(taint);
            return var2EDA88150582111521EDC9CAB7001682_2013565414;
            // ---------- Original Method ----------
            //return authority(Part.fromDecoded(authority));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.119 -0400", hash_original_method = "2AF9D1463857894BBB2A3B7E377A77BB", hash_generated_method = "3D756139B3E5C08405F9EF469E468A0D")
        public Builder encodedAuthority(String authority) {
            addTaint(authority.getTaint());
Builder var426370EFE7B4302B3E1C247DE7CA1F10_1466441438 =             authority(Part.fromEncoded(authority));
            var426370EFE7B4302B3E1C247DE7CA1F10_1466441438.addTaint(taint);
            return var426370EFE7B4302B3E1C247DE7CA1F10_1466441438;
            // ---------- Original Method ----------
            //return authority(Part.fromEncoded(authority));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.121 -0400", hash_original_method = "0552AFD7FA04CD9C4E588C7FB644B387", hash_generated_method = "0444AED10CFEFC1170ECAF9325BA4C70")
         Builder path(PathPart path) {
            this.opaquePart = null;
            this.path = path;
Builder var72A74007B2BE62B849F475C7BDA4658B_2003859057 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2003859057.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2003859057;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.path = path;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.124 -0400", hash_original_method = "311D5047B3596F1C34DEC3DA1D1264C5", hash_generated_method = "A679A90AED145506633855C173C2F6D1")
        public Builder path(String path) {
            addTaint(path.getTaint());
Builder varE93D7008AE3144DB58924E5F7D03413A_1788397620 =             path(PathPart.fromDecoded(path));
            varE93D7008AE3144DB58924E5F7D03413A_1788397620.addTaint(taint);
            return varE93D7008AE3144DB58924E5F7D03413A_1788397620;
            // ---------- Original Method ----------
            //return path(PathPart.fromDecoded(path));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.125 -0400", hash_original_method = "B2733F0C4852B782EB87F01613E6C574", hash_generated_method = "7093D27C85BBAE5EA12471B97370A295")
        public Builder encodedPath(String path) {
            addTaint(path.getTaint());
Builder var2C099BD4CBAC004E7DBA3E062586EF05_1267060703 =             path(PathPart.fromEncoded(path));
            var2C099BD4CBAC004E7DBA3E062586EF05_1267060703.addTaint(taint);
            return var2C099BD4CBAC004E7DBA3E062586EF05_1267060703;
            // ---------- Original Method ----------
            //return path(PathPart.fromEncoded(path));
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.125 -0400", hash_original_method = "818DCEC2192004BCFE40E4E49FDA7A4C", hash_generated_method = "AB3FA251D86350B1A9FA63275AD869AF")
        public Builder appendPath(String newSegment) {
            addTaint(newSegment.getTaint());
Builder var8D3C52E329AACC9BA26FC60EDBDA633E_578710583 =             path(PathPart.appendDecodedSegment(path, newSegment));
            var8D3C52E329AACC9BA26FC60EDBDA633E_578710583.addTaint(taint);
            return var8D3C52E329AACC9BA26FC60EDBDA633E_578710583;
            // ---------- Original Method ----------
            //return path(PathPart.appendDecodedSegment(path, newSegment));
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.134 -0400", hash_original_method = "04B6E07373B5BCB6E5F5541B11BC55A7", hash_generated_method = "E1817F630DEAA136259537BB879777BE")
        public Builder appendEncodedPath(String newSegment) {
            addTaint(newSegment.getTaint());
Builder var15BBA848D385BBCE5F9325C9F07D3D5A_564873258 =             path(PathPart.appendEncodedSegment(path, newSegment));
            var15BBA848D385BBCE5F9325C9F07D3D5A_564873258.addTaint(taint);
            return var15BBA848D385BBCE5F9325C9F07D3D5A_564873258;
            // ---------- Original Method ----------
            //return path(PathPart.appendEncodedSegment(path, newSegment));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.136 -0400", hash_original_method = "526B00AFFC674BC410AFF0DB5058AD68", hash_generated_method = "438B5EBC2DF3B86245CFFD2C56D0C5F4")
         Builder query(Part query) {
            this.opaquePart = null;
            this.query = query;
Builder var72A74007B2BE62B849F475C7BDA4658B_1660619057 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1660619057.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1660619057;
            // ---------- Original Method ----------
            //this.opaquePart = null;
            //this.query = query;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.143 -0400", hash_original_method = "915051404F16544BAB27A534573CC34D", hash_generated_method = "0A8D68C1BCC5DFC2C887A4E9EE74AB49")
        public Builder query(String query) {
            addTaint(query.getTaint());
Builder var66923BEC3D8C1278767576BF4D394152_1033989385 =             query(Part.fromDecoded(query));
            var66923BEC3D8C1278767576BF4D394152_1033989385.addTaint(taint);
            return var66923BEC3D8C1278767576BF4D394152_1033989385;
            // ---------- Original Method ----------
            //return query(Part.fromDecoded(query));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.145 -0400", hash_original_method = "2B1CFFF6E8520529FC529F01B5DBCD04", hash_generated_method = "D6899837E09AB4D5D91E08201BE8B378")
        public Builder encodedQuery(String query) {
            addTaint(query.getTaint());
Builder var05319EFE71D4D5FABCEFB5394AF0F3A4_234200736 =             query(Part.fromEncoded(query));
            var05319EFE71D4D5FABCEFB5394AF0F3A4_234200736.addTaint(taint);
            return var05319EFE71D4D5FABCEFB5394AF0F3A4_234200736;
            // ---------- Original Method ----------
            //return query(Part.fromEncoded(query));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.146 -0400", hash_original_method = "AAD8E80453C4B46D11B41869FDCBA00D", hash_generated_method = "0ED8185E23640C7B39FB7B5A294DBA82")
         Builder fragment(Part fragment) {
            this.fragment = fragment;
Builder var72A74007B2BE62B849F475C7BDA4658B_2072780637 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2072780637.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2072780637;
            // ---------- Original Method ----------
            //this.fragment = fragment;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.147 -0400", hash_original_method = "016C309F39EF5D90CF32B95F6FDB27F8", hash_generated_method = "D673586EB51EAA2DABC7A1266D5DD50E")
        public Builder fragment(String fragment) {
            addTaint(fragment.getTaint());
Builder var8A0E66BF4149A1703B51D880CE7BD3FB_1011652159 =             fragment(Part.fromDecoded(fragment));
            var8A0E66BF4149A1703B51D880CE7BD3FB_1011652159.addTaint(taint);
            return var8A0E66BF4149A1703B51D880CE7BD3FB_1011652159;
            // ---------- Original Method ----------
            //return fragment(Part.fromDecoded(fragment));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.147 -0400", hash_original_method = "C5F51A11F0BEF63CCF4FD5F6AF742648", hash_generated_method = "458A2022D19918797E4EA4AE9C2ED3C6")
        public Builder encodedFragment(String fragment) {
            addTaint(fragment.getTaint());
Builder varF653F4C1C1E12E452895547E2A8D497C_987500309 =             fragment(Part.fromEncoded(fragment));
            varF653F4C1C1E12E452895547E2A8D497C_987500309.addTaint(taint);
            return varF653F4C1C1E12E452895547E2A8D497C_987500309;
            // ---------- Original Method ----------
            //return fragment(Part.fromEncoded(fragment));
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.148 -0400", hash_original_method = "F83D70A0FC90543F01AB6385367098CC", hash_generated_method = "4B86219195D36FFF9606AA2A262F1AB7")
        public Builder appendQueryParameter(String key, String value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            this.opaquePart = null;
            String encodedParameter = encode(key, null) + "="
                    + encode(value, null);
            if(query == null)            
            {
                query = Part.fromEncoded(encodedParameter);
Builder var72A74007B2BE62B849F475C7BDA4658B_1648232290 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1648232290.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1648232290;
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
Builder var72A74007B2BE62B849F475C7BDA4658B_1024123122 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1024123122.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1024123122;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.148 -0400", hash_original_method = "581A1CF068B5634C1F252DE7C2737E06", hash_generated_method = "7F52050A5A3956A9F17304631D495917")
        public Builder clearQuery() {
Builder var53FE33D9FA667E351CE36A4E53159F37_363632814 =             query((Part) null);
            var53FE33D9FA667E351CE36A4E53159F37_363632814.addTaint(taint);
            return var53FE33D9FA667E351CE36A4E53159F37_363632814;
            // ---------- Original Method ----------
            //return query((Part) null);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.149 -0400", hash_original_method = "C36CE5067F02DA1F1C7276BF67665A1B", hash_generated_method = "D4B5A52DF6CB41EA7AAB3153C6771856")
        public Uri build() {
            if(opaquePart != null)            
            {
                if(this.scheme == null)                
                {
                    UnsupportedOperationException varBBE90DF2A7DE2FEB6E102C54C2A10961_456995838 = new UnsupportedOperationException(
                            "An opaque URI must have a scheme.");
                    varBBE90DF2A7DE2FEB6E102C54C2A10961_456995838.addTaint(taint);
                    throw varBBE90DF2A7DE2FEB6E102C54C2A10961_456995838;
                } //End block
Uri varBD7EC89A1E53A9CF305CC36AF2561E02_1470104963 =                 new OpaqueUri(scheme, opaquePart, fragment);
                varBD7EC89A1E53A9CF305CC36AF2561E02_1470104963.addTaint(taint);
                return varBD7EC89A1E53A9CF305CC36AF2561E02_1470104963;
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
Uri var1A5C773E6B2C9527C52233E0D175F391_445073881 =                 new HierarchicalUri(
                        scheme, authority, path, query, fragment);
                var1A5C773E6B2C9527C52233E0D175F391_445073881.addTaint(taint);
                return var1A5C773E6B2C9527C52233E0D175F391_445073881;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.158 -0400", hash_original_method = "7917AD3B49169A1AC8EEA7DD014B7E45", hash_generated_method = "3C06BD2A8B031D202C3BE8F06B199C5E")
        private boolean hasSchemeOrAuthority() {
            boolean var66F0DE1EAD0A64E28D3A3FCCC8CAE0D4_476071093 = (scheme != null
                    || (authority != null && authority != Part.NULL));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335401043 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335401043;
            // ---------- Original Method ----------
            //return scheme != null
                    //|| (authority != null && authority != Part.NULL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.158 -0400", hash_original_method = "50FC77E3DFFDDD2DB7D0B749912434F7", hash_generated_method = "484453F28691777F09002C6644F3EE1D")
        @Override
        public String toString() {
String var83CCC8E6DBC69F3499A1E5AC609A34CF_1617177443 =             build().toString();
            var83CCC8E6DBC69F3499A1E5AC609A34CF_1617177443.addTaint(taint);
            return var83CCC8E6DBC69F3499A1E5AC609A34CF_1617177443;
            // ---------- Original Method ----------
            //return build().toString();
        }

        
    }


    
    static abstract class AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.158 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "08274B7EEBA921030ECC3D76D1E6ECCB")

        volatile String encoded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.159 -0400", hash_original_field = "AD05458423E19C1FF1F3C0237F8CFBED", hash_generated_field = "B682B941676F7CF6A565D2078C9BC0A9")

        volatile String decoded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.159 -0400", hash_original_method = "21E01F693530948BFE81E2C9AE8C6D31", hash_generated_method = "00DF56A1D35C3F914A2155477BDE237F")
        @DSModeled(DSC.SAFE)
          AbstractPart(String encoded, String decoded) {
            this.encoded = encoded;
            this.decoded = decoded;
            // ---------- Original Method ----------
            //this.encoded = encoded;
            //this.decoded = decoded;
        }

        
        @DSModeled(DSC.SAFE)
        abstract String getEncoded();

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.160 -0400", hash_original_method = "06323BBC323E7F59CEDDE1FAA04ED1F6", hash_generated_method = "1539184D269B68795EE5C8E7CFB00FD4")
        final String getDecoded() {
            @SuppressWarnings("StringEquality") boolean hasDecoded = decoded != NOT_CACHED;
String varF9DE9787DBBABACF674820C53FE77B7A_1079625040 =             hasDecoded ? decoded : (decoded = decode(encoded));
            varF9DE9787DBBABACF674820C53FE77B7A_1079625040.addTaint(taint);
            return varF9DE9787DBBABACF674820C53FE77B7A_1079625040;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasDecoded = decoded != NOT_CACHED;
            //return hasDecoded ? decoded : (decoded = decode(encoded));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.160 -0400", hash_original_method = "BB7E54AFB81798C035BF3B3717F470E7", hash_generated_method = "E9BC0739AA6E54656D82CE69B1D4F438")
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
                IllegalArgumentException var25F0B2A44934D2D997027BC02866E4A5_154323177 = new IllegalArgumentException("Neither encoded nor decoded");
                var25F0B2A44934D2D997027BC02866E4A5_154323177.addTaint(taint);
                throw var25F0B2A44934D2D997027BC02866E4A5_154323177;
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.161 -0400", hash_original_method = "49186660D0AEF0721F749C758CF0FE34", hash_generated_method = "49186660D0AEF0721F749C758CF0FE34")
            public Representation ()
            {
                //Synthesized constructor
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.161 -0400", hash_original_field = "659BA2B3286FF6C4923CFE851F3CD42E", hash_generated_field = "FF4F4E4C6DA0CB1E3DB9C13C6C3A4A5B")

            static final int BOTH = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.161 -0400", hash_original_field = "D22FD9F8AEEC62F2AEF921B20283C7C9", hash_generated_field = "A15D22B3282778C07B2BEC94A0EE0FD2")

            static final int ENCODED = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.161 -0400", hash_original_field = "7CA715B76440B29FFB05D39B0C592B7F", hash_generated_field = "8C3D0A85A317D2355A45465A71C73F69")

            static final int DECODED = 2;
        }


        
    }


    
    static class Part extends AbstractPart {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.161 -0400", hash_original_method = "68B275EBA6010E5404727E121615E229", hash_generated_method = "CE292AEA2FF3777030E1EB75C7BF77AA")
        @DSModeled(DSC.BAN)
        private  Part(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(decoded.getTaint());
            addTaint(encoded.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.162 -0400", hash_original_method = "BD94DCCF5B44419F4498543CA74892E2", hash_generated_method = "3D4999EA94FEBBEDF9504722EE79CDFE")
         boolean isEmpty() {
            boolean var68934A3E9455FA72420237EB05902327_855776645 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968880749 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_968880749;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.162 -0400", hash_original_method = "74B8C999E422A266FD890BA259F6B43C", hash_generated_method = "FE8EA5D3C0D4BD66290C98088E381CE5")
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
String varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_693571054 =             hasEncoded ? encoded : (encoded = encode(decoded));
            varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_693571054.addTaint(taint);
            return varD9CB8C2B20ED9DEC2D7559A7FB72C3A1_693571054;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded));
        }

        
        @DSModeled(DSC.SAFE)
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

        
        @DSModeled(DSC.SAFE)
        static Part fromEncoded(String encoded) {
            return from(encoded, NOT_CACHED);
        }

        
        @DSModeled(DSC.SAFE)
        static Part fromDecoded(String decoded) {
            return from(NOT_CACHED, decoded);
        }

        
        @DSModeled(DSC.SAFE)
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.164 -0400", hash_original_method = "D79C0256E86C850253FAE782AD9920ED", hash_generated_method = "D6E891CD56E98A9A6565F34666DC1B4A")
            @DSModeled(DSC.SAFE)
            public  EmptyPart(String value) {
                super(value, value);
                addTaint(value.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.173 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "014D8A5AF1A936FC44851BCAB5A4641A")
            @Override
             boolean isEmpty() {
                boolean varB326B5062B2F0E69046810717534CB09_438661926 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644240117 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_644240117;
                // ---------- Original Method ----------
                //return true;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.173 -0400", hash_original_field = "22902092D13F95EF047EC38F67C7A689", hash_generated_field = "B57558D017E2A8337F27C36F5D930EAB")

        static final Part NULL = new EmptyPart(null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.173 -0400", hash_original_field = "7F2DFD92B4F00B07EC2711F9AFB4D4CD", hash_generated_field = "D56E54A9BB15BF578A32B43A761A7D58")

        static final Part EMPTY = new EmptyPart("");
    }


    
    static class PathPart extends AbstractPart {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.176 -0400", hash_original_field = "5C8A59F77C438336819DD4F6B0C372B5", hash_generated_field = "BB8884736C4C2C995D440C597E10BBE6")

        private PathSegments pathSegments;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.177 -0400", hash_original_method = "E8CA21F7072E8C7642F3BFF9454329AE", hash_generated_method = "BCE7A6DB1134431144E50BD91D1A7695")
        @DSModeled(DSC.BAN)
        private  PathPart(String encoded, String decoded) {
            super(encoded, decoded);
            addTaint(decoded.getTaint());
            addTaint(encoded.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.186 -0400", hash_original_method = "EEE1C5D1C73794B2424FF9B6A794D8BE", hash_generated_method = "4B0F67434D8457DAFD58D4166208573C")
         String getEncoded() {
            @SuppressWarnings("StringEquality") boolean hasEncoded = encoded != NOT_CACHED;
String varEFDAC2AC5D53E9CE24C648C5C33F0808_1967545914 =             hasEncoded ? encoded : (encoded = encode(decoded, "/"));
            varEFDAC2AC5D53E9CE24C648C5C33F0808_1967545914.addTaint(taint);
            return varEFDAC2AC5D53E9CE24C648C5C33F0808_1967545914;
            // ---------- Original Method ----------
            //@SuppressWarnings("StringEquality")
            //boolean hasEncoded = encoded != NOT_CACHED;
            //return hasEncoded ? encoded : (encoded = encode(decoded, "/"));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.187 -0400", hash_original_method = "BB12DAE5001652F9E9419E41FB496BCF", hash_generated_method = "8CFE3E49AD6DEBC7E990871E0E3646C1")
         PathSegments getPathSegments() {
            if(pathSegments != null)            
            {
PathSegments var5204DC86E95830EB05C770BC38BED307_1733217674 =                 pathSegments;
                var5204DC86E95830EB05C770BC38BED307_1733217674.addTaint(taint);
                return var5204DC86E95830EB05C770BC38BED307_1733217674;
            } //End block
            String path = getEncoded();
            if(path == null)            
            {
PathSegments var73DD0AB3EF50886F4E8427C8CCBD1FAF_292525413 =                 pathSegments = PathSegments.EMPTY;
                var73DD0AB3EF50886F4E8427C8CCBD1FAF_292525413.addTaint(taint);
                return var73DD0AB3EF50886F4E8427C8CCBD1FAF_292525413;
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
PathSegments var58DFB823F4B6E95DFEC9F8BC0A1DF96E_1815096738 =             pathSegments = segmentBuilder.build();
            var58DFB823F4B6E95DFEC9F8BC0A1DF96E_1815096738.addTaint(taint);
            return var58DFB823F4B6E95DFEC9F8BC0A1DF96E_1815096738;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
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

        
        @DSModeled(DSC.SAFE)
        static PathPart appendDecodedSegment(PathPart oldPart, String decoded) {
            String encoded = encode(decoded);
            PathPart retVal = appendEncodedSegment(oldPart, encoded);
            retVal.addTaint(oldPart.getTaint());
            retVal.addTaint(decoded.getTaint());
            return retVal;
        }

        
        @DSModeled(DSC.SAFE)
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

        
        @DSModeled(DSC.SAFE)
        static PathPart fromEncoded(String encoded) {
        	PathPart retVal = from(encoded, NOT_CACHED);
        	retVal.addTaint(encoded.getTaint());
            return retVal;
        }

        
        @DSModeled(DSC.SAFE)
        static PathPart fromDecoded(String decoded) {
            return from(NOT_CACHED, decoded);
        }

        
        @DSModeled(DSC.SAFE)
        static PathPart from(String encoded, String decoded) {
            if (encoded == null) {
                return NULL;
            }
            if (encoded.length() == 0) {
                return EMPTY;
            }
            return new PathPart(encoded, decoded);
        }

        
        @DSModeled(DSC.SAFE)
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.189 -0400", hash_original_field = "12FCD4CDDE0159C0A83B0F6923FAC7D8", hash_generated_field = "CE631D3EC26A75E141BE1EBBE7AA5D88")

        static final PathPart NULL = new PathPart(null, null);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.189 -0400", hash_original_field = "2511CF6735334EEEFE4C66E3501EA765", hash_generated_field = "092DD7A22CF30B1C24AB41550FA2A397")

        static final PathPart EMPTY = new PathPart("", "");
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.189 -0400", hash_original_field = "15E64A01463468950481CAE21CF06FCB", hash_generated_field = "0451CD7498AE36BDD61110634E7FCA90")

    private static final String LOG = Uri.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.189 -0400", hash_original_field = "A90280C308D46EDE51003B54A6774638", hash_generated_field = "B954F9C12AC0662BCBDFC1BE53358724")

    @SuppressWarnings("RedundantStringConstructorCall") private static final String NOT_CACHED = new String("NOT CACHED");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.189 -0400", hash_original_field = "A81A920AEF8690239BB9D44F7E78D4F4", hash_generated_field = "5038C252470848AFDD24667CC5D97705")

    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL,
            PathPart.EMPTY, Part.NULL, Part.NULL);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.190 -0400", hash_original_field = "096628D07602808452D76140024603D6", hash_generated_field = "70D3B26ADAF374FF9FC1A886C7965F17")

    private final static int NOT_FOUND = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.190 -0400", hash_original_field = "4FDDDF7A3C684DEFD4771F4F71A53864", hash_generated_field = "309A8D293FB70CF3C8B75760A49AAA8A")

    private final static int NOT_CALCULATED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.190 -0400", hash_original_field = "6DE16BB1834113B41F3DB9E09DDB15A3", hash_generated_field = "D90B08A155B6660D5725B7F9B3B765E3")

    private static final String NOT_HIERARCHICAL = "This isn't a hierarchical URI.";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.190 -0400", hash_original_field = "2D7FBEFE0E1B69A4322A3C2F72D1B945", hash_generated_field = "801ABCF993C84AFFC2A4DEC33E3ED2DF")

    private static final String DEFAULT_ENCODING = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.190 -0400", hash_original_field = "FEE7EF6013925E53DB51A6700DEA6FED", hash_generated_field = "013D84CBB14787012A1B410C2CED92EA")

    private static final int NULL_TYPE_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.190 -0400", hash_original_field = "FA031E527800FCED59C59BB3277BEE96", hash_generated_field = "A8963E713BB231EFDC73C3C4317D711B")

    public static final Parcelable.Creator<Uri> CREATOR
            = new Parcelable.Creator<Uri>() {
        @DSModeled(DSC.SPEC)
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

        @DSModeled(DSC.SAFE)
        public Uri[] newArray(int size) {
            return new Uri[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.190 -0400", hash_original_field = "7590EBC339FE731817F9724DB1BDFD6C", hash_generated_field = "C46B2CD1575F3EFF815653AFF0EA6C73")

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.191 -0400", hash_original_field = "B895F573C0891DA82989F42094373576", hash_generated_field = "EA76FA4E6E39D084A2B31303C1E9D60D")

    private static final byte[] REPLACEMENT = { (byte) 0xFF, (byte) 0xFD };
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
	public Uri(String uri) {
		this();
		uriString = uri;
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SPEC)
	public int describeContents() {
		return getTaintInt();
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SPEC)
	public void writeToParcel(Parcel dest, int flags) {
		dest.addTaint(getTaint());
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SPEC)
	public int compareTo(Uri arg0) {
		// TODO Auto-generated method stub
		return getTaintInt();
	}
    
    // orphaned legacy field
    private String uriString;
    
}

