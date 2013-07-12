package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class StringCharacterIterator implements CharacterIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.928 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.929 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

    int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.929 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

    int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.929 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.930 -0400", hash_original_method = "DAE1DA2C567D7E8FDA6EBD1FE5405924", hash_generated_method = "61D955F47042EEBAE171065441D93BDE")
    public  StringCharacterIterator(String value) {
        string = value;
        start = offset = 0;
        end = string.length();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.930 -0400", hash_original_method = "5C2CF51DC0D0A9D0DCD2C7E4ADB28E8E", hash_generated_method = "03D5E3E5F0EEB1FA00287999DFF61EAE")
    public  StringCharacterIterator(String value, int location) {
        string = value;
        start = 0;
        end = string.length();
    if(location < 0 || location > end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_38232753 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_38232753.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_38232753;
        } 
        offset = location;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.931 -0400", hash_original_method = "704865465DB7061F34F598DD3605E202", hash_generated_method = "E4A4F356C3FCAF37FD728B76AB003BBD")
    public  StringCharacterIterator(String value, int start, int end, int location) {
        string = value;
    if(start < 0 || end > string.length() || start > end
                || location < start || location > end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2098828454 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2098828454.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2098828454;
        } 
        this.start = start;
        this.end = end;
        offset = location;
        
        
        
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.932 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "BBEF4AF8D839AFF99B6BA017C61BC8BF")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_828448027 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_828448027.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_828448027;
        } 
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_846600868 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_846600868.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_846600868;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.932 -0400", hash_original_method = "0495E4BE554B279F8C8552A3E8BBAE9B", hash_generated_method = "D26DD0D8DA31D65BEF05A6106389FF8D")
    public char current() {
    if(offset == end)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_812910196 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_945208208 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_945208208;
        } 
        char var721AA069F761152C09EB16E9E8C899B9_1318138831 = (string.charAt(offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1463544206 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1463544206;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.932 -0400", hash_original_method = "4A7E92C9AA8B158215F27F7CAB59071D", hash_generated_method = "269562287F4EB04509CF7F3EE6CADAD3")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(!(object instanceof StringCharacterIterator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1539923863 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608448740 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_608448740;
        } 
        StringCharacterIterator it = (StringCharacterIterator) object;
        boolean varE97EE582A82473061DA20F1E791A5FE2_652346192 = (string.equals(it.string) && start == it.start && end == it.end
                && offset == it.offset);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842152552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842152552;
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.933 -0400", hash_original_method = "B333B42236D9FFA1243D291D9F8E02D4", hash_generated_method = "EB6164B96FCEFE4DF458ECD37B8B55C5")
    public char first() {
    if(start == end)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_190145053 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1393203497 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1393203497;
        } 
        offset = start;
        char var721AA069F761152C09EB16E9E8C899B9_1225335388 = (string.charAt(offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1427645944 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1427645944;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.933 -0400", hash_original_method = "C91A51EED2BDD0863CA60178FB31B7F7", hash_generated_method = "B72D31F688B64CBAB8FF06C492ED2F2C")
    public int getBeginIndex() {
        int varEA2B2676C28C0DB26D39331A336C6B92_1150967681 = (start);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925058246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925058246;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.933 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "6A2FD653278EF0FE7A62E7FCBD05346D")
    public int getEndIndex() {
        int var7F021A1415B86F2D013B2618FB31AE53_354742691 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509642257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509642257;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.934 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "55687B0CCCF35C747275140EF2F66A40")
    public int getIndex() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_2096645208 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811420279 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811420279;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.934 -0400", hash_original_method = "261EF3CD78C94C444435F1728CE93178", hash_generated_method = "EF04B125CA68CD5A82CEE3D26A07A4B1")
    @Override
    public int hashCode() {
        int var1EE1504AE6C76CDF0E633425310C3EEC_1298067434 = (string.hashCode() + start + end + offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147036687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147036687;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.934 -0400", hash_original_method = "920E2CC099037AFE91302301CF7E9F3E", hash_generated_method = "A6DF8E7D03E6F5C25FCA4977BFB74BB3")
    public char last() {
    if(start == end)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_705979858 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_885554038 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_885554038;
        } 
        offset = end - 1;
        char var721AA069F761152C09EB16E9E8C899B9_959483732 = (string.charAt(offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_871538411 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_871538411;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.935 -0400", hash_original_method = "8F260F0099582263F775831BBCA28C0F", hash_generated_method = "50465A609B21F33994E1A0563D8378F7")
    public char next() {
    if(offset >= (end - 1))        
        {
            offset = end;
            char var2BA22E58CA17BB728D522BBA36CF8350_492245548 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_287302938 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_287302938;
        } 
        char var8120EFC8EA6EC39FFC83C09CBC143231_264923412 = (string.charAt(++offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_661922629 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_661922629;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.935 -0400", hash_original_method = "6641F70E0E9C6153122A4B9C58397241", hash_generated_method = "6808FB125E4B74DF73996238C47880B8")
    public char previous() {
    if(offset == start)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_1624764137 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_594388025 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_594388025;
        } 
        char var85D9FBB298252268E258650FAC9E12B3_1182126095 = (string.charAt(--offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_87851677 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_87851677;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.936 -0400", hash_original_method = "EE5D609C4869D1C6E36BED6C6655B503", hash_generated_method = "0EEE341EA7C623A9A84E79332BAB8378")
    public char setIndex(int location) {
    if(location < start || location > end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2071518993 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2071518993.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2071518993;
        } 
        offset = location;
    if(offset == end)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_391121112 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_155681017 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_155681017;
        } 
        char var721AA069F761152C09EB16E9E8C899B9_872384220 = (string.charAt(offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1802300292 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1802300292;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.936 -0400", hash_original_method = "C3050CECF999A44D7D35577309274942", hash_generated_method = "16F449977253B2E84B6BB597D2C69A77")
    public void setText(String value) {
        string = value;
        start = offset = 0;
        end = value.length();
        
        
        
        
    }

    
}

