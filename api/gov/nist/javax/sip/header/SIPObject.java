package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.GenericObject;
import gov.nist.core.GenericObjectList;
import gov.nist.core.InternalErrorHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class SIPObject extends GenericObject {

    /** default Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.421 -0500", hash_original_method = "F2415C91D035ABB45320678077A163BD", hash_generated_method = "EF0377E88863F74D89719B23AA2BF7B9")
    
protected SIPObject() {
        super();
    }

    /** Debug function
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.424 -0500", hash_original_method = "BC21211AABBF5A727CE8CE0C8A5F5ABC", hash_generated_method = "07FA9249E0984A0CAE96B90D99799894")
    
public void dbgPrint() {
        super.dbgPrint();
    }

    /** Encode the header into a String.
     * @return String
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.427 -0500", hash_original_method = "62F9CE492238F967486EB3E8B7CFE75A", hash_generated_method = "5BF421C60268DEDED1E2C31D57984D81")
    
public abstract String encode();

    /** Encode the header into the given StringBuffer.
     * Default implemation calls encode().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.431 -0500", hash_original_method = "23BD5BF1494AAB1936A4882B6C7896EB", hash_generated_method = "E83555D6561D540C12E200451394DEB5")
    
public StringBuffer encode(StringBuffer buffer) {
        return buffer.append(encode());
    }

    /**
     * An introspection based equality predicate for SIPObjects.
     *@param other the other object to test against.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.435 -0500", hash_original_method = "C625D56C28F833180267D6A3AE3C9C8E", hash_generated_method = "3235E79C076831103811E5F9B5DBF5E3")
    
public boolean equals(Object other) {
        if (!this.getClass().equals(other.getClass()))
            return false;
        SIPObject that = (SIPObject) other;
        Class myclass = this.getClass();
        Class hisclass = other.getClass();
        while (true) {
            Field[] fields = myclass.getDeclaredFields();
            if (!hisclass.equals(myclass))
                return false;
            Field[] hisfields = hisclass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                Field g = hisfields[i];
                // Only print protected and public members.
                int modifier = f.getModifiers();
                if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)
                    continue;
                Class fieldType = f.getType();
                String fieldName = f.getName();
                if (fieldName.compareTo("stringRepresentation") == 0) {
                    continue;
                }
                if (fieldName.compareTo("indentation") == 0) {
                    continue;
                }
                try {
                    // Primitive fields are printed with type: value
                    if (fieldType.isPrimitive()) {
                        String fname = fieldType.toString();
                        if (fname.compareTo("int") == 0) {
                            if (f.getInt(this) != g.getInt(that))
                                return false;
                        } else if (fname.compareTo("short") == 0) {
                            if (f.getShort(this) != g.getShort(that))
                                return false;
                        } else if (fname.compareTo("char") == 0) {
                            if (f.getChar(this) != g.getChar(that))
                                return false;
                        } else if (fname.compareTo("long") == 0) {
                            if (f.getLong(this) != g.getLong(that))
                                return false;
                        } else if (fname.compareTo("boolean") == 0) {
                            if (f.getBoolean(this) != g.getBoolean(that))
                                return false;
                        } else if (fname.compareTo("double") == 0) {
                            if (f.getDouble(this) != g.getDouble(that))
                                return false;
                        } else if (fname.compareTo("float") == 0) {
                            if (f.getFloat(this) != g.getFloat(that))
                                return false;
                        }
                    } else if (g.get(that) == f.get(this))
                        continue;
                    else if (f.get(this) == null && g.get(that) != null)
                        return false;
                    else if (g.get(that) == null && f.get(this) != null)
                        return false;
                    else if (!f.get(this).equals(g.get(that)))
                        return false;
                } catch (IllegalAccessException ex1) {
                    System.out.println("accessed field " + fieldName);
                    System.out.println("modifier  " + modifier);
                    System.out.println("modifier.private  " + Modifier.PRIVATE);
                    InternalErrorHandler.handleException(ex1);
                }
            }
            if (myclass.equals(SIPObject.class))
                break;
            else {
                myclass = myclass.getSuperclass();
                hisclass = hisclass.getSuperclass();
            }
        }
        return true;
    }

    /** An introspection based predicate matching using a template
     * object. Allows for partial match of two protocl Objects.
     * You can set a generalized matcher (using regular expressions
     * for example) by implementing the Match interface and registering
     * it with the template.
     *@param other the match pattern to test against. The match object
     * has to be of the same type (class). Primitive types
     * and non-sip fields that are non null are matched for equality.
     * Null in any field  matches anything. Some book-keeping fields
     * are ignored when making the comparison.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.441 -0500", hash_original_method = "060178C12313F034DC0CE078907A1CE4", hash_generated_method = "A59E76E07226A59A509F31C28C1E52FB")
    
public boolean match(Object other) {
        if (other == null) {
            return true;
        }

        if (!this.getClass().equals(other.getClass()))
            return false;
        GenericObject that = (GenericObject) other;
        Class myclass = this.getClass();
        Class hisclass = other.getClass();
        while (true) {
            Field[] fields = myclass.getDeclaredFields();
            Field[] hisfields = hisclass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                Field g = hisfields[i];
                // Only print protected and public members.
                int modifier = f.getModifiers();
                if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)
                    continue;
                Class fieldType = f.getType();
                String fieldName = f.getName();
                if (fieldName.compareTo("stringRepresentation") == 0) {
                    continue;
                }
                if (fieldName.compareTo("indentation") == 0) {
                    continue;
                }
                try {
                    if (fieldType.isPrimitive()) {
                        String fname = fieldType.toString();
                        if (fname.compareTo("int") == 0) {
                            if (f.getInt(this) != g.getInt(that))
                                return false;
                        } else if (fname.compareTo("short") == 0) {
                            if (f.getShort(this) != g.getShort(that))
                                return false;
                        } else if (fname.compareTo("char") == 0) {
                            if (f.getChar(this) != g.getChar(that))
                                return false;
                        } else if (fname.compareTo("long") == 0) {
                            if (f.getLong(this) != g.getLong(that))
                                return false;
                        } else if (fname.compareTo("boolean") == 0) {
                            if (f.getBoolean(this) != g.getBoolean(that))
                                return false;
                        } else if (fname.compareTo("double") == 0) {
                            if (f.getDouble(this) != g.getDouble(that))
                                return false;
                        } else if (fname.compareTo("float") == 0) {
                            if (f.getFloat(this) != g.getFloat(that))
                                return false;
                        } else {
                            InternalErrorHandler.handleException(
                                "unknown type");
                        }
                    } else {
                        Object myObj = f.get(this);
                        Object hisObj = g.get(that);
                        if (hisObj != null && myObj == null)
                            return false;
                        else if (hisObj == null && myObj != null)
                            continue;
                        else if (hisObj == null && myObj == null)
                            continue;
                        else if (
                            hisObj instanceof java.lang.String
                                && myObj instanceof java.lang.String) {
                            if ((((String) hisObj).trim()).equals(""))
                                continue;
                            if (((String) myObj)
                                .compareToIgnoreCase((String) hisObj)
                                != 0)
                                return false;
                        } else if (
                            hisObj != null
                                && GenericObject.isMySubclass(myObj.getClass())
                                && GenericObject.isMySubclass(hisObj.getClass())
                                && myObj.getClass().equals(hisObj.getClass())
                                && ((GenericObject) hisObj).getMatcher()
                                    != null) {
                            String myObjEncoded =
                                ((GenericObject) myObj).encode();
                            boolean retval =
                                ((GenericObject) hisObj).getMatcher().match(
                                    myObjEncoded);
                            if (!retval)
                                return false;
                        } else if (
                            GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj))
                            return false;
                        else if (
                            GenericObjectList.isMySubclass(myObj.getClass())
                                && !((GenericObjectList) myObj).match(hisObj))
                            return false;

                    }
                } catch (IllegalAccessException ex1) {
                    InternalErrorHandler.handleException(ex1);
                }
            }
            if (myclass.equals(SIPObject.class))
                break;
            else {
                myclass = myclass.getSuperclass();
                hisclass = hisclass.getSuperclass();
            }
        }
        return true;
    }

    /**
     * An introspection based string formatting method. We need this because
     * in this package (although it is an exact duplicate of the one in
     * the superclass) because it needs to access the protected members
     * of the other objects in this class.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.447 -0500", hash_original_method = "8C7E8103DEE2671781774C37BABA3BB5", hash_generated_method = "43ACE820E048560DD88C790458E7EB59")
    
public String debugDump() {
        stringRepresentation = "";
        Class myclass = getClass();
        sprint(myclass.getName());
        sprint("{");
        Field[] fields = myclass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            // Only print protected and public members.
            int modifier = f.getModifiers();
            if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)
                continue;
            Class fieldType = f.getType();
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
                } else if (GenericObject.class.isAssignableFrom(fieldType)) {
                    if (f.get(this) != null) {
                        sprint(
                            ((GenericObject) f.get(this)).debugDump(
                                indentation + 1));
                    } else {
                        sprint("<null>");
                    }

                } else if (
                    GenericObjectList.class.isAssignableFrom(fieldType)) {
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
     * @param indent int to set
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.450 -0500", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "17B15A15CB497DC07A940E8E9144F966")
    
public String debugDump(int indent) {
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
        return retval;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.453 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    
public String toString() {
        return this.encode();
    }
    
}

