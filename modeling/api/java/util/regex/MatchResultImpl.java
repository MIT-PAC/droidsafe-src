package java.util.regex;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class MatchResultImpl implements MatchResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.951 -0500", hash_original_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.954 -0500", hash_original_field = "558F8D9D196E335F46E7F2341F45A030", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private int[] offsets;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.957 -0500", hash_original_method = "2A7F503D795C5A57339C0129F572051A", hash_generated_method = "2A7F503D795C5A57339C0129F572051A")
    
MatchResultImpl(String text, int[] offsets) {
        this.text = text;
        this.offsets = offsets.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.959 -0500", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "CC234EA5E37E807494135274DD1A4092")
    
public int end() {
        return end(0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.962 -0500", hash_original_method = "65429E9FFFA86BB606D2EED833A40ABB", hash_generated_method = "137C314DBAF3A834C368C8487500FA80")
    
public int end(int group) {
        return offsets[2 * group + 1];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.964 -0500", hash_original_method = "6ED812525C326D14A5EB91FA01A3208C", hash_generated_method = "908DA754DA97D8E70F1181F924529064")
    
public String group() {
        return text.substring(start(), end());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.967 -0500", hash_original_method = "018F540DDE0C3C1C686E1EDB2CD0CDCF", hash_generated_method = "1CE164CE50917AA7BC109272B3998E5B")
    
public String group(int group) {
        int from = offsets[group * 2];
        int to = offsets[(group * 2) + 1];
        if (from == -1 || to == -1) {
            return null;
        } else {
            return text.substring(from, to);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.969 -0500", hash_original_method = "F1AEADA2600B81876C4282B5C0543134", hash_generated_method = "91B863EC6AD5F17F30F4F1CB2A61C1AA")
    
public int groupCount() {
        return (offsets.length / 2) - 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.971 -0500", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "418FAD9CD57B1DF307E434ACAC1968EE")
    
public int start() {
        return start(0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.974 -0500", hash_original_method = "AECCCC3B75C18CF3285FB395DF7917FC", hash_generated_method = "2CF2682D4EE305D7276F5CC61ACB2CE8")
    
public int start(int group) {
        return offsets[2 * group];
    }
    
}

