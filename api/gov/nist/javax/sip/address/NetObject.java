package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.GenericObject;
import gov.nist.core.GenericObjectList;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.PackageNames;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class NetObject extends GenericObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.914 -0500", hash_original_field = "783363F762E312FC7DC4F9A7F69E1386", hash_generated_field = "46C2887731A82D54499D991777D692CF")

    protected static final String CORE_PACKAGE = PackageNames.CORE_PACKAGE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.917 -0500", hash_original_field = "928DF341A507E7600562A079BCA40233", hash_generated_field = "594D4223DA826D2239E3278060CF9C1D")

    protected static final String NET_PACKAGE = PackageNames.NET_PACKAGE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.920 -0500", hash_original_field = "8EC4059346EE0A9DAA6808EF798387E1", hash_generated_field = "F9F431553B7EF5ED564BB76D3511A1C4")

    protected static final String PARSER_PACKAGE = PackageNames.PARSER_PACKAGE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.923 -0500", hash_original_field = "C3FE4AA2D0A65F7FB2BCFABD2F7EA262", hash_generated_field = "E0F49F8A6EC1F0FC10D150214707E15F")

    protected static final String UDP = "udp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.925 -0500", hash_original_field = "68703AB10816D405D1396AB032A64065", hash_generated_field = "65B8023757C289C256D8CDF02D79EEAB")

    protected static final String TCP = "tcp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.928 -0500", hash_original_field = "724CDA95C5AAEE297506D48385EB0575", hash_generated_field = "10ACFD285BFF968264526433D33B1AB0")

    protected static final String TRANSPORT = "transport";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.931 -0500", hash_original_field = "BD65FD8EEC2E4D271EFF9026620D7EA7", hash_generated_field = "ADFC98A2AB6C9BE4ECB3DA0DC42944C8")

    protected static final String METHOD = "method";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.934 -0500", hash_original_field = "7623BEF341D152A0D4FEB02810549B81", hash_generated_field = "0BD3E85D4B799F1CA9E1ECA350C946CC")

    protected static final String USER = "user";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.937 -0500", hash_original_field = "C2C96E54A087EC878A0CE427960E2216", hash_generated_field = "F56AC3F2C0064F9B98AE234242186C42")

    protected static final String PHONE = "phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.940 -0500", hash_original_field = "DACD0CFFAAFF1FFBDFC317BDCCDDBD8C", hash_generated_field = "7A87650302C67C9E28DB90C3D1ED745E")

    protected static final String MADDR = "maddr";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.943 -0500", hash_original_field = "C825988851C285263CC7CE37BB173B0A", hash_generated_field = "9521875EFD450C64F6E61B84A224F274")

    protected static final String TTL = "ttl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.945 -0500", hash_original_field = "6AAE7998D4171BF8932B2515C7ED6328", hash_generated_field = "19B2449D5B180111495A6203819463E0")

    protected static final String LR = "lr";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.948 -0500", hash_original_field = "4BB498E684155A8F6B206B0766423FFA", hash_generated_field = "6F3518A2B8F324537D0A7D82E19056BF")

    protected static final String SIP = "sip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.950 -0500", hash_original_field = "3697685F85251A86BCFE64BAF2BF33E1", hash_generated_field = "2812DB6997C42C0FAEB5CA6CA624A89E")

    protected static final String SIPS = "sips";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.953 -0500", hash_original_field = "5B35D8051830BFBA2689666E17D62408", hash_generated_field = "9E085E7B626954040FA4C29E128B38D1")

    protected static final String TLS = "tls";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.956 -0500", hash_original_field = "FA136764F19CDA4BBA56101A9C66E64B", hash_generated_field = "C0E0F676E4DB6DFC77F8911D9A0B95A4")

    // params for outbound and gruu drafts
    protected static final String GRUU = "gr";

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.959 -0500", hash_original_method = "C4442EA667C9A2BEB67B2F1E6DC6F09B", hash_generated_method = "B6853C18CCFB456413C2D77962EC3F79")
    
public NetObject() {
        super();
    }

    /**
     * An introspection based equality predicate for SIPObjects.
     *@param that is the other object to test against.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.964 -0500", hash_original_method = "26A4AB68F41643C912C51D77CC375C44", hash_generated_method = "02191E5A470E6246C40D89D3F1FC593B")
    
public boolean equals(Object that) {
        if (!this.getClass().equals(that.getClass()))
            return false;
        Class<?> myclass = this.getClass();
        Class<?> hisclass = that.getClass();
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
                Class<?> fieldType = f.getType();
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
                    else if (g.get(that) == null && f.get(that) != null)
                        return false;
                    else if (!f.get(this).equals(g.get(that)))
                        return false;
                } catch (IllegalAccessException ex1) {
                    InternalErrorHandler.handleException(ex1);
                }
            }
            if (myclass.equals(NetObject.class))
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
     *@param other the match pattern to test against. The match object
     * has to be of the same type (class). Primitive types
     * and non-sip fields that are non null are matched for equality.
     * Null in any field  matches anything. Some book-keeping fields
     * are ignored when making the comparison.
     *@return true if match succeeds false otherwise.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.968 -0500", hash_original_method = "8D936CCD11169852B60D86BE02120DB8", hash_generated_method = "84A17DE28E583D85A533C31812768C46")
    
public boolean match(Object other) {
        if (other == null)
            return true;
        if (!this.getClass().equals(other.getClass()))
            return false;
        GenericObject that = (GenericObject) other;
        // System.out.println("Comparing " + that.encode());
        // System.out.println("this = " + this.encode());

        Class<?> hisclass = other.getClass();
        Class<?> myclass = this.getClass();
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
                Class<?> fieldType = f.getType();
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
                            if (((String) hisObj).equals(""))
                                continue;
                            if (((String) myObj)
                                .compareToIgnoreCase((String) hisObj)
                                != 0)
                                return false;
                        } else if (
                            GenericObject.isMySubclass(myObj.getClass())
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
            if (myclass.equals(NetObject.class))
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.973 -0500", hash_original_method = "8F6462E23806D652AB2FB8FE10D0061F", hash_generated_method = "3C7532443F0E1BCE055B73DA114D8A47")
    
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
            if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.976 -0500", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "17B15A15CB497DC07A940E8E9144F966")
    
public String debugDump(int indent) {
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
        return retval;
    }

    /** Encode this to a string.
     *
     *@return string representation for this object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:31.980 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    
public String toString() {
        return this.encode();
    }
}

