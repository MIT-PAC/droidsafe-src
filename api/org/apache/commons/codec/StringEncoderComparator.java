/*
 * Copyright 2001-2004 The Apache Software Foundation.
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

package org.apache.commons.codec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Comparator;

/**
 * Strings are comparable, and this comparator allows 
 * you to configure it with an instance of a class
 * which implements StringEncoder.  This comparator
 * is used to sort Strings by an encoding scheme such
 * as Soundex, Metaphone, etc.  This class can come in
 * handy if one need to sort Strings by an encoded
 * form of a name such as Soundex.
 *
 * @author Apache Software Foundation
 * @version $Id: StringEncoderComparator.java,v 1.14 2004/06/21 23:24:17 ggregory Exp $
 */
public class StringEncoderComparator implements Comparator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.257 -0400", hash_original_field = "1F4E2BA5DB7CF0A0617D9B8EADD2D732", hash_generated_field = "088179306DFF887D939C21D1D40C4F94")

    private StringEncoder stringEncoder;

    /**
     * Constructs a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.258 -0400", hash_original_method = "A6246BE8E3BF21BCFC499AE6964EEB31", hash_generated_method = "58E11B895C439789C8E4291492B158EE")
    
public StringEncoderComparator() {
        // no init.
    }

    /**
     * Constructs a new instance with the given algorithm.
     * @param stringEncoder the StringEncoder used for comparisons.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.258 -0400", hash_original_method = "A4A8433F0A809145998714F482BFD1A6", hash_generated_method = "CA7133976EF51E59C65592836B55FE6C")
    
public StringEncoderComparator(StringEncoder stringEncoder) {
        this.stringEncoder = stringEncoder;
    }

    /**
     * Compares two strings based not on the strings 
     * themselves, but on an encoding of the two 
     * strings using the StringEncoder this Comparator
     * was created with.
     * 
     * If an {@link EncoderException} is encountered, return <code>0</code>.
     * 
     * @param o1 the object to compare
     * @param o2 the object to compare to
     * @return the Comparable.compareTo() return code or 0 if an encoding error was caught.
     * @see Comparable
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.259 -0400", hash_original_method = "0BDE0194AD597745E92B3CDBBB2A4527", hash_generated_method = "4D58B047AA42BB5EFBA0DD8773C94DF4")
    
public int compare(Object o1, Object o2) {

        int compareCode = 0;

        try {
            Comparable s1 = (Comparable) ((Encoder) this.stringEncoder).encode(o1);
            Comparable s2 = (Comparable) ((Encoder) this.stringEncoder).encode(o2);
            compareCode = s1.compareTo(s2);
        } 
        catch (EncoderException ee) {
            compareCode = 0;
        }
        return compareCode;
    }

}
