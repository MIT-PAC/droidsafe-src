package java.util;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	@DSModeled(DSC.SAFE)
	protected AbstractMap() {
    }
}
