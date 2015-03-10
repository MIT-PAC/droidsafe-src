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
 * Copyright (C) 2008 The Android Open Source Project
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


package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class Predicates {
    
    public static <T> Predicate<T> and(Predicate<? super T>... components) {
        return and(Arrays.asList(components));
    }
    
    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> components) {
        return new AndPredicate(components);
    }
    
    public static <T> Predicate<T> or(Predicate<? super T>... components) {
        return or(Arrays.asList(components));
    }
    
    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> components) {
        return new OrPredicate(components);
    }
    
    public static <T> Predicate<T> not(Predicate<? super T> predicate) {
        return new NotPredicate<T>(predicate);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.813 -0500", hash_original_method = "8D570740569D5E9289A65558AD01F51B", hash_generated_method = "BAFFB33D4DEC340B65D746DF76E462CE")
    
private Predicates() {
    }
    
    private static class AndPredicate<T> implements Predicate<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.828 -0500", hash_original_field = "2D7BCA6A49180D21641A6C27CEFDAAD6", hash_generated_field = "0796151CBA0A8A363E453698674B2FF1")

        private  Iterable<? extends Predicate<? super T>> components;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.831 -0500", hash_original_method = "9C4B289345C7238C0EC3F315CFBA2A0C", hash_generated_method = "E3CFF2EEABB2A73F340AEF3FE1A9780E")
        
private AndPredicate(Iterable<? extends Predicate<? super T>> components) {
            this.components = components;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.838 -0500", hash_original_method = "6D31A308B444A1244C8D9BB7EDA35AF5", hash_generated_method = "84C4D444D90A3DB70B997705B2F9A6A2")
        
public boolean apply(T t) {
            for (Predicate<? super T> predicate : components) {
                if (!predicate.apply(t)) {
                    return false;
                }
            }
            return true;
        }
        
    }
    
    private static class OrPredicate<T> implements Predicate<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.843 -0500", hash_original_field = "2D7BCA6A49180D21641A6C27CEFDAAD6", hash_generated_field = "0796151CBA0A8A363E453698674B2FF1")

        private  Iterable<? extends Predicate<? super T>> components;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.846 -0500", hash_original_method = "B6491EF17EA70E2615FEA24AC54E8597", hash_generated_method = "531D0A79E9975B9984D08CE6545E6553")
        
private OrPredicate(Iterable<? extends Predicate<? super T>> components) {
            this.components = components;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.848 -0500", hash_original_method = "C50E50ECDBC0F3F3FDB7CDFDDA2299C7", hash_generated_method = "04EE760A52E396E9F2F1047143C73303")
        
public boolean apply(T t) {
            for (Predicate<? super T> predicate : components) {
                if (predicate.apply(t)) {
                    return true;
                }
            }
            return false;
        }
        
    }
    
    private static class NotPredicate<T> implements Predicate<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.853 -0500", hash_original_field = "6EAE66C7ACCB91F69508E701685F652C", hash_generated_field = "1F2E335622F7CC2AFE3755D1E7E5B593")

        private  Predicate<? super T> predicate;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.856 -0500", hash_original_method = "1580F792FEAB20E5896374554CF174B0", hash_generated_method = "4D23B2657E1E27CAFFC4256DF7543465")
        
private NotPredicate(Predicate<? super T> predicate) {
            this.predicate = predicate;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.858 -0500", hash_original_method = "03E08BFAE053695EB823C16C309BB346", hash_generated_method = "CF1A12B0B5F66C4BB680155A08FE3F5B")
        
public boolean apply(T t) {
            return !predicate.apply(t);
        }
        
    }
    
}

