/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.util;

/**
 * {@code ListResourceBundle} is the abstract superclass of classes which provide
 * resources by implementing the {@code getContents()} method to return
 * the list of resources.
 *
 * @see ResourceBundle
 * @since 1.1
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class ListResourceBundle extends ResourceBundle {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.652 -0400", hash_original_field = "B6BC830C29A0E26565590C4B68242D58", hash_generated_field = "B6BC830C29A0E26565590C4B68242D58")

    HashMap<String, Object> table;

    /**
     * Constructs a new instance of this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.653 -0400", hash_original_method = "BD8CDE055058A034A78670C9643890E9", hash_generated_method = "074EE51D5350E7B114C531C633FD94B3")
    
public ListResourceBundle() {
    }

    /**
     * Returns an {@code Object} array containing the resources of this
     * {@code ListResourceBundle}. Each element in the array is an array of two
     * elements, the first is the resource key string and the second is the
     * resource.
     *
     * @return a {@code Object} array containing the resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.653 -0400", hash_original_method = "088E3E08205265B1EE6C60F153D1CFA7", hash_generated_method = "C830A816E27C99C79BAB4A10A7DE3EB4")
    
protected abstract Object[][] getContents();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.657 -0400", hash_original_method = "0DE7940C5DD4041382B80179A6DFDAE8", hash_generated_method = "B3142587DBC7AAACB7FAEDA6D03D5C04")
    
@Override
    public Enumeration<String> getKeys() {
        initializeTable();
        if (parent != null) {
            return new Enumeration<String>() {
                Iterator<String> local = table.keySet().iterator();

                Enumeration<String> pEnum = parent.getKeys();

                String nextElement;

                private boolean findNext() {
                    if (nextElement != null) {
                        return true;
                    }
                    while (pEnum.hasMoreElements()) {
                        String next = pEnum.nextElement();
                        if (!table.containsKey(next)) {
                            nextElement = next;
                            return true;
                        }
                    }
                    return false;
                }

                public boolean hasMoreElements() {
                    if (local.hasNext()) {
                        return true;
                    }
                    return findNext();
                }

                public String nextElement() {
                    if (local.hasNext()) {
                        return local.next();
                    }
                    if (findNext()) {
                        String result = nextElement;
                        nextElement = null;
                        return result;
                    }
                    // Cause an exception
                    return pEnum.nextElement();
                }
            };
        } else {
            return new Enumeration<String>() {
                Iterator<String> it = table.keySet().iterator();

                public boolean hasMoreElements() {
                    return it.hasNext();
                }

                public String nextElement() {
                    return it.next();
                }
            };
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.658 -0400", hash_original_method = "74FBA14B3C3079E4C347742AD40E502F", hash_generated_method = "00122C73E7312FCDCBA1B81DE6BF1CD6")
    
@Override
    public final Object handleGetObject(String key) {
        initializeTable();
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        return table.get(key);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.658 -0400", hash_original_method = "024D7EF7D56D8591C824C686C2B4274B", hash_generated_method = "0F52ADE41F3E44C8E559002F3994313F")
    
private synchronized void initializeTable() {
        if (table == null) {
            Object[][] contents = getContents();
            table = new HashMap<String, Object>(contents.length / 3 * 4 + 3);
            for (Object[] content : contents) {
                if (content[0] == null || content[1] == null) {
                    throw new NullPointerException("null entry");
                }
                table.put((String) content[0], content[1]);
            }
        }
    }

    /**
     * Returns a set of the keys in this ResourceBundle but not in its parents.
     *
     * @return a set of the keys in this ResourceBundle but not in its parents.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.659 -0400", hash_original_method = "E845C964E677251D2B1F77A667AAD7EC", hash_generated_method = "04BB902845956A4117DE664F4FDDCCCC")
    
protected Set<String> handleKeySet() {
        initializeTable();
        return table.keySet();
    }
}
