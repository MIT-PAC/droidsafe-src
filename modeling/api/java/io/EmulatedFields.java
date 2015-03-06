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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class EmulatedFields {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.332 -0500", hash_original_field = "222F5CB81DB85F57268DF6B32981793A", hash_generated_field = "A5B1B9594264127836B75E232C6A005F")

    private ObjectSlot[] slotsToSerialize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.334 -0500", hash_original_field = "2F6659C7191D511B5899958D504FFA90", hash_generated_field = "BA97D77EB4E493202875178557881AFD")

    private ObjectStreamField[] declaredFields;

    /**
     * Constructs a new instance of EmulatedFields.
     *
     * @param fields
     *            an array of ObjectStreamFields, which describe the fields to
     *            be emulated (names, types, etc).
     * @param declared
     *            an array of ObjectStreamFields, which describe the declared
     *            fields.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.337 -0500", hash_original_method = "0D8BD958281DF75319EA682F9725E83E", hash_generated_method = "5BDEA4CA0D4C51812B024F4FD22876A5")
    
public EmulatedFields(ObjectStreamField[] fields, ObjectStreamField[] declared) {
        // We assume the slots are already sorted in the right shape for dumping
        buildSlots(fields);
        declaredFields = declared;
    }

    /**
     * Build emulated slots that correspond to emulated fields. A slot is a
     * field descriptor (ObjectStreamField) plus the actual value it holds.
     *
     * @param fields
     *            an array of ObjectStreamField, which describe the fields to be
     *            emulated (names, types, etc).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.340 -0500", hash_original_method = "3EEF58200AED128D87652E78B0B409B1", hash_generated_method = "65F9D2852DE6B216B7C6028C7CC4DADA")
    
private void buildSlots(ObjectStreamField[] fields) {
        slotsToSerialize = new ObjectSlot[fields.length];
        for (int i = 0; i < fields.length; i++) {
            ObjectSlot s = new ObjectSlot();
            slotsToSerialize[i] = s;
            s.field = fields[i];
        }
        // We assume the slots are already sorted in the right shape for dumping
    }

    /**
     * Returns {@code true} indicating the field called {@code name} has not had
     * a value explicitly assigned and that it still holds a default value for
     * its type, or {@code false} indicating that the field named has been
     * assigned a value explicitly.
     *
     * @param name
     *            the name of the field to test.
     * @return {@code true} if {@code name} still holds its default value,
     *         {@code false} otherwise
     *
     * @throws IllegalArgumentException
     *             if {@code name} is {@code null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.343 -0500", hash_original_method = "1C69260A170F4832C171F7666BEC6CDB", hash_generated_method = "CB06F330C1B40045938C390CB99FF60D")
    
public boolean defaulted(String name) throws IllegalArgumentException {
        ObjectSlot slot = findSlot(name, null);
        if (slot == null) {
            throw new IllegalArgumentException("no field '" + name + "'");
        }
        return slot.defaulted;
    }

    /**
     * Finds and returns an ObjectSlot that corresponds to a field named {@code
     * fieldName} and type {@code fieldType}. If the field type {@code
     * fieldType} corresponds to a primitive type, the field type has to match
     * exactly or {@code null} is returned. If the field type {@code fieldType}
     * corresponds to an object type, the field type has to be compatible in
     * terms of assignment, or null is returned. If {@code fieldType} is {@code
     * null}, no such compatibility checking is performed and the slot is
     * returned.
     *
     * @param fieldName
     *            the name of the field to find
     * @param fieldType
     *            the type of the field. This will be used to test
     *            compatibility. If {@code null}, no testing is done, the
     *            corresponding slot is returned.
     * @return the object slot, or {@code null} if there is no field with that
     *         name, or no compatible field (relative to {@code fieldType})
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.346 -0500", hash_original_method = "713D4075A7BFE1E9122D10F9179E2FD5", hash_generated_method = "CCE829DB41497ED7566802C2F6F6B36F")
    
private ObjectSlot findSlot(String fieldName, Class<?> fieldType) {
        boolean isPrimitive = fieldType != null && fieldType.isPrimitive();
        for (int i = 0; i < slotsToSerialize.length; i++) {
            ObjectSlot slot = slotsToSerialize[i];
            if (slot.field.getName().equals(fieldName)) {
                if (isPrimitive) {
                    // Looking for a primitive type field. Types must match
                    // *exactly*
                    if (slot.field.getType() == fieldType) {
                        return slot;
                    }
                } else {
                    // Looking for a non-primitive type field.
                    if (fieldType == null) {
                        return slot; // Null means we take anything
                    }
                    // Types must be compatible (assignment)
                    if (slot.field.getType().isAssignableFrom(fieldType)) {
                        return slot;
                    }
                }
            }
        }

        if (declaredFields != null) {
            for (int i = 0; i < declaredFields.length; i++) {
                ObjectStreamField field = declaredFields[i];
                if (field.getName().equals(fieldName)) {
                    if (isPrimitive ? fieldType == field.getType() : fieldType == null ||
                            field.getType().isAssignableFrom(fieldType)) {
                        ObjectSlot slot = new ObjectSlot();
                        slot.field = field;
                        slot.defaulted = true;
                        return slot;
                    }
                }
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.348 -0500", hash_original_method = "088986B40FCEDC0703EB00DECCCFDC49", hash_generated_method = "8DA0BEF21ADD53879C4635B580EE749D")
    
private ObjectSlot findMandatorySlot(String name, Class<?> type) {
        ObjectSlot slot = findSlot(name, type);
        if (slot == null || (type == null && slot.field.getType().isPrimitive())) {
            throw new IllegalArgumentException("no field '" + name + "' of type " + type);
        }
        return slot;
    }

    /**
     * Finds and returns the byte value of a given field named {@code name}
     * in the receiver. If the field has not been assigned any value yet, the
     * default value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.351 -0500", hash_original_method = "ACF5260920B1F0F677513369F3D8C323", hash_generated_method = "FA85D814085DAD11ADE86C720E780382")
    
public byte get(String name, byte defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, byte.class);
        return slot.defaulted ? defaultValue : ((Byte) slot.fieldValue).byteValue();
    }

    /**
     * Finds and returns the char value of a given field named {@code name} in the
     * receiver. If the field has not been assigned any value yet, the default
     * value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.353 -0500", hash_original_method = "97CAA651EBA3FEB1DEF47882147E3EE9", hash_generated_method = "ABC4DDC48A4C3E4860FA731C267CE734")
    
public char get(String name, char defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, char.class);
        return slot.defaulted ? defaultValue : ((Character) slot.fieldValue).charValue();
    }

    /**
     * Finds and returns the double value of a given field named {@code name}
     * in the receiver. If the field has not been assigned any value yet, the
     * default value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.356 -0500", hash_original_method = "8A61E03E38631E405F30500DFE3A2EED", hash_generated_method = "5D2E57B72234CE4834B332937E5A71F0")
    
public double get(String name, double defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, double.class);
        return slot.defaulted ? defaultValue : ((Double) slot.fieldValue).doubleValue();
    }

    /**
     * Finds and returns the float value of a given field named {@code name} in
     * the receiver. If the field has not been assigned any value yet, the
     * default value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.359 -0500", hash_original_method = "2A99383382827F229576C5D7E3624FBA", hash_generated_method = "300C102DED120EFE1542EC4497249BC9")
    
public float get(String name, float defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, float.class);
        return slot.defaulted ? defaultValue : ((Float) slot.fieldValue).floatValue();
    }

    /**
     * Finds and returns the int value of a given field named {@code name} in the
     * receiver. If the field has not been assigned any value yet, the default
     * value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.361 -0500", hash_original_method = "348173917C5323C10E5D8A71A480A22F", hash_generated_method = "3D80573FCFAE249D640CF65CA2996E9D")
    
public int get(String name, int defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, int.class);
        return slot.defaulted ? defaultValue : ((Integer) slot.fieldValue).intValue();
    }

    /**
     * Finds and returns the long value of a given field named {@code name} in the
     * receiver. If the field has not been assigned any value yet, the default
     * value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.365 -0500", hash_original_method = "57601B1EFC99CB5F2500857C9C4A7300", hash_generated_method = "B45160688894E7014BAC0471705F7CEF")
    
public long get(String name, long defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, long.class);
        return slot.defaulted ? defaultValue : ((Long) slot.fieldValue).longValue();
    }

    /**
     * Finds and returns the Object value of a given field named {@code name} in
     * the receiver. If the field has not been assigned any value yet, the
     * default value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.367 -0500", hash_original_method = "47E293617D5F89E0481B6C58D6863D6B", hash_generated_method = "DC4860BFA6E22B22392B0F27A7C5EABF")
    
public Object get(String name, Object defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, null);
        return slot.defaulted ? defaultValue : slot.fieldValue;
    }

    /**
     * Finds and returns the short value of a given field named {@code name} in
     * the receiver. If the field has not been assigned any value yet, the
     * default value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.370 -0500", hash_original_method = "EA3C9F151A3984D516E6CE85AC2BDF4D", hash_generated_method = "5280274D84D932A4E2B3E0CEAE755431")
    
public short get(String name, short defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, short.class);
        return slot.defaulted ? defaultValue : ((Short) slot.fieldValue).shortValue();
    }

    /**
     * Finds and returns the boolean value of a given field named {@code name} in
     * the receiver. If the field has not been assigned any value yet, the
     * default value {@code defaultValue} is returned instead.
     *
     * @param name
     *            the name of the field to find.
     * @param defaultValue
     *            return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, the default
     *         value otherwise.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.372 -0500", hash_original_method = "72E0CD60A94F0F11C444AC99B11C64E2", hash_generated_method = "19A66774A0B042446249E620D0B3A4EA")
    
public boolean get(String name, boolean defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, boolean.class);
        return slot.defaulted ? defaultValue : ((Boolean) slot.fieldValue).booleanValue();
    }

    /**
     * Find and set the byte value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.375 -0500", hash_original_method = "64C46ECEF3E0E1E6FE4F0FC120F58D81", hash_generated_method = "7FB24D8BB43DACAB26BAB8C572389336")
    
public void put(String name, byte value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, byte.class);
        slot.fieldValue = Byte.valueOf(value);
        slot.defaulted = false; // No longer default value
    }

    /**
     * Find and set the char value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.377 -0500", hash_original_method = "B195152936A8DE9E766C2D3BFA5BBEA4", hash_generated_method = "5E083CB5B8F8441226B9103845F4A19A")
    
public void put(String name, char value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, char.class);
        slot.fieldValue = Character.valueOf(value);
        slot.defaulted = false; // No longer default value
    }

    /**
     * Find and set the double value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.380 -0500", hash_original_method = "3D642E33ABBFFAD3AE138739766C10D1", hash_generated_method = "0EE6BB0F5056B321F9C83D36F1607A12")
    
public void put(String name, double value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, double.class);
        slot.fieldValue = Double.valueOf(value);
        slot.defaulted = false; // No longer default value
    }

    /**
     * Find and set the float value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.382 -0500", hash_original_method = "5C33ECB8D6052895E0E1DA7379AC4A20", hash_generated_method = "3EEF192658C02D1EB57B3361BD80F65F")
    
public void put(String name, float value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, float.class);
        slot.fieldValue = Float.valueOf(value);
        slot.defaulted = false; // No longer default value
    }

    /**
     * Find and set the int value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.385 -0500", hash_original_method = "C7B64C133814D04EB5CE7945AB5C3FD6", hash_generated_method = "B587C442A4868202EF0273A999FC34DB")
    
public void put(String name, int value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, int.class);
        slot.fieldValue = Integer.valueOf(value);
        slot.defaulted = false; // No longer default value
    }

    /**
     * Find and set the long value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.387 -0500", hash_original_method = "4164B16D12FE76E9A5204CEE3F8D4A11", hash_generated_method = "D72888F4BADA7428C5A9B78A62F340D3")
    
public void put(String name, long value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, long.class);
        slot.fieldValue = Long.valueOf(value);
        slot.defaulted = false; // No longer default value
    }

    /**
     * Find and set the Object value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.390 -0500", hash_original_method = "7164629BD662AF4C210D96FAFCA6D7A8", hash_generated_method = "1F474E68168290F2598C66EC27A2874B")
    
public void put(String name, Object value) throws IllegalArgumentException {
        Class<?> valueClass = null;
        if (value != null) {
            valueClass = value.getClass();
        }
        ObjectSlot slot = findMandatorySlot(name, valueClass);
        slot.fieldValue = value;
        slot.defaulted = false; // No longer default value
    }

    /**
     * Find and set the short value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.392 -0500", hash_original_method = "741DDC8469BC0231E1B51BB2B8F8F75A", hash_generated_method = "6297B8BEB2FC08296997155654E6E3CD")
    
public void put(String name, short value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, short.class);
        slot.fieldValue = Short.valueOf(value);
        slot.defaulted = false; // No longer default value
    }

    /**
     * Find and set the boolean value of a given field named {@code name} in the
     * receiver.
     *
     * @param name
     *            the name of the field to set.
     * @param value
     *            new value for the field.
     *
     * @throws IllegalArgumentException
     *             if the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.394 -0500", hash_original_method = "98E17CB3A991625B145B89A797910B92", hash_generated_method = "788AF49EAC62E138348B4A2D44600BC9")
    
public void put(String name, boolean value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, boolean.class);
        slot.fieldValue = Boolean.valueOf(value);
        slot.defaulted = false; // No longer default value
    }

    /**
     * Return the array of ObjectSlot the receiver represents.
     *
     * @return array of ObjectSlot the receiver represents.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.397 -0500", hash_original_method = "FD5D2C58D86BF6903270C5515850C93F", hash_generated_method = "AF5D2F7608E8365EE455C5E50D8D95C4")
    
public ObjectSlot[] slots() {
        return slotsToSerialize;
    }
    
    static class ObjectSlot {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.318 -0500", hash_original_field = "666B1AF45B3BB88D7A1E85239BC45DDE", hash_generated_field = "666B1AF45B3BB88D7A1E85239BC45DDE")

        ObjectStreamField field;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.320 -0500", hash_original_field = "5E1F8EDBBFF3A4D528D4DA8B4EA5155F", hash_generated_field = "5E1F8EDBBFF3A4D528D4DA8B4EA5155F")

        Object fieldValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.323 -0500", hash_original_field = "65016E670BD52C6342444B4F71434A83", hash_generated_field = "FE2742A309B77D3C1495FC9B5AC837CF")

        // assigned (false)
        boolean defaulted = true;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_method = "57E475AF330CFB18924297ADFA41ECEA", hash_generated_method = "57E475AF330CFB18924297ADFA41ECEA")
        public ObjectSlot ()
        {
            //Synthesized constructor
        }

        /**
         * Returns the descriptor for this emulated field.
         *
         * @return the field descriptor
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.326 -0500", hash_original_method = "59E78F3DAFAB25C124D589BA3544A531", hash_generated_method = "61079A71E6B9F2C95C9CF2C13733BC54")
        
public ObjectStreamField getField() {
            return field;
        }

        /**
         * Returns the value held by this emulated field.
         *
         * @return the field value
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.328 -0500", hash_original_method = "31B3B47C28245F569D31AEBE619B4C79", hash_generated_method = "CF3F818E93DF238F8CE6742FE2AD3BA3")
        
public Object getFieldValue() {
            return fieldValue;
        }
        
    }
    
}

