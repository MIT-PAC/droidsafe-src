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
 * Copyright (C) 2009 The Android Open Source Project
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


package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TypedProperties extends HashMap<String, Object> {
    /**
     * Instantiates a {@link java.io.StreamTokenizer} and sets its syntax tables
     * appropriately for the {@code TypedProperties} file format.
     *
     * @param r The {@code Reader} that the {@code StreamTokenizer} will read from
     * @return a newly-created and initialized {@code StreamTokenizer}
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.697 -0500", hash_original_method = "21E5AE23294866B670D117774FF68B3C", hash_generated_method = "1B295E4AB2294DCFBDF0C7865A9332B3")
    
static StreamTokenizer initTokenizer(Reader r) {
        StreamTokenizer st = new StreamTokenizer(r);

        // Treat everything we don't specify as "ordinary".
        st.resetSyntax();

        /* The only non-quoted-string words we'll be reading are:
         * - property names: [._$a-zA-Z0-9]
         * - type names: [a-zS]
         * - number literals: [-0-9.eExXA-Za-z]  ('x' for 0xNNN hex literals. "NaN", "Infinity")
         * - "true" or "false" (case insensitive): [a-zA-Z]
         */
        st.wordChars('0', '9');
        st.wordChars('A', 'Z');
        st.wordChars('a', 'z');
        st.wordChars('_', '_');
        st.wordChars('$', '$');
        st.wordChars('.', '.');
        st.wordChars('-', '-');
        st.wordChars('+', '+');

        // Single-character tokens
        st.ordinaryChar('=');

        // Other special characters
        st.whitespaceChars(' ', ' ');
        st.whitespaceChars('\t', '\t');
        st.whitespaceChars('\n', '\n');
        st.whitespaceChars('\r', '\r');
        st.quoteChar('"');

        // Java-style comments
        st.slashStarComments(true);
        st.slashSlashComments(true);

        return st;
    }

    /**
     * Converts a string to an internal type constant.
     *
     * @param typeName the type name to convert
     * @return the type constant that corresponds to {@code typeName},
     *         or {@code TYPE_ERROR} if the type is unknown
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.731 -0500", hash_original_method = "EF4819B29F3C178C4F6AF68711CF0B83", hash_generated_method = "C3543B83099E9A7A72D521A601682F75")
    
static int interpretType(String typeName) {
        if ("unset".equals(typeName)) {
            return TYPE_UNSET;
        } else if ("boolean".equals(typeName)) {
            return TYPE_BOOLEAN;
        } else if ("byte".equals(typeName)) {
            return TYPE_BYTE;
        } else if ("short".equals(typeName)) {
            return TYPE_SHORT;
        } else if ("int".equals(typeName)) {
            return TYPE_INT;
        } else if ("long".equals(typeName)) {
            return TYPE_LONG;
        } else if ("float".equals(typeName)) {
            return TYPE_FLOAT;
        } else if ("double".equals(typeName)) {
            return TYPE_DOUBLE;
        } else if ("String".equals(typeName)) {
            return TYPE_STRING;
        }
        return TYPE_ERROR;
    }

    /**
     * Parses the data in the reader.
     *
     * @param r The {@code Reader} containing input data to parse
     * @param map The {@code Map} to insert parameter values into
     * @throws ParseException if the input data is malformed
     * @throws IOException if there is a problem reading from the {@code Reader}
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.739 -0500", hash_original_method = "785911ECAA138D2E7940B3C09FD49889", hash_generated_method = "E3AC2BDA6DE51767040D1673E2EC6B0A")
    
static void parse(Reader r, Map<String, Object> map) throws ParseException, IOException {
        final StreamTokenizer st = initTokenizer(r);

        /* A property name must be a valid fully-qualified class + package name.
         * We don't support Unicode, though.
         */
        final String identifierPattern = "[a-zA-Z_$][0-9a-zA-Z_$]*";
        final Pattern propertyNamePattern =
            Pattern.compile("(" + identifierPattern + "\\.)*" + identifierPattern);

        while (true) {
            int token;

            // Read the next token, which is either the type or EOF.
            token = st.nextToken();
            if (token == StreamTokenizer.TT_EOF) {
                break;
            }
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "type name");
            }
            final int type = interpretType(st.sval);
            if (type == TYPE_ERROR) {
                throw new ParseException(st, "valid type name");
            }
            st.sval = null;

            if (type == TYPE_UNSET) {
                // Expect '('.
                token = st.nextToken();
                if (token != '(') {
                    throw new ParseException(st, "'('");
                }
            }

            // Read the property name.
            token = st.nextToken();
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "property name");
            }
            final String propertyName = st.sval;
            if (!propertyNamePattern.matcher(propertyName).matches()) {
                throw new ParseException(st, "valid property name");
            }
            st.sval = null;

            if (type == TYPE_UNSET) {
                // Expect ')'.
                token = st.nextToken();
                if (token != ')') {
                    throw new ParseException(st, "')'");
                }
                map.remove(propertyName);
            } else {
                // Expect '='.
                token = st.nextToken();
                if (token != '=') {
                    throw new ParseException(st, "'='");
                }

                // Read a value of the appropriate type, and insert into the map.
                final Object value = parseValue(st, type);
                final Object oldValue = map.remove(propertyName);
                if (oldValue != null) {
                    // TODO: catch the case where a string is set to null and then
                    //       the same property is defined with a different type.
                    if (value.getClass() != oldValue.getClass()) {
                        throw new ParseException(st,
                            "(property previously declared as a different type)");
                    }
                }
                map.put(propertyName, value);
            }

            // Expect ';'.
            token = st.nextToken();
            if (token != ';') {
                throw new ParseException(st, "';'");
            }
        }
    }

    /**
     * Parses the next token in the StreamTokenizer as the specified type.
     *
     * @param st The token source
     * @param type The type to interpret next token as
     * @return a Boolean, Number subclass, or String representing the value.
     *         Null strings are represented by the String instance NULL_STRING
     * @throws IOException if there is a problem reading from the {@code StreamTokenizer}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.744 -0500", hash_original_method = "9638F79FD1E953ECB07B4D80F472AAE0", hash_generated_method = "B44BA49CDDEAD21A77F269B911990AB1")
    
static Object parseValue(StreamTokenizer st, final int type) throws IOException {
        final int token = st.nextToken();

        if (type == TYPE_BOOLEAN) {
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "boolean constant");
            }

            if ("true".equals(st.sval)) {
                return Boolean.TRUE;
            } else if ("false".equals(st.sval)) {
                return Boolean.FALSE;
            }

            throw new ParseException(st, "boolean constant");
        } else if ((type & 0xff) == 'I') {
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "integer constant");
            }

            /* Parse the string.  Long.decode() handles C-style integer constants
             * ("0x" -> hex, "0" -> octal).  It also treats numbers with a prefix of "#" as
             * hex, but our syntax intentionally does not list '#' as a word character.
             */
            long value;
            try {
                value = Long.decode(st.sval);
            } catch (NumberFormatException ex) {
                throw new ParseException(st, "integer constant");
            }

            // Ensure that the type can hold this value, and return.
            int width = (type >> 8) & 0xff;
            switch (width) {
            case 1:
                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                    throw new ParseException(st, "8-bit integer constant");
                }
                return new Byte((byte)value);
            case 2:
                if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
                    throw new ParseException(st, "16-bit integer constant");
                }
                return new Short((short)value);
            case 4:
                if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
                    throw new ParseException(st, "32-bit integer constant");
                }
                return new Integer((int)value);
            case 8:
                if (value < Long.MIN_VALUE || value > Long.MAX_VALUE) {
                    throw new ParseException(st, "64-bit integer constant");
                }
                return new Long(value);
            default:
                throw new IllegalStateException(
                    "Internal error; unexpected integer type width " + width);
            }
        } else if ((type & 0xff) == 'F') {
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "float constant");
            }

            // Parse the string.
            /* TODO: Maybe just parse as float or double, losing precision if necessary.
             *       Parsing as double and converting to float can change the value
             *       compared to just parsing as float.
             */
            double value;
            try {
                /* TODO: detect if the string representation loses precision
                 *       when being converted to a double.
                 */
                value = Double.parseDouble(st.sval);
            } catch (NumberFormatException ex) {
                throw new ParseException(st, "float constant");
            }

            // Ensure that the type can hold this value, and return.
            if (((type >> 8) & 0xff) == 4) {
                // This property is a float; make sure the value fits.
                double absValue = Math.abs(value);
                if (absValue != 0.0 && !Double.isInfinite(value) && !Double.isNaN(value)) {
                    if (absValue < Float.MIN_VALUE || absValue > Float.MAX_VALUE) {
                        throw new ParseException(st, "32-bit float constant");
                    }
                }
                return new Float((float)value);
            } else {
                // This property is a double; no need to truncate.
                return new Double(value);
            }
        } else if (type == TYPE_STRING) {
            // Expect a quoted string or the word "null".
            if (token == '"') {
                return st.sval;
            } else if (token == StreamTokenizer.TT_WORD && "null".equals(st.sval)) {
                return NULL_STRING;
            }
            throw new ParseException(st, "double-quoted string or 'null'");
        }

        throw new IllegalStateException("Internal error; unknown type " + type);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.704 -0500", hash_original_field = "73616EF950FD28516A4EEC7E6CF51E60", hash_generated_field = "636FC1AE7A17ECC84638758548E6F26E")

    static final String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.707 -0500", hash_original_field = "AF26C1671A8AC3A570E72E32CBECB51F", hash_generated_field = "E1ACD2CFB22CAE29B9CA75C3973872EE")

    static final int TYPE_UNSET = 'x';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.709 -0500", hash_original_field = "241831DBE11FCFFBFB50978253773B99", hash_generated_field = "E580A7D7D1050DD90A59D8546A666FFF")

    static final int TYPE_BOOLEAN = 'Z';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.712 -0500", hash_original_field = "CEBD34A819ECD1F5BA309E12481D4047", hash_generated_field = "6BE67BABA764A60D2B4FFE61896B284A")

    static final int TYPE_BYTE = 'I' | 1 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.714 -0500", hash_original_field = "356940D51DB9E0C6BF638AEB1F5B30C6", hash_generated_field = "9A2BA086324E44D0FD861C86FC7A5A06")

    static final int TYPE_SHORT = 'I' | 2 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.716 -0500", hash_original_field = "521C6545CCB3FD363A7E5A07C92BCBC2", hash_generated_field = "DA873A8AC9972659FE05932734984FC1")

    static final int TYPE_INT = 'I' | 4 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.719 -0500", hash_original_field = "36A2502F4759A0FFBC612C3725E70051", hash_generated_field = "69BA5615F8B78F22534B8C5C19228490")

    static final int TYPE_LONG = 'I' | 8 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.721 -0500", hash_original_field = "735991253940BC0E31B8D7A9F8872600", hash_generated_field = "ED0FC9DA000EBF50B25ED5400E99DA5D")

    static final int TYPE_FLOAT = 'F' | 4 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.724 -0500", hash_original_field = "B9433B0C86987FEDDE76F2E51D2CDBF8", hash_generated_field = "5867595828327917045FEC3E185B8B83")

    static final int TYPE_DOUBLE = 'F' | 8 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.726 -0500", hash_original_field = "1C4F90E8C03B1ACCFB236ECE50E0DE6F", hash_generated_field = "235CD5ED9F27E795117F17DF7BCAFA50")

    static final int TYPE_STRING = 'L' | 's' << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.728 -0500", hash_original_field = "6CDCCAAAAEB511D0A149B87812320B8D", hash_generated_field = "1734EA463E0596C6DBE64154CCF362D1")

    static final int TYPE_ERROR = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.795 -0500", hash_original_field = "69E1525233766746346F0625CB0B1E7F", hash_generated_field = "83B21DDE04AFBBC067D3B1D2ABBE2EB9")

    public static final int STRING_TYPE_MISMATCH = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.797 -0500", hash_original_field = "F7AA283B5632FB201E46599FB52B541F", hash_generated_field = "00B47C8F77B363A29A3C021DA8F3516B")

    public static final int STRING_NOT_SET = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.800 -0500", hash_original_field = "923A5CBF0EB5ACE1E14BDD728F5A0991", hash_generated_field = "E18A84E3EBC448C32F75BCB5481CA863")

    public static final int STRING_NULL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.803 -0500", hash_original_field = "27B6FEE48A3230286165853D79303958", hash_generated_field = "72988529DEBF8FACA5F4299D7353C743")

    public static final int STRING_SET = 1;

    /**
     * Creates an empty TypedProperties instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.746 -0500", hash_original_method = "ECB16241B0AB765E13051ACDAE33A02C", hash_generated_method = "1F56D9702D0332A1D17344B96D52752A")
    
public TypedProperties() {
        super();
    }

    /**
     * Loads zero or more properties from the specified Reader.
     * Properties that have already been loaded are preserved unless
     * the new Reader overrides or unsets earlier values for the
     * same properties.
     * <p>
     * File syntax:
     * <blockquote>
     *     <tt>
     *     &lt;type&gt; &lt;property-name&gt; = &lt;value&gt; ;
     *     <br />
     *     unset ( &lt;property-name&gt; ) ;
     *     </tt>
     *     <p>
     *     "//" comments everything until the end of the line.
     *     "/&#2a;" comments everything until the next appearance of "&#2a;/".
     *     <p>
     *     Blank lines are ignored.
     *     <p>
     *     The only required whitespace is between the type and
     *     the property name.
     *     <p>
     *     &lt;type&gt; is one of {boolean, byte, short, int, long,
     *     float, double, String}, and is case-sensitive.
     *     <p>
     *     &lt;property-name&gt; is a valid fully-qualified class name
     *     (one or more valid identifiers separated by dot characters).
     *     <p>
     *     &lt;value&gt; depends on the type:
     *     <ul>
     *     <li> boolean: one of {true, false} (case-sensitive)
     *     <li> byte, short, int, long: a valid Java integer constant
     *          (including non-base-10 constants like 0xabc and 074)
     *          whose value does not overflow the type.  NOTE: these are
     *          interpreted as Java integer values, so they are all signed.
     *     <li> float, double: a valid Java floating-point constant.
     *          If the type is float, the value must fit in 32 bits.
     *     <li> String: a double-quoted string value, or the word {@code null}.
     *          NOTE: the contents of the string must be 7-bit clean ASCII;
     *          C-style octal escapes are recognized, but Unicode escapes are not.
     *     </ul>
     *     <p>
     *     Passing a property-name to {@code unset()} will unset the property,
     *     removing its value and type information, as if it had never been
     *     defined.
     * </blockquote>
     *
     * @param r The Reader to load properties from
     * @throws IOException if an error occurs when reading the data
     * @throws IllegalArgumentException if the data is malformed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.749 -0500", hash_original_method = "DEE9183B66993F47A34635E71D1E1A05", hash_generated_method = "A45756BA8CC020E8E8BAF2BED823763F")
    
public void load(Reader r) throws IOException {
        parse(r, this);
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.751 -0500", hash_original_method = "47BA0B831F55080B235C21EE87FA94B0", hash_generated_method = "7E6F6864129E3619C7A395D090949649")
    
@Override
    public Object get(Object key) {
        Object value = super.get(key);
        if (value == NULL_STRING) {
            return null;
        }
        return value;
    }

    /**
     * Returns the value of a boolean property, or the default if the property
     * has not been defined.
     *
     * @param property The name of the property to return
     * @param def The default value to return if the property is not set
     * @return the value of the property
     * @throws TypeException if the property is set and is not a boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.759 -0500", hash_original_method = "6663F38CAE0A0F250100A85B4A9042B2", hash_generated_method = "92C900CDEB61746DA43A78C4ECAE5A73")
    
public boolean getBoolean(String property, boolean def) {
        Object value = super.get(property);
        if (value == null) {
            return def;
        }
        if (value instanceof Boolean) {
            return ((Boolean)value).booleanValue();
        }
        throw new TypeException(property, value, "boolean");
    }

    /**
     * Returns the value of a byte property, or the default if the property
     * has not been defined.
     *
     * @param property The name of the property to return
     * @param def The default value to return if the property is not set
     * @return the value of the property
     * @throws TypeException if the property is set and is not a byte
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.761 -0500", hash_original_method = "C59AE35C77F78F452B75D7268F0F89E8", hash_generated_method = "F48D17D591B37A291A2FD3FEF954B6CC")
    
public byte getByte(String property, byte def) {
        Object value = super.get(property);
        if (value == null) {
            return def;
        }
        if (value instanceof Byte) {
            return ((Byte)value).byteValue();
        }
        throw new TypeException(property, value, "byte");
    }
    
    public static class ParseException extends IllegalArgumentException {
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.700 -0500", hash_original_method = "443E7125F6059ABCC086317CFCE0D16A", hash_generated_method = "443E7125F6059ABCC086317CFCE0D16A")
        
ParseException(StreamTokenizer state, String expected) {
            super("expected " + expected + ", saw " + state.toString());
        }
        
    }
    
    public static class TypeException extends IllegalArgumentException {
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.754 -0500", hash_original_method = "869ADEB9A2A381133512C58E64F92EC9", hash_generated_method = "869ADEB9A2A381133512C58E64F92EC9")
        
TypeException(String property, Object value, String requestedType) {
            super(property + " has type " + value.getClass().getName() +
                ", not " + requestedType);
        }
        
    }

    /**
     * Returns the value of a short property, or the default if the property
     * has not been defined.
     *
     * @param property The name of the property to return
     * @param def The default value to return if the property is not set
     * @return the value of the property
     * @throws TypeException if the property is set and is not a short
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.763 -0500", hash_original_method = "B3F410F783F41DCDA5B135E26EFE8189", hash_generated_method = "95ACE46283015B5C4161F8ED8B323BF8")
    
public short getShort(String property, short def) {
        Object value = super.get(property);
        if (value == null) {
            return def;
        }
        if (value instanceof Short) {
            return ((Short)value).shortValue();
        }
        throw new TypeException(property, value, "short");
    }

    /**
     * Returns the value of an integer property, or the default if the property
     * has not been defined.
     *
     * @param property The name of the property to return
     * @param def The default value to return if the property is not set
     * @return the value of the property
     * @throws TypeException if the property is set and is not an integer
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.766 -0500", hash_original_method = "81A20114A7AF0172426C6E77D3C9CCF3", hash_generated_method = "813800DAF504431A6C4DB016EE2CFEC7")
    
public int getInt(String property, int def) {
        Object value = super.get(property);
        if (value == null) {
            return def;
        }
        if (value instanceof Integer) {
            return ((Integer)value).intValue();
        }
        throw new TypeException(property, value, "int");
    }

    /**
     * Returns the value of a long property, or the default if the property
     * has not been defined.
     *
     * @param property The name of the property to return
     * @param def The default value to return if the property is not set
     * @return the value of the property
     * @throws TypeException if the property is set and is not a long
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.768 -0500", hash_original_method = "4BF2AEC507B97708CFEE1BE095F3CD54", hash_generated_method = "518122D4AC009D946AD402F1A71E5C56")
    
public long getLong(String property, long def) {
        Object value = super.get(property);
        if (value == null) {
            return def;
        }
        if (value instanceof Long) {
            return ((Long)value).longValue();
        }
        throw new TypeException(property, value, "long");
    }

    /**
     * Returns the value of a float property, or the default if the property
     * has not been defined.
     *
     * @param property The name of the property to return
     * @param def The default value to return if the property is not set
     * @return the value of the property
     * @throws TypeException if the property is set and is not a float
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.770 -0500", hash_original_method = "173DB4357D41B8C372C6266493A88C42", hash_generated_method = "3D53D42D01882F252FD2A09ED435CC5F")
    
public float getFloat(String property, float def) {
        Object value = super.get(property);
        if (value == null) {
            return def;
        }
        if (value instanceof Float) {
            return ((Float)value).floatValue();
        }
        throw new TypeException(property, value, "float");
    }

    /**
     * Returns the value of a double property, or the default if the property
     * has not been defined.
     *
     * @param property The name of the property to return
     * @param def The default value to return if the property is not set
     * @return the value of the property
     * @throws TypeException if the property is set and is not a double
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.773 -0500", hash_original_method = "319F68DA9A588357DEFC3D0ED78EA71B", hash_generated_method = "6DE1AD5DC9BC4336ED2D4F96E52D8609")
    
public double getDouble(String property, double def) {
        Object value = super.get(property);
        if (value == null) {
            return def;
        }
        if (value instanceof Double) {
            return ((Double)value).doubleValue();
        }
        throw new TypeException(property, value, "double");
    }

    /**
     * Returns the value of a string property, or the default if the property
     * has not been defined.
     *
     * @param property The name of the property to return
     * @param def The default value to return if the property is not set
     * @return the value of the property
     * @throws TypeException if the property is set and is not a string
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.775 -0500", hash_original_method = "3AAFD700C2ABAD81E6BE42DE7BFF48B2", hash_generated_method = "442710D781AD5436D2122443A85B1927")
    
public String getString(String property, String def) {
        Object value = super.get(property);
        if (value == null) {
            return def;
        }
        if (value == NULL_STRING) {
            return null;
        } else if (value instanceof String) {
            return (String)value;
        }
        throw new TypeException(property, value, "string");
    }

    /*
     * Getters with implicit defaults
     */

    /**
     * Returns the value of a boolean property, or false
     * if the property has not been defined.
     *
     * @param property The name of the property to return
     * @return the value of the property
     * @throws TypeException if the property is set and is not a boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.777 -0500", hash_original_method = "AE35D37F95D56A154F209F071D3D7624", hash_generated_method = "FA0E0FA128D6148E83DCD2393343C5DF")
    
public boolean getBoolean(String property) {
        return getBoolean(property, false);
    }

    /**
     * Returns the value of a byte property, or 0
     * if the property has not been defined.
     *
     * @param property The name of the property to return
     * @return the value of the property
     * @throws TypeException if the property is set and is not a byte
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.779 -0500", hash_original_method = "370EA3A899989D3F86644B48EA45FC9B", hash_generated_method = "4D787A05FE11834CB82EF826866951E9")
    
public byte getByte(String property) {
        return getByte(property, (byte)0);
    }

    /**
     * Returns the value of a short property, or 0
     * if the property has not been defined.
     *
     * @param property The name of the property to return
     * @return the value of the property
     * @throws TypeException if the property is set and is not a short
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.781 -0500", hash_original_method = "FA3A5E6826A1DDB74D3D7C867E30B692", hash_generated_method = "A397C983820E16571B0B1864A6FD9268")
    
public short getShort(String property) {
        return getShort(property, (short)0);
    }

    /**
     * Returns the value of an integer property, or 0
     * if the property has not been defined.
     *
     * @param property The name of the property to return
     * @return the value of the property
     * @throws TypeException if the property is set and is not an integer
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.783 -0500", hash_original_method = "01591AA36D981ABFF3C80720671DB519", hash_generated_method = "67BBA209E780D4E3F5E394ABCC864F34")
    
public int getInt(String property) {
        return getInt(property, 0);
    }

    /**
     * Returns the value of a long property, or 0
     * if the property has not been defined.
     *
     * @param property The name of the property to return
     * @return the value of the property
     * @throws TypeException if the property is set and is not a long
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.786 -0500", hash_original_method = "6768A5BD1563E9807D6B08281CAC66B5", hash_generated_method = "77CABAE825635C5706319A38C4ADEBF1")
    
public long getLong(String property) {
        return getLong(property, 0L);
    }

    /**
     * Returns the value of a float property, or 0.0
     * if the property has not been defined.
     *
     * @param property The name of the property to return
     * @return the value of the property
     * @throws TypeException if the property is set and is not a float
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.788 -0500", hash_original_method = "EF3DC0C356750228212346284358116F", hash_generated_method = "82049ADB2D02932124B3F707B8345E3A")
    
public float getFloat(String property) {
        return getFloat(property, 0.0f);
    }

    /**
     * Returns the value of a double property, or 0.0
     * if the property has not been defined.
     *
     * @param property The name of the property to return
     * @return the value of the property
     * @throws TypeException if the property is set and is not a double
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.790 -0500", hash_original_method = "C54C18DE732B31DF63D9F3187CBED443", hash_generated_method = "B742E02AE5919C5763B4E71CF79FAFFC")
    
public double getDouble(String property) {
        return getDouble(property, 0.0);
    }

    /**
     * Returns the value of a String property, or ""
     * if the property has not been defined.
     *
     * @param property The name of the property to return
     * @return the value of the property
     * @throws TypeException if the property is set and is not a string
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.792 -0500", hash_original_method = "1EC3769C452BFA246F7089382554F763", hash_generated_method = "6DADE53C8C1BC629F7568A082D24587F")
    
public String getString(String property) {
        return getString(property, "");
    }

    /**
     * Provides string type information about a property.
     *
     * @param property the property to check
     * @return STRING_SET if the property is a string and is non-null.
     *         STRING_NULL if the property is a string and is null.
     *         STRING_NOT_SET if the property is not set (no type or value).
     *         STRING_TYPE_MISMATCH if the property is set but is not a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.805 -0500", hash_original_method = "56B937E7FCE24CC3D04453B96CCA1E2A", hash_generated_method = "B5606C01AA154A9D1B45F35A230EB182")
    
public int getStringInfo(String property) {
        Object value = super.get(property);
        if (value == null) {
            return STRING_NOT_SET;
        }
        if (value == NULL_STRING) {
            return STRING_NULL;
        } else if (value instanceof String) {
            return STRING_SET;
        }
        return STRING_TYPE_MISMATCH;
    }
}

