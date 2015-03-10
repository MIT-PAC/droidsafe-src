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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface AttributeSet {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public int getAttributeCount();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getAttributeName(int index);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public String getAttributeValue(int index);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public String getAttributeValue(String namespace, String name);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public String getPositionDescription();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeNameResource(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeListValue(String namespace, String attribute,
                                     String[] options, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean getAttributeBooleanValue(String namespace, String attribute,
                                            boolean defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeResourceValue(String namespace, String attribute,
                                         int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeIntValue(String namespace, String attribute,
                                    int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                            int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public float getAttributeFloatValue(String namespace, String attribute,
                                        float defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeListValue(int index, String[] options, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean getAttributeBooleanValue(int index, boolean defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeResourceValue(int index, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeIntValue(int index, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeUnsignedIntValue(int index, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public float getAttributeFloatValue(int index, float defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getIdAttribute();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getClassAttribute();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getIdAttributeResourceValue(int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getStyleAttribute();

    public static class EmptyAttributeSet implements AttributeSet {

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeCount() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getAttributeName(int index) {
            // TODO Auto-generated method stub
            addTaint(index);
            String str = new String();
            str.addTaint(getTaint());
            return str;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getAttributeValue(int index) {
            // TODO Auto-generated method stub
            addTaint(index);
            String str = new String();
            str.addTaint(getTaint());
            return str;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getAttributeValue(String namespace, String name) {
            // TODO Auto-generated method stub
            addTaint(name.getTaint());
            addTaint(namespace.getTaint());
            String str = new String();
            str.addTaint(getTaint());
            return str;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getPositionDescription() {
            // TODO Auto-generated method stub
            String str = new String();
            str.addTaint(getTaint());
            return str;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeNameResource(int index) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public boolean getAttributeBooleanValue(String namespace,
                String attribute, boolean defaultValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeResourceValue(String namespace,
                String attribute, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeUnsignedIntValue(String namespace,
                String attribute, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeListValue(int index, String[] options,
                int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeResourceValue(int index, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeIntValue(int index, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeUnsignedIntValue(int index, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public float getAttributeFloatValue(int index, float defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getIdAttribute() {
            // TODO Auto-generated method stub
            String str = new String();
            str.addTaint(getTaint());
            return str; 
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getClassAttribute() {
            // TODO Auto-generated method stub
            String str = new String();
            str.addTaint(getTaint());
            return str; 
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getIdAttributeResourceValue(int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getStyleAttribute() {
            // TODO Auto-generated method stub
            return 0;
        }
    }
}
