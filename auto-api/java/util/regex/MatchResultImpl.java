package java.util.regex;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

class MatchResultImpl implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.566 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.566 -0400", hash_original_field = "831BD6D82461A6164F50E583F8749188", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private int[] offsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.566 -0400", hash_original_method = "2A7F503D795C5A57339C0129F572051A", hash_generated_method = "7096012F146361CD6F51844899818046")
      MatchResultImpl(String text, int[] offsets) {
        this.text = text;
        this.offsets = offsets.clone();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.566 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "6BDB39CC5F76F195808BBDBC86F08CC3")
    public int end() {
        int varD085614B73328778F16C47DE2FECFC57_621277751 = (end(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1084751371 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1084751371;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.567 -0400", hash_original_method = "65429E9FFFA86BB606D2EED833A40ABB", hash_generated_method = "3641E0A590073CFFB4071C9803D1E9FB")
    public int end(int group) {
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090265919 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090265919;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.567 -0400", hash_original_method = "6ED812525C326D14A5EB91FA01A3208C", hash_generated_method = "C20F98A58B0BBE491675984329024BA6")
    public String group() {
        String varB4EAC82CA7396A68D541C85D26508E83_2057509647 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2057509647 = text.substring(start(), end());
        varB4EAC82CA7396A68D541C85D26508E83_2057509647.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2057509647;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.568 -0400", hash_original_method = "018F540DDE0C3C1C686E1EDB2CD0CDCF", hash_generated_method = "BC94EFECC235881232F3ED487F459E5E")
    public String group(int group) {
        String varB4EAC82CA7396A68D541C85D26508E83_1766831498 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_711762738 = null; 
        int from = offsets[group * 2];
        int to = offsets[(group * 2) + 1];
        {
            varB4EAC82CA7396A68D541C85D26508E83_1766831498 = null;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_711762738 = text.substring(from, to);
        } 
        addTaint(group);
        String varA7E53CE21691AB073D9660D615818899_1802553499; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1802553499 = varB4EAC82CA7396A68D541C85D26508E83_1766831498;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1802553499 = varB4EAC82CA7396A68D541C85D26508E83_711762738;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1802553499.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1802553499;
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.568 -0400", hash_original_method = "F1AEADA2600B81876C4282B5C0543134", hash_generated_method = "C2F70F19D0CA116AE9B293E77FFC861A")
    public int groupCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895524672 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895524672;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.568 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "08AEFFC36E684DFD460704D75120FA2A")
    public int start() {
        int var2FA5FC50CE2538BDC8E886B2AA7A2178_345139991 = (start(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638671419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638671419;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.569 -0400", hash_original_method = "AECCCC3B75C18CF3285FB395DF7917FC", hash_generated_method = "1ED1A7AFA2BDEB8377B9A0BBDC0D84E8")
    public int start(int group) {
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445034846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445034846;
        
        
    }

    
}

