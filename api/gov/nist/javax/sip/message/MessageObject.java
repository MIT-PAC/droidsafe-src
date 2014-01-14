package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.GenericObject;
import gov.nist.core.GenericObjectList;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class MessageObject extends GenericObject {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.224 -0500", hash_original_method = "FC3F0C40EB43CAA923D6D6A1BF0E3847", hash_generated_method = "1DCA3CCA8E6E09BBA7F86CAD1E1D5F4C")
    
protected MessageObject() {
        super();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.212 -0500", hash_original_method = "62F9CE492238F967486EB3E8B7CFE75A", hash_generated_method = "5BF421C60268DEDED1E2C31D57984D81")
    
public abstract String encode();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.216 -0500", hash_original_method = "BC21211AABBF5A727CE8CE0C8A5F5ABC", hash_generated_method = "07FA9249E0984A0CAE96B90D99799894")
    
public void dbgPrint() {
        super.dbgPrint();
    }

    /**
     * An introspection based string formatting method. We need this because
     * in this package (although it is an exact duplicate of the one in
     * the superclass) because it needs to access the protected members
     * of the other objects in this class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.221 -0500", hash_original_method = "0442EC30A54A551F3B539049CBAE5178", hash_generated_method = "6D0150B112E54A3DB0A66FCA25337600")
    
public String debugDump() {
        stringRepresentation = "";
        Class<?> myclass = getClass();
        sprint(myclass.getName());
        sprint("{");
        Field[] fields = myclass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            // Only print protected and public members.
            int modifier = f.getModifiers();
            if (modifier == Modifier.PRIVATE)
                continue;
            Class<?> fieldType = f.getType();
            String fieldName = f.getName();
            if (fieldName.compareTo("stringRepresentation") == 0) {
                // avoid nasty recursions...
                continue;
            }
            if (fieldName.compareTo("indentation") == 0) {
                // formatting stuff - not relevant here.
                continue;
            }
            sprint(fieldName + ":");
            try {
                // Primitive fields are printed with type: value
                if (fieldType.isPrimitive()) {
                    String fname = fieldType.toString();
                    sprint(fname + ":");
                    if (fname.compareTo("int") == 0) {
                        int intfield = f.getInt(this);
                        sprint(intfield);
                    } else if (fname.compareTo("short") == 0) {
                        short shortField = f.getShort(this);
                        sprint(shortField);
                    } else if (fname.compareTo("char") == 0) {
                        char charField = f.getChar(this);
                        sprint(charField);
                    } else if (fname.compareTo("long") == 0) {
                        long longField = f.getLong(this);
                        sprint(longField);
                    } else if (fname.compareTo("boolean") == 0) {
                        boolean booleanField = f.getBoolean(this);
                        sprint(booleanField);
                    } else if (fname.compareTo("double") == 0) {
                        double doubleField = f.getDouble(this);
                        sprint(doubleField);
                    } else if (fname.compareTo("float") == 0) {
                        float floatField = f.getFloat(this);
                        sprint(floatField);
                    }
                } else if (
                    GenericObject.class.isAssignableFrom(
                        fieldType)) {
                    if (f.get(this) != null) {
                        sprint(
                            ((GenericObject) f.get(this)).debugDump(
                                this.indentation + 1));
                    } else {
                        sprint("<null>");
                    }

                } else if (GenericObjectList.class.isAssignableFrom(
                        fieldType)) {
                    if (f.get(this) != null) {
                        sprint(
                            ((GenericObjectList) f.get(this)).debugDump(
                                indentation + 1));
                    } else {
                        sprint("<null>");
                    }

                } else {
                    // Dont do recursion on things that are not
                    // of our header type...
                    if (f.get(this) != null) {
                        sprint(f.get(this).getClass().getName() + ":");
                    } else {
                        sprint(fieldType.getName() + ":");
                    }

                    sprint("{");
                    if (f.get(this) != null) {
                        sprint(f.get(this).toString());
                    } else {
                        sprint("<null>");
                    }
                    sprint("}");
                }
            } catch (IllegalAccessException ex1) {
                continue; // we are accessing a private field...
            }
        }
        sprint("}");
        return stringRepresentation;
    }

    /**
     * Formatter with a given starting indentation (for nested structs).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.226 -0500", hash_original_method = "FAEFAEB9988F2842518A414FFF4FC663", hash_generated_method = "A93437BD4A0526BE35A1025C3962E72C")
    
public String dbgPrint(int indent) {
        int save = indentation;
        indentation = indent;
        String retval = this.toString();
        indentation = save;
        return retval;
    }
    
}

