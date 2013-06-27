package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class MatchResultImpl implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.137 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.137 -0400", hash_original_field = "831BD6D82461A6164F50E583F8749188", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private int[] offsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.144 -0400", hash_original_method = "2A7F503D795C5A57339C0129F572051A", hash_generated_method = "7096012F146361CD6F51844899818046")
      MatchResultImpl(String text, int[] offsets) {
        this.text = text;
        this.offsets = offsets.clone();
        // ---------- Original Method ----------
        //this.text = text;
        //this.offsets = offsets.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.144 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "9128006CC390940EA27B7C740B8D1746")
    public int end() {
        int varD085614B73328778F16C47DE2FECFC57_745569787 = (end(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239611087 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239611087;
        // ---------- Original Method ----------
        //return end(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.146 -0400", hash_original_method = "65429E9FFFA86BB606D2EED833A40ABB", hash_generated_method = "F8B88B48CE61A22481B84567B13AF76F")
    public int end(int group) {
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23533808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23533808;
        // ---------- Original Method ----------
        //return offsets[2 * group + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.150 -0400", hash_original_method = "6ED812525C326D14A5EB91FA01A3208C", hash_generated_method = "8124410577D82572739478AD4AD38111")
    public String group() {
        String varB4EAC82CA7396A68D541C85D26508E83_90162587 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_90162587 = text.substring(start(), end());
        varB4EAC82CA7396A68D541C85D26508E83_90162587.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90162587;
        // ---------- Original Method ----------
        //return text.substring(start(), end());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.151 -0400", hash_original_method = "018F540DDE0C3C1C686E1EDB2CD0CDCF", hash_generated_method = "521347379591503CE37DE96D54542F5C")
    public String group(int group) {
        String varB4EAC82CA7396A68D541C85D26508E83_474287797 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1517657517 = null; //Variable for return #2
        int from;
        from = offsets[group * 2];
        int to;
        to = offsets[(group * 2) + 1];
        {
            varB4EAC82CA7396A68D541C85D26508E83_474287797 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1517657517 = text.substring(from, to);
        } //End block
        addTaint(group);
        String varA7E53CE21691AB073D9660D615818899_30849170; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_30849170 = varB4EAC82CA7396A68D541C85D26508E83_474287797;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_30849170 = varB4EAC82CA7396A68D541C85D26508E83_1517657517;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_30849170.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_30849170;
        // ---------- Original Method ----------
        //int from = offsets[group * 2];
        //int to = offsets[(group * 2) + 1];
        //if (from == -1 || to == -1) {
            //return null;
        //} else {
            //return text.substring(from, to);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.161 -0400", hash_original_method = "F1AEADA2600B81876C4282B5C0543134", hash_generated_method = "DBD670901533680C8585875A848A9998")
    public int groupCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851404699 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851404699;
        // ---------- Original Method ----------
        //return (offsets.length / 2) - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.163 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "0E5BD22568A70B5285996551DC7635BB")
    public int start() {
        int var2FA5FC50CE2538BDC8E886B2AA7A2178_1100651892 = (start(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108569084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108569084;
        // ---------- Original Method ----------
        //return start(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.163 -0400", hash_original_method = "AECCCC3B75C18CF3285FB395DF7917FC", hash_generated_method = "4F1489913A6429694C591A227A0E8043")
    public int start(int group) {
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013140336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013140336;
        // ---------- Original Method ----------
        //return offsets[2 * group];
    }

    
}

