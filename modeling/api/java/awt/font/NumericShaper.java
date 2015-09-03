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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/**
 * @author Ilya S. Okomin
 * @version $Revision$
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.awt.font;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * The Class NumericShaper provides methods to convert latin character codes
 * to unicode character codes.
 * For tables of the character codes used,
 * see <a href="http://www.unicode.org/Public/UNIDATA/">unicode.org</a>.
 */
public final class NumericShaper implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.006 -0400", hash_original_field = "BE4326059F662ECBCB4A2087942A1697", hash_generated_field = "217A544353F3280AEAE44FF5E618E7E2")

    private static final long serialVersionUID = -8022764705923730308L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.007 -0400", hash_original_field = "19EF9B19AEA8AC18541E69F9E5A634D4", hash_generated_field = "AC0B28A18360756C1BA46BC33AB16036")

    public static final int EUROPEAN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.009 -0400", hash_original_field = "4B9B80C791256F7BE43CB97032F14A0E", hash_generated_field = "9208C2D677BD29195A109D5D7130A96F")

    public static final int ARABIC = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.010 -0400", hash_original_field = "2F590B814D7C01170872895FC5C2258D", hash_generated_field = "C482663A69ABD0A65F92A50EF472387B")

    public static final int EASTERN_ARABIC = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.012 -0400", hash_original_field = "AEB28DC41D3C400CA39FBE013A81419C", hash_generated_field = "1CBC5CD98009AF752E2CD615AD16C8ED")

    public static final int DEVANAGARI = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.013 -0400", hash_original_field = "AD9BB4250619EE51260245B24D68D3A2", hash_generated_field = "2CA367069EFEDB5F6E9A649C7DCBBC76")

    public static final int BENGALI = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.015 -0400", hash_original_field = "7F364F1F91943E8635015168D3036E92", hash_generated_field = "B5F5311B0D4944800743A1B7FADCD355")

    public static final int GURMUKHI = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.016 -0400", hash_original_field = "A4C1F26E9ED27149991B1566B70BB55C", hash_generated_field = "93269D4C0CBD43D2F5249547F653BA61")

    public static final int GUJARATI = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.018 -0400", hash_original_field = "DC94B11318FC17A8286589952CB99499", hash_generated_field = "53714D5E87353CF054E28014469BEB5F")

    public static final int ORIYA = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.020 -0400", hash_original_field = "A42898EBBC6D65F327EC5314BA08062D", hash_generated_field = "CA6E3E3E98250ACCFFA2360BB8735554")

    public static final int TAMIL = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.021 -0400", hash_original_field = "706A05B2FC968D40CB469BA51B524767", hash_generated_field = "85EE1E12081889C67761C3A65AB51B1A")

    public static final int TELUGU = 512;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.022 -0400", hash_original_field = "D1A8B7AF2FA74DF64C07B6550A0E080C", hash_generated_field = "10C1E05ADE54C76E9AFC58C5766291EF")

    public static final int KANNADA = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.024 -0400", hash_original_field = "F3715050648DDF23955E798B0C42439C", hash_generated_field = "5EECA49286C5D4F397E97B4A5A3D9496")

    public static final int MALAYALAM = 2048;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.025 -0400", hash_original_field = "FC2A5A3081105047F3A14D600D5A62D8", hash_generated_field = "73D07CCDF6146CA8204F81B09F58F503")

    public static final int THAI = 4096;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.027 -0400", hash_original_field = "00895B7F67D7A60C19DAC031CABBA2F6", hash_generated_field = "B7DD701AAC2D918A5D41DE374F84410F")

    public static final int LAO = 8192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.029 -0400", hash_original_field = "2E5D3F2FE99FF4C9FBF297D326F7B1C0", hash_generated_field = "A1A08F4A09ABA2433031D6CE4231B627")

    public static final int TIBETAN = 16384;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.030 -0400", hash_original_field = "700C8A342A09491B41DBB1B06A5B2870", hash_generated_field = "4AA865BECDC16D5BFCD8432A8E634A60")

    public static final int MYANMAR = 32768;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.032 -0400", hash_original_field = "8A5FB990E32B988F18C1F707178CEFBF", hash_generated_field = "7AF13BFE2C869905658DF808CD9BA42B")

    public static final int ETHIOPIC = 65536;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.033 -0400", hash_original_field = "993B6D15D5C72F7E2B10873C73B2D1DC", hash_generated_field = "777C12D2D3A78C36E35B6AD76261F46B")

    public static final int KHMER = 131072;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.035 -0400", hash_original_field = "B23AE958C3855DC43F5DE1D64C097A4D", hash_generated_field = "32EFF4704A84B1571BEEA4FD7A955616")

    public static final int MONGOLIAN = 262144;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.036 -0400", hash_original_field = "9B78C63144363F84487E50AC3BA7BC16", hash_generated_field = "EC6BF6E42B34C8C836C43F3D5929F26E")

    public static final int ALL_RANGES = 524287;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.038 -0400", hash_original_field = "2B31D271B2C1F67B3CBADE6094F15EA0", hash_generated_field = "89AF884A6BD4796272D7522EC82895FF")

    // Index of the EUROPEAN range
    /** The Constant INDEX_EUROPEAN. */
    private static final int INDEX_EUROPEAN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.039 -0400", hash_original_field = "700BBA50F8B3FBCB85722EEEC50769C8", hash_generated_field = "BE11297E76EA9CFAE7A8FB02E461E9EA")

    /** The Constant INDEX_ARABIC. */
    private static final int INDEX_ARABIC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.041 -0400", hash_original_field = "C71E0741FA34567EDA636A0B426FD3AD", hash_generated_field = "E22D98123D8539CDB0182E24C6D3AFEC")

    /** The Constant INDEX_EASTERN_ARABIC. */
    private static final int INDEX_EASTERN_ARABIC = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.043 -0400", hash_original_field = "89654F8F927F2A52ED8B083EB3DBF44B", hash_generated_field = "D98E95100A03C06447AA8EE96E273A97")

    /** The Constant INDEX_DEVANAGARI. */
    private static final int INDEX_DEVANAGARI = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.044 -0400", hash_original_field = "723D8C7F7040A1515D8EEEDB6654091F", hash_generated_field = "5FBEBF185C7A3ABF8008AD725A7B8FC9")

    /** The Constant INDEX_BENGALI. */
    private static final int INDEX_BENGALI = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.046 -0400", hash_original_field = "6D584FE992BCB6A3885CCE0BA9BD6602", hash_generated_field = "9AA6876E7844D1D489E579EBFED522D7")

    /** The Constant INDEX_GURMUKHI. */
    private static final int INDEX_GURMUKHI = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.047 -0400", hash_original_field = "CD57C52C59245ECFC23CFD6A4A32EEF6", hash_generated_field = "3AE7EDCB2A58E159F9C4CBCF67257F99")

    /** The Constant INDEX_GUJARATI. */
    private static final int INDEX_GUJARATI = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.049 -0400", hash_original_field = "6E9F733E53CA6A6776316BF6487F7EFD", hash_generated_field = "5F203A6B555ADA95EA1BC57A0EA093E6")

    /** The Constant INDEX_ORIYA. */
    private static final int INDEX_ORIYA = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.050 -0400", hash_original_field = "DC68FA024709F46A8992CAE811A39E9A", hash_generated_field = "13F2D808324CCE82BC2A2D6AC21E1B08")

    /** The Constant INDEX_TAMIL. */
    private static final int INDEX_TAMIL = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.052 -0400", hash_original_field = "6A5362B0104AA7AFA684971BA00CE37A", hash_generated_field = "A5EF660CC90AC926155535D159184875")

    /** The Constant INDEX_TELUGU. */
    private static final int INDEX_TELUGU = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.053 -0400", hash_original_field = "7B7373F74DDB9CC3C999E1D5E64B5F8A", hash_generated_field = "1B0C4976D28022F1AD4AAA33077F40A6")

    /** The Constant INDEX_KANNADA. */
    private static final int INDEX_KANNADA = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.055 -0400", hash_original_field = "37866B941C972AF4D69F269C04D1F241", hash_generated_field = "A7B6EE4236368A1068EA894BBCD0EC90")

    /** The Constant INDEX_MALAYALAM. */
    private static final int INDEX_MALAYALAM = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.056 -0400", hash_original_field = "D4B67DF905895B20EF6DF835FAC31102", hash_generated_field = "D142E178AA1622F84D2245DD89DDD015")

    /** The Constant INDEX_THAI. */
    private static final int INDEX_THAI = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.058 -0400", hash_original_field = "04A313A142F0E668B3D5CD2D6237ECAB", hash_generated_field = "3CF438CF379688D39884A3463B7CC498")

    /** The Constant INDEX_LAO. */
    private static final int INDEX_LAO = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.059 -0400", hash_original_field = "42778852EB0BFD9EA4C9D22DB9620124", hash_generated_field = "489D43F37305D228F73AD80BDDBD0CC4")

    /** The Constant INDEX_TIBETAN. */
    private static final int INDEX_TIBETAN = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.061 -0400", hash_original_field = "3EEA263013C70A536F66C04D58272BC3", hash_generated_field = "F6BA0A1F4403C14F1755D89F59E91100")

    /** The Constant INDEX_MYANMAR. */
    private static final int INDEX_MYANMAR = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.062 -0400", hash_original_field = "D65724773CCA8762EA39ADB8DA527CFE", hash_generated_field = "B37D42E8B86D33510A91FF45A7FC6009")

    /** The Constant INDEX_ETHIOPIC. */
    private static final int INDEX_ETHIOPIC = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.064 -0400", hash_original_field = "B1B860A50BA244D69D686680063350AD", hash_generated_field = "533C84AB8F042A0BFD31FF17300737A1")

    /** The Constant INDEX_KHMER. */
    private static final int INDEX_KHMER = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.065 -0400", hash_original_field = "FD7D6574078A3DFDDA135D6AB4423828", hash_generated_field = "42C3B26EE529618B975171CD94C92D29")

    /** The Constant INDEX_MONGOLIAN. */
    private static final int INDEX_MONGOLIAN = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.068 -0400", hash_original_field = "504B146A32045A40B5F8419CDEC8575A", hash_generated_field = "C363A70EF42259A5FD0D47EB1BAAEA4C")

    /** The Constant MAX_INDEX. */
    private static final int MAX_INDEX = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.083 -0400", hash_original_field = "DF30F2984BA0A5919C91B9DEC6ADFE4E", hash_generated_field = "B67ED0B809EAFBDE56105C5162448D3C")

    /** The Constant STRONG_TEXT_FLAGS. */
    private static final int[] STRONG_TEXT_FLAGS = { 0, 0, 134217726, 134217726,
            0, 69207040, -8388609, -8388609, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -65533, -1, -1, -100663297, 196611, 16415, 0, 0, 0,
            67108864, -10432, -5, -32769, -4194305, -1, -1, -1, -1, -1017, -1,
            -32769, 67108863, 65535, -131072, -25165825, -2, 767, 1073741824,
            -65463, 2033663, -939513841, 134217726, 2047, -73728, -1, -1,
            541065215, -67059616, -180225, 65535, -8192, 16383, -1, 131135, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, -8, -469762049, -16703999, 537001971,
            -417812, -473563649, -1333765759, 133431235, -423960, -1016201729,
            1577058305, 1900480, -278552, -470942209, 72193, 65475, -417812,
            1676541439, -1333782143, 262083, -700594200, -1006647528, 8396230,
            524224, -139282, 66059775, 30, 65475, -139284, -470811137,
            1080036831, 65475, -139284, -1006633473, 8396225, 65475, -58720276,
            805044223, -16547713, 1835008, -2, 917503, 268402815, 0, -17816170,
            537783470, 872349791, 0, -50331649, -1050673153, -257, -2147481601,
            3872, -1073741824, 237503, 0, -1, 16914171, 16777215, 0, 0, -1,
            -65473, 536870911, -1, -1, -2080374785, -1, -1, -249, -1, 67108863,
            -1, -1, 1031749119, -1, -49665, 2134769663, -8388803, -1,
            -12713985, -1, 134217727, 536870911, 65535, -1, -1, 2097151, -2,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, 8388607, 134217726, -1, -1, 131071, 253951, 6553599, 262143,
            122879, -1, -1065353217, 401605055, 1023, 67043328, -1, -1,
            16777215, -1, 511, 0, 0, 536870911, 33226872, -64, 2047999, -1,
            -64513, 67044351, 0, -830472193, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, 0, 0,
            -1, -1, -1, -1, 268435455, -1, -1, 67108863, 1061158911, -1,
            -1426112705, 1073741823, -1, 1608515583, 265232348, 534519807,
            49152, 27648, 0, -2147352576, 2031616, 0, 0, 0, 1043332228,
            -201605808, 992, -1, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            -4194304, -1, 134217727, 2097152, 0, 0, 0, 0, 0, 0, 0, -268435456,
            -1, -1, 1023, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4096, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1,
            -32769, 2147483647, 0, -1, -1, -1, 31, -1, -65473, -1, 32831,
            8388607, 2139062143, 2139062143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 224, 524157950, -2, -1, -528482305, -2, -1,
            -134217729, -32, -122881, -1, -1, -32769, 16777215, 0, -65536,
            536870911, -1, 15, -1879048193, -1, 131071, -61441, 2147483647, -1,
            -1, -1, -125829121, -1, -1, 1073741823, 2147483647, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 2097152, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            134217728, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, 8191, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2117, 159, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 8, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2147483648, 1, 0, 0, -2147483648,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, -2147483648, 1, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2147483648, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -49153, -1, -63489, -1, -1, 67108863, 0,
            -1594359681, 1602223615, -37, -1, -1, 262143, -524288, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, 1073741823, -65536, -1, -196609, -1,
            255, 536805376, 0, 0, 0, -2162688, -1, -1, -1, 536870911, 0,
            134217726, 134217726, -64, -1, 2147483647, 486341884, 0

    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.098 -0400", hash_original_method = "E93180EB94E57CE76B0A6A52A4C33082", hash_generated_method = "F2F5D32F7513FBFCD1DB4DDEE2E47CCE")
    
private static IllegalArgumentException rangeException(int value) {
        throw new IllegalArgumentException("Illegal range argument value: " + value);
    }

    /**
     * Gets the NumericShaper for the specified unicode ranges
     * and default unicode range. The defaultContext parameter
     * is used as the starting context (which indicates the
     * language/script being used). The OR logical operation
     * should be used for multiple ranges:
     * NumericShaper.DEVANAGARI | NumericShaper.BENGALI.
     * The NumericShaper returned by this method is contextual
     * in that it supports multiple character ranges, depending
     * on the context.
     *
     * @param ranges the unicode ranges.
     * @param defaultContext the default, starting context.
     *
     * @return the NumericShaper for the specified ranges.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.104 -0400", hash_original_method = "6FCB02354E85617703D489BCB59F3D8D", hash_generated_method = "D2809E1AC7D0B5B30BD613D57CBF791E")
    
public static NumericShaper getContextualShaper(int ranges,
            int defaultContext) {
        ranges &= ALL_RANGES;
        defaultContext &= ALL_RANGES;
        return new NumericShaper(ranges, defaultContext, true);
    }

    /**
     * Gets the NumericShaper for the specified unicode ranges.
     * The OR logical operation should be used for multiple ranges:
     * NumericShaper.DEVANAGARI | NumericShaper.BENGALI.
     * The NumericShaper returned by this method is contextual
     * in that it supports multiple character ranges, depending
     * on the context.
     *
     * @param ranges the unicode ranges.
     *
     * @return the NumericShaper for the specified ranges.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.106 -0400", hash_original_method = "C8CD1CAF01E2FF06557279BA08A25863", hash_generated_method = "849A6B967B8071679B32CC9674E64FE1")
    
public static NumericShaper getContextualShaper(int ranges) {
        ranges &= ALL_RANGES;
        return new NumericShaper(ranges, EUROPEAN, true);
    }

    /**
     * Gets a NumericShaper for the specified unicode range.
     * The NumericShaper supports only a single range and
     * hence is not contextual.
     *
     * @param singleRange the specified unicode single range.
     *
     * @return the NumericShaper for the specified unicode range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.109 -0400", hash_original_method = "3FEDD0DDD28FF5F38839B3577FC7B174", hash_generated_method = "CA1FE2C706B83C5B55FDB70EFEB1985C")
    
public static NumericShaper getShaper(int singleRange) {
        singleRange &= ALL_RANGES;
        return new NumericShaper(singleRange, EUROPEAN, false);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.070 -0400", hash_original_field = "6FCC9EE452536E42CE73D8C23E768F13", hash_generated_field = "D3EE751E7018E281A2864BCC77657B51")

    /** The scripts ranges. */
    private final int[] scriptsRanges = {
            0x0000, 0x024F,     // EUROPEAN (basic latin + latin-1 + extended)
            0x0600, 0x06FF,     // ARABIC
            0x0600, 0x06FF,     // EASTERN_ARABIC (XXX: diff with ARABIC ? )
            0x0900, 0x097F,     // DEVANAGARI
            0x0980, 0x09FF,     // BENGALI
            0x0A00, 0x0A7F,     // GURMUKHI
            0x0A80, 0x0AFF,     // GUJARATI
            0x0B00, 0x0B7F,     // ORIYA
            0x0B80, 0x0BFF,     // TAMIL
            0x0C00, 0x0C7F,     // TELUGU
            0x0C80, 0x0CFF,     // KANNADA
            0x0D00, 0x0D7F,     // MALAYALAM
            0x0E00, 0x0E7F,     // THAI
            0x0E80, 0x0EFF,     // LAO
            0x0F00, 0x0FFF,     // TIBETAN
            0x1000, 0x109F,     // MYANMAR
            0x1200, 0x137F,     // ETHIOPIC
            0x1780, 0x17FF,     // KHMER
            0x1800, 0x18AF      // MONGOLIAN
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.072 -0400", hash_original_field = "46C0C8794EF4F6A2D3D010EB5A6C6249", hash_generated_field = "FA0FB2D35CEF904B911135DBED6B7331")

    /** The digits low ranges. */
    private final int[] digitsLowRanges = {
            0x0000,             // EUROPEAN
            0x0630,             // ARABIC
            0x0630,             // EASTERN_ARABIC
            0x0936,             // DEVANAGARI
            0x09B6,             // BENGALI
            0x0A36,             // GURMUKHI
            0x0AB6,             // GUJARATI
            0x0B36,             // ORIYA
            0x0BB6,             // TAMIL
            0x0C36,             // TELUGU
            0x0CB6,             // KANNADA
            0x0D36,             // MALAYALAM
            0x0E20,             // THAI
            0x0EA0,             // LAO
            0x0EF0,             // TIBETAN
            0x1010,             // MYANMAR
            0x1338,             // ETHIOPIC - (low range-1) no ETHIOPIC '0' DIGIT!
            0x17B0,             // KHMER
            0x17E0              // MONGOLIAN
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.073 -0400", hash_original_field = "CB5BE8E30B470F755CF8A02D305CDE64", hash_generated_field = "400953E5B4F22DB2816247D7D08AA73F")

    /** The contexts. */
    private final String[] contexts = {
            "EUROPEAN",
            "ARABIC",
            "EASTERN_ARABIC",
            "DEVANAGARI",
            "BENGALI",
            "GURMUKHI",
            "GUJARATI",
            "ORIYA",
            "TAMIL",
            "TELUGU",
            "KANNADA",
            "MALAYALAM",
            "THAI",
            "LAO",
            "TIBETAN",
            "MYANMAR",
            "ETHIOPIC",
            "KHMER",
            "MONGOLIAN"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.084 -0400", hash_original_field = "924FCEB5205DF39287EF00BA7F8A5371", hash_generated_field = "FC614EE1CA48589A6671F75E2DEE6B76")

    /** The key. */
    private int key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.086 -0400", hash_original_field = "DB965A11139AB665B00B4D2E2ABFFB32", hash_generated_field = "932555E474C656C0FC376E400D83F394")

    /** The mask. */
    private int mask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.088 -0400", hash_original_field = "022B4836973B3E6CCF9E67A3383AF0BC", hash_generated_field = "00B092FE9A2B482248C2E0E6E33B64CA")

    /** The ranges. */
    private int fRanges;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.090 -0400", hash_original_field = "542B4721C13D6DEC8A334C28477BF779", hash_generated_field = "2DD078F16FF7D5C80418182D3850505B")

    /** The default context index. */
    private int fDefaultContextIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.091 -0400", hash_original_field = "7F3F6CB135ECB7DC63491A8F37599A61", hash_generated_field = "96508E0812D3A61A87F57EE995307CFA")

    /** The contextual. */
    private boolean fContextual;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.092 -0400", hash_original_field = "7F57EADDFA685117F01B85317269EFC4", hash_generated_field = "E049581984B14741D8D6D71B215469DA")

    /** The single range index. */
    private int fSingleRangeIndex;

    /**
     * Creates NumericShaper with specified parameters.
     *
     * @param ranges specified ranges to be shaped
     * @param defaultContext default context range
     * @param isContextual specifies if the instance is contextual
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.093 -0400", hash_original_method = "D5453C8E1476C88A8081358CF5377930", hash_generated_method = "7EE2E149C1AA34154359A29494D49888")
    
private NumericShaper(int ranges, int defaultContext, boolean isContextual){
        this.fRanges = ranges;
        this.fDefaultContextIndex = getIndexFromRange(defaultContext);
        this.fContextual = isContextual;

        if (!fContextual){
            fSingleRangeIndex = getIndexFromRange(ranges);
        }
    }

    /**
     * Returns script index of the specified context range.
     *
     * @param range specified range
     *
     * @return one of the script indices according to the specified range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.095 -0400", hash_original_method = "D8BBE2B67D8C840A141BA63AAF8C5E8B", hash_generated_method = "6FF1F48A0287A8EC74BABE2E3275D2F9")
    
private int getIndexFromRange(int range){
        if (range == 0) {
            throw rangeException(range);
        }

        int index = 0;
        while (index < MAX_INDEX){
            if (range == (1 << index)){
                return index;
            }
            index++;
        }

        throw rangeException(range);
    }

    /**
     * Returns range corresponding to the specified script index.
     *
     * @param index specified script index
     *
     * @return one of the range constants according to the specified script index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.096 -0400", hash_original_method = "E30A8BC1C8D509F08DDB5BCAB6D73491", hash_generated_method = "DA96B1B3686205827EA61FCEC4042742")
    
private int getRangeFromIndex(int index){
        if (index < 0 || index >= MAX_INDEX){
            throw rangeException(index);
        }

        return 1 << index;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.099 -0400", hash_original_method = "901EBF5281D18A1F2D08C150935DC6CF", hash_generated_method = "41F0D688A8175F0FB250FC1E30E7E82F")
    
@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + fRanges;
        result = 31 * result + fDefaultContextIndex;
        result = 31 * result + (fContextual ? 1 : 0);
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.101 -0400", hash_original_method = "D8B6DCD3AB2AFAD3FB48F56778B03FF9", hash_generated_method = "6D9BD3CC21FF82F2E265BE0BBF844E9B")
    
@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        try {
            NumericShaper ns = (NumericShaper)obj;
            return (fRanges == ns.fRanges &&
                    fDefaultContextIndex == ns.fDefaultContextIndex &&
                    fContextual == ns.fContextual);
        } catch (ClassCastException e){
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.103 -0400", hash_original_method = "E1008406AD28195875610EB05258F007", hash_generated_method = "410027CCAB34D517804B58086B96B216")
    
@Override
    public String toString() {
        /* !! There is no description in the documentation what this method must
         * return. Thus format of toString method is based on 1.5 release
         * behavior and can be obtained using next test sample:
         *
         * // Simple shapers toString format
         * System.out.println(NumericShaper.getShaper(NumericShaper.EASTERN_ARABIC));
         *
         * // Context shapers with default context toString format
         * System.out.println(NumericShaper.getContextualShaper(
         *      NumericShaper.ARABIC | NumericShaper.TAMIL));
         *
         * // Context shapers with context
         * System.out.println(NumericShaper.getContextualShaper(
         *      NumericShaper.ARABIC | NumericShaper.TAMIL,
         *      NumericShaper.EASTERN_ARABIC));
         */
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("[contextual:");
        sb.append(fContextual);

        if (fContextual){
            sb.append(", context:");
            sb.append(contexts[fDefaultContextIndex]);
        }

        sb.append(", range(s): ");
        if (fContextual) {
            int index = 0;
            boolean isFirst = true;
            while (index < MAX_INDEX){
                if ((fRanges & (1 << index)) != 0){
                    if (isFirst){
                        isFirst = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(contexts[index]);
                }
                index++;
            }
        } else {
            sb.append(contexts[fSingleRangeIndex]);
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Gets the masks for all of the ranges supported by this NumericShaper,
     * packed into an int value using the logical OR logical operation
     * for multiple ranges:
     * NumericShaper.DEVANAGARI | NumericShaper.BENGALI.
     *
     * @return all ranges of this NumericShaper.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.107 -0400", hash_original_method = "74FA94DB72D7E5F63B8EDCA4345CAE55", hash_generated_method = "700AF4145B31D541F06FC8A8224F6288")
    
public int getRanges() {
        return fRanges;
    }

    /**
     * Checks if this NumericShaper is contextual (supporting
     * multiple script ranges) or not.
     *
     * @return true, if this NumericShaper is contextual, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.110 -0400", hash_original_method = "25F32C80196A92214BBC65AF90C93DBA", hash_generated_method = "4C785FA230C82D5E3B9E2A75340E1E92")
    
public boolean isContextual() {
        return fContextual;
    }

    /**
     * Transforms the encoding of the text, starting from the character
     * at index start and transforming count characters,
     * using the specified context.
     *
     * @param text the text to be shaped.
     * @param start the start offset of the text.
     * @param count the number of characters to be shaped.
     * @param context the context to be used for shaping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.111 -0400", hash_original_method = "3A039CFB5FB23C6800009AA566E66D3F", hash_generated_method = "8FB4B8DD255661E30270BCB2495840AD")
    
public void shape(char[] text, int start, int count, int context) {
        if (isContextual()){
            contextualShape(text, start, count, getIndexFromRange(context));
        } else {
            nonContextualShape(text, start, count);
        }
    }

    /**
     * Transforms the encoding of the text, starting from the character
     * at index start and transforming count characters.
     *
     * @param text the text to be shaped.
     * @param start the start offset of the text.
     * @param count the number of characters to be shaped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.113 -0400", hash_original_method = "2C99B5F9FA30CE949BAD9F2A49471B0A", hash_generated_method = "8E28D71268F5F4103562E15B17C0F106")
    
public void shape(char[] text, int start, int count) {
        if (isContextual()){
            contextualShape(text, start, count, fDefaultContextIndex);
        } else {
            nonContextualShape(text, start, count);
        }
    }

    /**
     * Converts count of digits of the given array of characters from the start
     * index using specified context. This method is applied for the contextual
     * shaping, if the shaper instance is not contextual use nonContextualShape
     * method.
     *
     * @param text an array of chars
     * @param start index of the first character to convert
     * @param count a number of characters to convert
     * @param contextIndex index of the script index to use in shaper
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.114 -0400", hash_original_method = "7CD459CA02BA6EDA3790E870E9AD0778", hash_generated_method = "3DCFDCB9434A1917090C8C7983061600")
    
private void contextualShape(char[] text, int start, int count,
            int contextIndex){
        char maxDigit = (char)0x0039;
        char minDigit = (char)0x0030;

        int currIndex;
        if (((1 << contextIndex) & fRanges) == 0 ){
            currIndex = INDEX_EUROPEAN;
        } else {
            currIndex = contextIndex;
        }

        for (int ind = start; ind < start + count; ind++){
            if (minDigit <= text[ind] && text[ind] <= maxDigit){
                if (currIndex != INDEX_ETHIOPIC || text[ind] != '0'){
                    text[ind] = (char)(digitsLowRanges[currIndex] + text[ind]);
                }
            } else {
                if(isCharStrong(text[ind])){
                    int index = getCharIndex(text[ind]);
                    if (currIndex != index){
                        if (((1 << index) & fRanges) != 0){
                            currIndex = index;
                        } else {
                            currIndex = INDEX_EUROPEAN;
                        }
                    }
                }
            }
        }

    }

    /**
     * Converts count of digits of the given array of characters from the start
     * index. Method is applied for non-contextual shaper.
     *
     * @param text an array of chars
     * @param start index of the first character to convert
     * @param count a number of characters to convert
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.116 -0400", hash_original_method = "4060C53488B85388A8589DA990375C48", hash_generated_method = "93125471A8B3E44F8114BC8582FE0660")
    
private void nonContextualShape(char[] text, int start, int count){
        char maxDigit = (char)0x0039;
        char minDigit = (char)((fRanges == ETHIOPIC) ? 0x0031 : 0x0030);
        for (int ind = start; ind < start + count; ind++){
            if (minDigit <= text[ind] && text[ind] <= maxDigit){
                    text[ind] = (char)(digitsLowRanges[fSingleRangeIndex] + text[ind]);
            }
        }

    }

    /**
     * Returns the index of the script of the specified char.
     *
     * @param ch specified unicode character
     *
     * @return script index corresponding to the given char
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.118 -0400", hash_original_method = "1A7909966DE9994C2B04FD77FA543541", hash_generated_method = "15402C1B6A535BCBC8DDBF75CC8CDD8F")
    
private int getCharIndex(char ch){
        int index = INDEX_EUROPEAN;
        for (int i=0; i < MAX_INDEX; i++){
            int j = i * 2;
            if (scriptsRanges[j] <= ch && ch <= scriptsRanges[j+1]){
                return i;
            }
        }

        return index;
    }

    /**
     * Returns true if the bidirectional category of the character
     * is strong.
     *
     * @param chr the chr
     *
     * @return true, if the character is strong, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.119 -0400", hash_original_method = "C455475965AA7172574087D5CCE9F171", hash_generated_method = "935EF4AA62815F612019AB5469CDB54A")
    
private boolean isCharStrong(int chr) {
        return (STRONG_TEXT_FLAGS[chr >> 5] & (1 << (chr % 32))) != 0;
    }

    /**
     * Updates all private serialized fields for object to be correctly serialized
     * according to the serialized form of this class mentioned in the
     * documentation.
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.120 -0400", hash_original_method = "E6B8CB0AF30DF8317A7CBD674404DE03", hash_generated_method = "73F8AE215148AA8DC109100CA1D451EB")
    
private void updateRangesFields(){
        fRanges = (mask & ~(1 << 31));
        fContextual = ((mask &(1 << 31)) != 0);
        if (fContextual){
            fRanges = (mask & ~(1 << 31));
            fDefaultContextIndex = key;
        } else {
            fRanges = mask;
            fSingleRangeIndex = key;
        }
    }

    /**
     * Updates private fields for object after deserialization
     * according to the serialized form of this class mentioned in the
     * documentation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.121 -0400", hash_original_method = "E676DFDEC85B4B1F452BB4B5F6043E68", hash_generated_method = "40BE6B1554522CFC4E9D5D7A59F7DA72")
    
private void updateKeyMaskFields(){
        mask = fRanges;
        if (fContextual){
            mask |= (1 << 31);
            key = fDefaultContextIndex;
        } else{
            key = fSingleRangeIndex;
        }
    }

    /**
     * Write object.
     *
     * @param out the out
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.123 -0400", hash_original_method = "A985AF99F9F781A8A9976410A53B204B", hash_generated_method = "B66F02FD6266CB4820ECF12D7742FC1B")
    
private void writeObject(java.io.ObjectOutputStream out)
                                throws IOException{
        updateKeyMaskFields();
        out.defaultWriteObject();
    }

    /**
     * Read object.
     *
     * @param in the in
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ClassNotFoundException the class not found exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.124 -0400", hash_original_method = "BCB1708F0DFA4BE5A3C6F7A871F32C47", hash_generated_method = "133FCCD96C9FEA72866FB5A8FB5E6E89")
    
private void readObject(java.io.ObjectInputStream in)
                                throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        updateRangesFields();
    }

}
