package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MultiValueMap<K,V> extends Map<K,List<V>>, Serializable {
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Object remove( K key, V item );
}
