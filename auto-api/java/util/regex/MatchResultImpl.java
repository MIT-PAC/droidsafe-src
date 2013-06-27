package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class MatchResultImpl implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.406 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.406 -0400", hash_original_field = "831BD6D82461A6164F50E583F8749188", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private int[] offsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.407 -0400", hash_original_method = "2A7F503D795C5A57339C0129F572051A", hash_generated_method = "7096012F146361CD6F51844899818046")
      MatchResultImpl(String text, int[] offsets) {
        this.text = text;
        this.offsets = offsets.clone();
        // ---------- Original Method ----------
        //this.text = text;
        //this.offsets = offsets.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.414 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "3F9303C9A4ED3136F1982194CAB81EFA")
    public int end() {
        int varD085614B73328778F16C47DE2FECFC57_980571636 = (end(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763385017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763385017;
        // ---------- Original Method ----------
        //return end(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.414 -0400", hash_original_method = "65429E9FFFA86BB606D2EED833A40ABB", hash_generated_method = "0A80DCE9FEDCF6EFF6C2F5D44DD7867B")
    public int end(int group) {
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634982374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634982374;
        // ---------- Original Method ----------
        //return offsets[2 * group + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.415 -0400", hash_original_method = "6ED812525C326D14A5EB91FA01A3208C", hash_generated_method = "8391ACD85A6072C1853E7B56B8034517")
    public String group() {
        String varB4EAC82CA7396A68D541C85D26508E83_906839390 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_906839390 = text.substring(start(), end());
        varB4EAC82CA7396A68D541C85D26508E83_906839390.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_906839390;
        // ---------- Original Method ----------
        //return text.substring(start(), end());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.416 -0400", hash_original_method = "018F540DDE0C3C1C686E1EDB2CD0CDCF", hash_generated_method = "EC65620571BB89B07125F312DEFADF89")
    public String group(int group) {
        String varB4EAC82CA7396A68D541C85D26508E83_111178491 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1552914415 = null; //Variable for return #2
        int from;
        from = offsets[group * 2];
        int to;
        to = offsets[(group * 2) + 1];
        {
            varB4EAC82CA7396A68D541C85D26508E83_111178491 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1552914415 = text.substring(from, to);
        } //End block
        addTaint(group);
        String varA7E53CE21691AB073D9660D615818899_1117686371; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1117686371 = varB4EAC82CA7396A68D541C85D26508E83_111178491;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1117686371 = varB4EAC82CA7396A68D541C85D26508E83_1552914415;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1117686371.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1117686371;
        // ---------- Original Method ----------
        //int from = offsets[group * 2];
        //int to = offsets[(group * 2) + 1];
        //if (from == -1 || to == -1) {
            //return null;
        //} else {
            //return text.substring(from, to);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.416 -0400", hash_original_method = "F1AEADA2600B81876C4282B5C0543134", hash_generated_method = "C654E3C37793CD6B9C1ECBDF51552393")
    public int groupCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064870559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064870559;
        // ---------- Original Method ----------
        //return (offsets.length / 2) - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.417 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "CC9E44842908B196E947EC2B6625DB28")
    public int start() {
        int var2FA5FC50CE2538BDC8E886B2AA7A2178_753753188 = (start(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504624738 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504624738;
        // ---------- Original Method ----------
        //return start(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.417 -0400", hash_original_method = "AECCCC3B75C18CF3285FB395DF7917FC", hash_generated_method = "0D7453B67E272E638C4262B225620510")
    public int start(int group) {
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907269388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907269388;
        // ---------- Original Method ----------
        //return offsets[2 * group];
    }

    
}

