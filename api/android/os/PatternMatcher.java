package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;





public class PatternMatcher implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.204 -0400", hash_original_field = "22A7D0E705563AC4D94E2656C1D970BF", hash_generated_field = "3CD87C11C7A58085FB84E25F889274B8")

    private String mPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.204 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.204 -0400", hash_original_method = "1FC2431316C42DE0C3D46C9188020DE6", hash_generated_method = "ADF085B19B9D41C3062DF9AA7E715C4A")
    public  PatternMatcher(String pattern, int type) {
        mPattern = pattern;
        mType = type;
        // ---------- Original Method ----------
        //mPattern = pattern;
        //mType = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.205 -0400", hash_original_method = "B901ADD56C5DD849BD7E8046FFB1F0D3", hash_generated_method = "AB26A796A7240D0D0FFF39F49D23E776")
    public  PatternMatcher(Parcel src) {
        mPattern = src.readString();
        mType = src.readInt();
        // ---------- Original Method ----------
        //mPattern = src.readString();
        //mType = src.readInt();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.205 -0400", hash_original_method = "05EB8C992FD149B44BBE0FC11E651762", hash_generated_method = "F54E82E33F2F3A03189BCC245CAED0CA")
    public final String getPath() {
String var85927E281577E5F9975F9E6243687DB0_1377151234 =         mPattern;
        var85927E281577E5F9975F9E6243687DB0_1377151234.addTaint(taint);
        return var85927E281577E5F9975F9E6243687DB0_1377151234;
        // ---------- Original Method ----------
        //return mPattern;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.205 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "881AD40BC52185D27F73388BC9772507")
    public final int getType() {
        int var3462A1A18A0EE070E8953CCF1DD788C0_1028498385 = (mType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897223421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897223421;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.206 -0400", hash_original_method = "62F8B077957CE70BF92EA7EF3ACCE61D", hash_generated_method = "67E5A20A23EE3C08DE19423022EE5700")
    public boolean match(String str) {
        addTaint(str.getTaint());
        boolean var180517933D62CEFA77B5C6C3FDCF3B9D_1125261524 = (matchPattern(mPattern, str, mType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461205205 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461205205;
        // ---------- Original Method ----------
        //return matchPattern(mPattern, str, mType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.207 -0400", hash_original_method = "4D68435646F5279408D2A4F2A408DED4", hash_generated_method = "3472B534F0D59E6168B1685FB1E58E23")
    public String toString() {
        String type = "? ";
switch(mType){
        case PATTERN_LITERAL:
        type = "LITERAL: ";
        break;
        case PATTERN_PREFIX:
        type = "PREFIX: ";
        break;
        case PATTERN_SIMPLE_GLOB:
        type = "GLOB: ";
        break;
}String var160283AB18459AF9E5F227D40E26F553_2058945782 =         "PatternMatcher{" + type + mPattern + "}";
        var160283AB18459AF9E5F227D40E26F553_2058945782.addTaint(taint);
        return var160283AB18459AF9E5F227D40E26F553_2058945782;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.207 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B86BD33CEDEC1FE30AFAE5D85336FD2F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1300907082 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740921696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740921696;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.208 -0400", hash_original_method = "ECBD3AB9E3B58368B577D8D9D90A2091", hash_generated_method = "206F045DFB06520644580040D8B26221")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mPattern);
        dest.writeInt(mType);
        // ---------- Original Method ----------
        //dest.writeString(mPattern);
        //dest.writeInt(mType);
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.208 -0400", hash_original_field = "846508075A47A0249E4AF0D6CF0B227F", hash_generated_field = "88FD9CAFD6BAA31BED99FDC6C75F201F")

    public static final int PATTERN_LITERAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.208 -0400", hash_original_field = "25CDA0FD4C9A3DB1C2F9075568A3775B", hash_generated_field = "AD9FE4CF9D9159CCE6CCF13FBDDA10E9")

    public static final int PATTERN_PREFIX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.208 -0400", hash_original_field = "C1C7B1BB5FCAA2A73B2703E637C2FEDE", hash_generated_field = "DCA7FDC47426EB3AC212F1972B5D2FF5")

    public static final int PATTERN_SIMPLE_GLOB = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.208 -0400", hash_original_field = "AF10CCA919E83B7FE09F2ADC78079C25", hash_generated_field = "67838E58B9F5097A89987486B2279E8E")

    public static final Parcelable.Creator<PatternMatcher> CREATOR
            = new Parcelable.Creator<PatternMatcher>() {
        public PatternMatcher createFromParcel(Parcel source) {
            return new PatternMatcher(source);
        }

        @DSModeled(DSC.SAFE)
        public PatternMatcher[] newArray(int size) {
            return new PatternMatcher[size];
        }
    };
    // orphaned legacy method
    public PatternMatcher createFromParcel(Parcel source) {
            return new PatternMatcher(source);
        }
    
    // orphaned legacy method
    public PatternMatcher[] newArray(int size) {
            return new PatternMatcher[size];
        }
    
}

