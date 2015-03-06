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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang.annotation;

/**
 * Indicates that an element of an annotation type was accessed that was added
 * after the type was compiled or serialized. This does not apply to new
 * elements that have default values.
 *
 * @since 1.5
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class IncompleteAnnotationException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.428 -0400", hash_original_field = "5E0E069B0F725185EFB7DA8FDF6E954A", hash_generated_field = "80DF1626B93164CB19A87E929F38C2B3")


    private static final long serialVersionUID = 8445097402741811912L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.430 -0400", hash_original_field = "574967FBA371163F854BF7CBCC00F002", hash_generated_field = "F880D2D321024CA083B090A9C057619D")


    private Class<? extends Annotation> annotationType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.431 -0400", hash_original_field = "32A46A319D532FEC6A665AD742892132", hash_generated_field = "823E28064230D111694A76E34EB1FCE1")


    private String elementName;

    /**
     * Constructs an instance with the incomplete annotation type and the name
     * of the element that's missing.
     *
     * @param annotationType
     *            the annotation type.
     * @param elementName
     *            the name of the incomplete element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.432 -0400", hash_original_method = "C2DBF2F05269C3235ED08EC2AAEDCD8A", hash_generated_method = "82070A00A9CAC5312612B9A67E320357")
    
public IncompleteAnnotationException(Class<? extends Annotation> annotationType,
            String elementName) {
        super("The element " + elementName + " is not complete for the annotation " +
                annotationType.getName());
        this.annotationType = annotationType;
        this.elementName = elementName;
    }

    /**
     * Returns the annotation type.
     *
     * @return a Class instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.433 -0400", hash_original_method = "E817E461C2316DA2BC33C7CEFBA0F603", hash_generated_method = "26E83CF656A96DD8E03F021807EDF6B7")
    
public Class<? extends Annotation> annotationType() {
        return annotationType;
    }

    /**
     * Returns the incomplete element's name.
     *
     * @return the name of the element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.434 -0400", hash_original_method = "3F9946A3B8CB859CAD61D926A54058B5", hash_generated_method = "E0C08CE6E8094F170C18AF003389C993")
    
public String elementName() {
        return elementName;
    }
}
