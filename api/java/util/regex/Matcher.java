package java.util.regex;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class Matcher implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "F8E35FE12BF69D119F3D49E111B1D9A2")

    private Pattern pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "ECFFF1362128F72A357ECE9557617256", hash_generated_field = "4BFD2E9911A5B09AFA78246F140BA69E")

    private int regionStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "93DE8CC916B0BCFB1D6128BF808B866E", hash_generated_field = "81B8E8F63D0573D4ED10DF96945C6FEF")

    private int regionEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "CBA38EE614CFC3B8B3563589CEE941DE", hash_generated_field = "12D45F7A9DCD34D02837FD43189B6ED4")

    private int findPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "C6ECF4653A20E3AE0B3EAED0AC081EF6", hash_generated_field = "7897EAE2C904551FD3FBA85C5C84AFAC")

    private int appendPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "0E4174C981DCB834637488B851694644", hash_generated_field = "7C4C3171C0696160D17E6982793E0AF8")

    private boolean matchFound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "394B4F383909BE2C1B724181C62146F3", hash_generated_field = "6F546FFAFB8033C940863BBC52B1D28B")

    private int[] matchOffsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "CCBC445CCB76CDC20299A7369C95C05A", hash_generated_field = "84D0C0F3D7AD96896E61ACD06804F92F")

    private boolean anchoringBounds = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.605 -0400", hash_original_field = "EA05B80BA92F422C6A4E97CE3DB6F1F0", hash_generated_field = "9AD9F3963812EC3748D564A27742AD96")

    private boolean transparentBounds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.606 -0400", hash_original_method = "3CAF328B13970C51C4DF071BCDFD21EA", hash_generated_method = "3772D21C32678A10B7E222AD4527DCCC")
      Matcher(Pattern pattern, CharSequence input) {
        usePattern(pattern);
        reset(input);
        addTaint(pattern.getTaint());
        addTaint(input.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.606 -0400", hash_original_method = "0ABA3494B4138038176605DE83A643DA", hash_generated_method = "0EF5995B05CE82FC8F4B5C192EF7E052")
    public Matcher appendReplacement(StringBuffer buffer, String replacement) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_348249739 = null; 
        buffer.append(input.substring(appendPos, start()));
        appendEvaluated(buffer, replacement);
        appendPos = end();
        varB4EAC82CA7396A68D541C85D26508E83_348249739 = this;
        addTaint(buffer.getTaint());
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_348249739.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_348249739;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.607 -0400", hash_original_method = "5B3F4DCDB18701B7EDED77C3B9D3C550", hash_generated_method = "BE6A2E5D739F9AAC86F9D585F98243CA")
    private void appendEvaluated(StringBuffer buffer, String s) {
        boolean escape = false;
        boolean dollar = false;
        {
            int i = 0;
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_1015496416 = (i < s.length());
            {
                char c = s.charAt(i);
                {
                    escape = true;
                } 
                {
                    dollar = true;
                } 
                {
                    buffer.append(group(c - '0'));
                    dollar = false;
                } 
                {
                    buffer.append(c);
                    dollar = false;
                    escape = false;
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException(s.length());
        } 
        addTaint(buffer.getTaint());
        addTaint(s.getTaint());
        
        
        
        
            
            
                
            
                
            
                
                
            
                
                
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.607 -0400", hash_original_method = "9AD9707639C16EE18626C91A471BEAF6", hash_generated_method = "15179A40F048D90E6E2FC60D293A1626")
    public Matcher reset() {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_124584736 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_124584736 = reset(input, 0, input.length());
        varB4EAC82CA7396A68D541C85D26508E83_124584736.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_124584736;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.608 -0400", hash_original_method = "6A88D6B012E13AB6428E01867B9DB072", hash_generated_method = "EA20762AE82420A2DA7F0459A5870EE5")
    public Matcher reset(CharSequence input) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1360957848 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1360957848 = reset(input, 0, input.length());
        addTaint(input.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1360957848.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1360957848;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.608 -0400", hash_original_method = "1E13D8D8B85E56AF9BB58282CB9C7392", hash_generated_method = "92238B21EFE02D1CC4B014A44A13DF95")
    private Matcher reset(CharSequence input, int start, int end) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1576377892 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        {
            boolean varF45ABFE6077AFC8486D01968E44A911F_1559353796 = (start < 0 || end < 0 || start > input.length() || end > input.length() || start > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } 
        } 
        this.input = input.toString();
        this.regionStart = start;
        this.regionEnd = end;
        resetForInput();
        matchFound = false;
        findPos = regionStart;
        appendPos = 0;
        varB4EAC82CA7396A68D541C85D26508E83_1576377892 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1576377892.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1576377892;
        
        
            
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.610 -0400", hash_original_method = "2FE41CFA985CF6A9EFE2D0795A2797F8", hash_generated_method = "4C70ED757244B985960D97F21F07C223")
    public Matcher usePattern(Pattern pattern) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_879169460 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        this.pattern = pattern;
        {
            closeImpl(address);
            address = 0;
        } 
        address = openImpl(pattern.address);
        {
            resetForInput();
        } 
        matchOffsets = new int[(groupCount() + 1) * 2];
        matchFound = false;
        varB4EAC82CA7396A68D541C85D26508E83_879169460 = this;
        varB4EAC82CA7396A68D541C85D26508E83_879169460.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_879169460;
        
        
            
        
        
        
            
            
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.610 -0400", hash_original_method = "4B8F5281B8D449CBFD7748E2AB98FC6B", hash_generated_method = "7103FCDC0C3502E02876C3BCAF9A118B")
    private void resetForInput() {
        setInputImpl(address, input, regionStart, regionEnd);
        useAnchoringBoundsImpl(address, anchoringBounds);
        useTransparentBoundsImpl(address, transparentBounds);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.611 -0400", hash_original_method = "764159AB96CDD9290AC2E4282412C52D", hash_generated_method = "22ECEC531B0FEE79AB188B1FC9C38FC7")
    public Matcher region(int start, int end) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_301058463 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_301058463 = reset(input, start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_301058463.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_301058463;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.611 -0400", hash_original_method = "26B8601C4A947AF0FE4D833433D4DFA4", hash_generated_method = "45ED2635D4FB3C99C3E7C193899C83E8")
    public StringBuffer appendTail(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1007126425 = null; 
        {
            buffer.append(input.substring(appendPos, regionEnd));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1007126425 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1007126425.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1007126425;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.612 -0400", hash_original_method = "902CB288EB494C9205FE6BF90EDE4AF5", hash_generated_method = "78799DC0BED45A9EB75D8FDB49336057")
    public String replaceFirst(String replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_1859964371 = null; 
        reset();
        StringBuffer buffer = new StringBuffer(input.length());
        {
            boolean var73BA7AA75A06BCD20094DC5116547A45_234364870 = (find());
            {
                appendReplacement(buffer, replacement);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1859964371 = appendTail(buffer).toString();
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1859964371.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1859964371;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.612 -0400", hash_original_method = "DCC3E518C2D0EED9BFA3E6DD970895A0", hash_generated_method = "6EE1D83679B09894BE4B95DEB158E9AF")
    public String replaceAll(String replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_1280772358 = null; 
        reset();
        StringBuffer buffer = new StringBuffer(input.length());
        {
            boolean var73BA7AA75A06BCD20094DC5116547A45_1194381380 = (find());
            {
                appendReplacement(buffer, replacement);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1280772358 = appendTail(buffer).toString();
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1280772358.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1280772358;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.613 -0400", hash_original_method = "29D81214171EEBB46568323FF70F06B8", hash_generated_method = "5CC93A7A441F76740E1B94CB69306B79")
    public Pattern pattern() {
        Pattern varB4EAC82CA7396A68D541C85D26508E83_2108706940 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2108706940 = pattern;
        varB4EAC82CA7396A68D541C85D26508E83_2108706940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2108706940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.613 -0400", hash_original_method = "C5DB0A67F29696168A3714469C702630", hash_generated_method = "754FD8F12B07030A0ECE9569716D4A80")
    public String group(int group) {
        String varB4EAC82CA7396A68D541C85D26508E83_757263626 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_609683113 = null; 
        ensureMatch();
        int from = matchOffsets[group * 2];
        int to = matchOffsets[(group * 2) + 1];
        {
            varB4EAC82CA7396A68D541C85D26508E83_757263626 = null;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_609683113 = input.substring(from, to);
        } 
        addTaint(group);
        String varA7E53CE21691AB073D9660D615818899_1772454445; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1772454445 = varB4EAC82CA7396A68D541C85D26508E83_757263626;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1772454445 = varB4EAC82CA7396A68D541C85D26508E83_609683113;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1772454445.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1772454445;
        
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.614 -0400", hash_original_method = "B66B9D5A22E4810AC45D3DC362BC1AC2", hash_generated_method = "005178881FD9BA2D36CDDD8A77F342B7")
    public String group() {
        String varB4EAC82CA7396A68D541C85D26508E83_929569674 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_929569674 = group(0);
        varB4EAC82CA7396A68D541C85D26508E83_929569674.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_929569674;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.614 -0400", hash_original_method = "1E0A41464CCCF143B80A589A774A22D2", hash_generated_method = "12A6C30B713AECA456D93A980D5F25D8")
    public boolean find(int start) {
        findPos = start;
        {
            findPos = regionStart;
        } 
        {
            matchFound = false;
        } 
        matchFound = findImpl(address, input, findPos, matchOffsets);
        {
            findPos = matchOffsets[1];
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16628570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16628570;
        
        
        
            
        
            
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.615 -0400", hash_original_method = "B9818686B652967984036901E54AA9CC", hash_generated_method = "B5503D4ECAB92608BE5E5828467F651C")
    public boolean find() {
        matchFound = findNextImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963914101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_963914101;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.615 -0400", hash_original_method = "97077CE30676723FC89EE7203F75639E", hash_generated_method = "DE415ED3B477614948ED21EA469FADBF")
    public boolean lookingAt() {
        matchFound = lookingAtImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121021105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121021105;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.615 -0400", hash_original_method = "F2B231DFAE39F525F974692AFF77961B", hash_generated_method = "7FA39308EF9FE4D8437A740587E4551C")
    public boolean matches() {
        matchFound = matchesImpl(address, input, matchOffsets);
        {
            findPos = matchOffsets[1];
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160614123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160614123;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.616 -0400", hash_original_method = "AB3FAB8AD474566DF13ED737E690D125", hash_generated_method = "081D6D305D3AFE7616BEBBE202FCC047")
    public int start(int group) throws IllegalStateException {
        ensureMatch();
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1601255419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1601255419;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.616 -0400", hash_original_method = "3B2B065B47272EA82FEECDA7C28418A1", hash_generated_method = "4A9E32163C3FB5BE1410B375FA7618C1")
    public int end(int group) {
        ensureMatch();
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126254375 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126254375;
        
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.617 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "142E32E5F2FD72D966BFCB0C91B75E51")
    public int start() {
        int var2FA5FC50CE2538BDC8E886B2AA7A2178_740560430 = (start(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616301546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616301546;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.617 -0400", hash_original_method = "2C579AC6636E2BB6A85949F583F18EF9", hash_generated_method = "5B09CF8F947398351A8DC07A0264A4CF")
    public int groupCount() {
        int varE3909558008410CE21184D2303B66659_2110472164 = (groupCountImpl(address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920272972 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920272972;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.617 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "E93E8C71A8AC1E8683797FE6D3236B01")
    public int end() {
        int varD085614B73328778F16C47DE2FECFC57_2126766961 = (end(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552608858 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552608858;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.618 -0400", hash_original_method = "AA5E91AED2A0230E676820BFF0A777EF", hash_generated_method = "4CA6EC1A6C738C00B0314DF0CBD316CE")
    public MatchResult toMatchResult() {
        MatchResult varB4EAC82CA7396A68D541C85D26508E83_108318784 = null; 
        ensureMatch();
        varB4EAC82CA7396A68D541C85D26508E83_108318784 = new MatchResultImpl(input, matchOffsets);
        varB4EAC82CA7396A68D541C85D26508E83_108318784.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_108318784;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.618 -0400", hash_original_method = "785D7AD880670D6D8A0DF6FCE0749ACB", hash_generated_method = "578C85452F0B05FCDF2EC82B0DE25FD7")
    public Matcher useAnchoringBounds(boolean value) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1561828990 = null; 
        anchoringBounds = value;
        useAnchoringBoundsImpl(address, value);
        varB4EAC82CA7396A68D541C85D26508E83_1561828990 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1561828990.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1561828990;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.618 -0400", hash_original_method = "56179EEEB1BB6D253C6C82DD4DB81ED5", hash_generated_method = "C4C49B428893A45308DCD8EF06D07636")
    public boolean hasAnchoringBounds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1332558461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1332558461;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.619 -0400", hash_original_method = "EB1ABBA9A1AC428A5376D92D0ECDDD75", hash_generated_method = "9BBF12243CF19C1A51206903C9951923")
    public Matcher useTransparentBounds(boolean value) {
        Matcher varB4EAC82CA7396A68D541C85D26508E83_1195219418 = null; 
        transparentBounds = value;
        useTransparentBoundsImpl(address, value);
        varB4EAC82CA7396A68D541C85D26508E83_1195219418 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1195219418.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1195219418;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.619 -0400", hash_original_method = "62DD7ED3C887DF9CAF781EDBA38B8A50", hash_generated_method = "92D502465B077044DA797A146EFC9F83")
    private void ensureMatch() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No successful match so far");
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.619 -0400", hash_original_method = "935CF82B5FBC95B795356ABD430E53CE", hash_generated_method = "A2458E676C16D273391B81EB4544A9EA")
    public boolean hasTransparentBounds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247485869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247485869;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.620 -0400", hash_original_method = "1309D9DA3902B8EF77EAE3BBEDE0D6E3", hash_generated_method = "F71C3955DE0112FA13AECA4C2D64A73A")
    public int regionStart() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020081873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020081873;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.620 -0400", hash_original_method = "A2DEE293E79DD1E070648045D7A01545", hash_generated_method = "8C3DF3847BFAFF567FF5045D49C16AE2")
    public int regionEnd() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580445114 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580445114;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.620 -0400", hash_original_method = "6469C197EE58C69EE809CEC9FEDF2877", hash_generated_method = "CD18DD9F0D9970936E8CE9F27EAF0CF0")
    public boolean requireEnd() {
        boolean varEF751A2F8A30FD1B90C84328A8A15FD6_1454553680 = (requireEndImpl(address));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153292393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153292393;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.621 -0400", hash_original_method = "EDB1A66CB81652E7B35BD52D60EF4E40", hash_generated_method = "918D19FEF3D0E70D4F41F5FCD31ABD40")
    public boolean hitEnd() {
        boolean var465B0EDCB419577F061CD4A8EF4B39F7_562964243 = (hitEndImpl(address));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923404050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_923404050;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.621 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "268F081DD9CF1446BB7E8CE24D74FE6E")
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

