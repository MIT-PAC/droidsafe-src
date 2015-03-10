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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.codec.language;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/**
 * Encodes a string into a Soundex value. Soundex is an encoding used to relate similar names, but can also be used as a
 * general purpose scheme to find word with similar phonemes.
 * 
 * @author Apache Software Foundation
 * @version $Id: Soundex.java,v 1.26 2004/07/07 23:15:24 ggregory Exp $
 */
public class Soundex implements StringEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.709 -0400", hash_original_field = "FC20F0ECA43EBA6ACDE7F3E13D6020A1", hash_generated_field = "05B900C9745525F6617CC73289FC7400")

    public static final Soundex US_ENGLISH = new Soundex();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.710 -0400", hash_original_field = "C04599B333342A3F1DE05C036D899E15", hash_generated_field = "B45BD6F8C665719E8B77556C9EF71DC5")

    public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.710 -0400", hash_original_field = "87A72EEDB4B3C85B22B4713BFC06AEFE", hash_generated_field = "C96A37903EC3C0728A34B3619EA47D34")

    public static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.711 -0400", hash_original_field = "7E8CAEE236AFAA0DC3F6549E15934D2F", hash_generated_field = "1EC123551D6B4A6AE586CC03BFDB8F3C")

    private int maxLength = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.712 -0400", hash_original_field = "C63E3171C856E32B3330950C7023C16B", hash_generated_field = "F6605E002F88E1EDC17F73DFEB7BF8A9")

    private char[] soundexMapping;

    /**
     * Creates an instance using US_ENGLISH_MAPPING
     * 
     * @see Soundex#Soundex(char[])
     * @see Soundex#US_ENGLISH_MAPPING
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.712 -0400", hash_original_method = "339A1A14B62A6BDA365D4D355DB33354", hash_generated_method = "A6112A3F201B8D9F6CC84BFD334BDEC4")
    
public Soundex() {
        this(US_ENGLISH_MAPPING);
    }

    /**
     * Creates a soundex instance using the given mapping. This constructor can be used to provide an internationalized
     * mapping for a non-Western character set.
     * 
     * Every letter of the alphabet is "mapped" to a numerical value. This char array holds the values to which each
     * letter is mapped. This implementation contains a default map for US_ENGLISH
     * 
     * @param mapping
     *                  Mapping array to use when finding the corresponding code for a given character
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.713 -0400", hash_original_method = "925A0FD8405BF4A6C375E92DF3616379", hash_generated_method = "8F9B5A00CA14CC0112AEF2770D1B518B")
    
public Soundex(char[] mapping) {
        this.setSoundexMapping(mapping);
    }

    // BEGIN android-note
    // Removed @see reference to SoundexUtils below, since the class isn't
    // public.
    // END android-note
    /**
     * Encodes the Strings and returns the number of characters in the two encoded Strings that are the same. This
     * return value ranges from 0 through 4: 0 indicates little or no similarity, and 4 indicates strong similarity or
     * identical values.
     * 
     * @param s1
     *                  A String that will be encoded and compared.
     * @param s2
     *                  A String that will be encoded and compared.
     * @return The number of characters in the two encoded Strings that are the same from 0 to 4.
     * 
     * @see <a href="http://msdn.microsoft.com/library/default.asp?url=/library/en-us/tsqlref/ts_de-dz_8co5.asp"> MS
     *          T-SQL DIFFERENCE </a>
     * 
     * @throws EncoderException
     *                  if an error occurs encoding one of the strings
     * @since 1.3
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.711 -0400", hash_original_method = "9372A1D570FF0E071E2A73F0471280C8", hash_generated_method = "73E7D5E07B73B540EF5D01C579CF6548")
    
public int difference(String s1, String s2) throws EncoderException {
        return SoundexUtils.difference(this, s1, s2);
    }

    /**
     * Encodes an Object using the soundex algorithm. This method is provided in order to satisfy the requirements of
     * the Encoder interface, and will throw an EncoderException if the supplied object is not of type java.lang.String.
     * 
     * @param pObject
     *                  Object to encode
     * @return An object (or type java.lang.String) containing the soundex code which corresponds to the String
     *             supplied.
     * @throws EncoderException
     *                  if the parameter supplied is not of type java.lang.String
     * @throws IllegalArgumentException
     *                  if a character is not mapped
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.713 -0400", hash_original_method = "691724DA7D74AB135EC7980DA6457A7C", hash_generated_method = "6F986E63DDE82F22972C21B483527243")
    
public Object encode(Object pObject) throws EncoderException {
        if (!(pObject instanceof String)) {
            throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
        }
        return soundex((String) pObject);
    }

    /**
     * Encodes a String using the soundex algorithm.
     * 
     * @param pString
     *                  A String object to encode
     * @return A Soundex code corresponding to the String supplied
     * @throws IllegalArgumentException
     *                  if a character is not mapped
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.714 -0400", hash_original_method = "1E598B71C72945526CFEDACCA9070A7B", hash_generated_method = "322F56CD5683A844E3322F033D9B5163")
    
public String encode(String pString) {
        return soundex(pString);
    }

    /**
     * Used internally by the SoundEx algorithm.
     * 
     * Consonants from the same code group separated by W or H are treated as one.
     * 
     * @param str
     *                  the cleaned working string to encode (in upper case).
     * @param index
     *                  the character position to encode
     * @return Mapping code for a particular character
     * @throws IllegalArgumentException
     *                  if the character is not mapped
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.715 -0400", hash_original_method = "1C423B9C9DE6ED5FDE5F6B7D1B55E6FD", hash_generated_method = "D9F53CC32F31D830119B254962924879")
    
private char getMappingCode(String str, int index) {
        char mappedChar = this.map(str.charAt(index));
        // HW rule check
        if (index > 1 && mappedChar != '0') {
            char hwChar = str.charAt(index - 1);
            if ('H' == hwChar || 'W' == hwChar) {
                char preHWChar = str.charAt(index - 2);
                char firstCode = this.map(preHWChar);
                if (firstCode == mappedChar || 'H' == preHWChar || 'W' == preHWChar) {
                    return 0;
                }
            }
        }
        return mappedChar;
    }

    /**
     * Returns the maxLength. Standard Soundex
     * 
     * @deprecated This feature is not needed since the encoding size must be constant. Will be removed in 2.0.
     * @return int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.715 -0400", hash_original_method = "8718428BF97E73CB2C2C03C08FB808C0", hash_generated_method = "356B9380B5AE12152D941925EA3ABBD9")
    
public int getMaxLength() {
        return this.maxLength;
    }

    /**
     * Returns the soundex mapping.
     * 
     * @return soundexMapping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.716 -0400", hash_original_method = "8CEBA29B269DDFC9413AE0F5113B6D1B", hash_generated_method = "F448A21756FD68831F9A46CDD7C56E02")
    
private char[] getSoundexMapping() {
        return this.soundexMapping;
    }

    /**
     * Maps the given upper-case character to it's Soudex code.
     * 
     * @param ch
     *                  An upper-case character.
     * @return A Soundex code.
     * @throws IllegalArgumentException
     *                  Thrown if <code>ch</code> is not mapped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.716 -0400", hash_original_method = "F488C8683BAD79FEBB225BED0B2508A5", hash_generated_method = "A3F7457ABB3A44E256A7D31F35B4F200")
    
private char map(char ch) {
        int index = ch - 'A';
        if (index < 0 || index >= this.getSoundexMapping().length) {
            throw new IllegalArgumentException("The character is not mapped: " + ch);
        }
        return this.getSoundexMapping()[index];
    }

    /**
     * Sets the maxLength.
     * 
     * @deprecated This feature is not needed since the encoding size must be constant. Will be removed in 2.0.
     * @param maxLength
     *                  The maxLength to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.717 -0400", hash_original_method = "13BFD5D911D3449D85B9FE67E96BBEEF", hash_generated_method = "189640A94C80B26E23E66A20812B0345")
    
public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * Sets the soundexMapping.
     * 
     * @param soundexMapping
     *                  The soundexMapping to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.717 -0400", hash_original_method = "A8F646DEF3E36306A8520055510EC523", hash_generated_method = "27E190F80A150288D0151B91494C859D")
    
private void setSoundexMapping(char[] soundexMapping) {
        this.soundexMapping = soundexMapping;
    }

    /**
     * Retreives the Soundex code for a given String object.
     * 
     * @param str
     *                  String to encode using the Soundex algorithm
     * @return A soundex code for the String supplied
     * @throws IllegalArgumentException
     *                  if a character is not mapped
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.718 -0400", hash_original_method = "0EBBB65C00DFAFB7B6E0400F5755712C", hash_generated_method = "94B188BA634D9793A5790601BA8B7F45")
    
public String soundex(String str) {
        if (str == null) {
            return null;
        }
        str = SoundexUtils.clean(str);
        if (str.length() == 0) {
            return str;
        }
        char out[] = {'0', '0', '0', '0'};
        char last, mapped;
        int incount = 1, count = 1;
        out[0] = str.charAt(0);
        last = getMappingCode(str, 0);
        while ((incount < str.length()) && (count < out.length)) {
            mapped = getMappingCode(str, incount++);
            if (mapped != 0) {
                if ((mapped != '0') && (mapped != last)) {
                    out[count++] = mapped;
                }
                last = mapped;
            }
        }
        return new String(out);
    }

}
