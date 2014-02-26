/*
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net.nntp;

/***
 * NNTPCommand stores a set of constants for NNTP command codes.  To interpret
 * the meaning of the codes, familiarity with RFC 977 is assumed.
 * <p>
 * @author Daniel F. Savarese
 * @author Rory Winston
 * @author Ted Wise
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class NNTPCommand
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.478 -0500", hash_original_field = "A474724B8B3C726E87521EE3326CBD82", hash_generated_field = "9854E4A31446A4143DDCEE0BDA0C9803")


    public static final int ARTICLE   = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.481 -0500", hash_original_field = "2AA3C04303D7BAC1BF530F9505A1C354", hash_generated_field = "0916A2F9E3316E146E19E06877BE3716")

    public static final int BODY      = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.483 -0500", hash_original_field = "51523F875D831FDC9782F54DC1DEA0FF", hash_generated_field = "8E6E0B9D259875C4093766BCF5841D19")

    public static final int GROUP     = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.487 -0500", hash_original_field = "3C8DCDB31883EE283BD8EF6DB2BDCD15", hash_generated_field = "672759973EFB0D983374BF321814928A")

    public static final int HEAD      = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.490 -0500", hash_original_field = "73B320DBEE8EEB994920D383F2B7D923", hash_generated_field = "ABDD22B61D89B05F8F4AA0859F185903")

    public static final int HELP      = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.493 -0500", hash_original_field = "02311EEBA1D690BFF618A3582274D16B", hash_generated_field = "0C20C37D60F00B7D5D4957D605E094E4")

    public static final int IHAVE     = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.496 -0500", hash_original_field = "4F93A3D6182701C767C3D8B61BC093BE", hash_generated_field = "8DAAC8554B9E96A8C291B76AC25D48F3")

    public static final int LAST      = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.499 -0500", hash_original_field = "458F28152089B301ABD925E15FDC4418", hash_generated_field = "1A9E30F083996E826051764BF1814C0A")

    public static final int LIST      = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.502 -0500", hash_original_field = "B27AC33067FA1EC4DCE85AEA7B4C7778", hash_generated_field = "7493CC0584D9563555E03E2E09770C62")

    public static final int NEWGROUPS = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.505 -0500", hash_original_field = "479C201FBBB672E43CEB4D8E3B200434", hash_generated_field = "57B5F9F01141AA6B4084DB6A7FB895F1")

    public static final int NEWNEWS   = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.509 -0500", hash_original_field = "A7D7C7692620DF36C58A890C4414C51A", hash_generated_field = "1E5C6D85052A3110CA974B3DEFC983E7")

    public static final int NEXT      = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.512 -0500", hash_original_field = "CA38772EE42BFDF9B398835F5FC30DDE", hash_generated_field = "392ECE5C61973A4673EDD3DC0C891FC6")

    public static final int POST      = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.515 -0500", hash_original_field = "093FBCA9C7C46F4B971BEF2B96950CB8", hash_generated_field = "BB55D33FAE9E29A2B291863DD5A9C767")

    public static final int QUIT      = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.519 -0500", hash_original_field = "D84E5AB14AD1B2A9653CC2F73EDE38E1", hash_generated_field = "F56E802399783DE668300179E9993924")

    public static final int SLAVE     = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.522 -0500", hash_original_field = "FFC30F18308C08D4BC978F212F69B96C", hash_generated_field = "5D41E2D75309362DFD68503D5EEFAE1F")

    public static final int STAT      = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.525 -0500", hash_original_field = "DBCC26615FA72B0CFB12BC77EA2405F0", hash_generated_field = "03914F10356E09EB519FE618056E2ECF")

    public static final int AUTHINFO  = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.527 -0500", hash_original_field = "D3AF92CBF4D9E8B236B645DC49B6E332", hash_generated_field = "FF384E8BD97DB756A46BA497F71DC5B1")

    public static final int XOVER     = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.530 -0500", hash_original_field = "6A2079D90B17DC32D34F1C7E9EBBF7E9", hash_generated_field = "20CAA49FF864C21C7D6AF1BF373EF967")

    public static final int XHDR      = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.537 -0500", hash_original_field = "1DA1FDA7630D56F396835F10A54783C4", hash_generated_field = "7970895F62D6D64209247ACB7BC88A5A")


    static final String[] _commands = {
        "ARTICLE", "BODY", "GROUP", "HEAD", "HELP", "IHAVE", "LAST", "LIST",
        "NEWGROUPS", "NEWNEWS", "NEXT", "POST", "QUIT", "SLAVE", "STAT",
        "AUTHINFO", "XOVER", "XHDR"
    };


    /***
     * Retrieve the NNTP protocol command string corresponding to a specified
     * command code.
     * <p>
     * @param command The command code.
     * @return The NNTP protcol command string corresponding to a specified
     *         command code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.540 -0500", hash_original_method = "00EADAB9B7F650A465A01299B290A28E", hash_generated_method = "D266DA9BA95C2A211722ACB893ECDCA5")
    
public static final String getCommand(int command)
    {
        return _commands[command];
    }

    // Cannot be instantiated
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.534 -0500", hash_original_method = "C8D053290B1C889DDFB4046FB8856A18", hash_generated_method = "7EF2D1A4F13E969BB60E3FE9560C7D13")
    
private NNTPCommand()
    {}

}

/* Emacs configuration
 * Local variables:        **
 * mode:             java  **
 * c-basic-offset:   4     **
 * indent-tabs-mode: nil   **
 * End:                    **
 */
