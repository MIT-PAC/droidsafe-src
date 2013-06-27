package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class RedirectLocations {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.471 -0400", hash_original_field = "7B09EE9A35BA33DA533A4D7CECA76160", hash_generated_field = "E609FAD9509EA57EE6F15C46616EE93D")

    private Set<URI> uris;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.472 -0400", hash_original_method = "9519CF5B1DBD865D59F3013CCB6A2D22", hash_generated_method = "6241604C09ADF2692B23606D59740848")
    public  RedirectLocations() {
        super();
        this.uris = new HashSet<URI>();
        // ---------- Original Method ----------
        //this.uris = new HashSet<URI>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.472 -0400", hash_original_method = "AE445335586A61F4AB9D472CB658E765", hash_generated_method = "0EA3391F4CBCB38774F9171A3B12B846")
    public boolean contains(final URI uri) {
        boolean varC23AF0F030E2E8E4829BE32E39180DC4_1099453655 = (this.uris.contains(uri));
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74841129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74841129;
        // ---------- Original Method ----------
        //return this.uris.contains(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.483 -0400", hash_original_method = "F9942D2466FE07715480ED4C9CFB455E", hash_generated_method = "D7338E03D5115F34DEF4FF21784CF196")
    public void add(final URI uri) {
        this.uris.add(uri);
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //this.uris.add(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.485 -0400", hash_original_method = "E60762F1048604C69EBEEFFB1108CCA7", hash_generated_method = "CF52DB769C5F05FC6A913B35DB19E446")
    public boolean remove(final URI uri) {
        boolean var0DB09C309E30E8DD4B77630C818A0B9D_26505810 = (this.uris.remove(uri));
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192936251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192936251;
        // ---------- Original Method ----------
        //return this.uris.remove(uri);
    }

    
}

