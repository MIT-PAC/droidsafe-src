package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class MatchResultImpl implements MatchResult {
    private String text;
    private int[] offsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.634 -0400", hash_original_method = "2A7F503D795C5A57339C0129F572051A", hash_generated_method = "ED23C0E06CCF26B225701C7F7BAABBB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     MatchResultImpl(String text, int[] offsets) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(offsets[0]);
        this.offsets = offsets.clone();
        // ---------- Original Method ----------
        //this.text = text;
        //this.offsets = offsets.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.634 -0400", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "D49C569E1D64967BED7B2152E39E0328")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int end() {
        int varD085614B73328778F16C47DE2FECFC57_900554766 = (end(0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return end(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.634 -0400", hash_original_method = "65429E9FFFA86BB606D2EED833A40ABB", hash_generated_method = "729BD8CA9A6DBDCC13B3A6A7EA41724B")
    @DSModeled(DSC.SAFE)
    public int end(int group) {
        dsTaint.addTaint(group);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offsets[2 * group + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.634 -0400", hash_original_method = "6ED812525C326D14A5EB91FA01A3208C", hash_generated_method = "4B5E863337DA7BF1A2D9C41AF7DF114E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String group() {
        String var226B9F5425A1DF01C8F45CED0C961F01_458356800 = (text.substring(start(), end()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return text.substring(start(), end());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.635 -0400", hash_original_method = "018F540DDE0C3C1C686E1EDB2CD0CDCF", hash_generated_method = "DA8403DBB8A13E32E570C40E9F5F78DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String group(int group) {
        dsTaint.addTaint(group);
        int from;
        from = offsets[group * 2];
        int to;
        to = offsets[(group * 2) + 1];
        {
            String varB666C879DCE9B321E60FB35A9A5D4B9F_1503498446 = (text.substring(from, to));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int from = offsets[group * 2];
        //int to = offsets[(group * 2) + 1];
        //if (from == -1 || to == -1) {
            //return null;
        //} else {
            //return text.substring(from, to);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.635 -0400", hash_original_method = "F1AEADA2600B81876C4282B5C0543134", hash_generated_method = "27F42FE4727401B7CE8368B208E1D836")
    @DSModeled(DSC.SAFE)
    public int groupCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (offsets.length / 2) - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.635 -0400", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "1D1B9C55549E8C9345ACE4AA6B9CD298")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int start() {
        int var2FA5FC50CE2538BDC8E886B2AA7A2178_1331257625 = (start(0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return start(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.635 -0400", hash_original_method = "AECCCC3B75C18CF3285FB395DF7917FC", hash_generated_method = "BF9C901E1911E1C3D5AE992C86E75BDD")
    @DSModeled(DSC.SAFE)
    public int start(int group) {
        dsTaint.addTaint(group);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offsets[2 * group];
    }

    
}

