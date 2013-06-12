package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class Matcher implements MatchResult {
    private Pattern pattern;
    private int address;
    private String input;
    private int regionStart;
    private int regionEnd;
    private int findPos;
    private int appendPos;
    private boolean matchFound;
    private int[] matchOffsets;
    private boolean anchoringBounds = true;
    private boolean transparentBounds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.828 -0400", hash_original_method = "3CAF328B13970C51C4DF071BCDFD21EA", hash_generated_method = "339773AC627FD341FF693128CD149103")
    @DSModeled(DSC.SAFE)
     Matcher(Pattern pattern, CharSequence input) {
        dsTaint.addTaint(input);
        dsTaint.addTaint(pattern.dsTaint);
        usePattern(pattern);
        reset(input);
        // ---------- Original Method ----------
        //usePattern(pattern);
        //reset(input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.828 -0400", hash_original_method = "0ABA3494B4138038176605DE83A643DA", hash_generated_method = "7521103F342DFC978B1107C0D45DC6D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher appendReplacement(StringBuffer buffer, String replacement) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(replacement);
        buffer.append(input.substring(appendPos, start()));
        appendEvaluated(buffer, replacement);
        appendPos = end();
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //buffer.append(input.substring(appendPos, start()));
        //appendEvaluated(buffer, replacement);
        //appendPos = end();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.828 -0400", hash_original_method = "5B3F4DCDB18701B7EDED77C3B9D3C550", hash_generated_method = "106AF94CF762730CA87E0A81EF7D2025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendEvaluated(StringBuffer buffer, String s) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(s);
        boolean escape;
        escape = false;
        boolean dollar;
        dollar = false;
        {
            int i;
            i = 0;
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_717976959 = (i < s.length());
            {
                char c;
                c = s.charAt(i);
                {
                    escape = true;
                } //End block
                {
                    dollar = true;
                } //End block
                {
                    buffer.append(group(c - '0'));
                    dollar = false;
                } //End block
                {
                    buffer.append(c);
                    dollar = false;
                    escape = false;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            throw new ArrayIndexOutOfBoundsException(s.length());
        } //End block
        // ---------- Original Method ----------
        //boolean escape = false;
        //boolean dollar = false;
        //for (int i = 0; i < s.length(); i++) {
            //char c = s.charAt(i);
            //if (c == '\\' && !escape) {
                //escape = true;
            //} else if (c == '$' && !escape) {
                //dollar = true;
            //} else if (c >= '0' && c <= '9' && dollar) {
                //buffer.append(group(c - '0'));
                //dollar = false;
            //} else {
                //buffer.append(c);
                //dollar = false;
                //escape = false;
            //}
        //}
        //if (escape) {
            //throw new ArrayIndexOutOfBoundsException(s.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "9AD9707639C16EE18626C91A471BEAF6", hash_generated_method = "C0FCA1D2DBEE2005C486950791A1ED9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher reset() {
        Matcher var786EEC8BB8C4AD8883A19B3AA2EEBEE4_1205939549 = (reset(input, 0, input.length()));
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reset(input, 0, input.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "6A88D6B012E13AB6428E01867B9DB072", hash_generated_method = "7FDEC75833E52B9A5DE1CF7257949C11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher reset(CharSequence input) {
        dsTaint.addTaint(input);
        Matcher var786EEC8BB8C4AD8883A19B3AA2EEBEE4_899198927 = (reset(input, 0, input.length()));
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reset(input, 0, input.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "1E13D8D8B85E56AF9BB58282CB9C7392", hash_generated_method = "4F88AD8CFB608303120021A75BD30E81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Matcher reset(CharSequence input, int start, int end) {
        dsTaint.addTaint(input);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            throw new IllegalArgumentException();
        } //End block
        {
            boolean varF45ABFE6077AFC8486D01968E44A911F_1956841548 = (start < 0 || end < 0 || start > input.length() || end > input.length() || start > end);
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        this.input = input.toString();
        resetForInput();
        matchFound = false;
        findPos = regionStart;
        appendPos = 0;
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (input == null) {
            //throw new IllegalArgumentException();
        //}
        //if (start < 0 || end < 0 || start > input.length() || end > input.length() || start > end) {
            //throw new IndexOutOfBoundsException();
        //}
        //this.input = input.toString();
        //this.regionStart = start;
        //this.regionEnd = end;
        //resetForInput();
        //matchFound = false;
        //findPos = regionStart;
        //appendPos = 0;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "2FE41CFA985CF6A9EFE2D0795A2797F8", hash_generated_method = "E1A96B997B88498C597C32D31F146D30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher usePattern(Pattern pattern) {
        dsTaint.addTaint(pattern.dsTaint);
        {
            throw new IllegalArgumentException();
        } //End block
        {
            closeImpl(address);
            address = 0;
        } //End block
        address = openImpl(pattern.address);
        {
            resetForInput();
        } //End block
        matchOffsets = new int[(groupCount() + 1) * 2];
        matchFound = false;
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (pattern == null) {
            //throw new IllegalArgumentException();
        //}
        //this.pattern = pattern;
        //if (address != 0) {
            //closeImpl(address);
            //address = 0;
        //}
        //address = openImpl(pattern.address);
        //if (input != null) {
            //resetForInput();
        //}
        //matchOffsets = new int[(groupCount() + 1) * 2];
        //matchFound = false;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "4B8F5281B8D449CBFD7748E2AB98FC6B", hash_generated_method = "78E805464F58820CBB73458526431B9F")
    @DSModeled(DSC.SAFE)
    private void resetForInput() {
        setInputImpl(address, input, regionStart, regionEnd);
        useAnchoringBoundsImpl(address, anchoringBounds);
        useTransparentBoundsImpl(address, transparentBounds);
        // ---------- Original Method ----------
        //setInputImpl(address, input, regionStart, regionEnd);
        //useAnchoringBoundsImpl(address, anchoringBounds);
        //useTransparentBoundsImpl(address, transparentBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "764159AB96CDD9290AC2E4282412C52D", hash_generated_method = "8BD0796C0F181C3764BCC9B5EADA4D0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher region(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        Matcher var45E6DF79F583FDFE6BCCE9DBA0C6E3B9_945270861 = (reset(input, start, end));
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reset(input, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "26B8601C4A947AF0FE4D833433D4DFA4", hash_generated_method = "7959071E6F57FDE1002150590A12C391")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer appendTail(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            buffer.append(input.substring(appendPos, regionEnd));
        } //End block
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (appendPos < regionEnd) {
            //buffer.append(input.substring(appendPos, regionEnd));
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "902CB288EB494C9205FE6BF90EDE4AF5", hash_generated_method = "095B00D743889EA52D89235419750F29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replaceFirst(String replacement) {
        dsTaint.addTaint(replacement);
        reset();
        StringBuffer buffer;
        buffer = new StringBuffer(input.length());
        {
            boolean var73BA7AA75A06BCD20094DC5116547A45_1145117970 = (find());
            {
                appendReplacement(buffer, replacement);
            } //End block
        } //End collapsed parenthetic
        String varDF69153FCCBB40C11762D99C87E1CEC6_2130294744 = (appendTail(buffer).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //reset();
        //StringBuffer buffer = new StringBuffer(input.length());
        //if (find()) {
            //appendReplacement(buffer, replacement);
        //}
        //return appendTail(buffer).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "DCC3E518C2D0EED9BFA3E6DD970895A0", hash_generated_method = "3D9FC5807088931AA5C6B8325660DAE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replaceAll(String replacement) {
        dsTaint.addTaint(replacement);
        reset();
        StringBuffer buffer;
        buffer = new StringBuffer(input.length());
        {
            boolean var73BA7AA75A06BCD20094DC5116547A45_232636735 = (find());
            {
                appendReplacement(buffer, replacement);
            } //End block
        } //End collapsed parenthetic
        String varDF69153FCCBB40C11762D99C87E1CEC6_1336535909 = (appendTail(buffer).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //reset();
        //StringBuffer buffer = new StringBuffer(input.length());
        //while (find()) {
            //appendReplacement(buffer, replacement);
        //}
        //return appendTail(buffer).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "29D81214171EEBB46568323FF70F06B8", hash_generated_method = "C8C590F7363800BF2D9B84E41B8351E6")
    @DSModeled(DSC.SAFE)
    public Pattern pattern() {
        return (Pattern)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.829 -0400", hash_original_method = "C5DB0A67F29696168A3714469C702630", hash_generated_method = "A49415F255CA70525B94AB14132DE2EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String group(int group) {
        dsTaint.addTaint(group);
        ensureMatch();
        int from;
        from = matchOffsets[group * 2];
        int to;
        to = matchOffsets[(group * 2) + 1];
        {
            String varB5348ECC6624AA52713DA921484DB5DF_782708972 = (input.substring(from, to));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //ensureMatch();
        //int from = matchOffsets[group * 2];
        //int to = matchOffsets[(group * 2) + 1];
        //if (from == -1 || to == -1) {
            //return null;
        //} else {
            //return input.substring(from, to);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "B66B9D5A22E4810AC45D3DC362BC1AC2", hash_generated_method = "CE5A1AA981DD9CAD18D92B24A1942C71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String group() {
        String var857AB1546D93CF982ED5AA004A46D7AE_1147363001 = (group(0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return group(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "1E0A41464CCCF143B80A589A774A22D2", hash_generated_method = "0901315EB908969780B56D99DF5497D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean find(int start) {
        dsTaint.addTaint(start);
        {
            findPos = regionStart;
        } //End block
        {
            matchFound = false;
        } //End block
        matchFound = findImpl(address, input, findPos, matchOffsets);
        {
            findPos = matchOffsets[1];
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //findPos = start;
        //if (findPos < regionStart) {
            //findPos = regionStart;
        //} else if (findPos >= regionEnd) {
            //matchFound = false;
            //return false;
        //}
        //matchFound = findImpl(address, input, findPos, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "B9818686B652967984036901E54AA9CC", hash_generated_method = "3BFF63A4520B152B3ECE4111C445273D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean find() {
        matchFound = findNextImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //matchFound = findNextImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "97077CE30676723FC89EE7203F75639E", hash_generated_method = "6FD0B189B366F687743FFC2F18AA6B0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean lookingAt() {
        matchFound = lookingAtImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //matchFound = lookingAtImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "F2B231DFAE39F525F974692AFF77961B", hash_generated_method = "E522AB523ABA527FFCBDF6229E1CEE15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean matches() {
        matchFound = matchesImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //matchFound = matchesImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "AB3FAB8AD474566DF13ED737E690D125", hash_generated_method = "13391268A33269AF01095334F3DE439C")
    @DSModeled(DSC.SAFE)
    public int start(int group) throws IllegalStateException {
        dsTaint.addTaint(group);
        ensureMatch();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ensureMatch();
        //return matchOffsets[group * 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "3B2B065B47272EA82FEECDA7C28418A1", hash_generated_method = "67D5D124FAB3BA618C04AFC7884C438E")
    @DSModeled(DSC.SAFE)
    public int end(int group) {
        dsTaint.addTaint(group);
        ensureMatch();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ensureMatch();
        //return matchOffsets[(group * 2) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "412B90C2E6660CBD34B9FCD7AA411423", hash_generated_method = "5C0A490BD2CE9B2C5AFFFA4AB2680065")
    public static String quoteReplacement(String s) {
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' || c == '$') {
                result.append('\\');
            }
            result.append(c);
        }
        return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "C6A6712F9AEB3BF816CFB3B69A2CBBBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int start() {
        int var2FA5FC50CE2538BDC8E886B2AA7A2178_1637287923 = (start(0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return start(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "2C579AC6636E2BB6A85949F583F18EF9", hash_generated_method = "F0C6FA88CE58945E602A1288E0A18581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int groupCount() {
        int varE3909558008410CE21184D2303B66659_1227120570 = (groupCountImpl(address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return groupCountImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "2E55C3DA8CFB59CA70DDCBB2E46B90EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int end() {
        int varD085614B73328778F16C47DE2FECFC57_1707761024 = (end(0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return end(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "AA5E91AED2A0230E676820BFF0A777EF", hash_generated_method = "E425DA03BA366C02C4BA5AF8A4F01E45")
    @DSModeled(DSC.SAFE)
    public MatchResult toMatchResult() {
        ensureMatch();
        return (MatchResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ensureMatch();
        //return new MatchResultImpl(input, matchOffsets);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "785D7AD880670D6D8A0DF6FCE0749ACB", hash_generated_method = "69C2419B682E413FCE580DD2E51EA6FC")
    @DSModeled(DSC.SAFE)
    public Matcher useAnchoringBounds(boolean value) {
        dsTaint.addTaint(value);
        useAnchoringBoundsImpl(address, value);
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //anchoringBounds = value;
        //useAnchoringBoundsImpl(address, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "56179EEEB1BB6D253C6C82DD4DB81ED5", hash_generated_method = "5865F6EEDDAE1A48CCBEA00C8A0BDFD8")
    @DSModeled(DSC.SAFE)
    public boolean hasAnchoringBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return anchoringBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "EB1ABBA9A1AC428A5376D92D0ECDDD75", hash_generated_method = "4F9778BBC6099AD22886D0A407DC8798")
    @DSModeled(DSC.SAFE)
    public Matcher useTransparentBounds(boolean value) {
        dsTaint.addTaint(value);
        useTransparentBoundsImpl(address, value);
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //transparentBounds = value;
        //useTransparentBoundsImpl(address, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "62DD7ED3C887DF9CAF781EDBA38B8A50", hash_generated_method = "E7D6B3B368CB4CA1C24EE6762801C40B")
    @DSModeled(DSC.SAFE)
    private void ensureMatch() {
        {
            throw new IllegalStateException("No successful match so far");
        } //End block
        // ---------- Original Method ----------
        //if (!matchFound) {
            //throw new IllegalStateException("No successful match so far");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "935CF82B5FBC95B795356ABD430E53CE", hash_generated_method = "05E3A19B2629D8EF6804844C0A0A4F4C")
    @DSModeled(DSC.SAFE)
    public boolean hasTransparentBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return transparentBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "1309D9DA3902B8EF77EAE3BBEDE0D6E3", hash_generated_method = "EAB6C8F1B78A62FB33FA2D0F5D72F665")
    @DSModeled(DSC.SAFE)
    public int regionStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return regionStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "A2DEE293E79DD1E070648045D7A01545", hash_generated_method = "07DF32F61C1E6471C88FB44C921FD7C9")
    @DSModeled(DSC.SAFE)
    public int regionEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return regionEnd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.830 -0400", hash_original_method = "6469C197EE58C69EE809CEC9FEDF2877", hash_generated_method = "6BBD43976A7E3237733BE1C3529AFD38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requireEnd() {
        boolean varEF751A2F8A30FD1B90C84328A8A15FD6_1648636202 = (requireEndImpl(address));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return requireEndImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "EDB1A66CB81652E7B35BD52D60EF4E40", hash_generated_method = "2072DA78FE0D7F4CD2CE0D7EDEA8F95F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hitEnd() {
        boolean var465B0EDCB419577F061CD4A8EF4B39F7_1322340583 = (hitEndImpl(address));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hitEndImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "2423E3A5A529212650FA426A2F677B91")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            closeImpl(address);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //closeImpl(address);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "8263343A665FA522ECFED6CB0D912EAE", hash_generated_method = "480897A941524788AA53F14F2C01EA79")
    private static void closeImpl(int addr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "B35927168ACDF7C6B617448B272CFF2F", hash_generated_method = "0E5B54ADA07B2467BAEA0401816EE948")
    private static boolean findImpl(int addr, String s, int startIndex, int[] offsets) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "067920F508FBCD0FE2317859B6E02CE6", hash_generated_method = "EE75AFA416373AD2B6E58575B8320087")
    private static boolean findNextImpl(int addr, String s, int[] offsets) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "0FF144F28DF58E989ACEE8E7F2D13267", hash_generated_method = "B7000C01D9E493070025B4D4DCD99455")
    private static int groupCountImpl(int addr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "D37FBC9FB276806800533F7152C11EF0", hash_generated_method = "DDB9B915F7FA6D0DE5E464C2AB5FB7C2")
    private static boolean hitEndImpl(int addr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "DBCD37C1EFC9DB8BCA0AAD758A7DACED", hash_generated_method = "4192AE09DA78FAED230B2414C0EBB22E")
    private static boolean lookingAtImpl(int addr, String s, int[] offsets) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "41173AC5E67BEEB9B9B9FB9172D07E09", hash_generated_method = "E51A3FCEACF1233ECDF8C156781A73EA")
    private static boolean matchesImpl(int addr, String s, int[] offsets) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "8B10D8BDCB5EABFC66CBA8B87C308838", hash_generated_method = "54936B53A777E68F38F3A6D23FFC735B")
    private static int openImpl(int patternAddr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "B51C121430CA5D9A1122C4F358C9B582", hash_generated_method = "4C3ECE13AD686D511F890F5F56662A98")
    private static boolean requireEndImpl(int addr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "ED90620D3881EF70B8DAAFBE90928048", hash_generated_method = "12124144D040DBA09245EF0A56385D36")
    private static void setInputImpl(int addr, String s, int start, int end) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "8D3342C74FD173C603516D913A30EE14", hash_generated_method = "263242D9B300E038E3D7CFF170BC00B1")
    private static void useAnchoringBoundsImpl(int addr, boolean value) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.831 -0400", hash_original_method = "865D45101F233A70ED8D04CDCF847E6D", hash_generated_method = "93E12085695B95E1F9E4F8D3EE23CCC0")
    private static void useTransparentBoundsImpl(int addr, boolean value) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


