package java.util.regex;

// Droidsafe Imports
import droidsafe.annotations.*;





class MatchResultImpl implements MatchResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_field = "831BD6D82461A6164F50E583F8749188", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private int[] offsets;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_method = "2A7F503D795C5A57339C0129F572051A", hash_generated_method = "7096012F146361CD6F51844899818046")
      MatchResultImpl(String text, int[] offsets) {
        this.text = text;
        this.offsets = offsets.clone();
        // ---------- Original Method ----------
        //this.text = text;
        //this.offsets = offsets.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "D18681B6951133957AA62D6AAD1B397B")
    public int end() {
        int varCA35A8AADB641992D83E31AADD95BCC2_594865520 = (end(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214818558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214818558;
        // ---------- Original Method ----------
        //return end(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_method = "65429E9FFFA86BB606D2EED833A40ABB", hash_generated_method = "4BD5A2753F8E8F8E5BC66F7D2575B8D8")
    public int end(int group) {
        addTaint(group);
        int varD32528EE803CDF12A396D45AC86559DC_968566717 = (offsets[2 * group + 1]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832543538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832543538;
        // ---------- Original Method ----------
        //return offsets[2 * group + 1];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_method = "6ED812525C326D14A5EB91FA01A3208C", hash_generated_method = "1B4FBF38C443D4B40CD349BDD07D71C7")
    public String group() {
String varC3BFC35EE8D0C434FE4840E3B4FC6A28_1291258090 =         text.substring(start(), end());
        varC3BFC35EE8D0C434FE4840E3B4FC6A28_1291258090.addTaint(taint);
        return varC3BFC35EE8D0C434FE4840E3B4FC6A28_1291258090;
        // ---------- Original Method ----------
        //return text.substring(start(), end());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_method = "018F540DDE0C3C1C686E1EDB2CD0CDCF", hash_generated_method = "6E4D0F279421B188BA14E08FFF4F74E2")
    public String group(int group) {
        addTaint(group);
        int from = offsets[group * 2];
        int to = offsets[(group * 2) + 1];
        if(from == -1 || to == -1)        
        {
String var540C13E9E156B687226421B24F2DF178_145635141 =             null;
            var540C13E9E156B687226421B24F2DF178_145635141.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_145635141;
        } //End block
        else
        {
String var2515E3E0F4436F57CDAB8003F8B9065A_1192238224 =             text.substring(from, to);
            var2515E3E0F4436F57CDAB8003F8B9065A_1192238224.addTaint(taint);
            return var2515E3E0F4436F57CDAB8003F8B9065A_1192238224;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_method = "F1AEADA2600B81876C4282B5C0543134", hash_generated_method = "34B749272875BD59CD13D97B82012E48")
    public int groupCount() {
        int varBE45F975A752B102894AE738129E1FB5_887632908 = ((offsets.length / 2) - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832405863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832405863;
        // ---------- Original Method ----------
        //return (offsets.length / 2) - 1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "2FD56FFA86C2DF8FC8E777F0C53856DC")
    public int start() {
        int var65754EB29CD48640473484E377E145B8_1030875204 = (start(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865482889 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865482889;
        // ---------- Original Method ----------
        //return start(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.360 -0400", hash_original_method = "AECCCC3B75C18CF3285FB395DF7917FC", hash_generated_method = "8B609EF48F8AB182C73ABD42E055E8D1")
    public int start(int group) {
        addTaint(group);
        int varEC70FF767228E41B1F3C47313686F1FB_920330262 = (offsets[2 * group]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074442207 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074442207;
        // ---------- Original Method ----------
        //return offsets[2 * group];
    }

    
}

