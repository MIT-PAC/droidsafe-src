package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PatternMatcher implements Parcelable {
    public static final int PATTERN_LITERAL = 0;
    public static final int PATTERN_PREFIX = 1;
    public static final int PATTERN_SIMPLE_GLOB = 2;
    private final String mPattern;
    private final int mType;
    public static final Parcelable.Creator<PatternMatcher> CREATOR = new Parcelable.Creator<PatternMatcher>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.832 -0400", hash_original_method = "FD3047E64A944595CFD464C3A36DC690", hash_generated_method = "24B6ABBD52ADC45FF56205C1099BBC6F")
        @DSModeled(DSC.SAFE)
        public PatternMatcher createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (PatternMatcher)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PatternMatcher(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.832 -0400", hash_original_method = "2D634B6780229A213F59B3C199AB2608", hash_generated_method = "7600CAA07414F6A72D75F6977291D4FF")
        @DSModeled(DSC.SAFE)
        public PatternMatcher[] newArray(int size) {
            dsTaint.addTaint(size);
            return (PatternMatcher[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PatternMatcher[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.832 -0400", hash_original_method = "1FC2431316C42DE0C3D46C9188020DE6", hash_generated_method = "C51416FEA309C3412A1935BF20FB4696")
    @DSModeled(DSC.SAFE)
    public PatternMatcher(String pattern, int type) {
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //mPattern = pattern;
        //mType = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.832 -0400", hash_original_method = "B901ADD56C5DD849BD7E8046FFB1F0D3", hash_generated_method = "29BDB0A688D543F89BF9FF97535B8EA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PatternMatcher(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mPattern = src.readString();
        mType = src.readInt();
        // ---------- Original Method ----------
        //mPattern = src.readString();
        //mType = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.832 -0400", hash_original_method = "05EB8C992FD149B44BBE0FC11E651762", hash_generated_method = "CFE9E015437130F669CECA05F4617618")
    @DSModeled(DSC.SAFE)
    public final String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.832 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "FFB2856D71D1F01B7B0011C3288182C3")
    @DSModeled(DSC.SAFE)
    public final int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.833 -0400", hash_original_method = "62F8B077957CE70BF92EA7EF3ACCE61D", hash_generated_method = "5F0C5A2CE68D1DB6512CFBB733924A97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(String str) {
        dsTaint.addTaint(str);
        boolean var2306B6FCBFA5915874A27ADE8981E3F6_1245916833 = (matchPattern(mPattern, str, mType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return matchPattern(mPattern, str, mType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.833 -0400", hash_original_method = "4D68435646F5279408D2A4F2A408DED4", hash_generated_method = "8F182C5A7A6EF1AAD8D4C0AFE789C7C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.833 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.833 -0400", hash_original_method = "ECBD3AB9E3B58368B577D8D9D90A2091", hash_generated_method = "6F93CD83C90B557669E8200EC723772F")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeString(mPattern);
        dest.writeInt(mType);
        // ---------- Original Method ----------
        //dest.writeString(mPattern);
        //dest.writeInt(mType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.833 -0400", hash_original_method = "0DACC851FA271C064A5A12BE9D7B9A0B", hash_generated_method = "16ABD1CACC50AD7C2A6C15813AFB901F")
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

    
}


