package java.security;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class AllPermission extends Permission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.780 -0400", hash_original_method = "09A3FF901F6A2CF2EED3134C2EAC6A79", hash_generated_method = "E22C358DE3BB8BF580C61BABF15F3F8C")
    public  AllPermission(String name, String actions) {
        super("");
        addTaint(actions.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.780 -0400", hash_original_method = "8D01BAC0F6DD766A4223D24BBCA0691E", hash_generated_method = "DA55DE73D4BB8B2A20910679600CE1D4")
    public  AllPermission() {
        super("");
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.781 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "9A8F1EB55E68314DA8FB5273BF04B146")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_5793450 =         null;
        var540C13E9E156B687226421B24F2DF178_5793450.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_5793450;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.781 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "F4B7087D539ED0AE92A7F48635CAA696")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_2109254163 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541111681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541111681;
        // ---------- Original Method ----------
        //return true;
    }

    
}

