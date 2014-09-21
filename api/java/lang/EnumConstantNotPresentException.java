/* Licensed to the Apache Software Foundation (ASF) under one or more
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

package java.lang;

/**
 * Thrown if an {@code enum} constant does not exist for a particular name.
 *
 * @since 1.5
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class EnumConstantNotPresentException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.900 -0400", hash_original_field = "EB6D0DF30A82B8A48FEFB7C3597518BE", hash_generated_field = "D98B53C0EF076071B5312DD601371549")


    private static final long serialVersionUID = -6046998521960521108L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.902 -0400", hash_original_field = "688F04BC94726CBD95F5B03E2811651D", hash_generated_field = "4FC3E15BD5E7427451F4E2C5D0FB47F3")


    @SuppressWarnings("unchecked")
    private  Class<? extends Enum> enumType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.903 -0400", hash_original_field = "08943D3D18CF133B309ED149D94647A3", hash_generated_field = "AE51680CCBD65331D97B4693D1C3FECD")


    private  String constantName;

    /**
     * Constructs a new {@code EnumConstantNotPresentException} with the current
     * stack trace and a detail message based on the specified enum type and
     * missing constant name.
     *
     * @param enumType
     *            the enum type.
     * @param constantName
     *            the missing constant name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.904 -0400", hash_original_method = "93E52C49B58E57608E024A09EFB5393A", hash_generated_method = "7D00F8D3A951177AB5D8E5BF46AAF9DE")
    
@SuppressWarnings("unchecked")
    public EnumConstantNotPresentException(Class<? extends Enum> enumType, String constantName) {
        super("enum constant " + enumType.getName() + "." + constantName + " is missing");
        this.enumType = enumType;
        this.constantName = constantName;
    }

    /**
     * Gets the enum type for which the constant name is missing.
     *
     * @return the enum type for which a constant name has not been found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.906 -0400", hash_original_method = "993C51C687E08EF24896DA5A822225E0", hash_generated_method = "B586BECA4E62CE98E39B41CAF9DF7822")
    
@SuppressWarnings("unchecked")
    public Class<? extends Enum> enumType() {
        return enumType;
    }

    /**
     * Gets the name of the missing constant.
     *
     * @return the name of the constant that has not been found in the enum
     *         type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.907 -0400", hash_original_method = "4A3898E47508F62B3E9000B8E032EC41", hash_generated_method = "DD6B74641ACC3E1B71054A8389F6D123")
    
public String constantName() {
        return constantName;
    }
}
