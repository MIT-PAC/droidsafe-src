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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class StringCharacterIterator implements CharacterIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.480 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.313 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

    int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.313 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

    int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.313 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;

    /**
     * Constructs a new {@code StringCharacterIterator} on the specified string.
     * The begin and current indices are set to the beginning of the string, the
     * end index is set to the length of the string.
     *
     * @param value
     *            the source string to iterate over.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.485 -0500", hash_original_method = "DAE1DA2C567D7E8FDA6EBD1FE5405924", hash_generated_method = "93516EC8B8DC016F21DFBAE3D09B5820")
    
public StringCharacterIterator(String value) {
        string = value;
        start = offset = 0;
        end = string.length();
    }

    /**
     * Constructs a new {@code StringCharacterIterator} on the specified string
     * with the current index set to the specified value. The begin index is set
     * to the beginning of the string, the end index is set to the length of the
     * string.
     *
     * @param value
     *            the source string to iterate over.
     * @param location
     *            the current index.
     * @throws IllegalArgumentException
     *            if {@code location} is negative or greater than the length
     *            of the source string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.487 -0500", hash_original_method = "5C2CF51DC0D0A9D0DCD2C7E4ADB28E8E", hash_generated_method = "9532413F151017E8364879F74187F66F")
    
public StringCharacterIterator(String value, int location) {
        string = value;
        start = 0;
        end = string.length();
        if (location < 0 || location > end) {
            throw new IllegalArgumentException();
        }
        offset = location;
    }

    /**
     * Constructs a new {@code StringCharacterIterator} on the specified string
     * with the begin, end and current index set to the specified values.
     *
     * @param value
     *            the source string to iterate over.
     * @param start
     *            the index of the first character to iterate.
     * @param end
     *            the index one past the last character to iterate.
     * @param location
     *            the current index.
     * @throws IllegalArgumentException
     *            if {@code start < 0}, {@code start > end}, {@code location <
     *            start}, {@code location > end} or if {@code end} is greater
     *            than the length of {@code value}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.491 -0500", hash_original_method = "704865465DB7061F34F598DD3605E202", hash_generated_method = "05C9949133E14BF5402CE864C72615D9")
    
public StringCharacterIterator(String value, int start, int end, int location) {
        string = value;
        if (start < 0 || end > string.length() || start > end
                || location < start || location > end) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
        offset = location;
    }

    /**
     * Returns a new {@code StringCharacterIterator} with the same source
     * string, begin, end, and current index as this iterator.
     *
     * @return a shallow copy of this iterator.
     * @see java.lang.Cloneable
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.494 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "88F588A1F8F1E65DC62D9CB72E24BF48")
    
@Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Returns the character at the current index in the source string.
     *
     * @return the current character, or {@code DONE} if the current index is
     *         past the end.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.496 -0500", hash_original_method = "0495E4BE554B279F8C8552A3E8BBAE9B", hash_generated_method = "CB63B3B77AD88F3F08287FFBADF6C86B")
    
public char current() {
        if (offset == end) {
            return DONE;
        }
        return string.charAt(offset);
    }

    /**
     * Compares the specified object with this {@code StringCharacterIterator}
     * and indicates if they are equal. In order to be equal, {@code object}
     * must be an instance of {@code StringCharacterIterator} that iterates over
     * the same sequence of characters with the same index.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this
     *         {@code StringCharacterIterator}; {@code false} otherwise.
     * @see #hashCode
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.499 -0500", hash_original_method = "4A7E92C9AA8B158215F27F7CAB59071D", hash_generated_method = "3B8D8F39B89B9959CEF1B48A3A12808B")
    
@Override
    public boolean equals(Object object) {
        if (!(object instanceof StringCharacterIterator)) {
            return false;
        }
        StringCharacterIterator it = (StringCharacterIterator) object;
        return string.equals(it.string) && start == it.start && end == it.end
                && offset == it.offset;
    }

    /**
     * Sets the current position to the begin index and returns the character at
     * the new position in the source string.
     *
     * @return the character at the begin index or {@code DONE} if the begin
     *         index is equal to the end index.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.501 -0500", hash_original_method = "B333B42236D9FFA1243D291D9F8E02D4", hash_generated_method = "AFE17903F70720F83CDBC1BB6F9D1B08")
    
public char first() {
        if (start == end) {
            return DONE;
        }
        offset = start;
        return string.charAt(offset);
    }

    /**
     * Returns the begin index in the source string.
     *
     * @return the index of the first character of the iteration.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.504 -0500", hash_original_method = "C91A51EED2BDD0863CA60178FB31B7F7", hash_generated_method = "61BB8D523DF35DF9979CE39259FD5564")
    
public int getBeginIndex() {
        return start;
    }

    /**
     * Returns the end index in the source string.
     *
     * @return the index one past the last character of the iteration.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.506 -0500", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "ACC8D1B1439CA809AB08C45ABAB29DED")
    
public int getEndIndex() {
        return end;
    }

    /**
     * Returns the current index in the source string.
     *
     * @return the current index.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.508 -0500", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "78C6B22E21CF81415ABD0C7B74926529")
    
public int getIndex() {
        return offset;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.511 -0500", hash_original_method = "261EF3CD78C94C444435F1728CE93178", hash_generated_method = "17A831DD66A1F4461FA71BE5269F41B2")
    
@Override
    public int hashCode() {
        return string.hashCode() + start + end + offset;
    }

    /**
     * Sets the current position to the end index - 1 and returns the character
     * at the new position.
     *
     * @return the character before the end index or {@code DONE} if the begin
     *         index is equal to the end index.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.513 -0500", hash_original_method = "920E2CC099037AFE91302301CF7E9F3E", hash_generated_method = "AFBCB786E817854F5D34F17C592E0592")
    
public char last() {
        if (start == end) {
            return DONE;
        }
        offset = end - 1;
        return string.charAt(offset);
    }

    /**
     * Increments the current index and returns the character at the new index.
     *
     * @return the character at the next index, or {@code DONE} if the next
     *         index would be past the end.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.516 -0500", hash_original_method = "8F260F0099582263F775831BBCA28C0F", hash_generated_method = "28483A73600FD1618D2907A401199D2D")
    
public char next() {
        if (offset >= (end - 1)) {
            offset = end;
            return DONE;
        }
        return string.charAt(++offset);
    }

    /**
     * Decrements the current index and returns the character at the new index.
     *
     * @return the character at the previous index, or {@code DONE} if the
     *         previous index would be past the beginning.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.518 -0500", hash_original_method = "6641F70E0E9C6153122A4B9C58397241", hash_generated_method = "AC3C770EA337D5D3EEA5382F4D68ABF2")
    
public char previous() {
        if (offset == start) {
            return DONE;
        }
        return string.charAt(--offset);
    }

    /**
     * Sets the current index in the source string.
     *
     * @param location
     *            the index the current position is set to.
     * @return the character at the new index, or {@code DONE} if
     *         {@code location} is set to the end index.
     * @throws IllegalArgumentException
     *            if {@code location} is smaller than the begin index or greater
     *            than the end index.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.521 -0500", hash_original_method = "EE5D609C4869D1C6E36BED6C6655B503", hash_generated_method = "AFED77A3090D1B189B24D105A4484250")
    
public char setIndex(int location) {
        if (location < start || location > end) {
            throw new IllegalArgumentException();
        }
        offset = location;
        if (offset == end) {
            return DONE;
        }
        return string.charAt(offset);
    }

    /**
     * Sets the source string to iterate over. The begin and end positions are
     * set to the start and end of this string.
     *
     * @param value
     *            the new source string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.523 -0500", hash_original_method = "C3050CECF999A44D7D35577309274942", hash_generated_method = "22CC0F07CED43A3C2DB9262A496CFC9F")
    
public void setText(String value) {
        string = value;
        start = offset = 0;
        end = value.length();
    }
    
}

