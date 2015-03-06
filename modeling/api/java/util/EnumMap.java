/* Licensed to the Apache Software Foundation (ASF) under one or more
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable, Map<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.022 -0500", hash_original_field = "EB1539CD940D015469BC4183AF7CD45A", hash_generated_field = "1557AA800F5DBE5D3C634E50FE75E1EE")

    // added implements Map<K, V> for apicheck
    // END android-changed

    private static final long serialVersionUID = 458661240069192865L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.025 -0500", hash_original_field = "F010784A251FB129AC47F47773283FBF", hash_generated_field = "784B4CB2B0AA1435846B96ECF749418D")

    private Class<K> keyType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.027 -0500", hash_original_field = "1379FEA8AFFEC55DC6F8F74FF07B46B6", hash_generated_field = "1296F5D01B4090600677F6D5CA1FE096")

    transient Enum[] keys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.030 -0500", hash_original_field = "54F62F83C92A1C47E6690E56D98127DA", hash_generated_field = "4150C40DB1D8CEF16DAAF4E72141B18D")

    transient Object[] values;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.032 -0500", hash_original_field = "5657F62044D4B0C47422B6B8DEA9CE7F", hash_generated_field = "2AFD2ACFCCD988AD1A9DB860BFAFC15E")

    transient boolean[] hasMapping;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.034 -0500", hash_original_field = "C7945E17114FC3C5BCFFF5BB4A9DD560", hash_generated_field = "204CA002E2DD9253A57F08EEC28189B5")

    private transient int mappingsCount;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.591 -0400", hash_original_method = "357B463561F8F38F36CCB594B2B44169", hash_generated_method = "D728EB7714A45C35A27862A2389C889E")
    public  EnumMap(Class<K> keyType) {
        addTaint(keyType.getTaint());
        // ---------- Original Method ----------
        //initialization(keyType);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.591 -0400", hash_original_method = "4FB74096ACFD3857AE5FA5EC3BFDBAC1", hash_generated_method = "DE0DEE09D8F2B560E6E7F0765E6E4F06")
    public  EnumMap(EnumMap<K, ? extends V> map) {
        addTaint(map.getTaint());
        putAll(map);
        // ---------- Original Method ----------
        //initialization(map);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.591 -0400", hash_original_method = "D652AC252782A7206F7D0F46E9A22736", hash_generated_method = "9CC33E4068876BFF8F77F0DCBF257B50")
    @SuppressWarnings("unchecked")
    public  EnumMap(Map<K, ? extends V> map) {
        addTaint(map.getTaint());
        putAll(map);
        
        if (DroidSafeAndroidRuntime.control)
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_715994921 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_715994921.addTaint(getTaint());
            throw var5783EF97022AA508B74A1E3EA38534AF_715994921;
        } //End block
        // ---------- Original Method ----------
        //if (map instanceof EnumMap) {
            //initialization((EnumMap<K, V>) map);
        //} else {
            //if (map.size() == 0) {
                //throw new IllegalArgumentException();
            //}
            //Iterator<K> iter = map.keySet().iterator();
            //K enumKey = iter.next();
            //Class clazz = enumKey.getClass();
            //if (clazz.isEnum()) {
                //initialization(clazz);
            //} else {
                //initialization(clazz.getSuperclass());
            //}
            //putAllImpl(map);
        //}
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.592 -0400", hash_original_method = "27D6CD5C74C8D110D14D6D471707F1DE", hash_generated_method = "12AD123C275828B67F145ADFD21A2D90")
    @SuppressWarnings("unchecked")
    @Override
    public EnumMap<K, V> clone() {
        try 
        {
            EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            EnumMap<K, V> var93535FC7597EF533BF9378E6783BB0AC_1899359267 =             enumMap;
            var93535FC7597EF533BF9378E6783BB0AC_1899359267.addTaint(getTaint());
            return var93535FC7597EF533BF9378E6783BB0AC_1899359267;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1475084858 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1475084858.addTaint(getTaint());
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1475084858;
        } //End block
        // ---------- Original Method ----------
        //try {
            //EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            //enumMap.initialization(this);
            //return enumMap;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.596 -0400", hash_original_method = "1D25B0764045DBFAD19E9C060947BE81", hash_generated_method = "8B89555382F557DC782057B5415E9994")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return getEntrySet();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.596 -0400", hash_original_method = "AC8EB1BDF42FFE99FA259DC7FD35D677", hash_generated_method = "545565E0A04297A6C761DA2AA4EF22CB")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        return getTaintBoolean();
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.600 -0400", hash_original_method = "DC4D5C48E92024F936CD723136F7EC43", hash_generated_method = "232D92AC03D454BF9E5F7DAD40AE5CC2")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        int elementCount = stream.readInt();
        Enum<K> enumKey;
        Object value;
for(int i = elementCount;i > 0;i--)
        {
            enumKey = (Enum<K>) stream.readObject();
            value = stream.readObject();
            put((K) enumKey, (V) value);
        } //End block
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //initialization(keyType);
        //int elementCount = stream.readInt();
        //Enum<K> enumKey;
        //Object value;
        //for (int i = elementCount; i > 0; i--) {
            //enumKey = (Enum<K>) stream.readObject();
            //value = stream.readObject();
            //putImpl((K) enumKey, (V) value);
        //}
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.235 -0500", hash_original_method = "7E98F968D6A8FBC0CE4D31A606E7DB44", hash_generated_method = "5EA4F7CC0E91ABF4E769AFD01C01E496")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(mappingsCount);
        Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }
}

