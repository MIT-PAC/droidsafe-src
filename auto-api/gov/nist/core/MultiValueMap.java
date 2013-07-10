package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MultiValueMap<K,V> extends Map<K,List<V>>, Serializable {
    public Object remove( K key, V item );
}
