package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class RedirectLocations {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.629 -0400", hash_original_field = "7B09EE9A35BA33DA533A4D7CECA76160", hash_generated_field = "E609FAD9509EA57EE6F15C46616EE93D")

    private Set<URI> uris;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.630 -0400", hash_original_method = "9519CF5B1DBD865D59F3013CCB6A2D22", hash_generated_method = "6241604C09ADF2692B23606D59740848")
    public  RedirectLocations() {
        super();
        this.uris = new HashSet<URI>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.630 -0400", hash_original_method = "AE445335586A61F4AB9D472CB658E765", hash_generated_method = "1A63745DA44EE53E78783BBCBE812478")
    public boolean contains(final URI uri) {
        addTaint(uri.getTaint());
        boolean var58A5D13FE9BF7EDB6A3C36EF0D314D3F_302790103 = (this.uris.contains(uri));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033825956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033825956;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.630 -0400", hash_original_method = "F9942D2466FE07715480ED4C9CFB455E", hash_generated_method = "118F4446B2A84A513CB9A39012B991C9")
    public void add(final URI uri) {
        addTaint(uri.getTaint());
        this.uris.add(uri);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.631 -0400", hash_original_method = "E60762F1048604C69EBEEFFB1108CCA7", hash_generated_method = "23D9CD0B5009CE67E6AA876E1BBFF8E7")
    public boolean remove(final URI uri) {
        addTaint(uri.getTaint());
        boolean varE3D13A5C93D62DC571A6963161403EC6_1754061158 = (this.uris.remove(uri));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898133259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898133259;
        
        
    }

    
}

