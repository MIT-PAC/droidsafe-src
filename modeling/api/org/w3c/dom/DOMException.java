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
 * Copyright (c) 2004 World Wide Web Consortium,
 *
 * (Massachusetts Institute of Technology, European Research Consortium for
 * Informatics and Mathematics, Keio University). All Rights Reserved. This
 * work is distributed under the W3C(r) Software License [1] in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.w3c.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class DOMException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.393 -0500", hash_original_field = "C41FDF8F026FB2F107DD6D54FC92BDFB", hash_generated_field = "36783AE5F69C1CEDA2F6C43C9028DBBF")

    /**
     * If index or size is negative, or greater than the allowed value.
     */
    public static final short INDEX_SIZE_ERR            = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.396 -0500", hash_original_field = "57C075BF28649D41FFF01F7422DF79A5", hash_generated_field = "3D6F297A2B43744FF37BF31B6C7EC120")

    public static final short DOMSTRING_SIZE_ERR        = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.398 -0500", hash_original_field = "D613E0029C306120C500BAEC92C8DD19", hash_generated_field = "72E1BDD1917135729A2087F22C52544B")

    public static final short HIERARCHY_REQUEST_ERR     = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.400 -0500", hash_original_field = "A3A179A018B7BE25E3DA9656CCB1CB89", hash_generated_field = "DA44178BBE9462B7B5AB6772EFFE2C08")

    public static final short WRONG_DOCUMENT_ERR        = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.403 -0500", hash_original_field = "A46E7506F1FC37B291FAC8E3BB840677", hash_generated_field = "805486A980FBA93F673D7A276AA1A7EE")

    public static final short INVALID_CHARACTER_ERR     = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.406 -0500", hash_original_field = "C3C46492A1F0B152D57A3294CC5B1002", hash_generated_field = "170FEEB0666CD34719E74694BA75E81D")

    public static final short NO_DATA_ALLOWED_ERR       = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.408 -0500", hash_original_field = "3A8D392AB221BA476FA1009719D1B913", hash_generated_field = "973982CA2917A22A966A20AD088B1C09")

    public static final short NO_MODIFICATION_ALLOWED_ERR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.411 -0500", hash_original_field = "AC8385E46BDC830EE8EA2C93584C7906", hash_generated_field = "730B5D6777E7B9A774A72656EAF616CC")

    public static final short NOT_FOUND_ERR             = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.413 -0500", hash_original_field = "013CA150CAE8EB28E94CB21FC3B7BECB", hash_generated_field = "8989E69EBF8D6238CFC6296AF0DF2B4D")

    public static final short NOT_SUPPORTED_ERR         = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.415 -0500", hash_original_field = "A80914EBAB18CAF58D3E62E00C86C6DD", hash_generated_field = "DA038D207206C798D80C9B363424AE9E")

    public static final short INUSE_ATTRIBUTE_ERR       = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.418 -0500", hash_original_field = "9FA6E1E48E08EAF3246C4B3B4E675D3A", hash_generated_field = "1A5F7AD9042CDA9D782BB551172B8D84")

    public static final short INVALID_STATE_ERR         = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.420 -0500", hash_original_field = "C5CD45F5A21DFEEBD0FB965BB5339D80", hash_generated_field = "D912D179B57CCD669AD836CBB1F4BDCA")

    public static final short SYNTAX_ERR                = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.423 -0500", hash_original_field = "4F97D760585813C7F1B488B8362C557B", hash_generated_field = "8DBD09678B3B6D6C756910B90AEA9402")

    public static final short INVALID_MODIFICATION_ERR  = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.425 -0500", hash_original_field = "22DDBED661D2089968F62FDF5BC2D117", hash_generated_field = "6FD5A9FD4914965940037196C9AEC3BA")

    public static final short NAMESPACE_ERR             = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.428 -0500", hash_original_field = "C56887935437AD90C24ED30EC8061AA3", hash_generated_field = "0B93A7653B41AE8C961FFA5C9611C848")

    public static final short INVALID_ACCESS_ERR        = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.430 -0500", hash_original_field = "E008319E50515D89BC3D791792008BF5", hash_generated_field = "379AD170D52C4CAEDDE41321EB27BD66")

    public static final short VALIDATION_ERR            = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.433 -0500", hash_original_field = "691D646778D91720CBA90F3F6A7F6734", hash_generated_field = "BEBAC5E1BFC1F09667C1415091497B1D")

    public static final short TYPE_MISMATCH_ERR         = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.391 -0500", hash_original_field = "DC8CBBDCB744149D89EF8867D4FED5DB", hash_generated_field = "5E518509D078CBA65D8E1C88B69CC66E")

    public short   code;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.389 -0500", hash_original_method = "0AC2D186CABB78D2BA6332ECA7EA8409", hash_generated_method = "361C077B3AD41B759F10727D57395071")
    
public DOMException(short code, String message) {
       super(message);
       this.code = code;
    }
}

