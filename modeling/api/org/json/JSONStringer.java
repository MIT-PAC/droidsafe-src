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


package org.json;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONStringer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.875 -0500", hash_original_field = "9554BB4AB1E316BAC076E8B4D17E52B3", hash_generated_field = "A0CBD6F499FC0AC1E6545290B568BB70")

    final StringBuilder out = new StringBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.879 -0500", hash_original_field = "03EBC1DED9EC27569647EC83C19CE188", hash_generated_field = "28EC373715B6F8CAC037841941695683")

    private final List<Scope> stack = new ArrayList<Scope>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.882 -0500", hash_original_field = "F000C6E98B2D56207FC8F266161FDDAE", hash_generated_field = "7D7A545AD595A13E474956B04BBDC653")

    private  String indent;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.884 -0500", hash_original_method = "98D853100F79BF96F83BA7B441C56113", hash_generated_method = "842E6284FCF12AC824A60F0618E2AA25")
    
public JSONStringer() {
        indent = null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.886 -0500", hash_original_method = "3DA6CD526A78C194327021A156DBFACA", hash_generated_method = "3DA6CD526A78C194327021A156DBFACA")
    
JSONStringer(int indentSpaces) {
        char[] indentChars = new char[indentSpaces];
        Arrays.fill(indentChars, ' ');
        indent = new String(indentChars);
    }

    /**
     * Begins encoding a new array. Each call to this method must be paired with
     * a call to {@link #endArray}.
     *
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.888 -0500", hash_original_method = "2E37A32AF13C3DB4BD8A6EB72023C7E4", hash_generated_method = "58C99E276A55D8F7D3AE52FB8031873D")
    
public JSONStringer array() throws JSONException {
        return open(Scope.EMPTY_ARRAY, "[");
    }

    /**
     * Ends encoding the current array.
     *
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.891 -0500", hash_original_method = "6A2E08939F192DB9BEF6B9CE1D1800F8", hash_generated_method = "39A4C997697F55BFCE6668965317B68A")
    
public JSONStringer endArray() throws JSONException {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    /**
     * Begins encoding a new object. Each call to this method must be paired
     * with a call to {@link #endObject}.
     *
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.893 -0500", hash_original_method = "CFE0E3CA762AC926F745749CF2134248", hash_generated_method = "1E5F361A76B398BAA875949F32A2F5C6")
    
public JSONStringer object() throws JSONException {
        return open(Scope.EMPTY_OBJECT, "{");
    }

    /**
     * Ends encoding the current object.
     *
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.895 -0500", hash_original_method = "04277D36A4D54D9CF9D1FF565E2D8229", hash_generated_method = "FB26E8F3B483A05A2AB71E2679FC20F2")
    
public JSONStringer endObject() throws JSONException {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    /**
     * Enters a new scope by appending any necessary whitespace and the given
     * bracket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.897 -0500", hash_original_method = "FE9B399F97E79B5140A06EB88BCEBC31", hash_generated_method = "FE9B399F97E79B5140A06EB88BCEBC31")
    
JSONStringer open(Scope empty, String openBracket) throws JSONException {
        if (stack.isEmpty() && out.length() > 0) {
            throw new JSONException("Nesting problem: multiple top-level roots");
        }
        beforeValue();
        stack.add(empty);
        out.append(openBracket);
        return this;
    }

    /**
     * Closes the current scope by appending any necessary whitespace and the
     * given bracket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.900 -0500", hash_original_method = "6B42F025815F6D5CF3C9CA43230A22B6", hash_generated_method = "6B42F025815F6D5CF3C9CA43230A22B6")
    
JSONStringer close(Scope empty, Scope nonempty, String closeBracket) throws JSONException {
        Scope context = peek();
        if (context != nonempty && context != empty) {
            throw new JSONException("Nesting problem");
        }

        stack.remove(stack.size() - 1);
        if (context == nonempty) {
            newline();
        }
        out.append(closeBracket);
        return this;
    }

    /**
     * Returns the value on the top of the stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.903 -0500", hash_original_method = "8F2C7ADB42C2C89CD99F5BA7F29697D3", hash_generated_method = "41778C0E8D4ACCEABECB6CD9DAF58067")
    
private Scope peek() throws JSONException {
        if (stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * Replace the value on the top of the stack with the given value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.905 -0500", hash_original_method = "06C25D9275C46608400AACFE7B687C39", hash_generated_method = "F6FEC691A089DA01633F8C77882C744D")
    
private void replaceTop(Scope topOfStack) {
        stack.set(stack.size() - 1, topOfStack);
    }

    /**
     * Encodes {@code value}.
     *
     * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
     *     Integer, Long, Double or null. May not be {@link Double#isNaN() NaNs}
     *     or {@link Double#isInfinite() infinities}.
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.908 -0500", hash_original_method = "71F86DA89D5C1CA3A74E1957819F40E1", hash_generated_method = "8641BB4A098E3400D15415ECE199D078")
    
public JSONStringer value(Object value) throws JSONException {
        if (stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }

        if (value instanceof JSONArray) {
            ((JSONArray) value).writeTo(this);
            return this;

        } else if (value instanceof JSONObject) {
            ((JSONObject) value).writeTo(this);
            return this;
        }

        beforeValue();

        if (value == null
                || value instanceof Boolean
                || value == JSONObject.NULL) {
            out.append(value);

        } else if (value instanceof Number) {
            out.append(JSONObject.numberToString((Number) value));

        } else {
            string(value.toString());
        }

        return this;
    }

    /**
     * Encodes {@code value} to this stringer.
     *
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.910 -0500", hash_original_method = "FCFB4EBC72F92C82B8A5BB74120390AB", hash_generated_method = "5A47643B3B96288E3B6B5EF58A891F71")
    
public JSONStringer value(boolean value) throws JSONException {
        if (stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        beforeValue();
        out.append(value);
        return this;
    }

    /**
     * Encodes {@code value} to this stringer.
     *
     * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
     *     {@link Double#isInfinite() infinities}.
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.912 -0500", hash_original_method = "B92957EDC8605AA2DADE9F77E64B9066", hash_generated_method = "E24D20CB87777A53B425F6762AC951B6")
    
public JSONStringer value(double value) throws JSONException {
        if (stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        beforeValue();
        out.append(JSONObject.numberToString(value));
        return this;
    }

    /**
     * Encodes {@code value} to this stringer.
     *
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.914 -0500", hash_original_method = "9F8BADDEDC1CE205B7B8CDF7A0DB9A85", hash_generated_method = "6F17948D9125C197706FFF8403D3B9F3")
    
public JSONStringer value(long value) throws JSONException {
        if (stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        beforeValue();
        out.append(value);
        return this;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.917 -0500", hash_original_method = "E6F73466C6FDC5C4F374E57C86CB98DF", hash_generated_method = "8B59663161522EDC93DCA494C2899DF8")
    
private void string(String value) {
        out.append("\"");
        for (int i = 0, length = value.length(); i < length; i++) {
            char c = value.charAt(i);

            /*
             * From RFC 4627, "All Unicode characters may be placed within the
             * quotation marks except for the characters that must be escaped:
             * quotation mark, reverse solidus, and the control characters
             * (U+0000 through U+001F)."
             */
            switch (c) {
                case '"':
                case '\\':
                case '/':
                    out.append('\\').append(c);
                    break;

                case '\t':
                    out.append("\\t");
                    break;

                case '\b':
                    out.append("\\b");
                    break;

                case '\n':
                    out.append("\\n");
                    break;

                case '\r':
                    out.append("\\r");
                    break;

                case '\f':
                    out.append("\\f");
                    break;

                default:
                    if (c <= 0x1F) {
                        out.append(String.format("\\u%04x", (int) c));
                    } else {
                        out.append(c);
                    }
                    break;
            }

        }
        out.append("\"");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.920 -0500", hash_original_method = "A1C4E39B6594D26F11F448F86F922EBA", hash_generated_method = "DFCA45D977E86FFB6D1A5152AF9391A1")
    
