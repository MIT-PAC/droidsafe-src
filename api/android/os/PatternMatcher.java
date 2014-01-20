package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class PatternMatcher implements Parcelable {
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.381 -0500", hash_original_method = "0DACC851FA271C064A5A12BE9D7B9A0B", hash_generated_method = "E4A178A455D5F4EC8C76C9D0D71455CB")
    
static boolean matchPattern(String pattern, String match, int type) {
        if (match == null) return false;
        if (type == PATTERN_LITERAL) {
            return pattern.equals(match);
        } if (type == PATTERN_PREFIX) {
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
                        // at the end with a pattern match, so
                        // all is good without checking!
                        return true;
                    }
                    ip++;
                    nextChar = pattern.charAt(ip);
                    // Consume everything until the next character in the
                    // pattern is found.
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
                        // Whoops, the next character in the pattern didn't
                        // exist in the match.
                        return false;
                    }
                    ip++;
                    nextChar = ip < NP ? pattern.charAt(ip) : 0;
                    im++;
                } else {
                    // Consume only characters matching the one before '*'.
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
            // Reached the end of both strings, all is good!
            return true;
        }
        
        // One last check: we may have finished the match string, but still
        // have a '.*' at the end of the pattern, which should still count
        // as a match.
        if (ip == NP-2 && pattern.charAt(ip) == '.'
            && pattern.charAt(ip+1) == '*') {
            return true;
        }
        
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.342 -0500", hash_original_field = "5D1D7C326F36BC145B5E45422E0F494F", hash_generated_field = "88FD9CAFD6BAA31BED99FDC6C75F201F")

    public static final int PATTERN_LITERAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.345 -0500", hash_original_field = "B1C5AB05971A546D19930A544157B830", hash_generated_field = "AD9FE4CF9D9159CCE6CCF13FBDDA10E9")

    public static final int PATTERN_PREFIX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.347 -0500", hash_original_field = "A15DEA3CB6746A4118C1E764BE98FF8E", hash_generated_field = "DCA7FDC47426EB3AC212F1972B5D2FF5")

    public static final int PATTERN_SIMPLE_GLOB = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.208 -0400", hash_original_field = "AF10CCA919E83B7FE09F2ADC78079C25", hash_generated_field = "67838E58B9F5097A89987486B2279E8E")

    public static final Parcelable.Creator<PatternMatcher> CREATOR
            = new Parcelable.Creator<PatternMatcher>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.373 -0500", hash_original_method = "FD3047E64A944595CFD464C3A36DC690", hash_generated_method = "2A939E89149C05B7DDC26C0EF7DEBCB1")
        
public PatternMatcher createFromParcel(Parcel source) {
            return new PatternMatcher(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.376 -0500", hash_original_method = "2D634B6780229A213F59B3C199AB2608", hash_generated_method = "C8A4A562E27286D3F9EF48EA90345EEA")
        
public PatternMatcher[] newArray(int size) {
            return new PatternMatcher[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.349 -0500", hash_original_field = "321647A6112621E87F809E4508D12401", hash_generated_field = "3CD87C11C7A58085FB84E25F889274B8")
    
    private  String mPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.352 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private  int mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.354 -0500", hash_original_method = "1FC2431316C42DE0C3D46C9188020DE6", hash_generated_method = "F601521677CE36FC91C3778E01E51E0C")
    
public PatternMatcher(String pattern, int type) {
        mPattern = pattern;
        mType = type;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.370 -0500", hash_original_method = "B901ADD56C5DD849BD7E8046FFB1F0D3", hash_generated_method = "C5F8DEE2EB1178FFE35B3121EE1B5D6E")
    
public PatternMatcher(Parcel src) {
        mPattern = src.readString();
        mType = src.readInt();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.356 -0500", hash_original_method = "05EB8C992FD149B44BBE0FC11E651762", hash_generated_method = "CD24450B41F8C51C8EDB097A7D2BA07A")
    
public final String getPath() {
        return mPattern;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.359 -0500", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "C3B6FFD7CB013DE0A3DF1A9A4C66A54A")
    
public final int getType() {
        return mType;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.361 -0500", hash_original_method = "62F8B077957CE70BF92EA7EF3ACCE61D", hash_generated_method = "B983538E39EFD5A045C0B7BCAC2EA3A8")
    
public boolean match(String str) {
        return matchPattern(mPattern, str, mType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.363 -0500", hash_original_method = "4D68435646F5279408D2A4F2A408DED4", hash_generated_method = "757F4636B2E1DD790C8287C7BC15C9D2")
    
public String toString() {
        String type = "? ";
        switch (mType) {
            case PATTERN_LITERAL:
                type = "LITERAL: ";
                break;
            case PATTERN_PREFIX:
                type = "PREFIX: ";
                break;
            case PATTERN_SIMPLE_GLOB:
                type = "GLOB: ";
                break;
        }
        return "PatternMatcher{" + type + mPattern + "}";
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.365 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.367 -0500", hash_original_method = "ECBD3AB9E3B58368B577D8D9D90A2091", hash_generated_method = "72FDFA96E430C045EBD67255F75C94F2")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPattern);
        dest.writeInt(mType);
    }
    // orphaned legacy method
    public PatternMatcher createFromParcel(Parcel source) {
            return new PatternMatcher(source);
        }
    
    // orphaned legacy method
    public PatternMatcher[] newArray(int size) {
            return new PatternMatcher[size];
        }
    
}

