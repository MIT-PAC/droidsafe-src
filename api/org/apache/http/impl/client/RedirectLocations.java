package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;




public class RedirectLocations {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.890 -0400", hash_original_field = "7B09EE9A35BA33DA533A4D7CECA76160", hash_generated_field = "E609FAD9509EA57EE6F15C46616EE93D")

    private Set<URI> uris;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.891 -0400", hash_original_method = "9519CF5B1DBD865D59F3013CCB6A2D22", hash_generated_method = "6241604C09ADF2692B23606D59740848")
    public  RedirectLocations() {
        super();
        this.uris = new HashSet<URI>();
        // ---------- Original Method ----------
        //this.uris = new HashSet<URI>();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.891 -0400", hash_original_method = "AE445335586A61F4AB9D472CB658E765", hash_generated_method = "888D34750EE38C985088E1CFF644F516")
    public boolean contains(final URI uri) {
        addTaint(uri.getTaint());
        boolean var58A5D13FE9BF7EDB6A3C36EF0D314D3F_522064805 = (this.uris.contains(uri));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751876874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751876874;
        // ---------- Original Method ----------
        //return this.uris.contains(uri);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.892 -0400", hash_original_method = "F9942D2466FE07715480ED4C9CFB455E", hash_generated_method = "118F4446B2A84A513CB9A39012B991C9")
    public void add(final URI uri) {
        addTaint(uri.getTaint());
        this.uris.add(uri);
        // ---------- Original Method ----------
        //this.uris.add(uri);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.892 -0400", hash_original_method = "E60762F1048604C69EBEEFFB1108CCA7", hash_generated_method = "0BA8EAF60D4166FCD58DA6CA082EAAED")
    public boolean remove(final URI uri) {
        addTaint(uri.getTaint());
        boolean varE3D13A5C93D62DC571A6963161403EC6_185061294 = (this.uris.remove(uri));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101117564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101117564;
        // ---------- Original Method ----------
        //return this.uris.remove(uri);
    }

    
}

