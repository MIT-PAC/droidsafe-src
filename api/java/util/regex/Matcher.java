package java.util.regex;

// Droidsafe Imports
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public final class Matcher implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "F8E35FE12BF69D119F3D49E111B1D9A2")

    private Pattern pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "ECFFF1362128F72A357ECE9557617256", hash_generated_field = "4BFD2E9911A5B09AFA78246F140BA69E")

    private int regionStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "93DE8CC916B0BCFB1D6128BF808B866E", hash_generated_field = "81B8E8F63D0573D4ED10DF96945C6FEF")

    private int regionEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "CBA38EE614CFC3B8B3563589CEE941DE", hash_generated_field = "12D45F7A9DCD34D02837FD43189B6ED4")

    private int findPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "C6ECF4653A20E3AE0B3EAED0AC081EF6", hash_generated_field = "7897EAE2C904551FD3FBA85C5C84AFAC")

    private int appendPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "0E4174C981DCB834637488B851694644", hash_generated_field = "7C4C3171C0696160D17E6982793E0AF8")

    private boolean matchFound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "394B4F383909BE2C1B724181C62146F3", hash_generated_field = "6F546FFAFB8033C940863BBC52B1D28B")

    private int[] matchOffsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "CCBC445CCB76CDC20299A7369C95C05A", hash_generated_field = "84D0C0F3D7AD96896E61ACD06804F92F")

    private boolean anchoringBounds = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.401 -0400", hash_original_field = "EA05B80BA92F422C6A4E97CE3DB6F1F0", hash_generated_field = "9AD9F3963812EC3748D564A27742AD96")

    private boolean transparentBounds;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.402 -0400", hash_original_method = "3CAF328B13970C51C4DF071BCDFD21EA", hash_generated_method = "8249972DDA8DD488E0F8A49E2E97FBB8")
      Matcher(Pattern pattern, CharSequence input) {
        addTaint(input.getTaint());
        addTaint(pattern.getTaint());
        usePattern(pattern);
        reset(input);
        // ---------- Original Method ----------
        //usePattern(pattern);
        //reset(input);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.403 -0400", hash_original_method = "0ABA3494B4138038176605DE83A643DA", hash_generated_method = "8B54DF3421C4CF2E886A856E5FD1ACFE")
    public Matcher appendReplacement(StringBuffer buffer, String replacement) {
        addTaint(replacement.getTaint());
        addTaint(buffer.getTaint());
        buffer.append(input.substring(appendPos, start()));
        appendEvaluated(buffer, replacement);
        appendPos = end();
Matcher var72A74007B2BE62B849F475C7BDA4658B_1656879820 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1656879820.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1656879820;
        // ---------- Original Method ----------
        //buffer.append(input.substring(appendPos, start()));
        //appendEvaluated(buffer, replacement);
        //appendPos = end();
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.404 -0400", hash_original_method = "5B3F4DCDB18701B7EDED77C3B9D3C550", hash_generated_method = "67D2777EBF3F682A40339A7B098EB61C")
    private void appendEvaluated(StringBuffer buffer, String s) {
        addTaint(s.getTaint());
        addTaint(buffer.getTaint());
        boolean escape = false;
        boolean dollar = false;
for(int i = 0;i < s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '\\' && !escape)            
            {
                escape = true;
            } //End block
            else
            if(c == '$' && !escape)            
            {
                dollar = true;
            } //End block
            else
            if(c >= '0' && c <= '9' && dollar)            
            {
                buffer.append(group(c - '0'));
                dollar = false;
            } //End block
            else
            {
                buffer.append(c);
                dollar = false;
                escape = false;
            } //End block
        } //End block
        if(escape)        
        {
            ArrayIndexOutOfBoundsException var30646BD3FD335CBB18D7EA21A204A309_1610216069 = new ArrayIndexOutOfBoundsException(s.length());
            var30646BD3FD335CBB18D7EA21A204A309_1610216069.addTaint(taint);
            throw var30646BD3FD335CBB18D7EA21A204A309_1610216069;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.405 -0400", hash_original_method = "9AD9707639C16EE18626C91A471BEAF6", hash_generated_method = "9CBC072578BF5D4EC059AF752CFC274C")
    public Matcher reset() {
Matcher var27B831E3E9D7996FF75BF262D46760AE_115119120 =         reset(input, 0, input.length());
        var27B831E3E9D7996FF75BF262D46760AE_115119120.addTaint(taint);
        return var27B831E3E9D7996FF75BF262D46760AE_115119120;
        // ---------- Original Method ----------
        //return reset(input, 0, input.length());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.406 -0400", hash_original_method = "6A88D6B012E13AB6428E01867B9DB072", hash_generated_method = "171BC7481097D862762933A3ECE0F9BD")
    public Matcher reset(CharSequence input) {
        addTaint(input.getTaint());
Matcher var27B831E3E9D7996FF75BF262D46760AE_346754845 =         reset(input, 0, input.length());
        var27B831E3E9D7996FF75BF262D46760AE_346754845.addTaint(taint);
        return var27B831E3E9D7996FF75BF262D46760AE_346754845;
        // ---------- Original Method ----------
        //return reset(input, 0, input.length());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.409 -0400", hash_original_method = "1E13D8D8B85E56AF9BB58282CB9C7392", hash_generated_method = "00FB523A4CC85C1CFA1855E09FC86D22")
    private Matcher reset(CharSequence input, int start, int end) {
        if(input == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1376200012 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1376200012.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1376200012;
        } //End block
        if(start < 0 || end < 0 || start > input.length() || end > input.length() || start > end)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_695210869 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_695210869.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_695210869;
        } //End block
        this.input = input.toString();
        this.regionStart = start;
        this.regionEnd = end;
        resetForInput();
        matchFound = false;
        findPos = regionStart;
        appendPos = 0;
Matcher var72A74007B2BE62B849F475C7BDA4658B_511592898 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_511592898.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_511592898;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.411 -0400", hash_original_method = "2FE41CFA985CF6A9EFE2D0795A2797F8", hash_generated_method = "5C19F154E08892F85579A8C913EC9218")
    public Matcher usePattern(Pattern pattern) {
        if(pattern == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2098332570 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2098332570.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2098332570;
        } //End block
        this.pattern = pattern;
        if(address != 0)        
        {
            closeImpl(address);
            address = 0;
        } //End block
        address = openImpl(pattern.address);
        if(input != null)        
        {
            resetForInput();
        } //End block
        matchOffsets = new int[(groupCount() + 1) * 2];
        matchFound = false;
Matcher var72A74007B2BE62B849F475C7BDA4658B_1131073176 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1131073176.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1131073176;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.411 -0400", hash_original_method = "4B8F5281B8D449CBFD7748E2AB98FC6B", hash_generated_method = "7103FCDC0C3502E02876C3BCAF9A118B")
    private void resetForInput() {
        setInputImpl(address, input, regionStart, regionEnd);
        useAnchoringBoundsImpl(address, anchoringBounds);
        useTransparentBoundsImpl(address, transparentBounds);
        // ---------- Original Method ----------
        //setInputImpl(address, input, regionStart, regionEnd);
        //useAnchoringBoundsImpl(address, anchoringBounds);
        //useTransparentBoundsImpl(address, transparentBounds);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.412 -0400", hash_original_method = "764159AB96CDD9290AC2E4282412C52D", hash_generated_method = "BF5156AA9B24D561ACE82A44A1442E08")
    public Matcher region(int start, int end) {
        addTaint(end);
        addTaint(start);
Matcher var892C482988B837DD1F64EE8E5F648166_1338351338 =         reset(input, start, end);
        var892C482988B837DD1F64EE8E5F648166_1338351338.addTaint(taint);
        return var892C482988B837DD1F64EE8E5F648166_1338351338;
        // ---------- Original Method ----------
        //return reset(input, start, end);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.412 -0400", hash_original_method = "26B8601C4A947AF0FE4D833433D4DFA4", hash_generated_method = "7668E4357304A4ECAA75059A8A253820")
    public StringBuffer appendTail(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(appendPos < regionEnd)        
        {
            buffer.append(input.substring(appendPos, regionEnd));
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1405707366 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1405707366.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1405707366;
        // ---------- Original Method ----------
        //if (appendPos < regionEnd) {
            //buffer.append(input.substring(appendPos, regionEnd));
        //}
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.412 -0400", hash_original_method = "902CB288EB494C9205FE6BF90EDE4AF5", hash_generated_method = "69B755D95B297B7397D8C58CAFCCFAA3")
    public String replaceFirst(String replacement) {
        addTaint(replacement.getTaint());
        reset();
        StringBuffer buffer = new StringBuffer(input.length());
        if(find())        
        {
            appendReplacement(buffer, replacement);
        } //End block
String varFE2C09F856B281EC496BCCBB30C802C4_1364961388 =         appendTail(buffer).toString();
        varFE2C09F856B281EC496BCCBB30C802C4_1364961388.addTaint(taint);
        return varFE2C09F856B281EC496BCCBB30C802C4_1364961388;
        // ---------- Original Method ----------
        //reset();
        //StringBuffer buffer = new StringBuffer(input.length());
        //if (find()) {
            //appendReplacement(buffer, replacement);
        //}
        //return appendTail(buffer).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.413 -0400", hash_original_method = "DCC3E518C2D0EED9BFA3E6DD970895A0", hash_generated_method = "7D5AA267BB47DAA240C8B99AE2461629")
    public String replaceAll(String replacement) {
        addTaint(replacement.getTaint());
        reset();
        StringBuffer buffer = new StringBuffer(input.length());
        while
(find())        
        {
            appendReplacement(buffer, replacement);
        } //End block
String varFE2C09F856B281EC496BCCBB30C802C4_430910503 =         appendTail(buffer).toString();
        varFE2C09F856B281EC496BCCBB30C802C4_430910503.addTaint(taint);
        return varFE2C09F856B281EC496BCCBB30C802C4_430910503;
        // ---------- Original Method ----------
        //reset();
        //StringBuffer buffer = new StringBuffer(input.length());
        //while (find()) {
            //appendReplacement(buffer, replacement);
        //}
        //return appendTail(buffer).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.413 -0400", hash_original_method = "29D81214171EEBB46568323FF70F06B8", hash_generated_method = "9CC59C563F36D38AC299CF27FCED1A64")
    public Pattern pattern() {
Pattern var407D32260E541B695CF3FD3F7EFB76AB_84740655 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_84740655.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_84740655;
        // ---------- Original Method ----------
        //return pattern;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.413 -0400", hash_original_method = "C5DB0A67F29696168A3714469C702630", hash_generated_method = "A8A86B25826ED762A843EEF38F27DAE0")
    public String group(int group) {
        addTaint(group);
        ensureMatch();
        int from = matchOffsets[group * 2];
        int to = matchOffsets[(group * 2) + 1];
        if(from == -1 || to == -1)        
        {
String var540C13E9E156B687226421B24F2DF178_115353609 =             null;
            var540C13E9E156B687226421B24F2DF178_115353609.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_115353609;
        } //End block
        else
        {
String varF0802F9FC813E0EBB369A8BC30266128_347823420 =             input.substring(from, to);
            varF0802F9FC813E0EBB369A8BC30266128_347823420.addTaint(taint);
            return varF0802F9FC813E0EBB369A8BC30266128_347823420;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.414 -0400", hash_original_method = "B66B9D5A22E4810AC45D3DC362BC1AC2", hash_generated_method = "324C8E66FB85A8F2015ED1CBD1D6AAD5")
    public String group() {
String var0ACD02150D7ACAC99FB753A66946449F_435965858 =         group(0);
        var0ACD02150D7ACAC99FB753A66946449F_435965858.addTaint(taint);
        return var0ACD02150D7ACAC99FB753A66946449F_435965858;
        // ---------- Original Method ----------
        //return group(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.415 -0400", hash_original_method = "1E0A41464CCCF143B80A589A774A22D2", hash_generated_method = "5B044D21F77607617133A9DB6CBC0C37")
    public boolean find(int start) {
        findPos = start;
        if(findPos < regionStart)        
        {
            findPos = regionStart;
        } //End block
        else
        if(findPos >= regionEnd)        
        {
            matchFound = false;
            boolean var68934A3E9455FA72420237EB05902327_402892849 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639581681 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639581681;
        } //End block
        matchFound = findImpl(address, input, findPos, matchOffsets);
        if(matchFound)        
        {
            findPos = matchOffsets[1];
        } //End block
        boolean var0E4174C981DCB834637488B851694644_1711529627 = (matchFound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600847570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600847570;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.416 -0400", hash_original_method = "B9818686B652967984036901E54AA9CC", hash_generated_method = "62D6B6460F8267A6726B441826AB5E37")
    public boolean find() {
        matchFound = findNextImpl(address, input, matchOffsets);
        if(matchFound)        
        {
            findPos = matchOffsets[1];
        } //End block
        boolean var0E4174C981DCB834637488B851694644_1759620620 = (matchFound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111688946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111688946;
        // ---------- Original Method ----------
        //matchFound = findNextImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.417 -0400", hash_original_method = "97077CE30676723FC89EE7203F75639E", hash_generated_method = "385CFF7E37E17A571F4C27D89FFD769A")
    public boolean lookingAt() {
        matchFound = lookingAtImpl(address, input, matchOffsets);
        if(matchFound)        
        {
            findPos = matchOffsets[1];
        } //End block
        boolean var0E4174C981DCB834637488B851694644_1205666443 = (matchFound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_384529018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_384529018;
        // ---------- Original Method ----------
        //matchFound = lookingAtImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.417 -0400", hash_original_method = "F2B231DFAE39F525F974692AFF77961B", hash_generated_method = "5486A658D4A8B756EC01A719D5FDD58E")
    public boolean matches() {
        matchFound = matchesImpl(address, input, matchOffsets);
        if(matchFound)        
        {
            findPos = matchOffsets[1];
        } //End block
        boolean var0E4174C981DCB834637488B851694644_2020635007 = (matchFound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815591558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815591558;
        // ---------- Original Method ----------
        //matchFound = matchesImpl(address, input, matchOffsets);
        //if (matchFound) {
            //findPos = matchOffsets[1];
        //}
        //return matchFound;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.418 -0400", hash_original_method = "AB3FAB8AD474566DF13ED737E690D125", hash_generated_method = "9B9B0CD05CD3FE7F01E3936027717CF4")
    public int start(int group) throws IllegalStateException {
        addTaint(group);
        ensureMatch();
        int var6B08C4E6F893AFDCFB49A16AFA368822_90256724 = (matchOffsets[group * 2]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401067143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401067143;
        // ---------- Original Method ----------
        //ensureMatch();
        //return matchOffsets[group * 2];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.418 -0400", hash_original_method = "3B2B065B47272EA82FEECDA7C28418A1", hash_generated_method = "CD7DDB195FD93A2A97BCC2B9091FED10")
    public int end(int group) {
        addTaint(group);
        ensureMatch();
        int varF7AF7F4984A8410BE30EDD10FED34101_618797294 = (matchOffsets[(group * 2) + 1]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149631430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149631430;
        // ---------- Original Method ----------
        //ensureMatch();
        //return matchOffsets[(group * 2) + 1];
    }

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.419 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "B7715D891338A01298D89499172B3D2F")
    public int start() {
        int var65754EB29CD48640473484E377E145B8_53774798 = (start(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104907206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104907206;
        // ---------- Original Method ----------
        //return start(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.419 -0400", hash_original_method = "2C579AC6636E2BB6A85949F583F18EF9", hash_generated_method = "C97663458329642E391809B76C81A22A")
    public int groupCount() {
        int var3288675F8AA029C328043FD1E6F67308_518758938 = (groupCountImpl(address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684454562 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684454562;
        // ---------- Original Method ----------
        //return groupCountImpl(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.420 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "8AF1C2DEF82508ADFB7AFE8FCE9B4EDF")
    public int end() {
        int varCA35A8AADB641992D83E31AADD95BCC2_1511212004 = (end(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605275741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605275741;
        // ---------- Original Method ----------
        //return end(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.421 -0400", hash_original_method = "AA5E91AED2A0230E676820BFF0A777EF", hash_generated_method = "22ACB6F0CAE271DB4CD4E6EDC99CC90A")
    public MatchResult toMatchResult() {
        ensureMatch();
MatchResult varC8FDB7F96980421E629760C82F38DDC7_399133534 =         new MatchResultImpl(input, matchOffsets);
        varC8FDB7F96980421E629760C82F38DDC7_399133534.addTaint(taint);
        return varC8FDB7F96980421E629760C82F38DDC7_399133534;
        // ---------- Original Method ----------
        //ensureMatch();
        //return new MatchResultImpl(input, matchOffsets);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.422 -0400", hash_original_method = "785D7AD880670D6D8A0DF6FCE0749ACB", hash_generated_method = "4F7AEC1296A0206EB72220F6A146E1FD")
    public Matcher useAnchoringBounds(boolean value) {
        anchoringBounds = value;
        useAnchoringBoundsImpl(address, value);
Matcher var72A74007B2BE62B849F475C7BDA4658B_450267573 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_450267573.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_450267573;
        // ---------- Original Method ----------
        //anchoringBounds = value;
        //useAnchoringBoundsImpl(address, value);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.422 -0400", hash_original_method = "56179EEEB1BB6D253C6C82DD4DB81ED5", hash_generated_method = "188220078061F853147FDCD57604DCF4")
    public boolean hasAnchoringBounds() {
        boolean var19B3006D2C5C72B63F2948F86CE60FF2_2005407261 = (anchoringBounds);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_378950133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_378950133;
        // ---------- Original Method ----------
        //return anchoringBounds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.423 -0400", hash_original_method = "EB1ABBA9A1AC428A5376D92D0ECDDD75", hash_generated_method = "5D61B216C4E298770268850C2F8D4409")
    public Matcher useTransparentBounds(boolean value) {
        transparentBounds = value;
        useTransparentBoundsImpl(address, value);
Matcher var72A74007B2BE62B849F475C7BDA4658B_2099028483 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2099028483.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2099028483;
        // ---------- Original Method ----------
        //transparentBounds = value;
        //useTransparentBoundsImpl(address, value);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.423 -0400", hash_original_method = "62DD7ED3C887DF9CAF781EDBA38B8A50", hash_generated_method = "DF2BDA89EE0640098CFD4D9568E2EC85")
    private void ensureMatch() {
        if(!matchFound)        
        {
            IllegalStateException var9684E0F6DFD7A709A943F77E9406046F_1813596781 = new IllegalStateException("No successful match so far");
            var9684E0F6DFD7A709A943F77E9406046F_1813596781.addTaint(taint);
            throw var9684E0F6DFD7A709A943F77E9406046F_1813596781;
        } //End block
        // ---------- Original Method ----------
        //if (!matchFound) {
            //throw new IllegalStateException("No successful match so far");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.423 -0400", hash_original_method = "935CF82B5FBC95B795356ABD430E53CE", hash_generated_method = "687BB550B832292B28FA14CEC3F929FB")
    public boolean hasTransparentBounds() {
        boolean varEA05B80BA92F422C6A4E97CE3DB6F1F0_1924834804 = (transparentBounds);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370396993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370396993;
        // ---------- Original Method ----------
        //return transparentBounds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.423 -0400", hash_original_method = "1309D9DA3902B8EF77EAE3BBEDE0D6E3", hash_generated_method = "3F9E342B93DB60DF0217E7B33503D046")
    public int regionStart() {
        int varECFFF1362128F72A357ECE9557617256_1362669938 = (regionStart);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059541078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059541078;
        // ---------- Original Method ----------
        //return regionStart;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.424 -0400", hash_original_method = "A2DEE293E79DD1E070648045D7A01545", hash_generated_method = "77B45627826CF6E222D53FBA9E2DCBCA")
    public int regionEnd() {
        int var93DE8CC916B0BCFB1D6128BF808B866E_688307175 = (regionEnd);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005364383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005364383;
        // ---------- Original Method ----------
        //return regionEnd;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.424 -0400", hash_original_method = "6469C197EE58C69EE809CEC9FEDF2877", hash_generated_method = "C45BD01AD42EC1FB102F9E1DA5CC0A27")
    public boolean requireEnd() {
        boolean var96C6E91545DD29B17217EA3AF9C12A85_1026850953 = (requireEndImpl(address));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573844947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_573844947;
        // ---------- Original Method ----------
        //return requireEndImpl(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.424 -0400", hash_original_method = "EDB1A66CB81652E7B35BD52D60EF4E40", hash_generated_method = "48F96E61FC534CF8ADD7E3548C377BEF")
    public boolean hitEnd() {
        boolean varAFD053EF07BBC569C02B1F0FD47E8A16_2097878833 = (hitEndImpl(address));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939227035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_939227035;
        // ---------- Original Method ----------
        //return hitEndImpl(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.424 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "268F081DD9CF1446BB7E8CE24D74FE6E")
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

    
    @DSModeled(DSC.SAFE)
    private static void closeImpl(int addr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean findImpl(int addr, String s, int startIndex, int[] offsets) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean findNextImpl(int addr, String s, int[] offsets) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static int groupCountImpl(int addr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean hitEndImpl(int addr) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean lookingAtImpl(int addr, String s, int[] offsets) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean matchesImpl(int addr, String s, int[] offsets) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static int openImpl(int patternAddr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean requireEndImpl(int addr) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void setInputImpl(int addr, String s, int start, int end) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void useAnchoringBoundsImpl(int addr, boolean value) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void useTransparentBoundsImpl(int addr, boolean value) {
    }

    
}

