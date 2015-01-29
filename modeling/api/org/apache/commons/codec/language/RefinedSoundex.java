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

package org.apache.commons.codec.language;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/**
 * Encodes a string into a Refined Soundex value. A refined soundex code is
 * optimized for spell checking words. Soundex method originally developed by
 * <CITE>Margaret Odell</CITE> and <CITE>Robert Russell</CITE>.
 * 
 * @author Apache Software Foundation
 * @version $Id: RefinedSoundex.java,v 1.21 2004/06/05 18:32:04 ggregory Exp $
 */
public class RefinedSoundex implements StringEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.433 -0400", hash_original_field = "1E9F2B1F4013C6E5433B1AD627EFDAE1", hash_generated_field = "97C821464EFAC58DAAEC6799122ECA31")

    public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.434 -0400", hash_original_field = "8150E808904D093095170724771A0602", hash_generated_field = "F6CA1F03C987C9B1DB222CA1BC4F3CFA")

    public static final char[] US_ENGLISH_MAPPING = "01360240043788015936020505".toCharArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.435 -0400", hash_original_field = "C63E3171C856E32B3330950C7023C16B", hash_generated_field = "F6605E002F88E1EDC17F73DFEB7BF8A9")

    private char[] soundexMapping;

    /**
     * Creates an instance of the RefinedSoundex object using the default US
     * English mapping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.435 -0400", hash_original_method = "23C617289A8DDF6F6B3FD3C27ABAC8B4", hash_generated_method = "563DF64068815DA3B76300343AB1AD9F")
    
public RefinedSoundex() {
        this(US_ENGLISH_MAPPING);
    }

    /**
     * Creates a refined soundex instance using a custom mapping. This
     * constructor can be used to customize the mapping, and/or possibly
     * provide an internationalized mapping for a non-Western character set.
     * 
     * @param mapping
     *                  Mapping array to use when finding the corresponding code for
     *                  a given character
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.436 -0400", hash_original_method = "A6C6DFED0D71F3855C0278D58ED571CA", hash_generated_method = "04A591E9028E45D84BF9E57C435E20BA")
    
public RefinedSoundex(char[] mapping) {
        this.soundexMapping = mapping;
    }

    // BEGIN android-note
    // Removed @see reference to SoundexUtils below, since the class isn't
    // public.
    // END android-note
    /**
     * Returns the number of characters in the two encoded Strings that are the
     * same. This return value ranges from 0 to the length of the shortest
     * encoded String: 0 indicates little or no similarity, and 4 out of 4 (for
     * example) indicates strong similarity or identical values. For refined
     * Soundex, the return value can be greater than 4.
     * 
     * @param s1
     *                  A String that will be encoded and compared.
     * @param s2
     *                  A String that will be encoded and compared.
     * @return The number of characters in the two encoded Strings that are the
     *             same from 0 to to the length of the shortest encoded String.
     * 
     * @see <a href="http://msdn.microsoft.com/library/default.asp?url=/library/en-us/tsqlref/ts_de-dz_8co5.asp">
     *          MS T-SQL DIFFERENCE</a>
     * 
     * @throws EncoderException
     *                  if an error occurs encoding one of the strings
     * @since 1.3
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.436 -0400", hash_original_method = "9372A1D570FF0E071E2A73F0471280C8", hash_generated_method = "73E7D5E07B73B540EF5D01C579CF6548")
    
public int difference(String s1, String s2) throws EncoderException {
        return SoundexUtils.difference(this, s1, s2);
    }

    /**
     * Encodes an Object using the refined soundex algorithm. This method is
     * provided in order to satisfy the requirements of the Encoder interface,
     * and will throw an EncoderException if the supplied object is not of type
     * java.lang.String.
     * 
     * @param pObject
     *                  Object to encode
     * @return An object (or type java.lang.String) containing the refined
     *             soundex code which corresponds to the String supplied.
     * @throws EncoderException
     *                  if the parameter supplied is not of type java.lang.String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.437 -0400", hash_original_method = "CF942B57FF7D4AAB7109E087E337232C", hash_generated_method = "A183D9D1A21AF22BDABE1ECE133DD5AB")
    
public Object encode(Object pObject) throws EncoderException {
        if (!(pObject instanceof java.lang.String)) {
            throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
        }
        return soundex((String) pObject);
    }

    /**
     * Encodes a String using the refined soundex algorithm.
     * 
     * @param pString
     *                  A String object to encode
     * @return A Soundex code corresponding to the String supplied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.437 -0400", hash_original_method = "1E598B71C72945526CFEDACCA9070A7B", hash_generated_method = "322F56CD5683A844E3322F033D9B5163")
    
public String encode(String pString) {
        return soundex(pString);
    }

    /**
     * Returns the mapping code for a given character. The mapping codes are
     * maintained in an internal char array named soundexMapping, and the
     * default values of these mappings are US English.
     * 
     * @param c
     *                  char to get mapping for
     * @return A character (really a numeral) to return for the given char
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.438 -0400", hash_original_method = "55FFD7B76B48863FB96D836E8AF1012D", hash_generated_method = "55FFD7B76B48863FB96D836E8AF1012D")
    
char getMappingCode(char c) {
        if (!Character.isLetter(c)) {
            return 0;
        }
        return this.soundexMapping[Character.toUpperCase(c) - 'A'];
    }

    /**
     * Retreives the Refined Soundex code for a given String object.
     * 
     * @param str
     *                  String to encode using the Refined Soundex algorithm
     * @return A soundex code for the String supplied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.439 -0400", hash_original_method = "AA7B08876B9A676C82049B1527C60A7E", hash_generated_method = "164655E4934D4D0FC15D1158974949D7")
    
public String soundex(String str) {
        if (str == null) {
            return null;
        }
        str = SoundexUtils.clean(str);
        if (str.length() == 0) {
            return str;
        }

        StringBuffer sBuf = new StringBuffer();
        sBuf.append(str.charAt(0));

        char last, current;
        last = '*';

        for (int i = 0; i < str.length(); i++) {

            current = getMappingCode(str.charAt(i));
            if (current == last) {
                continue;
            } else if (current != 0) {
                sBuf.append(current);
            }

            last = current;

        }

        return sBuf.toString();
    }
}
