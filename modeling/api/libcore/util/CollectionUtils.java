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
 * Copyright (C) 2010 The Android Open Source Project
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


package libcore.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.Reference;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class CollectionUtils {
    
    public static <T> Iterable<T> dereferenceIterable(
            final Iterable<? extends Reference<T>> iterable, final boolean trim) {
        return new Iterable<T>() {
            
        @DSSafe(DSCat.SAFE_LIST)
        public Iterator<T> iterator() {
                return new Iterator<T>() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.088 -0500", hash_original_field = "FC1841E2B61E0112C65F1A7B40112CCF", hash_generated_field = "BA3AF217822442F4EBB0D4F80E08231E")

                    private final Iterator<? extends Reference<T>> delegate = iterable.iterator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.091 -0500", hash_original_field = "2E6EC376CACD2EFB5EA0E7A5EE8CFB7F", hash_generated_field = "B7A3D502C84BFF6D6C17E75516015E89")

                    private boolean removeIsOkay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.094 -0500", hash_original_field = "DB5AAA58E6C7A117C4D5D733F5BFE4DB", hash_generated_field = "13CF7518FEC9876914E0AF86C869524E")

                    private T next;

                    @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.098 -0500", hash_original_method = "E85EAE479DB025693A9729458E71245D", hash_generated_method = "5FF4E103A055D1C17EDE93548A8402A2")
                    
private void computeNext() {
                        removeIsOkay = false;
                        while (next == null && delegate.hasNext()) {
                            next = delegate.next().get();
                            if (trim && next == null) {
                                delegate.remove();
                            }
                        }
                    }

                    @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.101 -0500", hash_original_method = "F98C6B6D707EE7EA3A5FD2D39F4A0387", hash_generated_method = "549F51A1F66C51FA06F9B2518887C403")
                    
@Override public boolean hasNext() {
                        computeNext();
                        return next != null;
                    }

                    @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.105 -0500", hash_original_method = "F120D99BE5EA300D8BF38607156FC87D", hash_generated_method = "C18C10D62F3F060AD23759D819CE225C")
                    
@Override public T next() {
                        if (!hasNext()) {
                            throw new IllegalStateException();
                        }
                        T result = next;
                        removeIsOkay = true;
                        next = null;
                        return result;
                    }

                    @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.108 -0500", hash_original_method = "8B1109B1635017616160F426171DA3AB", hash_generated_method = "146A4B3FE5B45281653375C39EBC7B3B")
                    
public void remove() {
                        if (!removeIsOkay) {
                            throw new IllegalStateException();
                        }
                        delegate.remove();
                    }
                };
            }
        };
    }
    
    public static <T> void removeDuplicates(List<T> list, Comparator<? super T> comparator) {
        Collections.sort(list, comparator);
        int j = 1;
        for (int i = 1; i < list.size(); i++) {
            if (comparator.compare(list.get(j - 1), list.get(i)) != 0) {
                T object = list.get(i);
                list.set(j++, object);
            }
        }
        if (j < list.size()) {
            list.subList(j, list.size()).clear();
        }
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.084 -0500", hash_original_method = "01B59B68B4B802DAB48FA08289978867", hash_generated_method = "9ECF08C0F15D4899C88459A1B3061187")
    
private CollectionUtils() {}
    
}

