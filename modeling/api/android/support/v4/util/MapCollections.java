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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Helper for writing standard Java collection interfaces to a data
 * structure like {@link ArrayMap}.
 * @hide
 */
abstract class MapCollections<K, V> {

    @DSSafe(DSCat.SAFE_LIST)
    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return oldSize != map.size();
    }

    @DSSafe(DSCat.SAFE_LIST)
    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return oldSize != map.size();
    }

    final class ArrayIterator<T> implements Iterator<T> {
        final int mOffset;
        int mSize;
        int mIndex;
        boolean mCanRemove = false;

        ArrayIterator(int offset) {
            mOffset = offset;
            mSize = colGetSize();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean hasNext() {
            return mIndex < mSize;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public T next() {
            Object res = colGetEntry(mIndex, mOffset);
            mIndex++;
            mCanRemove = true;
            return (T)res;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void remove() {
            if (!mCanRemove) {
                throw new IllegalStateException();
            }
            mIndex--;
            mSize--;
            mCanRemove = false;
            colRemoveAt(mIndex);
        }
    }

    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        int mIndex;
        boolean mEntryValid = false;

        MapIterator() {
            mEnd = colGetSize() - 1;
            mIndex = -1;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean hasNext() {
            return mIndex < mEnd;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Map.Entry<K, V> next() {
            mIndex++;
            mEntryValid = true;
            return this;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void remove() {
            if (!mEntryValid) {
                throw new IllegalStateException();
            }
            colRemoveAt(mIndex);
            mIndex--;
            mEnd--;
            mEntryValid = false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public K getKey() {
            if (!mEntryValid) {
                throw new IllegalStateException(
                        "This container does not support retaining Map.Entry objects");
            }
            return (K)colGetEntry(mIndex, 0);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public V getValue() {
            if (!mEntryValid) {
                throw new IllegalStateException(
                        "This container does not support retaining Map.Entry objects");
            }
            return (V)colGetEntry(mIndex, 1);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public V setValue(V object) {
            if (!mEntryValid) {
                throw new IllegalStateException(
                        "This container does not support retaining Map.Entry objects");
            }
            return colSetValue(mIndex, object);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public final boolean equals(Object o) {
            if (!mEntryValid) {
                throw new IllegalStateException(
                        "This container does not support retaining Map.Entry objects");
            }
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            return ContainerHelpers.equal(e.getKey(), colGetEntry(mIndex, 0))
                    && ContainerHelpers.equal(e.getValue(), colGetEntry(mIndex, 1));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public final int hashCode() {
            if (!mEntryValid) {
                throw new IllegalStateException(
                        "This container does not support retaining Map.Entry objects");
            }
            final Object key = colGetEntry(mIndex, 0);
            final Object value = colGetEntry(mIndex, 1);
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class EntrySet implements Set<Map.Entry<K, V>> {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean add(Map.Entry<K, V> object) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int oldSize = colGetSize();
            for (Map.Entry<K, V> entry : collection) {
                colPut(entry.getKey(), entry.getValue());
            }
            return oldSize != colGetSize();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void clear() {
            colClear();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            int index = colIndexOfKey(e.getKey());
            if (index < 0) {
                return false;
            }
            Object foundVal = colGetEntry(index, 1);
            return ContainerHelpers.equal(foundVal, e.getValue());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isEmpty() {
            return colGetSize() == 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int size() {
            return colGetSize();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public <T> T[] toArray(T[] array) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean equals(Object object) {
            return equalsSetHelper(this, object);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int hashCode() {
            int result = 0;
            for (int i=colGetSize()-1; i>=0; i--) {
                final Object key = colGetEntry(i, 0);
                final Object value = colGetEntry(i, 1);
                result += ( (key == null ? 0 : key.hashCode()) ^
                        (value == null ? 0 : value.hashCode()) );
            }
            return result;
        }
    };

    final class KeySet implements Set<K> {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean add(K object) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void clear() {
            colClear();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean contains(Object object) {
            return colIndexOfKey(object) >= 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean containsAll(Collection<?> collection) {
            return containsAllHelper(colGetMap(), collection);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isEmpty() {
            return colGetSize() == 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Iterator<K> iterator() {
            return new ArrayIterator<K>(0);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean remove(Object object) {
            int index = colIndexOfKey(object);
            if (index >= 0) {
                colRemoveAt(index);
                return true;
            }
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean removeAll(Collection<?> collection) {
            return removeAllHelper(colGetMap(), collection);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean retainAll(Collection<?> collection) {
            return retainAllHelper(colGetMap(), collection);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int size() {
            return colGetSize();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object[] toArray() {
            return toArrayHelper(0);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public <T> T[] toArray(T[] array) {
            return toArrayHelper(array, 0);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean equals(Object object) {
            return equalsSetHelper(this, object);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int hashCode() {
            int result = 0;
            for (int i=colGetSize()-1; i>=0; i--) {
                Object obj = colGetEntry(i, 0);
                result += obj == null ? 0 : obj.hashCode();
            }
            return result;
        }
    };

    final class ValuesCollection implements Collection<V> {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean add(V object) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void clear() {
            colClear();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean contains(Object object) {
            return colIndexOfValue(object) >= 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isEmpty() {
            return colGetSize() == 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Iterator<V> iterator() {
            return new ArrayIterator<V>(1);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean remove(Object object) {
            int index = colIndexOfValue(object);
            if (index >= 0) {
                colRemoveAt(index);
                return true;
            }
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean removeAll(Collection<?> collection) {
            int N = colGetSize();
            boolean changed = false;
            for (int i=0; i<N; i++) {
                Object cur = colGetEntry(i, 1);
                if (collection.contains(cur)) {
                    colRemoveAt(i);
                    i--;
                    N--;
                    changed = true;
                }
            }
            return changed;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean retainAll(Collection<?> collection) {
            int N = colGetSize();
            boolean changed = false;
            for (int i=0; i<N; i++) {
                Object cur = colGetEntry(i, 1);
                if (!collection.contains(cur)) {
                    colRemoveAt(i);
                    i--;
                    N--;
                    changed = true;
                }
            }
            return changed;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int size() {
            return colGetSize();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object[] toArray() {
            return toArrayHelper(1);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public <T> T[] toArray(T[] array) {
            return toArrayHelper(array, 1);
        }
    };

    @DSSafe(DSCat.SAFE_LIST)
    public static <T> boolean equalsSetHelper(Set<T> set, Object object) {
        if (set == object) {
            return true;
        }
        if (object instanceof Set) {
            Set<?> s = (Set<?>) object;

            try {
                return set.size() == s.size() && set.containsAll(s);
            } catch (NullPointerException ignored) {
                return false;
            } catch (ClassCastException ignored) {
                return false;
            }
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.007 -0400", hash_original_field = "E906CBDAE0BC7A16C3953C661914071C", hash_generated_field = "E906CBDAE0BC7A16C3953C661914071C")

    EntrySet mEntrySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.012 -0400", hash_original_field = "795EC2F7827225551A64D53BDE67E232", hash_generated_field = "795EC2F7827225551A64D53BDE67E232")

    KeySet mKeySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.018 -0400", hash_original_field = "8F1FF5CBDB61E4F124C097C3B92B34E8", hash_generated_field = "8F1FF5CBDB61E4F124C097C3B92B34E8")

    ValuesCollection mValues;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.465 -0400", hash_original_method = "CFCF1388094A07DB40C16FF95D6724A1", hash_generated_method = "0AC2212A1632995E3DF6BE063DBB29C4")
    
public Object[] toArrayHelper(int offset) {
        final int N = colGetSize();
        Object[] result = new Object[N];
        for (int i=0; i<N; i++) {
            result[i] = colGetEntry(i, offset);
        }
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    public <T> T[] toArrayHelper(T[] array, int offset) {
        final int N  = colGetSize();
        if (array.length < N) {
            @SuppressWarnings("unchecked") T[] newArray
                = (T[]) Array.newInstance(array.getClass().getComponentType(), N);
            array = newArray;
        }
        for (int i=0; i<N; i++) {
            array[i] = (T)colGetEntry(i, offset);
        }
        if (array.length > N) {
            array[N] = null;
        }
        return array;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.484 -0400", hash_original_method = "1B5608DE2EE60AD644A5D36EAB15D5C1", hash_generated_method = "C952575AED4CBB4C33E8A7AFBF348E14")
    
public Set<Map.Entry<K, V>> getEntrySet() {
        if (mEntrySet == null) {
            mEntrySet = new EntrySet();
        }
        return mEntrySet;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.489 -0400", hash_original_method = "13B8FCBE3CAB01DD6C3D953426701C51", hash_generated_method = "0676C64FA0E158C6F532E5EA207C9BC9")
    
public Set<K> getKeySet() {
        if (mKeySet == null) {
            mKeySet = new KeySet();
        }
        return mKeySet;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.494 -0400", hash_original_method = "AB3104883397160F633AACF1247C9B75", hash_generated_method = "311DDB82FDAE8F6F988604DD5CAD9262")
    
public Collection<V> getValues() {
        if (mValues == null) {
            mValues = new ValuesCollection();
        }
        return mValues;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.497 -0400", hash_original_method = "2616226927DFEF2E2FC635D51637A22F", hash_generated_method = "8265C01B42DABA13ECDC6838583C618B")
    
protected abstract int colGetSize();
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.502 -0400", hash_original_method = "B2D65FEBE53BB17F1C87897127957291", hash_generated_method = "2A4B9C83EB44EF167C5423FA8E27DEA0")
    
protected abstract Object colGetEntry(int index, int offset);
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.506 -0400", hash_original_method = "C686F42C1C641CE7B16BC69EED89F2C5", hash_generated_method = "706F4FDFE6646565EB057F68D8B42273")
    
protected abstract int colIndexOfKey(Object key);
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.510 -0400", hash_original_method = "C38AF8C5346C484F4FA84F03766B3748", hash_generated_method = "2688B24B7912B2E99EBBE38607E52C15")
    
protected abstract int colIndexOfValue(Object key);
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.513 -0400", hash_original_method = "6C10172A3A758AAB2FECB652D03F9409", hash_generated_method = "6B88AA66715DAF167BA93A81C29AB4AB")
    
protected abstract Map<K, V> colGetMap();
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.521 -0400", hash_original_method = "CCAD254939DC82C4F42B837FB13CBAE5", hash_generated_method = "B912CC7BD630B6E4A4D333985595C2BE")
    
protected abstract void colPut(K key, V value);
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.527 -0400", hash_original_method = "003A77DF57620CA053AEE35BDB69E21B", hash_generated_method = "A611B2077CCE20D456A3D8B1D0850AD3")
    
protected abstract V colSetValue(int index, V value);
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.534 -0400", hash_original_method = "A1AC558748839D4A08657B19B8564795", hash_generated_method = "ABDAE1362331A4453990090E24ACE423")
    
protected abstract void colRemoveAt(int index);
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:22.540 -0400", hash_original_method = "97C26526E7FAC5419E503CD4ABB865D7", hash_generated_method = "973A2DB0D39764E626CF9425D43CDDF8")
    
protected abstract void colClear();
}
