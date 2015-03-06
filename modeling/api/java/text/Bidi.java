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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.awt.font.NumericShaper;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implements the <a href="http://unicode.org/reports/tr9/">Unicode Bidirectional Algorithm</a>.
 *
 * <p>Use a {@code Bidi} object to get the information on the position reordering of a
 * bidirectional text, such as Arabic or Hebrew. The natural display ordering of
 * horizontal text in these languages is from right to left, while they order
 * numbers from left to right.
 *
 * <p>If the text contains multiple runs, the information of each run can be
 * obtained from the run index. The level of any particular run indicates the
 * direction of the text as well as the nesting level. Left-to-right runs have
 * even levels while right-to-left runs have odd levels.
 */
public final class Bidi {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.160 -0400", hash_original_field = "8F89864C23D54D3425E22FDA79AB53FB", hash_generated_field = "41A0C3EA4C1AF030A832A205BD9F7D38")

    public static final int DIRECTION_DEFAULT_LEFT_TO_RIGHT = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.161 -0400", hash_original_field = "96A35885B3577E870988ED3857F9DFF4", hash_generated_field = "29120457683CEEC052F8ED670E15C729")

    public static final int DIRECTION_DEFAULT_RIGHT_TO_LEFT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.162 -0400", hash_original_field = "4787F137E34A659DD8BCD15699F12FC9", hash_generated_field = "7A6AE430551179C3D7EF0661CF06C65E")

    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.164 -0400", hash_original_field = "083BCED6A13D22C807A886792C6EFBBE", hash_generated_field = "785726810980C04590955641F7CEFA03")

    public static final int DIRECTION_RIGHT_TO_LEFT = 1;

    /**
     * TODO: if we care about performance, we might just want to use an int[] instead of a Run[].
     */
    static class Run {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.167 -0400", hash_original_field = "A420862623A673AB42FCEC90A616158F", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

        private  int start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.169 -0400", hash_original_field = "136FDC88CA742E83C109AD31983DA2BF", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

        private  int limit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.172 -0400", hash_original_field = "6C23DC7E65CEAB9FBA953CF49B6B6875", hash_generated_field = "57A7D6A8967F8756CE39676B1CDDECE5")

