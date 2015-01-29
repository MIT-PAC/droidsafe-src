package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class RedirectLocations {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.534 -0500", hash_original_field = "1CA521CCC81E60F840743F80D41918F7", hash_generated_field = "E609FAD9509EA57EE6F15C46616EE93D")

    private  Set<URI> uris;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.536 -0500", hash_original_method = "9519CF5B1DBD865D59F3013CCB6A2D22", hash_generated_method = "5B37674157F725D7786F2E93247B9F7B")
    
public RedirectLocations() {
        super();
        this.uris = new HashSet<URI>();
    }
    
    /**
     * Returns true if this collection contains the given URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.539 -0500", hash_original_method = "AE445335586A61F4AB9D472CB658E765", hash_generated_method = "1FB526D41F3DD0C51856D56C1E80CDED")
    
public boolean contains(final URI uri) {
        return this.uris.contains(uri);
    }
    
    /**
     * Adds a new URI to the list of redirects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.541 -0500", hash_original_method = "F9942D2466FE07715480ED4C9CFB455E", hash_generated_method = "3A42119FB9C691DFF3EDB01412BDBFAC")
    
public void add(final URI uri) {
        this.uris.add(uri);
    }

    /**
     * Removes a URI from the list of redirects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.543 -0500", hash_original_method = "E60762F1048604C69EBEEFFB1108CCA7", hash_generated_method = "D7F57C172E88386FD52BD254A2E2CA69")
    
public boolean remove(final URI uri) {
        return this.uris.remove(uri);
    }
    
}

