/*
 * Copyright 2003-2004 The Apache Software Foundation
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
package org.apache.commons.net.telnet;

/***
 * The InvalidTelnetOptionException is the exception that is
 * thrown whenever a TelnetOptionHandler with an invlaid
 * option code is registered in TelnetClient with addOptionHandler.
 * <p>
 * @author Bruno D'Avanzo
 ***/
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class InvalidTelnetOptionException extends Exception
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.515 -0500", hash_original_field = "5274FE04EC28C0D01E1ABB2375F518DE", hash_generated_field = "E2BC2A2A9ADF0E2BAAE3223EBE6ACB3D")

    private int optionCode = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.519 -0500", hash_original_field = "8F9D2A2F9E449E55A75F4B9B664450FC", hash_generated_field = "09FF12C94050A1ACB3D33B33519AB971")

    private String msg;

    /***
     * Constructor for the exception.
     * <p>
     * @param message - Error message.
     * @param optcode - Option code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.523 -0500", hash_original_method = "D21884EAA3E7C47673E401CE1EB4EEBF", hash_generated_method = "8FA5A08B49E59C6FF21DE7B76E855103")
    
public InvalidTelnetOptionException(String message, int optcode)
    {
        optionCode = optcode;
        msg = message;
    }

    /***
     * Gets the error message of ths exception.
     * <p>
     * @return the error message.
     ***/
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.526 -0500", hash_original_method = "EC945BD8DBF6D007F334F84E157227FF", hash_generated_method = "1C31859E0B69A33E9B2D4801D7209242")
    
public String getMessage()
    {
        return (msg + ": " + optionCode);
    }
}
