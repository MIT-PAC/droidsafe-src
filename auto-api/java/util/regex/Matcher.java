package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.649 -0400", hash_original_method = "3CAF328B13970C51C4DF071BCDFD21EA", hash_generated_method = "146E5FBA614A7ECEF29B59F9736C75D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Matcher(Pattern pattern, CharSequence input) {
        dsTaint.addTaint(input);
        dsTaint.addTaint(pattern.dsTaint);
        usePattern(pattern);
        reset(input);
        // ---------- Original Method ----------
        //usePattern(pattern);
        //reset(input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.649 -0400", hash_original_method = "0ABA3494B4138038176605DE83A643DA", hash_generated_method = "9B5FA37FBDB614F5CEA76C8113E510C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.650 -0400", hash_original_method = "5B3F4DCDB18701B7EDED77C3B9D3C550", hash_generated_method = "632B5750C561A2C2E6D9AB47273C8BAB")
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
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_1285482853 = (i < s.length());
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
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException(s.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.650 -0400", hash_original_method = "9AD9707639C16EE18626C91A471BEAF6", hash_generated_method = "03CEA1C2368D797644F8F221E0567490")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher reset() {
        Matcher var786EEC8BB8C4AD8883A19B3AA2EEBEE4_1896164571 = (reset(input, 0, input.length()));
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reset(input, 0, input.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.651 -0400", hash_original_method = "6A88D6B012E13AB6428E01867B9DB072", hash_generated_method = "D790AC1760B5A530715306BE2D8EA58A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher reset(CharSequence input) {
        dsTaint.addTaint(input);
        Matcher var786EEC8BB8C4AD8883A19B3AA2EEBEE4_2085866165 = (reset(input, 0, input.length()));
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reset(input, 0, input.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.651 -0400", hash_original_method = "1E13D8D8B85E56AF9BB58282CB9C7392", hash_generated_method = "8C4A6BF2D145610BAC1225BEEA77254F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Matcher reset(CharSequence input, int start, int end) {
        dsTaint.addTaint(input);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            boolean varF45ABFE6077AFC8486D01968E44A911F_382920728 = (start < 0 || end < 0 || start > input.length() || end > input.length() || start > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.652 -0400", hash_original_method = "2FE41CFA985CF6A9EFE2D0795A2797F8", hash_generated_method = "A663085BEC862D8FD21EC553B9D63397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher usePattern(Pattern pattern) {
        dsTaint.addTaint(pattern.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.652 -0400", hash_original_method = "4B8F5281B8D449CBFD7748E2AB98FC6B", hash_generated_method = "7103FCDC0C3502E02876C3BCAF9A118B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetForInput() {
        setInputImpl(address, input, regionStart, regionEnd);
        useAnchoringBoundsImpl(address, anchoringBounds);
        useTransparentBoundsImpl(address, transparentBounds);
        // ---------- Original Method ----------
        //setInputImpl(address, input, regionStart, regionEnd);
        //useAnchoringBoundsImpl(address, anchoringBounds);
        //useTransparentBoundsImpl(address, transparentBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.652 -0400", hash_original_method = "764159AB96CDD9290AC2E4282412C52D", hash_generated_method = "579A892BE9D942AE62D1C2CFAE07A83E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher region(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        Matcher var45E6DF79F583FDFE6BCCE9DBA0C6E3B9_521392573 = (reset(input, start, end));
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reset(input, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.652 -0400", hash_original_method = "26B8601C4A947AF0FE4D833433D4DFA4", hash_generated_method = "57F2FDD1D410C84C26A4DF04DFFA68FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.653 -0400", hash_original_method = "902CB288EB494C9205FE6BF90EDE4AF5", hash_generated_method = "CB7A906CCEA7600F8B24E7228C15367F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replaceFirst(String replacement) {
        dsTaint.addTaint(replacement);
        reset();
        StringBuffer buffer;
        buffer = new StringBuffer(input.length());
        {
            boolean var73BA7AA75A06BCD20094DC5116547A45_249472995 = (find());
            {
                appendReplacement(buffer, replacement);
            } //End block
        } //End collapsed parenthetic
        String varDF69153FCCBB40C11762D99C87E1CEC6_252330201 = (appendTail(buffer).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //reset();
        //StringBuffer buffer = new StringBuffer(input.length());
        //if (find()) {
            //appendReplacement(buffer, replacement);
        //}
        //return appendTail(buffer).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.653 -0400", hash_original_method = "DCC3E518C2D0EED9BFA3E6DD970895A0", hash_generated_method = "969CF6C769055073F7E75712D4F85ED5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replaceAll(String replacement) {
        dsTaint.addTaint(replacement);
        reset();
        StringBuffer buffer;
        buffer = new StringBuffer(input.length());
        {
            boolean var73BA7AA75A06BCD20094DC5116547A45_1162919402 = (find());
            {
                appendReplacement(buffer, replacement);
            } //End block
        } //End collapsed parenthetic
        String varDF69153FCCBB40C11762D99C87E1CEC6_1577640247 = (appendTail(buffer).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //reset();
        //StringBuffer buffer = new StringBuffer(input.length());
        //while (find()) {
            //appendReplacement(buffer, replacement);
        //}
        //return appendTail(buffer).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.653 -0400", hash_original_method = "29D81214171EEBB46568323FF70F06B8", hash_generated_method = "FA1F7C8E84951527024AFC45DD52FCE7")
    @DSModeled(DSC.SAFE)
    public Pattern pattern() {
        return (Pattern)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.653 -0400", hash_original_method = "C5DB0A67F29696168A3714469C702630", hash_generated_method = "A23E00BF60312809D5B0DF39944DBD80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String group(int group) {
        dsTaint.addTaint(group);
        ensureMatch();
        int from;
        from = matchOffsets[group * 2];
        int to;
        to = matchOffsets[(group * 2) + 1];
        {
            String varB5348ECC6624AA52713DA921484DB5DF_1666356917 = (input.substring(from, to));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.653 -0400", hash_original_method = "B66B9D5A22E4810AC45D3DC362BC1AC2", hash_generated_method = "F994AEFDF1157DF1EA84823C448AF358")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String group() {
        String var857AB1546D93CF982ED5AA004A46D7AE_685252892 = (group(0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return group(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.654 -0400", hash_original_method = "1E0A41464CCCF143B80A589A774A22D2", hash_generated_method = "E4694AA045E3F8D5E4304B9F3DFF1F47")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.654 -0400", hash_original_method = "B9818686B652967984036901E54AA9CC", hash_generated_method = "5CE5A87DBB002210E3C6D011ED06F5B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.654 -0400", hash_original_method = "97077CE30676723FC89EE7203F75639E", hash_generated_method = "678F8549D277023F08D4C83FD7C923D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.655 -0400", hash_original_method = "F2B231DFAE39F525F974692AFF77961B", hash_generated_method = "F014D74C7A7718FB6883687667158E22")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.655 -0400", hash_original_method = "AB3FAB8AD474566DF13ED737E690D125", hash_generated_method = "98B5A4F4D85FAA8C5A554B67DFE90CEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int start(int group) throws IllegalStateException {
        dsTaint.addTaint(group);
        ensureMatch();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ensureMatch();
        //return matchOffsets[group * 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.655 -0400", hash_original_method = "3B2B065B47272EA82FEECDA7C28418A1", hash_generated_method = "7F95A0CC5F3468EF71A86F6001AB5B39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int end(int group) {
        dsTaint.addTaint(group);
        ensureMatch();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ensureMatch();
        //return matchOffsets[(group * 2) + 1];
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.655 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "08E956429735CEA5E08E22136B886AC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int start() {
        int var2FA5FC50CE2538BDC8E886B2AA7A2178_44522515 = (start(0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return start(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.655 -0400", hash_original_method = "2C579AC6636E2BB6A85949F583F18EF9", hash_generated_method = "76D4ED3C0FCE4751D81A83B3421158B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int groupCount() {
        int varE3909558008410CE21184D2303B66659_765612008 = (groupCountImpl(address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return groupCountImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.655 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "E6981AB1242D77401AFB2610CC42CD3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int end() {
        int varD085614B73328778F16C47DE2FECFC57_1682138619 = (end(0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return end(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.656 -0400", hash_original_method = "AA5E91AED2A0230E676820BFF0A777EF", hash_generated_method = "61E32038989E8277C83E6C0519824A04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MatchResult toMatchResult() {
        ensureMatch();
        MatchResult varF6AE9830F391568F57C11999579FAE75_523462480 = (new MatchResultImpl(input, matchOffsets));
        return (MatchResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ensureMatch();
        //return new MatchResultImpl(input, matchOffsets);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.656 -0400", hash_original_method = "785D7AD880670D6D8A0DF6FCE0749ACB", hash_generated_method = "6B3A474687E2226013A3CAB173C74E3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher useAnchoringBounds(boolean value) {
        dsTaint.addTaint(value);
        useAnchoringBoundsImpl(address, value);
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //anchoringBounds = value;
        //useAnchoringBoundsImpl(address, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.656 -0400", hash_original_method = "56179EEEB1BB6D253C6C82DD4DB81ED5", hash_generated_method = "AB7F97ADA3E3572F6FBD22D19E929A51")
    @DSModeled(DSC.SAFE)
    public boolean hasAnchoringBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return anchoringBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.656 -0400", hash_original_method = "EB1ABBA9A1AC428A5376D92D0ECDDD75", hash_generated_method = "BE061CA0A24D4DD32F6E4443D1FEDA5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher useTransparentBounds(boolean value) {
        dsTaint.addTaint(value);
        useTransparentBoundsImpl(address, value);
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //transparentBounds = value;
        //useTransparentBoundsImpl(address, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.656 -0400", hash_original_method = "62DD7ED3C887DF9CAF781EDBA38B8A50", hash_generated_method = "92D502465B077044DA797A146EFC9F83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureMatch() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No successful match so far");
        } //End block
        // ---------- Original Method ----------
        //if (!matchFound) {
            //throw new IllegalStateException("No successful match so far");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.657 -0400", hash_original_method = "935CF82B5FBC95B795356ABD430E53CE", hash_generated_method = "6BA3DFF5CB4ECD7AE309810F81FE23F9")
    @DSModeled(DSC.SAFE)
    public boolean hasTransparentBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return transparentBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.657 -0400", hash_original_method = "1309D9DA3902B8EF77EAE3BBEDE0D6E3", hash_generated_method = "59C1D2E770B25A4F6A5B4B1976F19062")
    @DSModeled(DSC.SAFE)
    public int regionStart() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return regionStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.657 -0400", hash_original_method = "A2DEE293E79DD1E070648045D7A01545", hash_generated_method = "613ECDE9A6E7EAE895CEBBC60A8684E6")
    @DSModeled(DSC.SAFE)
    public int regionEnd() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return regionEnd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.657 -0400", hash_original_method = "6469C197EE58C69EE809CEC9FEDF2877", hash_generated_method = "F7B89133C82C12C8EFA1C07A38F94C6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requireEnd() {
        boolean varEF751A2F8A30FD1B90C84328A8A15FD6_1825442891 = (requireEndImpl(address));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return requireEndImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.657 -0400", hash_original_method = "EDB1A66CB81652E7B35BD52D60EF4E40", hash_generated_method = "E1F6AAD30775E8928046FA58BA8B7BD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hitEnd() {
        boolean var465B0EDCB419577F061CD4A8EF4B39F7_1866917034 = (hitEndImpl(address));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hitEndImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.658 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "268F081DD9CF1446BB7E8CE24D74FE6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        private static void closeImpl(int addr) {
    }

    
        private static boolean findImpl(int addr, String s, int startIndex, int[] offsets) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean findNextImpl(int addr, String s, int[] offsets) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static int groupCountImpl(int addr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static boolean hitEndImpl(int addr) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean lookingAtImpl(int addr, String s, int[] offsets) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean matchesImpl(int addr, String s, int[] offsets) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static int openImpl(int patternAddr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static boolean requireEndImpl(int addr) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void setInputImpl(int addr, String s, int start, int end) {
    }

    
        private static void useAnchoringBoundsImpl(int addr, boolean value) {
    }

    
        private static void useTransparentBoundsImpl(int addr, boolean value) {
    }

    
}

