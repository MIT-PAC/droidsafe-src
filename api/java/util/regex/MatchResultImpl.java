package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class MatchResultImpl implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.261 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.261 -0400", hash_original_field = "831BD6D82461A6164F50E583F8749188", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private int[] offsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.263 -0400", hash_original_method = "2A7F503D795C5A57339C0129F572051A", hash_generated_method = "7096012F146361CD6F51844899818046")
      MatchResultImpl(String text, int[] offsets) {
        this.text = text;
        this.offsets = offsets.clone();
        // ---------- Original Method ----------
        //this.text = text;
        //this.offsets = offsets.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.263 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "BD7B457E3546A5F3EDE989A6C22B339E")
    public int end() {
        int varCA35A8AADB641992D83E31AADD95BCC2_1477694201 = (end(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_39017874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_39017874;
        // ---------- Original Method ----------
        //return end(0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.264 -0400", hash_original_method = "65429E9FFFA86BB606D2EED833A40ABB", hash_generated_method = "CA2EAE7FD803CC4DE6E4DFFD433CF997")
    public int end(int group) {
        addTaint(group);
        int varD32528EE803CDF12A396D45AC86559DC_761089993 = (offsets[2 * group + 1]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671190881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671190881;
        // ---------- Original Method ----------
        //return offsets[2 * group + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.264 -0400", hash_original_method = "6ED812525C326D14A5EB91FA01A3208C", hash_generated_method = "FD332542E91914EE8745FAD28205B8C0")
    public String group() {
String varC3BFC35EE8D0C434FE4840E3B4FC6A28_1994870237 =         text.substring(start(), end());
        varC3BFC35EE8D0C434FE4840E3B4FC6A28_1994870237.addTaint(taint);
        return varC3BFC35EE8D0C434FE4840E3B4FC6A28_1994870237;
        // ---------- Original Method ----------
        //return text.substring(start(), end());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.264 -0400", hash_original_method = "018F540DDE0C3C1C686E1EDB2CD0CDCF", hash_generated_method = "A1FCF6275BAA70127EDD46A3B6886CC3")
    public String group(int group) {
        addTaint(group);
        int from = offsets[group * 2];
        int to = offsets[(group * 2) + 1];
    if(from == -1 || to == -1)        
        {
String var540C13E9E156B687226421B24F2DF178_1045756739 =             null;
            var540C13E9E156B687226421B24F2DF178_1045756739.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1045756739;
        } //End block
        else
        {
String var2515E3E0F4436F57CDAB8003F8B9065A_1471446749 =             text.substring(from, to);
            var2515E3E0F4436F57CDAB8003F8B9065A_1471446749.addTaint(taint);
            return var2515E3E0F4436F57CDAB8003F8B9065A_1471446749;
        } //End block
        // ---------- Original Method ----------
        //int from = offsets[group * 2];
        //int to = offsets[(group * 2) + 1];
        //if (from == -1 || to == -1) {
            //return null;
        //} else {
            //return text.substring(from, to);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.265 -0400", hash_original_method = "F1AEADA2600B81876C4282B5C0543134", hash_generated_method = "ED8D4769FA68547273D777DDD00420EF")
    public int groupCount() {
        int varBE45F975A752B102894AE738129E1FB5_2128485649 = ((offsets.length / 2) - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_136351794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_136351794;
        // ---------- Original Method ----------
        //return (offsets.length / 2) - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.265 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "D02D31D6C03F17529329F7EF20807C87")
    public int start() {
        int var65754EB29CD48640473484E377E145B8_855529211 = (start(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992798149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992798149;
        // ---------- Original Method ----------
        //return start(0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.266 -0400", hash_original_method = "AECCCC3B75C18CF3285FB395DF7917FC", hash_generated_method = "F48E28D2B8A26634E6C997D0AE326EAB")
    public int start(int group) {
        addTaint(group);
        int varEC70FF767228E41B1F3C47313686F1FB_1153070908 = (offsets[2 * group]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129025973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129025973;
        // ---------- Original Method ----------
        //return offsets[2 * group];
    }

    
}

