package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;

public class NetworkConfig {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.630 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.630 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.630 -0400", hash_original_field = "A398FB77DF76E6153DF57CD65FD0A7C5", hash_generated_field = "B76BEC06EF6E298953D8260875E82B36")

    public int radio;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.630 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

    public int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.630 -0400", hash_original_field = "BBE04E9D02C7768AE3D81692B5315771", hash_generated_field = "3D480C8B39054F9E4BA1016E57A71468")

    public boolean dependencyMet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.630 -0400", hash_original_field = "5680DECA9C2B49BB75564AEB3B137962", hash_generated_field = "3DE9E6C805B41A267911B0D9515BC99E")

    public int restoreTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.631 -0400", hash_original_method = "93F95FF083791513BC80A25A69B4AF8A", hash_generated_method = "1A05FE727A426596D9FEF27F4D73E691")
    public  NetworkConfig(String init) {
        addTaint(init.getTaint());
        String fragments[] = init.split(",");
        name = fragments[0].trim().toLowerCase();
        type = Integer.parseInt(fragments[1]);
        radio = Integer.parseInt(fragments[2]);
        priority = Integer.parseInt(fragments[3]);
        restoreTime = Integer.parseInt(fragments[4]);
        dependencyMet = Boolean.parseBoolean(fragments[5]);
        // ---------- Original Method ----------
        //String fragments[] = init.split(",");
        //name = fragments[0].trim().toLowerCase();
        //type = Integer.parseInt(fragments[1]);
        //radio = Integer.parseInt(fragments[2]);
        //priority = Integer.parseInt(fragments[3]);
        //restoreTime = Integer.parseInt(fragments[4]);
        //dependencyMet = Boolean.parseBoolean(fragments[5]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.632 -0400", hash_original_method = "474B729266EEB37673AA204F699AE5C3", hash_generated_method = "0CD7D69C5BE6F8AA5FB2ED5F898A57BE")
    public boolean isDefault() {
        boolean varF4E52B2901BB1FD7247499B30FF884A3_1759153429 = ((type == radio));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244654182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244654182;
        // ---------- Original Method ----------
        //return (type == radio);
    }

    
}

