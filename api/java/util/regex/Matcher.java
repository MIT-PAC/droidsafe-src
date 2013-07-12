package java.util.regex;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class Matcher implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.299 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "F8E35FE12BF69D119F3D49E111B1D9A2")

    private Pattern pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.299 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.299 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.299 -0400", hash_original_field = "ECFFF1362128F72A357ECE9557617256", hash_generated_field = "4BFD2E9911A5B09AFA78246F140BA69E")

    private int regionStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.299 -0400", hash_original_field = "93DE8CC916B0BCFB1D6128BF808B866E", hash_generated_field = "81B8E8F63D0573D4ED10DF96945C6FEF")

    private int regionEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.299 -0400", hash_original_field = "CBA38EE614CFC3B8B3563589CEE941DE", hash_generated_field = "12D45F7A9DCD34D02837FD43189B6ED4")

    private int findPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.299 -0400", hash_original_field = "C6ECF4653A20E3AE0B3EAED0AC081EF6", hash_generated_field = "7897EAE2C904551FD3FBA85C5C84AFAC")

    private int appendPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.299 -0400", hash_original_field = "0E4174C981DCB834637488B851694644", hash_generated_field = "7C4C3171C0696160D17E6982793E0AF8")

    private boolean matchFound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.300 -0400", hash_original_field = "394B4F383909BE2C1B724181C62146F3", hash_generated_field = "6F546FFAFB8033C940863BBC52B1D28B")

    private int[] matchOffsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.300 -0400", hash_original_field = "CCBC445CCB76CDC20299A7369C95C05A", hash_generated_field = "84D0C0F3D7AD96896E61ACD06804F92F")

    private boolean anchoringBounds = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.300 -0400", hash_original_field = "EA05B80BA92F422C6A4E97CE3DB6F1F0", hash_generated_field = "9AD9F3963812EC3748D564A27742AD96")

    private boolean transparentBounds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.300 -0400", hash_original_method = "3CAF328B13970C51C4DF071BCDFD21EA", hash_generated_method = "8249972DDA8DD488E0F8A49E2E97FBB8")
      Matcher(Pattern pattern, CharSequence input) {
        addTaint(input.getTaint());
        addTaint(pattern.getTaint());
        usePattern(pattern);
        reset(input);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.301 -0400", hash_original_method = "0ABA3494B4138038176605DE83A643DA", hash_generated_method = "90DEB029AC284D81E8BD07F02B68C046")
    public Matcher appendReplacement(StringBuffer buffer, String replacement) {
        addTaint(replacement.getTaint());
        addTaint(buffer.getTaint());
        buffer.append(input.substring(appendPos, start()));
        appendEvaluated(buffer, replacement);
        appendPos = end();
Matcher var72A74007B2BE62B849F475C7BDA4658B_1470662769 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1470662769.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1470662769;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.302 -0400", hash_original_method = "5B3F4DCDB18701B7EDED77C3B9D3C550", hash_generated_method = "94E37F6A825BDC48D5161F7AB9BDC55A")
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
            } 
            else
    if(c == '$' && !escape)            
            {
                dollar = true;
            } 
            else
    if(c >= '0' && c <= '9' && dollar)            
            {
                buffer.append(group(c - '0'));
                dollar = false;
            } 
            else
            {
                buffer.append(c);
                dollar = false;
                escape = false;
            } 
        } 
    if(escape)        
        {
            ArrayIndexOutOfBoundsException var30646BD3FD335CBB18D7EA21A204A309_59480829 = new ArrayIndexOutOfBoundsException(s.length());
            var30646BD3FD335CBB18D7EA21A204A309_59480829.addTaint(taint);
            throw var30646BD3FD335CBB18D7EA21A204A309_59480829;
        } 
        
        
        
        
            
            
                
            
                
            
                
                
            
                
                
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.302 -0400", hash_original_method = "9AD9707639C16EE18626C91A471BEAF6", hash_generated_method = "D26D22CC84BB681128421238E0193C3A")
    public Matcher reset() {
Matcher var27B831E3E9D7996FF75BF262D46760AE_2019641669 =         reset(input, 0, input.length());
        var27B831E3E9D7996FF75BF262D46760AE_2019641669.addTaint(taint);
        return var27B831E3E9D7996FF75BF262D46760AE_2019641669;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.303 -0400", hash_original_method = "6A88D6B012E13AB6428E01867B9DB072", hash_generated_method = "FCB5F09E3273C7CD598446E4FFBF6F2F")
    public Matcher reset(CharSequence input) {
        addTaint(input.getTaint());
Matcher var27B831E3E9D7996FF75BF262D46760AE_1583733689 =         reset(input, 0, input.length());
        var27B831E3E9D7996FF75BF262D46760AE_1583733689.addTaint(taint);
        return var27B831E3E9D7996FF75BF262D46760AE_1583733689;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.304 -0400", hash_original_method = "1E13D8D8B85E56AF9BB58282CB9C7392", hash_generated_method = "E85F289F1CFBA383126B7747F0EB35EE")
    private Matcher reset(CharSequence input, int start, int end) {
    if(input == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_644105843 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_644105843.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_644105843;
        } 
    if(start < 0 || end < 0 || start > input.length() || end > input.length() || start > end)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_275825706 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_275825706.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_275825706;
        } 
        this.input = input.toString();
        this.regionStart = start;
        this.regionEnd = end;
        resetForInput();
        matchFound = false;
        findPos = regionStart;
        appendPos = 0;
Matcher var72A74007B2BE62B849F475C7BDA4658B_371251179 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_371251179.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_371251179;
        
        
            
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.306 -0400", hash_original_method = "2FE41CFA985CF6A9EFE2D0795A2797F8", hash_generated_method = "0C836208C657D28152CF42342668A6FE")
    public Matcher usePattern(Pattern pattern) {
    if(pattern == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_248799945 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_248799945.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_248799945;
        } 
        this.pattern = pattern;
    if(address != 0)        
        {
            closeImpl(address);
            address = 0;
        } 
        address = openImpl(pattern.address);
    if(input != null)        
        {
            resetForInput();
        } 
        matchOffsets = new int[(groupCount() + 1) * 2];
        matchFound = false;
Matcher var72A74007B2BE62B849F475C7BDA4658B_915875798 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_915875798.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_915875798;
        
        
            
        
        
        
            
            
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.306 -0400", hash_original_method = "4B8F5281B8D449CBFD7748E2AB98FC6B", hash_generated_method = "7103FCDC0C3502E02876C3BCAF9A118B")
    private void resetForInput() {
        setInputImpl(address, input, regionStart, regionEnd);
        useAnchoringBoundsImpl(address, anchoringBounds);
        useTransparentBoundsImpl(address, transparentBounds);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.306 -0400", hash_original_method = "764159AB96CDD9290AC2E4282412C52D", hash_generated_method = "C496BAFB2B1A18C66869D87EA4D3CCD7")
    public Matcher region(int start, int end) {
        addTaint(end);
        addTaint(start);
Matcher var892C482988B837DD1F64EE8E5F648166_949993061 =         reset(input, start, end);
        var892C482988B837DD1F64EE8E5F648166_949993061.addTaint(taint);
        return var892C482988B837DD1F64EE8E5F648166_949993061;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.307 -0400", hash_original_method = "26B8601C4A947AF0FE4D833433D4DFA4", hash_generated_method = "944B8A4F15975B18A4778D46D1CB7F2B")
    public StringBuffer appendTail(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(appendPos < regionEnd)        
        {
            buffer.append(input.substring(appendPos, regionEnd));
        } 
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_862379448 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_862379448.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_862379448;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.307 -0400", hash_original_method = "902CB288EB494C9205FE6BF90EDE4AF5", hash_generated_method = "BB1A2E154A23B7B0D66A6E5E1CBB05F9")
    public String replaceFirst(String replacement) {
        addTaint(replacement.getTaint());
        reset();
        StringBuffer buffer = new StringBuffer(input.length());
    if(find())        
        {
            appendReplacement(buffer, replacement);
        } 
String varFE2C09F856B281EC496BCCBB30C802C4_940364213 =         appendTail(buffer).toString();
        varFE2C09F856B281EC496BCCBB30C802C4_940364213.addTaint(taint);
        return varFE2C09F856B281EC496BCCBB30C802C4_940364213;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.308 -0400", hash_original_method = "DCC3E518C2D0EED9BFA3E6DD970895A0", hash_generated_method = "CDEC402A6D5119217312C3FCCA257797")
    public String replaceAll(String replacement) {
        addTaint(replacement.getTaint());
        reset();
        StringBuffer buffer = new StringBuffer(input.length());
        while
(find())        
        {
            appendReplacement(buffer, replacement);
        } 
String varFE2C09F856B281EC496BCCBB30C802C4_559262045 =         appendTail(buffer).toString();
        varFE2C09F856B281EC496BCCBB30C802C4_559262045.addTaint(taint);
        return varFE2C09F856B281EC496BCCBB30C802C4_559262045;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.308 -0400", hash_original_method = "29D81214171EEBB46568323FF70F06B8", hash_generated_method = "16F5D42119435B32BA753269A44D6969")
    public Pattern pattern() {
Pattern var407D32260E541B695CF3FD3F7EFB76AB_911535806 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_911535806.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_911535806;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.309 -0400", hash_original_method = "C5DB0A67F29696168A3714469C702630", hash_generated_method = "EA3A5FF870C9B75EAC5D575F12653062")
    public String group(int group) {
        addTaint(group);
        ensureMatch();
        int from = matchOffsets[group * 2];
        int to = matchOffsets[(group * 2) + 1];
    if(from == -1 || to == -1)        
        {
String var540C13E9E156B687226421B24F2DF178_895036469 =             null;
            var540C13E9E156B687226421B24F2DF178_895036469.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_895036469;
        } 
        else
        {
String varF0802F9FC813E0EBB369A8BC30266128_509058380 =             input.substring(from, to);
            varF0802F9FC813E0EBB369A8BC30266128_509058380.addTaint(taint);
            return varF0802F9FC813E0EBB369A8BC30266128_509058380;
        } 
        
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.309 -0400", hash_original_method = "B66B9D5A22E4810AC45D3DC362BC1AC2", hash_generated_method = "095CA51D78D875506530F52BAD4FFE6E")
    public String group() {
String var0ACD02150D7ACAC99FB753A66946449F_707526006 =         group(0);
        var0ACD02150D7ACAC99FB753A66946449F_707526006.addTaint(taint);
        return var0ACD02150D7ACAC99FB753A66946449F_707526006;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.310 -0400", hash_original_method = "1E0A41464CCCF143B80A589A774A22D2", hash_generated_method = "2636422C4B1610C9FEB3E6A64D8CE8E4")
    public boolean find(int start) {
        findPos = start;
    if(findPos < regionStart)        
        {
            findPos = regionStart;
        } 
        else
    if(findPos >= regionEnd)        
        {
            matchFound = false;
            boolean var68934A3E9455FA72420237EB05902327_1405815650 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86382581 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_86382581;
        } 
        matchFound = findImpl(address, input, findPos, matchOffsets);
    if(matchFound)        
        {
            findPos = matchOffsets[1];
        } 
        boolean var0E4174C981DCB834637488B851694644_316636716 = (matchFound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311709129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_311709129;
        
        
        
            
        
            
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.311 -0400", hash_original_method = "B9818686B652967984036901E54AA9CC", hash_generated_method = "FBE76D815E69280826A07354B0A5CC54")
    public boolean find() {
        matchFound = findNextImpl(address, input, matchOffsets);
    if(matchFound)        
        {
            findPos = matchOffsets[1];
        } 
        boolean var0E4174C981DCB834637488B851694644_1874840331 = (matchFound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791803039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791803039;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.312 -0400", hash_original_method = "97077CE30676723FC89EE7203F75639E", hash_generated_method = "86FAB73C84F2A70DCA234A79CCFA29E0")
    public boolean lookingAt() {
        matchFound = lookingAtImpl(address, input, matchOffsets);
    if(matchFound)        
        {
            findPos = matchOffsets[1];
        } 
        boolean var0E4174C981DCB834637488B851694644_76186026 = (matchFound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_324035602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_324035602;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.313 -0400", hash_original_method = "F2B231DFAE39F525F974692AFF77961B", hash_generated_method = "416E32831DE85115511F5BDD756628FD")
    public boolean matches() {
        matchFound = matchesImpl(address, input, matchOffsets);
    if(matchFound)        
        {
            findPos = matchOffsets[1];
        } 
        boolean var0E4174C981DCB834637488B851694644_1424794932 = (matchFound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195846151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195846151;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.313 -0400", hash_original_method = "AB3FAB8AD474566DF13ED737E690D125", hash_generated_method = "FB0555A1C3056EA9F4AE4EA56FB871D3")
    public int start(int group) throws IllegalStateException {
        addTaint(group);
        ensureMatch();
        int var6B08C4E6F893AFDCFB49A16AFA368822_800921641 = (matchOffsets[group * 2]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_688914530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_688914530;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.314 -0400", hash_original_method = "3B2B065B47272EA82FEECDA7C28418A1", hash_generated_method = "2C9D2CA2EA5F4D85AA8FCB580A13B802")
    public int end(int group) {
        addTaint(group);
        ensureMatch();
        int varF7AF7F4984A8410BE30EDD10FED34101_1028464347 = (matchOffsets[(group * 2) + 1]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71853815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71853815;
        
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.314 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "D476582947902C4A4B8D5494C47FA62B")
    public int start() {
        int var65754EB29CD48640473484E377E145B8_430443605 = (start(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271236229 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271236229;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.315 -0400", hash_original_method = "2C579AC6636E2BB6A85949F583F18EF9", hash_generated_method = "2C7D1D20544E1D4DE3025960C3A829F2")
    public int groupCount() {
        int var3288675F8AA029C328043FD1E6F67308_174348943 = (groupCountImpl(address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691985626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691985626;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.315 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "1BDF26281CE108A4317A42F1E23E8255")
    public int end() {
        int varCA35A8AADB641992D83E31AADD95BCC2_921773548 = (end(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120203097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120203097;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.315 -0400", hash_original_method = "AA5E91AED2A0230E676820BFF0A777EF", hash_generated_method = "6C6B04675FE611EE7E8D062390D3D093")
    public MatchResult toMatchResult() {
        ensureMatch();
MatchResult varC8FDB7F96980421E629760C82F38DDC7_1831482540 =         new MatchResultImpl(input, matchOffsets);
        varC8FDB7F96980421E629760C82F38DDC7_1831482540.addTaint(taint);
        return varC8FDB7F96980421E629760C82F38DDC7_1831482540;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.316 -0400", hash_original_method = "785D7AD880670D6D8A0DF6FCE0749ACB", hash_generated_method = "ED3A9432775FAE457921AA2EB433072F")
    public Matcher useAnchoringBounds(boolean value) {
        anchoringBounds = value;
        useAnchoringBoundsImpl(address, value);
Matcher var72A74007B2BE62B849F475C7BDA4658B_2049254877 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2049254877.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2049254877;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.316 -0400", hash_original_method = "56179EEEB1BB6D253C6C82DD4DB81ED5", hash_generated_method = "83889357B21A1D5EAA7278F98F5BB94E")
    public boolean hasAnchoringBounds() {
        boolean var19B3006D2C5C72B63F2948F86CE60FF2_2078966981 = (anchoringBounds);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071809943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071809943;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.316 -0400", hash_original_method = "EB1ABBA9A1AC428A5376D92D0ECDDD75", hash_generated_method = "FAC795EE6F841FEEC8259A462EB2A9E3")
    public Matcher useTransparentBounds(boolean value) {
        transparentBounds = value;
        useTransparentBoundsImpl(address, value);
Matcher var72A74007B2BE62B849F475C7BDA4658B_1620500452 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1620500452.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1620500452;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.317 -0400", hash_original_method = "62DD7ED3C887DF9CAF781EDBA38B8A50", hash_generated_method = "C06446A000FBB495DC0A172D1E7EBBF5")
    private void ensureMatch() {
    if(!matchFound)        
        {
            IllegalStateException var9684E0F6DFD7A709A943F77E9406046F_1610428125 = new IllegalStateException("No successful match so far");
            var9684E0F6DFD7A709A943F77E9406046F_1610428125.addTaint(taint);
            throw var9684E0F6DFD7A709A943F77E9406046F_1610428125;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.317 -0400", hash_original_method = "935CF82B5FBC95B795356ABD430E53CE", hash_generated_method = "E4550D2435FB37DD388CBBF2DA65AA8E")
    public boolean hasTransparentBounds() {
        boolean varEA05B80BA92F422C6A4E97CE3DB6F1F0_106514420 = (transparentBounds);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395519277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_395519277;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.317 -0400", hash_original_method = "1309D9DA3902B8EF77EAE3BBEDE0D6E3", hash_generated_method = "3CD28D6FA91D907FE5E861550B8BB6EC")
    public int regionStart() {
        int varECFFF1362128F72A357ECE9557617256_577929757 = (regionStart);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165844351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165844351;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.318 -0400", hash_original_method = "A2DEE293E79DD1E070648045D7A01545", hash_generated_method = "D8640AC9A7EFBB028AF55229C3F9C515")
    public int regionEnd() {
        int var93DE8CC916B0BCFB1D6128BF808B866E_1809154908 = (regionEnd);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127261294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127261294;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.318 -0400", hash_original_method = "6469C197EE58C69EE809CEC9FEDF2877", hash_generated_method = "237E3C3157A980110455FCE1BCE0FBFB")
    public boolean requireEnd() {
        boolean var96C6E91545DD29B17217EA3AF9C12A85_540779783 = (requireEndImpl(address));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1044999651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1044999651;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.318 -0400", hash_original_method = "EDB1A66CB81652E7B35BD52D60EF4E40", hash_generated_method = "1BE030C1A3667B910781544CEC4F389B")
    public boolean hitEnd() {
        boolean varAFD053EF07BBC569C02B1F0FD47E8A16_116115574 = (hitEndImpl(address));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981047952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981047952;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.319 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "268F081DD9CF1446BB7E8CE24D74FE6E")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            closeImpl(address);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
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

