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
 * Encodes a string into a metaphone value. 
 * <p>
 * Initial Java implementation by <CITE>William B. Brogden. December, 1997</CITE>. 
 * Permission given by <CITE>wbrogden</CITE> for code to be used anywhere.
 * </p>
 * <p>
 * <CITE>Hanging on the Metaphone</CITE> by <CITE>Lawrence Philips</CITE> in <CITE>Computer Language of Dec. 1990, p
 * 39.</CITE>
 * </p>
 * 
 * @author Apache Software Foundation
 * @version $Id: Metaphone.java,v 1.20 2004/06/05 18:32:04 ggregory Exp $
 */
public class Metaphone implements StringEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.600 -0400", hash_original_field = "75AB2F591AB968183C6BD92BA4D18429", hash_generated_field = "D20A8273824971801415D0B391FFF911")

    private String vowels = "AEIOU" ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.601 -0400", hash_original_field = "728B7CFCCEF12D8DA895D5C6BDBCDA7F", hash_generated_field = "F27697D8BDBAF65CA06A717C7FB95E3A")

    private String frontv = "EIY"   ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.602 -0400", hash_original_field = "42670C2C7C2E1F7C615E77A70A00AA33", hash_generated_field = "864700EC13F852832C1211A1B9F94940")

    private String varson = "CSPTG" ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.602 -0400", hash_original_field = "360BE26A77BBC184847F9125BDBB2937", hash_generated_field = "13BE94B5F2BC6C04BD74FD2912A38DCD")

    private int maxCodeLen = 4 ;

    /**
     * Creates an instance of the Metaphone encoder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.603 -0400", hash_original_method = "3877B4E9D2F66FA2C87BEEF6C5069074", hash_generated_method = "0D1E682E4447FE2C708D85E7CAD83E18")
    
public Metaphone() {
        super();
    }

    /**
     * Find the metaphone value of a String. This is similar to the
     * soundex algorithm, but better at finding similar sounding words.
     * All input is converted to upper case.
     * Limitations: Input format is expected to be a single ASCII word
     * with only characters in the A - Z range, no punctuation or numbers.
     *
     * @param txt String to find the metaphone code for
     * @return A metaphone code corresponding to the String supplied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.606 -0400", hash_original_method = "57BF6134D4D06867A32AED7093522EF0", hash_generated_method = "4923CB1035D8F90EFB179A95E61D22AE")
    
public String metaphone(String txt) {
        boolean hard = false ;
        if ((txt == null) || (txt.length() == 0)) {
            return "" ;
        }
        // single character is itself
        if (txt.length() == 1) {
            return txt.toUpperCase() ;
        }
      
        char[] inwd = txt.toUpperCase().toCharArray() ;
      
        StringBuffer local = new StringBuffer(40); // manipulate
        StringBuffer code = new StringBuffer(10) ; //   output
        // handle initial 2 characters exceptions
        switch(inwd[0]) {
        case 'K' : 
        case 'G' : 
        case 'P' : /* looking for KN, etc*/
            if (inwd[1] == 'N') {
                local.append(inwd, 1, inwd.length - 1);
            } else {
                local.append(inwd);
            }
            break;
        case 'A': /* looking for AE */
            if (inwd[1] == 'E') {
                local.append(inwd, 1, inwd.length - 1);
            } else {
                local.append(inwd);
            }
            break;
        case 'W' : /* looking for WR or WH */
            if (inwd[1] == 'R') {   // WR -> R
                local.append(inwd, 1, inwd.length - 1); 
                break ;
            }
            if (inwd[1] == 'H') {
                local.append(inwd, 1, inwd.length - 1);
                local.setCharAt(0, 'W'); // WH -> W
            } else {
                local.append(inwd);
            }
            break;
        case 'X' : /* initial X becomes S */
            inwd[0] = 'S';
            local.append(inwd);
            break ;
        default :
            local.append(inwd);
        } // now local has working string with initials fixed

        int wdsz = local.length();
        int n = 0 ;

        while ((code.length() < this.getMaxCodeLen()) && 
               (n < wdsz) ) { // max code size of 4 works well
            char symb = local.charAt(n) ;
            // remove duplicate letters except C
            if ((symb != 'C') && (isPreviousChar( local, n, symb )) ) {
                n++ ;
            } else { // not dup
                switch(symb) {
                case 'A' : case 'E' : case 'I' : case 'O' : case 'U' :
                    if (n == 0) { 
                        code.append(symb);
                    }
                    break ; // only use vowel if leading char
                case 'B' :
                    if ( isPreviousChar(local, n, 'M') && 
                         isLastChar(wdsz, n) ) { // B is silent if word ends in MB
                        break;
                    }
                    code.append(symb);
                    break;
                case 'C' : // lots of C special cases
                    /* discard if SCI, SCE or SCY */
                    if ( isPreviousChar(local, n, 'S') && 
                         !isLastChar(wdsz, n) && 
                         (this.frontv.indexOf(local.charAt(n + 1)) >= 0) ) { 
                        break;
                    }
                    if (regionMatch(local, n, "CIA")) { // "CIA" -> X
                        code.append('X'); 
                        break;
                    }
                    if (!isLastChar(wdsz, n) && 
                        (this.frontv.indexOf(local.charAt(n + 1)) >= 0)) {
                        code.append('S');
                        break; // CI,CE,CY -> S
                    }
                    if (isPreviousChar(local, n, 'S') &&
                        isNextChar(local, n, 'H') ) { // SCH->sk
                        code.append('K') ; 
                        break ;
                    }
                    if (isNextChar(local, n, 'H')) { // detect CH
                        if ((n == 0) && 
                            (wdsz >= 3) && 
                            isVowel(local,2) ) { // CH consonant -> K consonant
                            code.append('K');
                        } else { 
                            code.append('X'); // CHvowel -> X
                        }
                    } else { 
                        code.append('K');
                    }
                    break ;
                case 'D' :
                    if (!isLastChar(wdsz, n + 1) && 
                        isNextChar(local, n, 'G') && 
                        (this.frontv.indexOf(local.charAt(n + 2)) >= 0)) { // DGE DGI DGY -> J 
                        code.append('J'); n += 2 ;
                    } else { 
                        code.append('T');
                    }
                    break ;
                case 'G' : // GH silent at end or before consonant
                    if (isLastChar(wdsz, n + 1) && 
                        isNextChar(local, n, 'H')) {
                        break;
                    }
                    if (!isLastChar(wdsz, n + 1) &&  
                        isNextChar(local,n,'H') && 
                        !isVowel(local,n+2)) {
                        break;
                    }
                    if ((n > 0) && 
                        ( regionMatch(local, n, "GN") ||
                          regionMatch(local, n, "GNED") ) ) {
                        break; // silent G
                    }
                    if (isPreviousChar(local, n, 'G')) {
                        hard = true ;
                    } else {
                        hard = false ;
                    }
                    if (!isLastChar(wdsz, n) && 
                        (this.frontv.indexOf(local.charAt(n + 1)) >= 0) && 
                        (!hard)) {
                        code.append('J');
                    } else {
                        code.append('K');
                    }
                    break ;
                case 'H':
                    if (isLastChar(wdsz, n)) {
                        break ; // terminal H
                    }
                    if ((n > 0) && 
                        (this.varson.indexOf(local.charAt(n - 1)) >= 0)) {
                        break;
                    }
                    if (isVowel(local,n+1)) {
                        code.append('H'); // Hvowel
                    }
                    break;
                case 'F': 
                case 'J' : 
                case 'L' :
                case 'M': 
                case 'N' : 
                case 'R' :
                    code.append(symb); 
                    break;
                case 'K' :
                    if (n > 0) { // not initial
                        if (!isPreviousChar(local, n, 'C')) {
                            code.append(symb);
                        }
                    } else {
                        code.append(symb); // initial K
                    }
                    break ;
                case 'P' :
                    if (isNextChar(local,n,'H')) {
                        // PH -> F
                        code.append('F');
                    } else {
                        code.append(symb);
                    }
                    break ;
                case 'Q' :
                    code.append('K');
                    break;
                case 'S' :
                    if (regionMatch(local,n,"SH") || 
                        regionMatch(local,n,"SIO") || 
                        regionMatch(local,n,"SIA")) {
                        code.append('X');
                    } else {
                        code.append('S');
                    }
                    break;
                case 'T' :
                    if (regionMatch(local,n,"TIA") || 
                        regionMatch(local,n,"TIO")) {
                        code.append('X'); 
                        break;
                    }
                    if (regionMatch(local,n,"TCH")) {
                        // Silent if in "TCH"
                        break;
                    }
                    // substitute numeral 0 for TH (resembles theta after all)
                    if (regionMatch(local,n,"TH")) {
                        code.append('0');
                    } else {
                        code.append('T');
                    }
                    break ;
                case 'V' :
                    code.append('F'); break ;
                case 'W' : case 'Y' : // silent if not followed by vowel
                    if (!isLastChar(wdsz,n) && 
                        isVowel(local,n+1)) {
                        code.append(symb);
                    }
                    break ;
                case 'X' :
                    code.append('K'); code.append('S');
                    break ;
                case 'Z' :
                    code.append('S'); break ;
                } // end switch
                n++ ;
            } // end else from symb != 'C'
            if (code.length() > this.getMaxCodeLen()) { 
                code.setLength(this.getMaxCodeLen()); 
            }
        }
        return code.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.607 -0400", hash_original_method = "D59FA4C7F5D01DDDC5EBB1C4FCCA0776", hash_generated_method = "3DD3844A34DD6B8CF879E684A1ABAD57")
    
