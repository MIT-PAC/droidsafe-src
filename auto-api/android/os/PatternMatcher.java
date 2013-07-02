package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class PatternMatcher implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.906 -0400", hash_original_field = "22A7D0E705563AC4D94E2656C1D970BF", hash_generated_field = "3CD87C11C7A58085FB84E25F889274B8")

    private String mPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.906 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.906 -0400", hash_original_method = "1FC2431316C42DE0C3D46C9188020DE6", hash_generated_method = "ADF085B19B9D41C3062DF9AA7E715C4A")
    public  PatternMatcher(String pattern, int type) {
        mPattern = pattern;
        mType = type;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.907 -0400", hash_original_method = "B901ADD56C5DD849BD7E8046FFB1F0D3", hash_generated_method = "AB26A796A7240D0D0FFF39F49D23E776")
    public  PatternMatcher(Parcel src) {
        mPattern = src.readString();
        mType = src.readInt();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.907 -0400", hash_original_method = "05EB8C992FD149B44BBE0FC11E651762", hash_generated_method = "B344CA6E016689D87658A9DD4ACE1EBB")
    public final String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1111704812 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1111704812 = mPattern;
        varB4EAC82CA7396A68D541C85D26508E83_1111704812.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1111704812;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.908 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "72A1F91B6C2ADC1BD756C171F0B0E4BE")
    public final int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262995401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262995401;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.908 -0400", hash_original_method = "62F8B077957CE70BF92EA7EF3ACCE61D", hash_generated_method = "62B27294D671DD298255AEA2D553A32D")
    public boolean match(String str) {
        boolean var2306B6FCBFA5915874A27ADE8981E3F6_1779834670 = (matchPattern(mPattern, str, mType));
        addTaint(str.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580250703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_580250703;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.909 -0400", hash_original_method = "4D68435646F5279408D2A4F2A408DED4", hash_generated_method = "AAA4AFEFEA481BDCEBF6208C2F846B70")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_241984622 = null; 
        String type = "? ";
        
        type = "LITERAL: ";
        
        
        type = "PREFIX: ";
        
        
        type = "GLOB: ";
        
        varB4EAC82CA7396A68D541C85D26508E83_241984622 = "PatternMatcher{" + type + mPattern + "}";
        varB4EAC82CA7396A68D541C85D26508E83_241984622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_241984622;
        
        
        
            
                
                
            
                
                
            
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.909 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2DF2C07BB8B84712C1054BB2D33744CD")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074339528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074339528;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.910 -0400", hash_original_method = "ECBD3AB9E3B58368B577D8D9D90A2091", hash_generated_method = "D9046BADE35B9199CDF4595CDCC16D03")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPattern);
        dest.writeInt(mType);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static boolean matchPattern(String pattern, String match, int type) {
        if (match == null) return false;
        if (type == PATTERN_LITERAL) {
            return pattern.equals(match);
        }
        if (type == PATTERN_PREFIX) {
            return match.startsWith(pattern);
        } else if (type != PATTERN_SIMPLE_GLOB) {
            return false;
        }
        final int NP = pattern.length();
        if (NP <= 0) {
            return match.length() <= 0;
        }
        final int NM = match.length();
        int ip = 0, im = 0;
        char nextChar = pattern.charAt(0);
        while ((ip<NP) && (im<NM)) {
            char c = nextChar;
            ip++;
            nextChar = ip < NP ? pattern.charAt(ip) : 0;
            final boolean escaped = (c == '\\');
            if (escaped) {
                c = nextChar;
                ip++;
                nextChar = ip < NP ? pattern.charAt(ip) : 0;
            }
            if (nextChar == '*') {
                if (!escaped && c == '.') {
                    if (ip >= (NP-1)) {
                        return true;
                    }
                    ip++;
                    nextChar = pattern.charAt(ip);
                    if (nextChar == '\\') {
                        ip++;
                        nextChar = ip < NP ? pattern.charAt(ip) : 0;
                    }
                    do {
                        if (match.charAt(im) == nextChar) {
                            break;
                        }
                        im++;
                    } while (im < NM);
                    if (im == NM) {
                        return false;
                    }
                    ip++;
                    nextChar = ip < NP ? pattern.charAt(ip) : 0;
                    im++;
                } else {
                    do {
                        if (match.charAt(im) != c) {
                            break;
                        }
                        im++;
                    } while (im < NM);
                    ip++;
                    nextChar = ip < NP ? pattern.charAt(ip) : 0;
                }
            } else {
                if (c != '.' && match.charAt(im) != c) return false;
                im++;
            }
        }
        if (ip >= NP && im >= NM) {
            return true;
        }
        if (ip == NP-2 && pattern.charAt(ip) == '.'
            && pattern.charAt(ip+1) == '*') {
            return true;
        }
        return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.910 -0400", hash_original_field = "846508075A47A0249E4AF0D6CF0B227F", hash_generated_field = "88FD9CAFD6BAA31BED99FDC6C75F201F")

    public static final int PATTERN_LITERAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.910 -0400", hash_original_field = "25CDA0FD4C9A3DB1C2F9075568A3775B", hash_generated_field = "AD9FE4CF9D9159CCE6CCF13FBDDA10E9")

    public static final int PATTERN_PREFIX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.910 -0400", hash_original_field = "C1C7B1BB5FCAA2A73B2703E637C2FEDE", hash_generated_field = "DCA7FDC47426EB3AC212F1972B5D2FF5")

    public static final int PATTERN_SIMPLE_GLOB = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.910 -0400", hash_original_field = "AF10CCA919E83B7FE09F2ADC78079C25", hash_generated_field = "67838E58B9F5097A89987486B2279E8E")

    public static final Parcelable.Creator<PatternMatcher> CREATOR
            = new Parcelable.Creator<PatternMatcher>() {
        public PatternMatcher createFromParcel(Parcel source) {
            return new PatternMatcher(source);
        }

        public PatternMatcher[] newArray(int size) {
            return new PatternMatcher[size];
        }
    };
    
    public PatternMatcher createFromParcel(Parcel source) {
            return new PatternMatcher(source);
        }
    
    
    public PatternMatcher[] newArray(int size) {
            return new PatternMatcher[size];
        }
    
}

