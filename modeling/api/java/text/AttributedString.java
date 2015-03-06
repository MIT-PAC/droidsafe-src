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
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class AttributedString {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.095 -0500", hash_original_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C", hash_generated_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C")

    String text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.097 -0500", hash_original_field = "EA3CF0028C57B0F0FB6C371B620465D1", hash_generated_field = "EA3CF0028C57B0F0FB6C371B620465D1")

    Map<AttributedCharacterIterator.Attribute, List<Range>> attributeMap;

    /**
     * Constructs an {@code AttributedString} from an {@code
     * AttributedCharacterIterator}, which represents attributed text.
     *
     * @param iterator
     *            the {@code AttributedCharacterIterator} that contains the text
     *            for this attributed string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.198 -0500", hash_original_method = "5638BBE38DFF9B04A672F4EC9A02409B", hash_generated_method = "549451187631A94BF8217CD56E05447C")
    
public AttributedString(AttributedCharacterIterator iterator) {
        if (iterator.getBeginIndex() > iterator.getEndIndex()) {
            throw new IllegalArgumentException("Invalid substring range");
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = iterator.getBeginIndex(); i < iterator.getEndIndex(); i++) {
            buffer.append(iterator.current());
            iterator.next();
        }
        text = buffer.toString();
        Set<AttributedCharacterIterator.Attribute> attributes = iterator
                .getAllAttributeKeys();
        if (attributes == null) {
            return;
        }
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);

        Iterator<Attribute> it = attributes.iterator();
        while (it.hasNext()) {
            AttributedCharacterIterator.Attribute attribute = it.next();
            iterator.setIndex(0);
            while (iterator.current() != CharacterIterator.DONE) {
                int start = iterator.getRunStart(attribute);
                int limit = iterator.getRunLimit(attribute);
                Object value = iterator.getAttribute(attribute);
                if (value != null) {
                    addAttribute(attribute, value, start, limit);
                }
                iterator.setIndex(limit);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.202 -0500", hash_original_method = "3A8973AD4EBE1F3B94E1633368C42F9D", hash_generated_method = "76E0AB286E2C917791F96CD048B777AA")
    
private AttributedString(AttributedCharacterIterator iterator, int start,
            int end, Set<Attribute> attributes) {
        if (start < iterator.getBeginIndex() || end > iterator.getEndIndex()
                || start > end) {
            throw new IllegalArgumentException();
        }

        if (attributes == null) {
            return;
        }

        StringBuilder buffer = new StringBuilder();
        iterator.setIndex(start);
        while (iterator.getIndex() < end) {
            buffer.append(iterator.current());
            iterator.next();
        }
        text = buffer.toString();
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);

        Iterator<Attribute> it = attributes.iterator();
        while (it.hasNext()) {
            AttributedCharacterIterator.Attribute attribute = it.next();
            iterator.setIndex(start);
            while (iterator.getIndex() < end) {
                Object value = iterator.getAttribute(attribute);
                int runStart = iterator.getRunStart(attribute);
                int limit = iterator.getRunLimit(attribute);
                if ((value instanceof Annotation && runStart >= start && limit <= end)
                        || (value != null && !(value instanceof Annotation))) {
                    addAttribute(attribute, value, (runStart < start ? start
                            : runStart)
                            - start, (limit > end ? end : limit) - start);
                }
                iterator.setIndex(limit);
            }
        }
    }

    /**
     * Constructs an {@code AttributedString} from a range of the text contained
     * in the specified {@code AttributedCharacterIterator}, starting at {@code
     * start} and ending at {@code end}. All attributes will be copied to this
     * attributed string.
     *
     * @param iterator
     *            the {@code AttributedCharacterIterator} that contains the text
     *            for this attributed string.
     * @param start
     *            the start index of the range of the copied text.
     * @param end
     *            the end index of the range of the copied text.
     * @throws IllegalArgumentException
     *             if {@code start} is less than first index of
     *             {@code iterator}, {@code end} is greater than the last
     *             index + 1 in {@code iterator} or if {@code start > end}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.204 -0500", hash_original_method = "D0E1FC5545253EA6E008AE3675A9452F", hash_generated_method = "4A69B046F0DC285A3AD270A5E57E6835")
    
public AttributedString(AttributedCharacterIterator iterator, int start,
            int end) {
        this(iterator, start, end, iterator.getAllAttributeKeys());
    }

    /**
     * Constructs an {@code AttributedString} from a range of the text contained
     * in the specified {@code AttributedCharacterIterator}, starting at {@code
     * start}, ending at {@code end} and it will copy the attributes defined in
     * the specified set. If the set is {@code null} then all attributes are
     * copied.
     *
     * @param iterator
     *            the {@code AttributedCharacterIterator} that contains the text
     *            for this attributed string.
     * @param start
     *            the start index of the range of the copied text.
     * @param end
     *            the end index of the range of the copied text.
     * @param attributes
     *            the set of attributes that will be copied, or all if it is
     *            {@code null}.
     * @throws IllegalArgumentException
     *             if {@code start} is less than first index of
     *             {@code iterator}, {@code end} is greater than the last index +
     *             1 in {@code iterator} or if {@code start > end}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.207 -0500", hash_original_method = "B4766721E168BC843A6EA06CFE59500E", hash_generated_method = "B59C0E88B16BF64C9DF1EEBC384D83DC")
    
public AttributedString(AttributedCharacterIterator iterator, int start,
            int end, AttributedCharacterIterator.Attribute[] attributes) {
        this(iterator, start, end, (attributes == null
                ? new HashSet<Attribute>()
                : new HashSet<Attribute>(Arrays.asList(attributes))));
    }

    /**
     * Creates an {@code AttributedString} from the given text.
     *
     * @param value
     *            the text to take as base for this attributed string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.210 -0500", hash_original_method = "A0ACF5D97B9D79B3295575A771939692", hash_generated_method = "48D6ACE7C7ABD5B1247D0E282AA020F5")
    
public AttributedString(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        text = value;
        attributeMap = new HashMap<Attribute, List<Range>>(11);
    }

    /**
     * Creates an {@code AttributedString} from the given text and the
     * attributes. The whole text has the given attributes applied.
     *
     * @param value
     *            the text to take as base for this attributed string.
     * @param attributes
     *            the attributes that the text is associated with.
     * @throws IllegalArgumentException
     *             if the length of {@code value} is 0 but the size of {@code
     *             attributes} is greater than 0.
     * @throws NullPointerException
     *             if {@code value} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.213 -0500", hash_original_method = "85CF866984BA31F6F3E97322323F86BA", hash_generated_method = "447A1B5A9EC03334905B86FA059A8461")
    
public AttributedString(String value,
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (value.length() == 0 && !attributes.isEmpty()) {
            throw new IllegalArgumentException("Cannot add attributes to empty string");
        }
        text = value;
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<?> it = attributes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            ArrayList<Range> ranges = new ArrayList<Range>(1);
            ranges.add(new Range(0, text.length(), entry.getValue()));
            attributeMap.put((AttributedCharacterIterator.Attribute) entry
                    .getKey(), ranges);
        }
    }

    /**
     * Applies a given attribute to this string.
     *
     * @param attribute
     *            the attribute that will be applied to this string.
     * @param value
     *            the value of the attribute that will be applied to this
     *            string.
     * @throws IllegalArgumentException
     *             if the length of this attributed string is 0.
     * @throws NullPointerException
     *             if {@code attribute} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.216 -0500", hash_original_method = "F800EB2F1E580436E49CB51D04E3F37C", hash_generated_method = "52E912297D8319959E7727A211EA1F19")
    
public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value) {
        if (attribute == null) {
            throw new NullPointerException();
        }
        if (text.length() == 0) {
            throw new IllegalArgumentException();
        }

        List<Range> ranges = attributeMap.get(attribute);
        if (ranges == null) {
            ranges = new ArrayList<Range>(1);
            attributeMap.put(attribute, ranges);
        } else {
            ranges.clear();
        }
        ranges.add(new Range(0, text.length(), value));
    }

    /**
     * Applies a given attribute to the given range of this string.
     *
     * @param attribute
     *            the attribute that will be applied to this string.
     * @param value
     *            the value of the attribute that will be applied to this
     *            string.
     * @param start
     *            the start of the range where the attribute will be applied.
     * @param end
     *            the end of the range where the attribute will be applied.
     * @throws IllegalArgumentException
     *             if {@code start < 0}, {@code end} is greater than the length
     *             of this string, or if {@code start >= end}.
     * @throws NullPointerException
     *             if {@code attribute} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.220 -0500", hash_original_method = "1EA9CE9DE6197B4051F39E120F823C8E", hash_generated_method = "93559F9E76B147DE214A12BD25014E3C")
    
public void addAttribute(AttributedCharacterIterator.Attribute attribute,
            Object value, int start, int end) {
        if (attribute == null) {
            throw new NullPointerException();
        }
        if (start < 0 || end > text.length() || start >= end) {
            throw new IllegalArgumentException();
        }

        if (value == null) {
            return;
        }

        List<Range> ranges = attributeMap.get(attribute);
        if (ranges == null) {
            ranges = new ArrayList<Range>(1);
            ranges.add(new Range(start, end, value));
            attributeMap.put(attribute, ranges);
            return;
        }
        ListIterator<Range> it = ranges.listIterator();
        while (it.hasNext()) {
            Range range = it.next();
            if (end <= range.start) {
                it.previous();
                break;
            } else if (start < range.end
                    || (start == range.end && value.equals(range.value))) {
                Range r1 = null, r3;
                it.remove();
                r1 = new Range(range.start, start, range.value);
                r3 = new Range(end, range.end, range.value);

                while (end > range.end && it.hasNext()) {
                    range = it.next();
                    if (end <= range.end) {
                        if (end > range.start
                                || (end == range.start && value.equals(range.value))) {
                            it.remove();
                            r3 = new Range(end, range.end, range.value);
                            break;
                        }
                    } else {
                        it.remove();
                    }
                }

                if (value.equals(r1.value)) {
                    if (value.equals(r3.value)) {
                        it.add(new Range(r1.start < start ? r1.start : start,
                                r3.end > end ? r3.end : end, r1.value));
                    } else {
                        it.add(new Range(r1.start < start ? r1.start : start,
                                end, r1.value));
                        if (r3.start < r3.end) {
                            it.add(r3);
                        }
                    }
                } else {
                    if (value.equals(r3.value)) {
                        if (r1.start < r1.end) {
                            it.add(r1);
                        }
                        it.add(new Range(start, r3.end > end ? r3.end : end,
                                r3.value));
                    } else {
                        if (r1.start < r1.end) {
                            it.add(r1);
                        }
                        it.add(new Range(start, end, value));
                        if (r3.start < r3.end) {
                            it.add(r3);
                        }
                    }
                }
                return;
            }
        }
        it.add(new Range(start, end, value));
    }

    /**
     * Applies a given set of attributes to the given range of the string.
     *
     * @param attributes
     *            the set of attributes that will be applied to this string.
     * @param start
     *            the start of the range where the attribute will be applied.
     * @param end
     *            the end of the range where the attribute will be applied.
     * @throws IllegalArgumentException
     *             if {@code start < 0}, {@code end} is greater than the length
     *             of this string, or if {@code start >= end}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.223 -0500", hash_original_method = "9BDF8CEEC650CFF21B203033378C7411", hash_generated_method = "D2B5FC2E1D0298403E6F489A411CC0EB")
    
public void addAttributes(
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes,
            int start, int end) {
        Iterator<?> it = attributes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            addAttribute(
                    (AttributedCharacterIterator.Attribute) entry.getKey(),
                    entry.getValue(), start, end);
        }
    }

    /**
     * Returns an {@code AttributedCharacterIterator} that gives access to the
     * complete content of this attributed string.
     *
     * @return the newly created {@code AttributedCharacterIterator}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.225 -0500", hash_original_method = "3C3A14639543169375B4E8491231683C", hash_generated_method = "70FF1D5C6DB97D8D9158233D5FA99D28")
    
public AttributedCharacterIterator getIterator() {
        return new AttributedIterator(this);
    }

    /**
     * Returns an {@code AttributedCharacterIterator} that gives access to the
     * complete content of this attributed string. Only attributes contained in
     * {@code attributes} are available from this iterator if they are defined
     * for this text.
     *
     * @param attributes
     *            the array containing attributes that will be in the new
     *            iterator if they are defined for this text.
     * @return the newly created {@code AttributedCharacterIterator}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.228 -0500", hash_original_method = "AFA08901CAEF730E40B185484FAABB29", hash_generated_method = "26A06F6605BB57E3A2E7B284838AB359")
    
public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes) {
        return new AttributedIterator(this, attributes, 0, text.length());
    }

    /**
     * Returns an {@code AttributedCharacterIterator} that gives access to the
     * contents of this attributed string starting at index {@code start} up to
     * index {@code end}. Only attributes contained in {@code attributes} are
     * available from this iterator if they are defined for this text.
     *
     * @param attributes
     *            the array containing attributes that will be in the new
     *            iterator if they are defined for this text.
     * @param start
     *            the start index of the iterator on the underlying text.
     * @param end
     *            the end index of the iterator on the underlying text.
     * @return the newly created {@code AttributedCharacterIterator}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.230 -0500", hash_original_method = "EF8FB9411A496C9D99CDE8B83C48CE6B", hash_generated_method = "7DC49E672FE2CD50CFEF589021657F23")
    
public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes, int start,
            int end) {
        return new AttributedIterator(this, attributes, start, end);
    }
    
    static class Range {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.100 -0500", hash_original_field = "A420862623A673AB42FCEC90A616158F", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.102 -0500", hash_original_field = "302E5A3147803830441A79AED31F4022", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.105 -0500", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.107 -0500", hash_original_method = "9919123D3D1FFC7D42BA1CB1CAFB2DA5", hash_generated_method = "9919123D3D1FFC7D42BA1CB1CAFB2DA5")
        
Range(int s, int e, Object v) {
            start = s;
            end = e;
            value = v;
        }
        
    }
    
    static class AttributedIterator implements AttributedCharacterIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_field = "8D589AFA4DFAEEED85FFF5AA78E5FF6A", hash_generated_field = "D0C174A901D805EE41B6CF46156FC355")

        private int begin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

        private int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.115 -0500", hash_original_field = "29952B3FB0A05E507FF36DA98D657172", hash_generated_field = "D02499DC7F8023F8CAFDC0A4B220FECC")

        private AttributedString attrString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.117 -0500", hash_original_field = "02187A1DE7B3344886DF15C4DDE851BF", hash_generated_field = "8E1D222DFFE5F062ACF483541B60F0D5")

        private HashSet<Attribute> attributesAllowed;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.120 -0500", hash_original_method = "E441422DE6FDEDB0F1BB74606A67171C", hash_generated_method = "E441422DE6FDEDB0F1BB74606A67171C")
        
AttributedIterator(AttributedString attrString) {
            this.attrString = attrString;
            begin = 0;
            end = attrString.text.length();
            offset = 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.123 -0500", hash_original_method = "43841E67E512106866A3902EDBE2D718", hash_generated_method = "43841E67E512106866A3902EDBE2D718")
        
AttributedIterator(AttributedString attrString,
                AttributedCharacterIterator.Attribute[] attributes, int begin,
                int end) {
            if (begin < 0 || end > attrString.text.length() || begin > end) {
                throw new IllegalArgumentException();
            }
            this.begin = begin;
            this.end = end;
            offset = begin;
            this.attrString = attrString;
            if (attributes != null) {
                HashSet<Attribute> set = new HashSet<Attribute>(
                        (attributes.length * 4 / 3) + 1);
                for (int i = attributes.length; --i >= 0;) {
                    set.add(attributes[i]);
                }
                attributesAllowed = set;
            }
        }

        /**
         * Returns a new {@code AttributedIterator} with the same source string,
         * begin, end, and current index as this attributed iterator.
         *
         * @return a shallow copy of this attributed iterator.
         * @see java.lang.Cloneable
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.127 -0500", hash_original_method = "CC2190075ADAC44CCBDC93141CA9BE6C", hash_generated_method = "44AE55E213931B931D436A023F145C4E")
        
@Override
        @SuppressWarnings("unchecked")
        public Object clone() {
            try {
                AttributedIterator clone = (AttributedIterator) super.clone();
                if (attributesAllowed != null) {
                    clone.attributesAllowed = (HashSet<Attribute>) attributesAllowed
                            .clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.129 -0500", hash_original_method = "81A9D498AF1F73C3D962F8C3EDD6D3D9", hash_generated_method = "FEFE4C54A85D8DEC647D86E467CEFE61")
        
public char current() {
            if (offset == end) {
                return DONE;
            }
            return attrString.text.charAt(offset);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.132 -0500", hash_original_method = "4AF9D055D17E58470820B415A8EBAFA4", hash_generated_method = "AEF215975D4DD2DFDD64AD59FE4DAA92")
        
public char first() {
            if (begin == end) {
                return DONE;
            }
            offset = begin;
            return attrString.text.charAt(offset);
        }

        /**
         * Returns the begin index in the source string.
         *
         * @return the index of the first character to iterate.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.134 -0500", hash_original_method = "1D4D2C19F23B97FE6ECF3D3284916FD4", hash_generated_method = "F7911960348415BFBAD397B847A674C7")
        
public int getBeginIndex() {
            return begin;
        }

        /**
         * Returns the end index in the source String.
         *
         * @return the index one past the last character to iterate.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.137 -0500", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "ACC8D1B1439CA809AB08C45ABAB29DED")
        
public int getEndIndex() {
            return end;
        }

        /**
         * Returns the current index in the source String.
         *
         * @return the current index.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.139 -0500", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "78C6B22E21CF81415ABD0C7B74926529")
        
public int getIndex() {
            return offset;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.142 -0500", hash_original_method = "20101C80E99D94E4CD68776989F0B447", hash_generated_method = "6373E2873E101E6AAFA9CF3AE9E0B9AC")
        
private boolean inRange(Range range) {
            if (!(range.value instanceof Annotation)) {
                return true;
            }
            return range.start >= begin && range.start < end
                    && range.end > begin && range.end <= end;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.145 -0500", hash_original_method = "D282867E9466B5652FFBD5F7BCA71B9B", hash_generated_method = "B2D3D82DDC0DCD4CC70151539E51F85B")
        
private boolean inRange(List<Range> ranges) {
            Iterator<Range> it = ranges.iterator();
            while (it.hasNext()) {
                Range range = it.next();
                if (range.start >= begin && range.start < end) {
                    return !(range.value instanceof Annotation)
                            || (range.end > begin && range.end <= end);
                } else if (range.end > begin && range.end <= end) {
                    return !(range.value instanceof Annotation)
                            || (range.start >= begin && range.start < end);
                }
            }
            return false;
        }

        /**
         * Returns a set of attributes present in the {@code AttributedString}.
         * An empty set returned indicates that no attributes where defined.
         *
         * @return a set of attribute keys that may be empty.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.148 -0500", hash_original_method = "1F90FC3406D3E88B418E6F5A05B249D4", hash_generated_method = "19BDE914DC09300083E2188F1CB3A53B")
        
public Set<AttributedIterator.Attribute> getAllAttributeKeys() {
            if (begin == 0 && end == attrString.text.length()
                    && attributesAllowed == null) {
                return attrString.attributeMap.keySet();
            }

            Set<AttributedIterator.Attribute> result = new HashSet<Attribute>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    .entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Attribute, List<Range>> entry = it.next();
                if (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey())) {
                    List<Range> ranges = entry.getValue();
                    if (inRange(ranges)) {
                        result.add(entry.getKey());
                    }
                }
            }
            return result;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.151 -0500", hash_original_method = "7F47FD199B74CEDC765420E2B0AD1B85", hash_generated_method = "8B0F14EC21CD12FEE40E3DE66D4F41E1")
        
private Object currentValue(List<Range> ranges) {
            Iterator<Range> it = ranges.iterator();
            while (it.hasNext()) {
                Range range = it.next();
                if (offset >= range.start && offset < range.end) {
                    return inRange(range) ? range.value : null;
                }
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.154 -0500", hash_original_method = "9256DFDAE9CB8C43C18A44C8B3AC6DAC", hash_generated_method = "333DD1A1694570679808041C2E323073")
        
public Object getAttribute(
                AttributedCharacterIterator.Attribute attribute) {
            if (attributesAllowed != null
                    && !attributesAllowed.contains(attribute)) {
                return null;
            }
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            if (ranges == null) {
                return null;
            }
            return currentValue(ranges);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.157 -0500", hash_original_method = "AAAFE2E009783E25A93A8B590538D893", hash_generated_method = "B7CA3841E6FE08E8D490A5AF31260DAA")
        
public Map<Attribute, Object> getAttributes() {
            Map<Attribute, Object> result = new HashMap<Attribute, Object>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    .entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Attribute, List<Range>> entry = it.next();
                if (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey())) {
                    Object value = currentValue(entry.getValue());
                    if (value != null) {
                        result.put(entry.getKey(), value);
                    }
                }
            }
            return result;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.159 -0500", hash_original_method = "B67CDF67136100A9ADF2991D47BD9A14", hash_generated_method = "1143D87374631893A073C09129971673")
        
public int getRunLimit() {
            return getRunLimit(getAllAttributeKeys());
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.162 -0500", hash_original_method = "40F484258D42E498FCA29FFC5F596001", hash_generated_method = "D0103678C208EFCE7480C5398687A394")
        
private int runLimit(List<Range> ranges) {
            int result = end;
            ListIterator<Range> it = ranges.listIterator(ranges.size());
            while (it.hasPrevious()) {
                Range range = it.previous();
                if (range.end <= begin) {
                    break;
                }
                if (offset >= range.start && offset < range.end) {
                    return inRange(range) ? range.end : result;
                } else if (offset >= range.end) {
                    break;
                }
                result = range.start;
            }
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.164 -0500", hash_original_method = "F819F4AC98ED7B00F15856104CEA6D7F", hash_generated_method = "E22F8A8B1478140A715EF8CB3FB93B77")
        
public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            if (attributesAllowed != null
                    && !attributesAllowed.contains(attribute)) {
                return end;
            }
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            if (ranges == null) {
                return end;
            }
            return runLimit(ranges);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.167 -0500", hash_original_method = "39CD1571C1B0AAE61A932D3B1E130DFE", hash_generated_method = "BF9BCD83E0D05B9063793D870686585E")
        
public int getRunLimit(Set<? extends Attribute> attributes) {
            int limit = end;
            Iterator<? extends Attribute> it = attributes.iterator();
            while (it.hasNext()) {
                AttributedCharacterIterator.Attribute attribute = it.next();
                int newLimit = getRunLimit(attribute);
                if (newLimit < limit) {
                    limit = newLimit;
                }
            }
            return limit;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.169 -0500", hash_original_method = "FE3F08CD8D40BCC02EAAB9CF9D349F73", hash_generated_method = "8E2B58FDAD2633BA3E10448891A05BE2")
        
public int getRunStart() {
            return getRunStart(getAllAttributeKeys());
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.173 -0500", hash_original_method = "3940F742081E74CA234FF11DA5FD3120", hash_generated_method = "1AF3D97DF9B83DA977D426D799AF9A3E")
        
private int runStart(List<Range> ranges) {
            int result = begin;
            Iterator<Range> it = ranges.iterator();
            while (it.hasNext()) {
                Range range = it.next();
                if (range.start >= end) {
                    break;
                }
                if (offset >= range.start && offset < range.end) {
                    return inRange(range) ? range.start : result;
                } else if (offset < range.start) {
                    break;
                }
                result = range.end;
            }
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.176 -0500", hash_original_method = "D8F9F8B7D0C4F74D05FEF10E27E7F588", hash_generated_method = "A7B117FF73641A857771605CBA73DFCC")
        
public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            if (attributesAllowed != null
                    && !attributesAllowed.contains(attribute)) {
                return begin;
            }
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            if (ranges == null) {
                return begin;
            }
            return runStart(ranges);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.179 -0500", hash_original_method = "62E2E3A1AAFB276945B722FDB547D45B", hash_generated_method = "6DC4E4B305594D2168B776393B666F59")
        
public int getRunStart(Set<? extends Attribute> attributes) {
            int start = begin;
            Iterator<? extends Attribute> it = attributes.iterator();
            while (it.hasNext()) {
                AttributedCharacterIterator.Attribute attribute = it.next();
                int newStart = getRunStart(attribute);
                if (newStart > start) {
                    start = newStart;
                }
            }
            return start;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.181 -0500", hash_original_method = "6CAD62DAB178D2919A2036BE42DEC497", hash_generated_method = "430325AAC24DBD01E7DF99B1EDA839D9")
        
public char last() {
            if (begin == end) {
                return DONE;
            }
            offset = end - 1;
            return attrString.text.charAt(offset);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.184 -0500", hash_original_method = "B623F272BE854A8CF15368B2FE2B8A97", hash_generated_method = "648C073C30860A21FCCBDA428DD692D0")
        
public char next() {
            if (offset >= (end - 1)) {
                offset = end;
                return DONE;
            }
            return attrString.text.charAt(++offset);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.187 -0500", hash_original_method = "E77E60DF0F891730B03F44D98923AB66", hash_generated_method = "5EA3C4C7CD74D6CCBBF3B03048B9F119")
        
public char previous() {
            if (offset == begin) {
                return DONE;
            }
            return attrString.text.charAt(--offset);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:03.189 -0500", hash_original_method = "C542CEFF91217DDB3083AD983C51F194", hash_generated_method = "890F7D5463D8C8B06260FB3BDC88E65A")
        
public char setIndex(int location) {
            if (location < begin || location > end) {
                throw new IllegalArgumentException();
            }
            offset = location;
            if (offset == end) {
                return DONE;
            }
            return attrString.text.charAt(offset);
        }
        
    }
    
}

