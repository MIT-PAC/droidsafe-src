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
* @author Alexander Y. Kleymenov
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class GeneralNames {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.352 -0400", hash_original_field = "F9F6263E38C505EB7173C59BEEA7DE3D", hash_generated_field = "D64C2D3B9F619417B7A91D4BDC12D942")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralName.ASN1) {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.595 -0500", hash_original_method = "9A3FA9B8D9477389BCCE5A60E545BDE1", hash_generated_method = "770532B7223B3B4CD51BAFFFD97304EC")
        
@Override public Object getDecodedObject(BerInputStream in) {
            return new GeneralNames((List<GeneralName>) in.content, in.getEncoded());
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.597 -0500", hash_original_method = "0E3B702024D2ADCD7756F36AE80C73BB", hash_generated_method = "534AF2DE55B88D3C0C66F15FB7D37CBA")
        
@Override public Collection getValues(Object object) {
            GeneralNames gns = (GeneralNames) object;
            return gns.generalNames;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.570 -0500", hash_original_field = "D11E37AFF2CB9F1C8ABEE86455776935", hash_generated_field = "12F5E55FAE92B8BE0DECC643C9318F42")

    private List<GeneralName> generalNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.573 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.575 -0500", hash_original_method = "900922C5A2333ABDC3D6DB9D2843B6C9", hash_generated_method = "8EEE6CC0CA35A8F9FFE56BB73F14D846")
    
public GeneralNames() {
        generalNames = new ArrayList<GeneralName>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.578 -0500", hash_original_method = "FCF1D75BDAE857F225708496A2E96EC2", hash_generated_method = "D51F6A440EFDE24067D922B5F190BB73")
    
public GeneralNames(List<GeneralName> generalNames) {
        this.generalNames = generalNames;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.580 -0500", hash_original_method = "84AB2B2BC22C66DEEE9A4059D9B177CB", hash_generated_method = "ECA719710CD81A8E3929815AEFB0A021")
    
private GeneralNames(List<GeneralName> generalNames, byte[] encoding) {
        this.generalNames = generalNames;
        this.encoding = encoding;
    }

    /**
     * Returns the list of values.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.582 -0500", hash_original_method = "0BE5F893124FC75916B0920319238607", hash_generated_method = "E469072D7EA24D4FA1AB52D8E4E1E3D7")
    
public List<GeneralName> getNames() {
        if ((generalNames == null) || (generalNames.size() == 0)) {
            return null;
        }
        return new ArrayList<GeneralName>(generalNames);
    }

    /**
     * Returns the collection of pairs: (Integer (tag), Object (name value))*
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.585 -0500", hash_original_method = "393D0968412D8AD2DE170EB074DB113A", hash_generated_method = "5703127E086E9DCCAAFA514DF4493212")
    
public Collection<List<?>> getPairsList() {
        Collection<List<?>> result = new ArrayList<List<?>>();
        if (generalNames == null) {
            return result;
        }
        for (GeneralName generalName : generalNames) {
            result.add(generalName.getAsList());
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.587 -0500", hash_original_method = "62FCFAA5CD61EB40B84DD9F5E8E0A72D", hash_generated_method = "9241BD32EED8C77306D8A2F54017C15D")
    
public void addName(GeneralName name) {
        encoding = null;
        if (generalNames == null) {
            generalNames = new ArrayList<GeneralName>();
        }
        generalNames.add(name);
    }

    /**
     * Returns ASN.1 encoded form of this X.509 GeneralNames value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.589 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.592 -0500", hash_original_method = "78509CF3CFA7027FFCDFED35C29E300D", hash_generated_method = "0A5AD2537BB87CDDF04EE1FD30A033B2")
    
public void dumpValue(StringBuilder sb, String prefix) {
        if (generalNames == null) {
            return;
        }
        for (GeneralName generalName : generalNames) {
            sb.append(prefix);
            sb.append(generalName);
            sb.append('\n');
        }
    }
}

