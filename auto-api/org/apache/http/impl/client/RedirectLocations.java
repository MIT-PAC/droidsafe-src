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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.288 -0400", hash_original_field = "7B09EE9A35BA33DA533A4D7CECA76160", hash_generated_field = "E609FAD9509EA57EE6F15C46616EE93D")

    private Set<URI> uris;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.289 -0400", hash_original_method = "9519CF5B1DBD865D59F3013CCB6A2D22", hash_generated_method = "6241604C09ADF2692B23606D59740848")
    public  RedirectLocations() {
        super();
        this.uris = new HashSet<URI>();
        // ---------- Original Method ----------
        //this.uris = new HashSet<URI>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.289 -0400", hash_original_method = "AE445335586A61F4AB9D472CB658E765", hash_generated_method = "336162266FB3D85AD8A99F2AA84502C0")
    public boolean contains(final URI uri) {
        boolean varC23AF0F030E2E8E4829BE32E39180DC4_1737268379 = (this.uris.contains(uri));
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_238013793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_238013793;
        // ---------- Original Method ----------
        //return this.uris.contains(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.289 -0400", hash_original_method = "F9942D2466FE07715480ED4C9CFB455E", hash_generated_method = "D7338E03D5115F34DEF4FF21784CF196")
    public void add(final URI uri) {
        this.uris.add(uri);
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //this.uris.add(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.289 -0400", hash_original_method = "E60762F1048604C69EBEEFFB1108CCA7", hash_generated_method = "1DB5F736A67EF1F318FB3355ED5D8AF0")
    public boolean remove(final URI uri) {
        boolean var0DB09C309E30E8DD4B77630C818A0B9D_447191204 = (this.uris.remove(uri));
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122464891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_122464891;
        // ---------- Original Method ----------
        //return this.uris.remove(uri);
    }

    
}

