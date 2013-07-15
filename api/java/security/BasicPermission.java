package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public abstract class BasicPermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.934 -0400", hash_original_method = "D7C15085897CB0E8D87B48429476636B", hash_generated_method = "EBDBEF6EF7CE8B0F1566EF95CE070D5E")
    public  BasicPermission(String name) {
        super("");
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.934 -0400", hash_original_method = "70983AE2C4FC471A8D797105AE850E32", hash_generated_method = "892449386B6D940740DFA727AE8EEB57")
    public  BasicPermission(String name, String action) {
        super("");
        addTaint(action.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.934 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "B277919700FFF042EF65E07743085319")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_1515564568 =         null;
        var540C13E9E156B687226421B24F2DF178_1515564568.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1515564568;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.935 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "75A23020F196B0524910C6BDB341D040")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_48706258 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_208730763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_208730763;
        // ---------- Original Method ----------
        //return true;
    }

    
}

