package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StringCharacterIterator implements CharacterIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.958 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.958 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

    int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.958 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

    int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.958 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.959 -0400", hash_original_method = "DAE1DA2C567D7E8FDA6EBD1FE5405924", hash_generated_method = "61D955F47042EEBAE171065441D93BDE")
    public  StringCharacterIterator(String value) {
        string = value;
        start = offset = 0;
        end = string.length();
        // ---------- Original Method ----------
        //string = value;
        //start = offset = 0;
        //end = string.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.970 -0400", hash_original_method = "5C2CF51DC0D0A9D0DCD2C7E4ADB28E8E", hash_generated_method = "510DC00F3B09306C8E907D29BEC1747B")
    public  StringCharacterIterator(String value, int location) {
        string = value;
        start = 0;
        end = string.length();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        offset = location;
        // ---------- Original Method ----------
        //string = value;
        //start = 0;
        //end = string.length();
        //if (location < 0 || location > end) {
            //throw new IllegalArgumentException();
        //}
        //offset = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.970 -0400", hash_original_method = "704865465DB7061F34F598DD3605E202", hash_generated_method = "11995F4DA38DE3E63C0FE59A5DA33653")
    public  StringCharacterIterator(String value, int start, int end, int location) {
        string = value;
        {
            boolean var7E6A1450C2AD9DE97936A8CA5751A69D_1863579563 = (start < 0 || end > string.length() || start > end
                || location < start || location > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        this.start = start;
        this.end = end;
        offset = location;
        // ---------- Original Method ----------
        //string = value;
        //if (start < 0 || end > string.length() || start > end
                //|| location < start || location > end) {
            //throw new IllegalArgumentException();
        //}
        //this.start = start;
        //this.end = end;
        //offset = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.971 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "10169418601FC996327F94E68762F2C8")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_166565337 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_166565337 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_166565337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_166565337;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.975 -0400", hash_original_method = "0495E4BE554B279F8C8552A3E8BBAE9B", hash_generated_method = "5C032A3AC5E443D59639270DBA1DC9E6")
    public char current() {
        char var21B7B547718317726EE4A22CD454BA01_1501109661 = (string.charAt(offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_287075809 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_287075809;
        // ---------- Original Method ----------
        //if (offset == end) {
            //return DONE;
        //}
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.976 -0400", hash_original_method = "4A7E92C9AA8B158215F27F7CAB59071D", hash_generated_method = "D55EB405081456F812FD4C41D2E5C0CD")
    @Override
    public boolean equals(Object object) {
        StringCharacterIterator it;
        it = (StringCharacterIterator) object;
        boolean var81DC82203AB0F08D0DDD7ACB6D612DC1_2049766396 = (string.equals(it.string) && start == it.start && end == it.end
                && offset == it.offset);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_424710132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_424710132;
        // ---------- Original Method ----------
        //if (!(object instanceof StringCharacterIterator)) {
            //return false;
        //}
        //StringCharacterIterator it = (StringCharacterIterator) object;
        //return string.equals(it.string) && start == it.start && end == it.end
                //&& offset == it.offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.985 -0400", hash_original_method = "B333B42236D9FFA1243D291D9F8E02D4", hash_generated_method = "05C1D262316BF8E94AD62F277905233E")
    public char first() {
        offset = start;
        char var21B7B547718317726EE4A22CD454BA01_503383142 = (string.charAt(offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1227912244 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1227912244;
        // ---------- Original Method ----------
        //if (start == end) {
            //return DONE;
        //}
        //offset = start;
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.986 -0400", hash_original_method = "C91A51EED2BDD0863CA60178FB31B7F7", hash_generated_method = "E9FABB1D74B53EAAF020FFEB07C7A058")
    public int getBeginIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984054197 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984054197;
        // ---------- Original Method ----------
        //return start;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.987 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "389C54DC3F5D3E4E3F30C12D6B6E0E68")
    public int getEndIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314659834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314659834;
        // ---------- Original Method ----------
        //return end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.987 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "01DA246F3F392549458B2FD000CA62BE")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126927945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126927945;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.987 -0400", hash_original_method = "261EF3CD78C94C444435F1728CE93178", hash_generated_method = "7268A22FA447A1AA83764EBC35465ABD")
    @Override
    public int hashCode() {
        int varC302329FBC202906BCCCE10F9522C378_673718243 = (string.hashCode() + start + end + offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690696627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690696627;
        // ---------- Original Method ----------
        //return string.hashCode() + start + end + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.988 -0400", hash_original_method = "920E2CC099037AFE91302301CF7E9F3E", hash_generated_method = "11BF5AE3EF081238B14338D765CABA6B")
    public char last() {
        offset = end - 1;
        char var21B7B547718317726EE4A22CD454BA01_1405983407 = (string.charAt(offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1193391624 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1193391624;
        // ---------- Original Method ----------
        //if (start == end) {
            //return DONE;
        //}
        //offset = end - 1;
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.988 -0400", hash_original_method = "8F260F0099582263F775831BBCA28C0F", hash_generated_method = "697CF39337C2CF6B7D2BA334EE0598C0")
    public char next() {
        {
            offset = end;
        } //End block
        char var238AEF82B15A80F78B72DEC013544975_2083271784 = (string.charAt(++offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1636774879 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1636774879;
        // ---------- Original Method ----------
        //if (offset >= (end - 1)) {
            //offset = end;
            //return DONE;
        //}
        //return string.charAt(++offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.989 -0400", hash_original_method = "6641F70E0E9C6153122A4B9C58397241", hash_generated_method = "95D7FCD737839BC89D82619E5C3007DB")
    public char previous() {
        char var420CAAE2ECFCDE70CA387D7F943D6777_416170613 = (string.charAt(--offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1691112283 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1691112283;
        // ---------- Original Method ----------
        //if (offset == start) {
            //return DONE;
        //}
        //return string.charAt(--offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.998 -0400", hash_original_method = "EE5D609C4869D1C6E36BED6C6655B503", hash_generated_method = "95827EAEE28CF7A4A2F323AF21FAEFFB")
    public char setIndex(int location) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        offset = location;
        char var21B7B547718317726EE4A22CD454BA01_1816774233 = (string.charAt(offset));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1045170591 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1045170591;
        // ---------- Original Method ----------
        //if (location < start || location > end) {
            //throw new IllegalArgumentException();
        //}
        //offset = location;
        //if (offset == end) {
            //return DONE;
        //}
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.008 -0400", hash_original_method = "C3050CECF999A44D7D35577309274942", hash_generated_method = "16F449977253B2E84B6BB597D2C69A77")
    public void setText(String value) {
        string = value;
        start = offset = 0;
        end = value.length();
        // ---------- Original Method ----------
        //string = value;
        //start = offset = 0;
        //end = value.length();
    }

    
}

