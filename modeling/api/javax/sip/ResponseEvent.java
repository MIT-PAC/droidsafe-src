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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;

import javax.sip.message.Response;

public class ResponseEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.132 -0500", hash_original_field = "0C87BCBAF0D95855709E5BEE2BDBA46D", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.134 -0500", hash_original_field = "2C5E80C481A3FC0A353BB24E978FA586", hash_generated_field = "357A96A988CEB8869E67EAB0CC1CA73C")

    private Response mResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.136 -0500", hash_original_field = "1070B773CE6DA8864E09299E049FADCE", hash_generated_field = "A2FE03B3287159BF06762C26E990AE5E")

    private ClientTransaction mClientTransaction;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.139 -0500", hash_original_method = "F99FD2C7A85B9DCBE0AD9A9C8BE9081F", hash_generated_method = "79F2149217A290A902CF4A34FB4DF48B")
    
public ResponseEvent(Object source, ClientTransaction clientTransaction,
            Dialog dialog, Response response) {
        super(source);
        mDialog = dialog;
        mResponse = response;
        mClientTransaction = clientTransaction;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.141 -0500", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "C71E5AB7F1A8C6EFC64CAA7F76F42BA5")
    
public Dialog getDialog() {
        return mDialog;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.143 -0500", hash_original_method = "00292A90D159CA5BE7BB594CFFCF61C9", hash_generated_method = "A01E97A361AA1C9AE35D701EE381576E")
    
public Response getResponse() {
        return mResponse;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.145 -0500", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "81AF1418326903D133D5A72B4179C35F")
    
public ClientTransaction getClientTransaction(){
        return mClientTransaction;
    }
    
}