private void newline() {
        if (indent == null) {
            return;
        }

        out.append("\n");
        for (int i = 0; i < stack.size(); i++) {
            out.append(indent);
        }
    }

    /**
     * Encodes the key (property name) to this stringer.
     *
     * @param name the name of the forthcoming value. May not be null.
     * @return this stringer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.922 -0500", hash_original_method = "473489656459EE056EBCFF443DF4BB5C", hash_generated_method = "45060C32A54FC5AA9554F1AC32B91A6A")
    
public JSONStringer key(String name) throws JSONException {
        if (name == null) {
            throw new JSONException("Names must be non-null");
        }
        beforeKey();
        string(name);
        return this;
    }

    /**
     * Inserts any necessary separators and whitespace before a name. Also
     * adjusts the stack to expect the key's value.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.924 -0500", hash_original_method = "2432D2D31ED521C760D918E6DCE1C6CE", hash_generated_method = "EFBF8EEE61202CEEA55EB02BE50D9FAB")
    
private void beforeKey() throws JSONException {
        Scope context = peek();
        if (context == Scope.NONEMPTY_OBJECT) { // first in object
            out.append(',');
        } else if (context != Scope.EMPTY_OBJECT) { // not in an object!
            throw new JSONException("Nesting problem");
        }
        newline();
        replaceTop(Scope.DANGLING_KEY);
    }

    /**
     * Inserts any necessary separators and whitespace before a literal value,
     * inline array, or inline object. Also adjusts the stack to expect either a
     * closing bracket or another element.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.927 -0500", hash_original_method = "9CA1703B701EBBFA9C513149EAF6F304", hash_generated_method = "6E4181A1A4AC2C5E6956D940DF347FA6")
    
private void beforeValue() throws JSONException {
        if (stack.isEmpty()) {
            return;
        }

        Scope context = peek();
        if (context == Scope.EMPTY_ARRAY) { // first in array
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
        } else if (context == Scope.NONEMPTY_ARRAY) { // another in array
            out.append(',');
            newline();
        } else if (context == Scope.DANGLING_KEY) { // value for key
            out.append(indent == null ? ":" : ": ");
            replaceTop(Scope.NONEMPTY_OBJECT);
        } else if (context != Scope.NULL) {
            throw new JSONException("Nesting problem");
        }
    }

    /**
     * Returns the encoded JSON string.
     *
     * <p>If invoked with unterminated arrays or unclosed objects, this method's
     * return value is undefined.
     *
     * <p><strong>Warning:</strong> although it contradicts the general contract
     * of {@link Object#toString}, this method returns null if the stringer
     * contains no data.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.929 -0500", hash_original_method = "84F418CD08C16D699E3DC2920B2AB795", hash_generated_method = "320EA7E88D5C5D1897AC412B38C46602")
    
@Override public String toString() {
        return out.length() == 0 ? null : out.toString();
    }
    
    enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL,
    }
    
}

