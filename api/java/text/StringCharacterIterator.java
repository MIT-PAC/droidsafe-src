package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class StringCharacterIterator implements CharacterIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.294 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.294 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

    int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.295 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

    int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.295 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.295 -0400", hash_original_method = "DAE1DA2C567D7E8FDA6EBD1FE5405924", hash_generated_method = "61D955F47042EEBAE171065441D93BDE")
    public  StringCharacterIterator(String value) {
        string = value;
        start = offset = 0;
        end = string.length();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.295 -0400", hash_original_method = "5C2CF51DC0D0A9D0DCD2C7E4ADB28E8E", hash_generated_method = "510DC00F3B09306C8E907D29BEC1747B")
    public  StringCharacterIterator(String value, int location) {
        string = value;
        start = 0;
        end = string.length();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        offset = location;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.296 -0400", hash_original_method = "704865465DB7061F34F598DD3605E202", hash_generated_method = "9B10556FB1E92CE8C6A7BD2A28DB42E2")
    public  StringCharacterIterator(String value, int start, int end, int location) {
        string = value;
        {
            boolean var7E6A1450C2AD9DE97936A8CA5751A69D_284017530 = (start < 0 || end > string.length() || start > end
                || location < start || location > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        this.start = start;
        this.end = end;
        offset = location;
        
        
        
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.297 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "1CFE9FD98A4F18486B4C75E56A3777BB")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1400167217 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1400167217 = super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1400167217.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1400167217;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.297 -0400", hash_original_method = "0495E4BE554B279F8C8552A3E8BBAE9B", hash_generated_method = "193DB33A4A610A2BA45B3D5F8A1FC1B1")
    public char current() {
        char var21B7B547718317726EE4A22CD454BA01_933217872 = (string.charAt(offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1433440828 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1433440828;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.297 -0400", hash_original_method = "4A7E92C9AA8B158215F27F7CAB59071D", hash_generated_method = "992EE120B5FBC29182C9CBF2ADA6466E")
    @Override
    public boolean equals(Object object) {
        StringCharacterIterator it = (StringCharacterIterator) object;
        boolean var81DC82203AB0F08D0DDD7ACB6D612DC1_1712623089 = (string.equals(it.string) && start == it.start && end == it.end
                && offset == it.offset);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724580750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724580750;
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.298 -0400", hash_original_method = "B333B42236D9FFA1243D291D9F8E02D4", hash_generated_method = "07FF3B92070DE29A1FBE971CAEB8779B")
    public char first() {
        offset = start;
        char var21B7B547718317726EE4A22CD454BA01_1984967063 = (string.charAt(offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_2121500746 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2121500746;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.298 -0400", hash_original_method = "C91A51EED2BDD0863CA60178FB31B7F7", hash_generated_method = "D30A9E5F7E4516EF1B995E195011038A")
    public int getBeginIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271241892 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271241892;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.299 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "E6ACFE3E5C08ED98E0DC0BCF5870FF1A")
    public int getEndIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_293415067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_293415067;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.299 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "05EA21AE47A6A5FC7D483102FA72BB54")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295273262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295273262;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.301 -0400", hash_original_method = "261EF3CD78C94C444435F1728CE93178", hash_generated_method = "26289A8E5266294B1F9FEEDDAACF2880")
    @Override
    public int hashCode() {
        int varC302329FBC202906BCCCE10F9522C378_1546839520 = (string.hashCode() + start + end + offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142136781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142136781;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.302 -0400", hash_original_method = "920E2CC099037AFE91302301CF7E9F3E", hash_generated_method = "163B019551F0061CF4F3D17CC4218485")
    public char last() {
        offset = end - 1;
        char var21B7B547718317726EE4A22CD454BA01_524144223 = (string.charAt(offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1571704464 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1571704464;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.304 -0400", hash_original_method = "8F260F0099582263F775831BBCA28C0F", hash_generated_method = "18CC4C49B92B7AD4ED8F5CC092EC64B0")
    public char next() {
        {
            offset = end;
        } 
        char var238AEF82B15A80F78B72DEC013544975_1633211220 = (string.charAt(++offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_196163271 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_196163271;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.305 -0400", hash_original_method = "6641F70E0E9C6153122A4B9C58397241", hash_generated_method = "10AF1F82C89FA3EAB2A964F67E2166F6")
    public char previous() {
        char var420CAAE2ECFCDE70CA387D7F943D6777_530829273 = (string.charAt(--offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1469090027 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1469090027;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.305 -0400", hash_original_method = "EE5D609C4869D1C6E36BED6C6655B503", hash_generated_method = "2709E399A408788C245FA326BF1EE07B")
    public char setIndex(int location) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        offset = location;
        char var21B7B547718317726EE4A22CD454BA01_903111100 = (string.charAt(offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_712519164 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_712519164;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.306 -0400", hash_original_method = "C3050CECF999A44D7D35577309274942", hash_generated_method = "16F449977253B2E84B6BB597D2C69A77")
    public void setText(String value) {
        string = value;
        start = offset = 0;
        end = value.length();
        
        
        
        
    }

    
}

