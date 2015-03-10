/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.analyses.infoflow;

import java.util.HashMap;

@SuppressWarnings("serial")
public class DefaultHashMap<K,V> extends HashMap<K,V> {
    protected V defaultValue;

    public DefaultHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }

    public DefaultHashMap(DefaultHashMap<K, V> that) {
        super(that);
        this.defaultValue = that.defaultValue;
    }

    @Override
    public V get(Object key) {
        V value = super.get(key);
        return ((value == null) && !this.containsKey(key)) ? this.defaultValue : value;
    }

    @Override
    public V remove(Object key) {
        V value = get(key);
        super.remove(key);
        return value;
    }

    @Override
    public V put(K key, V value) {
        V val = get(key);
        super.put(key, value);
        return val;
    }
}