private boolean isVowel(StringBuffer string, int index) {
        return (this.vowels.indexOf(string.charAt(index)) >= 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.608 -0400", hash_original_method = "F02DC4BC9B06E67829BA7691BB41D721", hash_generated_method = "0D5A7A8245A821E090CAB97EC66023F7")
    
private boolean isPreviousChar(StringBuffer string, int index, char c) {
        boolean matches = false;
        if( index > 0 &&
            index < string.length() ) {
            matches = string.charAt(index - 1) == c;
        }
        return matches;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.608 -0400", hash_original_method = "39F7617B6C60287DCA0FB524E47AFBCF", hash_generated_method = "629071331AB8DF1A806ED271E49B5F06")
    
private boolean isNextChar(StringBuffer string, int index, char c) {
        boolean matches = false;
        if( index >= 0 &&
            index < string.length() - 1 ) {
            matches = string.charAt(index + 1) == c;
        }
        return matches;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.609 -0400", hash_original_method = "399DF9ADC6FA3E1BD5AD471979BD854D", hash_generated_method = "7E842BDAE19156520DF2B18EF26558F3")
    
private boolean regionMatch(StringBuffer string, int index, String test) {
        boolean matches = false;
        if( index >= 0 &&
            (index + test.length() - 1) < string.length() ) {
            String substring = string.substring( index, index + test.length());
            matches = substring.equals( test );
        }
        return matches;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.609 -0400", hash_original_method = "B4C684A093C1768E810473F162E48AEB", hash_generated_method = "B73B0806A88DA5502D3566161E4EC3E2")
    
private boolean isLastChar(int wdsz, int n) {
        return n + 1 == wdsz;
    } 
    
    
    /**
     * Encodes an Object using the metaphone algorithm.  This method
     * is provided in order to satisfy the requirements of the
     * Encoder interface, and will throw an EncoderException if the
     * supplied object is not of type java.lang.String.
     *
     * @param pObject Object to encode
     * @return An object (or type java.lang.String) containing the 
     *         metaphone code which corresponds to the String supplied.
     * @throws EncoderException if the parameter supplied is not
     *                          of type java.lang.String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.610 -0400", hash_original_method = "DA2404118756C5E107F531236F3C42F9", hash_generated_method = "E159A881BEDBC861743A51EDFAAB580D")
    
public Object encode(Object pObject) throws EncoderException {
        if (!(pObject instanceof java.lang.String)) {
            throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String"); 
        }
        return metaphone((String) pObject);
    }

    /**
     * Encodes a String using the Metaphone algorithm. 
     *
     * @param pString String object to encode
     * @return The metaphone code corresponding to the String supplied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.610 -0400", hash_original_method = "C3B221668AABDAC9CAE97BC7412E7D54", hash_generated_method = "C41E2660B0005382FF35D955F45A8276")
    
public String encode(String pString) {
        return metaphone(pString);   
    }

    /**
     * Tests is the metaphones of two strings are identical.
     *
     * @param str1 First of two strings to compare
     * @param str2 Second of two strings to compare
     * @return true if the metaphones of these strings are identical, 
     *         false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.611 -0400", hash_original_method = "FF710532FC595330817EE7B661608830", hash_generated_method = "F90EC418E7B5B3D57E55F7AE559DF9EC")
    
public boolean isMetaphoneEqual(String str1, String str2) {
        return metaphone(str1).equals(metaphone(str2));
    }

    /**
     * Returns the maxCodeLen.
     * @return int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.611 -0400", hash_original_method = "53FC9A6F30C18D9412BF76DFC3D2F433", hash_generated_method = "92BD6472A9D4C03F7DAF13D471BE969A")
    
public int getMaxCodeLen() { return this.maxCodeLen; }

    /**
     * Sets the maxCodeLen.
     * @param maxCodeLen The maxCodeLen to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.612 -0400", hash_original_method = "E18ED09E55EC88E198B808F02955AF0A", hash_generated_method = "A360454A3426CC9DD47B4968BE2FCAA3")
    
public void setMaxCodeLen(int maxCodeLen) { this.maxCodeLen = maxCodeLen; }

}
