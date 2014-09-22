/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io.comparator;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Compare two files using a set of delegate file {@link Comparator}.
 * <p>
 * This comparator can be used to sort lists or arrays of files
 * by combining a number other comparators.
 * <p>
 * Example of sorting a list of files by type (i.e. directory or file)
 * and then by name:
 * <pre>
 *       CompositeFileComparator comparator =
 *                       new CompositeFileComparator(
 *                                   DirectoryFileComparator.DIRECTORY_COMPARATOR,
 *                                   NameFileComparator.NAME_COMPARATOR);
 *       List&lt;File&gt; list = ...
 *       comparator.sort(list);
 * </pre>
 *
 * @version $Id: CompositeFileComparator.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 2.0
 */
public class CompositeFileComparator extends AbstractFileComparator implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.733 -0400", hash_original_field = "FF9CE7795EF2BD95A145D2C38FAE0471", hash_generated_field = "7EC266BDB84DEDF52EDA39CAC5771972")


    private static final Comparator<?>[] NO_COMPARATORS = {};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.733 -0400", hash_original_field = "4E65A3C14639ABFBCA9B90DD868514BA", hash_generated_field = "577A5DF0D229ECB4715636D7E1830F2D")

    private  Comparator<File>[] delegates;

    /**
     * Create a composite comparator for the set of delegate comparators.
     *
     * @param delegates The delegate file comparators
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.734 -0400", hash_original_method = "5DBBCC36A1E40C37C83AB1F6C81AA43A", hash_generated_method = "2B3CBDD6BB133BD8B3BB410A0086EA3A")
    
@SuppressWarnings("unchecked") // casts 1 & 2 must be OK because types are already correct
    public CompositeFileComparator(Comparator<File>... delegates) {
        if (delegates == null) {
            this.delegates = (Comparator<File>[]) NO_COMPARATORS;//1
        } else {
            this.delegates = (Comparator<File>[]) new Comparator<?>[delegates.length];//2
            System.arraycopy(delegates, 0, this.delegates, 0, delegates.length);
        }
    }

    /**
     * Create a composite comparator for the set of delegate comparators.
     *
     * @param delegates The delegate file comparators
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.735 -0400", hash_original_method = "CB873E20A34C1FCC65A288AB5E09AA6B", hash_generated_method = "FF0B2C31F69F9A24CDCA0203B6CCF967")
    
@SuppressWarnings("unchecked") // casts 1 & 2 must be OK because types are already correct
    public CompositeFileComparator(Iterable<Comparator<File>> delegates) {
        if (delegates == null) {
            this.delegates = (Comparator<File>[]) NO_COMPARATORS; //1
        } else {
            List<Comparator<File>> list = new ArrayList<Comparator<File>>();
            for (Comparator<File> comparator : delegates) {
                list.add(comparator);
            }
            this.delegates = (Comparator<File>[]) list.toArray(new Comparator<?>[list.size()]); //2
        }
    }

    /**
     * Compare the two files using delegate comparators.
     * 
     * @param file1 The first file to compare
     * @param file2 The second file to compare
     * @return the first non-zero result returned from
     * the delegate comparators or zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.735 -0400", hash_original_method = "6BA921DFE406E4FB2E3ADDA69967D7F7", hash_generated_method = "9D705E36618CB1F12130B41CDFC2CAA7")
    
public int compare(File file1, File file2) {
        int result = 0;
        for (Comparator<File> delegate : delegates) {
            result = delegate.compare(file1, file2);
            if (result != 0) {
                break;
            }
        }
        return result;
    }

    /**
     * String representation of this file comparator.
     *
     * @return String representation of this file comparator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.736 -0400", hash_original_method = "47C1793FC370107B09B70CFDB1B2DA4E", hash_generated_method = "BC3D1E61DAFDAE554A0EA697D826A9A7")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append('{');
        for (int i = 0; i < delegates.length; i++) {
            if (i > 0) {
                builder.append(',');
            }
            builder.append(delegates[i]);
        }
        builder.append('}');
        return builder.toString();
    }
}