        private  int level;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.175 -0400", hash_original_method = "19D650FFE508FC89393AABAA925DD9DD", hash_generated_method = "8D4BD04F89CA07575DDE858E8006D17B")
        
public Run(int start, int limit, int level) {
            this.start = start;
            this.limit = limit;
            this.level = level;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.177 -0400", hash_original_method = "63C151A9E9D1A27793AC54A30AA83904", hash_generated_method = "EECC757E73371F003E4128027C26DB71")
        
public int getLevel() {
            return level;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.178 -0400", hash_original_method = "E9BCDE537A27AAEF2054C14106CB86CE", hash_generated_method = "F72A53169BC803706BE3883A13017D3C")
        
public int getLimit() {
            return limit;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.179 -0400", hash_original_method = "5A8C39D0071C09866907F3602E3370F8", hash_generated_method = "7D6A128E84F956C046126FE17B8085F2")
        
public int getStart() {
            return start;
        }
    }

    // create the native UBiDi struct, need to be closed with ubidi_close().
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.189 -0400", hash_original_method = "60CA400D6EBE8CDE0A5293BA71967EDB", hash_generated_method = "1C1D6F79C702AD69EBFAEC1AFCE5A969")
    
private static long createUBiDi(char[] text, int textStart,
            byte[] embeddings, int embStart, int paragraphLength, int flags) {
        char[] realText = null;

        byte[] realEmbeddings = null;

        if (text == null || text.length - textStart < paragraphLength) {
            throw new IllegalArgumentException();
        }
        realText = new char[paragraphLength];
        System.arraycopy(text, textStart, realText, 0, paragraphLength);

        if (embeddings != null) {
            if (embeddings.length - embStart < paragraphLength) {
                throw new IllegalArgumentException();
            }
            if (paragraphLength > 0) {
                Bidi temp = new Bidi(text, textStart, null, 0, paragraphLength, flags);
                realEmbeddings = new byte[paragraphLength];
                System.arraycopy(temp.offsetLevel, 0, realEmbeddings, 0, paragraphLength);
                for (int i = 0; i < paragraphLength; i++) {
                    byte e = embeddings[i];
                    if (e < 0) {
                        realEmbeddings[i] = (byte) (UBIDI_LEVEL_OVERRIDE - e);
                    } else if (e > 0) {
                        realEmbeddings[i] = e;
                    } else {
                        realEmbeddings[i] |= (byte) UBIDI_LEVEL_OVERRIDE;
                    }
                }
            }
        }

        if (flags > 1 || flags < -2) {
            flags = 0;
        }

        long bidi = 0;
        boolean needsDeletion = true;
        try {
            bidi = ubidi_open();
            ubidi_setPara(bidi, realText, paragraphLength, flags, realEmbeddings);
            needsDeletion = false;
        } finally {
            if (needsDeletion) {
                ubidi_close(bidi);
            }
        }
        return bidi;
    }

    /**
     * Reorders a range of objects according to their specified levels. This is
     * a convenience function that does not use a {@code Bidi} object. The range
     * of objects at {@code index} from {@code objectStart} to {@code
     * objectStart + count} will be reordered according to the range of levels
     * at {@code index} from {@code levelStart} to {@code levelStart + count}.
     *
     * @param levels
     *            the level array, which is already determined.
     * @param levelStart
     *            the start offset of the range of the levels.
     * @param objects
     *            the object array to reorder.
     * @param objectStart
     *            the start offset of the range of objects.
     * @param count
     *            the count of the range of objects to reorder.
     * @throws IllegalArgumentException
     *             if {@code count}, {@code levelStart} or {@code objectStart}
     *             is negative; if {@code count > levels.length - levelStart} or
     *             if {@code count > objects.length - objectStart}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.219 -0400", hash_original_method = "7DC63803759191FC0B079437BBD17762", hash_generated_method = "6E323B7417D212672B3EAA45A7F2D44B")
    
public static void reorderVisually(byte[] levels, int levelStart,
            Object[] objects, int objectStart, int count) {
        if (count < 0 || levelStart < 0 || objectStart < 0
                || count > levels.length - levelStart
                || count > objects.length - objectStart) {
            throw new IllegalArgumentException("Invalid ranges (levels=" + levels.length +
                    ", levelStart=" + levelStart + ", objects=" + objects.length +
                    ", objectStart=" + objectStart + ", count=" + count + ")");
        }

        byte[] realLevels = new byte[count];
        System.arraycopy(levels, levelStart, realLevels, 0, count);

        int[] indices = ubidi_reorderVisual(realLevels, count);

        ArrayList<Object> result = new ArrayList<Object>(count);
        for (int i = 0; i < count; i++) {
            result.add(objects[objectStart + indices[i]]);
        }

        System.arraycopy(result.toArray(), 0, objects, objectStart, count);
    }

    /**
     * Indicates whether a range of characters of a text requires a {@code Bidi}
     * object to display properly.
     *
     * @param text
     *            the char array of the text.
     * @param start
     *            the start offset of the range of characters.
     * @param limit
     *            the limit offset of the range of characters.
     * @return {@code true} if the range of characters requires a {@code Bidi}
     *         object; {@code false} otherwise.
     * @throws IllegalArgumentException
     *             if {@code start} or {@code limit} is negative; {@code start >
     *             limit} or {@code limit} is greater than the length of this
     *             object's paragraph text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.221 -0400", hash_original_method = "A5C4811514D362789B4F76D330C8450C", hash_generated_method = "4560EB4D7895DCE73A1DBC14FED7EF2E")
    
public static boolean requiresBidi(char[] text, int start, int limit) {
        if (limit < 0 || start < 0 || start > limit || limit > text.length) {
            throw new IllegalArgumentException();
        }

        Bidi bidi = new Bidi(text, start, null, 0, limit - start, 0);
        return !bidi.isLeftToRight();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.224 -0400", hash_original_field = "B138D884FE30604ED8DD1188A5264AA0", hash_generated_field = "05294FC43F8C5462FABC996D7030F632")

    private static final int UBIDI_LEVEL_OVERRIDE = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.225 -0400", hash_original_field = "7C832353F867FAA30523CBEFBD111157", hash_generated_field = "0B24F5676BC3BC517AFD7B6622EBBA59")

    private static final int UBiDiDirection_UBIDI_LTR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.227 -0400", hash_original_field = "36702D8ADDD9AACF78326C26966EAB8D", hash_generated_field = "1EA447382B6FE74B1A469F842EFA5FDE")

    private static final int UBiDiDirection_UBIDI_RTL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.230 -0400", hash_original_field = "843ADDC38E31AB5C3ABB20DA0B116A4D", hash_generated_field = "D1C54EF9C96D928BFBC2C23B4AEDDD8D")

    private static final int UBiDiDirection_UBIDI_MIXED = 2;

    // ICU4C functions.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.233 -0400", hash_original_method = "5EA46B013A910D17DACD4CAB9CCFCC18", hash_generated_method = "C65E3154C0CC65EEF27476D2B6C1DD92")
    
    private static long ubidi_open(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (long)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.235 -0400", hash_original_method = "35C1A714E86C400DFD7DFA36F8B839DF", hash_generated_method = "A8A05A75645E71A35A7CCF273079469D")
    
    private static void ubidi_close(long pBiDi){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.237 -0400", hash_original_method = "5FF621F0DBED1B7BC7309EF0BC9ADD1A", hash_generated_method = "10A42B139D2B313F934B5E71EC2BF82C")
    
    private static void ubidi_setPara(long pBiDi, char[] text, int length, int paraLevel, byte[] embeddingLevels){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.239 -0400", hash_original_method = "F49E91BD230CE6C2495AC85A4D45E287", hash_generated_method = "DF27E7FB797171D767E22A529BE49B50")
    
    private static long ubidi_setLine(final long pParaBiDi, int start, int limit){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pParaBiDi;
    	taintDouble += start;
    	taintDouble += limit;
    
    	return (long)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.241 -0400", hash_original_method = "D99B63F198AFE4C18587770BB0BA4732", hash_generated_method = "12213E664DB3BB886713523897A8C9B3")
    
    private static int ubidi_getDirection(final long pBiDi){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pBiDi;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.244 -0400", hash_original_method = "987666A6A5A8FAC9A40D5C69DE06BF5D", hash_generated_method = "5DA6592A8FC646ADA99B0ECE090040BF")
    
    private static int ubidi_getLength(final long pBiDi){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pBiDi;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.246 -0400", hash_original_method = "BB4CDB59E62D3BB182668B367F43C524", hash_generated_method = "406C3F792A0089B5FD5E8367957EDE38")
    
    private static byte ubidi_getParaLevel(final long pBiDi){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pBiDi;
    
    	return (byte)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.248 -0400", hash_original_method = "6E0F6996F9DB3EE074FC2C3B840FDE5C", hash_generated_method = "B538B81ED4CAE46140EF7CC8B0F602D3")
    
    private static byte[] ubidi_getLevels(long pBiDi){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pBiDi;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.250 -0400", hash_original_method = "AFA94C3C973F6EA0874263F6B91F8450", hash_generated_method = "7BC17B91458BB00F53A7CD505393D893")
    
    private static int ubidi_countRuns(long pBiDi){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pBiDi;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.252 -0400", hash_original_method = "F8BFFCCDF7FB11AF5CFAC18CFB666B8F", hash_generated_method = "32E37A84527CDF138580B5076DE2F6D1")
    
    private static Bidi.Run[] ubidi_getRuns(long pBidi){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pBidi;
    
    	Bidi.Run[] retObj = new Bidi.Run[1]; 
    	retObj[0] = new Bidi.Run(DSUtils.FAKE_INT, DSUtils.FAKE_INT, DSUtils.FAKE_INT); 
    	retObj[0].addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.254 -0400", hash_original_method = "419CFAAA6C07388E31F8B83135096326", hash_generated_method = "D9477F0A51296F6D1E8D671D7A0B17C9")
    
    private static int[] ubidi_reorderVisual(byte[] levels, int length){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += levels[0];
    	taintDouble += length;
    
    	int[] retObj = new int[1]; 
    	retObj[0] = (int)taintDouble;
    	return retObj;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.193 -0400", hash_original_field = "2FF690F21BCD38E3483C44DE4CBE0B39", hash_generated_field = "DF288BFEDA889C538A422567CA9C9D64")

    private int baseLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.195 -0400", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private int length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.196 -0400", hash_original_field = "809B7C4661D036928E68D5E904F6DD92", hash_generated_field = "F7CA1961F13BFDE1DE4164E4ACEC9759")

    private byte[] offsetLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.197 -0400", hash_original_field = "F31D7FBE1A5A441B095A23FF3CB1CC7D", hash_generated_field = "0847083DA9E7E7F6141100FBBE80B452")

    private Run[] runs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.198 -0400", hash_original_field = "ADC17F105EA1AD923B501924B108B3D8", hash_generated_field = "A4A7AF3FC9749BFCB6C841A3FD768E56")

    private int direction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.200 -0400", hash_original_field = "7DB823303E9ACDA0941A177CFC66150C", hash_generated_field = "AE935D0D650E3AFBE13476DAA9ED6D62")

    private boolean unidirectional;

    /**
     * Creates a {@code Bidi} object from the {@code
     * AttributedCharacterIterator} of a paragraph text. The RUN_DIRECTION
     * attribute determines the base direction of the bidirectional text. If it
     * is not specified explicitly, the algorithm uses
     * DIRECTION_DEFAULT_LEFT_TO_RIGHT by default. The BIDI_EMBEDDING attribute
     * specifies the level of embedding for each character. Values between -1
     * and -62 denote overrides at the level's absolute value, values from 1 to
     * 62 indicate embeddings, and the 0 value indicates the level is calculated
     * by the algorithm automatically. For the character with no BIDI_EMBEDDING
     * attribute or with a improper attribute value, such as a {@code null}
     * value, the algorithm treats its embedding level as 0. The NUMERIC_SHAPING
     * attribute specifies the instance of NumericShaper used to convert
     * European digits to other decimal digits before performing the bidi
     * algorithm.
     *
     * @param paragraph
     *            the String containing the paragraph text to perform the
     *            algorithm.
     * @throws IllegalArgumentException if {@code paragraph == null}
     * @see java.awt.font.TextAttribute#BIDI_EMBEDDING
     * @see java.awt.font.TextAttribute#NUMERIC_SHAPING
     * @see java.awt.font.TextAttribute#RUN_DIRECTION
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.183 -0400", hash_original_method = "8307F0E9ADD844AA8C6ADFC89CAA385A", hash_generated_method = "B24EEE429B519D10A0C4163C3E3C4118")
    
public Bidi(AttributedCharacterIterator paragraph) {
        if (paragraph == null) {
            throw new IllegalArgumentException("paragraph is null");
        }

        int begin = paragraph.getBeginIndex();
        int end = paragraph.getEndIndex();
        int length = end - begin;
        char[] text = new char[length + 1]; // One more char for AttributedCharacterIterator.DONE

        if (length != 0) {
            text[0] = paragraph.first();
        } else {
            paragraph.first();
        }

        // First check the RUN_DIRECTION attribute.
        int flags = DIRECTION_DEFAULT_LEFT_TO_RIGHT;
        Object direction = paragraph.getAttribute(TextAttribute.RUN_DIRECTION);
        if (direction != null && direction instanceof Boolean) {
            if (direction.equals(TextAttribute.RUN_DIRECTION_LTR)) {
                flags = DIRECTION_LEFT_TO_RIGHT;
            } else {
                flags = DIRECTION_RIGHT_TO_LEFT;
            }
        }

        // Retrieve the text and gather BIDI_EMBEDDINGS
        byte[] embeddings = null;
        for (int textLimit = 1, i = 1; i < length; textLimit = paragraph
                .getRunLimit(TextAttribute.BIDI_EMBEDDING)
                - begin + 1) {
            Object embedding = paragraph.getAttribute(TextAttribute.BIDI_EMBEDDING);
            if (embedding != null && embedding instanceof Integer) {
                int embLevel = ((Integer) embedding).intValue();

                if (embeddings == null) {
                    embeddings = new byte[length];
                }

                for (; i < textLimit; i++) {
                    text[i] = paragraph.next();
                    embeddings[i - 1] = (byte) embLevel;
                }
            } else {
                for (; i < textLimit; i++) {
                    text[i] = paragraph.next();
                }
            }
        }

        // Apply NumericShaper to the text
        Object numericShaper = paragraph.getAttribute(TextAttribute.NUMERIC_SHAPING);
        if (numericShaper != null && numericShaper instanceof NumericShaper) {
            ((NumericShaper) numericShaper).shape(text, 0, length);
        }

        long bidi = 0;
        try {
            bidi = createUBiDi(text, 0, embeddings, 0, length, flags);
            readBidiInfo(bidi);
        } finally {
            ubidi_close(bidi);
        }
    }

    /**
     * Creates a {@code Bidi} object.
     *
     * @param text
     *            the char array of the paragraph text that is processed.
     * @param textStart
     *            the index in {@code text} of the start of the paragraph.
     * @param embeddings
     *            the embedding level array of the paragraph text, specifying
     *            the embedding level information for each character. Values
     *            between -1 and -61 denote overrides at the level's absolute
     *            value, values from 1 to 61 indicate embeddings, and the 0
     *            value indicates the level is calculated by the algorithm
     *            automatically.
     * @param embStart
     *            the index in {@code embeddings} of the start of the paragraph.
     * @param paragraphLength
     *            the length of the text to perform the algorithm.
     * @param flags
     *            indicates the base direction of the bidirectional text. It is
     *            expected that this will be one of the direction constant
     *            values defined in this class. An unknown value is treated as
     *            DIRECTION_DEFAULT_LEFT_TO_RIGHT.
     * @throws IllegalArgumentException
     *             if {@code textStart}, {@code embStart}, or {@code
     *             paragraphLength} is negative; if
     *             {@code text.length < textStart + paragraphLength} or
     *             {@code embeddings.length < embStart + paragraphLength}.
     * @see #DIRECTION_LEFT_TO_RIGHT
     * @see #DIRECTION_RIGHT_TO_LEFT
     * @see #DIRECTION_DEFAULT_RIGHT_TO_LEFT
     * @see #DIRECTION_DEFAULT_LEFT_TO_RIGHT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.185 -0400", hash_original_method = "6A7B1728254F1DA322900D21F8E46EE2", hash_generated_method = "15F880D2F6F11AF4AA965F7ADE7DE5B6")
    
public Bidi(char[] text, int textStart, byte[] embeddings, int embStart,
            int paragraphLength, int flags) {

        if (text == null || text.length - textStart < paragraphLength) {
            throw new IllegalArgumentException();
        }

        if (embeddings != null) {
            if (embeddings.length - embStart < paragraphLength) {
                throw new IllegalArgumentException();
            }
        }

        if (textStart < 0) {
            throw new IllegalArgumentException("Negative textStart value " + textStart);
        }
        if (embStart < 0) {
            throw new IllegalArgumentException("Negative embStart value " + embStart);
        }
        if (paragraphLength < 0) {
            throw new IllegalArgumentException("Negative paragraph length " + paragraphLength);
        }

        long bidi = 0;
        try {
            bidi = createUBiDi(text, textStart, embeddings, embStart, paragraphLength, flags);
            readBidiInfo(bidi);
        } finally {
            ubidi_close(bidi);
        }
    }

    /**
     * Creates a {@code Bidi} object.
     *
     * @param paragraph
     *            the string containing the paragraph text to perform the
     *            algorithm on.
     * @param flags
     *            indicates the base direction of the bidirectional text. It is
     *            expected that this will be one of the direction constant
     *            values defined in this class. An unknown value is treated as
     *            DIRECTION_DEFAULT_LEFT_TO_RIGHT.
     * @see #DIRECTION_LEFT_TO_RIGHT
     * @see #DIRECTION_RIGHT_TO_LEFT
     * @see #DIRECTION_DEFAULT_RIGHT_TO_LEFT
     * @see #DIRECTION_DEFAULT_LEFT_TO_RIGHT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.187 -0400", hash_original_method = "8A5BC648A44784A8BBAED23896FCE0B3", hash_generated_method = "F57AAE2D037FA18EE32CEB142D918F27")
    
public Bidi(String paragraph, int flags) {
        this((paragraph == null ? null : paragraph.toCharArray()), 0, null, 0,
                (paragraph == null ? 0 : paragraph.length()), flags);
    }

    /* private constructor used by createLineBidi() */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.191 -0400", hash_original_method = "1706054E1DB19F601C2F979483D4196E", hash_generated_method = "F005591F1A583C33A836EA9A6DB66C5E")
    
private Bidi(long pBidi) {
        readBidiInfo(pBidi);
    }

    // read info from the native UBiDi struct
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.192 -0400", hash_original_method = "D9AD2A98531D968F5CEA727640BA1397", hash_generated_method = "4611DA4E8629B49C43CA1F200E6D22CC")
    
private void readBidiInfo(long pBidi) {
        length = ubidi_getLength(pBidi);

        offsetLevel = (length == 0) ? null : ubidi_getLevels(pBidi);

        baseLevel = ubidi_getParaLevel(pBidi);

        int runCount = ubidi_countRuns(pBidi);
        if (runCount == 0) {
            unidirectional = true;
            runs = null;
        } else if (runCount < 0) {
            runs = null;
        } else {
            runs = ubidi_getRuns(pBidi);

            // Simplified case for one run which has the base level
            if (runCount == 1 && runs[0].getLevel() == baseLevel) {
                unidirectional = true;
                runs = null;
            }
        }

        direction = ubidi_getDirection(pBidi);
    }

    /**
     * Returns whether the base level is from left to right.
     *
     * @return true if the base level is from left to right.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.201 -0400", hash_original_method = "9C64BAD1BE875A71B9D1BFD72B090F3E", hash_generated_method = "04F8E5FE79E9B9E8BDEE99B50B05360E")
    
public boolean baseIsLeftToRight() {
        return baseLevel % 2 == 0 ? true : false;
    }

    /**
     * Creates a new {@code Bidi} object containing the information of one line
     * from this object.
     *
     * @param lineStart
     *            the start offset of the line.
     * @param lineLimit
     *            the limit of the line.
     * @return the new line Bidi object. In this new object, the indices will
     *         range from 0 to (limit - start - 1).
     * @throws IllegalArgumentException
     *             if {@code lineStart < 0}, {@code lineLimit < 0}, {@code
     *             lineStart > lineLimit} or if {@code lineStart} is greater
     *             than the length of this object's paragraph text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.203 -0400", hash_original_method = "B54AB57BB637A747AF95CE1C786AD2F3", hash_generated_method = "81B2322C389D66C8C244A4C2FCD63608")
    
public Bidi createLineBidi(int lineStart, int lineLimit) {
        if (lineStart < 0 || lineLimit < 0 || lineLimit > length || lineStart > lineLimit) {
            throw new IllegalArgumentException("Invalid ranges (start=" + lineStart + ", " +
                    "limit=" + lineLimit + ", length=" + length + ")");
        }

        char[] text = new char[this.length];
        Arrays.fill(text, 'a');
        byte[] embeddings = new byte[this.length];
        for (int i = 0; i < embeddings.length; i++) {
            embeddings[i] = (byte) -this.offsetLevel[i];
        }

        int dir = this.baseIsLeftToRight()
                ? Bidi.DIRECTION_LEFT_TO_RIGHT
                : Bidi.DIRECTION_RIGHT_TO_LEFT;
        long parent = 0;
        try {
            parent = createUBiDi(text, 0, embeddings, 0, this.length, dir);
            if (lineStart == lineLimit) {
                return createEmptyLineBidi(parent);
            }
            return new Bidi(ubidi_setLine(parent, lineStart, lineLimit));
        } finally {
            ubidi_close(parent);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.204 -0400", hash_original_method = "12CD041E3A304037870B13A1BC4A7707", hash_generated_method = "4B2B3263CDCD58B1C3AE61CC903F7F62")
    
private Bidi createEmptyLineBidi(long parent) {
        // ICU4C doesn't allow this case, but the RI does.
        Bidi result = new Bidi(parent);
        result.length = 0;
        result.offsetLevel = null;
        result.runs = null;
        result.unidirectional = true;
        return result;
    }

    /**
     * Returns the base level.
     *
     * @return the base level.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.205 -0400", hash_original_method = "55F70EC517D9ED09C94C278C23E9AB38", hash_generated_method = "B3EBA8B4553B46F5587CBFC8AC8B7054")
    
public int getBaseLevel() {
        return baseLevel;
    }

    /**
     * Returns the length of the text in the {@code Bidi} object.
     *
     * @return the length.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.206 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "AF903EC3B9FE28DC883DCDAF202C537E")
    
public int getLength() {
        return length;
    }

    /**
     * Returns the level of a specified character.
     *
     * @param offset
     *            the offset of the character.
     * @return the level.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.208 -0400", hash_original_method = "7F6DABD788765CCD6052460801CACF48", hash_generated_method = "7997AF7CD8A41DE8E7BA554CDE9E4A60")
    
public int getLevelAt(int offset) {
        try {
            return offsetLevel[offset] & ~UBIDI_LEVEL_OVERRIDE;
        } catch (RuntimeException e) {
            return baseLevel;
        }
    }

    /**
     * Returns the number of runs in the bidirectional text.
     *
     * @return the number of runs, at least 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.209 -0400", hash_original_method = "E0B28BEBFD61D3472D741DE5A86B428D", hash_generated_method = "23AB303B2C1913C171955A8381C719F0")
    
public int getRunCount() {
        return unidirectional ? 1 : runs.length;
    }

    /**
     * Returns the level of the specified run.
     *
     * @param run
     *            the index of the run.
     * @return the level of the run.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.211 -0400", hash_original_method = "CC875FECADF80C00FDA55989E2EAD2CD", hash_generated_method = "A6A8FF204BED89773EB27A898F43A38A")
    
public int getRunLevel(int run) {
        return unidirectional ? baseLevel : runs[run].getLevel();
    }

    /**
     * Returns the limit offset of the specified run.
     *
     * @param run
     *            the index of the run.
     * @return the limit offset of the run.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.212 -0400", hash_original_method = "6C39B73962A6961BF4A47678ED0F244F", hash_generated_method = "558D6D312EE96DB79065D98C717BD524")
    
public int getRunLimit(int run) {
        return unidirectional ? length : runs[run].getLimit();
    }

    /**
     * Returns the start offset of the specified run.
     *
     * @param run
     *            the index of the run.
     * @return the start offset of the run.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.213 -0400", hash_original_method = "582EC507F5BE629DDBFFDE3B8AF5F078", hash_generated_method = "D7787CD9CF09F33E19AFFEEF9B698140")
    
public int getRunStart(int run) {
        return unidirectional ? 0 : runs[run].getStart();
    }

    /**
     * Indicates whether the text is from left to right, that is, both the base
     * direction and the text direction is from left to right.
     *
     * @return {@code true} if the text is from left to right; {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.215 -0400", hash_original_method = "E7CEA79E484E23FE3B17B1606FADFE49", hash_generated_method = "BDB27921B6BF6868DA9405E0261F8CA9")
    
public boolean isLeftToRight() {
        return direction == UBiDiDirection_UBIDI_LTR;
    }

    /**
     * Indicates whether the text direction is mixed.
     *
     * @return {@code true} if the text direction is mixed; {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.216 -0400", hash_original_method = "432A9B2ACB5398DF220568E8BD2B2E52", hash_generated_method = "DB8BAD6F4A7B51A7E28791ECC9677AA8")
    
public boolean isMixed() {
        return direction == UBiDiDirection_UBIDI_MIXED;
    }

    /**
     * Indicates whether the text is from right to left, that is, both the base
     * direction and the text direction is from right to left.
     *
     * @return {@code true} if the text is from right to left; {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.217 -0400", hash_original_method = "35E182D2C7EEB0F8214080478407DB5E", hash_generated_method = "B3CA99D2C95F40EB28F19456D85CA93B")
    
public boolean isRightToLeft() {
        return direction == UBiDiDirection_UBIDI_RTL;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.222 -0400", hash_original_method = "063D967061B6BDAE28DFCBF4E0BAE7D2", hash_generated_method = "A54E05B3983DC17F5D1AA630148C1909")
    
@Override
    public String toString() {
        return getClass().getName()
                + "[direction: " + direction + " baseLevel: " + baseLevel
                + " length: " + length + " runs: " + Arrays.toString(runs) + "]";
    }
}
