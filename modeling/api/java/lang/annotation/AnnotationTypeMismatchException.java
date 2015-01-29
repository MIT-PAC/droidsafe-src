/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package java.lang.annotation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.lang.reflect.Method;

/**
 * Indicates that an annotation type has changed since it was compiled or
 * serialized.
 *
 * @since 1.5
 */
public class AnnotationTypeMismatchException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.404 -0400", hash_original_field = "694708298AE431B2B0F691803C2FA8C9", hash_generated_field = "B5E89DEE6EC53F6ACD32C9B11A8FB3D1")


    private static final long serialVersionUID = 8125925355765570191L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.405 -0400", hash_original_field = "BFFBD2FEC285C69AB9467587AF27B556", hash_generated_field = "0C001F9CC5AB0E1461C22F10F38F8507")


    private Method element;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.407 -0400", hash_original_field = "0B107619D3B0054DC724B25DA07A5AF6", hash_generated_field = "85AFB65E91DFA42F21D02A08A2618646")


    private String foundType;

    /**
     * Constructs an instance for the given type element and the type found.
     *
     * @param element
     *            the annotation type element.
     * @param foundType
     *            the invalid type that was found. This is actually the textual
     *            type description found in the binary class representation,
     *            so it may not be human-readable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.408 -0400", hash_original_method = "FC36FCA077BB9356BFDFCA10D99D0311", hash_generated_method = "2430FCC224E47ADC0C94FB89530AAC4A")
    
public AnnotationTypeMismatchException(Method element, String foundType) {
        super("The annotation element " + element + " doesn't match the type " + foundType);
        this.element = element;
        this.foundType = foundType;
    }

    /**
     * Returns the method object for the invalid type.
     *
     * @return a {@link Method} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.410 -0400", hash_original_method = "25736550470809040A3F8C62976339C4", hash_generated_method = "B61E8F76A04C239FB09D418D5B87F38F")
    
public Method element() {
        return element;
    }

    /**
     * Returns the invalid type.
     *
     * @return a string describing the invalid data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.411 -0400", hash_original_method = "2D3ED0AC0F4C47315DD1BD37872C7540", hash_generated_method = "BADAA8FB9076D2DB6C31FE605FEA6DCD")
    
public String foundType() {
        return foundType;
    }
}
