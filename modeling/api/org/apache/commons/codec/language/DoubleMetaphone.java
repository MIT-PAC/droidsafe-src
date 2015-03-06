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
 * Encodes a string into a double metaphone value.
 * This Implementation is based on the algorithm by <CITE>Lawrence Philips</CITE>.
 * <ul>
 * <li>Original Article: <a 
 * href="http://www.cuj.com/documents/s=8038/cuj0006philips/">
 * http://www.cuj.com/documents/s=8038/cuj0006philips/</a></li>
 * <li>Original Source Code: <a href="ftp://ftp.cuj.com/pub/2000/1806/philips.zip">
 * ftp://ftp.cuj.com/pub/2000/1806/philips.zip</a></li>
 * </ul>
 * 
 * @author Apache Software Foundation
 * @version $Id: DoubleMetaphone.java,v 1.24 2004/06/05 18:32:04 ggregory Exp $
 */
public class DoubleMetaphone implements StringEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.435 -0400", hash_original_field = "0FE2661593DF0C58CF2562E94116C514", hash_generated_field = "913CB0ADDB56A43D9F7CC397238711AA")

    private static final String VOWELS = "AEIOUY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.436 -0400", hash_original_field = "A9E97305881C1420CA0016A6EA6EF4BD", hash_generated_field = "ED3D2C4116E7F5731D781759EB9DAC6B")

    private static final String[] SILENT_START = 
    { "GN", "KN", "PN", "WR", "PS" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.436 -0400", hash_original_field = "1545069D588FCED8F218D550A218669F", hash_generated_field = "BE6CB94FDB8F136D1D4D5737DD057015")

    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = 
    { "L", "R", "N", "M", "B", "H", "F", "V", "W", " " };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.437 -0400", hash_original_field = "12E5F75E224E5E4AC44EE2A8039E552F", hash_generated_field = "5015F675C41ECD7DDE7393C60B2815FF")

    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = 
    { "ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.438 -0400", hash_original_field = "93AD711EFA71ADC7954142B976493E2A", hash_generated_field = "5FFE7E3013385670B162E8314083CD12")

    private static final String[] L_T_K_S_N_M_B_Z = 
    { "L", "T", "K", "S", "N", "M", "B", "Z" };

    /**
     * Shortcut method with 1 criteria
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.472 -0400", hash_original_method = "D43146211DD30099A852EB07F596E6C2", hash_generated_method = "4DB923C1EA43FB43A94C35364896E453")
    
private static boolean contains(String value, int start, int length, 
                                    String criteria) {
        return contains(value, start, length, 
                        new String[] { criteria });
    }

    /**
     * Shortcut method with 2 criteria
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.473 -0400", hash_original_method = "ED214FC677587573A3092F09EFB22E36", hash_generated_method = "0D0CAC1B1294F15D0FA32D5EBAF4A2F1")
    
private static boolean contains(String value, int start, int length, 
                                    String criteria1, String criteria2) {
        return contains(value, start, length, 
                        new String[] { criteria1, criteria2 });
    }

    /**
     * Shortcut method with 3 criteria
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.474 -0400", hash_original_method = "639ED1CAB7330F9B0CDE6D13A14B67F4", hash_generated_method = "04E6EA25C3F735EB185EFA6CEB0182D5")
    
private static boolean contains(String value, int start, int length, 
                                    String criteria1, String criteria2, 
                                    String criteria3) {
        return contains(value, start, length, 
                        new String[] { criteria1, criteria2, criteria3 });
    }

    /**
     * Shortcut method with 4 criteria
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.474 -0400", hash_original_method = "DBD2848452E30EF8C99C53C0106675C8", hash_generated_method = "CB837E92AA750BCEDB79E830FF7C9DB3")
    
private static boolean contains(String value, int start, int length, 
                                    String criteria1, String criteria2, 
                                    String criteria3, String criteria4) {
        return contains(value, start, length, 
                        new String[] { criteria1, criteria2, criteria3, 
                                       criteria4 });
    }

    /**
     * Shortcut method with 5 criteria
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.475 -0400", hash_original_method = "B29C3FEEE8F91C6C1D6D318DAC8D8B15", hash_generated_method = "32B4B25ACFDF8C0FBB0703964256D1AB")
    
private static boolean contains(String value, int start, int length, 
                                    String criteria1, String criteria2, 
                                    String criteria3, String criteria4, 
                                    String criteria5) {
        return contains(value, start, length, 
                        new String[] { criteria1, criteria2, criteria3, 
                                       criteria4, criteria5 });
    }

    /**
     * Shortcut method with 6 criteria
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.476 -0400", hash_original_method = "F2A8A7114388A83AFB9148728DC98FB1", hash_generated_method = "84AABE52B5199505ECE3C40F729CE0BC")
    
private static boolean contains(String value, int start, int length, 
                                    String criteria1, String criteria2, 
                                    String criteria3, String criteria4, 
                                    String criteria5, String criteria6) {
        return contains(value, start, length, 
                        new String[] { criteria1, criteria2, criteria3, 
                                       criteria4, criteria5, criteria6 });
    }
    
    /**
     * Determines whether <code>value</code> contains any of the criteria 
     starting
     * at index <code>start</code> and matching up to length <code>length</code>
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.477 -0400", hash_original_method = "AF5A296444896F1AD517AE5700089864", hash_generated_method = "37ECF25E149B9AA3C57FB6FF6EA60F1C")
    
protected static boolean contains(String value, int start, int length, 
                                      String[] criteria) {
        boolean result = false;
        if (start >= 0 && start + length <= value.length()) {
            String target = value.substring(start, start + length);

            for (int i = 0; i < criteria.length; i++) {
                if (target.equals(criteria[i])) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.438 -0400", hash_original_field = "360BE26A77BBC184847F9125BDBB2937", hash_generated_field = "8B85CB3D17211D5FDEC8CA858620498E")

    protected int maxCodeLen = 4;

    /**
     * Creates an instance of this DoubleMetaphone encoder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.439 -0400", hash_original_method = "306664D74E802C544F96CDD20B750264", hash_generated_method = "103A3FDB63AC0ACC18B104055FA07B5E")
    
public DoubleMetaphone() {
        super();
    }
    
    /**
     * Encode a value with Double Metaphone
     *
     * @param value String to encode
     * @return an encoded string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.439 -0400", hash_original_method = "CFE447BE824F339B0EBBFC43909D5C94", hash_generated_method = "B292AED96BA03B3A6969D8469F2CB45D")
    
public String doubleMetaphone(String value) {
        return doubleMetaphone(value, false);
    }
    
    /**
     * Encode a value with Double Metaphone, optionally using the alternate
     * encoding.
     *
     * @param value String to encode
     * @param alternate use alternate encode
     * @return an encoded string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.442 -0400", hash_original_method = "4745F366B4E323504C75B60DAA491ED5", hash_generated_method = "D86553B526AFFDF5221B72B98CC82A76")
    
public String doubleMetaphone(String value, boolean alternate) {
        value = cleanInput(value);
        if (value == null) {
            return null;
        }
        
        boolean slavoGermanic = isSlavoGermanic(value);
        int index = isSilentStart(value) ? 1 : 0;
        
        DoubleMetaphoneResult result = new DoubleMetaphoneResult(this.getMaxCodeLen());
        
        while (!result.isComplete() && index <= value.length() - 1) {
            switch (value.charAt(index)) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
                index = handleAEIOUY(value, result, index);
                break;
            case 'B':
                result.append('P');
                index = charAt(value, index + 1) == 'B' ? index + 2 : index + 1;
                break;
            case '\u00C7':
                // A C with a Cedilla
                result.append('S');
                index++;
                break; 
            case 'C':
                index = handleC(value, result, index);
                break;
            case 'D':
                index = handleD(value, result, index);
                break;
            case 'F':
                result.append('F');
                index = charAt(value, index + 1) == 'F' ? index + 2 : index + 1;
                break;
            case 'G':
                index = handleG(value, result, index, slavoGermanic);
                break;
            case 'H':
                index = handleH(value, result, index);
                break;
            case 'J':
                index = handleJ(value, result, index, slavoGermanic);
                break;
            case 'K':
                result.append('K');
                index = charAt(value, index + 1) == 'K' ? index + 2 : index + 1;
                break;
            case 'L':
                index = handleL(value, result, index);
                break;
            case 'M':
                result.append('M');
                index = conditionM0(value, index) ? index + 2 : index + 1;
                break;
            case 'N':
                result.append('N');
                index = charAt(value, index + 1) == 'N' ? index + 2 : index + 1;
                break;
            case '\u00D1':
                // N with a tilde (spanish ene)
                result.append('N');
                index++;
                break;
            case 'P':
                index = handleP(value, result, index);
                break;
            case 'Q':
                result.append('K');
                index = charAt(value, index + 1) == 'Q' ? index + 2 : index + 1;
                break;
            case 'R':
                index = handleR(value, result, index, slavoGermanic);
                break;
            case 'S':
                index = handleS(value, result, index, slavoGermanic);
                break;
            case 'T':
                index = handleT(value, result, index);
                break;
            case 'V':
                result.append('F');
                index = charAt(value, index + 1) == 'V' ? index + 2 : index + 1;
                break;
            case 'W':
                index = handleW(value, result, index);
                break;
            case 'X':
                index = handleX(value, result, index);
                break;
            case 'Z':
                index = handleZ(value, result, index, slavoGermanic);
                break;
            default:
                index++;
                break;
            }
        }

        return alternate ? result.getAlternate() : result.getPrimary();
    }
    
    /**
     * Encode the value using DoubleMetaphone.  It will only work if 
     * <code>obj</code> is a <code>String</code> (like <code>Metaphone</code>).
     *
     * @param obj Object to encode (should be of type String)
     * @return An encoded Object (will be of type String)
     * @throws EncoderException encode parameter is not of type String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.443 -0400", hash_original_method = "EF9CB7E560194B697D530C283E40B2D2", hash_generated_method = "77F0C979A8BAD2A8318EE5127D64E6AC")
    
public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("DoubleMetaphone encode parameter is not of type String"); 
        } 
        return doubleMetaphone((String) obj);
    }

    /**
     * Encode the value using DoubleMetaphone.
     *
     * @param value String to encode
     * @return An encoded String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.443 -0400", hash_original_method = "3031FE249F5CE3F2014E77A11C9675EE", hash_generated_method = "71C0F62D990BB42862F6F81DE318B32D")
    
public String encode(String value) {
        return doubleMetaphone(value);   
    }

    /**
     * Check if the Double Metaphone values of two <code>String</code> values
     * are equal.
     * 
     * @param value1 The left-hand side of the encoded {@link String#equals(Object)}.
     * @param value2 The right-hand side of the encoded {@link String#equals(Object)}.
     * @return <code>true</code> if the encoded <code>String</code>s are equal;
     *          <code>false</code> otherwise.
     * @see #isDoubleMetaphoneEqual(String,String,boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.444 -0400", hash_original_method = "3A1F780B4E10DD64D09F66978CACFCA5", hash_generated_method = "A990ED33B751BDA19334FD8ADF52EAF1")
    
public boolean isDoubleMetaphoneEqual(String value1, String value2) {
        return isDoubleMetaphoneEqual(value1, value2, false);
    }
    
    /**
     * Check if the Double Metaphone values of two <code>String</code> values
     * are equal, optionally using the alternate value.
     * 
     * @param value1 The left-hand side of the encoded {@link String#equals(Object)}.
     * @param value2 The right-hand side of the encoded {@link String#equals(Object)}.
     * @param alternate use the alternate value if <code>true</code>.
     * @return <code>true</code> if the encoded <code>String</code>s are equal;
     *          <code>false</code> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.445 -0400", hash_original_method = "CE9467A20F4CACD32CB333CB576C654A", hash_generated_method = "7264E26D2B721ACBFD19AC987E94B0CA")
    
public boolean isDoubleMetaphoneEqual(String value1, 
                                          String value2, 
                                          boolean alternate) {
        return doubleMetaphone(value1, alternate).equals(doubleMetaphone
                                                         (value2, alternate));
    }
    
    /**
     * Returns the maxCodeLen.
     * @return int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.445 -0400", hash_original_method = "53FC9A6F30C18D9412BF76DFC3D2F433", hash_generated_method = "92BD6472A9D4C03F7DAF13D471BE969A")
    
public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    /**
     * Sets the maxCodeLen.
     * @param maxCodeLen The maxCodeLen to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.446 -0400", hash_original_method = "E18ED09E55EC88E198B808F02955AF0A", hash_generated_method = "A360454A3426CC9DD47B4968BE2FCAA3")
    
public void setMaxCodeLen(int maxCodeLen) {
        this.maxCodeLen = maxCodeLen;
    }

    //-- BEGIN HANDLERS --//

    /**
     * Handles 'A', 'E', 'I', 'O', 'U', and 'Y' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.446 -0400", hash_original_method = "FA52A4C3707CCDDDF489C2F17047599B", hash_generated_method = "B147CA4DC03A3AF6F27BF3CF82100557")
    
private int handleAEIOUY(String value, DoubleMetaphoneResult result, int 
                             index) {
        if (index == 0) {
            result.append('A');
        }
        return index + 1;
    }
    
    /**
     * Handles 'C' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.448 -0400", hash_original_method = "66710A9067B88FB9B934FC4457CB1061", hash_generated_method = "C8D00130EB62EA5A4F98FD7143947A18")
    
private int handleC(String value, 
                        DoubleMetaphoneResult result, 
                        int index) {
        if (conditionC0(value, index)) {  // very confusing, moved out
            result.append('K');
            index += 2;
        } else if (index == 0 && contains(value, index, 6, "CAESAR")) {
            result.append('S');
            index += 2;
        } else if (contains(value, index, 2, "CH")) {
            index = handleCH(value, result, index);
        } else if (contains(value, index, 2, "CZ") && 
                   !contains(value, index - 2, 4, "WICZ")) {
            //-- "Czerny" --//
            result.append('S', 'X');
            index += 2;
        } else if (contains(value, index + 1, 3, "CIA")) {
            //-- "focaccia" --//
            result.append('X');
            index += 3;
        } else if (contains(value, index, 2, "CC") && 
                   !(index == 1 && charAt(value, 0) == 'M')) {
            //-- double "cc" but not "McClelland" --//
            return handleCC(value, result, index);
        } else if (contains(value, index, 2, "CK", "CG", "CQ")) {
            result.append('K');
            index += 2;
        } else if (contains(value, index, 2, "CI", "CE", "CY")) {
            //-- Italian vs. English --//
            if (contains(value, index, 3, "CIO", "CIE", "CIA")) {
                result.append('S', 'X');
            } else {
                result.append('S');
            }
            index += 2;
        } else {
            result.append('K');
            if (contains(value, index + 1, 2, " C", " Q", " G")) { 
                //-- Mac Caffrey, Mac Gregor --//
                index += 3;
            } else if (contains(value, index + 1, 1, "C", "K", "Q") && 
                       !contains(value, index + 1, 2, "CE", "CI")) {
                index += 2;
            } else {
                index++;
            }
        }
        
        return index;
    }

    /**
     * Handles 'CC' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.449 -0400", hash_original_method = "E9357143661C4CBD062C72A99CA332CD", hash_generated_method = "F1CFBA8A44FEEE267762B3A58ED6A9B1")
    
private int handleCC(String value, 
                         DoubleMetaphoneResult result, 
                         int index) {
        if (contains(value, index + 2, 1, "I", "E", "H") && 
            !contains(value, index + 2, 2, "HU")) {
            //-- "bellocchio" but not "bacchus" --//
            if ((index == 1 && charAt(value, index - 1) == 'A') || 
                contains(value, index - 1, 5, "UCCEE", "UCCES")) {
                //-- "accident", "accede", "succeed" --//
                result.append("KS");
            } else {
                //-- "bacci", "bertucci", other Italian --//
                result.append('X');
            }
            index += 3;
        } else {    // Pierce's rule
            result.append('K');
            index += 2;
        }
        
        return index;
    }
    
    /**
     * Handles 'CH' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.450 -0400", hash_original_method = "C4363C06EF39F3E979478C615A16D25B", hash_generated_method = "8CD5F4944DC1A4F0B3F195F05E025641")
    
private int handleCH(String value, 
                         DoubleMetaphoneResult result, 
                         int index) {
        if (index > 0 && contains(value, index, 4, "CHAE")) {   // Michael
            result.append('K', 'X');
            return index + 2;
        } else if (conditionCH0(value, index)) {
            //-- Greek roots ("chemistry", "chorus", etc.) --//
            result.append('K');
            return index + 2;
        } else if (conditionCH1(value, index)) {
            //-- Germanic, Greek, or otherwise 'ch' for 'kh' sound --//
            result.append('K');
            return index + 2;
        } else {
            if (index > 0) {
                if (contains(value, 0, 2, "MC")) {
                    result.append('K');
                } else {
                    result.append('X', 'K');
                }
            } else {
                result.append('X');
            }
            return index + 2;
        }
    }

    /**
     * Handles 'D' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.450 -0400", hash_original_method = "BEF7C8A36A61745EB3A28E57DD5A9FED", hash_generated_method = "BC28DF8440C56DEF5BEC0854D5C512FB")
    
private int handleD(String value, 
                        DoubleMetaphoneResult result, 
                        int index) {
        if (contains(value, index, 2, "DG")) {
            //-- "Edge" --//
            if (contains(value, index + 2, 1, "I", "E", "Y")) {
                result.append('J');
                index += 3;
                //-- "Edgar" --//
            } else {
                result.append("TK");
                index += 2;
            }
        } else if (contains(value, index, 2, "DT", "DD")) {
            result.append('T');
            index += 2;
        } else {
            result.append('T');
            index++;
        }
        return index;
    }

    /**
     * Handles 'G' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.452 -0400", hash_original_method = "C04D21339CFA40AC05FBD4CEA26D310A", hash_generated_method = "8D1938798E84B869C2C7763D487B1D98")
    
private int handleG(String value, 
                        DoubleMetaphoneResult result, 
                        int index, 
                        boolean slavoGermanic) {
        if (charAt(value, index + 1) == 'H') {
            index = handleGH(value, result, index);
        } else if (charAt(value, index + 1) == 'N') {
            if (index == 1 && isVowel(charAt(value, 0)) && !slavoGermanic) {
                result.append("KN", "N");
            } else if (!contains(value, index + 2, 2, "EY") && 
                       charAt(value, index + 1) != 'Y' && !slavoGermanic) {
                result.append("N", "KN");
            } else {
                result.append("KN");
            }
            index = index + 2;
        } else if (contains(value, index + 1, 2, "LI") && !slavoGermanic) {
            result.append("KL", "L");
            index += 2;
        } else if (index == 0 && (charAt(value, index + 1) == 'Y' || contains(value, index + 1, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            //-- -ges-, -gep-, -gel-, -gie- at beginning --//
            result.append('K', 'J');
            index += 2;
        } else if ((contains(value, index + 1, 2, "ER") || 
                    charAt(value, index + 1) == 'Y') &&
                   !contains(value, 0, 6, "DANGER", "RANGER", "MANGER") &&
                   !contains(value, index - 1, 1, "E", "I") && 
                   !contains(value, index - 1, 3, "RGY", "OGY")) {
            //-- -ger-, -gy- --//
            result.append('K', 'J');
            index += 2;
        } else if (contains(value, index + 1, 1, "E", "I", "Y") || 
                   contains(value, index - 1, 4, "AGGI", "OGGI")) {
            //-- Italian "biaggi" --//
            if ((contains(value, 0 ,4, "VAN ", "VON ") || contains(value, 0, 3, "SCH")) || contains(value, index + 1, 2, "ET")) {
                //-- obvious germanic --//
                result.append('K');
            } else if (contains(value, index + 1, 4, "IER")) {
                result.append('J');
            } else {
                result.append('J', 'K');
            }
            index += 2;
        } else if (charAt(value, index + 1) == 'G') {
            index += 2;
            result.append('K');
        } else {
            index++;
            result.append('K');
        }
        return index;
    }
    
    /**
     * Handles 'GH' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.455 -0400", hash_original_method = "0AB65C0A8309BECF9DF803F58DFF3ADB", hash_generated_method = "22BF10F26F4E86778B4A86578FC6C782")
    
private int handleGH(String value, 
                         DoubleMetaphoneResult result, 
                         int index) {
        if (index > 0 && !isVowel(charAt(value, index - 1))) {
            result.append('K');
            index += 2;
        } else if (index == 0) {
            if (charAt(value, index + 2) == 'I') {
                result.append('J');
            } else {
                result.append('K');
            }
            index += 2;
        } else if ((index > 1 && contains(value, index - 2, 1, "B", "H", "D")) ||
                   (index > 2 && contains(value, index - 3, 1, "B", "H", "D")) ||
                   (index > 3 && contains(value, index - 4, 1, "B", "H"))) {
            //-- Parker's rule (with some further refinements) - "hugh"
            index += 2;
        } else {
            if (index > 2 && charAt(value, index - 1) == 'U' && 
                contains(value, index - 3, 1, "C", "G", "L", "R", "T")) {
                //-- "laugh", "McLaughlin", "cough", "gough", "rough", "tough"
                result.append('F');
            } else if (index > 0 && charAt(value, index - 1) != 'I') {
                result.append('K');
            }
            index += 2;
        }
        return index;
    }

    /**
     * Handles 'H' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.455 -0400", hash_original_method = "24E00A928675E75D0841AC75BD361533", hash_generated_method = "09F96439DFBB9A7A4BE9D211F8A7D21A")
    
private int handleH(String value, 
                        DoubleMetaphoneResult result, 
                        int index) {
        //-- only keep if first & before vowel or between 2 vowels --//
        if ((index == 0 || isVowel(charAt(value, index - 1))) && 
            isVowel(charAt(value, index + 1))) {
            result.append('H');
            index += 2;
            //-- also takes car of "HH" --//
        } else {
            index++;
        }
        return index;
    }
    
    /**
     * Handles 'J' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.456 -0400", hash_original_method = "DC4520A08FC5096E13EEA9B9A8CCEB9C", hash_generated_method = "702DFC49808577C558CDF604A2CBCE20")
    
private int handleJ(String value, DoubleMetaphoneResult result, int index, 
                        boolean slavoGermanic) {
        if (contains(value, index, 4, "JOSE") || contains(value, 0, 4, "SAN ")) {
                //-- obvious Spanish, "Jose", "San Jacinto" --//
                if ((index == 0 && (charAt(value, index + 4) == ' ') || 
                     value.length() == 4) || contains(value, 0, 4, "SAN ")) {
                    result.append('H');
                } else {
                    result.append('J', 'H');
                }
                index++;
            } else {
                if (index == 0 && !contains(value, index, 4, "JOSE")) {
                    result.append('J', 'A');
                } else if (isVowel(charAt(value, index - 1)) && !slavoGermanic && 
                              (charAt(value, index + 1) == 'A' || charAt(value, index + 1) == 'O')) {
                    result.append('J', 'H');
                } else if (index == value.length() - 1) {
                    result.append('J', ' ');
                } else if (!contains(value, index + 1, 1, L_T_K_S_N_M_B_Z) && !contains(value, index - 1, 1, "S", "K", "L")) {
                    result.append('J');
                }

                if (charAt(value, index + 1) == 'J') {
                    index += 2;
                } else {
                    index++;
                }
            }
        return index;
    }
    
    /**
     * Handles 'L' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.457 -0400", hash_original_method = "5F6E92126740527619B1D96BADC72C6E", hash_generated_method = "6035646119323832DDE95EC9CE8ED9E5")
    
private int handleL(String value, 
                        DoubleMetaphoneResult result, 
                        int index) {
        result.append('L');
        if (charAt(value, index + 1) == 'L') {
            if (conditionL0(value, index)) {
                result.appendAlternate(' ');
            }
            index += 2;
        } else {
            index++;
        }
        return index;
    }

    /**
     * Handles 'P' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.458 -0400", hash_original_method = "FC899DEC0E12EB8012F1AF3A006D9447", hash_generated_method = "7DB8637C164C2912EE09F818F470F198")
    
private int handleP(String value, 
                        DoubleMetaphoneResult result, 
                        int index) {
        if (charAt(value, index + 1) == 'H') {
            result.append('F');
            index += 2;
        } else {
            result.append('P');
            index = contains(value, index + 1, 1, "P", "B") ? index + 2 : index + 1;
        }
        return index;
    }

    /**
     * Handles 'R' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.459 -0400", hash_original_method = "1AFF94373CE43938D77349C7E6B3F7D6", hash_generated_method = "D6F7369E1EB1F73F9B63CDD923CEC241")
    
private int handleR(String value, 
                        DoubleMetaphoneResult result, 
                        int index, 
                        boolean slavoGermanic) {
        if (index == value.length() - 1 && !slavoGermanic && 
            contains(value, index - 2, 2, "IE") && 
            !contains(value, index - 4, 2, "ME", "MA")) {
            result.appendAlternate('R');
        } else {
            result.append('R');
        }
        return charAt(value, index + 1) == 'R' ? index + 2 : index + 1;
    }

    /**
     * Handles 'S' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.460 -0400", hash_original_method = "CF9437B3FC8CF6068DBA7C8A302960BB", hash_generated_method = "5BF7DB8F1A9668F142E9E771D94C268C")
    
private int handleS(String value, 
                        DoubleMetaphoneResult result, 
                        int index, 
                        boolean slavoGermanic) {
        if (contains(value, index - 1, 3, "ISL", "YSL")) {
            //-- special cases "island", "isle", "carlisle", "carlysle" --//
            index++;
        } else if (index == 0 && contains(value, index, 5, "SUGAR")) {
            //-- special case "sugar-" --//
            result.append('X', 'S');
            index++;
        } else if (contains(value, index, 2, "SH")) {
            if (contains(value, index + 1, 4, 
                         "HEIM", "HOEK", "HOLM", "HOLZ")) {
                //-- germanic --//
                result.append('S');
            } else {
                result.append('X');
            }
            index += 2;
        } else if (contains(value, index, 3, "SIO", "SIA") || contains(value, index, 4, "SIAN")) {
            //-- Italian and Armenian --//
            if (slavoGermanic) {
                result.append('S');
            } else {
                result.append('S', 'X');
            }
            index += 3;
        } else if ((index == 0 && contains(value, index + 1, 1, "M", "N", "L", "W")) || contains(value, index + 1, 1, "Z")) {
            //-- german & anglicisations, e.g. "smith" match "schmidt" //
            // "snider" match "schneider" --//
            //-- also, -sz- in slavic language altho in hungarian it //
            //   is pronounced "s" --//
            result.append('S', 'X');
            index = contains(value, index + 1, 1, "Z") ? index + 2 : index + 1;
        } else if (contains(value, index, 2, "SC")) {
            index = handleSC(value, result, index);
        } else {
            if (index == value.length() - 1 && contains(value, index - 2, 
                                                        2, "AI", "OI")){
                //-- french e.g. "resnais", "artois" --//
                result.appendAlternate('S');
            } else {
                result.append('S');
            }
            index = contains(value, index + 1, 1, "S", "Z") ? index + 2 : index + 1;
        }
        return index;
    }

    /**
     * Handles 'SC' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.461 -0400", hash_original_method = "D49BF75E5653B3A60DB1C3ABCF118E80", hash_generated_method = "C6A02D5F4B9BA9B3FA838ED2F4665239")
    
private int handleSC(String value, 
                         DoubleMetaphoneResult result, 
                         int index) {
        if (charAt(value, index + 2) == 'H') {
            //-- Schlesinger's rule --//
            if (contains(value, index + 3, 
                         2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                //-- Dutch origin, e.g. "school", "schooner" --//
                if (contains(value, index + 3, 2, "ER", "EN")) {
                    //-- "schermerhorn", "schenker" --//
                    result.append("X", "SK");
                } else {
                    result.append("SK");
                }
            } else {
                if (index == 0 && !isVowel(charAt(value, 3)) && charAt(value, 3) != 'W') {
                    result.append('X', 'S');
                } else {
                    result.append('X');
                }
            }
        } else if (contains(value, index + 2, 1, "I", "E", "Y")) {
            result.append('S');
        } else {
            result.append("SK");
        }
        return index + 3;
    }

    /**
     * Handles 'T' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.462 -0400", hash_original_method = "533E04489FE3E23B14310C8FB92F78C5", hash_generated_method = "6184B4AE3AB81180E1C693397BAC6510")
    
private int handleT(String value, 
                        DoubleMetaphoneResult result, 
                        int index) {
        if (contains(value, index, 4, "TION")) {
            result.append('X');
            index += 3;
        } else if (contains(value, index, 3, "TIA", "TCH")) {
            result.append('X');
            index += 3;
        } else if (contains(value, index, 2, "TH") || contains(value, index, 
                                                               3, "TTH")) {
            if (contains(value, index + 2, 2, "OM", "AM") || 
                //-- special case "thomas", "thames" or germanic --//
                contains(value, 0, 4, "VAN ", "VON ") || 
                contains(value, 0, 3, "SCH")) {
                result.append('T');
            } else {
                result.append('0', 'T');
            }
            index += 2;
        } else {
            result.append('T');
            index = contains(value, index + 1, 1, "T", "D") ? index + 2 : index + 1;
        }
        return index;
    }

    /**
     * Handles 'W' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.463 -0400", hash_original_method = "A0A4144F386BA40ADB58AED5A9A5F99C", hash_generated_method = "F9F86953701F49F2CA7D82380BD8925B")
    
private int handleW(String value, 
                        DoubleMetaphoneResult result, 
                        int index) {
        if (contains(value, index, 2, "WR")) {
            //-- can also be in middle of word --//
            result.append('R');
            index += 2;
        } else {
            if (index == 0 && (isVowel(charAt(value, index + 1)) || 
                               contains(value, index, 2, "WH"))) {
                if (isVowel(charAt(value, index + 1))) {
                    //-- Wasserman should match Vasserman --//
                    result.append('A', 'F');
                } else {
                    //-- need Uomo to match Womo --//
                    result.append('A');
                }
                index++;
            } else if ((index == value.length() - 1 && isVowel(charAt(value, index - 1))) ||
                       contains(value, index - 1, 
                                5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") ||
                       contains(value, 0, 3, "SCH")) {
                //-- Arnow should match Arnoff --//
                result.appendAlternate('F');
                index++;
            } else if (contains(value, index, 4, "WICZ", "WITZ")) {
                //-- Polish e.g. "filipowicz" --//
                result.append("TS", "FX");
                index += 4;
            } else {
                index++;
            }
        }
        return index;
    }
    
    /**
     * Handles 'X' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.464 -0400", hash_original_method = "31F26CED2D9DD4AAAFE52ACDE68992E7", hash_generated_method = "11FC7D3D554A594833AA979DB176E76F")
    
private int handleX(String value, 
                        DoubleMetaphoneResult result, 
                        int index) {
        if (index == 0) {
            result.append('S');
            index++;
        } else {
            if (!((index == value.length() - 1) && 
                  (contains(value, index - 3, 3, "IAU", "EAU") || 
                   contains(value, index - 2, 2, "AU", "OU")))) {
                //-- French e.g. breaux --//
                result.append("KS");
            }
            index = contains(value, index + 1, 1, "C", "X") ? index + 2 : index + 1;
        }
        return index;
    }

    /**
     * Handles 'Z' cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.465 -0400", hash_original_method = "2712ACBC7A57054D6E52521A90E499FB", hash_generated_method = "553812C8CEC629E544B2C792B826D7B1")
    
private int handleZ(String value, DoubleMetaphoneResult result, int index, 
                        boolean slavoGermanic) {
        if (charAt(value, index + 1) == 'H') {
            //-- Chinese pinyin e.g. "zhao" or Angelina "Zhang" --//
            result.append('J');
            index += 2;
        } else {
            if (contains(value, index + 1, 2, "ZO", "ZI", "ZA") || (slavoGermanic && (index > 0 && charAt(value, index - 1) != 'T'))) {
                result.append("S", "TS");
            } else {
                result.append('S');
            }
            index = charAt(value, index + 1) == 'Z' ? index + 2 : index + 1;
        }
        return index;
    }

    //-- BEGIN CONDITIONS --//

    /**
     * Complex condition 0 for 'C'
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.465 -0400", hash_original_method = "EF2EDFAE53FCE066020553E02BDC1BE8", hash_generated_method = "E5B5F7E1373A699D0EA764C472C5701A")
    
private boolean conditionC0(String value, int index) {
        if (contains(value, index, 4, "CHIA")) {
            return true;
        } else if (index <= 1) {
            return false;
        } else if (isVowel(charAt(value, index - 2))) {
            return false;
        } else if (!contains(value, index - 1, 3, "ACH")) {
            return false;
        } else {
            char c = charAt(value, index + 2);
            return (c != 'I' && c != 'E')
                    || contains(value, index - 2, 6, "BACHER", "MACHER");
        }
    }
    
    /**
     * Complex condition 0 for 'CH'
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.466 -0400", hash_original_method = "32C7A1E0157D2C9087EAC41BD14B15D7", hash_generated_method = "00FDB7FDFDC88CB2383D99F2E4B0637A")
    
private boolean conditionCH0(String value, int index) {
        if (index != 0) {
            return false;
        } else if (!contains(value, index + 1, 5, "HARAC", "HARIS") && 
                   !contains(value, index + 1, 3, "HOR", "HYM", "HIA", "HEM")) {
            return false;
        } else if (contains(value, 0, 5, "CHORE")) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Complex condition 1 for 'CH'
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.467 -0400", hash_original_method = "FE5F2D56D7E3E4B2BC0C9F62A9CCE451", hash_generated_method = "002098531688D57D20DFE7C9587694C6")
    
private boolean conditionCH1(String value, int index) {
        return ((contains(value, 0, 4, "VAN ", "VON ") || contains(value, 0, 
                                                                   3, "SCH")) ||
                contains(value, index - 2, 6, "ORCHES", "ARCHIT", "ORCHID") ||
                contains(value, index + 2, 1, "T", "S") ||
                ((contains(value, index - 1, 1, "A", "O", "U", "E") || index == 0) &&
                 (contains(value, index + 2, 1, L_R_N_M_B_H_F_V_W_SPACE) || index + 1 == value.length() - 1)));
    }
    
    /**
     * Complex condition 0 for 'L'
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.468 -0400", hash_original_method = "55A436B99F6C8E03AE20C8FD63456AB6", hash_generated_method = "D906860E1FD6CD0845567AF905A581BB")
    
private boolean conditionL0(String value, int index) {
        if (index == value.length() - 3 && 
            contains(value, index - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        } else if ((contains(value, index - 1, 2, "AS", "OS") || 
                    contains(value, value.length() - 1, 1, "A", "O")) &&
                   contains(value, index - 1, 4, "ALLE")) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Complex condition 0 for 'M'
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.469 -0400", hash_original_method = "F78E06F1002DF6D1BD2F5054F702D564", hash_generated_method = "AA5572773BF49D9A6D6CAEAEA25D4BD5")
    
private boolean conditionM0(String value, int index) {
        if (charAt(value, index + 1) == 'M') {
            return true;
        }
        return contains(value, index - 1, 3, "UMB")
                && ((index + 1) == value.length() - 1 || contains(value,
                        index + 2, 2, "ER"));
    }
    
    //-- BEGIN HELPER FUNCTIONS --//

    /**
     * Determines whether or not a value is of slavo-germanic orgin. A value is
     * of slavo-germanic origin if it contians any of 'W', 'K', 'CZ', or 'WITZ'.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.469 -0400", hash_original_method = "5BFD5B4026C9A4D9AF170A3840BAB7CB", hash_generated_method = "0D05602220E8516B679E14BEDF23478C")
    
private boolean isSlavoGermanic(String value) {
        return value.indexOf('W') > -1 || value.indexOf('K') > -1 || 
            value.indexOf("CZ") > -1 || value.indexOf("WITZ") > -1;
    }

    /**
     * Determines whether or not a character is a vowel or not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.470 -0400", hash_original_method = "85049635908343ACDAD200DDE16B4592", hash_generated_method = "2FD16A3C49F5C9E6773A5C4B53A454C2")
    
private boolean isVowel(char ch) {
        return VOWELS.indexOf(ch) != -1;
    }

    /**
     * Determines whether or not the value starts with a silent letter.  It will
     * return <code>true</code> if the value starts with any of 'GN', 'KN',
     * 'PN', 'WR' or 'PS'.
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.470 -0400", hash_original_method = "00066F2A5261D560420BAE8B5DB685BE", hash_generated_method = "0F0633676B8D14425F94FFB8C4B89BE8")
    
private boolean isSilentStart(String value) {
        boolean result = false;
        for (int i = 0; i < SILENT_START.length; i++) {
            if (value.startsWith(SILENT_START[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Cleans the input
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.471 -0400", hash_original_method = "2019F6006EC0A353E6A211B1629AD93C", hash_generated_method = "8D865895679905044613188400A70A29")
    
private String cleanInput(String input) {
        if (input == null) {
            return null;
        }
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }
        return input.toUpperCase();
    }

    /**
     * Gets the character at index <code>index</code> if available, otherwise
     * it returns <code>Character.MIN_VALUE</code> so that there is some sort
     * of a default
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.472 -0400", hash_original_method = "9E9ED07632B5920E5CCFE88A121F094F", hash_generated_method = "96A5A62E45DDD676388703727EBD56B1")
    
protected char charAt(String value, int index) {
        if (index < 0 || index >= value.length()) {
            return Character.MIN_VALUE;
        } 
        return value.charAt(index);
    }
    
    //-- BEGIN INNER CLASSES --//
    
    /**
     * Inner class for storing results, since there is the optional alternate
     * encoding.
     */
    public class DoubleMetaphoneResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.478 -0400", hash_original_field = "864B47F72FC1DD5F68D71EF82BD34E61", hash_generated_field = "35707E71784E4DE79699980D63ED3C14")


        private StringBuffer primary = new StringBuffer(getMaxCodeLen());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.479 -0400", hash_original_field = "87CD3FD5717A547642406EDA18EB01C1", hash_generated_field = "85CAF3CFD53B4437CCF668F8CA986D37")

        private StringBuffer alternate = new StringBuffer(getMaxCodeLen());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.479 -0400", hash_original_field = "68EDD71DC293957163FC69C97CA58CC7", hash_generated_field = "3F0EB136285F025BD7EDE3729449E350")

        private int maxLength;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.480 -0400", hash_original_method = "12EAA90C8971056C7C268BCC9FAEF092", hash_generated_method = "E6076E9313F176E8DE3C0B3D90AD4435")
        
public DoubleMetaphoneResult(int maxLength) {
            this.maxLength = maxLength;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.480 -0400", hash_original_method = "4C31083F88E8B0B6B8D9DC35FD8AF43C", hash_generated_method = "605CFF0447D0FEA0BD59D2C26DD00052")
        
public void append(char value) {
            appendPrimary(value);
            appendAlternate(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.481 -0400", hash_original_method = "47C37E531FCDA8AC5A973D0038BE1E54", hash_generated_method = "AC528F3E7760103F961301F041B5AC60")
        
public void append(char primary, char alternate) {
            appendPrimary(primary);
            appendAlternate(alternate);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.482 -0400", hash_original_method = "FC5A570A4B69336245BDE680C7F01816", hash_generated_method = "3A21AB0E24633365813DD159C9CE0BE1")
        
public void appendPrimary(char value) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(value);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.482 -0400", hash_original_method = "0D1F111907AB56B255883669A43C87B1", hash_generated_method = "BF88EC04C597B5A0C327D22D17A049EA")
        
public void appendAlternate(char value) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(value);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.483 -0400", hash_original_method = "B5A202ED74871276CD1B4E3E095E99F0", hash_generated_method = "AA7693577243E8BAC6126E4B5B1E123B")
        
public void append(String value) {
            appendPrimary(value);
            appendAlternate(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.483 -0400", hash_original_method = "505D93797D885347D9CB603D30F29323", hash_generated_method = "04787801650DCA56FAEEF4A4784FA32E")
        
public void append(String primary, String alternate) {
            appendPrimary(primary);
            appendAlternate(alternate);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.484 -0400", hash_original_method = "C8D576ED9B3901AA48DE833C96AACF73", hash_generated_method = "B677AC2EF3078BF416870D4EE33740B3")
        
public void appendPrimary(String value) {
            int addChars = this.maxLength - this.primary.length();
            if (value.length() <= addChars) {
                this.primary.append(value);
            } else {
                this.primary.append(value.substring(0, addChars));
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.484 -0400", hash_original_method = "A80BC44DC84C9993395638E61E6A0B97", hash_generated_method = "326E7338E93ACB42862386B6649C6B94")
        
public void appendAlternate(String value) {
            int addChars = this.maxLength - this.alternate.length();
            if (value.length() <= addChars) {
                this.alternate.append(value);
            } else {
                this.alternate.append(value.substring(0, addChars));
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.485 -0400", hash_original_method = "84EA37EE8F0E1912E8E020BE787078FB", hash_generated_method = "6521518E01167BEE4C8FDC78C44DC7C7")
        
public String getPrimary() {
            return this.primary.toString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.486 -0400", hash_original_method = "30E0A250E71CA2A72AD4B42D80BB662A", hash_generated_method = "7D5EC28B262761D52B878518C5E0B1D1")
        
public String getAlternate() {
            return this.alternate.toString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:49.486 -0400", hash_original_method = "A5A1424F1E327099914033747597CEF1", hash_generated_method = "F0F4930F4DBDEF11D884ABBF48217173")
        
public boolean isComplete() {
            return this.primary.length() >= this.maxLength && 
                this.alternate.length() >= this.maxLength;
        }
    }
}
