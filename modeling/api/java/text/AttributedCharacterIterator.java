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
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;

public interface AttributedCharacterIterator extends CharacterIterator {
    
    public static class Attribute implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.340 -0500", hash_original_field = "A257E6C9ED72D07359849AED69D69087", hash_generated_field = "385C16D260BAD11F2749B86ED81E7405")

        private static final long serialVersionUID = -9142742483513960612L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.343 -0500", hash_original_field = "5B636D7ABFAFE29C5A1F4DDC52A925B5", hash_generated_field = "02AAC6208FE1255FF42E622F931F0B28")

        public static final Attribute INPUT_METHOD_SEGMENT = new Attribute("input_method_segment");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.346 -0500", hash_original_field = "BE94DBD7B8057611768D647AE1064C6A", hash_generated_field = "CA74EC4F0D13A5655444EF72BDE11F98")

        public static final Attribute LANGUAGE = new Attribute("language");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.349 -0500", hash_original_field = "01453FAFA7492D7320684842EA3055CB", hash_generated_field = "9778834F848AE49974A15956283CDD59")

        public static final Attribute READING = new Attribute("reading");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.351 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;

        /**
         * The constructor for an {@code Attribute} with the name passed.
         *
         * @param name
         *            the name of the new {@code Attribute}.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.354 -0500", hash_original_method = "ACCFEBD66AB851A6FC608414A08D299B", hash_generated_method = "61712E1BA4300DCAD5753E2F1F265E00")
        
protected Attribute(String name) {
            this.name = name;
        }

        /**
         * Compares this attribute with the specified object. Checks if both
         * objects are the same instance. It is defined final so all subclasses
         * have the same behavior for this method.
         *
         * @param object
         *            the object to compare against.
         * @return {@code true} if the object passed is equal to this instance;
         *         {@code false} otherwise.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.357 -0500", hash_original_method = "36C8AF9F829C9B051BDBF3B9526FC822", hash_generated_method = "34C966AA4C0E8EC46BF85551F0775538")
        
@Override
        public final boolean equals(Object object) {
            return this == object;
        }

        /**
         * Returns the name of this attribute.
         *
         * @return the name of this attribute.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.359 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "C7902D845D08F4F6CA0D1BA5E593678A")
        
protected String getName() {
            return name;
        }

        /**
         * Calculates the hash code for objects of type {@code Attribute}. It
         * is defined final so all sub types calculate their hash code
         * identically.
         *
         * @return the hash code for this instance of {@code Attribute}.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.361 -0500", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "BDAAB55570B432722AF7AB079E5FB145")
        
@Override
        public final int hashCode() {
            return super.hashCode();
        }

        /**
         * Resolves a deserialized instance to the correct constant attribute.
         *
         * @return the {@code Attribute} this instance represents.
         * @throws InvalidObjectException
         *             if this instance is not of type {@code Attribute.class}
         *             or if it is not a known {@code Attribute}.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.364 -0500", hash_original_method = "E825C982907901F08723C9B3A9C59DC5", hash_generated_method = "B5F8BDA74B76C82BB3DB988F74EDA6D3")
        
protected Object readResolve() throws InvalidObjectException {
            /*
             * This class is used like Java enums, where all instances are
             * defined as fields of their own class. To preserve identity
             * equality, resolve to the canonical instance when deserialized.
             */
            try {
                for (Field field : getClass().getFields()) {
                    if (field.getType() == getClass() && Modifier.isStatic(field.getModifiers())) {
                        Attribute candidate = (Attribute) field.get(null);
                        if (name.equals(candidate.name)) {
                            return candidate;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
            }
            throw new InvalidObjectException("Failed to resolve " + this);
        }

        /**
         * Returns the name of the class followed by a "(", the name of the
         * attribute, and a ")".
         *
         * @return the string representing this instance.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.367 -0500", hash_original_method = "4A1605B03FE1E22048A20B9E05E481A5", hash_generated_method = "4396D2BAEFB73347858E563F022F81BC")
        
@Override
        public String toString() {
            return getClass().getName() + '(' + getName() + ')';
        }
    }
    
    public Set<Attribute> getAllAttributeKeys();
    
    public Object getAttribute(Attribute attribute);
    
    public Map<Attribute, Object> getAttributes();
    
    public int getRunLimit();
    
    public int getRunLimit(Attribute attribute);
    
    public int getRunLimit(Set<? extends Attribute> attributes);
    
    public int getRunStart();
    
    public int getRunStart(Attribute attribute);
    
    public int getRunStart(Set<? extends Attribute> attributes);
}
