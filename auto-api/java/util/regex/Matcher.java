package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Matcher implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "F8E35FE12BF69D119F3D49E111B1D9A2")

    private Pattern pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "ECFFF1362128F72A357ECE9557617256", hash_generated_field = "4BFD2E9911A5B09AFA78246F140BA69E")

    private int regionStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "93DE8CC916B0BCFB1D6128BF808B866E", hash_generated_field = "81B8E8F63D0573D4ED10DF96945C6FEF")

    private int regionEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "CBA38EE614CFC3B8B3563589CEE941DE", hash_generated_field = "12D45F7A9DCD34D02837FD43189B6ED4")

    private int findPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "C6ECF4653A20E3AE0B3EAED0AC081EF6", hash_generated_field = "7897EAE2C904551FD3FBA85C5C84AFAC")

    private int appendPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "0E4174C981DCB834637488B851694644", hash_generated_field = "7C4C3171C0696160D17E6982793E0AF8")

    private boolean matchFound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "394B4F383909BE2C1B724181C62146F3", hash_generated_field = "6F546FFAFB8033C940863BBC52B1D28B")

    private int[] matchOffsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "CCBC445CCB76CDC20299A7369C95C05A", hash_generated_field = "84D0C0F3D7AD96896E61ACD06804F92F")

    private boolean anchoringBounds = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.307 -0400", hash_original_field = "EA05B80BA92F422C6A4E97CE3DB6F1F0", hash_generated_field = "9AD9F3963812EC3748D564A27742AD96")

    private boolean transparentBounds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.321 -0400", hash_original_method = "3CAF328B13970C51C4DF071BCDFD21EA", hash_generated_method = "3772D21C32678A10B7E222AD4527DCCC")
      Matcher(Pattern pattern, CharSequence input) {
        usePattern(pattern);
        reset(input);
        addTaint(pattern.getTaint());
        addTaint(input.getTaint());
        // ---------- Original Method ----------
        //usePattern(pattern);
        //reset(input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.322 -0400", hash_original_method = "0ABA3494B4138038176605DE83A643DA", hash_generated_method = "FE5AF3DF4E23B8AD1DEFA7AFB6A4BA5D")
    public Matcher appendReplacement(StringBuffer buffer, String replacement) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1036197555 = null; //Variable for return #1
        buffer.append(input.substring(appendPos, start()));
        appendEvaluated(buffer, replacement);
        appendPos = end();
        varB4EAC82CA7396A68D541C85D26508E83_1036197555 = this;
        addTaint(buffer.getTaint());
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1036197555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1036197555;
        // ---------- Original Method ----------
        //buffer.append(input.substring(appendPos, start()));
        //appendEvaluated(buffer, replacement);
        //appendPos = end();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.323 -0400", hash_original_method = "5B3F4DCDB18701B7EDED77C3B9D3C550", hash_generated_method = "4B57FF06F7E5A297ABE51A0C37F75247")
    private void appendEvaluated(StringBuffer buffer, String s) {
        boolean escape;
        escape = false;
        boolean dollar;
        dollar = false;
        {
            int i;
            i = 0;
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_1302794783 = (i < s.length());
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
        addTaint(buffer.getTaint());
        addTaint(s.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.328 -0400", hash_original_method = "9AD9707639C16EE18626C91A471BEAF6", hash_generated_method = "34915D083E1AAD80BFB61989F6B757DC")
    public Matcher reset() {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_222922894 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_222922894 = reset(input, 0, input.length());
        varB4EAC82CA7396A68D541C85D26508E83_222922894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_222922894;
        // ---------- Original Method ----------
        //return reset(input, 0, input.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.328 -0400", hash_original_method = "6A88D6B012E13AB6428E01867B9DB072", hash_generated_method = "88AD8637308FA10318472183E755E5D1")
    public Matcher reset(CharSequence input) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1256995267 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1256995267 = reset(input, 0, input.length());
        addTaint(input.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1256995267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1256995267;
        // ---------- Original Method ----------
        //return reset(input, 0, input.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.345 -0400", hash_original_method = "1E13D8D8B85E56AF9BB58282CB9C7392", hash_generated_method = "A7259B5B95F07D1C60BD2F3F1FEDC984")
    private Matcher reset(CharSequence input, int start, int end) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_433618347 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            boolean varF45ABFE6077AFC8486D01968E44A911F_1644405301 = (start < 0 || end < 0 || start > input.length() || end > input.length() || start > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        this.input = input.toString();
        this.regionStart = start;
        this.regionEnd = end;
        resetForInput();
        matchFound = false;
        findPos = regionStart;
        appendPos = 0;
        varB4EAC82CA7396A68D541C85D26508E83_433618347 = this;
        varB4EAC82CA7396A68D541C85D26508E83_433618347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_433618347;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.357 -0400", hash_original_method = "2FE41CFA985CF6A9EFE2D0795A2797F8", hash_generated_method = "E3A7CBAD65A29BDF83D30175D66F908F")
    public Matcher usePattern(Pattern pattern) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1889799180 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        this.pattern = pattern;
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
        varB4EAC82CA7396A68D541C85D26508E83_1889799180 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1889799180.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1889799180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.359 -0400", hash_original_method = "4B8F5281B8D449CBFD7748E2AB98FC6B", hash_generated_method = "7103FCDC0C3502E02876C3BCAF9A118B")
    private void resetForInput() {
        setInputImpl(address, input, regionStart, regionEnd);
        useAnchoringBoundsImpl(address, anchoringBounds);
        useTransparentBoundsImpl(address, transparentBounds);
        // ---------- Original Method ----------
        //setInputImpl(address, input, regionStart, regionEnd);
        //useAnchoringBoundsImpl(address, anchoringBounds);
        //useTransparentBoundsImpl(address, transparentBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.359 -0400", hash_original_method = "764159AB96CDD9290AC2E4282412C52D", hash_generated_method = "9C69B28E644A609033D50D5CC4B5153E")
    public Matcher region(int start, int end) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_969843877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_969843877 = reset(input, start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_969843877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_969843877;
        // ---------- Original Method ----------
        //return reset(input, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.403 -0400", hash_original_method = "26B8601C4A947AF0FE4D833433D4DFA4", hash_generated_method = "80B92C7425DB12B5F61F9EB80FBC8D12")
    public StringBuffer appendTail(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1665202188 = null; //Variable for return #1
        {
            buffer.append(input.substring(appendPos, regionEnd));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1665202188 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1665202188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1665202188;
        // ---------- Original Method ----------
        //if (appendPos < regionEnd) {
            //buffer.append(input.substring(appendPos, regionEnd));
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.406 -0400", hash_original_method = "902CB288EB494C9205FE6BF90EDE4AF5", hash_generated_method = "586BF4BDA5B6B0A1C93F5DC4EF93A74C")
    public String replaceFirst(String replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_127867722 = null; //Variable for return #1
        reset();
        StringBuffer buffer;
        buffer = new StringBuffer(input.length());
        {
            boolean var73BA7AA75A06BCD20094DC5116547A45_242993110 = (find());
            {
                appendReplacement(buffer, replacement);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_127867722 = appendTail(buffer).toString();
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_127867722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_127867722;
        // ---------- Original Method ----------
        //reset();
        //StringBuffer buffer = new StringBuffer(input.length());
        //if (find()) {
            //appendReplacement(buffer, replacement);
        //}
        //return appendTail(buffer).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.408 -0400", hash_original_method = "DCC3E518C2D0EED9BFA3E6DD970895A0", hash_generated_method = "CB8B14F2AACA47D3133520BD5BCE5290")
    public String replaceAll(String replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_45853491 = null; //Variable for return #1
        reset();
        StringBuffer buffer;
        buffer = new StringBuffer(input.length());
        {
            boolean var73BA7AA75A06BCD20094DC5116547A45_1729536679 = (find());
            {
                appendReplacement(buffer, replacement);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_45853491 = appendTail(buffer).toString();
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_45853491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_45853491;
        // ---------- Original Method ----------
        //reset();
        //StringBuffer buffer = new StringBuffer(input.length());
        //while (find()) {
            //appendReplacement(buffer, replacement);
        //}
        //return appendTail(buffer).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.409 -0400", hash_original_method = "29D81214171EEBB46568323FF70F06B8", hash_generated_method = "D6D754131BC95B8ED16567B492D17AA6")
    public Pattern pattern() {
        Pattern varB4EAC82CA7396A68D541C85D26508E83_1029007117 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1029007117 = pattern;
        varB4EAC82CA7396A68D541C85D26508E83_1029007117.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1029007117;
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.410 -0400", hash_original_method = "C5DB0A67F29696168A3714469C702630", hash_generated_method = "D0BEE56C36ED799ECFF85B8357899622")
    public String group(int group) {
        String varB4EAC82CA7396A68D541C85D26508E83_17298991 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1524856925 = null; //Variable for return #2
        ensureMatch();
        int from;
        from = matchOffsets[group * 2];
        int to;
        to = matchOffsets[(group * 2) + 1];
        {
            varB4EAC82CA7396A68D541C85D26508E83_17298991 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1524856925 = input.substring(from, to);
        } //End block
        addTaint(group);
        String varA7E53CE21691AB073D9660D615818899_840282124; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_840282124 = varB4EAC82CA7396A68D541C85D26508E83_17298991;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_840282124 = varB4EAC82CA7396A68D541C85D26508E83_1524856925;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_840282124.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_840282124;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.425 -0400", hash_original_method = "B66B9D5A22E4810AC45D3DC362BC1AC2", hash_generated_method = "81945A8616B1484D1A8B6D8E56EE286F")
    public String group() {
        String varB4EAC82CA7396A68D541C85D26508E83_1291970054 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1291970054 = group(0);
        varB4EAC82CA7396A68D541C85D26508E83_1291970054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291970054;
        // ---------- Original Method ----------
        //return group(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.444 -0400", hash_original_method = "1E0A41464CCCF143B80A589A774A22D2", hash_generated_method = "9ACC167672CEE71E455F12E03A3AF15E")
    public boolean find(int start) {
        findPos = start;
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255408020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_255408020;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.445 -0400", hash_original_method = "B9818686B652967984036901E54AA9CC", hash_generated_method = "6D444DB28E30C67726B8DE05FF74E133")
    public boolean find() {
        matchFound = findNextImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368193818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368193818;
        // ---------- Original Method ----------
        //matchFound = findNextImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.447 -0400", hash_original_method = "97077CE30676723FC89EE7203F75639E", hash_generated_method = "4D1A6D6ABE36A65CAC5CFA69244F1F94")
    public boolean lookingAt() {
        matchFound = lookingAtImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2028698883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2028698883;
        // ---------- Original Method ----------
        //matchFound = lookingAtImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.464 -0400", hash_original_method = "F2B231DFAE39F525F974692AFF77961B", hash_generated_method = "3B7FCD571752BC93B2184BF9102E9FED")
    public boolean matches() {
        matchFound = matchesImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56933039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_56933039;
        // ---------- Original Method ----------
        //matchFound = matchesImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.465 -0400", hash_original_method = "AB3FAB8AD474566DF13ED737E690D125", hash_generated_method = "768D195A8C994188E4AD79B7D245CD28")
    public int start(int group) throws IllegalStateException {
        ensureMatch();
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363761203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363761203;
        // ---------- Original Method ----------
        //ensureMatch();
        //return matchOffsets[group * 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.465 -0400", hash_original_method = "3B2B065B47272EA82FEECDA7C28418A1", hash_generated_method = "AFCF1B185B97203F9D24059E0F5E08BB")
    public int end(int group) {
        ensureMatch();
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192409528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192409528;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.469 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "05212CD410C0365643D7A41E922D5C79")
    public int start() {
        int var2FA5FC50CE2538BDC8E886B2AA7A2178_895804783 = (start(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206329441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206329441;
        // ---------- Original Method ----------
        //return start(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.481 -0400", hash_original_method = "2C579AC6636E2BB6A85949F583F18EF9", hash_generated_method = "FBD6754A2F12D3F26F7D5FB353131F43")
    public int groupCount() {
        int varE3909558008410CE21184D2303B66659_748380894 = (groupCountImpl(address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284019633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284019633;
        // ---------- Original Method ----------
        //return groupCountImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.481 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "DFE365EA95138E0E76D87069D194A5B8")
    public int end() {
        int varD085614B73328778F16C47DE2FECFC57_314640413 = (end(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288377529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288377529;
        // ---------- Original Method ----------
        //return end(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.482 -0400", hash_original_method = "AA5E91AED2A0230E676820BFF0A777EF", hash_generated_method = "7075A4FF26F8BD5828DF30396D838704")
    public MatchResult toMatchResult() {
        MatchResult varB4EAC82CA7396A68D541C85D26508E83_1806544265 = null; //Variable for return #1
        ensureMatch();
        varB4EAC82CA7396A68D541C85D26508E83_1806544265 = new MatchResultImpl(input, matchOffsets);
        varB4EAC82CA7396A68D541C85D26508E83_1806544265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1806544265;
        // ---------- Original Method ----------
        //ensureMatch();
        //return new MatchResultImpl(input, matchOffsets);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.483 -0400", hash_original_method = "785D7AD880670D6D8A0DF6FCE0749ACB", hash_generated_method = "96FAE045DA578CC6B19687881C7CE162")
    public Matcher useAnchoringBounds(boolean value) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1672630772 = null; //Variable for return #1
        anchoringBounds = value;
        useAnchoringBoundsImpl(address, value);
        varB4EAC82CA7396A68D541C85D26508E83_1672630772 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1672630772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1672630772;
        // ---------- Original Method ----------
        //anchoringBounds = value;
        //useAnchoringBoundsImpl(address, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.483 -0400", hash_original_method = "56179EEEB1BB6D253C6C82DD4DB81ED5", hash_generated_method = "46D6E904BE87D3CBFF777007B2656631")
    public boolean hasAnchoringBounds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940517446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940517446;
        // ---------- Original Method ----------
        //return anchoringBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.484 -0400", hash_original_method = "EB1ABBA9A1AC428A5376D92D0ECDDD75", hash_generated_method = "1733050770C3E5F6999A5C7753F63E70")
    public Matcher useTransparentBounds(boolean value) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1094111320 = null; //Variable for return #1
        transparentBounds = value;
        useTransparentBoundsImpl(address, value);
        varB4EAC82CA7396A68D541C85D26508E83_1094111320 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1094111320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1094111320;
        // ---------- Original Method ----------
        //transparentBounds = value;
        //useTransparentBoundsImpl(address, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.484 -0400", hash_original_method = "62DD7ED3C887DF9CAF781EDBA38B8A50", hash_generated_method = "92D502465B077044DA797A146EFC9F83")
    private void ensureMatch() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No successful match so far");
        } //End block
        // ---------- Original Method ----------
        //if (!matchFound) {
            //throw new IllegalStateException("No successful match so far");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.484 -0400", hash_original_method = "935CF82B5FBC95B795356ABD430E53CE", hash_generated_method = "64A37648FB31471B23493892DDC0B725")
    public boolean hasTransparentBounds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_516301666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_516301666;
        // ---------- Original Method ----------
        //return transparentBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.491 -0400", hash_original_method = "1309D9DA3902B8EF77EAE3BBEDE0D6E3", hash_generated_method = "B1CA5D1CE554C7459F75CEA02ADEE4E1")
    public int regionStart() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1087333661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1087333661;
        // ---------- Original Method ----------
        //return regionStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.492 -0400", hash_original_method = "A2DEE293E79DD1E070648045D7A01545", hash_generated_method = "FCEAE9DB84BB676060B54466FB29AC06")
    public int regionEnd() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654095600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654095600;
        // ---------- Original Method ----------
        //return regionEnd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.492 -0400", hash_original_method = "6469C197EE58C69EE809CEC9FEDF2877", hash_generated_method = "C8E641576E7E7546FA0A4D687A95E1BC")
    public boolean requireEnd() {
        boolean varEF751A2F8A30FD1B90C84328A8A15FD6_8635764 = (requireEndImpl(address));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_242567640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_242567640;
        // ---------- Original Method ----------
        //return requireEndImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.492 -0400", hash_original_method = "EDB1A66CB81652E7B35BD52D60EF4E40", hash_generated_method = "4DC1DEEBB1CABC33C9B859FCC4C48BA3")
    public boolean hitEnd() {
        boolean var465B0EDCB419577F061CD4A8EF4B39F7_694811628 = (hitEndImpl(address));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792132175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792132175;
        // ---------- Original Method ----------
        //return hitEndImpl(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.496 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "268F081DD9CF1446BB7E8CE24D74FE6E")
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

