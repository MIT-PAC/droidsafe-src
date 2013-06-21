package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PatternMatcher implements Parcelable {
    private String mPattern;
    private int mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.045 -0400", hash_original_method = "1FC2431316C42DE0C3D46C9188020DE6", hash_generated_method = "2AA56E511247CA273DEAAD3A8ED93EDE")
    @DSModeled(DSC.SAFE)
    public PatternMatcher(String pattern, int type) {
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //mPattern = pattern;
        //mType = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.045 -0400", hash_original_method = "B901ADD56C5DD849BD7E8046FFB1F0D3", hash_generated_method = "D12CE00D835A9F9863423D620892B84C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PatternMatcher(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mPattern = src.readString();
        mType = src.readInt();
        // ---------- Original Method ----------
        //mPattern = src.readString();
        //mType = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.046 -0400", hash_original_method = "05EB8C992FD149B44BBE0FC11E651762", hash_generated_method = "D6DE707F064BB23BE1E4F97D058A0114")
    @DSModeled(DSC.SAFE)
    public final String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.046 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "BDF02A7D2D67ED47E04F6529F8A62816")
    @DSModeled(DSC.SAFE)
    public final int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.046 -0400", hash_original_method = "62F8B077957CE70BF92EA7EF3ACCE61D", hash_generated_method = "BF5E23DBC85ED80FEB464E554A67DDE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(String str) {
        dsTaint.addTaint(str);
        boolean var2306B6FCBFA5915874A27ADE8981E3F6_1497235839 = (matchPattern(mPattern, str, mType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return matchPattern(mPattern, str, mType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.046 -0400", hash_original_method = "4D68435646F5279408D2A4F2A408DED4", hash_generated_method = "4ECD7F5E7C3602938C634F3305D92D15")
    @DSModeled(DSC.SAFE)
    public String toString() {
        String type;
        type = "? ";
        //Begin case PATTERN_LITERAL 
        type = "LITERAL: ";
        //End case PATTERN_LITERAL 
        //Begin case PATTERN_PREFIX 
        type = "PREFIX: ";
        //End case PATTERN_PREFIX 
        //Begin case PATTERN_SIMPLE_GLOB 
        type = "GLOB: ";
        //End case PATTERN_SIMPLE_GLOB 
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String type = "? ";
        //switch (mType) {
            //case PATTERN_LITERAL:
                //type = "LITERAL: ";
                //break;
            //case PATTERN_PREFIX:
                //type = "PREFIX: ";
                //break;
            //case PATTERN_SIMPLE_GLOB:
                //type = "GLOB: ";
                //break;
        //}
        //return "PatternMatcher{" + type + mPattern + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.047 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.047 -0400", hash_original_method = "ECBD3AB9E3B58368B577D8D9D90A2091", hash_generated_method = "4A6FF776C5C022D001CF4B3DBD23135B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mPattern);
        dest.writeInt(mType);
        // ---------- Original Method ----------
        //dest.writeString(mPattern);
        //dest.writeInt(mType);
    }

    
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

    
    public static final int PATTERN_LITERAL = 0;
    public static final int PATTERN_PREFIX = 1;
    public static final int PATTERN_SIMPLE_GLOB = 2;
    public static final Parcelable.Creator<PatternMatcher> CREATOR = new Parcelable.Creator<PatternMatcher>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.047 -0400", hash_original_method = "FD3047E64A944595CFD464C3A36DC690", hash_generated_method = "CA298F897552F7B8F4E19D3269CF46C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PatternMatcher createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            PatternMatcher var9C67BC4002AC526CCB3E92FCFD912BF2_782658283 = (new PatternMatcher(source));
            return (PatternMatcher)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PatternMatcher(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.048 -0400", hash_original_method = "2D634B6780229A213F59B3C199AB2608", hash_generated_method = "6FAFFF07F7E87B2D71FA8333E0CA6FB1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PatternMatcher[] newArray(int size) {
            dsTaint.addTaint(size);
            PatternMatcher[] varD564E1704F59542BF21CD7157EF4F2F3_2126719193 = (new PatternMatcher[size]);
            return (PatternMatcher[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PatternMatcher[size];
        }

        
}; //Transformed anonymous class
}

