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
* Conditions Of Use
*
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
*
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
*
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*
* .
*
*/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;

public class RSeq extends SIPHeader implements javax.sip.header.RSeqHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.446 -0500", hash_original_field = "F8EF62319DC7554669434938D4737539", hash_generated_field = "0CC6639306B4D0AC114368BCCC7354B6")

    private static final long serialVersionUID = 8765762413224043394L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.449 -0500", hash_original_field = "581F60A6D443ADFC2ED9EAB5D0FA287B", hash_generated_field = "C1658771442CAEB41DDFE88E4F8049F6")

    protected long sequenceNumber;

    /** Creates a new instance of RSeq */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.452 -0500", hash_original_method = "1AAF86792C53F220850630A2C399A377", hash_generated_method = "F23EB0EE2ABF189E0964015CD69CAB2F")
    
public RSeq() {
        super(NAME);
    }

    /** Gets the sequence number of this RSeqHeader.
     * @deprecated
     * @return the integer value of the Sequence number of the RSeqHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.455 -0500", hash_original_method = "39133A5DFA90BF891F6ADEE458981A87", hash_generated_method = "6D320E3A7100F3252D23482EE5ACC465")
    
public int getSequenceNumber() {
        return (int)this.sequenceNumber;
    }

    /** Encode the body of this header (the stuff that follows headerName).
     * A.K.A headerValue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.458 -0500", hash_original_method = "5D7C81BCBFD28CA691320147DF9DB2DE", hash_generated_method = "19013A4DCE29E261487A5DF1011BDA8C")
    
protected String encodeBody() {
        return Long.toString(this.sequenceNumber);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.460 -0500", hash_original_method = "5EE204E642716446A9A561BAE9DA4271", hash_generated_method = "66986177B84CDF6993C8F18A16AD5904")
    
public long getSeqNumber() {
        return this.sequenceNumber;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.463 -0500", hash_original_method = "479EDE29655FEADB0A6AC8DE2CF03B87", hash_generated_method = "00666C39E172A3D5D6A53F4B5FDB71D9")
    
public void setSeqNumber(long sequenceNumber) throws InvalidArgumentException {

            if (sequenceNumber <= 0 ||sequenceNumber > ((long)1)<<32 - 1)
                throw new InvalidArgumentException(
                    "Bad seq number " + sequenceNumber);
            this.sequenceNumber = sequenceNumber;

    }

    /**
     * @deprecated
     * @see javax.sip.header.RSeqHeader#setSequenceNumber(int)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.466 -0500", hash_original_method = "34CCD2A626C0B5A84694D440C0C4B269", hash_generated_method = "066CDF009BA94F3DCA7BF90AE5E40E39")
    
public void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException {
        this.setSeqNumber(sequenceNumber);

    }
}

